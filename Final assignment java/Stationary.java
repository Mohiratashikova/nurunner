public class Stationary extends State {
    public Stationary (Common c) {
        super(c, "Stationary");
        isOver = false;
        isVisible = true;
    }
    @Override 
    public void step (Entity e) {
    }

}