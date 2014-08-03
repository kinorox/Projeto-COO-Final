package std.ep.game.utils;

import java.util.ArrayList;

import std.ep.game.elements.actions.states.*;
import std.ep.game.elements.enemy.Enemy;
import std.ep.game.elements.player.Player;
import std.ep.game.elements.projectil.Projectil;
import std.ep.game.lib.GameLib;

public class GameUtils {
	
	/* Encontra e devolve o primeiro índice do  */
	/* array referente a uma posição "inativa". */
	
	public static Integer findFreeIndex(ArrayList<Projectil> stateArray){
		
		Integer i = 0;
		
		for (Projectil a : stateArray) {	
			if(a.getState().equals(Inactive.instancia)) break;
			i++;
		}
		
		return i;
		
	}
	

	/* Encontra e devolve o conjunto de índices (a quantidade */
	/* de índices é defnida através do parâmetro "amount") do */
	/* array, referentes a posições "inativas".               */ 

	public ArrayList<Integer> findFreeIndex(State state, int amount){

		Integer i, k;
		ArrayList<Integer> freeArray =  { stateArray.length, stateArray.length, stateArray.length };
		int [] freeArray = { stateArray.length, stateArray.length, stateArray.length };
		
		for(i = 0, k = 0; i < stateArray.length && k < amount; i++){
				
			if(stateArray[i] == INACTIVE) { 
				
				freeArray[k] = i; 
				k++;
			}
		}
		
		return freeArray;
	}
	
	public static ArrayList<Projectil> checkProjectil(Player p, double delta){
		ArrayList<Projectil> pr = p.getProjetil();
		ArrayList<Projectil> result = new ArrayList<Projectil>();
		
		for (Projectil pro : pr) {
			if(pro.getState().equals(Active.instancia)) {
				
				if(pro.getY() < 0) Inactive.setState(p);
				else {
					pro.setX(pro.getX() + pro.getVeloX()*delta);
					pro.setY(pro.getY() + pro.getVeloY()*delta);
				}
				
				return result;
			}
		}
		
		return null;
		
	}
	
	public static ArrayList<Enemy> checkProjectil(ArrayList<Enemy> p, double delta){
		
		for (Enemy e : p) {
			
			ArrayList<Projectil> pr = e.getProjetil();
			ArrayList<Projectil> result = new ArrayList<Projectil>();
			ArrayList<Enemy> finalEnemy = new ArrayList<Enemy>();
			
			for (Projectil pro : pr) {
				if(pro.getState().equals(Active.instancia)) {
					
					if(pro.getY() > GameLib.HEIGHT) Inactive.setState(e);
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
	
	public static void checkExplosion(Player p, long currentTime){
		if(p.getExplosionEnd() < currentTime) Active.setState(p);
		
	}
}
