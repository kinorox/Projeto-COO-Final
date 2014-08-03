package std.ep.game.elements.projectil;

import std.ep.game.elements.actions.states.Inactive;
import std.ep.game.elements.actions.states.State;

public class Projectil {

	private State state;
	private double X; // coordenadas x
	private double Y; // coordenadas y
	private double VelocidadeX; // velocidade no eixo x
	private double VelocidadeY; // velocidade no eixo y
	private double radius; // raio (tamanho dos projéteis inimigos)
	
	public Projectil()
	{
		this.state  = new Inactive();
		this.X  = 0.0;
		this.Y  = 0.0;
		this.VelocidadeX = 0.0;
		this.VelocidadeY = 0.0;
		this.radius  = 0.0;
	}
	
	
	public Projectil(double radius) {
		super();
		this.radius = radius;
	}

	public double getX() {
		return X;
	}

	public void setX(double xCoord) {
		this.X = xCoord;
	}

	public double getY() {
		return Y;
	}

	public void setY(double yCoord) {
		this.Y = yCoord;
	}

	public double getVeloX() {
		return VelocidadeX;
	}

	public void setVeloX(double xVcoord) {
		this.VelocidadeX = xVcoord;
	}

	public double getVeloY() {
		return VelocidadeY;
	}

	public void setVeloY(double yVcoord) {
		this.VelocidadeY = yVcoord;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public State getState() {
		return state;
	}

	public void setState(State instancia) {
		this.state = instancia;
	}
					
}
