/**
 * @author Thor Long
 * Date: 11/17/2022
 * CSE 017
 * user made linkedlist methods
 */
import java.util.NoSuchElementException;
import java.util.Iterator;
//linked list implementing
public class LinkedList<E>{
    // Data members
private Node head, tail;
int size;
    // Inner class Node
private class Node{
E value;
Node next, previous;
Node(E initialValue){
value = initialValue; next = null;
}
}
    // Constructor
public LinkedList() {
head = tail = null;
size = 0;
}
// Adding an item to the list
public boolean addFirst(E item) {
Node newNode = new Node(item);
if(head == null) { head = tail = newNode; }
else { newNode.next = head;
    head = newNode;
}
size++; return true;
}
public boolean addLast(E item) {
Node newNode = new Node(item);
if(head == null) { head = tail = newNode; }
else { tail.next = newNode; tail = newNode; }
size++; return true;
}
public boolean add(E item) {
return addFirst(item);
}
// Retrieving an item from the list
public E getFirst() {
if (head == null)
throw new NoSuchElementException();
return head.value;
}
public E getLast() {
if (head == null)
throw new NoSuchElementException();
return tail.value;
}
// Removing an item from the list
public boolean removeFirst() {
if (head == null) throw new NoSuchElementException();
head = head.next;
if(head == null) tail=null;
size--; return true;
}
public boolean removeLast() {
if (head == null) throw new NoSuchElementException();
if(size == 1) return removeFirst();
Node current = head;
Node previous = null;
while(current.next != null) {
previous = current; current = current.next;
}
previous.next = null; tail = previous;
size--; return true;
}
// toString() method
public String toString() {
String output = "[";
Node node = head;
while(node != null) {
output += node.value + " ";
node = node.next;//ITERATION
}
output += "]";
return output;
} 
// clear, check if empty, and size of the list
public void clear() { head = tail = null; size = 0; 
}
public boolean isEmpty() { return (size == 0); 
}
public int size() { 
    return size;
        }
// Generating an iterator for the list
public Iterator<E> iterator(){
    return new LinkedListIterator();
    }
    private class LinkedListIterator implements Iterator<E>{
    private Node current = head;
    public boolean hasNext() {
    return (current != null);
    }
    public E next() {
    if(current == null)
        throw new NoSuchElementException();
    E value = current.value;
    current = current.next; return value;
    }
    public boolean hasPrevious(){
        return (current.previous != null);
    }
    public E previous(){
        if(hasPrevious()){
            E value = current.value;
            current = current.previous;
            return value;
        }else{  
            throw new NoSuchElementException();
        }
    }
    public void add(E value){
        Node newNode = new Node(value);
        if(head == null){
            head = tail = newNode;
            head.previous = null;
            tail.next = null;
        }else{
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
            tail.next = null;
        }
        size++;
    }
    public void remove(){
        current.previous.next = current.next;
        current.next.previous = current.previous;
        current.next = null;
        current.previous = null;
        size--;
    }
    public void set(E value){
        current.value = value;
    }
    public int nextIndex(){
        Iterator iter = iterator();
        int index = 0;
        Node start = head;
        while(iter.hasNext()){
            if(start.equals(current)){
                return index+1;
            }
            start = start.next;
            index++;
        }
        return -1;
    }
    public int previousIndex(){
        Iterator iter = iterator();
        int index = 0;
        Node start = head;
        while(iter.hasNext()){
            if(start.equals(current)){
                return index-1;
            }
            start = start.next;
            index++;
        }
        return -1;
    }
}

//O(n)
    public int contains(E item){
        int iterations = 0;
        Iterator<E> iterator = iterator();
        while(iterator.hasNext()){
            iterations++;
            if(iterator.next().equals(item)){
                return iterations;
            }
        }
        return iterations;
    }
    //O(n)
    public int remove(Object item){
        E value = (E) item;
        int iterations = 0;
        Node current = head;
        Node previous = null;
        while(current != null){
            iterations++;
            if(current.value.equals(value)){
                break;
            }
            previous = current;
            current = current.next;
        }
        if(current != null){ //found
            if(current == head){
                removeFirst();
            }else{
                previous.next = current.next;
            }
            
        }
        return iterations;
    }
    //Add method
    //O(n)
    public int add(int index, E item){
        int iterations = 0;
        if(index > size || index < 0){
            throw new NoSuchElementException();
        }
        if(index == 0){
            addFirst(item);
            return iterations;
        }
        if(index == size-1){
            addLast(item);
            return iterations;
        } 
        Node current = head;
        Node previous = null;
        int i = 0;
        while(i < index){
            iterations++;
            i++;
            previous = current;
            current = current.next;
        }
        Node newNode = new Node(item);
        previous.next = newNode;
        newNode.next = current;
        size++;
        return iterations;
    }
    
}