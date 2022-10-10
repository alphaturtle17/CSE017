public class SonicRobot extends Robot{
    public SonicRobot(){
        super();
    }
    public SonicRobot(String name, int position){
        super(name, position);
    }
    public void move(int max) 
        throws OutOfRangeException {
            if(getPosition() * 10 < max){
                setPosition(getPosition() * 10);
            }else{
                throw new OutOfRangeException("Position is out of range for robot " + getName());
            }
    }
    public Object clone(){
        SonicRobot clone = new SonicRobot(getName(), getPosition());
        return clone;
    }
    public String toString(){
        return String.format("%-10s\t%s", "Sonic", super.toString());
    }
}
