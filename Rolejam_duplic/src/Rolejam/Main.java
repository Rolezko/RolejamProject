package Rolejam;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application {
	
	
	Hero Hero = new Hero();
	Enemy Enemy = new Enemy();

	
	@Override
	public void start(Stage primaryStage) {
		
	 try {
         FXMLLoader loader=new FXMLLoader(getClass().getResource("/Rolejam/MainScene.fxml"));
         Parent root = (Parent) loader.load();
         Stage stage = new Stage();
         stage.setTitle("MainScene");
         stage.setScene(new Scene(root));
         stage.setResizable(false);
         MainSceneController localMainController = new MainSceneController();
         localMainController = loader.getController();
         localMainController.Hero = Hero;
         localMainController.UpdateHeroStat();
         stage.show();
      
     } 
	 catch (IOException e) {
         e.printStackTrace();
     }
	}
	

	
	
	public static void main(String[] args) {


	launch(args);
		
		
		
	}
}