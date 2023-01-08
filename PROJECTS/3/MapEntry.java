/**
 * @author Thor Long
 * Date 11/24/2022
 * CSE 017
 * Implements a singular map entry
 */
public class MapEntry<K,V> {
    private K key;
    private V value;
    /**
     * Generic constructor with key and value
     * @param k key
     * @param v value
     */
    MapEntry(K k, V v){
        key = k;
        value = v;
    }
    /**
     * Getter for key
     * @return K key
     */
    public K getKey() {
        return key;
    }
    /**
     * Getter for value
     * @return V value
     */
    public V getValue() {
        return value;
    }
    /**
     * Setter for key
     * @param key for key
     */
    public void setKey(K key) {
        this.key = key;
    }
    /**
     * Setter for value
     * @param value v
     */
    public void setValue(V value) {
        this.value = value;
    }
    /**
     * ToString
     * @return String for mapentry
     */
    @Override
    public String toString() {
        String s = "";
        s += key;
        s += " ";
        s += value;
        return s;
    }
}
