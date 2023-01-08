/**
 * @author Thor Long
 * Date 11/24/2022
 * CSE 017
 * Implements a hash map with quadratic probing to hopefully cut down on collisions
 */
import java.util.ArrayList;
public class HashMapQP<K, V> {
	public static int iterations;
	public static int collisions;
	private int size;
	private double loadFactor;
	private MapEntry<K, V>[] hashTable;
	private int capacity;
	public int capacity2;
	private int first = 0;
	
   /**
   * Default constructor
   * Creates an empty hash table with capacity 100
   * and default load factor of 0.9
   */
	public HashMapQP() {
		this(100, 0.5);
	}
   /**
   * Constructor with one parameters
   * Creates an empty hash table with capacity c
   * and default load factor of 0.9
   */
	public HashMapQP(int c) {
		this(c, 0.5);
	}
	/**
  	* Constructor with two parameters
   	* Creates an empty hash table with capacity c
   	* and load factor lf
  	 */
	public HashMapQP(int c, double lf) {
		capacity = trimToPowerOf2(c);
		capacity2 = c;
		hashTable = new MapEntry[capacity];
		loadFactor = lf;
		size = 0;
		collisions = 0;
	}

	/**
	 * Private method to find the closest power of 2
	 * to the capacity of the hash table
	 * @param c desired capacity for the hash table
	 * @return  closest power of 2 to c
	 */
	private int trimToPowerOf2(int c) {
		int capacity = 1;
		while (capacity < c)
			capacity = capacity << 1;
		return capacity;
	}
	/**
	 * hash method
	 * @param hashCode
	 * @return valid index in the hash table
	 */
	private int hash(int hashCode) {
		return hashCode & (hashTable.length - 1);
	}
	/**
	 * Rehash method called when the size of the hashtable
	 * reached lf * capacity
	 */
	private void rehash() {
		ArrayList<MapEntry<K,V>> list = toList();
		hashTable = new MapEntry[capacity << 1];
		capacity = capacity << 1;
		size = 0;
		for(MapEntry<K,V> entry: list) {
			if (entry != null) {
				put(entry.getKey(), entry.getValue());
			}
		}
	}
	/**
	 * Method size
	 * @return the number of elements added to the hash table
	 */
	public int size() {
		return size;
	}
	/**
	 * Method clear
	 * resets all the hash table elements to null
	 * and clears all the linked lists attached to the hash table
	 */
	public void clear() {
		size = 0;
		for (int i = 0; i < hashTable.length; i++)
			if (hashTable[i] != null)
				hashTable[i] = null;
	}
	/**
	 * Method isEmpty
	 * @return true if there are no valid data in the hash table
	 */
	public boolean isEmpty() {
		return (size == 0);
	}
	/**
	 * Search method
	 * @param key being searched for
	 * @return true if key is found, false otherwise
	 */
	public boolean containsKey(K key) {
		if (get(key) != 0)
			return true;
		return false;
	}
	/**
	 * Get method
	 * @param key being searched for
	 * @return the value of the hash table entry if the key is found,
	 * null if the key is not found
	 */
	public int get(K key) {
		iterations = 0;
		int HTIndex = hash(key.hashCode()) % capacity;
		if (hashTable[HTIndex] != null) {
			MapEntry<K, V> e = hashTable[HTIndex];
			if (e.getKey().equals(key)) {
				return iterations;
			}
			HTIndex = (HTIndex + 1) % capacity;
			iterations++;
		}
		iterations = 0;
		return 0;
	}
	// remove a key if found
	  public void remove(K key) {
		if (containsKey(key)) {
			int HTIndex = hash(key.hashCode());
			while (!key.equals(hashTable[HTIndex].getKey())) {
				HTIndex = (HTIndex +1) % capacity;
			}
			hashTable[HTIndex] = null;
			HTIndex = (HTIndex + 1) % capacity;
			MapEntry<K, V> e = hashTable[HTIndex];
			while (e != null) {
				K t1 = e.getKey();
				V t2 = e.getValue();
				hashTable[HTIndex] = null;
				size--;
				put(t1, t2);
				HTIndex = (HTIndex + 1) % capacity;
				e = hashTable[HTIndex];
			}
			size--;
		} else {
			return;
		}
	}
	/**
	 * Add a new entry to the hash table
	 * @param key key of the entry to be added
	 * @param value value of the entry to be added
	 * @return the old value of the entry if an entry with the same key is found
	 * the parameter value is returned if a new entry has been added
	 */
	public V put(K key, V value) {
		if (value == null) {
			remove(key);
		}
		int HTIndex = hash(key.hashCode()) % capacity;
		MapEntry<K, V> e = hashTable[HTIndex];
		while (e != null) {
			if (e.getKey().equals(key)) {
				V old = e.getValue();
				e.setValue(value);
				return old;
			} else {
				if (first == 0){
					collisions++;
					first++;
				}
			}
			HTIndex = (HTIndex + 1) % capacity;
			e = hashTable[HTIndex];
		}
		MapEntry<K, V> e2 =  new MapEntry<>(key, value);
		hashTable[HTIndex] = e2;
		size++;
		first = 0;
		if (size >= capacity * loadFactor) {
			rehash();
		}
		return value;
	}

	/**
	 * Method toList used by rehash
	 * @return all the entries in the hash table in an array list
	 */
	public ArrayList<MapEntry<K,V>> toList(){
		ArrayList<MapEntry<K,V>> list = new ArrayList<>(capacity);
		for(MapEntry e : this.hashTable) {
			if (e != null) {
				list.add(e);
			}
		}
		return list;
	}
	/**
	 * toString method
	 * @return the hashtable entries formatted as a string
	 */
	public String toString() {
		String out = "[";
		for(int i=0; i<hashTable.length; i++) {
			if(hashTable[i]!=null) {
				out += hashTable[i].toString();
				out += "\n";
			}
		}
		out += "]";
		return out;
	}
}
