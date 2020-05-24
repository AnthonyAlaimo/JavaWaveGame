package gameStuff;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
//Our player class, where we set the features of our player
//THE SPEED BOSS
public class Boss2 extends GameObject{
	
	
	Random num = new Random();
	Handler handler;
	//dimension variables for the player
	private int width = 32;
	private int height = 32;
	
	
	public Boss2(int positionX, int positionY, int width, int height, ID id, Handler handler) {
		super(positionX, positionY, width, height, id);
		//pass in the handler for the game and set our player handler equal to it
		//now our player handler can be referenced and used to find any object in our game
		this.handler = handler;
		//velX = num.nextInt(5) + 1;
		//velY = num.nextInt(5);
		
	
	}
	//method used for collision of objects, returns true when rectangles come in contact
	public Rectangle getBounds() {
		//overlaps with Player parameters
		return new Rectangle(positionX, positionY, width, height);
	}
	public void tick() {
		positionX += velX;
		positionY += velY;
		//bounding player2 within our JFrame window
		positionX=Game.clamp(positionX, 0, Game.WIDTH - 34);
		positionY=Game.clamp(positionY, 0, Game.HEIGHT - 56);
		collision();
	}
	
	private void collision() {
		for(int CurrentObject = 0; CurrentObject < handler.object.size(); CurrentObject++) {
			//set a temporary variable which gets the ID of the current variable and makes it run
			//updates all the game objects
			//this is for collision between the player and enemy objects enemy objects
			GameObject EnemyObject = handler.object.get(CurrentObject);
			if (EnemyObject.getID() == ID.Player || EnemyObject.getID() == ID.Player2 || 
					EnemyObject.getID() == ID.Player3 || EnemyObject.getID() == ID.Player4) {
				if(getBounds().intersects(EnemyObject.getBounds())) {
					if ((HUD2.HEALTH - 5) < 0) {
						HUD2.HEALTH = 0;
					}else {
						HUD2.HEALTH -= 5;
					}
				}
			}
		}
	}
	
	
	public void render(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(positionX, positionY, width, height);
		//this.g = g;
	}
}

