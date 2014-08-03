package std.ep.game.elements.facade;

import java.util.ArrayList;

import std.ep.game.elements.background.Background;
import std.ep.game.elements.enemy.Enemy;
import std.ep.game.elements.enemy.Enemy1;
import std.ep.game.elements.enemy.Enemy2;
import std.ep.game.elements.player.Player;
import std.ep.game.elements.projectile.Projectile;
import std.ep.game.lib.GameLib;

public class ElementsFacade {

	private ArrayList<Enemy> enemy1;
	private ArrayList<Enemy> enemy2;
	private ArrayList<Enemy> enemy3;
	private ArrayList<Background> primaryBG;
	private ArrayList<Background> secondaryBG;
	private Player p;
	
	public void initializeElements(){

		long delta;
		long currentTime = System.currentTimeMillis();
		
		//inicializacao
		Player p = new Player(currentTime);
		p.setState(1); //active

		enemy1 = initializeEnemy();
		enemy2 = initializeEnemy();
		primaryBG = initializeBackground(20, 0.070);
		secondaryBG = initializeBackground(50, 0.045);
		
		GameLib.initGraphics();
		
	}

	private ArrayList<Background> initializeBackground(int size, double speed) {
		ArrayList<Background> bg = new ArrayList<>(size);
		
		for(int i = 0; i<=size; i++){
			Background b = new Background();
			b.setSpeed(speed);
			b.setxCoord(Math.random() * GameLib.WIDTH);
			b.setyCoord(Math.random() * GameLib.HEIGHT);
			bg.add(b);
		}
		
		return bg;
	}

	private ArrayList<Enemy> initializeEnemy() {
		ArrayList<Enemy> en = new ArrayList<>(10);
		
		for(int i = 0; i<=10; i++) {
			Enemy e = new Enemy1(System.currentTimeMillis());
			e.setStates(0); //inactive
			en.add(e);
		}
		
		return en;
	}
	
	public static void busyWait(long time){
		
		while(System.currentTimeMillis() < time) Thread.yield();
	}

	public ArrayList<Enemy> getEnemy1() {
		return enemy1;
	}

	public ArrayList<Enemy> getEnemy2() {
		return enemy2;
	}

	public ArrayList<Enemy> getEnemy3() {
		return enemy3;
	}

	public ArrayList<Background> getPrimaryBG() {
		return primaryBG;
	}

	public ArrayList<Background> getSecondaryBG() {
		return secondaryBG;
	}

	public Player getP() {
		return p;
	}
	
}
