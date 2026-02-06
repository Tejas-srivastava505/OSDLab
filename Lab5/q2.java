import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class q2 {
    public static void main(String[] args) {
        String source = "input.txt";
        String destination = "output.txt";

        try (FileReader reader = new FileReader(source);
             FileWriter writer = new FileWriter(destination)) {

            int character;
            while ((character = reader.read()) != -1) {
                writer.write(character);
            }

            System.out.println("Text copied successfully.");

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}