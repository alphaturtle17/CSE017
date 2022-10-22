/**
 * @author Thor Long
 * Date: 10/21/22
 * CSE 017
 * Server class is a server who helps customers in this simulation
 */
public class Server {
    private Customer currentCustomer;
    private boolean status;
    private int serviceTime;
    /**
     * Default constructor with no parameters, initializes variables to null, false, 0
     */
    Server(){
        currentCustomer = null;
        status = false;
        serviceTime = 0;
    }
    /**
     * Checks if the server is free or not
     * @return true if status is false, false if status is true (status )
     */
    public boolean isFree(){
        if(status == false){
            return true;
        }else{
            return false;
        }
    }
    /**
     * Setter method for status true meaning server is occupied
     */
    public void setBusy(){
        status = true;
    }
    /**
     * Setter method for status false meaning server is free
     */
    public void setFree(){
        status = false;
    }
    /**
     * Getter method for serviceTime
     * @return int serviceTime
     */
    public int getServiceTime(){
        return serviceTime;
    }
    /**
     * Setter method for service time
     * @param sTime for service rate time
     */
    public void setServiceTime(int sTime){
        serviceTime = sTime;
    }
    /**
     * Method for decrementing servicetime and setting server free if time is 0
     */
    public void decrementServiceTime(){
        serviceTime--;
        if(getServiceTime() == 0){
            setFree();
            setCurrentCustomer(null);
        }
    }
    /**
     * Seetter method for current customer
     * @param c for Customer object
     */
    public void setCurrentCustomer(Customer c){
        currentCustomer = c;
    }
    /**
     * Getter method for current customer
     * @return Customer currentCustomer
     */
    public Customer getCurrentCustomer(){
        return currentCustomer;
    }
    /**
     * Overrides toString for output.
     */
    @Override
    public String toString(){
        String s = "";
        s += currentCustomer + " " + status + " " + serviceTime;
        return s;
    }
}
