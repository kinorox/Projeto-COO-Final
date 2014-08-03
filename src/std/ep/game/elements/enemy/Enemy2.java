package std.ep.game.elements.enemy;

import std.ep.game.lib.GameLib;

public class Enemy2 extends Enemy {
	
	double enemy2_spawnX = GameLib.WIDTH * 0.20;			// coordenada x do próximo inimigo tipo 2 a aparecer
	int enemy2_count = 0;	  								// contagem de inimigos tipo 2 (usada na "formação de voo")
	double enemy2_radius = 12.0;							// raio (tamanho aproximado do inimigo 2)
	long nextEnemy2;										// instante em que um novo inimigo 2 deve aparecer
	
	public Enemy2(long nextEnemy2) {
		super();
		this.nextEnemy2 = nextEnemy2 + 2000;
	}
	
	
	public int getEnemy2_count() {
		return enemy2_count;
	}
	
	public void setEnemy2_count(int enemy2_count) {
		this.enemy2_count = enemy2_count;
	}
	
	public long getNextEnemy2() {
		return nextEnemy2;
	}
	
	public void setNextEnemy2(long nextEnemy2) {
		this.nextEnemy2 = nextEnemy2;
	}
	
}
