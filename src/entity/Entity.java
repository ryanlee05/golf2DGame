package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
    public int worldX, worldY;

    public int speed;

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2,
        setDriver, setIron, setWedge, setPutter, bsDriver, bsIron, bsWedge,
        bsPutter, finishDriver, finishIron, finishWedge, finishPutter;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 2;

    public boolean moving = false;

    public Rectangle solidArea;

    public int solidAreaDefaultX, solidAreaDefaultY;

    public boolean collisionOn = false;

    public String collisionDirection = "none";
}
