package Lab1;

// Interface
interface Amenities {
    void provideWifi();
    void provideBreakfast();
}

// Abstract class (RENAMED)
abstract class Rooom {
    int roomNumber;
    double basePrice;

    Rooom(int roomNumber, double basePrice) {
        this.roomNumber = roomNumber;
        this.basePrice = basePrice;
    }

    abstract double calculateTariff();

    void displayRoomDetails() {
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Base Price: " + basePrice);
    }
}

// Standard room class (RENAMED)
class Standard extends Rooom implements Amenities {
    boolean ac;

    Standard(int roomNumber, double basePrice, boolean ac) {
        super(roomNumber, basePrice);
        this.ac = ac;
    }

    @Override
    double calculateTariff() {
        return basePrice + (ac ? 1000 : 0);
    }

    public void provideWifi() {
        System.out.println("WiFi available in Standard Room");
    }

    public void provideBreakfast() {
        System.out.println("Breakfast not included in Standard Room");
    }
}

// Luxury room class (RENAMED)
class Luxury extends Rooom implements Amenities {
    boolean ac, personalService;

    Luxury(int roomNumber, double basePrice, boolean ac, boolean personalService) {
        super(roomNumber, basePrice);
        this.ac = ac;
        this.personalService = personalService;
    }

    @Override
    double calculateTariff() {
        return basePrice
                + (ac ? 1000 : 0)
                + (personalService ? 3000 : 0);
    }

    public void provideWifi() {
        System.out.println("High-speed WiFi available in Luxury Room");
    }

    public void provideBreakfast() {
        System.out.println("Complimentary breakfast included");
    }
}

// Main class
public class Q4 {
    public static void main(String[] args) {

        Rooom r;

        r = new Standard(101, 5000, true);
        r.displayRoomDetails();
        System.out.println("Tariff: " + r.calculateTariff());
        ((Amenities) r).provideWifi();
        ((Amenities) r).provideBreakfast();

        System.out.println();

        r = new Luxury(201, 8000, true, true);
        r.displayRoomDetails();
        System.out.println("Tariff: " + r.calculateTariff());
        ((Amenities) r).provideWifi();
        ((Amenities) r).provideBreakfast();
    }
}
