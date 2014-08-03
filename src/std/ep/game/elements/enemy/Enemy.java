package std.ep.game.elements.enemy;

import std.ep.game.lib.GameLib;

public abstract class Enemy {	
	
	private int states;						// estados (0=inativo - 1=ativo - 2=explodindo)
	private double xCoord;					// coordenadas x
	private double yCoord;					// coordenadas y
	private double xVCoord;					// velocidades
	private double angle;					// ângulos (indicam direção do movimento)
	private double rv;						// velocidades de rotação
	private double explosionStart;			// instantes dos inícios das explosões
	private double explosionEnd;			// instantes dos finais das explosões
	
	public Enemy() {}

	public int getStates() {
		return states;
	}

	public void setStates(int states) {
		this.states = states;
	}

	public double getxCoord() {
		return xCoord;
	}

	public void setxCoord(double xCoord) {
		this.xCoord = xCoord;
	}

	public double getyCoord() {
		return yCoord;
	}

	public void setyCoord(double yCoord) {
		this.yCoord = yCoord;
	}

	public double getxVCoord() {
		return xVCoord;
	}

	public void setxVCoord(double xVCoord) {
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
		
}
