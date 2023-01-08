/**
 * @author Thor Long
 * Date: 11/3/22
 * CSE 017
 * Comparator by first looks at the first object in a pair of objects and returns what comes before and after.
 */
import java.util.Comparator;
public class ComparatorByFirst<E1 extends Comparable<E1>, E2,E3,E4> implements Comparator<Tuple<E1,E2,E3,E4>>{
    /**
     * Method to compare the first object in each pair with each other
     * @param pair1 for first pair
     * @param pair2 for second pair
     * @return -1, 0, or 1 if object is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compare(Tuple<E1, E2, E3, E4> o1, Tuple<E1, E2, E3, E4> o2) {
        E1 first1 = o1.getFirst();
        E1 first2 = o2.getFirst();
        return first1.compareTo(first2);
    }
}
