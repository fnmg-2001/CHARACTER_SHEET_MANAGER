package application;

import java.io.File;

import org.hibernate.SessionFactory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Accordion;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
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
import modelo.Categoria;
import modelo.ConsultasHibernate;
import modelo.PdsCombate;
import modelo.Raza;
import modelo.ResistenciasTabla;
import modelo.ValorConstitucion;
import modelo.VentajaSeleccionada;

public class PersonajeController {
	
	ConsultasHibernate ch;
	SessionFactory sessionFactory;
	Categoria categoriaSeleccionada;
	Raza razaSeleccionada;
	
	@FXML
	ImageView imagenChar, iD10Apariencia;
	
	@FXML
	Accordion acPrincipalHabilidadesSecundarias, acPds;
	
	@FXML
	Pane pPersonajeChar, pD10Apariencia; 
	
	@FXML
	TitledPane tpAtleticas, tpPdsCombate;
	
	@FXML
	TextField tApariencia, tCansancioBase, tCansancioEspecial, tCansancioTotal, tTurnoBase, tTurnoAgilidad, tTurnoDestreza, tTurnoCategoria, tTurnoArmadura,
	tTurnoDesarmado, tTurnoEspecial, tTurnoTotal, tPuntosVidaBase, tPuntosVidaCategoria, tPuntosVidaTotales, tRegeneracion, tCuracionDia, tNegativoDia, tPuntosVidaEspecial,
	tAccionesTurno, tPuntosCreacion, tCategoriaPrimerLv, tNivelTotal, tPdsRestantes, tLlevarArmadura, tHabilidadDefensa, tHabilidadAtaque;
	
	@FXML
	TableView<CaracteristicaSeleccionada> tableViewCaracteristicas;
	
	@FXML
	TableView<ResistenciasTabla> tableViewResistencias;

	@FXML
	TableView<VentajaSeleccionada> tableViewVentaja;
	
	@FXML
	TableView<DesventajaSeleccionada> tableViewDesventaja;
	
	@FXML
	TableView<String> tableViewPuntosCreacion;
	
	@FXML
	TableView<PdsCombate> tableViewCombate;
	
	@FXML
	TableColumn<CaracteristicaSeleccionada, String> colBase, colTemp, colTotal, colBono;
	

	@FXML
	TableColumn<ResistenciasTabla, String> colNombreResistencias, colResistenciasBase, colResistenciasBono, colResistenciasRaza, colResistenciasEspecial, colResistenciasTotal;
	
	@FXML
	TableColumn<VentajaSeleccionada, ComboBox<String>> colVentajaNombre;
	
	@FXML
	TableColumn<VentajaSeleccionada, String> colVentajaCoste;
	
	@FXML
	TableColumn<DesventajaSeleccionada, ComboBox<String>> colDesventajaNombre;

	@FXML
	TableColumn<DesventajaSeleccionada, String> colDesventajaBeneficio;
	
	@FXML
	TableColumn<CaracteristicaSeleccionada, String> colPuntos;
	
	@FXML
	TableColumn<PdsCombate, String> colPdsCombateNombreHabilidad, colPdsCombateCosteHabilidad, colPdsCombatePuntosHabilidad, colPdsCombateBaseHabilidad, colPdsCombateBonoHabilidad, colPdsCombateCategoriaHabilidad,
	colPdsCombateEspecialHabilidad, colPdsCombateTotalHabilidad;
	
	
	public PersonajeController(SessionFactory sessionFactory, String categoria, String raza) {
		this.ch = new ConsultasHibernate();
		this.sessionFactory = sessionFactory;
		this.categoriaSeleccionada = ch.obtenerCategoria(categoria, sessionFactory);
		this.razaSeleccionada = ch.obtenerRaza(raza, sessionFactory);
	}
	
