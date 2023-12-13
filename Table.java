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
public class Table {
       private String table_no;
        private int table_no_of_seat;

    public Table(String table_no, int table_no_of_seat) {
        this.table_no = table_no;
        this.table_no_of_seat = table_no_of_seat;
    }

    public String getTable_no() {
        return table_no;
    }

    public int getTable_no_of_seat() {
        return table_no_of_seat;
    }

    @Override
     public String toString() {
        return 
                   table_no +"\t\t" + table_no_of_seat ;
             
    }
        
        
}
