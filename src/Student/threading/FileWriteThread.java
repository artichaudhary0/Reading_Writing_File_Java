package Student.threading;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

public class FileWriteThread extends Thread {
    private String outputFile;
    private BlockingQueue<String> queue;

    public FileWriteThread(String outputFile, BlockingQueue<String> queue) {
        this.outputFile = outputFile;
        this.queue = queue;
    }

    @Override
    public void run() {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            String line ;
            while (!(line = queue.take()).equals("EOF")) {
                writer.write(processLine(line));
                writer.newLine();
            }
        }catch (IOException | InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
    private String processLine(String line) {
        return line.toUpperCase() ;
    }

}
