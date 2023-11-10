package ui;

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;


// Defining the SplashScreen class which extends the JFrame class

public class SplashScreen extends JFrame {

    public SplashScreen() {
        setSize(500, 300);
        setLayout(null);
        setUndecorated(true);
        setLocation(500, 500);

        // Creating a JLabel and setting its image to a logo
        JLabel splashLabel = new JLabel(new ImageIcon("logo.png"));
        splashLabel.setSize(getSize());
        splashLabel.setLocation(0, 0);

        add(splashLabel);

        setVisible(true);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Creating an instance of the MainFrame class and making it visible
        new MainFrame().setVisible(true);
        dispose();
    }


    // Main method of the SplashScreen class
    public static void main(String[] args) throws ClassNotFoundException {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }

            // Creating an instance of the SplashScreen class
            new SplashScreen();

            // Catching and logging exceptions related to setting the look and feel
        } catch (InstantiationException ex) {
            Logger.getLogger(SplashScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SplashScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(SplashScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}