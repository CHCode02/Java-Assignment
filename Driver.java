package assignment;

import javax.swing.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.String;
import java.io.File;
import java.io.IOException;

public class Driver {

    public static void main(String[] args) {
//        try {
//            File custFile = new File("custList.txt");
//            if (custFile.createNewFile()) {
//                System.out.println("File created: " + custFile.getName());
//            } else {
//                System.out.println("File already exists.");
//            }
//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//        }

        Scanner input = new Scanner(System.in);
        JFrame f = new JFrame();
        Recipient recipient = new Recipient("Kao Wei", "ABC123", "017-429 3447", "chongkw-wm20@student.tarc.edu.my", "Chong Kao Wei");
        ArrayList<Customer> custList = new ArrayList<>();
        Customer cust1 = new Customer("Gui Jun", "ABCDEF", 'M');
        Customer cust2 = new Customer("Sally", "AAAAAA", 'F');
        Customer cust3 = new Customer("Chen Hong", "123ABC", 'M');
        Customer newCust = new Customer();
        int choice, count = 1, count2 = 1;
        custList.add(cust1);
        custList.add(cust2);
        custList.add(cust3);
        JOptionPane.showMessageDialog(f, "LOGO");
        do {
            User.userMenu();
            choice = input.nextInt();
            if (choice < 1 || choice > 3) {
                System.out.println("Please enter a valid input.");
            }
        } while (choice < 1 || choice > 3);
        switch (choice) {
            case 1 -> {
                System.out.print("\n\n");
                do {
                    newCust.CustomerMenu();
                    choice = input.nextInt();
                    if (choice < 1 || choice > 3) {
                        System.out.println("Please enter a valid input.");
                    }
                } while (choice < 1 || choice > 3);
                switch (choice) {
                    case 1 ->
                        count = newCust.CustomerLogin(custList);
                    case 2 -> {
                        newCust.CustomerRegister(custList);
                        custList.add(newCust);
                    }
                    default -> {
                        System.out.println("Have a nice day, goodbye.");
                        System.exit(0);
                    }
                }
                for (Customer m : custList) {
                    if (count == count2) {
                        newCust = m;
                        break;
                    }
                    count2++;
                }
            }
            case 2 ->
                recipient.RecipientLogin();
            default -> {
                System.out.println("Have a nice day, goodbye.");
                System.exit(0);
            }
        }
        if (count != 1) {
            do {
                newCust.ProfileMenu();
                choice = input.nextInt();
                if (choice < 1 || choice > 2) {
                    System.out.println("Please enter a valid input.");
                }
            } while (choice < 1 || choice > 3);
            switch (choice) {
                case 1 ->
                    newCust.viewProfile(newCust);
                default -> {
                    System.out.println("Have a nice day, goodbye.");
                    System.exit(0);
                }
            }

        } else {
            do {
                recipient.ProfileMenu();
                choice = input.nextInt();
                if (choice < 1 || choice > 3) {
                    System.out.println("Please enter a valid input.");
                }

            } while (choice < 1 || choice > 3);
        }
    }
}
