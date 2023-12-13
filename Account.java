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
public class Account extends Payment{
    private String bankType;
    private String userName;
    private String accountPsw;
    private String holderName;
    private int accountNo;
    private double balance;

    public Account(String bankType, String userName, String accountPsw, String holderName, int accountNo, double balance) {
        this.bankType = bankType;
        this.userName = userName;
        this.accountPsw = accountPsw;
        this.holderName = holderName;
        this.accountNo = accountNo;
        this.balance = balance;
    }

    
    
    public Account(String bankType, String userName, String accountPsw, String holderName, int accountNo, double balance,BookingDetail bd) {
        super(bd);
        this.bankType = bankType;
        this.userName = userName;
        this.accountPsw = accountPsw;
        this.accountNo = accountNo;
        this.holderName = holderName;
        this.balance = balance;
        
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAccountPsw() {
        return accountPsw;
    }

    public void setAccountPsw(String accountPsw) {
        this.accountPsw = accountPsw;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static double payment(double balance, double totalPayment) {
        return balance -= totalPayment;
    }

    public static double receive(double balance, double totalPayment) {
        return balance += totalPayment;
    }

    public int checkBalance(double totalPayment) {
        if (getBalance() < totalPayment) {
            return 1;
        } else {
            System.out.println("Error!!Insufficient Fund!!");
            return 0;
        }
    }

    @Override
    public String toString() {
        return "\tAccount" +
                "bankType='" + bankType + '\'' +
                ", userName='" + userName + '\'' +
                ", accountPsw='" + accountPsw + '\'' +
                ", holderName='" + holderName + '\'' +
                ", accountNo=" + accountNo +
                ", balance=" + balance +
                '}';
    }
}

