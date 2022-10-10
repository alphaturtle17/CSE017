import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Objects;
public class Arena{
    public static void main(String[] args){
        Robot[] robots = new Robot[20];
        int trackLength = 1000;
        int count = readRobots(robots, "robots.txt");
        if(count > 0){
            // Creating 5 clone robots and changing their names
            for(int i=0; i<5; i++){ 
                String name = "Robot" + (10+i+1);
                int rIndex = (int)(Math.random() * count);
                robots[count] = (Robot) (robots[rIndex].clone());
                robots[count].setName(name);
                count++;
            }
            System.out.println("Robot race started ...");
            // Loop to implement the robot race
            for(int i=0; i<3; i++){
                for(int j=0; j<count; j++){
                    try{
                        robots[j].move(trackLength);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }                
            }
            
            
            // Displaying the final position of the robots
            System.out.println("Robot race ended.\n");
            System.out.println("Robot positions at the end of the race");
            print(robots, count);
            // Sorting the robots by position
            java.util.Arrays.sort(robots, 0, count);
            System.out.println("\nRobot ranking at the end of the race");
            print(robots, count);
            // Finding the robot with the max position, but not out of range 
            int winner = 0;
            for(int i=0; i<count; i++){
                if(robots[i].getPosition() > robots[winner].getPosition() &&
                   robots[i].getPosition() <= trackLength){
                        winner = i;
                }
            }
            System.out.println("The race winner: " + robots[winner]);
      }
      else{
        System.out.println("There are no robots in the race.");
      }
    }

    
    public static int readRobots(Robot[] list, String filename){
        int count = 0;
        File file = new File(filename);
        try { //Count all of the lines
            
            Scanner rf = new Scanner(file); //Scanner passing in file to read
            while (rf.hasNextLine()) {
                rf.nextLine();
                count++;
            }
            rf.close();
            //return count;
        } catch(FileNotFoundException f){
            System.out.println("Could not write to file " + filename);
            //return -1;
        }
        try{
            Scanner rf = new Scanner(file);
            for(int i = 0; i < count; i++){
                String s = rf.nextLine();
                String[] attributes = s.split("\\ ");
                
                if(Objects.equals(attributes[0], "Fast")){ //Using Objects we can check the actual object
                    list[i] = new FastRobot(attributes[1], Integer.valueOf(attributes[2]));
                }else if(Objects.equals(attributes[0], "Turbo")){
                    list[i] = new TurboRobot(attributes[1], Integer.valueOf(attributes[2]));
                }else if(Objects.equals(attributes[0], "Sonic")){
                    list[i] = new SonicRobot(attributes[1], Integer.valueOf(attributes[2]));
                }
            }
            rf.close();
            return count;
        }catch(FileNotFoundException exception){
            System.out.println("Cannot write to " + filename);
            return -1;
        }
    }
    public static void print(Robot[] list, int count){
        for(int i=0; i<count; i++){
            System.out.println(list[i]);
        }
    }
}
