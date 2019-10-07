import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;


public class Quiz extends Assessment {
    public Quiz (Common c, Vector2D vector) {
        super(c);
        position = new Vector2D (vector.x, vector.y);
        points = common.randomInt(3, 5);
    }
    @Override
    public void draw (Graphics2D g2d) {
        g2d.setPaint(Color.BLUE);
        //draw triangle
        g2d.fillPolygon(new int[] {(int)(position.x+width/2), (int)(position.x), (int)(position.x+width)}, new int[] {(int)(position.y), (int)(position.y+height), (int)(position.y+height)}, 3);
        g2d.setPaint(Color.BLACK);
        //write points
        g2d.drawString(Integer.toString(points), (int)(position.x) + offset, ((int)(position.y) + 3*offset) );
    }
}