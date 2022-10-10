/**
 * @author Thor Long
 * Date: 9/11/2022
 * CSE 017
 * Circle is a type of shape and extends it, adding attributes for circle type.
 */
public class Circle extends Shape{
    private double radius;
    /**
     * No argument constructor sets radius to 1 and calls super constructor
     */
    Circle(){
        super();
        radius = 1.0;
    }
    /**
     * Constructor with two arguments 
     * @param color for color of shape
     * @param radius for radius of circle
     */
    Circle(String color, double radius){
        super(color);
        this.radius = radius;
    }
    /**
     * getter method for radius
     * @return double radius
     */
    public double getRadius() {
        return radius;
    }
    /**
     * Setter method for radius
     * @param radius for radius of circle
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }
    /**
     * Overrides toString formats object'S information
     */
    @Override
    public String toString(){
        return String.format("%-10s\t%s\t%-40.2f\t%-10.2f\t%-10.2f", "Circle", super.toString(), radius, getArea(), getPerimeter());
    }
    /**
     * Method for getting area of circle
     * @return area of circle
     */
    public double getArea(){
        return Math.PI * radius * radius;
    }
    /**
     * Method for getting permiter of circle
     * @return double perimeter of circle
     */
    public double getPerimeter(){
        return Math.PI * radius * 2;
    }
    /**
     * Scales the shape by a factor of f
     */
    public void scale(double f){
        radius *= f;
    }
    /**
     * Creates deep copy of circle
     */
    public Object clone(){
        return new Circle(getColor(), radius);
    }
}
