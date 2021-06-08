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
import modelo.PdsMisticos;
import modelo.Raza;
import modelo.ResistenciasTabla;
import modelo.ValorConstitucion;
import modelo.VentajaSeleccionada;

public class PersonajeController {
	
	ConsultasHibernate ch;
	SessionFactory sessionFactory;
	Categoria categoriaSeleccionada;
	Raza razaSeleccionada;
	ValorConstitucion valorConstitucion;
	
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
	tAccionesTurno, tPuntosCreacion, tCategoriaPrimerLv, tNivelTotal, tPdsRestantes, tLlevarArmadura, tHabilidadDefensa, tHabilidadAtaque, tPuntosRegeneracionEspecial,
	tRazaGeneral, tEtniaGeneral;
	
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
	TableView<PdsMisticos> tableViewMisticas;

	@FXML
	TableView<PdsPsiquicos> tableViewPsiquicas;
	
	@FXML
	TableView<PdsHabilidadesSecundarias> tableViewSecundarias;
	
	@FXML
	TableView<PdsHabilidadesSecundariasResumen> tableViewResumenAtleticas, tableViewResumenSociales, tableViewResumenPerceptivas, tableViewResumenIntelectuales, tableViewResumenVigor,
	tableViewResumenSubterfugio, tableViewResumenCreativas;
	
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
	
	@FXML
	TableColumn<PdsMisticos, String> colPdsMisticoNombreHabilidad, colPdsMisticoCosteHabilidad, colPdsMisticoPdsHabilidad, colPdsMisticoBaseHabilidad, colPdsMisticoBonoHabilidad, colPdsMisticoCategoriaHabilidad,
	colPdsMisticoEspecialHabilidad, colPdsMisticoTotalHabilidad;
	
	@FXML
	TableColumn<PdsPsiquicos, String> colPdsPsiquicoNombreHabilidad, colPdsPsiquicoCosteHabilidad, colPdsPsiquicoPdsHabilidad, colPdsPsiquicoBaseHabilidad, colPdsPsiquicoBonoHabilidad, colPdsPsiquicoCategoriaHabilidad,
	colPdsPsiquicoEspecialHabilidad, colPdsPsiquicoTotalHabilidad;

	@FXML
	TableColumn<PdsHabilidadesSecundarias, String> colPdsSecundariasNombreHabilidad, colPdsSecundariasCosteHabilidad, colPdsSecundariasPdsHabilidad, colPdsSecundariasBaseHabilidad, colPdsSecundariasBonoHabilidad, colPdsSecundariasCategoriaHabilidad,
	colPdsSecundariasEspecialHabilidad, colPdsSecundariasTotalHabilidad, colPdsSecundariasBonoNatural, colPdsSecundariasHabilidadNatural, colPdsSecundariasBonoNovel;

	@FXML
	TableColumn<PdsHabilidadesSecundariasResumen, String> colNombreSecundariaAtleticas, colPenalizadorSecundariaAtleticas, colTotalSecundariaAtleticas, 
	colNombreSecundariaSociales, colPenalizadorSecundariaSociales, colTotalSecundariaSociales,
	colNombreSecundariaPerceptivas, colPenalizadorSecundariaPerceptivas, colTotalSecundariaPerceptivas,
	colNombreSecundariaIntelectuales, colPenalizadorSecundariaIntelectuales, colTotalSecundariaIntelectuales, 
	colNombreSecundariaVigor, colPenalizadorSecundariaVigor, colTotalSecundariaVigor,
	colNombreSecundariaSubterfugio, colPenalizadorSecundariaSubterfugio, colTotalSecundariaSubterfugio,
	colNombreSecundariaCreativas, colPenalizadorSecundariaCreativas, colTotalSecundariaCreativas;
	
	
	
