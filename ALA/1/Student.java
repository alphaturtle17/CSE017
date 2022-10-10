/**
 * @author Thor Long
 * Date: 8/31/22
 * CSE 017 
 * Student.java extends Person class to specialize object to fit description of a student
 */
public class Student extends Person{
    private int id;
    private String major;

    /**
     * Default Constructor
     * No Parameters
     * No initialization
     */
    public Student(){

    }
    /**
     * Constructor with 6 parameters 
     * @param name for Name of student
     * @param address for Address of student
     * @param phone for Phone number of student
     * @param email for Email of student
     * @param id for ID of student
     * @param major for major of student
     */
    public Student(String name, String address, String phone, String email, int id, String major){
        super(name, address, phone, email);
        this.id = id;
        this.major = major;
    }
    
    /**
     * Getter for ID of student
     * @return value of student ID
     */
    public int getID(){
        return id;
    }
    
    /** 
     * Setter for ID of student
     * @param id to set id number to value
     */
    public void setID(int id){
        this.id = id;
    }
    
    /** 
     * Getter for major of student
     * @return value of major of student
     */
    public String getMajor(){
        return major;
    }
    
    /** 
     * Setter method for major of student
     * @param major to set student major
     */
    public void setMajor(String major){
        this.major = major;
    }
    
    /** 
     * Method to return all information of Student
     * @return string value containing formatted data members and values
     */
    @Override
    public String toString(){
        String s = super.toString();
        s += "\nID: " + id;
        s += "\nMajor: " + major;
        return s;
    }
}