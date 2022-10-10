/**
 * @author Thor Long
 * Date: 8/31/22
 * CSE 017 
 * Extends employee to add rank to what kind of employee the person is
 */
public class Faculty extends Employee{
    private String rank;

    /**
     * Default Constructor
     * No Parameters
     * No initialization
     */
    public Faculty(){

    }
    /**
     * Constructor with 8 parameters
     * @param name  for name of faculty 
     * @param address   for address of faculty 
     * @param phone for phone number of faculty 
     * @param email for email of faculty
     * @param id    for id of faculty
     * @param position  for position of faculty
     * @param salary    for salary of faculty
     * @param rank  for rank of faculty
     */
    public Faculty(String name, String address, String phone, String email, int id, String position, double salary, String rank){
        super(name,address,phone,email,id,position,salary);
        this.rank = rank;
    }
    /**
     * Getter method for rank
     * @return string with rank value
     */
    public String getRank(){
        return rank;
    }
    /**
     * Setter method to set rank of faculty member to something
     * @param rank  to set rank
     */
    public void setRank(String rank){
        this.rank = rank;
    }
    /**
     * Method to print all information of faculty member
     * @return  s string of formatted information of faculty
     */
    @Override
    public String toString(){
        String s = super.toString();
        s += "\nRank: " + rank;
        return s;
    }
}