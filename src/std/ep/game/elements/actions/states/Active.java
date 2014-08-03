package std.ep.game.elements.actions.states;

import std.ep.game.elements.enemy.Enemy;
import std.ep.game.elements.player.Player;
import std.ep.game.elements.projectil.Projectil;

public class Active implements State{
	
	public static Active instancia;

	public Active instancia() { 
		if (this.instancia == null)
			this.instancia = new Active();
		 
		return this.instancia; 
	 }
	
	public static void setState(Player p) {
		p.setState(instancia);
	}

	public static void setState(Enemy e) {
		e.setStates(instancia);
		
	}

	public static void setState(Projectil pr) {
		pr.setState(instancia);
	}

}
