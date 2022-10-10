/**
 * @author Thor Long
 * Date: 9/14/2022
 * CSE 017
 * InvalidAccountNumberException is a InputMismatchException to catch if the account number is wrong
 */
import java.util.InputMismatchException;
public class InvalidAccountNumberException extends InputMismatchException{
    /**
     * Default constructor for InvalidAccountNumberException with default message
     */
    InvalidAccountNumberException(){
        super("Invalid Account Number");
    }
    /**
     * Constructor with one parameter
     * @param message for message to be written out
     */
    InvalidAccountNumberException(String message){
        super(message);
    }
}
