/**
 * @author Thor Long
 * Date: 9/25/2022
 * CSE 017
 * Comparator by second looks at the second object in a pair of objects and returns what comes before and after.
 */
import java.util.Comparator;
public class ComparatorBySecond<E1,E2 extends Comparable<E2>> implements Comparator<Pair<E1,E2>>{
    /**
     * Method to compare the second object in each pair with each other
     * @param pair1 for first pair
     * @param pair2 for second pair
     * @return -1, 0, or 1 if object is less than, equal to, or greater than the specified object.
     */
    public int compare(Pair<E1,E2> pair1, Pair<E1,E2> pair2){
        E2 second1 = pair1.getSecond();
        E2 second2 = pair2.getSecond();
        return second1.compareTo(second2);
    }
}
