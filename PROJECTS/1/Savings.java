/**
 * @author Thor Long
 * Date: 9/14/2022
 * CSE 017
 * Savings class extends bankaccount as a type and also has yearly interest rate
 */
public class Savings extends BankAccount{
    private double YearlyInterestRate;
    /**
     * Constructor with 3 arguments for savings accounts
     * @param owner for name of owner
     * @param balance for amount of money in accountas
     * @param yInterestRate for interest rate of savings account
     */
    Savings(long number, String owner, double balance, double yInterestRate){
        super(number, owner, balance);
        YearlyInterestRate = yInterestRate;
    }
    /**
     * Getter method for yearly interest rate
     * @return double YearlyInterest rate
     */
    public double getYearlyInterest(){
        return YearlyInterestRate;
    }
    /**
     * Getter method for monthly interest rate divides yearly interest by 12 and div by 100
     * @return double MonthlyInterest
     */
    public double getMonthlyInterest(){
        double MonthlyInterest = ((YearlyInterestRate / 12) / 100) * balance;
        return MonthlyInterest;
    }
    /**
     * Setter method to set yearly interest rate to balance
     * @param y to set yearly interest rate
     */
    public void setYearlyInterest(double y){
        YearlyInterestRate = y;
    }
    /**
     * Method to apply monthly interest to balance and returns amount 
     * @return interestAmount amount of money added to balance
     */
    public double applyInterest(){
        double interestAmount = getMonthlyInterest();
        balance  += interestAmount;
        return interestAmount;
    }
    /**
     * toString method overriding super class to add yearly interest rate to information
     * @return String s for information format
     */
    @Override
    public String toString(){
        String s = super.toString();
        s +=  YearlyInterestRate + "\t";
        return s;
    }
    /**
     * simplestring method returns formatted savings account line for writing
     * @return String for format
     */
    @Override
    public String simpleString(){
        String s = super.simpleString();
        s += "|" + YearlyInterestRate;
        return s;
    }
}
