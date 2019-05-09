package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	public static String Stock_name="name of stock";
	
	
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			
			
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Main_Page.fxml"));
			Scene scene = new Scene(root,841,698);
		
			primaryStage.setScene(scene);
			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	
		
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	
		
		
	public static void SwitchPageto(ActionEvent event,String fxmldocumentstr) {
			try {
			Parent root = FXMLLoader.load(application.Main.class.getResource(fxmldocumentstr)); 
			Scene scene = new Scene(root,841,698);
			Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();
			
			
			
			}catch(Exception e) { e.printStackTrace();}
			
			
			
			
			
			
			
		
			
	}
	
	
	
	
	
	

	
	
	
	
	

}
