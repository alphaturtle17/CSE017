/**
 * @author Thor Long
 * Date: 10/6/2022
 * CSE 017
 * Finds and sorts PrintRequest
 */
public class PrintRequest implements Comparable<PrintRequest>{
    private int id;
    private String group;
    private double size;
    /**
     * Constructor method with three parameters
     * @param id for id of request
     * @param group for group
     * @param size for size in bytes
     */
    PrintRequest(int id, String group, double size){
        this.id = id;
        this.group = group;
        this.size = size;
    }
    /**
     * Getter method for ID
     * @return int id
     */
    public int getId() {
        return id;
    }
    /**
     * getter method for group
     * @return String group
     */
    public String getGroup() {
        return group;
    }
    /**
     * Getter method for size
     * @return double size
     */
    public double getSize() {
        return size;
    }
    /**
     * Setter method for id
     * @param id for id
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * setter method for group
     * @param group set group
     */
    public void setGroup(String group) {
        this.group = group;
    }
    /**
     * Setter method for size 
     * @param size in bytes
     */
    public void setSize(double size) {
        this.size = size;
    }
    /**
     * Overrides toString from object class
     * @return formatted string
     */
    @Override
    public String toString(){
        String unit = "";
        double s = size;
        if(size > 1000000000){
            unit = "GB";
            s = size / 1000000000;
        }else if(size > 1000000){
            unit = "MB";
            s = size / 1000000;
        }else if(size > 1000){
            unit = "KB";
            s = size / 1000;
        }else{
            unit = "bytes";
            s = size;
        }
        return String.format("%-10d\t%-10s\t%.1f%s\t", id, group, s, unit);
    }
    /**
     * Compareto overrided for comparable 
     * @param pr for print request
     * @return int compareto
     */
    @Override
    public int compareTo(PrintRequest pr){
        if(group.equals(pr.group)){
            return 0;
        }else if(group.equals("root")){
            return 1;
        }else if(pr.group.equals("root")){
            return -1;
        }else if(group.equals("admin")){
            return 1;
        }else if(pr.group.equals("admin")){
            return -1;
        }else if(group.equals("user")){
            return 1;
        }else if(pr.group.equals("user")){
            return -1;
        }else{
            return -1;
        }
    }
}
