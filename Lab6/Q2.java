package Lab6;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

class Roaom1 implements Serializable {
    private static final long serialVersionUID = 1L;

    int roomNumber;
    String roomType;
    double price;
    boolean status;
    String guestName;

    Roaom1(int roomNumber, String roomType, double price, boolean status, String name) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
        this.status = status;
        this.guestName = name;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    void setBookingStatus(boolean status) {
        this.status = status;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    @Override
    public String toString() {
        return "\nRoom Number: " + roomNumber +
                "\nRoom Type: " + roomType +
                "\nPrice per Night: " + price +
                "\nBooking Status: " + (status ? "Booked" : "Available") +
                "\nGuest Name: " + (guestName == null ? "None" : guestName) +
                "\n---------------------------";
    }
}

class Hotel11 {
    String file_name = "rooms.ser";

    void addRoom(Roaom1 room) {
        try {
            File file = new File(file_name);
            FileOutputStream fos = new FileOutputStream(file, true);
            ObjectOutputStream oos;

            if (file.length() == 0) {
                oos = new ObjectOutputStream(fos);
            } else {
                oos = new AppendableObjectOutputStream(fos);
            }
            oos.writeObject(room);
            oos.close();
            System.out.println("Room " + room.getRoomNumber() + " added.");

        } catch (IOException e) {
            System.out.println("error adding room: " + e.getMessage());
        }
    }

    void displayAllRoom() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file_name))) {
            System.out.println("All room details: ");
            while (true) {
                Roaom1 room = (Roaom1) ois.readObject(); // must cast to Roaom1
                System.out.println(room);
            }
        } catch (EOFException e) {
            // End of file reached → normal
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    void searchRoom(int roomNumber) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file_name));
            while (true) {
                Roaom1 room = (Roaom1) ois.readObject();
                if (room.getRoomNumber() == roomNumber) {
                    System.out.println("\nRoom Found:");
                    System.out.println(room);
                    break;
                }
            }
        } catch (EOFException e) {
            System.out.println("\nRoom not found.");
        } catch (Exception e) {
            System.out.println("error searching the room");
        }
    }

    void updateBooking(int roomNumber, boolean status, String guestName) {

        File tempFile = new File("temp.ser");

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file_name));
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(tempFile));

            while (true) {
                Roaom1 room = (Roaom1) ois.readObject();

                if (room.getRoomNumber() == roomNumber) {
                    room.setBookingStatus(status);
                    room.setGuestName(status ? guestName : null);
                }

                oos.writeObject(room);
            }

        } catch (EOFException e) {
            // End of file reached
        } catch (Exception e) {
            System.out.println("Error updating room.");
        }

        new File(file_name).delete();
        tempFile.renameTo(new File(file_name));

        System.out.println("\nRoom " + roomNumber + " booking updated.");
    }
}

class AppendableObjectOutputStream extends ObjectOutputStream {
    AppendableObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        reset();
    }
}

public class Q2 {
    public static void main(String[] args) {
        Hotel11 hotel = new Hotel11();
        Roaom1 r1 = new Roaom1(1, "Single", 2500.0, false, null);
        Roaom1 r2 = new Roaom1(2, "Double", 4000.0, false, null);
        Roaom1 r3 = new Roaom1(3, "Suite", 7500.0, false, null);
        hotel.addRoom(r1);
        hotel.addRoom(r2);
        hotel.addRoom(r3);
        hotel.displayAllRoom();
        hotel.searchRoom(2);
        hotel.updateBooking(2, true, "Viraj");
        hotel.displayAllRoom();
    }
}