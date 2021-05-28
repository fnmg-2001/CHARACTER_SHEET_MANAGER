package application;

import java.io.IOException;

import org.hibernate.SessionFactory;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class PrincipalController {
	
	SessionFactory sessionFactory;
	
	@FXML
	ListView<String> listPersonajes;
	
	
	public PrincipalController(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	
	@FXML
	public void initialize(){
		
		
	}
	
	public void addPersonaje(ActionEvent ev) throws IOException {
		Stage stage = new Stage();
		RazaController razaController = new RazaController(sessionFactory);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Raza.fxml"));
		loader.setController(razaController);
		Pane pane = (Pane)loader.load();
		Scene scene = new Scene(pane,1190,790);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setTitle("Anima Sheet Manager");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
		((Node)ev.getSource()).getScene().getWindow().hide();
	}
	
}
