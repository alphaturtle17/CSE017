/**
 * @author Thor Long
 * Date 11/24/2022
 * CSE 017
 * Implements a way to sort and compare strings 
 */
import java.util.Comparator;
public class StringComparator implements Comparator<String>{
    @Override
    public int compare(String o1, String o2) {
        String[] first = o1.split("\\@");
        String[] second = o2.split("\\@");
        if(first[0].compareTo(second[0]) > 0){
            return 1;
        }else if(first[0].compareTo(second[0]) < 0){
            return -1;
        }else{
            return 0;
        }
    }
}
