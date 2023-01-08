/**
 * @author Thor Long
 * Date: 10/26/2022
 * CSE017
 * Heap implimentation 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class AnimalTree {
    public static void main(String[] args){
        BST<String> animalBST = new BST<>();
        Heap<String> animalHeap = new Heap<>();
        ArrayList<String> animalAL = new ArrayList<>();

        System.out.println("Testing add");
        readFile("animals.txt", animalAL, animalBST, animalHeap);
        System.out.println("Testing contains");
        testContains(animalAL, animalBST, animalHeap);
        System.out.println("Testing remove");
        testRemove(animalAL, animalBST, animalHeap);

        System.out.println("BST Height" + animalBST.height());
        System.out.println("Heap Height" + animalHeap.height());

        System.out.println("Is BST Balanced: " + animalBST.isBalanced());
        System.out.println("Is Heap Balanced: " + animalHeap.isBalanced());

        animalBST.clear();
        animalHeap.clear();
        java.util.Collections.sort(animalAL);
        
        for(int i = 0; i < animalAL.size(); i++){
            String animal = animalAL.get(i);
            animalBST.add(animal);
            animalHeap.add(animal);
        }

        System.out.println("BST Height" + animalBST.height());
        System.out.println("Heap Height" + animalHeap.height());

        System.out.println("Is BST Balanced: " + animalBST.isBalanced());
        System.out.println("Is Heap Balanced: " + animalHeap.isBalanced());
    }    
    /**
     * read files reads the file from 
     * @param filename for name of file
     * @param al for arraylist 
     * @param bst for name of bst
     * @param heap for name of heap
     */
    public static void readFile(String filename, ArrayList<String> al, BST<String> bst, Heap<String> heap){
        try{
            File file = new File(filename);
            Scanner rf = new Scanner(file);
            int bstIter = 0;
            int heapIter = 0;
            int index = 0;
            while(rf.hasNext()){
                String animal = rf.nextLine();
                int bstCurr = bst.add(animal);
                int heapCurr = heap.add(animal);
                al.add(animal);

                if(index % 24 == 0){
                    bstIter += bstCurr;
                    heapIter += heapCurr;
                    System.out.printf("%-30s\t%-10d\t%-10d\n", animal, bstCurr, heapCurr);
                }
                index++;
            }
            System.out.printf("%-30s\t%-10d\t%-10d\n", "Average", (bstIter/al.size()), (heapIter/al.size()));
            rf.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }
    }
    /**
     * testing if contains
     * @param al fr arraylist
     * @param bst for binary search tree
     * @param heap for name of heap
     */
    public static void testContains(ArrayList<String> al, BST<String> bst, Heap<String> heap){
        int bstIter = 0;
        int heapIter = 0;
        for(int i = 0; i < 20; i++){
            int random = (int)(Math.random() * al.size());
            String animal = al.get(random);
            int bstCurr = bst.contains(animal);
            int heapCurr = heap.contains(animal);
            bstIter += bstCurr;
            heapIter += heapCurr;
            System.out.printf("%-30s\t%-10d\t%-10d\n", animal, bstCurr, heapCurr);
        }
        System.out.printf("%-30s\t%-10d\t%-10d\n", "Average", (bstIter/20), (heapIter/20));
    }
    /**
     * testing remove from data structures
     * @param al for array list
     * @param bst for binary search tree
     * @param heap for heap
     */
    public static void testRemove(ArrayList<String> al, BST<String> bst, Heap<String> heap){
        int bstIter = 0;
        int heapIter = 0;
        for(int i = 0; i < 20; i++){
            int random = (int)(Math.random() * al.size());
            String animal = al.get(random);
            int bstCurr = bst.remove(animal);
            int heapCurr = heap.remove();
            bstIter += bstCurr;
            heapIter += heapCurr;
            System.out.printf("%-30s\t%-10d\t%-10d\n", animal, bstCurr, heapCurr);
        }
        System.out.printf("%-30s\t%-10d\t%-10d\n", "Average", (bstIter/20), (heapIter/20));
    }
}
