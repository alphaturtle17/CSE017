/**
 * @author Thor Long
 * Date: 10/21/22
 * CSE 017
 * Customer class represents a customer in a queue needing to be helped
 */
public class Customer{
    private int customerNo;
    private int arrivalTime;
    private int waitingTime;
    /**
     * Constructor with three parameters
     * @param cn for customer number
     * @param at for arrival time
     * @param wt for waiting time
     */
    Customer(int cn, int at, int wt){
        customerNo = cn;
        arrivalTime = at;
        waitingTime = wt;
    }
    /**
     * Getter method for customer number
     * @return int customerNo 
     */
    public int getCustomerNo() {
        return customerNo;
    }
    /**
     * Getter method for arrival time
     * @return int arrivalTime
     */
    public int getArrivalTime() {
        return arrivalTime;
    }
    /**
     * Getter method for waiting time
     * @return int waitingTime
     */
    public int getWaitingTime() {
        return waitingTime;
    }
    /**
     * Setter method for customer number
     * @param customerNo for number
     */
    public void setCustomerNo(int customerNo) {
        this.customerNo = customerNo;
    }
    /**
     * Setter method for arrival time
     * @param arrivalTime for time arrived in simulation
     */
    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    /**
     * Setter method for waiting time
     * @param waitingTime for time waiting in queue
     */
    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }
    /**
     * Method to incriment time waiting in queue
     */
    public void incrementWaitingTime(){
        waitingTime++;
    }
    /**
     * toString method for output
     */
    @Override
    public String toString() {
        String s = "";
        s += customerNo + " " + arrivalTime + " " + waitingTime;
        return s;
    }
}