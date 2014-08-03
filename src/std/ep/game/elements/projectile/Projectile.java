package std.ep.game.elements.projectile;

public class Projectile {

	private boolean active;
	private double xCoord; // coordenadas x
	private double yCoord; // coordenadas y
	private double xVcoord; // velocidade no eixo x
	private double yVcoord; // velocidade no eixo y
	private double radius; // raio (tamanho dos projéteis inimigos)
	
	public Projectile(double radius) {
		super();
		this.radius = radius;
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

	public double getxVcoord() {
		return xVcoord;
	}

	public void setxVcoord(double xVcoord) {
		this.xVcoord = xVcoord;
	}

	public double getyVcoord() {
		return yVcoord;
	}

	public void setyVcoord(double yVcoord) {
		this.yVcoord = yVcoord;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
					
}
