import java.util.*;

/*The Hotel Billing system should calculate the total bill amount for hotel guests based on room charges and additional service charges. Store numeric values such as room tariff, number of days stayed, and service charges using wrapper class objects (Integer, Double) instead of primitive data types. 

Demonstrate autoboxing by automatically converting primitive values to wrapper class objects when assigning values or storing them in collections. Demonstrate unboxing by automatically converting wrapper class objects back to primitive types while performing arithmetic operations for bill calculation*/

class Hotel_Billing{
    Integer no_days;
    Double room_tariff,serviceCharge;
    double total_Bill;

    public Hotel_Billing(int nod,double room_tariff,double SC){
        no_days=nod;
        this.room_tariff=room_tariff;
        serviceCharge=SC;
    }

    public double total_bill(){
        return 5000 + no_days*1000 + room_tariff * no_days + serviceCharge;
    } 
    public void display(){
        System.out.println("No of days stayed: "+no_days);
        System.out.println("Room Tariff per day "+room_tariff);
        System.out.println("Service Charge: "+serviceCharge);
        System.out.println("Total Bill: "+total_bill());

    }

}

class q1{
    public static void main(String[] args) {
        int no;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of days stayed: ");
        no=sc.nextInt();
        Hotel_Billing room1=new Hotel_Billing(no,1000,450);
        room1.display();
        sc.close();
    
    }
}