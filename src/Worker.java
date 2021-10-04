import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Stack;

public class Worker extends Thread{

    private int id;
    public static String inpTextDir;
    public static String outTextDir;
    private Text2AllophoneProcessor t2a;
    public static Stack<String> inputFiles = new Stack<String>();

    public Worker(int id){
        System.out.println("Initializing the Text To Allophone Worker " + id);
        this.id = id;
        this.t2a = new Text2AllophoneProcessor();
    }
    
    @Override
    public void run() {
        while (!inputFiles.isEmpty()){
            String inputFile = getFile();
            System.out.println("Worker " + id + " is processing file: " + inputFile);
            try {
                String inputText = readFileContent(
                    inpTextDir + "/" + inputFile
                );
                String allophone = t2a.process(inputText);
                String outputFile = outTextDir + "/" + inputFile.split("\\.")[0] + ".xml";
                clearFileContent(outputFile);
                writeFileContent(outputFile, allophone);
            } catch (IOException e){
                e.printStackTrace();
            } catch (InterruptedException e) {
                ;
            }
        }
        System.out.println("the Text To Allophone Worker " + id + " ended");
    }
  
    synchronized public String getFile(){
        return inputFiles.pop();
    }

    public static void loadInputFiles() throws FileNotFoundException{
        File folder = new File(inpTextDir);
        for (File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                throw new FileNotFoundException(fileEntry.getName() + " is directory");
            } else {
                inputFiles.push(fileEntry.getName());
            }
        }

    }

    public void writeFileContent(
        String inputFile, String content
    ) throws IOException{
        File file = new File(inputFile);
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter br = new BufferedWriter(fr);
        br.write(content);
        br.close();
        fr.close();
    }

    public void clearFileContent(String file) throws FileNotFoundException{
        try {
            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();
        } catch (FileNotFoundException e) {
            ;
        }
    }

    public String readFileContent(String inputFile) throws IOException{
        String content;
        content = new String(Files.readAllBytes(Paths.get(inputFile)));
        return content;
    }

}
