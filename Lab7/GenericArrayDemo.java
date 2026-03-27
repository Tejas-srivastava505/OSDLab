package Lab7;

import java.util.Scanner;

public class GenericArrayDemo {

    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println("\n---------------------");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rooms: ");
        int n = sc.nextInt();

        Integer[] roomNumbers = new Integer[n];
        String[] roomTypes = new String[n];
        Double[] roomPrices = new Double[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nRoom " + (i + 1));

            System.out.print("Enter Room Number: ");
            roomNumbers[i] = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Room Type: ");
            roomTypes[i] = sc.nextLine();

            System.out.print("Enter Room Price: ");
            roomPrices[i] = sc.nextDouble();
        }

        System.out.println("\nRoom Numbers:");
        printArray(roomNumbers);

        System.out.println("Room Types:");
        printArray(roomTypes);

        System.out.println("Room Prices:");
        printArray(roomPrices);

        sc.close();
    }
}
