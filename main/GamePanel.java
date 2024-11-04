package main;

import GameMap.TileManager;
import entity.Player;
import object.SuperObject;

import javax.swing.*;  //import for the screen setting
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{ //GamePanel is a subclass of Jpanel
    //Screen Setting
    public final int originalTileSize = 16;
    public final int scale = 3;
    public final int tileSize = originalTileSize * scale;
    public int maxScreenCol = 16;
    public int maxScreenRow = 12;
    public int screenWidth = maxScreenCol * tileSize;
    public int screenHeight = maxScreenRow * tileSize;

    Thread gameThread; //To repeat a process again and again(keep it running)
    KeyboardInput keyboard = new KeyboardInput();

    //FOR WORLDMAP
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int maxWorldWidth = tileSize * maxWorldCol; //so that the image print jomnoun pon ng
    public final int maxWorldHeight = tileSize * maxWorldRow;


    //FPS
    int fps = 60;

    TileManager tileM = new TileManager(this); //so that we can use Tile from TileManager
    public Player player = new Player(this,keyboard); //so that we can use player and keyboard class from the Player class
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public SuperObject []obj = new SuperObject[10]; //this mean we can display 10 object at the same time in the world




    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight)); //set the size of this class (Jpanel)
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true); //It uses two memory buffers to hold frame data: one visible to the user and another in the background.
        this.addKeyListener(keyboard);
        this.setFocusable(true); //Game panel can be "focus" to recieve key input from keyboard

    }
    public void setUpGame(){
        aSetter.setObject();


    }
    public void startGameThread() { //when we call this the game thread start and then get override
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {  //it override the thread so that the game thread will always run no matter what
        double drawInterval = 1000000000/fps; //  The variable defines how often the game state should be updated and redrawn in nanoseconds, ber ot mean it will be redrawn to the point rub jenh pi screen
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime ;
        long timer = 0; //for show fps
        long drawcount = 0; //for show fps
        while(gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval; //ber delta >=1 mean ney tha the game need to render another frame cause delta ng jg oy yg dg tha how much time has pass since we joch ah key ng and compare vea with drawinterval(del vea brb yg pi how much time that need to pass to update another frame)
            timer += currentTime - lastTime; //how much nano second have pass
            lastTime = currentTime; //derm 3 oy ah last time del yg perform calculation ng kom oy change
            if (delta >= 1) { //we put this cause if the game missed a frame it would just come back down here update and print another frame
                update();
                repaint();
                delta--; //This decrement effectively "consumes" one frame's worth of time from the delta, reducing it below 1 unless the time accumulated was sufficient to trigger multiple frames in one iteration.
                drawcount++; //dg tha vea draw 1 frame

            }
            if(timer >= 1000000000){ //nv pel ah timer ng run ban 1billion nanosecond or equal to 1 second, vea print ah drawcount khang ler ng derm 3 oy dg tha vea draw and update rub ban marn dong knong pel 1 second ng
                System.out.println("FPS: " + drawcount);
                drawcount = 0;
                timer = 0;
            }
            ;


        }

    }
    public void update(){ //y+ = jos krom , x+ = tv sdam
        player.update();


    }
    public void paintComponent(Graphics g){//paintcomponent is a component from java to draw stuff and create stuff
        super.paintComponent(g); //when use paintComponent you need to type this
        Graphics2D g2 = (Graphics2D) g; //it is a better and have more function than Graphics g

        //tile
        tileM.draw(g2); //do this first then player r it will hide the player character and this is to call the tileM from above

        //object
        for(int i = 0; i < obj.length; i++){
            if(obj[i] != null){
                obj[i].draw(g2, this);
            }
        }

        //player

        player.draw(g2);






        g2.dispose(); //dispose any graphic content and releasing any system resources that is using it
    }


}
