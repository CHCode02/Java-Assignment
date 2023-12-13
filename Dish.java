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
public class Dish {
    
    private String dish_id;
    private String dish_name;
    private DishType dish_type;
    private double dish_price;
    private boolean dish_availability;

    public Dish(String dish_id, String dish_name, DishType dish_type, double dish_price, boolean dish_availability) {
        this.dish_id = dish_id;
        this.dish_name = dish_name;
        this.dish_type = dish_type;
        this.dish_price = dish_price;
        this.dish_availability = dish_availability;
    }
   
    public Dish(){
        
    }

    
    public String getDish_id() {
        return dish_id;
    }

    public String getDish_name() {
        return dish_name;
    }

    public DishType getDish_type() {
        return dish_type;
    }

    public double getDish_price() {
        return dish_price;
    }


    public boolean isDish_availability() {
        return dish_availability;
    }

    @Override
    public String toString() {
       return String.format("%s\t %-27s\t %.2f", dish_id,dish_name,dish_price);
        
    }
    
    
}
