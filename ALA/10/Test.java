/**
 * @author Thor Long
 * Date: 11/30/2022
 * CSE 017
 * Tests the efficiency of 8 different sorting algorithms with a random, sorted, and reversed arraylist
Results:
Sorting Algorithm       Random          Sorted          Reversed
Selection Sort          50014998        50014998        50014998       
Insertion Sort          25125695        9999            24751386       
Bubble Sort             49974865        10000           49983679       
Merge Sort              287231          287231          287231
Quick Sort              169466          50014999        170785
Heap Sort               159516          246819          159714
Bucket Sort             50000           50000           50000
Radix Sort              90084           90084           90084

Looking at these numbers, we can clearly see the more advanced sorting algorithms being much more efficient (Bucket and Radix) across the board than all the other
algorithms. They are consistent in their numbers, meaning they are more versatile with different sets of data, and are therefore generally the best when trying to sort
arraylists. However, we see with the sorted lists, Insertion sort and Bubble sort perform much better, due to the nature of them, so if you knowingly already have
a sorted list these are the algorithms to go for.
 */
import java.util.ArrayList;
public class Test {
    public static void main(String[] args){
        final int SIZE = 10000;
        ArrayList<Integer> randomList = new ArrayList<>();//random list
        for(int i = 0; i < SIZE; i++){
            randomList.add((int)(Math.random()* (SIZE-1)) + 1);
        }
        ArrayList<Integer> sortedList = (ArrayList<Integer>)  (randomList.clone());
        ArrayList<Integer> reversedList = (ArrayList<Integer>)  (randomList.clone());
        java.util.Collections.sort(sortedList);//sorted
        java.util.Collections.sort(reversedList);
        java.util.Collections.reverse(reversedList);//reversed sorted
        System.out.printf("%-20s\t%-15s\t%-15s\t%-15s\n", "Sorting Algorithm", "Random", "Sorted", "Reversed");
        //Selection sort
        Sort.selectionSort(randomList);
        int randomIterations = Sort.iterations[0];
        Sort.selectionSort(sortedList);
        int sortedIterations = Sort.iterations[0];
        Sort.selectionSort(reversedList);
        int reversedIterations = Sort.iterations[0];
        System.out.printf("%-20s\t%-15d\t%-15d\t%-15d\n", "Selection Sort", randomIterations, sortedIterations, reversedIterations);

        //Insertion Sort
        java.util.Collections.shuffle(randomList);
        java.util.Collections.shuffle(reversedList);
        Sort.insertionSort(randomList);
        randomIterations = Sort.iterations[1];
        Sort.insertionSort(sortedList);
        sortedIterations = Sort.iterations[1];
        Sort.insertionSort(reversedList);
        reversedIterations = Sort.iterations[1];
        System.out.printf("%-20s\t%-15d\t%-15d\t%-15d\n", "Insertion Sort", randomIterations, sortedIterations, reversedIterations);
       
        //Bubble Sort
        java.util.Collections.shuffle(randomList);
        java.util.Collections.shuffle(reversedList);
        Sort.bubbleSort(randomList);
        randomIterations = Sort.iterations[2];
        Sort.bubbleSort(sortedList);
        sortedIterations = Sort.iterations[2];
        Sort.bubbleSort(reversedList);
        reversedIterations = Sort.iterations[2];
        System.out.printf("%-20s\t%-15d\t%-15d\t%-15d\n", "Bubble Sort", randomIterations, sortedIterations, reversedIterations);
       
        //Merge Sort
        java.util.Collections.shuffle(randomList);
        java.util.Collections.shuffle(reversedList);
        Sort.iterations[3] = 0;
        Sort.mergeSort(randomList);
        randomIterations = Sort.iterations[3];
        Sort.iterations[3] = 0;
        Sort.mergeSort(sortedList);
        sortedIterations = Sort.iterations[3];
        Sort.iterations[3] = 0;
        Sort.mergeSort(reversedList);
        reversedIterations = Sort.iterations[3];
        System.out.printf("%-20s\t%-15d\t%-15d\t%-15d\n", "Merge Sort", randomIterations, sortedIterations, reversedIterations);
        
        //Quick Sort
        java.util.Collections.shuffle(randomList);
        java.util.Collections.shuffle(reversedList);
        Sort.quickSort(randomList);
        randomIterations = Sort.iterations[4];
        Sort.quickSort(sortedList);
        sortedIterations = Sort.iterations[4];
        Sort.quickSort(reversedList);
        reversedIterations = Sort.iterations[4];
        System.out.printf("%-20s\t%-15d\t%-15d\t%-15d\n", "Quick Sort", randomIterations, sortedIterations, reversedIterations);
        
        //Heap Sort
        java.util.Collections.shuffle(randomList);
        java.util.Collections.shuffle(reversedList);
        Sort.heapSort(randomList);
        randomIterations = Sort.iterations[5];
        Sort.heapSort(sortedList);
        sortedIterations = Sort.iterations[5];
        Sort.heapSort(reversedList);
        reversedIterations = Sort.iterations[5];
        System.out.printf("%-20s\t%-15d\t%-15d\t%-15d\n", "Heap Sort", randomIterations, sortedIterations, reversedIterations);

        //Bucket Sort
        java.util.Collections.shuffle(randomList);
        java.util.Collections.shuffle(reversedList);
        Sort.bucketSort(randomList);
        randomIterations = Sort.iterations[6];
        Sort.bucketSort(sortedList);
        sortedIterations = Sort.iterations[6];
        Sort.bucketSort(reversedList);
        reversedIterations = Sort.iterations[6];
        System.out.printf("%-20s\t%-15d\t%-15d\t%-15d\n", "Bucket Sort", randomIterations, sortedIterations, reversedIterations);
        
        //Radix Sort
        java.util.Collections.shuffle(randomList);
        java.util.Collections.shuffle(reversedList);
        Sort.radixSort(randomList);
        randomIterations = Sort.iterations[7];
        Sort.radixSort(sortedList);
        sortedIterations = Sort.iterations[7];
        Sort.radixSort(reversedList);
        reversedIterations = Sort.iterations[7];
        System.out.printf("%-20s\t%-15d\t%-15d\t%-15d\n", "Radix Sort", randomIterations, sortedIterations, reversedIterations);
        
    }
}
