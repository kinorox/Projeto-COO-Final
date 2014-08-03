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
	
	private ArrayList<Background> primary;
	private ArrayList<Background> secondary;
	
	private Projectile projectile_e1;
	private Projectile projectile_e2;
	private Projectile projectile_e3;
	
	private Player p;
	
	public void execute(){

		long delta;
		long currentTime = System.currentTimeMillis();
		
		//inicializacao
		enemy1 = initializeEnemy();
		enemy2 = initializeEnemy();
		
		primary = new ArrayList<>(20);
		for(int i = 0; i<primary.size(); i++){
			Background b = new Background();
			b.setxCoord(Math.random() * GameLib.WIDTH);
			b.setyCoord(Math.random() * GameLib.HEIGHT);
			primary.add(b);
		}
		
		secondary = new ArrayList<>(50);
		for(int i = 0; i<secondary.size(); i++){
			Background b = new Background();
			b.setxCoord(Math.random() * GameLib.WIDTH);
			b.setyCoord(Math.random() * GameLib.HEIGHT);
			secondary.add(b);
		}
		
	}

	private ArrayList<Enemy> initializeEnemy() {
		ArrayList<Enemy> en = new ArrayList<>(10);
		
		for(int i = 0; i<enemy1.size(); i++) {
			Enemy e = new Enemy1(System.currentTimeMillis());
			e.setStates(0); //inactive
			en.add(e);
		}
		
		return en;
	}
	
}
