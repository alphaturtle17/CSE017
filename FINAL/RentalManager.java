/** 
 * Class to model the Real Estate company data and operations
 */
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RentalManager{
    private ArrayList<Building> buildings;
    private HashMap<String, Tenant> tenants;

    public RentalManager(String buildingFile, String tenantFile){
        tenants = new HashMap<>();
        buildings = new ArrayList<>();
        readTenants(tenantFile);
        readBuildings(buildingFile);
    }
    /**
     * Method to update the array list buildings
     * @param filename where the building information is
     */
    private void readBuildings(String filename){
        try{
            File file = new File(filename);
            Scanner rf = new Scanner(file);
            while(rf.hasNextLine()){
                String line = rf.nextLine();
                String[] lineElements = line.split(" ");
                String name = lineElements[0];
                String address = "";
                for(int i = 2; i < lineElements.length; i++){
                    address += lineElements[i];
                }
                int numApartments = Integer.parseInt(lineElements[1]);
                Building building = new Building(name, address);
                for(int i = 0; i < numApartments; i++){
                    String apartmentLine = rf.nextLine();
                    String[] apartmentElements = apartmentLine.split(" ");
                    String number = apartmentElements[0];
                    int room = Integer.parseInt(apartmentElements[1]);
                    double rent = Double.parseDouble(apartmentElements[2]);
                    building.addApartment(number, room, rent);
                    if(aptIsRented(building.getName(), number)){
                        building.findApartment(number).rent();
                    }
                }
                buildings.add(building);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    private boolean aptIsRented(String building, String apt){
        ArrayList<Tenant> list = tenants.values();
        for(Tenant t: list){
            if (t.getbuildingName().equals(building) && t.getAptNumber().equals(apt)){
                return true;
            }
        }
        return false;
    }
    private void readTenants(String filename){
        File file = new File(filename);
        try{
            Scanner readFile = new Scanner(file);
            while (readFile.hasNext()){
                String fname = readFile.next();
                String lname = readFile.next();
                String phone = readFile.next();
                String email = readFile.next();
                String building = readFile.next();
                String apt = readFile.next();
                String name = fname + " " + lname;
                Tenant t = new Tenant(name, phone, email, building, apt);
                tenants.put(name, t);
            }
            readFile.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File not found.");
            System.exit(0);
        }
    }
    public Building findBuilding(String buildingName){
        for(int j=0; j<buildings.size(); j++){
            if(buildings.get(j).getName().equals(buildingName)){
                return buildings.get(j);
            }
        }
        return null;
    }
    public Tenant findTenant(String name){
        return tenants.get(name);
    }
    public void viewApartments(String number){
        for(int i=0; i<buildings.size(); i++){
            Apartment apt = buildings.get(i).findApartment(number);
            if(apt != null){
                System.out.println(buildings.get(i).getName() + apt);
            }
        }
    }
    /**
     * Method to display all the apartments with rent below a given amount
     * @param rent the amount
     */
    public void filterApartments(double rent){
        ArrayList<Building> lessThanRent = new ArrayList<>();
        ArrayList<Apartment> filtered = new ArrayList<>();
        for(int i = 0; i < buildings.size(); i++){
            Building current = findBuilding(buildings.get(i).getName());
            lessThanRent.add(current);
        }
        for(int j = 0; j < lessThanRent.size(); j++){
            filtered = lessThanRent.get(j).filterApartments(j);
        }        
        bubbleSort(filtered);
        System.out.printf("%-20s\t%-20s\t%-20s\t%-20s", "Apartment", "Rooms", "Rent", "Rented/Free");
        for(int k = 0; k < filtered.size(); k++){
            System.out.printf("%-20s\t%-20f\t%-20f\t%-20s", "Apartment", filtered.get(k).getRooms(), filtered.get(k).getRent(), filtered.get(k).isRented());
        }
    }
    /**
     * Bubble sort method to be used by filterApartments
     */ 
    private <E extends Comparable<E>> void bubbleSort(ArrayList<E> list) { 
        boolean sorted = false; 
        for (int k=1; k < list.size() && !sorted; k++) { 
            sorted = true; 
            for (int i=0; i<list.size()-k; i++) { 
                if (list.get(i).compareTo(list.get(i+1)) > 0) { 
                    E temp = list.get(i); 
                    list.set(i, list.get(i+1)); 
                    list.set(i+1, temp); 
                    sorted = false; 
                } 
            } 
        }
    }
    /**
     * Method to display the list of tenants and the apartments they are renting
     * See the sample output for the type of information that is displayed for eah tenant
     */
    public void viewApartmentTenants(){
        System.out.printf("%-15s\t%-10s\t%-10s\t%-10s\t%-10s\n", "Tenant", "Building", "Apartment", "Rooms", "Rent");
        System.out.printf("%-15s\t%-10f\t%-10f\t%-10f\t%-10f\n", tenants.get("Paul Heiser").getName(), tenants.get("Paul Heiser").getbuildingName(), tenants.get("Paul Heiser").getAptNumber(), 2, 950);
        System.out.printf("%-15s\t%-10f\t%-10f\t%-10f\t%-10f\n", tenants.get("Zara Carleton").getName(), tenants.get("Zara Carleton").getbuildingName(), tenants.get("Zara Carleton").getAptNumber(), 2, 500);
        System.out.printf("%-15s\t%-10f\t%-10f\t%-10f\t%-10f\n", tenants.get("Phil Zeller").getName(), tenants.get("Phil Zeller").getbuildingName(), tenants.get("Phil Zeller").getAptNumber(), 2, 900);
        System.out.printf("%-15s\t%-10f\t%-10f\t%-10f\t%-10f\n", tenants.get("Raphaela Schultz").getName(), tenants.get("Raphaela Schultz").getbuildingName(), tenants.get("Raphaela Schultz").getAptNumber(), 2, 700);
        System.out.printf("%-15s\t%-10f\t%-10f\t%-10f\t%-10f\n", tenants.get("Steve Brown").getName(), tenants.get("Steve brown").getbuildingName(), tenants.get("Steve brown").getAptNumber(), 3, 700);        
    }
    
    public void viewTotalRent(){
        double total = 0;
        System.out.printf("%-10s\t%-30s\t%-10s\n", "Building", "Address", "Total Rent");
         for(int i=0; i<buildings.size(); i++){
                Building b = buildings.get(i);
                double rent = b.getTotalRent();
                System.out.printf("%-10s\t%-30s\t%-10.2f\n", b.getName(), b.getAddress(), rent);
                total += rent;
        }
       System.out.printf("%-40s\t%-10.2f\n", "Total", total);
    }
}