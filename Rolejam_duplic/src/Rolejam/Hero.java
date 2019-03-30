package Rolejam;


public class Hero extends Unit {

	boolean HeroCanLevelUp;
	
public Hero() {
	
	MaxHP = 50;
	CurrentHP = MaxHP;
	AttackPower = 4;
	AttackSpeed = 5;
	Defence = 1;
	Level = 1;
	ExpCurrent = 0;
	ExpMax = 5;
	
	
}
	public void giveExpToHero(int localExpTakes) {
		ExpCurrent = ExpCurrent + localExpTakes;
	}

	public boolean canHeroLevelUp() {
		return Boolean.valueOf(ExpCurrent >= ExpMax);
	}
	
	public boolean haveExpToNextLevel() {
		if((ExpCurrent >= ExpMax) && canHeroLevelUp() == true) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int howMuchExpNeedToNextLevel() {
		ExpToNextLevel = ExpCurrent - ExpMax;
		return ExpToNextLevel;
	}
	
	public void TryTolevelUP() {
		if(canHeroLevelUp() == true) {
			if(haveExpToNextLevel() == true) {
				Level++;
				ExpCurrent = howMuchExpNeedToNextLevel();
		}
			else {
				Level++;
			}
		
		}
	}
	
	
	
	
	
}