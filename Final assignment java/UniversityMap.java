import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.Graphics;


public class UniversityMap extends Entity {
    public BufferedImage image;
    public int width;
    public int height;
    
    public UniversityMap (int width, int height, Common c) {
        super(c);
        this.width = width;
        this.height = height;
        try {
            image = ImageIO.read( new File( "NUMap-Faded.jpg" ) ) ;
        } catch (IOException e) {
            System.out.println(e);
        }
        position = new Vector2D(0,0);
        state = new Stationary(common);
    }
    
    public void draw (Graphics2D g2d) {
      
       g2d.drawImage(image, 0, 0, width, height, null);
    }
}