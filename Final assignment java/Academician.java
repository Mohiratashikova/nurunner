import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.Graphics;

public class Academician extends Entity{
    public BufferedImage image;
    public int width = 50;
    public int height = 70;
    public int offset = 10;
    public Vector2D vect;
    public Academician(String name, Common c) {
        super(c);
        try {
            if (name.equals("Nivelle"))    image = ImageIO.read( new File( "HansDeNivelle.gif" ) ) ;
            else if (name.equals("Temizer")) image = ImageIO.read( new File( "SelimTemizer.gif" ) ) ;
            else if (name.equals("Katsu")) image = ImageIO.read( new File( "ShigeoKatsu.gif" ) ) ;
            else image = ImageIO.read( new File( "VassiliosTourassis.gif" ) ) ;
        } catch (IOException e) {
            System.out.println(e);
        }
        this.name = new String (name);
        position = new Vector2D(common.randomInt(0, (common.windowWidth-width)),common.randomInt(0, (common.windowHeight-height)));
        state = new Rest(5, common);
    }

    public void draw (Graphics2D g2d) {
        //draw Image
       g2d.drawImage(image, (int)(position.x), (int)(position.y), width, height, null);
        //write name
       g2d.drawString(this.name, (int)(position.x), ((int)(position.y)));
       //name of the state
       g2d.drawString(this.state.name, (int)(position.x), ((int)(position.y) + height + offset));
    }
    public Assessment createAssessment() {
        int rand = common.randomInt(0, 2);
        double one = (double)(common.randomInt(0, 100));
        double two = (double)(common.randomInt(0, 100));
        vect = new Vector2D((position.x + one), (position.y + two));

        if (rand == 0) {
            return new LabFactory(common).createAssessment(vect); 
        } else if (rand == 1) {
            return new HomeworkFactory(common).createAssessment(vect);
        } else { 
            return new QuizFactory(common).createAssessment(vect);
        } 
    }
}