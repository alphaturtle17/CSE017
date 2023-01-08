/**
 * @author Thor Long
 * Date: 11/17/2022
 * CSE 017
 * Compares number of searches required for linkedlist bst and hash map
 */
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Test{
    /*
     * ANALYSIS OF RESULTS FOR SEARCHING ITERATIONS
     * We see that the number of iterations vary greatly from linkedlist, to binary search tree, then to hash map.
     * It required much more iterations to do the linked list, then bst, and finally the hash map required the least amount of seraches.
     * This definitely shows the efficiency to use a hashmap and is therefore probably the best general one.                    
     */
    public static void main(String[] args){
        HashMap<String, String> dictionaryHM = new HashMap<>(50000);
        BST<String> dictionaryBST = new BST<>();
        LinkedList<String> dictionaryLL = new LinkedList<>();
        ArrayList<HashMapEntry<String,String>> words = new ArrayList<>();
        readFile(words, "dictionary.txt");
        java.util.Collections.shuffle(words);
        addWords(words, dictionaryHM, dictionaryBST, dictionaryLL);
        testSearch(words, dictionaryHM, dictionaryBST, dictionaryLL);
        System.out.println("Max hashmap collisions: " + dictionaryHM.collisions());
    }
    /**
     * Tests the search method, prints out values and iterations, then average iterations 
     * @param ar for arraylist of items to search for
     * @param hm for hashmap
     * @param bst for binarysearchtree
     * @param ll for linkedlist
     */
    public static void testSearch(ArrayList<HashMapEntry<String,String>> ar, HashMap<String,String> hm, BST<String> bst, LinkedList<String> ll){ 
        int totalHM = 0, totalBST = 0, totalLL = 0;
        for(int i = 0; i < 1000; i++){
            int random = (int) (Math.random() * ar.size());
            HashMapEntry<String,String> value = ar.get(random);
            HashMap.getIterations = 0;
            hm.get(value.getKey());
            int hmIter = HashMap.getIterations;
            int bstIter = bst.contains(value.getKey());
            int llIter = ll.contains(value.getKey());
            
            totalHM += hmIter;
            totalBST += bstIter;
            totalLL += llIter;

            if(i % 50 == 0){
                System.out.printf("%-30s\t%-10d\t%-10d\t%-10d\n", value.getKey(), llIter, bstIter, hmIter);
            }
        }
        System.out.printf("%-30s\t%-10d\t%-10d\t%-10d\n", "Average iterations", totalLL/1000, totalBST/1000, totalHM/1000);
    }
    /**
     * Tests the add method
     * @param ar for arraylist of items to add from
     * @param hm for hashmap
     * @param bst for binarysearchtree
     * @param ll for linkedlist
     */
    public static void addWords(ArrayList<HashMapEntry<String,String>> ar, HashMap<String,String> hm, BST<String> bst, LinkedList<String> ll){
        for(int i = 0; i < ar.size(); i++){
            HashMapEntry<String,String> entry = ar.get(i);
            hm.put(entry.getKey(), entry.getValue());
            bst.add(entry.getKey());
            ll.add(entry.getKey());
        }
    }
    /**
     * Reads the file and adds it to a ArrayList<HashMapEntry<String,String>>
     * @param list for ArrayList<HashMapEntry<String,String>> for list to add items to 
     * @param filename for name of file
     */
    public static void readFile(ArrayList<HashMapEntry<String,String>> list, String filename){
        try{
            File file = new File(filename);
            Scanner scnr = new Scanner(file);
            while(scnr.hasNextLine()){
                String input = scnr.nextLine();
                String[] lines = input.split("\\|");
                list.add(new HashMapEntry<String,String>(lines[0], lines[1]));
            }
            scnr.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found");
            System.exit(0);
        }
    }
}