	public PersonajeController(SessionFactory sessionFactory, String categoria, String raza) {
		this.ch = new ConsultasHibernate();
		this.sessionFactory = sessionFactory;
		this.categoriaSeleccionada = ch.obtenerCategoria(categoria, sessionFactory);
		this.razaSeleccionada = ch.obtenerRaza(raza, sessionFactory);
		valorConstitucion = new ValorConstitucion("0");
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
		
		/*------------------------------------------------------Tabla Pds Combate Pesta�a Pds------------------------------------------------------*/
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
		
		/*------------------------------------------------------Tabla Pds Misticos Pesta�a Pds------------------------------------------------------*/
		if (null==categoriaSeleccionada.getBonoZeon()) {
			categoriaSeleccionada.setBonoZeon(0);
		} else if (null==categoriaSeleccionada.getBonoConvocar()) {
			categoriaSeleccionada.setBonoConvocar(0);
		} else if (null==categoriaSeleccionada.getBonoControlar()) {
			categoriaSeleccionada.setBonoControlar(0);
		} else if (null==categoriaSeleccionada.getBonoAtar()) {
			categoriaSeleccionada.setBonoAtar(0);
		} else if (null==categoriaSeleccionada.getBonoDesconvocar()) {
			categoriaSeleccionada.setBonoDesconvocar(0);
		}
		
		ObservableList<PdsMisticos> pdsInvertidosMisticos = FXCollections.observableArrayList(
				new PdsMisticos("Zeon",String.valueOf(categoriaSeleccionada.getCosteZeon()),null,"0",String.valueOf(categoriaSeleccionada.getBonoZeon()),null),
				new PdsMisticos("ACT",String.valueOf(categoriaSeleccionada.getCosteAct()),null,"0","-",null),
				new PdsMisticos("Multiplo de regeneracion",String.valueOf(categoriaSeleccionada.getCosteAct()/2),null,"0","-",null),
				new PdsMisticos("Proyeccion Magia",String.valueOf(categoriaSeleccionada.getCosteProyeccionMagica()),null,"0","-",null),
				new PdsMisticos("Nivel de Magia",String.valueOf(categoriaSeleccionada.getCosteNivelMagia()),null,"0","-",null),
				
				new PdsMisticos("Convocar",String.valueOf(categoriaSeleccionada.getCosteConvocar()),null,"0",String.valueOf(categoriaSeleccionada.getBonoConvocar()),null),
				new PdsMisticos("Controlar",String.valueOf(categoriaSeleccionada.getCosteControlar()),null,"0",String.valueOf(categoriaSeleccionada.getBonoControlar()),null),
				new PdsMisticos("Atar",String.valueOf(categoriaSeleccionada.getCosteAtar()),null,"0",String.valueOf(categoriaSeleccionada.getBonoAtar()),null),
				new PdsMisticos("Desconvocar",String.valueOf(categoriaSeleccionada.getCosteDesconvocar()),null,"0",String.valueOf(categoriaSeleccionada.getBonoDesconvocar()),null));
		
		colPdsMisticoNombreHabilidad.setCellValueFactory(new PropertyValueFactory<PdsMisticos, String>("nombreHabilidad"));
		colPdsMisticoCosteHabilidad.setCellValueFactory(new PropertyValueFactory<PdsMisticos, String>("costeHabilidad"));
		colPdsMisticoPdsHabilidad.setCellValueFactory(new PropertyValueFactory<PdsMisticos, String>("pdsHabilidad"));
		colPdsMisticoBaseHabilidad.setCellValueFactory(new PropertyValueFactory<PdsMisticos, String>("baseHabilidad"));
		colPdsMisticoBonoHabilidad.setCellValueFactory(new PropertyValueFactory<PdsMisticos, String>("bonoHabilidad"));
		colPdsMisticoCategoriaHabilidad.setCellValueFactory(new PropertyValueFactory<PdsMisticos, String>("categoriaHabilidad"));
		colPdsMisticoEspecialHabilidad.setCellValueFactory(new PropertyValueFactory<PdsMisticos, String>("especialHabilidad"));
		colPdsMisticoTotalHabilidad.setCellValueFactory(new PropertyValueFactory<PdsMisticos, String>("totalHabilidad"));
		
		colPdsMisticoPdsHabilidad.setCellFactory(TextFieldTableCell.forTableColumn());
		colPdsMisticoEspecialHabilidad.setCellFactory(TextFieldTableCell.forTableColumn());
		
		tableViewMisticas.setItems(pdsInvertidosMisticos);

		/*------------------------------------------------------Tabla Pds Psiquicos Pesta�a Pds------------------------------------------------------*/
		ObservableList<PdsPsiquicos> pdsInvertidosPsiquicos = FXCollections.observableArrayList(
				new PdsPsiquicos("CV",String.valueOf(categoriaSeleccionada.getCostePuntosCv()),null,"0",String.valueOf(categoriaSeleccionada.getCvInnato()),null),
				new PdsPsiquicos("Proyeccion Psiquica",String.valueOf(categoriaSeleccionada.getCosteProyeccionPsiquica()),null,"0","-",null));
		
		colPdsPsiquicoNombreHabilidad.setCellValueFactory(new PropertyValueFactory<PdsPsiquicos, String>("nombreHabilidad"));
		colPdsPsiquicoCosteHabilidad.setCellValueFactory(new PropertyValueFactory<PdsPsiquicos, String>("costeHabilidad"));
		colPdsPsiquicoPdsHabilidad.setCellValueFactory(new PropertyValueFactory<PdsPsiquicos, String>("pdsHabilidad"));
		colPdsPsiquicoBaseHabilidad.setCellValueFactory(new PropertyValueFactory<PdsPsiquicos, String>("baseHabilidad"));
		colPdsPsiquicoBonoHabilidad.setCellValueFactory(new PropertyValueFactory<PdsPsiquicos, String>("bonoHabilidad"));
		colPdsPsiquicoCategoriaHabilidad.setCellValueFactory(new PropertyValueFactory<PdsPsiquicos, String>("categoriaHabilidad"));
		colPdsPsiquicoEspecialHabilidad.setCellValueFactory(new PropertyValueFactory<PdsPsiquicos, String>("especialHabilidad"));
		colPdsPsiquicoTotalHabilidad.setCellValueFactory(new PropertyValueFactory<PdsPsiquicos, String>("totalHabilidad"));
		
		colPdsPsiquicoPdsHabilidad.setCellFactory(TextFieldTableCell.forTableColumn());
		colPdsPsiquicoEspecialHabilidad.setCellFactory(TextFieldTableCell.forTableColumn());
		
		tableViewPsiquicas.setItems(pdsInvertidosPsiquicos);

		/*------------------------------------------------------Tabla Habilidades Secundarias Pesta�a Pds ------------------------------------------------------*/
		if ("null" == String.valueOf(categoriaSeleccionada.getBonoAcrobacias())) {
			categoriaSeleccionada.setBonoAcrobacias(0);
		}
		if ("null" == String.valueOf(categoriaSeleccionada.getBonoAtletismo())) {
			categoriaSeleccionada.setBonoAtletismo(0);
		}
		if ("null" == String.valueOf(categoriaSeleccionada.getBonoBuscar())) {
			categoriaSeleccionada.setBonoBuscar(0);
		}
		if ("null" == String.valueOf(categoriaSeleccionada.getBonoRastrear())) {
			categoriaSeleccionada.setBonoRastrear(0);
		}
		if ("null" == String.valueOf(categoriaSeleccionada.getBonoTramperia())) {
			categoriaSeleccionada.setBonoTramperia(0);
		}
		if ("null" == String.valueOf(categoriaSeleccionada.getBonoAnimales())) {
			categoriaSeleccionada.setBonoAnimales(0);
		}
		if ("null" == String.valueOf(categoriaSeleccionada.getBonoHerbolaria())) {
			categoriaSeleccionada.setBonoHerbolaria(0);
		}
		if ("null" == String.valueOf(categoriaSeleccionada.getBonoOcultarse())) {
			categoriaSeleccionada.setBonoOcultarse(0);
		}
		if ("null" == String.valueOf(categoriaSeleccionada.getBonoSigilo())) {
			categoriaSeleccionada.setBonoSigilo(0);
		}
		if ("null" == String.valueOf(categoriaSeleccionada.getBonoRobo())) {
			categoriaSeleccionada.setBonoRobo(0);
		} 
		if ("null" == String.valueOf(categoriaSeleccionada.getBonoValoracionMagica())) {
			categoriaSeleccionada.setBonoValoracionMagica(0);
		}
		if ("null" == String.valueOf(categoriaSeleccionada.getBonoOcultismo())) {
			categoriaSeleccionada.setBonoOcultismo(0);
		} 
		if ("null" == String.valueOf(categoriaSeleccionada.getBonoDisfraz())) {
			categoriaSeleccionada.setBonoDisfraz(0);
		}
		if ("null" == String.valueOf(categoriaSeleccionada.getBonoProezaFuerza())) {
			categoriaSeleccionada.setBonoProezaFuerza(0);
		}
		if ("null" == String.valueOf(categoriaSeleccionada.getBonoSaltar())) {
			categoriaSeleccionada.setBonoSaltar(0);
		}
		if ("null" == String.valueOf(categoriaSeleccionada.getBonoTrucoManos())) {
			categoriaSeleccionada.setBonoTrucoManos(0);
		}
		if ("null" == String.valueOf(categoriaSeleccionada.getBonoEstilo())) {
			categoriaSeleccionada.setBonoEstilo(0);
		}
		if ("null" == String.valueOf(categoriaSeleccionada.getBonoLiderazgo())) {
			categoriaSeleccionada.setBonoLiderazgo(0);
		} 
		if ("null" == String.valueOf(categoriaSeleccionada.getBonoIntimidar())) {
			categoriaSeleccionada.setBonoIntimidar(0);
		}
		if ("null" == String.valueOf(categoriaSeleccionada.getBonoPersuasion())) {
			categoriaSeleccionada.setBonoPersuasion(0);
		}
		if ("null" == String.valueOf(categoriaSeleccionada.getBonoResistirDolor())) {
			categoriaSeleccionada.setBonoResistirDolor(0);
		}
		if ("null" == String.valueOf(categoriaSeleccionada.getBonoFrialdad())) {
			categoriaSeleccionada.setBonoFrialdad(0);
		}
		if ("null" == String.valueOf(categoriaSeleccionada.getBonoVeneno())) {
			categoriaSeleccionada.setBonoVeneno(0);
		}
		if ("null" == String.valueOf(categoriaSeleccionada.getBonoAdvertir())) {
			categoriaSeleccionada.setBonoAdvertir(0);
		}
		ObservableList<PdsHabilidadesSecundarias> pdsInvertidosSecundarias = FXCollections.observableArrayList(
				new PdsHabilidadesSecundarias("Acrobacias",String.valueOf(categoriaSeleccionada.getCosteAtleticas()),null,"0",String.valueOf(categoriaSeleccionada.getBonoAcrobacias()),null,null,null,null),
				new PdsHabilidadesSecundarias("Atletismo",String.valueOf(categoriaSeleccionada.getCosteAtleticas()),null,"0",String.valueOf(categoriaSeleccionada.getBonoAtletismo()),null,null,null,null),
				new PdsHabilidadesSecundarias("Montar",String.valueOf(categoriaSeleccionada.getCosteAtleticas()),null,"0","0",null,null,null,null),
				new PdsHabilidadesSecundarias("Nadar",String.valueOf(categoriaSeleccionada.getCosteAtleticas()),null,"0","0",null,null,null,null),
				new PdsHabilidadesSecundarias("Trepar",String.valueOf(categoriaSeleccionada.getCosteAtleticas()),null,"0","0",null,null,null,null),
				new PdsHabilidadesSecundarias("Saltar",String.valueOf(categoriaSeleccionada.getCosteAtleticas()),null,"0",String.valueOf(categoriaSeleccionada.getBonoSaltar()),null,null,null,null),
				
				new PdsHabilidadesSecundarias("Estilo",String.valueOf(categoriaSeleccionada.getCosteSociales()),null,"0",String.valueOf(categoriaSeleccionada.getBonoEstilo()),null,null,null,null),
				new PdsHabilidadesSecundarias("Intimidar",String.valueOf(categoriaSeleccionada.getCosteSociales()),null,"0",String.valueOf(categoriaSeleccionada.getBonoIntimidar()),null,null,null,null),
				new PdsHabilidadesSecundarias("Liderazgo",String.valueOf(categoriaSeleccionada.getCosteSociales()),null,"0",String.valueOf(categoriaSeleccionada.getBonoLiderazgo()),null,null,null,null),
				new PdsHabilidadesSecundarias("Persuasion",String.valueOf(categoriaSeleccionada.getCosteSociales()),null,"0",String.valueOf(categoriaSeleccionada.getBonoPersuasion()),null,null,null,null),
				new PdsHabilidadesSecundarias("Comercio",String.valueOf(categoriaSeleccionada.getCosteSociales()),null,"0","0",null,null,null,null),
				new PdsHabilidadesSecundarias("Callejeo",String.valueOf(categoriaSeleccionada.getCosteSociales()),null,"0","0",null,null,null,null),
				new PdsHabilidadesSecundarias("Etiqueta",String.valueOf(categoriaSeleccionada.getCosteSociales()),null,"0","0",null,null,null,null),
				
				new PdsHabilidadesSecundarias("Advertir",String.valueOf(categoriaSeleccionada.getCostePerceptivas()),null,"0",String.valueOf(categoriaSeleccionada.getBonoAdvertir()),null,null,null,null),
				new PdsHabilidadesSecundarias("Buscar",String.valueOf(categoriaSeleccionada.getCostePerceptivas()),null,"0",String.valueOf(categoriaSeleccionada.getBonoBuscar()),null,null,null,null),
				new PdsHabilidadesSecundarias("Rastrear",String.valueOf(categoriaSeleccionada.getCostePerceptivas()),null,"0",String.valueOf(categoriaSeleccionada.getBonoRastrear()),null,null,null,null),
				
				new PdsHabilidadesSecundarias("Animales",String.valueOf(categoriaSeleccionada.getCosteIntelectuales()),null,"0",String.valueOf(categoriaSeleccionada.getBonoAnimales()),null,null,null,null),
				new PdsHabilidadesSecundarias("Ciencia",String.valueOf(categoriaSeleccionada.getCosteIntelectuales()),null,"0","0",null,null,null,null),
				new PdsHabilidadesSecundarias("Ley",String.valueOf(categoriaSeleccionada.getCosteIntelectuales()),null,"0","0",null,null,null,null),
				new PdsHabilidadesSecundarias("Herbolaria",String.valueOf(categoriaSeleccionada.getCosteIntelectuales()),null,"0",String.valueOf(categoriaSeleccionada.getBonoHerbolaria()),null,null,null,null),
				new PdsHabilidadesSecundarias("Historia",String.valueOf(categoriaSeleccionada.getCosteIntelectuales()),null,"0","0",null,null,null,null),
				new PdsHabilidadesSecundarias("Tactica",String.valueOf(categoriaSeleccionada.getCosteIntelectuales()),null,"0","0",null,null,null,null),
				new PdsHabilidadesSecundarias("Medicina",String.valueOf(categoriaSeleccionada.getCosteIntelectuales()),null,"0","0",null,null,null,null),
				new PdsHabilidadesSecundarias("Memorizar",String.valueOf(categoriaSeleccionada.getCosteIntelectuales()),null,"0","0",null,null,null,null),
				new PdsHabilidadesSecundarias("Navegacion",String.valueOf(categoriaSeleccionada.getCosteIntelectuales()),null,"0","0",null,null,null,null),
				new PdsHabilidadesSecundarias("Ocultismo",String.valueOf(categoriaSeleccionada.getCosteIntelectuales()),null,"0",String.valueOf(categoriaSeleccionada.getBonoOcultismo()),null,null,null,null),
				new PdsHabilidadesSecundarias("Tasacion",String.valueOf(categoriaSeleccionada.getCosteIntelectuales()),null,"0","0",null,null,null,null),
				new PdsHabilidadesSecundarias("V.Magica",String.valueOf(categoriaSeleccionada.getCosteIntelectuales()),null,"0",String.valueOf(categoriaSeleccionada.getBonoValoracionMagica()),null,null,null,null),
				
				new PdsHabilidadesSecundarias("Frialdad",String.valueOf(categoriaSeleccionada.getCosteVigor()),null,"0",String.valueOf(categoriaSeleccionada.getBonoFrialdad()),null,null,null,null),
				new PdsHabilidadesSecundarias("P.Fuerza",String.valueOf(categoriaSeleccionada.getCosteVigor()),null,"0",String.valueOf(categoriaSeleccionada.getBonoProezaFuerza()),null,null,null,null),
				new PdsHabilidadesSecundarias("Res.Dolor",String.valueOf(categoriaSeleccionada.getCosteVigor()),null,"0",String.valueOf(categoriaSeleccionada.getBonoResistirDolor()),null,null,null,null),
				
				new PdsHabilidadesSecundarias("Cerrajeria",String.valueOf(categoriaSeleccionada.getCosteSubterfugio()),null,"0","0",null,null,null,null),
				new PdsHabilidadesSecundarias("Disfraz",String.valueOf(categoriaSeleccionada.getCosteSubterfugio()),null,"0",String.valueOf(categoriaSeleccionada.getBonoDisfraz()),null,null,null,null),
				new PdsHabilidadesSecundarias("Ocultarse",String.valueOf(categoriaSeleccionada.getCosteSubterfugio()),null,"0",String.valueOf(categoriaSeleccionada.getBonoOcultarse()),null,null,null,null),
				new PdsHabilidadesSecundarias("Robo",String.valueOf(categoriaSeleccionada.getCosteSubterfugio()),null,"0",String.valueOf(categoriaSeleccionada.getBonoRobo()),null,null,null,null),
				new PdsHabilidadesSecundarias("Sigilo",String.valueOf(categoriaSeleccionada.getCosteSubterfugio()),null,"0",String.valueOf(categoriaSeleccionada.getBonoSigilo()),null,null,null,null),
				new PdsHabilidadesSecundarias("Tramperia",String.valueOf(categoriaSeleccionada.getCosteSubterfugio()),null,"0",String.valueOf(categoriaSeleccionada.getBonoTramperia()),null,null,null,null),
				new PdsHabilidadesSecundarias("Venenos",String.valueOf(categoriaSeleccionada.getCosteSubterfugio()),null,"0",String.valueOf(categoriaSeleccionada.getBonoVeneno()),null,null,null,null),
				
				new PdsHabilidadesSecundarias("Arte",String.valueOf(categoriaSeleccionada.getCosteCreativas()),null,"0","0",null,null,null,null),
				new PdsHabilidadesSecundarias("Baile",String.valueOf(categoriaSeleccionada.getCosteCreativas()),null,"0","0",null,null,null,null),
				new PdsHabilidadesSecundarias("Forja",String.valueOf(categoriaSeleccionada.getCosteCreativas()),null,"0","0",null,null,null,null),
				new PdsHabilidadesSecundarias("Runas",String.valueOf(categoriaSeleccionada.getCosteCreativas()),null,"0","0",null,null,null,null),
				new PdsHabilidadesSecundarias("Alquimia",String.valueOf(categoriaSeleccionada.getCosteCreativas()),null,"0","0",null,null,null,null),
				new PdsHabilidadesSecundarias("Animismo",String.valueOf(categoriaSeleccionada.getCosteCreativas()),null,"0","0",null,null,null,null),
				new PdsHabilidadesSecundarias("Musica",String.valueOf(categoriaSeleccionada.getCosteCreativas()),null,"0","0",null,null,null,null),
				new PdsHabilidadesSecundarias("T.Manos",String.valueOf(categoriaSeleccionada.getCosteCreativas()),null,"0",String.valueOf(categoriaSeleccionada.getBonoTrucoManos()),null,null,null,null),
				new PdsHabilidadesSecundarias("Caligrafia Ritual",String.valueOf(categoriaSeleccionada.getCosteCreativas()),null,"0","0",null,null,null,null),
				new PdsHabilidadesSecundarias("Orfebreria",String.valueOf(categoriaSeleccionada.getCosteCreativas()),null,"0","0",null,null,null,null),
				new PdsHabilidadesSecundarias("Confeccion",String.valueOf(categoriaSeleccionada.getCosteCreativas()),null,"0","0",null,null,null,null));
		
		colPdsSecundariasNombreHabilidad.setCellValueFactory(new PropertyValueFactory<PdsHabilidadesSecundarias, String>("nombreHabilidad"));
		colPdsSecundariasCosteHabilidad.setCellValueFactory(new PropertyValueFactory<PdsHabilidadesSecundarias, String>("costeHabilidad"));
		colPdsSecundariasPdsHabilidad.setCellValueFactory(new PropertyValueFactory<PdsHabilidadesSecundarias, String>("pdsHabilidad"));
		colPdsSecundariasBaseHabilidad.setCellValueFactory(new PropertyValueFactory<PdsHabilidadesSecundarias, String>("baseHabilidad"));
		colPdsSecundariasBonoHabilidad.setCellValueFactory(new PropertyValueFactory<PdsHabilidadesSecundarias, String>("bonoHabilidad"));
		colPdsSecundariasCategoriaHabilidad.setCellValueFactory(new PropertyValueFactory<PdsHabilidadesSecundarias, String>("categoriaHabilidad"));
		colPdsSecundariasEspecialHabilidad.setCellValueFactory(new PropertyValueFactory<PdsHabilidadesSecundarias, String>("especialHabilidad"));
		colPdsSecundariasBonoNatural.setCellValueFactory(new PropertyValueFactory<PdsHabilidadesSecundarias, String>("bonoNatural"));
		colPdsSecundariasHabilidadNatural.setCellValueFactory(new PropertyValueFactory<PdsHabilidadesSecundarias, String>("habilidadNatural"));
		colPdsSecundariasBonoNovel.setCellValueFactory(new PropertyValueFactory<PdsHabilidadesSecundarias, String>("bonoNovel"));
		colPdsSecundariasTotalHabilidad.setCellValueFactory(new PropertyValueFactory<PdsHabilidadesSecundarias, String>("totalHabilidad"));
		
		colPdsSecundariasPdsHabilidad.setCellFactory(TextFieldTableCell.forTableColumn());
		colPdsSecundariasEspecialHabilidad.setCellFactory(TextFieldTableCell.forTableColumn());
		colPdsSecundariasBonoNatural.setCellFactory(TextFieldTableCell.forTableColumn());
		colPdsSecundariasHabilidadNatural.setCellFactory(TextFieldTableCell.forTableColumn());
		colPdsSecundariasBonoNovel.setCellFactory(TextFieldTableCell.forTableColumn());
		
		tableViewSecundarias.setItems(pdsInvertidosSecundarias);
		
		/*------------------------------------------------------Tabla Pds Resumen Secundarias Pesta�a Principal------------------------------------------------------*/
		ObservableList<PdsHabilidadesSecundariasResumen> resumenSecundarias = FXCollections.observableArrayList(
				new PdsHabilidadesSecundariasResumen("Acrobacias","0",tableViewSecundarias.getItems().get(0).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("Atletismo","0",tableViewSecundarias.getItems().get(1).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("Montar","0",tableViewSecundarias.getItems().get(2).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("Nadar","0",tableViewSecundarias.getItems().get(3).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("Trepar","0",tableViewSecundarias.getItems().get(4).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("Saltar","0",tableViewSecundarias.getItems().get(5).getTotalHabilidad()));
		
		colNombreSecundariaAtleticas.setCellValueFactory(new PropertyValueFactory<PdsHabilidadesSecundariasResumen, String>("nombreHabilidad"));
		colPenalizadorSecundariaAtleticas.setCellValueFactory(new PropertyValueFactory<PdsHabilidadesSecundariasResumen, String>("penalizadorNaturalHabilidad"));
		colTotalSecundariaAtleticas.setCellValueFactory(new PropertyValueFactory<PdsHabilidadesSecundariasResumen, String>("totalHabilidad"));
		
		tableViewResumenAtleticas.setItems(resumenSecundarias);

		/*------------------------------------------------------Valores TextField Pesta�a Principal------------------------------------------------------*/
		
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
		
		if (tTurnoArmadura.getText().isEmpty()||tTurnoArmadura.getText().equals(null)||null==tTurnoArmadura.getText()||tTurnoArmadura.getText()=="") {
			tTurnoArmadura.setText("0");
		} else {
			
		}
		
		if (tTurnoEspecial.getText().isEmpty()||tTurnoEspecial.getText().equals(null)||null==tTurnoEspecial.getText()||tTurnoEspecial.getText()=="") {
			tTurnoEspecial.setText("0");
		} else {
			
		}

		tRazaGeneral.setText(razaSeleccionada.getNombre());
		
//		if ("HUMANO"==razaSeleccionada.getNombre()||"NEPHILIM VETALA"==razaSeleccionada.getNombre()||"NEPHILIM DEVAH"==razaSeleccionada.getNombre()||"NEPHILIM TURAK"==razaSeleccionada.getNombre()
//				||"NEPHILIM DUK�ZARIST"==razaSeleccionada.getNombre()||"NEPHILIM DAIMAH"==razaSeleccionada.getNombre()||"NEPHILIM EBUDAN"==razaSeleccionada.getNombre()||"NEPHILIM D�ANJAYNI"==razaSeleccionada.getNombre()
//				||"NEPHILIM JAY�N"==razaSeleccionada.getNombre()||"NEPHILIM SYLVAIN"==razaSeleccionada.getNombre()) {
//			tEtniaGeneral.setEditable(true);
//			tEtniaGeneral.setText("");
//		} else {
//			tEtniaGeneral.setEditable(false);
//			tEtniaGeneral.setText("-");
//		}
		
		tPuntosVidaCategoria.setText(String.valueOf(categoriaSeleccionada.getPuntosVida()));
		tPuntosVidaBase.setText(valorConstitucion.getPuntosVidaBase());
		tPuntosVidaBase.setText(valorConstitucion.getPuntosVidaBase());
		tPuntosVidaTotales.setText(String.valueOf(Integer.parseInt(valorConstitucion.getPuntosVidaBase())+Integer.parseInt(tPuntosVidaCategoria.getText())));
		tRegeneracion.setText(valorConstitucion.getRegeneracionBase());
		tCuracionDia.setText(valorConstitucion.getCuracionDia());
		tNegativoDia.setText(valorConstitucion.getNegativoDia());
		tTurnoCategoria.setText(String.valueOf(categoriaSeleccionada.getTurno()));
		tTurnoTotal.setText(String.valueOf(Integer.parseInt(tTurnoBase.getText())+Integer.parseInt(tTurnoAgilidad.getText())+Integer.parseInt(tTurnoDestreza.getText())+
				Integer.parseInt(tTurnoCategoria.getText()) +Integer.parseInt(tTurnoArmadura.getText()) +Integer.parseInt(tTurnoDesarmado.getText()) +Integer.parseInt(tTurnoEspecial.getText())));
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
			tableViewCombate.getItems().get(4).setBonoHabilidad(caracteristica.getTotalCaracteristica());
			tTurnoTotal.setText(String.valueOf(Integer.parseInt(tTurnoBase.getText())+Integer.parseInt(tTurnoAgilidad.getText())+
					Integer.parseInt(tTurnoDestreza.getText())+Integer.parseInt(tTurnoCategoria.getText())+Integer.parseInt(tTurnoArmadura.getText())+Integer.parseInt(tTurnoDesarmado.getText())+
					Integer.parseInt(tTurnoEspecial.getText())));
			
			if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=1&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=9) {
				tableViewCombate.getItems().get(10).setBonoHabilidad("1");
				
			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=10&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=12) {
				tableViewCombate.getItems().get(10).setBonoHabilidad("2");
				
			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=13&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=15) {
				tableViewCombate.getItems().get(10).setBonoHabilidad("3");
				
			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=16) {
				tableViewCombate.getItems().get(10).setBonoHabilidad("4");
				
			}
			
			
		} else if (tableViewCaracteristicas.getSelectionModel().getSelectedItem().getNombreCaracteristica().equals("CON")) {
			valorConstitucion.setConstitucion(caracteristica.getTotalCaracteristica());
			tCansancioBase.setText(caracteristica.getTotalCaracteristica());
			tCansancioTotal.setText(String.valueOf(Integer.parseInt(caracteristica.getTotalCaracteristica())+Integer.parseInt(tCansancioEspecial.getText())));
			tPuntosVidaBase.setText(valorConstitucion.getPuntosVidaBase());
			if (tPuntosVidaEspecial.getText().isEmpty()||tPuntosVidaEspecial.getText().equals(null)||null==tPuntosVidaEspecial.getText()||tPuntosVidaEspecial.getText()=="") {
				tPuntosVidaTotales.setText(String.valueOf(Integer.parseInt(valorConstitucion.getPuntosVidaBase())+Integer.parseInt(tPuntosVidaCategoria.getText())+Integer.parseInt("0")));
				
			} else {
				tPuntosVidaTotales.setText(String.valueOf(Integer.parseInt(valorConstitucion.getPuntosVidaBase())+Integer.parseInt(tPuntosVidaCategoria.getText())+Integer.parseInt(tPuntosVidaEspecial.getText())));
				
			}
			
			if (tPuntosRegeneracionEspecial.getText().isEmpty()||tPuntosRegeneracionEspecial.getText().equals(null)||null==tPuntosRegeneracionEspecial.getText()||tPuntosRegeneracionEspecial.getText()=="") {
				valorConstitucion.setRegeneracionBase(String.valueOf(Integer.parseInt(valorConstitucion.getRegeneracionBase())+Integer.parseInt("0")));
				tRegeneracion.setText(valorConstitucion.getRegeneracionBase());
				tCuracionDia.setText(valorConstitucion.getCuracionDia());
				tNegativoDia.setText(valorConstitucion.getNegativoDia());
			} else {
				valorConstitucion.setRegeneracionBase(String.valueOf(Integer.parseInt(valorConstitucion.getRegeneracionBase())+Integer.parseInt(tPuntosRegeneracionEspecial.getText())));
				tRegeneracion.setText(valorConstitucion.getRegeneracionBase());
				tCuracionDia.setText(valorConstitucion.getCuracionDia());
				tNegativoDia.setText(valorConstitucion.getNegativoDia());
			}
			
			tableViewResistencias.getItems().get(1).setBonoCaracteristica(caracteristica.getBonoCaracteristica());
			tableViewResistencias.getItems().get(2).setBonoCaracteristica(caracteristica.getBonoCaracteristica());
			tableViewResistencias.getItems().get(3).setBonoCaracteristica(caracteristica.getBonoCaracteristica());
			tableViewCombate.getItems().get(5).setBonoHabilidad(caracteristica.getTotalCaracteristica());
			
			if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=1&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=9) {
				tableViewCombate.getItems().get(11).setBonoHabilidad("1");
				
			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=10&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=12) {
				tableViewCombate.getItems().get(11).setBonoHabilidad("2");
				
			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=13&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=15) {
				tableViewCombate.getItems().get(11).setBonoHabilidad("3");
				
			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=16) {
				tableViewCombate.getItems().get(11).setBonoHabilidad("4");
				
			}
			
		} else if (tableViewCaracteristicas.getSelectionModel().getSelectedItem().getNombreCaracteristica().equals("FUE")) {
			tableViewResistencias.getItems().get(4).setBonoCaracteristica(caracteristica.getBonoCaracteristica());
			tableViewCombate.getItems().get(7).setBonoHabilidad(caracteristica.getTotalCaracteristica());
			
			if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=1&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=9) {
				tableViewCombate.getItems().get(13).setBonoHabilidad("1");
				
			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=10&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=12) {
				tableViewCombate.getItems().get(13).setBonoHabilidad("2");
				
			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=13&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=15) {
				tableViewCombate.getItems().get(13).setBonoHabilidad("3");
				
			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=16) {
				tableViewCombate.getItems().get(13).setBonoHabilidad("4");
				
			}
			
		} else if (tableViewCaracteristicas.getSelectionModel().getSelectedItem().getNombreCaracteristica().equals("DES")) {
			AccionesTurno accionesTurno = new AccionesTurno(caracteristica.getTotalCaracteristica(),tableViewCaracteristicas.getItems().get(0).getTotalCaracteristica());
			tTurnoDestreza.setText(caracteristica.getBonoCaracteristica());
			tableViewCombate.getItems().get(0).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewCombate.getItems().get(1).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewCombate.getItems().get(6).setBonoHabilidad(caracteristica.getTotalCaracteristica());
			tTurnoTotal.setText(String.valueOf(Integer.parseInt(tTurnoBase.getText())+Integer.parseInt(tTurnoAgilidad.getText())+
					Integer.parseInt(tTurnoDestreza.getText())+Integer.parseInt(tTurnoCategoria.getText())+Integer.parseInt(tTurnoArmadura.getText())+Integer.parseInt(tTurnoDesarmado.getText())+
					Integer.parseInt(tTurnoEspecial.getText())));
			
			if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=1&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=9) {
				tableViewCombate.getItems().get(12).setBonoHabilidad("1");
				
			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=10&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=12) {
				tableViewCombate.getItems().get(12).setBonoHabilidad("2");
				
			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=13&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=15) {
				tableViewCombate.getItems().get(12).setBonoHabilidad("3");
				
			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=16) {
				tableViewCombate.getItems().get(12).setBonoHabilidad("4");
				
			}
			
			tAccionesTurno.setText(accionesTurno.getNumeroAcciones());
			
		} else if (tableViewCaracteristicas.getSelectionModel().getSelectedItem().getNombreCaracteristica().equals("INT")) {
			
			
		} else if (tableViewCaracteristicas.getSelectionModel().getSelectedItem().getNombreCaracteristica().equals("PER")) {
			
			
		} else if (tableViewCaracteristicas.getSelectionModel().getSelectedItem().getNombreCaracteristica().equals("POD")) {
			tableViewResistencias.getItems().get(4).setBonoCaracteristica(caracteristica.getBonoCaracteristica());
			tableViewCombate.getItems().get(8).setBonoHabilidad(caracteristica.getTotalCaracteristica());
			
			if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=1&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=9) {
				tableViewCombate.getItems().get(14).setBonoHabilidad("1");
				
			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=10&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=12) {
				tableViewCombate.getItems().get(14).setBonoHabilidad("2");
				
			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=13&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=15) {
				tableViewCombate.getItems().get(14).setBonoHabilidad("3");
				
			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=16) {
				tableViewCombate.getItems().get(14).setBonoHabilidad("4");
				
			}
			
		} else if (tableViewCaracteristicas.getSelectionModel().getSelectedItem().getNombreCaracteristica().equals("VOL")) {
			tableViewResistencias.getItems().get(5).setBonoCaracteristica(caracteristica.getBonoCaracteristica());
			tableViewCombate.getItems().get(9).setBonoHabilidad(caracteristica.getTotalCaracteristica());
			
			if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=1&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=9) {
				tableViewCombate.getItems().get(15).setBonoHabilidad("1");
				
			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=10&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=12) {
				tableViewCombate.getItems().get(15).setBonoHabilidad("2");
				
			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=13&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=15) {
				tableViewCombate.getItems().get(15).setBonoHabilidad("3");
				
			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=16) {
				tableViewCombate.getItems().get(15).setBonoHabilidad("4");
				
			}
			
		}
		
		tableViewCaracteristicas.refresh();
		tableViewResistencias.refresh();
		tableViewCombate.refresh();
		tableViewMisticas.refresh();
		tableViewPsiquicas.refresh();
		tableViewSecundarias.refresh();
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
			tableViewCombate.getItems().get(4).setBonoHabilidad(caracteristica.getTotalCaracteristica());
			tTurnoTotal.setText(String.valueOf(Integer.parseInt(tTurnoBase.getText())+Integer.parseInt(tTurnoAgilidad.getText())+
					Integer.parseInt(tTurnoDestreza.getText())+Integer.parseInt(tTurnoCategoria.getText())+Integer.parseInt(tTurnoArmadura.getText())+Integer.parseInt(tTurnoDesarmado.getText())+
					Integer.parseInt(tTurnoEspecial.getText())));
			
			if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=1&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=9) {
				tableViewCombate.getItems().get(10).setBonoHabilidad("1");
				
			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=10&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=12) {
				tableViewCombate.getItems().get(10).setBonoHabilidad("2");
				
			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=13&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=15) {
				tableViewCombate.getItems().get(10).setBonoHabilidad("3");
				
			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=16) {
				tableViewCombate.getItems().get(10).setBonoHabilidad("4");
				
			}
			
			
		} else if (tableViewCaracteristicas.getSelectionModel().getSelectedItem().getNombreCaracteristica().equals("CON")) {
			valorConstitucion.setConstitucion(caracteristica.getTotalCaracteristica());
			tCansancioBase.setText(caracteristica.getTotalCaracteristica());
			tCansancioTotal.setText(String.valueOf(Integer.parseInt(caracteristica.getTotalCaracteristica())+Integer.parseInt(tCansancioEspecial.getText())));
			tPuntosVidaBase.setText(valorConstitucion.getPuntosVidaBase());
			if (tPuntosVidaEspecial.getText().isEmpty()||tPuntosVidaEspecial.getText().equals(null)||null==tPuntosVidaEspecial.getText()||tPuntosVidaEspecial.getText()=="") {
				tPuntosVidaTotales.setText(String.valueOf(Integer.parseInt(valorConstitucion.getPuntosVidaBase())+Integer.parseInt(tPuntosVidaCategoria.getText())+Integer.parseInt("0")));
				
			} else {
				tPuntosVidaTotales.setText(String.valueOf(Integer.parseInt(valorConstitucion.getPuntosVidaBase())+Integer.parseInt(tPuntosVidaCategoria.getText())+Integer.parseInt(tPuntosVidaEspecial.getText())));
				
			}
			
			if (tPuntosRegeneracionEspecial.getText().isEmpty()||tPuntosRegeneracionEspecial.getText().equals(null)||null==tPuntosRegeneracionEspecial.getText()||tPuntosRegeneracionEspecial.getText()=="") {
				valorConstitucion.setRegeneracionBase(String.valueOf(Integer.parseInt(valorConstitucion.getRegeneracionBase())+Integer.parseInt("0")));
				tRegeneracion.setText(valorConstitucion.getRegeneracionBase());
				tCuracionDia.setText(valorConstitucion.getCuracionDia());
				tNegativoDia.setText(valorConstitucion.getNegativoDia());
			} else {
				valorConstitucion.setRegeneracionBase(String.valueOf(Integer.parseInt(valorConstitucion.getRegeneracionBase())+Integer.parseInt(tPuntosRegeneracionEspecial.getText())));
				tRegeneracion.setText(valorConstitucion.getRegeneracionBase());
				tCuracionDia.setText(valorConstitucion.getCuracionDia());
				tNegativoDia.setText(valorConstitucion.getNegativoDia());
			}
			
			tableViewResistencias.getItems().get(1).setBonoCaracteristica(caracteristica.getBonoCaracteristica());
			tableViewResistencias.getItems().get(2).setBonoCaracteristica(caracteristica.getBonoCaracteristica());
			tableViewResistencias.getItems().get(3).setBonoCaracteristica(caracteristica.getBonoCaracteristica());
			tableViewCombate.getItems().get(5).setBonoHabilidad(caracteristica.getTotalCaracteristica());
			
			if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=1&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=9) {
				tableViewCombate.getItems().get(11).setBonoHabilidad("1");
				
			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=10&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=12) {
				tableViewCombate.getItems().get(11).setBonoHabilidad("2");
				
			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=13&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=15) {
				tableViewCombate.getItems().get(11).setBonoHabilidad("3");
				
			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=16) {
				tableViewCombate.getItems().get(11).setBonoHabilidad("4");
				
			}
			
		} else if (tableViewCaracteristicas.getSelectionModel().getSelectedItem().getNombreCaracteristica().equals("FUE")) {
			tableViewResistencias.getItems().get(4).setBonoCaracteristica(caracteristica.getBonoCaracteristica());
			tableViewCombate.getItems().get(7).setBonoHabilidad(caracteristica.getTotalCaracteristica());
			
			if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=1&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=9) {
				tableViewCombate.getItems().get(13).setBonoHabilidad("1");
				
			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=10&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=12) {
				tableViewCombate.getItems().get(13).setBonoHabilidad("2");
				
			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=13&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=15) {
				tableViewCombate.getItems().get(13).setBonoHabilidad("3");
				
			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=16) {
				tableViewCombate.getItems().get(13).setBonoHabilidad("4");
				
			}
			
		} else if (tableViewCaracteristicas.getSelectionModel().getSelectedItem().getNombreCaracteristica().equals("DES")) {
			AccionesTurno accionesTurno = new AccionesTurno(caracteristica.getTotalCaracteristica(),tableViewCaracteristicas.getItems().get(0).getTotalCaracteristica());
			tTurnoDestreza.setText(caracteristica.getBonoCaracteristica());
			tableViewCombate.getItems().get(0).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewCombate.getItems().get(1).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewCombate.getItems().get(6).setBonoHabilidad(caracteristica.getTotalCaracteristica());
			tTurnoTotal.setText(String.valueOf(Integer.parseInt(tTurnoBase.getText())+Integer.parseInt(tTurnoAgilidad.getText())+
					Integer.parseInt(tTurnoDestreza.getText())+Integer.parseInt(tTurnoCategoria.getText())+Integer.parseInt(tTurnoArmadura.getText())+Integer.parseInt(tTurnoDesarmado.getText())+
					Integer.parseInt(tTurnoEspecial.getText())));
			
			if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=1&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=9) {
				tableViewCombate.getItems().get(12).setBonoHabilidad("1");
				
			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=10&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=12) {
				tableViewCombate.getItems().get(12).setBonoHabilidad("2");
				
			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=13&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=15) {
				tableViewCombate.getItems().get(12).setBonoHabilidad("3");
				
			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=16) {
				tableViewCombate.getItems().get(12).setBonoHabilidad("4");
				
			}
			
			tAccionesTurno.setText(accionesTurno.getNumeroAcciones());
			
		} else if (tableViewCaracteristicas.getSelectionModel().getSelectedItem().getNombreCaracteristica().equals("INT")) {
			
			
		} else if (tableViewCaracteristicas.getSelectionModel().getSelectedItem().getNombreCaracteristica().equals("PER")) {
			
			
		} else if (tableViewCaracteristicas.getSelectionModel().getSelectedItem().getNombreCaracteristica().equals("POD")) {
			tableViewResistencias.getItems().get(4).setBonoCaracteristica(caracteristica.getBonoCaracteristica());
			tableViewCombate.getItems().get(8).setBonoHabilidad(caracteristica.getTotalCaracteristica());
			
			if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=1&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=9) {
				tableViewCombate.getItems().get(14).setBonoHabilidad("1");
				
			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=10&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=12) {
				tableViewCombate.getItems().get(14).setBonoHabilidad("2");
				
			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=13&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=15) {
				tableViewCombate.getItems().get(14).setBonoHabilidad("3");
				
			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=16) {
				tableViewCombate.getItems().get(14).setBonoHabilidad("4");
				
			}
			
		} else if (tableViewCaracteristicas.getSelectionModel().getSelectedItem().getNombreCaracteristica().equals("VOL")) {
			tableViewResistencias.getItems().get(5).setBonoCaracteristica(caracteristica.getBonoCaracteristica());
			tableViewCombate.getItems().get(9).setBonoHabilidad(caracteristica.getTotalCaracteristica());
			
			if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=1&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=9) {
				tableViewCombate.getItems().get(15).setBonoHabilidad("1");
				
			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=10&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=12) {
				tableViewCombate.getItems().get(15).setBonoHabilidad("2");
				
			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=13&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=15) {
				tableViewCombate.getItems().get(15).setBonoHabilidad("3");
				
			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=16) {
				tableViewCombate.getItems().get(15).setBonoHabilidad("4");
				
			}
			
		}
		
		tableViewCaracteristicas.refresh();
		tableViewResistencias.refresh();
		tableViewCombate.refresh();
		tableViewMisticas.refresh();
		tableViewPsiquicas.refresh();
		tableViewSecundarias.refresh();
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
	
	public void cambiarPdsMisticos (TableColumn.CellEditEvent<PdsMisticos, String> cellEditEvent) {
		PdsMisticos pds = tableViewMisticas.getSelectionModel().getSelectedItem();
		pds.setPdsHabilidad(cellEditEvent.getNewValue());
		
		if (tableViewMisticas.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Zeon")) {
			
		} else if (tableViewMisticas.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("ACT")) {
			
		} else if (tableViewMisticas.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Multiplo de Regeneracion")) {
			
		} else if (tableViewMisticas.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Proyeccion Magia")) {
			
		} else if (tableViewMisticas.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Nivel de Magia")) {
			
		} else if (tableViewMisticas.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Convocar")) {
			
		} else if (tableViewMisticas.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Controlar")) {
			
		} else if (tableViewMisticas.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Atar")) {
			
		} else if (tableViewMisticas.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Desconvocar")) {
			
		}
		
		tableViewMisticas.refresh();
	}
	
	public void cambiarPdsEspecialMisticos (TableColumn.CellEditEvent<PdsMisticos, String> cellEditEvent) {
		PdsMisticos pds = tableViewMisticas.getSelectionModel().getSelectedItem();
		pds.setEspecialHabilidad(cellEditEvent.getNewValue());
		
		if (tableViewMisticas.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Zeon")) {
			
		} else if (tableViewMisticas.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("ACT")) {
			
		} else if (tableViewMisticas.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Multiplo de Regeneracion")) {
			
		} else if (tableViewMisticas.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Proyeccion Magia")) {
			
		} else if (tableViewMisticas.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Nivel de Magia")) {
			
		} else if (tableViewMisticas.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Convocar")) {
			
		} else if (tableViewMisticas.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Controlar")) {
			
		} else if (tableViewMisticas.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Atar")) {
			
		} else if (tableViewMisticas.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Desconvocar")) {
			
		}
		
		tableViewMisticas.refresh();
	}
	
	public void cambiarPdsPsiquicos (TableColumn.CellEditEvent<PdsPsiquicos, String> cellEditEvent) {
		PdsPsiquicos pds = tableViewPsiquicas.getSelectionModel().getSelectedItem();
		pds.setPdsHabilidad(cellEditEvent.getNewValue());
		
		if (tableViewPsiquicas.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("CV")) {
			
		} else if (tableViewPsiquicas.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Proyeccion Psiquica")) {
			
		}
		
		tableViewPsiquicas.refresh();
	}
	
	public void cambiarPdsEspecialPsiquicos (TableColumn.CellEditEvent<PdsPsiquicos, String> cellEditEvent) {
		PdsPsiquicos pds = tableViewPsiquicas.getSelectionModel().getSelectedItem();
		pds.setEspecialHabilidad(cellEditEvent.getNewValue());
		
		if (tableViewPsiquicas.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("CV")) {
			
		} else if (tableViewPsiquicas.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Proyeccion Psiquica")) {
			
		}
		
	tableViewPsiquicas.refresh();
	}
	
	public void cambiarPdsHabilidadesSecundarias (TableColumn.CellEditEvent<PdsHabilidadesSecundarias, String> cellEditEvent) {
		PdsHabilidadesSecundarias pds = tableViewSecundarias.getSelectionModel().getSelectedItem();
		pds.setPdsHabilidad(cellEditEvent.getNewValue());
		
		if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Acrobacias")) {
			tableViewResumenAtleticas.getItems().get(0).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Atletismo")) {
			tableViewResumenAtleticas.getItems().get(1).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Montar")) {
			tableViewResumenAtleticas.getItems().get(2).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Nadar")) {
			tableViewResumenAtleticas.getItems().get(3).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Trepar")) {
			tableViewResumenAtleticas.getItems().get(4).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Saltar")) {
			tableViewResumenAtleticas.getItems().get(5).setTotalHabilidad(pds.getTotalHabilidad());
		}
		
		tableViewSecundarias.refresh();
		tableViewResumenAtleticas.refresh();
	}

	public void cambiarPdsEspecialHabilidadesSecundarias (TableColumn.CellEditEvent<PdsHabilidadesSecundarias, String> cellEditEvent) {
		PdsHabilidadesSecundarias pds = tableViewSecundarias.getSelectionModel().getSelectedItem();
		pds.setEspecialHabilidad(cellEditEvent.getNewValue());
		
		if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Acrobacias")) {
			tableViewResumenAtleticas.getItems().get(0).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Atletismo")) {
			tableViewResumenAtleticas.getItems().get(1).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Montar")) {
			tableViewResumenAtleticas.getItems().get(2).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Nadar")) {
			tableViewResumenAtleticas.getItems().get(3).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Trepar")) {
			tableViewResumenAtleticas.getItems().get(4).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Saltar")) {
			tableViewResumenAtleticas.getItems().get(5).setTotalHabilidad(pds.getTotalHabilidad());
		}
		
		tableViewSecundarias.refresh();
		tableViewResumenAtleticas.refresh();
	}

	public void cambiarPdsBonoNaturalHabilidadesSecundarias (TableColumn.CellEditEvent<PdsHabilidadesSecundarias, String> cellEditEvent) {
		PdsHabilidadesSecundarias pds = tableViewSecundarias.getSelectionModel().getSelectedItem();
		pds.setBonoNatural(cellEditEvent.getNewValue());
		
		if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Acrobacias")) {
			tableViewResumenAtleticas.getItems().get(0).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Atletismo")) {
			tableViewResumenAtleticas.getItems().get(1).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Montar")) {
			tableViewResumenAtleticas.getItems().get(2).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Nadar")) {
			tableViewResumenAtleticas.getItems().get(3).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Trepar")) {
			tableViewResumenAtleticas.getItems().get(4).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Saltar")) {
			tableViewResumenAtleticas.getItems().get(5).setTotalHabilidad(pds.getTotalHabilidad());
		}
		
		tableViewSecundarias.refresh();
		tableViewResumenAtleticas.refresh();
	}

	public void cambiarPdsHabilidadNaturalHabilidadesSecundarias (TableColumn.CellEditEvent<PdsHabilidadesSecundarias, String> cellEditEvent) {
		PdsHabilidadesSecundarias pds = tableViewSecundarias.getSelectionModel().getSelectedItem();
		pds.setHabilidadNatural(cellEditEvent.getNewValue());
		
		if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Acrobacias")) {
			tableViewResumenAtleticas.getItems().get(0).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Atletismo")) {
			tableViewResumenAtleticas.getItems().get(1).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Montar")) {
			tableViewResumenAtleticas.getItems().get(2).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Nadar")) {
			tableViewResumenAtleticas.getItems().get(3).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Trepar")) {
			tableViewResumenAtleticas.getItems().get(4).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Saltar")) {
			tableViewResumenAtleticas.getItems().get(5).setTotalHabilidad(pds.getTotalHabilidad());
		}
		
		tableViewSecundarias.refresh();
		tableViewResumenAtleticas.refresh();
	}

	public void cambiarPdsBonoNovelHabilidadesSecundarias (TableColumn.CellEditEvent<PdsHabilidadesSecundarias, String> cellEditEvent) {
		PdsHabilidadesSecundarias pds = tableViewSecundarias.getSelectionModel().getSelectedItem();
		pds.setBonoNovel(cellEditEvent.getNewValue());
		
		if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Acrobacias")) {
			tableViewResumenAtleticas.getItems().get(0).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Atletismo")) {
			tableViewResumenAtleticas.getItems().get(1).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Montar")) {
			tableViewResumenAtleticas.getItems().get(2).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Nadar")) {
			tableViewResumenAtleticas.getItems().get(3).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Trepar")) {
			tableViewResumenAtleticas.getItems().get(4).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Saltar")) {
			tableViewResumenAtleticas.getItems().get(5).setTotalHabilidad(pds.getTotalHabilidad());
		}
		
		tableViewSecundarias.refresh();
		tableViewResumenAtleticas.refresh();
	}

	public void cambiarValorCansancio(KeyEvent ev){
		System.out.println(ev.getCode()+" "+ev.getText());
		
		if (ev.getCode() == KeyCode.DIGIT1||ev.getCode() == KeyCode.DIGIT2||ev.getCode() == KeyCode.DIGIT3||ev.getCode() == KeyCode.DIGIT4||
				ev.getCode() == KeyCode.DIGIT5||ev.getCode() == KeyCode.DIGIT6||ev.getCode() == KeyCode.DIGIT7||ev.getCode() == KeyCode.DIGIT8||
				ev.getCode() == KeyCode.DIGIT9||ev.getCode() == KeyCode.DIGIT0||ev.getCode() == KeyCode.NUMPAD1||ev.getCode() == KeyCode.NUMPAD2||
				ev.getCode() == KeyCode.NUMPAD3||ev.getCode() == KeyCode.NUMPAD4||ev.getCode() == KeyCode.NUMPAD5||ev.getCode() == KeyCode.NUMPAD6||
				ev.getCode() == KeyCode.NUMPAD7||ev.getCode() == KeyCode.NUMPAD8||ev.getCode() == KeyCode.NUMPAD9||ev.getCode() == KeyCode.NUMPAD0||
				ev.getCode() == KeyCode.MINUS || ev.getCode() == KeyCode.BACK_SPACE) {
				
			if (tCansancioEspecial.getText().isEmpty()||tCansancioEspecial.getText().equals(null)||null==tCansancioEspecial.getText()||tCansancioEspecial.getText()==""
					||tCansancioEspecial.getText()=="0") {
				tCansancioEspecial.setText("0");
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
				
			if (tPuntosVidaEspecial.getText().isEmpty()||tPuntosVidaEspecial.getText().equals(null)||null==tPuntosVidaEspecial.getText()||tPuntosVidaEspecial.getText()==""
					||tPuntosVidaEspecial.getText()=="0") {
				tPuntosVidaEspecial.setText("0");
				tPuntosVidaTotales.setText(String.valueOf(Integer.parseInt(tPuntosVidaBase.getText())+Integer.parseInt(tPuntosVidaEspecial.getText())+Integer.parseInt(tPuntosVidaCategoria.getText())));
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

	public void cambiarValorRegeneracionEspecial(KeyEvent ev){
		System.out.println(ev.getCode()+" "+ev.getText());
		
		if (ev.getCode() == KeyCode.DIGIT1||ev.getCode() == KeyCode.DIGIT2||ev.getCode() == KeyCode.DIGIT3||ev.getCode() == KeyCode.DIGIT4||
				ev.getCode() == KeyCode.DIGIT5||ev.getCode() == KeyCode.DIGIT6||ev.getCode() == KeyCode.DIGIT7||ev.getCode() == KeyCode.DIGIT8||
				ev.getCode() == KeyCode.DIGIT9||ev.getCode() == KeyCode.DIGIT0||ev.getCode() == KeyCode.NUMPAD1||ev.getCode() == KeyCode.NUMPAD2||
				ev.getCode() == KeyCode.NUMPAD3||ev.getCode() == KeyCode.NUMPAD4||ev.getCode() == KeyCode.NUMPAD5||ev.getCode() == KeyCode.NUMPAD6||
				ev.getCode() == KeyCode.NUMPAD7||ev.getCode() == KeyCode.NUMPAD8||ev.getCode() == KeyCode.NUMPAD9||ev.getCode() == KeyCode.NUMPAD0||
				ev.getCode() == KeyCode.MINUS || ev.getCode() == KeyCode.BACK_SPACE) {
			
			
			if (tPuntosRegeneracionEspecial.getText().isEmpty()||tPuntosRegeneracionEspecial.getText().equals(null)||null==tPuntosRegeneracionEspecial.getText()||tPuntosRegeneracionEspecial.getText()==""
					||tPuntosRegeneracionEspecial.getText()=="0") {
				tPuntosRegeneracionEspecial.setText("0");
				valorConstitucion.setConstitucion(String.valueOf(tableViewCaracteristicas.getItems().get(1).getTotalCaracteristica()));
				tRegeneracion.setText(valorConstitucion.getRegeneracionBase());
				tCuracionDia.setText(valorConstitucion.getCuracionDia());
				tNegativoDia.setText(valorConstitucion.getNegativoDia());
			} else {
//				valorConstitucion.setRegeneracionBase(String.valueOf(Integer.parseInt(valorConstitucion.getRegeneracionBase())+Integer.parseInt(tPuntosRegeneracionEspecial.getText())));
				valorConstitucion.setConstitucion(String.valueOf(Integer.parseInt(String.valueOf(tableViewCaracteristicas.getItems().get(1).getTotalCaracteristica()))/*+Integer.parseInt(tPuntosRegeneracionEspecial.getText())*/));
				valorConstitucion.setRegeneracionBase(String.valueOf(Integer.parseInt(valorConstitucion.getRegeneracionBase())+Integer.parseInt(tPuntosRegeneracionEspecial.getText())));
				tRegeneracion.setText(valorConstitucion.getRegeneracionBase());
				tCuracionDia.setText(valorConstitucion.getCuracionDia());
				tNegativoDia.setText(valorConstitucion.getNegativoDia());
			}
				
			} else {
				Alert alerta = new Alert(Alert.AlertType.WARNING);
				alerta.setHeaderText(null);
			    alerta.setTitle("Info");
			    alerta.setContentText("No se pueden escribir caracteres diferentes a un numero");
			    alerta.showAndWait();
			}
	}
	
	public void cambiarValorTurnoEspecial(KeyEvent ev){
		System.out.println(ev.getCode()+" "+ev.getText());
		
		if (ev.getCode() == KeyCode.DIGIT1||ev.getCode() == KeyCode.DIGIT2||ev.getCode() == KeyCode.DIGIT3||ev.getCode() == KeyCode.DIGIT4||
				ev.getCode() == KeyCode.DIGIT5||ev.getCode() == KeyCode.DIGIT6||ev.getCode() == KeyCode.DIGIT7||ev.getCode() == KeyCode.DIGIT8||
				ev.getCode() == KeyCode.DIGIT9||ev.getCode() == KeyCode.DIGIT0||ev.getCode() == KeyCode.NUMPAD1||ev.getCode() == KeyCode.NUMPAD2||
				ev.getCode() == KeyCode.NUMPAD3||ev.getCode() == KeyCode.NUMPAD4||ev.getCode() == KeyCode.NUMPAD5||ev.getCode() == KeyCode.NUMPAD6||
				ev.getCode() == KeyCode.NUMPAD7||ev.getCode() == KeyCode.NUMPAD8||ev.getCode() == KeyCode.NUMPAD9||ev.getCode() == KeyCode.NUMPAD0||
				ev.getCode() == KeyCode.MINUS || ev.getCode() == KeyCode.BACK_SPACE) {
			
			
			if (tTurnoEspecial.getText().isEmpty()||tTurnoEspecial.getText().equals(null)||null==tTurnoEspecial.getText()||tTurnoEspecial.getText()==""
					||tTurnoEspecial.getText()=="0") {
				tTurnoEspecial.setText("0");
				tTurnoTotal.setText(String.valueOf(Integer.parseInt(tTurnoBase.getText())+Integer.parseInt(tTurnoAgilidad.getText())+
						Integer.parseInt(tTurnoDestreza.getText())+Integer.parseInt(tTurnoCategoria.getText())+Integer.parseInt(tTurnoArmadura.getText())+Integer.parseInt(tTurnoDesarmado.getText())+
						Integer.parseInt(tTurnoEspecial.getText())));
				
			} else {
//				valorConstitucion.setRegeneracionBase(String.valueOf(Integer.parseInt(valorConstitucion.getRegeneracionBase())+Integer.parseInt(tPuntosRegeneracionEspecial.getText())));
				tTurnoTotal.setText(String.valueOf(Integer.parseInt(tTurnoBase.getText())+Integer.parseInt(tTurnoAgilidad.getText())+
						Integer.parseInt(tTurnoDestreza.getText())+Integer.parseInt(tTurnoCategoria.getText())+Integer.parseInt(tTurnoArmadura.getText())+Integer.parseInt(tTurnoDesarmado.getText())+
						Integer.parseInt(tTurnoEspecial.getText())));
				
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
