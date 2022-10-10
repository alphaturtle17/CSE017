public class FastRobot extends Robot{
    public FastRobot(){
        super();
    }
    public FastRobot(String name, int position){
        super(name, position);
    }
    public void move(int max) 
        throws OutOfRangeException {
            if(getPosition() + 2 < max){
                setPosition(getPosition() + 2);
            }else{
                throw new OutOfRangeException("Position is out of range for robot " + getName());
            }
           
    }
    public Object clone(){
        FastRobot clone = new FastRobot(getName(), getPosition());
        return clone;
    }
    public String toString(){
        return String.format("%-10s\t%s", "Fast", super.toString());
    }
}
