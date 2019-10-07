import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;


public class Display extends JPanel {
    public Common common;
    
    public Display(Common obj) {
        common = obj;
    }
    @Override public Dimension getPreferredSize() {
        return new Dimension( common.windowWidth , common.windowHeight ) ;
    }
    @Override public void paintComponent (Graphics g){
        super.paintComponent( g ) ;

        Graphics2D g2d = (Graphics2D) g ;
        common.drawAllEntities(g2d);
    }
}