/**
 * @author Thor Long
 * Date: 10/24/2022
 * CSE 017
 * AnimalList uses user made arraylist and linkedlist to see the iterations and such from animals.txt
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class AnimalList {  
    public static void main(String[] args){
        ArrayList<String> animalAL = new ArrayList<>();
        LinkedList<String> animalLL = new LinkedList<>();
        File file = new File("animals.txt");
        try{
            Scanner rf = new Scanner(file);
            while(rf.hasNextLine()){
                String line = rf.nextLine();
                animalAL.add(line);
                animalLL.add(line);
            }
            rf.close();
        }catch(FileNotFoundException exception){
            System.out.println(exception.getMessage());
            System.exit(0);
        }
        testSearch(animalAL, animalLL);
        testRemove(animalAL, animalLL);
        testAdd(animalAL, animalLL);
    }    
    /**
     * Tests search method
     * @param al for arraylist<String>
     * @param ll for linkedList<String>
     */
    public static void testSearch(ArrayList<String> al, LinkedList<String> ll){
        int totalAL = 0;
        int totalLL = 0;
        System.out.println("Comparing the methods that contain an object");
        System.out.printf("%-30s\t%-15s\t%-15s\n", "Animal Name", "Iterations (AL)", "Iterations (LL)");
        for(int i = 0; i < 20; i++){
            int randomIndex = (int) (Math.random() * al.size());
            String randomName = al.get(randomIndex);
            int ALIterations = al.contains(randomName);
            int LLIterations = ll.contains(randomName);
            System.out.printf("%-30s\t%-15d\t%-15d\n", randomName, ALIterations, LLIterations);
            totalAL+= ALIterations;
            totalLL += LLIterations;
        }
        System.out.printf("%-30s\t%-15d\t%-15d\n", "Average", totalAL/20, totalLL/20);
    }
    /**
     * tests remove method with iterations
     * @param al for arraylist 
     * @param ll for linkedlist
     */
    public static void testRemove(ArrayList<String> al, LinkedList<String> ll){
        int totalAL = 0;
        int totalLL = 0;
        System.out.println("Comparing the methods that contain an object");
        System.out.printf("%-30s\t%-15s\t%-15s\n", "Animal Name", "Iterations (AL)", "Iterations (LL)");
        for(int i = 0; i < 20; i++){
            int randomIndex = (int) (Math.random() * al.size());
            String randomName = al.get(randomIndex);
            int ALIterations = al.remove(randomName);
            int LLIterations = ll.remove(randomName);
            System.out.printf("%-30s\t%-15d\t%-15d\n", randomName, ALIterations, LLIterations);
            totalAL+= ALIterations;
            totalLL += LLIterations;
        }
        System.out.printf("%-30s\t%-15d\t%-15d\n", "Average", totalAL/20, totalLL/20);
    }
    /**
     * Tests add method from data structures
     * @param al for arraylist
     * @param ll for linkedlist
     */
    public static void testAdd(ArrayList<String> al, LinkedList<String> ll){
        int totalAL = 0;
        int totalLL = 0;
        System.out.println("Comparing the methods that contain an object");
        System.out.printf("%-30s\t%-15s\t%-15s\n", "Animal Name", "Iterations (AL)", "Iterations (LL)");
        for(int i = 0; i < 20; i++){
            int randomIndex = (int) (Math.random() * al.size());
            String randomName = al.get(randomIndex);
            int ALIterations = al.add(randomIndex, randomName);
            int LLIterations = ll.add(randomIndex, randomName);
            System.out.printf("%-30s\t%-15d\t%-15d\n", randomName, ALIterations, LLIterations);
            totalAL+= ALIterations;
            totalLL += LLIterations;
        }
        System.out.printf("%-30s\t%-15d\t%-15d\n", "Average", totalAL/20, totalLL/20);
    }
}
