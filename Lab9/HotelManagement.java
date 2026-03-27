import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.ArrayList;


public class HotelManagement extends Application {

    ArrayList<Room> rooms = new ArrayList<>();
    ArrayList<Customer> customers = new ArrayList<>();

    @Override
    public void start(Stage stage) {

        // ---------------- ROOM INPUT ----------------
        TextField txtRoomNo = new TextField();
        TextField txtPrice = new TextField();

        ComboBox<String> cmbType = new ComboBox<>();
        cmbType.getItems().addAll("Single", "Double", "Deluxe");

        Button btnAddRoom = new Button("Add Room");
        Button btnViewRooms = new Button("View Rooms");

        // ---------------- CUSTOMER INPUT ----------------
        TextField txtName = new TextField();
        TextField txtContact = new TextField();
        TextField txtBookRoom = new TextField();

        Button btnBook = new Button("Book Room");
        Button btnCheckout = new Button("Checkout");

        // ---------------- OUTPUT ----------------
        TextArea output = new TextArea();
        output.setPrefHeight(150);

        // ---------------- ACTIONS ----------------
        btnAddRoom.setOnAction(e -> {
            try {
                int roomNo = Integer.parseInt(txtRoomNo.getText());
                double price = Double.parseDouble(txtPrice.getText());
                String type = cmbType.getValue();

                rooms.add(new Room(roomNo, type, price));

                output.setText("Room Added Successfully!");

                txtRoomNo.clear();
                txtPrice.clear();
                cmbType.setValue(null);

            } catch (Exception ex) {
                output.setText("Invalid Room Input!");
            }
        });

        btnViewRooms.setOnAction(e -> {
            String result = "";
            for (Room r : rooms) {
                result += "Room " + r.roomNumber +
                        " | " + r.type +
                        " | ₹" + r.price +
                        " | " + (r.isAvailable ? "Available" : "Booked") + "\n";
            }
            output.setText(result.isEmpty() ? "No rooms added!" : result);
        });

        btnBook.setOnAction(e -> {
            try {
                int roomNo = Integer.parseInt(txtBookRoom.getText());

                for (Room r : rooms) {
                    if (r.roomNumber == roomNo) {
                        if (r.isAvailable) {
                            r.isAvailable = false;

                            customers.add(new Customer(
                                    txtName.getText(),
                                    txtContact.getText(),
                                    roomNo
                            ));

                            output.setText("Room Booked Successfully!");

                            txtName.clear();
                            txtContact.clear();
                            txtBookRoom.clear();
                            return;
                        } else {
                            output.setText("Room already occupied!");
                            return;
                        }
                    }
                }
                output.setText("Room not found!");

            } catch (Exception ex) {
                output.setText("Invalid Booking Input!");
            }
        });

        btnCheckout.setOnAction(e -> {
            try {
                int roomNo = Integer.parseInt(txtBookRoom.getText());

                for (Room r : rooms) {
                    if (r.roomNumber == roomNo) {
                        r.isAvailable = true;
                        output.setText("Checkout successful!");
                        return;
                    }
                }

                output.setText("Room not found!");

            } catch (Exception ex) {
                output.setText("Invalid Room Number!");
            }
        });

        // ---------------- ROOM SECTION ----------------
        GridPane roomGrid = new GridPane();
        roomGrid.setHgap(10);
        roomGrid.setVgap(10);

        roomGrid.add(new Label("Room No:"), 0, 0);
        roomGrid.add(txtRoomNo, 1, 0);
        roomGrid.add(new Label("Type:"), 0, 1);
        roomGrid.add(cmbType, 1, 1);
        roomGrid.add(new Label("Price:"), 0, 2);
        roomGrid.add(txtPrice, 1, 2);
        roomGrid.add(btnAddRoom, 0, 3);
        roomGrid.add(btnViewRooms, 1, 3);

        TitledPane roomPane = new TitledPane("Room Management", roomGrid);

        // ---------------- CUSTOMER SECTION ----------------
        GridPane custGrid = new GridPane();
        custGrid.setHgap(10);
        custGrid.setVgap(10);

        custGrid.add(new Label("Name:"), 0, 0);
        custGrid.add(txtName, 1, 0);
        custGrid.add(new Label("Contact:"), 0, 1);
        custGrid.add(txtContact, 1, 1);
        custGrid.add(new Label("Room No:"), 0, 2);
        custGrid.add(txtBookRoom, 1, 2);
        custGrid.add(btnBook, 0, 3);
        custGrid.add(btnCheckout, 1, 3);

        TitledPane custPane = new TitledPane("Customer Booking", custGrid);

        // ---------------- MAIN LAYOUT ----------------
        VBox root = new VBox(15);
        root.setStyle("-fx-padding: 20; -fx-background-color: #f4f6f8;");
        root.getChildren().addAll(roomPane, custPane, new Label("Output:"), output);

        // ---------------- SCENE ----------------
        Scene scene = new Scene(root, 420, 500);

        stage.setTitle("Hotel Management System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}