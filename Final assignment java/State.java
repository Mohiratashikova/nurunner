public abstract class State {
    public String name;
    public boolean isOver;
    public boolean isVisible;
    public Common common;
    public State (Common c, String name) {
        this.common = c;
        this.name = name;
    }
    public abstract void step (Entity e);
}