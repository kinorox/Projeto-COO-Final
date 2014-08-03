package std.ep.game.elements.actions.states;

import std.ep.game.elements.enemy.Enemy;
import std.ep.game.elements.player.Player;
import std.ep.game.elements.projectil.Projectil;

public interface State {
	public static void setState(Player p) {
	}
	public static void setState(Enemy e) {
	}
	public static void setState(Projectil pr) {
	}
}
