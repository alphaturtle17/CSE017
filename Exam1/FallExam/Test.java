import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
public class Test {
    public static void main(String [] args){
        Room[] rooms = new Room[100];
        String fileName = "rooms.txt";
        int count = readFromFile(rooms, fileName);
        Scanner scnr = new Scanner(System.in);
        try{
            int userChoice = 0;
            do{
                System.out.println("What do you want to do?");
                System.out.println("1. Find room\n2. View rooms\n3. Sort rooms\n4. Exit");
                userChoice = scnr.nextInt();
                switch(userChoice){
                    case 1:
                        System.out.println("What room do you want to find?");
                        String number = scnr.next();
                        checkRoomNumber(number);
                        int found = findRoom(rooms, count, number);
                        System.out.println(rooms[found]);
                        break;
                    case 2:
                        System.out.println("Type\tNumber\tCapacity\tArea\tOwner/Computers");
                        printRooms(rooms, count);
                        break;
                    case 3:
                        java.util.Arrays.sort(rooms, 0, count);
                        break;
                    case 4:
                        System.out.println("Goodbye");
                        break;
                }
            }while(userChoice != 4);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void printRooms(Room[] list, int count){
        for(int i = 0; i < count; i++){
            System.out.println(list[i]);
        }
    }
    public static int findRoom(Room[] list, int count, String roomNumber){
        for(int i = 0; i < count; i++){
            if(list[i].getNumber().equals(roomNumber)){
                return i;
            }
        }
        return -1;
    }
    public static void checkRoomNumber(String roomNumber)
        throws Exception{
            if(roomNumber.matches("[A-Z][A-Z][-][0-9][0-9][0-9]")){
                System.out.println("Yay");
            }else{
                throw new Exception("Incorrect room number");
            }
        }
    public static int readFromFile(Room[] list, String filename){
        int count = 0;
        File file = new File(filename);
        try { //Count all of the lines in accounts.txt
            
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
                
                if(Objects.equals(attributes[0], "lab")){ //Using Objects we can check the actual object
                    list[i] = new Lab(attributes[1], Integer.valueOf(attributes[2]), Integer.valueOf(attributes[3]), Integer.valueOf(4));
                }else if(Objects.equals(attributes[0], "classroom")){
                    list[i] = new Classroom(attributes[1], Integer.valueOf(attributes[2]), Integer.valueOf(attributes[3]));
                }else if(Objects.equals(attributes[0], "office")){
                    list[i] = new Office(attributes[1], Integer.valueOf(attributes[2]), Integer.valueOf(attributes[3]), attributes[4]);
                }
            }
            rf.close();
            return count;
        }catch(FileNotFoundException exception){
            System.out.println("Cannot write to " + filename);
            return -1;
        }
    }

}
