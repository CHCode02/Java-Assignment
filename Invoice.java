/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.time.LocalDate;


/**
 *
 * @author HP
 */
public class Invoice {
    private Cash cash;
    private LocalDate date_generate;
    private Account account;
    
    public Invoice(Cash cash) {
        this.cash = cash;
        this.date_generate = LocalDate.now();    
       
        System.out.println("Invoice");
        System.out.println("==============");
        System.out.println("Date " + date_generate);
        System.out.println(cash.getBd().toString());
        System.out.printf("Cash : RM%.2f",cash.getAmount());
        System.out.println("Balance : RM"+ cash.calculateBalance());
    }
 
    
    public Invoice (Account account){
        this.date_generate = LocalDate.now();
        
        System.out.println("Invoice");
        System.out.println("==============");
        System.out.println("Date " + date_generate);
        System.out.println("Bank "+account.getBankType());
        System.out.println("Account Name "+account.getUserName());
      
      
    }

}
