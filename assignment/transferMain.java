package assignment;

import java.util.Scanner;

public class transferMain {
    static String staffPassword = "Abc123";
    static double payment1 = 250.00;

     public static void main(String[] args){
         Account[] bankListArr = presetData();//Array for storing variable data



        Scanner userInput = new Scanner(System.in);
        int continueChoice = 0;
        do{
            String[] bankToStringArr = new String[]{     //Array for storing toString data
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
            int decision =  userInput.nextInt();
            int userIndex;
            if(decision == 1){
                int bankChoice;
                String userBankType;
                do{
                    System.out.println("Transfer Menu:\n");
                    System.out.println("Which Bank did you want to pay?\n");
                    System.out.println("""
                        1.MayBank
                        2.Public Bank
                        3.Hong Leong Bank
                        4.back""".indent(2));
                    System.out.println("Enter your choice here:");
                    bankChoice =  userInput.nextInt();
                    bankMenu(bankChoice);
                }while(bankChoice <= 0 ||bankChoice > 4);

                userBankType = translateBankType(bankChoice);
                String userName,userPsw;

                int errorCounter = 0;
                do{
                    System.out.println("UserName:");
                    userName =  userInput.next();

                    System.out.println("Password:");
                    userPsw =  userInput.next();


                    userIndex = checkAccount(userBankType,userName,userPsw,bankListArr);

                    if(userIndex == -1){
                        System.out.println("No Record found/Username or password is incorrect...Please try again");
                        errorCounter++;
                    }
                    else{
                        System.out.println("Welcome"+bankListArr[userIndex].getHolderName());
                        break;
                    }
                }while(errorCounter < 3);

                if(errorCounter < 3){

                    System.out.println("      ==Transfer Section==");
                    System.out.println("  Transfer Amount : RM"+payment1);
                    System.out.println("  From Account : "+bankListArr[userIndex].getAccountNo()+" ("+bankListArr[userIndex].getHolderName()+")");
                    System.out.println("  To Account  : "+bankListArr[0].getAccountNo()+" ("+bankListArr[0].getHolderName()+")");
                    int confirmation;
                    do{
                        System.out.println("Reminder << MAKE SURE THE ACCOUNT NO AND AMOUNT IS CORRECT BEFORE ACCEPT THE PROCESS.>>");
                        System.out.println("Do you accept the Transaction?(Yes = 1)(No = 0)");
                        confirmation =  userInput.nextInt();
                        if(confirmation < 0 || confirmation > 1){
                            System.out.println("Error!! Invalid Input Please Try Again");
                        }
                    }while (confirmation < 0 || confirmation > 1);
                    if(confirmation == 1){
                        System.out.println(userIndex);
                        bankListArr[userIndex].setBalance(Account.payment(bankListArr[userIndex].getBalance(),payment1));
                        bankListArr[0].setBalance(Account.receive(bankListArr[0].getBalance(),payment1));
                        System.out.println("Account Balance:RM"+bankListArr[userIndex].getBalance());
                    }
                }
                else {
                    System.out.println("Bye Bye!!");
                    System.out.println("Back to last menu");
                }
                System.out.println("-------------------------------Method End Here-------------------------------");
            }

            else if(decision == 2){
                for (String s : bankToStringArr) {
                    System.out.println(s);
                }
                System.out.println("-------------------------------Method End Here-------------------------------");
            }


            else if(decision == 3){
                int settingChoice ;
                int choiceBankType;
                String modifyBankType;
                int modifyAccountNo;
                int conformation;

                checkPassword();
                do{
                    System.out.println("Setting Menu:");
                    System.out.println("    1.Change Restaurant Bank Detail");
                    System.out.println("    2.Change Staff Password");
                    System.out.println("    3.Back");
                    System.out.println("Enter your choice here:");
                    settingChoice =  userInput.nextInt();

                    if(settingChoice <= 0||settingChoice > 3){
                        System.out.println("Error!! Invalid Input!! Please Try Again");
                    }
                }while(settingChoice <= 0||settingChoice > 3);

                if(settingChoice == 1){
                    do{
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
                        System.out.println("Bank.: "+bankListArr[0].getBankType());
                        System.out.println("Account No.: "+bankListArr[0].getAccountNo());
                        System.out.println("\n==To==");
                        System.out.println("Bank.: "+modifyBankType);
                        System.out.println("Account No.: "+modifyAccountNo);

                        do{
                            System.out.println("\nDo you sure you want to change?(Yes = 1)(No = 0)(Edit = 2)");
                            conformation = userInput.nextInt();
                            if(conformation < 0||conformation > 2){
                                System.out.println("Error!! Invalid Input!! Please Try Again...");
                            }
                        }while(conformation < 0||conformation > 2);

                        if(conformation == 1){
                            bankListArr[0].setBankType(modifyBankType);
                            bankListArr[0].setAccountNo(modifyAccountNo);
                            System.out.println("Restaurant Account Changed!!");
                        }
                        else if(conformation == 2){
                            System.out.println("====New Modify Section====");
                        }
                        else{
                            System.out.println("Back to main");
                        }

                    }while(conformation == 2);
                }

                else if(settingChoice == 2){
                    String modifyStaffPsw,confirmNewStaffPsw;
                    do{
                        System.out.println("Enter New Staff Password(More Than 6 character/words/symbol):");
                        modifyStaffPsw = userInput.nextLine();

                        System.out.println("Confirm Your password:");
                        confirmNewStaffPsw = userInput.nextLine();

                        if(modifyStaffPsw.equals(confirmNewStaffPsw)){
                            if(modifyStaffPsw.length() > 6){
                                staffPassword = modifyStaffPsw;
                            }
                            else{
                                System.out.println("Error!!Password less than 6 character/words/symbol");
                            }
                        }
                        else{
                            System.out.println("Error!!Password is not Same");
                        }
                    }while(modifyStaffPsw.length() < 6|| !modifyStaffPsw.equals(confirmNewStaffPsw));
                }
            }
            System.out.println("Do you want to continue?(Yes = 1)(No = 0)");
            continueChoice = userInput.nextInt();
        }while(continueChoice == 1);
    }
    /*
    //End of Main Method
    ////////////////////////////////////
    //Support Method
    */
    private static void checkPassword(){
        Scanner pswInput = new Scanner(System.in);
        int errorCounter = 0;
        int result = 0;
        do{
            if (errorCounter == 3){
                System.out.println("Bye bye!\n");
                System.out.println("----Main menu shown out here----");
                System.out.println("<Ignore Below Statement>");
            }

            System.out.println("Please Enter Password");
            String psw = pswInput.nextLine();

            if(psw.equals(staffPassword)){
                System.out.println("Welcome !!");
                result = 1;
            }

            else{
                System.out.println("Password Error!");
                errorCounter ++;
            }
        }while(result == 0);
    }

    private static void bankMenu(int choice){
        switch (choice) {
            case 1 -> System.out.println("Welcome to <<MayBank>> Transfer Page!!");
            case 2 -> System.out.println("Welcome to <<Public Bank>> Transfer Page!!");
            case 3 -> System.out.println("Welcome to <<Heong Leong Bank>> Transfer Page!!");
            case 4 -> System.out.println("back to main menu!!");
            default -> System.out.println("Error!! Invalid Input!! Please Try Again");
        }
    }

    private static String translateBankType(int choice){
        return switch (choice) {
            case 1 -> "MayBank";
            case 2 -> "Public Bank";
            case 3 -> "Heong Leong";
            case 4 -> "Main";
            default -> "Error";
        };
    }

    private static Account[] presetData(){
            Account[] bankDetail = new Account[6];
            bankDetail[0] = new Account("Public Bank", "LeeFranchise", "lee0000", "Lee Franchise Sdn Bhd", 2004873, 15000.00);
            bankDetail[1] = new Account("MayBank", "Tan001", "tan0001", "Tan", 205001, 3000.00);
            bankDetail[2] = new Account("Heong Leong", "Tiew002", "tiew0002", "Tiew", 205002, 5000.00);
            bankDetail[3] = new Account("Public Bank", "Lee003", "tiew0003", "Lee", 205003, 8000.00);
            bankDetail[4] = new Account("MayBank", "Aden004", "aden0004", "Aden", 205004, 6000.00);
            bankDetail[5] = new Account("Heong Leong", "Yew005", "yew0005", "Yew", 205005, 2000.00);

        return bankDetail;
    }

    private static int checkAccount(String userBankType,String userName,String userPsw,Account[] bankAccount) {
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
        if (result == 0){
            return -1;
        }
        else{
            return accountLocate;
        }
    }
}

