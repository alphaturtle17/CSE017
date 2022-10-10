public class Office extends Room{
    private String owner;

    Office(String number, int capacity, int area, String owner){
        super(number, capacity, area);
        this.owner = owner;
    }
    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    @Override
    public String toString() {
        return super.toString() + "\t" + getOwner();
    }
}
