import java.util.Scanner;
public class Simulation {
    public static void main(String[] args){
        Scanner scnr = new Scanner(System.in);
        try{
            System.out.println("Simulation parameters: ");
            System.out.println("Enter simulation time in minutes: ");
            int simTime = 100;//scnr.nextInt();
            System.out.println("Enter number of servers: ");
            int numServers = 1;//scnr.nextInt();
            System.out.println("Enter how fast customers arrive (customers per hour): ");
            int cusPh = 10;//scnr.nextInt();
            System.out.println("Enter the amount of time it takes a server to serve a customer in minutes: ");
            int servPM = 5;//scnr.nextInt();
            //Intro parameters done
            ServerList serverlist = new ServerList(numServers);
            CustomerQueue queue = new CustomerQueue();
            int cusNum = 0;
            int totalWaitingTime = 0;
            int finishedCustomers = 0;
            for(int clock = 0; clock < simTime; clock++){
                serverlist.updateServiceTime();
                
                if(!queue.isEmpty()){
                    queue.updateWaitingTime();
                }
                double p = Math.random();
                if(p < (double) cusPh/60){
                    cusNum++;
                    Customer cust = new Customer(cusNum, clock, 0);
                    queue.addCustomer(cust);
                    System.out.println("Customer " + cust.getCustomerNo() + " arrived at time " + cust.getArrivalTime());
                }
                int s = serverlist.getFreeServer();
                if(clock % servPM == 0){
                    serverlist.setServerBusy(s, null, 0);
                }
                if(serverlist.getFreeServer() != -1 && queue.isEmpty() == false){
                    Customer c = queue.getNextCustomer();
                    
                    totalWaitingTime += c.getWaitingTime();
                    serverlist.setServerBusy(s, c, servPM);
                    System.out.println("Customer number " + cusNum + " assigned to server " + s);
                }
            }    

            System.out.println("Simulation time: " + simTime);
            System.out.println("Number of servers: " + numServers);
            System.out.println("Average service time: " + finishedCustomers / servPM);
            System.out.println("Customer arrival rate: " + cusPh);
            System.out.println("Total customers: " + cusNum);
            System.out.println("Customers served: " + finishedCustomers);
            System.out.println("Number of customers still being served: " + serverlist.getBusyServers());
            System.out.println("Number of customers left in the queue: " + queue.size());
            System.out.println("Total waiting time: " + totalWaitingTime);
            System.out.println("Average waiting time per customer: " + totalWaitingTime / cusNum);


        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
