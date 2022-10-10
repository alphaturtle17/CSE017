/**
 * @author Thor Long
 * 10/10/2022
 * CSE 017
 * Sudoku board solver from file
 */
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class Board {
    private ArrayList<ArrayList<Integer>> board;
    private ArrayList<Integer> avaliableNumbers;
    private final int EMPTY = 0;
    /**
     * Constructor initializing the sudoku board and array of numbers
     * @param filename for name of file
     */
    Board(String filename){
        board = new ArrayList<>(9); //set board to carry 9 columns
        avaliableNumbers = new ArrayList<Integer>(9);
        for(int i = 0; i < 9; i++){
            board.add(new ArrayList<>(9)); //Set 9 columns add arraylist to it
            for(int j = 0; j < 9; j++){
                board.get(i).add(EMPTY); //probably right
            }
        }
        for(int i = 0; i < 9; i++){
            avaliableNumbers.add(9);
        }
        readBoard(filename);
    }
    /**
     * Reads sudoku board from file filename and assigns the values to the 2D arraylist board
     * @param filename for name of file
     * @throws IllegalArgumentException if argument is invalid
     */
    private void readBoard(String filename)
        throws IllegalArgumentException{
            int counter = 0;
            File file = new File(filename);
            try { //Count all of the lines
                Scanner rf = new Scanner(file); //Scanner passing in file to read
                while (rf.hasNextLine()) {
                    rf.nextLine();
                    counter++;
                }
                rf.close();
            } catch (FileNotFoundException exception) {
                System.out.println(exception.getMessage());
            }
            try{
                Scanner rf = new Scanner(file);
                for(int i = 0; i < counter; i++){ //index 1
                    String s = rf.nextLine();
                    String[] attributes = s.split("\\ ");
                    for(int j = 0; j < attributes.length; j++){
                        int number = Integer.valueOf(attributes[j]);
                        board.get(i).set(j, number);
                        if(number != EMPTY){
                            if(isAvaliable(number) && checkMove(i, j)){
                                avaliableNumbers.set(number-1, avaliableNumbers.get(number-1)-1);
                            }else{
                                rf.close();
                                throw new IllegalArgumentException("Failed at row: " + i + ", col: " + j);
                            }
                        }
                    }
                }
                rf.close();
            }catch(FileNotFoundException exception){
                System.out.println(exception.getMessage());
            }
        }
    /**
     * Checks if digit is avaliable to be placed down on the sudoku board
     * @param digit for input digit
     * @return t/f based on avaliability
     */
    private boolean isAvaliable(int digit){
        if(digit > 0 && digit < 10){
            if(avaliableNumbers.get(digit-1) > 0){
                return true;
            }else{
                return false;
            }
        }else{
            System.out.println("Not Avaliable");
            return false;
        }
    }
    /**
     * Sees if no numbers are avaliable to be placed
     * @return t/f for if numbers can be still placed
     */
    private boolean noNumbersLeft(){
        int count = 0;
        for(int i = 0; i < 9; i++){
            if(avaliableNumbers.get(i) == EMPTY){
                //do nothing hooray
            }else{
                count++;
            }
        }
        if(count == 0){
            return true;
        }else{
            return false;
        }
    }
    /**
     * No problem here, just a method that checks to see if sudoku parameters are met
     * @param row for index of row in board
     * @param col for index of col in board
     * @return true or false, if good move or not
     */
    private boolean checkMove(int row, int col){
        boolean uniqueColumn = true;
        boolean uniqueRow = true;
        boolean uniqueBlock = true;
        int number = board.get(row).get(col);

        for(int i = 0; i < 9; i++){
            if(board.get(row).get(i) == number && col != i){
                uniqueRow = false;
            }
        }
        for(int i = 0; i < 9; i++){
            if(board.get(i).get(col) == number && row != i){
                uniqueColumn = false;
            }
        }
        int boxRow = row - row % 3;
        int boxCol = col - col % 3;
        for(int i = boxRow; i < boxRow + 3; i++){
            for(int j = boxCol; j < boxCol + 3; j++){
                if(board.get(i).get(j) == number && i != row && j != col){
                    uniqueBlock = false;
                }
            }
        }
        
        if(uniqueColumn && uniqueRow && uniqueBlock){
            return true;
        }else{
            return false;
        }
    }
    /**
     * Solves a sudoku puzzle
     * @return t/f
     */
    public boolean solve(){
        return solve(0,0);
    }
    /**
     * Helper method for solve(), has the logic for solving a sudoku board
     * @param row for row index
     * @param col for column index
     * @return t/f
     */
    public boolean solve(int row, int col){
        if(noNumbersLeft() || row == 9){
            return true;
        }
        if(col == 9){
            return solve(row + 1, 0);
        }
        if(board.get(row).get(col) != EMPTY){
            return solve(row, col+1);
        }
        if(board.get(row).get(col) == EMPTY){
            for(int i = 1; i < 10; i++){
                if(isAvaliable(i)){
                    board.get(row).set(col, i);
                    if(checkMove(row, col)){
                        avaliableNumbers.set(i-1, avaliableNumbers.get(i-1)-1);
                        if(solve(row, col)){
                            return true;
                        }else{
                            avaliableNumbers.set(i-1, avaliableNumbers.get(i-1)+1);
                        }
                    }else{
                        avaliableNumbers.set(i-1, avaliableNumbers.get(i-1)+1);
                    }
                }
            }
            board.get(row).set(col, 0);
            return false;
        }
        return false;
    }
    /**
     * Overwrites toString method from Object class
     * @return String s, formatted sudoku board
     */
    @Override
    public String toString(){
        String s = "";
        for(int i = 0; i < board.size(); i++){
            for(int j = 0; j < board.get(i).size(); j++){
                s += board.get(i).get(j);
                s += " ";
            }
            s += "\n";
        }
        return s;
    }
}
