import java.util.LinkedList;
import java.util.Queue;
public class CustomerQueue {
    private Queue<Customer> customers;
    
    CustomerQueue(){
        customers = new LinkedList<Customer>();
    }
    public Customer getNextCustomer(){
        return customers.poll();
    }
    public void updateWaitingTime(){
        for(Customer c : customers){
            c.incrementWaitingTime();
        }
    }
    public void addCustomer(Customer c){
        customers.add(c);
    }
    public boolean isEmpty(){
        if(customers.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    public int size(){
        return customers.size();
    }
    public String toString(){
        String s = "";
        return s;
    }
}
