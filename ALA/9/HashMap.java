/**
 * @author Thor Long
 * Date: 11/17/2022
 * CSE 017
 * Implementation of a HashMap
 */
import java.util.ArrayList;
import java.util.LinkedList;

public class HashMap<K, V> {
    private int size;
    private double loadFactor;
    private LinkedList<HashMapEntry<K, V>>[] hashTable;
    public static int getIterations = 0;
    // Constructors
    public HashMap() {
        this(100, 0.9);
    }

    public HashMap(int c) {
        this(c, 0.9);
    }
    /**
     * Constructor with 2 parameters
     * @param c for count
     * @param lf for load factor
     */
    public HashMap(int c, double lf) {
        hashTable = new LinkedList[trimToPowerOf2(c)];
        loadFactor = lf;
        size = 0;
    }

    // private methods
    private int trimToPowerOf2(int c) {
        int capacity = 1;
        while (capacity < c)
            capacity = capacity << 1; // * 2
        return capacity;
    }
    /**
     * Hashes input
     * @param hashCode for what
     * @return int index
     */
    private int hash(int hashCode) {
        return hashCode & (hashTable.length - 1);
    }
    /**
     * Hashes again
     */
    private void rehash() {
		ArrayList<HashMapEntry<K,V>> list = toList();
		hashTable = new LinkedList[hashTable.length << 1];
		size = 0;
		for(HashMapEntry<K,V> entry: list) 
			put(entry.getKey(), entry.getValue());
	}
    /**
     * Returns size
     * @return size
     */
    public int size() {
        return size;
    }
    /**
     * Clears hashmap
     */
    public void clear() {
        size = 0;
        for (int i = 0; i < hashTable.length; i++)
            if (hashTable[i] != null)
                hashTable[i].clear();
    }
    /**
     * Checks if map is empty
     * @return t/f is empty
     */
    public boolean isEmpty() {
        return (size == 0);
    }

    // search for key - returns true if found
    public boolean containsKey(K key) {
        if (get(key) != null)
            return true;
        return false;
    }

    // returns the value of key if found, null otherwise
    public V get(K key) {
        int HTIndex = hash(key.hashCode());
        if (hashTable[HTIndex] != null) {
            LinkedList<HashMapEntry<K, V>> ll = hashTable[HTIndex];
            for (HashMapEntry<K, V> entry : ll) {
                getIterations++;
                if (entry.getKey().equals(key))
                    return entry.getValue();
            }
        }
        return null;
    }


    // remove a key if found
    public void remove(K key) {
        int HTIndex = hash(key.hashCode());
        if (hashTable[HTIndex] != null) { // key is in the hash map
            LinkedList<HashMapEntry<K, V>> ll = hashTable[HTIndex];
            for (HashMapEntry<K, V> entry : ll) {
                if (entry.getKey().equals(key)) {
                    ll.remove(entry);
                    size--;
                    break;
                }
            }
        }
    }

    // adds a new key or modifies an existing key
    public V put(K key, V value) {
        if (get(key) != null) { // The key is in the hash map
            int HTIndex = hash(key.hashCode());
            LinkedList<HashMapEntry<K, V>> ll;
            ll = hashTable[HTIndex];
            for (HashMapEntry<K, V> entry : ll) {
                if (entry.getKey().equals(key)) {
                    V old = entry.getValue();
                    entry.setValue(value);
                    return old;
                }
            }
        } // key not in the hash map - check load factor
        if (size >= hashTable.length * loadFactor)
            rehash();
        int HTIndex = hash(key.hashCode());
        // create a new LL if empty
        if (hashTable[HTIndex] == null) {
            hashTable[HTIndex] = new LinkedList<>();
        }
        hashTable[HTIndex].add(new HashMapEntry<>(key, value));
        size++;
        return value;
    }

    // returns the elements of the hash map as a list
    public ArrayList<HashMapEntry<K,V>> toList() {
        ArrayList<HashMapEntry<K, V>> list = new ArrayList<>();
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] != null) {
                LinkedList<HashMapEntry<K, V>> ll = hashTable[i];
                for (HashMapEntry<K, V> entry : ll)
                    list.add(entry);
            }
        }
        return list;
    }

    // returns the elements of the hash map as a string
    public String toString() {
        String out = "[";
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] != null) {
                for (HashMapEntry<K, V> entry : hashTable[i])
                    out += entry.toString();
                out += "\n";
            }
        }
        out += "]";
        return out;
    }
    /**
     * Returns the largest size of collisions in a hashmap
     * @return int number of collisions
     */
    public int collisions(){
        int max = 0;
        for(LinkedList<HashMapEntry<K,V>> ll: hashTable){
            if(ll != null){
                if(ll.size() > max){
                    max = ll.size();
                }
            }
        }
        return max;
    }
}
