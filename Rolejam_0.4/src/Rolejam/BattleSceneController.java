package Rolejam;


import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

public class BattleSceneController implements Initializable {
	
	Hero Hero = new Hero();
	
	Enemy Enemy = new Enemy();
	
	MainSceneController localMainSceneController;
	
	
	@FXML
	Label HPEnemyLabel, AttackPowerEnemyLabel, SpeedEnemyLabel, DefenceEnemyLabel;
	@FXML
	Label HPHeroLabel, AttackPowerHeroLabel, SpeedHeroLabel, DefenceHeroLabel;
	@FXML
	ToggleButton hAttackHeadTG, hAttackBodyTG, hAttackLegTG ,hDefenceHeadTG, hDefenceBodyTG, hDefenceLegTG;
	@FXML
	ToggleButton eAttackHeadTG, eAttackBodyTG, eAttackLegTG ,eDefenceHeadTG, eDefenceBodyTG, eDefenceLegTG;
	@FXML
	Button hReadyB, eReadyB;
	@FXML
	TextArea LogsTA;
	@FXML
	ProgressBar HPProgressBarHero, HPProgressBarEnemy;
	
	
	
	boolean hAttackSelected, hDefenceSelected, 
	EnemyAHeadSel, EnemyABodySel, EnemyALegSel, EnemyDHeadSel, EnemyDBodySel, EnemyDLegSel,
	HeroAHeadSel, HeroABodySel, HeroALegSel, HeroDHeadSel, HeroDBodySel, HeroDLegSel,
	IsHeroAlive, IsEnemyAlive;
	
	
	
	public void EnemyDeathAction() {
		HPEnemyLabel.setText(String.valueOf(0 + "/" + String.valueOf(Enemy.MaxHP)));
		HPProgressBarEnemy.setProgress((0));
		TextIfHeroWin("Hero", "Enemy", Enemy.CostExp);
			IsEnemyAlive = false;
			Hero.ExpCurrent = Hero.ExpCurrent + Enemy.CostExp;
			Hero.TryTolevelUP();
	}
	
	public void SettingEnemyParam() {
		if(Enemy.CurrentHP <= 0) {
			EnemyDeathAction();

	}
		else {
	    HPEnemyLabel.setText(String.valueOf(Enemy.CurrentHP) + "/" + String.valueOf(Enemy.MaxHP));
	    HPProgressBarEnemy.setProgress(((double) Enemy.CurrentHP / (double) Enemy.MaxHP));
		AttackPowerEnemyLabel.setText(String.valueOf(Enemy.AttackPower));
		SpeedEnemyLabel.setText(String.valueOf(Enemy.AttackSpeed));
		DefenceEnemyLabel.setText(String.valueOf(Enemy.Defence));
			IsEnemyAlive = true;
		}
	}
	
	public void SettingHeroParam() { // ���� �������� ����
		
		
		if(Hero.CurrentHP <= 0) {
			HPHeroLabel.setText(String.valueOf(0 + "/" + String.valueOf(Hero.MaxHP)));
			HPProgressBarHero.setProgress((0));
			IsHeroAlive = false;

		}
		else {
		HPHeroLabel.setText(String.valueOf(Hero.CurrentHP) + "/" + String.valueOf(Hero.MaxHP));
		HPProgressBarHero.setProgress(((double) Hero.CurrentHP / (double) Hero.MaxHP));
		AttackPowerHeroLabel.setText(String.valueOf(Hero.AttackPower));
		SpeedHeroLabel.setText(String.valueOf(Hero.AttackSpeed));
		DefenceHeroLabel.setText(String.valueOf(Hero.Defence));
		
			IsHeroAlive = true;
		}
		
	}
	
	public void UpdateAllParam() {
		
		SettingEnemyParam();
		SettingHeroParam();
	}
	
	@FXML
	public void HeroAttackChooseBs() {

		
		if(hAttackHeadTG.isSelected() == true) {
			hAttackHeadTG.setStyle("-fx-border-radius: 3;-fx-border-width: 1.2 ;-fx-border-color: #FF0000;");
			hAttackBodyTG.setDisable(true);
			hAttackLegTG.setDisable(true);
			hAttackSelected = true;
			HeroAHeadSel = true;
		}
		
		if(hAttackHeadTG.isSelected() == false) {
			HeroAHeadSel = false;
		}
		
		
		if(hAttackBodyTG.isSelected() == true) {
			hAttackBodyTG.setStyle("-fx-border-radius: 3;-fx-border-width: 1.2 ;-fx-border-color: #FF0000;");
			hAttackHeadTG.setDisable(true);
			hAttackLegTG.setDisable(true);
			hAttackSelected = true;
			HeroABodySel = true;
		}
		
		if(hAttackBodyTG.isSelected()== false) {
			HeroABodySel = false;
		}
		

		if(hAttackLegTG.isSelected() == true) {
			hAttackLegTG.setStyle("-fx-border-radius: 3;-fx-border-width: 1.2 ;-fx-border-color: #FF0000;");
			hAttackHeadTG.setDisable(true);
			hAttackBodyTG.setDisable(true);
			hAttackSelected = true;
			HeroALegSel = true;
		}
		
		if(hAttackLegTG.isSelected() == false) {
			HeroALegSel = false;
		}
		
		if(hAttackHeadTG.isSelected() == false && hAttackBodyTG.isSelected() == false && hAttackLegTG.isSelected() == false) {
		hAttackHeadTG.setDisable(false);
		hAttackBodyTG.setDisable(false);
		hAttackLegTG.setDisable(false);
		hAttackHeadTG.setStyle(null);
		hAttackBodyTG.setStyle(null);
		hAttackLegTG.setStyle(null);
		hAttackSelected = false;
		
		
		}
		
		isHeroReady();
				
	}
	
