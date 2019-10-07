import java.awt.Graphics2D;

public abstract class Entity {
    public String name;
    public Vector2D position;
    public State state;
    public Common common;
    public int grade;
    public Entity (Common c) {
        this.common = c;
    }

    public abstract void draw (Graphics2D g2d);
    public void step(){}
}