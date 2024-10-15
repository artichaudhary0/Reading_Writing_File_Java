package Student.main;
import Student.file.FileProcessor;

public class Main {
    public static void main(String[] args) {

        // input and output file path
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        // create a FileProcessor object
        FileProcessor fileProcessor = new FileProcessor(inputFile , outputFile);

        // start processing
        fileProcessor.processFiles();
    }
}