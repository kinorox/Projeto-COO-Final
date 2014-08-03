package std.ep.game.elements.enemy;

import java.util.ArrayList;

import std.ep.game.elements.actions.states.Active;
import std.ep.game.elements.actions.states.Exploding;
import std.ep.game.elements.actions.states.Inactive;
import std.ep.game.elements.player.Player;
import std.ep.game.elements.projectil.Projectil;
import std.ep.game.lib.GameLib;
import std.ep.game.utils.GameUtils;

public class EnemyActions {
	
	public static ArrayList<Enemy> checkEnemyState(Player p, ArrayList<Enemy1> eArray, long currentTime, double delta) {
		
		ArrayList<Enemy> result = new ArrayList<Enemy>();
		
		for(Enemy1 e : eArray ) {
			if(e.getStates().equals(Exploding.instancia)){
				if(currentTime > e.getExplosionEnd()){
					Inactive.setState(e);
				}
			}
			
			if(e.getStates().equals(Active.instancia)){
				
				if(e.getY() > GameLib.HEIGHT + 10) Inactive.setState(e);
				else {
					e.setX(e.getX() + e.getVelocidade() * Math.cos(e.getAngle()) * delta);
					e.setY(e.getY() + e.getVelocidade() * Math.sin(e.getAngle()) * delta * (-1.0));
					e.setAngle(e.getAngle() + e.getRv() * delta);
					
					if(currentTime > e.getNextShoot() && e.getY() < p.getY()) {
						ArrayList<Projectil> pr = e.getProjetil();
						Integer free = GameUtils.findFreeIndex(pr);
						
						if(free < pr.size()) {
							
							Projectil pro = pr.get(free);
							pro.setX(e.getX());
							pro.setY(e.getY());
							pro.setVeloX(Math.cos(e.getAngle()) * 0.45);
							pro.setVeloY(Math.sin(e.getAngle()) * 0.45 * (-1.0));
							Active.setState(pro);
							
							pr.set(free, pro);
							
							e.setNextShoot((long) (currentTime + 200 + Math.random() * 500));
							
						}
					}
				}
			}
			
			result.add(e);
		}
		
		return result;
	}
}
