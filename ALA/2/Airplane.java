/**
 * @author Thor Long
 * Date: 9/7/22
 * CSE 017
 * Creates an airplane seating chart with '.' and 'X' marking empty and filled seats respectively with methods to manipulate a file containing/saving the plane seats
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;
public class Airplane {
    private char[][] seatMap;
    /**
     * No argument constructor creates a default two dimentional array representing free seats
     */
    public Airplane(){
        seatMap = new char[9][8]; //'X' for occupied seats and '.' for free seats
        for(int i = 0; i < seatMap.length; i++){
            for(int j = 0; j < seatMap[i].length; j++){
                seatMap[i][j] = '.';
            } 
        }
    }
    /**
     * Constructor with one parameter creates a two dimentional array from a prewritten file (or creates a new empty file)
     * @param filename for reading previous airplane seat reservations
     */
    public Airplane(String filename){
        seatMap = new char[9][8];
        readMap(filename);
    } 
    /**
     * Uses the File object to read the file and assign it to the two dimentional array seatMap, catches FileNotFound
     * @param filename for the file name of what is being read and converted to the seating chart
     */
    private void readMap(String filename){
        File file = new File(filename);
        try{
            Scanner readFile = new Scanner(file);
            for(int i = 0; i < seatMap.length; i++){
                for(int j = 0; j < seatMap[i].length; j++){
                    seatMap[i][j] = readFile.next().charAt(0);
                } 
            }
            readFile.close();
        }catch(FileNotFoundException exception){
            for(int i = 0; i < seatMap.length; i++){
                for(int j = 0; j < seatMap[i].length; j++){
                    seatMap[i][j] = '.';
                } 
            }
        }
    }
    /**
     * Checks to see if the seat number is valid syntax (number then capital letter, between 1-9 and A-H)
     * @param seatNumber for user inputted seatNumber
     * @return true if seatNumber is valid input
     * @throws InvalidSeatException if seatNumber is invalid
     */
    public boolean checkSeatNumber(String seatNumber)
        throws InvalidSeatException{
            if(seatNumber.matches("[1-9][A-H]")){
                return true;
            }
            throw new InvalidSeatException("Invalid seat number (row[1-9]column[A-H]). Please try again.");
        }
    /**
     * Validates seatNumber using checkSeatNumber and marks an X at the valid position
     * @param seatNumber for user inputted seat number
     * @return true if successful, false if seat is taken
     * @throws InvalidSeatException if seat number is invalid using checkSeatNumber
     */
    public boolean reserveSeat(String seatNumber)
        throws InvalidSeatException{
            if(checkSeatNumber(seatNumber)){
                int row = seatNumber.charAt(0) - '1';
                int col = seatNumber.charAt(1) - 'A';
                if(seatMap[row][col] == '.'){
                    seatMap[row][col] = 'X';
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }
    /**
     * Validates seatNumber, changes any 'X' to '.' indicating a freed seat
     * @param seatNumber for user inputted seat number
     * @return true if seat is freed, false if it was already free
     * @throws InvalidSeatException using checkSeatNumber if input is invalid
     */
    public boolean freeSeat(String seatNumber)
            throws InvalidSeatException{
                if(checkSeatNumber(seatNumber)){
                    int row = seatNumber.charAt(0) - '1';
                    int col = seatNumber.charAt(1) - 'A';
                    if(seatMap[row][col] == 'X'){
                        seatMap[row][col] = '.';
                        return true;
                    }else{
                        return false;
                    }
                }else{
                    return false;  
                }                    
            }
    /**
     * Opens a new file and formats and creates a file named the input
     * @param filename for name of file writing into
     */
    public void saveMap(String filename){
        File file = new File(filename);
        try{
            PrintWriter pr = new PrintWriter(file); //opening file for writing
            for(int i = 0; i < seatMap.length; i++){
                for(int j = 0; j < seatMap[i].length; j++){
                    pr.print(seatMap[i][j] + " "); //using printwriter to print
                }
                pr.println();
            }
            pr.close(); //make sure you close
        }catch(FileNotFoundException exception){
            System.out.println("Cannot write to " + filename);
        }
    }
    /**
     * Formats output for toString method overriding Object class automatically
     * @return String s for future output of plane data
     */
    public String toString(){
        String s = "\tA\tB\tC\tD\tE\tF\tG\tH\n";
        for(int i = 0; i < seatMap.length; i++){
            s += (i + 1) + "\t";
            for(int j = 0; j < seatMap[i].length; j++){
                s += seatMap[i][j] + "\t";
            }
            s += "\n";
        }
        return s;
    }
}


