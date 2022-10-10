/**
 * @author Thor Long
 * Date: 9/11/2022
 * CSE 017
 * Rectangle extends shape and makes the things rectangle based
 */
public class Rectangle extends Shape{
    private double length;
    private double width;
    /**
     * No argument constructor creates default 1x1 rectangle.
     */
    Rectangle(){
        super();
        length = 1;
        width = 1;
    }
    /**
     * Constructor with 3 parameters
     * @param color for color of rectangle
     * @param length for length of rectangle
     * @param width for width of rectangle
     */
    Rectangle(String color, double length, double width){
        super(color);
        this.length = length;
        this.width = width;
    }
    /**
     * Getter method for length
     * @return double length
     */
    public double getLength(){
        return length;
    }
    /**
     * Getter method for width
     * @return double width
     */
    public double getWidth(){
        return width;
    }
    /**
     * Setter method for length
     * @param length
     */
    public void setLength(double length){
        this.length = length;
    }
    /**
     * Setter method for width
     * @param width
     */
    public void setWidth(double width){
        this.width = width;
    }
    /**
     * Overrides toString and formats for output
     */
    @Override
    public String toString(){
        return String.format("%-10s\t%s\t%-15.2f\t%-25.2f\t%-10.2f\t%-10.2f", "Rectangle", super.toString(), length, width, getArea(), getPerimeter());
    }
    /**
     * Gets area of rectangle
     */
    public double getArea(){
        return length * width;
    }
    /**
     * Gets perimeter of rectangle
     */
    public double getPerimeter(){
        return (2 * length) + (2 * width);
    }
    /**
     * Scales rectangle by factor of f
     */
    public void scale(double f){
        length *= f;
        width *= f;
    }
    /**
     * Creates new deep copy of rectangle
     */
    public Object clone(){
        return new Rectangle(getColor(), getLength(), getWidth());
    }

}
