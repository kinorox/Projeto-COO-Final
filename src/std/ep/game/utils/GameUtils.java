package std.ep.game.utils;

import java.util.ArrayList;

import std.ep.game.elements.actions.states.*;
import std.ep.game.elements.enemy.Enemy;
import std.ep.game.elements.player.Player;
import std.ep.game.elements.projectil.Projectil;
import std.ep.game.lib.GameLib;

public class GameUtils {

	private static State INACTIVE = new Inactive();
	private static State ACTIVE = new Active();
	private static State EXPLODING = new Exploding();
	
	/* Encontra e devolve o primeiro índice do  */
	/* array referente a uma posição "inativa". */
	
	public Integer findFreeIndex(ArrayList<Enemy> stateArray){
		
		Integer i = 0;
		
		for (Enemy a : stateArray) {	
			if(a.getStates().equals(INACTIVE)) break;
			i++;
		}
		
		return i;
		
	}
	

	/* Encontra e devolve o conjunto de índices (a quantidade */
	/* de índices é defnida através do parâmetro "amount") do */
	/* array, referentes a posições "inativas".               */ 

//	public ArrayList<Integer> findFreeIndex(State state, int amount){
//
//		Integer i, k;
//		ArrayList<Integer> freeArray =  { stateArray.length, stateArray.length, stateArray.length };
//		int [] freeArray = { stateArray.length, stateArray.length, stateArray.length };
//		
//		for(i = 0, k = 0; i < stateArray.length && k < amount; i++){
//				
//			if(stateArray[i] == INACTIVE) { 
//				
//				freeArray[k] = i; 
//				k++;
//			}
//		}
//		
//		return freeArray;
//	}
	
	public ArrayList<Projectil> checkProjectil(Player p, double delta){
		ArrayList<Projectil> pr = p.getProjetil();
		ArrayList<Projectil> result = new ArrayList<Projectil>();
		
		for (Projectil pro : pr) {
			if(pro.getState().equals(ACTIVE)) {
				
				if(pro.getY() < 0) INACTIVE.setState(p);
				else {
					pro.setX(pro.getX() + pro.getVeloX()*delta);
					pro.setY(pro.getY() + pro.getVeloY()*delta);
				}
				
				return result;
			}
		}
		
		return null;
		
	}
	
	public ArrayList<Enemy> checkProjectil(ArrayList<Enemy> p, double delta){
		
		for (Enemy e : p) {
			
			ArrayList<Projectil> pr = e.getProjetil();
			ArrayList<Projectil> result = new ArrayList<Projectil>();
			ArrayList<Enemy> finalEnemy = new ArrayList<Enemy>();
			
			for (Projectil pro : pr) {
				if(pro.getState().equals(ACTIVE)) {
					
					if(pro.getY() > GameLib.HEIGHT) INACTIVE.setState(e);
					else {
						pro.setX(pro.getX() + pro.getVeloX()*delta);
						pro.setY(pro.getY() + pro.getVeloY()*delta);
					}
					
					e.setProjetil(result);
					
				}
			}
			
			finalEnemy.add(e);
			
			return finalEnemy;
		}
		
		return null;
		
	}
	
	public void checkExplosion(Player p, long currentTime){
		if(p.getExplosionEnd() < currentTime) ACTIVE.setState(p);
		
	}
}
