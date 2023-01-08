/**
 * @author Thor Long
 * Date: 11/6/2022
 * CSE 017
 * ArrayList is an implementation of an arraylist
 */
 import java.util.Iterator;
  import java.util.ListIterator;
  /**
   * Class ArrayList
   * @author Houria Oudghiri
   * Date of creation: October 10, 2021
   * Date of last modification: October 22, 2022
   */
  public class ArrayList<E> implements Cloneable,List<E>{
    // data members
    private E[] elements;
    private int size;
    // Constructors
    public ArrayList() {
      elements = (E[]) new Object[10];
      size = 0;
    }
    public ArrayList(int capacity) {
      elements = (E[]) new Object[capacity];
      size = 0;
    }
    /**
     * Method to add value to the list
     * O(N)
     * @param value to be added
     * @return true if the addition was successful
     */
    public boolean add(E item) {
    return add(size, item);
    }
        /**
     * Method to add value to the list at a specific index
     * O(N)
     * @param index position where value is added
     * @param value to be added
     * @return true if the addition was successful
     */
    public boolean add(int index, E item){
    if(index > size || index < 0)
      throw new ArrayIndexOutOfBoundsException();
    ensureCapacity();
    for(int i=size-1; i>=index; i--){
      elements[i+1] = elements[i];
        }
    elements[index] = item;
    size++;
    return true;
    }
    /**
     * Method to get the value from the list
     * O(1)
     * @param index of the element to get
     * @return value of the element at index
     * throws an exception of type ArrayIndexOutOfBoundsExceptiont if index is invalid
     */
    public E get(int index) {
      checkIndex(index);
      return elements[index];
    } 
        /**
     * Method to modify the value of an element in the list
     * O(1)
     * @param index of the element to be modified
     * @param value new value of the element at index
     * @return the old value of the element at index
     * throws an  exception of type ArrayIndexOutOfBoundsException if index is invalid
     */
    public E set(int index, E item) {
      checkIndex(index);
      E oldItem = elements[index];
      elements[index] = item;
      return oldItem;
    }
     /**
     * Method to get the number of elements in the list
     * O(1)
     * @return size of the list
     */
    public int size() { 
      return size; 
    }
    /**
     * Method to clear the list
     * O(1)
     */
    public void clear() { 
      size = 0; 
    }
    /**
     * Method to check if the list is empty
     * O(1)
     * @return true if the list is empty
     */
    public boolean isEmpty() { 
      return (size == 0);
    }
     /**
     * Method to remove a value from the list
     * O(N)
     * @param o value to find and remove from the list
     * @return true if o was found and removed, false otherwise
     */
    public boolean remove(Object o) {
      E item = (E) o;
      for(int i=0; i<size; i++)
        if(elements[i].equals(item)){
            remove(i);
            return true;
        }
      return false;
    }
     /**
     * Method to remove an element from the list
     * O(n)
     * @param index of the element to remove
     * @return true if the element is removed successfully
     * throws an exception of type ArrayIndexOutOfBoundsException if index is invalid
     */
    public boolean remove(int index) {
      checkIndex(index);
      E item = elements[index];
      for(int i=index; i<size-1; i++)
        elements[i] = elements[i+1];
      size--;
      return true;
    }
    /**
     * Shrink the list to size
     * O(N)
     */
    public void trimToSize() {
      if (size != elements.length) {
          E[] newElements = (E[]) new Object[size];// capacity = size
          for(int i=0; i<size; i++)
            newElements[i] = elements[i];
          elements = newElements;
      }
    }
    /**
     * Grow the list if needed
     * O(N)
     */
    private void ensureCapacity() {
      if(size >= elements.length) {
          int newCap = (int) (elements.length * 1.5);
          E[] newElements = (E[]) new Object[newCap];
          for(int i=0; i<size; i++)
            newElements[i] = elements[i];
          elements = newElements;
      }
    }
    /**
     * Check if the index is valid
     * O(1)
     * @param index for index
     */
    private void checkIndex(int index){
      if(index < 0 || index >= size)
          throw new ArrayIndexOutOfBoundsException(
              "Index out of bounds. Must be between 0 and "+(size-1));
    }
    /**
     * toString() method
     * O(n)
     * @return String toString
     */
    public String toString() {
      String output = "[";
      for(int i=0; i<size-1; i++)
          output += elements[i] + " ";
      output += elements[size-1] + "]";
      return output;
      
    }
     /**
     * Method to get an iterator for the list
     * O(N)
     * @return iterator object associated with this list
     */
    public Iterator<E> iterator(){
      return new ArrayIterator();
    }
    // Inner class that implements the interface Iterator<E>
    private class ArrayIterator implements Iterator<E>{
      private int current = -1;
      /**
       * hasNext method checks if iterator has next elements
       * O(1)
       * @return boolean if there are more elements
       */
      public boolean hasNext() { 
        return current < size-1; 
      }
      /**
       * next returns next value in array
       * O(1)
       * @return E next element
       */
      public E next() { 
        return elements[++current]; 
      }
      /**
       * previous returns previous value in array
       * O(1)
       * @return E previous element
       */
      public E previous(){
        return elements[--current];
      }
      /**
       * hasPrevious returns if arraylist has previous value
       * O(1)
       * @return t/f if has prev value
       */
      public boolean hasPrevious(){
        return current-1 > -1;   //probably wrong
      }
    }
    /**
     * Clone method (deep copy)
     * O(n)
     */
    public Object clone(){
        ArrayList<E> copy = new ArrayList<>();
        for(int i=0; i<size; i++){
            copy.add(elements[i]);
        }
        return copy;
    }
    /**
     * Checks if object is in arraylist
     * O(N)
     * @param Object o, for object
     * @return boolean t/f if object is in array
     */
    @Override
    public boolean contains(Object o) {
      E value = (E) o;
            Iterator<E> iter = iterator();
            while(iter.hasNext()){
                
                if(iter.next().equals(value)){
                    return true;
                }
            }
            return false;
    }
    /**
     * Checks if otherlist is contained in all
     * O(N)
     * @param List<E> for other list
     * @return boolean t/f if every element in otherlist is in array
     */
    @Override
    public boolean containsAll(List<E> otherList) {
      for(int i = 0; i < size; i++){
        if(!contains(otherList.get(i))){
          return false;
        }
      }
      return true;
    }
    /**
     * Adds all elements in otherlist to arraylist
     * O(N)
     * @param List<E> otherList for list of elements to add
     * @return true if worked, false if no elements in otherList
     */
    @Override
    public boolean addAll(List<E> otherList) {
      if(otherList.isEmpty()){
        return false;
      }
      for(int i = 0; i < otherList.size(); i++){
        add(otherList.get(i));
      }
      return true;
    }
    /**
     * Removes all elements in otherlist from arraylist
     * O(N)
     * @param List<E> list of elements to remove
     * @return true if works, false if empty
     */
    @Override
    public boolean removeAll(List<E> otherList) {
      if(otherList.isEmpty()){
        return false;
      }
      for(int i = 0; i < otherList.size(); i++){
        remove(otherList.get(i));
      }
      return true;
    }
    /**
     * removes all elements except elements in otherList in arraylist
     * O(N)
     * @param List<E> for elements to keep
     * @return true if works, false if not.
     */
    @Override
    public boolean retainAll(List<E> otherList) {
      if(otherList.isEmpty()){
        return false;
      }
      clear(); 
      return addAll(otherList);
    }
    /**
     * Makes new listIterator
     * O(N)
     * @return ListIterator<E> 
     */
    @Override
    public ListIterator<E> listIterator() {
      return listIterator(0);
    }
    /**
     * Iterates through arraylist
     * O(N)
     * @param int index for index to start at
     * @return ListIterator<E> object
     */
    @Override
    public ListIterator<E> listIterator(int index)
      throws ArrayIndexOutOfBoundsException{
        
          ArrayIterator iter = new ArrayIterator();
          if(iter.hasNext())
            while(iter.hasNext()){
            iter.next();
        }
      return null;
    }
    /**
     * Converts arrayList to an array
     * O(N)
     * @return Array of objects
     */
    @Override
    public Object[] toArray() {
      Object[] arr = new Object[size];
      for(int i = 0; i < size; i++){
        arr[i] = get(i);
      }
      return arr;
    }
  }