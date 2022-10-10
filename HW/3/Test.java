/**
 * @author Thor Long
 * 10/10/2022
 * CSE 017
 * Sudoku board main method 
 */
public class Test{
    public static void main(String[]args){
        Board puzzle = new Board("sudoku.txt");
        long nano_startTime = 0;
        long nano_endTime = 0;
	    System.out.println(puzzle);
        try{
            nano_startTime = System.nanoTime();
            puzzle.solve();
            nano_endTime = System.nanoTime();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Solved!");
	    System.out.println(puzzle);
        double seconds = (double) (nano_endTime - nano_startTime) / 1000000000;
        System.out.println("Time elapsed: " +  seconds + " seconds");
    }
}


