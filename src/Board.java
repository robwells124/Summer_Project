import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Board extends JPanel {

    private final int INITIAL_DELAY = 100;
    private final int PERIOD_INTERVAL = 25;

    private Timer timer;
    public Sprites.Mario mario;
    private Image levelBackground;


    public Board() {

        initBoard();
    }

    private void initBoard() {

        loadImage();

        int w = levelBackground.getWidth(this);
        int h =  levelBackground.getHeight(this);
        setPreferredSize(new Dimension(w, h));
        mario = new Sprites.Mario("res\\MarioStanding.png",12,16);
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
        doDrawing(g);

    }
    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;


        g2d.drawImage(mario.getImage(), mario.getX(),
                mario.getY(), this);
    }

    private class ScheduleTask extends TimerTask {

        @Override
        public void run() {

            repaint();
        }
    }

}