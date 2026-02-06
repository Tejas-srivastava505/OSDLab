// Design and implement a Java application to simulate an Online Order Processing System where multiple customer orders are processed simultaneously using multithreading.
// i.
// In an e-commerce platform, several operations such as order validation, payment processing, and order shipment must be handled concurrently for different customers. To improve system performance and responsiveness, each order processing task should be executed in a separate thread.
// ii.
// Create individual threads for handling different customer orders or different stages of order processing. Each thread should simulate processing by displaying status messages and using the sleep() method to represent time-consuming operations.
// iii.
// The main program should start multiple threads at the same time and demonstrate concurrent execution of order-related tasks.

class Customer implements Runnable{
    String ops;
    int duration;
    Customer(String ops, int duration){
        this.ops=ops;
        this.duration=duration;
    }
    @Override
    public void run(){
        try{
            System.out.println("Doing "+ops);
            Thread.sleep(duration);
            System.out.println("Time taken: "+duration);
            System.out.println("Operation completed");
        }
        catch (InterruptedException e){
            System.out.println("Task interrupted");
        }
    }
}


public class Online_order {
    public static void main(String[] args) {
        Customer cust1=new Customer("Order Validation", 1500);
        Customer cust2=new Customer("Payment Processing", 2000);
        Customer cust3=new Customer("Order Shipment", 1800);
        Thread t1=new Thread(cust1,"Operation for customer 1");
        Thread t2=new Thread(cust2,"Operation for customer 2");
        Thread t3=new Thread(cust3,"Operation for customer 3");
        t1.start();
        t2.start();
        t3.start();
    }
    
}
