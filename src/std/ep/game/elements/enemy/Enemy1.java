package std.ep.game.elements.enemy;

public class Enemy1 extends Enemy{
	
	double radius = 9.0;    // raio (tamanho do inimigo 1)
	long nextShoot;			// instantes do próximo tiro
	long nextEnemy;			// instante em que um novo inimigo 1 deve aparecer								
	
	public Enemy1(long nextEnemy) {
		super();
		this.nextEnemy = nextEnemy + 2000;
	}
	
	public long getNextShoot() {
		return nextShoot;
	}

	public void setNextShoot(long nextShoot) {
		this.nextShoot = nextShoot;
	}

	public long getNextEnemy() {
		return nextEnemy;
	}

	public void setNextEnemy(long nextEnemy) {
		this.nextEnemy = nextEnemy;
	}
	
	
}
