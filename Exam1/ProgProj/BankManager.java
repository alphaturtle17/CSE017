/**
 * @author Thor Long
 * Date: 9/21/22
 * CSE 017
 * Main method for programming project, makes a user interface that users can manipulate the Bank class and bank account classes as well.
 */
import java.util.InputMismatchException;
import java.util.Scanner;
public class BankManager {
    public static void main(String[] args){
        String fileName = "accounts.txt";
        Bank thorBank = new Bank(fileName);
        Scanner scnr = new Scanner(System.in);
        try{
            int choice = 0;
            do{
                System.out.println("What would you like to do?");
                System.out.println("1. View Accounts\n2. Manage Account\n3. Add Account\n4. Remove an Account\n5. Sort Accounts by Balance\n6. View Closable Accounts (Accounts with < $200)\n7. Exit");
                choice = scnr.nextInt();
                switch(choice){
                    case 1:
                        thorBank.viewAll();
                        break;
                    case 2: //Bank Manager Switch Statement Incoming
                        System.out.println("Please enter a valid 10 digit bank account number: ");
                        try{
                            int managechoice = 0;
                            do{
                                long valid = scnr.nextLong();
                                //In find(), it throws an InvalidAccountNumberException if the bank account number doesn't exist.
                                System.out.println("What would you like to do?\n1. Withdraw money\n2. Deposit Money\n3. Apply Monthly Interest (Savings accounts only)\n4. Apply Investment Risk (Investment accounts only)\n5. Exit");
                                int userChoice = scnr.nextInt();
                                switch(userChoice){
                                    case 1:
                                        System.out.println("How much money do you want to withdraw?");
                                        if(((BankAccount) thorBank.find(valid)).withdraw(scnr.nextInt())){
                                            System.out.println("Your new balance is: " + ((BankAccount) thorBank.find(valid)).getBalance());
                                            break;
                                        }else{
                                            System.out.println("Insufficient Funds");
                                            break;
                                        }
                                    case 2:
                                        System.out.println("How much money do you want to deposit?");
                                        ((BankAccount) thorBank.find(valid)).deposit(scnr.nextInt());
                                        System.out.println("Your new balance is: " + ((BankAccount) thorBank.find(valid)).getBalance());
                                        break;
                                    case 3:
                                        if(((BankAccount) thorBank.find(valid)) instanceof Savings){
                                            double userInterest = ((Savings) ((BankAccount) thorBank.find(valid))).applyInterest();
                                            System.out.println("Amount added to balance: " + userInterest);
                                            System.out.println("New balance: " + ((BankAccount) thorBank.find(valid)).getBalance());
                                            break;
                                        }else{
                                            System.out.println("Not avaliable for your account type");
                                            break;
                                        }
                                    case 4:
                                        if(((BankAccount) thorBank.find(valid)) instanceof Investment){
                                            double userRisk = ((Investment) ((BankAccount) thorBank.find(valid))).applyRisk();
                                            System.out.println("Net difference in account: " + userRisk);
                                            System.out.println("New balance: " + ((BankAccount) thorBank.find(valid)).getBalance());
                                            break;
                                        }else{
                                            System.out.println("Not avaliable for your account type");
                                            break;
                                        }
                                    default:
                                        System.out.println("Invalid input");
                                        break;
                                }
                            }while(managechoice != 5);
                        }catch (Exception exception){
                            System.out.println(exception.getMessage());
                        }                        
                        break;
                    case 3:
                        try{
                            System.out.println("What type of account would you like to make?");
                            String type = scnr.next();
                            type = type.toLowerCase();
                            switch(type){
                                case "checking":
                                    try{
                                        System.out.println("Please enter a 10 digit account number: ");
                                        long checkNumber = scnr.nextLong();
                                        System.out.println("Enter your name: ");
                                        String checkOwner = scnr.next();
                                        System.out.println("Enter your balance: ");
                                        int checkBalance = scnr.nextInt();
                                        Checking ch = new Checking(checkNumber, checkOwner, checkBalance);

                                        thorBank.add(ch); //returs true but wtf
                                        
        
                                    }catch(Exception exception){
                                        System.out.println(exception.getMessage());
                                    }
                                    break;
                                case "savings":
                                    try{
                                        System.out.println("Please enter a 10 digit account number: ");
                                        long savNumber = scnr.nextLong();
                                        System.out.println("Enter your name: ");
                                        String savOwner = scnr.next();
                                        System.out.println("Enter your balance: ");
                                        int savBalance = scnr.nextInt();
                                        System.out.println("What is your yearly interest rate?");
                                        double yInterestRate = scnr.nextInt();
                                        Savings sa = new Savings(savNumber, savOwner, savBalance, yInterestRate);
                                        thorBank.add(sa);
                                        }catch(Exception exception){
                                            System.out.println(exception.getMessage());
                                        }
                                    break;
                                case "investment":
                                    try{
                                        System.out.println("Please enter a 10 digit account number: ");
                                        long invNumber = scnr.nextLong();
                                        System.out.println("Enter your name: ");
                                        String invOwner = scnr.nextLine();
                                        System.out.println("Enter your balance: ");
                                        int invBalance = scnr.nextInt();
                                        boolean good = false;
                                        String invType = "";
                                        do{
                                            System.out.println("What is your type of investment account?");
                                            invType = scnr.next();
                                            if(invType.toLowerCase().equals("property") || invType.toLowerCase().equals("growth") || invType.toLowerCase().equals("shares")){
                                                good = true;
                                            }else{
                                                System.out.println("Invalid Investment Type");
                                                good = false;
                                            }
                                        }while(good == false);
                                        
                                        Investment in = new Investment(invNumber, invOwner, invBalance, invType);
                                        thorBank.add(in);
                                        }catch(Exception exception){
                                            System.out.println(exception.getMessage());
                                        }
                                break;
                            }
                        }catch (Exception exception){
                            System.out.println(exception);
                        }
                        break;
                    case 4:
                        System.out.println("Please enter a valid 10 digit bank account number: ");
                        long remove = scnr.nextLong();
                        try{
                            thorBank.remove(remove);
                        }catch (Exception exception){
                            System.out.println(exception.getMessage());
                        }
                        break;
                    case 5:
                        thorBank.sort();
                        thorBank.viewAll();
                        break;
                    case 6:
                        thorBank.viewClosable();
                        break;
                    case 7:
                        thorBank.saveAccounts(fileName);
                        break;
                    default:
                        System.out.println("Invalid input");
                        break;
                }
            }while(choice != 7);
        }catch(InputMismatchException exception){
            System.out.println(exception.getMessage());
        }
    }
}
