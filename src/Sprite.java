import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;


public class Sprite {

    private int x;
    private int y;
    private int w;
    private int h;
    private Image image;

    public Sprite(String img,int x, int y){
        loadImage(img);
        this.x = x;
        this.y = y;
    }
    private void loadImage(String img) {
        ImageIcon ii = new ImageIcon(img);
        image = ii.getImage();

        w = image.getWidth(null);
        h = image.getHeight(null);
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
        return w;
    }
    public int getHeight(){
        return  h;
    }

    public Image getImage() {
        return image;
    }

}
