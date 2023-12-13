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
public class Cash extends Payment{
    private double amount;

    public Cash(BookingDetail bd) {
        super(bd);
    }

    public Cash() {
    }

    
    public Cash(double amount, BookingDetail bd) {
        super(bd);
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    
    
    
    public double calculateBalance(){
        return amount - super.getBd().calculateTotal();
    }
    
}
