package std.ep.game.elements.player;
import std.ep.game.elements.projectile.*;

public class Player {

	private int state;											// estado (0 inactive - 1 active - 2 exploding)
	private double xCoord;										// coordenada x
	private double yCoord;										// coordenada y
	private double xVcoord;										// velocidade no eixo x
	private double yVcoord;										// velocidade no eixo y
	private double radius;										// raio (tamanho aproximado do player)
	private double explosionStart;								// instante do início da explosão
	private double explosionEnd;								// instante do final da explosão
	public long nextShot;										// instante a partir do qual pode haver um próximo tiro
	private Projectile projetil; 
	
	public Player(long nextShot)
	{
		super();
		this.nextShot = nextShot;
		this.projetil = new Projectile();
	}
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
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
	
	public Projectile getProjetil()
	{
		return this.projetil;
	}
}
