package GameMap;

import java.awt.image.BufferedImage;

public class Tile {
    public BufferedImage image; //This line says each Tile can have an image, like a picture of grass, a road, or a wall.
    public boolean collision = false; //This line sets up a rule for the Tile. If collision is true, it means you can't walk through the Tile (like a wall). If it's false, you can walk through it (like air or grass).
}
