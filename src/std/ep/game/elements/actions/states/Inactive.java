package std.ep.game.elements.actions.states;

import std.ep.game.elements.enemy.Enemy;
import std.ep.game.elements.player.Player;
import std.ep.game.elements.projectil.Projectil;

public class Inactive implements State{
	
	public static Inactive instancia;

	public static Inactive instancia() { 
		if (instancia == null)
			instancia = new Inactive();
		 
		return instancia; 
	 }
	
	public static void setState(Player p) {
		p.setState(instancia());
	}

	public static void setState(Enemy e) {
		e.setStates(instancia());
		
	}

	public static void setState(Projectil pr) {
		pr.setState(instancia());
	}

}
