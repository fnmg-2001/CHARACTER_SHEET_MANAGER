package application;

import java.io.File;

import org.hibernate.SessionFactory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Accordion;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import modelo.AccionesTurno;
import modelo.CaracteristicaSeleccionada;
import modelo.ConsultasHibernate;
import modelo.ValorConstitucion;
import modelo.VentajaSeleccionada;

public class PersonajeController {
	
	SessionFactory sessionFactory;
	
	@FXML
	ImageView imagenChar, iD10Apariencia;
	
	@FXML
	Accordion acPrincipalHabilidadesSecundarias;
	
	@FXML
	Pane pPersonajeChar, pD10Apariencia; 
	
	@FXML
	TitledPane tpAtleticas;
	
	@FXML
	TextField tApariencia, tCansancioBase, tCansancioEspecial, tCansancioTotal, tTurnoBase, tTurnoAgilidad, tTurnoDestreza, tTurnoCategoria, tTurnoArmadura,
	tTurnoDesarmado, tTurnoEspecial, tTurnoTotal, tPuntosVidaBase, tPuntosVidaCategoria, tPuntosVidaTotales, tRegeneracion, tCuracionDia, tNegativoDia, tPuntosVidaEspecial,
	tAccionesTurno;
	
	@FXML
	TableView<CaracteristicaSeleccionada> tableViewCaracteristicas;
	
	@FXML
	TableView<String> tableViewPuntosCreacion;
	
	@FXML
	TableView tableViewVentaja;
	
	@FXML
	TableColumn<CaracteristicaSeleccionada, String> colBase, colTemp, colTotal, colBono;
	
	@FXML
	TableColumn<ComboBox, String> ventajaNombre, ventajaCoste;
	
	@FXML
	TableColumn<CaracteristicaSeleccionada, String> colPuntos;
	
