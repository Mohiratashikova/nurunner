import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;
public class Homework extends Assessment {
    public Homework (Common c, Vector2D vector) {
        super (c);
        position = new Vector2D (vector.x, vector.y);
        points = common.randomInt(1,3);
    }
    @Override
    public void draw (Graphics2D g2d) {
        g2d.setPaint(Color.GREEN);
        //draw rect
        g2d.fillRect((int)(position.x), (int)(position.y), width, height);
        g2d.setPaint(Color.BLACK);
        //write points
        g2d.drawString(Integer.toString(points), (int)(position.x) + offset, ((int)(position.y) + 3*offset) );
    }

}