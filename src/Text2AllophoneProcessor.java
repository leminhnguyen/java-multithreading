public class Text2AllophoneProcessor {
    
    public Text2AllophoneProcessor() {
        // init some objects which need to convert text to allophone
    }

    public String process(String inputText) throws InterruptedException{
        // simulate the process of converting text to allophone
        Thread.sleep(2000);
        String allophone = "<Allophone>" + inputText + "</Allophone>";

        return allophone;
    }
}
