package Lab1;

class Room {
    int roomNumber;
    double baseTariff;

    Room(int roomNumber, double baseTariff) {
        this.roomNumber = roomNumber;
        this.baseTariff = baseTariff;
    }

    double calculateTariff() {
        return baseTariff;
    }
}

class StandardRoom extends Room {
    boolean ac;

    StandardRoom(int roomNumber, double baseTariff, boolean ac) {
        super(roomNumber, baseTariff);
        this.ac = ac;
    }

    @Override
    double calculateTariff() {
        return baseTariff + (ac ? 1000 : 0);
    }
}

class LuxuryRoom extends Room {
    boolean ac, ps;

    LuxuryRoom(int roomNumber, double baseTariff, boolean ac, boolean ps) {
        super(roomNumber, baseTariff);
        this.ac = ac;
        this.ps = ps;
    }

    @Override
    double calculateTariff() {
        return baseTariff
             + (ac ? 1000 : 0)
             + (ps ? 3000 : 0);
    }
}

public class Q3 {
    public static void main(String[] args) {
        Room r;

        r = new StandardRoom(101, 5000.00, true);
        System.out.println("Standard Room Tariff: " + r.calculateTariff());

        r = new LuxuryRoom(201, 5000.00, true, true);
        System.out.println("Luxury Room Tariff: " + r.calculateTariff());
    }
}
