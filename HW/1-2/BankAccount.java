/**
 * @author Thor Long
 * Date: 9/7/22
 * CSE 017
 * BankAccount is the parent class for checking, savings and investment bank accounts
 */
import java.util.Random;
public class BankAccount {
    private long number;
    protected String owner;
    protected double balance;
    /**
     * No argument constructor
     * No initialization or parameters
     */
    BankAccount(){
        Random rand = new Random();
        number = rand.nextInt(2147483647);
    }
    /**
     * Constructor with 2 parameters
     * @param owner for name of bankaccount owner
     * @param balance for balance of bankaccount
     * Initializes random number for bank account number
     */
    BankAccount(String owner, double balance){
        Random rand = new Random();
        number = rand.nextInt(2147483647);
        this.owner = owner;
        this.balance = balance;
    }
    /**
     * Constructor with 3 parameters 
     * @param number for account number
     * @param owner for owner of account
     * @param balance for balance of bankAccount
     */
    BankAccount(long number, String owner, double balance){
        this.number = number;
        this.owner = owner;
        this.balance = balance;
    }
    /**
     * Getter method for bank account number
     * @return number getter method for number
     */
    public long getNumber(){
        return number;
    }
    /**
     * Getter method for name of owner
     * @return String owner 
     */
    public String getOwner(){
        return owner;
    }
    /**
     * Getter method for double balance
     * @return double balance amount of money
     */
    public double getBalance(){
        return balance;
    }
    /**
     * deposit method adds double amount to balance
     * @param amount to add to balance
     */
    public void deposit(double amount){
        balance += amount;
    }
    /**
     * Withdraw method subtracts double amount of money from balance
     * @param amount for amount taking out of bankAccount
     * @return boolean t/f for if you are permitted to take money out/did the method do as expected
     */
    public boolean withdraw(double amount){
        if(amount > balance){
            return false;
        }else{
            balance -= amount;
            return true;
        }
    }
    /* 
     * toString method prints out the value
     * @return String s for data in BankAccount
     */
    public String toString(){
        String s = "\n";
        s += getClass().getSimpleName() + "\t\t";
        s += number +"\t";
        s += owner + "\t";
        s += balance + "\t";
        return s;
    }
    /**
     * Simplestring returns string of values formatted to be accepted with the array program
     * @return String s for simplestring
     */
    public String simpleString() {
        String s = getClass().getSimpleName();
        s += "|" + number;
        s += "|" + owner;
        s += "|" + balance;
        return s;
    }
}
