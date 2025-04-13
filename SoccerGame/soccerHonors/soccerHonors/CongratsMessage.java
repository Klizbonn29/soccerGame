package soccerHonors;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class CongratsMessage extends GameObject{

	public CongratsMessage(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(custom);
		g.setFont(new Font("Comic Sans", Font.PLAIN, 40));
		g.drawString("Congrats, you have won Jeff the Shark :)", this.x, this.y);
		
	}

}
