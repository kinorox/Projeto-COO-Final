package std.ep.game.graphics;

import java.awt.Color;
import java.util.ArrayList;

import std.ep.game.elements.actions.states.Active;
import std.ep.game.elements.actions.states.Exploding;
import std.ep.game.elements.background.Background;
import std.ep.game.elements.enemy.Enemy;
import std.ep.game.elements.player.Player;
import std.ep.game.elements.projectil.Projectil;
import std.ep.game.lib.GameLib;

public class Window {
	
	public static void playerDraw(Player p, long currentTime){
		if(p.getState().equals(Exploding.instancia())){
			
			double alpha = (currentTime - p.getExplosionStart()) / (p.getExplosionEnd() - p.getExplosionStart());
			GameLib.drawExplosion(p.getX(), p.getY(), alpha);
		}
		else{
			
			GameLib.setColor(Color.BLUE);
			GameLib.drawPlayer(p.getX(), p.getY(), p.getRadius());
		}
	}
	
	public static void playerProjectileDraw(Player p){
		
		for(Projectil pr : p.getProjetil()){
			
			if(pr.getState().equals(Active.instancia())){
				GameLib.setColor(Color.GREEN);
				GameLib.drawLine(pr.getX(), pr.getY() - 5, pr.getX(), pr.getY() + 5);
				GameLib.drawLine(pr.getX() - 1, pr.getY() - 3, pr.getX() - 1, pr.getY() + 3);
				GameLib.drawLine(pr.getX() + 1, pr.getY() - 3, pr.getX() + 1, pr.getY() + 3);
			}
			
		}
		
	}
	
	public static void enemyProjectileDraw(ArrayList<Enemy> e){
		
		for(Enemy en : e) {
			for(Projectil p : en.getProjetil()) {
				if(p.getState().equals(Active.instancia())){
					GameLib.setColor(Color.RED);
					GameLib.drawCircle(p.getX(), p.getY(), p.getRadius());
				}
			}
		}
	}
	
	public static void enemy1Draw(ArrayList<Enemy> enemy, long currentTime){
		
		for(Enemy e : enemy){
			
			if(e.getStates().equals(Exploding.instancia())){
				Double alpha = (currentTime - e.getExplosionStart() / e.getExplosionEnd() - e.getExplosionStart());
				GameLib.drawExplosion(e.getX(), e.getY(), alpha);
			}
			
			if(e.getStates().equals(Active.instancia())){
				GameLib.setColor(Color.CYAN);
				GameLib.drawCircle(e.getX(), e.getY(), e.getRadius());
			}
		}
	}
	
	public static void enemy2Draw(ArrayList<Enemy> enemy, long currentTime){
		
		for(Enemy e : enemy){
			
			if(e.getStates().equals(Exploding.instancia())){
				Double alpha = (currentTime - e.getExplosionStart() / e.getExplosionEnd() - e.getExplosionStart());
				GameLib.drawExplosion(e.getX(), e.getY(), alpha);
			}
			
			if(e.getStates().equals(Active.instancia())){
				GameLib.setColor(Color.MAGENTA);
				GameLib.drawDiamond(e.getX(), e.getY(), e.getRadius());
			}
			
		}
	}
	
	public static void backgroundBehindDraw(ArrayList<Background> bg, double delta){
		GameLib.setColor(Color.DARK_GRAY);
		bg.get(0).setCount(bg.get(0).getCount() + bg.get(0).getSpeed() * delta);
		
		for(Background b : bg) {
			GameLib.fillRect(b.getxCoord(), (b.getyCoord() + b.getCount()) % GameLib.HEIGHT, 2, 2 );
		}
	}
	
	public static void backgroundCloserDraw(ArrayList<Background> bg, double delta){	
		GameLib.setColor(Color.GRAY);
		bg.get(0).setCount(bg.get(0).getCount() + bg.get(0).getSpeed() * delta);
		
		for(Background b : bg) {
			GameLib.fillRect(b.getxCoord(), (b.getyCoord() + b.getCount()) % GameLib.HEIGHT, 3, 3 );
		}
	}
}
