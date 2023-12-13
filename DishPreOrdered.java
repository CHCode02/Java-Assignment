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
public class DishPreOrdered {
      private int id;
      private Dish d;
      private int quantity;
      private String remark;

    public DishPreOrdered(Dish d, int quantity) {
        this.d = d;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public Dish getD() {
        return d;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getRemark() {
        return remark;
    }

    
      
    public double calculateSubTotal(){
        return d.getDish_price()*quantity;
    }  

}
