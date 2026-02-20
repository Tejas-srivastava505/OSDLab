package Lab6;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
// 1. Design and implement a Java application to manage hotel room bookings where room records are stored in a file and accessed using RandomAccessFile. Each room record should be of fixed length, enabling direct (random) access to any room’s booking information without reading the file sequentially.
// The system must support operations such as adding rooms, viewing room details, and updating booking status by directly navigating to the required record position in the file.
// i. hotel room details in a file using RandomAccessFile.
// ii.Each room record must contain:
// iii. Room Number (int)
// iv. Room Type (fixed-length String, e.g., 20 characters)
// v. Price per Night (double)
// vi. Booking Status (boolean)
// vii. Provide an option to:
// viii. Add new room records
// ix. Display details of a specific room using its room number
// x. Update booking status (book / vacate a room)
// xi. Use the seek() method to jump directly to the position of a room record.
// xii. Ensure data is read and written in the same sequence and format.
// xiii. Close the file after each operation.
class Q1{
    static final String File_name ="rooms.dat";
    static final int name_length = 20;
    static final int record_size = 4+(2*name_length)+8+1;
    public static String fixLength(String str){
        if(str.length()>name_length){
            return str.substring(0,name_length);

        }
        while(str.length() < name_length){
            str+=" ";
        }
        return str;
    }

    public static void addRoom(int Roomno, String type,double price,boolean status) throws IOException{
        RandomAccessFile raf= new RandomAccessFile(File_name, "rw");

        raf.seek(raf.length()); //end of file
        
        raf.writeInt(Roomno);
        raf.writeChars(fixLength(type));
        raf.writeDouble(price);
        raf.writeBoolean(status);

        raf.close();
        System.out.println("Room added Successfully into the data.");


    }

    //room finder
    public static long findRoomPosition(int roomNo) throws IOException{
        RandomAccessFile raf=new RandomAccessFile(File_name, "r");

        while (raf.getFilePointer() < raf.length()){
            long position = raf.getFilePointer();
            int storedRoomNo = raf.readInt();

            if(storedRoomNo == roomNo){
                raf.close();
                return position;

            }
            raf.seek(position + record_size);
        }
        raf.close();
        return -1;
    }
    public static void veiwRoom(int roomNo) throws IOException {
        RandomAccessFile raf=new RandomAccessFile(File_name,"r");

        long position=findRoomPosition(roomNo);

        if(position==-1){
            System.out.println("Room not found.");
            raf.close();
            return;
        }
        raf.seek(position);
        System.out.println("Room No: "+raf.readInt());

        char[] type=new char[name_length];
        for(int i=0;i<name_length;i++){
            type[i]=raf.readChar();
        }

        System.out.println("Room Type: "+new String(type).trim());
        System.out.println("Price per Night: "+raf.readDouble());
        System.out.println("Booked: "+raf.readBoolean());

        raf.close();
    }

    public static void updateBooking(int roomNo, boolean newStatus) throws IOException {
        RandomAccessFile raf=new RandomAccessFile(File_name,"rw");
        long position=findRoomPosition(roomNo);

        if (position==-1){
            System.out.println("Room not found. ");
            raf.close();
            return;
        }
        raf.seek(position + 4+(2*name_length)+8);

        raf.writeBoolean(newStatus);

        raf.close();
        System.out.println("Booking Status updated.");
    }

    public static void main(String args[]) throws IOException {
        Scanner sc=new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Room");
            System.out.println("2. View Room");
            System.out.println("3. Update Booking");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Room No: ");
                    int rno = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Room Type: ");
                    String type = sc.nextLine();
                    System.out.print("Price: ");
                    double price = sc.nextDouble();
                    System.out.print("Booked (true/false): ");
                    boolean status = sc.nextBoolean();
                    addRoom(rno, type, price, status);
                    break;

                case 2:
                    System.out.print("Enter Room No to View: ");
                    veiwRoom(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Enter Room No: ");
                    int room = sc.nextInt();
                    System.out.print("New Status (true = booked, false = vacant): ");
                    boolean newStatus = sc.nextBoolean();
                    updateBooking(room, newStatus);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        sc.close();

    }
}


