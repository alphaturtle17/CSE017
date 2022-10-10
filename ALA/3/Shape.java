/**
 * @author Thor Long
 * Date: 9/11/2022
 * CSE 017
 * Shape.java is an abstract class that impliments different attributes of a shape, can be duplicated, and scales as well
 */
public abstract class Shape implements Comparable<Shape>, Cloneable, Scalable{
    private String color;
    /**
     * no argument constructor sets the shape's default to none.
     */
    protected Shape(){
        color = "none";
    }
    /**
     * Constructor with one argument sets color of shape
     * @param color for color of shape
     */
    protected Shape(String color){
        this.color = color;
    }
    /**
     * Setter method for color attribute
     * @param color for color of shape
     */
    public void setColor(String color){
        this.color = color;
    }
    /**
     * Getter method for color variable
     * @return String color
     */
    public String getColor(){
        return color;
    }
    /**
     * toString method overrides toString and formats output.
     */
    @Override
    public String toString(){
        return String.format("%-10s", color);
    }
    /**
     * compareto method compares the area of each shape
     * @return 0 if same, -1 if less than, else 1
     */
    public int compareTo(Shape s){
        if(getArea() == s.getArea()){
            return 0;
        }else if(getArea() < s.getArea()){
            return -1;
        }else{
            return 1;
        }
    }
    public abstract double getArea();
    public abstract double getPerimeter();
    public abstract Object clone();
    public abstract void scale(double f);
}
