import Sprites.Mario;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    private Image bardejov;
    private Mario mario;

    public Board() {

        initBoard();
    }

    private void initBoard() {

        loadImage();

        int w = bardejov.getWidth(this);
        int h =  bardejov.getHeight(this);
        setPreferredSize(new Dimension(w, h));
        mario = new Mario("res\\MarioStanding.png",12,16);
    }

    private void loadImage() {
        ImageIcon ii = new ImageIcon("res/background.png");
        bardejov = ii.getImage();
    }

    @Override
    public void paintComponent(Graphics g) {

        g.drawImage(bardejov, 0, 0, null);
        doDrawing(g);
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(mario.getImage(), mario.getX(),
                mario.getY(), this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }
}