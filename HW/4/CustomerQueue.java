/**
 * @author Thor Long
 * Date: 10/21/22
 * CSE 017
 * CustomerQueue is a linkedlist queue of customers
 */
import java.util.LinkedList;
import java.util.Queue;
public class CustomerQueue {
    private Queue<Customer> customers;
    /**
     * Default constructor no args no parameters, initializes empty queue linkedlist with customer objects
     */
    CustomerQueue(){
        customers = new LinkedList<Customer>();
    }
    /**
     * Gets next customer in queue and removes from queue
     * @return Customer
     */
    public Customer getNextCustomer(){
        return customers.poll();
    }
    /**
     * Increments the waiting time for each customer in queue
     */
    public void updateWaitingTime(){
        for(Customer c : customers){
            c.incrementWaitingTime();
        }
    }
    /**
     * Adds customer to queue
     * @param c Customer
     */
    public void addCustomer(Customer c){
        customers.add(c);
    }
    /**
     * Method to see if there are any customers in queue
     * @return
     */
    public boolean isEmpty(){
        if(customers.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    /**
     * Size of queue
     * @return int size of queue
     */
    public int size(){
        return customers.size();
    }
    /**
     * ToString method for linkedlist/queue of customers
     */
    public String toString(){
        String s = "[";
        while(customers.peek() != null){
            s += customers.poll();
        }
        s += "]";
        return s;
    }
}