	@FXML
	public void initialize(){
		ObservableList<String> nombreVentajas = ch.obtenerNombresVentaja(sessionFactory);
		ObservableList<String> nombreDesventajas = ch.obtenerNombresDesventaja(sessionFactory);
		acPrincipalHabilidadesSecundarias.setExpandedPane(tpAtleticas);
		acPds.setExpandedPane(tpPdsCombate);
		
		/*------------------------------------------------------Tabla Caracteristicas------------------------------------------------------*/
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
		
		/*------------------------------------------------------Tabla Resistencias------------------------------------------------------*/
		ObservableList<ResistenciasTabla> resistencias = FXCollections.observableArrayList(
				new ResistenciasTabla("Pres. Base","30","0","0","0"),
				new ResistenciasTabla("RF","30","0","0","0"),
				new ResistenciasTabla("RE","30","0","0","0"),
				new ResistenciasTabla("RV","30","0","0","0"),
				new ResistenciasTabla("RM","30","0","0","0"),
				new ResistenciasTabla("RP","30","0","0","0"));
		
		colNombreResistencias.setCellValueFactory(new PropertyValueFactory<ResistenciasTabla, String>("nombreResistencia"));
		colResistenciasBase.setCellValueFactory(new PropertyValueFactory<ResistenciasTabla, String>("presenciaBase")); 
		colResistenciasBono.setCellValueFactory(new PropertyValueFactory<ResistenciasTabla, String>("bonoCaracteristica")); 
		colResistenciasRaza.setCellValueFactory(new PropertyValueFactory<ResistenciasTabla, String>("bonoRaza"));
		colResistenciasEspecial.setCellValueFactory(new PropertyValueFactory<ResistenciasTabla, String>("bonoEspecial"));
		colResistenciasTotal.setCellValueFactory(new PropertyValueFactory<ResistenciasTabla, String>("resistenciaTotal"));
		
		colResistenciasEspecial.setCellFactory(TextFieldTableCell.forTableColumn());
		tableViewResistencias.setItems(resistencias);
		
		/*------------------------------------------------------Tabla Ventajas------------------------------------------------------*/
		ComboBox<String> cVentajas = new ComboBox<String>();
		cVentajas.setItems(nombreVentajas);
		ComboBox<String> cVentajas2 = new ComboBox<String>();
		cVentajas2.setItems(nombreVentajas);
		ComboBox<String> cVentajas3 = new ComboBox<String>();
		cVentajas3.setItems(nombreVentajas);
		ComboBox<String> cVentajas4 = new ComboBox<String>();
		cVentajas4.setItems(nombreVentajas);
		ComboBox<String> cVentajas5 = new ComboBox<String>();
		cVentajas5.setItems(nombreVentajas);
		ComboBox<String> cVentajas6 = new ComboBox<String>();
		cVentajas6.setItems(nombreVentajas);
		ComboBox<String> cVentajas7 = new ComboBox<String>();
		cVentajas7.setItems(nombreVentajas);
		
		ObservableList<VentajaSeleccionada> ventajas = FXCollections.observableArrayList(
				new VentajaSeleccionada(cVentajas,"-"),
				new VentajaSeleccionada(cVentajas2,"-"),
				new VentajaSeleccionada(cVentajas3,"-"),
				new VentajaSeleccionada(cVentajas4,"-"),
				new VentajaSeleccionada(cVentajas5,"-"),
				new VentajaSeleccionada(cVentajas6,"-"),
				new VentajaSeleccionada(cVentajas7,"-"));
		
		colVentajaNombre.setCellValueFactory(new PropertyValueFactory<VentajaSeleccionada, ComboBox<String>>("nombreVentaja"));
		colVentajaCoste.setCellValueFactory(new PropertyValueFactory<VentajaSeleccionada, String>("costeVentaja"));
		
		cVentajas.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				VentajaSeleccionada ventaja = ventajas.get(0);
				ventaja.setCosteVentaja(String.valueOf(ch.obtenerCosteVentajaSeleccionada(sessionFactory, cVentajas.getSelectionModel().getSelectedItem())));
				tableViewVentaja.refresh();
				tPuntosCreacion.setText(String.valueOf(Integer.parseInt(tPuntosCreacion.getText())-Integer.parseInt(ventaja.getCosteVentaja())));
			}
		});
		
		cVentajas2.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				VentajaSeleccionada ventaja = ventajas.get(1);
				ventaja.setCosteVentaja(String.valueOf(ch.obtenerCosteVentajaSeleccionada(sessionFactory, cVentajas2.getSelectionModel().getSelectedItem())));
				tableViewVentaja.refresh();
				tPuntosCreacion.setText(String.valueOf(Integer.parseInt(tPuntosCreacion.getText())-Integer.parseInt(ventaja.getCosteVentaja())));
			}
		});
		
		cVentajas3.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				VentajaSeleccionada ventaja = ventajas.get(2);
				ventaja.setCosteVentaja(String.valueOf(ch.obtenerCosteVentajaSeleccionada(sessionFactory, cVentajas3.getSelectionModel().getSelectedItem())));
				tableViewVentaja.refresh();
				tPuntosCreacion.setText(String.valueOf(Integer.parseInt(tPuntosCreacion.getText())-Integer.parseInt(ventaja.getCosteVentaja())));
			}
		});
		
		cVentajas4.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				VentajaSeleccionada ventaja = ventajas.get(3);
				ventaja.setCosteVentaja(String.valueOf(ch.obtenerCosteVentajaSeleccionada(sessionFactory, cVentajas4.getSelectionModel().getSelectedItem())));
				tableViewVentaja.refresh();
				tPuntosCreacion.setText(String.valueOf(Integer.parseInt(tPuntosCreacion.getText())-Integer.parseInt(ventaja.getCosteVentaja())));
			}
		});
		
		cVentajas5.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				VentajaSeleccionada ventaja = ventajas.get(4);
				ventaja.setCosteVentaja(String.valueOf(ch.obtenerCosteVentajaSeleccionada(sessionFactory, cVentajas5.getSelectionModel().getSelectedItem())));
				tableViewVentaja.refresh();
				tPuntosCreacion.setText(String.valueOf(Integer.parseInt(tPuntosCreacion.getText())-Integer.parseInt(ventaja.getCosteVentaja())));
			}
		});
		
		cVentajas6.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				VentajaSeleccionada ventaja = ventajas.get(5);
				ventaja.setCosteVentaja(String.valueOf(ch.obtenerCosteVentajaSeleccionada(sessionFactory, cVentajas6.getSelectionModel().getSelectedItem())));
				tableViewVentaja.refresh();
				tPuntosCreacion.setText(String.valueOf(Integer.parseInt(tPuntosCreacion.getText())-Integer.parseInt(ventaja.getCosteVentaja())));
			}
		});
		
		cVentajas7.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				VentajaSeleccionada ventaja = ventajas.get(6);
				ventaja.setCosteVentaja(String.valueOf(ch.obtenerCosteVentajaSeleccionada(sessionFactory, cVentajas7.getSelectionModel().getSelectedItem())));
				tableViewVentaja.refresh();
				tPuntosCreacion.setText(String.valueOf(Integer.parseInt(tPuntosCreacion.getText())-Integer.parseInt(ventaja.getCosteVentaja())));
			}
		});
		
