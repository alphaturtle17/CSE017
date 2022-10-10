/**
 * @author Thor Long
 * Date: 9/7/22
 * CSE 017
 * Main method to create a reserved seat using Airplane.java, as well as a menu making it user friendly.
 */
import java.util.InputMismatchException;
import java.util.Scanner;
public class SeatReservation {
    public static void main(String args[]){
        String fName = "seatsmap.txt";
        Airplane plane = new Airplane(fName);
        Scanner scnr = new Scanner(System.in);
        System.out.println(plane); //formatted view of seatMap
        boolean running = true;
        do{
            System.out.println("Select an operation:\n1. Reserve Seat\n2. Free a Seat\n3. Quit");
            try{
                int choice = scnr.nextInt();
                String seatNumber;
                
                switch(choice){
                    case 1://Reserve
                        System.out.println("Enter a seat number: ");
                        seatNumber = scnr.next();
                        if(plane.reserveSeat(seatNumber)){
                            System.out.println(seatNumber + " reserved.");
                            System.out.println(plane);
                        }else{
                            System.out.println("Seat number " + seatNumber + " already reserved.");
                        }
                        break;
                    case 2://Free a Seat
                        System.out.println("Enter a seat number: ");
                        seatNumber = scnr.next();
                        if(plane.freeSeat(seatNumber)){
                            System.out.println(seatNumber + " freed.");
                            System.out.println(plane);
                        }else{
                            System.out.println("Seat number " + seatNumber + " is already freed.");
                        }
                        break;
                    case 3:
                        plane.saveMap(fName);
                        running = false;
                        break;//Qui
                    default:
                        System.out.println("Invalid option");
                }
            }catch(InvalidSeatException exception){
                System.out.println(exception.getMessage());
            }catch(InputMismatchException exception){
                System.out.println("Invalid Input");
                scnr.next();
            }  
        }while(running == true);
    }
}
