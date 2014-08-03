package std.ep.game.elements.player;
import std.ep.game.lib.GameLib;

public class Player {

	private int state;											// estado (0 inactive - 1 active - 2 exploding)
	private double xCoord = GameLib.WIDTH / 2;					// coordenada x
	private double yCoord = GameLib.HEIGHT * 0.90;				// coordenada y
	private double xVcoord = 0.25;								// velocidade no eixo x
	private double yVcoord = 0.25;								// velocidade no eixo y
	private double radius = 12.0;								// raio (tamanho aproximado do player)
	private double explosionStart;								// instante do início da explosão
	private double explosionEnd;								// instante do final da explosão
	private long nextShot;										// instante a partir do qual pode haver um próximo tiro
	
	public Player(long nextShot) {
		super();
		this.nextShot = nextShot;
	}
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
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
	
}
