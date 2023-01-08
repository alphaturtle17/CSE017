/**
 * @author Thor Long
 * Date: 11/10/2022
 * CSE 017
 * LinkedList class implementation
 */
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ListIterator;
/**
 * Class LinkedList
 * @author Houria Oudghiri
 * Date of creation: October 10, 2021
 * Date of last modification: October 22, 2022
 */
public class LinkedList<E> implements Cloneable, List<E>{
     // Data members
	private Node head, tail;
	int size;
    // Inner class Node
	private class Node{
		E value;
		Node next, previous;
		Node(E initialValue){
			value = initialValue; 
            next = null;
            previous = null;
		}
	}
    // Constructor
	public LinkedList() {
		head = tail = null;
		size = 0;
	}
    /**
     * Adds new node to first element in linkedlist 
     * O(1)
     * @param item for value of node
     * @return true/false if operation succeeds
     */
    // Adding an item to the head of the ist
    public boolean addFirst(E item) { //adding to back of list
		Node newNode = new Node(item);
		if(head == null) {
            head = tail = newNode;
        }
		else { 
            newNode.next = head;
            newNode.previous = null; //redunddant 
            head.previous = newNode;
			head = newNode;
		}
		size++; 
        return true;
    }
    /**
     * Adding an item to the end of the list
     * O(1)
     * @param item for value of item
     * @return true / false if operation works
     */
    public boolean addLast(E item) {
		Node newNode = new Node(item);
		if(head == null) { 
            head = tail = newNode; 
        }
		else { 
            tail.next = newNode;
            newNode.next = null;
            newNode.previous = tail;
            tail = newNode; 

        }
		size++; 
        return true;
    }
    /**
     * Adds item to last
     * O(1)
     * @param E item for value
     * @return t/f if works
     */
    public boolean add(E item) {
		return addLast(item);
    }
    /**
     * Getting the item at the head of the list
     * O(1)
     * @return E element at head
     */
    public E getFirst() {
		if (head == null)
			throw new NoSuchElementException();
		return head.value;
    }
    /**
     * getting the element at the end of the list
     * O(1)
     * @throws NoSuchElementException if notail
     * @return E element at tail
     */
    public E getLast() {
		if (head == null)
			throw new NoSuchElementException();
		return tail.value;
    } 
    /**
     * Removing the item at the head of the list
     * O(1)
     * @throws NoSuchElementException if no head
     * @return true if works
     */
    public boolean removeFirst() {
		if (head == null) 
            throw new NoSuchElementException();
		head = head.next;
        head.previous = null;
		if(head == null)
            tail = null;
		size--; 
        return true;
    }
    /**
     * Removing the item at the end of the list
     * O(logN)
     * @return true/false if works
     */
    public boolean removeLast() {
		if (head == null) 
            throw new NoSuchElementException();
		if(size == 1) 
            return removeFirst();
		Node current = head;
		Node previous = null;
		while(current.next != null) {
            previous = current;
			current = current.next;
		}
		previous.next = null; 
        tail = previous;
		size--; 
        return true;
    } 
    /**
     * toString() method
     * O(LogN)
     * @return toString
     */
    public String toString() {
		String output = "[";
		Node node = head;
		while(node != null) {
			output += node.value + " ";
			node = node.next;
		}
		output += "]";
		return output;
    }
    /**
     * clear, check if empty, and size of the list
     * O(1)
     */
    public void clear() {
        head = tail = null; 
        size = 0; 
    }
    /**
     * returns if list empty
     * O(1)
     * @return t/f if list is empty
     */
    public boolean isEmpty() {
        return (size == 0);
    }
    /**
     * Size of array
     * O(1)
     * @return size
     */
    public int size() {
        return size; 
    } 
    /**
     * Implementing an iterator for the list
     * O(n)
     * @return LinkedListIterator
     */
    public Iterator<E> iterator(){
		  return new LinkedListIterator();
    }
    /**
     * Implementing an iterator for the list
     * O(n)
     * @param index for starting index
     * @return Iterator<E> iterator
     */
    public Iterator<E> iterator(int index){
        return new LinkedListIterator(index);
    }
    // Inner class to implement the interface Iterator
    private class LinkedListIterator implements Iterator<E>{
        private Node current = head;
        private Node previous = null;

        LinkedListIterator(){
            current = head;
        }
        LinkedListIterator(int index){
            for(int i = 0; i < index - 1; i++){
                previous = current;
                current = current.next;
            }
        }
        /**
         * If iterator has next
         * O(1)
         * @return boolean if
         */
        public boolean hasNext() {
        return (current != null);
        }
        /**
         * Returns next value
         * O(1)
         * @return E value
         */
        public E next() {
        if(current == null)
            throw new NoSuchElementException();
        E value = current.value;
        current = current.next;
        return value;
        }
        /**
         * Returns previous value
         * O(1)
         * @return E value
         */
        public E previous(){
            if(current == null)
                throw new NoSuchElementException();
            E value = current.value;
            current = current.previous;
            return value;
        }
        /**
         * If iterator has previous value
         * @return t/f if previous exists
         */
        public boolean hasPrevious(){
            return (previous != null);
        }
        public void add(E value){
            throw new UnsupportedOperationException();
        }
        public void remove(){
            throw new UnsupportedOperationException();
        }
        public void set(E value){
            throw new UnsupportedOperationException();
        }
        public int nextIndex(){
            throw new UnsupportedOperationException();
        }
        public int previousIndex(){
            throw new UnsupportedOperationException();
        }
    }

