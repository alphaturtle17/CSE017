/**
 * @author Thor Long
 * CSE 017
 * Date: 9/25/2022
 * Generics for sort methods by first and second using states and trees from files.
 */
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Test {
    public static void main(String args[]){
        ArrayList<Pair<String, String>> states = new ArrayList<>(50);
        ArrayList<Pair<String, Integer>> trees = new ArrayList<>(50);
        Scanner scnr = new Scanner(System.in);

        try{
            int choice = 0;
            
            do{
                System.out.println("What do you want to do?");
                System.out.println("1. View States\n2. Search for a state capital\n3. Sort states by name\n4. Sort states by capital\n5. View trees\n6. Search for a tree\n7. Sort trees by name\n8. Sort trees by height\n9. Exit");
                choice = scnr.nextInt();
                switch(choice){
                    case 1:
                        readStatesFromFile(states, "states.txt");
                        print(states);
                        break;
                    case 2:
                        System.out.println("Enter a state name?");
                        String name = scnr.next();
                        int index = search(states, name);
                        if(index == -1){
                            System.out.println("State not found.");
                        }else{
                            System.out.println("State found: " + states.get(index));
                        }
                        break;
                    case 3:
                        states.sort(new ComparatorByFirst<String, String>());
                        print(states);
                        break;
                    case 4:
                        states.sort(new ComparatorBySecond<String, String>());
                        print(states);
                        break;
                    case 5:
                        readTreesFromFile(trees, "trees.txt");
                        print(trees);
                        break;
                    case 6:
                        System.out.println("What tree do you want to search for?");
                        String tree = scnr.next();
                        int treeIndex = search(trees, tree);
                        if(treeIndex == -1){
                            System.out.println("State not found.");
                        }else{
                            System.out.println("State found: " + trees.get(treeIndex));
                        }

                        break;
                    case 7:
                        trees.sort(new ComparatorByFirst<String, Integer>());
                        print(trees);
                        break;
                    case 8:
                        trees.sort(new ComparatorBySecond<String, Integer>());
                        print(trees);
                        break;
                    default:
                        break;
                }
            }while(choice != 9);
            scnr.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }    
    }
    /**
     * Print method to print pair of objects
     * @param <E1> for object 1
     * @param <E2> for object 2
     * @param list for arraylist of objects
     */
    public static <E1,E2> void print(ArrayList<Pair<E1,E2>> list){
        for(Pair<E1,E2> p: list){
            System.out.println(p);
        }
    }
    /**
     * Search method to find a object in the first object of the pair
     * @param <E1> for first object
     * @param <E2> for second object
     * @param list for arraylist of pairs
     * @param key for what you're looking for
     * @return index of key, or -1
     */
    public static <E1,E2> int search(ArrayList<Pair<E1,E2>> list, E1 key){
        for(int i = 0; i < list.size(); i++){ //Size() = how much in it,  length() is capacity
            Pair<E1,E2> p = list.get(i);
            if(p.getFirst().equals(key)){
                return i;
            }
        }
        return -1;
    }
    /**
     * Method to read states from the file
     * @param list for arraylist to put states/capitals in 
     * @param filename for name of file
     */
    public static void readStatesFromFile(ArrayList<Pair<String, String>> list, String filename){
        File f = new File(filename);

        try{
            Scanner fr = new Scanner(f);
            while(fr.hasNextLine()){
                String line = fr.nextLine();
                String[] stuff = line.split("\\|");
                Pair<String, String> p = new Pair<String,String>(stuff[0], stuff[1]);
                list.add(p);
            }
            fr.close();
        }catch(FileNotFoundException e){
            System.out.println("File Not Found");
            System.exit(0);
        }
    }
    /**
     * Method to read trees from file
     * @param list for arraylist where it goes
     * @param filename for name of file
     */
    public static void readTreesFromFile(ArrayList<Pair<String, Integer>> list, String filename){
        File f = new File(filename);

        try{
            Scanner fr = new Scanner(f);
            while(fr.hasNextLine()){
                String line = fr.nextLine();
                String[] stuff = line.split("\\|");
                Pair<String, Integer> tree = new Pair<>(stuff[0],  Integer.valueOf(stuff[1]));
                list.add(tree);
            }
            fr.close();
        }catch(FileNotFoundException e){
            System.out.println("File Not Found");
            System.exit(0);
        }
    }
}
