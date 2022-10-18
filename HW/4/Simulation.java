import java.util.Scanner;
public class Simulation {
    public static void main(String[] args){
        Scanner scnr = new Scanner(System.in);
        try{
            System.out.println("Simulation parameters: ");
            System.out.println("Enter simulation time in minutes: ");
            int simTime = scnr.nextInt();
            System.out.println("Enter number of servers: ");
            int numServers = scnr.nextInt();
            System.out.println("Enter how fast customers arrive (customers per hour): ");
            int cusPM = scnr.nextInt();
            System.out.println("Enter the amount of time it takes a server to serve a customer in minutes: ");
            int servPM = scnr.nextInt();
            //Intro parameters done
            ServerList sl = new ServerList(numServers);
            CustomerQueue queue = new CustomerQueue();
            for(int clock = 0; clock < simTime; clock++){
                //Update the server list to decrement the service time of each busy server by one time unit (use the method updateServiceTime)
                sl.updateServiceTime();
                //If the customer’s queue is nonempty, increment the waiting time of each customer by one time unit (use the method incrementWaitingTime)
                if(!queue.isEmpty()){
                    queue.updateWaitingTime();
                }
                //If a customer arrives, add the customer to the customer queue. Generate a random number p between 0 and 1. If p < (customer arrival rate/60), assume a new customer arrived, otherwise no customer arrived
                if((clock % cusPM) == 0){
                    
                }
                //If a server is free and the customer queue is nonempty, remove a customer from the front of the queue and assign the customer to the free server (use getNextCustomer() to get the customer at the front of the queue, getFreeServer() to get the index of the first free server or -1 if all servers are busy, and setServerBusy() to assign a customer to a server)
            }    
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
