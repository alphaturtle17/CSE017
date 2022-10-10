/**
 * @author Thor Long
 * Date: 9/25/2022
 * CSE 017
 * Defines a pair of generic objects with methods comparing and looking at them
 */
public class Pair<E1, E2>{
    private E1 first;
    private E2 second;

    /**
     * Constructor with two parameters
     * @param first for first object
     * @param second for second object
     */
    public Pair(E1 first, E2 second){
        this.first = first;
        this.second = second;
    }
    /**
     * Getter method for first object
     * @return object first
     */
    public E1 getFirst(){
        return first;
    }
    /**
     * Getter method for second object
     * @return object second
     */
    public E2 getSecond(){
        return second;
    }
    /**
     * Setter method for first object
     * @param first for setting object equal to it
     */
    public void setFirst(E1 first){
        this.first = first;
    }
    /**
     * Setter method for second object 
     * @param second for setting object equal to it
     */
    public void setSecond(E2 second){
        this.second = second;
    }
    /**
     * Method to see if pair of objects are the same.
     * @param Object obj for object
     * @return true if equal, false if not
     */
    public boolean equals(Object obj){
        if(obj instanceof Pair){
            Pair<E1,E2> p = (Pair<E1,E2>) obj;
            boolean firstEq = this.first.equals(p.first);
            boolean secondEq = this.second.equals(p.second);
            return firstEq && secondEq;
        }
        return false;
    }
    /**
     * Format toString override
     */
    public String toString(){
        return "(" + first + ", " + second + ")"; 
    }
}
