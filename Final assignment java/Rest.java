public class Rest extends State {
    public int duration;
    
    public Rest (int duration, Common c) {
        super(c, "Rest");
        isOver = false;
        isVisible = true;
        this.duration = duration;
    }
    @Override
    public void step (Entity e) {
        --duration;
        if (duration == 0) {
            isOver = true;
        }
    }
}