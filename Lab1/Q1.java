package Lab1;
import java.util.*;

/*Create a Book class with private data members including book ID, book title, 
author name, price, and availability status. Provide public setter methods to assign 
values to these data members and public getter methods to retrieve their values. 
Include validation in setter methods to ensure that the price is a positive value.*/
class book{
    private int book_ID,price;
    private String book_title,author;
    boolean availabilty; 
    public void setID(int book_ID){
        this.book_ID=book_ID;
    }
    public void setTitle(String book_title){
        this.book_title=book_title;
    }
    public void setAuthor(String author){
        this.author=author;
    }
    public void setPrice(int price){
        if(validate(price)){
            this.price=price;
        }
    }
    public void setAvailability(boolean availabilit){
        availabilty=availabilit;
    }
    public boolean validate(int price){
        if(price<0){
            System.out.println("Wrong value of price.");
            return false;
        }
        return true;
    }
    //this.author=author;
    public void displayID(){
        System.out.println("Book_ID: "+book_ID);
    }
    public void displayTitle(){
        System.out.println("Title: "+book_title);
    }
    public void displayAuthor(){
        System.out.println("Author: "+author);
    }
    public void displayPrice(){
        System.out.println("Price: "+price);
    }
    public void displayAvailability(){
            System.out.println("Availability: "+availabilty);
    }

}    


public class Q1{
    public static void main(String[] args) {
        book b=new book();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the book ID: ");
        b.setID(sc.nextInt());
        sc.nextLine();
        System.out.println("Enter the book Title: ");
        b.setTitle(sc.nextLine());
        System.out.println("Author name: ");
        b.setAuthor(sc.nextLine());
        System.out.println("Price: ");
        b.setPrice(sc.nextInt());
        System.out.println("Available(true or false): ");
        b.setAvailability(sc.nextBoolean());
        b.displayID();
        b.displayTitle();
        b.displayAuthor();
        b.displayPrice();
        b.displayAvailability();
        sc.close();
    }
}