    /**
     * Clone method (deep copy)
     * O(N)
     * @return Object copy of linked list
     */
    public Object clone(){
        LinkedList<E> copy = new LinkedList<>();
        for(Node node = head; node!=null; node = node.next){
            copy.add(node.value);
        }
        return copy;
    }
    /**
     * Adds new node to index
     * O(logN)
     * @return t/f
     * @param int index for index of node
     * @param E value for value of node
     */
    @Override
    public boolean add(int index, E value) 
        throws ArrayIndexOutOfBoundsException{
        Node current = head;
        Node previous = null;
        int count = 0;
        if(current == null){
            current = new Node(value);
            return true;
        }
        while(current != null && count != index){
            previous = current; 
            current = current.next;
            count++;
        }
        if(count == index){
            Node newNode = new Node(value);
            previous.next = newNode;
            newNode.previous = previous;
            newNode.next = current;
            current.previous = newNode;
            return true;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
    /**
     * Gets the item at index
     * O(logN)
     * @param int index for index of thing
     * @return E value at index
     */
    @Override
    public E get(int index) 
        throws ArrayIndexOutOfBoundsException{
        Node current = head;
        Node previous = null;
        int count = 0;
        while(index != count && current != null){
            previous = current;
            current = current.next;
            count++;
        }
        if(current == null){
            return null;
        }
        if(index == count){
            return current.value;
        }
        return null;
    }
    /**
     * Set value at index
     * O(logN)
     * @param int index for index of value
     * @param E value for value of node
     */
    @Override
    public E set(int index, E value) {
        Node current = head;
        Node previous = null;
        int count = 0;
        while(index != count){
            previous = current;
            current = current.next;
            count++;
        }
        if(index == count){
            Node newNode = new Node(value);
            previous.next = newNode;
            newNode.previous = previous;
            newNode.next = current;
            current.previous = newNode;
            size++;
            return newNode.value;
        }
        return null;
    }
    /**
     * Removes object from linkedlist
     * O(N)
     * @param Object o for type of object
     * @return t/f if works
     */
    @Override
    public boolean remove(Object o) {
        Node current = head;
        Node previous = null;
        while(current != null && !current.value.equals((E)o)){
            previous = current; 
            current = current.next;
        }
        if(current == head){
            removeFirst();
            return true;
        }
        if(current != null){
            previous.next = current.next;
            current.next.previous = previous;
            size--;
            return true;
        }
        return false;
    }
    /**
     * Removes object at index
     * O(N)
     * @param int index
     * @return boolean
     */
    @Override
    public boolean remove(int index) {
        Node current = head;
        Node previous = null;
        int count = 0;
        while(current != null && count != index){
            previous = current; 
            current = current.next;
            count++;
        }
        if(current == null){
            return false;
        }
        previous.next = current.next;
        size--;
        return true;
    }
    /**
     * Checks if it contains the object
     * O(N)
     * @param Object O type object
     * @return t/f if works
     */
    @Override
    public boolean contains(Object o) {
        Node current = head;
        Node previous = null;
        while(current != null &&!current.value.equals((E)o)){
            previous = current; 
            current = current.next;
        }
        if(current != null){
            return true;
        }
        return false;
    }
    /**
     * Checks if all elements in otherList are in linkedlist
     * O(N)
     * @param List<E> otherList for list to check
     * @return boolean t/f if works
     */
    @Override
    public boolean containsAll(List<E> otherList) {
        for(int i = 0; i < otherList.size(); i++){
            if(contains(otherList.get(i)) == false){
                return false;
            }
        }
        return true;
    }
    /**
     * Adds all items from otherList to list
     * O(N)
     * @param List<E> otherList list of items
     * @return boolean t/f if works
     */
    @Override
    public boolean addAll(List<E> otherList) {
        if(otherList.size() == 0){
            return false;
        }
        for(int i = 0; i < otherList.size(); i++){
            addLast(otherList.get(i));
        }
        return true;
    }
    /**
     * Removes all items in otherList from list
     * O(N)
     * @param List<E> otherList
     * @return t/f if works
     */
    @Override
    public boolean removeAll(List<E> otherList) {
        for(int i = 0; i < otherList.size(); i++){
            remove(otherList.get(i));
        }
        return true;
    }
    /**
     * Clears list then adds only items from otherList
     * O(N)
     * @param List<E> otherList
     * @return boolean t/f if operation works
     */
    @Override
    public boolean retainAll(List<E> otherList) {
        clear();
        return addAll(otherList);
    }
    /**
     * Converts LinkedList to array
     * O(N)
     * @return Object[] array of objects
     */
    @Override
    public Object[] toArray() {
        LinkedListIterator iter = new LinkedListIterator();
        Object[] arr = new Object[size];
        for(int i = 0; i < size; i++){
            if(iter.hasNext()){
                arr[i] = iter.current.value;
                iter.next();
            }
        }
        return arr;
      }
    /**
     * Method to return listIterator
     * O(N)
     * @return ListIterator<E>
     */
    @Override
    public ListIterator<E> listIterator(){
        throw new UnsupportedOperationException();
    }
    /**
     * Method to return listIterator at index
     * O(N)
     * @param index for starting point
     * @return ListIterator<E>
     */
    public ListIterator<E> listIterator(int index){
        throw new UnsupportedOperationException();
    }
}

