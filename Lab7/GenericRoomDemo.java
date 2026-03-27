package Lab7;

import java.util.Scanner;

class Room<T, U> {
    private T roomId;
    private U roomAttribute;

    public Room(T roomId, U roomAttribute) {
        this.roomId = roomId;
        this.roomAttribute = roomAttribute;
    }

    public void display() {
        System.out.println("Room ID: " + roomId);
        System.out.println("Room Attribute: " + roomAttribute);
        System.out.println("-----------------------");
    }
}

public class GenericRoomDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Integer + String
        System.out.print("Enter Room Number (Integer): ");
        Integer roomNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Room Type (String): ");
        String roomType = sc.nextLine();

        Room<Integer, String> r1 = new Room<>(roomNo, roomType);
        r1.display();

        // String + Double
        System.out.print("Enter Room ID (String): ");
        String id = sc.nextLine();

        System.out.print("Enter Room Price (Double): ");
        Double price = sc.nextDouble();

        Room<String, Double> r2 = new Room<>(id, price);
        r2.display();

        sc.close();
    }
}