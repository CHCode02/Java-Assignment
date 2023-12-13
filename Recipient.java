package assignment;
import java.lang.String;

/**
 *
 * @author CHONG KAO WEI
 */
public class Recipient extends User {
    private String recipientName;

    public Recipient(String username, String password, String phone, String email, String recipientName) {
        super(username, password, phone, email);
        this.recipientName = recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientName() {
        return recipientName;
    }
    
    @Override
    public int checkUsername(String username){
        if(username.equals(super.getUsername()))
            return 0;
        else
            return 1;
    }
    
    @Override
    public int checkPassword(String password){
        if(password.equals(super.getPassword()))
            return 0;
        else
            return 1;
    }
    
    public void RecipientLogin(){
        String username;
        String password;
        int valid;
        do{
        System.out.println("\n\nRecipient Login");
        System.out.printf("Username: ");
        username = input.nextLine();
        valid = checkUsername(username);
        if(valid == 0) {
            System.out.printf("Password: ");
            password = input.nextLine();
            valid = checkPassword(password);
            if(valid == 0){
                System.out.println("Login Successful. Welcome " + super.getUsername() + ".");
            }
            else
                System.out.println("Wrong password!!\n");
        }
        else
            System.out.println("Wrong username!!\n");
        } while(valid != 0);
    }
    
    @Override
    public void ProfileMenu() {
        System.out.printf("""
               
               Recipient Profile             
               1. View Profile
               2. View Customer List
               3. Exit
               
               Please enter your selection:""");
    }
}
