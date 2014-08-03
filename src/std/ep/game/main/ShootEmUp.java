package std.ep.game.main;

import java.util.ArrayList;

import std.ep.game.elements.actions.Colide;
import std.ep.game.elements.actions.states.Active;
import std.ep.game.elements.actions.states.Exploding;
import std.ep.game.elements.actions.states.State;
import std.ep.game.elements.enemy.Enemy;
import std.ep.game.elements.enemy.EnemyActions;
import std.ep.game.elements.facade.ElementsFacade;
import std.ep.game.elements.player.Player;
import std.ep.game.utils.GameUtils;

public class ShootEmUp {
	
	private static State EXPLODING = new Exploding();
	private static State ACTIVE = new Active();
	private static State INACTIVE = new Active();
	
	public static void main(String[] args){
		
		/* Já a variável "currentTime" nos dá o timestamp atual.  */
		
		long currentTime = System.currentTimeMillis();
		
		ElementsFacade elements = new ElementsFacade(currentTime);
		Colide colisionHelper = new Colide();
		GameUtils util = new GameUtils();
		
		elements.initializeElements();
		
		/* Usada para atualizar o estado dos elementos do jogo    */
		/* (player, projéteis e inimigos) "delta" indica quantos  */
		/* ms se passaram desde a última atualização.             */
		
		double delta = System.currentTimeMillis() - currentTime;
		
		/* Já a variável "currentTime" nos dá o timestamp atual.  */
		
		currentTime = System.currentTimeMillis();
		
		Player p = elements.getP();
		ArrayList<Enemy> e1 = elements.getEnemy1();
		ArrayList<Enemy> e2 = elements.getEnemy2();
		ArrayList<Enemy> e3 = elements.getEnemy3();
		
		/**
		 * colisoes
		 */

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
		
		/**
		 * Atualizacao de status
		 */
		//projeteis (player)
		p.setProjetil(util.checkProjectil(p, delta));
			
		//projeteis (inimigos)
		elements.setEnemy1(util.checkProjectil(e1, delta));
		
		//inimigos tipo 1
		elements.setEnemy1(EnemyActions.checkEnemy1State(p, e1, currentTime, delta));
		
		//inimigo tipo 2
		elements.setEnemy2(EnemyActions.checkEnemy2State(p, e2, currentTime, delta));
		
	}
	
}
