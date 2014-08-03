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
						double[] angles = { Math.PI/2 + Math.PI/8, Math.PI/2, Math.PI/2 - Math.PI/8 }; 
					}
				}
		
																	
					if(shootNow){

						double [] angles = { Math.PI/2 + Math.PI/8, Math.PI/2, Math.PI/2 - Math.PI/8 };
						int [] freeArray = findFreeIndex(e_projectile_states, angles.length);

						for(int k = 0; k < freeArray.length; k++){
							
							int free = freeArray[k];
							
							if(free < e_projectile_states.length){
								
								double a = angles[k] + Math.random() * Math.PI/6 - Math.PI/12;
								double vx = Math.cos(a);
								double vy = Math.sin(a);
									
								e_projectile_X[free] = enemy2_X[i];
								e_projectile_Y[free] = enemy2_Y[i];
								e_projectile_VX[free] = vx * 0.30;
								e_projectile_VY[free] = vy * 0.30;
								e_projectile_states[free] = 1;
							}
						}
					}
				}
			}
		}
	}

}
