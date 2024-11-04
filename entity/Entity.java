package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    public int worldX,worldY;
    public int speed;
    public BufferedImage up1, down1, left1, right1, up2, down2, left2, right2; //we use this to store our image files
    public String direction; //String is used to store text. It's like a container where you can keep words or sentences so that your program can work with them.
    public int spriteCounter= 0;
    public int spriteNumber = 1;
    public Rectangle solidArea;
    public boolean collisionOn = false;



}
