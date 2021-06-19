package application;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.SessionFactory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
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
import javafx.stage.Stage;
import modelo.AccionesTurno;
import modelo.Arma;
import modelo.ArmaSeleccionada;
import modelo.Armadura;
import modelo.ArmaduraSeleccionada;
import modelo.ArteMarcial;
import modelo.ArteMarcialSeleccionado;
import modelo.CaracteristicaSeleccionada;
import modelo.Caracteristicas;
import modelo.Categoria;
import modelo.ConjuroSeleccionado;
import modelo.ConsultasHibernate;
import modelo.Desventaja;
import modelo.DesventajaSeleccionada;
import modelo.NivelClase;
import modelo.PdsCombate;
import modelo.PdsHabilidadesSecundarias;
import modelo.PdsHabilidadesSecundariasResumen;
import modelo.PdsMisticos;
import modelo.PdsPrimariasComunes;
import modelo.PdsPrimariasKi;
import modelo.PdsPrimariasMisticas;
import modelo.PdsPrimariasPsiquicas;
import modelo.PdsPsiquicos;
import modelo.PdsSecundariasAtleticas;
import modelo.PdsSecundariasCreativas;
import modelo.PdsSecundariasIntelectuales;
import modelo.PdsSecundariasPerceptivas;
import modelo.PdsSecundariasSociales;
import modelo.PdsSecundariasSubterfugio;
import modelo.PdsSecundariasVigor;
import modelo.Personaje;
import modelo.PoderPsiquico;
import modelo.PoderPsiquicoSeleccionado;
import modelo.PotencialPsiquico;
import modelo.PreparacionPsiquico;
import modelo.Raza;
import modelo.ResistenciasTabla;
import modelo.TablaConjurosLibreAcceso;
import modelo.TablaEstilo;
import modelo.TablaEstiloSeleccionada;
import modelo.TablaMagia;
import modelo.TablaMagiaSeleccionada;
import modelo.TablaViasMagia;
import modelo.ValorConstitucion;
import modelo.Ventaja;
import modelo.VentajaSeleccionada;
import modelo.ViaSeleccionada;

public class PersonajeController {
	
	ConsultasHibernate ch;
	SessionFactory sessionFactory;
	Categoria categoriaSeleccionada;
	Raza razaSeleccionada;
	ValorConstitucion valorConstitucion;
	NivelClase nivelClase;
	PotencialPsiquico potencialPsiquico;
	Personaje personaje;
	String direccionImagen;
	
	@FXML
	ImageView imagenChar, iD10Apariencia;
	
	@FXML
	Accordion acPrincipalHabilidadesSecundarias, acPds, acTablasCombate;
	
	@FXML
	Pane pPersonajeChar, pD10Apariencia; 
	
	@FXML
	TitledPane tpAtleticas, tpPdsCombate, tpTablasEstilos;
	
	@FXML
	TextField tApariencia, tCansancioBase, tCansancioEspecial, tCansancioTotal, tTurnoBase, tTurnoAgilidad, tTurnoDestreza, tTurnoCategoria, tTurnoArmadura,
	tTurnoDesarmado, tTurnoEspecial, tTurnoTotal, tPuntosVidaBase, tPuntosVidaCategoria, tPuntosVidaTotales, tRegeneracion, tCuracionDia, tNegativoDia, tPuntosVidaEspecial,
	tAccionesTurno, tPuntosCreacion, tCategoriaPrimerLv, tNivelTotal, tPdsRestantes, tLlevarArmadura, tHabilidadDefensa, tHabilidadAtaque, tPuntosRegeneracionEspecial,
	tRazaGeneral, tEtniaGeneral, tBonosNaturales, tHabilidadesNaturales, tBonosNovel, tTipoArma1, tTipoArma2, tTipoArma3, tTipoArma4, tRasgoArma1, tRasgoArma2, tRasgoArma3,
	tRasgoArma4, tDineroOro, tDineroPlata, tDineroCobre, tNombre, tSexo, tEdad, tRegion, tProyeccionMagicaAtaque, tProyeccionMagicaDefensa, tAcumulacionTurno, tPuntosZeon, 
	tNivelMagiaTotal, tCvUsado, tPotencialTotal, tCvTotales, tProyeccionPsiquicaAtaque, tProyeccionPsiquicaDefensa, tCosteTablaPsiquico, tPdsTablaPsiquico;
	
	@FXML
	TextArea tAreaEquipoCombate, tAreaVestimenta, tAreaEquipoVariado, tAreaContactos, tAreaTitulosPosesiones, tAreaJoyas, tAreaPersonalidad, tAreaParticularidades, tAreaObjetivos,
	tAreaHistoria;
	
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
	TableView<TablaEstiloSeleccionada> tableViewTablasEstilos;
	
	@FXML
	TableView<ArteMarcialSeleccionado> tableViewTablasArtesMarciales;
	
	@FXML
	TableView<ViaSeleccionada> tableViewNivelVia;

	@FXML
	TableView<TablaMagiaSeleccionada> tableViewTablasMistico;

	@FXML
	TableView<ConjuroSeleccionado> tableViewConjurosLibreAcceso;

	@FXML
	TableView<PreparacionPsiquico> tableViewConcentracion;

	@FXML
	TableView<PoderPsiquicoSeleccionado> tableViewPoderesPsiquicos;
	
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
	ComboBox<String> cBoxNombreArma1, cBoxNombreArma2, cBoxNombreArma3, cBoxNombreArma4, cNombreTablaPsiquico;
	
	@FXML
	TableColumn<ArmaduraSeleccionada, String> colArmaduraFilo, colArmaduraContundente, colArmaduraPenetrante, colArmaduraCalor, colArmaduraElectrico, colArmaduraFrio, colArmaduraEnergia,
	colArmaduraEntereza, colArmaduraRequisito, colArmaduraPenalizacionNatural;

	@FXML
	TableColumn<ArmaduraSeleccionada, ComboBox<String>> colArmaduraNombre;
	
	@FXML
	TableColumn<TablaEstiloSeleccionada, String> colCosteTablaEstilos, colPdsTablaEstilos;

	@FXML
	TableColumn<TablaEstiloSeleccionada, ComboBox<String>> colNombreTablaEstilos;
	
	@FXML
	TableColumn<ArteMarcialSeleccionado, ComboBox<String>> colNombreTablaArtesMarciales;
	
	@FXML
	TableColumn<ArteMarcialSeleccionado, String> colCosteTablaArtesMarciales, colPdsTablaArtesMarciales, colHaTablaArtesMarciales, colHpTablaArtesMarciales,
	colHeTablaArtesMarciales, colTurnoTablaArtesMarciales;

	@FXML
	TableColumn<ViaSeleccionada, ComboBox<String>> colViaNombre;
	
	@FXML
	TableColumn<ViaSeleccionada, String> colNivelViaUsado, colNivelViaTotal;

	@FXML
	TableColumn<TablaMagiaSeleccionada, ComboBox<String>> colNombreTablasMistico;
	
	@FXML
	TableColumn<TablaMagiaSeleccionada, String> colCosteTablasMistico, colPdsTablasMistico;

	@FXML
	TableColumn<ConjuroSeleccionado, ComboBox<String>> colConjurosLibreAccesoNombre;
	
	@FXML
	TableColumn<ConjuroSeleccionado, String> colConjurosLibreAccesoNivel;
	
	@FXML
	TableColumn<PreparacionPsiquico, String> colPreparacionConcentracion, colBonoPotencialConcentracion;
	
	@FXML
	TableColumn<PoderPsiquicoSeleccionado, ComboBox<String>> colNombrePoderesMentales;
	
	@FXML
	TableColumn<PoderPsiquicoSeleccionado, String> colDisciplinaPoderesMentales, colNivelPoderesMentales;
	
	public PersonajeController(SessionFactory sessionFactory, String categoria, String raza, Personaje personaje) {
		this.ch = new ConsultasHibernate();
		this.sessionFactory = sessionFactory;
		this.categoriaSeleccionada = ch.obtenerCategoria(categoria, sessionFactory);
		this.razaSeleccionada = ch.obtenerRaza(raza, sessionFactory);
		this.personaje = personaje;
		
		if (null!=personaje.getNombre()) {
			this.nivelClase = new NivelClase(categoria, String.valueOf(personaje.getNivel()));
		} else {
			this.nivelClase = new NivelClase(this.categoriaSeleccionada.getNombre(), "1");
		}
		
		
		if (null!=personaje.getNombre()) {
			if (personaje.getCvInvertido()!=null) {
				this.potencialPsiquico = new PotencialPsiquico(String.valueOf(personaje.getCaracteristicas().getPoder()+personaje.getCaracteristicas().getPoderTemporal()), String.valueOf(personaje.getCvInvertido()));
			} else {
				this.potencialPsiquico = new PotencialPsiquico(String.valueOf(personaje.getCaracteristicas().getPoder()+personaje.getCaracteristicas().getPoderTemporal()), "0");
			}

			valorConstitucion = new ValorConstitucion(String.valueOf(personaje.getCaracteristicas().getConstitucion()+personaje.getCaracteristicas().getConstitucionTemporal()));

			
		} else {
			this.potencialPsiquico = new PotencialPsiquico("0", "0");
			valorConstitucion = new ValorConstitucion(String.valueOf("0"));
			
		}
	}
	
	@FXML
	public void initialize(){
		tNivelTotal.setText(nivelClase.getNivel());
		ObservableList<String> nombreVentajas = ch.obtenerNombresVentaja(sessionFactory);
		ObservableList<String> nombreDesventajas = ch.obtenerNombresDesventaja(sessionFactory);
		ObservableList<String> nombreArmas = ch.obtenerListaArmas(sessionFactory);
		ObservableList<String> nombreArmaduras = ch.obtenerListaArmaduras(sessionFactory);
		ObservableList<String> nombreEstilos = ch.obtenerListaTablasEstilo(sessionFactory);
		ObservableList<String> nombreArtesMarciales = ch.obtenerListaArtesMarciales(sessionFactory);
		ObservableList<String> nombreViasMagicas = ch.obtenerListaViasMagicas(sessionFactory);
		ObservableList<String> nombreTablasMagicas = ch.listaTablasMagias(sessionFactory);
		ObservableList<String> nombreConjurosLibreAcceso = ch.listaConjurosLibreAcceso(sessionFactory);
		ObservableList<String> nombreTablaPsiquico = FXCollections.observableArrayList();
		ObservableList<String> nombresPoderesPsiquicos = ch.listaPoderesPsiquicos(sessionFactory);
		acPrincipalHabilidadesSecundarias.setExpandedPane(tpAtleticas);
		acPds.setExpandedPane(tpPdsCombate);
		acTablasCombate.setExpandedPane(tpTablasEstilos);
		

		/*------------------------------------------------------Tabla Caracteristicas------------------------------------------------------*/
		obtenerTablaCaracteristicas(personaje);
		
		/*------------------------------------------------------Tabla Resistencias------------------------------------------------------*/
		obtenerTablaResistencias();
		
		/*------------------------------------------------------Tabla Ventajas------------------------------------------------------*/
		obtenerTablaVentajas(nombreVentajas);
		
		/*------------------------------------------------------Tabla Desventajas------------------------------------------------------*/
		obtenerTablaDesventajas(nombreDesventajas);
		
		/*------------------------------------------------------Tabla Pds Combate Pestaña Pds------------------------------------------------------*/
		obtenerTablaCombate();
		
		/*------------------------------------------------------Tabla Pds Misticos Pestaña Pds------------------------------------------------------*/
		obtenerTablaMistico();

		/*------------------------------------------------------Tabla Pds Psiquicos Pestaña Pds------------------------------------------------------*/
		obtenerTablaPsiquico();

		/*------------------------------------------------------Tabla Habilidades Secundarias Pestaña Pds ------------------------------------------------------*/
		obtenerTablaSecundarias();
		
		/*------------------------------------------------------Tabla Pds Resumen Secundarias Pestaña Principal------------------------------------------------------*/
		obtenerTablaResumenAtleticas();
		
		/*------------------------------------------------------Tabla Pds Resumen Secundarias Pestaña Principal------------------------------------------------------*/
		obtenerTablaResumenSociales();
		
		/*------------------------------------------------------Tabla Pds Resumen Secundarias Pestaña Principal------------------------------------------------------*/
		obtenerTablaResumenPerceptivas();

		/*------------------------------------------------------Tabla Pds Resumen Secundarias Pestaña Principal------------------------------------------------------*/
		obtenerTablaResumenIntelectuales();

		/*------------------------------------------------------Tabla Pds Resumen Secundarias Pestaña Principal------------------------------------------------------*/
		obtenerTablaResumenVigor();

		/*------------------------------------------------------Tabla Pds Resumen Secundarias Pestaña Principal------------------------------------------------------*/
		obtenerTablaResumenSubterfugio();
		
		/*------------------------------------------------------Tabla Pds Resumen Secundarias Pestaña Principal------------------------------------------------------*/
		obtenerTablaResumenCreativas();
		
		/*------------------------------------------------------Tabla Armas de la pestaña Combate------------------------------------------------------*/
		/*------------------------------------------------------Seteo del turno de los texfield de la pestaña principal------------------------------------------------------*/
		obtenerTablaArma(nombreArmas);

		/*------------------------------------------------------Tabla Armaduras Pestaña Combate------------------------------------------------------*/
		obtenerTablaArmadura(nombreArmaduras);

		/*------------------------------------------------------Tabla Estilos Pestaña Combate------------------------------------------------------*/
		obtenerTablaEstilos(nombreEstilos);

		/*------------------------------------------------------Tabla Artes Marciales Pestaña Combate------------------------------------------------------*/
		obtenerTablaArtesMarciales(nombreArtesMarciales);

		/*------------------------------------------------------Tabla Nivel Via Pestaña Misticos------------------------------------------------------*/
		obtenerTablaNivelMagia(nombreViasMagicas);
		
		/*------------------------------------------------------Tabla Tablas Misticas Pestaña Misticos------------------------------------------------------*/
		obtenerTablasMistico(nombreTablasMagicas);

		/*------------------------------------------------------Tabla Tablas Conjuros libre acceso Pestaña Misticos------------------------------------------------------*/
		obtenerTablaConjurosLibreAcceso(nombreConjurosLibreAcceso);

		/*------------------------------------------------------Tabla Concentracion Pestaña Psiquico------------------------------------------------------*/
		obtenerTablaConcentracion();
		
		/*------------------------------------------------------Tabla Poderes Psiquicos Pestaña Psiquico------------------------------------------------------*/
		obtenerTablaPoderesPsiquicos(nombresPoderesPsiquicos);
		
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
		tProyeccionMagicaAtaque.setText(tableViewMisticas.getItems().get(3).getTotalHabilidad());
		tProyeccionMagicaDefensa.setText(tableViewMisticas.getItems().get(3).getTotalHabilidad());
		tPuntosZeon.setText(tableViewMisticas.getItems().get(0).getTotalHabilidad());
		tAcumulacionTurno.setText(String.valueOf(Integer.parseInt(tableViewMisticas.getItems().get(2).getTotalHabilidad())+Integer.parseInt(tableViewMisticas.getItems().get(1).getTotalHabilidad())));
		tNivelMagiaTotal.setText(tableViewMisticas.getItems().get(4).getTotalHabilidad());
		tPotencialTotal.setText(potencialPsiquico.getPotencial());
		tCvTotales.setText(tableViewPsiquicas.getItems().get(0).getTotalHabilidad());
		tProyeccionPsiquicaAtaque.setText(tableViewPsiquicas.getItems().get(1).getTotalHabilidad());
		tProyeccionPsiquicaDefensa.setText(tableViewPsiquicas.getItems().get(1).getTotalHabilidad());
		if (null!=personaje.getImagen()) {
			this.direccionImagen = personaje.getImagen();
            Image image = new Image("file:" + direccionImagen);
            imagenChar.setImage(image);
		}
		if (null!=personaje.getNombre()) {
			tNombre.setText(personaje.getNombre());
			tApariencia.setText(String.valueOf(personaje.getApariencia()));
			tEtniaGeneral.setText(personaje.getEtnia());
			tRegion.setText(personaje.getOrigen());
			tEdad.setText(String.valueOf(personaje.getEdad()));
			tAreaContactos.setText(personaje.getContactos());
			tAreaEquipoCombate.setText(personaje.getEquipoCombate());
			tAreaEquipoVariado.setText(personaje.getEquipoVariado());
			tAreaTitulosPosesiones.setText(personaje.getTitulosPosesiones());
			tAreaVestimenta.setText(personaje.getVestimentaAccesorios());
			tAreaJoyas.setText(personaje.getJoyas());
			tAreaHistoria.setText(personaje.getHistoria());
			tAreaObjetivos.setText(personaje.getObjetivos());
			tAreaParticularidades.setText(personaje.getParticularidades());
			tAreaPersonalidad.setText(personaje.getDescripcion());
			tDineroOro.setText(personaje.getMonedasOro());
			tDineroPlata.setText(personaje.getMonedasPlata());
			tDineroCobre.setText(personaje.getMonedasCobre());
			tNombre.setEditable(false);
			
			tCvUsado.setText(String.valueOf(personaje.getCvInvertido()));
			tPuntosRegeneracionEspecial.setText(String.valueOf(personaje.getRegeneracionEspecial()));
			tPuntosVidaEspecial.setText(String.valueOf(personaje.getPvEspecial()));
			tTurnoEspecial.setText(String.valueOf(personaje.getTurnoEspecial()));
			tCansancioEspecial.setText(String.valueOf(personaje.getCansancioEspecial()));
			
		}
		
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
		
		obtenerPdsMisticos(pds);
	}
	
	public void cambiarPdsEspecialMisticos (TableColumn.CellEditEvent<PdsMisticos, String> cellEditEvent) {
		PdsMisticos pds = tableViewMisticas.getSelectionModel().getSelectedItem();
		pds.setEspecialHabilidad(cellEditEvent.getNewValue());
		
		obtenerPdsMisticos(pds);
	}
	
	public void cambiarPdsPsiquicos (TableColumn.CellEditEvent<PdsPsiquicos, String> cellEditEvent) {
		PdsPsiquicos pds = tableViewPsiquicas.getSelectionModel().getSelectedItem();
		pds.setPdsHabilidad(cellEditEvent.getNewValue());
		
		cambiarPdsPsiquicos(pds);
		
	}
	
	public void cambiarPdsEspecialPsiquicos (TableColumn.CellEditEvent<PdsPsiquicos, String> cellEditEvent) {
		PdsPsiquicos pds = tableViewPsiquicas.getSelectionModel().getSelectedItem();
		pds.setEspecialHabilidad(cellEditEvent.getNewValue());
		
		cambiarPdsPsiquicos(pds);
		
	}
	
