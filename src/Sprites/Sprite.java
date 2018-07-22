package Sprites;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;


public class Sprite {

    private int x;
    private int y;
    private int width;
    private int height;
    private Image image;

    public Sprite() {
        this.x = 0;
        this.y = 0 ;
    }
    public Sprite(String img,int x, int y){
        loadImage(img);
        this.x = x;
        this.y = y;
    }
    private void loadImage(String img) {
        ImageIcon ii = new ImageIcon(img);
        image = ii.getImage();

        width = image.getWidth(null);
        height = image.getHeight(null);
    }

    public void setX(int x){
        this.x =x;
    }
    public void setY(int y){
        this.y =y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public  int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }

    //used for collision detection
    public Rectangle getBounds(){
        return new Rectangle(x, y, width, height);
    }

    public Image getImage() {
        return image;
    }

}
