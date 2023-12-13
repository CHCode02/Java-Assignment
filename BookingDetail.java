/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author HP
 */
public class BookingDetail {
    private String book_no;
    private Date booking_date;
    private Date booking_time;
    private int booking_hour;
    private Table table;
    private ArrayList<DishPreOrdered> dish_ordered= new ArrayList<DishPreOrdered>();

    public BookingDetail() {
    }


    public BookingDetail( Date booking_date,Date booking_time, int booking_hour, Table table) {
        this.book_no +=1;
        this.booking_date = booking_date;
        this.booking_time = booking_time;
        this.booking_hour = booking_hour;
        this.table = table;
        
    }

    public String getBook_no() {
        return book_no;
    }

    public Date getBooking_date() {
        return booking_date;
    }

    public int getBooking_hour() {
        return booking_hour;
    }

    public Date getBooking_time() {
        return booking_time;
    }
    
    



    public Table getTable() {
        return table;
    }

    public ArrayList<DishPreOrdered> getDish_ordered() {
        return dish_ordered;
    }

    public void setBooking_date(Date booking_date) {
        this.booking_date = booking_date;
    }

    public void setBooking_hour(int booking_hour) {
        this.booking_hour = booking_hour;
    }

    public void setBooking_time(Date booking_time) {
        this.booking_time = booking_time;
    }

    public void setTable(Table table) {
        this.table = table;
    }
    
    
    
    //preorder dish
    public void preOrderDish(Dish d,int quantity){
        dish_ordered.add(new DishPreOrdered(d,quantity));
    }
    
    public void removeDish(int index){
        dish_ordered.remove(index-1);
    }
    
    public double calculateTotal(){
        double total=0;
        for(int x = 0;x<dish_ordered.size();x++){
            total += dish_ordered.get(x).calculateSubTotal();
        }
        return total;
    }

    @Override
   public String toString() {
        return "==========Booking Details==========\n"
             + "Booking No   = " + book_no +"\n"
             + "Booking Date = " + booking_date +"\n"
             + "Booking Time = " + booking_time +"\n"
             + "Booking Hour = " + booking_hour +"\n" 
             + "Table No     = " + table +"\n"
             + "Dish Ordered = " + super.toString()+"\n";
      
    }
    

}
