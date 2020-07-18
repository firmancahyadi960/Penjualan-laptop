package icon;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import javax.swing.JDesktopPane;

public class DesktopPaneImage extends JDesktopPane {

    private Image img;

    public DesktopPaneImage() {
        try {
            img = Toolkit.getDefaultToolkit().getImage(getClass().
                    getResource("service-laptop-800x563w.jpg"));

            MediaTracker media = new MediaTracker(this);
            media.addImage(img, 0);
            try {
                media.waitForID(0);
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }

}
