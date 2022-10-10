/**
 * @author Thor Long
 * Date: 9/25/2022
 * CSE 017
 * Comparator by first looks at the first object in a pair of objects and returns what comes before and after.
 */
import java.util.Comparator;
public class ComparatorByFirst<E1 extends Comparable<E1>, E2> implements Comparator<Pair<E1,E2>>{
    /**
     * Method to compare the first object in each pair with each other
     * @param pair1 for first pair
     * @param pair2 for second pair
     * @return -1, 0, or 1 if object is less than, equal to, or greater than the specified object.
     */
    public int compare(Pair<E1,E2> pair1, Pair<E1,E2> pair2){
        E1 first1 = pair1.getFirst();
        E1 first2 = pair2.getFirst();
        return first1.compareTo(first2);
    }
}
