package application;
	
import org.hibernate.SessionFactory;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import modelo.ConsultasHibernate;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			ConsultasHibernate ch = new ConsultasHibernate();
			SessionFactory sf = ch.obtenerSessionFactory();
			primaryStage = new Stage();
			InicioController inicio = new InicioController(sf);
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Inicio.fxml"));
			loader.setController(inicio);
			Pane pane = (Pane)loader.load();
			Scene scene = new Scene(pane,1200,800);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Anima Sheet Manager");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}
