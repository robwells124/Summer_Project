package Sprites;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;


public class Mario extends Sprite {

    private int dx;
    private int dy;
    //private int x;
    //private int y;
    private int w=12;
    private int h=16;
    private Image image;


    public Mario(String img,int x, int y){
        super( img,x, y);
        loadImage();
    }
    private void loadImage() {

        ImageIcon ii = new ImageIcon("res/MarioStanding.png");
        image = ii.getImage();

        w = image.getWidth(null);
        h = image.getHeight(null);
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            dx = -2;
        }

        if (key == KeyEvent.VK_RIGHT) {
            //System.out.println("YES");
            dx = 2;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -2;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 2;
        }
    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
    public void moving(){
        setX(getX() + dx);
        setY(getY() + dy);
        //System.out.println(x);
        //System.out.println(y );
    }
}
