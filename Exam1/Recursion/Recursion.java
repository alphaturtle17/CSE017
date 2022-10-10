/**
 * @author Thor Long
 * Date: 9/15/22
 * CSE 017
 * Scans files for a word in a certain path and directories. Also gets the size of directories in a path
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Recursion{
    public static void main(String args[]){
        Scanner keys = new Scanner(System.in);
        System.out.println("Enter a path: ");
        String path = keys.nextLine();
        System.out.println("Enter a word: ");
        String word = keys.nextLine();
        findWord(path, word);

        System.out.println("Enter another path: ");
        path = keys.nextLine();
        long pathSize = getSize(path);
        String unit = " bytes";
        double size = 0;
        if(pathSize > 1000000000){
            size = pathSize / 1000000000.0;
            unit = " Gbytes";
        }else if(pathSize > 1000000){
            size = pathSize / 1000000.0;
            unit = " Mbytes";
        }else if(pathSize > 1000){
            size = pathSize / 1000.0;
            unit = " Kbytes";
        }else{
            size = pathSize;
        }
        System.out.println("Size of " + path + ": " + size + unit);
        keys.close();
    }
    /**
     * Calculates the size of path in bytes
     * @param path for path of directory
     * @return long size in bytes/kbytes/mbytes/gbytes
     */
    public static long getSize(String path){
        File folder = new File(path);
        long size = 0;
        if(folder.isFile()){
            size = folder.length();

        }else if(folder.isDirectory()){
            File[] contents = folder.listFiles();
            for(int i = 0; i < contents.length; i++){
                if(contents[i].isFile()){
                    size += contents[i].length();
                }else if(contents[i].isDirectory()){
                    size += getSize(contents[i].getAbsolutePath());
                }
            }
        }
        return size;
    }
    /**
     * Finds String word in path of directory and subdirectories
     * @param path for path of directory
     * @param word for word you want to find
     */
    public static void findWord(String path, String word){
        File file = new File(path);
        if(file.exists()){
            if(file.isDirectory()){
                File[] contents = file.listFiles();
                for(int i = 0; i < contents.length; i++){
                    findWord(contents[i].getAbsolutePath(), word);
                }
            }else if(file.isFile()){
                int wordCount = countWords(file, word);
                if(wordCount != 0){
                    System.out.println(word + " appears " + wordCount + " times in the file " + file.getAbsolutePath());
                }
            }
            
        }else{
            System.out.println("Invalid path name");
        }
    }
    /**
     * Iterates through a file's line for a word
     * @param file for file path
     * @param word for word you want to find
     * @return int count of words found in file
     */
    public static int countWords(File file, String word){
        int count = 0;
        try{
            Scanner scnr = new Scanner(file);

            while(scnr.hasNextLine()){
                String line = scnr.nextLine();
                int index = line.indexOf(word, 0);
                while(index != -1){
                    count++;
                    index = line.indexOf(word, index + 1);
                }
            }
            scnr.close();
            return count;
        }catch(FileNotFoundException e){
            return 0;
        }
    }
}