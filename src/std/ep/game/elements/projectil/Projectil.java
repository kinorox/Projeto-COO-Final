package std.ep.game.elements.projectil;

public class Projectil {

	private boolean active;
	private double X; // coordenadas x
	private double Y; // coordenadas y
	private double VelocidadeX; // velocidade no eixo x
	private double VelocidadeY; // velocidade no eixo y
	private double radius; // raio (tamanho dos projéteis inimigos)
	
	public Projectil()
	{
		this.active  = true;
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

	public double setVeloY() {
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

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
					
}
