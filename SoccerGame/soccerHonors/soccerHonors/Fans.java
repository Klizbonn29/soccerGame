package soccerHonors;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Fans extends GameObject {
	int speedVal;
	public Fans(int x, int y, int speed, String imgName) {
		this.x = x;
		this.y = y;
		this.speed = -speed;
		speedVal = speed;
		this.img = loadImage(imgName);
	}
	
	public BufferedImage loadImage(String imgName) {
		File imgFile = new File("SoccerPNG/" + imgName);
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
		
		if(fire == false) {
			this.y = this.y - speedVal;
		}
		
		if(this.y < 150) {
			speedVal = this.speed;
		}
		
		if(this.y > 250) {
			speedVal = -this.speed;
		}
		
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(this.img, this.x, this.y, null);
		
	}

}
