import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class q1 {
    public static void main(String[] args) {
        String source = "source.txt";
        String destination = "copy.txt";

        try (FileInputStream in = new FileInputStream(source);
             FileOutputStream out = new FileOutputStream(destination)) {

            int data;
            while ((data = in.read()) != -1) {
                out.write(data);
            }

            System.out.println("File copied successfully.");

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}