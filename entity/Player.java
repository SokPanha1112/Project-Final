package entity;

import main.GamePanel;
import main.KeyboardInput;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends Entity {
    GamePanel gamePanel;
    KeyboardInput keyboard;

    public final int screenX; //so the screen dont change place
    public final int screenY;


    public Player(GamePanel gamePanel , KeyboardInput keyboard) {  //This allows the Player object to have access to both the game’s display (or logic) and the player’s keyboard inputs, which are necessary to control the player’s actions in the game.
        this.gamePanel = gamePanel;
        this.keyboard = keyboard;
        screenX = gamePanel.screenWidth /2 - (gamePanel.tileSize / 2); //IF OT DOK TILESIZE/2, THE PROBLEM IS THAT VEA KIT THA RUB NG NV MIDDLE TAE PEL PRINT TV IT IS NOT ACTUALLY MIDDLE CAUSE THE DOT THAT COMPUTER KIT NG IS IN THE MIDDLE TAE PEL PRINT RUB TV RUB NG NV KHANG JONG JIT DOT NG
        screenY = gamePanel.screenHeight /2 - (gamePanel.tileSize / 2);

        solidArea = new Rectangle();//hitbox
        solidArea.x = 8;
        solidArea.y = 16;
        solidArea.width = 32;
        solidArea.height = 32;

        setDefaultValue(); //derm 3 oy vea run ah setDefaultvalue krom ng
        getPlayerImage();


    }

    public void setDefaultValue() { //player location and speed
        worldX= gamePanel.tileSize * 23; //oy nv kdal pel create map thom
        worldY= gamePanel.tileSize * 21;
        speed=12;
        direction = "up"; //any direction is fine
    }
    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/rubPlayer/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/rubPlayer/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/rubPlayer/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/rubPlayer/boy_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/rubPlayer/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/rubPlayer/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/rubPlayer/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/rubPlayer/boy_right_2.png"));

        }
        catch (IOException e){ //. The IOException is a type of error in Java that occurs when there is a problem with input or output operations, typically when you are trying to read or write files, or if there is a network communication error. By writing catch (IOException e), you are telling the program, "If an IOException occurs, then handle it using the code inside this block."
            e.printStackTrace(); //It prints a report of the methods that were called at the time the error occurred.
        }
    }
    public void update() {
        if (keyboard.upPressed == true || keyboard.downPressed == true ||
                keyboard.rightPressed == true || keyboard.moveLeft == true) { //add ah ng dak condition tol tah joch keyboard ban vea run loop and make animation
            if (keyboard.upPressed == true) {
                direction = "up";

            } else if (keyboard.downPressed == true) {
                direction = "down";

            } else if (keyboard.rightPressed == true) {
                direction = "right";

            } else if (keyboard.moveLeft == true) {
                direction = "left";

            }
            //Check Tile Collision
            collisionOn = false;
            gamePanel.cChecker.checkTile(this);

            //If collision is false, plauer can move
            if (collisionOn == false) {
                switch (direction) {
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                }
            }

            spriteCounter++;
            if (spriteCounter > 12) { //this get update every 12 frame
                if (spriteNumber == 1) {
                    spriteNumber = 2;
                } else if (spriteNumber == 2) {
                    spriteNumber = 1;
                }
                spriteCounter = 0; //this is just to reset and loop it again
            }

        }

    }
    public void draw(Graphics2D g2) { //dont forget to pass the Graphics2D so that we can use all of it function and draw
        BufferedImage image =null; //null; as a "clean slate" means starting with nothing in the variable. By initializing it to null, you ensure that it starts fresh and only contains what you explicitly assign to it afterward.

        switch(direction){
            case "up":
                if (spriteNumber ==1){
                    image = up1;
                }
                if (spriteNumber ==2){
                    image = up2;
                }
                break;
            case "down":
                if (spriteNumber ==1){
                    image = down1;
                }
                if (spriteNumber ==2){
                    image = down2;
                }
                break;
            case "right":
                if (spriteNumber ==1){
                    image = right1;
                }
                if (spriteNumber ==2){
                    image = right2;
                }
                break;
            case "left":
                if (spriteNumber ==1){
                    image = left1;
                }
                if (spriteNumber ==2){
                    image = left2;
                }
                break;
        }
        g2.drawImage(image,screenX,screenY, gamePanel.tileSize, gamePanel.tileSize, null); //draw an image on screen. This ImageObserver is used to get notifications about the image as it is being drawn or loaded. However, in the code you provided, this isn't necessary because the image is already loaded and doesn't need to be monitored while it's being drawn.
    }

}
