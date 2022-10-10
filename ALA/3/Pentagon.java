/**
 * @author Thor Long
 * Date: 9/11/2022
 * CSE 017
 * Pentagon class extends shape and extends abstract classes for pentagons
 */
public class Pentagon extends Shape{
    private double side;
    /**
     * No argument constructor default pentagon side to 1
     */
    Pentagon(){
        super();
        side = 1;
    }
    /**
     * 2 argument constructor 
     * @param color for color of pentagon
     * @param side for side length
     */
    Pentagon(String color, double side){
        super(color);
        this.side = side;
    }
    /**
     * Getter method for side
     * @return double side
     */
    public double getSide() {
        return side;
    }
    /**
     * Setter method for side
     * @param side 
     */
    public void setSide(double side) {
        this.side = side;
    }
    /**
     * Overrides toString formatting output
     */
    @Override
    public String toString(){
        return String.format("%-10s\t%s\t%-40.2f\t%-10.2f\t%-10.2f", "Pentagon", super.toString(), side, getArea(), getPerimeter());
    }
    /**
     * Gets area of pentagon
     */
    public double getArea(){
        return (Math.sqrt(5 * (5 + 2*Math.sqrt(5))) * (side * side)) / 4;
    }
    /**
     * Gets perimeter of pentagon
     */
    public double getPerimeter(){
        return 5 * side;
    }
    /**
     * Scales pentagon by factor of f
     */
    public void scale(double f){
        side *= f;
    }
    /**
     * Creates a new deep copy of pentagon
     */
    public Object clone(){
        return new Pentagon(getColor(), getSide());
    }

}
