package assignment;
import java.util.Scanner;
import java.lang.String;

/**
 *
 * @author CHONG KAO WEI
 */
public class User {
    static Scanner input = new Scanner(System.in);
    private String username;
    private String password;
    private String phone;
    private String email;
    
    public User(){
    
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public User(String username, String password, String phoneOrEmail) {
        this.username = username;
        this.password = password;
        this.email = phoneOrEmail;
    }

    public User(String username, String password, String phone, String email) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public int validatePassword(String username){
        return 0;
    }
    
    public int validatePhone(String phone){
        return 0;
    }
    
    public int validateEmail(String email){
        return 0;
    }
    
    public int checkUsername(String username){
        if(username.equals(this.username))
            return 0;
        else
            return 1;
    }
    
    public int checkPassword(String password){
        if(password.equals(this.password))
            return 0;
        else
            return 1;
    }
    
    public void resetPassword(String password){
        this.password = password;
    }
    
    public int confirmPassword(String password){
        if(password.equals(this.password))
            return 0;
        else
            return 1;
    }
    
    public static void userMenu(){
        System.out.printf("""
               User Menu              
               1. Customer
               2. Recipient
               3. Exit
               
               Please enter your selection:""");
    }
    
    public void ProfileMenu() {
    
    }
    
    @Override
    public String toString(){
        return "\nUsername   : " + this.getUsername() +
                "\nPhone      : " + this.getPhone() +
                "\nEmail      : " + this.getEmail();
    }
    
}