	public void isHeroReady() {
		
		if(hAttackSelected == true && hDefenceSelected == true) {
			hReadyB.setDisable(false);
		}
		else {
			hReadyB.setDisable(true);
		}
	}
	
	@FXML
	public void HeroDefenceChooseBs() {
		
		if(hDefenceHeadTG.isSelected()) {
			hDefenceHeadTG.setStyle("-fx-border-radius: 3;-fx-border-width: 1.2 ;-fx-border-color: #0000FF;");
			hDefenceBodyTG.setDisable(true);
			hDefenceLegTG.setDisable(true);
			hDefenceSelected = true;
			HeroDHeadSel = true;
		}
		
		if(!hDefenceHeadTG.isSelected()) {
			HeroDHeadSel = false;
		}
		
		
		if(hDefenceBodyTG.isSelected()) {
			hDefenceBodyTG.setStyle("-fx-border-radius: 3;-fx-border-width: 1.2 ;-fx-border-color: #0000FF;");
			hDefenceHeadTG.setDisable(true);
			hDefenceLegTG.setDisable(true);
			hDefenceSelected = true;
			HeroDBodySel = true;
		}
		if(!hDefenceBodyTG.isSelected()) {
			HeroDBodySel = false;
		}

		if(hDefenceLegTG.isSelected()) {
			hDefenceLegTG.setStyle("-fx-border-radius: 3;-fx-border-width: 1.2 ;-fx-border-color: #0000FF;");
			hDefenceHeadTG.setDisable(true);
			hDefenceBodyTG.setDisable(true);
			hDefenceSelected = true;
			HeroDLegSel = true;
		}
		if(!hDefenceLegTG.isSelected()) {
			HeroDLegSel = false;
		}
		
		
		if(!hDefenceHeadTG.isSelected() && !hDefenceBodyTG.isSelected() && !hDefenceLegTG.isSelected()) {
		hDefenceHeadTG.setDisable(false);
		hDefenceBodyTG.setDisable(false);
		hDefenceLegTG.setDisable(false);
		hDefenceHeadTG.setStyle(null);
		hDefenceBodyTG.setStyle(null);
		hDefenceLegTG.setStyle(null);
		hDefenceSelected = false;
		
		}
		
		isHeroReady();
		
	}
	
	@FXML
	public void TheHeroIsReady() {
		if(IsHeroAlive == true && IsEnemyAlive == true) {
		int localEnemyAttack = Enemy.EnemyAIAttack();
		int localEnemyDefence = Enemy.EnemyAIDefence();
		
		EnemyAHeadSel = false;
		EnemyABodySel = false;
		EnemyALegSel = false;
		EnemyDHeadSel = false;
		EnemyDBodySel = false;
		EnemyDLegSel = false;
		
	if(localEnemyAttack == 1) {
		EnemyAHeadSel = true;
		}
	if(localEnemyAttack == 2) {
		EnemyABodySel = true;
		}
	if(localEnemyAttack == 3) {
		EnemyALegSel = true;
		}
	
	if(localEnemyDefence == 1) {
		EnemyDHeadSel = true;
		}
	if(localEnemyDefence == 2) {
		EnemyDBodySel = true;
		}
	if(localEnemyDefence == 3) {
		EnemyDLegSel = true;
		}
	EnemyAttackChooseBs();
	EnemyDefenceChooseBs();
	FightHeroVsEnemy();
	FightEnemyVsHero();
	

	UpdateAllParam();
		}
		
		else {
			Stage stage = (Stage) hReadyB.getScene().getWindow();
		    GetHeroInfoFromBattleScene();
			stage.close();
		    
		}
			
	}

