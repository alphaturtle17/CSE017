/**
 * @author Thor Long
 * Date: 9/11/2022
 * CSE 017
 * Triangle extends shape and impliments specifics
 */
public class Triangle extends Shape{
    private double side1;
    private double side2;
    private double side3;
    /**
     * No argument constructor setting default triangle to a 3-4-5 triangle
     */
    Triangle(){
        super();
        side1 = 3;
        side2 = 4;
        side3 = 5;
    }
    /**
     * 4 argument constructor with color, and side lengths
     * @param color for triangle color
     * @param side1 for length of side 1 
     * @param side2 for length of side 2
     * @param side3 for length of side 3
     */
    Triangle(String color, double side1, double side2, double side3){
        super(color);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    /**
     * Getter method for side 1
     * @return double side1
     */
    public double getSide1() {
        return side1;
    }
    /**
     * Getter method for side 2
     * @return double side2
     */
    public double getSide2() {
        return side2;
    }
    /**
     * Getter method for side 3
     * @return double side3
     */
    public double getSide3() {
        return side3;
    }
    /**
     * Setter method for side1
     * @param side1 length
     */
    public void setSide1(double side1) {
        this.side1 = side1;
    }
    /**
     * Setter method for side 2
     * @param side2 length
     */
    public void setSide2(double side2) {
        this.side2 = side2;
    }
    /**
     *Setter method for side 3
     * @param side3 length
     */
    public void setSide3(double side3) {
        this.side3 = side3;
    }
    /**
     * Overrides toString formatting shape for triangle
     */
    @Override
    public String toString(){
        return String.format("%-10s\t%s\t%-10.2f\t%-10.2f\t%-10.2f\t%-10.2f", "Triangle", super.toString(), side1, side2, side3, getArea(), getPerimeter());
    }
    /**
     * Gets area of triangle
     * @return area of triangle
     */
    public double getArea(){
        double halfPerm = getPerimeter() / 2;
        return Math.sqrt(halfPerm*(halfPerm - side1)*(halfPerm - side2)*(halfPerm - side3));
    }
    /**
     * Gets perimeter of triangle
     * @return perimeter of triangle
     */
    public double getPerimeter(){
        return side1 + side2 + side3;
    }
    /**
     * Scales triangle by f scale
     */
    public void scale(double f){
        side1 *= f;
        side2 *= f;
        side3 *= f;
    }
    /**
     * Creates new deep copy of triangle
     */
    public Object clone(){
        return new Triangle(getColor(), getSide1(), getSide2(), getSide3());
    }
}
