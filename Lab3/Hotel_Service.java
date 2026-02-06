// 1.
// Design and implement a Java application to simulate a Hotel Room Service Management System where multiple service requests are handled concurrently using multithreading.
// i.
// In a hotel, different room service tasks such as room cleaning, food delivery, and maintenance may occur at the same time. To efficiently manage these tasks, the application should create separate threads for each service request so that they can execute concurrently rather than sequentially.
// ii.
// Create individual threads for different service operations using Java thread creation techniques (Thread class or Runnable interface). Each thread should simulate a service task by displaying status messages and pausing execution using the sleep() method to represent processing time.
// iii.
// The main program should start multiple threads simultaneously and demonstrate concurrent execution of hotel service tasks.

class Hotel extends Thread{
    int RoomNumber;
    String ServiceName;
    int duration;
    Hotel(int RoomNumber,String ServiceName, int duration){
        this.RoomNumber=RoomNumber;
        this.ServiceName=ServiceName;
        this.duration=duration;
    }
    @Override
    public void run(){
        try{
            System.out.println(ServiceName +" is in process. Will take "+duration+" seconds");
            Thread.sleep(duration);
            System.out.println(ServiceName+ " is completed");
        }
        catch(InterruptedException e){
            System.out.println("Interrupted. ");
        }
    }
}
class Hotel_Service{
    public static void main(String args[]){
        Hotel service1=new Hotel(101,"Room Cleaning",500);
        Hotel service2=new Hotel(101,"Food delivery",800);
        Hotel service3=new Hotel(101,"Maintenance",1000);
        service1.start();
        service2.start();
        service3.start();

    }
}