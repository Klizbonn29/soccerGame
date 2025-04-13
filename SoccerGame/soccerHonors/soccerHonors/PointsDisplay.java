package soccerHonors;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class PointsDisplay extends GameObject{
	int rectX, rectY, rectWidth, rectHeight;
	public PointsDisplay(int x, int y, int width, int height) {
		this.x = x + 50;
		this.y = y + 10;
		this.rectWidth = width;
		this.rectHeight = height;
		this.rectX = 12 + 50;
		this.rectY = 18 + 10;
	}
	
	@Override
	public void update() {
		
	}

	@Override
	public void draw(Graphics g) {
		Color newC = new Color(106, 143, 95);
		g.setColor(custom);
		g.fillRoundRect(rectX, rectY, rectWidth, rectHeight, 50, 50);
		g.setColor(newC);
		g.setFont(new Font("Rooster", 80, 40));
		g.drawString(Integer.toString(points), this.x, this.y);
		
	}
	
}
