public abstract class Assessment extends Entity {
    public int points;
    public int height = 20;
    public int width = 20;
    public int offset = 5;
    public Assessment(Common c) {
        super(c);
        state = new Stationary(common);
    }
}