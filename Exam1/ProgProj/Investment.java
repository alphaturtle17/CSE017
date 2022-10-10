/**
 * @author Thor Long
 * Date: 9/14/2022
 * CSE 017
 * Investment class is a type of Bankaccount that adds a new parameter type
 */
public class Investment extends BankAccount{
    private String type;
    /**
     * Constructor with 3 arguments
     * @param owner for name of investment account owner
     * @param balance for balance of account 
     * @param type for type of investment account
     */
    Investment(long number, String owner, double balance, String type){
        super(number, owner, balance);
        this.type = type;
    }
    /**
     * Getter method for type of investment account
     * @return String type for type of account
     */
    public String getType(){
        return type;
    }
    /**
     * Sets the type of the investment account to a string, limited to (property, growth, or shares accounts)
     * @param type for type of investment account
     */
    public void setType(String type){
        if(type.toLowerCase().equals("property") || type.toLowerCase().equals("growth") || type.toLowerCase().equals("shares")){
            this.type = type;
        }else{
            System.out.println("Invalid Investment Type");
        }
    }
    /**
     * Method applyRisk randomizes loss/gains for investment accounts (limited to 5% of total balance)
     * @return double risk, amount of money lost/gained, specified by negative or positive double values
     */
    public double applyRisk(){
        double risk = 0;
        double fivePercent = balance * .05;
        double number = Math.random();
        if(number < .5){//loss
            risk = Math.random() * -fivePercent;
            balance += risk;
        }else{//gain
            risk = Math.random() * fivePercent;
            balance += risk;
        }
        return risk;
    }
    /**
     * toString method formats output for investment classes to add to BankAccount toString
     * @return String s for data
     */
    @Override
    public String toString(){
        String s = super.toString();
        s += type + "\t";
        return s;
    }
    /**
     * method simplestring returns string value formatted for accepting the array of bankaccounts
     * @return string s for format
     */
    @Override
    public String simpleString(){
        String s = super.simpleString();
        s += "|" + type;
        return s;
    }
}
