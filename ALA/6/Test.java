/**
 * @author Thor Long
 * Date: 10/6/2022
 * CSE 017
 * Tests stack for postfix expressions
 */
import java.util.Scanner;
import java.util.Stack;
import java.util.EmptyStackException;
import java.util.PriorityQueue;
import java.io.File;
import java.io.FileNotFoundException;


public class Test {
    public static void main(String [] args){
        Scanner scnr = new Scanner(System.in);
        Stack<Integer> postFixStack = new Stack<>();
        boolean wantToRun = true;
        do{
            System.out.println("Enter a postfix expression");
            String expression = scnr.nextLine();
            String[] tokens = expression.split(" ");
            //Eval expressions using each element n tokens
            for(int i = 0; i < tokens.length; i++){
                //if number, push to stack
                //otherwise, if valid operation, pop the top two numbers (that were pushed, do operation, push result)
                if(tokens[i].matches("\\d+")){
                    int num = Integer.parseInt(tokens[i]);
                    postFixStack.push(num);
                }else{
                    int num1 = 0;
                    int num2 = 0;
                    try{
                        num1 = postFixStack.pop();
                        num2 = postFixStack.pop();
                    }catch(EmptyStackException e){
                        System.out.println("Malformed Expression");
                    }
                    switch(tokens[i]){
                        case "+":
                            postFixStack.push(num1 + num2);
                            break;
                        case "-":
                            postFixStack.push(num2 - num1);
                            break;
                        case "*":
                            postFixStack.push(num1 * num2);
                            break;
                        case "/":
                            postFixStack.push(num2 / num1);
                            break;
                        default:
                            System.out.println("Invalid operation");
                            i = tokens.length;
                    }
                }
            }
            //For loop ends--expression was evaluated completely as entered
            try{
                int result = postFixStack.pop();
                if(postFixStack.isEmpty()){
                    System.out.println("Result: " + result);
                }else{
                    System.out.println("Malformed Expression");
                    postFixStack.clear();
                }
            }catch(EmptyStackException e){
                System.out.println("Malformed Expression");
            }
            //ADD LOOP TO SEE IF THEY STILL WANT TO DO ANOTHER EXPRESSION
            System.out.println("Do you want to evaluate another expression? (yes, no)");
            String input = scnr.next();
            if(input.toLowerCase().equals("yes")){
                wantToRun = true;
                scnr.nextLine();
            }else if(input.toLowerCase().equals("no")){
                wantToRun = false;

            }else{
                System.out.println("Invalid input, you're getting booted");
                wantToRun = false;
            }
        }while(wantToRun == true);
        
        //part2
        PriorityQueue<PrintRequest> request = new PriorityQueue<>();
        readRequests(request, "requests.txt");

        System.out.printf("%-10s\t%-10s\t%-10s\t%-15s\n", "Request ID", "Request Group", "Size", "Completion Time");
        int speed = 10000; //bytes per second
        double totalTime = 0;
        double time = 0;
        System.out.println("Summary of Printed Requests");
        while(!request.isEmpty()){
            PrintRequest pr = request.poll();
            time = pr.getSize() / speed;
            //conv time for printing
            String strTime = timeConvert(time);
            System.out.printf("%s\t%-15s\n", pr.toString(), strTime);
            totalTime += time;
        }   
        String allTime = timeConvert(totalTime);
        System.out.printf("%s\t%-15s\n", "Total Printing Time: ", allTime);
        scnr.close();
    }    
    /**
     * Method converts time from seconds into a more readable format for humans
     * @param time in seconds
     * @return formatted time in days:hours:minutes:seconds
     */
    public static String timeConvert(double time){
        int days = 0;
        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        String out = "";
        
        if(time > 86400){
            //days
            days = (int) (time / 86400);
            time = (int) (time % 86400);
            if(days < 10){
                out += "0" + days +":";
            }else{
                out += days + ":";
            }
        }else{
            out +="00:";
        }
        if(time > 3600){
            //hours
            hours = (int) (time / 3600);
            time = (int) (time % 3600);
            if(hours < 10){
                out += "0" + hours + ":";
            }else{
                out += hours + ":";
            }
        }else{
            out += "00:";
        }
        if(time > 60){
            //hours
            minutes = (int) (time / 60);
            time = (int) (time % 60);
            if(hours < 10){
                out += "0" + minutes + ":";
            }else{
                out += minutes + ":";
            }
        }else{
            out += "00:";
        }
        seconds = (int) Math.round(time);
        if(seconds < 10){
            out += "0" + seconds;
        }else{
            out += seconds;
        }
        return out;
    }
    /**
     * Reads in file text from priority queue
     * @param pq for PriorityQueue<PrintRequest>
     * @param filename for name of file
     */
    public static void readRequests(PriorityQueue<PrintRequest> pq, String filename){
        File f = new File(filename);
        try{
            Scanner rf = new Scanner(f);
            while(rf.hasNext()){
                int id = rf.nextInt();
                String group = rf.next();
                double size = rf.nextDouble();
                PrintRequest pr = new PrintRequest(id, group, size);
                pq.offer(pr);
            }
            rf.close();
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
}
