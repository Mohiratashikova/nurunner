import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;

public class Student extends Entity {
    public int height = 30;
    public int width = 30;
    public int offset = 10;
    public Student(String name, Common c) {
        super(c);
        grade = 0;
        this.name = new String (name);
        position = new Vector2D(common.randomInt(0, (common.windowWidth-width)),common.randomInt(0, (common.windowHeight-height)));
        state = new Rest(5, common);
    }
    public void draw (Graphics2D g2d) {
        if (grade < 100) {
            g2d.setPaint(Color.CYAN);
        } else 
            g2d.setPaint(Color.MAGENTA);
        g2d.fillOval((int)(position.x), (int)(position.y), width, height);
        g2d.setPaint(Color.BLACK);
        //printing name
        g2d.drawString(this.name, (int)(position.x), ((int)(position.y)));
        //printing grade
        g2d.drawString(Integer.toString(grade), (int)(position.x) + offset, ((int)(position.y)+2*offset) );
        //printing state
        g2d.drawString(state.name, (int)(position.x), ((int)(position.y) + height + offset));
    }

}