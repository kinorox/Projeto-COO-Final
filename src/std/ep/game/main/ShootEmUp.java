package std.ep.game.main;

import std.ep.game.elements.actions.ColideActions;
import std.ep.game.elements.actions.EnemyActions;
import std.ep.game.elements.actions.PlayerActions;
import std.ep.game.elements.facade.ElementsFacade;
import std.ep.game.graphics.Window;
import std.ep.game.lib.GameLib;
import std.ep.game.utils.GameUtils;

public class ShootEmUp {
	
	public static void main(String[] args){
		
		boolean running;
		long delta;
		long currentTime;
		
		try {
			running = true;
			currentTime = System.currentTimeMillis();
			
			ElementsFacade elements = new ElementsFacade(currentTime);
			ColideActions colisionHelper = new ColideActions();
			GameUtils.beginState();
			elements.initializeElements();
			GameLib.initGraphics();
			
			while(running){

				/* Usada para atualizar o estado dos elementos do jogo    */
				/* (player, projéteis e inimigos) "delta" indica quantos  */
				/* ms se passaram desde a última atualização.             */
				
				delta = System.currentTimeMillis() - currentTime;
				
				/* Já a variável "currentTime" nos dá o timestamp atual.  */
				
				currentTime = System.currentTimeMillis();
				
				/**
				 * colisoes
				 */
				
				if(elements.getP().getState().equals(GameUtils.ACTIVE)){
					//checar colisoes player - projetil (inimigo)
					if(colisionHelper.playerColisionWithEnemyProjectile(elements.getP(), elements.getEnemy1(), currentTime) != null){
						elements.setP(colisionHelper.playerColisionWithEnemyProjectile(elements.getP(), elements.getEnemy1(), currentTime));
					}
					if(colisionHelper.playerColisionWithEnemyProjectile(elements.getP(), elements.getEnemy2(), currentTime) != null){
						elements.setP(colisionHelper.playerColisionWithEnemyProjectile(elements.getP(), elements.getEnemy2(), currentTime));
					}
					if(colisionHelper.playerColisionWithEnemyProjectile(elements.getP(), elements.getEnemy3(), currentTime) != null){
						elements.setP(colisionHelper.playerColisionWithEnemyProjectile(elements.getP(), elements.getEnemy3(), currentTime));
					}
					
					//checar colisoes player - inimigo
					if(colisionHelper.playerEnemyCollision(elements.getP(), elements.getEnemy1()) != null){
						elements.setP(colisionHelper.playerEnemyCollision(elements.getP(), elements.getEnemy1()));
					}
					if(colisionHelper.playerEnemyCollision(elements.getP(), elements.getEnemy2()) != null){
						elements.setP(colisionHelper.playerEnemyCollision(elements.getP(), elements.getEnemy2()));
					}
					if(colisionHelper.playerEnemyCollision(elements.getP(), elements.getEnemy3()) != null){
						elements.setP(colisionHelper.playerEnemyCollision(elements.getP(), elements.getEnemy3()));
					}
				}
				
				//checar colisoes inimigo - projetil (player)
				if(colisionHelper.enemyColisionWithPlayerProjectile(elements.getP(), elements.getEnemy1(), currentTime) != null){
					elements.setEnemy1(colisionHelper.enemyColisionWithPlayerProjectile(elements.getP(), elements.getEnemy1(), currentTime));
				}
				if(colisionHelper.enemyColisionWithPlayerProjectile(elements.getP(), elements.getEnemy2(), currentTime) != null){
					elements.setEnemy2(colisionHelper.enemyColisionWithPlayerProjectile(elements.getP(), elements.getEnemy2(), currentTime));
				}
				if(colisionHelper.enemyColisionWithPlayerProjectile(elements.getP(), elements.getEnemy3(), currentTime) != null){
					elements.setEnemy3(colisionHelper.enemyColisionWithPlayerProjectile(elements.getP(), elements.getEnemy3(), currentTime));
				}
				
				/**
				 * Atualizacao de status
				 */
				//projeteis (player)
				if(GameUtils.checkProjectil(elements.getP(), delta) != null) elements.getP().setProjetil(GameUtils.checkProjectil(elements.getP(), delta));
					
				//projeteis (inimigos)
				if(GameUtils.checkProjectil(elements.getEnemy1(), delta) != null) elements.setEnemy1(GameUtils.checkProjectil(elements.getEnemy1(), delta));
				
				//inimigos tipo 1
				if(EnemyActions.checkEnemy1State(elements.getP(), elements.getEnemy1(), currentTime, delta) != null) elements.setEnemy1(EnemyActions.checkEnemy1State(elements.getP(), elements.getEnemy1(), currentTime, delta));
				
				//inimigo tipo 2
				if(EnemyActions.checkEnemy2State(elements.getP(), elements.getEnemy2(), currentTime, delta) != null) elements.setEnemy2(EnemyActions.checkEnemy2State(elements.getP(), elements.getEnemy2(), currentTime, delta));
				
				//checar inimigos1
				if(EnemyActions.checkIfItsTimeToBornBaby1(currentTime, elements.getEnemy1()) != null) elements.setEnemy1(EnemyActions.checkIfItsTimeToBornBaby1(currentTime, elements.getEnemy1()));
				
				//checar inimigos2
				if(EnemyActions.checkIfItsTimeToBornBaby2(currentTime, elements.getEnemy2()) != null) elements.setEnemy2(EnemyActions.checkIfItsTimeToBornBaby2(currentTime, elements.getEnemy2()));
				
				//checar se a explosao ja terminou
				GameUtils.checkExplosion(elements.getP(), currentTime);

				/**
				 * input do usuario
				 */
				running = PlayerActions.keyPressVerifier(running, delta, currentTime, elements);
				
				//player dentro da tela
				if(PlayerActions.checkPlayerInTheWindow(elements.getP()) != null) elements.setP(PlayerActions.checkPlayerInTheWindow(elements.getP()));
				
				/**
				 * iniciando os graficos
				 */
				Window.backgroundBehindDraw(elements.getSecondaryBG(), delta);
				Window.backgroundCloserDraw(elements.getPrimaryBG(), delta);
				Window.playerDraw(elements.getP(), currentTime);
				Window.playerProjectileDraw(elements.getP());
				Window.enemyProjectileDraw(elements.getEnemy1());
				Window.enemyProjectileDraw(elements.getEnemy2());
				Window.enemy1Draw(elements.getEnemy1(), currentTime);
				Window.enemy2Draw(elements.getEnemy2(), currentTime);
				
				GameLib.display();
				GameUtils.busyWait(currentTime + 5);
			}
			
			System.exit(0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
