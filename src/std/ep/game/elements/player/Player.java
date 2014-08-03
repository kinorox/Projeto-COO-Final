package std.ep.game.elements.player;
import java.util.ArrayList;

import std.ep.game.elements.projectil.*;
import std.ep.game.elements.actions.*;
import std.ep.game.elements.actions.states.State;
public class Player {

	private State state;
	private double xCoord;										// coordenada x
	private double yCoord;										// coordenada y
	private double xVcoord;										// velocidade no eixo x
	private double yVcoord;										// velocidade no eixo y
	private double radius;										// raio (tamanho aproximado do player)
	private double explosionStart;								// instante do início da explosão
	private double explosionEnd;								// instante do final da explosão
	public long nextShot;										// instante a partir do qual pode haver um próximo tiro
	private ArrayList<Projectil> projetil; 
	
	public void setProjetil(ArrayList<Projectil> projetil) {
		this.projetil = projetil;
	}

	public Player(long nextShot)
	{
		super();
		this.nextShot = nextShot;
		this.projetil = new ArrayList<Projectil>();
	}
	
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public double getX() {
		return xCoord;
	}
	public void setX(double xCoord) {
		this.xCoord = xCoord;
	}
	public double getY() {
		return yCoord;
	}
	public void setY(double yCoord) {
		this.yCoord = yCoord;
	}
	public double getVeloX() {
		return xVcoord;
	}
	public void setVeloX(double xVcoord) {
		this.xVcoord = xVcoord;
	}
	public double getVeloY() {
		return yVcoord;
	}
	public void setVeloY(double yVcoord) {
		this.yVcoord = yVcoord;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public double getExplosionStart() {
		return explosionStart;
	}
	public void setExplosionStart(double explosionStart) {
		this.explosionStart = explosionStart;
	}
	public double getExplosionEnd() {
		return explosionEnd;
	}
	public void setExplosionEnd(double explosionEnd) {
		this.explosionEnd = explosionEnd;
	}
	public long getNextShot() {
		return nextShot;
	}
	public void setNextShot(long nextShot) {
		this.nextShot = nextShot;
	}
	
	public ArrayList<Projectil> getProjetil()
	{
		return this.projetil;
	}
}
