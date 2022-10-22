/**
 * @author Thor Long
 * Date: 10/21/22
 * CSE 017
 * ServerList defines an arraylist of servers
 */
import java.util.ArrayList;
public class ServerList {
    private ArrayList<Server> list;
    /**
     * Constructor with one parameter
     * @param servers for number of servers in arraylist serverlist
     */
    ServerList(int servers){
        list = new ArrayList<Server>(servers);
        for(int i = 0; i < servers; i++){
            list.add(new Server());
        }
    }
    /**
     * Method gets index of first free server
     * @return index of first free server, else return -1;
     */
    public int getFreeServer(){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).isFree()){
                return i;
            }
        }
        return -1;
    }
    /**
     * Method to set server to "busy" meaning occupied and can't attend anyone else
     * @param i for index
     * @param c for Customer
     * @param serviceTime for time occupied with customer
     */
    public void setServerBusy(int i, Customer c, int serviceTime){
        list.get(i).setCurrentCustomer(c);
        list.get(i).setServiceTime(serviceTime);
        list.get(i).setBusy();
    }
    /**
     * Method to decrement serviceTime if server is occupied
     */
    public void updateServiceTime(){
        for(int i = 0; i < list.size(); i++){
            if(!list.get(i).isFree()){
                list.get(i).decrementServiceTime();
            }   
        }
    }
    /**
     * Gets number of servers that are working with someone currently
     * @return int amount of busy servers
     */
    public int getBusyServers(){
        int amtBusyServers = 0;
        for(int i = 0; i < list.size(); i++){
            if(!list.get(i).isFree()){
                amtBusyServers++;
            }
        }
        return amtBusyServers;
    }
    /**
     * toString method for arraylist of servers
     */
    public String toString(){
        String s = "[";
        for(int i = 0; i < list.size(); i++){
            s += list.get(i).toString();
        }
        s += "]";
        return s;
    }
}
