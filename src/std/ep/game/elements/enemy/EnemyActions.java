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
	
	public static ArrayList<Enemy> checkEnemy1State(Player p, ArrayList<Enemy> eArray, long currentTime, double delta) {
		
		ArrayList<Enemy> result = new ArrayList<Enemy>();
		
		for(Enemy e : eArray ) {
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
					
					if(currentTime > ((Enemy1) e).getNextShoot() && e.getY() < p.getY()) {
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
							
							((Enemy1) e).setNextShoot((long) (currentTime + 200 + Math.random() * 500));
							
						}
					}
				}
			}
			
			result.add(e);
		}
		
		return result;
	}
	
	public static ArrayList<Enemy> checkEnemy2State(Player p, ArrayList<Enemy> eArray, long currentTime, double delta) {
		
		ArrayList<Enemy> result = new ArrayList<Enemy>();
		
		for(Enemy e : eArray ) {
			if(e.getStates().equals(Exploding.instancia)){
				if(currentTime > e.getExplosionEnd()){
					Inactive.setState(e);
				}
			}
			
			if(e.getStates().equals(Active.instancia)){
				
				if(e.getY() > GameLib.HEIGHT + 10) Inactive.setState(e);
				else {
					
					boolean shootNow = false;
					double previousY = e.getY();
					
					e.setX(e.getX() + e.getVelocidade() * Math.cos(e.getAngle()) * delta);
					e.setY(e.getY() + e.getVelocidade() * Math.sin(e.getAngle()) * delta * (-1.0));
					e.setAngle(e.getAngle() + e.getRv() * delta);
					
					double threshold = GameLib.HEIGHT * 0.30;
					
					if(previousY < threshold && e.getY() >= threshold) {
						
						if(e.getX() < GameLib.WIDTH / 2) e.setRv(0.003);
						else e.setRv(-0.003);
				
					}
					
					if(e.getRv() > 0 && Math.abs(e.getAngle() - 3 * Math.PI) < 0.05){
						e.setRv(0.0);
						e.setAngle(3*Math.PI);
						shootNow = true;
					}
					
					if(e.getRv() < 0 && Math.abs(e.getAngle()) < 0.05){
						e.setRv(0.0);
						e.setAngle(0.0);
						shootNow = true;
					}
					
					if(shootNow){
						ArrayList<Double> angles = new ArrayList<Double>();
						angles.add(Math.PI/2 + Math.PI/8);
						angles.add(Math.PI/2);
						angles.add(Math.PI/2 - Math.PI/8);
						
						ArrayList<Integer> freeArray = GameUtils.findFreeIndex(e, angles.size());
						
						for (int k = 0; k < freeArray.size(); k++){
							int free = freeArray.get(k);
							
							if(free < e.getProjetil().size()){
								
								Double a = angles.get(k) + Math.random() * Math.PI/6 - Math.PI/12;
								Double vx = Math.cos(a);
								Double vy = Math.sin(a);
								
								e.getProjetil().get(free).setX(e.getX());
								e.getProjetil().get(free).setY(e.getY());
								e.getProjetil().get(free).setVeloX(vx * 0.30);
								e.getProjetil().get(free).setVeloY(vy * 0.30);
								Active.setState(e.getProjetil().get(free));
								
							}
						}
					}
				}

			}
			
			result.add(e);
		}
		
		return result;
	}

}
