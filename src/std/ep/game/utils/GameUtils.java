package std.ep.game.utils;

import java.util.ArrayList;
import java.util.ListIterator;

import std.ep.game.elements.actions.states.*;
import std.ep.game.elements.enemy.Enemy;
import std.ep.game.elements.player.Player;
import std.ep.game.elements.projectil.Projectil;
import std.ep.game.lib.GameLib;

public class GameUtils {
	
	public static Active ACTIVE;
	public static Inactive INACTIVE;
	public static Exploding EXPLODING;
	
	public static void beginState(){
		ACTIVE = new Active();
		INACTIVE = new Inactive();
		EXPLODING = new Exploding();
	}
	
	/* Encontra e devolve o primeiro índice do  */
	/* array referente a uma posição "inativa". */
	
	public static Integer findFreeIndex(ArrayList<Enemy> stateArray){
		Integer i = 0;
		
		ListIterator<Enemy> listEn = stateArray.listIterator();
		
		while(listEn.hasNext()){
			Enemy e = listEn.next();
			if(e.getStates().equals(Inactive.instancia())) break;
			i++;
		}
		
		return i;
	}
	
	public static Integer findFreeIndexProjectil(ArrayList<Projectil> stateArray){
		Integer i = 0;
		for (Projectil a : stateArray) {	
			if(a.getState().equals(Inactive.instancia())) break;
			i++;
		}
		return i;
	}
	

	/* Encontra e devolve o conjunto de índices (a quantidade */
	/* de índices é defnida através do parâmetro "amount") do */
	/* array, referentes a posições "inativas".               */ 

	public static ArrayList<Integer> findFreeIndex(Enemy e, int amount){

		Integer i, k;
		ArrayList<Projectil> pr = e.getProjetil();
		ArrayList<Integer> freeArray =  new ArrayList<Integer>();
		
		freeArray.add(pr.size());
		freeArray.add(pr.size());
		freeArray.add(pr.size());
		
		for(i = 0, k = 0; i < pr.size() && k < amount; i++){
			
			if(pr.get(i).getState().equals(Inactive.instancia())){
				freeArray.set(k, i);
				k++;
			}
		}
		
		return freeArray;
	}
	
	public static ArrayList<Projectil> checkProjectil(Player p, double delta){
		
		try {
			ArrayList<Projectil> projectilArray = p.getProjetil();
			ListIterator<Projectil> litProj = projectilArray.listIterator();
			
			while(litProj.hasNext()){
				Projectil pro = (Projectil) litProj.next();
				
				if(pro.getState().equals(Active.instancia())){
					
					if(pro.getY() < 0) GameUtils.INACTIVE.setState(pro);
					else
						pro.setX(pro.getX() + pro.getVeloX() * delta);
						pro.setY(pro.getY() + pro.getVeloY() * delta);
					
				}
				
				litProj.set(pro);
			}
			
			return projectilArray;
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	public static ArrayList<Enemy> checkProjectil(ArrayList<Enemy> p, double delta){

		ArrayList<Enemy> finalEnemy = new ArrayList<Enemy>();
		
		for (Enemy e : p) {

			ArrayList<Projectil> result = new ArrayList<Projectil>();
			
			for (Projectil pro : e.getProjetil()) {
				if(pro.getState().equals(Active.instancia())) {
					
					if(pro.getY() > GameLib.HEIGHT) GameUtils.INACTIVE.setState(e);
					else {
						pro.setX(pro.getX() + pro.getVeloX()*delta);
						pro.setY(pro.getY() + pro.getVeloY()*delta);
					}
				}
				result.add(pro);
			}

			e.setProjetil(result);
			finalEnemy.add(e);
			
		}
		
		if(finalEnemy.size() > 0) return finalEnemy;
		
		return null;
		
	}
	
	public static void checkExplosion(Player p, long currentTime){
		if(p.getExplosionEnd() < currentTime) GameUtils.INACTIVE.setState(p);
		
	}
	
	public static void busyWait(long time){
		while(System.currentTimeMillis() < time) Thread.yield();
	}
}
