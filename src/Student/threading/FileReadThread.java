package Student.threading;

import java.io.*;
import java.util.concurrent.BlockingQueue;

public class FileReadThread extends Thread {

    private String inputFile;
    private BlockingQueue<String> queue;

    public FileReadThread(String inputFile, BlockingQueue<String> queue) {
        this.inputFile = inputFile;
        this.queue = queue;
    }

    @Override
    public void run() {

        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                queue.put(line);
            }
            queue.put("EOF");
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
