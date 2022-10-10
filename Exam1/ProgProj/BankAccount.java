/**
 * @author Thor Long
 * Date: 9/14/22
 * CSE 017
 * BankAccount is the parent class for checking, savings and investment bank accounts
 */
import java.util.Random;
public abstract class BankAccount implements Comparable<BankAccount>, Closable{
    private long number;
    private String owner;
    protected double balance;
    /**
     * Constructor with 2 parameters
     * @param owner for name of bankaccount owner
     * @param balance for balance of bankaccount
     * Initializes random number for bank account number
     */
    protected BankAccount(String owner, double balance){
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
    protected BankAccount(long number, String owner, double balance){
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
    /**
     * Compares balances of own bank account to ba
     * @param ba for bank account comparing to
     * @return 1 if balance > ba, -1 if balance < ba, 0 if balances are equal
     */
    public int compareTo(BankAccount ba){
        double bank1 = getBalance(); 
        double bank2 = ba.getBalance();

        if(bank1 > bank2){
            return 1;
        }else if(bank1 < bank2){
            return -1;
        }else{
            return 0; //Balances are equal
        }
    }
    /**
     * Checks to see if bankaccount is closable
     * @return true if balance < 200, else false
     */
    public boolean isClosable(){
        if (getBalance() < 200) {
            return true;
        }
        else {
            return false;
        }
    }
}
