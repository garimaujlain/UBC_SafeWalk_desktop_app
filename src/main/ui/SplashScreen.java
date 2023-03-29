package ui;

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SplashScreen extends JFrame {

    public SplashScreen() {
        setSize(500, 300);
        setLayout(null);
        setUndecorated(true);
        setLocation(500, 500);
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
        new MainFrame().setVisible(true);
        dispose();
    }

    public static void main(String[] args) throws ClassNotFoundException {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            new SplashScreen();

        } catch (InstantiationException ex) {
            Logger.getLogger(SplashScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SplashScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(SplashScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}