	public void cambiarPdsPsiquicos(PdsPsiquicos pds) {
		if (tableViewPsiquicas.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("CV")) {
			tCvTotales.setText(tableViewPsiquicas.getItems().get(0).getTotalHabilidad());
		} else if (tableViewPsiquicas.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Proyeccion Psiquica")) {
			tProyeccionPsiquicaAtaque.setText(tableViewPsiquicas.getItems().get(1).getTotalHabilidad());
			tProyeccionPsiquicaDefensa.setText(tableViewPsiquicas.getItems().get(1).getTotalHabilidad());
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

	public void cambiarNivelesViaUsados (TableColumn.CellEditEvent<PdsMisticos, String> cellEditEvent) {
		ViaSeleccionada nivel = tableViewNivelVia.getSelectionModel().getSelectedItem();
		nivel.setNivelUsado(cellEditEvent.getNewValue());
		
		tableViewNivelVia.refresh();
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
			
//			if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=1&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=9) {
//				tableViewCombate.getItems().get(10).setBonoHabilidad("1");
//				
//			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=10&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=12) {
//				tableViewCombate.getItems().get(10).setBonoHabilidad("2");
//				
//			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=13&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=15) {
//				tableViewCombate.getItems().get(10).setBonoHabilidad("3");
//				
//			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=16) {
//				tableViewCombate.getItems().get(10).setBonoHabilidad("4");
//				
//			}
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
			
			tableviewArmaSeleccionada1.getItems().get(0).setTurno(String.valueOf(Integer.parseInt(tTurnoTotal.getText())-Integer.parseInt("20")));
			tableviewArmaSeleccionada2.getItems().get(0).setTurno(String.valueOf(Integer.parseInt(tTurnoTotal.getText())-Integer.parseInt("20")));
			tableviewArmaSeleccionada3.getItems().get(0).setTurno(String.valueOf(Integer.parseInt(tTurnoTotal.getText())-Integer.parseInt("20")));
			tableviewArmaSeleccionada4.getItems().get(0).setTurno(String.valueOf(Integer.parseInt(tTurnoTotal.getText())-Integer.parseInt("20")));
			
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
//			tableViewCombate.getItems().get(5).setBonoHabilidad(caracteristica.getTotalCaracteristica());
			
//			if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=1&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=9) {
//				tableViewCombate.getItems().get(11).setBonoHabilidad("1");
//				
//			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=10&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=12) {
//				tableViewCombate.getItems().get(11).setBonoHabilidad("2");
//				
//			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=13&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=15) {
//				tableViewCombate.getItems().get(11).setBonoHabilidad("3");
//				
//			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=16) {
//				tableViewCombate.getItems().get(11).setBonoHabilidad("4");
//				
//			}
			
		} else if (tableViewCaracteristicas.getSelectionModel().getSelectedItem().getNombreCaracteristica().equals("FUE")) {
			caracteristica.setTotalCaracteristica(String.valueOf(Integer.parseInt(caracteristica.getBaseCaracteristica())+Integer.parseInt(caracteristica.getTempCaracteristica())+Integer.parseInt(razaSeleccionada.getBonoFuerza())));
			caracteristica.setBonoCaracteristica(caracteristica.getTotalCaracteristica());
			tableViewResistencias.getItems().get(4).setBonoCaracteristica(caracteristica.getBonoCaracteristica());
//			tableViewCombate.getItems().get(7).setBonoHabilidad(caracteristica.getTotalCaracteristica());
			
//			if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=1&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=9) {
//				tableViewCombate.getItems().get(13).setBonoHabilidad("1");
//				
//			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=10&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=12) {
//				tableViewCombate.getItems().get(13).setBonoHabilidad("2");
//				
//			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=13&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=15) {
//				tableViewCombate.getItems().get(13).setBonoHabilidad("3");
//				
//			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=16) {
//				tableViewCombate.getItems().get(13).setBonoHabilidad("4");
//				
//			}
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
//			tableViewCombate.getItems().get(6).setBonoHabilidad(caracteristica.getTotalCaracteristica());
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
			
//			if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=1&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=9) {
//				tableViewCombate.getItems().get(12).setBonoHabilidad("1");
//				
//			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=10&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=12) {
//				tableViewCombate.getItems().get(12).setBonoHabilidad("2");
//				
//			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=13&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=15) {
//				tableViewCombate.getItems().get(12).setBonoHabilidad("3");
//				
//			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=16) {
//				tableViewCombate.getItems().get(12).setBonoHabilidad("4");
//				
//			}
			
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
			
			
			tableviewArmaSeleccionada1.getItems().get(0).setTurno(String.valueOf(Integer.parseInt(tTurnoTotal.getText())-Integer.parseInt("20")));
			tableviewArmaSeleccionada2.getItems().get(0).setTurno(String.valueOf(Integer.parseInt(tTurnoTotal.getText())-Integer.parseInt("20")));
			tableviewArmaSeleccionada3.getItems().get(0).setTurno(String.valueOf(Integer.parseInt(tTurnoTotal.getText())-Integer.parseInt("20")));
			tableviewArmaSeleccionada4.getItems().get(0).setTurno(String.valueOf(Integer.parseInt(tTurnoTotal.getText())-Integer.parseInt("20")));
			

			tProyeccionMagicaAtaque.setText(tableViewMisticas.getItems().get(3).getTotalHabilidad());
			tProyeccionMagicaDefensa.setText(tableViewMisticas.getItems().get(3).getTotalHabilidad());
			
			tProyeccionPsiquicaAtaque.setText(tableViewPsiquicas.getItems().get(1).getTotalHabilidad());
			tProyeccionPsiquicaDefensa.setText(tableViewPsiquicas.getItems().get(1).getTotalHabilidad());
			
			
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
			
			tableViewMisticas.getItems().get(4).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tNivelMagiaTotal.setText(tableViewMisticas.getItems().get(4).getTotalHabilidad());
			
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
//			tableViewCombate.getItems().get(8).setBonoHabilidad(caracteristica.getTotalCaracteristica());
			
//			if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=1&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=9) {
//				tableViewCombate.getItems().get(14).setBonoHabilidad("1");
//				
//			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=10&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=12) {
//				tableViewCombate.getItems().get(14).setBonoHabilidad("2");
//				
//			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=13&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=15) {
//				tableViewCombate.getItems().get(14).setBonoHabilidad("3");
//				
//			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=16) {
//				tableViewCombate.getItems().get(14).setBonoHabilidad("4");
//				
//			}
			
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
			tableViewMisticas.getItems().get(2).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewMisticas.getItems().get(5).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewMisticas.getItems().get(7).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			tableViewMisticas.getItems().get(8).setBonoHabilidad(caracteristica.getBonoCaracteristica());
			
			tPuntosZeon.setText(tableViewMisticas.getItems().get(0).getTotalHabilidad());
			tAcumulacionTurno.setText(String.valueOf(Integer.parseInt(tableViewMisticas.getItems().get(2).getTotalHabilidad())+Integer.parseInt(tableViewMisticas.getItems().get(1).getTotalHabilidad())));
			
			
		} else if (tableViewCaracteristicas.getSelectionModel().getSelectedItem().getNombreCaracteristica().equals("VOL")) {
			caracteristica.setTotalCaracteristica(String.valueOf(Integer.parseInt(caracteristica.getBaseCaracteristica())+Integer.parseInt(caracteristica.getTempCaracteristica())+Integer.parseInt(razaSeleccionada.getBonoVoluntad())));
			caracteristica.setBonoCaracteristica(caracteristica.getTotalCaracteristica());
			tableViewResistencias.getItems().get(5).setBonoCaracteristica(caracteristica.getBonoCaracteristica());
//			tableViewCombate.getItems().get(9).setBonoHabilidad(caracteristica.getTotalCaracteristica());
			
//			if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=1&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=9) {
//				tableViewCombate.getItems().get(15).setBonoHabilidad("1");
//				
//			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=10&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=12) {
//				tableViewCombate.getItems().get(15).setBonoHabilidad("2");
//				
//			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=13&&Integer.parseInt(caracteristica.getTotalCaracteristica())<=15) {
//				tableViewCombate.getItems().get(15).setBonoHabilidad("3");
//				
//			} else if (Integer.parseInt(caracteristica.getTotalCaracteristica())>=16) {
//				tableViewCombate.getItems().get(15).setBonoHabilidad("4");
//				
//			}
			
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
			
			potencialPsiquico.setVoluntad(tableViewCaracteristicas.getItems().get(7).getTotalCaracteristica());
			tPotencialTotal.setText(potencialPsiquico.getPotencial());
			
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
	
	public void obtenerPdsMisticos(PdsMisticos pds) {
		if (tableViewMisticas.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Zeon")) {
			tPuntosZeon.setText(tableViewMisticas.getItems().get(0).getTotalHabilidad());
		} else if (tableViewMisticas.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("ACT")) {
			tAcumulacionTurno.setText(String.valueOf(Integer.parseInt(tableViewMisticas.getItems().get(2).getTotalHabilidad())+Integer.parseInt(tableViewMisticas.getItems().get(1).getTotalHabilidad())));
		} else if (tableViewMisticas.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Multiplo de Regeneracion")) {
			tAcumulacionTurno.setText(String.valueOf(Integer.parseInt(tableViewMisticas.getItems().get(2).getTotalHabilidad())+Integer.parseInt(tableViewMisticas.getItems().get(1).getTotalHabilidad())));
		} else if (tableViewMisticas.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Proyeccion Magia")) {
			tProyeccionMagicaAtaque.setText(tableViewMisticas.getItems().get(3).getTotalHabilidad());
			tProyeccionMagicaDefensa.setText(tableViewMisticas.getItems().get(3).getTotalHabilidad());
		} else if (tableViewMisticas.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Nivel de Magia")) {
			tNivelMagiaTotal.setText(pds.getTotalHabilidad());
		} else if (tableViewMisticas.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Convocar")) {
			
		} else if (tableViewMisticas.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Controlar")) {
			
		} else if (tableViewMisticas.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Atar")) {
			
		} else if (tableViewMisticas.getSelectionModel().getSelectedItem().getNombreHabilidad().equals("Desconvocar")) {
			
		}
		
		tableViewMisticas.refresh();
	}
	
	public void cambiarArmaSeleccionada(ActionEvent ev) {
		String nombreArmaSeleccioanda = (String) ((ComboBox<?>)ev.getSource()).getSelectionModel().getSelectedItem();
		if (((ComboBox<?>)ev.getSource()).getId().equals("cBoxNombreArma1")) {
			tableviewArmaSeleccionada1.getItems().get(0).setArmaSeleccionada(ch.obtenerArma(sessionFactory, nombreArmaSeleccioanda), 
					tableViewCombate.getItems().get(0).getTotalHabilidad(), 
					tableViewCaracteristicas.getItems().get(2).getBonoCaracteristica(),
					String.valueOf(Integer.parseInt(tTurnoTotal.getText())-Integer.parseInt("20")));
			tTipoArma1.setText(tableviewArmaSeleccionada1.getItems().get(0).getTipoArma());
			tRasgoArma1.setText(tableviewArmaSeleccionada1.getItems().get(0).getRasgo());
			tableviewArmaSeleccionada1.refresh();
		} else if (((ComboBox<?>)ev.getSource()).getId().equals("cBoxNombreArma2")) {
			tableviewArmaSeleccionada2.getItems().get(0).setArmaSeleccionada(ch.obtenerArma(sessionFactory, nombreArmaSeleccioanda), 
					tableViewCombate.getItems().get(0).getTotalHabilidad(), 
					tableViewCaracteristicas.getItems().get(2).getBonoCaracteristica(),
					String.valueOf(Integer.parseInt(tTurnoTotal.getText())-Integer.parseInt("20")));
			tTipoArma2.setText(tableviewArmaSeleccionada2.getItems().get(0).getTipoArma());
			tRasgoArma2.setText(tableviewArmaSeleccionada2.getItems().get(0).getRasgo());
			tableviewArmaSeleccionada2.refresh();
		} else if (((ComboBox<?>)ev.getSource()).getId().equals("cBoxNombreArma3")) {
			tableviewArmaSeleccionada3.getItems().get(0).setArmaSeleccionada(ch.obtenerArma(sessionFactory, nombreArmaSeleccioanda), 
					tableViewCombate.getItems().get(0).getTotalHabilidad(), 
					tableViewCaracteristicas.getItems().get(2).getBonoCaracteristica(),
					String.valueOf(Integer.parseInt(tTurnoTotal.getText())-Integer.parseInt("20")));
			tTipoArma3.setText(tableviewArmaSeleccionada3.getItems().get(0).getTipoArma());
			tRasgoArma3.setText(tableviewArmaSeleccionada3.getItems().get(0).getRasgo());
			tableviewArmaSeleccionada3.refresh();
		} else if (((ComboBox<?>)ev.getSource()).getId().equals("cBoxNombreArma4")) {
			tableviewArmaSeleccionada4.getItems().get(0).setArmaSeleccionada(ch.obtenerArma(sessionFactory, nombreArmaSeleccioanda), 
					tableViewCombate.getItems().get(0).getTotalHabilidad(), 
					tableViewCaracteristicas.getItems().get(2).getBonoCaracteristica(),
					String.valueOf(Integer.parseInt(tTurnoTotal.getText())-Integer.parseInt("20")));
			tTipoArma4.setText(tableviewArmaSeleccionada4.getItems().get(0).getTipoArma());
			tRasgoArma4.setText(tableviewArmaSeleccionada4.getItems().get(0).getRasgo());
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
		
		for (int i = 0; i < tableViewCombate.getItems().size(); i++) {
			tableViewCombate.getItems().get(i).setNivelClase(tNivelTotal.getText());
		}
		
		for (int i = 0; i < tableViewMisticas.getItems().size(); i++) {
			tableViewMisticas.getItems().get(i).setNivelClase(tNivelTotal.getText());
		}
		
		for (int i = 0; i < tableViewSecundarias.getItems().size(); i++) {
			tableViewSecundarias.getItems().get(i).setNivelClase(tNivelTotal.getText());
		}
		

		for (int i = 0; i < tableViewResumenAtleticas.getItems().size(); i++) {
			tableViewResumenAtleticas.getItems().get(i).setTotalHabilidad(tableViewSecundarias.getItems().get(i).getTotalHabilidad());
		}
		
		for (int i = 0; i < tableViewResumenSociales.getItems().size(); i++) {
			for (int j = 6; j < 12; j++) {
				tableViewResumenSociales.getItems().get(i).setTotalHabilidad(tableViewSecundarias.getItems().get(j).getTotalHabilidad());
				i++;
			}
		}
		
		for (int i = 0; i < tableViewResumenPerceptivas.getItems().size(); i++) {
			for (int j = 13; j < 15; j++) {
				tableViewResumenPerceptivas.getItems().get(i).setTotalHabilidad(tableViewSecundarias.getItems().get(j).getTotalHabilidad());
				i++;
			}
		}
		
		for (int i = 0; i < tableViewResumenIntelectuales.getItems().size(); i++) {
			for (int j = 16; j < 27; j++) {
				tableViewResumenIntelectuales.getItems().get(i).setTotalHabilidad(tableViewSecundarias.getItems().get(j).getTotalHabilidad());
				i++;
			}
		}
		
		for (int i = 0; i < tableViewResumenVigor.getItems().size(); i++) {
			for (int j = 28; j < 30; j++) {
				tableViewResumenVigor.getItems().get(i).setTotalHabilidad(tableViewSecundarias.getItems().get(j).getTotalHabilidad());
				i++;
			}
		}
		
		for (int i = 0; i < tableViewResumenSubterfugio.getItems().size(); i++) {
			for (int j = 31; j < 37; j++) {
				tableViewResumenSubterfugio.getItems().get(i).setTotalHabilidad(tableViewSecundarias.getItems().get(j).getTotalHabilidad());
				i++;
			}
		}
		
		for (int i = 0; i < tableViewResumenCreativas.getItems().size(); i++) {
			for (int j = 38; j < 48; j++) {
				tableViewResumenCreativas.getItems().get(i).setTotalHabilidad(tableViewSecundarias.getItems().get(j).getTotalHabilidad());
				i++;
			}
		}
		
		tHabilidadAtaque.setText(tableViewCombate.getItems().get(0).getTotalHabilidad());
		tLlevarArmadura.setText(tableViewCombate.getItems().get(3).getTotalHabilidad());
		if (Integer.parseInt(tableViewCombate.getItems().get(2).getTotalHabilidad())>Integer.parseInt(tableViewCombate.getItems().get(1).getTotalHabilidad())) {
			tHabilidadDefensa.setText(tableViewCombate.getItems().get(2).getTotalHabilidad());
		} else {
			tHabilidadDefensa.setText(tableViewCombate.getItems().get(1).getTotalHabilidad());
		}

		
		tableViewResistencias.refresh();
		tableViewCombate.refresh();
		tableViewMisticas.refresh();
		tableViewSecundarias.refresh();
		tableViewResumenAtleticas.refresh();
		tableViewResumenSociales.refresh();
		tableViewResumenPerceptivas.refresh();
		tableViewResumenIntelectuales.refresh();
		tableViewResumenVigor.refresh();
		tableViewResumenSubterfugio.refresh();
		tableViewResumenCreativas.refresh();
		
		
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
	
	public void obtenerTablaCaracteristicas(Personaje personaje2) {
		if (null==personaje.getNombre()) {
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

			
			colBase.setCellFactory(TextFieldTableCell.forTableColumn());
			colTemp.setCellFactory(TextFieldTableCell.forTableColumn());
			tableViewCaracteristicas.setItems(caracteristicas);
		} else {
			ObservableList<CaracteristicaSeleccionada> caracteristicas = FXCollections.observableArrayList(
					new CaracteristicaSeleccionada("AGI",String.valueOf(personaje.getCaracteristicas().getAgilidad()),String.valueOf(personaje.getCaracteristicas().getAgilidadTemporal()),razaSeleccionada.getBonoAgilidad()),
					new CaracteristicaSeleccionada("CON",String.valueOf(personaje.getCaracteristicas().getConstitucion()),String.valueOf(personaje.getCaracteristicas().getConstitucionTemporal()),razaSeleccionada.getBonoConstitucion()),
					new CaracteristicaSeleccionada("FUE",String.valueOf(personaje.getCaracteristicas().getFuerza()),String.valueOf(personaje.getCaracteristicas().getFuerzaTemporal()),razaSeleccionada.getBonoFuerza()),
					new CaracteristicaSeleccionada("DES",String.valueOf(personaje.getCaracteristicas().getDestreza()),String.valueOf(personaje.getCaracteristicas().getDestrezaTemporal()),razaSeleccionada.getBonoDestreza()),
					new CaracteristicaSeleccionada("INT",String.valueOf(personaje.getCaracteristicas().getInteligencia()),String.valueOf(personaje.getCaracteristicas().getInteligenciaTemporal()),razaSeleccionada.getBonoPercepcion()),
					new CaracteristicaSeleccionada("PER",String.valueOf(personaje.getCaracteristicas().getPercepcion()),String.valueOf(personaje.getCaracteristicas().getPercepcionTemporal()),razaSeleccionada.getBonoPercepcion()),
					new CaracteristicaSeleccionada("POD",String.valueOf(personaje.getCaracteristicas().getPoder()),String.valueOf(personaje.getCaracteristicas().getPoderTemporal()),razaSeleccionada.getBonoPoder()),
					new CaracteristicaSeleccionada("VOL",String.valueOf(personaje.getCaracteristicas().getVoluntad()),String.valueOf(personaje.getCaracteristicas().getVoluntadTemporal()),razaSeleccionada.getBonoVoluntad()));
			
			colPuntos.setCellValueFactory(new PropertyValueFactory<CaracteristicaSeleccionada, String>("nombreCaracteristica"));
			colBase.setCellValueFactory(new PropertyValueFactory<CaracteristicaSeleccionada, String>("baseCaracteristica"));
			colTemp.setCellValueFactory(new PropertyValueFactory<CaracteristicaSeleccionada, String>("tempCaracteristica"));
			colTotal.setCellValueFactory(new PropertyValueFactory<CaracteristicaSeleccionada, String>("totalCaracteristica"));
			colBono.setCellValueFactory(new PropertyValueFactory<CaracteristicaSeleccionada, String>("bonoCaracteristica"));

			
			colBase.setCellFactory(TextFieldTableCell.forTableColumn());
			colTemp.setCellFactory(TextFieldTableCell.forTableColumn());
			tableViewCaracteristicas.setItems(caracteristicas);
		}

	}
	
	public void obtenerTablaResistencias() {
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
	}
	
	public void obtenerTablaVentajas(ObservableList<String> nombreVentajas) {
		if (null==personaje.getNombre()) {
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
			tableViewVentaja.setItems(ventajas);
		} else {
			
			ArrayList<String> nombreSetVentajas = new ArrayList<String>();
			for (Ventaja ventaja : personaje.getVentajas()) {
				nombreSetVentajas.add(ventaja.getNombre());
			}
			
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
			
			if (0 < nombreSetVentajas.size()) {
				if (nombreSetVentajas.get(0)!=null) {
					cVentajas.setValue(nombreSetVentajas.get(0));
					ventajas.get(0).setCosteVentaja(String.valueOf(ch.obtenerCosteVentajaSeleccionada(sessionFactory, cVentajas.getValue())));
					tPuntosCreacion.setText(String.valueOf(Integer.parseInt(tPuntosCreacion.getText())-Integer.parseInt(ventajas.get(0).getCosteVentaja())));
				}
			}
			
			if (1 < nombreSetVentajas.size()) {
				if (nombreSetVentajas.get(1)!=null) {
					cVentajas2.setValue(nombreSetVentajas.get(1));
					ventajas.get(1).setCosteVentaja(String.valueOf(ch.obtenerCosteVentajaSeleccionada(sessionFactory, cVentajas2.getValue())));
					tPuntosCreacion.setText(String.valueOf(Integer.parseInt(tPuntosCreacion.getText())-Integer.parseInt(ventajas.get(1).getCosteVentaja())));
				}
			}
			
			if (2 < nombreSetVentajas.size()) {
				if (nombreSetVentajas.get(2)!=null) {
					cVentajas3.setValue(nombreSetVentajas.get(2));
					ventajas.get(2).setCosteVentaja(String.valueOf(ch.obtenerCosteVentajaSeleccionada(sessionFactory, cVentajas3.getValue())));
					tPuntosCreacion.setText(String.valueOf(Integer.parseInt(tPuntosCreacion.getText())-Integer.parseInt(ventajas.get(2).getCosteVentaja())));
				}
			}
			
			if (3 < nombreSetVentajas.size()) {
				if (nombreSetVentajas.get(3)!=null) {
					cVentajas4.setValue(nombreSetVentajas.get(3));
					ventajas.get(3).setCosteVentaja(String.valueOf(ch.obtenerCosteVentajaSeleccionada(sessionFactory, cVentajas4.getValue())));
					tPuntosCreacion.setText(String.valueOf(Integer.parseInt(tPuntosCreacion.getText())-Integer.parseInt(ventajas.get(3).getCosteVentaja())));
				}
			}
			
			if (4 < nombreSetVentajas.size()) {
				if (nombreSetVentajas.get(4)!=null) {
					cVentajas5.setValue(nombreSetVentajas.get(4));
					ventajas.get(4).setCosteVentaja(String.valueOf(ch.obtenerCosteVentajaSeleccionada(sessionFactory, cVentajas5.getValue())));
					tPuntosCreacion.setText(String.valueOf(Integer.parseInt(tPuntosCreacion.getText())-Integer.parseInt(ventajas.get(4).getCosteVentaja())));
				}
			}
			
			if (5 < nombreSetVentajas.size()) {
				if (nombreSetVentajas.get(5)!=null) {
					cVentajas6.setValue(nombreSetVentajas.get(5));
					ventajas.get(5).setCosteVentaja(String.valueOf(ch.obtenerCosteVentajaSeleccionada(sessionFactory, cVentajas6.getValue())));
					tPuntosCreacion.setText(String.valueOf(Integer.parseInt(tPuntosCreacion.getText())-Integer.parseInt(ventajas.get(5).getCosteVentaja())));
				}
			}
			
			if (6 < nombreSetVentajas.size()) {
				if (nombreSetVentajas.get(6)!=null) {
					cVentajas7.setValue(nombreSetVentajas.get(6));
					ventajas.get(6).setCosteVentaja(String.valueOf(ch.obtenerCosteVentajaSeleccionada(sessionFactory, cVentajas7.getValue())));
					tPuntosCreacion.setText(String.valueOf(Integer.parseInt(tPuntosCreacion.getText())-Integer.parseInt(ventajas.get(6).getCosteVentaja())));
				}
			}
			
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
			tableViewVentaja.setItems(ventajas);
		}
		
		
//		colVentajaNombre.setCellFactory(ComboBoxTableCell.forTableColumn(new DefaultStringConverter(), nombreVentajas));
		

	}
	
	public void obtenerTablaDesventajas(ObservableList<String> nombreDesventajas) {
		
		if (null==personaje.getNombre()) {
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
		} else {
			
			ArrayList<String> nombreSetDesventajas = new ArrayList<String>();
			for (Desventaja desventaja : personaje.getDesventajas()) {
				nombreSetDesventajas.add(desventaja.getNombre());
			}
			
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
			
			if (0 < nombreSetDesventajas.size()) {
				if (nombreDesventajas.get(0)!=null) {
					cDesventajas.setValue(nombreSetDesventajas.get(0));
					desventajas.get(0).setBeneficioDesventaja(String.valueOf(ch.obtenerBeneficioDesventajaSeleccionada(sessionFactory, cDesventajas.getValue())));
					tPuntosCreacion.setText(String.valueOf(Integer.parseInt(tPuntosCreacion.getText())-Integer.parseInt(desventajas.get(0).getBeneficioDesventaja())));
				}
			}
			
			if (1 < nombreSetDesventajas.size()) {
				if (nombreDesventajas.get(1)!=null) {
					cDesventajas2.setValue(nombreSetDesventajas.get(1));
					desventajas.get(1).setBeneficioDesventaja(String.valueOf(ch.obtenerBeneficioDesventajaSeleccionada(sessionFactory, cDesventajas2.getValue())));
					tPuntosCreacion.setText(String.valueOf(Integer.parseInt(tPuntosCreacion.getText())-Integer.parseInt(desventajas.get(1).getBeneficioDesventaja())));
				}
			}
			
			if (2 < nombreSetDesventajas.size()) {
				if (nombreDesventajas.get(2)!=null) {
					cDesventajas3.setValue(nombreSetDesventajas.get(2));
					desventajas.get(2).setBeneficioDesventaja(String.valueOf(ch.obtenerBeneficioDesventajaSeleccionada(sessionFactory, cDesventajas3.getValue())));
					tPuntosCreacion.setText(String.valueOf(Integer.parseInt(tPuntosCreacion.getText())-Integer.parseInt(desventajas.get(2).getBeneficioDesventaja())));
				}
			}
			
			if (3 < nombreSetDesventajas.size()) {
				if (nombreDesventajas.get(3)!=null) {
					cDesventajas4.setValue(nombreSetDesventajas.get(3));
					desventajas.get(3).setBeneficioDesventaja(String.valueOf(ch.obtenerBeneficioDesventajaSeleccionada(sessionFactory, cDesventajas4.getValue())));
					tPuntosCreacion.setText(String.valueOf(Integer.parseInt(tPuntosCreacion.getText())-Integer.parseInt(desventajas.get(3).getBeneficioDesventaja())));
				}
			}
			
			if (4 < nombreSetDesventajas.size()) {
				if (nombreDesventajas.get(4)!=null) {
					cDesventajas5.setValue(nombreSetDesventajas.get(4));
					desventajas.get(4).setBeneficioDesventaja(String.valueOf(ch.obtenerBeneficioDesventajaSeleccionada(sessionFactory, cDesventajas4.getValue())));
					tPuntosCreacion.setText(String.valueOf(Integer.parseInt(tPuntosCreacion.getText())-Integer.parseInt(desventajas.get(4).getBeneficioDesventaja())));
				}
			}
			

			
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
			
		}
		
		
	}
	
	public void obtenerTablaCombate() {
		if (null==personaje.getNombre()) {
			ObservableList<PdsCombate> pdsInvertidosCombate = FXCollections.observableArrayList(
					new PdsCombate("H.Ataque",String.valueOf(categoriaSeleccionada.getCosteHabilidadAtaque()),"0","0",String.valueOf(categoriaSeleccionada.getBonoHa()),"0",tNivelTotal.getText()),
					new PdsCombate("H.Parada",String.valueOf(categoriaSeleccionada.getCosteHabilidadParada()),"0","0",String.valueOf(categoriaSeleccionada.getBonoHp()),"0",tNivelTotal.getText()),
					new PdsCombate("H.Esquiva",String.valueOf(categoriaSeleccionada.getCosteHabilidadEsquiva()),"0","0",String.valueOf(categoriaSeleccionada.getBonoHe()),"0",tNivelTotal.getText()),
					new PdsCombate("Llevar Armadura",String.valueOf(categoriaSeleccionada.getCosteLlevarArmadura()),"0","0",String.valueOf(categoriaSeleccionada.getBonoLlevarArmadura()),"0",tNivelTotal.getText()),

					new PdsCombate("Conocimiento Marcial","5","0","0",String.valueOf(categoriaSeleccionada.getConocimientoMarcial()),"0",tNivelTotal.getText()));
			
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
		} else {
			ObservableList<PdsCombate> pdsInvertidosCombate = FXCollections.observableArrayList(
					new PdsCombate("H.Ataque",String.valueOf(categoriaSeleccionada.getCosteHabilidadAtaque()),String.valueOf(personaje.getPdsPrimariasComunes().getPdsHa()),String.valueOf(tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica()),String.valueOf(categoriaSeleccionada.getBonoHa()),String.valueOf(personaje.getPdsPrimariasComunes().getPdsEspHa()),tNivelTotal.getText()),
					new PdsCombate("H.Parada",String.valueOf(categoriaSeleccionada.getCosteHabilidadParada()),String.valueOf(personaje.getPdsPrimariasComunes().getPdsHp()),String.valueOf(tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica()),String.valueOf(categoriaSeleccionada.getBonoHp()),String.valueOf(personaje.getPdsPrimariasComunes().getPdsEspHp()),tNivelTotal.getText()),
					new PdsCombate("H.Esquiva",String.valueOf(categoriaSeleccionada.getCosteHabilidadEsquiva()),String.valueOf(personaje.getPdsPrimariasComunes().getPdsHe()),String.valueOf(tableViewCaracteristicas.getItems().get(0).getBonoCaracteristica()),String.valueOf(categoriaSeleccionada.getBonoHe()),String.valueOf(personaje.getPdsPrimariasComunes().getPdsEspHe()),tNivelTotal.getText()),
					new PdsCombate("Llevar Armadura",String.valueOf(categoriaSeleccionada.getCosteLlevarArmadura()),String.valueOf(personaje.getPdsPrimariasComunes().getPdsLlevarArmadura()),String.valueOf(tableViewCaracteristicas.getItems().get(2).getBonoCaracteristica()),String.valueOf(categoriaSeleccionada.getBonoLlevarArmadura()),String.valueOf(personaje.getPdsPrimariasComunes().getPdsEspLlevarArmadura()),tNivelTotal.getText()),

					new PdsCombate("Conocimiento Marcial","5",String.valueOf(personaje.getPdsPrimariasKi().getPdsConocimientoMarcial()),"0",String.valueOf(categoriaSeleccionada.getConocimientoMarcial()),String.valueOf(personaje.getPdsPrimariasKi().getPdsConocimientoMarcial()+personaje.getPdsPrimariasKi().getPdsEspConocimientoMarcial()),tNivelTotal.getText()));
			
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
		}
		
	}
	
	public void obtenerTablaMistico(){
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
		
		if (null==personaje.getNombre()) {
			ObservableList<PdsMisticos> pdsInvertidosMisticos = FXCollections.observableArrayList(
					new PdsMisticos("Zeon",String.valueOf(categoriaSeleccionada.getCosteZeon()),"0",tableViewCaracteristicas.getItems().get(6).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoZeon()),"0",tNivelTotal.getText()),
					new PdsMisticos("ACT",String.valueOf(categoriaSeleccionada.getCosteAct()),"0",tableViewCaracteristicas.getItems().get(6).getBonoCaracteristica(),"-","0",tNivelTotal.getText()),
					new PdsMisticos("Multiplo de regeneracion",String.valueOf(categoriaSeleccionada.getCosteAct()/2),"0",tableViewCaracteristicas.getItems().get(6).getBonoCaracteristica(),"-","0",tNivelTotal.getText()),
					new PdsMisticos("Proyeccion Magia",String.valueOf(categoriaSeleccionada.getCosteProyeccionMagica()),"0",tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),"-","0",tNivelTotal.getText()),
					new PdsMisticos("Nivel de Magia",String.valueOf(categoriaSeleccionada.getCosteNivelMagia()),"0",tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),"-","0",tNivelTotal.getText()),
					
					new PdsMisticos("Convocar",String.valueOf(categoriaSeleccionada.getCosteConvocar()),"0",tableViewCaracteristicas.getItems().get(6).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoConvocar()),"0",tNivelTotal.getText()),
					new PdsMisticos("Controlar",String.valueOf(categoriaSeleccionada.getCosteControlar()),"0",tableViewCaracteristicas.getItems().get(7).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoControlar()),"0",tNivelTotal.getText()),
					new PdsMisticos("Atar",String.valueOf(categoriaSeleccionada.getCosteAtar()),"0",tableViewCaracteristicas.getItems().get(6).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoAtar()),"0",tNivelTotal.getText()),
					new PdsMisticos("Desconvocar",String.valueOf(categoriaSeleccionada.getCosteDesconvocar()),"0",tableViewCaracteristicas.getItems().get(6).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoDesconvocar()),"0",tNivelTotal.getText()));
			
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
		} else {
			ObservableList<PdsMisticos> pdsInvertidosMisticos = FXCollections.observableArrayList(
					new PdsMisticos("Zeon",String.valueOf(categoriaSeleccionada.getCosteZeon()),String.valueOf(personaje.getPdsPrimariasMisticas().getPdsZeon()),tableViewCaracteristicas.getItems().get(6).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoZeon()),String.valueOf(personaje.getPdsPrimariasMisticas().getPdsEspZeon()),tNivelTotal.getText()),
					new PdsMisticos("ACT",String.valueOf(categoriaSeleccionada.getCosteAct()),String.valueOf(personaje.getPdsPrimariasMisticas().getPdsAct()),tableViewCaracteristicas.getItems().get(6).getBonoCaracteristica(),"-",String.valueOf(personaje.getPdsPrimariasMisticas().getPdsEspAct()),tNivelTotal.getText()),
					new PdsMisticos("Multiplo de regeneracion",String.valueOf(categoriaSeleccionada.getCosteAct()/2),String.valueOf(personaje.getPdsPrimariasMisticas().getPdsMultiploRegeneracion()),tableViewCaracteristicas.getItems().get(6).getBonoCaracteristica(),"-",String.valueOf(personaje.getPdsPrimariasMisticas().getPdsEspMultiploRegeneracion()),tNivelTotal.getText()),
					new PdsMisticos("Proyeccion Magia",String.valueOf(categoriaSeleccionada.getCosteProyeccionMagica()),String.valueOf(personaje.getPdsPrimariasMisticas().getPdsProyeccionMagica()),tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),"-",String.valueOf(personaje.getPdsPrimariasMisticas().getPdsEspProyeccionMagica()),tNivelTotal.getText()),
					new PdsMisticos("Nivel de Magia",String.valueOf(categoriaSeleccionada.getCosteNivelMagia()),String.valueOf(personaje.getPdsPrimariasMisticas().getPdsLvMagia()),tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),"-",String.valueOf(personaje.getPdsPrimariasMisticas().getPdsEspLvMagia()),tNivelTotal.getText()),
					
					new PdsMisticos("Convocar",String.valueOf(categoriaSeleccionada.getCosteConvocar()),String.valueOf(personaje.getPdsPrimariasMisticas().getPdsConvocar()),tableViewCaracteristicas.getItems().get(6).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoConvocar()),String.valueOf(personaje.getPdsPrimariasMisticas().getPdsEspConvocar()),tNivelTotal.getText()),
					new PdsMisticos("Controlar",String.valueOf(categoriaSeleccionada.getCosteControlar()),String.valueOf(personaje.getPdsPrimariasMisticas().getPdsControlar()),tableViewCaracteristicas.getItems().get(7).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoControlar()),String.valueOf(personaje.getPdsPrimariasMisticas().getPdsEspControlar()),tNivelTotal.getText()),
					new PdsMisticos("Atar",String.valueOf(categoriaSeleccionada.getCosteAtar()),String.valueOf(personaje.getPdsPrimariasMisticas().getPdsAtar()),tableViewCaracteristicas.getItems().get(6).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoAtar()),String.valueOf(personaje.getPdsPrimariasMisticas().getPdsEspAtar()),tNivelTotal.getText()),
					new PdsMisticos("Desconvocar",String.valueOf(categoriaSeleccionada.getCosteDesconvocar()),String.valueOf(personaje.getPdsPrimariasMisticas().getPdsDesconvocar()),tableViewCaracteristicas.getItems().get(6).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoDesconvocar()),String.valueOf(personaje.getPdsPrimariasMisticas().getPdsEspDesconvocar()),tNivelTotal.getText()));
			
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
		}
		
		
	}
	
	public void obtenerTablaPsiquico() {
		if (null==personaje.getNombre()) {
			ObservableList<PdsPsiquicos> pdsInvertidosPsiquicos = FXCollections.observableArrayList(
					new PdsPsiquicos("CV",String.valueOf(categoriaSeleccionada.getCostePuntosCv()),"0","0",String.valueOf(categoriaSeleccionada.getCvInnato()),"0"),
					new PdsPsiquicos("Proyeccion Psiquica",String.valueOf(categoriaSeleccionada.getCosteProyeccionPsiquica()),"0","0","-","0"));
			
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
		} else {
			ObservableList<PdsPsiquicos> pdsInvertidosPsiquicos = FXCollections.observableArrayList(
					new PdsPsiquicos("CV",String.valueOf(categoriaSeleccionada.getCostePuntosCv()),String.valueOf(personaje.getPdsPrimariasPsiquicas().getPdsCv()),"0",String.valueOf(categoriaSeleccionada.getCvInnato()),String.valueOf(personaje.getPdsPrimariasPsiquicas().getPdsEspCv())),
					new PdsPsiquicos("Proyeccion Psiquica",String.valueOf(categoriaSeleccionada.getCosteProyeccionPsiquica()),String.valueOf(personaje.getPdsPrimariasPsiquicas().getPdsProyeccionPsiquica()),"0","-",String.valueOf(personaje.getPdsPrimariasPsiquicas().getPdsEspProyeccionPsiquica())));
			
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
		}
		
	}
	
	public void obtenerTablaSecundarias() {
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
		
		if (null==personaje.getNombre()) {
			ObservableList<PdsHabilidadesSecundarias> pdsInvertidosSecundarias = FXCollections.observableArrayList(
					new PdsHabilidadesSecundarias("Acrobacias",costeAcrobacias,"0",tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoAcrobacias()),"0","0","0","0", tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Atletismo",costeAtletismo,"0",tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoAtletismo()),"0","0","0","0", tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Montar",String.valueOf(categoriaSeleccionada.getCosteAtleticas()),"0",tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),"0","0","0","0","0", tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Nadar",String.valueOf(categoriaSeleccionada.getCosteAtleticas()),"0",tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),"0","0","0","0","0", tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Trepar",String.valueOf(categoriaSeleccionada.getCosteAtleticas()),"0",tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),"0","0","0","0","0", tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Saltar",costeSaltar,"0",tableViewCaracteristicas.getItems().get(2).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoSaltar()),"0","0","0","0", tNivelTotal.getText()),
					
					new PdsHabilidadesSecundarias("Estilo",costeEstilo,"0",tableViewCaracteristicas.getItems().get(6).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoEstilo()),"0","0","0","0", tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Intimidar",costeIntimidar,"0",tableViewCaracteristicas.getItems().get(7).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoIntimidar()),"0","0","0","0", tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Liderazgo",costeLiderazgo,"0",tableViewCaracteristicas.getItems().get(6).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoLiderazgo()),"0","0","0","0", tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Persuasion",costePersuasion,"0",tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoPersuasion()),"0","0","0","0", tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Comercio",String.valueOf(categoriaSeleccionada.getCosteSociales()),"0",tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),"0","0","0","0","0", tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Callejeo",String.valueOf(categoriaSeleccionada.getCosteSociales()),"0",tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),"0","0","0","0","0", tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Etiqueta",String.valueOf(categoriaSeleccionada.getCosteSociales()),"0",tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),"0","0","0","0","0", tNivelTotal.getText()),
					
					new PdsHabilidadesSecundarias("Advertir",costeAdvertir,"0",tableViewCaracteristicas.getItems().get(5).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoAdvertir()),"0","0","0","0", tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Buscar",costeBuscar,"0",tableViewCaracteristicas.getItems().get(5).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoBuscar()),"0","0","0","0", tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Rastrear",costeRastrear,"0",tableViewCaracteristicas.getItems().get(5).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoRastrear()),"0","0","0","0", tNivelTotal.getText()),
					
					new PdsHabilidadesSecundarias("Animales",costeAnimales,"0",tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoAnimales()),"0","0","0","0", tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Ciencia",String.valueOf(categoriaSeleccionada.getCosteIntelectuales()),"0",tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),"0","0","0","0","0", tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Ley",String.valueOf(categoriaSeleccionada.getCosteIntelectuales()),"0",tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),"0","0","0","0","0", tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Herbolaria",costeHerbolaria,"0",tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoHerbolaria()),"0","0","0","0", tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Historia",String.valueOf(categoriaSeleccionada.getCosteIntelectuales()),"0",tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),"0","0","0","0","0", tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Tactica",String.valueOf(categoriaSeleccionada.getCosteIntelectuales()),"0",tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),"0","0","0","0","0", tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Medicina",String.valueOf(categoriaSeleccionada.getCosteIntelectuales()),"0",tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),"0","0","0","0","0", tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Memorizar",costeMemorizar,"0",tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),"0","0","0","0","0", tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Navegacion",String.valueOf(categoriaSeleccionada.getCosteIntelectuales()),"0",tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),"0","0","0","0","0", tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Ocultismo",costeOcultismo,"0",tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoOcultismo()),"0","0","0","0", tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Tasacion",costeTasacion,"0",tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),"0","0","0","0","0", tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("V.Magica",costeValoracionMagica,"0",tableViewCaracteristicas.getItems().get(6).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoValoracionMagica()),"0","0","0","0", tNivelTotal.getText()),
					
					new PdsHabilidadesSecundarias("Frialdad",costeFrialdad,"0",tableViewCaracteristicas.getItems().get(7).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoFrialdad()),"0","0","0","0", tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("P.Fuerza",costeProezaFuerza,"0",tableViewCaracteristicas.getItems().get(2).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoProezaFuerza()),"0","0","0","0", tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Res.Dolor",costeResistirDolor,"0",tableViewCaracteristicas.getItems().get(7).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoResistirDolor()),"0","0","0","0", tNivelTotal.getText()),
					
					new PdsHabilidadesSecundarias("Cerrajeria",String.valueOf(categoriaSeleccionada.getCosteSubterfugio()),"0",tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),"0","0","0","0","0", tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Disfraz",costeDisfraz,"0",tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoDisfraz()),"0","0","0","0", tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Ocultarse",costeOcultarse,"0",tableViewCaracteristicas.getItems().get(5).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoOcultarse()),"0","0","0","0", tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Robo",costeRobo,"0",tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoRobo()),"0","0","0","0", tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Sigilo",costeSigilo,"0",tableViewCaracteristicas.getItems().get(0).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoSigilo()),"0","0","0","0", tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Tramperia",costeTramperia,"0",tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoTramperia()),"0","0","0","0", tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Venenos",costeVeneno,"0",tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoVeneno()),"0","0","0","0", tNivelTotal.getText()),
					
					new PdsHabilidadesSecundarias("Arte",String.valueOf(categoriaSeleccionada.getCosteCreativas()),"0",tableViewCaracteristicas.getItems().get(6).getBonoCaracteristica(),"0","0","0","0","0", tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Baile",String.valueOf(categoriaSeleccionada.getCosteCreativas()),"0",tableViewCaracteristicas.getItems().get(1).getBonoCaracteristica(),"0","0","0","0","0", tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Forja",String.valueOf(categoriaSeleccionada.getCosteCreativas()),"0",tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),"0","0","0","0","0", tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Runas",String.valueOf(categoriaSeleccionada.getCosteCreativas()),"0",tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),"0","0","0","0","0", tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Alquimia",String.valueOf(categoriaSeleccionada.getCosteCreativas()),"0",tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),"0","0","0","0","0", tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Animismo",String.valueOf(categoriaSeleccionada.getCosteCreativas()),"0",tableViewCaracteristicas.getItems().get(6).getBonoCaracteristica(),"0","0","0","0","0", tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Musica",String.valueOf(categoriaSeleccionada.getCosteCreativas()),"0",tableViewCaracteristicas.getItems().get(6).getBonoCaracteristica(),"0","0","0","0","0", tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("T.Manos",costeTrucoManos,"0",tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoTrucoManos()),"0","0","0","0", tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Caligrafia Ritual",String.valueOf(categoriaSeleccionada.getCosteCreativas()),"0",tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),"0","0","0","0","0", tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Orfebreria",String.valueOf(categoriaSeleccionada.getCosteCreativas()),"0",tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),"0","0","0","0","0", tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Confeccion",String.valueOf(categoriaSeleccionada.getCosteCreativas()),"0",tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),"0","0","0","0","0", tNivelTotal.getText()));
			
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
		} else {
			ObservableList<PdsHabilidadesSecundarias> pdsInvertidosSecundarias = FXCollections.observableArrayList(
					new PdsHabilidadesSecundarias("Acrobacias",costeAcrobacias,String.valueOf(personaje.getPdsSecundariasAtleticas().getPdsAcrobacias()),tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoAcrobacias()),String.valueOf(personaje.getPdsSecundariasAtleticas().getPdsEspAcrobacias()),String.valueOf(personaje.getPdsSecundariasAtleticas().getBonoNaturalAcrobacias()),String.valueOf(personaje.getPdsSecundariasAtleticas().getHabNaturalAcrobacias()),String.valueOf(personaje.getPdsSecundariasAtleticas().getBonoNovelAcrobacias()), tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Atletismo",costeAtletismo,String.valueOf(personaje.getPdsSecundariasAtleticas().getPdsAtletismo()),tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoAtletismo()),String.valueOf(personaje.getPdsSecundariasAtleticas().getPdsEspAtletismo()),String.valueOf(personaje.getPdsSecundariasAtleticas().getBonoNaturalAtletismo()),String.valueOf(personaje.getPdsSecundariasAtleticas().getHabNaturalAtletismo()),String.valueOf(personaje.getPdsSecundariasAtleticas().getBonoNovelAtletismo()), tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Montar",String.valueOf(categoriaSeleccionada.getCosteAtleticas()),String.valueOf(personaje.getPdsSecundariasAtleticas().getPdsMontar()),tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),"0",String.valueOf(personaje.getPdsSecundariasAtleticas().getPdsEspMontar()),String.valueOf(personaje.getPdsSecundariasAtleticas().getBonoNaturalMontar()),String.valueOf(personaje.getPdsSecundariasAtleticas().getHabNaturalMontar()),String.valueOf(personaje.getPdsSecundariasAtleticas().getBonoNovelMontar()), tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Nadar",String.valueOf(categoriaSeleccionada.getCosteAtleticas()),String.valueOf(personaje.getPdsSecundariasAtleticas().getPdsNadar()),tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),"0",String.valueOf(personaje.getPdsSecundariasAtleticas().getPdsEspNadar()),String.valueOf(personaje.getPdsSecundariasAtleticas().getBonoNaturalNadar()),String.valueOf(personaje.getPdsSecundariasAtleticas().getHabNaturalNadar()),String.valueOf(personaje.getPdsSecundariasAtleticas().getBonoNovelNadar()), tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Trepar",String.valueOf(categoriaSeleccionada.getCosteAtleticas()),String.valueOf(personaje.getPdsSecundariasAtleticas().getPdsTrepar()),tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),"0",String.valueOf(personaje.getPdsSecundariasAtleticas().getPdsEspTrepar()),String.valueOf(personaje.getPdsSecundariasAtleticas().getBonoNaturalTrepar()),String.valueOf(personaje.getPdsSecundariasAtleticas().getHabNaturalTrepar()),String.valueOf(personaje.getPdsSecundariasAtleticas().getBonoNovelTrepar()), tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Saltar",costeSaltar,String.valueOf(personaje.getPdsSecundariasAtleticas().getPdsSaltar()),tableViewCaracteristicas.getItems().get(2).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoSaltar()),String.valueOf(personaje.getPdsSecundariasAtleticas().getPdsEspSaltar()),String.valueOf(personaje.getPdsSecundariasAtleticas().getBonoNaturalSaltar()),String.valueOf(personaje.getPdsSecundariasAtleticas().getHabNaturalSaltar()),String.valueOf(personaje.getPdsSecundariasAtleticas().getBonoNovelSaltar()), tNivelTotal.getText()),
					
					new PdsHabilidadesSecundarias("Estilo",costeEstilo,String.valueOf(personaje.getPdsSecundariasSociales().getPdsEstilo()),tableViewCaracteristicas.getItems().get(6).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoEstilo()),String.valueOf(personaje.getPdsSecundariasSociales().getPdsEspEstilo()),String.valueOf(personaje.getPdsSecundariasSociales().getBonoNaturalEstilo()),String.valueOf(personaje.getPdsSecundariasSociales().getHabNaturalEstilo()),String.valueOf(personaje.getPdsSecundariasSociales().getBonoNovelEstilo()), tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Intimidar",costeIntimidar,String.valueOf(personaje.getPdsSecundariasSociales().getPdsIntimidar()),tableViewCaracteristicas.getItems().get(7).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoIntimidar()),String.valueOf(personaje.getPdsSecundariasSociales().getPdsEspIntimidar()),String.valueOf(personaje.getPdsSecundariasSociales().getBonoNaturalIntimidar()),String.valueOf(personaje.getPdsSecundariasSociales().getHabNaturalIntimidar()),String.valueOf(personaje.getPdsSecundariasSociales().getBonoNovelIntimidar()), tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Liderazgo",costeLiderazgo,String.valueOf(personaje.getPdsSecundariasSociales().getPdsLiderazgo()),tableViewCaracteristicas.getItems().get(6).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoLiderazgo()),String.valueOf(personaje.getPdsSecundariasSociales().getPdsEspLiderazgo()),String.valueOf(personaje.getPdsSecundariasSociales().getBonoNaturalLiderazgo()),String.valueOf(personaje.getPdsSecundariasSociales().getHabNaturalLiderazgo()),String.valueOf(personaje.getPdsSecundariasSociales().getBonoNovelLiderazgo()), tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Persuasion",costePersuasion,String.valueOf(personaje.getPdsSecundariasSociales().getPdsPersuasion()),tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoPersuasion()),String.valueOf(personaje.getPdsSecundariasSociales().getPdsEspPersuasion()),String.valueOf(personaje.getPdsSecundariasSociales().getBonoNaturalPersuasion()),String.valueOf(personaje.getPdsSecundariasSociales().getHabNaturalPersuasion()),String.valueOf(personaje.getPdsSecundariasSociales().getBonoNovelPersuasion()), tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Comercio",String.valueOf(categoriaSeleccionada.getCosteSociales()),String.valueOf(personaje.getPdsSecundariasSociales().getPdsComercio()),tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),"0",String.valueOf(personaje.getPdsSecundariasSociales().getPdsEspComercio()),String.valueOf(personaje.getPdsSecundariasSociales().getBonoNaturalComercio()),String.valueOf(personaje.getPdsSecundariasSociales().getHabNaturalComercio()),String.valueOf(personaje.getPdsSecundariasSociales().getBonoNovelComercio()), tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Callejeo",String.valueOf(categoriaSeleccionada.getCosteSociales()),String.valueOf(personaje.getPdsSecundariasSociales().getPdsCallejeo()),tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),"0",String.valueOf(personaje.getPdsSecundariasSociales().getPdsEspCallejeo()),String.valueOf(personaje.getPdsSecundariasSociales().getBonoNaturalCallejeo()),String.valueOf(personaje.getPdsSecundariasSociales().getHabNaturalCallejeo()),String.valueOf(personaje.getPdsSecundariasSociales().getBonoNovelCallejeo()), tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Etiqueta",String.valueOf(categoriaSeleccionada.getCosteSociales()),String.valueOf(personaje.getPdsSecundariasSociales().getPdsEtiqueta()),tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),"0",String.valueOf(personaje.getPdsSecundariasSociales().getPdsEspEtiqueta()),String.valueOf(personaje.getPdsSecundariasSociales().getBonoNaturalEtiqueta()),String.valueOf(personaje.getPdsSecundariasSociales().getHabNaturalEtiqueta()),String.valueOf(personaje.getPdsSecundariasSociales().getBonoNovelEtiqueta()), tNivelTotal.getText()),
					
					new PdsHabilidadesSecundarias("Advertir",costeAdvertir,String.valueOf(personaje.getPdsSecundariasPerceptivas().getPdsAdvertir()),tableViewCaracteristicas.getItems().get(5).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoAdvertir()),String.valueOf(personaje.getPdsSecundariasPerceptivas().getPdsEspAdvertir()),String.valueOf(personaje.getPdsSecundariasPerceptivas().getBonoNaturalAdvertir()),String.valueOf(personaje.getPdsSecundariasPerceptivas().getHabNaturalAdvertir()),String.valueOf(personaje.getPdsSecundariasPerceptivas().getBonoNovelAdvertir()), tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Buscar",costeBuscar,String.valueOf(personaje.getPdsSecundariasPerceptivas().getPdsBuscar()),tableViewCaracteristicas.getItems().get(5).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoBuscar()),String.valueOf(personaje.getPdsSecundariasPerceptivas().getPdsEspBuscar()),String.valueOf(personaje.getPdsSecundariasPerceptivas().getBonoNaturalBuscar()),String.valueOf(personaje.getPdsSecundariasPerceptivas().getHabNaturalBuscar()),String.valueOf(personaje.getPdsSecundariasPerceptivas().getBonoNovelBuscar()), tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Rastrear",costeRastrear,String.valueOf(personaje.getPdsSecundariasPerceptivas().getPdsRastrear()),tableViewCaracteristicas.getItems().get(5).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoRastrear()),String.valueOf(personaje.getPdsSecundariasPerceptivas().getPdsEspRastrear()),String.valueOf(personaje.getPdsSecundariasPerceptivas().getBonoNaturalRastrear()),String.valueOf(personaje.getPdsSecundariasPerceptivas().getHabNaturalRastrear()),String.valueOf(personaje.getPdsSecundariasPerceptivas().getBonoNovelRastrear()), tNivelTotal.getText()),
					
					new PdsHabilidadesSecundarias("Animales",costeAnimales,String.valueOf(personaje.getPdsSecundariasIntelectuales().getPdsAnimales()),tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoAnimales()),String.valueOf(personaje.getPdsSecundariasIntelectuales().getPdsEspAnimales()),String.valueOf(personaje.getPdsSecundariasIntelectuales().getBonoNaturalAnimales()),String.valueOf(personaje.getPdsSecundariasIntelectuales().getHabNaturalAnimales()),String.valueOf(personaje.getPdsSecundariasIntelectuales().getBonoNovelAnimales()), tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Ciencia",String.valueOf(categoriaSeleccionada.getCosteIntelectuales()),String.valueOf(personaje.getPdsSecundariasIntelectuales().getPdsCiencia()),tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),"0",String.valueOf(personaje.getPdsSecundariasIntelectuales().getPdsEspCiencia()),String.valueOf(personaje.getPdsSecundariasIntelectuales().getBonoNaturalCiencia()),String.valueOf(personaje.getPdsSecundariasIntelectuales().getHabNaturalCiencia()),String.valueOf(personaje.getPdsSecundariasIntelectuales().getBonoNovelCiencia()), tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Ley",String.valueOf(categoriaSeleccionada.getCosteIntelectuales()),String.valueOf(personaje.getPdsSecundariasIntelectuales().getPdsLey()),tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),"0",String.valueOf(personaje.getPdsSecundariasIntelectuales().getPdsEspLey()),String.valueOf(personaje.getPdsSecundariasIntelectuales().getBonoNaturalLey()),String.valueOf(personaje.getPdsSecundariasIntelectuales().getHabNaturalLey()),String.valueOf(personaje.getPdsSecundariasIntelectuales().getBonoNovelLey()), tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Herbolaria",costeHerbolaria,String.valueOf(personaje.getPdsSecundariasIntelectuales().getPdsHerbolaria()),tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoHerbolaria()),String.valueOf(personaje.getPdsSecundariasIntelectuales().getPdsEspHerbolaria()),String.valueOf(personaje.getPdsSecundariasIntelectuales().getBonoNaturalHerbolaria()),String.valueOf(personaje.getPdsSecundariasIntelectuales().getHabNaturalHerbolaria()),String.valueOf(personaje.getPdsSecundariasIntelectuales().getBonoNovelHerbolaria()), tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Historia",String.valueOf(categoriaSeleccionada.getCosteIntelectuales()),String.valueOf(personaje.getPdsSecundariasIntelectuales().getPdsHistoria()),tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),"0",String.valueOf(personaje.getPdsSecundariasIntelectuales().getPdsEspHistoria()),String.valueOf(personaje.getPdsSecundariasIntelectuales().getBonoNaturalHistoria()),String.valueOf(personaje.getPdsSecundariasIntelectuales().getHabNaturalHistoria()),String.valueOf(personaje.getPdsSecundariasIntelectuales().getBonoNovelHistoria()), tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Tactica",String.valueOf(categoriaSeleccionada.getCosteIntelectuales()),String.valueOf(personaje.getPdsSecundariasIntelectuales().getPdsTactica()),tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),"0",String.valueOf(personaje.getPdsSecundariasIntelectuales().getPdsEspTactica()),String.valueOf(personaje.getPdsSecundariasIntelectuales().getBonoNaturalTactica()),String.valueOf(personaje.getPdsSecundariasIntelectuales().getHabNaturalTactica()),String.valueOf(personaje.getPdsSecundariasIntelectuales().getBonoNovelTactica()), tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Medicina",String.valueOf(categoriaSeleccionada.getCosteIntelectuales()),String.valueOf(personaje.getPdsSecundariasIntelectuales().getPdsMedicina()),tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),"0",String.valueOf(personaje.getPdsSecundariasIntelectuales().getPdsEspMedicina()),String.valueOf(personaje.getPdsSecundariasIntelectuales().getBonoNaturalMedicina()),String.valueOf(personaje.getPdsSecundariasIntelectuales().getHabNaturalMedicina()),String.valueOf(personaje.getPdsSecundariasIntelectuales().getBonoNovelMedicina()), tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Memorizar",costeMemorizar,String.valueOf(personaje.getPdsSecundariasIntelectuales().getPdsMemorizar()),tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),"0",String.valueOf(personaje.getPdsSecundariasIntelectuales().getPdsEspMemorizar()),String.valueOf(personaje.getPdsSecundariasIntelectuales().getBonoNaturalMemorizar()),String.valueOf(personaje.getPdsSecundariasIntelectuales().getHabNaturalMemorizar()),String.valueOf(personaje.getPdsSecundariasIntelectuales().getBonoNovelMemorizar()), tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Navegacion",String.valueOf(categoriaSeleccionada.getCosteIntelectuales()),String.valueOf(personaje.getPdsSecundariasIntelectuales().getPdsNavegacion()),tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),"0",String.valueOf(personaje.getPdsSecundariasIntelectuales().getPdsEspNavegacion()),String.valueOf(personaje.getPdsSecundariasIntelectuales().getBonoNaturalNavegacion()),String.valueOf(personaje.getPdsSecundariasIntelectuales().getHabNaturalNavegacion()),String.valueOf(personaje.getPdsSecundariasIntelectuales().getBonoNovelNavegacion()), tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Ocultismo",costeOcultismo,String.valueOf(personaje.getPdsSecundariasIntelectuales().getPdsOcultismo()),tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoOcultismo()),String.valueOf(personaje.getPdsSecundariasIntelectuales().getPdsEspOcultismo()),String.valueOf(personaje.getPdsSecundariasIntelectuales().getBonoNaturalOcultismo()),String.valueOf(personaje.getPdsSecundariasIntelectuales().getHabNaturalOcultismo()),String.valueOf(personaje.getPdsSecundariasIntelectuales().getBonoNovelOcultismo()), tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Tasacion",costeTasacion,String.valueOf(personaje.getPdsSecundariasIntelectuales().getPdsTasacion()),tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),"0",String.valueOf(personaje.getPdsSecundariasIntelectuales().getPdsEspTasacion()),String.valueOf(personaje.getPdsSecundariasIntelectuales().getBonoNaturalTasacion()),String.valueOf(personaje.getPdsSecundariasIntelectuales().getHabNaturalTasacion()),String.valueOf(personaje.getPdsSecundariasIntelectuales().getBonoNovelTasacion()), tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("V.Magica",costeValoracionMagica,String.valueOf(personaje.getPdsSecundariasIntelectuales().getPdsValoracionMagica()),tableViewCaracteristicas.getItems().get(6).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoValoracionMagica()),String.valueOf(personaje.getPdsSecundariasIntelectuales().getPdsEspValoracionMagica()),String.valueOf(personaje.getPdsSecundariasIntelectuales().getBonoNaturalValoracionMagica()),String.valueOf(personaje.getPdsSecundariasIntelectuales().getHabNaturalValoracionMagica()),String.valueOf(personaje.getPdsSecundariasIntelectuales().getBonoNovelValoracionMagica()), tNivelTotal.getText()),
					
					new PdsHabilidadesSecundarias("Frialdad",costeFrialdad,String.valueOf(personaje.getPdsSecundariasVigor().getPdsFrialdad()),tableViewCaracteristicas.getItems().get(7).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoFrialdad()),String.valueOf(personaje.getPdsSecundariasVigor().getPdsEspFrialdad()),String.valueOf(personaje.getPdsSecundariasVigor().getBonoNaturalFrialdad()),String.valueOf(personaje.getPdsSecundariasVigor().getHabNaturalFrialdad()),String.valueOf(personaje.getPdsSecundariasVigor().getBonoNovelFrialdad()), tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("P.Fuerza",costeProezaFuerza,String.valueOf(personaje.getPdsSecundariasVigor().getPdsProezaFuerza()),tableViewCaracteristicas.getItems().get(2).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoProezaFuerza()),String.valueOf(personaje.getPdsSecundariasVigor().getPdsEspProezaFuerza()),String.valueOf(personaje.getPdsSecundariasVigor().getBonoNaturalProezaFuerza()),String.valueOf(personaje.getPdsSecundariasVigor().getHabNaturalProezaFuerza()),String.valueOf(personaje.getPdsSecundariasVigor().getBonoNovelProezaFuerza()), tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Res.Dolor",costeResistirDolor,String.valueOf(personaje.getPdsSecundariasVigor().getPdsResistirDolor()),tableViewCaracteristicas.getItems().get(7).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoResistirDolor()),String.valueOf(personaje.getPdsSecundariasVigor().getPdsEspResistirDolor()),String.valueOf(personaje.getPdsSecundariasVigor().getBonoNaturalResistirDolor()),String.valueOf(personaje.getPdsSecundariasVigor().getHabNaturalResistirDolor()),String.valueOf(personaje.getPdsSecundariasVigor().getBonoNovelResistirDolor()), tNivelTotal.getText()),
					
					new PdsHabilidadesSecundarias("Cerrajeria",String.valueOf(categoriaSeleccionada.getCosteSubterfugio()),String.valueOf(personaje.getPdsSecundariasSubterfugio().getPdsCerrajeria()),tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),"0",String.valueOf(personaje.getPdsSecundariasSubterfugio().getPdsEspCerrajeria()),String.valueOf(personaje.getPdsSecundariasSubterfugio().getBonoNaturalCerrajeria()),String.valueOf(personaje.getPdsSecundariasSubterfugio().getHabNaturalCerrajeria()),String.valueOf(personaje.getPdsSecundariasSubterfugio().getBonoNovelCerrajeria()), tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Disfraz",costeDisfraz,String.valueOf(personaje.getPdsSecundariasSubterfugio().getPdsDisfraz()),tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoDisfraz()), String.valueOf(personaje.getPdsSecundariasSubterfugio().getPdsEspDisfraz()),String.valueOf(personaje.getPdsSecundariasSubterfugio().getBonoNaturalDisfraz()),String.valueOf(personaje.getPdsSecundariasSubterfugio().getHabNaturalDisfraz()),String.valueOf(personaje.getPdsSecundariasSubterfugio().getBonoNovelDisfraz()), tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Ocultarse",costeOcultarse,String.valueOf(personaje.getPdsSecundariasSubterfugio().getPdsOcultarse()),tableViewCaracteristicas.getItems().get(5).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoOcultarse()), String.valueOf(personaje.getPdsSecundariasSubterfugio().getPdsEspOcultarse()),String.valueOf(personaje.getPdsSecundariasSubterfugio().getBonoNaturalOcultarse()),String.valueOf(personaje.getPdsSecundariasSubterfugio().getHabNaturalOcultarse()),String.valueOf(personaje.getPdsSecundariasSubterfugio().getBonoNovelOcultarse()), tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Robo",costeRobo,String.valueOf(personaje.getPdsSecundariasSubterfugio().getPdsRobo()),tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoRobo()),String.valueOf(personaje.getPdsSecundariasSubterfugio().getPdsEspRobo()),String.valueOf(personaje.getPdsSecundariasSubterfugio().getBonoNaturalRobo()),String.valueOf(personaje.getPdsSecundariasSubterfugio().getHabNaturalRobo()),String.valueOf(personaje.getPdsSecundariasSubterfugio().getBonoNovelRobo()), tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Sigilo",costeSigilo,String.valueOf(personaje.getPdsSecundariasSubterfugio().getPdsSigilo()),tableViewCaracteristicas.getItems().get(0).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoSigilo()),String.valueOf(personaje.getPdsSecundariasSubterfugio().getPdsEspSigilo()),String.valueOf(personaje.getPdsSecundariasSubterfugio().getBonoNaturalSigilo()),String.valueOf(personaje.getPdsSecundariasSubterfugio().getHabNaturalSigilo()),String.valueOf(personaje.getPdsSecundariasSubterfugio().getBonoNovelSigilo()), tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Tramperia",costeTramperia,String.valueOf(personaje.getPdsSecundariasSubterfugio().getPdsTramperia()),tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoTramperia()),String.valueOf(personaje.getPdsSecundariasSubterfugio().getPdsEspTramperia()),String.valueOf(personaje.getPdsSecundariasSubterfugio().getBonoNaturalTramperia()),String.valueOf(personaje.getPdsSecundariasSubterfugio().getHabNaturalTramperia()),String.valueOf(personaje.getPdsSecundariasSubterfugio().getBonoNovelTramperia()), tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Venenos",costeVeneno,String.valueOf(personaje.getPdsSecundariasSubterfugio().getPdsVenenos()),tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoVeneno()),String.valueOf(personaje.getPdsSecundariasSubterfugio().getPdsEspVenenos()),String.valueOf(personaje.getPdsSecundariasSubterfugio().getBonoNaturalVenenos()),String.valueOf(personaje.getPdsSecundariasSubterfugio().getHabNaturalVenenos()),String.valueOf(personaje.getPdsSecundariasSubterfugio().getBonoNovelVenenos()), tNivelTotal.getText()),
					
					new PdsHabilidadesSecundarias("Arte",String.valueOf(categoriaSeleccionada.getCosteCreativas()),String.valueOf(personaje.getPdsSecundariasCreativas().getPdsArte()),tableViewCaracteristicas.getItems().get(6).getBonoCaracteristica(),"0","0",String.valueOf(personaje.getPdsSecundariasCreativas().getBonoNaturalAlquimia()),String.valueOf(personaje.getPdsSecundariasCreativas().getHabNaturalAlquimia()),String.valueOf(personaje.getPdsSecundariasCreativas().getBonoNovelArte()), tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Baile",String.valueOf(categoriaSeleccionada.getCosteCreativas()),String.valueOf(personaje.getPdsSecundariasCreativas().getPdsBaile()),tableViewCaracteristicas.getItems().get(1).getBonoCaracteristica(),"0","0",String.valueOf(personaje.getPdsSecundariasCreativas().getBonoNaturalBaile()),String.valueOf(personaje.getPdsSecundariasCreativas().getHabNaturalBaile()),String.valueOf(personaje.getPdsSecundariasCreativas().getBonoNovelBaile()), tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Forja",String.valueOf(categoriaSeleccionada.getCosteCreativas()),String.valueOf(personaje.getPdsSecundariasCreativas().getPdsForja()),tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),"0","0",String.valueOf(personaje.getPdsSecundariasCreativas().getBonoNaturalForja()),String.valueOf(personaje.getPdsSecundariasCreativas().getHabNaturalForja()),String.valueOf(personaje.getPdsSecundariasCreativas().getBonoNovelForja()), tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Runas",String.valueOf(categoriaSeleccionada.getCosteCreativas()),String.valueOf(personaje.getPdsSecundariasCreativas().getPdsRunas()),tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),"0","0",String.valueOf(personaje.getPdsSecundariasCreativas().getBonoNaturalRunas()),String.valueOf(personaje.getPdsSecundariasCreativas().getHabNaturalRunas()),String.valueOf(personaje.getPdsSecundariasCreativas().getBonoNovelRunas()), tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Alquimia",String.valueOf(categoriaSeleccionada.getCosteCreativas()),String.valueOf(personaje.getPdsSecundariasCreativas().getPdsAlquimia()),tableViewCaracteristicas.getItems().get(4).getBonoCaracteristica(),"0","0",String.valueOf(personaje.getPdsSecundariasCreativas().getBonoNaturalAlquimia()),String.valueOf(personaje.getPdsSecundariasCreativas().getHabNaturalAlquimia()),String.valueOf(personaje.getPdsSecundariasCreativas().getBonoNovelAlquimia()), tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Animismo",String.valueOf(categoriaSeleccionada.getCosteCreativas()),String.valueOf(personaje.getPdsSecundariasCreativas().getPdsAnimismo()),tableViewCaracteristicas.getItems().get(6).getBonoCaracteristica(),"0","0",String.valueOf(personaje.getPdsSecundariasCreativas().getBonoNaturalAnimismo()),String.valueOf(personaje.getPdsSecundariasCreativas().getHabNaturalAnimismo()),String.valueOf(personaje.getPdsSecundariasCreativas().getBonoNovelAnimismo()), tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Musica",String.valueOf(categoriaSeleccionada.getCosteCreativas()),String.valueOf(personaje.getPdsSecundariasCreativas().getPdsMusica()),tableViewCaracteristicas.getItems().get(6).getBonoCaracteristica(),"0","0",String.valueOf(personaje.getPdsSecundariasCreativas().getBonoNaturalMusica()),String.valueOf(personaje.getPdsSecundariasCreativas().getHabNaturalMusica()),String.valueOf(personaje.getPdsSecundariasCreativas().getBonoNovelMusica()), tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("T.Manos",costeTrucoManos,String.valueOf(personaje.getPdsSecundariasCreativas().getPdsTrucoManos()),tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),String.valueOf(categoriaSeleccionada.getBonoTrucoManos()),"0",String.valueOf(personaje.getPdsSecundariasCreativas().getBonoNaturalTrucoManos()),String.valueOf(personaje.getPdsSecundariasCreativas().getHabNaturalTrucoManos()),String.valueOf(personaje.getPdsSecundariasCreativas().getBonoNovelTrucoManos()), tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Caligrafia Ritual",String.valueOf(categoriaSeleccionada.getCosteCreativas()),String.valueOf(personaje.getPdsSecundariasCreativas().getPdsCaligrafiaRitual()),tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),"0","0",String.valueOf(personaje.getPdsSecundariasCreativas().getBonoNaturalCaligrafiaRitual()),String.valueOf(personaje.getPdsSecundariasCreativas().getHabNaturalCaligrafiaRitual()),String.valueOf(personaje.getPdsSecundariasCreativas().getBonoNovelCaligrafiaRitual()), tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Orfebreria",String.valueOf(categoriaSeleccionada.getCosteCreativas()),String.valueOf(personaje.getPdsSecundariasCreativas().getPdsOrfebreria()),tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),"0","0",String.valueOf(personaje.getPdsSecundariasCreativas().getBonoNaturalOrfebreria()),String.valueOf(personaje.getPdsSecundariasCreativas().getHabNaturalOrfebreria()),String.valueOf(personaje.getPdsSecundariasCreativas().getBonoNovelOrfebreria()), tNivelTotal.getText()),
					new PdsHabilidadesSecundarias("Confeccion",String.valueOf(categoriaSeleccionada.getCosteCreativas()),String.valueOf(personaje.getPdsSecundariasCreativas().getPdsConfeccion()),tableViewCaracteristicas.getItems().get(3).getBonoCaracteristica(),"0","0",String.valueOf(personaje.getPdsSecundariasCreativas().getBonoNaturalConfeccion()),String.valueOf(personaje.getPdsSecundariasCreativas().getHabNaturalConfeccion()),String.valueOf(personaje.getPdsSecundariasCreativas().getBonoNovelConfeccion()), tNivelTotal.getText()));
			
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
		}
		
	}
	
	public void obtenerTablaResumenAtleticas() {
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
	}
	
	public void obtenerTablaResumenSociales(){
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
	}
	
	public void obtenerTablaResumenPerceptivas(){
		ObservableList<PdsHabilidadesSecundariasResumen> resumenSecundarias3 = FXCollections.observableArrayList(
				new PdsHabilidadesSecundariasResumen("Advertir","0",tableViewSecundarias.getItems().get(13).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("Buscar","0",tableViewSecundarias.getItems().get(14).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("Rastrear","0",tableViewSecundarias.getItems().get(15).getTotalHabilidad()));
		
		colNombreSecundariaPerceptivas.setCellValueFactory(new PropertyValueFactory<PdsHabilidadesSecundariasResumen, String>("nombreHabilidad"));
		colPenalizadorSecundariaPerceptivas.setCellValueFactory(new PropertyValueFactory<PdsHabilidadesSecundariasResumen, String>("penalizadorNaturalHabilidad"));
		colTotalSecundariaPerceptivas.setCellValueFactory(new PropertyValueFactory<PdsHabilidadesSecundariasResumen, String>("totalHabilidad"));
		
		tableViewResumenPerceptivas.setItems(resumenSecundarias3);
	}
	
	public void obtenerTablaResumenIntelectuales(){
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
	}
	
	public void obtenerTablaResumenSubterfugio() {
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
	}
	
	public void obtenerTablaResumenVigor(){
		ObservableList<PdsHabilidadesSecundariasResumen> resumenSecundarias5 = FXCollections.observableArrayList(
				new PdsHabilidadesSecundariasResumen("Frialdad","0",tableViewSecundarias.getItems().get(28).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("P.Fuerza","0",tableViewSecundarias.getItems().get(29).getTotalHabilidad()),
				new PdsHabilidadesSecundariasResumen("R.Dolor","0",tableViewSecundarias.getItems().get(30).getTotalHabilidad()));
		
		
		colNombreSecundariaVigor.setCellValueFactory(new PropertyValueFactory<PdsHabilidadesSecundariasResumen, String>("nombreHabilidad"));
		colPenalizadorSecundariaVigor.setCellValueFactory(new PropertyValueFactory<PdsHabilidadesSecundariasResumen, String>("penalizadorNaturalHabilidad"));
		colTotalSecundariaVigor.setCellValueFactory(new PropertyValueFactory<PdsHabilidadesSecundariasResumen, String>("totalHabilidad"));
		
		tableViewResumenVigor.setItems(resumenSecundarias5);
	}
	
	public void obtenerTablaResumenCreativas(){
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
	}
	
	public void obtenerTablaArma(ObservableList<String> nombreArmas ) {
		valorTextFieldTurnoTotal();
				
		ArrayList<String> nombreSetArmas = new ArrayList<String>();
		for (Arma arma : personaje.getArmas()) {
			nombreSetArmas.add(arma.getNombre());
		}
		
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
			tRasgoArma1.setText(armaSeleccionada1.get(0).getRasgo());
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
		

		
		if (0 < nombreSetArmas.size()) {
			if (nombreSetArmas.get(0)!=null) {
				cBoxNombreArma1.setValue(nombreSetArmas.get(0));
				/*armaSeleccionada1.get(0).setArmaSeleccionada(ch.obtenerArma(sessionFactory, cBoxNombreArma1.getSelectionModel().getSelectedItem()), tableViewCombate.getItems().get(0).getTotalHabilidad(), tableViewCaracteristicas.getItems().get(2).getBonoCaracteristica(), String.valueOf(Integer.parseInt(tTurnoTotal.getText())-Integer.parseInt("20")));*/
				tableviewArmaSeleccionada1.getItems().get(0).setArmaSeleccionada(ch.obtenerArma(sessionFactory, cBoxNombreArma1.getSelectionModel().getSelectedItem()), 
						tableViewCombate.getItems().get(0).getTotalHabilidad(), 
						tableViewCaracteristicas.getItems().get(2).getBonoCaracteristica(),
						String.valueOf(Integer.parseInt(tTurnoTotal.getText())-Integer.parseInt("20")));
				tTipoArma1.setText(tableviewArmaSeleccionada1.getItems().get(0).getTipoArma());
				tRasgoArma1.setText(tableviewArmaSeleccionada1.getItems().get(0).getRasgo());
				tableviewArmaSeleccionada1.refresh();
			}
		}

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
			tRasgoArma2.setText(armaSeleccionada2.get(0).getRasgo());
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
		

		
		if (1 < nombreSetArmas.size()) {
			if (nombreSetArmas.get(1)!=null) {
				cBoxNombreArma2.setValue(nombreSetArmas.get(1));
				/*armaSeleccionada1.get(0).setArmaSeleccionada(ch.obtenerArma(sessionFactory, cBoxNombreArma1.getSelectionModel().getSelectedItem()), tableViewCombate.getItems().get(0).getTotalHabilidad(), tableViewCaracteristicas.getItems().get(2).getBonoCaracteristica(), String.valueOf(Integer.parseInt(tTurnoTotal.getText())-Integer.parseInt("20")));*/
				tableviewArmaSeleccionada2.getItems().get(0).setArmaSeleccionada(ch.obtenerArma(sessionFactory, cBoxNombreArma2.getSelectionModel().getSelectedItem()), 
						tableViewCombate.getItems().get(0).getTotalHabilidad(), 
						tableViewCaracteristicas.getItems().get(2).getBonoCaracteristica(),
						String.valueOf(Integer.parseInt(tTurnoTotal.getText())-Integer.parseInt("20")));
				tTipoArma2.setText(tableviewArmaSeleccionada2.getItems().get(0).getTipoArma());
				tRasgoArma2.setText(tableviewArmaSeleccionada2.getItems().get(0).getRasgo());
				tableviewArmaSeleccionada2.refresh();
			}
		}
		
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
			tTipoArma3.setText(armaSeleccionada3.get(0).getTipoArma());
			tRasgoArma3.setText(armaSeleccionada3.get(0).getRasgo());
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

		
		if (2 < nombreSetArmas.size()) {
			if (nombreSetArmas.get(2)!=null) {
				cBoxNombreArma3.setValue(nombreSetArmas.get(2));
				/*armaSeleccionada1.get(0).setArmaSeleccionada(ch.obtenerArma(sessionFactory, cBoxNombreArma1.getSelectionModel().getSelectedItem()), tableViewCombate.getItems().get(0).getTotalHabilidad(), tableViewCaracteristicas.getItems().get(2).getBonoCaracteristica(), String.valueOf(Integer.parseInt(tTurnoTotal.getText())-Integer.parseInt("20")));*/
				tableviewArmaSeleccionada2.getItems().get(0).setArmaSeleccionada(ch.obtenerArma(sessionFactory, cBoxNombreArma3.getSelectionModel().getSelectedItem()), 
						tableViewCombate.getItems().get(0).getTotalHabilidad(), 
						tableViewCaracteristicas.getItems().get(2).getBonoCaracteristica(),
						String.valueOf(Integer.parseInt(tTurnoTotal.getText())-Integer.parseInt("20")));
				tTipoArma3.setText(tableviewArmaSeleccionada2.getItems().get(0).getTipoArma());
				tRasgoArma3.setText(tableviewArmaSeleccionada2.getItems().get(0).getRasgo());
				tableviewArmaSeleccionada3.refresh();
			}
		}

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
			tRasgoArma4.setText(armaSeleccionada4.get(0).getRasgo());
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
		
		if (3 < nombreSetArmas.size()) {
			if (nombreSetArmas.get(3)!=null) {
				cBoxNombreArma4.setValue(nombreSetArmas.get(3));
				/*armaSeleccionada1.get(0).setArmaSeleccionada(ch.obtenerArma(sessionFactory, cBoxNombreArma1.getSelectionModel().getSelectedItem()), tableViewCombate.getItems().get(0).getTotalHabilidad(), tableViewCaracteristicas.getItems().get(2).getBonoCaracteristica(), String.valueOf(Integer.parseInt(tTurnoTotal.getText())-Integer.parseInt("20")));*/
				tableviewArmaSeleccionada4.getItems().get(0).setArmaSeleccionada(ch.obtenerArma(sessionFactory, cBoxNombreArma4.getSelectionModel().getSelectedItem()), 
						tableViewCombate.getItems().get(0).getTotalHabilidad(), 
						tableViewCaracteristicas.getItems().get(2).getBonoCaracteristica(),
						String.valueOf(Integer.parseInt(tTurnoTotal.getText())-Integer.parseInt("20")));
				tTipoArma4.setText(tableviewArmaSeleccionada4.getItems().get(0).getTipoArma());
				tRasgoArma4.setText(tableviewArmaSeleccionada4.getItems().get(0).getRasgo());
				tableviewArmaSeleccionada4.refresh();
			}
		}
	}
	
	public void obtenerTablaArmadura(ObservableList<String> nombreArmaduras) {
		if (null==personaje.getNombre()) {
			ComboBox<String> cArmaduras = new ComboBox<String>();
			cArmaduras.setItems(nombreArmaduras);
			cArmaduras.setPrefWidth(colArmaduraNombre.getPrefWidth());

			ObservableList<ArmaduraSeleccionada> armadurasSeleccionadas = FXCollections.observableArrayList(
					new ArmaduraSeleccionada(cArmaduras,"-","-","-","-","-","-","-","-","-","-"));

			
			cArmaduras.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					Armadura armadura = ch.obtenerArmadura(sessionFactory, cArmaduras.getSelectionModel().getSelectedItem());
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
		}else {
			ComboBox<String> cArmaduras = new ComboBox<String>();
			cArmaduras.setItems(nombreArmaduras);
			cArmaduras.setPrefWidth(colArmaduraNombre.getPrefWidth());
			
			ArrayList<String> nombreSetArmaduras = new ArrayList<String>();
			for (Armadura armadura : personaje.getArmaduras()) {
				nombreSetArmaduras.add(armadura.getNombre());
			}
			
			ObservableList<ArmaduraSeleccionada> armadurasSeleccionadas = FXCollections.observableArrayList(
					new ArmaduraSeleccionada(cArmaduras,"-","-","-","-","-","-","-","-","-","-"));
			
			if (0 < armadurasSeleccionadas.size()) {
				if (armadurasSeleccionadas.get(0)!=null) {
					cArmaduras.setValue(nombreSetArmaduras.get(0));
					Armadura armadura = ch.obtenerArmadura(sessionFactory, cArmaduras.getValue());
					armadurasSeleccionadas.get(0).setCalor(String.valueOf(armadura.getTipoArmaduraCalor()));
					armadurasSeleccionadas.get(0).setContundente(String.valueOf(armadura.getTipoArmaduraContundente()));
					armadurasSeleccionadas.get(0).setElectrico(String.valueOf(armadura.getTipoArmaduraElectrico()));
					armadurasSeleccionadas.get(0).setEnergia(String.valueOf(armadura.getTipoArmaduraEnergia()));
					armadurasSeleccionadas.get(0).setFilo(String.valueOf(armadura.getTipoArmaduraFilo()));
					armadurasSeleccionadas.get(0).setFrio(String.valueOf(armadura.getTipoArmaduraFrio()));
					armadurasSeleccionadas.get(0).setPenetrante(String.valueOf(armadura.getTipoArmaduraPenetrante()));
					armadurasSeleccionadas.get(0).setEntereza(String.valueOf(armadura.getEntereza()));
					armadurasSeleccionadas.get(0).setPenalizadorNatural(String.valueOf(armadura.getPenalizadorNatural()));
					armadurasSeleccionadas.get(0).setRequisito(String.valueOf(armadura.getRequisitoNecesario()));
				}
			}
			
			cArmaduras.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					Armadura armadura = ch.obtenerArmadura(sessionFactory, cArmaduras.getSelectionModel().getSelectedItem());
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
		}
		
	}
	
	public void obtenerTablaEstilos(ObservableList<String> nombreEstilos){
		ComboBox<String> cTablasEstilos1 = new ComboBox<String>();
		cTablasEstilos1.setItems(nombreEstilos);
		cTablasEstilos1.setPrefWidth(colNombreTablaEstilos.getPrefWidth());
		ComboBox<String> cTablasEstilos2 = new ComboBox<String>();
		cTablasEstilos2.setItems(nombreEstilos);
		cTablasEstilos2.setPrefWidth(colNombreTablaEstilos.getPrefWidth());
		ComboBox<String> cTablasEstilos3 = new ComboBox<String>();
		cTablasEstilos3.setItems(nombreEstilos);
		cTablasEstilos3.setPrefWidth(colNombreTablaEstilos.getPrefWidth());
		ComboBox<String> cTablasEstilos4 = new ComboBox<String>();
		cTablasEstilos4.setItems(nombreEstilos);
		cTablasEstilos4.setPrefWidth(colNombreTablaEstilos.getPrefWidth());
		ComboBox<String> cTablasEstilos5 = new ComboBox<String>();
		cTablasEstilos5.setItems(nombreEstilos);
		cTablasEstilos5.setPrefWidth(colNombreTablaEstilos.getPrefWidth());
		
		ArrayList<String> nombreSetTablaEstilos = new ArrayList<String>();
		for (TablaEstilo tablaEstilo : personaje.getTablaEstilos()) {
			nombreSetTablaEstilos.add(tablaEstilo.getNombre());
		}
		
		
		ObservableList<TablaEstiloSeleccionada> tablasEstilosSeleccionadas = FXCollections.observableArrayList(
				new TablaEstiloSeleccionada(cTablasEstilos1,"0","0"),
				new TablaEstiloSeleccionada(cTablasEstilos2,"0","0"),
				new TablaEstiloSeleccionada(cTablasEstilos3,"0","0"),
				new TablaEstiloSeleccionada(cTablasEstilos4,"0","0"),
				new TablaEstiloSeleccionada(cTablasEstilos5,"0","0"));
		
		
		if (0 < nombreSetTablaEstilos.size()) {
			if (nombreSetTablaEstilos.get(0)!=null) {
				cTablasEstilos1.setValue(nombreSetTablaEstilos.get(0));
				TablaEstilo tablaEstiloCoste = ch.obtenerTablasEstiloSeleccionada(sessionFactory, cTablasEstilos1.getValue());
				tablasEstilosSeleccionadas.get(0).setCoste(String.valueOf(tablaEstiloCoste.getCoste()));
				tablasEstilosSeleccionadas.get(0).setPds(String.valueOf(tablaEstiloCoste.getCoste()));
			}
		}
		
		if (1 < nombreSetTablaEstilos.size()) {
			if (nombreSetTablaEstilos.get(1)!=null) {
				cTablasEstilos2.setValue(nombreSetTablaEstilos.get(1));
				TablaEstilo tablaEstiloCoste = ch.obtenerTablasEstiloSeleccionada(sessionFactory, cTablasEstilos2.getValue());
				tablasEstilosSeleccionadas.get(1).setCoste(String.valueOf(tablaEstiloCoste.getCoste()));
				tablasEstilosSeleccionadas.get(1).setPds(String.valueOf(tablaEstiloCoste.getCoste()));
			}
		}
		
		if (2 < nombreSetTablaEstilos.size()) {
			if (nombreSetTablaEstilos.get(2)!=null) {
				cTablasEstilos3.setValue(nombreSetTablaEstilos.get(2));
				TablaEstilo tablaEstiloCoste = ch.obtenerTablasEstiloSeleccionada(sessionFactory, cTablasEstilos3.getValue());
				tablasEstilosSeleccionadas.get(2).setCoste(String.valueOf(tablaEstiloCoste.getCoste()));
				tablasEstilosSeleccionadas.get(2).setPds(String.valueOf(tablaEstiloCoste.getCoste()));
			}
		}
		if (3 < nombreSetTablaEstilos.size()) {
			if (nombreSetTablaEstilos.get(3)!=null) {
				cTablasEstilos4.setValue(nombreSetTablaEstilos.get(3));
				TablaEstilo tablaEstiloCoste = ch.obtenerTablasEstiloSeleccionada(sessionFactory, cTablasEstilos4.getValue());
				tablasEstilosSeleccionadas.get(3).setCoste(String.valueOf(tablaEstiloCoste.getCoste()));
				tablasEstilosSeleccionadas.get(3).setPds(String.valueOf(tablaEstiloCoste.getCoste()));
			}
		}
		
		if (4 < nombreSetTablaEstilos.size()) {
			if (nombreSetTablaEstilos.get(4)!=null) {
				cTablasEstilos5.setValue(nombreSetTablaEstilos.get(4));
				TablaEstilo tablaEstiloCoste = ch.obtenerTablasEstiloSeleccionada(sessionFactory, cTablasEstilos5.getValue());
				tablasEstilosSeleccionadas.get(4).setCoste(String.valueOf(tablaEstiloCoste.getCoste()));
				tablasEstilosSeleccionadas.get(4).setPds(String.valueOf(tablaEstiloCoste.getCoste()));
			}
		}
		
		
		cTablasEstilos1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				TablaEstilo tablaEstilo = ch.obtenerTablasEstiloSeleccionada(sessionFactory, cTablasEstilos1.getSelectionModel().getSelectedItem());
				TablaEstiloSeleccionada tablaEstiloSeleccionada = tablasEstilosSeleccionadas.get(0);
				tablaEstiloSeleccionada.setCoste(String.valueOf(tablaEstilo.getCoste()));
				tablaEstiloSeleccionada.setPds(String.valueOf(tablaEstilo.getCoste()));
				tableViewTablasEstilos.refresh();
			}
		});
		
		cTablasEstilos2.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				TablaEstilo tablaEstilo = ch.obtenerTablasEstiloSeleccionada(sessionFactory, cTablasEstilos2.getSelectionModel().getSelectedItem());
				TablaEstiloSeleccionada tablaEstiloSeleccionada = tablasEstilosSeleccionadas.get(1);
				tablaEstiloSeleccionada.setCoste(String.valueOf(tablaEstilo.getCoste()));
				tablaEstiloSeleccionada.setPds(String.valueOf(tablaEstilo.getCoste()));
				tableViewTablasEstilos.refresh();
			}
		});
		
		cTablasEstilos3.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				TablaEstilo tablaEstilo = ch.obtenerTablasEstiloSeleccionada(sessionFactory, cTablasEstilos3.getSelectionModel().getSelectedItem());
				TablaEstiloSeleccionada tablaEstiloSeleccionada = tablasEstilosSeleccionadas.get(2);
				tablaEstiloSeleccionada.setCoste(String.valueOf(tablaEstilo.getCoste()));
				tablaEstiloSeleccionada.setPds(String.valueOf(tablaEstilo.getCoste()));
				tableViewTablasEstilos.refresh();
			}
		});
		
		cTablasEstilos4.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				TablaEstilo tablaEstilo = ch.obtenerTablasEstiloSeleccionada(sessionFactory, cTablasEstilos4.getSelectionModel().getSelectedItem());
				TablaEstiloSeleccionada tablaEstiloSeleccionada = tablasEstilosSeleccionadas.get(3);
				tablaEstiloSeleccionada.setCoste(String.valueOf(tablaEstilo.getCoste()));
				tablaEstiloSeleccionada.setPds(String.valueOf(tablaEstilo.getCoste()));
				tableViewTablasEstilos.refresh();
			}
		});
		
		cTablasEstilos5.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				TablaEstilo tablaEstilo = ch.obtenerTablasEstiloSeleccionada(sessionFactory, cTablasEstilos5.getSelectionModel().getSelectedItem());
				TablaEstiloSeleccionada tablaEstiloSeleccionada = tablasEstilosSeleccionadas.get(4);
				tablaEstiloSeleccionada.setCoste(String.valueOf(tablaEstilo.getCoste()));
				tablaEstiloSeleccionada.setPds(String.valueOf(tablaEstilo.getCoste()));
				tableViewTablasEstilos.refresh();
			}
		});
		

		colNombreTablaEstilos.setCellValueFactory(new PropertyValueFactory<TablaEstiloSeleccionada, ComboBox<String>>("nombreTabla"));
		colCosteTablaEstilos.setCellValueFactory(new PropertyValueFactory<TablaEstiloSeleccionada, String>("coste"));
		colPdsTablaEstilos.setCellValueFactory(new PropertyValueFactory<TablaEstiloSeleccionada, String>("pds"));
		
		colPdsTablaEstilos.setCellFactory(TextFieldTableCell.forTableColumn());
		
		tableViewTablasEstilos.setItems(tablasEstilosSeleccionadas);
	}
	
	public void obtenerTablaArtesMarciales(ObservableList<String> nombreArtesMarciales) {
		ComboBox<String> cArtesMarciales1 = new ComboBox<String>();
		cArtesMarciales1.setItems(nombreArtesMarciales);
		cArtesMarciales1.setPrefWidth(colNombreTablaArtesMarciales.getPrefWidth());
		ComboBox<String> cArtesMarciales2 = new ComboBox<String>();
		cArtesMarciales2.setItems(nombreArtesMarciales);
		cArtesMarciales2.setPrefWidth(colNombreTablaArtesMarciales.getPrefWidth());
		ComboBox<String> cArtesMarciales3 = new ComboBox<String>();
		cArtesMarciales3.setItems(nombreArtesMarciales);
		cArtesMarciales3.setPrefWidth(colNombreTablaArtesMarciales.getPrefWidth());
		ComboBox<String> cArtesMarciales4 = new ComboBox<String>();
		cArtesMarciales4.setItems(nombreArtesMarciales);
		cArtesMarciales4.setPrefWidth(colNombreTablaArtesMarciales.getPrefWidth());
		ComboBox<String> cArtesMarciales5 = new ComboBox<String>();
		cArtesMarciales5.setItems(nombreArtesMarciales);
		cArtesMarciales5.setPrefWidth(colNombreTablaArtesMarciales.getPrefWidth());
		ComboBox<String> cArtesMarciales6 = new ComboBox<String>();
		cArtesMarciales6.setItems(nombreArtesMarciales);
		cArtesMarciales6.setPrefWidth(colNombreTablaArtesMarciales.getPrefWidth());
		ComboBox<String> cArtesMarciales7 = new ComboBox<String>();
		cArtesMarciales7.setItems(nombreArtesMarciales);
		cArtesMarciales7.setPrefWidth(colNombreTablaArtesMarciales.getPrefWidth());
		ComboBox<String> cArtesMarciales8 = new ComboBox<String>();
		cArtesMarciales8.setItems(nombreArtesMarciales);
		cArtesMarciales8.setPrefWidth(colNombreTablaArtesMarciales.getPrefWidth());
		ComboBox<String> cArtesMarciales9 = new ComboBox<String>();
		cArtesMarciales9.setItems(nombreArtesMarciales);
		cArtesMarciales9.setPrefWidth(colNombreTablaArtesMarciales.getPrefWidth());
		ComboBox<String> cArtesMarciales10 = new ComboBox<String>();
		cArtesMarciales10.setItems(nombreArtesMarciales);
		cArtesMarciales10.setPrefWidth(colNombreTablaArtesMarciales.getPrefWidth());
		
		ArrayList<String> nombreSetArtesMarciales = new ArrayList<String>();
		for (ArteMarcial arteMarcial : personaje.getArteMarcials()) {
			nombreSetArtesMarciales.add(arteMarcial.getNombre());
		}
		
		ObservableList<ArteMarcialSeleccionado> tablasArtesMarciales = FXCollections.observableArrayList(
				new ArteMarcialSeleccionado(cArtesMarciales1,"0","0","0","0","0","0"),
				new ArteMarcialSeleccionado(cArtesMarciales2,"0","0","0","0","0","0"),
				new ArteMarcialSeleccionado(cArtesMarciales3,"0","0","0","0","0","0"),
				new ArteMarcialSeleccionado(cArtesMarciales4,"0","0","0","0","0","0"),
				new ArteMarcialSeleccionado(cArtesMarciales5,"0","0","0","0","0","0"),
				new ArteMarcialSeleccionado(cArtesMarciales6,"0","0","0","0","0","0"),
				new ArteMarcialSeleccionado(cArtesMarciales7,"0","0","0","0","0","0"),
				new ArteMarcialSeleccionado(cArtesMarciales8,"0","0","0","0","0","0"),
				new ArteMarcialSeleccionado(cArtesMarciales9,"0","0","0","0","0","0"),
				new ArteMarcialSeleccionado(cArtesMarciales10,"0","0","0","0","0","0"));
		
		if (0 < nombreSetArtesMarciales.size()) {
			if (nombreSetArtesMarciales.get(0)!=null) {
				cArtesMarciales1.setValue(nombreSetArtesMarciales.get(0));
				ArteMarcial arteMarcial = ch.obtenerArteMarcialSeleccionada(sessionFactory, cArtesMarciales1.getValue());
				tablasArtesMarciales.get(0).setCoste(String.valueOf("20"));
				tablasArtesMarciales.get(0).setPds("20");
				tablasArtesMarciales.get(0).setBonoHa(String.valueOf(arteMarcial.getBonoAtaque()));
				tablasArtesMarciales.get(0).setBonoHp(String.valueOf(arteMarcial.getBonoParada()));
				tablasArtesMarciales.get(0).setBonoHe(String.valueOf(arteMarcial.getBonoEsquiva()));
				tablasArtesMarciales.get(0).setBonoTurno(String.valueOf(arteMarcial.getBonoTurno()));
			}
		}
		
		if (1 < nombreSetArtesMarciales.size()) {
			if (nombreSetArtesMarciales.get(1)!=null) {
				cArtesMarciales2.setValue(nombreSetArtesMarciales.get(1));
				ArteMarcial arteMarcial = ch.obtenerArteMarcialSeleccionada(sessionFactory, cArtesMarciales2.getValue());
				tablasArtesMarciales.get(1).setCoste(String.valueOf("20"));
				tablasArtesMarciales.get(1).setPds("20");
				tablasArtesMarciales.get(1).setBonoHa(String.valueOf(arteMarcial.getBonoAtaque()));
				tablasArtesMarciales.get(1).setBonoHp(String.valueOf(arteMarcial.getBonoParada()));
				tablasArtesMarciales.get(1).setBonoHe(String.valueOf(arteMarcial.getBonoEsquiva()));
				tablasArtesMarciales.get(1).setBonoTurno(String.valueOf(arteMarcial.getBonoTurno()));
			}
		}
		
		if (2 < nombreSetArtesMarciales.size()) {
			if (nombreSetArtesMarciales.get(2)!=null) {
				cArtesMarciales3.setValue(nombreSetArtesMarciales.get(2));
				ArteMarcial arteMarcial = ch.obtenerArteMarcialSeleccionada(sessionFactory, cArtesMarciales3.getValue());
				tablasArtesMarciales.get(2).setCoste(String.valueOf("20"));
				tablasArtesMarciales.get(2).setPds("20");
				tablasArtesMarciales.get(2).setBonoHa(String.valueOf(arteMarcial.getBonoAtaque()));
				tablasArtesMarciales.get(2).setBonoHp(String.valueOf(arteMarcial.getBonoParada()));
				tablasArtesMarciales.get(2).setBonoHe(String.valueOf(arteMarcial.getBonoEsquiva()));
				tablasArtesMarciales.get(2).setBonoTurno(String.valueOf(arteMarcial.getBonoTurno()));
			}
		}
		
		if (3 < nombreSetArtesMarciales.size()) {
			if (nombreSetArtesMarciales.get(3)!=null) {
				cArtesMarciales4.setValue(nombreSetArtesMarciales.get(3));
				ArteMarcial arteMarcial = ch.obtenerArteMarcialSeleccionada(sessionFactory, cArtesMarciales4.getValue());
				tablasArtesMarciales.get(3).setCoste(String.valueOf("20"));
				tablasArtesMarciales.get(3).setPds("20");
				tablasArtesMarciales.get(3).setBonoHa(String.valueOf(arteMarcial.getBonoAtaque()));
				tablasArtesMarciales.get(3).setBonoHp(String.valueOf(arteMarcial.getBonoParada()));
				tablasArtesMarciales.get(3).setBonoHe(String.valueOf(arteMarcial.getBonoEsquiva()));
				tablasArtesMarciales.get(3).setBonoTurno(String.valueOf(arteMarcial.getBonoTurno()));
			}
		}
		
		if (4 < nombreSetArtesMarciales.size()) {
			if (nombreSetArtesMarciales.get(4)!=null) {
				cArtesMarciales5.setValue(nombreSetArtesMarciales.get(4));
				ArteMarcial arteMarcial = ch.obtenerArteMarcialSeleccionada(sessionFactory, cArtesMarciales5.getValue());
				tablasArtesMarciales.get(4).setCoste(String.valueOf("20"));
				tablasArtesMarciales.get(4).setPds("20");
				tablasArtesMarciales.get(4).setBonoHa(String.valueOf(arteMarcial.getBonoAtaque()));
				tablasArtesMarciales.get(4).setBonoHp(String.valueOf(arteMarcial.getBonoParada()));
				tablasArtesMarciales.get(4).setBonoHe(String.valueOf(arteMarcial.getBonoEsquiva()));
				tablasArtesMarciales.get(4).setBonoTurno(String.valueOf(arteMarcial.getBonoTurno()));
			}
		}
		
		if (5 < nombreSetArtesMarciales.size()) {
			if (nombreSetArtesMarciales.get(5)!=null) {
				cArtesMarciales6.setValue(nombreSetArtesMarciales.get(1));
				ArteMarcial arteMarcial = ch.obtenerArteMarcialSeleccionada(sessionFactory, cArtesMarciales6.getValue());
				tablasArtesMarciales.get(5).setCoste(String.valueOf("20"));
				tablasArtesMarciales.get(5).setPds("20");
				tablasArtesMarciales.get(5).setBonoHa(String.valueOf(arteMarcial.getBonoAtaque()));
				tablasArtesMarciales.get(5).setBonoHp(String.valueOf(arteMarcial.getBonoParada()));
				tablasArtesMarciales.get(5).setBonoHe(String.valueOf(arteMarcial.getBonoEsquiva()));
				tablasArtesMarciales.get(5).setBonoTurno(String.valueOf(arteMarcial.getBonoTurno()));
			}
		}
		
		if (6 < nombreSetArtesMarciales.size()) {
			if (nombreSetArtesMarciales.get(6)!=null) {
				cArtesMarciales7.setValue(nombreSetArtesMarciales.get(6));
				ArteMarcial arteMarcial = ch.obtenerArteMarcialSeleccionada(sessionFactory, cArtesMarciales7.getValue());
				tablasArtesMarciales.get(6).setCoste(String.valueOf("20"));
				tablasArtesMarciales.get(6).setPds("20");
				tablasArtesMarciales.get(6).setBonoHa(String.valueOf(arteMarcial.getBonoAtaque()));
				tablasArtesMarciales.get(6).setBonoHp(String.valueOf(arteMarcial.getBonoParada()));
				tablasArtesMarciales.get(6).setBonoHe(String.valueOf(arteMarcial.getBonoEsquiva()));
				tablasArtesMarciales.get(6).setBonoTurno(String.valueOf(arteMarcial.getBonoTurno()));
			}
		}
		
		if (7 < nombreSetArtesMarciales.size()) {
			if (nombreSetArtesMarciales.get(7)!=null) {
				cArtesMarciales8.setValue(nombreSetArtesMarciales.get(7));
				ArteMarcial arteMarcial = ch.obtenerArteMarcialSeleccionada(sessionFactory, cArtesMarciales8.getValue());
				tablasArtesMarciales.get(7).setCoste(String.valueOf("20"));
				tablasArtesMarciales.get(7).setPds("20");
				tablasArtesMarciales.get(7).setBonoHa(String.valueOf(arteMarcial.getBonoAtaque()));
				tablasArtesMarciales.get(7).setBonoHp(String.valueOf(arteMarcial.getBonoParada()));
				tablasArtesMarciales.get(7).setBonoHe(String.valueOf(arteMarcial.getBonoEsquiva()));
				tablasArtesMarciales.get(7).setBonoTurno(String.valueOf(arteMarcial.getBonoTurno()));
			}
		}
		
		if (8 < nombreSetArtesMarciales.size()) {
			if (nombreSetArtesMarciales.get(8)!=null) {
				cArtesMarciales9.setValue(nombreSetArtesMarciales.get(8));
				ArteMarcial arteMarcial = ch.obtenerArteMarcialSeleccionada(sessionFactory, cArtesMarciales9.getValue());
				tablasArtesMarciales.get(8).setCoste(String.valueOf("20"));
				tablasArtesMarciales.get(8).setPds("20");
				tablasArtesMarciales.get(8).setBonoHa(String.valueOf(arteMarcial.getBonoAtaque()));
				tablasArtesMarciales.get(8).setBonoHp(String.valueOf(arteMarcial.getBonoParada()));
				tablasArtesMarciales.get(8).setBonoHe(String.valueOf(arteMarcial.getBonoEsquiva()));
				tablasArtesMarciales.get(8).setBonoTurno(String.valueOf(arteMarcial.getBonoTurno()));
			}
		}
		
		if (9 < nombreSetArtesMarciales.size()) {
			if (nombreSetArtesMarciales.get(9)!=null) {
				cArtesMarciales10.setValue(nombreSetArtesMarciales.get(9));
				ArteMarcial arteMarcial = ch.obtenerArteMarcialSeleccionada(sessionFactory, cArtesMarciales10.getValue());
				tablasArtesMarciales.get(9).setCoste(String.valueOf("20"));
				tablasArtesMarciales.get(9).setPds("20");
				tablasArtesMarciales.get(9).setBonoHa(String.valueOf(arteMarcial.getBonoAtaque()));
				tablasArtesMarciales.get(9).setBonoHp(String.valueOf(arteMarcial.getBonoParada()));
				tablasArtesMarciales.get(9).setBonoHe(String.valueOf(arteMarcial.getBonoEsquiva()));
				tablasArtesMarciales.get(9).setBonoTurno(String.valueOf(arteMarcial.getBonoTurno()));
			}
		}
		
		cArtesMarciales1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				ArteMarcial arteMarcial = ch.obtenerArteMarcialSeleccionada(sessionFactory, cArtesMarciales1.getSelectionModel().getSelectedItem());
				ArteMarcialSeleccionado arteMarcialSeleccionado = tablasArtesMarciales.get(0);
				arteMarcialSeleccionado.setCoste(String.valueOf("20"));
				arteMarcialSeleccionado.setPds("20");
				arteMarcialSeleccionado.setBonoHa(String.valueOf(arteMarcial.getBonoAtaque()));
				arteMarcialSeleccionado.setBonoHp(String.valueOf(arteMarcial.getBonoParada()));
				arteMarcialSeleccionado.setBonoHe(String.valueOf(arteMarcial.getBonoEsquiva()));
				arteMarcialSeleccionado.setBonoTurno(String.valueOf(arteMarcial.getBonoTurno()));
				tableViewTablasArtesMarciales.refresh();
			}
		});
		
		cArtesMarciales2.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				ArteMarcial arteMarcial = ch.obtenerArteMarcialSeleccionada(sessionFactory, cArtesMarciales2.getSelectionModel().getSelectedItem());
				ArteMarcialSeleccionado arteMarcialSeleccionado = tablasArtesMarciales.get(1);
				arteMarcialSeleccionado.setCoste(String.valueOf("20"));
				arteMarcialSeleccionado.setPds("20");
				arteMarcialSeleccionado.setBonoHa(String.valueOf(arteMarcial.getBonoAtaque()));
				arteMarcialSeleccionado.setBonoHp(String.valueOf(arteMarcial.getBonoParada()));
				arteMarcialSeleccionado.setBonoHe(String.valueOf(arteMarcial.getBonoEsquiva()));
				arteMarcialSeleccionado.setBonoTurno(String.valueOf(arteMarcial.getBonoTurno()));
				tableViewTablasArtesMarciales.refresh();
			}
		});
		
		cArtesMarciales3.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				ArteMarcial arteMarcial = ch.obtenerArteMarcialSeleccionada(sessionFactory, cArtesMarciales3.getSelectionModel().getSelectedItem());
				ArteMarcialSeleccionado arteMarcialSeleccionado = tablasArtesMarciales.get(2);
				arteMarcialSeleccionado.setCoste(String.valueOf("20"));
				arteMarcialSeleccionado.setPds("20");
				arteMarcialSeleccionado.setBonoHa(String.valueOf(arteMarcial.getBonoAtaque()));
				arteMarcialSeleccionado.setBonoHp(String.valueOf(arteMarcial.getBonoParada()));
				arteMarcialSeleccionado.setBonoHe(String.valueOf(arteMarcial.getBonoEsquiva()));
				arteMarcialSeleccionado.setBonoTurno(String.valueOf(arteMarcial.getBonoTurno()));
				tableViewTablasArtesMarciales.refresh();
			}
		});
		
		cArtesMarciales4.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				ArteMarcial arteMarcial = ch.obtenerArteMarcialSeleccionada(sessionFactory, cArtesMarciales4.getSelectionModel().getSelectedItem());
				ArteMarcialSeleccionado arteMarcialSeleccionado = tablasArtesMarciales.get(3);
				arteMarcialSeleccionado.setCoste(String.valueOf("20"));
				arteMarcialSeleccionado.setPds("20");
				arteMarcialSeleccionado.setBonoHa(String.valueOf(arteMarcial.getBonoAtaque()));
				arteMarcialSeleccionado.setBonoHp(String.valueOf(arteMarcial.getBonoParada()));
				arteMarcialSeleccionado.setBonoHe(String.valueOf(arteMarcial.getBonoEsquiva()));
				arteMarcialSeleccionado.setBonoTurno(String.valueOf(arteMarcial.getBonoTurno()));
				tableViewTablasArtesMarciales.refresh();
			}
		});
		
		cArtesMarciales5.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				ArteMarcial arteMarcial = ch.obtenerArteMarcialSeleccionada(sessionFactory, cArtesMarciales5.getSelectionModel().getSelectedItem());
				ArteMarcialSeleccionado arteMarcialSeleccionado = tablasArtesMarciales.get(4);
				arteMarcialSeleccionado.setCoste(String.valueOf("20"));
				arteMarcialSeleccionado.setPds("20");
				arteMarcialSeleccionado.setBonoHa(String.valueOf(arteMarcial.getBonoAtaque()));
				arteMarcialSeleccionado.setBonoHp(String.valueOf(arteMarcial.getBonoParada()));
				arteMarcialSeleccionado.setBonoHe(String.valueOf(arteMarcial.getBonoEsquiva()));
				arteMarcialSeleccionado.setBonoTurno(String.valueOf(arteMarcial.getBonoTurno()));
				tableViewTablasArtesMarciales.refresh();
			}
		});

		cArtesMarciales6.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				ArteMarcial arteMarcial = ch.obtenerArteMarcialSeleccionada(sessionFactory, cArtesMarciales6.getSelectionModel().getSelectedItem());
				ArteMarcialSeleccionado arteMarcialSeleccionado = tablasArtesMarciales.get(5);
				arteMarcialSeleccionado.setCoste(String.valueOf("20"));
				arteMarcialSeleccionado.setPds("20");
				arteMarcialSeleccionado.setBonoHa(String.valueOf(arteMarcial.getBonoAtaque()));
				arteMarcialSeleccionado.setBonoHp(String.valueOf(arteMarcial.getBonoParada()));
				arteMarcialSeleccionado.setBonoHe(String.valueOf(arteMarcial.getBonoEsquiva()));
				arteMarcialSeleccionado.setBonoTurno(String.valueOf(arteMarcial.getBonoTurno()));
				tableViewTablasArtesMarciales.refresh();
			}
		});
		
		cArtesMarciales7.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				ArteMarcial arteMarcial = ch.obtenerArteMarcialSeleccionada(sessionFactory, cArtesMarciales7.getSelectionModel().getSelectedItem());
				ArteMarcialSeleccionado arteMarcialSeleccionado = tablasArtesMarciales.get(6);
				arteMarcialSeleccionado.setCoste(String.valueOf("20"));
				arteMarcialSeleccionado.setPds("20");
				arteMarcialSeleccionado.setBonoHa(String.valueOf(arteMarcial.getBonoAtaque()));
				arteMarcialSeleccionado.setBonoHp(String.valueOf(arteMarcial.getBonoParada()));
				arteMarcialSeleccionado.setBonoHe(String.valueOf(arteMarcial.getBonoEsquiva()));
				arteMarcialSeleccionado.setBonoTurno(String.valueOf(arteMarcial.getBonoTurno()));
				tableViewTablasArtesMarciales.refresh();
			}
		});
		
		cArtesMarciales8.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				ArteMarcial arteMarcial = ch.obtenerArteMarcialSeleccionada(sessionFactory, cArtesMarciales8.getSelectionModel().getSelectedItem());
				ArteMarcialSeleccionado arteMarcialSeleccionado = tablasArtesMarciales.get(7);
				arteMarcialSeleccionado.setCoste(String.valueOf("20"));
				arteMarcialSeleccionado.setPds("20");
				arteMarcialSeleccionado.setBonoHa(String.valueOf(arteMarcial.getBonoAtaque()));
				arteMarcialSeleccionado.setBonoHp(String.valueOf(arteMarcial.getBonoParada()));
				arteMarcialSeleccionado.setBonoHe(String.valueOf(arteMarcial.getBonoEsquiva()));
				arteMarcialSeleccionado.setBonoTurno(String.valueOf(arteMarcial.getBonoTurno()));
				tableViewTablasArtesMarciales.refresh();
			}
		});
		
		cArtesMarciales9.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				ArteMarcial arteMarcial = ch.obtenerArteMarcialSeleccionada(sessionFactory, cArtesMarciales9.getSelectionModel().getSelectedItem());
				ArteMarcialSeleccionado arteMarcialSeleccionado = tablasArtesMarciales.get(8);
				arteMarcialSeleccionado.setCoste(String.valueOf("20"));
				arteMarcialSeleccionado.setPds("20");
				arteMarcialSeleccionado.setBonoHa(String.valueOf(arteMarcial.getBonoAtaque()));
				arteMarcialSeleccionado.setBonoHp(String.valueOf(arteMarcial.getBonoParada()));
				arteMarcialSeleccionado.setBonoHe(String.valueOf(arteMarcial.getBonoEsquiva()));
				arteMarcialSeleccionado.setBonoTurno(String.valueOf(arteMarcial.getBonoTurno()));
				tableViewTablasArtesMarciales.refresh();
			}
		});
		
		cArtesMarciales10.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				ArteMarcial arteMarcial = ch.obtenerArteMarcialSeleccionada(sessionFactory, cArtesMarciales10.getSelectionModel().getSelectedItem());
				ArteMarcialSeleccionado arteMarcialSeleccionado = tablasArtesMarciales.get(9);
				arteMarcialSeleccionado.setCoste(String.valueOf("20"));
				arteMarcialSeleccionado.setPds("20");
				arteMarcialSeleccionado.setBonoHa(String.valueOf(arteMarcial.getBonoAtaque()));
				arteMarcialSeleccionado.setBonoHp(String.valueOf(arteMarcial.getBonoParada()));
				arteMarcialSeleccionado.setBonoHe(String.valueOf(arteMarcial.getBonoEsquiva()));
				arteMarcialSeleccionado.setBonoTurno(String.valueOf(arteMarcial.getBonoTurno()));
				tableViewTablasArtesMarciales.refresh();
			}
		});
		
		colNombreTablaArtesMarciales.setCellValueFactory(new PropertyValueFactory<ArteMarcialSeleccionado, ComboBox<String>>("nombreArteMarcial"));
		colCosteTablaArtesMarciales.setCellValueFactory(new PropertyValueFactory<ArteMarcialSeleccionado, String>("coste"));
		colPdsTablaArtesMarciales.setCellValueFactory(new PropertyValueFactory<ArteMarcialSeleccionado, String>("pds"));
		colHaTablaArtesMarciales.setCellValueFactory(new PropertyValueFactory<ArteMarcialSeleccionado, String>("bonoHa"));
		colHpTablaArtesMarciales.setCellValueFactory(new PropertyValueFactory<ArteMarcialSeleccionado, String>("bonoHe"));
		colHeTablaArtesMarciales.setCellValueFactory(new PropertyValueFactory<ArteMarcialSeleccionado, String>("bonoHp"));
		colTurnoTablaArtesMarciales.setCellValueFactory(new PropertyValueFactory<ArteMarcialSeleccionado, String>("bonoTurno"));
		
		colPdsTablaArtesMarciales.setCellFactory(TextFieldTableCell.forTableColumn());
		
		tableViewTablasArtesMarciales.setItems(tablasArtesMarciales);
	}
	
	public void obtenerTablaNivelMagia(ObservableList<String> nombreViasMagicas){
		ComboBox<String> cViaMagica1 = new ComboBox<String>();
		cViaMagica1.setItems(nombreViasMagicas);
		cViaMagica1.setPrefWidth(colViaNombre.getPrefWidth());
		ComboBox<String> cViaMagica2 = new ComboBox<String>();
		cViaMagica2.setItems(nombreViasMagicas);
		cViaMagica2.setPrefWidth(colViaNombre.getPrefWidth());
		ComboBox<String> cViaMagica3 = new ComboBox<String>();
		cViaMagica3.setItems(nombreViasMagicas);
		cViaMagica3.setPrefWidth(colViaNombre.getPrefWidth());
		ComboBox<String> cViaMagica4 = new ComboBox<String>();
		cViaMagica4.setItems(nombreViasMagicas);
		cViaMagica4.setPrefWidth(colViaNombre.getPrefWidth());
		ComboBox<String> cViaMagica5 = new ComboBox<String>();
		cViaMagica5.setItems(nombreViasMagicas);
		cViaMagica5.setPrefWidth(colViaNombre.getPrefWidth());
		ComboBox<String> cViaMagica6 = new ComboBox<String>();
		cViaMagica6.setItems(nombreViasMagicas);
		cViaMagica6.setPrefWidth(colViaNombre.getPrefWidth());
		
		ObservableList<ViaSeleccionada> viaMagica = FXCollections.observableArrayList(
				new ViaSeleccionada(cViaMagica1,"0","0"),
				new ViaSeleccionada(cViaMagica2,"0","0"),
				new ViaSeleccionada(cViaMagica3,"0","0"),
				new ViaSeleccionada(cViaMagica4,"0","0"),
				new ViaSeleccionada(cViaMagica5,"0","0"),
				new ViaSeleccionada(cViaMagica6,"0","0"));
		
		cViaMagica1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				TablaViasMagia tablaViasMagia = ch.obtenerViaMagiaSeleccionada(sessionFactory, cViaMagica1.getSelectionModel().getSelectedItem());
				ViaSeleccionada viaSeleccionada = viaMagica.get(0); 
				
				tableViewNivelVia.refresh();
			}
		});
		
		cViaMagica2.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				TablaViasMagia tablaViasMagia = ch.obtenerViaMagiaSeleccionada(sessionFactory, cViaMagica2.getSelectionModel().getSelectedItem());
				ViaSeleccionada viaSeleccionada = viaMagica.get(1); 
				
				tableViewNivelVia.refresh();
			}
		});
		
		cViaMagica3.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				TablaViasMagia tablaViasMagia = ch.obtenerViaMagiaSeleccionada(sessionFactory, cViaMagica3.getSelectionModel().getSelectedItem());
				ViaSeleccionada viaSeleccionada = viaMagica.get(2); 
				
				tableViewNivelVia.refresh();
			}
		});
		
		cViaMagica4.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				TablaViasMagia tablaViasMagia = ch.obtenerViaMagiaSeleccionada(sessionFactory, cViaMagica4.getSelectionModel().getSelectedItem());
				ViaSeleccionada viaSeleccionada = viaMagica.get(3); 
				
				tableViewNivelVia.refresh();
			}
		});
		
		cViaMagica5.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				TablaViasMagia tablaViasMagia = ch.obtenerViaMagiaSeleccionada(sessionFactory, cViaMagica5.getSelectionModel().getSelectedItem());
				ViaSeleccionada viaSeleccionada = viaMagica.get(4); 
				
				tableViewNivelVia.refresh();
			}
		});
		
		cViaMagica6.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				TablaViasMagia tablaViasMagia = ch.obtenerViaMagiaSeleccionada(sessionFactory, cViaMagica6.getSelectionModel().getSelectedItem());
				ViaSeleccionada viaSeleccionada = viaMagica.get(5); 
				
				tableViewNivelVia.refresh();
			}
		});
		colViaNombre.setCellValueFactory(new PropertyValueFactory<ViaSeleccionada, ComboBox<String>>("nombreViaSeleccionada"));
		colNivelViaUsado.setCellValueFactory(new PropertyValueFactory<ViaSeleccionada, String>("nivelUsado"));
		colNivelViaTotal.setCellValueFactory(new PropertyValueFactory<ViaSeleccionada, String>("nivelTotal"));
		
		colNivelViaUsado.setCellFactory(TextFieldTableCell.forTableColumn());
		
		tableViewNivelVia.setItems(viaMagica);
	}
	
	public void obtenerTablasMistico(ObservableList<String> nombreTablasMagicas) {
		ComboBox<String> cTablaMistica1 = new ComboBox<String>();
		cTablaMistica1.setItems(nombreTablasMagicas);
		ComboBox<String> cTablaMistica2 = new ComboBox<String>();
		cTablaMistica2.setItems(nombreTablasMagicas);
		
		ObservableList<TablaMagiaSeleccionada> tablaTablasMagia = FXCollections.observableArrayList(
				new TablaMagiaSeleccionada(cTablaMistica1,"0","0"),
				new TablaMagiaSeleccionada(cTablaMistica2,"0","0"));
		
		cTablaMistica1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				TablaMagia tablaMistico = ch.obtenerTablaMagia(sessionFactory, cTablaMistica1.getSelectionModel().getSelectedItem());
				TablaMagiaSeleccionada tablasMisticos = tablaTablasMagia.get(0); 
				tablasMisticos.setCoste(String.valueOf(tablaMistico.getCoste()));
				
				tableViewTablasMistico.refresh();
			}
		});
		
		cTablaMistica2.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				TablaMagia tablaMistico = ch.obtenerTablaMagia(sessionFactory, cTablaMistica2.getSelectionModel().getSelectedItem());
				TablaMagiaSeleccionada tablasMisticos = tablaTablasMagia.get(1); 
				tablasMisticos.setCoste(String.valueOf(tablaMistico.getCoste()));
				
				tableViewTablasMistico.refresh();
			}
		});
		
		colNombreTablasMistico.setCellValueFactory(new PropertyValueFactory<TablaMagiaSeleccionada, ComboBox<String>>("nombreTablaSeleccionada"));
		colCosteTablasMistico.setCellValueFactory(new PropertyValueFactory<TablaMagiaSeleccionada, String>("coste"));
		colPdsTablasMistico.setCellValueFactory(new PropertyValueFactory<TablaMagiaSeleccionada, String>("pds"));
		
		tableViewTablasMistico.setItems(tablaTablasMagia);
	}
	
	public void obtenerTablaConjurosLibreAcceso(ObservableList<String> nombreConjurosLibreAcceso) {
		ComboBox<String> cConjurosSeleccionados1 = new ComboBox<String>();
		cConjurosSeleccionados1.setItems(nombreConjurosLibreAcceso);
		cConjurosSeleccionados1.setPrefWidth(colConjurosLibreAccesoNombre.getPrefWidth());
		ComboBox<String> cConjurosSeleccionados2 = new ComboBox<String>();
		cConjurosSeleccionados2.setItems(nombreConjurosLibreAcceso);
		cConjurosSeleccionados2.setPrefWidth(colConjurosLibreAccesoNombre.getPrefWidth());
		
		ComboBox<String> cConjurosSeleccionados3 = new ComboBox<String>();
		cConjurosSeleccionados3.setItems(nombreConjurosLibreAcceso);
		cConjurosSeleccionados3.setPrefWidth(colConjurosLibreAccesoNombre.getPrefWidth());
		ComboBox<String> cConjurosSeleccionados4 = new ComboBox<String>();
		cConjurosSeleccionados4.setItems(nombreConjurosLibreAcceso);
		cConjurosSeleccionados4.setPrefWidth(colConjurosLibreAccesoNombre.getPrefWidth());
		
		ComboBox<String> cConjurosSeleccionados5 = new ComboBox<String>();
		cConjurosSeleccionados5.setItems(nombreConjurosLibreAcceso);
		cConjurosSeleccionados5.setPrefWidth(colConjurosLibreAccesoNombre.getPrefWidth());
		ComboBox<String> cConjurosSeleccionados6 = new ComboBox<String>();
		cConjurosSeleccionados6.setItems(nombreConjurosLibreAcceso);
		cConjurosSeleccionados6.setPrefWidth(colConjurosLibreAccesoNombre.getPrefWidth());
		
		ComboBox<String> cConjurosSeleccionados7 = new ComboBox<String>();
		cConjurosSeleccionados7.setItems(nombreConjurosLibreAcceso);
		cConjurosSeleccionados7.setPrefWidth(colConjurosLibreAccesoNombre.getPrefWidth());
		ComboBox<String> cConjurosSeleccionados8 = new ComboBox<String>();
		cConjurosSeleccionados8.setItems(nombreConjurosLibreAcceso);
		cConjurosSeleccionados8.setPrefWidth(colConjurosLibreAccesoNombre.getPrefWidth());
		
		ComboBox<String> cConjurosSeleccionados9 = new ComboBox<String>();
		cConjurosSeleccionados9.setItems(nombreConjurosLibreAcceso);
		cConjurosSeleccionados9.setPrefWidth(colConjurosLibreAccesoNombre.getPrefWidth());
		ComboBox<String> cConjurosSeleccionados10 = new ComboBox<String>();
		cConjurosSeleccionados10.setItems(nombreConjurosLibreAcceso);
		cConjurosSeleccionados10.setPrefWidth(colConjurosLibreAccesoNombre.getPrefWidth());
		
		ComboBox<String> cConjurosSeleccionados11 = new ComboBox<String>();
		cConjurosSeleccionados11.setItems(nombreConjurosLibreAcceso);
		cConjurosSeleccionados11.setPrefWidth(colConjurosLibreAccesoNombre.getPrefWidth());
		ComboBox<String> cConjurosSeleccionados12 = new ComboBox<String>();
		cConjurosSeleccionados12.setItems(nombreConjurosLibreAcceso);
		cConjurosSeleccionados12.setPrefWidth(colConjurosLibreAccesoNombre.getPrefWidth());
		
		ComboBox<String> cConjurosSeleccionados13 = new ComboBox<String>();
		cConjurosSeleccionados13.setItems(nombreConjurosLibreAcceso);
		cConjurosSeleccionados13.setPrefWidth(colConjurosLibreAccesoNombre.getPrefWidth());
		ComboBox<String> cConjurosSeleccionados14 = new ComboBox<String>();
		cConjurosSeleccionados14.setItems(nombreConjurosLibreAcceso);
		cConjurosSeleccionados14.setPrefWidth(colConjurosLibreAccesoNombre.getPrefWidth());
		
		ComboBox<String> cConjurosSeleccionados15 = new ComboBox<String>();
		cConjurosSeleccionados15.setItems(nombreConjurosLibreAcceso);
		cConjurosSeleccionados15.setPrefWidth(colConjurosLibreAccesoNombre.getPrefWidth());
		ComboBox<String> cConjurosSeleccionados16 = new ComboBox<String>();
		cConjurosSeleccionados16.setItems(nombreConjurosLibreAcceso);
		cConjurosSeleccionados16.setPrefWidth(colConjurosLibreAccesoNombre.getPrefWidth());
		
		ComboBox<String> cConjurosSeleccionados17 = new ComboBox<String>();
		cConjurosSeleccionados17.setItems(nombreConjurosLibreAcceso);
		cConjurosSeleccionados17.setPrefWidth(colConjurosLibreAccesoNombre.getPrefWidth());
		ComboBox<String> cConjurosSeleccionados18 = new ComboBox<String>();
		cConjurosSeleccionados18.setItems(nombreConjurosLibreAcceso);
		cConjurosSeleccionados18.setPrefWidth(colConjurosLibreAccesoNombre.getPrefWidth());
		
		ComboBox<String> cConjurosSeleccionados19 = new ComboBox<String>();
		cConjurosSeleccionados19.setItems(nombreConjurosLibreAcceso);
		cConjurosSeleccionados19.setPrefWidth(colConjurosLibreAccesoNombre.getPrefWidth());
		ComboBox<String> cConjurosSeleccionados20 = new ComboBox<String>();
		cConjurosSeleccionados20.setItems(nombreConjurosLibreAcceso);
		cConjurosSeleccionados20.setPrefWidth(colConjurosLibreAccesoNombre.getPrefWidth());
		
		ComboBox<String> cConjurosSeleccionados21 = new ComboBox<String>();
		cConjurosSeleccionados21.setItems(nombreConjurosLibreAcceso);
		cConjurosSeleccionados21.setPrefWidth(colConjurosLibreAccesoNombre.getPrefWidth());
		
		ArrayList<String> nombreSetConjurosLibreAcceso = new ArrayList<String>();
		for (TablaConjurosLibreAcceso tablaConjurosLibreAcceso : personaje.getTablaConjurosLibreAccesos()) {
			nombreSetConjurosLibreAcceso.add(tablaConjurosLibreAcceso.getNombre());
		}
		
		ObservableList<ConjuroSeleccionado> conjurosLibreAcceso = FXCollections.observableArrayList(
				new ConjuroSeleccionado(cConjurosSeleccionados1,"0"),
				new ConjuroSeleccionado(cConjurosSeleccionados2,"0"),
				new ConjuroSeleccionado(cConjurosSeleccionados3,"0"),
				new ConjuroSeleccionado(cConjurosSeleccionados4,"0"),
				new ConjuroSeleccionado(cConjurosSeleccionados5,"0"),
				new ConjuroSeleccionado(cConjurosSeleccionados6,"0"),
				new ConjuroSeleccionado(cConjurosSeleccionados7,"0"),
				new ConjuroSeleccionado(cConjurosSeleccionados8,"0"),
				new ConjuroSeleccionado(cConjurosSeleccionados9,"0"),
				new ConjuroSeleccionado(cConjurosSeleccionados10,"0"),
				new ConjuroSeleccionado(cConjurosSeleccionados11,"0"),
				new ConjuroSeleccionado(cConjurosSeleccionados12,"0"),
				new ConjuroSeleccionado(cConjurosSeleccionados13,"0"),
				new ConjuroSeleccionado(cConjurosSeleccionados14,"0"),
				new ConjuroSeleccionado(cConjurosSeleccionados15,"0"),
				new ConjuroSeleccionado(cConjurosSeleccionados16,"0"),
				new ConjuroSeleccionado(cConjurosSeleccionados17,"0"),
				new ConjuroSeleccionado(cConjurosSeleccionados18,"0"),
				new ConjuroSeleccionado(cConjurosSeleccionados19,"0"),
				new ConjuroSeleccionado(cConjurosSeleccionados20,"0"),
				new ConjuroSeleccionado(cConjurosSeleccionados21,"0"));
		
		if (0 < nombreSetConjurosLibreAcceso.size()) {
			if (nombreSetConjurosLibreAcceso.get(0)!=null) {
				cConjurosSeleccionados1.setValue(nombreSetConjurosLibreAcceso.get(0));
				TablaConjurosLibreAcceso tablaConjurosLibreAcceso = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, cConjurosSeleccionados1.getValue());
				conjurosLibreAcceso.get(0).setNivel(tablaConjurosLibreAcceso.getNivel());
			}
		}
		
		if (1 < nombreSetConjurosLibreAcceso.size()) {
			if (nombreSetConjurosLibreAcceso.get(1)!=null) {
				cConjurosSeleccionados2.setValue(nombreSetConjurosLibreAcceso.get(1));
				TablaConjurosLibreAcceso tablaConjurosLibreAcceso = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, cConjurosSeleccionados2.getValue());
				conjurosLibreAcceso.get(1).setNivel(tablaConjurosLibreAcceso.getNivel());
			}
		}
		
		if (2 < nombreSetConjurosLibreAcceso.size()) {
			if (nombreSetConjurosLibreAcceso.get(2)!=null) {
				cConjurosSeleccionados3.setValue(nombreSetConjurosLibreAcceso.get(2));
				TablaConjurosLibreAcceso tablaConjurosLibreAcceso = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, cConjurosSeleccionados3.getValue());
				conjurosLibreAcceso.get(2).setNivel(tablaConjurosLibreAcceso.getNivel());
			}
		}
		
		if (3 < nombreSetConjurosLibreAcceso.size()) {
			if (nombreSetConjurosLibreAcceso.get(3)!=null) {
				cConjurosSeleccionados4.setValue(nombreSetConjurosLibreAcceso.get(3));
				TablaConjurosLibreAcceso tablaConjurosLibreAcceso = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, cConjurosSeleccionados4.getValue());
				conjurosLibreAcceso.get(3).setNivel(tablaConjurosLibreAcceso.getNivel());
			}
		}
		
		if (4 < nombreSetConjurosLibreAcceso.size()) {
			if (nombreSetConjurosLibreAcceso.get(4)!=null) {
				cConjurosSeleccionados5.setValue(nombreSetConjurosLibreAcceso.get(4));
				TablaConjurosLibreAcceso tablaConjurosLibreAcceso = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, cConjurosSeleccionados5.getValue());
				conjurosLibreAcceso.get(4).setNivel(tablaConjurosLibreAcceso.getNivel());
			}
		}
		
		if (5 < nombreSetConjurosLibreAcceso.size()) {
			if (nombreSetConjurosLibreAcceso.get(5)!=null) {
				cConjurosSeleccionados6.setValue(nombreSetConjurosLibreAcceso.get(1));
				TablaConjurosLibreAcceso tablaConjurosLibreAcceso = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, cConjurosSeleccionados6.getValue());
				conjurosLibreAcceso.get(5).setNivel(tablaConjurosLibreAcceso.getNivel());
			}
		}
		
		if (6 < nombreSetConjurosLibreAcceso.size()) {
			if (nombreSetConjurosLibreAcceso.get(6)!=null) {
				cConjurosSeleccionados7.setValue(nombreSetConjurosLibreAcceso.get(3));
				TablaConjurosLibreAcceso tablaConjurosLibreAcceso = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, cConjurosSeleccionados7.getValue());
				conjurosLibreAcceso.get(6).setNivel(tablaConjurosLibreAcceso.getNivel());
			}
		}
		
		if (7 < nombreSetConjurosLibreAcceso.size()) {
			if (nombreSetConjurosLibreAcceso.get(7)!=null) {
				cConjurosSeleccionados8.setValue(nombreSetConjurosLibreAcceso.get(4));
				TablaConjurosLibreAcceso tablaConjurosLibreAcceso = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, cConjurosSeleccionados8.getValue());
				conjurosLibreAcceso.get(7).setNivel(tablaConjurosLibreAcceso.getNivel());
			}
		}
		
		if (8 < nombreSetConjurosLibreAcceso.size()) {
			if (nombreSetConjurosLibreAcceso.get(8)!=null) {
				cConjurosSeleccionados9.setValue(nombreSetConjurosLibreAcceso.get(8));
				TablaConjurosLibreAcceso tablaConjurosLibreAcceso = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, cConjurosSeleccionados9.getValue());
				conjurosLibreAcceso.get(8).setNivel(tablaConjurosLibreAcceso.getNivel());
			}
		}
		
		if (9 < nombreSetConjurosLibreAcceso.size()) {
			if (nombreSetConjurosLibreAcceso.get(9)!=null) {
				cConjurosSeleccionados10.setValue(nombreSetConjurosLibreAcceso.get(9));
				TablaConjurosLibreAcceso tablaConjurosLibreAcceso = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, cConjurosSeleccionados10.getValue());
				conjurosLibreAcceso.get(9).setNivel(tablaConjurosLibreAcceso.getNivel());
			}
		}
		
		if (10 < nombreSetConjurosLibreAcceso.size()) {
			if (nombreSetConjurosLibreAcceso.get(10)!=null) {
				cConjurosSeleccionados11.setValue(nombreSetConjurosLibreAcceso.get(10));
				TablaConjurosLibreAcceso tablaConjurosLibreAcceso = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, cConjurosSeleccionados11.getValue());
				conjurosLibreAcceso.get(10).setNivel(tablaConjurosLibreAcceso.getNivel());
			}
		}
		
		if (11 < nombreSetConjurosLibreAcceso.size()) {
			if (nombreSetConjurosLibreAcceso.get(11)!=null) {
				cConjurosSeleccionados12.setValue(nombreSetConjurosLibreAcceso.get(11));
				TablaConjurosLibreAcceso tablaConjurosLibreAcceso = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, cConjurosSeleccionados12.getValue());
				conjurosLibreAcceso.get(11).setNivel(tablaConjurosLibreAcceso.getNivel());
			}
		}
		
		if (12 < nombreSetConjurosLibreAcceso.size()) {
			if (nombreSetConjurosLibreAcceso.get(12)!=null) {
				cConjurosSeleccionados13.setValue(nombreSetConjurosLibreAcceso.get(12));
				TablaConjurosLibreAcceso tablaConjurosLibreAcceso = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, cConjurosSeleccionados13.getValue());
				conjurosLibreAcceso.get(12).setNivel(tablaConjurosLibreAcceso.getNivel());
			}
		}
		
		if (13 < nombreSetConjurosLibreAcceso.size()) {
			if (nombreSetConjurosLibreAcceso.get(13)!=null) {
				cConjurosSeleccionados14.setValue(nombreSetConjurosLibreAcceso.get(13));
				TablaConjurosLibreAcceso tablaConjurosLibreAcceso = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, cConjurosSeleccionados14.getValue());
				conjurosLibreAcceso.get(13).setNivel(tablaConjurosLibreAcceso.getNivel());
			}
		}
		
		if (14 < nombreSetConjurosLibreAcceso.size()) {
			if (nombreSetConjurosLibreAcceso.get(14)!=null) {
				cConjurosSeleccionados15.setValue(nombreSetConjurosLibreAcceso.get(14));
				TablaConjurosLibreAcceso tablaConjurosLibreAcceso = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, cConjurosSeleccionados15.getValue());
				conjurosLibreAcceso.get(14).setNivel(tablaConjurosLibreAcceso.getNivel());
			}
		}
		
		if (15 < nombreSetConjurosLibreAcceso.size()) {
			if (nombreSetConjurosLibreAcceso.get(15)!=null) {
				cConjurosSeleccionados16.setValue(nombreSetConjurosLibreAcceso.get(15));
				TablaConjurosLibreAcceso tablaConjurosLibreAcceso = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, cConjurosSeleccionados16.getValue());
				conjurosLibreAcceso.get(15).setNivel(tablaConjurosLibreAcceso.getNivel());
			}
		}
		
		if (16 < nombreSetConjurosLibreAcceso.size()) {
			if (nombreSetConjurosLibreAcceso.get(16)!=null) {
				cConjurosSeleccionados17.setValue(nombreSetConjurosLibreAcceso.get(16));
				TablaConjurosLibreAcceso tablaConjurosLibreAcceso = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, cConjurosSeleccionados17.getValue());
				conjurosLibreAcceso.get(16).setNivel(tablaConjurosLibreAcceso.getNivel());
			}
		}
		
		if (17 < nombreSetConjurosLibreAcceso.size()) {
			if (nombreSetConjurosLibreAcceso.get(17)!=null) {
				cConjurosSeleccionados18.setValue(nombreSetConjurosLibreAcceso.get(17));
				TablaConjurosLibreAcceso tablaConjurosLibreAcceso = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, cConjurosSeleccionados18.getValue());
				conjurosLibreAcceso.get(17).setNivel(tablaConjurosLibreAcceso.getNivel());
			}
		}
		
		if (18 < nombreSetConjurosLibreAcceso.size()) {
			if (nombreSetConjurosLibreAcceso.get(18)!=null) {
				cConjurosSeleccionados19.setValue(nombreSetConjurosLibreAcceso.get(18));
				TablaConjurosLibreAcceso tablaConjurosLibreAcceso = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, cConjurosSeleccionados19.getValue());
				conjurosLibreAcceso.get(18).setNivel(tablaConjurosLibreAcceso.getNivel());
			}
		}
		
		if (19 < nombreSetConjurosLibreAcceso.size()) {
			if (nombreSetConjurosLibreAcceso.get(19)!=null) {
				cConjurosSeleccionados20.setValue(nombreSetConjurosLibreAcceso.get(19));
				TablaConjurosLibreAcceso tablaConjurosLibreAcceso = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, cConjurosSeleccionados20.getValue());
				conjurosLibreAcceso.get(19).setNivel(tablaConjurosLibreAcceso.getNivel());
			}
		}
		
		if (20 < nombreSetConjurosLibreAcceso.size()) {
			if (nombreSetConjurosLibreAcceso.get(20)!=null) {
				cConjurosSeleccionados21.setValue(nombreSetConjurosLibreAcceso.get(20));
				TablaConjurosLibreAcceso tablaConjurosLibreAcceso = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, cConjurosSeleccionados21.getValue());
				conjurosLibreAcceso.get(20).setNivel(tablaConjurosLibreAcceso.getNivel());
			}
		}
		
		cConjurosSeleccionados1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				TablaConjurosLibreAcceso tablaConjurosLibreAcceso = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, cConjurosSeleccionados1.getSelectionModel().getSelectedItem());
				ConjuroSeleccionado conjuroSeleccionado = conjurosLibreAcceso.get(0); 
				conjuroSeleccionado.setNivel(String.valueOf(tablaConjurosLibreAcceso.getNivel()));
				
				tableViewConjurosLibreAcceso.refresh();
			}
		});
		
		cConjurosSeleccionados2.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				TablaConjurosLibreAcceso tablaConjurosLibreAcceso = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, cConjurosSeleccionados2.getSelectionModel().getSelectedItem());
				ConjuroSeleccionado conjuroSeleccionado = conjurosLibreAcceso.get(1); 
				conjuroSeleccionado.setNivel(String.valueOf(tablaConjurosLibreAcceso.getNivel()));
				
				tableViewConjurosLibreAcceso.refresh();
			}
		});
		
		cConjurosSeleccionados3.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				TablaConjurosLibreAcceso tablaConjurosLibreAcceso = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, cConjurosSeleccionados3.getSelectionModel().getSelectedItem());
				ConjuroSeleccionado conjuroSeleccionado = conjurosLibreAcceso.get(2); 
				conjuroSeleccionado.setNivel(String.valueOf(tablaConjurosLibreAcceso.getNivel()));
				
				tableViewConjurosLibreAcceso.refresh();
			}
		});
		
		cConjurosSeleccionados4.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				TablaConjurosLibreAcceso tablaConjurosLibreAcceso = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, cConjurosSeleccionados4.getSelectionModel().getSelectedItem());
				ConjuroSeleccionado conjuroSeleccionado = conjurosLibreAcceso.get(3); 
				conjuroSeleccionado.setNivel(String.valueOf(tablaConjurosLibreAcceso.getNivel()));
				
				tableViewConjurosLibreAcceso.refresh();
			}
		});
		
		cConjurosSeleccionados5.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				TablaConjurosLibreAcceso tablaConjurosLibreAcceso = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, cConjurosSeleccionados5.getSelectionModel().getSelectedItem());
				ConjuroSeleccionado conjuroSeleccionado = conjurosLibreAcceso.get(4); 
				conjuroSeleccionado.setNivel(String.valueOf(tablaConjurosLibreAcceso.getNivel()));
				
				tableViewConjurosLibreAcceso.refresh();
			}
		});
		
		cConjurosSeleccionados6.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				TablaConjurosLibreAcceso tablaConjurosLibreAcceso = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, cConjurosSeleccionados6.getSelectionModel().getSelectedItem());
				ConjuroSeleccionado conjuroSeleccionado = conjurosLibreAcceso.get(5); 
				conjuroSeleccionado.setNivel(String.valueOf(tablaConjurosLibreAcceso.getNivel()));
				
				tableViewConjurosLibreAcceso.refresh();
			}
		});
		
		cConjurosSeleccionados7.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				TablaConjurosLibreAcceso tablaConjurosLibreAcceso = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, cConjurosSeleccionados7.getSelectionModel().getSelectedItem());
				ConjuroSeleccionado conjuroSeleccionado = conjurosLibreAcceso.get(6); 
				conjuroSeleccionado.setNivel(String.valueOf(tablaConjurosLibreAcceso.getNivel()));
				
				tableViewConjurosLibreAcceso.refresh();
			}
		});
		
		cConjurosSeleccionados8.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				TablaConjurosLibreAcceso tablaConjurosLibreAcceso = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, cConjurosSeleccionados8.getSelectionModel().getSelectedItem());
				ConjuroSeleccionado conjuroSeleccionado = conjurosLibreAcceso.get(7); 
				conjuroSeleccionado.setNivel(String.valueOf(tablaConjurosLibreAcceso.getNivel()));
				
				tableViewConjurosLibreAcceso.refresh();
			}
		});
		
		cConjurosSeleccionados9.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				TablaConjurosLibreAcceso tablaConjurosLibreAcceso = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, cConjurosSeleccionados9.getSelectionModel().getSelectedItem());
				ConjuroSeleccionado conjuroSeleccionado = conjurosLibreAcceso.get(8); 
				conjuroSeleccionado.setNivel(String.valueOf(tablaConjurosLibreAcceso.getNivel()));
				
				tableViewConjurosLibreAcceso.refresh();
			}
		});
		
		cConjurosSeleccionados10.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				TablaConjurosLibreAcceso tablaConjurosLibreAcceso = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, cConjurosSeleccionados10.getSelectionModel().getSelectedItem());
				ConjuroSeleccionado conjuroSeleccionado = conjurosLibreAcceso.get(9); 
				conjuroSeleccionado.setNivel(String.valueOf(tablaConjurosLibreAcceso.getNivel()));
				
				tableViewConjurosLibreAcceso.refresh();
			}
		});
		
		cConjurosSeleccionados11.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				TablaConjurosLibreAcceso tablaConjurosLibreAcceso = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, cConjurosSeleccionados11.getSelectionModel().getSelectedItem());
				ConjuroSeleccionado conjuroSeleccionado = conjurosLibreAcceso.get(10); 
				conjuroSeleccionado.setNivel(String.valueOf(tablaConjurosLibreAcceso.getNivel()));
				
				tableViewConjurosLibreAcceso.refresh();
			}
		});
		
		cConjurosSeleccionados12.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				TablaConjurosLibreAcceso tablaConjurosLibreAcceso = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, cConjurosSeleccionados12.getSelectionModel().getSelectedItem());
				ConjuroSeleccionado conjuroSeleccionado = conjurosLibreAcceso.get(11); 
				conjuroSeleccionado.setNivel(String.valueOf(tablaConjurosLibreAcceso.getNivel()));
				
				tableViewConjurosLibreAcceso.refresh();
			}
		});
		
		cConjurosSeleccionados13.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				TablaConjurosLibreAcceso tablaConjurosLibreAcceso = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, cConjurosSeleccionados13.getSelectionModel().getSelectedItem());
				ConjuroSeleccionado conjuroSeleccionado = conjurosLibreAcceso.get(12); 
				conjuroSeleccionado.setNivel(String.valueOf(tablaConjurosLibreAcceso.getNivel()));
				
				tableViewConjurosLibreAcceso.refresh();
			}
		});
		
		cConjurosSeleccionados14.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				TablaConjurosLibreAcceso tablaConjurosLibreAcceso = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, cConjurosSeleccionados14.getSelectionModel().getSelectedItem());
				ConjuroSeleccionado conjuroSeleccionado = conjurosLibreAcceso.get(13); 
				conjuroSeleccionado.setNivel(String.valueOf(tablaConjurosLibreAcceso.getNivel()));
				
				tableViewConjurosLibreAcceso.refresh();
			}
		});
		
		cConjurosSeleccionados15.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				TablaConjurosLibreAcceso tablaConjurosLibreAcceso = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, cConjurosSeleccionados15.getSelectionModel().getSelectedItem());
				ConjuroSeleccionado conjuroSeleccionado = conjurosLibreAcceso.get(14); 
				conjuroSeleccionado.setNivel(String.valueOf(tablaConjurosLibreAcceso.getNivel()));
				
				tableViewConjurosLibreAcceso.refresh();
			}
		});
		
		cConjurosSeleccionados16.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				TablaConjurosLibreAcceso tablaConjurosLibreAcceso = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, cConjurosSeleccionados16.getSelectionModel().getSelectedItem());
				ConjuroSeleccionado conjuroSeleccionado = conjurosLibreAcceso.get(15); 
				conjuroSeleccionado.setNivel(String.valueOf(tablaConjurosLibreAcceso.getNivel()));
				
				tableViewConjurosLibreAcceso.refresh();
			}
		});
		
		cConjurosSeleccionados17.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				TablaConjurosLibreAcceso tablaConjurosLibreAcceso = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, cConjurosSeleccionados17.getSelectionModel().getSelectedItem());
				ConjuroSeleccionado conjuroSeleccionado = conjurosLibreAcceso.get(16); 
				conjuroSeleccionado.setNivel(String.valueOf(tablaConjurosLibreAcceso.getNivel()));
				
				tableViewConjurosLibreAcceso.refresh();
			}
		});
		
		cConjurosSeleccionados18.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				TablaConjurosLibreAcceso tablaConjurosLibreAcceso = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, cConjurosSeleccionados18.getSelectionModel().getSelectedItem());
				ConjuroSeleccionado conjuroSeleccionado = conjurosLibreAcceso.get(17); 
				conjuroSeleccionado.setNivel(String.valueOf(tablaConjurosLibreAcceso.getNivel()));
				
				tableViewConjurosLibreAcceso.refresh();
			}
		});
		
		cConjurosSeleccionados19.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				TablaConjurosLibreAcceso tablaConjurosLibreAcceso = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, cConjurosSeleccionados19.getSelectionModel().getSelectedItem());
				ConjuroSeleccionado conjuroSeleccionado = conjurosLibreAcceso.get(18); 
				conjuroSeleccionado.setNivel(String.valueOf(tablaConjurosLibreAcceso.getNivel()));
				
				tableViewConjurosLibreAcceso.refresh();
			}
		});
		
		cConjurosSeleccionados20.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				TablaConjurosLibreAcceso tablaConjurosLibreAcceso = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, cConjurosSeleccionados20.getSelectionModel().getSelectedItem());
				ConjuroSeleccionado conjuroSeleccionado = conjurosLibreAcceso.get(19); 
				conjuroSeleccionado.setNivel(String.valueOf(tablaConjurosLibreAcceso.getNivel()));
				
				tableViewConjurosLibreAcceso.refresh();
			}
		});
		
		cConjurosSeleccionados21.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				TablaConjurosLibreAcceso tablaConjurosLibreAcceso = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, cConjurosSeleccionados21.getSelectionModel().getSelectedItem());
				ConjuroSeleccionado conjuroSeleccionado = conjurosLibreAcceso.get(20); 
				conjuroSeleccionado.setNivel(String.valueOf(tablaConjurosLibreAcceso.getNivel()));
				
				tableViewConjurosLibreAcceso.refresh();
			}
		});
		
		
		colConjurosLibreAccesoNombre.setCellValueFactory(new PropertyValueFactory<ConjuroSeleccionado, ComboBox<String>>("nombreConjuroLibreAcceso"));
		colConjurosLibreAccesoNivel.setCellValueFactory(new PropertyValueFactory<ConjuroSeleccionado, String>("nivel"));
		
		tableViewConjurosLibreAcceso.setItems(conjurosLibreAcceso);
		
	}
	
	public void obtenerTablaPoderesPsiquicos(ObservableList<String> nombresPoderesPsiquicos) {
		ComboBox<String> cPoderPsiquicoSeleccionado1 = new ComboBox<String>();
		cPoderPsiquicoSeleccionado1.setItems(nombresPoderesPsiquicos);
		cPoderPsiquicoSeleccionado1.setPrefWidth(colConjurosLibreAccesoNombre.getPrefWidth());
		ComboBox<String> cPoderPsiquicoSeleccionado2 = new ComboBox<String>();
		cPoderPsiquicoSeleccionado2.setItems(nombresPoderesPsiquicos);
		cPoderPsiquicoSeleccionado2.setPrefWidth(colConjurosLibreAccesoNombre.getPrefWidth());
		
		ComboBox<String> cPoderPsiquicoSeleccionado3 = new ComboBox<String>();
		cPoderPsiquicoSeleccionado3.setItems(nombresPoderesPsiquicos);
		cPoderPsiquicoSeleccionado3.setPrefWidth(colConjurosLibreAccesoNombre.getPrefWidth());
		ComboBox<String> cPoderPsiquicoSeleccionado4 = new ComboBox<String>();
		cPoderPsiquicoSeleccionado4.setItems(nombresPoderesPsiquicos);
		cPoderPsiquicoSeleccionado4.setPrefWidth(colConjurosLibreAccesoNombre.getPrefWidth());
		
		ComboBox<String> cPoderPsiquicoSeleccionado5 = new ComboBox<String>();
		cPoderPsiquicoSeleccionado5.setItems(nombresPoderesPsiquicos);
		cPoderPsiquicoSeleccionado5.setPrefWidth(colConjurosLibreAccesoNombre.getPrefWidth());
		ComboBox<String> cPoderPsiquicoSeleccionado6 = new ComboBox<String>();
		cPoderPsiquicoSeleccionado6.setItems(nombresPoderesPsiquicos);
		cPoderPsiquicoSeleccionado6.setPrefWidth(colConjurosLibreAccesoNombre.getPrefWidth());
		
		ComboBox<String> cPoderPsiquicoSeleccionado7 = new ComboBox<String>();
		cPoderPsiquicoSeleccionado7.setItems(nombresPoderesPsiquicos);
		cPoderPsiquicoSeleccionado7.setPrefWidth(colConjurosLibreAccesoNombre.getPrefWidth());
		ComboBox<String> cPoderPsiquicoSeleccionado8 = new ComboBox<String>();
		cPoderPsiquicoSeleccionado8.setItems(nombresPoderesPsiquicos);
		cPoderPsiquicoSeleccionado8.setPrefWidth(colConjurosLibreAccesoNombre.getPrefWidth());
		
		ComboBox<String> cPoderPsiquicoSeleccionado9 = new ComboBox<String>();
		cPoderPsiquicoSeleccionado9.setItems(nombresPoderesPsiquicos);
		cPoderPsiquicoSeleccionado9.setPrefWidth(colConjurosLibreAccesoNombre.getPrefWidth());
		ComboBox<String> cPoderPsiquicoSeleccionado10 = new ComboBox<String>();
		cPoderPsiquicoSeleccionado10.setItems(nombresPoderesPsiquicos);
		cPoderPsiquicoSeleccionado10.setPrefWidth(colConjurosLibreAccesoNombre.getPrefWidth());
		
		ComboBox<String> cPoderPsiquicoSeleccionado11 = new ComboBox<String>();
		cPoderPsiquicoSeleccionado11.setItems(nombresPoderesPsiquicos);
		cPoderPsiquicoSeleccionado11.setPrefWidth(colConjurosLibreAccesoNombre.getPrefWidth());
		ComboBox<String> cPoderPsiquicoSeleccionado12 = new ComboBox<String>();
		cPoderPsiquicoSeleccionado12.setItems(nombresPoderesPsiquicos);
		cPoderPsiquicoSeleccionado12.setPrefWidth(colConjurosLibreAccesoNombre.getPrefWidth());
		
		ComboBox<String> cPoderPsiquicoSeleccionado13 = new ComboBox<String>();
		cPoderPsiquicoSeleccionado13.setItems(nombresPoderesPsiquicos);
		cPoderPsiquicoSeleccionado13.setPrefWidth(colConjurosLibreAccesoNombre.getPrefWidth());
		ComboBox<String> cPoderPsiquicoSeleccionado14 = new ComboBox<String>();
		cPoderPsiquicoSeleccionado14.setItems(nombresPoderesPsiquicos);
		cPoderPsiquicoSeleccionado14.setPrefWidth(colConjurosLibreAccesoNombre.getPrefWidth());
		
		ComboBox<String> cPoderPsiquicoSeleccionado15 = new ComboBox<String>();
		cPoderPsiquicoSeleccionado15.setItems(nombresPoderesPsiquicos);
		cPoderPsiquicoSeleccionado15.setPrefWidth(colConjurosLibreAccesoNombre.getPrefWidth());
		ComboBox<String> cPoderPsiquicoSeleccionado16 = new ComboBox<String>();
		cPoderPsiquicoSeleccionado16.setItems(nombresPoderesPsiquicos);
		cPoderPsiquicoSeleccionado16.setPrefWidth(colConjurosLibreAccesoNombre.getPrefWidth());
		
		ComboBox<String> cPoderPsiquicoSeleccionado17 = new ComboBox<String>();
		cPoderPsiquicoSeleccionado17.setItems(nombresPoderesPsiquicos);
		cPoderPsiquicoSeleccionado17.setPrefWidth(colConjurosLibreAccesoNombre.getPrefWidth());
		ComboBox<String> cPoderPsiquicoSeleccionado18 = new ComboBox<String>();
		cPoderPsiquicoSeleccionado18.setItems(nombresPoderesPsiquicos);
		cPoderPsiquicoSeleccionado18.setPrefWidth(colConjurosLibreAccesoNombre.getPrefWidth());
		
		ComboBox<String> cPoderPsiquicoSeleccionado19 = new ComboBox<String>();
		cPoderPsiquicoSeleccionado19.setItems(nombresPoderesPsiquicos);
		cPoderPsiquicoSeleccionado19.setPrefWidth(colConjurosLibreAccesoNombre.getPrefWidth());
		ComboBox<String> cPoderPsiquicoSeleccionado20 = new ComboBox<String>();
		cPoderPsiquicoSeleccionado20.setItems(nombresPoderesPsiquicos);
		cPoderPsiquicoSeleccionado20.setPrefWidth(colConjurosLibreAccesoNombre.getPrefWidth());
		
		ArrayList<String> nombreSetPoderPsiquico = new ArrayList<String>();
		for (PoderPsiquico poderPsiquico : personaje.getPoderPsiquicos()) {
			nombreSetPoderPsiquico.add(poderPsiquico.getNombre());
		}
		
		ObservableList<PoderPsiquicoSeleccionado> poderesPsiquicosSeleccionados = FXCollections.observableArrayList(
				new PoderPsiquicoSeleccionado(cPoderPsiquicoSeleccionado1,"","0"),
				new PoderPsiquicoSeleccionado(cPoderPsiquicoSeleccionado2,"","0"),
				new PoderPsiquicoSeleccionado(cPoderPsiquicoSeleccionado3,"","0"),
				new PoderPsiquicoSeleccionado(cPoderPsiquicoSeleccionado4,"","0"),
				new PoderPsiquicoSeleccionado(cPoderPsiquicoSeleccionado5,"","0"),
				new PoderPsiquicoSeleccionado(cPoderPsiquicoSeleccionado6,"","0"),
				new PoderPsiquicoSeleccionado(cPoderPsiquicoSeleccionado7,"","0"),
				new PoderPsiquicoSeleccionado(cPoderPsiquicoSeleccionado8,"","0"),
				new PoderPsiquicoSeleccionado(cPoderPsiquicoSeleccionado9,"","0"),
				new PoderPsiquicoSeleccionado(cPoderPsiquicoSeleccionado10,"","0"),
				new PoderPsiquicoSeleccionado(cPoderPsiquicoSeleccionado11,"","0"),
				new PoderPsiquicoSeleccionado(cPoderPsiquicoSeleccionado12,"","0"),
				new PoderPsiquicoSeleccionado(cPoderPsiquicoSeleccionado13,"","0"),
				new PoderPsiquicoSeleccionado(cPoderPsiquicoSeleccionado14,"","0"),
				new PoderPsiquicoSeleccionado(cPoderPsiquicoSeleccionado15,"","0"),
				new PoderPsiquicoSeleccionado(cPoderPsiquicoSeleccionado16,"","0"),
				new PoderPsiquicoSeleccionado(cPoderPsiquicoSeleccionado17,"","0"),
				new PoderPsiquicoSeleccionado(cPoderPsiquicoSeleccionado18,"","0"),
				new PoderPsiquicoSeleccionado(cPoderPsiquicoSeleccionado19,"","0"),
				new PoderPsiquicoSeleccionado(cPoderPsiquicoSeleccionado20,"","0"));
		

		if (0 < nombreSetPoderPsiquico.size()) {
			if (nombreSetPoderPsiquico.get(0)!=null) {
				cPoderPsiquicoSeleccionado1.setValue(nombreSetPoderPsiquico.get(0));
				PoderPsiquico poderPsiquico = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, cPoderPsiquicoSeleccionado1.getValue());
				poderesPsiquicosSeleccionados.get(0).setDisciplinaPoderSeleccionado(poderPsiquico.getDisciplina());
				poderesPsiquicosSeleccionados.get(0).setNivelPoderSeleccionado(String.valueOf(poderPsiquico.getNivel()));
			}
		}
		
		if (1 < nombreSetPoderPsiquico.size()) {
			if (nombreSetPoderPsiquico.get(1)!=null) {
				cPoderPsiquicoSeleccionado2.setValue(nombreSetPoderPsiquico.get(1));
				PoderPsiquico poderPsiquico = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, cPoderPsiquicoSeleccionado2.getValue());
				poderesPsiquicosSeleccionados.get(1).setDisciplinaPoderSeleccionado(poderPsiquico.getDisciplina());
				poderesPsiquicosSeleccionados.get(1).setNivelPoderSeleccionado(String.valueOf(poderPsiquico.getNivel()));
			}
		}
		
		if (2 < nombreSetPoderPsiquico.size()) {
			if (nombreSetPoderPsiquico.get(2)!=null) {
				cPoderPsiquicoSeleccionado3.setValue(nombreSetPoderPsiquico.get(2));
				PoderPsiquico poderPsiquico = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, cPoderPsiquicoSeleccionado3.getValue());
				poderesPsiquicosSeleccionados.get(2).setDisciplinaPoderSeleccionado(poderPsiquico.getDisciplina());
				poderesPsiquicosSeleccionados.get(2).setNivelPoderSeleccionado(String.valueOf(poderPsiquico.getNivel()));
			}
		}
		
		if (3 < nombreSetPoderPsiquico.size()) {
			if (nombreSetPoderPsiquico.get(3)!=null) {
				cPoderPsiquicoSeleccionado4.setValue(nombreSetPoderPsiquico.get(3));
				PoderPsiquico poderPsiquico = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, cPoderPsiquicoSeleccionado4.getValue());
				poderesPsiquicosSeleccionados.get(3).setDisciplinaPoderSeleccionado(poderPsiquico.getDisciplina());
				poderesPsiquicosSeleccionados.get(3).setNivelPoderSeleccionado(String.valueOf(poderPsiquico.getNivel()));
			}
		}
		
		if (4 < nombreSetPoderPsiquico.size()) {
			if (nombreSetPoderPsiquico.get(4)!=null) {
				cPoderPsiquicoSeleccionado5.setValue(nombreSetPoderPsiquico.get(4));
				PoderPsiquico poderPsiquico = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, cPoderPsiquicoSeleccionado5.getValue());
				poderesPsiquicosSeleccionados.get(4).setDisciplinaPoderSeleccionado(poderPsiquico.getDisciplina());
				poderesPsiquicosSeleccionados.get(4).setNivelPoderSeleccionado(String.valueOf(poderPsiquico.getNivel()));
			}
		}
		
		if (5 < nombreSetPoderPsiquico.size()) {
			if (nombreSetPoderPsiquico.get(5)!=null) {
				cPoderPsiquicoSeleccionado6.setValue(nombreSetPoderPsiquico.get(1));
				PoderPsiquico poderPsiquico = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, cPoderPsiquicoSeleccionado6.getValue());
				poderesPsiquicosSeleccionados.get(5).setDisciplinaPoderSeleccionado(poderPsiquico.getDisciplina());
				poderesPsiquicosSeleccionados.get(5).setNivelPoderSeleccionado(String.valueOf(poderPsiquico.getNivel()));
			}
		}
		
		if (6 < nombreSetPoderPsiquico.size()) {
			if (nombreSetPoderPsiquico.get(6)!=null) {
				cPoderPsiquicoSeleccionado7.setValue(nombreSetPoderPsiquico.get(3));
				PoderPsiquico poderPsiquico = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, cPoderPsiquicoSeleccionado7.getValue());
				poderesPsiquicosSeleccionados.get(6).setDisciplinaPoderSeleccionado(poderPsiquico.getDisciplina());
				poderesPsiquicosSeleccionados.get(6).setNivelPoderSeleccionado(String.valueOf(poderPsiquico.getNivel()));
			}
		}
		
		if (7 < nombreSetPoderPsiquico.size()) {
			if (nombreSetPoderPsiquico.get(7)!=null) {
				cPoderPsiquicoSeleccionado8.setValue(nombreSetPoderPsiquico.get(4));
				PoderPsiquico poderPsiquico = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, cPoderPsiquicoSeleccionado8.getValue());
				poderesPsiquicosSeleccionados.get(7).setDisciplinaPoderSeleccionado(poderPsiquico.getDisciplina());
				poderesPsiquicosSeleccionados.get(7).setNivelPoderSeleccionado(String.valueOf(poderPsiquico.getNivel()));
			}
		}
		
		if (8 < nombreSetPoderPsiquico.size()) {
			if (nombreSetPoderPsiquico.get(8)!=null) {
				cPoderPsiquicoSeleccionado9.setValue(nombreSetPoderPsiquico.get(8));
				PoderPsiquico poderPsiquico = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, cPoderPsiquicoSeleccionado9.getValue());
				poderesPsiquicosSeleccionados.get(8).setDisciplinaPoderSeleccionado(poderPsiquico.getDisciplina());
				poderesPsiquicosSeleccionados.get(8).setNivelPoderSeleccionado(String.valueOf(poderPsiquico.getNivel()));
			}
		}
		
		if (9 < nombreSetPoderPsiquico.size()) {
			if (nombreSetPoderPsiquico.get(9)!=null) {
				cPoderPsiquicoSeleccionado10.setValue(nombreSetPoderPsiquico.get(9));
				PoderPsiquico poderPsiquico = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, cPoderPsiquicoSeleccionado10.getValue());
				poderesPsiquicosSeleccionados.get(9).setDisciplinaPoderSeleccionado(poderPsiquico.getDisciplina());
				poderesPsiquicosSeleccionados.get(9).setNivelPoderSeleccionado(String.valueOf(poderPsiquico.getNivel()));
			}
		}
		
		if (10 < nombreSetPoderPsiquico.size()) {
			if (nombreSetPoderPsiquico.get(10)!=null) {
				cPoderPsiquicoSeleccionado11.setValue(nombreSetPoderPsiquico.get(10));
				PoderPsiquico poderPsiquico = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, cPoderPsiquicoSeleccionado11.getValue());
				poderesPsiquicosSeleccionados.get(10).setDisciplinaPoderSeleccionado(poderPsiquico.getDisciplina());
				poderesPsiquicosSeleccionados.get(10).setNivelPoderSeleccionado(String.valueOf(poderPsiquico.getNivel()));
			}
		}
		
		if (11 < nombreSetPoderPsiquico.size()) {
			if (nombreSetPoderPsiquico.get(11)!=null) {
				cPoderPsiquicoSeleccionado12.setValue(nombreSetPoderPsiquico.get(11));
				PoderPsiquico poderPsiquico = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, cPoderPsiquicoSeleccionado12.getValue());
				poderesPsiquicosSeleccionados.get(11).setDisciplinaPoderSeleccionado(poderPsiquico.getDisciplina());
				poderesPsiquicosSeleccionados.get(11).setNivelPoderSeleccionado(String.valueOf(poderPsiquico.getNivel()));
			}
		}
		
		if (12 < nombreSetPoderPsiquico.size()) {
			if (nombreSetPoderPsiquico.get(12)!=null) {
				cPoderPsiquicoSeleccionado13.setValue(nombreSetPoderPsiquico.get(12));
				PoderPsiquico poderPsiquico = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, cPoderPsiquicoSeleccionado13.getValue());
				poderesPsiquicosSeleccionados.get(12).setDisciplinaPoderSeleccionado(poderPsiquico.getDisciplina());
				poderesPsiquicosSeleccionados.get(12).setNivelPoderSeleccionado(String.valueOf(poderPsiquico.getNivel()));
			}
		}
		
		if (13 < nombreSetPoderPsiquico.size()) {
			if (nombreSetPoderPsiquico.get(13)!=null) {
				cPoderPsiquicoSeleccionado14.setValue(nombreSetPoderPsiquico.get(13));
				PoderPsiquico poderPsiquico = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, cPoderPsiquicoSeleccionado14.getValue());
				poderesPsiquicosSeleccionados.get(13).setDisciplinaPoderSeleccionado(poderPsiquico.getDisciplina());
				poderesPsiquicosSeleccionados.get(13).setNivelPoderSeleccionado(String.valueOf(poderPsiquico.getNivel()));
			}
		}
		
		if (14 < nombreSetPoderPsiquico.size()) {
			if (nombreSetPoderPsiquico.get(14)!=null) {
				cPoderPsiquicoSeleccionado15.setValue(nombreSetPoderPsiquico.get(14));
				PoderPsiquico poderPsiquico = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, cPoderPsiquicoSeleccionado15.getValue());
				poderesPsiquicosSeleccionados.get(14).setDisciplinaPoderSeleccionado(poderPsiquico.getDisciplina());
				poderesPsiquicosSeleccionados.get(14).setNivelPoderSeleccionado(String.valueOf(poderPsiquico.getNivel()));
			}
		}
		
		if (15 < nombreSetPoderPsiquico.size()) {
			if (nombreSetPoderPsiquico.get(15)!=null) {
				cPoderPsiquicoSeleccionado16.setValue(nombreSetPoderPsiquico.get(15));
				PoderPsiquico poderPsiquico = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, cPoderPsiquicoSeleccionado16.getValue());
				poderesPsiquicosSeleccionados.get(15).setDisciplinaPoderSeleccionado(poderPsiquico.getDisciplina());
				poderesPsiquicosSeleccionados.get(15).setNivelPoderSeleccionado(String.valueOf(poderPsiquico.getNivel()));
			}
		}
		
		if (16 < nombreSetPoderPsiquico.size()) {
			if (nombreSetPoderPsiquico.get(16)!=null) {
				cPoderPsiquicoSeleccionado17.setValue(nombreSetPoderPsiquico.get(16));
				PoderPsiquico poderPsiquico = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, cPoderPsiquicoSeleccionado17.getValue());
				poderesPsiquicosSeleccionados.get(16).setDisciplinaPoderSeleccionado(poderPsiquico.getDisciplina());
				poderesPsiquicosSeleccionados.get(16).setNivelPoderSeleccionado(String.valueOf(poderPsiquico.getNivel()));
			}
		}
		
		if (17 < nombreSetPoderPsiquico.size()) {
			if (nombreSetPoderPsiquico.get(17)!=null) {
				cPoderPsiquicoSeleccionado18.setValue(nombreSetPoderPsiquico.get(17));
				PoderPsiquico poderPsiquico = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, cPoderPsiquicoSeleccionado18.getValue());
				poderesPsiquicosSeleccionados.get(17).setDisciplinaPoderSeleccionado(poderPsiquico.getDisciplina());
				poderesPsiquicosSeleccionados.get(17).setNivelPoderSeleccionado(String.valueOf(poderPsiquico.getNivel()));
			}
		}
		
		if (18 < nombreSetPoderPsiquico.size()) {
			if (nombreSetPoderPsiquico.get(18)!=null) {
				cPoderPsiquicoSeleccionado19.setValue(nombreSetPoderPsiquico.get(18));
				PoderPsiquico poderPsiquico = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, cPoderPsiquicoSeleccionado19.getValue());
				poderesPsiquicosSeleccionados.get(18).setDisciplinaPoderSeleccionado(poderPsiquico.getDisciplina());
				poderesPsiquicosSeleccionados.get(18).setNivelPoderSeleccionado(String.valueOf(poderPsiquico.getNivel()));
			}
		}
		
		if (19 < nombreSetPoderPsiquico.size()) {
			if (nombreSetPoderPsiquico.get(19)!=null) {
				cPoderPsiquicoSeleccionado20.setValue(nombreSetPoderPsiquico.get(19));
				PoderPsiquico poderPsiquico = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, cPoderPsiquicoSeleccionado20.getValue());
				poderesPsiquicosSeleccionados.get(19).setDisciplinaPoderSeleccionado(poderPsiquico.getDisciplina());
				poderesPsiquicosSeleccionados.get(19).setNivelPoderSeleccionado(String.valueOf(poderPsiquico.getNivel()));
			}
		}
		
		
		cPoderPsiquicoSeleccionado1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				PoderPsiquico poderPsiquico = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, cPoderPsiquicoSeleccionado1.getSelectionModel().getSelectedItem());
				PoderPsiquicoSeleccionado poderPsiquicoSeleccionado = poderesPsiquicosSeleccionados.get(0); 
				poderPsiquicoSeleccionado.setNivelPoderSeleccionado(String.valueOf(poderPsiquico.getNivel()));
				poderPsiquicoSeleccionado.setDisciplinaPoderSeleccionado(poderPsiquico.getDisciplina());
				
				tableViewPoderesPsiquicos.refresh();
			}
		});
		
		cPoderPsiquicoSeleccionado2.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				PoderPsiquico poderPsiquico = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, cPoderPsiquicoSeleccionado2.getSelectionModel().getSelectedItem());
				PoderPsiquicoSeleccionado poderPsiquicoSeleccionado = poderesPsiquicosSeleccionados.get(1); 
				poderPsiquicoSeleccionado.setNivelPoderSeleccionado(String.valueOf(poderPsiquico.getNivel()));
				poderPsiquicoSeleccionado.setDisciplinaPoderSeleccionado(poderPsiquico.getDisciplina());
				
				tableViewPoderesPsiquicos.refresh();
			}
		});
		
		cPoderPsiquicoSeleccionado3.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				PoderPsiquico poderPsiquico = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, cPoderPsiquicoSeleccionado3.getSelectionModel().getSelectedItem());
				PoderPsiquicoSeleccionado poderPsiquicoSeleccionado = poderesPsiquicosSeleccionados.get(2); 
				poderPsiquicoSeleccionado.setNivelPoderSeleccionado(String.valueOf(poderPsiquico.getNivel()));
				poderPsiquicoSeleccionado.setDisciplinaPoderSeleccionado(poderPsiquico.getDisciplina());
				
				tableViewPoderesPsiquicos.refresh();
			}
		});
		
		cPoderPsiquicoSeleccionado4.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				PoderPsiquico poderPsiquico = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, cPoderPsiquicoSeleccionado4.getSelectionModel().getSelectedItem());
				PoderPsiquicoSeleccionado poderPsiquicoSeleccionado = poderesPsiquicosSeleccionados.get(3); 
				poderPsiquicoSeleccionado.setNivelPoderSeleccionado(String.valueOf(poderPsiquico.getNivel()));
				poderPsiquicoSeleccionado.setDisciplinaPoderSeleccionado(poderPsiquico.getDisciplina());
				
				tableViewPoderesPsiquicos.refresh();
			}
		});
		
		cPoderPsiquicoSeleccionado5.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				PoderPsiquico poderPsiquico = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, cPoderPsiquicoSeleccionado5.getSelectionModel().getSelectedItem());
				PoderPsiquicoSeleccionado poderPsiquicoSeleccionado = poderesPsiquicosSeleccionados.get(4); 
				poderPsiquicoSeleccionado.setNivelPoderSeleccionado(String.valueOf(poderPsiquico.getNivel()));
				poderPsiquicoSeleccionado.setDisciplinaPoderSeleccionado(poderPsiquico.getDisciplina());
				
				tableViewPoderesPsiquicos.refresh();
			}
		});
		
		cPoderPsiquicoSeleccionado6.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				PoderPsiquico poderPsiquico = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, cPoderPsiquicoSeleccionado6.getSelectionModel().getSelectedItem());
				PoderPsiquicoSeleccionado poderPsiquicoSeleccionado = poderesPsiquicosSeleccionados.get(5); 
				poderPsiquicoSeleccionado.setNivelPoderSeleccionado(String.valueOf(poderPsiquico.getNivel()));
				poderPsiquicoSeleccionado.setDisciplinaPoderSeleccionado(poderPsiquico.getDisciplina());
				
				tableViewPoderesPsiquicos.refresh();
			}
		});
		
		cPoderPsiquicoSeleccionado7.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				PoderPsiquico poderPsiquico = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, cPoderPsiquicoSeleccionado7.getSelectionModel().getSelectedItem());
				PoderPsiquicoSeleccionado poderPsiquicoSeleccionado = poderesPsiquicosSeleccionados.get(6); 
				poderPsiquicoSeleccionado.setNivelPoderSeleccionado(String.valueOf(poderPsiquico.getNivel()));
				poderPsiquicoSeleccionado.setDisciplinaPoderSeleccionado(poderPsiquico.getDisciplina());
				
				tableViewPoderesPsiquicos.refresh();
			}
		});
		
		cPoderPsiquicoSeleccionado8.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				PoderPsiquico poderPsiquico = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, cPoderPsiquicoSeleccionado8.getSelectionModel().getSelectedItem());
				PoderPsiquicoSeleccionado poderPsiquicoSeleccionado = poderesPsiquicosSeleccionados.get(7); 
				poderPsiquicoSeleccionado.setNivelPoderSeleccionado(String.valueOf(poderPsiquico.getNivel()));
				poderPsiquicoSeleccionado.setDisciplinaPoderSeleccionado(poderPsiquico.getDisciplina());
				
				tableViewPoderesPsiquicos.refresh();
			}
		});
		
		cPoderPsiquicoSeleccionado9.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				PoderPsiquico poderPsiquico = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, cPoderPsiquicoSeleccionado9.getSelectionModel().getSelectedItem());
				PoderPsiquicoSeleccionado poderPsiquicoSeleccionado = poderesPsiquicosSeleccionados.get(8); 
				poderPsiquicoSeleccionado.setNivelPoderSeleccionado(String.valueOf(poderPsiquico.getNivel()));
				poderPsiquicoSeleccionado.setDisciplinaPoderSeleccionado(poderPsiquico.getDisciplina());
				
				tableViewPoderesPsiquicos.refresh();
			}
		});
		
		cPoderPsiquicoSeleccionado10.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				PoderPsiquico poderPsiquico = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, cPoderPsiquicoSeleccionado10.getSelectionModel().getSelectedItem());
				PoderPsiquicoSeleccionado poderPsiquicoSeleccionado = poderesPsiquicosSeleccionados.get(9); 
				poderPsiquicoSeleccionado.setNivelPoderSeleccionado(String.valueOf(poderPsiquico.getNivel()));
				poderPsiquicoSeleccionado.setDisciplinaPoderSeleccionado(poderPsiquico.getDisciplina());
				
				tableViewPoderesPsiquicos.refresh();
			}
		});
		
		cPoderPsiquicoSeleccionado11.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				PoderPsiquico poderPsiquico = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, cPoderPsiquicoSeleccionado11.getSelectionModel().getSelectedItem());
				PoderPsiquicoSeleccionado poderPsiquicoSeleccionado = poderesPsiquicosSeleccionados.get(10); 
				poderPsiquicoSeleccionado.setNivelPoderSeleccionado(String.valueOf(poderPsiquico.getNivel()));
				poderPsiquicoSeleccionado.setDisciplinaPoderSeleccionado(poderPsiquico.getDisciplina());
				
				tableViewPoderesPsiquicos.refresh();
			}
		});
		
		cPoderPsiquicoSeleccionado12.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				PoderPsiquico poderPsiquico = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, cPoderPsiquicoSeleccionado12.getSelectionModel().getSelectedItem());
				PoderPsiquicoSeleccionado poderPsiquicoSeleccionado = poderesPsiquicosSeleccionados.get(11); 
				poderPsiquicoSeleccionado.setNivelPoderSeleccionado(String.valueOf(poderPsiquico.getNivel()));
				poderPsiquicoSeleccionado.setDisciplinaPoderSeleccionado(poderPsiquico.getDisciplina());
				
				tableViewPoderesPsiquicos.refresh();
			}
		});
		
		cPoderPsiquicoSeleccionado13.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				PoderPsiquico poderPsiquico = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, cPoderPsiquicoSeleccionado13.getSelectionModel().getSelectedItem());
				PoderPsiquicoSeleccionado poderPsiquicoSeleccionado = poderesPsiquicosSeleccionados.get(12); 
				poderPsiquicoSeleccionado.setNivelPoderSeleccionado(String.valueOf(poderPsiquico.getNivel()));
				poderPsiquicoSeleccionado.setDisciplinaPoderSeleccionado(poderPsiquico.getDisciplina());
				
				tableViewPoderesPsiquicos.refresh();
			}
		});
		
		cPoderPsiquicoSeleccionado14.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				PoderPsiquico poderPsiquico = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, cPoderPsiquicoSeleccionado14.getSelectionModel().getSelectedItem());
				PoderPsiquicoSeleccionado poderPsiquicoSeleccionado = poderesPsiquicosSeleccionados.get(13); 
				poderPsiquicoSeleccionado.setNivelPoderSeleccionado(String.valueOf(poderPsiquico.getNivel()));
				poderPsiquicoSeleccionado.setDisciplinaPoderSeleccionado(poderPsiquico.getDisciplina());
				
				tableViewPoderesPsiquicos.refresh();
			}
		});
		
		cPoderPsiquicoSeleccionado15.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				PoderPsiquico poderPsiquico = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, cPoderPsiquicoSeleccionado15.getSelectionModel().getSelectedItem());
				PoderPsiquicoSeleccionado poderPsiquicoSeleccionado = poderesPsiquicosSeleccionados.get(14); 
				poderPsiquicoSeleccionado.setNivelPoderSeleccionado(String.valueOf(poderPsiquico.getNivel()));
				poderPsiquicoSeleccionado.setDisciplinaPoderSeleccionado(poderPsiquico.getDisciplina());
				
				tableViewPoderesPsiquicos.refresh();
			}
		});
		
		cPoderPsiquicoSeleccionado16.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				PoderPsiquico poderPsiquico = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, cPoderPsiquicoSeleccionado16.getSelectionModel().getSelectedItem());
				PoderPsiquicoSeleccionado poderPsiquicoSeleccionado = poderesPsiquicosSeleccionados.get(15); 
				poderPsiquicoSeleccionado.setNivelPoderSeleccionado(String.valueOf(poderPsiquico.getNivel()));
				poderPsiquicoSeleccionado.setDisciplinaPoderSeleccionado(poderPsiquico.getDisciplina());
				
				tableViewPoderesPsiquicos.refresh();
			}
		});
		
		cPoderPsiquicoSeleccionado17.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				PoderPsiquico poderPsiquico = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, cPoderPsiquicoSeleccionado17.getSelectionModel().getSelectedItem());
				PoderPsiquicoSeleccionado poderPsiquicoSeleccionado = poderesPsiquicosSeleccionados.get(16); 
				poderPsiquicoSeleccionado.setNivelPoderSeleccionado(String.valueOf(poderPsiquico.getNivel()));
				poderPsiquicoSeleccionado.setDisciplinaPoderSeleccionado(poderPsiquico.getDisciplina());
				
				tableViewPoderesPsiquicos.refresh();
			}
		});
		
		cPoderPsiquicoSeleccionado18.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				PoderPsiquico poderPsiquico = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, cPoderPsiquicoSeleccionado18.getSelectionModel().getSelectedItem());
				PoderPsiquicoSeleccionado poderPsiquicoSeleccionado = poderesPsiquicosSeleccionados.get(17); 
				poderPsiquicoSeleccionado.setNivelPoderSeleccionado(String.valueOf(poderPsiquico.getNivel()));
				poderPsiquicoSeleccionado.setDisciplinaPoderSeleccionado(poderPsiquico.getDisciplina());
				
				tableViewPoderesPsiquicos.refresh();
			}
		});
		
		cPoderPsiquicoSeleccionado19.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				PoderPsiquico poderPsiquico = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, cPoderPsiquicoSeleccionado19.getSelectionModel().getSelectedItem());
				PoderPsiquicoSeleccionado poderPsiquicoSeleccionado = poderesPsiquicosSeleccionados.get(18); 
				poderPsiquicoSeleccionado.setNivelPoderSeleccionado(String.valueOf(poderPsiquico.getNivel()));
				poderPsiquicoSeleccionado.setDisciplinaPoderSeleccionado(poderPsiquico.getDisciplina());
				
				tableViewPoderesPsiquicos.refresh();
			}
		});
		
		cPoderPsiquicoSeleccionado20.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				PoderPsiquico poderPsiquico = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, cPoderPsiquicoSeleccionado20.getSelectionModel().getSelectedItem());
				PoderPsiquicoSeleccionado poderPsiquicoSeleccionado = poderesPsiquicosSeleccionados.get(19); 
				poderPsiquicoSeleccionado.setNivelPoderSeleccionado(String.valueOf(poderPsiquico.getNivel()));
				poderPsiquicoSeleccionado.setDisciplinaPoderSeleccionado(poderPsiquico.getDisciplina());
				
				tableViewPoderesPsiquicos.refresh();
			}
		});
		
		colNombrePoderesMentales.setCellValueFactory(new PropertyValueFactory<PoderPsiquicoSeleccionado, ComboBox<String>>("nombrePoderSeleccionado"));
		colDisciplinaPoderesMentales.setCellValueFactory(new PropertyValueFactory<PoderPsiquicoSeleccionado, String>("disciplinaPoderSeleccionado"));
		colNivelPoderesMentales.setCellValueFactory(new PropertyValueFactory<PoderPsiquicoSeleccionado, String>("nivelPoderSeleccionado"));
		
		tableViewPoderesPsiquicos.setItems(poderesPsiquicosSeleccionados);
	}
	
	public void obtenerTablaConcentracion() {
		ObservableList<PreparacionPsiquico> tablaPreparacion = FXCollections.observableArrayList(
				new PreparacionPsiquico("1 Asalto","10"),
				new PreparacionPsiquico("3 Asaltos","20"),
				new PreparacionPsiquico("5 Asaltos","30"),
				new PreparacionPsiquico("1 Minuto","40"),
				new PreparacionPsiquico("1 Hora","50"));
		
		colPreparacionConcentracion.setCellValueFactory(new PropertyValueFactory<PreparacionPsiquico, String>("preparacion"));
		colBonoPotencialConcentracion.setCellValueFactory(new PropertyValueFactory<PreparacionPsiquico, String>("bonoPotencial"));
		
		tableViewConcentracion.setItems(tablaPreparacion);
	}
	
	public void cambiarValorCvUsado(KeyEvent ev) {
		potencialPsiquico.setCv(tCvUsado.getText());
		tPotencialTotal.setText(potencialPsiquico.getPotencial());
	}
	
	public void seleccionarCTablaPsiquico(ActionEvent ev) {
		if (((ComboBox<?>)ev.getSource()).getSelectionModel().getSelectedItem().equals("Tabla de Proyeccion Psiquica")) {
			tCosteTablaPsiquico.setText("100");
			tPdsTablaPsiquico.setText("100");
		} else {
			tCosteTablaPsiquico.setText("0");
			tPdsTablaPsiquico.setText("0");
		}
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
        	direccionImagen = imgFile.getAbsolutePath();
            Image image = new Image("file:" + direccionImagen);
            imagenChar.setImage(image);
        }
	}
	
	public void insertarPersonaje(ActionEvent ev) throws IOException {

		
		
		/*Caracteristicas*/
		Caracteristicas caracteristicas = new Caracteristicas();
		caracteristicas.setAgilidad(Integer.parseInt(tableViewCaracteristicas.getItems().get(0).getBaseCaracteristica()));
		caracteristicas.setConstitucion(Integer.parseInt(tableViewCaracteristicas.getItems().get(1).getBaseCaracteristica()));
		caracteristicas.setFuerza(Integer.parseInt(tableViewCaracteristicas.getItems().get(2).getBaseCaracteristica()));
		caracteristicas.setDestreza(Integer.parseInt(tableViewCaracteristicas.getItems().get(3).getBaseCaracteristica()));
		caracteristicas.setPercepcion(Integer.parseInt(tableViewCaracteristicas.getItems().get(4).getBaseCaracteristica()));
		caracteristicas.setInteligencia(Integer.parseInt(tableViewCaracteristicas.getItems().get(5).getBaseCaracteristica()));
		caracteristicas.setPoder(Integer.parseInt(tableViewCaracteristicas.getItems().get(6).getBaseCaracteristica()));
		caracteristicas.setVoluntad(Integer.parseInt(tableViewCaracteristicas.getItems().get(7).getBaseCaracteristica()));

		caracteristicas.setAgilidadTemporal(Integer.parseInt(tableViewCaracteristicas.getItems().get(0).getTempCaracteristica()));
		caracteristicas.setConstitucionTemporal(Integer.parseInt(tableViewCaracteristicas.getItems().get(1).getTempCaracteristica()));
		caracteristicas.setFuerzaTemporal(Integer.parseInt(tableViewCaracteristicas.getItems().get(2).getTempCaracteristica()));
		caracteristicas.setDestrezaTemporal(Integer.parseInt(tableViewCaracteristicas.getItems().get(3).getTempCaracteristica()));
		caracteristicas.setPercepcionTemporal(Integer.parseInt(tableViewCaracteristicas.getItems().get(4).getTempCaracteristica()));
		caracteristicas.setInteligenciaTemporal(Integer.parseInt(tableViewCaracteristicas.getItems().get(5).getTempCaracteristica()));
		caracteristicas.setPoderTemporal(Integer.parseInt(tableViewCaracteristicas.getItems().get(6).getTempCaracteristica()));
		caracteristicas.setVoluntadTemporal(Integer.parseInt(tableViewCaracteristicas.getItems().get(7).getTempCaracteristica()));
		
		
		Set<Ventaja> ventajas = new HashSet<Ventaja>();
		if (!(tableViewVentaja.getItems().get(0).getNombreVentaja().getSelectionModel().getSelectedItem()==null)) {
			Ventaja ventaja1 = ch.obtenerVentajaSeleccionada(sessionFactory, tableViewVentaja.getItems().get(0).getNombreVentaja().getSelectionModel().getSelectedItem());
			ventajas.add(ventaja1);
		}
		if (!(tableViewVentaja.getItems().get(1).getNombreVentaja().getSelectionModel().getSelectedItem()==null)) {
			Ventaja ventaja2 = ch.obtenerVentajaSeleccionada(sessionFactory, tableViewVentaja.getItems().get(1).getNombreVentaja().getSelectionModel().getSelectedItem());
			ventajas.add(ventaja2);
		}
		if (!(tableViewVentaja.getItems().get(2).getNombreVentaja().getSelectionModel().getSelectedItem()==null)) {
			Ventaja ventaja3 = ch.obtenerVentajaSeleccionada(sessionFactory, tableViewVentaja.getItems().get(2).getNombreVentaja().getSelectionModel().getSelectedItem());
			ventajas.add(ventaja3);
			
		}
		if (!(tableViewVentaja.getItems().get(3).getNombreVentaja().getSelectionModel().getSelectedItem()==null)) {
			Ventaja ventaja4 = ch.obtenerVentajaSeleccionada(sessionFactory, tableViewVentaja.getItems().get(3).getNombreVentaja().getSelectionModel().getSelectedItem());
			ventajas.add(ventaja4);
			
		}
		if (!(tableViewVentaja.getItems().get(4).getNombreVentaja().getSelectionModel().getSelectedItem()==null)) {
			Ventaja ventaja5 = ch.obtenerVentajaSeleccionada(sessionFactory, tableViewVentaja.getItems().get(4).getNombreVentaja().getSelectionModel().getSelectedItem());
			ventajas.add(ventaja5);
			
		}
		if (!(tableViewVentaja.getItems().get(5).getNombreVentaja().getSelectionModel().getSelectedItem()==null)) {
			Ventaja ventaja6 = ch.obtenerVentajaSeleccionada(sessionFactory, tableViewVentaja.getItems().get(5).getNombreVentaja().getSelectionModel().getSelectedItem());
			ventajas.add(ventaja6);
			
		}
		if (!(tableViewVentaja.getItems().get(6).getNombreVentaja().getSelectionModel().getSelectedItem()==null)) {
			Ventaja ventaja7 = ch.obtenerVentajaSeleccionada(sessionFactory, tableViewVentaja.getItems().get(6).getNombreVentaja().getSelectionModel().getSelectedItem());
			ventajas.add(ventaja7);
			
		}
		
		Set<Desventaja> desventajas = new HashSet<Desventaja>();
		if (!(tableViewDesventaja.getItems().get(0).getNombreDesventaja().getSelectionModel().getSelectedItem()==null)) {
			Desventaja desventaja1 = ch.obtenerDesventajaSeleccionada(sessionFactory, tableViewDesventaja.getItems().get(0).getNombreDesventaja().getSelectionModel().getSelectedItem());
			desventajas.add(desventaja1);
		}
		if (!(tableViewDesventaja.getItems().get(1).getNombreDesventaja().getSelectionModel().getSelectedItem()==null)) {
			Desventaja desventaja2 = ch.obtenerDesventajaSeleccionada(sessionFactory, tableViewDesventaja.getItems().get(1).getNombreDesventaja().getSelectionModel().getSelectedItem());
			desventajas.add(desventaja2);
		}
		if (!(tableViewDesventaja.getItems().get(2).getNombreDesventaja().getSelectionModel().getSelectedItem()==null)) {
			Desventaja desventaja3 = ch.obtenerDesventajaSeleccionada(sessionFactory, tableViewDesventaja.getItems().get(2).getNombreDesventaja().getSelectionModel().getSelectedItem());
			desventajas.add(desventaja3);
		}
		if (!(tableViewDesventaja.getItems().get(3).getNombreDesventaja().getSelectionModel().getSelectedItem()==null)) {
			Desventaja desventaja4 = ch.obtenerDesventajaSeleccionada(sessionFactory, tableViewDesventaja.getItems().get(3).getNombreDesventaja().getSelectionModel().getSelectedItem());
			desventajas.add(desventaja4);
		}
		if (!(tableViewDesventaja.getItems().get(4).getNombreDesventaja().getSelectionModel().getSelectedItem()==null)) {
			Desventaja desventaja5 = ch.obtenerDesventajaSeleccionada(sessionFactory, tableViewDesventaja.getItems().get(4).getNombreDesventaja().getSelectionModel().getSelectedItem());
			desventajas.add(desventaja5);
		}

		
		
		/*Pds Secundarias*/
		PdsPrimariasComunes pdsPrimariasComunes = new PdsPrimariasComunes();
		pdsPrimariasComunes.setPdsHa(Integer.parseInt(tableViewCombate.getItems().get(0).getPdsHabilidad()));
		pdsPrimariasComunes.setPdsHp(Integer.parseInt(tableViewCombate.getItems().get(1).getPdsHabilidad()));
		pdsPrimariasComunes.setPdsHe(Integer.parseInt(tableViewCombate.getItems().get(2).getPdsHabilidad()));
		pdsPrimariasComunes.setPdsLlevarArmadura(Integer.parseInt(tableViewCombate.getItems().get(3).getPdsHabilidad()));

		pdsPrimariasComunes.setPdsEspHa(Integer.parseInt(tableViewCombate.getItems().get(0).getEspecialHabilidad()));
		pdsPrimariasComunes.setPdsEspHp(Integer.parseInt(tableViewCombate.getItems().get(1).getEspecialHabilidad()));
		pdsPrimariasComunes.setPdsEspHe(Integer.parseInt(tableViewCombate.getItems().get(2).getEspecialHabilidad()));
		pdsPrimariasComunes.setPdsEspLlevarArmadura(Integer.parseInt(tableViewCombate.getItems().get(3).getEspecialHabilidad()));
		
		PdsPrimariasKi pdsPrimariasKi = new PdsPrimariasKi();
		pdsPrimariasKi.setPdsConocimientoMarcial(Integer.parseInt(tableViewCombate.getItems().get(4).getPdsHabilidad()));
		pdsPrimariasKi.setPdsEspConocimientoMarcial(Integer.parseInt(tableViewCombate.getItems().get(4).getEspecialHabilidad()));
		
		PdsPrimariasMisticas pdsPrimariasMisticas = new PdsPrimariasMisticas();
		pdsPrimariasMisticas.setPdsAct(Integer.parseInt(tableViewMisticas.getItems().get(1).getPdsHabilidad()));
		pdsPrimariasMisticas.setPdsLvMagia(Integer.parseInt(tableViewMisticas.getItems().get(4).getPdsHabilidad()));
		pdsPrimariasMisticas.setPdsZeon(Integer.parseInt(tableViewMisticas.getItems().get(0).getPdsHabilidad()));
		pdsPrimariasMisticas.setPdsMultiploRegeneracion(Integer.parseInt(tableViewMisticas.getItems().get(2).getPdsHabilidad()));
		pdsPrimariasMisticas.setPdsProyeccionMagica(Integer.parseInt(tableViewMisticas.getItems().get(3).getPdsHabilidad()));
		
		pdsPrimariasMisticas.setPdsConvocar(Integer.parseInt(tableViewMisticas.getItems().get(5).getPdsHabilidad()));
		pdsPrimariasMisticas.setPdsControlar(Integer.parseInt(tableViewMisticas.getItems().get(6).getPdsHabilidad()));
		pdsPrimariasMisticas.setPdsAtar(Integer.parseInt(tableViewMisticas.getItems().get(7).getPdsHabilidad()));
		pdsPrimariasMisticas.setPdsDesconvocar(Integer.parseInt(tableViewMisticas.getItems().get(8).getPdsHabilidad()));
		
		pdsPrimariasMisticas.setPdsEspAct(Integer.parseInt(tableViewMisticas.getItems().get(1).getEspecialHabilidad()));
		pdsPrimariasMisticas.setPdsEspLvMagia(Integer.parseInt(tableViewMisticas.getItems().get(4).getEspecialHabilidad()));
		pdsPrimariasMisticas.setPdsEspZeon(Integer.parseInt(tableViewMisticas.getItems().get(0).getPdsHabilidad()));
		pdsPrimariasMisticas.setPdsEspMultiploRegeneracion(Integer.parseInt(tableViewMisticas.getItems().get(2).getEspecialHabilidad()));
		pdsPrimariasMisticas.setPdsEspProyeccionMagica(Integer.parseInt(tableViewMisticas.getItems().get(3).getEspecialHabilidad()));
		
		pdsPrimariasMisticas.setPdsEspConvocar(Integer.parseInt(tableViewMisticas.getItems().get(5).getEspecialHabilidad()));
		pdsPrimariasMisticas.setPdsEspControlar(Integer.parseInt(tableViewMisticas.getItems().get(6).getEspecialHabilidad()));
		pdsPrimariasMisticas.setPdsEspAtar(Integer.parseInt(tableViewMisticas.getItems().get(7).getEspecialHabilidad()));
		pdsPrimariasMisticas.setPdsEspDesconvocar(Integer.parseInt(tableViewMisticas.getItems().get(8).getEspecialHabilidad()));
		
		PdsPrimariasPsiquicas pdsPrimariasPsiquicas = new PdsPrimariasPsiquicas();
		pdsPrimariasPsiquicas.setPdsCv(Integer.parseInt(tableViewPsiquicas.getItems().get(0).getPdsHabilidad()));
		pdsPrimariasPsiquicas.setPdsProyeccionPsiquica(Integer.parseInt(tableViewPsiquicas.getItems().get(1).getPdsHabilidad()));
		
		pdsPrimariasPsiquicas.setPdsEspCv(Integer.parseInt(tableViewPsiquicas.getItems().get(0).getEspecialHabilidad()));
		pdsPrimariasPsiquicas.setPdsEspProyeccionPsiquica(Integer.parseInt(tableViewPsiquicas.getItems().get(1).getEspecialHabilidad()));
		
		
		/*Pds Secundarias*/
		PdsSecundariasAtleticas pdsSecundariasAtleticas = new PdsSecundariasAtleticas();
		pdsSecundariasAtleticas.setPdsAcrobacias(Integer.parseInt(tableViewSecundarias.getItems().get(0).getPdsHabilidad()));
		pdsSecundariasAtleticas.setPdsEspAcrobacias(Integer.parseInt(tableViewSecundarias.getItems().get(0).getEspecialHabilidad()));
		pdsSecundariasAtleticas.setBonoNaturalAcrobacias(Integer.parseInt(tableViewSecundarias.getItems().get(0).getBonoNatural()));
		pdsSecundariasAtleticas.setHabNaturalAcrobacias(Integer.parseInt(tableViewSecundarias.getItems().get(0).getHabilidadNatural()));
		pdsSecundariasAtleticas.setBonoNovelAcrobacias(Integer.parseInt(tableViewSecundarias.getItems().get(0).getBonoNovel()));
		
		pdsSecundariasAtleticas.setPdsAtletismo(Integer.parseInt(tableViewSecundarias.getItems().get(1).getPdsHabilidad()));
		pdsSecundariasAtleticas.setPdsEspAtletismo(Integer.parseInt(tableViewSecundarias.getItems().get(1).getEspecialHabilidad()));
		pdsSecundariasAtleticas.setBonoNaturalAtletismo(Integer.parseInt(tableViewSecundarias.getItems().get(1).getBonoNatural()));
		pdsSecundariasAtleticas.setHabNaturalAtletismo(Integer.parseInt(tableViewSecundarias.getItems().get(1).getHabilidadNatural()));
		pdsSecundariasAtleticas.setBonoNovelAtletismo(Integer.parseInt(tableViewSecundarias.getItems().get(1).getBonoNovel()));
		
		pdsSecundariasAtleticas.setPdsMontar(Integer.parseInt(tableViewSecundarias.getItems().get(2).getPdsHabilidad()));
		pdsSecundariasAtleticas.setPdsEspMontar(Integer.parseInt(tableViewSecundarias.getItems().get(2).getEspecialHabilidad()));
		pdsSecundariasAtleticas.setBonoNaturalMontar(Integer.parseInt(tableViewSecundarias.getItems().get(2).getBonoNatural()));
		pdsSecundariasAtleticas.setHabNaturalMontar(Integer.parseInt(tableViewSecundarias.getItems().get(2).getHabilidadNatural()));
		pdsSecundariasAtleticas.setBonoNovelMontar(Integer.parseInt(tableViewSecundarias.getItems().get(2).getBonoNovel()));
		
		pdsSecundariasAtleticas.setPdsNadar(Integer.parseInt(tableViewSecundarias.getItems().get(3).getPdsHabilidad()));
		pdsSecundariasAtleticas.setPdsEspNadar(Integer.parseInt(tableViewSecundarias.getItems().get(3).getEspecialHabilidad()));
		pdsSecundariasAtleticas.setBonoNaturalNadar(Integer.parseInt(tableViewSecundarias.getItems().get(3).getBonoNatural()));
		pdsSecundariasAtleticas.setHabNaturalNadar(Integer.parseInt(tableViewSecundarias.getItems().get(3).getHabilidadNatural()));
		pdsSecundariasAtleticas.setBonoNovelNadar(Integer.parseInt(tableViewSecundarias.getItems().get(3).getBonoNovel()));
		
		pdsSecundariasAtleticas.setPdsTrepar(Integer.parseInt(tableViewSecundarias.getItems().get(4).getPdsHabilidad()));
		pdsSecundariasAtleticas.setPdsEspTrepar(Integer.parseInt(tableViewSecundarias.getItems().get(4).getEspecialHabilidad()));
		pdsSecundariasAtleticas.setBonoNaturalTrepar(Integer.parseInt(tableViewSecundarias.getItems().get(4).getBonoNatural()));
		pdsSecundariasAtleticas.setHabNaturalTrepar(Integer.parseInt(tableViewSecundarias.getItems().get(4).getHabilidadNatural()));
		pdsSecundariasAtleticas.setBonoNovelTrepar(Integer.parseInt(tableViewSecundarias.getItems().get(4).getBonoNovel()));
		
		pdsSecundariasAtleticas.setPdsSaltar(Integer.parseInt(tableViewSecundarias.getItems().get(5).getPdsHabilidad()));
		pdsSecundariasAtleticas.setPdsEspSaltar(Integer.parseInt(tableViewSecundarias.getItems().get(5).getEspecialHabilidad()));
		pdsSecundariasAtleticas.setBonoNaturalSaltar(Integer.parseInt(tableViewSecundarias.getItems().get(5).getBonoNatural()));
		pdsSecundariasAtleticas.setHabNaturalSaltar(Integer.parseInt(tableViewSecundarias.getItems().get(5).getHabilidadNatural()));
		pdsSecundariasAtleticas.setBonoNovelSaltar(Integer.parseInt(tableViewSecundarias.getItems().get(5).getBonoNovel()));
		
		
		
		PdsSecundariasSociales pdsSecundariasSociales = new PdsSecundariasSociales();
		pdsSecundariasSociales.setPdsEstilo(Integer.parseInt(tableViewSecundarias.getItems().get(6).getPdsHabilidad()));
		pdsSecundariasSociales.setPdsIntimidar(Integer.parseInt(tableViewSecundarias.getItems().get(7).getPdsHabilidad()));
		pdsSecundariasSociales.setPdsLiderazgo(Integer.parseInt(tableViewSecundarias.getItems().get(8).getPdsHabilidad()));
		pdsSecundariasSociales.setPdsPersuasion(Integer.parseInt(tableViewSecundarias.getItems().get(9).getPdsHabilidad()));
		pdsSecundariasSociales.setPdsComercio(Integer.parseInt(tableViewSecundarias.getItems().get(10).getPdsHabilidad()));
		pdsSecundariasSociales.setPdsCallejeo(Integer.parseInt(tableViewSecundarias.getItems().get(11).getPdsHabilidad()));
		pdsSecundariasSociales.setPdsEtiqueta(Integer.parseInt(tableViewSecundarias.getItems().get(12).getPdsHabilidad()));

		pdsSecundariasSociales.setPdsEspEstilo(Integer.parseInt(tableViewSecundarias.getItems().get(6).getEspecialHabilidad()));
		pdsSecundariasSociales.setPdsEspIntimidar(Integer.parseInt(tableViewSecundarias.getItems().get(7).getEspecialHabilidad()));
		pdsSecundariasSociales.setPdsEspLiderazgo(Integer.parseInt(tableViewSecundarias.getItems().get(8).getEspecialHabilidad()));
		pdsSecundariasSociales.setPdsEspPersuasion(Integer.parseInt(tableViewSecundarias.getItems().get(9).getEspecialHabilidad()));
		pdsSecundariasSociales.setPdsEspComercio(Integer.parseInt(tableViewSecundarias.getItems().get(10).getEspecialHabilidad()));
		pdsSecundariasSociales.setPdsEspCallejeo(Integer.parseInt(tableViewSecundarias.getItems().get(11).getEspecialHabilidad()));
		pdsSecundariasSociales.setPdsEspEtiqueta(Integer.parseInt(tableViewSecundarias.getItems().get(12).getEspecialHabilidad()));
		
		pdsSecundariasSociales.setBonoNaturalEstilo(Integer.parseInt(tableViewSecundarias.getItems().get(6).getBonoNatural()));
		pdsSecundariasSociales.setBonoNaturalIntimidar(Integer.parseInt(tableViewSecundarias.getItems().get(7).getBonoNatural()));
		pdsSecundariasSociales.setBonoNaturalLiderazgo(Integer.parseInt(tableViewSecundarias.getItems().get(8).getBonoNatural()));
		pdsSecundariasSociales.setBonoNaturalPersuasion(Integer.parseInt(tableViewSecundarias.getItems().get(9).getBonoNatural()));
		pdsSecundariasSociales.setBonoNaturalComercio(Integer.parseInt(tableViewSecundarias.getItems().get(10).getBonoNatural()));
		pdsSecundariasSociales.setBonoNaturalCallejeo(Integer.parseInt(tableViewSecundarias.getItems().get(11).getBonoNatural()));
		pdsSecundariasSociales.setBonoNaturalEtiqueta(Integer.parseInt(tableViewSecundarias.getItems().get(12).getBonoNatural()));
		
		pdsSecundariasSociales.setHabNaturalEstilo(Integer.parseInt(tableViewSecundarias.getItems().get(6).getHabilidadNatural()));
		pdsSecundariasSociales.setHabNaturalIntimidar(Integer.parseInt(tableViewSecundarias.getItems().get(7).getHabilidadNatural()));
		pdsSecundariasSociales.setHabNaturalLiderazgo(Integer.parseInt(tableViewSecundarias.getItems().get(8).getHabilidadNatural()));
		pdsSecundariasSociales.setHabNaturalPersuasion(Integer.parseInt(tableViewSecundarias.getItems().get(9).getHabilidadNatural()));
		pdsSecundariasSociales.setHabNaturalComercio(Integer.parseInt(tableViewSecundarias.getItems().get(10).getHabilidadNatural()));
		pdsSecundariasSociales.setHabNaturalCallejeo(Integer.parseInt(tableViewSecundarias.getItems().get(11).getHabilidadNatural()));
		pdsSecundariasSociales.setHabNaturalEtiqueta(Integer.parseInt(tableViewSecundarias.getItems().get(12).getHabilidadNatural()));
		
		pdsSecundariasSociales.setBonoNovelEstilo(Integer.parseInt(tableViewSecundarias.getItems().get(6).getBonoNovel()));
		pdsSecundariasSociales.setBonoNovelIntimidar(Integer.parseInt(tableViewSecundarias.getItems().get(7).getBonoNovel()));
		pdsSecundariasSociales.setBonoNovelLiderazgo(Integer.parseInt(tableViewSecundarias.getItems().get(8).getBonoNovel()));
		pdsSecundariasSociales.setBonoNovelPersuasion(Integer.parseInt(tableViewSecundarias.getItems().get(9).getBonoNovel()));
		pdsSecundariasSociales.setBonoNovelComercio(Integer.parseInt(tableViewSecundarias.getItems().get(10).getBonoNovel()));
		pdsSecundariasSociales.setBonoNovelCallejeo(Integer.parseInt(tableViewSecundarias.getItems().get(11).getBonoNovel()));
		pdsSecundariasSociales.setBonoNovelEtiqueta(Integer.parseInt(tableViewSecundarias.getItems().get(12).getBonoNovel()));
		
		
		
		PdsSecundariasPerceptivas pdsSecundariasPerceptivas = new PdsSecundariasPerceptivas();
		pdsSecundariasPerceptivas.setPdsAdvertir(Integer.parseInt(tableViewSecundarias.getItems().get(13).getPdsHabilidad()));
		pdsSecundariasPerceptivas.setPdsBuscar(Integer.parseInt(tableViewSecundarias.getItems().get(14).getPdsHabilidad()));
		pdsSecundariasPerceptivas.setPdsRastrear(Integer.parseInt(tableViewSecundarias.getItems().get(15).getPdsHabilidad()));

		pdsSecundariasPerceptivas.setPdsEspAdvertir(Integer.parseInt(tableViewSecundarias.getItems().get(13).getEspecialHabilidad()));
		pdsSecundariasPerceptivas.setPdsEspBuscar(Integer.parseInt(tableViewSecundarias.getItems().get(14).getEspecialHabilidad()));
		pdsSecundariasPerceptivas.setPdsEspRastrear(Integer.parseInt(tableViewSecundarias.getItems().get(8).getEspecialHabilidad()));
		
		pdsSecundariasPerceptivas.setBonoNaturalAdvertir(Integer.parseInt(tableViewSecundarias.getItems().get(13).getBonoNatural()));
		pdsSecundariasPerceptivas.setBonoNaturalBuscar(Integer.parseInt(tableViewSecundarias.getItems().get(14).getBonoNatural()));
		pdsSecundariasPerceptivas.setBonoNaturalRastrear(Integer.parseInt(tableViewSecundarias.getItems().get(15).getBonoNatural()));
		
		pdsSecundariasPerceptivas.setHabNaturalAdvertir(Integer.parseInt(tableViewSecundarias.getItems().get(13).getHabilidadNatural()));
		pdsSecundariasPerceptivas.setHabNaturalBuscar(Integer.parseInt(tableViewSecundarias.getItems().get(14).getHabilidadNatural()));
		pdsSecundariasPerceptivas.setHabNaturalRastrear(Integer.parseInt(tableViewSecundarias.getItems().get(15).getHabilidadNatural()));
		
		pdsSecundariasPerceptivas.setBonoNovelAdvertir(Integer.parseInt(tableViewSecundarias.getItems().get(13).getBonoNovel()));
		pdsSecundariasPerceptivas.setBonoNovelBuscar(Integer.parseInt(tableViewSecundarias.getItems().get(14).getBonoNovel()));
		pdsSecundariasPerceptivas.setBonoNovelRastrear(Integer.parseInt(tableViewSecundarias.getItems().get(15).getBonoNovel()));

		
		
		PdsSecundariasIntelectuales pdsSecundariasIntelectuales= new PdsSecundariasIntelectuales();
		pdsSecundariasIntelectuales.setPdsAnimales(Integer.parseInt(tableViewSecundarias.getItems().get(16).getPdsHabilidad()));
		pdsSecundariasIntelectuales.setPdsCiencia(Integer.parseInt(tableViewSecundarias.getItems().get(17).getPdsHabilidad()));
		pdsSecundariasIntelectuales.setPdsLey(Integer.parseInt(tableViewSecundarias.getItems().get(18).getPdsHabilidad()));
		pdsSecundariasIntelectuales.setPdsHerbolaria(Integer.parseInt(tableViewSecundarias.getItems().get(19).getPdsHabilidad()));
		pdsSecundariasIntelectuales.setPdsHistoria(Integer.parseInt(tableViewSecundarias.getItems().get(20).getPdsHabilidad()));
		pdsSecundariasIntelectuales.setPdsTactica(Integer.parseInt(tableViewSecundarias.getItems().get(21).getPdsHabilidad()));
		pdsSecundariasIntelectuales.setPdsMedicina(Integer.parseInt(tableViewSecundarias.getItems().get(22).getPdsHabilidad()));
		pdsSecundariasIntelectuales.setPdsMemorizar(Integer.parseInt(tableViewSecundarias.getItems().get(23).getPdsHabilidad()));
		pdsSecundariasIntelectuales.setPdsNavegacion(Integer.parseInt(tableViewSecundarias.getItems().get(24).getPdsHabilidad()));
		pdsSecundariasIntelectuales.setPdsOcultismo(Integer.parseInt(tableViewSecundarias.getItems().get(25).getPdsHabilidad()));
		pdsSecundariasIntelectuales.setPdsTasacion(Integer.parseInt(tableViewSecundarias.getItems().get(26).getPdsHabilidad()));
		pdsSecundariasIntelectuales.setPdsValoracionMagica(Integer.parseInt(tableViewSecundarias.getItems().get(27).getPdsHabilidad()));

		pdsSecundariasIntelectuales.setPdsEspAnimales(Integer.parseInt(tableViewSecundarias.getItems().get(16).getEspecialHabilidad()));
		pdsSecundariasIntelectuales.setPdsEspCiencia(Integer.parseInt(tableViewSecundarias.getItems().get(17).getEspecialHabilidad()));
		pdsSecundariasIntelectuales.setPdsEspLey(Integer.parseInt(tableViewSecundarias.getItems().get(18).getEspecialHabilidad()));
		pdsSecundariasIntelectuales.setPdsEspHerbolaria(Integer.parseInt(tableViewSecundarias.getItems().get(19).getEspecialHabilidad()));
		pdsSecundariasIntelectuales.setPdsEspHistoria(Integer.parseInt(tableViewSecundarias.getItems().get(20).getEspecialHabilidad()));
		pdsSecundariasIntelectuales.setPdsEspTactica(Integer.parseInt(tableViewSecundarias.getItems().get(21).getEspecialHabilidad()));
		pdsSecundariasIntelectuales.setPdsEspMedicina(Integer.parseInt(tableViewSecundarias.getItems().get(22).getEspecialHabilidad()));
		pdsSecundariasIntelectuales.setPdsEspMemorizar(Integer.parseInt(tableViewSecundarias.getItems().get(23).getEspecialHabilidad()));
		pdsSecundariasIntelectuales.setPdsEspNavegacion(Integer.parseInt(tableViewSecundarias.getItems().get(24).getEspecialHabilidad()));
		pdsSecundariasIntelectuales.setPdsEspOcultismo(Integer.parseInt(tableViewSecundarias.getItems().get(25).getEspecialHabilidad()));
		pdsSecundariasIntelectuales.setPdsEspTasacion(Integer.parseInt(tableViewSecundarias.getItems().get(26).getEspecialHabilidad()));
		pdsSecundariasIntelectuales.setPdsEspValoracionMagica(Integer.parseInt(tableViewSecundarias.getItems().get(27).getEspecialHabilidad()));
		
		pdsSecundariasIntelectuales.setBonoNaturalAnimales(Integer.parseInt(tableViewSecundarias.getItems().get(16).getBonoNatural()));
		pdsSecundariasIntelectuales.setBonoNaturalCiencia(Integer.parseInt(tableViewSecundarias.getItems().get(17).getBonoNatural()));
		pdsSecundariasIntelectuales.setBonoNaturalLey(Integer.parseInt(tableViewSecundarias.getItems().get(18).getBonoNatural()));
		pdsSecundariasIntelectuales.setBonoNaturalHerbolaria(Integer.parseInt(tableViewSecundarias.getItems().get(19).getBonoNatural()));
		pdsSecundariasIntelectuales.setBonoNaturalHistoria(Integer.parseInt(tableViewSecundarias.getItems().get(20).getBonoNatural()));
		pdsSecundariasIntelectuales.setBonoNaturalTactica(Integer.parseInt(tableViewSecundarias.getItems().get(21).getBonoNatural()));
		pdsSecundariasIntelectuales.setBonoNaturalMedicina(Integer.parseInt(tableViewSecundarias.getItems().get(22).getBonoNatural()));
		pdsSecundariasIntelectuales.setBonoNaturalMemorizar(Integer.parseInt(tableViewSecundarias.getItems().get(23).getBonoNatural()));
		pdsSecundariasIntelectuales.setBonoNaturalNavegacion(Integer.parseInt(tableViewSecundarias.getItems().get(24).getBonoNatural()));
		pdsSecundariasIntelectuales.setBonoNaturalOcultismo(Integer.parseInt(tableViewSecundarias.getItems().get(25).getBonoNatural()));
		pdsSecundariasIntelectuales.setBonoNaturalTasacion(Integer.parseInt(tableViewSecundarias.getItems().get(26).getBonoNatural()));
		pdsSecundariasIntelectuales.setBonoNaturalValoracionMagica(Integer.parseInt(tableViewSecundarias.getItems().get(27).getBonoNatural()));
		
		pdsSecundariasIntelectuales.setHabNaturalAnimales(Integer.parseInt(tableViewSecundarias.getItems().get(16).getHabilidadNatural()));
		pdsSecundariasIntelectuales.setHabNaturalCiencia(Integer.parseInt(tableViewSecundarias.getItems().get(17).getHabilidadNatural()));
		pdsSecundariasIntelectuales.setHabNaturalLey(Integer.parseInt(tableViewSecundarias.getItems().get(18).getHabilidadNatural()));
		pdsSecundariasIntelectuales.setHabNaturalHerbolaria(Integer.parseInt(tableViewSecundarias.getItems().get(19).getHabilidadNatural()));
		pdsSecundariasIntelectuales.setHabNaturalHistoria(Integer.parseInt(tableViewSecundarias.getItems().get(20).getHabilidadNatural()));
		pdsSecundariasIntelectuales.setHabNaturalTactica(Integer.parseInt(tableViewSecundarias.getItems().get(21).getHabilidadNatural()));
		pdsSecundariasIntelectuales.setHabNaturalMedicina(Integer.parseInt(tableViewSecundarias.getItems().get(22).getHabilidadNatural()));
		pdsSecundariasIntelectuales.setHabNaturalMemorizar(Integer.parseInt(tableViewSecundarias.getItems().get(23).getHabilidadNatural()));
		pdsSecundariasIntelectuales.setHabNaturalNavegacion(Integer.parseInt(tableViewSecundarias.getItems().get(24).getHabilidadNatural()));
		pdsSecundariasIntelectuales.setHabNaturalOcultismo(Integer.parseInt(tableViewSecundarias.getItems().get(25).getHabilidadNatural()));
		pdsSecundariasIntelectuales.setHabNaturalTasacion(Integer.parseInt(tableViewSecundarias.getItems().get(26).getHabilidadNatural()));
		pdsSecundariasIntelectuales.setHabNaturalValoracionMagica(Integer.parseInt(tableViewSecundarias.getItems().get(27).getHabilidadNatural()));

		pdsSecundariasIntelectuales.setBonoNovelAnimales(Integer.parseInt(tableViewSecundarias.getItems().get(16).getBonoNovel()));
		pdsSecundariasIntelectuales.setBonoNovelCiencia(Integer.parseInt(tableViewSecundarias.getItems().get(17).getBonoNovel()));
		pdsSecundariasIntelectuales.setBonoNovelLey(Integer.parseInt(tableViewSecundarias.getItems().get(18).getBonoNovel()));
		pdsSecundariasIntelectuales.setBonoNovelHerbolaria(Integer.parseInt(tableViewSecundarias.getItems().get(19).getBonoNovel()));
		pdsSecundariasIntelectuales.setBonoNovelHistoria(Integer.parseInt(tableViewSecundarias.getItems().get(20).getBonoNovel()));
		pdsSecundariasIntelectuales.setBonoNovelTactica(Integer.parseInt(tableViewSecundarias.getItems().get(21).getBonoNovel()));
		pdsSecundariasIntelectuales.setBonoNovelMedicina(Integer.parseInt(tableViewSecundarias.getItems().get(22).getBonoNovel()));
		pdsSecundariasIntelectuales.setBonoNovelMemorizar(Integer.parseInt(tableViewSecundarias.getItems().get(23).getBonoNovel()));
		pdsSecundariasIntelectuales.setBonoNovelNavegacion(Integer.parseInt(tableViewSecundarias.getItems().get(24).getBonoNovel()));
		pdsSecundariasIntelectuales.setBonoNovelOcultismo(Integer.parseInt(tableViewSecundarias.getItems().get(25).getBonoNovel()));
		pdsSecundariasIntelectuales.setBonoNovelTasacion(Integer.parseInt(tableViewSecundarias.getItems().get(26).getBonoNovel()));
		pdsSecundariasIntelectuales.setBonoNovelValoracionMagica(Integer.parseInt(tableViewSecundarias.getItems().get(27).getBonoNovel()));

		
		
		PdsSecundariasVigor pdsSecundariasVigor = new PdsSecundariasVigor();
		pdsSecundariasVigor.setPdsFrialdad(Integer.parseInt(tableViewSecundarias.getItems().get(28).getPdsHabilidad()));
		pdsSecundariasVigor.setPdsProezaFuerza(Integer.parseInt(tableViewSecundarias.getItems().get(29).getPdsHabilidad()));
		pdsSecundariasVigor.setPdsResistirDolor(Integer.parseInt(tableViewSecundarias.getItems().get(30).getPdsHabilidad()));

		pdsSecundariasVigor.setPdsEspFrialdad(Integer.parseInt(tableViewSecundarias.getItems().get(28).getEspecialHabilidad()));
		pdsSecundariasVigor.setPdsEspProezaFuerza(Integer.parseInt(tableViewSecundarias.getItems().get(29).getEspecialHabilidad()));
		pdsSecundariasVigor.setPdsEspResistirDolor(Integer.parseInt(tableViewSecundarias.getItems().get(30).getEspecialHabilidad()));
		
		pdsSecundariasVigor.setBonoNaturalFrialdad(Integer.parseInt(tableViewSecundarias.getItems().get(28).getBonoNatural()));
		pdsSecundariasVigor.setBonoNaturalProezaFuerza(Integer.parseInt(tableViewSecundarias.getItems().get(29).getBonoNatural()));
		pdsSecundariasVigor.setBonoNaturalResistirDolor(Integer.parseInt(tableViewSecundarias.getItems().get(30).getBonoNatural()));
		
		pdsSecundariasVigor.setHabNaturalFrialdad(Integer.parseInt(tableViewSecundarias.getItems().get(28).getHabilidadNatural()));
		pdsSecundariasVigor.setHabNaturalProezaFuerza(Integer.parseInt(tableViewSecundarias.getItems().get(29).getHabilidadNatural()));
		pdsSecundariasVigor.setHabNaturalResistirDolor(Integer.parseInt(tableViewSecundarias.getItems().get(30).getHabilidadNatural()));
		
		pdsSecundariasVigor.setBonoNovelFrialdad(Integer.parseInt(tableViewSecundarias.getItems().get(28).getBonoNovel()));
		pdsSecundariasVigor.setBonoNovelProezaFuerza(Integer.parseInt(tableViewSecundarias.getItems().get(29).getBonoNovel()));
		pdsSecundariasVigor.setBonoNovelResistirDolor(Integer.parseInt(tableViewSecundarias.getItems().get(30).getBonoNovel()));

		
		
		PdsSecundariasSubterfugio pdsSecundariasSubterfugio = new PdsSecundariasSubterfugio();
		pdsSecundariasSubterfugio.setPdsCerrajeria(Integer.parseInt(tableViewSecundarias.getItems().get(31).getPdsHabilidad()));
		pdsSecundariasSubterfugio.setPdsDisfraz(Integer.parseInt(tableViewSecundarias.getItems().get(32).getPdsHabilidad()));
		pdsSecundariasSubterfugio.setPdsOcultarse(Integer.parseInt(tableViewSecundarias.getItems().get(33).getPdsHabilidad()));
		pdsSecundariasSubterfugio.setPdsRobo(Integer.parseInt(tableViewSecundarias.getItems().get(34).getPdsHabilidad()));
		pdsSecundariasSubterfugio.setPdsSigilo(Integer.parseInt(tableViewSecundarias.getItems().get(35).getPdsHabilidad()));
		pdsSecundariasSubterfugio.setPdsTramperia(Integer.parseInt(tableViewSecundarias.getItems().get(36).getPdsHabilidad()));
		pdsSecundariasSubterfugio.setPdsVenenos(Integer.parseInt(tableViewSecundarias.getItems().get(37).getPdsHabilidad()));

		pdsSecundariasSubterfugio.setPdsEspCerrajeria(Integer.parseInt(tableViewSecundarias.getItems().get(31).getEspecialHabilidad()));
		pdsSecundariasSubterfugio.setPdsEspDisfraz(Integer.parseInt(tableViewSecundarias.getItems().get(32).getEspecialHabilidad()));
		pdsSecundariasSubterfugio.setPdsEspOcultarse(Integer.parseInt(tableViewSecundarias.getItems().get(33).getEspecialHabilidad()));
		pdsSecundariasSubterfugio.setPdsEspRobo(Integer.parseInt(tableViewSecundarias.getItems().get(34).getEspecialHabilidad()));
		pdsSecundariasSubterfugio.setPdsEspSigilo(Integer.parseInt(tableViewSecundarias.getItems().get(35).getEspecialHabilidad()));
		pdsSecundariasSubterfugio.setPdsEspTramperia(Integer.parseInt(tableViewSecundarias.getItems().get(36).getEspecialHabilidad()));
		pdsSecundariasSubterfugio.setPdsEspVenenos(Integer.parseInt(tableViewSecundarias.getItems().get(37).getEspecialHabilidad()));

		pdsSecundariasSubterfugio.setBonoNaturalCerrajeria(Integer.parseInt(tableViewSecundarias.getItems().get(31).getBonoNatural()));
		pdsSecundariasSubterfugio.setBonoNaturalDisfraz(Integer.parseInt(tableViewSecundarias.getItems().get(32).getBonoNatural()));
		pdsSecundariasSubterfugio.setBonoNaturalOcultarse(Integer.parseInt(tableViewSecundarias.getItems().get(33).getBonoNatural()));
		pdsSecundariasSubterfugio.setBonoNaturalRobo(Integer.parseInt(tableViewSecundarias.getItems().get(34).getBonoNatural()));
		pdsSecundariasSubterfugio.setBonoNaturalSigilo(Integer.parseInt(tableViewSecundarias.getItems().get(35).getBonoNatural()));
		pdsSecundariasSubterfugio.setBonoNaturalTramperia(Integer.parseInt(tableViewSecundarias.getItems().get(36).getBonoNatural()));
		pdsSecundariasSubterfugio.setBonoNaturalVenenos(Integer.parseInt(tableViewSecundarias.getItems().get(37).getBonoNatural()));

		pdsSecundariasSubterfugio.setHabNaturalCerrajeria(Integer.parseInt(tableViewSecundarias.getItems().get(31).getHabilidadNatural()));
		pdsSecundariasSubterfugio.setHabNaturalDisfraz(Integer.parseInt(tableViewSecundarias.getItems().get(32).getHabilidadNatural()));
		pdsSecundariasSubterfugio.setHabNaturalOcultarse(Integer.parseInt(tableViewSecundarias.getItems().get(33).getHabilidadNatural()));
		pdsSecundariasSubterfugio.setHabNaturalRobo(Integer.parseInt(tableViewSecundarias.getItems().get(34).getHabilidadNatural()));
		pdsSecundariasSubterfugio.setHabNaturalSigilo(Integer.parseInt(tableViewSecundarias.getItems().get(35).getHabilidadNatural()));
		pdsSecundariasSubterfugio.setHabNaturalTramperia(Integer.parseInt(tableViewSecundarias.getItems().get(36).getHabilidadNatural()));
		pdsSecundariasSubterfugio.setHabNaturalVenenos(Integer.parseInt(tableViewSecundarias.getItems().get(37).getHabilidadNatural()));

		pdsSecundariasSubterfugio.setBonoNovelCerrajeria(Integer.parseInt(tableViewSecundarias.getItems().get(31).getBonoNovel()));
		pdsSecundariasSubterfugio.setBonoNovelDisfraz(Integer.parseInt(tableViewSecundarias.getItems().get(32).getBonoNovel()));
		pdsSecundariasSubterfugio.setBonoNovelOcultarse(Integer.parseInt(tableViewSecundarias.getItems().get(33).getBonoNovel()));
		pdsSecundariasSubterfugio.setBonoNovelRobo(Integer.parseInt(tableViewSecundarias.getItems().get(34).getBonoNovel()));
		pdsSecundariasSubterfugio.setBonoNovelSigilo(Integer.parseInt(tableViewSecundarias.getItems().get(35).getBonoNovel()));
		pdsSecundariasSubterfugio.setBonoNovelTramperia(Integer.parseInt(tableViewSecundarias.getItems().get(36).getBonoNovel()));
		pdsSecundariasSubterfugio.setBonoNovelVenenos(Integer.parseInt(tableViewSecundarias.getItems().get(37).getBonoNovel()));

		
		
		PdsSecundariasCreativas pdsSecundariasCreativas = new PdsSecundariasCreativas();
		pdsSecundariasCreativas.setPdsArte(Integer.parseInt(tableViewSecundarias.getItems().get(38).getPdsHabilidad()));
		pdsSecundariasCreativas.setPdsBaile(Integer.parseInt(tableViewSecundarias.getItems().get(39).getPdsHabilidad()));
		pdsSecundariasCreativas.setPdsForja(Integer.parseInt(tableViewSecundarias.getItems().get(40).getPdsHabilidad()));
		pdsSecundariasCreativas.setPdsRunas(Integer.parseInt(tableViewSecundarias.getItems().get(41).getPdsHabilidad()));
		pdsSecundariasCreativas.setPdsAlquimia(Integer.parseInt(tableViewSecundarias.getItems().get(42).getPdsHabilidad()));
		pdsSecundariasCreativas.setPdsAnimismo(Integer.parseInt(tableViewSecundarias.getItems().get(43).getPdsHabilidad()));
		pdsSecundariasCreativas.setPdsMusica(Integer.parseInt(tableViewSecundarias.getItems().get(44).getPdsHabilidad()));
		pdsSecundariasCreativas.setPdsTrucoManos(Integer.parseInt(tableViewSecundarias.getItems().get(45).getPdsHabilidad()));
		pdsSecundariasCreativas.setPdsCaligrafiaRitual(Integer.parseInt(tableViewSecundarias.getItems().get(46).getPdsHabilidad()));
		pdsSecundariasCreativas.setPdsOrfebreria(Integer.parseInt(tableViewSecundarias.getItems().get(47).getPdsHabilidad()));
		pdsSecundariasCreativas.setPdsConfeccion(Integer.parseInt(tableViewSecundarias.getItems().get(48).getPdsHabilidad()));

		pdsSecundariasCreativas.setPdsEspArte(Integer.parseInt(tableViewSecundarias.getItems().get(38).getEspecialHabilidad()));
		pdsSecundariasCreativas.setPdsEspBaile(Integer.parseInt(tableViewSecundarias.getItems().get(39).getEspecialHabilidad()));
		pdsSecundariasCreativas.setPdsEspForja(Integer.parseInt(tableViewSecundarias.getItems().get(40).getEspecialHabilidad()));
		pdsSecundariasCreativas.setPdsEspRunas(Integer.parseInt(tableViewSecundarias.getItems().get(41).getEspecialHabilidad()));
		pdsSecundariasCreativas.setPdsEspAlquimia(Integer.parseInt(tableViewSecundarias.getItems().get(42).getEspecialHabilidad()));
		pdsSecundariasCreativas.setPdsEspAnimismo(Integer.parseInt(tableViewSecundarias.getItems().get(43).getEspecialHabilidad()));
		pdsSecundariasCreativas.setPdsEspMusica(Integer.parseInt(tableViewSecundarias.getItems().get(44).getEspecialHabilidad()));
		pdsSecundariasCreativas.setPdsEspTrucoManos(Integer.parseInt(tableViewSecundarias.getItems().get(45).getEspecialHabilidad()));
		pdsSecundariasCreativas.setPdsEspCaligrafiaRitual(Integer.parseInt(tableViewSecundarias.getItems().get(46).getEspecialHabilidad()));
		pdsSecundariasCreativas.setPdsEspOrfebreria(Integer.parseInt(tableViewSecundarias.getItems().get(47).getEspecialHabilidad()));
		pdsSecundariasCreativas.setPdsEspConfeccion(Integer.parseInt(tableViewSecundarias.getItems().get(48).getEspecialHabilidad()));

		pdsSecundariasCreativas.setBonoNaturalArte(Integer.parseInt(tableViewSecundarias.getItems().get(38).getBonoNatural()));
		pdsSecundariasCreativas.setBonoNaturalBaile(Integer.parseInt(tableViewSecundarias.getItems().get(39).getBonoNatural()));
		pdsSecundariasCreativas.setBonoNaturalForja(Integer.parseInt(tableViewSecundarias.getItems().get(40).getBonoNatural()));
		pdsSecundariasCreativas.setBonoNaturalRunas(Integer.parseInt(tableViewSecundarias.getItems().get(41).getBonoNatural()));
		pdsSecundariasCreativas.setBonoNaturalAlquimia(Integer.parseInt(tableViewSecundarias.getItems().get(42).getBonoNatural()));
		pdsSecundariasCreativas.setBonoNaturalAnimismo(Integer.parseInt(tableViewSecundarias.getItems().get(43).getBonoNatural()));
		pdsSecundariasCreativas.setBonoNaturalMusica(Integer.parseInt(tableViewSecundarias.getItems().get(44).getBonoNatural()));
		pdsSecundariasCreativas.setBonoNaturalTrucoManos(Integer.parseInt(tableViewSecundarias.getItems().get(45).getBonoNatural()));
		pdsSecundariasCreativas.setBonoNaturalCaligrafiaRitual(Integer.parseInt(tableViewSecundarias.getItems().get(46).getBonoNatural()));
		pdsSecundariasCreativas.setBonoNaturalOrfebreria(Integer.parseInt(tableViewSecundarias.getItems().get(47).getBonoNatural()));
		pdsSecundariasCreativas.setBonoNaturalConfeccion(Integer.parseInt(tableViewSecundarias.getItems().get(48).getBonoNatural()));

		pdsSecundariasCreativas.setHabNaturalArte(Integer.parseInt(tableViewSecundarias.getItems().get(38).getHabilidadNatural()));
		pdsSecundariasCreativas.setHabNaturalBaile(Integer.parseInt(tableViewSecundarias.getItems().get(39).getHabilidadNatural()));
		pdsSecundariasCreativas.setHabNaturalForja(Integer.parseInt(tableViewSecundarias.getItems().get(40).getHabilidadNatural()));
		pdsSecundariasCreativas.setHabNaturalRunas(Integer.parseInt(tableViewSecundarias.getItems().get(41).getHabilidadNatural()));
		pdsSecundariasCreativas.setHabNaturalAlquimia(Integer.parseInt(tableViewSecundarias.getItems().get(42).getHabilidadNatural()));
		pdsSecundariasCreativas.setHabNaturalAnimismo(Integer.parseInt(tableViewSecundarias.getItems().get(43).getHabilidadNatural()));
		pdsSecundariasCreativas.setHabNaturalMusica(Integer.parseInt(tableViewSecundarias.getItems().get(44).getHabilidadNatural()));
		pdsSecundariasCreativas.setHabNaturalTrucoManos(Integer.parseInt(tableViewSecundarias.getItems().get(45).getHabilidadNatural()));
		pdsSecundariasCreativas.setHabNaturalCaligrafiaRitual(Integer.parseInt(tableViewSecundarias.getItems().get(46).getHabilidadNatural()));
		pdsSecundariasCreativas.setHabNaturalOrfebreria(Integer.parseInt(tableViewSecundarias.getItems().get(47).getHabilidadNatural()));
		pdsSecundariasCreativas.setHabNaturalConfeccion(Integer.parseInt(tableViewSecundarias.getItems().get(48).getHabilidadNatural()));

		pdsSecundariasCreativas.setBonoNovelArte(Integer.parseInt(tableViewSecundarias.getItems().get(38).getBonoNovel()));
		pdsSecundariasCreativas.setBonoNovelBaile(Integer.parseInt(tableViewSecundarias.getItems().get(39).getBonoNovel()));
		pdsSecundariasCreativas.setBonoNovelForja(Integer.parseInt(tableViewSecundarias.getItems().get(40).getBonoNovel()));
		pdsSecundariasCreativas.setBonoNovelRunas(Integer.parseInt(tableViewSecundarias.getItems().get(41).getBonoNovel()));
		pdsSecundariasCreativas.setBonoNovelAlquimia(Integer.parseInt(tableViewSecundarias.getItems().get(42).getBonoNovel()));
		pdsSecundariasCreativas.setBonoNovelAnimismo(Integer.parseInt(tableViewSecundarias.getItems().get(43).getBonoNovel()));
		pdsSecundariasCreativas.setBonoNovelMusica(Integer.parseInt(tableViewSecundarias.getItems().get(44).getBonoNovel()));
		pdsSecundariasCreativas.setBonoNovelTrucoManos(Integer.parseInt(tableViewSecundarias.getItems().get(45).getBonoNovel()));
		pdsSecundariasCreativas.setBonoNovelCaligrafiaRitual(Integer.parseInt(tableViewSecundarias.getItems().get(46).getBonoNovel()));
		pdsSecundariasCreativas.setBonoNovelOrfebreria(Integer.parseInt(tableViewSecundarias.getItems().get(47).getBonoNovel()));
		pdsSecundariasCreativas.setBonoNovelConfeccion(Integer.parseInt(tableViewSecundarias.getItems().get(48).getBonoNovel()));

		
		Set<Arma> armas = new HashSet<Arma>();
		armas.add(tableviewArmaSeleccionada1.getItems().get(0).getArmaSeleccionada());
		armas.add(tableviewArmaSeleccionada2.getItems().get(0).getArmaSeleccionada());
		armas.add(tableviewArmaSeleccionada3.getItems().get(0).getArmaSeleccionada());
		armas.add(tableviewArmaSeleccionada4.getItems().get(0).getArmaSeleccionada());
		
		/*Armadura Personaje*/
		Set<Armadura> armaduras = new HashSet<Armadura>();
		if (!(tableViewArmaduras.getItems().get(0).getNombreArmadura().getSelectionModel().getSelectedItem()==null)) {
			Armadura armadura = ch.obtenerArmadura(sessionFactory, tableViewArmaduras.getItems().get(0).getNombreArmadura().getSelectionModel().getSelectedItem());
			armaduras.add(armadura);
		}

		
		/*Estilos*/
		Set<TablaEstilo> tablaEstilos = new HashSet<TablaEstilo>();
		if (!(tableViewTablasEstilos.getItems().get(0).getNombreTabla().getSelectionModel().getSelectedItem()==null)) {
			TablaEstilo tablaEstilo1 = ch.obtenerTablasEstiloSeleccionada(sessionFactory, tableViewTablasEstilos.getItems().get(0).getNombreTabla().getSelectionModel().getSelectedItem());
			tablaEstilos.add(tablaEstilo1);
		}
		if (!(tableViewTablasEstilos.getItems().get(1).getNombreTabla().getSelectionModel().getSelectedItem()==null)) {
			TablaEstilo tablaEstilo2 = ch.obtenerTablasEstiloSeleccionada(sessionFactory, tableViewTablasEstilos.getItems().get(1).getNombreTabla().getSelectionModel().getSelectedItem());
			tablaEstilos.add(tablaEstilo2);
		}
		if (!(tableViewTablasEstilos.getItems().get(2).getNombreTabla().getSelectionModel().getSelectedItem()==null)) {
			TablaEstilo tablaEstilo3 = ch.obtenerTablasEstiloSeleccionada(sessionFactory, tableViewTablasEstilos.getItems().get(2).getNombreTabla().getSelectionModel().getSelectedItem());
			tablaEstilos.add(tablaEstilo3);
		}
		if (!(tableViewTablasEstilos.getItems().get(3).getNombreTabla().getSelectionModel().getSelectedItem()==null)) {
			TablaEstilo tablaEstilo4 = ch.obtenerTablasEstiloSeleccionada(sessionFactory, tableViewTablasEstilos.getItems().get(3).getNombreTabla().getSelectionModel().getSelectedItem());
			tablaEstilos.add(tablaEstilo4);
		}
		
		
		/*Artes Marciales*/
		Set<ArteMarcial> tablaArteMarcial = new HashSet<ArteMarcial>();
		if (!(tableViewTablasArtesMarciales.getItems().get(0).getNombreArteMarcial().getSelectionModel().getSelectedItem()==null)) {
			ArteMarcial arteMarcial1 = ch.obtenerArteMarcialSeleccionada(sessionFactory, tableViewTablasArtesMarciales.getItems().get(0).getNombreArteMarcial().getSelectionModel().getSelectedItem());
			tablaArteMarcial.add(arteMarcial1);
		}
		if (!(tableViewTablasArtesMarciales.getItems().get(1).getNombreArteMarcial().getSelectionModel().getSelectedItem()==null)) {
			ArteMarcial arteMarcial2 = ch.obtenerArteMarcialSeleccionada(sessionFactory, tableViewTablasArtesMarciales.getItems().get(1).getNombreArteMarcial().getSelectionModel().getSelectedItem());
			tablaArteMarcial.add(arteMarcial2);
		}
		if (!(tableViewTablasArtesMarciales.getItems().get(2).getNombreArteMarcial().getSelectionModel().getSelectedItem()==null)) {
			ArteMarcial arteMarcial3 = ch.obtenerArteMarcialSeleccionada(sessionFactory, tableViewTablasArtesMarciales.getItems().get(2).getNombreArteMarcial().getSelectionModel().getSelectedItem());
			tablaArteMarcial.add(arteMarcial3);
		}
		if (!(tableViewTablasArtesMarciales.getItems().get(3).getNombreArteMarcial().getSelectionModel().getSelectedItem()==null)) {
			ArteMarcial arteMarcial4 = ch.obtenerArteMarcialSeleccionada(sessionFactory, tableViewTablasArtesMarciales.getItems().get(3).getNombreArteMarcial().getSelectionModel().getSelectedItem());
			tablaArteMarcial.add(arteMarcial4);
		}
		if (!(tableViewTablasArtesMarciales.getItems().get(4).getNombreArteMarcial().getSelectionModel().getSelectedItem()==null)) {
			ArteMarcial arteMarcial5 = ch.obtenerArteMarcialSeleccionada(sessionFactory, tableViewTablasArtesMarciales.getItems().get(4).getNombreArteMarcial().getSelectionModel().getSelectedItem());
			tablaArteMarcial.add(arteMarcial5);
		}
		if (!(tableViewTablasArtesMarciales.getItems().get(5).getNombreArteMarcial().getSelectionModel().getSelectedItem()==null)) {
			ArteMarcial arteMarcial6 = ch.obtenerArteMarcialSeleccionada(sessionFactory, tableViewTablasArtesMarciales.getItems().get(5).getNombreArteMarcial().getSelectionModel().getSelectedItem());
			tablaArteMarcial.add(arteMarcial6);
		}
		if (!(tableViewTablasArtesMarciales.getItems().get(6).getNombreArteMarcial().getSelectionModel().getSelectedItem()==null)) {
			ArteMarcial arteMarcial7 = ch.obtenerArteMarcialSeleccionada(sessionFactory, tableViewTablasArtesMarciales.getItems().get(6).getNombreArteMarcial().getSelectionModel().getSelectedItem());
			tablaArteMarcial.add(arteMarcial7);
		}
		if (!(tableViewTablasArtesMarciales.getItems().get(7).getNombreArteMarcial().getSelectionModel().getSelectedItem()==null)) {
			ArteMarcial arteMarcial8 = ch.obtenerArteMarcialSeleccionada(sessionFactory, tableViewTablasArtesMarciales.getItems().get(7).getNombreArteMarcial().getSelectionModel().getSelectedItem());
			tablaArteMarcial.add(arteMarcial8);
		}
		if (!(tableViewTablasArtesMarciales.getItems().get(8).getNombreArteMarcial().getSelectionModel().getSelectedItem()==null)) {
			ArteMarcial arteMarcial9 = ch.obtenerArteMarcialSeleccionada(sessionFactory, tableViewTablasArtesMarciales.getItems().get(8).getNombreArteMarcial().getSelectionModel().getSelectedItem());
			tablaArteMarcial.add(arteMarcial9);
		}
		if (!(tableViewTablasArtesMarciales.getItems().get(9).getNombreArteMarcial().getSelectionModel().getSelectedItem()==null)) {
			ArteMarcial arteMarcial10 = ch.obtenerArteMarcialSeleccionada(sessionFactory, tableViewTablasArtesMarciales.getItems().get(9).getNombreArteMarcial().getSelectionModel().getSelectedItem());
			tablaArteMarcial.add(arteMarcial10);
		}
		
		/*Tabla Niveles Magia*/
//		TablaTablaViasMagiaPersonaje tablaTablaViasMagiaPersonaje1 = new TablaTablaViasMagiaPersonaje();
//		tablaTablaViasMagiaPersonaje1.setTablaViasMagia(ch.obtenerViaMagiaSeleccionada(sessionFactory, tableViewNivelVia.getItems().get(0).getNombreViaSeleccionada().getSelectionModel().getSelectedItem()));
//		tablaTablaViasMagiaPersonaje1.setNivelesUsados(Integer.parseInt(tableViewNivelVia.getItems().get(0).getNivelUsado()));
//		
//		TablaTablaViasMagiaPersonaje tablaTablaViasMagiaPersonaje2 = new TablaTablaViasMagiaPersonaje();
//		tablaTablaViasMagiaPersonaje2.setTablaViasMagia(ch.obtenerViaMagiaSeleccionada(sessionFactory, tableViewNivelVia.getItems().get(1).getNombreViaSeleccionada().getSelectionModel().getSelectedItem()));		
//		tablaTablaViasMagiaPersonaje2.setNivelesUsados(Integer.parseInt(tableViewNivelVia.getItems().get(1).getNivelUsado()));
//		
//		TablaTablaViasMagiaPersonaje tablaTablaViasMagiaPersonaje3 = new TablaTablaViasMagiaPersonaje();
//		tablaTablaViasMagiaPersonaje3.setTablaViasMagia(ch.obtenerViaMagiaSeleccionada(sessionFactory, tableViewNivelVia.getItems().get(2).getNombreViaSeleccionada().getSelectionModel().getSelectedItem()));
//		tablaTablaViasMagiaPersonaje3.setNivelesUsados(Integer.parseInt(tableViewNivelVia.getItems().get(2).getNivelUsado()));
//		
//		TablaTablaViasMagiaPersonaje tablaTablaViasMagiaPersonaje4 = new TablaTablaViasMagiaPersonaje();
//		tablaTablaViasMagiaPersonaje4.setTablaViasMagia(ch.obtenerViaMagiaSeleccionada(sessionFactory, tableViewNivelVia.getItems().get(3).getNombreViaSeleccionada().getSelectionModel().getSelectedItem()));
//		tablaTablaViasMagiaPersonaje4.setNivelesUsados(Integer.parseInt(tableViewNivelVia.getItems().get(3).getNivelUsado()));
//		
//		TablaTablaViasMagiaPersonaje tablaTablaViasMagiaPersonaje5 = new TablaTablaViasMagiaPersonaje();
//		tablaTablaViasMagiaPersonaje5.setTablaViasMagia(ch.obtenerViaMagiaSeleccionada(sessionFactory, tableViewNivelVia.getItems().get(4).getNombreViaSeleccionada().getSelectionModel().getSelectedItem()));		
//		tablaTablaViasMagiaPersonaje5.setNivelesUsados(Integer.parseInt(tableViewNivelVia.getItems().get(4).getNivelUsado()));
//		
//		TablaTablaViasMagiaPersonaje tablaTablaViasMagiaPersonaje6 = new TablaTablaViasMagiaPersonaje();
//		tablaTablaViasMagiaPersonaje6.setTablaViasMagia(ch.obtenerViaMagiaSeleccionada(sessionFactory, tableViewNivelVia.getItems().get(5).getNombreViaSeleccionada().getSelectionModel().getSelectedItem()));
//		tablaTablaViasMagiaPersonaje6.setNivelesUsados(Integer.parseInt(tableViewNivelVia.getItems().get(5).getNivelUsado()));
		
		Set<TablaMagia> tablaMagia = new HashSet<TablaMagia>();
		if (!(tableViewTablasMistico.getItems().get(0).getNombreTablaSeleccionada().getSelectionModel().getSelectedItem()==null)) {
			TablaMagia tablaMagia1 = ch.obtenerTablaMagia(sessionFactory, tableViewTablasMistico.getItems().get(0).getNombreTablaSeleccionada().getSelectionModel().getSelectedItem());
			tablaMagia.add(tablaMagia1);
		}
		if (!(tableViewTablasMistico.getItems().get(1).getNombreTablaSeleccionada().getSelectionModel().getSelectedItem()==null)) {
			TablaMagia tablaMagia2 = ch.obtenerTablaMagia(sessionFactory, tableViewTablasMistico.getItems().get(1).getNombreTablaSeleccionada().getSelectionModel().getSelectedItem());
			tablaMagia.add(tablaMagia2);
		}
		
		Set<TablaConjurosLibreAcceso> tablaConjurosLibreAcceso = new HashSet<TablaConjurosLibreAcceso>();
		if (!(tableViewConjurosLibreAcceso.getItems().get(0).getNombreConjuroLibreAcceso().getSelectionModel().getSelectedItem()==null)) {
			TablaConjurosLibreAcceso tablaConjurosLibreAcceso1 = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, tableViewConjurosLibreAcceso.getItems().get(0).getNombreConjuroLibreAcceso().getSelectionModel().getSelectedItem());
			tablaConjurosLibreAcceso.add(tablaConjurosLibreAcceso1);
		}
		if (!(tableViewConjurosLibreAcceso.getItems().get(1).getNombreConjuroLibreAcceso().getSelectionModel().getSelectedItem()==null)) {
			TablaConjurosLibreAcceso tablaConjurosLibreAcceso2 = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, tableViewConjurosLibreAcceso.getItems().get(1).getNombreConjuroLibreAcceso().getSelectionModel().getSelectedItem());
			tablaConjurosLibreAcceso.add(tablaConjurosLibreAcceso2);
		}
		if (!(tableViewConjurosLibreAcceso.getItems().get(2).getNombreConjuroLibreAcceso().getSelectionModel().getSelectedItem()==null)) {
			TablaConjurosLibreAcceso tablaConjurosLibreAcceso3 = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, tableViewConjurosLibreAcceso.getItems().get(2).getNombreConjuroLibreAcceso().getSelectionModel().getSelectedItem());
			tablaConjurosLibreAcceso.add(tablaConjurosLibreAcceso3);
		}
		if (!(tableViewConjurosLibreAcceso.getItems().get(3).getNombreConjuroLibreAcceso().getSelectionModel().getSelectedItem()==null)) {
			TablaConjurosLibreAcceso tablaConjurosLibreAcceso4 = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, tableViewConjurosLibreAcceso.getItems().get(3).getNombreConjuroLibreAcceso().getSelectionModel().getSelectedItem());
			tablaConjurosLibreAcceso.add(tablaConjurosLibreAcceso4);
		}
		if (!(tableViewConjurosLibreAcceso.getItems().get(4).getNombreConjuroLibreAcceso().getSelectionModel().getSelectedItem()==null)) {
			TablaConjurosLibreAcceso tablaConjurosLibreAcceso5 = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, tableViewConjurosLibreAcceso.getItems().get(4).getNombreConjuroLibreAcceso().getSelectionModel().getSelectedItem());
			tablaConjurosLibreAcceso.add(tablaConjurosLibreAcceso5);
		}
		if (!(tableViewConjurosLibreAcceso.getItems().get(5).getNombreConjuroLibreAcceso().getSelectionModel().getSelectedItem()==null)) {
			TablaConjurosLibreAcceso tablaConjurosLibreAcceso6 = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, tableViewConjurosLibreAcceso.getItems().get(5).getNombreConjuroLibreAcceso().getSelectionModel().getSelectedItem());
			tablaConjurosLibreAcceso.add(tablaConjurosLibreAcceso6);
		}
		if (!(tableViewConjurosLibreAcceso.getItems().get(6).getNombreConjuroLibreAcceso().getSelectionModel().getSelectedItem()==null)) {
			TablaConjurosLibreAcceso tablaConjurosLibreAcceso7 = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, tableViewConjurosLibreAcceso.getItems().get(6).getNombreConjuroLibreAcceso().getSelectionModel().getSelectedItem());
			tablaConjurosLibreAcceso.add(tablaConjurosLibreAcceso7);
		}
		if (!(tableViewConjurosLibreAcceso.getItems().get(7).getNombreConjuroLibreAcceso().getSelectionModel().getSelectedItem()==null)) {
			TablaConjurosLibreAcceso tablaConjurosLibreAcceso8 = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, tableViewConjurosLibreAcceso.getItems().get(7).getNombreConjuroLibreAcceso().getSelectionModel().getSelectedItem());
			tablaConjurosLibreAcceso.add(tablaConjurosLibreAcceso8);
		}
		if (!(tableViewConjurosLibreAcceso.getItems().get(8).getNombreConjuroLibreAcceso().getSelectionModel().getSelectedItem()==null)) {
			TablaConjurosLibreAcceso tablaConjurosLibreAcceso9 = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, tableViewConjurosLibreAcceso.getItems().get(8).getNombreConjuroLibreAcceso().getSelectionModel().getSelectedItem());
			tablaConjurosLibreAcceso.add(tablaConjurosLibreAcceso9);
		}
		if (!(tableViewConjurosLibreAcceso.getItems().get(9).getNombreConjuroLibreAcceso().getSelectionModel().getSelectedItem()==null)) {
			TablaConjurosLibreAcceso tablaConjurosLibreAcceso10 = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, tableViewConjurosLibreAcceso.getItems().get(9).getNombreConjuroLibreAcceso().getSelectionModel().getSelectedItem());
			tablaConjurosLibreAcceso.add(tablaConjurosLibreAcceso10);
		}
		if (!(tableViewConjurosLibreAcceso.getItems().get(10).getNombreConjuroLibreAcceso().getSelectionModel().getSelectedItem()==null)) {
			TablaConjurosLibreAcceso tablaConjurosLibreAcceso11 = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, tableViewConjurosLibreAcceso.getItems().get(10).getNombreConjuroLibreAcceso().getSelectionModel().getSelectedItem());
			tablaConjurosLibreAcceso.add(tablaConjurosLibreAcceso11);
		}
		if (!(tableViewConjurosLibreAcceso.getItems().get(11).getNombreConjuroLibreAcceso().getSelectionModel().getSelectedItem()==null)) {
			TablaConjurosLibreAcceso tablaConjurosLibreAcceso12 = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, tableViewConjurosLibreAcceso.getItems().get(11).getNombreConjuroLibreAcceso().getSelectionModel().getSelectedItem());
			tablaConjurosLibreAcceso.add(tablaConjurosLibreAcceso12);
		}
		if (!(tableViewConjurosLibreAcceso.getItems().get(12).getNombreConjuroLibreAcceso().getSelectionModel().getSelectedItem()==null)) {
			TablaConjurosLibreAcceso tablaConjurosLibreAcceso13 = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, tableViewConjurosLibreAcceso.getItems().get(12).getNombreConjuroLibreAcceso().getSelectionModel().getSelectedItem());
			tablaConjurosLibreAcceso.add(tablaConjurosLibreAcceso13);
		}
		if (!(tableViewConjurosLibreAcceso.getItems().get(13).getNombreConjuroLibreAcceso().getSelectionModel().getSelectedItem()==null)) {
			TablaConjurosLibreAcceso tablaConjurosLibreAcceso14 = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, tableViewConjurosLibreAcceso.getItems().get(13).getNombreConjuroLibreAcceso().getSelectionModel().getSelectedItem());
			tablaConjurosLibreAcceso.add(tablaConjurosLibreAcceso14);
		}
		if (!(tableViewConjurosLibreAcceso.getItems().get(14).getNombreConjuroLibreAcceso().getSelectionModel().getSelectedItem()==null)) {
			TablaConjurosLibreAcceso tablaConjurosLibreAcceso15 = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, tableViewConjurosLibreAcceso.getItems().get(14).getNombreConjuroLibreAcceso().getSelectionModel().getSelectedItem());
			tablaConjurosLibreAcceso.add(tablaConjurosLibreAcceso15);
		}
		if (!(tableViewConjurosLibreAcceso.getItems().get(15).getNombreConjuroLibreAcceso().getSelectionModel().getSelectedItem()==null)) {
			TablaConjurosLibreAcceso tablaConjurosLibreAcceso16 = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, tableViewConjurosLibreAcceso.getItems().get(15).getNombreConjuroLibreAcceso().getSelectionModel().getSelectedItem());
			tablaConjurosLibreAcceso.add(tablaConjurosLibreAcceso16);
		}
		if (!(tableViewConjurosLibreAcceso.getItems().get(16).getNombreConjuroLibreAcceso().getSelectionModel().getSelectedItem()==null)) {
			TablaConjurosLibreAcceso tablaConjurosLibreAcceso17 = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, tableViewConjurosLibreAcceso.getItems().get(16).getNombreConjuroLibreAcceso().getSelectionModel().getSelectedItem());
			tablaConjurosLibreAcceso.add(tablaConjurosLibreAcceso17);
		}
		if (!(tableViewConjurosLibreAcceso.getItems().get(17).getNombreConjuroLibreAcceso().getSelectionModel().getSelectedItem()==null)) {
			TablaConjurosLibreAcceso tablaConjurosLibreAcceso18 = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, tableViewConjurosLibreAcceso.getItems().get(17).getNombreConjuroLibreAcceso().getSelectionModel().getSelectedItem());
			tablaConjurosLibreAcceso.add(tablaConjurosLibreAcceso18);
		}
		if (!(tableViewConjurosLibreAcceso.getItems().get(18).getNombreConjuroLibreAcceso().getSelectionModel().getSelectedItem()==null)) {
			TablaConjurosLibreAcceso tablaConjurosLibreAcceso19 = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, tableViewConjurosLibreAcceso.getItems().get(18).getNombreConjuroLibreAcceso().getSelectionModel().getSelectedItem());
			tablaConjurosLibreAcceso.add(tablaConjurosLibreAcceso19);
		}
		if (!(tableViewConjurosLibreAcceso.getItems().get(19).getNombreConjuroLibreAcceso().getSelectionModel().getSelectedItem()==null)) {
			TablaConjurosLibreAcceso tablaConjurosLibreAcceso20 = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, tableViewConjurosLibreAcceso.getItems().get(19).getNombreConjuroLibreAcceso().getSelectionModel().getSelectedItem());
			tablaConjurosLibreAcceso.add(tablaConjurosLibreAcceso20);
		}
		if (!(tableViewConjurosLibreAcceso.getItems().get(20).getNombreConjuroLibreAcceso().getSelectionModel().getSelectedItem()==null)) {
			TablaConjurosLibreAcceso tablaConjurosLibreAcceso21 = ch.obtenerConjuroLibreAccesoSeleccionado(sessionFactory, tableViewConjurosLibreAcceso.getItems().get(20).getNombreConjuroLibreAcceso().getSelectionModel().getSelectedItem());
			tablaConjurosLibreAcceso.add(tablaConjurosLibreAcceso21);
		}

		Set<PoderPsiquico> tablaPoderesPsiquicos = new HashSet<PoderPsiquico>();
		if (!(tableViewPoderesPsiquicos.getItems().get(1).getNombrePoderSeleccionado().getSelectionModel().getSelectedItem()==null)) {
			PoderPsiquico poderPsiquico1 = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, tableViewPoderesPsiquicos.getItems().get(0).getNombrePoderSeleccionado().getSelectionModel().getSelectedItem());
			tablaPoderesPsiquicos.add(poderPsiquico1);
		}
		if (!(tableViewPoderesPsiquicos.getItems().get(1).getNombrePoderSeleccionado().getSelectionModel().getSelectedItem()==null)) {
			PoderPsiquico poderPsiquico2 = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, tableViewPoderesPsiquicos.getItems().get(1).getNombrePoderSeleccionado().getSelectionModel().getSelectedItem());
			tablaPoderesPsiquicos.add(poderPsiquico2);
		}
		if (!(tableViewPoderesPsiquicos.getItems().get(2).getNombrePoderSeleccionado().getSelectionModel().getSelectedItem()==null)) {
			PoderPsiquico poderPsiquico3 = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, tableViewPoderesPsiquicos.getItems().get(2).getNombrePoderSeleccionado().getSelectionModel().getSelectedItem());
			tablaPoderesPsiquicos.add(poderPsiquico3);
		}
		if (!(tableViewPoderesPsiquicos.getItems().get(3).getNombrePoderSeleccionado().getSelectionModel().getSelectedItem()==null)) {
			PoderPsiquico poderPsiquico4 = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, tableViewPoderesPsiquicos.getItems().get(3).getNombrePoderSeleccionado().getSelectionModel().getSelectedItem());
			tablaPoderesPsiquicos.add(poderPsiquico4);
		}
		if (!(tableViewPoderesPsiquicos.getItems().get(4).getNombrePoderSeleccionado().getSelectionModel().getSelectedItem()==null)) {
			PoderPsiquico poderPsiquico5 = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, tableViewPoderesPsiquicos.getItems().get(4).getNombrePoderSeleccionado().getSelectionModel().getSelectedItem());
			tablaPoderesPsiquicos.add(poderPsiquico5);
		}
		if (!(tableViewPoderesPsiquicos.getItems().get(5).getNombrePoderSeleccionado().getSelectionModel().getSelectedItem()==null)) {
			PoderPsiquico poderPsiquico6 = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, tableViewPoderesPsiquicos.getItems().get(5).getNombrePoderSeleccionado().getSelectionModel().getSelectedItem());
			tablaPoderesPsiquicos.add(poderPsiquico6);
		}
		if (!(tableViewPoderesPsiquicos.getItems().get(6).getNombrePoderSeleccionado().getSelectionModel().getSelectedItem()==null)) {
			PoderPsiquico poderPsiquico7 = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, tableViewPoderesPsiquicos.getItems().get(6).getNombrePoderSeleccionado().getSelectionModel().getSelectedItem());
			tablaPoderesPsiquicos.add(poderPsiquico7);
		}
		if (!(tableViewPoderesPsiquicos.getItems().get(7).getNombrePoderSeleccionado().getSelectionModel().getSelectedItem()==null)) {
			PoderPsiquico poderPsiquico8 = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, tableViewPoderesPsiquicos.getItems().get(7).getNombrePoderSeleccionado().getSelectionModel().getSelectedItem());
			tablaPoderesPsiquicos.add(poderPsiquico8);
		}
		if (!(tableViewPoderesPsiquicos.getItems().get(8).getNombrePoderSeleccionado().getSelectionModel().getSelectedItem()==null)) {
			PoderPsiquico poderPsiquico9 = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, tableViewPoderesPsiquicos.getItems().get(8).getNombrePoderSeleccionado().getSelectionModel().getSelectedItem());
			tablaPoderesPsiquicos.add(poderPsiquico9);
		}
		if (!(tableViewPoderesPsiquicos.getItems().get(9).getNombrePoderSeleccionado().getSelectionModel().getSelectedItem()==null)) {
			PoderPsiquico poderPsiquico10 = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, tableViewPoderesPsiquicos.getItems().get(9).getNombrePoderSeleccionado().getSelectionModel().getSelectedItem());
			tablaPoderesPsiquicos.add(poderPsiquico10);
		}
		if (!(tableViewPoderesPsiquicos.getItems().get(10).getNombrePoderSeleccionado().getSelectionModel().getSelectedItem()==null)) {
			PoderPsiquico poderPsiquico11 = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, tableViewPoderesPsiquicos.getItems().get(10).getNombrePoderSeleccionado().getSelectionModel().getSelectedItem());
			tablaPoderesPsiquicos.add(poderPsiquico11);
		}
		if (!(tableViewPoderesPsiquicos.getItems().get(11).getNombrePoderSeleccionado().getSelectionModel().getSelectedItem()==null)) {
			PoderPsiquico poderPsiquico12 = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, tableViewPoderesPsiquicos.getItems().get(11).getNombrePoderSeleccionado().getSelectionModel().getSelectedItem());
			tablaPoderesPsiquicos.add(poderPsiquico12);
		}
		if (!(tableViewPoderesPsiquicos.getItems().get(12).getNombrePoderSeleccionado().getSelectionModel().getSelectedItem()==null)) {
			PoderPsiquico poderPsiquico13 = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, tableViewPoderesPsiquicos.getItems().get(12).getNombrePoderSeleccionado().getSelectionModel().getSelectedItem());
			tablaPoderesPsiquicos.add(poderPsiquico13);
		}
		if (!(tableViewPoderesPsiquicos.getItems().get(13).getNombrePoderSeleccionado().getSelectionModel().getSelectedItem()==null)) {
			PoderPsiquico poderPsiquico14 = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, tableViewPoderesPsiquicos.getItems().get(13).getNombrePoderSeleccionado().getSelectionModel().getSelectedItem());
			tablaPoderesPsiquicos.add(poderPsiquico14);
		}
		if (!(tableViewPoderesPsiquicos.getItems().get(14).getNombrePoderSeleccionado().getSelectionModel().getSelectedItem()==null)) {
			PoderPsiquico poderPsiquico15 = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, tableViewPoderesPsiquicos.getItems().get(14).getNombrePoderSeleccionado().getSelectionModel().getSelectedItem());
			tablaPoderesPsiquicos.add(poderPsiquico15);
		}
		if (!(tableViewPoderesPsiquicos.getItems().get(15).getNombrePoderSeleccionado().getSelectionModel().getSelectedItem()==null)) {
			PoderPsiquico poderPsiquico16 = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, tableViewPoderesPsiquicos.getItems().get(15).getNombrePoderSeleccionado().getSelectionModel().getSelectedItem());
			tablaPoderesPsiquicos.add(poderPsiquico16);
		}
		if (!(tableViewPoderesPsiquicos.getItems().get(16).getNombrePoderSeleccionado().getSelectionModel().getSelectedItem()==null)) {
			PoderPsiquico poderPsiquico17 = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, tableViewPoderesPsiquicos.getItems().get(16).getNombrePoderSeleccionado().getSelectionModel().getSelectedItem());
			tablaPoderesPsiquicos.add(poderPsiquico17);
		}
		if (!(tableViewPoderesPsiquicos.getItems().get(17).getNombrePoderSeleccionado().getSelectionModel().getSelectedItem()==null)) {
			PoderPsiquico poderPsiquico18 = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, tableViewPoderesPsiquicos.getItems().get(17).getNombrePoderSeleccionado().getSelectionModel().getSelectedItem());
			tablaPoderesPsiquicos.add(poderPsiquico18);
		}
		if (!(tableViewPoderesPsiquicos.getItems().get(18).getNombrePoderSeleccionado().getSelectionModel().getSelectedItem()==null)) {
			PoderPsiquico poderPsiquico19 = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, tableViewPoderesPsiquicos.getItems().get(18).getNombrePoderSeleccionado().getSelectionModel().getSelectedItem());
			tablaPoderesPsiquicos.add(poderPsiquico19);
		}
		if (!(tableViewPoderesPsiquicos.getItems().get(19).getNombrePoderSeleccionado().getSelectionModel().getSelectedItem()==null)) {
			PoderPsiquico poderPsiquico20 = ch.obtenerPoderPsiquicoSeleccionado(sessionFactory, tableViewPoderesPsiquicos.getItems().get(19).getNombrePoderSeleccionado().getSelectionModel().getSelectedItem());
			tablaPoderesPsiquicos.add(poderPsiquico20);
		}
		
		Personaje personajeNuevo = new Personaje();
		
		personajeNuevo.setNombre(tNombre.getText());
		personajeNuevo.setImagen(direccionImagen);
		personajeNuevo.setApariencia(Integer.parseInt(tApariencia.getText()));
		personajeNuevo.setEdad(Integer.parseInt(tEdad.getText()));
		personajeNuevo.setOrigen(tRegeneracion.getText());
		personajeNuevo.setEtnia(tEtniaGeneral.getText());
		
		personajeNuevo.setDescripcion(tAreaPersonalidad.getText());
		personajeNuevo.setParticularidades(tAreaParticularidades.getText());
		personajeNuevo.setObjetivos(tAreaObjetivos.getText());
		personajeNuevo.setHistoria(tAreaHistoria.getText());
		personajeNuevo.setCansancioEspecial(Integer.parseInt(tCansancioEspecial.getText()));
		personajeNuevo.setTurnoEspecial(Integer.parseInt(tTurnoEspecial.getText()));
		personajeNuevo.setPvEspecial(Integer.parseInt(tPuntosVidaEspecial.getText()));
		personajeNuevo.setRegeneracionEspecial(Integer.parseInt(tPuntosRegeneracionEspecial.getText()));
		personajeNuevo.setCvInvertido(Integer.parseInt(tCvUsado.getText()));
		
		personajeNuevo.setContactos(tAreaContactos.getText());
		personajeNuevo.setEquipoCombate(tAreaEquipoCombate.getText());
		personajeNuevo.setEquipoVariado(tAreaEquipoVariado.getText());
		personajeNuevo.setTitulosPosesiones(tAreaTitulosPosesiones.getText());
		personajeNuevo.setVestimentaAccesorios(tAreaVestimenta.getText());
		personajeNuevo.setJoyas(tAreaJoyas.getText());
		personajeNuevo.setMonedasOro(tDineroOro.getText());
		personajeNuevo.setMonedasPlata(tDineroPlata.getText());
		personajeNuevo.setMonedasCobre(tDineroCobre.getText());
		
		personajeNuevo.setCategoria(categoriaSeleccionada);
		personajeNuevo.setRaza(razaSeleccionada);
		personajeNuevo.setCaracteristicas(caracteristicas);
		personajeNuevo.setArmas(armas);
		personajeNuevo.setArmaduras(armaduras);
		personajeNuevo.setVentajas(ventajas);
		personajeNuevo.setDesventajas(desventajas);
		personajeNuevo.setArteMarcials(tablaArteMarcial);
		personajeNuevo.setTablaEstilos(tablaEstilos);
		personajeNuevo.setNivel(Integer.parseInt(tNivelTotal.getText()));
		
		if (null==personaje.getNombre()) {
			int idPersonaje = ch.insertarPersonaje(sessionFactory, personajeNuevo, caracteristicas, pdsPrimariasComunes, pdsPrimariasKi, pdsPrimariasMisticas, pdsPrimariasPsiquicas,
					pdsSecundariasAtleticas, pdsSecundariasSociales, pdsSecundariasCreativas, pdsSecundariasIntelectuales, pdsSecundariasPerceptivas, pdsSecundariasSubterfugio, 
					pdsSecundariasVigor, ventajas, desventajas, armas, armaduras, tablaArteMarcial, tablaConjurosLibreAcceso, tablaPoderesPsiquicos, tablaEstilos);
		} else {
			int idPersonaje = ch.actualizarPersonaje(sessionFactory, personajeNuevo, caracteristicas, pdsPrimariasComunes, pdsPrimariasKi, pdsPrimariasMisticas, pdsPrimariasPsiquicas,
					pdsSecundariasAtleticas, pdsSecundariasSociales, pdsSecundariasCreativas, pdsSecundariasIntelectuales, pdsSecundariasPerceptivas, pdsSecundariasSubterfugio, 
					pdsSecundariasVigor, ventajas, desventajas, armas, armaduras, tablaArteMarcial, tablaConjurosLibreAcceso, tablaPoderesPsiquicos, tablaEstilos);
		}
		
		((Node)ev.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		primaryStage = new Stage();
		PrincipalController inicio = new PrincipalController(sessionFactory);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Principal.fxml"));
		loader.setController(inicio);
		Pane pane = (Pane)loader.load();
		Scene scene = new Scene(pane,1400,800);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setTitle("Anima Sheet Manager");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void salirPersonaje(ActionEvent ev) throws IOException {
		((Node)ev.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		primaryStage = new Stage();
		PrincipalController inicio = new PrincipalController(sessionFactory);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Principal.fxml"));
		loader.setController(inicio);
		Pane pane = (Pane)loader.load();
		Scene scene = new Scene(pane,1400,800);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setTitle("Anima Sheet Manager");
		primaryStage.setScene(scene);
		primaryStage.show();
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
