package application;


import java.io.IOException;

import org.hibernate.SessionFactory;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class InicioController {
	
	SessionFactory sessionFactory;
	
	public InicioController(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@FXML
	private TextField txtUsuario, txtPass;
	@FXML
	private Label lblInicio, lblUser, lblPass;
	@FXML
	private Button btnAceptar;
	@FXML
	private Pane paneP;
	
	public void aceptarLogin(ActionEvent ev) throws IOException {
		Stage stage = new Stage();
		PrincipalController principal = new PrincipalController(sessionFactory);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Principal.fxml"));
		loader.setController(principal);
		Pane pane = (Pane)loader.load();
		Scene scene = new Scene(pane,1600,800);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setTitle("Anima Sheet Manager");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
		((Node)ev.getSource()).getScene().getWindow().hide();
	}	
	
}
