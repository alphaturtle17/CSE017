/**
 * @author Thor Long
 * Date: 9/9/2022
 * CSE 017
 * InvalidAccountNumberException is a InputMismatchException to catch if the account number is wrong
 */
import java.util.InputMismatchException;
public class InvalidAccountNumberException extends InputMismatchException{
    InvalidAccountNumberException(){
        super("Invalid Account Number");
    }
    InvalidAccountNumberException(String message){
        super(message);
    }
}
