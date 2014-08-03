package std.ep.game.elements.colide;
import java.util.ArrayList;

import std.ep.game.elements.enemy.Enemy;
import std.ep.game.elements.player.Player;

public class Colide 
{
	
	public void playerProjectileCollision(Player p, ArrayList<Enemy> e)
	{
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
				}
			}
		}
	}
	
	public void playerEnemyCollision(Player p, ArrayList<Enemy> e) //DEVE RETORNAR UM OBJETO P?
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
			}
		}
	}
	
	public void playerProjectileEnemyCollision(Player p, ArrayList<Enemy> e)
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
	}
}
