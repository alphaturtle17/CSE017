/**
 * @author Thor Long
 * Date: 9/7/22
 * CSE 017
 * InvalidSeatException is a user made exception used if there is a wrong seat number in the Airplane/SeatReservation classes
 */
public class InvalidSeatException extends Exception{
    /**
     * Constructor overrides the getMessage exception class and makes the return message invalid seat number
     */
    public InvalidSeatException(){
        super("Invalid Seat Number");
    }
    /**
     * Constructor overrides the getMessage exception class and makes the return message invalid seat number
     * @param message for custom message
     */
    public InvalidSeatException(String message){
        super(message);
        
    }
}
