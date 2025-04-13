package soccerHonors;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Congratulations extends GameObject{
	int tempSpeed;
	
	public Congratulations(int x, int y, int speed, String imgName) {
		this.x = x;
		this.y = y;
		this.speed = speed;
		tempSpeed = speed;
		this.img = loadImage(imgName);
	}
	
	public BufferedImage loadImage(String imgName) {
		File imgFile = new File ("SoccerPNG/" + imgName);
		try {
			return this.img = ImageIO.read(imgFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this.img;
	}

	@Override
	public void update() {
		this.y = this.y - tempSpeed;
		
		if(this.y < 50) {
			tempSpeed = -speed;
		}
		
		if(this.y > 150) {
			tempSpeed = speed;
		}
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(this.img, this.x, this.y, null);
		
	}
}