	public PersonajeController(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@FXML
	public void initialize(){
		acPrincipalHabilidadesSecundarias.setExpandedPane(tpAtleticas);
		
		int puntosCaracteristica=0;
		ObservableList<CaracteristicaSeleccionada> caracteristicas = FXCollections.observableArrayList(
				new CaracteristicaSeleccionada("AGI","0","0"),
				new CaracteristicaSeleccionada("CON","0","0"),
				new CaracteristicaSeleccionada("FUE","0","0"),
				new CaracteristicaSeleccionada("DES","0","0"),
				new CaracteristicaSeleccionada("INT","0","0"),
				new CaracteristicaSeleccionada("PER","0","0"),
				new CaracteristicaSeleccionada("POD","0","0"),
				new CaracteristicaSeleccionada("VOL","0","0"));
		
		
		colPuntos.setCellValueFactory(new PropertyValueFactory<CaracteristicaSeleccionada, String>("nombreCaracteristica"));
		colBase.setCellValueFactory(new PropertyValueFactory<CaracteristicaSeleccionada, String>("baseCaracteristica"));
		colTemp.setCellValueFactory(new PropertyValueFactory<CaracteristicaSeleccionada, String>("tempCaracteristica"));
		colTotal.setCellValueFactory(new PropertyValueFactory<CaracteristicaSeleccionada, String>("totalCaracteristica"));
		colBono.setCellValueFactory(new PropertyValueFactory<CaracteristicaSeleccionada, String>("bonoCaracteristica"));
		
		for (CaracteristicaSeleccionada caracteristicaSeleccionada : caracteristicas) {
			if (Integer.parseInt(caracteristicaSeleccionada.getTotalCaracteristica())>=10) {
				puntosCaracteristica = puntosCaracteristica + (Integer.parseInt(caracteristicaSeleccionada.getTotalCaracteristica())+1);
			}else {
				puntosCaracteristica = puntosCaracteristica + Integer.parseInt(caracteristicaSeleccionada.getTotalCaracteristica());
			}
			
		}
		
		colBase.setCellFactory(TextFieldTableCell.forTableColumn());
		colTemp.setCellFactory(TextFieldTableCell.forTableColumn());
		colPuntos.setText(puntosCaracteristica+".pts");
		tableViewCaracteristicas.setItems(caracteristicas);
		
		tCansancioBase.setText(String.valueOf(tableViewCaracteristicas.getItems().get(2).getTotalCaracteristica()));
		tCansancioEspecial.setText("0");
		tCansancioTotal.setText(String.valueOf(String.valueOf(Integer.parseInt(tableViewCaracteristicas.getItems().get(2).getTotalCaracteristica())+Integer.parseInt(tCansancioEspecial.getText()))));
	}
	
	public void cambiarBase (TableColumn.CellEditEvent<CaracteristicaSeleccionada, String> cellEditEvent) {
		CaracteristicaSeleccionada caracteristica = tableViewCaracteristicas.getSelectionModel().getSelectedItem();
		caracteristica.setBaseCaracteristica(cellEditEvent.getNewValue());
		caracteristica.setTotalCaracteristica(String.valueOf(Integer.parseInt(caracteristica.getBaseCaracteristica())+Integer.parseInt(caracteristica.getTempCaracteristica())));
		caracteristica.setBonoCaracteristica(caracteristica.getTotalCaracteristica());
		AccionesTurno accionesTurno = new AccionesTurno(tableViewCaracteristicas.getItems().get(4).getTotalCaracteristica(),caracteristica.getTotalCaracteristica());
		
		if (tableViewCaracteristicas.getSelectionModel().getSelectedItem().getNombreCaracteristica().equals("AGI")) {
			tTurnoAgilidad.setText(caracteristica.getBonoCaracteristica());
			tAccionesTurno.setText(accionesTurno.getNumeroAcciones());
			
		} else if (tableViewCaracteristicas.getSelectionModel().getSelectedItem().getNombreCaracteristica().equals("CON")) {
			ValorConstitucion valorConstitucion = new ValorConstitucion(caracteristica.getTotalCaracteristica());
			tCansancioBase.setText(caracteristica.getTotalCaracteristica());
			tCansancioTotal.setText(String.valueOf(Integer.parseInt(caracteristica.getTotalCaracteristica())+Integer.parseInt(tCansancioEspecial.getText())));
			tPuntosVidaBase.setText(valorConstitucion.getPuntosVidaBase());
			tPuntosVidaTotales.setText(String.valueOf(Integer.parseInt(valorConstitucion.getPuntosVidaBase())+Integer.parseInt(tPuntosVidaCategoria.getText())));
			tRegeneracion.setText(valorConstitucion.getRegeneracionBase());
			tCuracionDia.setText(valorConstitucion.getCuracionDia());
			tNegativoDia.setText(valorConstitucion.getNegativoDia());
			
		} else if (tableViewCaracteristicas.getSelectionModel().getSelectedItem().getNombreCaracteristica().equals("DES")) {
			tTurnoDestreza.setText(caracteristica.getBonoCaracteristica());
			tAccionesTurno.setText(accionesTurno.getNumeroAcciones());
			
		}
		
		tableViewCaracteristicas.refresh();
		System.out.println(caracteristica.getBonoCaracteristica());
	}
	
	public void cambiarTemporal (TableColumn.CellEditEvent<CaracteristicaSeleccionada, String> cellEditEvent) {
		CaracteristicaSeleccionada caracteristica = tableViewCaracteristicas.getSelectionModel().getSelectedItem();
		caracteristica.setTempCaracteristica(cellEditEvent.getNewValue());
		caracteristica.setTotalCaracteristica(String.valueOf(Integer.parseInt(caracteristica.getBaseCaracteristica())+Integer.parseInt(caracteristica.getTempCaracteristica())));
		caracteristica.setBonoCaracteristica(caracteristica.getTotalCaracteristica());
		AccionesTurno accionesTurno = new AccionesTurno(tableViewCaracteristicas.getItems().get(4).getTotalCaracteristica(),caracteristica.getTotalCaracteristica());
		
		if (tableViewCaracteristicas.getSelectionModel().getSelectedItem().getNombreCaracteristica().equals("AGI")) {
			tTurnoAgilidad.setText(caracteristica.getBonoCaracteristica());
			tAccionesTurno.setText(accionesTurno.getNumeroAcciones());
			
		} else if (tableViewCaracteristicas.getSelectionModel().getSelectedItem().getNombreCaracteristica().equals("CON")) {
			ValorConstitucion valorConstitucion = new ValorConstitucion(caracteristica.getTotalCaracteristica());
			tCansancioBase.setText(caracteristica.getTotalCaracteristica());
			tCansancioTotal.setText(String.valueOf(Integer.parseInt(caracteristica.getTotalCaracteristica())+Integer.parseInt(tCansancioEspecial.getText())));
			tPuntosVidaBase.setText(valorConstitucion.getPuntosVidaBase());
			tPuntosVidaTotales.setText(String.valueOf(Integer.parseInt(valorConstitucion.getPuntosVidaBase())+Integer.parseInt(tPuntosVidaCategoria.getText())));
			tRegeneracion.setText(valorConstitucion.getRegeneracionBase());
			tCuracionDia.setText(valorConstitucion.getCuracionDia());
			tNegativoDia.setText(valorConstitucion.getNegativoDia());
			
		} else if (tableViewCaracteristicas.getSelectionModel().getSelectedItem().getNombreCaracteristica().equals("DES")) {
			tTurnoDestreza.setText(caracteristica.getBonoCaracteristica());
			tAccionesTurno.setText(accionesTurno.getNumeroAcciones());
			
		}
		
		tableViewCaracteristicas.refresh();
		System.out.println(caracteristica.getBonoCaracteristica());
	}
	
	public void cambiarValorCansancio(KeyEvent ev){
		System.out.println(ev.getCode()+" "+ev.getText());
		
		if (ev.getCode() == KeyCode.DIGIT1||ev.getCode() == KeyCode.DIGIT2||ev.getCode() == KeyCode.DIGIT3||ev.getCode() == KeyCode.DIGIT4||
				ev.getCode() == KeyCode.DIGIT5||ev.getCode() == KeyCode.DIGIT6||ev.getCode() == KeyCode.DIGIT7||ev.getCode() == KeyCode.DIGIT8||
				ev.getCode() == KeyCode.DIGIT9||ev.getCode() == KeyCode.DIGIT0||ev.getCode() == KeyCode.NUMPAD1||ev.getCode() == KeyCode.NUMPAD2||
				ev.getCode() == KeyCode.NUMPAD3||ev.getCode() == KeyCode.NUMPAD4||ev.getCode() == KeyCode.NUMPAD5||ev.getCode() == KeyCode.NUMPAD6||
				ev.getCode() == KeyCode.NUMPAD7||ev.getCode() == KeyCode.NUMPAD8||ev.getCode() == KeyCode.NUMPAD9||ev.getCode() == KeyCode.NUMPAD0||
				ev.getCode() == KeyCode.MINUS || ev.getCode() == KeyCode.BACK_SPACE) {
				
			if (tCansancioEspecial.getText().isEmpty()) {
				tCansancioTotal.setText(String.valueOf(tableViewCaracteristicas.getItems().get(2).getTotalCaracteristica()+Integer.parseInt("0")));
			}
			else {
				tCansancioTotal.setText(String.valueOf(tableViewCaracteristicas.getItems().get(2).getTotalCaracteristica()+Integer.parseInt(tCansancioEspecial.getText())));
			}
				
			} else {
				Alert alerta = new Alert(Alert.AlertType.WARNING);
				alerta.setHeaderText(null);
			    alerta.setTitle("Info");
			    alerta.setContentText("No se pueden escribir caracteres diferentes a un numero");
			    alerta.showAndWait();
			}
	}
	
	public void seleccionarImagenPersonaje(MouseEvent ev) {
		FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Buscar Imagen");

        // Agregar filtros para facilitar la busqueda
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );

        // Obtener la imagen seleccionada
        File imgFile = fileChooser.showOpenDialog(((Node)ev.getSource()).getScene().getWindow());

        // Mostar la imagen
        if (imgFile != null) {
            Image image = new Image("file:" + imgFile.getAbsolutePath());
            imagenChar.setImage(image);
        }
	}
	
	public void tirarApariencia(MouseEvent ev) {
		int apariencia = (int)(Math.random()*10)+1;
		tApariencia.setText(String.valueOf(apariencia));
	}
	
	public void PaneImagenPersonaje(MouseEvent ev) {
		pPersonajeChar.setStyle("-fx-background-color: #d4d5d6");
	}
	
	public void sinPaneImagenPersonaje(MouseEvent ev) {
		pPersonajeChar.setStyle(null);
	}
	
	public void paneImagenApariencia(MouseEvent ev) {
		pD10Apariencia.setStyle("-fx-background-color: #ff675c");
	}
	
	public void paneImagenApariencia2(MouseEvent ev) {
		pD10Apariencia.setStyle("-fx-background-color: #ff5145");
	}
	
	public void sinPaneImagenApariencia(MouseEvent ev) {
		pD10Apariencia.setStyle(null);
	}
	
	
}
