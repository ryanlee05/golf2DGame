package Object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import golf.KeyHandler;
import golf.gamePanel;

public class Clubs {
	gamePanel gp;
	KeyHandler keyH;
	BufferedImage[] clubImages = new BufferedImage[4];
	BufferedImage[] hImages = new BufferedImage[4];
	public String[] clubNames = {"Driver", "Iron", "Wedge", "Putter"};

	public int currentIndex = 0;
	int x, y;
	boolean qPressedLastFrame = false;
	boolean ePressedLastFrame = false;

	public Clubs(gamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		this.x = 15 + gp.tileSize / 2;
		this.y = gp.screenHeight - gp.tileSize;
		try {
			clubImages[0] = ImageIO.read(getClass().getResourceAsStream("/clubs/Driver.png"));
			clubImages[1] = ImageIO.read(getClass().getResourceAsStream("/clubs/Iron.png"));
			clubImages[2] = ImageIO.read(getClass().getResourceAsStream("/clubs/Wedge.png"));
			clubImages[3] = ImageIO.read(getClass().getResourceAsStream("/clubs/Putter.png"));
			hImages[0] = ImageIO.read(getClass().getResourceAsStream("/clubs/Driver_h.png"));
			hImages[1] = ImageIO.read(getClass().getResourceAsStream("/clubs/Iron_h.png"));
			hImages[2] = ImageIO.read(getClass().getResourceAsStream("/clubs/Wedge_h.png"));
			hImages[3] = ImageIO.read(getClass().getResourceAsStream("/clubs/Putter_h.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void update() {
		if (gp.golfBall.playerReady && !gp.golfBall.hitInProgress) {
			if (keyH.qPressed && !qPressedLastFrame) {
				gp.playSoundEffect(4);
				currentIndex = (currentIndex - 1 + clubImages.length) % clubImages.length;
				
				
			}

			if (keyH.ePressed && !ePressedLastFrame) {
				gp.playSoundEffect(3);
				currentIndex = (currentIndex + 1) % clubImages.length;
			}
			
			if(currentIndex == 0) {
				gp.golfBall.club = "driver";
			}
			else if(currentIndex == 1) {
				gp.golfBall.club = "iron";
			}
			else if (currentIndex == 2) {
				gp.golfBall.club = "wedge";
			}
			else {
				gp.golfBall.club = "putter";
			}

			qPressedLastFrame = keyH.qPressed;
			ePressedLastFrame = keyH.ePressed;
		}

	}
	
	public void draw(Graphics2D g2) {
		int size = gp.tileSize;
		int smallSize = size / 2 + 10;

		int prevIndex = (currentIndex - 1 + clubImages.length) % clubImages.length;
		int nextIndex = (currentIndex + 1) % clubImages.length;

		if (gp.golfBall.playerReady) {
			g2.drawImage(clubImages[prevIndex], x - size / 2 - 10, y + gp.tileSize / 4 - 50, smallSize + 50,
					smallSize + 50, null);

			g2.drawImage(hImages[currentIndex], x + 50, y - 50, size + 50, size + 50, null);

			g2.drawImage(clubImages[nextIndex], x + size + 100, y + gp.tileSize / 4 - 50, smallSize + 50,
					smallSize + 50, null);
		}

	}
}