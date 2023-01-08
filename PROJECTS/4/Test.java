/**
 * @author Thor Long
 * Date: 12/9/2022
 * CSE 017
 * Tests merge sort with multiple different file sizes with different integers
 * 
 * We see that for merge sort the amount of iterations that the algorithm has increases
 * a lot, which makes sense in the context of the O(n) time and space complexity, since the
 * algorithm performance grows linearly and proportionally to the data set. More elements
 * equals more iterations. 
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.IOException;
public class Test{
    public static int iterations = 0;
    public static void main(String[] args) {
        //Testing methods for 100000 integers
        System.out.println("Testing method for 100000 elements: ");
        writeStuff(100000);
        externalMergeSort("100000Data.txt");
        System.out.println("Iterations for 100000 elements: " + iterations);
        iterations = 0;
        //Creating 10 files with different sizes 10000 -> 100000 elements
        for(int i = 10000; i <= 100000; i++){
            if(i % 10000 == 0){
                iterations = 0;
                writeStuff(i);
                externalMergeSort(i + "Data.txt");
                System.out.println("Iterations for " +  i + " elements: " + iterations);
            }
        }
    }
    /**
     * Continually splits the file into smaller and smaller tiny files and sorts them, then deletes temporary files
     * @param filename for name of file to add
     */
    public static void externalMergeSort(String filename) {
        // split the input file into two partially sorted files
        while (!split(filename, "tempfile1", "tempfile2")) {
            // merge the temporary files back into the input file
            merge("tempfile1", "tempfile2", filename);
        }
        File tf1 = new File("tempfile1");
        File tf2 = new File("tempfile2");
        tf1.delete();
        tf2.delete();
    }
    /**
     * Merges the two files file1 and file2 into a singular file filename in sorted order
     * O(n) time and space complexity
     * @param file1 for name of file 1
     * @param file2 for name of file 2
     * @param filename for name of sorted file
     */
    public static void merge(String file1, String file2, String filename) {
        try{
            File file = new File(filename);
            PrintWriter write = new PrintWriter(file);

            File f1 = new File(file1);
            File f2 = new File(file2);

            Scanner rf1 = new Scanner(f1);
            Scanner rf2 = new Scanner(f2);

            String item1 = rf1.nextLine();
            String item2 = rf2.nextLine();

            while(rf1.hasNextLine() && rf2.hasNextLine()){
                if(Integer.parseInt(item1) < Integer.parseInt(item2)){
                    write.println(item1);
                    item1 = rf1.nextLine();
                }else{
                    write.println(item2);
                    item2 = rf2.nextLine();
                }
            }
            while(rf1.hasNextLine()){
                write.println(item1);
                item1 = rf1.nextLine();
            }
            while(rf2.hasNextLine()){
                write.println(item2);
                item2 = rf2.nextLine();
            }   
            rf1.close();
            rf2.close();
            write.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    /**
     * Method splits the file filename into sorted order for merge sort into file1 and file2
     * O(n) time and space complexity
     * @param filename for name of file with data
     * @param file1 for name of the first temp file
     * @param file2 for name of the second temp file
     * @return true if file2 still has more numbers to add
     */
    public static boolean split(String filename, String file1, String file2) {
        // create file object for the input file
        File file = new File(filename);

        // create scanner to read from the input file
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Error: input file not found");
            return false;
        }

        // create print writers to write to the output files
        PrintWriter writeFile1 = null;
        File tempFile1 = new File(file1);
        try {
            writeFile1 = new PrintWriter(tempFile1);
        } catch (IOException e) {
            System.out.println("Error: unable to create first output file");
            sc.close();
            return false;
        }
        PrintWriter writeFile2 = null;
        File tempFile2 = new File(file2);
        try {
            writeFile2 = new PrintWriter(tempFile2);
        } catch (IOException e) {
            System.out.println("Error: unable to create second output file");
            sc.close();
            writeFile1.close();
            return false;
        }

        PrintWriter writeFile = writeFile1;

        String previous = sc.nextLine();
        String current = sc.nextLine();

        writeFile1.println(previous);
        while (sc.hasNextLine()) {
            iterations++;
            if(Integer.parseInt(previous) <= Integer.parseInt(current)){
                writeFile = writeFile1;
                writeFile1.println(current);
            }else{
                writeFile = writeFile2;
                writeFile.println(current);
            }
            previous = current;
            current = sc.nextLine();
        }

        // close the scanner and print writers
        sc.close();
        writeFile.close();
        writeFile1.close();
        writeFile2.close();
        return tempFile2.length() == 0;
    }
    /**
     * Method to write n random integers 0 < x < 10000, used once then deleted
     */
    public static void writeStuff(int n){
        try{
            File file = new File(n + "Data.txt");
            PrintWriter pr = new PrintWriter(file);
            for(int i = 0; i < n; i++){
                pr.println((int)(Math.random() * 10000));
            }
            pr.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }
    }
}