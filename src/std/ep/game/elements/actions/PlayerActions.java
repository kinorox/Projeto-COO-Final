package std.ep.game.elements.actions;

import java.util.ArrayList;

import std.ep.game.elements.actions.states.Active;
import std.ep.game.elements.player.Player;
import std.ep.game.elements.projectil.Projectil;
import std.ep.game.lib.GameLib;
import std.ep.game.utils.GameUtils;

public class PlayerActions {
	
	public static Player checkWhatTheUserIsPressing(Player p, double delta, long currentTime){

		if(p.getState().equals(Active.instancia())){
			
			if(GameLib.iskeyPressed(GameLib.KEY_UP)) p.setY(p.getY() - delta * p.getVeloY());
			if(GameLib.iskeyPressed(GameLib.KEY_DOWN)) p.setY(p.getY() + delta * p.getVeloY());
			if(GameLib.iskeyPressed(GameLib.KEY_LEFT)) p.setX(p.getX() - delta * p.getVeloX());
			if(GameLib.iskeyPressed(GameLib.KEY_RIGHT)) p.setX(p.getX() + delta * p.getVeloX());
			if(GameLib.iskeyPressed(GameLib.KEY_CONTROL)) {
				
				if(currentTime > p.getNextShot()){
					
					int free = GameUtils.findFreeIndex(p.getProjetil());
											
					if(free < p.getProjetil().size()){
						
						Projectil pr = p.getProjetil().get(free);
						pr.setX(p.getX());
						pr.setY(p.getY() - 2 * p.getRadius());
						pr.setVeloX(0.0);
						pr.setVeloY(-1.0);
						Active.setState(pr);
						p.setNextShot(currentTime + 100);
						
						p.getProjetil().set(free, pr);
					}
				}	
			}
		}
		
		return p;
	}
	
	public static Player checkPlayerInTheWindow(Player p) {

		if(p.getX() < 0.0) p.setX(0.0);
		if(p.getX() >= GameLib.WIDTH) p.setX(GameLib.WIDTH - 1);
		if(p.getY() < 25.0) p.setY(25.0);
		if(p.getY() >= GameLib.HEIGHT) p.setY(GameLib.HEIGHT);
		
		return p;
	}
}