//		colVentajaNombre.setCellFactory(ComboBoxTableCell.forTableColumn(new DefaultStringConverter(), nombreVentajas));
		
		tableViewVentaja.setItems(ventajas);
		
		/*------------------------------------------------------Tabla Desventajas------------------------------------------------------*/
		ComboBox<String> cDesventajas = new ComboBox<String>();
		cDesventajas.setItems(nombreDesventajas);
		ComboBox<String> cDesventajas2 = new ComboBox<String>();
		cDesventajas2.setItems(nombreDesventajas);
		ComboBox<String> cDesventajas3 = new ComboBox<String>();
		cDesventajas3.setItems(nombreDesventajas);
		ComboBox<String> cDesventajas4 = new ComboBox<String>();
		cDesventajas4.setItems(nombreDesventajas);
		ComboBox<String> cDesventajas5 = new ComboBox<String>();
		cDesventajas5.setItems(nombreDesventajas);
		ComboBox<String> cDesventajas6 = new ComboBox<String>();
		cDesventajas6.setItems(nombreDesventajas);
		
		ObservableList<DesventajaSeleccionada> desventajas = FXCollections.observableArrayList(
				new DesventajaSeleccionada(cDesventajas,"-"),
				new DesventajaSeleccionada(cDesventajas2,"-"),
				new DesventajaSeleccionada(cDesventajas3,"-"),
				new DesventajaSeleccionada(cDesventajas4,"-"),
				new DesventajaSeleccionada(cDesventajas5,"-"));
		
		colDesventajaNombre.setCellValueFactory(new PropertyValueFactory<DesventajaSeleccionada, ComboBox<String>>("nombreDesventaja"));
		colDesventajaBeneficio.setCellValueFactory(new PropertyValueFactory<DesventajaSeleccionada, String>("beneficioDesventaja"));
		
		cDesventajas.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				DesventajaSeleccionada desventaja = desventajas.get(0);
				desventaja.setBeneficioDesventaja(String.valueOf(ch.obtenerBeneficioDesventajaSeleccionada(sessionFactory, cDesventajas.getSelectionModel().getSelectedItem())));
				tableViewDesventaja.refresh();
				tPuntosCreacion.setText(String.valueOf(Integer.parseInt(tPuntosCreacion.getText())+Integer.parseInt(desventaja.getBeneficioDesventaja())));
			}
		});
		
		cDesventajas2.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				DesventajaSeleccionada desventaja = desventajas.get(1);
				desventaja.setBeneficioDesventaja(String.valueOf(ch.obtenerBeneficioDesventajaSeleccionada(sessionFactory, cDesventajas2.getSelectionModel().getSelectedItem())));
				tableViewDesventaja.refresh();
				tPuntosCreacion.setText(String.valueOf(Integer.parseInt(tPuntosCreacion.getText())+Integer.parseInt(desventaja.getBeneficioDesventaja())));
			}
		});
		
		cDesventajas3.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				DesventajaSeleccionada desventaja = desventajas.get(2);
				desventaja.setBeneficioDesventaja(String.valueOf(ch.obtenerBeneficioDesventajaSeleccionada(sessionFactory, cDesventajas3.getSelectionModel().getSelectedItem())));
				tableViewDesventaja.refresh();
				tPuntosCreacion.setText(String.valueOf(Integer.parseInt(tPuntosCreacion.getText())+Integer.parseInt(desventaja.getBeneficioDesventaja())));
			}
		});
		
		cDesventajas4.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				DesventajaSeleccionada desventaja = desventajas.get(3);
				desventaja.setBeneficioDesventaja(String.valueOf(ch.obtenerBeneficioDesventajaSeleccionada(sessionFactory, cDesventajas4.getSelectionModel().getSelectedItem())));
				tableViewDesventaja.refresh();
				tPuntosCreacion.setText(String.valueOf(Integer.parseInt(tPuntosCreacion.getText())+Integer.parseInt(desventaja.getBeneficioDesventaja())));
			}
		});
		
		cDesventajas5.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				DesventajaSeleccionada desventaja = desventajas.get(4);
				desventaja.setBeneficioDesventaja(String.valueOf(ch.obtenerBeneficioDesventajaSeleccionada(sessionFactory, cDesventajas5.getSelectionModel().getSelectedItem())));
				tableViewDesventaja.refresh();
				tPuntosCreacion.setText(String.valueOf(Integer.parseInt(tPuntosCreacion.getText())+Integer.parseInt(desventaja.getBeneficioDesventaja())));
			}
		});
		
		tableViewDesventaja.setItems(desventajas);
		
		/*------------------------------------------------------Tabla Pds Combate Pestaña Pds------------------------------------------------------*/
		ObservableList<PdsCombate> pdsInvertidosCombate = FXCollections.observableArrayList(
				new PdsCombate("H.Ataque",String.valueOf(categoriaSeleccionada.getCosteHabilidadAtaque()),null,"0",String.valueOf(categoriaSeleccionada.getBonoHa()),null),
				new PdsCombate("H.Parada",String.valueOf(categoriaSeleccionada.getCosteHabilidadParada()),null,"0",String.valueOf(categoriaSeleccionada.getBonoHp()),null),
				new PdsCombate("H.Esquiva",String.valueOf(categoriaSeleccionada.getCosteHabilidadEsquiva()),null,"0",String.valueOf(categoriaSeleccionada.getBonoHe()),null),
				new PdsCombate("Llevar Armadura",String.valueOf(categoriaSeleccionada.getCosteLlevarArmadura()),null,"0",String.valueOf(categoriaSeleccionada.getBonoLlevarArmadura()),null),
				
				new PdsCombate("Puntos Ki AGI",String.valueOf(categoriaSeleccionada.getCostePuntoKi()),null,"0","-",null),
				new PdsCombate("Puntos Ki CON",String.valueOf(categoriaSeleccionada.getCostePuntoKi()),null,"0","-",null),
				new PdsCombate("Puntos Ki DES",String.valueOf(categoriaSeleccionada.getCostePuntoKi()),null,"0","-",null),
				new PdsCombate("Puntos Ki FUE",String.valueOf(categoriaSeleccionada.getCostePuntoKi()),null,"0","-",null),
				new PdsCombate("Puntos Ki POD",String.valueOf(categoriaSeleccionada.getCostePuntoKi()),null,"0","-",null),
				new PdsCombate("Puntos Ki VOL",String.valueOf(categoriaSeleccionada.getCostePuntoKi()),null,"0","-",null),

				new PdsCombate("Acumulacion Ki AGI",String.valueOf(categoriaSeleccionada.getCosteAcumulacionKi()),null,"0","-",null),
				new PdsCombate("Acumulacion Ki CON",String.valueOf(categoriaSeleccionada.getCosteAcumulacionKi()),null,"0","-",null),
				new PdsCombate("Acumulacion Ki DES",String.valueOf(categoriaSeleccionada.getCosteAcumulacionKi()),null,"0","-",null),
				new PdsCombate("Acumulacion Ki FUE",String.valueOf(categoriaSeleccionada.getCosteAcumulacionKi()),null,"0","-",null),
				new PdsCombate("Acumulacion Ki POD",String.valueOf(categoriaSeleccionada.getCosteAcumulacionKi()),null,"0","-",null),
				new PdsCombate("Acumulacion Ki VOL",String.valueOf(categoriaSeleccionada.getCosteAcumulacionKi()),null,"0","-",null),

				new PdsCombate("Conocimiento Marcial","5",null,"0",String.valueOf(categoriaSeleccionada.getConocimientoMarcial()),null));
		
		colPdsCombateNombreHabilidad.setCellValueFactory(new PropertyValueFactory<PdsCombate, String>("nombreHabilidad"));
		colPdsCombateCosteHabilidad.setCellValueFactory(new PropertyValueFactory<PdsCombate, String>("costeHabilidad"));
		colPdsCombatePuntosHabilidad.setCellValueFactory(new PropertyValueFactory<PdsCombate, String>("pdsHabilidad"));
		colPdsCombateBaseHabilidad.setCellValueFactory(new PropertyValueFactory<PdsCombate, String>("baseHabilidad"));
		colPdsCombateBonoHabilidad.setCellValueFactory(new PropertyValueFactory<PdsCombate, String>("bonoHabilidad"));
		colPdsCombateCategoriaHabilidad.setCellValueFactory(new PropertyValueFactory<PdsCombate, String>("categoriaHabilidad"));
		colPdsCombateEspecialHabilidad.setCellValueFactory(new PropertyValueFactory<PdsCombate, String>("especialHabilidad"));
		colPdsCombateTotalHabilidad.setCellValueFactory(new PropertyValueFactory<PdsCombate, String>("totalHabilidad"));
		
		colPdsCombatePuntosHabilidad.setCellFactory(TextFieldTableCell.forTableColumn());
		colPdsCombateEspecialHabilidad.setCellFactory(TextFieldTableCell.forTableColumn());
		
		tableViewCombate.setItems(pdsInvertidosCombate);
		/*------------------------------------------------------Valores TextField Pestaña Principal------------------------------------------------------*/
		
		if (tableViewCaracteristicas.getItems().get(0).getBonoCaracteristica()=="-") {
			tTurnoAgilidad.setText("0");
		} else {
			tTurnoAgilidad.setText(tableViewCaracteristicas.getItems().get(0).getBonoCaracteristica());
		}
		
		if (tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica()=="-") {
			tTurnoDestreza.setText("0");
		} else {
			tTurnoDestreza.setText(tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica());
		}
