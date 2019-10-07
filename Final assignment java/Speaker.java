import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.Graphics;

public class Speaker extends Entity {
    public BufferedImage image;
    public int width = 50;
    public int height = 70;
    public Speaker(String name, Common c) {
        super(c);
        try {
            if (name.equals("Nazarbayev"))    image = ImageIO.read( new File( "NursultanNazarbayev.gif" ) ) ;
            else image = ImageIO.read( new File( "KassymJomartTokayev.gif" ) ) ;
        } catch (IOException e) {
            System.out.println(e);
        }
        this.name = new String (name);
        //initialization only to create a pointer
        position = new Vector2D(0,0);
        state = new Stationary(common);
    }
    public void draw (Graphics2D g2d) {
       g2d.drawImage(image, (int)(position.x), (int)(position.y), width, height, null);
       g2d.drawString(this.name, (int)(position.x), (int)(position.y));
    }
}