package std.ep.game.elements.actions.states;

import std.ep.game.elements.enemy.Enemy;
import std.ep.game.elements.player.Player;
import std.ep.game.elements.projectil.Projectil;

public class Exploding implements State{

	public static Exploding instancia;

	public static Exploding instancia() { 
		if (instancia == null)
			instancia = new Exploding();
		 
		return instancia; 
	 }
	
	public void setState(Player p) {
		p.setState(instancia());
	}

	public void setState(Enemy e) {
		e.setStates(instancia());
		
	}

	public void setState(Projectil pr) {
		pr.setState(instancia());
	}
	
}