//		
//		if (tTurnoArmadura.getText().isEmpty()||tTurnoArmadura.getText().equals(null)||null==tTurnoArmadura.getText()||tTurnoArmadura.getText()=="") {
//			tTurnoArmadura.setText("0");
//		} else {
//			
//		}
//		
//		if (tTurnoEspecial.getText().isEmpty()||tTurnoEspecial.getText().equals(null)||null==tTurnoEspecial.getText()||""==tTurnoEspecial.getText()) {
//			tTurnoEspecial.setText("0");
//		} else {
//			
//		}
//		
//		tTurnoTotal.setText(String.valueOf(Integer.parseInt(tTurnoBase.getText())+Integer.parseInt(tTurnoAgilidad.getText())+Integer.parseInt(tTurnoDestreza.getText()+
//				Integer.parseInt(tTurnoCategoria.getText())+Integer.parseInt(tTurnoArmadura.getText())+Integer.parseInt(tTurnoDesarmado.getText())+Integer.parseInt(tTurnoEspecial.getText()))));
		tPuntosVidaCategoria.setText(String.valueOf(categoriaSeleccionada.getPuntosVida()));
		tTurnoCategoria.setText(String.valueOf(categoriaSeleccionada.getTurno()));
		tCansancioBase.setText(String.valueOf(tableViewCaracteristicas.getItems().get(2).getTotalCaracteristica()));
		tCansancioEspecial.setText("0");
		tCansancioTotal.setText(String.valueOf(String.valueOf(Integer.parseInt(tableViewCaracteristicas.getItems().get(2).getTotalCaracteristica())+Integer.parseInt(tCansancioEspecial.getText()))));
		tCategoriaPrimerLv.setText(categoriaSeleccionada.getNombre());
		tHabilidadAtaque.setText(tableViewCombate.getItems().get(0).getTotalHabilidad());
		if (Integer.parseInt(tableViewCombate.getItems().get(2).getTotalHabilidad())>Integer.parseInt(tableViewCombate.getItems().get(1).getTotalHabilidad())) {
			tHabilidadDefensa.setText(tableViewCombate.getItems().get(2).getTotalHabilidad());
		} else {
			tHabilidadDefensa.setText(tableViewCombate.getItems().get(1).getTotalHabilidad());
		}
		tLlevarArmadura.setText(tableViewCombate.getItems().get(3).getTotalHabilidad());
	}
	
	public void cambiarBase (TableColumn.CellEditEvent<CaracteristicaSeleccionada, String> cellEditEvent) {
		CaracteristicaSeleccionada caracteristica = tableViewCaracteristicas.getSelectionModel().getSelectedItem();
		caracteristica.setBaseCaracteristica(cellEditEvent.getNewValue());
		caracteristica.setTotalCaracteristica(String.valueOf(Integer.parseInt(caracteristica.getBaseCaracteristica())+Integer.parseInt(caracteristica.getTempCaracteristica())));
		caracteristica.setBonoCaracteristica(caracteristica.getTotalCaracteristica());
		
		if (tableViewCaracteristicas.getSelectionModel().getSelectedItem().getNombreCaracteristica().equals("AGI")) {
			AccionesTurno accionesTurno = new AccionesTurno(tableViewCaracteristicas.getItems().get(3).getTotalCaracteristica(),caracteristica.getTotalCaracteristica());
			tTurnoAgilidad.setText(caracteristica.getBonoCaracteristica());
			tableViewCombate.getItems().get(2).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tAccionesTurno.setText(accionesTurno.getNumeroAcciones());
			tableViewCombate.getItems().get(4).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			
		} else if (tableViewCaracteristicas.getSelectionModel().getSelectedItem().getNombreCaracteristica().equals("CON")) {
			ValorConstitucion valorConstitucion = new ValorConstitucion(caracteristica.getTotalCaracteristica());
			tCansancioBase.setText(caracteristica.getTotalCaracteristica());
			tCansancioTotal.setText(String.valueOf(Integer.parseInt(caracteristica.getTotalCaracteristica())+Integer.parseInt(tCansancioEspecial.getText())));
			tPuntosVidaBase.setText(valorConstitucion.getPuntosVidaBase());
			tPuntosVidaTotales.setText(String.valueOf(Integer.parseInt(valorConstitucion.getPuntosVidaBase())+Integer.parseInt(tPuntosVidaCategoria.getText())));
			tRegeneracion.setText(valorConstitucion.getRegeneracionBase());
			tCuracionDia.setText(valorConstitucion.getCuracionDia());
			tNegativoDia.setText(valorConstitucion.getNegativoDia());
			tableViewResistencias.getItems().get(1).setBonoCaracteristica(caracteristica.getBonoCaracteristica());
			tableViewResistencias.getItems().get(2).setBonoCaracteristica(caracteristica.getBonoCaracteristica());
			tableViewResistencias.getItems().get(3).setBonoCaracteristica(caracteristica.getBonoCaracteristica());
			tableViewCombate.getItems().get(5).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			
		} else if (tableViewCaracteristicas.getSelectionModel().getSelectedItem().getNombreCaracteristica().equals("FUE")) {
			tableViewResistencias.getItems().get(4).setBonoCaracteristica(caracteristica.getBonoCaracteristica());
			tableViewCombate.getItems().get(7).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			
		} else if (tableViewCaracteristicas.getSelectionModel().getSelectedItem().getNombreCaracteristica().equals("DES")) {
			AccionesTurno accionesTurno = new AccionesTurno(caracteristica.getTotalCaracteristica(),tableViewCaracteristicas.getItems().get(0).getTotalCaracteristica());
			tTurnoDestreza.setText(caracteristica.getBonoCaracteristica());
			tableViewCombate.getItems().get(0).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewCombate.getItems().get(1).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewCombate.getItems().get(6).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tAccionesTurno.setText(accionesTurno.getNumeroAcciones());
			
		} else if (tableViewCaracteristicas.getSelectionModel().getSelectedItem().getNombreCaracteristica().equals("INT")) {
			
			
		} else if (tableViewCaracteristicas.getSelectionModel().getSelectedItem().getNombreCaracteristica().equals("PER")) {
			
			
		} else if (tableViewCaracteristicas.getSelectionModel().getSelectedItem().getNombreCaracteristica().equals("POD")) {
			tableViewResistencias.getItems().get(4).setBonoCaracteristica(caracteristica.getBonoCaracteristica());
			tableViewCombate.getItems().get(8).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			
		} else if (tableViewCaracteristicas.getSelectionModel().getSelectedItem().getNombreCaracteristica().equals("VOL")) {
			tableViewResistencias.getItems().get(5).setBonoCaracteristica(caracteristica.getBonoCaracteristica());
			tableViewCombate.getItems().get(9).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			
		}
		
		tableViewCaracteristicas.refresh();
		tableViewResistencias.refresh();
		tableViewCombate.refresh();
		System.out.println(caracteristica.getBonoCaracteristica());
	}
	
	public void cambiarTemporal (TableColumn.CellEditEvent<CaracteristicaSeleccionada, String> cellEditEvent) {
		CaracteristicaSeleccionada caracteristica = tableViewCaracteristicas.getSelectionModel().getSelectedItem();
		caracteristica.setTempCaracteristica(cellEditEvent.getNewValue());
		caracteristica.setTotalCaracteristica(String.valueOf(Integer.parseInt(caracteristica.getBaseCaracteristica())+Integer.parseInt(caracteristica.getTempCaracteristica())));
		caracteristica.setBonoCaracteristica(caracteristica.getTotalCaracteristica());
		
		
		if (tableViewCaracteristicas.getSelectionModel().getSelectedItem().getNombreCaracteristica().equals("AGI")) {
			AccionesTurno accionesTurno = new AccionesTurno(tableViewCaracteristicas.getItems().get(3).getTotalCaracteristica(),caracteristica.getTotalCaracteristica());
			tTurnoAgilidad.setText(caracteristica.getBonoCaracteristica());
			tableViewCombate.getItems().get(2).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tAccionesTurno.setText(accionesTurno.getNumeroAcciones());
			tableViewCombate.getItems().get(4).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			
		} else if (tableViewCaracteristicas.getSelectionModel().getSelectedItem().getNombreCaracteristica().equals("CON")) {
			ValorConstitucion valorConstitucion = new ValorConstitucion(caracteristica.getTotalCaracteristica());
			tCansancioBase.setText(caracteristica.getTotalCaracteristica());
			tCansancioTotal.setText(String.valueOf(Integer.parseInt(caracteristica.getTotalCaracteristica())+Integer.parseInt(tCansancioEspecial.getText())));
			tPuntosVidaBase.setText(valorConstitucion.getPuntosVidaBase());
			tPuntosVidaTotales.setText(String.valueOf(Integer.parseInt(valorConstitucion.getPuntosVidaBase())+Integer.parseInt(tPuntosVidaCategoria.getText())));
			tRegeneracion.setText(valorConstitucion.getRegeneracionBase());
			tCuracionDia.setText(valorConstitucion.getCuracionDia());
			tNegativoDia.setText(valorConstitucion.getNegativoDia());
			tableViewResistencias.getItems().get(1).setBonoCaracteristica(caracteristica.getBonoCaracteristica());
			tableViewResistencias.getItems().get(2).setBonoCaracteristica(caracteristica.getBonoCaracteristica());
			tableViewResistencias.getItems().get(3).setBonoCaracteristica(caracteristica.getBonoCaracteristica());
			tableViewCombate.getItems().get(5).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			
		} else if (tableViewCaracteristicas.getSelectionModel().getSelectedItem().getNombreCaracteristica().equals("FUE")) {
			tableViewResistencias.getItems().get(4).setBonoCaracteristica(caracteristica.getBonoCaracteristica());
			tableViewCombate.getItems().get(7).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			
		} else if (tableViewCaracteristicas.getSelectionModel().getSelectedItem().getNombreCaracteristica().equals("DES")) {
			AccionesTurno accionesTurno = new AccionesTurno(caracteristica.getTotalCaracteristica(),tableViewCaracteristicas.getItems().get(0).getTotalCaracteristica());
			tTurnoDestreza.setText(caracteristica.getBonoCaracteristica());
			tableViewCombate.getItems().get(0).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewCombate.getItems().get(1).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewCombate.getItems().get(6).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tAccionesTurno.setText(accionesTurno.getNumeroAcciones());
			
		} else if (tableViewCaracteristicas.getSelectionModel().getSelectedItem().getNombreCaracteristica().equals("INT")) {
			
			
		} else if (tableViewCaracteristicas.getSelectionModel().getSelectedItem().getNombreCaracteristica().equals("PER")) {
			
			
		} else if (tableViewCaracteristicas.getSelectionModel().getSelectedItem().getNombreCaracteristica().equals("POD")) {
			tableViewResistencias.getItems().get(4).setBonoCaracteristica(caracteristica.getBonoCaracteristica());
			tableViewCombate.getItems().get(8).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			
		} else if (tableViewCaracteristicas.getSelectionModel().getSelectedItem().getNombreCaracteristica().equals("VOL")) {
			tableViewResistencias.getItems().get(5).setBonoCaracteristica(caracteristica.getBonoCaracteristica());
			tableViewCombate.getItems().get(9).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			
		}
		
		tableViewCaracteristicas.refresh();
		tableViewResistencias.refresh();
		tableViewCombate.refresh();
		System.out.println(caracteristica.getBonoCaracteristica());
	}
	
	public void cambiarEspecialResistencias (TableColumn.CellEditEvent<ResistenciasTabla, String> cellEditEvent) {
		ResistenciasTabla resistencia = tableViewResistencias.getSelectionModel().getSelectedItem();
		resistencia.setBonoEspecial(cellEditEvent.getNewValue());
//		if (cellEditEvent.getNewValue()=="") {
//			resistencia.setBonoEspecial("0");
//		} else {
//			resistencia.setBonoEspecial(cellEditEvent.getNewValue());
//		}
		
		tableViewResistencias.refresh();
	}

	public void cambiarPdsCombate (TableColumn.CellEditEvent<PdsCombate, String> cellEditEvent) {
		PdsCombate pds = tableViewCombate.getSelectionModel().getSelectedItem();
		pds.setPdsHabilidad(cellEditEvent.getNewValue());
//		if (cellEditEvent.getNewValue()=="") {
//			pds.setPdsHabilidad("0");
//		} else {
//			pds.setPdsHabilidad(cellEditEvent.getNewValue());
//		}
		
		if (tableViewCombate.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("H.Ataque")) {
			tHabilidadAtaque.setText(pds.getTotalHabilidad());
		} else if (tableViewCombate.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("H.Parada")) {
			if (Integer.parseInt(pds.getTotalHabilidad())>Integer.parseInt(tableViewCombate.getItems().get(1).getTotalHabilidad())) {
				tHabilidadDefensa.setText(pds.getTotalHabilidad());
			} else {
				tHabilidadDefensa.setText(tableViewCombate.getItems().get(1).getTotalHabilidad());
			}
			
		} else if (tableViewCombate.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("H.Esquiva")) {
			if (Integer.parseInt(pds.getTotalHabilidad())>Integer.parseInt(tableViewCombate.getItems().get(1).getTotalHabilidad())) {
				tHabilidadDefensa.setText(pds.getTotalHabilidad());
			} else {
				tHabilidadDefensa.setText(tableViewCombate.getItems().get(1).getTotalHabilidad());
			}
			
		} else if (tableViewCombate.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Llevar Armadura")) {
			tLlevarArmadura.setText(pds.getTotalHabilidad());
		}
		
		tableViewCombate.refresh();
	}
	
	public void cambiarPdsEspecialCombate (TableColumn.CellEditEvent<PdsCombate, String> cellEditEvent) {
		PdsCombate pds = tableViewCombate.getSelectionModel().getSelectedItem();
		pds.setEspecialHabilidad(cellEditEvent.getNewValue());
//		if (cellEditEvent.getNewValue()=="") {
//			pds.setEspecialHabilidad("0");
//		} else {
//			pds.setEspecialHabilidad(cellEditEvent.getNewValue());
//		}
		
		
		
		tableViewCombate.refresh();
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
				tCansancioTotal.setText(String.valueOf(Integer.parseInt(tableViewCaracteristicas.getItems().get(1).getTotalCaracteristica())+Integer.parseInt(tCansancioEspecial.getText())));
			}
				
			} else {
				Alert alerta = new Alert(Alert.AlertType.WARNING);
				alerta.setHeaderText(null);
			    alerta.setTitle("Info");
			    alerta.setContentText("No se pueden escribir caracteres diferentes a un numero");
			    alerta.showAndWait();
			}
	}
	
	public void cambiarValorVidaEspecial(KeyEvent ev){
		System.out.println(ev.getCode()+" "+ev.getText());
		
		if (ev.getCode() == KeyCode.DIGIT1||ev.getCode() == KeyCode.DIGIT2||ev.getCode() == KeyCode.DIGIT3||ev.getCode() == KeyCode.DIGIT4||
				ev.getCode() == KeyCode.DIGIT5||ev.getCode() == KeyCode.DIGIT6||ev.getCode() == KeyCode.DIGIT7||ev.getCode() == KeyCode.DIGIT8||
				ev.getCode() == KeyCode.DIGIT9||ev.getCode() == KeyCode.DIGIT0||ev.getCode() == KeyCode.NUMPAD1||ev.getCode() == KeyCode.NUMPAD2||
				ev.getCode() == KeyCode.NUMPAD3||ev.getCode() == KeyCode.NUMPAD4||ev.getCode() == KeyCode.NUMPAD5||ev.getCode() == KeyCode.NUMPAD6||
				ev.getCode() == KeyCode.NUMPAD7||ev.getCode() == KeyCode.NUMPAD8||ev.getCode() == KeyCode.NUMPAD9||ev.getCode() == KeyCode.NUMPAD0||
				ev.getCode() == KeyCode.MINUS || ev.getCode() == KeyCode.BACK_SPACE) {
				
			if (tPuntosVidaEspecial.getText().isEmpty()) {
				tPuntosVidaTotales.setText(String.valueOf(Integer.parseInt(tPuntosVidaBase.getText())+Integer.parseInt("0")+Integer.parseInt(tPuntosVidaCategoria.getText())));
			}
			else {
				tPuntosVidaTotales.setText(String.valueOf(Integer.parseInt(tPuntosVidaBase.getText())+Integer.parseInt(tPuntosVidaEspecial.getText())+Integer.parseInt(tPuntosVidaCategoria.getText())));
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
