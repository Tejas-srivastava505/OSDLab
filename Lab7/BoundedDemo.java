package Lab7;

import java.util.Scanner;

class RoomCharge<T extends Number> {

    private T price;
    private T discount;

    public RoomCharge(T price, T discount) {
        this.price = price;
        this.discount = discount;
    }

    public void calculate() {
        double total = price.doubleValue();
        double discounted = total - discount.doubleValue();

        System.out.println("Total Price: " + total);
        System.out.println("Discounted Price: " + discounted);
    }
}

public class BoundedDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Room Price: ");
        Double price = sc.nextDouble();

        System.out.print("Enter Discount: ");
        Double discount = sc.nextDouble();

        RoomCharge<Double> rc = new RoomCharge<>(price, discount);
        rc.calculate();

        sc.close();
    }
}
