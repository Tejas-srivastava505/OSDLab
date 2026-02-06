public class Q1 {
    public static void main(String[] args) {
        Hotel hotel=new Hotel(2);
    for(int i=0;i<3;i++){
        new customer(hotel, "Customer "+i).start();
    }
    }
}
class Hotel {
    private int availableRooms;

    public Hotel( int a){
        availableRooms=a;
    }

    public synchronized void bookRoom(String customername){
        while(availableRooms==0){
            System.out.println(customername + " is waiting to book a room ...");
            try{
                wait();
            } catch (InterruptedException e){
                System.out.println("An error occured.");
                return;
            }

        }
        availableRooms--;
        System.out.println("Room booked by: "+customername+"\nRooms left: "+availableRooms);
    }

    public synchronized void releaseRoom(String custname){
        availableRooms++;
        System.out.println(custname + " is leaving the room...." + "\nRoom left: "+availableRooms);
        notifyAll();
    }   
}

class customer extends Thread{
    private final Hotel hotel;
    private final String custName;
    customer(Hotel hotel, String custName){
        this.hotel=hotel;
        this.custName=custName;
    }

    public void run(){
        hotel.bookRoom(custName);

        try{
            Thread.sleep(1000);
        }
        catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        hotel.releaseRoom(custName);
    }
}