	public void EnemyAttackChooseBs() {
		if (EnemyAHeadSel == true) {	
			eAttackHeadTG.setStyle("-fx-border-radius: 3;-fx-border-width: 1.2 ;-fx-border-color: #FF0000;");
		}
		if (EnemyAHeadSel == false) {
			eAttackHeadTG.setStyle(null);
		}
		
		if (EnemyABodySel == true) {	
			eAttackBodyTG.setStyle("-fx-border-radius: 3;-fx-border-width: 1.2 ;-fx-border-color: #FF0000;");
		}
		if (EnemyABodySel == false) {	
			eAttackBodyTG.setStyle(null);
		}
		
		if (EnemyALegSel == true) {	
			eAttackLegTG.setStyle("-fx-border-radius: 3;-fx-border-width: 1.2 ;-fx-border-color: #FF0000;");
		}
		if (EnemyALegSel == false) {	
			eAttackLegTG.setStyle(null);
		}
	}
	public void EnemyDefenceChooseBs() {
		if (EnemyDHeadSel == true) {	
			eDefenceHeadTG.setStyle("-fx-border-radius: 3;-fx-border-width: 1.2 ;-fx-border-color: #0000FF;");
		}
		if (EnemyDHeadSel == false) {
			eDefenceHeadTG.setStyle(null);
		}
		
		if (EnemyDBodySel == true) {	
			eDefenceBodyTG.setStyle("-fx-border-radius: 3;-fx-border-width: 1.2 ;-fx-border-color: #0000FF;");
		}
		if (EnemyDBodySel == false) {	
			eDefenceBodyTG.setStyle(null);
		}
		
		if (EnemyDLegSel == true) {	
			eDefenceLegTG.setStyle("-fx-border-radius: 3;-fx-border-width: 1.2 ;-fx-border-color: #0000FF;");
		}
		if (EnemyDLegSel == false) {	
			eDefenceLegTG.setStyle(null);
		}
	}
	
	public void FightHeroVsEnemy() {
		
		 if(HeroAHeadSel == true) {
			if(EnemyDHeadSel == false) {
				Enemy.CurrentHP = Enemy.CurrentHP - (Hero.AttackPower - Enemy.Defence);
				TextIfDamaged("Hero", "Enemy", "Head", String.valueOf(Hero.AttackPower - Enemy.Defence));
			}
			if(EnemyDHeadSel == true) {
				TextIfBlocked("Hero", "Enemy", "Head");
			}
			
		}
		if(HeroABodySel == true) {
			if(EnemyDBodySel == false) {
				Enemy.CurrentHP = Enemy.CurrentHP - (Hero.AttackPower - Enemy.Defence);
				TextIfDamaged("Hero", "Enemy", "Body", String.valueOf(Hero.AttackPower - Enemy.Defence));
			}
			if(EnemyDBodySel == true) {
				TextIfBlocked("Hero", "Enemy", "Body");
			}
		}
		if(HeroALegSel == true) {
			if(EnemyDLegSel == false) {
				Enemy.CurrentHP = Enemy.CurrentHP - (Hero.AttackPower - Enemy.Defence);
				TextIfDamaged("Hero", "Enemy", "Leg", String.valueOf(Hero.AttackPower - Enemy.Defence));
			}
			if(EnemyDLegSel == true) {
				TextIfBlocked("Hero", "Enemy", "Leg");
			}
		}
		
	}
	
	public void FightEnemyVsHero() {
		
		 if(EnemyAHeadSel == true) {
			if(HeroDHeadSel == false) {
				Hero.CurrentHP = Hero.CurrentHP - (Enemy.AttackPower - Hero.Defence);
				TextIfDamaged("Enemy", "Hero", "Head", String.valueOf(Enemy.AttackPower - Hero.Defence));
			}
			if(HeroDHeadSel == true) {
				TextIfBlocked("Enemy", "Hero", "Head");
			}
			
		}
		if(EnemyABodySel == true) {
			if(HeroDBodySel == false) {
				Hero.CurrentHP = Hero.CurrentHP - (Enemy.AttackPower - Hero.Defence);
				TextIfDamaged("Enemy", "Hero", "Body", String.valueOf(Enemy.AttackPower - Hero.Defence));
			}
			if(HeroDBodySel == true) {
				TextIfBlocked("Enemy", "Hero", "Body");
				}
		}
		if(EnemyALegSel == true) {
			if(HeroDLegSel == false) {
				Hero.CurrentHP = Hero.CurrentHP - (Enemy.AttackPower - Hero.Defence);
				TextIfDamaged("Enemy", "Hero", "Leg", String.valueOf(Enemy.AttackPower - Hero.Defence));
			}
			if(HeroDLegSel == true) {
				TextIfBlocked("Enemy", "Hero", "Leg");
			}
		}
		
	}
	
	public void AddNextTextToLog(String localInfo) {

		LogsTA.appendText("\n");
		LogsTA.appendText(new Date().toString() + ": " + localInfo);
	}
	
	public void TextIfBlocked(String Who, String toWhom, String Where) {
		AddNextTextToLog(Who + " Attack " + toWhom + " in " + Where + ", but attack is blocked!");
	}

	public void TextIfDamaged(String Who, String toWhom, String Where,String howMuchDamage) {
		AddNextTextToLog(Who + " Attack " + toWhom + " in " + Where + ", and deal to " + toWhom + " " + howMuchDamage + " damage.");
	}
	
	public void TextIfHeroWin(String Who, String versusWho, int HowMuchExpGained) {
		AddNextTextToLog("The " + Who + " and win the battle, " + Who + " gain " + HowMuchExpGained + " Exp.");
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	
	public void GetHeroInfoFromBattleScene() {
		localMainSceneController.SetHeroInfoFromBattleScene(Hero);
		localMainSceneController.UpdateHeroStat();
	}
	
	public void SetMainController(MainSceneController localMainSceneController) {
		this.localMainSceneController = localMainSceneController;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
