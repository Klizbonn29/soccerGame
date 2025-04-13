package soccerHonors;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Ball extends GameObject implements KeyListener{
	int keycode;
	int startX, startY;
	
	public Ball(int x, int y, int speed, String imgName) {
		this.x = x;
		this.startX = x;
		this.y = y;
		this.startY = y;
		this.speed = speed;
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
		if((run == true) && (hit == false)) {
			if((this.keycode == 37) && (this.x > 0)) {
				this.x = this.x - speed;
				this.keycode = 0;
			}
			
			if((this.keycode == 39) && (this.x < 1400)) {
				this.x = this.x + speed;
				this.keycode = 0;
			}
			
			if(this.keycode == 32) {
				run = false;
			}
		}
		
		if((run == false) && (hit == false)) {
			this.y = this.y - speed;
			
			if(this.y <= 50) {
				this.x = startX;
				this.y = startY;
				this.keycode = 0;
				run = true;
			}
			
		}
		
		if(hit == true) {
			this.x = startX;
			this.y = startY;
			this.keycode = 0;
			hit = false;
			run = true;
		}
		
		
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(this.img, this.x, this.y, null);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.print(e.getKeyCode());
		this.keycode = e.getKeyCode();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
