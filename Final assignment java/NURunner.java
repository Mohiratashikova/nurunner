import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;


public class NURunner {
    public JFrame window;
    public Display display;
    public Common common;
    public Timer timer;
    public NURunner(boolean bool) {
        window = new JFrame();
        common = new Common(1200, 600);
        display = new Display(common);
        window.setTitle( "NU Runner by Mokhira Atashikova" ) ;
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ) ;
        window.setVisible( bool );
        window.setResizable(false);

        Container cp = window.getContentPane() ;
        cp.setLayout( new FlowLayout() ) ;
        
        cp.add(display);
        
        timer = new Timer(40, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            common.stepAllEntities();
            display.repaint();
        }
        });
        
        timer.start();    
        window.pack();
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater( new Runnable() {
                                        public void run () {
                                            new NURunner(true);
                                        }
        } ) ;
    }
}