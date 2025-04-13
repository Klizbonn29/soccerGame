package soccerHonors;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends GameObject{
	int width, height;
	Color color;
	
	public Line (int x, int y, int width, int height, Color color) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(this.color);
		g.fillRect(this.x, this.y, this.width, this.height);
		
	}
	
}
