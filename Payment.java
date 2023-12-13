/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;



/**
 *
 * @author HP
 */
public class Payment {
    private BookingDetail bd;

    public Payment(BookingDetail bd) {
        this.bd = bd;
    }

    public Payment() {
    }

    public BookingDetail getBd() {
        return bd;
    }

  
    @Override
   
        public String toString() {
        return "==========Payment=========={" 
             + "Booking Details = " + bd +"\n"
             + "===========================";    }
    

}
