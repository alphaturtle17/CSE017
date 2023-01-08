/**
 * @author Thor Long
 * Date: 11/24/2022
 * CSE 017
 * Testing QP and SC hashmaps as well as tree map
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        HashMapQP<String,String> qp = new HashMapQP<>(100000);
        HashMapSC<String,String> sc = new HashMapSC<>(100000);
        TreeMap<String,String> tm = new TreeMap<>(new StringComparator());
        readFile("emails.txt", qp, sc, tm);
        System.out.println("Testing get()");
        searching("mailinglist.txt", qp, sc, tm);


        System.out.println("\nTesting put(), number of collisions");
        System.out.printf("%-20s\t%-10s\t%-10s\n", "Size", "HashMap QP", "HashMap SC");
        HashMapQP<String,String> qp5 = new HashMapQP<>(50000);
        HashMapSC<String,String> sc5 = new HashMapSC<>(50000);
        putting("emails.txt", qp5, sc5);
        HashMapQP<String,String> qp10 = new HashMapQP<>(50000*2);
        HashMapSC<String,String> sc10 = new HashMapSC<>(50000*2);
        putting("emails.txt", qp10, sc10);
        HashMapQP<String,String> qp15 = new HashMapQP<>(50000*3);
        HashMapSC<String,String> sc15 = new HashMapSC<>(50000*3);
        putting("emails.txt", qp15, sc15);
        HashMapQP<String,String> qp20 = new HashMapQP<>(50000*4);
        HashMapSC<String,String> sc20 = new HashMapSC<>(50000*4);
        putting("emails.txt", qp20, sc20);
        HashMapQP<String,String> qp25 = new HashMapQP<>(50000*5);
        HashMapSC<String,String> sc25 = new HashMapSC<>(50000*5);
        putting("emails.txt", qp25, sc25);
        HashMapQP<String,String> qp30 = new HashMapQP<>(50000*6);
        HashMapSC<String,String> sc30 = new HashMapSC<>(50000*6);
        putting("emails.txt", qp30, sc30);
        HashMapQP<String,String> qp35 = new HashMapQP<>(50000*7);
        HashMapSC<String,String> sc35 = new HashMapSC<>(50000*7);
        putting("emails.txt", qp35, sc35);
        HashMapQP<String,String> qp40 = new HashMapQP<>(50000*8);
        HashMapSC<String,String> sc40 = new HashMapSC<>(50000*8);
        putting("emails.txt", qp40, sc40);
        HashMapQP<String,String> qp45 = new HashMapQP<>(50000*9);
        HashMapSC<String,String> sc45 = new HashMapSC<>(50000*9);
        putting("emails.txt", qp45, sc45);
        HashMapQP<String,String> qp50 = new HashMapQP<>(50000*10);
        HashMapSC<String,String> sc50 = new HashMapSC<>(50000*10);
        putting("emails.txt", qp50, sc50);

    }
    /**
     * Tests the put command on each hashmap
     * @param filename for name of file
     * @param hmQp for hash map with quadratic probing 
     * @param hmSc for hash map with separate chaining
     */
    public static void putting(String filename, HashMapQP<String,String> hmQp, HashMapSC<String,String> hmSc){
        try{
            File file = new File(filename);
            Scanner rf = new Scanner(file);
            while(rf.hasNextLine()){
                String line = rf.nextLine();
                String[] strings = line.split("\\ ");
                hmQp.put(strings[0], strings[1]);
                hmSc.put(strings[0], strings[1]);
            }
            System.out.printf("%-20d\t%-30d\t%-30d\n",hmQp.capacity2,hmQp.collisions,hmSc.collisions);
            rf.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found");
            System.exit(0);
        }
    }
    /**
     * Tests the get method in all the hashmaps and treemaps
     * HashMapQP shows very little iterations along with hashmapSC, all being much less iterations than TreeMap
     * therefore TreeMap is the most inefficient of the other get methods because it iterates more times.
     * @param filename for name of file
     * @param hmQp for hashmap with quantum p
     * @param hmSc for hashmap with sc
     * @param tree for treemap
     */
    public static void searching(String filename, HashMapQP<String,String> hmQp, HashMapSC<String,String> hmSc, TreeMap<String,String> tree){
        try{
            System.out.printf("%-20s\t%-10s\t%-10s\t%-10s\n", "Username", "HashMap QP", "HashMap SC", "TreeMap");
            int qpIter = 0;
            int scIter = 0;
            int treeIter = 0;

            int filesize = 0;
            File file = new File(filename);

            Scanner readCounter = new Scanner(file);
            Scanner rf = new Scanner(file);
            while(readCounter.hasNext()){
                filesize++;
                readCounter.nextLine();
            }
            readCounter.close();
            for(int i = 1; i <= 100; i++){
                int random = (int) Math.random() * filesize;
                int count = 0;
                if((i % 5) == 0){
                    while(rf.hasNextLine()){
                        if(count == random){
                            String line = rf.nextLine();
                            String[] strings = line.split("\\ ");
                            qpIter = hmQp.get(strings[0]);
                            scIter = hmSc.get(strings[0]);
                            treeIter = tree.get(strings[0]);
                            System.out.printf("%-20s\t%-10d\t%-10d\t%-10d\n",strings[0],qpIter,scIter,treeIter);
                            break;
                        } else{
                            count++;
                            rf.nextLine();
                        }
                    }
                }
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found");
            System.exit(0);
        }
    }
    /**
     * Reads each file and adds it to the respected data structure
     * @param filename for name of file
     * @param hmQp for hash map quad probing
     * @param hmSc for hash map separate chainging
     * @param tree for tree map
     */
    public static void readFile(String filename, HashMapQP<String,String> hmQp, HashMapSC<String,String> hmSc, TreeMap<String,String> tree){
        try{
            File file = new File(filename);
            Scanner rf = new Scanner(file);
            while(rf.hasNextLine()){
                String[] strings = rf.nextLine().split("\\ ");
                hmQp.put(strings[0], strings[1]);
                hmSc.put(strings[0], strings[1]);
                tree.add(strings[0], strings[1]);
                rf.nextLine();
            }
            rf.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found");
            System.exit(0);
        }
    }
}
