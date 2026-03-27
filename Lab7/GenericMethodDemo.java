package Lab7;

import java.util.Scanner;

public class GenericMethodDemo {

    public static <T> void display(T data) {
        System.out.println("Value: " + data);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Room Number (Integer): ");
        Integer roomNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Room Type (String): ");
        String roomType = sc.nextLine();

        System.out.print("Enter Price per Night (Double): ");
        Double price = sc.nextDouble();

        System.out.print("Enter Booking Status (true/false): ");
        Boolean status = sc.nextBoolean();

        System.out.println("\nDisplaying Room Details:");
        display(roomNo);
        display(roomType);
        display(price);
        display(status);

        sc.close();
    }
}