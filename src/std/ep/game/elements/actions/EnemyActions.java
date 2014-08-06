package std.ep.game.elements.actions;

import java.util.ArrayList;
import java.util.ListIterator;

import std.ep.game.elements.actions.states.Active;
import std.ep.game.elements.actions.states.Exploding;
import std.ep.game.elements.actions.states.Inactive;
import std.ep.game.elements.enemy.Enemy;
import std.ep.game.elements.enemy.Enemy1;
import std.ep.game.elements.enemy.Enemy2;
import std.ep.game.elements.enemy.Enemy3;
import std.ep.game.elements.player.Player;
import std.ep.game.elements.projectil.Projectil;
import std.ep.game.lib.GameLib;
import std.ep.game.utils.GameUtils;

public class EnemyActions {
	
	public static ArrayList<Enemy> checkEnemy1State(Player p, ArrayList<Enemy> eArray, long currentTime, double delta) {
		
		ArrayList<Enemy> result = new ArrayList<Enemy>();
		
		for(Enemy e : eArray ) {
			if(e.getStates().equals(Exploding.instancia())){
				if(currentTime > e.getExplosionEnd()){
					GameUtils.ACTIVE.setState(e);
				}
			}
			
			if(e.getStates().equals(Active.instancia())){
				
				if(e.getY() > GameLib.HEIGHT + 10) GameUtils.INACTIVE.setState(e);
				else {
					e.setX(e.getX() + e.getVelocidade() * Math.cos(e.getAngle()) * delta);
					e.setY(e.getY() + e.getVelocidade() * Math.sin(e.getAngle()) * delta * (-1.0));
					e.setAngle(e.getAngle() + e.getRv() * delta);
					
					if(currentTime > ((Enemy1) e).getNextShoot() && e.getY() < p.getY()) {
						ArrayList<Projectil> pr = e.getProjetil();
						Integer free = GameUtils.findFreeIndex(eArray);
						
						if(free < pr.size()) {
							
							Projectil pro = pr.get(free);
							pro.setX(e.getX());
							pro.setY(e.getY());
							pro.setVeloX(Math.cos(e.getAngle()) * 0.45);
							pro.setVeloY(Math.sin(e.getAngle()) * 0.45 * (-1.0));
							GameUtils.ACTIVE.setState(pro);
							
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
		
		try {
			ListIterator<Enemy> litrEnemy = eArray.listIterator();
			
			while(litrEnemy.hasNext()){
				Enemy e = litrEnemy.next();
				
				if(e.getStates().equals(Exploding.instancia())){
					if(currentTime > e.getExplosionEnd()) e.setStates(GameUtils.INACTIVE);
				}
				
				if(e.getStates().equals(Active.instancia())){
					if(e.getX() < -10 || e.getX() > GameLib.WIDTH + 10 ) e.setStates(GameUtils.INACTIVE);
					else{
						
						boolean shootNow = false;
						Double prevY = e.getY();
						
						e.setX(e.getX() + e.getVelocidade() * Math.cos(e.getAngle()) * delta);
						e.setY(e.getY() + e.getVelocidade() * Math.sin(e.getAngle()) * delta * (-1.0));
						e.setAngle(e.getAngle() + e.getRv() * delta);
						
						Double threshold = GameLib.HEIGHT * 0.30;
						
						if(prevY < threshold && e.getY() >= threshold) {
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
									GameUtils.ACTIVE.setState(e.getProjetil().get(free));
									
								}
							}
						}
					}
				}
			}
			
			return eArray;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public static ArrayList<Enemy> checkIfItsTimeToBornBaby1(long currentTime, ArrayList<Enemy> e){
		
		ListIterator<Enemy> litrEn = e.listIterator();
		
		while(litrEn.hasNext()){
			Enemy e1 = litrEn.next();
			
			if(currentTime > ((Enemy1) e1).getNextEnemy()){
				Integer free = GameUtils.findFreeIndex(e);
				
				if(free < e.size()){
					e.get(free).setX(Math.random() * (GameLib.WIDTH - 20.0) + 10.0);
					e.get(free).setY(-10.0);
					e.get(free).setVelocidade(0.20 + Math.random() * 0.15);
					e.get(free).setAngle(3*Math.PI/2);
					e.get(free).setRv(0.0);
					GameUtils.ACTIVE.setState(e.get(free));
					((Enemy1) e.get(free)).setNextShoot(currentTime + 500);
					((Enemy1) e.get(free)).setNextEnemy(currentTime + 500);
				}
			}
		}
		
		return e;
		
	}
	
	public static ArrayList<Enemy> checkIfItsTimeToBornBaby2(long currentTime, ArrayList<Enemy> e){
		
		Enemy2 e2 = (Enemy2) e.get(0);
	
		if(currentTime > e2.getNextEnemy2()){
			Integer free = GameUtils.findFreeIndex(e);
			
			if(free < e.size()){
				
				e.get(free).setX(GameLib.WIDTH * 0.20);
				e.get(free).setY(-10.0);
				e.get(free).setVelocidade(0.42);
				e.get(free).setAngle(3*Math.PI/2);
				e.get(free).setRv(0.0);
				
				GameUtils.ACTIVE.setState(e.get(free));

				((Enemy2) e.get(free)).setEnemy2_count(((Enemy2) e.get(free)).getEnemy2_count()+1);
				
				if(((Enemy2) e.get(free)).getEnemy2_count() < 10){
					((Enemy2) e.get(free)).setNextEnemy2(currentTime + 120);
				} else {
					((Enemy2) e.get(free)).setEnemy2_count(0);
					e.get(free).setX(Math.random() > 0.5 ? GameLib.WIDTH * 0.2 : GameLib.WIDTH * 0.8);
					((Enemy2) e.get(free)).setNextEnemy2((long) (currentTime + 3000 + Math.random() * 3000));
				}
			}
		}
		
		return e;
		
	}

}
