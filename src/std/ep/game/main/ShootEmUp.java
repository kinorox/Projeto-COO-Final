package std.ep.game.main;

import java.util.ArrayList;

import std.ep.game.elements.actions.Colide;
import std.ep.game.elements.enemy.Enemy;
import std.ep.game.elements.facade.ElementsFacade;
import std.ep.game.elements.player.Player;

public class ShootEmUp {
	
	public static void main(String[] args){
		ElementsFacade elements = new ElementsFacade();
		Colide colisionHelper = new Colide();
		
		elements.initializeElements();
		
		Player p = elements.getP();
		ArrayList<Enemy> e1 = elements.getEnemy1();
		ArrayList<Enemy> e2 = elements.getEnemy2();
		ArrayList<Enemy> e3 = elements.getEnemy3();

		//checar colisoes player - projetil (inimigo)
		elements.setP(colisionHelper.playerColisionWithEnemyProjectile(p, e1));
		elements.setP(colisionHelper.playerColisionWithEnemyProjectile(p, e2));
		elements.setP(colisionHelper.playerColisionWithEnemyProjectile(p, e3));
		
		//checar colisoes player - inimigo
		elements.setP(colisionHelper.playerEnemyCollision(p, e1));
		elements.setP(colisionHelper.playerEnemyCollision(p, e2));
		elements.setP(colisionHelper.playerEnemyCollision(p, e3));
		
		//checar colisoes inimigo - projetil (player)
		elements.setEnemy1(colisionHelper.enemyColisionWithPlayerProjectile(p, e1));
		elements.setEnemy2(colisionHelper.enemyColisionWithPlayerProjectile(p, e2));
		elements.setEnemy3(colisionHelper.enemyColisionWithPlayerProjectile(p, e3));
		
		
	}
	
}
