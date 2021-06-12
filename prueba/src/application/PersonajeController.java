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
import modelo.ArmaSeleccionada;
import modelo.Armadura;
import modelo.ArmaduraSeleccionada;
import modelo.CaracteristicaSeleccionada;
import modelo.Categoria;
import modelo.ConsultasHibernate;
import modelo.DesventajaSeleccionada;
import modelo.NivelClase;
import modelo.PdsCombate;
import modelo.PdsHabilidadesSecundarias;
import modelo.PdsHabilidadesSecundariasResumen;
import modelo.PdsMisticos;
import modelo.PdsPsiquicos;
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
	NivelClase nivelClase;
	
	@FXML
	ImageView imagenChar, iD10Apariencia;
	
	@FXML
	Accordion acPrincipalHabilidadesSecundarias, acPds, acTablasCombate;
	
	@FXML
	Pane pPersonajeChar, pD10Apariencia; 
	
	@FXML
	TitledPane tpAtleticas, tpPdsCombate, tpTablasArmas;
	
	@FXML
	TextField tApariencia, tCansancioBase, tCansancioEspecial, tCansancioTotal, tTurnoBase, tTurnoAgilidad, tTurnoDestreza, tTurnoCategoria, tTurnoArmadura,
	tTurnoDesarmado, tTurnoEspecial, tTurnoTotal, tPuntosVidaBase, tPuntosVidaCategoria, tPuntosVidaTotales, tRegeneracion, tCuracionDia, tNegativoDia, tPuntosVidaEspecial,
	tAccionesTurno, tPuntosCreacion, tCategoriaPrimerLv, tNivelTotal, tPdsRestantes, tLlevarArmadura, tHabilidadDefensa, tHabilidadAtaque, tPuntosRegeneracionEspecial,
	tRazaGeneral, tEtniaGeneral, tBonosNaturales, tHabilidadesNaturales, tBonosNovel, tTipoArma1, tTipoArma2, tTipoArma3, tTipoArma4;
	
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
	TableView<ArmaSeleccionada> tableviewArmaSeleccionada1, tableviewArmaSeleccionada2, tableviewArmaSeleccionada3, tableviewArmaSeleccionada4;
	
	@FXML
	TableView<ArmaduraSeleccionada> tableViewArmaduras;
	
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
	TableColumn<PdsHabilidadesSecundariasResumen, String> 
	colNombreSecundariaAtleticas, colPenalizadorSecundariaAtleticas, colTotalSecundariaAtleticas, 
	colNombreSecundariaSociales, colPenalizadorSecundariaSociales, colTotalSecundariaSociales,
	colNombreSecundariaPerceptivas, colPenalizadorSecundariaPerceptivas, colTotalSecundariaPerceptivas,
	colNombreSecundariaIntelectuales, colPenalizadorSecundariaIntelectuales, colTotalSecundariaIntelectuales, 
	colNombreSecundariaVigor, colPenalizadorSecundariaVigor, colTotalSecundariaVigor,
	colNombreSecundariaSubterfugio, colPenalizadorSecundariaSubterfugio, colTotalSecundariaSubterfugio,
	colNombreSecundariaCreativas, colPenalizadorSecundariaCreativas, colTotalSecundariaCreativas;

	@FXML
	TableColumn<ArmaSeleccionada, String> 
	colCritico1Arma1, colCritico2Arma1, colEnterezaArma1, colRoturaArma1, colTurnoArma1, colAtaqueArma1, colDañoArma1,
	colCritico1Arma2, colCritico2Arma2, colEnterezaArma2, colRoturaArma2, colTurnoArma2, colAtaqueArma2, colDañoArma2,
	colCritico1Arma3, colCritico2Arma3, colEnterezaArma3, colRoturaArma3, colTurnoArma3, colAtaqueArma3, colDañoArma3,
	colCritico1Arma4, colCritico2Arma4, colEnterezaArma4, colRoturaArma4, colTurnoArma4, colAtaqueArma4, colDañoArma4;

	@FXML
	ComboBox<String> cBoxNombreArma1, cBoxNombreArma2, cBoxNombreArma3, cBoxNombreArma4;
	
	@FXML
	TableColumn<ArmaduraSeleccionada, String> colArmaduraFilo, colArmaduraContundente, colArmaduraPenetrante, colArmaduraCalor, colArmaduraElectrico, colArmaduraFrio, colArmaduraEnergia,
	colArmaduraEntereza, colArmaduraRequisito, colArmaduraPenalizacionNatural;

	@FXML
	TableColumn<ArmaduraSeleccionada, ComboBox<String>> colArmaduraNombre;
	
	
	public PersonajeController(SessionFactory sessionFactory, String categoria, String raza) {
		this.ch = new ConsultasHibernate();
		this.sessionFactory = sessionFactory;
		this.categoriaSeleccionada = ch.obtenerCategoria(categoria, sessionFactory);
		this.razaSeleccionada = ch.obtenerRaza(raza, sessionFactory);
		this.nivelClase = new NivelClase(this.categoriaSeleccionada.getNombre(), "1");
		valorConstitucion = new ValorConstitucion(String.valueOf("0"));
	}
	
	@FXML
	public void initialize(){
		tNivelTotal.setText(nivelClase.getNivel());
		ObservableList<String> nombreVentajas = ch.obtenerNombresVentaja(sessionFactory);
		ObservableList<String> nombreDesventajas = ch.obtenerNombresDesventaja(sessionFactory);
		ObservableList<String> nombreArmas = ch.obtenerListaArmas(sessionFactory);
		ObservableList<String> nombreArmaduras = ch.obtenerListaArmaduras(sessionFactory);
		acPrincipalHabilidadesSecundarias.setExpandedPane(tpAtleticas);
		acPds.setExpandedPane(tpPdsCombate);
		acTablasCombate.setExpandedPane(tpTablasArmas);
		
		/*------------------------------------------------------Tabla Caracteristicas------------------------------------------------------*/
		int puntosCaracteristica=0;
		ObservableList<CaracteristicaSeleccionada> caracteristicas = FXCollections.observableArrayList(
				new CaracteristicaSeleccionada("AGI","0","0",razaSeleccionada.getBonoAgilidad()),
				new CaracteristicaSeleccionada("CON","0","0",razaSeleccionada.getBonoConstitucion()),
				new CaracteristicaSeleccionada("FUE","0","0",razaSeleccionada.getBonoFuerza()),
				new CaracteristicaSeleccionada("DES","0","0",razaSeleccionada.getBonoDestreza()),
				new CaracteristicaSeleccionada("INT","0","0",razaSeleccionada.getBonoPercepcion()),
				new CaracteristicaSeleccionada("PER","0","0",razaSeleccionada.getBonoPercepcion()),
				new CaracteristicaSeleccionada("POD","0","0",razaSeleccionada.getBonoPoder()),
				new CaracteristicaSeleccionada("VOL","0","0",razaSeleccionada.getBonoVoluntad()));
		
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
				new ResistenciasTabla("Pres. Base","0","0","0",nivelClase.getNivel()),
				new ResistenciasTabla("RF",tableViewCaracteristicas.getItems().get(1).getBonoCaracteristica(),razaSeleccionada.getBonoResistenciaFisica(),"0",nivelClase.getNivel()),
				new ResistenciasTabla("RE",tableViewCaracteristicas.getItems().get(1).getBonoCaracteristica(),razaSeleccionada.getBonoResistenciaEnfermedades(),"0",nivelClase.getNivel()),
				new ResistenciasTabla("RV",tableViewCaracteristicas.getItems().get(1).getBonoCaracteristica(),razaSeleccionada.getBonoResistenciaVenenos(),"0",nivelClase.getNivel()),
				new ResistenciasTabla("RM",tableViewCaracteristicas.getItems().get(6).getBonoCaracteristica(),razaSeleccionada.getBonoResistenciaMagica(),"0",nivelClase.getNivel()),
				new ResistenciasTabla("RP",tableViewCaracteristicas.getItems().get(7).getBonoCaracteristica(),razaSeleccionada.getBonoResistenciaPsiquica(),"0",nivelClase.getNivel()));
		
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
		
		/*------------------------------------------------------Tabla Pds Misticos Pestaña Pds------------------------------------------------------*/
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
				new PdsMisticos("Zeon",String.valueOf(categoriaSeleccionada.getCosteZeon()),null,tableViewCaracteristicas.getItems().get(6).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoZeon()),null),
				new PdsMisticos("ACT",String.valueOf(categoriaSeleccionada.getCosteAct()),null,tableViewCaracteristicas.getItems().get(6).getBonoCaracteristica(),"-",null),
				new PdsMisticos("Multiplo de regeneracion",String.valueOf(categoriaSeleccionada.getCosteAct()/2),null,tableViewCaracteristicas.getItems().get(6).getBonoCaracteristica(),"-",null),
				new PdsMisticos("Proyeccion Magia",String.valueOf(categoriaSeleccionada.getCosteProyeccionMagica()),null,tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),"-",null),
				new PdsMisticos("Nivel de Magia",String.valueOf(categoriaSeleccionada.getCosteNivelMagia()),null,tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),"-",null),
				
				new PdsMisticos("Convocar",String.valueOf(categoriaSeleccionada.getCosteConvocar()),null,tableViewCaracteristicas.getItems().get(6).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoConvocar()),null),
				new PdsMisticos("Controlar",String.valueOf(categoriaSeleccionada.getCosteControlar()),null,tableViewCaracteristicas.getItems().get(7).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoControlar()),null),
				new PdsMisticos("Atar",String.valueOf(categoriaSeleccionada.getCosteAtar()),null,tableViewCaracteristicas.getItems().get(6).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoAtar()),null),
				new PdsMisticos("Desconvocar",String.valueOf(categoriaSeleccionada.getCosteDesconvocar()),null,tableViewCaracteristicas.getItems().get(6).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoDesconvocar()),null));
		
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

		/*------------------------------------------------------Tabla Pds Psiquicos Pestaña Pds------------------------------------------------------*/
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

		/*------------------------------------------------------Tabla Habilidades Secundarias Pestaña Pds ------------------------------------------------------*/
		/*Obtener Valores Bonos*/
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
		
		/*Obtener Costes Reducidos de la Categoria Seleccionada*/
		String costeAcrobacias, costeAtletismo, costeBuscar, costeRastrear, costeTramperia, costeAnimales, costeHerbolaria, costeOcultarse, costeSigilo, costeRobo, costeValoracionMagica,
		costeOcultismo, costeDisfraz, costeProezaFuerza, costeSaltar, costeTrucoManos, costeEstilo, costeLiderazgo, costeIntimidar, costePersuasion, costeResistirDolor, costeFrialdad, costeVeneno,
		costeAdvertir,  costeMemorizar, costeTasacion;
		if (categoriaSeleccionada.getCosteReducidoAcrobacias()!=null&&categoriaSeleccionada.getCosteReducidoAcrobacias()<categoriaSeleccionada.getCosteAtleticas()) {
			costeAcrobacias = String.valueOf(categoriaSeleccionada.getCosteReducidoAcrobacias());
		} else {
			costeAcrobacias = String.valueOf(categoriaSeleccionada.getCosteAtleticas());
		}
		if (categoriaSeleccionada.getCosteReducidoAtletismo()!=null&&categoriaSeleccionada.getCosteReducidoAtletismo()<categoriaSeleccionada.getCosteAtleticas()) {
			costeAtletismo = String.valueOf(categoriaSeleccionada.getCosteReducidoAtletismo());
		} else {
			costeAtletismo = String.valueOf(categoriaSeleccionada.getCosteAtleticas());
		}
		if (categoriaSeleccionada.getCosteReducidoBuscar()!=null&&categoriaSeleccionada.getCosteReducidoBuscar()<categoriaSeleccionada.getCostePerceptivas()) {
			costeBuscar = String.valueOf(categoriaSeleccionada.getCosteReducidoAtletismo());
		} else {
			costeBuscar = String.valueOf(categoriaSeleccionada.getCostePerceptivas());
		}
		if (categoriaSeleccionada.getCosteReducidoRastrear()!=null&&categoriaSeleccionada.getCosteReducidoRastrear()<categoriaSeleccionada.getCostePerceptivas()) {
			costeRastrear = String.valueOf(categoriaSeleccionada.getCosteReducidoRastrear());
		} else {
			costeRastrear = String.valueOf(categoriaSeleccionada.getCostePerceptivas());
		}
		if (categoriaSeleccionada.getCosteReducidoTramperia()!=null&&categoriaSeleccionada.getCosteReducidoTramperia()<categoriaSeleccionada.getCosteSubterfugio()) {
			costeTramperia = String.valueOf(categoriaSeleccionada.getCosteReducidoTramperia());
		} else {
			costeTramperia = String.valueOf(categoriaSeleccionada.getCosteSubterfugio());
		}
		if (categoriaSeleccionada.getCosteReducidoAnimales()!=null&&categoriaSeleccionada.getCosteReducidoAnimales()<categoriaSeleccionada.getCosteIntelectuales()) {
			costeAnimales = String.valueOf(categoriaSeleccionada.getCosteReducidoAnimales());
		} else {
			costeAnimales = String.valueOf(categoriaSeleccionada.getCosteIntelectuales());
		}
		if (categoriaSeleccionada.getCosteReducidoHerbolaria()!=null&&categoriaSeleccionada.getCosteReducidoHerbolaria()<categoriaSeleccionada.getCosteIntelectuales()) {
			costeHerbolaria = String.valueOf(categoriaSeleccionada.getCosteReducidoHerbolaria());
		} else {
			costeHerbolaria = String.valueOf(categoriaSeleccionada.getCosteIntelectuales());
		}
		if (categoriaSeleccionada.getCosteReducidoOcultarse()!=null&&categoriaSeleccionada.getCosteReducidoOcultarse()<categoriaSeleccionada.getCosteSubterfugio()) {
			costeOcultarse = String.valueOf(categoriaSeleccionada.getCosteReducidoOcultarse());
		} else {
			costeOcultarse = String.valueOf(categoriaSeleccionada.getCosteSubterfugio());
		}
		if (categoriaSeleccionada.getCosteReducidoSigilo()!=null&&categoriaSeleccionada.getCosteReducidoSigilo()<categoriaSeleccionada.getCosteSubterfugio()) {
			costeSigilo = String.valueOf(categoriaSeleccionada.getCosteReducidoSigilo());
		} else {
			costeSigilo = String.valueOf(categoriaSeleccionada.getCosteSubterfugio());
		}
		if (categoriaSeleccionada.getCosteReducidoRobo()!=null&&categoriaSeleccionada.getCosteReducidoRobo()<categoriaSeleccionada.getCosteSubterfugio()) {
			costeRobo = String.valueOf(categoriaSeleccionada.getCosteReducidoRobo());
		} else {
			costeRobo = String.valueOf(categoriaSeleccionada.getCosteSubterfugio());
		} 
		if (categoriaSeleccionada.getCosteReducidoValoracionMagica()!=null&&categoriaSeleccionada.getCosteReducidoValoracionMagica()<categoriaSeleccionada.getCosteIntelectuales()) {
			costeValoracionMagica = String.valueOf(categoriaSeleccionada.getCosteReducidoValoracionMagica());
		} else {
			costeValoracionMagica = String.valueOf(categoriaSeleccionada.getCosteIntelectuales());
		}
		if (categoriaSeleccionada.getCosteReducidoOcultismo()!=null&&categoriaSeleccionada.getCosteReducidoOcultismo()<categoriaSeleccionada.getCosteIntelectuales()) {
			costeOcultismo = String.valueOf(categoriaSeleccionada.getCosteReducidoOcultismo());
		} else {
			costeOcultismo = String.valueOf(categoriaSeleccionada.getCosteIntelectuales());
		} 
		if (categoriaSeleccionada.getCosteReducidoDisfraz()!=null&&categoriaSeleccionada.getCosteReducidoDisfraz()<categoriaSeleccionada.getCosteSubterfugio()) {
			costeDisfraz = String.valueOf(categoriaSeleccionada.getCosteReducidoDisfraz());
		} else {
			costeDisfraz = String.valueOf(categoriaSeleccionada.getCosteSubterfugio());
		}
		if (categoriaSeleccionada.getCosteReducidoProezaFuerza()!=null&&categoriaSeleccionada.getCosteReducidoProezaFuerza()<categoriaSeleccionada.getCosteVigor()) {
			costeProezaFuerza = String.valueOf(categoriaSeleccionada.getCosteReducidoProezaFuerza());
		} else {
			costeProezaFuerza = String.valueOf(categoriaSeleccionada.getCosteVigor());
		}
		if (categoriaSeleccionada.getCosteReducidoSaltar()!=null&&categoriaSeleccionada.getCosteReducidoSaltar()<categoriaSeleccionada.getCosteAtleticas()) {
			costeSaltar = String.valueOf(categoriaSeleccionada.getCosteReducidoSaltar());
		} else {
			costeSaltar = String.valueOf(categoriaSeleccionada.getCosteAtleticas());
		}
		if (categoriaSeleccionada.getCosteReducidoTrucoManos()!=null&&categoriaSeleccionada.getCosteReducidoTrucoManos()<categoriaSeleccionada.getCosteCreativas()) {
			costeTrucoManos = String.valueOf(categoriaSeleccionada.getCosteReducidoTrucoManos());
		} else {
			costeTrucoManos = String.valueOf(categoriaSeleccionada.getCosteCreativas());
		}
		if (categoriaSeleccionada.getCosteReducidoEstilo()!=null&&categoriaSeleccionada.getCosteReducidoEstilo()<categoriaSeleccionada.getCosteSociales()) {
			costeEstilo = String.valueOf(categoriaSeleccionada.getCosteReducidoEstilo());
		} else {
			costeEstilo = String.valueOf(categoriaSeleccionada.getCosteSociales());
		}
		if (categoriaSeleccionada.getCosteReducidoLiderazgo()!=null&&categoriaSeleccionada.getCosteReducidoLiderazgo()<categoriaSeleccionada.getCosteSociales()) {
			costeLiderazgo = String.valueOf(categoriaSeleccionada.getCosteReducidoLiderazgo());
		} else {
			costeLiderazgo = String.valueOf(categoriaSeleccionada.getCosteSociales());
		} 
		if (categoriaSeleccionada.getCosteReducidoIntimidar()!=null&&categoriaSeleccionada.getCosteReducidoIntimidar()<categoriaSeleccionada.getCosteSociales()) {
			costeIntimidar = String.valueOf(categoriaSeleccionada.getCosteReducidoIntimidar());
		} else {
			costeIntimidar = String.valueOf(categoriaSeleccionada.getCosteSociales());
		}
		if (categoriaSeleccionada.getCosteReducidoPersuasion()!=null&&categoriaSeleccionada.getCosteReducidoPersuasion()<categoriaSeleccionada.getCosteSociales()) {
			costePersuasion = String.valueOf(categoriaSeleccionada.getCosteReducidoPersuasion());
		} else {
			costePersuasion = String.valueOf(categoriaSeleccionada.getCosteSociales());
		}
		if (categoriaSeleccionada.getCosteReducidoResistirDolor()!=null&&categoriaSeleccionada.getCosteReducidoResistirDolor()<categoriaSeleccionada.getCosteVigor()) {
			costeResistirDolor = String.valueOf(categoriaSeleccionada.getCosteReducidoResistirDolor());
		} else {
			costeResistirDolor = String.valueOf(categoriaSeleccionada.getCosteVigor());
		}
		if (categoriaSeleccionada.getCosteReducidoFrialdad()!=null&&categoriaSeleccionada.getCosteReducidoFrialdad()<categoriaSeleccionada.getCosteVigor()) {
			costeFrialdad = String.valueOf(categoriaSeleccionada.getCosteReducidoFrialdad());
		} else {
			costeFrialdad = String.valueOf(categoriaSeleccionada.getCosteVigor());
		}
		if (categoriaSeleccionada.getCosteReducidoVenenos()!=null&&categoriaSeleccionada.getCosteReducidoVenenos()<categoriaSeleccionada.getCosteSubterfugio()) {
			costeVeneno = String.valueOf(categoriaSeleccionada.getCosteReducidoVenenos());
		} else {
			costeVeneno = String.valueOf(categoriaSeleccionada.getCosteSubterfugio());
		}
		if (categoriaSeleccionada.getCosteReducidoAdvertir()!=null&&categoriaSeleccionada.getCosteReducidoAdvertir()<categoriaSeleccionada.getCostePerceptivas()) {
			costeAdvertir = String.valueOf(categoriaSeleccionada.getCosteReducidoAdvertir());
		} else {
			costeAdvertir = String.valueOf(categoriaSeleccionada.getCostePerceptivas());
		}
		if (categoriaSeleccionada.getCosteReducidoTasacion()!=null&&categoriaSeleccionada.getCosteReducidoTasacion()<categoriaSeleccionada.getCosteIntelectuales()) {
			costeTasacion = String.valueOf(categoriaSeleccionada.getCosteReducidoTasacion());
		} else {
			costeTasacion = String.valueOf(categoriaSeleccionada.getCosteIntelectuales());
		}
		if (categoriaSeleccionada.getCosteReducidoRastrear()!=null&&categoriaSeleccionada.getCosteReducidoRastrear()!=null&&categoriaSeleccionada.getCosteReducidoMemorizar()<categoriaSeleccionada.getCosteIntelectuales()) {
			costeMemorizar = String.valueOf(categoriaSeleccionada.getCosteReducidoMemorizar());
		} else {
			costeMemorizar = String.valueOf(categoriaSeleccionada.getCosteIntelectuales());
		}
		ObservableList<PdsHabilidadesSecundarias> pdsInvertidosSecundarias = FXCollections.observableArrayList(
				new PdsHabilidadesSecundarias("Acrobacias",costeAcrobacias,null,tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoAcrobacias()),null,null,null,null),
				new PdsHabilidadesSecundarias("Atletismo",costeAtletismo,null,tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoAtletismo()),null,null,null,null),
				new PdsHabilidadesSecundarias("Montar",String.valueOf(categoriaSeleccionada.getCosteAtleticas()),null,tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),"0",null,null,null,null),
				new PdsHabilidadesSecundarias("Nadar",String.valueOf(categoriaSeleccionada.getCosteAtleticas()),null,tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),"0",null,null,null,null),
				new PdsHabilidadesSecundarias("Trepar",String.valueOf(categoriaSeleccionada.getCosteAtleticas()),null,tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),"0",null,null,null,null),
				new PdsHabilidadesSecundarias("Saltar",costeSaltar,null,tableViewCaracteristicas.getItems().get(2).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoSaltar()),null,null,null,null),
				
				new PdsHabilidadesSecundarias("Estilo",costeEstilo,null,tableViewCaracteristicas.getItems().get(6).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoEstilo()),null,null,null,null),
				new PdsHabilidadesSecundarias("Intimidar",costeIntimidar,null,tableViewCaracteristicas.getItems().get(7).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoIntimidar()),null,null,null,null),
				new PdsHabilidadesSecundarias("Liderazgo",costeLiderazgo,null,tableViewCaracteristicas.getItems().get(6).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoLiderazgo()),null,null,null,null),
				new PdsHabilidadesSecundarias("Persuasion",costePersuasion,null,tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoPersuasion()),null,null,null,null),
				new PdsHabilidadesSecundarias("Comercio",String.valueOf(categoriaSeleccionada.getCosteSociales()),null,tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),"0",null,null,null,null),
				new PdsHabilidadesSecundarias("Callejeo",String.valueOf(categoriaSeleccionada.getCosteSociales()),null,tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),"0",null,null,null,null),
				new PdsHabilidadesSecundarias("Etiqueta",String.valueOf(categoriaSeleccionada.getCosteSociales()),null,tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),"0",null,null,null,null),
				
				new PdsHabilidadesSecundarias("Advertir",costeAdvertir,null,tableViewCaracteristicas.getItems().get(5).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoAdvertir()),null,null,null,null),
				new PdsHabilidadesSecundarias("Buscar",costeBuscar,null,tableViewCaracteristicas.getItems().get(5).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoBuscar()),null,null,null,null),
				new PdsHabilidadesSecundarias("Rastrear",costeRastrear,null,tableViewCaracteristicas.getItems().get(5).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoRastrear()),null,null,null,null),
				
				new PdsHabilidadesSecundarias("Animales",costeAnimales,null,tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoAnimales()),null,null,null,null),
				new PdsHabilidadesSecundarias("Ciencia",String.valueOf(categoriaSeleccionada.getCosteIntelectuales()),null,tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),"0",null,null,null,null),
				new PdsHabilidadesSecundarias("Ley",String.valueOf(categoriaSeleccionada.getCosteIntelectuales()),null,tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),"0",null,null,null,null),
				new PdsHabilidadesSecundarias("Herbolaria",costeHerbolaria,null,tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoHerbolaria()),null,null,null,null),
				new PdsHabilidadesSecundarias("Historia",String.valueOf(categoriaSeleccionada.getCosteIntelectuales()),null,tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),"0",null,null,null,null),
				new PdsHabilidadesSecundarias("Tactica",String.valueOf(categoriaSeleccionada.getCosteIntelectuales()),null,tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),"0",null,null,null,null),
				new PdsHabilidadesSecundarias("Medicina",String.valueOf(categoriaSeleccionada.getCosteIntelectuales()),null,tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),"0",null,null,null,null),
				new PdsHabilidadesSecundarias("Memorizar",costeMemorizar,null,tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),"0",null,null,null,null),
				new PdsHabilidadesSecundarias("Navegacion",String.valueOf(categoriaSeleccionada.getCosteIntelectuales()),null,tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),"0",null,null,null,null),
				new PdsHabilidadesSecundarias("Ocultismo",costeOcultismo,null,tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoOcultismo()),null,null,null,null),
				new PdsHabilidadesSecundarias("Tasacion",costeTasacion,null,tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),"0",null,null,null,null),
				new PdsHabilidadesSecundarias("V.Magica",costeValoracionMagica,null,tableViewCaracteristicas.getItems().get(6).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoValoracionMagica()),null,null,null,null),
				
				new PdsHabilidadesSecundarias("Frialdad",costeFrialdad,null,tableViewCaracteristicas.getItems().get(7).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoFrialdad()),null,null,null,null),
				new PdsHabilidadesSecundarias("P.Fuerza",costeProezaFuerza,null,tableViewCaracteristicas.getItems().get(2).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoProezaFuerza()),null,null,null,null),
				new PdsHabilidadesSecundarias("Res.Dolor",costeResistirDolor,null,tableViewCaracteristicas.getItems().get(7).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoResistirDolor()),null,null,null,null),
				
				new PdsHabilidadesSecundarias("Cerrajeria",String.valueOf(categoriaSeleccionada.getCosteSubterfugio()),null,tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),"0",null,null,null,null),
				new PdsHabilidadesSecundarias("Disfraz",costeDisfraz,null,tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoDisfraz()),null,null,null,null),
				new PdsHabilidadesSecundarias("Ocultarse",costeOcultarse,null,tableViewCaracteristicas.getItems().get(5).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoOcultarse()),null,null,null,null),
				new PdsHabilidadesSecundarias("Robo",costeRobo,null,tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoRobo()),null,null,null,null),
				new PdsHabilidadesSecundarias("Sigilo",costeSigilo,null,tableViewCaracteristicas.getItems().get(0).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoSigilo()),null,null,null,null),
				new PdsHabilidadesSecundarias("Tramperia",costeTramperia,null,tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoTramperia()),null,null,null,null),
				new PdsHabilidadesSecundarias("Venenos",costeVeneno,null,tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoVeneno()),null,null,null,null),
				
				new PdsHabilidadesSecundarias("Arte",String.valueOf(categoriaSeleccionada.getCosteCreativas()),null,tableViewCaracteristicas.getItems().get(6).getBonoCaracteristica(),"0",null,null,null,null),
				new PdsHabilidadesSecundarias("Baile",String.valueOf(categoriaSeleccionada.getCosteCreativas()),null,tableViewCaracteristicas.getItems().get(1).getBonoCaracteristica(),"0",null,null,null,null),
				new PdsHabilidadesSecundarias("Forja",String.valueOf(categoriaSeleccionada.getCosteCreativas()),null,tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),"0",null,null,null,null),
				new PdsHabilidadesSecundarias("Runas",String.valueOf(categoriaSeleccionada.getCosteCreativas()),null,tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),"0",null,null,null,null),
				new PdsHabilidadesSecundarias("Alquimia",String.valueOf(categoriaSeleccionada.getCosteCreativas()),null,tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),"0",null,null,null,null),
				new PdsHabilidadesSecundarias("Animismo",String.valueOf(categoriaSeleccionada.getCosteCreativas()),null,tableViewCaracteristicas.getItems().get(6).getBonoCaracteristica(),"0",null,null,null,null),
				new PdsHabilidadesSecundarias("Musica",String.valueOf(categoriaSeleccionada.getCosteCreativas()),null,tableViewCaracteristicas.getItems().get(6).getBonoCaracteristica(),"0",null,null,null,null),
				new PdsHabilidadesSecundarias("T.Manos",costeTrucoManos,null,tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoTrucoManos()),null,null,null,null),
				new PdsHabilidadesSecundarias("Caligrafia Ritual",String.valueOf(categoriaSeleccionada.getCosteCreativas()),null,tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),"0",null,null,null,null),
				new PdsHabilidadesSecundarias("Orfebreria",String.valueOf(categoriaSeleccionada.getCosteCreativas()),null,tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),"0",null,null,null,null),
				new PdsHabilidadesSecundarias("Confeccion",String.valueOf(categoriaSeleccionada.getCosteCreativas()),null,tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),"0",null,null,null,null));
		
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
		
		/*------------------------------------------------------Tabla Pds Resumen Secundarias Pestaña Principal------------------------------------------------------*/
		ObservableList<PdsHabilidadesSecundariasResumen> resumenSecundarias1 = FXCollections.observableArrayList(
				new PdsHabilidadesSecundariasResumen("Acrobacias","0",tableViewSecundarias.getItems().get(0).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("Atletismo","0",tableViewSecundarias.getItems().get(1).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("Montar","0",tableViewSecundarias.getItems().get(2).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("Nadar","0",tableViewSecundarias.getItems().get(3).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("Trepar","0",tableViewSecundarias.getItems().get(4).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("Saltar","0",tableViewSecundarias.getItems().get(5).getTotalHabilidad()));
		
		colNombreSecundariaAtleticas.setCellValueFactory(new PropertyValueFactory<PdsHabilidadesSecundariasResumen, String>("nombreHabilidad"));
		colPenalizadorSecundariaAtleticas.setCellValueFactory(new PropertyValueFactory<PdsHabilidadesSecundariasResumen, String>("penalizadorNaturalHabilidad"));
		colTotalSecundariaAtleticas.setCellValueFactory(new PropertyValueFactory<PdsHabilidadesSecundariasResumen, String>("totalHabilidad"));
		
		tableViewResumenAtleticas.setItems(resumenSecundarias1);
		/*------------------------------------------------------Tabla Pds Resumen Secundarias Pestaña Principal------------------------------------------------------*/
		ObservableList<PdsHabilidadesSecundariasResumen> resumenSecundarias2 = FXCollections.observableArrayList(
				new PdsHabilidadesSecundariasResumen("Estilo","0",tableViewSecundarias.getItems().get(6).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("Intimidar","0",tableViewSecundarias.getItems().get(7).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("Liderazgo","0",tableViewSecundarias.getItems().get(8).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("Persuasion","0",tableViewSecundarias.getItems().get(9).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("Comercio","0",tableViewSecundarias.getItems().get(10).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("Callejeo","0",tableViewSecundarias.getItems().get(11).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("Etiqueta","0",tableViewSecundarias.getItems().get(12).getTotalHabilidad()));
		
		colNombreSecundariaSociales.setCellValueFactory(new PropertyValueFactory<PdsHabilidadesSecundariasResumen, String>("nombreHabilidad"));
		colPenalizadorSecundariaSociales.setCellValueFactory(new PropertyValueFactory<PdsHabilidadesSecundariasResumen, String>("penalizadorNaturalHabilidad"));
		colTotalSecundariaSociales.setCellValueFactory(new PropertyValueFactory<PdsHabilidadesSecundariasResumen, String>("totalHabilidad"));
		
		tableViewResumenSociales.setItems(resumenSecundarias2);
		
		/*------------------------------------------------------Tabla Pds Resumen Secundarias Pestaña Principal------------------------------------------------------*/
		ObservableList<PdsHabilidadesSecundariasResumen> resumenSecundarias3 = FXCollections.observableArrayList(
				new PdsHabilidadesSecundariasResumen("Advertir","0",tableViewSecundarias.getItems().get(13).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("Buscar","0",tableViewSecundarias.getItems().get(14).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("Rastrear","0",tableViewSecundarias.getItems().get(15).getTotalHabilidad()));
		
		colNombreSecundariaPerceptivas.setCellValueFactory(new PropertyValueFactory<PdsHabilidadesSecundariasResumen, String>("nombreHabilidad"));
		colPenalizadorSecundariaPerceptivas.setCellValueFactory(new PropertyValueFactory<PdsHabilidadesSecundariasResumen, String>("penalizadorNaturalHabilidad"));
		colTotalSecundariaPerceptivas.setCellValueFactory(new PropertyValueFactory<PdsHabilidadesSecundariasResumen, String>("totalHabilidad"));
		
		tableViewResumenPerceptivas.setItems(resumenSecundarias3);

		/*------------------------------------------------------Tabla Pds Resumen Secundarias Pestaña Principal------------------------------------------------------*/
		ObservableList<PdsHabilidadesSecundariasResumen> resumenSecundarias4 = FXCollections.observableArrayList(
				new PdsHabilidadesSecundariasResumen("Animales","0",tableViewSecundarias.getItems().get(16).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("Ciencia","0",tableViewSecundarias.getItems().get(17).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("Ley","0",tableViewSecundarias.getItems().get(18).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("Herbolaria","0",tableViewSecundarias.getItems().get(19).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("Historia","0",tableViewSecundarias.getItems().get(20).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("Tactica","0",tableViewSecundarias.getItems().get(21).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("Medicina","0",tableViewSecundarias.getItems().get(22).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("Memorizar","0",tableViewSecundarias.getItems().get(23).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("Navegacion","0",tableViewSecundarias.getItems().get(24).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("Ocultismo","0",tableViewSecundarias.getItems().get(25).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("Tasacion","0",tableViewSecundarias.getItems().get(26).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("V.Magica","0",tableViewSecundarias.getItems().get(27).getTotalHabilidad()));
		
		
		colNombreSecundariaIntelectuales.setCellValueFactory(new PropertyValueFactory<PdsHabilidadesSecundariasResumen, String>("nombreHabilidad"));
		colPenalizadorSecundariaIntelectuales.setCellValueFactory(new PropertyValueFactory<PdsHabilidadesSecundariasResumen, String>("penalizadorNaturalHabilidad"));
		colTotalSecundariaIntelectuales.setCellValueFactory(new PropertyValueFactory<PdsHabilidadesSecundariasResumen, String>("totalHabilidad"));
		
		tableViewResumenIntelectuales.setItems(resumenSecundarias4);

		/*------------------------------------------------------Tabla Pds Resumen Secundarias Pestaña Principal------------------------------------------------------*/
		ObservableList<PdsHabilidadesSecundariasResumen> resumenSecundarias5 = FXCollections.observableArrayList(
				new PdsHabilidadesSecundariasResumen("Frialdad","0",tableViewSecundarias.getItems().get(28).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("P.Fuerza","0",tableViewSecundarias.getItems().get(29).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("R.Dolor","0",tableViewSecundarias.getItems().get(30).getTotalHabilidad()));
		
		
		colNombreSecundariaVigor.setCellValueFactory(new PropertyValueFactory<PdsHabilidadesSecundariasResumen, String>("nombreHabilidad"));
		colPenalizadorSecundariaVigor.setCellValueFactory(new PropertyValueFactory<PdsHabilidadesSecundariasResumen, String>("penalizadorNaturalHabilidad"));
		colTotalSecundariaVigor.setCellValueFactory(new PropertyValueFactory<PdsHabilidadesSecundariasResumen, String>("totalHabilidad"));
		
		tableViewResumenVigor.setItems(resumenSecundarias5);

		/*------------------------------------------------------Tabla Pds Resumen Secundarias Pestaña Principal------------------------------------------------------*/
		ObservableList<PdsHabilidadesSecundariasResumen> resumenSecundarias6 = FXCollections.observableArrayList(
				new PdsHabilidadesSecundariasResumen("Cerrajeria","0",tableViewSecundarias.getItems().get(31).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("Disfraz","0",tableViewSecundarias.getItems().get(32).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("Ocultarse","0",tableViewSecundarias.getItems().get(33).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("Robo","0",tableViewSecundarias.getItems().get(34).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("Sigilo","0",tableViewSecundarias.getItems().get(35).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("Tramperia","0",tableViewSecundarias.getItems().get(36).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("Venenos","0",tableViewSecundarias.getItems().get(37).getTotalHabilidad()));
		
		
		colNombreSecundariaSubterfugio.setCellValueFactory(new PropertyValueFactory<PdsHabilidadesSecundariasResumen, String>("nombreHabilidad"));
		colPenalizadorSecundariaSubterfugio.setCellValueFactory(new PropertyValueFactory<PdsHabilidadesSecundariasResumen, String>("penalizadorNaturalHabilidad"));
		colTotalSecundariaSubterfugio.setCellValueFactory(new PropertyValueFactory<PdsHabilidadesSecundariasResumen, String>("totalHabilidad"));
		
		tableViewResumenSubterfugio.setItems(resumenSecundarias6);
		
		/*------------------------------------------------------Tabla Pds Resumen Secundarias Pestaña Principal------------------------------------------------------*/
		ObservableList<PdsHabilidadesSecundariasResumen> resumenSecundarias7 = FXCollections.observableArrayList(
				new PdsHabilidadesSecundariasResumen("Arte","0",tableViewSecundarias.getItems().get(38).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("Baile","0",tableViewSecundarias.getItems().get(39).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("Forja","0",tableViewSecundarias.getItems().get(40).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("Runas","0",tableViewSecundarias.getItems().get(41).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("Alquimia","0",tableViewSecundarias.getItems().get(42).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("Animismo","0",tableViewSecundarias.getItems().get(43).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("Musica","0",tableViewSecundarias.getItems().get(44).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("T.Manos","0",tableViewSecundarias.getItems().get(45).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("Caligrafia Ritual","0",tableViewSecundarias.getItems().get(46).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("Orfebreria","0",tableViewSecundarias.getItems().get(47).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("Confeccion","0",tableViewSecundarias.getItems().get(48).getTotalHabilidad()));
		
		
		colNombreSecundariaCreativas.setCellValueFactory(new PropertyValueFactory<PdsHabilidadesSecundariasResumen, String>("nombreHabilidad"));
		colPenalizadorSecundariaCreativas.setCellValueFactory(new PropertyValueFactory<PdsHabilidadesSecundariasResumen, String>("penalizadorNaturalHabilidad"));
		colTotalSecundariaCreativas.setCellValueFactory(new PropertyValueFactory<PdsHabilidadesSecundariasResumen, String>("totalHabilidad"));
		
		tableViewResumenCreativas.setItems(resumenSecundarias7);
		
		/*------------------------------------------------------Tabla Pds Arma1 de la pestaña Combate------------------------------------------------------*/
		
		/*------------------------------------------------------Seteo del turno de los texfield de la pestaña principal------------------------------------------------------*/
		valorTextFieldTurnoTotal();
		
		cBoxNombreArma1.setItems(nombreArmas);
		cBoxNombreArma2.setItems(nombreArmas);
		cBoxNombreArma3.setItems(nombreArmas);
		cBoxNombreArma4.setItems(nombreArmas);
		ObservableList<ArmaSeleccionada> armaSeleccionada1;
		ObservableList<ArmaSeleccionada> armaSeleccionada2;
		ObservableList<ArmaSeleccionada> armaSeleccionada3;
		ObservableList<ArmaSeleccionada> armaSeleccionada4;
		
		/*Si no tiene armas seleccionadas Lista 1*/
		if ("null".equals(cBoxNombreArma1.getSelectionModel().getSelectedItem())||
				cBoxNombreArma1.getSelectionModel().isEmpty()||
				cBoxNombreArma1.getSelectionModel().getSelectedItem()=="") {
			armaSeleccionada1 = FXCollections.observableArrayList(
					new ArmaSeleccionada(ch.obtenerArma(sessionFactory, "Desarmado"),
							tableViewCombate.getItems().get(0).getTotalHabilidad(),
							tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),
							tTurnoTotal.getText()));
			cBoxNombreArma1.setValue("Desarmado");
			tTipoArma1.setText(armaSeleccionada1.get(0).getTipoArma());
			/*Esta seria en caso de que haya un personaje ya creado con sus armas ya elegidas*/
		} else {
			armaSeleccionada1 = FXCollections.observableArrayList(
					new ArmaSeleccionada(ch.obtenerArma(sessionFactory, cBoxNombreArma1.getSelectionModel().getSelectedItem()),
							tableViewCombate.getItems().get(0).getTotalHabilidad(),
							tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),
							tTurnoTotal.getText()));
		}
		
		colCritico1Arma1.setCellValueFactory(new PropertyValueFactory<ArmaSeleccionada, String>("critico1"));
		colCritico2Arma1.setCellValueFactory(new PropertyValueFactory<ArmaSeleccionada, String>("critico2"));
		colEnterezaArma1.setCellValueFactory(new PropertyValueFactory<ArmaSeleccionada, String>("entereza"));
		colRoturaArma1.setCellValueFactory(new PropertyValueFactory<ArmaSeleccionada, String>("rotura"));
		colTurnoArma1.setCellValueFactory(new PropertyValueFactory<ArmaSeleccionada, String>("turno"));
		colAtaqueArma1.setCellValueFactory(new PropertyValueFactory<ArmaSeleccionada, String>("ataque"));
		colDañoArma1.setCellValueFactory(new PropertyValueFactory<ArmaSeleccionada, String>("daño"));
		
		tableviewArmaSeleccionada1.setItems(armaSeleccionada1);
		

		/*Si no tiene armas seleccionadas Lista 2*/
		if ("null".equals(cBoxNombreArma2.getSelectionModel().getSelectedItem())||
				cBoxNombreArma2.getSelectionModel().isEmpty()||
				cBoxNombreArma2.getSelectionModel().getSelectedItem()=="") {
			armaSeleccionada2 = FXCollections.observableArrayList(
					new ArmaSeleccionada(ch.obtenerArma(sessionFactory, "Desarmado"),
							tableViewCombate.getItems().get(0).getTotalHabilidad(),
							tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),
							tTurnoTotal.getText()));
			cBoxNombreArma2.setValue("Desarmado");
			tTipoArma2.setText(armaSeleccionada2.get(0).getTipoArma());
			/*Esta seria en caso de que haya un personaje ya creado con sus armas ya elegidas*/
		} else {
			armaSeleccionada2 = FXCollections.observableArrayList(
					new ArmaSeleccionada(ch.obtenerArma(sessionFactory, cBoxNombreArma2.getSelectionModel().getSelectedItem()),
							tableViewCombate.getItems().get(0).getTotalHabilidad(),
							tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),
							tTurnoTotal.getText()));
		}
		
		colCritico1Arma2.setCellValueFactory(new PropertyValueFactory<ArmaSeleccionada, String>("critico1"));
		colCritico2Arma2.setCellValueFactory(new PropertyValueFactory<ArmaSeleccionada, String>("critico2"));
		colEnterezaArma2.setCellValueFactory(new PropertyValueFactory<ArmaSeleccionada, String>("entereza"));
		colRoturaArma2.setCellValueFactory(new PropertyValueFactory<ArmaSeleccionada, String>("rotura"));
		colTurnoArma2.setCellValueFactory(new PropertyValueFactory<ArmaSeleccionada, String>("turno"));
		colAtaqueArma2.setCellValueFactory(new PropertyValueFactory<ArmaSeleccionada, String>("ataque"));
		colDañoArma2.setCellValueFactory(new PropertyValueFactory<ArmaSeleccionada, String>("daño"));
		
		tableviewArmaSeleccionada2.setItems(armaSeleccionada2);
		
		/*Si no tiene armas seleccionadas Lista 3*/
		if ("null".equals(cBoxNombreArma3.getSelectionModel().getSelectedItem())||
				cBoxNombreArma3.getSelectionModel().isEmpty()||
				cBoxNombreArma3.getSelectionModel().getSelectedItem()=="") {
			armaSeleccionada3 = FXCollections.observableArrayList(
					new ArmaSeleccionada(ch.obtenerArma(sessionFactory, "Desarmado"),
							tableViewCombate.getItems().get(0).getTotalHabilidad(),
							tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),
							tTurnoTotal.getText()));
			cBoxNombreArma3.setValue("Desarmado");
			tTipoArma3.setText(armaSeleccionada1.get(0).getTipoArma());
			/*Esta seria en caso de que haya un personaje ya creado con sus armas ya elegidas*/
		} else {
			armaSeleccionada3 = FXCollections.observableArrayList(
					new ArmaSeleccionada(ch.obtenerArma(sessionFactory, cBoxNombreArma3.getSelectionModel().getSelectedItem()),
							tableViewCombate.getItems().get(0).getTotalHabilidad(),
							tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),
							tTurnoTotal.getText()));
		}
		
		colCritico1Arma3.setCellValueFactory(new PropertyValueFactory<ArmaSeleccionada, String>("critico1"));
		colCritico2Arma3.setCellValueFactory(new PropertyValueFactory<ArmaSeleccionada, String>("critico2"));
		colEnterezaArma3.setCellValueFactory(new PropertyValueFactory<ArmaSeleccionada, String>("entereza"));
		colRoturaArma3.setCellValueFactory(new PropertyValueFactory<ArmaSeleccionada, String>("rotura"));
		colTurnoArma3.setCellValueFactory(new PropertyValueFactory<ArmaSeleccionada, String>("turno"));
		colAtaqueArma3.setCellValueFactory(new PropertyValueFactory<ArmaSeleccionada, String>("ataque"));
		colDañoArma3.setCellValueFactory(new PropertyValueFactory<ArmaSeleccionada, String>("daño"));
		
		tableviewArmaSeleccionada3.setItems(armaSeleccionada3);
		

		/*Si no tiene armas seleccionadas Lista 4*/
		if ("null".equals(cBoxNombreArma4.getSelectionModel().getSelectedItem())||
				cBoxNombreArma4.getSelectionModel().isEmpty()||
				cBoxNombreArma4.getSelectionModel().getSelectedItem()=="") {
			armaSeleccionada4 = FXCollections.observableArrayList(
					new ArmaSeleccionada(ch.obtenerArma(sessionFactory, "Desarmado"),
							tableViewCombate.getItems().get(0).getTotalHabilidad(),
							tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),
							tTurnoTotal.getText()));
			cBoxNombreArma4.setValue("Desarmado");
			tTipoArma4.setText(armaSeleccionada4.get(0).getTipoArma());
			/*Esta seria en caso de que haya un personaje ya creado con sus armas ya elegidas*/
		} else {
			armaSeleccionada4 = FXCollections.observableArrayList(
					new ArmaSeleccionada(ch.obtenerArma(sessionFactory, cBoxNombreArma4.getSelectionModel().getSelectedItem()),
							tableViewCombate.getItems().get(0).getTotalHabilidad(),
							tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),
							tTurnoTotal.getText()));
		}
		
		colCritico1Arma4.setCellValueFactory(new PropertyValueFactory<ArmaSeleccionada, String>("critico1"));
		colCritico2Arma4.setCellValueFactory(new PropertyValueFactory<ArmaSeleccionada, String>("critico2"));
		colEnterezaArma4.setCellValueFactory(new PropertyValueFactory<ArmaSeleccionada, String>("entereza"));
		colRoturaArma4.setCellValueFactory(new PropertyValueFactory<ArmaSeleccionada, String>("rotura"));
		colTurnoArma4.setCellValueFactory(new PropertyValueFactory<ArmaSeleccionada, String>("turno"));
		colAtaqueArma4.setCellValueFactory(new PropertyValueFactory<ArmaSeleccionada, String>("ataque"));
		colDañoArma4.setCellValueFactory(new PropertyValueFactory<ArmaSeleccionada, String>("daño"));
		
		tableviewArmaSeleccionada4.setItems(armaSeleccionada4);

		/*------------------------------------------------------Tabla Armaduras Pestaña Combate------------------------------------------------------*/
		ComboBox<String> cArmaduras = new ComboBox<String>();
		cArmaduras.setItems(nombreArmaduras);
		
		ObservableList<ArmaduraSeleccionada> armadurasSeleccionadas = FXCollections.observableArrayList(
				new ArmaduraSeleccionada(cArmaduras,"-","-","-","-","-","-","-","-","-","-"));
		
		cArmaduras.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				Armadura armadura = ch.obtenerArmamadura(sessionFactory, cArmaduras.getSelectionModel().getSelectedItem());
				ArmaduraSeleccionada armaduraSeleccionada = armadurasSeleccionadas.get(0);
				armaduraSeleccionada.setFilo(String.valueOf(armadura.getTipoArmaduraFilo()));
				armaduraSeleccionada.setContundente(String.valueOf(armadura.getTipoArmaduraFilo()));
				armaduraSeleccionada.setPenetrante(String.valueOf(armadura.getTipoArmaduraPenetrante()));
				armaduraSeleccionada.setCalor(String.valueOf(armadura.getTipoArmaduraCalor()));
				armaduraSeleccionada.setElectrico(String.valueOf(armadura.getTipoArmaduraElectrico()));
				armaduraSeleccionada.setFrio(String.valueOf(armadura.getTipoArmaduraFrio()));
				armaduraSeleccionada.setEnergia(String.valueOf(armadura.getTipoArmaduraEnergia()));
				armaduraSeleccionada.setEntereza(String.valueOf(armadura.getEntereza()));
				armaduraSeleccionada.setRequisito(String.valueOf(armadura.getRequisitoNecesario()));
				armaduraSeleccionada.setPenalizadorNatural(String.valueOf(armadura.getPenalizadorNatural()));
				tableViewArmaduras.refresh();
				
			}
		});
		
		
		colArmaduraNombre.setCellValueFactory(new PropertyValueFactory<ArmaduraSeleccionada, ComboBox<String>>("nombreArmadura"));
		colArmaduraFilo.setCellValueFactory(new PropertyValueFactory<ArmaduraSeleccionada, String>("filo"));
		colArmaduraContundente.setCellValueFactory(new PropertyValueFactory<ArmaduraSeleccionada, String>("contundente"));
		colArmaduraPenetrante.setCellValueFactory(new PropertyValueFactory<ArmaduraSeleccionada, String>("penetrante"));
		colArmaduraCalor.setCellValueFactory(new PropertyValueFactory<ArmaduraSeleccionada, String>("calor"));
		colArmaduraElectrico.setCellValueFactory(new PropertyValueFactory<ArmaduraSeleccionada, String>("electrico"));
		colArmaduraFrio.setCellValueFactory(new PropertyValueFactory<ArmaduraSeleccionada, String>("frio"));
		colArmaduraEnergia.setCellValueFactory(new PropertyValueFactory<ArmaduraSeleccionada, String>("energia"));
		colArmaduraEntereza.setCellValueFactory(new PropertyValueFactory<ArmaduraSeleccionada, String>("entereza"));
		colArmaduraRequisito.setCellValueFactory(new PropertyValueFactory<ArmaduraSeleccionada, String>("requisito"));
		colArmaduraPenalizacionNatural.setCellValueFactory(new PropertyValueFactory<ArmaduraSeleccionada, String>("penalizadorNatural"));
		
		tableViewArmaduras.setItems(armadurasSeleccionadas);
		
		/*------------------------------------------------------Valores TextField Pestaña Principal------------------------------------------------------*/
		

		tRazaGeneral.setText(razaSeleccionada.getNombre());
		tPdsRestantes.setText(nivelClase.getPds());
		tBonosNaturales.setText(nivelClase.getBonoNatural());
		tHabilidadesNaturales.setText(nivelClase.getHabilidadNatural());
		tBonosNovel.setText(nivelClase.getBonoNovel());
		tPuntosVidaCategoria.setText(String.valueOf(categoriaSeleccionada.getPuntosVida()));
		tPuntosVidaBase.setText(valorConstitucion.getPuntosVidaBase());
		tPuntosVidaBase.setText(valorConstitucion.getPuntosVidaBase());
		tPuntosVidaTotales.setText(String.valueOf(Integer.parseInt(valorConstitucion.getPuntosVidaBase())+Integer.parseInt(tPuntosVidaCategoria.getText())));
		
		tRegeneracion.setText("0");
		valorConstitucion.setRegeneracionBase(String.valueOf(Integer.parseInt(tRegeneracion.getText())+Integer.parseInt(razaSeleccionada.getBonoRegeneracion())));
		tRegeneracion.setText(valorConstitucion.getRegeneracionBase());
		tCuracionDia.setText(valorConstitucion.getCuracionDia());
		tNegativoDia.setText(valorConstitucion.getNegativoDia());
		tCansancioBase.setText(String.valueOf(tableViewCaracteristicas.getItems().get(1).getTotalCaracteristica()));
		tCansancioEspecial.setText("0");
		tCansancioTotal.setText(String.valueOf(Integer.parseInt(tableViewCaracteristicas.getItems().get(1).getTotalCaracteristica())+Integer.parseInt(tCansancioEspecial.getText())+Integer.parseInt(razaSeleccionada.getBonoCansancio())));
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
		
		obtenerCaracteristicas(caracteristica);
		
	}
	
	public void cambiarTemporal (TableColumn.CellEditEvent<CaracteristicaSeleccionada, String> cellEditEvent) {
		CaracteristicaSeleccionada caracteristica = tableViewCaracteristicas.getSelectionModel().getSelectedItem();
		caracteristica.setTempCaracteristica(cellEditEvent.getNewValue());

		obtenerCaracteristicas(caracteristica);
	}
	
	public void cambiarEspecialResistencias (TableColumn.CellEditEvent<ResistenciasTabla, String> cellEditEvent) {
		ResistenciasTabla resistencia = tableViewResistencias.getSelectionModel().getSelectedItem();
		resistencia.setBonoEspecial(cellEditEvent.getNewValue());
		
		tableViewResistencias.refresh();
	}

	public void cambiarPdsCombate (TableColumn.CellEditEvent<PdsCombate, String> cellEditEvent) {
		PdsCombate pds = tableViewCombate.getSelectionModel().getSelectedItem();
		pds.setPdsHabilidad(cellEditEvent.getNewValue());
		
		cambiarPdsCombate(pds);
	}
	
	public void cambiarPdsEspecialCombate (TableColumn.CellEditEvent<PdsCombate, String> cellEditEvent) {
		PdsCombate pds = tableViewCombate.getSelectionModel().getSelectedItem();
		pds.setEspecialHabilidad(cellEditEvent.getNewValue());
		
		cambiarPdsCombate(pds);
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
		
		obtenerTotalHabilidades(pds);
	}

	public void cambiarPdsEspecialHabilidadesSecundarias (TableColumn.CellEditEvent<PdsHabilidadesSecundarias, String> cellEditEvent) {
		PdsHabilidadesSecundarias pds = tableViewSecundarias.getSelectionModel().getSelectedItem();
		pds.setEspecialHabilidad(cellEditEvent.getNewValue());
		
		obtenerTotalHabilidades(pds);
	}

	public void cambiarPdsBonoNaturalHabilidadesSecundarias (TableColumn.CellEditEvent<PdsHabilidadesSecundarias, String> cellEditEvent) {
		PdsHabilidadesSecundarias pds = tableViewSecundarias.getSelectionModel().getSelectedItem();
		pds.setBonoNatural(cellEditEvent.getNewValue());
		
		obtenerTotalHabilidades(pds);
	}

	public void cambiarPdsHabilidadNaturalHabilidadesSecundarias (TableColumn.CellEditEvent<PdsHabilidadesSecundarias, String> cellEditEvent) {
		PdsHabilidadesSecundarias pds = tableViewSecundarias.getSelectionModel().getSelectedItem();
		pds.setHabilidadNatural(cellEditEvent.getNewValue());
		
		obtenerTotalHabilidades(pds);
	}

	public void cambiarPdsBonoNovelHabilidadesSecundarias (TableColumn.CellEditEvent<PdsHabilidadesSecundarias, String> cellEditEvent) {
		PdsHabilidadesSecundarias pds = tableViewSecundarias.getSelectionModel().getSelectedItem();
		pds.setBonoNovel(cellEditEvent.getNewValue());
		
		obtenerTotalHabilidades(pds);
	}

	public void obtenerCaracteristicas(CaracteristicaSeleccionada caracteristica) {
		if (tableViewCaracteristicas.getSelectionModel().getSelectedItem().getNombreCaracteristica().equals("AGI")) {
			caracteristica.setTotalCaracteristica(String.valueOf(Integer.parseInt(caracteristica.getBaseCaracteristica())+Integer.parseInt(caracteristica.getTempCaracteristica())+Integer.parseInt(razaSeleccionada.getBonoAgilidad())));
			caracteristica.setBonoCaracteristica(caracteristica.getTotalCaracteristica());
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
			tableViewSecundarias.getItems().get(0).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(0).setBonoNatural(tableViewSecundarias.getItems().get(0).getBonoNatural());
			tableViewSecundarias.getItems().get(0).setHabilidadNatural(tableViewSecundarias.getItems().get(0).getHabilidadNatural());
			tableViewSecundarias.getItems().get(0).setBonoNovel(tableViewSecundarias.getItems().get(0).getBonoNovel());
			tableViewResumenAtleticas.getItems().get(0).setTotalHabilidad(tableViewSecundarias.getItems().get(0).getTotalHabilidad());
			
			tableViewSecundarias.getItems().get(1).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(1).setBonoNatural(tableViewSecundarias.getItems().get(1).getBonoNatural());
			tableViewSecundarias.getItems().get(1).setHabilidadNatural(tableViewSecundarias.getItems().get(1).getHabilidadNatural());
			tableViewSecundarias.getItems().get(1).setBonoNovel(tableViewSecundarias.getItems().get(1).getBonoNovel());
			tableViewResumenAtleticas.getItems().get(1).setTotalHabilidad(tableViewSecundarias.getItems().get(1).getTotalHabilidad());
			
			tableViewSecundarias.getItems().get(2).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(2).setBonoNatural(tableViewSecundarias.getItems().get(2).getBonoNatural());
			tableViewSecundarias.getItems().get(2).setHabilidadNatural(tableViewSecundarias.getItems().get(2).getHabilidadNatural());
			tableViewSecundarias.getItems().get(2).setBonoNovel(tableViewSecundarias.getItems().get(2).getBonoNovel());
			tableViewResumenAtleticas.getItems().get(2).setTotalHabilidad(tableViewSecundarias.getItems().get(2).getTotalHabilidad());
			
			tableViewSecundarias.getItems().get(3).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(3).setBonoNatural(tableViewSecundarias.getItems().get(3).getBonoNatural());
			tableViewSecundarias.getItems().get(3).setHabilidadNatural(tableViewSecundarias.getItems().get(3).getHabilidadNatural());
			tableViewSecundarias.getItems().get(3).setBonoNovel(tableViewSecundarias.getItems().get(3).getBonoNovel());
			tableViewResumenAtleticas.getItems().get(3).setTotalHabilidad(tableViewSecundarias.getItems().get(3).getTotalHabilidad());
			
			tableViewSecundarias.getItems().get(4).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(4).setBonoNatural(tableViewSecundarias.getItems().get(4).getBonoNatural());
			tableViewSecundarias.getItems().get(4).setHabilidadNatural(tableViewSecundarias.getItems().get(4).getHabilidadNatural());
			tableViewSecundarias.getItems().get(4).setBonoNovel(tableViewSecundarias.getItems().get(4).getBonoNovel());
			tableViewResumenAtleticas.getItems().get(4).setTotalHabilidad(tableViewSecundarias.getItems().get(4).getTotalHabilidad());
			
			tableViewSecundarias.getItems().get(34).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(34).setBonoNatural(tableViewSecundarias.getItems().get(34).getBonoNatural());
			tableViewSecundarias.getItems().get(34).setHabilidadNatural(tableViewSecundarias.getItems().get(34).getHabilidadNatural());
			tableViewSecundarias.getItems().get(34).setBonoNovel(tableViewSecundarias.getItems().get(34).getBonoNovel());
			tableViewResumenSubterfugio.getItems().get(4).setTotalHabilidad(tableViewSecundarias.getItems().get(34).getTotalHabilidad());
			
			tableViewSecundarias.getItems().get(39).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(39).setBonoNatural(tableViewSecundarias.getItems().get(39).getBonoNatural());
			tableViewSecundarias.getItems().get(39).setHabilidadNatural(tableViewSecundarias.getItems().get(39).getHabilidadNatural());
			tableViewSecundarias.getItems().get(39).setBonoNovel(tableViewSecundarias.getItems().get(39).getBonoNovel());
			tableViewResumenCreativas.getItems().get(1).setTotalHabilidad(tableViewSecundarias.getItems().get(39).getTotalHabilidad());
			
			tableviewArmaSeleccionada1.getItems().get(0).setTurno(String.valueOf(Integer.parseInt(tTurnoBase.getText())+Integer.parseInt(tTurnoAgilidad.getText())+
					Integer.parseInt(tTurnoDestreza.getText())+Integer.parseInt(tTurnoCategoria.getText())+Integer.parseInt(tTurnoArmadura.getText())));
			
			tableviewArmaSeleccionada2.getItems().get(0).setTurno(String.valueOf(Integer.parseInt(tTurnoBase.getText())+Integer.parseInt(tTurnoAgilidad.getText())+
					Integer.parseInt(tTurnoDestreza.getText())+Integer.parseInt(tTurnoCategoria.getText())+Integer.parseInt(tTurnoArmadura.getText())));
			
			tableviewArmaSeleccionada3.getItems().get(0).setTurno(String.valueOf(Integer.parseInt(tTurnoBase.getText())+Integer.parseInt(tTurnoAgilidad.getText())+
					Integer.parseInt(tTurnoDestreza.getText())+Integer.parseInt(tTurnoCategoria.getText())+Integer.parseInt(tTurnoArmadura.getText())));
			
			tableviewArmaSeleccionada4.getItems().get(0).setTurno(String.valueOf(Integer.parseInt(tTurnoBase.getText())+Integer.parseInt(tTurnoAgilidad.getText())+
					Integer.parseInt(tTurnoDestreza.getText())+Integer.parseInt(tTurnoCategoria.getText())+Integer.parseInt(tTurnoArmadura.getText())));
			
		} else if (tableViewCaracteristicas.getSelectionModel().getSelectedItem().getNombreCaracteristica().equals("CON")) {
			caracteristica.setTotalCaracteristica(String.valueOf(Integer.parseInt(caracteristica.getBaseCaracteristica())+Integer.parseInt(caracteristica.getTempCaracteristica())+Integer.parseInt(razaSeleccionada.getBonoConstitucion())));
			caracteristica.setBonoCaracteristica(caracteristica.getTotalCaracteristica());
			valorConstitucion.setConstitucion(caracteristica.getTotalCaracteristica());
			tCansancioBase.setText(String.valueOf(Integer.parseInt(caracteristica.getTotalCaracteristica())));
			tCansancioTotal.setText(String.valueOf(Integer.parseInt(tableViewCaracteristicas.getItems().get(1).getTotalCaracteristica())+Integer.parseInt(tCansancioEspecial.getText())+Integer.valueOf(razaSeleccionada.getBonoCansancio())));
			tPuntosVidaBase.setText(valorConstitucion.getPuntosVidaBase());
			if (tPuntosVidaEspecial.getText().isEmpty()||tPuntosVidaEspecial.getText().equals(null)||null==tPuntosVidaEspecial.getText()||tPuntosVidaEspecial.getText()=="") {
				tPuntosVidaTotales.setText(String.valueOf(Integer.parseInt(valorConstitucion.getPuntosVidaBase())+Integer.parseInt(tPuntosVidaCategoria.getText())+Integer.parseInt("0")));
				
			} else {
				tPuntosVidaTotales.setText(String.valueOf(Integer.parseInt(valorConstitucion.getPuntosVidaBase())+Integer.parseInt(tPuntosVidaCategoria.getText())+Integer.parseInt(tPuntosVidaEspecial.getText())));
				
			}
			
			if (tPuntosRegeneracionEspecial.getText().isEmpty()||tPuntosRegeneracionEspecial.getText().equals(null)||null==tPuntosRegeneracionEspecial.getText()||tPuntosRegeneracionEspecial.getText()==""||tPuntosRegeneracionEspecial.getText()=="0"||
					Integer.parseInt(caracteristica.getTotalCaracteristica())<=0) {
				valorConstitucion.setRegeneracionBase("0");
				valorConstitucion.setRegeneracionBase(String.valueOf(Integer.parseInt(valorConstitucion.getRegeneracionBase())+Integer.parseInt(tPuntosRegeneracionEspecial.getText())+Integer.parseInt(razaSeleccionada.getBonoRegeneracion())));
				tRegeneracion.setText(valorConstitucion.getRegeneracionBase());
				tCuracionDia.setText(valorConstitucion.getCuracionDia());
				tNegativoDia.setText(valorConstitucion.getNegativoDia());
			} else {
				valorConstitucion.setRegeneracionBase(String.valueOf(Integer.parseInt(valorConstitucion.getRegeneracionBase())+Integer.parseInt(tPuntosRegeneracionEspecial.getText())+Integer.parseInt(razaSeleccionada.getBonoRegeneracion())));
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
			caracteristica.setTotalCaracteristica(String.valueOf(Integer.parseInt(caracteristica.getBaseCaracteristica())+Integer.parseInt(caracteristica.getTempCaracteristica())+Integer.parseInt(razaSeleccionada.getBonoFuerza())));
			caracteristica.setBonoCaracteristica(caracteristica.getTotalCaracteristica());
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
			tableViewCombate.getItems().get(3).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tLlevarArmadura.setText(tableViewCombate.getItems().get(3).getTotalHabilidad());
			
			tableViewSecundarias.getItems().get(5).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(5).setBonoNatural(tableViewSecundarias.getItems().get(5).getBonoNatural());
			tableViewSecundarias.getItems().get(5).setHabilidadNatural(tableViewSecundarias.getItems().get(5).getHabilidadNatural());
			tableViewSecundarias.getItems().get(5).setBonoNovel(tableViewSecundarias.getItems().get(5).getBonoNovel());
			tableViewResumenAtleticas.getItems().get(5).setTotalHabilidad(tableViewSecundarias.getItems().get(5).getTotalHabilidad());
			
			tableViewSecundarias.getItems().get(29).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(29).setBonoNatural(tableViewSecundarias.getItems().get(29).getBonoNatural());
			tableViewSecundarias.getItems().get(29).setHabilidadNatural(tableViewSecundarias.getItems().get(29).getHabilidadNatural());
			tableViewSecundarias.getItems().get(29).setBonoNovel(tableViewSecundarias.getItems().get(29).getBonoNovel());
			tableViewResumenVigor.getItems().get(1).setTotalHabilidad(tableViewSecundarias.getItems().get(29).getTotalHabilidad());
			
			tableviewArmaSeleccionada1.getItems().get(0).setBonoFuerza(caracteristica.getBonoCaracteristica());
			tableviewArmaSeleccionada2.getItems().get(0).setBonoFuerza(caracteristica.getBonoCaracteristica());
			tableviewArmaSeleccionada3.getItems().get(0).setBonoFuerza(caracteristica.getBonoCaracteristica());
			tableviewArmaSeleccionada4.getItems().get(0).setBonoFuerza(caracteristica.getBonoCaracteristica());
			
		} else if (tableViewCaracteristicas.getSelectionModel().getSelectedItem().getNombreCaracteristica().equals("DES")) {
			caracteristica.setTotalCaracteristica(String.valueOf(Integer.parseInt(caracteristica.getBaseCaracteristica())+Integer.parseInt(caracteristica.getTempCaracteristica())+Integer.parseInt(razaSeleccionada.getBonoDestreza())));
			caracteristica.setBonoCaracteristica(caracteristica.getTotalCaracteristica());
			AccionesTurno accionesTurno = new AccionesTurno(caracteristica.getTotalCaracteristica(),tableViewCaracteristicas.getItems().get(0).getTotalCaracteristica());
			tTurnoDestreza.setText(caracteristica.getBonoCaracteristica());
			tableViewCombate.getItems().get(0).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewCombate.getItems().get(1).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewCombate.getItems().get(6).setBonoHabilidad(caracteristica.getTotalCaracteristica());
			tTurnoTotal.setText(String.valueOf(Integer.parseInt(tTurnoBase.getText())+Integer.parseInt(tTurnoAgilidad.getText())+
					Integer.parseInt(tTurnoDestreza.getText())+Integer.parseInt(tTurnoCategoria.getText())+Integer.parseInt(tTurnoArmadura.getText())+Integer.parseInt(tTurnoDesarmado.getText())+
					Integer.parseInt(tTurnoEspecial.getText())));
			
			tHabilidadAtaque.setText(tableViewCombate.getItems().get(0).getTotalHabilidad());
			if (Integer.parseInt(tableViewCombate.getItems().get(1).getTotalHabilidad())>Integer.parseInt(tableViewCombate.getItems().get(2).getTotalHabilidad())) {
				tHabilidadDefensa.setText(tableViewCombate.getItems().get(1).getTotalHabilidad());
			} else {
				tHabilidadDefensa.setText(tableViewCombate.getItems().get(2).getTotalHabilidad());
			}
			tLlevarArmadura.setText(tableViewCombate.getItems().get(3).getTotalHabilidad());
			
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
			tableViewMisticas.getItems().get(3).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewPsiquicas.getItems().get(1).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			
			tableViewSecundarias.getItems().get(31).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(31).setBonoNatural(tableViewSecundarias.getItems().get(31).getBonoNatural());
			tableViewSecundarias.getItems().get(31).setHabilidadNatural(tableViewSecundarias.getItems().get(31).getHabilidadNatural());
			tableViewSecundarias.getItems().get(31).setBonoNovel(tableViewSecundarias.getItems().get(31).getBonoNovel());
			tableViewResumenSubterfugio.getItems().get(0).setTotalHabilidad(tableViewSecundarias.getItems().get(31).getTotalHabilidad());
			
			tableViewSecundarias.getItems().get(32).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(32).setBonoNatural(tableViewSecundarias.getItems().get(32).getBonoNatural());
			tableViewSecundarias.getItems().get(32).setHabilidadNatural(tableViewSecundarias.getItems().get(32).getHabilidadNatural());
			tableViewSecundarias.getItems().get(32).setBonoNovel(tableViewSecundarias.getItems().get(32).getBonoNovel());
			tableViewResumenSubterfugio.getItems().get(1).setTotalHabilidad(tableViewSecundarias.getItems().get(32).getTotalHabilidad());

			tableViewSecundarias.getItems().get(34).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(34).setBonoNatural(tableViewSecundarias.getItems().get(34).getBonoNatural());
			tableViewSecundarias.getItems().get(34).setHabilidadNatural(tableViewSecundarias.getItems().get(34).getHabilidadNatural());
			tableViewSecundarias.getItems().get(34).setBonoNovel(tableViewSecundarias.getItems().get(34).getBonoNovel());
			tableViewResumenSubterfugio.getItems().get(3).setTotalHabilidad(tableViewSecundarias.getItems().get(34).getTotalHabilidad());

			tableViewSecundarias.getItems().get(36).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(36).setBonoNatural(tableViewSecundarias.getItems().get(36).getBonoNatural());
			tableViewSecundarias.getItems().get(36).setHabilidadNatural(tableViewSecundarias.getItems().get(36).getHabilidadNatural());
			tableViewSecundarias.getItems().get(36).setBonoNovel(tableViewSecundarias.getItems().get(36).getBonoNovel());
			tableViewResumenSubterfugio.getItems().get(5).setTotalHabilidad(tableViewSecundarias.getItems().get(36).getTotalHabilidad());

			tableViewSecundarias.getItems().get(40).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(40).setBonoNatural(tableViewSecundarias.getItems().get(40).getBonoNatural());
			tableViewSecundarias.getItems().get(40).setHabilidadNatural(tableViewSecundarias.getItems().get(40).getHabilidadNatural());
			tableViewSecundarias.getItems().get(40).setBonoNovel(tableViewSecundarias.getItems().get(40).getBonoNovel());
			tableViewResumenCreativas.getItems().get(2).setTotalHabilidad(tableViewSecundarias.getItems().get(40).getTotalHabilidad());

			tableViewSecundarias.getItems().get(41).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(41).setBonoNatural(tableViewSecundarias.getItems().get(41).getBonoNatural());
			tableViewSecundarias.getItems().get(41).setHabilidadNatural(tableViewSecundarias.getItems().get(41).getHabilidadNatural());
			tableViewSecundarias.getItems().get(41).setBonoNovel(tableViewSecundarias.getItems().get(41).getBonoNovel());
			tableViewResumenCreativas.getItems().get(3).setTotalHabilidad(tableViewSecundarias.getItems().get(41).getTotalHabilidad());

			tableViewSecundarias.getItems().get(45).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(45).setBonoNatural(tableViewSecundarias.getItems().get(45).getBonoNatural());
			tableViewSecundarias.getItems().get(45).setHabilidadNatural(tableViewSecundarias.getItems().get(45).getHabilidadNatural());
			tableViewSecundarias.getItems().get(45).setBonoNovel(tableViewSecundarias.getItems().get(45).getBonoNovel());
			tableViewResumenCreativas.getItems().get(7).setTotalHabilidad(tableViewSecundarias.getItems().get(45).getTotalHabilidad());

			tableViewSecundarias.getItems().get(46).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(46).setBonoNatural(tableViewSecundarias.getItems().get(46).getBonoNatural());
			tableViewSecundarias.getItems().get(46).setHabilidadNatural(tableViewSecundarias.getItems().get(46).getHabilidadNatural());
			tableViewSecundarias.getItems().get(46).setBonoNovel(tableViewSecundarias.getItems().get(46).getBonoNovel());
			tableViewResumenCreativas.getItems().get(8).setTotalHabilidad(tableViewSecundarias.getItems().get(46).getTotalHabilidad());

			tableViewSecundarias.getItems().get(47).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(47).setBonoNatural(tableViewSecundarias.getItems().get(47).getBonoNatural());
			tableViewSecundarias.getItems().get(47).setHabilidadNatural(tableViewSecundarias.getItems().get(47).getHabilidadNatural());
			tableViewSecundarias.getItems().get(47).setBonoNovel(tableViewSecundarias.getItems().get(47).getBonoNovel());
			tableViewResumenCreativas.getItems().get(9).setTotalHabilidad(tableViewSecundarias.getItems().get(47).getTotalHabilidad());

			tableViewSecundarias.getItems().get(48).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(48).setBonoNatural(tableViewSecundarias.getItems().get(48).getBonoNatural());
			tableViewSecundarias.getItems().get(48).setHabilidadNatural(tableViewSecundarias.getItems().get(48).getHabilidadNatural());
			tableViewSecundarias.getItems().get(48).setBonoNovel(tableViewSecundarias.getItems().get(48).getBonoNovel());
			tableViewResumenCreativas.getItems().get(10).setTotalHabilidad(tableViewSecundarias.getItems().get(48).getTotalHabilidad());
			
		
			
			tableviewArmaSeleccionada1.getItems().get(0).setAtaque(tableViewCombate.getItems().get(0).getTotalHabilidad());
			tableviewArmaSeleccionada2.getItems().get(0).setAtaque(tableViewCombate.getItems().get(0).getTotalHabilidad());
			tableviewArmaSeleccionada3.getItems().get(0).setAtaque(tableViewCombate.getItems().get(0).getTotalHabilidad());
			tableviewArmaSeleccionada4.getItems().get(0).setAtaque(tableViewCombate.getItems().get(0).getTotalHabilidad());
			
		} else if (tableViewCaracteristicas.getSelectionModel().getSelectedItem().getNombreCaracteristica().equals("INT")) {
			caracteristica.setTotalCaracteristica(String.valueOf(Integer.parseInt(caracteristica.getBaseCaracteristica())+Integer.parseInt(caracteristica.getTempCaracteristica())+Integer.parseInt(razaSeleccionada.getBonoInteligencia())));
			caracteristica.setBonoCaracteristica(caracteristica.getTotalCaracteristica());
			tableViewSecundarias.getItems().get(9).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(9).setBonoNatural(tableViewSecundarias.getItems().get(9).getBonoNatural());
			tableViewSecundarias.getItems().get(9).setHabilidadNatural(tableViewSecundarias.getItems().get(9).getHabilidadNatural());
			tableViewSecundarias.getItems().get(9).setBonoNovel(tableViewSecundarias.getItems().get(9).getBonoNovel());
			tableViewResumenSociales.getItems().get(3).setTotalHabilidad(tableViewSecundarias.getItems().get(9).getTotalHabilidad());
			
			tableViewSecundarias.getItems().get(10).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(10).setBonoNatural(tableViewSecundarias.getItems().get(10).getBonoNatural());
			tableViewSecundarias.getItems().get(10).setHabilidadNatural(tableViewSecundarias.getItems().get(10).getHabilidadNatural());
			tableViewSecundarias.getItems().get(10).setBonoNovel(tableViewSecundarias.getItems().get(10).getBonoNovel());
			tableViewResumenSociales.getItems().get(4).setTotalHabilidad(tableViewSecundarias.getItems().get(10).getTotalHabilidad());
			
			tableViewSecundarias.getItems().get(11).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(11).setBonoNatural(tableViewSecundarias.getItems().get(11).getBonoNatural());
			tableViewSecundarias.getItems().get(11).setHabilidadNatural(tableViewSecundarias.getItems().get(11).getHabilidadNatural());
			tableViewSecundarias.getItems().get(11).setBonoNovel(tableViewSecundarias.getItems().get(11).getBonoNovel());
			tableViewResumenSociales.getItems().get(5).setTotalHabilidad(tableViewSecundarias.getItems().get(11).getTotalHabilidad());
			
			tableViewSecundarias.getItems().get(12).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(12).setBonoNatural(tableViewSecundarias.getItems().get(12).getBonoNatural());
			tableViewSecundarias.getItems().get(12).setHabilidadNatural(tableViewSecundarias.getItems().get(12).getHabilidadNatural());
			tableViewSecundarias.getItems().get(12).setBonoNovel(tableViewSecundarias.getItems().get(12).getBonoNovel());
			tableViewResumenSociales.getItems().get(6).setTotalHabilidad(tableViewSecundarias.getItems().get(12).getTotalHabilidad());
			
			tableViewSecundarias.getItems().get(16).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(16).setBonoNatural(tableViewSecundarias.getItems().get(16).getBonoNatural());
			tableViewSecundarias.getItems().get(16).setHabilidadNatural(tableViewSecundarias.getItems().get(16).getHabilidadNatural());
			tableViewSecundarias.getItems().get(16).setBonoNovel(tableViewSecundarias.getItems().get(16).getBonoNovel());
			tableViewResumenIntelectuales.getItems().get(0).setTotalHabilidad(tableViewSecundarias.getItems().get(16).getTotalHabilidad());
			
			tableViewSecundarias.getItems().get(17).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(17).setBonoNatural(tableViewSecundarias.getItems().get(17).getBonoNatural());
			tableViewSecundarias.getItems().get(17).setHabilidadNatural(tableViewSecundarias.getItems().get(17).getHabilidadNatural());
			tableViewSecundarias.getItems().get(17).setBonoNovel(tableViewSecundarias.getItems().get(17).getBonoNovel());
			tableViewResumenIntelectuales.getItems().get(1).setTotalHabilidad(tableViewSecundarias.getItems().get(17).getTotalHabilidad());
			
			tableViewSecundarias.getItems().get(18).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(18).setBonoNatural(tableViewSecundarias.getItems().get(18).getBonoNatural());
			tableViewSecundarias.getItems().get(18).setHabilidadNatural(tableViewSecundarias.getItems().get(18).getHabilidadNatural());
			tableViewSecundarias.getItems().get(18).setBonoNovel(tableViewSecundarias.getItems().get(18).getBonoNovel());
			tableViewResumenIntelectuales.getItems().get(2).setTotalHabilidad(tableViewSecundarias.getItems().get(18).getTotalHabilidad());
			
			tableViewSecundarias.getItems().get(19).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(19).setBonoNatural(tableViewSecundarias.getItems().get(19).getBonoNatural());
			tableViewSecundarias.getItems().get(19).setHabilidadNatural(tableViewSecundarias.getItems().get(19).getHabilidadNatural());
			tableViewSecundarias.getItems().get(19).setBonoNovel(tableViewSecundarias.getItems().get(19).getBonoNovel());
			tableViewResumenIntelectuales.getItems().get(3).setTotalHabilidad(tableViewSecundarias.getItems().get(19).getTotalHabilidad());
			
			tableViewSecundarias.getItems().get(20).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(20).setBonoNatural(tableViewSecundarias.getItems().get(20).getBonoNatural());
			tableViewSecundarias.getItems().get(20).setHabilidadNatural(tableViewSecundarias.getItems().get(20).getHabilidadNatural());
			tableViewSecundarias.getItems().get(20).setBonoNovel(tableViewSecundarias.getItems().get(20).getBonoNovel());
			tableViewResumenIntelectuales.getItems().get(4).setTotalHabilidad(tableViewSecundarias.getItems().get(20).getTotalHabilidad());
			
			tableViewSecundarias.getItems().get(21).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(21).setBonoNatural(tableViewSecundarias.getItems().get(21).getBonoNatural());
			tableViewSecundarias.getItems().get(21).setHabilidadNatural(tableViewSecundarias.getItems().get(21).getHabilidadNatural());
			tableViewSecundarias.getItems().get(21).setBonoNovel(tableViewSecundarias.getItems().get(21).getBonoNovel());
			tableViewResumenIntelectuales.getItems().get(5).setTotalHabilidad(tableViewSecundarias.getItems().get(21).getTotalHabilidad());
			
			tableViewSecundarias.getItems().get(22).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(22).setBonoNatural(tableViewSecundarias.getItems().get(22).getBonoNatural());
			tableViewSecundarias.getItems().get(22).setHabilidadNatural(tableViewSecundarias.getItems().get(22).getHabilidadNatural());
			tableViewSecundarias.getItems().get(22).setBonoNovel(tableViewSecundarias.getItems().get(22).getBonoNovel());
			tableViewResumenIntelectuales.getItems().get(6).setTotalHabilidad(tableViewSecundarias.getItems().get(22).getTotalHabilidad());
			
			tableViewSecundarias.getItems().get(23).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(23).setBonoNatural(tableViewSecundarias.getItems().get(23).getBonoNatural());
			tableViewSecundarias.getItems().get(23).setHabilidadNatural(tableViewSecundarias.getItems().get(23).getHabilidadNatural());
			tableViewSecundarias.getItems().get(23).setBonoNovel(tableViewSecundarias.getItems().get(23).getBonoNovel());
			tableViewResumenIntelectuales.getItems().get(7).setTotalHabilidad(tableViewSecundarias.getItems().get(23).getTotalHabilidad());

			tableViewSecundarias.getItems().get(24).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(24).setBonoNatural(tableViewSecundarias.getItems().get(24).getBonoNatural());
			tableViewSecundarias.getItems().get(24).setHabilidadNatural(tableViewSecundarias.getItems().get(24).getHabilidadNatural());
			tableViewSecundarias.getItems().get(24).setBonoNovel(tableViewSecundarias.getItems().get(24).getBonoNovel());
			tableViewResumenIntelectuales.getItems().get(8).setTotalHabilidad(tableViewSecundarias.getItems().get(24).getTotalHabilidad());
			
			tableViewSecundarias.getItems().get(25).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(25).setBonoNatural(tableViewSecundarias.getItems().get(25).getBonoNatural());
			tableViewSecundarias.getItems().get(25).setHabilidadNatural(tableViewSecundarias.getItems().get(25).getHabilidadNatural());
			tableViewSecundarias.getItems().get(25).setBonoNovel(tableViewSecundarias.getItems().get(25).getBonoNovel());
			tableViewResumenIntelectuales.getItems().get(9).setTotalHabilidad(tableViewSecundarias.getItems().get(25).getTotalHabilidad());
			
			tableViewSecundarias.getItems().get(26).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(26).setBonoNatural(tableViewSecundarias.getItems().get(26).getBonoNatural());
			tableViewSecundarias.getItems().get(26).setHabilidadNatural(tableViewSecundarias.getItems().get(26).getHabilidadNatural());
			tableViewSecundarias.getItems().get(26).setBonoNovel(tableViewSecundarias.getItems().get(26).getBonoNovel());
			tableViewResumenIntelectuales.getItems().get(10).setTotalHabilidad(tableViewSecundarias.getItems().get(26).getTotalHabilidad());
			
			tableViewSecundarias.getItems().get(27).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(27).setBonoNatural(tableViewSecundarias.getItems().get(27).getBonoNatural());
			tableViewSecundarias.getItems().get(27).setHabilidadNatural(tableViewSecundarias.getItems().get(27).getHabilidadNatural());
			tableViewSecundarias.getItems().get(27).setBonoNovel(tableViewSecundarias.getItems().get(27).getBonoNovel());
			tableViewResumenIntelectuales.getItems().get(7).setTotalHabilidad(tableViewSecundarias.getItems().get(27).getTotalHabilidad());

			tableViewSecundarias.getItems().get(37).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(37).setBonoNatural(tableViewSecundarias.getItems().get(37).getBonoNatural());
			tableViewSecundarias.getItems().get(37).setHabilidadNatural(tableViewSecundarias.getItems().get(37).getHabilidadNatural());
			tableViewSecundarias.getItems().get(37).setBonoNovel(tableViewSecundarias.getItems().get(37).getBonoNovel());
			tableViewResumenSubterfugio.getItems().get(6).setTotalHabilidad(tableViewSecundarias.getItems().get(37).getTotalHabilidad());

			tableViewSecundarias.getItems().get(42).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(42).setBonoNatural(tableViewSecundarias.getItems().get(42).getBonoNatural());
			tableViewSecundarias.getItems().get(42).setHabilidadNatural(tableViewSecundarias.getItems().get(42).getHabilidadNatural());
			tableViewSecundarias.getItems().get(42).setBonoNovel(tableViewSecundarias.getItems().get(42).getBonoNovel());
			tableViewResumenCreativas.getItems().get(4).setTotalHabilidad(tableViewSecundarias.getItems().get(42).getTotalHabilidad());
			
		} else if (tableViewCaracteristicas.getSelectionModel().getSelectedItem().getNombreCaracteristica().equals("PER")) {
			caracteristica.setTotalCaracteristica(String.valueOf(Integer.parseInt(caracteristica.getBaseCaracteristica())+Integer.parseInt(caracteristica.getTempCaracteristica())+Integer.parseInt(razaSeleccionada.getBonoPercepcion())));
			caracteristica.setBonoCaracteristica(caracteristica.getTotalCaracteristica());
			tableViewSecundarias.getItems().get(13).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(13).setBonoNatural(tableViewSecundarias.getItems().get(13).getBonoNatural());
			tableViewSecundarias.getItems().get(13).setHabilidadNatural(tableViewSecundarias.getItems().get(13).getHabilidadNatural());
			tableViewSecundarias.getItems().get(13).setBonoNovel(tableViewSecundarias.getItems().get(13).getBonoNovel());
			tableViewResumenPerceptivas.getItems().get(0).setTotalHabilidad(tableViewSecundarias.getItems().get(13).getTotalHabilidad());
			
			tableViewSecundarias.getItems().get(14).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(14).setBonoNatural(tableViewSecundarias.getItems().get(14).getBonoNatural());
			tableViewSecundarias.getItems().get(14).setHabilidadNatural(tableViewSecundarias.getItems().get(14).getHabilidadNatural());
			tableViewSecundarias.getItems().get(14).setBonoNovel(tableViewSecundarias.getItems().get(14).getBonoNovel());
			tableViewResumenPerceptivas.getItems().get(1).setTotalHabilidad(tableViewSecundarias.getItems().get(14).getTotalHabilidad());
			
			tableViewSecundarias.getItems().get(15).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(15).setBonoNatural(tableViewSecundarias.getItems().get(15).getBonoNatural());
			tableViewSecundarias.getItems().get(15).setHabilidadNatural(tableViewSecundarias.getItems().get(15).getHabilidadNatural());
			tableViewSecundarias.getItems().get(15).setBonoNovel(tableViewSecundarias.getItems().get(15).getBonoNovel());
			tableViewResumenPerceptivas.getItems().get(2).setTotalHabilidad(tableViewSecundarias.getItems().get(15).getTotalHabilidad());
			
			tableViewSecundarias.getItems().get(33).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(33).setBonoNatural(tableViewSecundarias.getItems().get(33).getBonoNatural());
			tableViewSecundarias.getItems().get(33).setHabilidadNatural(tableViewSecundarias.getItems().get(33).getHabilidadNatural());
			tableViewSecundarias.getItems().get(33).setBonoNovel(tableViewSecundarias.getItems().get(33).getBonoNovel());
			tableViewResumenSubterfugio.getItems().get(2).setTotalHabilidad(tableViewSecundarias.getItems().get(33).getTotalHabilidad());
			
		} else if (tableViewCaracteristicas.getSelectionModel().getSelectedItem().getNombreCaracteristica().equals("POD")) {
			caracteristica.setTotalCaracteristica(String.valueOf(Integer.parseInt(caracteristica.getBaseCaracteristica())+Integer.parseInt(caracteristica.getTempCaracteristica())+Integer.parseInt(razaSeleccionada.getBonoPoder())));
			caracteristica.setBonoCaracteristica(caracteristica.getTotalCaracteristica());
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
			tableViewSecundarias.getItems().get(6).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(6).setBonoNatural(tableViewSecundarias.getItems().get(6).getBonoNatural());
			tableViewSecundarias.getItems().get(6).setHabilidadNatural(tableViewSecundarias.getItems().get(6).getHabilidadNatural());
			tableViewSecundarias.getItems().get(6).setBonoNovel(tableViewSecundarias.getItems().get(6).getBonoNovel());
			tableViewResumenSociales.getItems().get(0).setTotalHabilidad(tableViewSecundarias.getItems().get(6).getTotalHabilidad());
			
			tableViewSecundarias.getItems().get(8).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(8).setBonoNatural(tableViewSecundarias.getItems().get(8).getBonoNatural());
			tableViewSecundarias.getItems().get(8).setHabilidadNatural(tableViewSecundarias.getItems().get(8).getHabilidadNatural());
			tableViewSecundarias.getItems().get(8).setBonoNovel(tableViewSecundarias.getItems().get(8).getBonoNovel());
			tableViewResumenSociales.getItems().get(2).setTotalHabilidad(tableViewSecundarias.getItems().get(8).getTotalHabilidad());
			
			tableViewSecundarias.getItems().get(27).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(27).setBonoNatural(tableViewSecundarias.getItems().get(27).getBonoNatural());
			tableViewSecundarias.getItems().get(27).setHabilidadNatural(tableViewSecundarias.getItems().get(27).getHabilidadNatural());
			tableViewSecundarias.getItems().get(27).setBonoNovel(tableViewSecundarias.getItems().get(27).getBonoNovel());
			tableViewResumenIntelectuales.getItems().get(11).setTotalHabilidad(tableViewSecundarias.getItems().get(27).getTotalHabilidad());
			
			tableViewSecundarias.getItems().get(38).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(38).setBonoNatural(tableViewSecundarias.getItems().get(38).getBonoNatural());
			tableViewSecundarias.getItems().get(38).setHabilidadNatural(tableViewSecundarias.getItems().get(38).getHabilidadNatural());
			tableViewSecundarias.getItems().get(38).setBonoNovel(tableViewSecundarias.getItems().get(38).getBonoNovel());
			tableViewResumenCreativas.getItems().get(0).setTotalHabilidad(tableViewSecundarias.getItems().get(38).getTotalHabilidad());
			
			tableViewSecundarias.getItems().get(43).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(43).setBonoNatural(tableViewSecundarias.getItems().get(43).getBonoNatural());
			tableViewSecundarias.getItems().get(43).setHabilidadNatural(tableViewSecundarias.getItems().get(43).getHabilidadNatural());
			tableViewSecundarias.getItems().get(43).setBonoNovel(tableViewSecundarias.getItems().get(43).getBonoNovel());
			tableViewResumenCreativas.getItems().get(5).setTotalHabilidad(tableViewSecundarias.getItems().get(43).getTotalHabilidad());
			
			tableViewSecundarias.getItems().get(44).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(44).setBonoNatural(tableViewSecundarias.getItems().get(44).getBonoNatural());
			tableViewSecundarias.getItems().get(44).setHabilidadNatural(tableViewSecundarias.getItems().get(44).getHabilidadNatural());
			tableViewSecundarias.getItems().get(44).setBonoNovel(tableViewSecundarias.getItems().get(44).getBonoNovel());
			tableViewResumenCreativas.getItems().get(6).setTotalHabilidad(tableViewSecundarias.getItems().get(44).getTotalHabilidad());
			
			tableViewMisticas.getItems().get(0).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewMisticas.getItems().get(1).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewMisticas.getItems().get(5).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewMisticas.getItems().get(7).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewMisticas.getItems().get(8).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			
		} else if (tableViewCaracteristicas.getSelectionModel().getSelectedItem().getNombreCaracteristica().equals("VOL")) {
			caracteristica.setTotalCaracteristica(String.valueOf(Integer.parseInt(caracteristica.getBaseCaracteristica())+Integer.parseInt(caracteristica.getTempCaracteristica())+Integer.parseInt(razaSeleccionada.getBonoVoluntad())));
			caracteristica.setBonoCaracteristica(caracteristica.getTotalCaracteristica());
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
			tableViewMisticas.getItems().get(6).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			
			tableViewSecundarias.getItems().get(7).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(7).setBonoNatural(tableViewSecundarias.getItems().get(7).getBonoNatural());
			tableViewSecundarias.getItems().get(7).setHabilidadNatural(tableViewSecundarias.getItems().get(7).getHabilidadNatural());
			tableViewSecundarias.getItems().get(7).setBonoNovel(tableViewSecundarias.getItems().get(7).getBonoNovel());
			tableViewResumenSociales.getItems().get(1).setTotalHabilidad(tableViewSecundarias.getItems().get(7).getTotalHabilidad());
			
			tableViewSecundarias.getItems().get(28).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(28).setBonoNatural(tableViewSecundarias.getItems().get(28).getBonoNatural());
			tableViewSecundarias.getItems().get(28).setHabilidadNatural(tableViewSecundarias.getItems().get(28).getHabilidadNatural());
			tableViewSecundarias.getItems().get(28).setBonoNovel(tableViewSecundarias.getItems().get(28).getBonoNovel());
			tableViewResumenVigor.getItems().get(0).setTotalHabilidad(tableViewSecundarias.getItems().get(28).getTotalHabilidad());

			tableViewSecundarias.getItems().get(30).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewSecundarias.getItems().get(30).setBonoNatural(tableViewSecundarias.getItems().get(30).getBonoNatural());
			tableViewSecundarias.getItems().get(30).setHabilidadNatural(tableViewSecundarias.getItems().get(30).getHabilidadNatural());
			tableViewSecundarias.getItems().get(30).setBonoNovel(tableViewSecundarias.getItems().get(30).getBonoNovel());
			tableViewResumenVigor.getItems().get(2).setTotalHabilidad(tableViewSecundarias.getItems().get(30).getTotalHabilidad());
			
		}
		tableViewCaracteristicas.refresh();
		tableViewResistencias.refresh();
		tableViewCombate.refresh();
		tableViewMisticas.refresh();
		tableViewPsiquicas.refresh();
		tableViewSecundarias.refresh();
		tableViewResumenAtleticas.refresh();
		tableViewResumenSociales.refresh();
		tableViewResumenPerceptivas.refresh();
		tableViewResumenIntelectuales.refresh();
		tableViewResumenVigor.refresh();
		tableViewResumenSubterfugio.refresh();
		tableViewResumenCreativas.refresh();
		tableviewArmaSeleccionada1.refresh();
		tableviewArmaSeleccionada2.refresh();
		tableviewArmaSeleccionada3.refresh();
		tableviewArmaSeleccionada4.refresh();
	}
	
	
	public void cambiarPdsCombate(PdsCombate pds) {
		if (tableViewCombate.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("H.Ataque")) {
			tHabilidadAtaque.setText(pds.getTotalHabilidad());
			
			tableviewArmaSeleccionada1.getItems().get(0).setAtaque(pds.getTotalHabilidad());
			tableviewArmaSeleccionada2.getItems().get(0).setAtaque(pds.getTotalHabilidad());
			tableviewArmaSeleccionada3.getItems().get(0).setAtaque(pds.getTotalHabilidad());
			tableviewArmaSeleccionada4.getItems().get(0).setAtaque(pds.getTotalHabilidad());
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
		tableviewArmaSeleccionada1.refresh();
		tableviewArmaSeleccionada2.refresh();
		tableviewArmaSeleccionada3.refresh();
		tableviewArmaSeleccionada4.refresh();
	}
	
	public void cambiarArmaSeleccionada(ActionEvent ev) {
		String nombreArmaSeleccioanda = (String) ((ComboBox<?>)ev.getSource()).getSelectionModel().getSelectedItem();
		if (((ComboBox<?>)ev.getSource()).getId().equals("cBoxNombreArma1")) {
			tableviewArmaSeleccionada1.getItems().get(0).setArmaSeleccionada(ch.obtenerArma(sessionFactory, nombreArmaSeleccioanda), 
					tableViewCombate.getItems().get(0).getTotalHabilidad(), 
					tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica());
			tTipoArma1.setText(tableviewArmaSeleccionada1.getItems().get(0).getTipoArma());
			tableviewArmaSeleccionada1.refresh();
		} else if (((ComboBox<?>)ev.getSource()).getId().equals("cBoxNombreArma2")) {
			tableviewArmaSeleccionada2.getItems().get(0).setArmaSeleccionada(ch.obtenerArma(sessionFactory, nombreArmaSeleccioanda), 
					tableViewCombate.getItems().get(0).getTotalHabilidad(), 
					tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica());
			tTipoArma2.setText(tableviewArmaSeleccionada2.getItems().get(0).getTipoArma());
			tableviewArmaSeleccionada2.refresh();
		} else if (((ComboBox<?>)ev.getSource()).getId().equals("cBoxNombreArma3")) {
			tableviewArmaSeleccionada3.getItems().get(0).setArmaSeleccionada(ch.obtenerArma(sessionFactory, nombreArmaSeleccioanda), 
					tableViewCombate.getItems().get(0).getTotalHabilidad(), 
					tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica());
			tTipoArma3.setText(tableviewArmaSeleccionada3.getItems().get(0).getTipoArma());
			tableviewArmaSeleccionada3.refresh();
		} else if (((ComboBox<?>)ev.getSource()).getId().equals("cBoxNombreArma4")) {
			tableviewArmaSeleccionada4.getItems().get(0).setArmaSeleccionada(ch.obtenerArma(sessionFactory, nombreArmaSeleccioanda), 
					tableViewCombate.getItems().get(0).getTotalHabilidad(), 
					tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica());
			tTipoArma4.setText(tableviewArmaSeleccionada4.getItems().get(0).getTipoArma());
			tableviewArmaSeleccionada4.refresh();
		}
		
	}
	
	public void obtenerTotalHabilidades(PdsHabilidadesSecundarias pds) {
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
			
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Estilo")) {
			tableViewResumenSociales.getItems().get(0).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Intimidar")) {
			tableViewResumenSociales.getItems().get(1).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Liderazgo")) {
			tableViewResumenSociales.getItems().get(2).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Persuasion")) {
			tableViewResumenSociales.getItems().get(3).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Comercio")) {
			tableViewResumenSociales.getItems().get(4).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Callejeo")) {
			tableViewResumenSociales.getItems().get(5).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Etiqueta")) {
			tableViewResumenSociales.getItems().get(6).setTotalHabilidad(pds.getTotalHabilidad());
		
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Advertir")) {
			tableViewResumenPerceptivas.getItems().get(0).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Buscar")) {
			tableViewResumenSociales.getItems().get(1).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Rastrear")) {
			tableViewResumenSociales.getItems().get(2).setTotalHabilidad(pds.getTotalHabilidad());
			
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Animales")) {
			tableViewResumenIntelectuales.getItems().get(0).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Ciencia")) {
			tableViewResumenIntelectuales.getItems().get(1).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Ley")) {
			tableViewResumenIntelectuales.getItems().get(2).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Herbolaria")) {
			tableViewResumenIntelectuales.getItems().get(3).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Historia")) {
			tableViewResumenIntelectuales.getItems().get(4).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Tactica")) {
			tableViewResumenIntelectuales.getItems().get(5).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Medicina")) {
			tableViewResumenIntelectuales.getItems().get(6).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Memorizar")) {
			tableViewResumenIntelectuales.getItems().get(7).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Navegacion")) {
			tableViewResumenIntelectuales.getItems().get(8).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Ocultismo")) {
			tableViewResumenIntelectuales.getItems().get(9).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Tasacion")) {
			tableViewResumenIntelectuales.getItems().get(10).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("V.Magica")) {
			tableViewResumenIntelectuales.getItems().get(11).setTotalHabilidad(pds.getTotalHabilidad());
		}
		
		else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Frialdad")) {
			tableViewResumenVigor.getItems().get(0).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("P.Fuerza")) {
			tableViewResumenVigor.getItems().get(1).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Res.Dolor")) {
			tableViewResumenVigor.getItems().get(2).setTotalHabilidad(pds.getTotalHabilidad());
		}
		
		else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Cerrajeria")) {
			tableViewResumenSubterfugio.getItems().get(0).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Disfraz")) {
			tableViewResumenSubterfugio.getItems().get(1).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Ocultarse")) {
			tableViewResumenSubterfugio.getItems().get(2).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Robo")) {
			tableViewResumenSubterfugio.getItems().get(3).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Sigio")) {
			tableViewResumenSubterfugio.getItems().get(4).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Tramperia")) {
			tableViewResumenSubterfugio.getItems().get(5).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Venenos")) {
			tableViewResumenSubterfugio.getItems().get(6).setTotalHabilidad(pds.getTotalHabilidad());
		}
		
		else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Arte")) {
			tableViewResumenSubterfugio.getItems().get(0).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Baile")) {
			tableViewResumenSubterfugio.getItems().get(1).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Forja")) {
			tableViewResumenSubterfugio.getItems().get(2).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Runas")) {
			tableViewResumenSubterfugio.getItems().get(3).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Alquimia")) {
			tableViewResumenSubterfugio.getItems().get(4).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Animismo")) {
			tableViewResumenSubterfugio.getItems().get(5).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Musica")) {
			tableViewResumenSubterfugio.getItems().get(6).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("T.Manos")) {
			tableViewResumenSubterfugio.getItems().get(1).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Caligrafia Ritual")) {
			tableViewResumenSubterfugio.getItems().get(2).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Orfebreria")) {
			tableViewResumenSubterfugio.getItems().get(3).setTotalHabilidad(pds.getTotalHabilidad());
		} else if (tableViewSecundarias.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Confeccion")) {
			tableViewResumenSubterfugio.getItems().get(4).setTotalHabilidad(pds.getTotalHabilidad());
		}
		tableViewCaracteristicas.refresh();
		tableViewResistencias.refresh();
		tableViewCombate.refresh();
		tableViewMisticas.refresh();
		tableViewPsiquicas.refresh();
		tableViewSecundarias.refresh();
		tableViewResumenAtleticas.refresh();
		tableViewResumenSociales.refresh();
		tableViewResumenPerceptivas.refresh();
		tableViewResumenIntelectuales.refresh();
		tableViewResumenVigor.refresh();
		tableViewResumenSubterfugio.refresh();
		tableViewResumenCreativas.refresh();
	}
	
	public void cambiarValorNivel (KeyEvent ev) {
		nivelClase.setNivel(tNivelTotal.getText());
		tHabilidadesNaturales.setText(nivelClase.getHabilidadNatural());
		tBonosNaturales.setText(nivelClase.getBonoNatural());
		tBonosNovel.setText(nivelClase.getBonoNovel());
		tPdsRestantes.setText(nivelClase.getPds());
		
		for (int i = 0; i < tableViewResistencias.getItems().size(); i++) {
			tableViewResistencias.getItems().get(i).setNivel(tNivelTotal.getText());
		}
		tableViewResistencias.refresh();
		
	}
	
	public void cambiarValorCansancio(KeyEvent ev){
		
		if (obtenerTecla(ev)) {
			if (tCansancioEspecial.getText().isEmpty()||tCansancioEspecial.getText().equals(null)||null==tCansancioEspecial.getText()||tCansancioEspecial.getText()==""
					||tCansancioEspecial.getText()=="0") {
				tCansancioEspecial.setText("0");
				tCansancioTotal.setText(String.valueOf(Integer.parseInt(tableViewCaracteristicas.getItems().get(1).getTotalCaracteristica())+Integer.parseInt("0"))+Integer.valueOf(razaSeleccionada.getBonoCansancio()));
			}
			else {
				tCansancioTotal.setText(String.valueOf(Integer.parseInt(tableViewCaracteristicas.getItems().get(1).getTotalCaracteristica())+Integer.parseInt(tCansancioEspecial.getText())+Integer.valueOf(razaSeleccionada.getBonoCansancio())));
			}
				
		} else {
			tCansancioEspecial.setText("0");
			Alert alerta = new Alert(Alert.AlertType.WARNING);
			alerta.setHeaderText(null);
			   alerta.setTitle("Info");
			   alerta.setContentText("No se pueden escribir caracteres diferentes a un numero");
			   alerta.showAndWait();
		}
	}
	
	public void cambiarValorVidaEspecial(KeyEvent ev){
		
		if (obtenerTecla(ev)) {
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
		
		if (obtenerTecla(ev)) {
			if (tPuntosRegeneracionEspecial.getText().isEmpty()||tPuntosRegeneracionEspecial.getText().equals(null)||null==tPuntosRegeneracionEspecial.getText()||tPuntosRegeneracionEspecial.getText()==""
					||tPuntosRegeneracionEspecial.getText()=="0") {
				tPuntosRegeneracionEspecial.setText("0");
				valorConstitucion.setRegeneracionBase(String.valueOf(Integer.parseInt(valorConstitucion.getRegeneracionBase())+Integer.parseInt("0")+Integer.parseInt(razaSeleccionada.getBonoRegeneracion())));
				tRegeneracion.setText(valorConstitucion.getRegeneracionBase());
				tCuracionDia.setText(valorConstitucion.getCuracionDia());
				tNegativoDia.setText(valorConstitucion.getNegativoDia());
			} else {
				valorConstitucion.setConstitucion(String.valueOf(Integer.parseInt(String.valueOf(tableViewCaracteristicas.getItems().get(1).getTotalCaracteristica()))/*+Integer.parseInt(tPuntosRegeneracionEspecial.getText())*/));
				valorConstitucion.setRegeneracionBase(String.valueOf(Integer.parseInt(valorConstitucion.getRegeneracionBase())+Integer.parseInt(tPuntosRegeneracionEspecial.getText())+Integer.parseInt(razaSeleccionada.getBonoRegeneracion())));
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
	
	public void valorTextFieldTurnoTotal() {
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
		tTurnoCategoria.setText(String.valueOf(categoriaSeleccionada.getTurno()));
		tTurnoTotal.setText(String.valueOf(Integer.parseInt(tTurnoBase.getText())+Integer.parseInt(tTurnoAgilidad.getText())+Integer.parseInt(tTurnoDestreza.getText())+
				Integer.parseInt(tTurnoCategoria.getText()) +Integer.parseInt(tTurnoArmadura.getText()) +Integer.parseInt(tTurnoDesarmado.getText()) +Integer.parseInt(tTurnoEspecial.getText())));
		
	}
	
	public void cambiarValorTurnoEspecial(KeyEvent ev){
		if (obtenerTecla(ev)) {
			if (tTurnoEspecial.getText().isEmpty()||tTurnoEspecial.getText().equals(null)||null==tTurnoEspecial.getText()||tTurnoEspecial.getText()==""
					||tTurnoEspecial.getText()=="0") {
				tTurnoEspecial.setText("0");
				tTurnoTotal.setText(String.valueOf(Integer.parseInt(tTurnoBase.getText())+Integer.parseInt(tTurnoAgilidad.getText())+
						Integer.parseInt(tTurnoDestreza.getText())+Integer.parseInt(tTurnoCategoria.getText())+Integer.parseInt(tTurnoArmadura.getText())+Integer.parseInt(tTurnoDesarmado.getText())+
						Integer.parseInt(tTurnoEspecial.getText())));
				
			} else {
				tTurnoTotal.setText(String.valueOf(Integer.parseInt(tTurnoBase.getText())+Integer.parseInt(tTurnoAgilidad.getText())+
						Integer.parseInt(tTurnoDestreza.getText())+Integer.parseInt(tTurnoCategoria.getText())+Integer.parseInt(tTurnoArmadura.getText())+Integer.parseInt(tTurnoDesarmado.getText())+
						Integer.parseInt(tTurnoEspecial.getText())));
				
			}
			tableviewArmaSeleccionada1.getItems().get(0).setTurno(String.valueOf(Integer.parseInt(tTurnoBase.getText())+Integer.parseInt(tTurnoAgilidad.getText())+
					Integer.parseInt(tTurnoDestreza.getText())+Integer.parseInt(tTurnoCategoria.getText())+Integer.parseInt(tTurnoArmadura.getText())+
					Integer.parseInt(tTurnoEspecial.getText())));
			
			tableviewArmaSeleccionada2.getItems().get(0).setTurno(String.valueOf(Integer.parseInt(tTurnoBase.getText())+Integer.parseInt(tTurnoAgilidad.getText())+
					Integer.parseInt(tTurnoDestreza.getText())+Integer.parseInt(tTurnoCategoria.getText())+Integer.parseInt(tTurnoArmadura.getText())+
					Integer.parseInt(tTurnoEspecial.getText())));
			
			tableviewArmaSeleccionada3.getItems().get(0).setTurno(String.valueOf(Integer.parseInt(tTurnoBase.getText())+Integer.parseInt(tTurnoAgilidad.getText())+
					Integer.parseInt(tTurnoDestreza.getText())+Integer.parseInt(tTurnoCategoria.getText())+Integer.parseInt(tTurnoArmadura.getText())+
					Integer.parseInt(tTurnoEspecial.getText())));
			
			tableviewArmaSeleccionada4.getItems().get(0).setTurno(String.valueOf(Integer.parseInt(tTurnoBase.getText())+Integer.parseInt(tTurnoAgilidad.getText())+
					Integer.parseInt(tTurnoDestreza.getText())+Integer.parseInt(tTurnoCategoria.getText())+Integer.parseInt(tTurnoArmadura.getText())+
					Integer.parseInt(tTurnoEspecial.getText())));
				
		} else {
			Alert alerta = new Alert(Alert.AlertType.WARNING);
			alerta.setHeaderText(null);
			   alerta.setTitle("Info");
			   alerta.setContentText("No se pueden escribir caracteres diferentes a un numero");
			   alerta.showAndWait();
		}
		tableviewArmaSeleccionada1.refresh();
		tableviewArmaSeleccionada2.refresh();
		tableviewArmaSeleccionada3.refresh();
		tableviewArmaSeleccionada4.refresh();
	}
	
	public boolean obtenerTecla(KeyEvent ev) {

		boolean teclaPulsada = false;
		
		if (ev.getCode() == KeyCode.DIGIT1||ev.getCode() == KeyCode.DIGIT2||ev.getCode() == KeyCode.DIGIT3||ev.getCode() == KeyCode.DIGIT4||
				ev.getCode() == KeyCode.DIGIT5||ev.getCode() == KeyCode.DIGIT6||ev.getCode() == KeyCode.DIGIT7||ev.getCode() == KeyCode.DIGIT8||
				ev.getCode() == KeyCode.DIGIT9||ev.getCode() == KeyCode.DIGIT0||ev.getCode() == KeyCode.NUMPAD1||ev.getCode() == KeyCode.NUMPAD2||
				ev.getCode() == KeyCode.NUMPAD3||ev.getCode() == KeyCode.NUMPAD4||ev.getCode() == KeyCode.NUMPAD5||ev.getCode() == KeyCode.NUMPAD6||
				ev.getCode() == KeyCode.NUMPAD7||ev.getCode() == KeyCode.NUMPAD8||ev.getCode() == KeyCode.NUMPAD9||ev.getCode() == KeyCode.NUMPAD0||
				ev.getCode() == KeyCode.MINUS || ev.getCode() == KeyCode.BACK_SPACE) {
			teclaPulsada = true;
		} else {
			teclaPulsada = false;
		}
		
		return teclaPulsada;
		
	}
	
	public void seleccionarImagenPersonaje(MouseEvent ev) {
		FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Buscar Imagen");

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );

        File imgFile = fileChooser.showOpenDialog(((Node)ev.getSource()).getScene().getWindow());

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
