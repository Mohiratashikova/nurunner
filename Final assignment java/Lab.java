import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;

public class Lab extends Assessment {
    public Lab (Common c, Vector2D vector) {
        super(c);
        position = new Vector2D (vector.x, vector.y);
        points = common.randomInt(2, 4);
    }
    @Override
    public void draw (Graphics2D g2d) {
        g2d.setPaint(Color.RED);
        //draw circle
        g2d.fillOval((int)(position.x), (int)(position.y), width, height);
        g2d.setPaint(Color.BLACK);
        //write points
        g2d.drawString(Integer.toString(points), (int)(position.x) + offset, ((int)(position.y) + 3*offset) );
    }
}