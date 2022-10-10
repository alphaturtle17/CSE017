/**
 * @author Thor Long
 * Date: 9/11/2022
 * CSE 017
 * Main method for testing Shapes.java and all child classes
 */
public class TestShapes {
    public static void main(String args[]){
        Shape[] shapes = new Shape[8]; //Array size 8
        shapes[0] = new Circle("Black", 2.5);
        shapes[1] = new Triangle("Green", 6.0, 6.0, 6.0);
        shapes[2] = new Rectangle("Red", 5.0, 3.0);
        shapes[3] = new Pentagon("Yellow", 7.0);
        
        shapes[4] = (Circle) shapes[0].clone();
        shapes[5] = (Triangle) shapes[1].clone();
        shapes[6] = (Rectangle) shapes[2].clone();
        shapes[7] = (Pentagon) shapes[3].clone();



        shapes[4].scale(2.0);
        shapes[5].setColor("Orange");
        ((Rectangle)shapes[6]).setLength(10.0);
        ((Pentagon)shapes[7]).setSide(4.0);

        System.out.println("Unsorted Shapes");
        System.out.printf("%-10s\t%-10s\t%-40s\t%-10s\t%s", "Shape", "Color", "Dimensions", "Area", "Perimeter\n");
        for(int i = 0; i < shapes.length; i++){
            System.out.println(shapes[i]);
        }
        java.util.Arrays.sort(shapes);
        System.out.println("\nSorted Shapes");
        for(int i = 0; i < shapes.length; i++){
            System.out.println(shapes[i]);
        }

        System.out.println("Average Perimeter: " + getAveragePerimeter(shapes));

    }
    /**
     * Calculates the average perimeter of array of shapes
     * @param list for array of shapes
     * @return double averagePerimeter for average perimeter of all shapes
     */
    public static double getAveragePerimeter(Shape[] list){
        double averagePerimeter = 0;
        for(int i = 0; i < list.length; i++){
            averagePerimeter += list[i].getPerimeter();
        }
        averagePerimeter = averagePerimeter / 2;
        return averagePerimeter;
    }
}
