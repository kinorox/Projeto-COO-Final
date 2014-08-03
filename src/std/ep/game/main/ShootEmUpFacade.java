package std.ep.game.main;

import java.util.ArrayList;

import std.ep.game.elements.background.Background;
import std.ep.game.elements.enemy.Enemy;
import std.ep.game.elements.enemy.Enemy1;
import std.ep.game.elements.enemy.Enemy2;
import std.ep.game.elements.player.Player;
import std.ep.game.elements.projectile.Projectile;
import std.ep.game.lib.GameLib;

public class ShootEmUpFacade {

	private ArrayList<Enemy> enemy1;
	private ArrayList<Enemy> enemy2;
	private ArrayList<Enemy> enemy3;
	
	private ArrayList<Background> primaryBG;
	private ArrayList<Background> secondaryBG;
	
	private ArrayList<Projectile> e_projectile;
	private ArrayList<Projectile> projectile;
	
	private Player p;
	
	public void execute(){

		long delta;
		long currentTime = System.currentTimeMillis();
		
		//inicializacao
		Player p = new Player(currentTime);
		p.setState(1); //active
		
		projectile = initializeProjectile(10, 1.0);
		e_projectile = initializeProjectile(200, 2.0);
		enemy1 = initializeEnemy();
		enemy2 = initializeEnemy();
		primaryBG = initializeBackground(20, 0.070);
		secondaryBG = initializeBackground(50, 0.045);
		
		GameLib.initGraphics();
		
	}
	
	private ArrayList<Projectile> initializeProjectile(int size, double radius){
		ArrayList<Projectile> p = new ArrayList<>(size);
		
		for(int i = 0; i<=size; i++){
			Projectile pj = new Projectile(radius);
			pj.setActive(false);
			
			p.add(pj);
		}
		
		return p;
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
	
}
