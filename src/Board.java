import Sprites.Sprite;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.util.*;

public class Board extends JPanel {

    private final int INITIAL_DELAY = 100;
    private final int PERIOD_INTERVAL = 25;

    private Timer timer;
    public Sprites.Mario mario;
    private Image levelBackground;
    public Map<Coordinate, Boolean> terrain = new HashMap<>(); //check tiles surrounding mario
    public List<Sprite> onScreenEnemies = new ArrayList<>(); //




    public Board() {

        initBoard();
    }

    private void initBoard() {

        loadImage();
        addKeyListener(new TAdapter());
        setFocusable(true);
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
    public void paintComponent(Graphics g) { //is called with repaint() in ScheduleTask
        super.paintComponent(g);
        g.drawImage(levelBackground, 0, 0, null);
        drawMario(g);
        //System.out.println(mario.getX());
    }
    private void drawMario(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;


        g2d.drawImage(mario.getImage(), mario.getX(),
                mario.getY(), this);
        //System.out.println("drawMario");
    }

    private class ScheduleTask extends TimerTask {

        @Override
        public void run() {
            mario.moving();
            //System.out.println(mario.getX());
            repaint();
        }
    }
    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            mario.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            //System.out.println("PRESSED");
            mario.keyPressed(e);
        }
    }

}