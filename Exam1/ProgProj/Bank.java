/**
 * @author Thor Long
 * Date: 9/21/22   
 * CSE 017 
 * Bank is a collection of a max of 100 bank accounts, and has methods to manipulate and store different accounts
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.io.PrintWriter;
public class Bank {
    private BankAccount[] accounts = new BankAccount[100]; //Going to be some null values, just use count instead of accounts.length
    private int count;
    private String filename;
    /**
     * Constructor with one parameter
     * @param filename for name of file to be passed into Filereader
     */
    Bank(String filename){
        this.filename = filename;
        readAccounts(filename);
    }
    /**
     * Reads the accounts from a file, formats objects into arrays
     * @param filename for name of file
     */
    private void readAccounts(String filename){
        File file = new File(filename);
        try { //Count all of the lines in accounts.txt
            
            Scanner rf = new Scanner(file); //Scanner passing in file to read
            while (rf.hasNextLine()) {
                rf.nextLine();
                count++;
            }
            rf.close();
        } catch(FileNotFoundException f){
            System.out.println("Could not write to file " + filename);
        }
        try{
            Scanner rf = new Scanner(file);
            for(int i = 0; i < count; i++){
                String s = rf.nextLine();
                String[] attributes = s.split("\\|");
                
                if(Objects.equals(attributes[0], "Checking")){ //Using Objects we can check the actual object
                    accounts[i] = new Checking(Long.parseLong(attributes[1]), attributes[2], Double.parseDouble(attributes[3]));
                }else if(Objects.equals(attributes[0], "Savings")){
                    accounts[i] = new Savings(Long.parseLong(attributes[1]), attributes[2], Double.parseDouble(attributes[3]), Double.parseDouble(attributes[4]));
                }else if(Objects.equals(attributes[0], "Investment")){
                    accounts[i] = new Investment(Long.parseLong(attributes[1]), attributes[2], Double.parseDouble(attributes[3]), attributes[4]);
                }
            }
            rf.close();
        }catch(FileNotFoundException exception){
            System.out.println("Cannot write to " + filename);
        }
    }
    /**
     * Finds a BankAccount by looking through the account number
     * @param number for account number
     * @return BankAccount object
     * @throws InvalidAccountNumberException if account number is invalid
     */
    public BankAccount find(long number)
        throws InvalidAccountNumberException{
            for(int i = 0; i < count; i++){
                if(accounts[i].getNumber() == number){
                    return accounts[i];
                }
            }
            throw new InvalidAccountNumberException("Invalid account number");
        }
    /**
     * Adds a bank account to the array
     * @param ba for bank account
     * @return true or false if account was sucessfully added
     */
    public boolean add(BankAccount ba){
        if(count < accounts.length){ 
            
            accounts[count] = ba;
            count++;
            return true;
        }else{
            return false;
        }
    }
    /**
     * Removes account from array of bankaccounts
     * @param number for account number
     * @return t/f if method worked.
     */
    public boolean remove(long number){
        int temp = count;
        for(int i = 0; i < count; i++){
            if(accounts[i].getNumber() == number){
                accounts[i] = null;
                for(int j = i; j < count; j++){
                    accounts[j] = accounts[j+1];
                }
                count--;
            }
        }
        if(count < temp){
            return true;
        }else{
            throw new InvalidAccountNumberException();
        }
    }
    /**
     * Views formatted list in accounts array
     */
    public void viewAll(){
        for(int i = 0; i < count; i++){
            System.out.println(accounts[i]);
        }
    }
    /**
     * Views any account that isCloseable
     */
    public void viewClosable(){
        for(int i = 0; i < count; i++){
            if(accounts[i].isClosable()){
                System.out.println(accounts[i]);
            }
        }
    }
    /**
     * Sorts accounts
     */
    public void sort(){
        try{
            java.util.Arrays.sort(accounts, 0, count);
        }catch(Exception exception){
            System.out.println(exception.getMessage());
        }
    }
    /**
     * Uses printwriter to save the file to specified filename
     * @param filename for name of file writing to
     */
    public void saveAccounts(String filename){
        try{
            File file2 = new File(filename);
            PrintWriter pr = new PrintWriter(file2);
            for(int i = 0; i < count; i++){
                pr.print(accounts[i].simpleString());
                pr.println();
            }
            pr.close();
        }catch(FileNotFoundException exception){
            System.out.println("Cannot write to " + filename);
        }
    }
}
