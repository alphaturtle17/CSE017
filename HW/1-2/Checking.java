/**
 * @author Thor Long
 * Date: 9/7/2022
 * CSE 017
 * Checking class is a type of bankaccount 
 */
public class Checking extends BankAccount{
    /**
     * Noarg constructor
     * no parameters
     * no instantiation
     */
    Checking(){
        super();
    }
    /**
     * Constructor with 2 parameters 
     * @param owner name of owner of checking account 
     * @param balance double balance of checking account
     */
    Checking(long number, String owner, double balance){
        super(number, owner, balance);
    }
    /**
     * toString method for overriding toString and making everything look nice
     * @return String s formatting information
     */
    @Override
    public String toString(){
        String s = super.toString();
        return s;
    }
    /**
     * SimpleString returns formatted string
     * @return string s
     */
    @Override
    public String simpleString(){
        String s = super.simpleString();
        return s;
    }
}
