package GameMap;

import main.GamePanel;

import javax.imageio.ImageIO; //This allows TileManager to use tools for reading images, so it can show pictures on your tiles.
import java.awt.*; //This brings in a toolkit for building the graphical parts of your game, like drawing images or shapes.
import java.io.BufferedReader;
import java.io.IOException; //This is for handling errors that might happen when reading files, like your tile images.
import java.io.InputStream; //This is not explicitly used in the provided code but generally helps in reading data, like image files, from various sources.
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gamePanel; //A variable to keep a reference to the game's main panel which might hold settings and functions needed by TileManager.
    public Tile[] tile; //This is an array to hold all the different types of tiles the game might use, like earth, water, or floor tiles.
    public int mapTileNum [][];




    public TileManager(GamePanel gamePanel) { //This is the constructor, a special function that sets up a new TileManager. It needs a GamePanel to work properly.
        this.gamePanel = gamePanel; //This line saves the GamePanel passed in so it can be used later.
        tile = new Tile [35]; //Sets up space for 10 tiles in the tile array. //the tile array is like your box of colored pencils, helping you organize and reuse them efficiently as you draw your game world.
        mapTileNum = new int[gamePanel.maxWorldCol][gamePanel.maxWorldRow];


        getTileImage();
        loadTileImage();
    }
    public void getTileImage(){
        try {
            tile[0] = new Tile (); //Creates a new Tile and puts it in the first slot of the array.
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/rubTile/earth.png")); //Reads an image file named earth.png and puts that image in the first tile.

            tile [1] = new Tile ();
            tile [1].image = ImageIO.read(getClass().getResourceAsStream("/rubTile/floor01.png"));

            tile [2] = new Tile ();
            tile [2].image = ImageIO.read(getClass().getResourceAsStream("/rubTile/water00.png"));

            tile [3] = new Tile ();
            tile [3].image = ImageIO.read(getClass().getResourceAsStream("/rubTile/grass00.png"));

            tile [4] = new Tile ();
            tile [4].image = ImageIO.read(getClass().getResourceAsStream("/rubTile/grass01.png"));

            tile [5] = new Tile ();
            tile [5].image = ImageIO.read(getClass().getResourceAsStream("/rubTile/hut.png"));

            tile [6] = new Tile ();
            tile [6].image = ImageIO.read(getClass().getResourceAsStream("/rubTile/road00.png"));

            tile [7] = new Tile ();
            tile [7].image = ImageIO.read(getClass().getResourceAsStream("/rubTile/road01.png"));

            tile [8] = new Tile ();
            tile [8].image = ImageIO.read(getClass().getResourceAsStream("/rubTile/road02.png"));

            tile [9] = new Tile ();
            tile [9].image = ImageIO.read(getClass().getResourceAsStream("/rubTile/road03.png"));

            tile [10] = new Tile ();
            tile [10].image = ImageIO.read(getClass().getResourceAsStream("/rubTile/road04.png"));

            tile [11] = new Tile ();
            tile [11].image = ImageIO.read(getClass().getResourceAsStream("/rubTile/road05.png"));

            tile [12] = new Tile ();
            tile [12].image = ImageIO.read(getClass().getResourceAsStream("/rubTile/road06.png"));

            tile [13] = new Tile ();
            tile [13].image = ImageIO.read(getClass().getResourceAsStream("/rubTile/road07.png"));

            tile [14] = new Tile ();
            tile [14].image = ImageIO.read(getClass().getResourceAsStream("/rubTile/road08.png"));

            tile [15] = new Tile ();
            tile [15].image = ImageIO.read(getClass().getResourceAsStream("/rubTile/road09.png"));

            tile [16] = new Tile ();
            tile [16].image = ImageIO.read(getClass().getResourceAsStream("/rubTile/road10.png"));

            tile [17] = new Tile ();
            tile [17].image = ImageIO.read(getClass().getResourceAsStream("/rubTile/road11.png"));

            tile [18] = new Tile ();
            tile [18].image = ImageIO.read(getClass().getResourceAsStream("/rubTile/road12.png"));

            tile [19] = new Tile ();
            tile [19].image = ImageIO.read(getClass().getResourceAsStream("/rubTile/table01.png"));

            tile [20] = new Tile ();
            tile [20].image = ImageIO.read(getClass().getResourceAsStream("/rubTile/tree.png"));

            tile [21] = new Tile ();
            tile [21].image = ImageIO.read(getClass().getResourceAsStream("/rubTile/wall.png"));
            tile[21].collision = true;

            tile [22] = new Tile ();
            tile [22].image = ImageIO.read(getClass().getResourceAsStream("/rubTile/water01.png"));

            tile [23] = new Tile ();
            tile [23].image = ImageIO.read(getClass().getResourceAsStream("/rubTile/water02.png"));

            tile [24] = new Tile ();
            tile [24].image = ImageIO.read(getClass().getResourceAsStream("/rubTile/water03.png"));

            tile [25] = new Tile ();
            tile [25].image = ImageIO.read(getClass().getResourceAsStream("/rubTile/water04.png"));

            tile [26] = new Tile ();
            tile [26].image = ImageIO.read(getClass().getResourceAsStream("/rubTile/water05.png"));

            tile [27] = new Tile ();
            tile [27].image = ImageIO.read(getClass().getResourceAsStream("/rubTile/water06.png"));

            tile [28] = new Tile ();
            tile [28].image = ImageIO.read(getClass().getResourceAsStream("/rubTile/water07.png"));

            tile [29] = new Tile ();
            tile [29].image = ImageIO.read(getClass().getResourceAsStream("/rubTile/water08.png"));

            tile [30] = new Tile ();
            tile [30].image = ImageIO.read(getClass().getResourceAsStream("/rubTile/water09.png"));

            tile [31] = new Tile ();
            tile [31].image = ImageIO.read(getClass().getResourceAsStream("/rubTile/water10.png"));

            tile [32] = new Tile ();
            tile [32].image = ImageIO.read(getClass().getResourceAsStream("/rubTile/water11.png"));

            tile [33] = new Tile ();
            tile [33].image = ImageIO.read(getClass().getResourceAsStream("/rubTile/water12.png"));

            tile [34] = new Tile ();
            tile [34].image = ImageIO.read(getClass().getResourceAsStream("/rubTile/water13.png"));





        }
        catch (IOException e){
            e.printStackTrace();
        }


    }

    public void loadTileImage(){
        try {
            InputStream is = getClass().getResourceAsStream("/Map/Test.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is)); //read the string in the text
            int col = 0;
            int row = 0;

            while (col < gamePanel.maxWorldCol && row < gamePanel.maxWorldRow) {
                String line = br.readLine(); //make the string readable
                while (col < gamePanel.maxWorldCol) {
                    String[] numbers = line.split(" "); //read one line and space and then read the other line
                    int num = Integer.parseInt(numbers[col]); //convert the string into int
                    mapTileNum[col][row] = num;
                    col++;

                }
                if (col == gamePanel.maxWorldCol) {
                    col = 0;
                    row++;
                }

            }
            br.close();



        }catch (Exception e){

        }
    }
    public void draw(Graphics2D g2){
        int worldCol = 0;
        int worldRow = 0;
        while (worldCol < gamePanel.maxWorldCol && worldRow < gamePanel.maxWorldRow){ //max screen 16
            int tileNum = mapTileNum[worldCol][worldRow];
            int worldX = worldCol * gamePanel.tileSize; //postion on the map
            int worldY = worldRow * gamePanel.tileSize;
            int screenX = worldX - gamePanel.player.worldX + gamePanel.player.screenX; //position on the screen as we draw it
            int screenY = worldY - gamePanel.player.worldY + gamePanel.player.screenY;

            if (worldX + gamePanel.tileSize > gamePanel.player.worldX - gamePanel.player.screenX && worldX - gamePanel.tileSize < gamePanel.player.worldX + gamePanel.player.screenX &&
                    worldY + gamePanel.tileSize > gamePanel.player.worldY - gamePanel.player.screenY && worldY - gamePanel.tileSize < gamePanel.player.worldY + gamePanel.player.screenY) {
                g2.drawImage(tile[tileNum].image,screenX,screenY, gamePanel.tileSize, gamePanel.tileSize, null);
            }

            worldCol++;

            if (worldCol == gamePanel.maxWorldCol){
                worldCol = 0; //reset ah klaeng print rub

                worldRow++;

            }


        }
    }
}
