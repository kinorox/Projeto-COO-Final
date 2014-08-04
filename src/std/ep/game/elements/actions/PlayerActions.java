package std.ep.game.elements.actions;

import java.util.ArrayList;

import std.ep.game.elements.actions.states.Active;
import std.ep.game.elements.facade.ElementsFacade;
import std.ep.game.elements.player.Player;
import std.ep.game.elements.projectil.Projectil;
import std.ep.game.lib.GameLib;
import std.ep.game.utils.GameUtils;

public class PlayerActions {
	
	public static boolean keyPressVerifier(boolean running, long delta,
			long currentTime, ElementsFacade elements) {
		
		if(GameLib.iskeyPressed(GameLib.KEY_UP)){
			elements.getP().setY(elements.getP().getY() - delta * elements.getP().getVeloY());
		}
		if(GameLib.iskeyPressed(GameLib.KEY_DOWN)){
			elements.getP().setY(elements.getP().getY() + delta * elements.getP().getVeloY());
		}
		if(GameLib.iskeyPressed(GameLib.KEY_LEFT)){
			elements.getP().setX(elements.getP().getX() - delta * elements.getP().getVeloX());
		}
		if(GameLib.iskeyPressed(GameLib.KEY_RIGHT)){ 
			elements.getP().setX(elements.getP().getX() + delta * elements.getP().getVeloX());
		}
		if(GameLib.iskeyPressed(GameLib.KEY_CONTROL)) {
			
			if(currentTime > elements.getP().getNextShot()){
				
				int free = GameUtils.findFreeIndexProjectil(elements.getP().getProjetil());
										
				if(free < elements.getP().getProjetil().size()){
					
					Projectil pr = elements.getP().getProjetil().get(free);
					pr.setX(elements.getP().getX());
					pr.setY(elements.getP().getY() - 2 * elements.getP().getRadius());
					pr.setVeloX(0.0);
					pr.setVeloY(-1.0);
					GameUtils.ACTIVE.setState(pr);
					elements.getP().setNextShot(currentTime + 100);
					
					elements.getP().getProjetil().set(free, pr);
				}
			}	
		}
		
		if(GameLib.iskeyPressed(GameLib.KEY_ESCAPE)) {
			running = false;
		}
		
		return running;
	}
	
	public static Player checkPlayerInTheWindow(Player p) {

		if(p.getX() < 0.0) p.setX(0.0);
		if(p.getX() >= GameLib.WIDTH) p.setX(GameLib.WIDTH - 1);
		if(p.getY() < 25.0) p.setY(25.0);
		if(p.getY() >= GameLib.HEIGHT) p.setY(GameLib.HEIGHT);
		
		return p;
	}
}
