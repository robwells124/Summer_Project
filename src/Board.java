import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Board extends JPanel {

    private final int INITIAL_DELAY = 100;
    private final int PERIOD_INTERVAL = 25;

    private Timer timer;

    private Image levelBackground;


    public Board() {

        initBoard();
    }

    private void initBoard() {

        loadImage();

        int w = levelBackground.getWidth(this);
        int h =  levelBackground.getHeight(this);
        setPreferredSize(new Dimension(w, h));

        setDoubleBuffered(true);

        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(),
                INITIAL_DELAY, PERIOD_INTERVAL);
    }

    private void loadImage() {
        ImageIcon ii = new ImageIcon("res/background.png");
        levelBackground = ii.getImage();
    }

    @Override
    public void paintComponent(Graphics g) {

        g.drawImage(levelBackground, 0, 0, null);
    }

    private class ScheduleTask extends TimerTask {

        @Override
        public void run() {

            repaint();
        }
    }

}