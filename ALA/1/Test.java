/**
 * @author Thor Long
 * Date: 8/31/22
 * CSE 017
 * Test.java main method prints and sorts an array of people derived from Person.java 
 */
public class Test{
    public static void main(String args[]){
        Person [] people = new Person[4];
        Person p = new Person("Helen Brown", "222 10th Street Bethlehem", "610-334-2288", "hbrown@gmail.com");
        Student s = new Student("Paul Leister", "972 4th STreet Allentown", "610-331-7177", "pleister@gmail.com", 12345, "CSE");
        Employee e = new Employee("Beth Down", "234 Main Street Philadelphia", "484-222-4433", "bdown@gmail.com", 33442, "Systems Administrator", 75000);
        Faculty f = new Faculty("Mark Jones", "21 Orchid Street Bethlehem", "610-333-2211", "mjones@gmail.com", 22222, "Faculty", 100000, "Associate Professor");

        people[0] = p;
        people[1] = s;
        people[2] = e;
        people[3] = f;

        System.out.println("Original List:");
        printArray(people);
        sortArray(people);
        System.out.println("\nSorted List:");
        printArray(people);
 
    }
    /**
     * Method prints array
     * @param Person[] takes in array of Person objects to print 
     */
    public static void printArray(Person[] people){
       for(int i = 0; i < people.length; i++){
            System.out.println(people[i]);
        }
    }
    /**
     * Method sorts the array of Person objects using the .getName and compareTo
     * @param Person[] switches Person objects based on the first letter of the name from .getName
     */
    public static void sortArray(Person[] list){
        for(int i= 0 ; i < list.length; i++){
            int min = i;
            for(int j = i+1; j < list.length; j++){
                String s1 = list[j].getName();
                String s2 = list[min].getName();
                if(s1.compareTo(s2) < 0){ //return 0 s1==s2  
                    min = j;          //>0 s1 after s2,
                                      //<0 s1 before s2
                }
            }
            Person temp = list[i];
            list[i] = list[min];
            list[min] = temp;
        }
    }
}