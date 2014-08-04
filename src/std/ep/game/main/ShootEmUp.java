package std.ep.game.main;

import java.util.ArrayList;

import std.ep.game.elements.actions.ColideActions;
import std.ep.game.elements.actions.EnemyActions;
import std.ep.game.elements.actions.PlayerActions;
import std.ep.game.elements.enemy.Enemy;
import std.ep.game.elements.facade.ElementsFacade;
import std.ep.game.elements.player.Player;
import std.ep.game.lib.GameLib;
import std.ep.game.utils.GameUtils;

public class ShootEmUp {
	
	public static void main(String[] args){
		
		/* Já a variável "currentTime" nos dá o timestamp atual.  */
		
		long currentTime = System.currentTimeMillis();
		
		boolean running;
		
		ElementsFacade elements = new ElementsFacade(currentTime);
		ColideActions colisionHelper = new ColideActions();
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
		Player result = colisionHelper.playerColisionWithEnemyProjectile(p, e1);
		if(result != null) elements.setP(colisionHelper.playerColisionWithEnemyProjectile(p, e1));
		
		result = colisionHelper.playerColisionWithEnemyProjectile(p, e2);
		if(result != null) elements.setP(colisionHelper.playerColisionWithEnemyProjectile(p, e2));
		
		result = colisionHelper.playerColisionWithEnemyProjectile(p, e3);
		if(result != null) elements.setP(colisionHelper.playerColisionWithEnemyProjectile(p, e3));
		
		//checar colisoes player - inimigo
		result = colisionHelper.playerEnemyCollision(p, e1);
		if(result != null) elements.setP(colisionHelper.playerEnemyCollision(p, e1));
		
		result = colisionHelper.playerEnemyCollision(p, e2);
		if(result != null) elements.setP(colisionHelper.playerEnemyCollision(p, e2));
		
		result = colisionHelper.playerEnemyCollision(p, e3);
		if(result != null) elements.setP(colisionHelper.playerEnemyCollision(p, e3));
		
		//checar colisoes inimigo - projetil (player)
		ArrayList<Enemy> result2 = colisionHelper.enemyColisionWithPlayerProjectile(p, e1);
		if(result2 != null) elements.setEnemy1(colisionHelper.enemyColisionWithPlayerProjectile(p, e1));
		
		result2 = colisionHelper.enemyColisionWithPlayerProjectile(p, e2);
		if(result2 != null) elements.setEnemy2(colisionHelper.enemyColisionWithPlayerProjectile(p, e2));
		
		result2 = colisionHelper.enemyColisionWithPlayerProjectile(p, e2);
		if(result2 != null) elements.setEnemy3(colisionHelper.enemyColisionWithPlayerProjectile(p, e3));
		
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
		
		//checar inimigos1
		EnemyActions.checkIfItsTimeToBornBaby1(currentTime, e1);
		
		//checar inimigos2
		EnemyActions.checkIfItsTimeToBornBaby2(currentTime, e2);
		
		//checar se a explosao ja terminou
		GameUtils.checkExplosion(p, currentTime);
		
		//checa as acoes do usuario
		elements.setP(PlayerActions.checkWhatTheUserIsPressing(p, delta, currentTime));
		
		if(GameLib.iskeyPressed(GameLib.KEY_ESCAPE)) running = false;
		
		elements.setP(PlayerActions.checkPlayerInTheWindow(p));
		
	}
	
}
