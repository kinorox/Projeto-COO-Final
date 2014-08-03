package std.ep.game.elements.actions.states;

import std.ep.game.elements.enemy.Enemy;
import std.ep.game.elements.player.Player;
import std.ep.game.elements.projectil.Projectil;

public class Inactive implements State{
	
	private Inactive instancia;

	public Inactive instancia() { 
		if (this.instancia == null)
			this.instancia = new Inactive();
		 
		return this.instancia; 
	 }
	
	@Override
	public void setState(Player p) {
		p.setState(instancia);
	}

	@Override
	public void setState(Enemy e) {
		e.setStates(instancia);
		
	}

	@Override
	public void setState(Projectil pr) {
		pr.setState(instancia);
	}

}
