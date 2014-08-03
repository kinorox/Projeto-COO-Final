package std.ep.game.elements.enemy;
import java.util.ArrayList;

import std.ep.game.elements.actions.*;
import std.ep.game.elements.actions.states.State;
import std.ep.game.elements.projectil.*;
import std.ep.game.lib.GameLib;

public abstract class Enemy {	
	
	private State state;						// estados (0=inativo - 1=ativo - 2=explodindo)
	private double xCoord;					// coordenadas x
	private double yCoord;					// coordenadas y
	private double xVCoord;					// velocidades
	private double angle;					// ângulos (indicam direção do movimento)
	private double rv;						// velocidades de rotação
	private double explosionStart;			// instantes dos inícios das explosões
	private double explosionEnd;			// instantes dos finais das explosões
	private double radius;
	private ArrayList<Projectil> projetil; 
	
	public Enemy()
	{
		this.projetil = new ArrayList<Projectil>();
	}

	public State getStates() {
		return state;
	}

	public void setStates(State instancia) {
		this.state = instancia;
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

	public double getVelocidade() {
		return xVCoord;
	}

	public void setVelocidade(double xVCoord) {
		this.xVCoord = xVCoord;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public double getRv() {
		return rv;
	}

	public void setRv(double rv) {
		this.rv = rv;
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
	
	public ArrayList<Projectil> getProjetil() {
		return projetil;
	}
	
	public void setProjetil(ArrayList<Projectil> projetil) {
		this.projetil = projetil;
	}
	
	public void setRadius(double rad)
	{
		this.radius = rad;
	}
	
	public double getRadius()
	{
		return this.radius;
	}
		
}
