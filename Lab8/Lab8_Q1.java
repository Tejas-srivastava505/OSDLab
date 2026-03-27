package Lab8;
import java.util.*;

// Room Class
class Room {
    int roomNumber;
    String roomType;
    double price;
    boolean isAvailable;

    public Room(int roomNumber, String roomType, double price) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
        this.isAvailable = true;
    }
}

// Customer Class
class Customer {
    int customerId;
    String name;
    String contact;
    int roomNumber;

    public Customer(int customerId, String name, String contact, int roomNumber) {
        this.customerId = customerId;
        this.name = name;
        this.contact = contact;
        this.roomNumber = roomNumber;
    }
}

// Main System Class
public class Lab8_Q1 {

    static ArrayList<Room> rooms = new ArrayList<>();
    static ArrayList<Customer> customers = new ArrayList<>();
    static HashMap<Integer, Customer> roomCustomerMap = new HashMap<>();

    static Scanner sc = new Scanner(System.in);

    // Add Room
    public static void addRoom() {
        try {
            System.out.print("Enter Room Number: ");
            int number = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Room Type: ");
            String type = sc.nextLine();

            System.out.print("Enter Price: ");
            double price = sc.nextDouble();

            rooms.add(new Room(number, type, price));
            System.out.println("Room added successfully!");

        } catch (Exception e) {
            System.out.println("Invalid input!");
            sc.nextLine();
        }
    }

    // Display Available Rooms
    public static void displayAvailableRooms() {
        if (rooms.isEmpty()) {
            System.out.println("No rooms available.");
            return;
        }

        // Sort by room number
        Collections.sort(rooms, Comparator.comparingInt(r -> r.roomNumber));

        System.out.println("\nAvailable Rooms:");
        for (Room r : rooms) {
            if (r.isAvailable) {
                System.out.println("Room No: " + r.roomNumber +
                        ", Type: " + r.roomType +
                        ", Price: " + r.price);
            }
        }
    }

    // Add Customer
    public static void addCustomer() {
        try {
            System.out.print("Enter Customer ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Contact: ");
            String contact = sc.nextLine();

            customers.add(new Customer(id, name, contact, -1));
            System.out.println("Customer added successfully!");

        } catch (Exception e) {
            System.out.println("Invalid input!");
            sc.nextLine();
        }
    }

    // Book Room
    public static void bookRoom() {
        try {
            System.out.print("Enter Customer ID: ");
            int id = sc.nextInt();

            Customer cust = null;
            for (Customer c : customers) {
                if (c.customerId == id) {
                    cust = c;
                    break;
                }
            }

            if (cust == null) {
                System.out.println("Customer not found!");
                return;
            }

            System.out.print("Enter Room Number to Book: ");
            int roomNo = sc.nextInt();

            for (Room r : rooms) {
                if (r.roomNumber == roomNo) {
                    if (!r.isAvailable) {
                        System.out.println("Room already booked!");
                        return;
                    }

                    r.isAvailable = false;
                    cust.roomNumber = roomNo;
                    roomCustomerMap.put(roomNo, cust);

                    System.out.println("Room booked successfully!");
                    return;
                }
            }

            System.out.println("Room not found!");

        } catch (Exception e) {
            System.out.println("Invalid input!");
            sc.nextLine();
        }
    }

    // Checkout Customer
    public static void checkoutCustomer() {
        try {
            System.out.print("Enter Room Number: ");
            int roomNo = sc.nextInt();

            if (!roomCustomerMap.containsKey(roomNo)) {
                System.out.println("No customer in this room!");
                return;
            }

            Customer cust = roomCustomerMap.get(roomNo);

            // Free room
            for (Room r : rooms) {
                if (r.roomNumber == roomNo) {
                    r.isAvailable = true;
                    break;
                }
            }

            cust.roomNumber = -1;
            roomCustomerMap.remove(roomNo);

            System.out.println("Checkout successful!");

        } catch (Exception e) {
            System.out.println("Invalid input!");
            sc.nextLine();
        }
    }

    // Display All Customers
    public static void displayCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }

        Iterator<Customer> it = customers.iterator();

        while (it.hasNext()) {
            Customer c = it.next();
            System.out.println("ID: " + c.customerId +
                    ", Name: " + c.name +
                    ", Contact: " + c.contact +
                    ", Room: " + (c.roomNumber == -1 ? "None" : c.roomNumber));
        }
    }

    // Menu
    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== Hotel Management System =====");
            System.out.println("1. Add Room");
            System.out.println("2. Display Available Rooms");
            System.out.println("3. Add Customer");
            System.out.println("4. Book Room");
            System.out.println("5. Checkout Customer");
            System.out.println("6. Display All Customers");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addRoom();
                case 2 -> displayAvailableRooms();
                case 3 -> addCustomer();
                case 4 -> bookRoom();
                case 5 -> checkoutCustomer();
                case 6 -> displayCustomers();
                case 7 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 7);
    }
}