public class Lab extends Room{
    private int computers;

    Lab(String number, int capacity, int area, int computers){
        super(number, capacity, area);
        this.computers = computers;
    }
    public int getComputers() {
        return computers;
    }
    public void setComputers(int computers) {
        this.computers = computers;
    }
    @Override
    public String toString() {
        return super.toString() + "\t" + getComputers();
    }
}
