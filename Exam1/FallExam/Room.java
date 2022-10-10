public abstract class Room implements Comparable<Room>{
    private String number;
    private int capacity;
    private int area;

    Room(String number, int capacity, int area){
        this.number = number;
        this.capacity = capacity;
        this.area = area;
    }
    public String getNumber() {
        return number;
    }
    public int getCapacity() {
        return capacity;
    }
    public int getArea() {
        return area;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public void setArea(int area) {
        this.area = area;
    }
    @Override
    public String toString(){
        String thing = "\n" + getClass().getSimpleName() + "\t" + getNumber() + "\t" + getCapacity() + "\t\t" + getArea();
        return thing;
    }
    public int compareTo(Room r){
        if(getCapacity() > r.getCapacity()){
            return 1;
        }else if(getCapacity() < r.getCapacity()){
            return -1;
        }else{
            return 0;
        }
    }
}
