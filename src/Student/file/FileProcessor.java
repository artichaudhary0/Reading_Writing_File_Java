package Student.file;
import Student.threading.FileReadThread;
import Student.threading.FileWriteThread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FileProcessor {
    private String inputFile;
    private String outputFile;
    private BlockingQueue<String> queue ;

    // constructor
    public FileProcessor(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        this.queue = new LinkedBlockingQueue<>(); // thread -safe queue
    }

    //processFiles
    public void processFiles(){
        // create read and write threads
        FileReadThread readThread = new FileReadThread(inputFile , queue);
        FileWriteThread writeThread = new FileWriteThread(outputFile,queue);

        // start both the thread
        readThread.start();
        writeThread.start();


        try{
            readThread.join();
            writeThread.join();
            System.out.println("File processed successfully");
        }catch (InterruptedException error){
            System.out.println("Error waiting for threading : "+error.getMessage());
        }
    }
}
