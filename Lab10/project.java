import java.util.*;

class Hotel_Manager{
    enum Rooms{
        STANDARD(600),DELUXE(950),SUITE(1200);

        private Integer tariff;

        private Rooms(Integer tariff){
            this.tariff=tariff;
            
        }
        public void display(){
            System.out.println("The Room you have choosed is : "+this+"\nAnd the tariff applied per day : "+ this.tariff);
        }
        public Double display.z_bill(Integer nod){  
            System.out.println("The total bill is of: ")
        }
    }

}
class project{
    public static void main(String[] args){
        Hotel_Manager.Rooms r1=Hotel_Manager.Rooms.STANDARD;
        r1.display();
    }
}