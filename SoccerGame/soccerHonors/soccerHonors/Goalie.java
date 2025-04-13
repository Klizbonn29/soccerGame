package soccerHonors;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Goalie extends GameObject{
	int setVal;
	
	public Goalie(int x, int y, int speed, String imgName) {
		this.x = x;
		this.y = y;
		this.speed = speed;
		setVal = speed;
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
		return img;
	}
	
	@Override
	public void update() {
		this.x = this.x + setVal;
		
		if(this.x > 850) {
			setVal = -speed;
		}
		if(this.x < 400) {
			setVal = speed;
		}
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(this.img, this.x, this.y, null);
	}
	
}
