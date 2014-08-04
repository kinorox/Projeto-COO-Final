package std.ep.game.elements.actions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import std.ep.game.elements.actions.states.Active;
import std.ep.game.elements.actions.states.Exploding;
import std.ep.game.elements.actions.states.State;
import std.ep.game.elements.enemy.Enemy;
import std.ep.game.elements.player.Player;
import std.ep.game.elements.projectil.Projectil;
import std.ep.game.utils.GameUtils;

public class ColideActions 
{
	
	public ArrayList<Enemy> enemyColisionWithPlayerProjectile(Player p, ArrayList<Enemy> e, long currentTime)
	{
		
		try {
			ListIterator<Projectil> litProj = p.getProjetil().listIterator();
			ListIterator<Enemy> litEnemy = e.listIterator();
			
			while(litProj.hasNext()){
				Projectil pr = (Projectil) litProj.next();
				
				while(litEnemy.hasNext()){
					Enemy en = (Enemy) litEnemy.next();
					
					if(en.getStates().equals(GameUtils.ACTIVE.instancia())){
						Double dx = en.getX() - pr.getX();
						Double dy = en.getY() - pr.getY();
						Double dist = Math.sqrt(dx * dx + dy * dy);
						
						if(dist < en.getRadius()) {
							GameUtils.EXPLODING.setState(en);
							en.setExplosionStart(currentTime);
							en.setExplosionEnd(currentTime + 500);
						}
					}
					
					litEnemy.set(en);
				}
				
			}

			return e;
			
		} catch (Exception e1) {
			e1.printStackTrace();
			throw e1;
		}
		
	}
	
	public Player playerEnemyCollision(Player p, ArrayList<Enemy> e)
	{
		
		try {
			ListIterator<Enemy> litEn = e.listIterator();
			
			while(litEn.hasNext()){
				Enemy en = (Enemy) litEn.next();
				
				Double dx = en.getX() - p.getX();
				Double dy = en.getY() - p.getY();
				Double dist = Math.sqrt(dx * dx + dy * dy);
				
				if(dist < (p.getRadius() + en.getRadius()) * 0.8){
					GameUtils.EXPLODING.setState(p);
					p.setExplosionStart(p.getNextShot());
					p.setExplosionEnd(p.getNextShot() + 2000);
				}
			}
			
			return p;
		} catch (Exception e1) {
			e1.printStackTrace();
			throw e1;
		}
		
		
	}
	
	public Player playerColisionWithEnemyProjectile(Player p, ArrayList<Enemy> e, long currentTime)
	{
		
		try {
			ListIterator<Enemy> litEn = e.listIterator();
			
			while(litEn.hasNext()){
				Enemy en = (Enemy) litEn.next();
				ListIterator<Projectil> litProj = en.getProjetil().listIterator();
				
				while(litProj.hasNext()){
					Projectil pr = (Projectil) litProj.next();
					
					Double dx = pr.getX() - p.getX();
					Double dy = pr.getY() - p.getY();
					Double dist = Math.sqrt(dx * dx + dy * dy);
					
					if(dist < (p.getRadius() + pr.getRadius()) * 0.8){
						GameUtils.EXPLODING.setState(p);
						p.setExplosionStart(currentTime);
						p.setExplosionEnd(currentTime + 2000);
					}
				}
			}
			
			return p;
			
		} catch (Exception e1) {
			e1.printStackTrace();
			throw e1;
		}
		
	}
}
