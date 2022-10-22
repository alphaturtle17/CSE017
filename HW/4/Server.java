public class Server {
    private Customer currentCustomer;
    private boolean status;
    private int serviceTime;

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
    public void setBusy(){
        status = true;
    }
    public void setFree(){
        status = false;
    }
    public int getServiceTime(){
        return serviceTime;
    }
    public void setServiceTime(int sTime){
        serviceTime = sTime;
    }
    public void decrementServiceTime(){
        serviceTime--;
    }
    public void setCurrentCustomer(Customer c){
        currentCustomer = c;
    }
    public Customer getCurrentCustomer(){
        return currentCustomer;
    }
    @Override
    public String toString(){
        String s = "";
        s += currentCustomer + " " + status + " " + serviceTime;
        return s;
    }
}
