package Lab6;

import java.io.RandomAccessFile;
import java.io.IOException;
public class RandomAccessFileDemo {
    public static void main(String[] args) {
        try {
// Open file in read-write mode
            RandomAccessFile raf = new RandomAccessFile("D:\\OSDL_240911600\\Lab6\\data.dat", "rw");
            // Writing data to file
            raf.writeInt(101);
            raf.writeUTF("Java");
            raf.writeDouble(99.5);
            // Move file pointer to beginning
            raf.seek(0);
            // Reading data sequentially
            int id = raf.readInt();
            String name = raf.readUTF();
            double marks = raf.readDouble();
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Marks: " + marks);
            // Random access: move pointer and read again
            raf.seek(4); // Skips integer (4 bytes)
            System.out.println("Name (Random Access): " + raf.readUTF());
            raf.close();
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}