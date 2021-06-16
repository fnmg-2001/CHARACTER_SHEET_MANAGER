package application;

import java.io.IOException;
import java.util.List;

import org.hibernate.SessionFactory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelo.ConsultasHibernate;
import modelo.Personaje;
import modelo.TablaPersonajes;


public class PrincipalController {
	
	ConsultasHibernate ch;
	SessionFactory sessionFactory;
	
	@FXML
	ListView<String> listPersonajes;
	
	@FXML
	TableView<TablaPersonajes> tableViewPersonaje;
	
	@FXML
	TableColumn<TablaPersonajes, String> colNombrePersonaje, colNivelPersonaje, colRazaPersonaje, colCategoriaPersonaje;
	
	
	public PrincipalController(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	
	@FXML
	public void initialize(){
		this.ch = new ConsultasHibernate();
		
		List<Personaje> personajes= ch.listaPersonajes(sessionFactory);
		
		if (!personajes.isEmpty()) {
			ObservableList<TablaPersonajes> tablaPersonajes = FXCollections.observableArrayList();
			TablaPersonajes tablaPersonaje;
			
			for (Personaje personaje : personajes) {
				String nombre = personaje.getNombre();
				String nivel = String.valueOf(personaje.getNivel());
				String categoria = personaje.getCategoria().getNombre();
				String raza = personaje.getRaza().getNombre();
				tablaPersonaje = new TablaPersonajes(personaje.getIdPersonaje(),nombre, nivel, categoria, raza);
				tablaPersonajes.add(tablaPersonaje);
				
			}
			
			colNombrePersonaje.setCellValueFactory(new PropertyValueFactory<TablaPersonajes, String>("colNombre"));
			colNivelPersonaje.setCellValueFactory(new PropertyValueFactory<TablaPersonajes, String>("colNivel"));
			colRazaPersonaje.setCellValueFactory(new PropertyValueFactory<TablaPersonajes, String>("colRaza"));
			colCategoriaPersonaje.setCellValueFactory(new PropertyValueFactory<TablaPersonajes, String>("colCategoria"));
			
			tableViewPersonaje.setItems(tablaPersonajes);
		}
		
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
	
	public void modificarPersonaje(ActionEvent ev) throws IOException {
		Personaje personaje = ch.obtenerPersonaje(sessionFactory, tableViewPersonaje.getSelectionModel().getSelectedItem().getIdPersonaje());
		Stage stage = new Stage();
		PersonajeController personajeController = new PersonajeController(sessionFactory, personaje.getCategoria().getNombre(), personaje.getRaza().getNombre(),personaje);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Personaje.fxml"));
		loader.setController(personajeController);
		TabPane pane = (TabPane)loader.load();
		Scene scene = new Scene(pane,1200,800);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setTitle("Anima Sheet Manager");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
		((Node)ev.getSource()).getScene().getWindow().hide();
	}
	
	public void eliminarPersonaje(ActionEvent ev) throws IOException {
		ch.eliminarPersonaje(sessionFactory, tableViewPersonaje.getSelectionModel().getSelectedItem().getIdPersonaje());
		tableViewPersonaje.refresh();
		
		List<Personaje> personajes= ch.listaPersonajes(sessionFactory);
		
		if (!personajes.isEmpty()) {
			ObservableList<TablaPersonajes> tablaPersonajes = FXCollections.observableArrayList();
			TablaPersonajes tablaPersonaje;
			
			for (Personaje personaje : personajes) {
				String nombre = personaje.getNombre();
				String nivel = String.valueOf(personaje.getNivel());
				String categoria = personaje.getCategoria().getNombre();
				String raza = personaje.getRaza().getNombre();
				tablaPersonaje = new TablaPersonajes(personaje.getIdPersonaje(),nombre, nivel, categoria, raza);
				tablaPersonajes.add(tablaPersonaje);
				
			}
			
			colNombrePersonaje.setCellValueFactory(new PropertyValueFactory<TablaPersonajes, String>("colNombre"));
			colNivelPersonaje.setCellValueFactory(new PropertyValueFactory<TablaPersonajes, String>("colNivel"));
			colRazaPersonaje.setCellValueFactory(new PropertyValueFactory<TablaPersonajes, String>("colRaza"));
			colCategoriaPersonaje.setCellValueFactory(new PropertyValueFactory<TablaPersonajes, String>("colCategoria"));
			
			
			tableViewPersonaje.setItems(tablaPersonajes);
			tableViewPersonaje.refresh();
			
		}
		
	}
	
}
