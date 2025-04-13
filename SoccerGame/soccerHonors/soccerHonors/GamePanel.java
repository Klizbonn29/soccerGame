package soccerHonors;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1;
	Dimension dim;
	GameObject [] gameObjects;
	Goal goal;
	Timer gameLoop;
	Boolean before5 = true;
	GameObject [] congrats;
	Color customGreen = new Color(106, 143, 95);
	
	public GamePanel(Dimension dim) {
		super();
		this.dim = dim;
		this.setPreferredSize(dim);
		this.setBackground(customGreen);
		
		goal = new Goal(520, -100, "goal4.png");
		gameObjects = new GameObject[8];
		gameObjects[0] = goal;
		gameObjects[1] = new Goalie(625, 100, 10, "goalKeeper.png");
		gameObjects[2] = new Ball(625, 400, 10, "soccerBall.png");
		gameObjects[3] = new PointsDisplay(50, 80, 100, 100);
		gameObjects[4] = new Fans(0, 200, 8, "fans (1).png");
		gameObjects[5] = new Line (250, 350, 940, 10, Color.white);
		gameObjects[6] = new Line(250, 0, 10, 350, Color.white);
		gameObjects[7] = new Line(1180, 0, 10, 350, Color.white);
		congrats = new GameObject[2];
		congrats [0] = new Congratulations(460, 100, 8, "jeff.png");
		congrats [1] = new CongratsMessage(350, 700);
		
		this.addKeyListener((KeyListener) gameObjects[2]);
		this.setFocusable(true);
		
		gameLoop = new Timer(30, this);
		gameLoop.start();
		
		
	}
	
	public void update() {
		int index;
		
		if (this.before5 == true) {
			if(((gameObjects[1].y + 100) == gameObjects[2].y) && ((gameObjects[1].x - 30) < gameObjects[2].x) && ((gameObjects[1].x + 160) > gameObjects[2].x)) {
				gameObjects[2].hit = true;
			}
			
			if((gameObjects[0].y + 200 == gameObjects[2].y) && ((gameObjects[0].x < gameObjects[2].x)) && ((gameObjects[0].x + 300) > gameObjects[2].x)) {
				gameObjects[3].points++;
				
			}
			
			for(index = 0; index < gameObjects.length; index++) {
				this.gameObjects[index].update();
				
			}
			
			if(gameObjects[3].points == 5) {
				before5 = false;
			}
		}
		
		if(this.before5 == false) {
			for(index = 0; index < congrats.length; index++) {
				congrats[index].update();
			}
		}
	}
	
	public void draw(Graphics g) {
		int index;
		
		if (this.before5 == true) {
			for(index = 0; index < gameObjects.length; index++) {
				this.gameObjects[index].draw(g);
			}
		}
		
		if(this.before5 == false) {
			for(index = 0; index < congrats.length; index++) {
				congrats[index].draw(g);
			}
			
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		this.draw(g);
		Toolkit.getDefaultToolkit().sync();
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.update();
		this.repaint();
		
	}
	
	
	
}
