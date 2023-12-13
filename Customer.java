package assignment;

import java.util.ArrayList;
import java.util.Date;
import java.lang.String;
import java.util.Scanner;

/**
 *
 * @author CHONG KAO WEI
 */
public class Customer extends User {

    private String customerId;
    private char gender;
    private Date dob;
    private String address;
    char setGender;
    int custno = 20210000;

    public Customer() {
    }

    public Customer(String username, String password, char gender) {
        super(username, password);
        this.gender = gender;
        custno++;
        this.customerId = "CUST" + custno;
    }

    public Customer(String username, String password, String phoneOrEmail, char gender) {
        super(username, password, phoneOrEmail);
        this.gender = gender;
        custno++;
        this.customerId = "CUST" + custno;
    }

    public Customer(String username, String password, String phone, String email, char gender) {
        super(username, password, phone, email);
        this.gender = gender;
        custno++;
        this.customerId = "CUST" + custno;
    }

    public Customer(String username, String password, char gender, Date dob) {
        super(username, password);
        this.gender = gender;
        this.dob = dob;
        custno++;
        this.customerId = "CUST" + custno;
    }

    public Customer(String username, String password, String phoneOrEmail, char gender, Date dob) {
        super(username, password, phoneOrEmail);
        this.gender = gender;
        this.dob = dob;
    }

    public Customer(String username, String password, String phone, String email, char gender, Date dob) {
        super(username, password, phone, email);
        this.gender = gender;
        this.dob = dob;
        custno++;
        this.customerId = "CUST" + custno;
    }

    public Customer(String username, String password, char gender, String address) {
        super(username, password);
        this.gender = gender;
        this.address = address;
        custno++;
        this.customerId = "CUST" + custno;
    }

    public Customer(String username, String password, String phoneOrEmail, char gender, String address) {
        super(username, password, phoneOrEmail);
        this.gender = gender;
        this.address = address;
        custno++;
        this.customerId = "CUST" + custno;
    }

    public Customer(String username, String password, String phone, String email, char gender, String address) {
        super(username, password, phone, email);
        this.gender = gender;
        this.address = address;
        custno++;
        this.customerId = "CUST" + custno;
    }

    public Customer(String username, String password, char gender, Date dob, String address) {
        super(username, password);
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        custno++;
        this.customerId = "CUST" + custno;
    }

    public Customer(String username, String password, String phoneOrEmail, char gender, Date dob, String address) {
        super(username, password, phoneOrEmail);
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        custno++;
        this.customerId = "CUST" + custno;
    }

    public Customer(String username, String password, String phone, String email, char gender, Date dob, String address) {
        super(username, password, phone, email);
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        custno++;
        this.customerId = "CUST" + custno;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCustomerId() {
        return customerId;
    }

    public char getGender() {
        return gender;
    }

    public Date getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public void CustomerMenu() {
        System.out.printf("""
               Registration              
               1. Login
               2. Sign up
               3. Back
               
               Please enter your selection:""");
    }

    public int CustomerLogin(ArrayList<Customer> custList) {
        String username;
        String password;
        int valid = 0;
        int count = 1;
        int count2 = 1;
        do {
            System.out.println("\n\nCustomer Login");
            System.out.printf("Username: ");
            username = input.nextLine();
            for (Customer m : custList) {
                if (m.getUsername().equals(username)) {
                    break;
                } else {
                    valid++;
                }
                count++;
            }
            if (valid == custList.size()) {
                System.out.println("The username is not founded.");
                CustomerLogin(custList);
            }
            System.out.printf("Password: ");
            password = input.nextLine();
            for (Customer m : custList) {
                if (m.getPassword().equals(password)) {
                    break;
                }
                count2++;
            }
            if (count == count2) {
                System.out.println("Login Successful. Welcome " + username + ".");
            } else {
                System.out.println("Wrong password!!\n");
            }
        } while (count != count2);
        return count;
    }

    public void CustomerRegister(ArrayList<Customer> custList) {
        String username;
        char tempGender;
        System.out.println("\n\nCustomer Registration");
        System.out.printf("Username: ");
        username = input.nextLine();
        for (Customer m : custList) {
            if (m.getUsername().equals(username)) {
                System.out.println("The account is been created.");
                CustomerRegister(custList);
            } else {
                super.setUsername(username);
            }
        }
        System.out.printf("Password: ");
        super.setPassword(input.nextLine());
        do {
            System.out.printf("Gender(M/F): ");
            tempGender = input.next().charAt(0);
            if (tempGender == 'M' || tempGender == 'F' || tempGender == 'm' || tempGender == 'f') {
                this.gender = input.next().charAt(0);
            } else {
                System.out.println("Invalid input is entered. Gender in M or F only.");
            }
        } while (tempGender != 'M' && tempGender != 'F' && tempGender != 'm' && tempGender != 'f');
    }

    @Override
    public void ProfileMenu() {
        System.out.printf("""
               
               Customer Profile             
               1. View Profile
               2. Exit
               
               Please enter your selection:""");
    }

    public void viewProfile(Customer cust) {
        System.out.println(cust.toString());
    }

    @Override
    public String toString() {
        return "\nCustomer"
                + "\n\nCustomer ID: " + this.getCustomerId()
                + super.toString()
                + "\nGender     : " + this.getGender()
                + "\nDay of birth: " + this.getDob()
                + "\nAddress    : \n" + this.address;
    }

}
