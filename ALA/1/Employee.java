/**
 * @author Thor Long
 * Date: 8/31/22
 * CSE 017 
 * Extends person class to add for positions of power in a hypothetical school environment
 */
public class Employee extends Person{
    private int id;
    private String position;
    private double salary;

    /**
     * Default constructor
     * No parameters
     * No initialization
     */
    public Employee(){

    }
    /**
     * Constructor with 7 parameters 
     * @param name  for name of employee
     * @param address   for address of employee
     * @param phone for phone number of employee
     * @param email for email address of employee
     * @param id    for id of employee  
     * @param position  for position of employee
     * @param salary    for salary of employee
     */
    public Employee(String name, String address, String phone, String email, int id, String position, double salary){
        super(name, address, phone, email);
        this.id = id;
        this.position = position;
        this.salary = salary;
    }
    /**
     * Getter method to get id of employee
     * @return int id number
     */
    public int getID(){
        return id;
    }
    /**
     * Setter method to set employee id
     * @param id to set id 
     */
    public void setID(int id){
        this.id = id;
    }
    /**
     * Getter method for position of employee
     * @return  String position of employee
     */
    public String getPosition(){
        return position;
    }
    /**
     * Setter method for position of employee
     * @param position to set position
     */
    public void setPosition(String position){
        this.position = position;
    }
    /**
     * Getter method for salary
     * @return double salary value of employee salary
     */
    public double getSalary(){
        return salary;
    }
    /**
     * Setter method for salary of employee
     * @param salary to set salary to double value
     */
    public void setSalary(double salary){
        this.salary = salary;
    }
    /**
     * Method to print formatted information of employee
     * @return String s of formatted information
     */
    @Override
    public String toString(){
        String s = super.toString();
        s += "\nID: " + id;
        s += "\nPosition: " + position;
        s += "\nSalary: " + salary;
        return s;
    }
}