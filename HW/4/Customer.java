public class Customer{
    private int customerNo;
    private int arrivalTime;
    private int waitingTime;

    Customer(int cn, int at, int wt){
        customerNo = cn;
        arrivalTime = at;
        waitingTime = wt;
    }
    public int getCustomerNo() {
        return customerNo;
    }
    public int getArrivalTime() {
        return arrivalTime;
    }
    public int getWaitingTime() {
        return waitingTime;
    }
    public void setCustomerNo(int customerNo) {
        this.customerNo = customerNo;
    }
    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }
    public void incrementWaitingTime(){
        waitingTime++;
    }
    @Override
    public String toString() {
        String s = "";
        s += customerNo + " " + arrivalTime + " " + waitingTime;
        return s;
    }
}