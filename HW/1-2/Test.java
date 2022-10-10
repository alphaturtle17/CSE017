/**
 * @author Thor Long
 * Date: 9/9/2022
 * CSE 017
 * Main method for running array of bankAccounts interacting with array of bankAccounts catching exceptions and reading/writing to file
 */
import java.util.Objects;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class Test {
    public static void main(String[] args){
        BankAccount[] bankAccounts = new BankAccount[50];
        File file = new File("accounts.txt");
        Scanner scnr = new Scanner(System.in);
        int counter = 0;
        try { //Count all of the lines in accounts.txt
            Scanner rf = new Scanner(file); //Scanner passing in file to read
            while (rf.hasNextLine()) {
                rf.nextLine();
                counter++;
            }
            rf.close();
        } catch (FileNotFoundException exception) {
            System.out.println("Cannot write to " + file);
        }

            try{
            Scanner rf = new Scanner(file);
            for(int i = 0; i < counter; i++){
                String s = rf.nextLine();
                String[] attributes = s.split("\\|");
                
                if(Objects.equals(attributes[0], "Checking")){ //Using Objects we can check the actual object
                    bankAccounts[i] = new Checking(Long.parseLong(attributes[1]), attributes[2], Double.parseDouble(attributes[3]));
                }else if(Objects.equals(attributes[0], "Savings")){
                    bankAccounts[i] = new Savings(Long.parseLong(attributes[1]), attributes[2], Double.parseDouble(attributes[3]), Double.parseDouble(attributes[4]));
                }else if(Objects.equals(attributes[0], "Investment")){
                    bankAccounts[i] = new Investment(Long.parseLong(attributes[1]), attributes[2], Double.parseDouble(attributes[3]), attributes[4]);
                }
            }
            rf.close();
        }catch(FileNotFoundException exception){
            System.out.println("Cannot write to " + file);
        }


        int choice = 0;
        do{
            try{
                System.out.println("What do you want to do?");
                System.out.println("1. View list of bank accounts\n2. Search accounts by number\n3. Add new account\n4. Remove existing account\n5. Sort list of bank accounts\n6. Exit");
                choice = scnr.nextInt();
                switch(choice){
                    case 1:
                        printBankAccounts(bankAccounts, counter);
                        break;
                    case 2:
                        try{
                            System.out.println("What account number are you searching for?");
                            long number = scnr.nextLong();
                            if(checkAccountNumber(number)){
                                findBankAccount(bankAccounts, counter, number);
                            }
                        }catch(InvalidAccountNumberException exception){
                            System.out.println(exception.getMessage());
                        }
                        break;
                    case 3:
                        System.out.println("What account would you like to make? (Checking, Savings, Investment)");
                        String userType = scnr.next();
                        if(Objects.equals(userType.toLowerCase(), "checking")){
                            counter++; 
                            System.out.println("What is your name?");
                            String name = scnr.next();
                            bankAccounts[counter+1] = new Checking(); //number needs to come automatically not inputted random here
                            bankAccounts[counter+1].owner = name;
                            bankAccounts[counter+1].balance = 0;

                        }else if(Objects.equals(userType.toLowerCase(), "savings")){
                            counter++; 
                            System.out.println("What is your name?");
                            String name = scnr.next();
                            bankAccounts[counter] = new Savings(); //number needs to come automatically not inputted random here
                            bankAccounts[counter].owner = name;
                            bankAccounts[counter].balance = 0;
                         
                        }else if(Objects.equals(userType.toLowerCase(), "investment")){
                            counter++; 
                            System.out.println("What is your name?");
                            String name = scnr.next();
                            System.out.println("What is your investment account type? (Property, growth, shares");
                            String investType = scnr.next();
                            bankAccounts[counter] = new Investment(); //number needs to come automatically not inputted random here
                            bankAccounts[counter].owner = name;
                            bankAccounts[counter].balance = 0;
                            ((Investment) bankAccounts[counter]).setType(investType);
                        }else{
                            System.out.println("Incorrect account type :(");
                        }
                        break;
                    case 4:
                        try{
                            System.out.println("What is your account number?");
                            long deleteNum = scnr.nextLong();
                            if(checkAccountNumber(deleteNum)){
                                for(int i = 0; i < bankAccounts.length; i++){
                                    if(deleteNum == bankAccounts[i].getNumber()){
                                        System.out.println("Account number " + bankAccounts[i].getNumber() + " has been deleted");
                                        bankAccounts[i] = null;
                                        for(int j = i; j < counter - 1; j++){
                                            bankAccounts[j] = bankAccounts[j+1];
                                        }
                                        counter--;
                                        break;
                                    }
                                }
                            }
                        }catch(InvalidAccountNumberException exception){
                            System.out.println(exception.getMessage());
                        }
                        break;
                    case 5:
                        sortBankAccounts(bankAccounts, counter);
                        break;
                    case 6:
                        try{
                            File file2 = new File("accounts.txt");
                            PrintWriter pr = new PrintWriter(file2);
                            for(int i = 0; i < counter; i++){
                                pr.print(bankAccounts[i].simpleString());
                                pr.println();
                            }
                            pr.close();
                        }catch(FileNotFoundException exception){
                            System.out.println("Cannot write to " + file);
                        }
                        break;
                }
            }catch(Exception exception){
                System.out.println("Hold on there buddy: " + exception.getMessage());
                scnr.nextLine();
            }
        }while(choice != 6);
        scnr.close();
    }

    /**
     * printBankAccounts prints list of bank accounts in a certain count number of indicies
     */
    public static void printBankAccounts(BankAccount[] list, int count){
        for(int i = 0; i < count; i++){
            System.out.println(list[i]);
        }
    }
    /**
     * findBankAccount compares the account number of a bankaccount to user input to check validity 
     * @param list for list of accounts
     * @param count for number of indicies to pass through
     * @param number for account number
     * @return 0 if the bankaccount is true else -1
     */
    public static int findBankAccount(BankAccount[] list, int count, long number){
        int reVal = -1;
        for(int i = 0; i < count; i++){
            if(Long.compare(list[i].getNumber(), number) == 0){
                reVal = 0;
            }
        }
        return reVal;
    }
    /**
     * Sorts the bankaccount list for list in by number in bankaccount
     * @param list for account lists
     * @param count for indicies
     */
    public static void sortBankAccounts(BankAccount[] list, int count){
        
        for (int i=1; i<count; i++) {
            //Insert element i in the sorted sub-list
            BankAccount currentVal = list[i];
            int j = i;
            while (j>0 && ((BankAccount)currentVal).getNumber()<((BankAccount)list[j - 1]).getNumber()){
                 // Shift element (j-1) into element (j)
                 list[j] = list[j - 1];
                 j--;
            }
            // Insert currentVal at position j
            list[j] = currentVal;
         }
    }
    /**
     * Checks if account number is valid digits
     * @param number for long number to check
     * @return true if works
     * @throws InvalidAccountNumberException if digits are not 10 long
     */
    public static boolean checkAccountNumber(long number)
        throws InvalidAccountNumberException{
            if((number / 1000000000) >= 1  && (number / 1000000000) < 10){//10 digit integers /1000000000 are 1 <= x < 10
                return true;
            }
            throw new InvalidAccountNumberException("Account numbers MUST be 10 digits long");
        }
}
