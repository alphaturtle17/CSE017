import java.util.ArrayList;
public class ServerList {
    private ArrayList<Server> list;

    ServerList(int servers){
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
    public void setServerBusy(int i, Customer c, int serviceTime){
        list.get(i).setCurrentCustomer(c);
        list.get(i).setServiceTime(serviceTime);
        list.get(i).setBusy();
    }
    public void updateServiceTime(){
        for(int i = 0; i < list.size(); i++){
            list.get(i).decrementServiceTime();
        }
    }
    public int getBusyServers(){
        int amtBusyServers = 0;
        for(int i = 0; i < list.size(); i++){
            if(!list.get(i).isFree()){
                amtBusyServers++;
            }
        }
        return amtBusyServers;
    }
    public String toString(){
        String s = "";
        return s;
    }
}
