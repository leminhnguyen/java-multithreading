public class App {

    // some config variables
    public static int NUM_WORKERS = 5;

    public static void main(String[] args) throws Exception {
        // load the input files from input text dir
        Worker.loadInputFiles();
        Worker.inpTextDir = "resources/inp_texts";
        Worker.outTextDir = "resources/out_allophones";

        for (int workerId=0; workerId < NUM_WORKERS; workerId++) {
            Worker worker = new Worker(workerId);
            worker.start();
        }
    }
}
