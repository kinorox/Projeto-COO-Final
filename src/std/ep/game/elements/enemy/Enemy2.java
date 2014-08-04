package std.ep.game.elements.enemy;

import std.ep.game.lib.GameLib;

public class Enemy2 extends Enemy 
{
	double spawnX;			// coordenada x do próximo inimigo tipo 2 a aparecer
	int count;	  			// contagem de inimigos tipo 2 (usada na "formação de voo")
	long nextEnemy2;		// instante em que um novo inimigo 2 deve aparecer
	
	public Enemy2(long nextEnemy2)
	{
		super();
		this.nextEnemy2 = nextEnemy2 + 7000;
		this.spawnX = GameLib.WIDTH * 0.20;
	}
	
	public void setSpawnX(double s) 
	{
		this.spawnX = s;
	}

	public int getEnemy2_count()
	{
		return count;
	}
	
	public void setEnemy2_count(int count) 
	{
		this.count = count;
	}
	
	public long getNextEnemy2()
	{
		return nextEnemy2;
	}
	
	public void setNextEnemy2(long nextEnemy2) {
		this.nextEnemy2 = nextEnemy2;
	}
	
}
