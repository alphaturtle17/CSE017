public class TurboRobot extends Robot{
    public TurboRobot(){
        super();
    }
    public TurboRobot(String name, int position){
        super(name, position);
    }
    public void move(int max) 
        throws OutOfRangeException {
            if(getPosition() * 2 < max){
                setPosition(getPosition() * 2);
            }else{
                throw new OutOfRangeException("Position is out of range for robot " + getName());
            }
    }
    public Object clone(){
        TurboRobot clone = new TurboRobot(getName(), getPosition());
        return clone;
    }
    public String toString(){
        return String.format("%-10s\t%s", "Turbo", super.toString());
    }
}
