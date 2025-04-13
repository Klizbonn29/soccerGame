package soccerHonors;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class GameObject {
	int x, y;
	int speed;
	int points = 0;
	BufferedImage img;
	Boolean run = true;
	Boolean hit = false;
	Boolean fire = false;
	Color custom = new Color (199, 203, 130);
	
	public abstract void update();
	public abstract void draw(Graphics g);
	
}
