package std.ep.game.elements.actions;
import java.util.ArrayList;

import std.ep.game.elements.enemy.Enemy;
import std.ep.game.elements.player.Player;

public class Colide 
{
	
	private Integer ACTIVE = 1;
	private Integer EXPLODING = 2;
	
	public ArrayList<Enemy> enemyColisionWithPlayerProjectile(Player p, ArrayList<Enemy> e)
	{
		
		ArrayList<Enemy> er = new ArrayList<>(e.size());
		
		for(Enemy a : e)
		{
			if(a.getStates() == ACTIVE)
			{	
				double dx = a.getX() - p.getProjetil().getX();
				double dy = a.getY() - p.getProjetil().getY();
				double dist = Math.sqrt(dx * dx + dy * dy);
				
				if(dist < a.getRadius())
				{	
					a.setStates(EXPLODING);
					a.setExplosionStart(p.getNextShot());
					a.setExplosionEnd(p.getNextShot() + 500);
					
					er.add(a);
				}
			}
		}
		
		return er;
	}
	
	public Player playerEnemyCollision(Player p, ArrayList<Enemy> e) //DEVE RETORNAR UM OBJETO P?
	{
		for(Enemy a : e)
		{
			double dx = a.getX() - p.getX();
			double dy = a.getY() - p.getY();
			double dist = Math.sqrt(dx * dx + dy * dy);
			
			if(dist < (p.getRadius() + a.getRadius()) * 0.8)
			{	
				p.setState(EXPLODING);
				p.setExplosionStart(p.getNextShot());
				p.setExplosionEnd(p.getNextShot() + 2000);
				
				return p;
			}
		}
		
		return null;
	}
	
	public Player playerColisionWithEnemyProjectile(Player p, ArrayList<Enemy> e)
	{
		if(p.getState() == ACTIVE)
		{		
			for(Enemy a: e)
			{
				double dx 	= a.getProjetil().getX() - p.getX();
				double dy 	= a.getProjetil().getY() - p.getY();
				double dist = Math.sqrt(dx * dx + dy * dy);
				
				if(dist < (p.getRadius() + a.getProjetil().getRadius()) * 0.8)
				{		
					p.setState(EXPLODING);
					p.setExplosionStart(p.getNextShot()); //NextShot armazena o valor de currentTime
					p.setExplosionEnd(p.getNextShot() + 2000);
				}
			}
		}
		
		return null;
	}
}
