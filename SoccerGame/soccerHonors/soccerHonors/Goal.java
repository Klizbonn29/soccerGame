package soccerHonors;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Goal extends GameObject {
	
	public Goal(int x, int y, String imgName) {
		this.x = x;
		this.y = y;
		try {
			this.img = loadImage(imgName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public BufferedImage loadImage(String imgName) throws IOException {
		File imageFile = new File("SoccerPNG/" + imgName);
		return this.img = ImageIO.read(imageFile);
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics g) {
		
		g.drawImage(this.img, this.x, this.y, null);
		
	}
}
