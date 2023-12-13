/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.*;

/**
 *
 * @author HP
 */
public class Assignment1 {

    static String staffPassword = "Abc123";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean repeat = true;
        BookingDetail bd = new BookingDetail();
        Scanner input = new Scanner(System.in);
        Scanner user_input = new Scanner(System.in);
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
        JOptionPane.showMessageDialog(f, "Cusinational Restaurant");
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
        do {
            System.out.println("Welcome to reservation system");
            System.out.println("1 Reservation");
            System.out.println("2 Payment");
            System.out.println("Enter your choice > ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    String select;
                    clearScreen();
                    System.out.println("Reservation ");
                    System.out.println("1. Book Table");
                    System.out.println("2. Pre-order Dish");
                    System.out.println("3. Return");
                    do {
                        System.out.println("Select Choice");
                        select = user_input.nextLine();
                        switch (select) {
                            case "1":
                                clearScreen();
                                bd = BookTable();
                                break;
                            case "2":
                                clearScreen();
                                bd = PreOrderDish();
                                break;
                            case "3":
                                break;
                            default:
                                System.out.println("Ivalid Input");
                        }
                    } while (select.equals("1") == false && select.equals("2") == false && select.equals("3") == false);

                    break;
                case 2:
                    clearScreen();
                    case2(bd);

                    break;

                default:

            }
        } while (repeat = true);

    }

    public static void case2(BookingDetail bd) {
        String select;
        Scanner input = new Scanner(System.in);
        System.out.println("Payment");
        System.out.println("1. Cash");
        System.out.println("2. Bank Transfer");
        System.out.println("3. Return");
        do {
            System.out.println("Select Choice");
            select = input.nextLine();
            switch (select) {
                case "1":
                    clearScreen();
                    PayWithCash(bd);
                    break;
                case "2":
                    clearScreen();
                    PayWithAccount(bd);
                    break;
                case "3":
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        } while (select.equals("1") == false && select.equals("2") == false && select.equals("3") == false);

    }

    public static void PayWithCash(BookingDetail bd) {
        Scanner input = new Scanner(System.in);
        System.out.println("Total Price = RM" + bd.calculateTotal());
        System.out.print("Enter Amount >");
        double amount = input.nextDouble();
        Cash cash = new Cash(amount, bd);
        System.out.println("You Balance is " + cash.calculateBalance());
        Invoice invoice = new Invoice(cash);

    }

    public static void PayWithAccount(BookingDetail bd) {

        double payment1 = bd.calculateTotal();
        Scanner userInput = new Scanner(System.in);
        Account[] bankListArr = accountList();
        int continueChoice = 0;
        do {
            String[] bankToStringArr = new String[]{ //Array for storing toString data
                bankListArr[0].toString(),//For Development checking use only
                bankListArr[1].toString(),// bankToStringArr[0]
                bankListArr[2].toString(),
                bankListArr[3].toString(),
                bankListArr[4].toString(),
                bankListArr[5].toString() //bankListArray[4]
            };
            System.out.println("What Action Do you want to continue?");
            System.out.println("    1.Receive Payment");
            System.out.println("    2.Check Account Detail(Development Use Only)");
            System.out.println("    3.Setting");

            System.out.println("Enter your choice here:");
            int decision = userInput.nextInt();
            int userIndex;
            if (decision == 1) {
                int bankChoice;
                String userBankType;
                do {
                    System.out.println("Transfer Menu:\n");
                    System.out.println("Which Bank did you want to pay?\n");
                    System.out.println("""
                        1.MayBank
                        2.Public Bank
                        3.Hong Leong Bank
                        4.back""".indent(2));
                    System.out.println("Enter your choice here:");
                    bankChoice = userInput.nextInt();
                    bankMenu(bankChoice);
                } while (bankChoice <= 0 || bankChoice > 4);

                userBankType = translateBankType(bankChoice);
                String userName, userPsw;

                int errorCounter = 0;
                do {
                    System.out.println("UserName:");
                    userName = userInput.next();

                    System.out.println("Password:");
                    userPsw = userInput.next();

                    userIndex = checkAccount(userBankType, userName, userPsw, bankListArr);

                    if (userIndex == -1) {
                        System.out.println("No Record found/Username or password is incorrect...Please try again");
                        errorCounter++;
                    } else {
                        System.out.println("Welcome" + bankListArr[userIndex].getHolderName());
                        break;
                    }
                } while (errorCounter < 3);

                if (errorCounter < 3) {

                    System.out.println("      ==Transfer Section==");
                    System.out.println("  Transfer Amount : RM" + payment1);
                    System.out.println("  From Account : " + bankListArr[userIndex].getAccountNo() + " (" + bankListArr[userIndex].getHolderName() + ")");
                    System.out.println("  To Account  : " + bankListArr[0].getAccountNo() + " (" + bankListArr[0].getHolderName() + ")");
                    int confirmation;
                    do {
                        System.out.println("Reminder << MAKE SURE THE ACCOUNT NO AND AMOUNT IS CORRECT BEFORE ACCEPT THE PROCESS.>>");
                        System.out.println("Do you accept the Transaction?(Yes = 1)(No = 0)");
                        confirmation = userInput.nextInt();
                        if (confirmation < 0 || confirmation > 1) {
                            System.out.println("Error!! Invalid Input Please Try Again");
                        }
                    } while (confirmation < 0 || confirmation > 1);
                    if (confirmation == 1) {
                        System.out.println(userIndex);
                        bankListArr[userIndex].setBalance(Account.payment(bankListArr[userIndex].getBalance(), payment1));
                        bankListArr[0].setBalance(Account.receive(bankListArr[0].getBalance(), payment1));
                        System.out.println("Account Balance:RM" + bankListArr[userIndex].getBalance());
                        Invoice invoice = new Invoice(bankListArr[userIndex]);

                    }

                } else {
                    System.out.println("Bye Bye!!");
                    System.out.println("Back to last menu");
                }
                System.out.println("-------------------------------Method End Here-------------------------------");
            } else if (decision == 2) {
                for (String s : bankToStringArr) {
                    System.out.println(s);
                }
                System.out.println("-------------------------------Method End Here-------------------------------");
            } else if (decision == 3) {
                int settingChoice;
                int choiceBankType;
                String modifyBankType;
                int modifyAccountNo;
                int conformation;

                checkPassword();
                do {
                    System.out.println("Setting Menu:");
                    System.out.println("    1.Change Restaurant Bank Detail");
                    System.out.println("    2.Change Staff Password");
                    System.out.println("    3.Back");
                    System.out.println("Enter your choice here:");
                    settingChoice = userInput.nextInt();

                    if (settingChoice <= 0 || settingChoice > 3) {
                        System.out.println("Error!! Invalid Input!! Please Try Again");
                    }
                } while (settingChoice <= 0 || settingChoice > 3);

                if (settingChoice == 1) {
                    do {
                        System.out.println("""
                               1.MayBank
                             2.Public Bank
                             3.Hong Leong Bank
                           """);
                        System.out.println("Choose New Account Bank:");
                        choiceBankType = userInput.nextInt();
                        modifyBankType = translateBankType(choiceBankType);

                        System.out.println("Enter New Account No.:");
                        modifyAccountNo = userInput.nextInt();

                        System.out.println("    --Modify List--");
                        System.out.println("==From==");
                        System.out.println("Bank.: " + bankListArr[0].getBankType());
                        System.out.println("Account No.: " + bankListArr[0].getAccountNo());
                        System.out.println("\n==To==");
                        System.out.println("Bank.: " + modifyBankType);
                        System.out.println("Account No.: " + modifyAccountNo);

                        do {
                            System.out.println("\nDo you sure you want to change?(Yes = 1)(No = 0)(Edit = 2)");
                            conformation = userInput.nextInt();
                            if (conformation < 0 || conformation > 2) {
                                System.out.println("Error!! Invalid Input!! Please Try Again...");
                            }
                        } while (conformation < 0 || conformation > 2);

                        if (conformation == 1) {
                            bankListArr[0].setBankType(modifyBankType);
                            bankListArr[0].setAccountNo(modifyAccountNo);
                            System.out.println("Restaurant Account Changed!!");
                        } else if (conformation == 2) {
                            System.out.println("====New Modify Section====");
                        } else {
                            System.out.println("Back to main");
                        }

                    } while (conformation == 2);
                } else if (settingChoice == 2) {
                    String modifyStaffPsw, confirmNewStaffPsw;
                    do {
                        System.out.println("Enter New Staff Password(More Than 6 character/words/symbol):");
                        modifyStaffPsw = userInput.nextLine();

                        System.out.println("Confirm Your password:");
                        confirmNewStaffPsw = userInput.nextLine();

                        if (modifyStaffPsw.equals(confirmNewStaffPsw)) {
                            if (modifyStaffPsw.length() > 6) {
                                staffPassword = modifyStaffPsw;
                            } else {
                                System.out.println("Error!!Password less than 6 character/words/symbol");
                            }
                        } else {
                            System.out.println("Error!!Password is not Same");
                        }
                    } while (modifyStaffPsw.length() < 6 || !modifyStaffPsw.equals(confirmNewStaffPsw));
                }
            }
            System.out.println("Do you want to continue?(Yes = 1)(No = 0)");
            continueChoice = userInput.nextInt();
        } while (continueChoice == 1);
    }

    //Object List
    public static ArrayList<Dish> dishList() {

        ArrayList<Dish> dish_list = new ArrayList<Dish>();
        dish_list.add(new Dish("D01", "Fried Rice", DishType.Main, 6.95, true));
        dish_list.add(new Dish("D02", "Fried Noddle", DishType.Main, 6.95, true));
        dish_list.add(new Dish("D03", "Fried Bihun", DishType.Main, 6.95, true));
        dish_list.add(new Dish("D04", "Char Kuey Teow", DishType.Main, 8.95, true));
        dish_list.add(new Dish("D05", "Steamed Chicken", DishType.Meat, 21.95, true));
        dish_list.add(new Dish("D06", "Roasted Chicken", DishType.Meat, 24.95, true));
        dish_list.add(new Dish("D07", "Pecking Duck", DishType.Meat, 30.95, true));
        dish_list.add(new Dish("D08", "Salted Egg Crab", DishType.Seafood, 45.95, true));
        dish_list.add(new Dish("D09", "Salted Egg Tiger Prawn", DishType.Seafood, 35.95, true));
        dish_list.add(new Dish("D10", "Salted Egg Squid", DishType.Seafood, 37.95, true));
        dish_list.add(new Dish("D11", "Steamed Abalone", DishType.Seafood, 50.95, true));
        dish_list.add(new Dish("D12", "Chicken Soup", DishType.Soup, 14.95, true));
        dish_list.add(new Dish("D13", "ABC Soup", DishType.Soup, 14.95, true));
        dish_list.add(new Dish("D14", "Lotus Root Soup", DishType.Soup, 14.95, true));
        dish_list.add(new Dish("D15", "Seaweed Soup", DishType.Soup, 14.95, true));
        dish_list.add(new Dish("D16", "Shark Fin Soup", DishType.Soup, 90.45, true));
        dish_list.add(new Dish("D17", "Stir Fried Lettuce", DishType.Vegetable, 8.95, true));
        dish_list.add(new Dish("D18", "Stir Fried Eggplant", DishType.Vegetable, 10.95, true));
        dish_list.add(new Dish("D19", "Stir Fried Brocolli", DishType.Vegetable, 11.45, true));
        dish_list.add(new Dish("D20", "Stir Fried Cabbage", DishType.Vegetable, 9.45, true));
        dish_list.add(new Dish("D21", "Stir Fried Abalone Mushroom", DishType.Vegetable, 11.45, true));
        dish_list.add(new Dish("D22", "Mixed Vegetables", DishType.Vegetable, 12.95, true));
        dish_list.add(new Dish("D23", "Mixed Mushroom", DishType.Vegetable, 20.45, true));
        dish_list.add(new Dish("D24", "Red Bean Soup", DishType.Dessert, 14.95, true));
        dish_list.add(new Dish("D25", "Bird Nest Soup", DishType.Dessert, 31.45, true));

        return dish_list;
    }

    public static ArrayList<Table> tableList() {

        ArrayList<Table> table = new ArrayList<Table>();
        table.add(new Table("T01", 10));
        table.add(new Table("T02", 8));
        table.add(new Table("T03", 12));
        table.add(new Table("T04", 20));
        table.add(new Table("T05", 15));
        table.add(new Table("T06", 5));
        table.add(new Table("T07", 10));
        table.add(new Table("T08", 14));

        return table;
    }

    private static Account[] accountList() {
        Account[] bankDetail = new Account[6];
        bankDetail[0] = new Account("Public Bank", "LeeFranchise", "lee0000", "Lee Franchise Sdn Bhd", 2004873, 15000.00);
        bankDetail[1] = new Account("MayBank", "Tan001", "tan0001", "Tan", 205001, 3000.00);
        bankDetail[2] = new Account("Heong Leong", "Tiew002", "tiew0002", "Tiew", 205002, 5000.00);
        bankDetail[3] = new Account("Public Bank", "Lee003", "tiew0003", "Lee", 205003, 8000.00);
        bankDetail[4] = new Account("MayBank", "Aden004", "aden0004", "Aden", 205004, 6000.00);
        bankDetail[5] = new Account("Heong Leong", "Yew005", "yew0005", "Yew", 205005, 2000.00);

        return bankDetail;
    }

    //Reservation Function
    public static BookingDetail BookTable() {
        BookingDetail bd = new BookingDetail();
        Scanner input = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        int y;
        //Booking Date
        do {
            System.out.println("Enter your booking date (dd/MM/yyyy)");
            String string_date = input.nextLine();
            Date date;

            try {
                date = new SimpleDateFormat("dd/MM/yyyy").parse(string_date);
                bd.setBooking_date(date);
                y = 0;
            } catch (ParseException ex) {
                System.out.println("Invalid Date format. Please try again.");
                y = 1;
            }
        } while (y == 1);

        //Booking time
        do {
            System.out.println("Enter your booking time (HH:mm in 24 format)");
            String string_time = input.nextLine();
            Date time;

            try {
                time = new SimpleDateFormat("HH:mm").parse(string_time);
                bd.setBooking_time(time);
                y = 0;
            } catch (ParseException ex) {
                System.out.println("Invalid Time format. Please try again.");

                y = 1;
            }
        } while (y == 1);

        System.out.println("Enter total hour of booking");
        bd.setBooking_hour(input.nextInt());

        //select table
        tableList();
        System.out.println("Table No       Number Of Seat");
        System.out.println("================================");
        for (int x = 0; x < tableList().size(); x++) {
            System.out.println(tableList().get(x).toString());
        }
        System.out.println("Select table");
        while (y == 0) {
            y = 0;
            System.out.println("Enter Table ID > ");
            String user_input = sc.nextLine();

            for (int x = 0; x < tableList().size(); x++) {
                if (tableList().get(x).getTable_no().equals(user_input) == true) {
                    bd.setTable(tableList().get(x));
                    System.out.println("Booking Complete");
                    y = 1;
                }
            }
            if (y == 0) {
                System.out.println("No Table Found");
            }
        }
        clearScreen();
        return bd;
    }

    public static BookingDetail PreOrderDish() {
        Boolean repeat;
        BookingDetail bd = new BookingDetail();

        Scanner input = new Scanner(System.in);
        int y = 0;
        dishList();
        System.out.println("Pre-Order Dish\n");
        System.out.println("Dish ID  Dish Name                       Price");
        for (int x = 0; x < dishList().size(); x++) {
            System.out.println(dishList().get(x).toString());
        }
        while (y == 0) {
            while (y == 0) {
                y = 0;
                repeat = false;
                System.out.print("Enter Dish ID > ");
                String user_input = input.nextLine();
                System.out.print("Enter Quantity > ");
                int quantity = input.nextInt();
                input.nextLine();

                for (int x = 0; x < dishList().size(); x++) {
                    if (dishList().get(x).getDish_id().equals(user_input) == true) {
                        bd.preOrderDish(dishList().get(x), quantity);
                        System.out.println("Order Complete");
                        y = 1;
                    }
                }
                if (y == 0) {
                    System.out.println("No Dish Found");
                }
            }

            y = 0;

            System.out.println("Continue Order? (Y/N) > ");
            String again = input.nextLine();
            if (again.equals("N")) {
                y = 1;
            }
        }
        clearScreen();
        return bd;
    }

    //Account Function 
    private static void checkPassword() {
        Scanner pswInput = new Scanner(System.in);
        int errorCounter = 0;
        int result = 0;
        do {
            if (errorCounter == 3) {
                System.out.println("Bye bye!\n");
                System.out.println("----Main menu shown out here----");
                System.out.println("<Ignore Below Statement>");
            }

            System.out.println("Please Enter Password");
            String psw = pswInput.nextLine();

            if (psw.equals(staffPassword)) {
                System.out.println("Welcome !!");
                result = 1;
            } else {
                System.out.println("Password Error!");
                errorCounter++;
            }
        } while (result == 0);
    }

    private static void bankMenu(int choice) {
        switch (choice) {
            case 1 ->
                System.out.println("Welcome to <<MayBank>> Transfer Page!!");
            case 2 ->
                System.out.println("Welcome to <<Public Bank>> Transfer Page!!");
            case 3 ->
                System.out.println("Welcome to <<Heong Leong Bank>> Transfer Page!!");
            case 4 ->
                System.out.println("back to main menu!!");
            default ->
                System.out.println("Error!! Invalid Input!! Please Try Again");
        }
    }

    private static String translateBankType(int choice) {
        return switch (choice) {
            case 1 ->
                "MayBank";
            case 2 ->
                "Public Bank";
            case 3 ->
                "Heong Leong";
            case 4 ->
                "Main";
            default ->
                "Error";
        };
    }

    private static int checkAccount(String userBankType, String userName, String userPsw, Account[] bankAccount) {
        int result = 0;
        int accountLocate = 0;
        for (int index = 0; index < bankAccount.length; index++) {
            if (userBankType.equals(bankAccount[index].getBankType())) {
                if (userName.equals(bankAccount[index].getUserName())) {
                    if (userPsw.equals(bankAccount[index].getAccountPsw())) {
                        result++;
                        accountLocate = index;
                    }
                }
            }
        }
        if (result == 0) {
            return -1;
        } else {
            return accountLocate;
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
