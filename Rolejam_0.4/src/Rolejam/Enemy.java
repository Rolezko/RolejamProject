package Rolejam;

import java.util.Random;

public class Enemy extends Unit {
Random Random = new Random();
int CostExp = 1 + Random.nextInt(4);
	
	
	public Enemy() {
		MaxHP = 2 + Random.nextInt(7);
		CurrentHP = MaxHP;
		AttackPower = 2 + Random.nextInt(5);
		AttackSpeed = 2 + Random.nextInt(2);
	}
	
public int EnemyAIAttack() {
	return 1 + Random.nextInt(3);
}

public int EnemyAIDefence() {
	return 1 + Random.nextInt(3);
}
	
}
