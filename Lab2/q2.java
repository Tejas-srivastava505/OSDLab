import java.util.*;

/*Design and implement a Java application to manage room tariff details in a Hotel Management System using Java enumerations (enum). The application should demonstrate the use of enum constants, enum constructors, and enum methods.
i.
Define an enum named RoomType to represent different types of hotel rooms such as STANDARD, DELUXE, and SUITE. Each enum constant should be associated with a base tariff value using an enum constructor. The enum should also include methods to return the base tariff and to calculate the total room cost based on the number of days stayed.
ii.
Create a main class to select a room type, specify the number of days of stay, and compute the total room tariff by invoking the enum methods. The application should clearly illustrate how enum constructors are */
enum RoomType{
    STANDARD(600), DELUXE(950), SUITE(1200);

    private Integer tariff;
    
    private RoomType(int tariff){
        this.tariff=tariff;
    }
    


    Integer tariff(){
        return tariff;
    }

    Integer total_cost(int nod){
        return 5000+nod*tariff; 
    }
}
public class q2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter what type of room u want(in capital letters): ");
        String room=sc.next();
        RoomType r=RoomType.valueOf(room);
        System.out.println("Enter the numbers of days you want to stay: ");
        Integer nod=sc.nextInt();
        System.out.println("The room Tariff is : "+ r.tariff() );
        System.out.println("The room total cost is: " + r.total_cost(nod));
        sc.close();
    }
}
