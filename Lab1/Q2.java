package Lab1;
/*Create a base class named Room to represent general room details in a hotel. The 
class should contain data members such as room number, room type, and base 
price.
Initializing only the room number and type 
Initializing room number, type, and base price 

Create a derived class named DeluxeRoom that inherits from the Room class 
using single inheritance. The derived class should include additional data 
members such as free Wi-Fi availability and complimentary breakfast. 
Implement appropriate constructors in the derived class that invoke the base 
class constructors using the super keyword. 
Create a main class to instantiate objects of both Room and DeluxeRoom using 
different constructors and display the room details. This application should 
clearly illustrate constructor overloading and inheritance.*/

class Room{
    int room_number,base_price;
    String room_type;
    Room(int room_number,String room_type){
        this.room_number=room_number;
        this.room_type=room_type;
    }
    Room(int room_number,String room_type,int base_price){
        this.room_number=room_number;
        this.room_type=room_type;
        this.base_price=base_price;        
    }
    void display(){
        System.out.println("Room Number: "+room_number);
        System.out.println("Room Type: "+room_type);
        System.out.println("Room Base Price: "+base_price);
    }
}
class DeluxeRoom extends Room{
    boolean free_wifi,compli_bf;
    //with price
    DeluxeRoom(int room_number,String room_type,int base_price,boolean free_wifi,boolean compli_bf){
        super(room_number,room_type,base_price);
        this.free_wifi=free_wifi;
        this.compli_bf=compli_bf;
    }
    //without price
    DeluxeRoom(int room_number,String room_type,boolean free_wifi,boolean compli_bf){
        super(room_number,room_type);
        this.free_wifi=free_wifi;
        this.compli_bf=compli_bf;
    }
    void display(){
        super.display();
        System.out.println("Free Wifi: "+free_wifi);
        System.out.println("Complimentary Breakfast: "+compli_bf);
    }
}
public class Q2 {
    public static void main(String[] args) {
        DeluxeRoom drs=new DeluxeRoom(1,"Standard", false, false);
        DeluxeRoom drd=new DeluxeRoom(2,"Deluxe", 4825,true, true);
        drs.display();
        drd.display();
    }
}
