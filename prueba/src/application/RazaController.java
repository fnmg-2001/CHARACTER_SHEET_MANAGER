package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.SessionFactory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelo.Categoria;
import modelo.ConsultasHibernate;
import modelo.Raza;
import javafx.scene.Node;

public class RazaController {
	
	SessionFactory sessionFactory;
	
	@FXML
	ScrollPane pRazas, pRazaSeleccionada, pCategoria, pCategoriaSeleccionada;
	
	@FXML
	TextField txtArquetipo, txtMultiploVida, txtPuntosVida, txtTurno, txtConocimientoMarcial, txtCvInnatos, txtHa, txtHp, txtHe, txtLlevarArmadura,
	txtCosteConocimientoMarcial, txtKi, txtMultiploAcumulacion, txtZeon, txtMultiploAct, txtProyeccionMagica, txtConvocar, txtControlar, txtAtar, txtDesconvocar,
	txtCv, txtProyeccionPsiquica, txtAtleticas, txtSociales, txtPerceptivas, txtIntelectuales, txtVigor, txtSubterfugio, txtCreativas;
	
	@FXML
	Label lRaza1, lRaza2, lHome, lRasgos, lBack, lCategoria1, lCategoria2;
	
	@FXML
	TextArea tAreaDescripcion, tAreaDescripcionCategoria;
	
	@FXML
	Accordion acRasgos;
	
	@FXML
	ImageView imgHome, imgBack, imgBack2, imgRaza, imgCategoria;
	
	@FXML
	ComboBox<String> cNephilim, cPaladinAlter;
	
	@FXML
	Pane pBonosCostes;
	
	Categoria categoria;
	
	public RazaController(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		
	}
	
	@FXML
	public void initialize(){
		ConsultasHibernate ch = new ConsultasHibernate();
		ObservableList<String> listaNephilims = ch.obtenerListaNombreNephilim(sessionFactory);
		cNephilim.setItems(listaNephilims);
		cNephilim.getSelectionModel().selectFirst();
		
	}
	
	public void home(MouseEvent ev) throws IOException {
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
	
	public void selectRaza(ActionEvent ev) throws IOException {
		imgBack.setVisible(true);
		cNephilim.getSelectionModel().selectFirst();
		int nRasgos = 0;
		ConsultasHibernate ch = new ConsultasHibernate();
		Raza raza = ch.obtenerRaza(((Button)ev.getSource()).getText(), sessionFactory);
		
		tAreaDescripcion.setText(raza.getDescripcion());
		
		pRazas.setVisible(false);
		lRaza2.setText(((Button)ev.getSource()).getText());
		lRaza1.setVisible(false);
		lRaza2.setVisible(true);
		
		nRasgos = comprobarNumeroRasgos(raza);
		if (nRasgos > 0) {
			cNephilim.setVisible(false);
			lRasgos.setVisible(true);
			acRasgos.setVisible(true);
			TitledPane[] tRasgos = new TitledPane[nRasgos];
			TextArea[] tArea = new TextArea[nRasgos];
			String [] sRasgos = new String[]{raza.getRasgo1(),raza.getRasgo2(),raza.getRasgo3(),raza.getRasgo4(),raza.getRasgo5(),
					raza.getRasgo6(),raza.getRasgo7(),raza.getRasgo8(),raza.getRasgo9(),raza.getRasgo10(),raza.getRasgo11()};
			
			for (int i = 0; i < nRasgos; i++) {
				String[] partes = sRasgos[i].split(":");
				tArea[i] = new TextArea(partes[1]);
				tArea[i].setWrapText(true);
				tArea[i].setEditable(false);
	            tRasgos[i] = new TitledPane(partes[0],tArea[i]);
	            
	        }
			imgRaza.setImage(new Image("file:"+raza.getImagen()));
			acRasgos.getPanes().clear();
			acRasgos.getPanes().addAll(tRasgos);
			acRasgos.setExpandedPane(tRasgos[0]);
			
		}else {
			imgRaza.setImage(new Image("file:"+raza.getImagen()));
			cNephilim.setVisible(true);
			lRasgos.setVisible(false);
			acRasgos.setVisible(false);
			
		}
		
	}
	
	public void selectNephilim(ActionEvent ev) throws IOException {
		imgBack.setVisible(true);
		int nRasgos = 0;
		ConsultasHibernate ch = new ConsultasHibernate();
		Raza raza = ch.obtenerRaza(cNephilim.getSelectionModel().getSelectedItem(), sessionFactory);
		
		tAreaDescripcion.setText(raza.getDescripcion());
		
		pRazas.setVisible(false);
		lRaza2.setText(cNephilim.getSelectionModel().getSelectedItem());
		lRaza1.setVisible(false);
		lRaza2.setVisible(true);
		
		nRasgos = comprobarNumeroRasgos(raza);
		if (nRasgos > 0) {
			cNephilim.setVisible(true);
			lRasgos.setVisible(true);
			acRasgos.setVisible(true);
			TitledPane[] tRasgos = new TitledPane[nRasgos];
			TextArea[] tArea = new TextArea[nRasgos];
			String [] sRasgos = new String[]{raza.getRasgo1(),raza.getRasgo2(),raza.getRasgo3(),raza.getRasgo4(),raza.getRasgo5(),
					raza.getRasgo6(),raza.getRasgo7(),raza.getRasgo8(),raza.getRasgo9(),raza.getRasgo10(),raza.getRasgo11()};
			
			for (int i = 0; i < nRasgos; i++) {
				String[] partes = sRasgos[i].split(":");
				tArea[i] = new TextArea(partes[1]);
				tArea[i].setWrapText(true);
				tArea[i].setEditable(false);;
	            tRasgos[i] = new TitledPane(partes[0],tArea[i]);
	            
	        }
			imgRaza.setImage(new Image("file:"+raza.getImagen()));
			acRasgos.getPanes().clear();
			acRasgos.getPanes().addAll(tRasgos);
			acRasgos.setExpandedPane(tRasgos[0]);
			
		}else {
			imgRaza.setImage(new Image("file:"+raza.getImagen()));
			lRasgos.setVisible(false);
			acRasgos.setVisible(false);
			
		}
		
	}
	
	public int comprobarNumeroRasgos(Raza raza) {
		int numeroRasgos=0;
		
		String rasgosRaza [] = new String [] {raza.getRasgo1(),raza.getRasgo2(),raza.getRasgo3(),raza.getRasgo4(),raza.getRasgo5(),
				raza.getRasgo6(),raza.getRasgo7(),raza.getRasgo8(),raza.getRasgo9(),raza.getRasgo10(),raza.getRasgo11()};
		
		for (int i = 0; i < rasgosRaza.length; i++) {
			if (rasgosRaza[i]!=null) {
				numeroRasgos++;
			}
		}
		return numeroRasgos;
	}
	
	public void selectRazaAceptar(ActionEvent ev) {
		pCategoria.setVisible(true);
		pRazas.setVisible(false);
		pRazaSeleccionada.setVisible(false);
		lCategoria1.setVisible(true);
		lRaza2.setVisible(false);
		imgBack2.setVisible(true);
		imgBack.setVisible(false);

	}
	
	public void selectCategoria(ActionEvent ev) throws IOException {
		
		pBonosCostes.getChildren().clear();
		ConsultasHibernate ch = new ConsultasHibernate();
		Categoria categoria = ch.obtenerCategoria(((Button)ev.getSource()).getText(), sessionFactory);
		
		if (((Button)ev.getSource()).getText().equals("PALADIN")) {
			cPaladinAlter.setVisible(true);
			ObservableList<String> nombrePaladin = FXCollections.observableArrayList();
			nombrePaladin.setAll("PALADIN","PALADIN(ESP)");
			cPaladinAlter.setItems(nombrePaladin);
			cPaladinAlter.getSelectionModel().select(0);
			
		} else if (((Button)ev.getSource()).getText().equals("PALADIN OSCURO")) {
			cPaladinAlter.setVisible(true);
			ObservableList<String> nombrePaladin = FXCollections.observableArrayList();
			nombrePaladin.setAll("PALADIN OSCURO","PALADIN OSCURO(ESP)");
			cPaladinAlter.setItems(nombrePaladin);
			cPaladinAlter.getSelectionModel().select(0);
			
		} else {
			cPaladinAlter.setVisible(false);
		}
		
		txtArquetipo.setText(categoria.getArquetipo1()); 
		if (categoria.getArquetipo2()==null) {
			txtArquetipo.setText(categoria.getArquetipo1());
		} else {
			txtArquetipo.setText(categoria.getArquetipo1()+", "+categoria.getArquetipo2());
		}
		
		imgCategoria.setImage(new Image("file:"+categoria.getImagen()));
		tAreaDescripcionCategoria.setText(categoria.getDescripcion());
		txtMultiploVida.setText(String.valueOf(categoria.getMultiploVida()));
		txtPuntosVida.setText(String.valueOf(categoria.getPuntosVida()));
		txtTurno.setText(String.valueOf(categoria.getTurno()));
		txtConocimientoMarcial.setText(String.valueOf(categoria.getConocimientoMarcial()));
		txtCvInnatos.setText(String.valueOf(categoria.getCvInnato()));
		
		txtHa.setText(String.valueOf(categoria.getCosteHabilidadAtaque()));
		txtHp.setText(String.valueOf(categoria.getCosteHabilidadParada()));
		txtHe.setText(String.valueOf(categoria.getCosteHabilidadEsquiva()));
		txtLlevarArmadura.setText(String.valueOf(categoria.getCosteLlevarArmadura()));
		txtCosteConocimientoMarcial.setText("5");
		txtKi.setText(String.valueOf(categoria.getCostePuntoKi()));
		txtMultiploAcumulacion.setText(String.valueOf(categoria.getCosteAcumulacionKi()));
		
		txtZeon.setText(String.valueOf(categoria.getCosteZeon()));
		txtMultiploAct.setText(String.valueOf(categoria.getMultiploRegeneracion()));
		txtProyeccionMagica.setText(String.valueOf(categoria.getCosteProyeccionMagica()));
		txtConvocar.setText(String.valueOf(categoria.getCosteConvocar()));
		txtControlar.setText(String.valueOf(categoria.getCosteControlar())); 
		txtAtar.setText(String.valueOf(categoria.getCosteAtar())); 
		txtDesconvocar.setText(String.valueOf(categoria.getCosteDesconvocar()));
		
		txtCv.setText(String.valueOf(categoria.getCostePuntosCv()));
		txtProyeccionPsiquica.setText(String.valueOf(categoria.getCosteProyeccionPsiquica()));
		
		txtAtleticas.setText(String.valueOf(categoria.getCosteAtleticas()));
		txtSociales.setText(String.valueOf(categoria.getCosteSociales()));
		txtPerceptivas.setText(String.valueOf(categoria.getCostePerceptivas())); 
		txtIntelectuales.setText(String.valueOf(categoria.getCosteIntelectuales())); 
		txtVigor.setText(String.valueOf(categoria.getCosteVigor())); 
		txtSubterfugio.setText(String.valueOf(categoria.getCosteSubterfugio()));
		txtCreativas.setText(String.valueOf(categoria.getCosteCreativas()));
		
		lCategoria2.setText(categoria.getNombre());
		
		
		List<Integer> lBono = new ArrayList<Integer>();
		Integer [] sBonos = new Integer[]{categoria.getBonoAcrobacias(), categoria.getBonoAdvertir(), categoria.getBonoAnimales(), categoria.getBonoAtar(), categoria.getBonoAtletismo(),
				categoria.getBonoBuscar(), categoria.getBonoControlar(), categoria.getBonoConvocar(), categoria.getBonoDesconvocar(), categoria.getBonoDeteccionKi(), 
				categoria.getBonoDisfraz(), categoria.getBonoEstilo(), categoria.getBonoFrialdad(), categoria.getBonoHa(), categoria.getBonoHe(), categoria.getBonoHp(), categoria.getBonoHerbolaria(),
				categoria.getBonoIntimidar(), categoria.getBonoLiderazgo(), categoria.getBonoLlevarArmadura(), categoria.getBonoOcultacionKi(), categoria.getBonoOcultarse(), categoria.getBonoOcultismo(),
				categoria.getBonoPersuasion(), categoria.getBonoProezaFuerza(), categoria.getBonoRastrear(),categoria.getBonoResistirDolor(), categoria.getBonoRobo(), categoria.getBonoSaltar(), 
				categoria.getBonoSigilo(), categoria.getBonoTramperia(), categoria.getBonoTrucoManos(), categoria.getBonoValoracionMagica(), categoria.getBonoVeneno(), categoria.getBonoZeon(),

				categoria.getCosteReducidoAcrobacias(), categoria.getCosteReducidoAdvertir(), categoria.getCosteReducidoAnimales(), categoria.getCosteReducidoAtletismo(), categoria.getCosteReducidoBuscar(), 
				categoria.getCosteReducidoDisfraz(), categoria.getCosteReducidoEstilo(), categoria.getCosteReducidoFrialdad(), categoria.getCosteReducidoHerbolaria(),
				categoria.getCosteReducidoIntimidar(), categoria.getCosteReducidoLiderazgo(), categoria.getCosteReducidoOcultarse(), categoria.getCosteReducidoOcultismo(), categoria.getCosteReducidoMemorizar(),
				categoria.getCosteReducidoPersuasion(), categoria.getCosteReducidoProezaFuerza(), categoria.getCosteReducidoRastrear(),categoria.getCosteReducidoResistirDolor(), categoria.getCosteReducidoRobo(), 
				categoria.getCosteReducidoSaltar(), categoria.getCosteReducidoSigilo(), categoria.getCosteReducidoTramperia(), categoria.getCosteReducidoTrucoManos(), categoria.getCosteReducidoValoracionMagica(), 
				categoria.getCosteReducidoVenenos()};
		
		for (int i = 0; i < sBonos.length; i++) {
			lBono.add(sBonos[i]);
		}
		
		
		List<String> lBonoNombre = new ArrayList<String>();
		String [] sBonosNombres = new String[] {"BONO ACROBACIAS", "BONO ADVERTIR", "BONO ANIMALES", "BONO ATAR", "BONO ATLETISMO",
				"BONO BUSCAR", "BONO CONTROLAR", "BONO CONVOCAR", "BONO DESCONVOCAR", "BONO DETECCION DE KI", 
				"BONO DISFRAZ", "BONO ESTILO", "BONO FRIALDAD", "BONO HABILIDAD DE ATAQUE", "BONO HABILIDAD DE ESQUIVA", "BONO HABILIDAD DE PARADA", "BONO HERBOLARIA",
				"BONO INTIMIDAR", "BONO LIDERAZGO", "BONO LLEVAR ARMADURA", "BONO OCULTACION DE KI", "BONO OCULTARSE", "BONO OCULTISMO",
				"BONO PERSUASION", "BONO PROEZA DE FUERZA", "BONO RASTREAR", "BONO RESISTIR EL DOLOR", "BONO ROBO", "BONO SALTAR", 
				"BONO SIGILO", "BONO TRAMPERIA", "BONO TRUCO DE MANOS", "BONO VALORACION MAGICA", "BONO VENENO", "BONO ZEON",

				"COSTE REDUCIDO ACROBACIAS", "COSTE REDUCIDO ADVERTIR", "COSTE REDUCIDO ANIMALES", "COSTE REDUCIDO ATLETISMO", "COSTE REDUCIDO BUSCAR", 
				"COSTE REDUCIDO DISFRAZ", "COSTE REDUCIDO ESTILO", "COSTE REDUCIDO FRIALDAD", "COSTE REDUCIDO HERBOLARIA",
				"COSTE REDUCIDO INTIMIDAR", "COSTE REDUCIDO LIDERAZGO", "COSTE REDUCIDO OCULTARSE", "COSTE REDUCIDO OCULTISMO", "COSTE REDUCIDO MEMORIZAR",
				"COSTE REDUCIDO PERSUASION", "COSTE REDUCIDO PROEZA DE FUERZA", "COSTE REDUCIDO RASTREAR", "COSTE REDUCIDO RESISTIR EL DOLOR", "COSTE REDUCIDO ROBO", 
				"COSTE REDUCIDO SALTAR", "COSTE REDUCIDO SIGILO", "COSTE REDUCIDO TRAMPERIA", "COSTE REDUCIDO TRUCO DE MANOS", "COSTE REDUCIDO VALORACION MAGICA", 
				"COSTE REDUCIDO VENENO"};
		
		for (int i = 0; i < sBonosNombres.length; i++) {
			lBonoNombre.add(sBonosNombres[i]);
		}
		
		
		int nBonos = comprobarNumeroBonos(categoria, sBonos);
		lBonoNombre = eliminarNombreBonosNulos(lBonoNombre,lBono);
		lBono.removeAll(Collections.singleton(null));
		TextField tBonos[] = new TextField[nBonos];
		Label lNombresBonos[] = new Label[nBonos];
		int x = 0;
		int y = 0;
		
		for (int i = 0; i < nBonos; i++) {
			
			tBonos[i] = new TextField();
			tBonos[i].setPrefWidth(366);
			tBonos[i].setPrefHeight(31);
			tBonos[i].setLayoutX(x);
			tBonos[i].setLayoutY(y);
			tBonos[i].getStyleClass().add("textFieldBonos");
			tBonos[i].setAlignment(Pos.CENTER_RIGHT);
			tBonos[i].setEditable(false);
			tBonos[i].setText(String.valueOf(lBono.get(i)));
			
			
			lNombresBonos[i] = new Label();
			lNombresBonos[i].setPrefWidth(320);
			lNombresBonos[i].setPrefHeight(30);
			lNombresBonos[i].setLayoutX(x);
			lNombresBonos[i].setLayoutY(y);
			lNombresBonos[i].getStyleClass().add("labelRasgoCategoria");
			lNombresBonos[i].setText(lBonoNombre.get(i));
			
			pBonosCostes.getChildren().add(tBonos[i]);
			pBonosCostes.getChildren().add(lNombresBonos[i]);
			
			y= y+31;
		}
		
		pCategoriaSeleccionada.setVisible(true);
		pCategoria.setVisible(false);
		lCategoria1.setVisible(false);
		lCategoria2.setVisible(true);
		lRaza2.setVisible(false);
		imgBack2.setVisible(true);
		imgBack.setVisible(false);
		
		if (lCategoria2.getText().equals("NOVEL")) {
			TextField tBonoEspecial = new TextField();
			tBonoEspecial.setText("+10 A CINCO HABILIDADES POR NIVEL");
			tBonoEspecial.setPrefWidth(366);
			tBonoEspecial.setPrefHeight(31);
			tBonoEspecial.setLayoutX(0);
			tBonoEspecial.setLayoutY(580);
			tBonoEspecial.getStyleClass().add("textFieldBonos");
			tBonoEspecial.setAlignment(Pos.CENTER_RIGHT);
			tBonoEspecial.setEditable(false);
			pBonosCostes.getChildren().add(tBonoEspecial);
		}
		if (lCategoria2.getText().equals("MENTALISTA")) {
			TextField tBonoEspecial = new TextField();
			tBonoEspecial.setText("NO TIENE BONOS NI COSTES REDUCIDOS");
			tBonoEspecial.setPrefWidth(366);
			tBonoEspecial.setPrefHeight(31);
			tBonoEspecial.setLayoutX(0);
			tBonoEspecial.setLayoutY(580);
			tBonoEspecial.getStyleClass().add("textFieldBonos");
			tBonoEspecial.setAlignment(Pos.CENTER_RIGHT);
			tBonoEspecial.setEditable(false);
			pBonosCostes.getChildren().add(tBonoEspecial);
		}
		
	}
	
	public int comprobarNumeroBonos(Categoria categoria, Integer sBonos []) {
		int numeroBonos=0;
		
		
		for (int i = 0; i < sBonos.length; i++) {
			if (sBonos[i]!=null) {
				
			}
			
			if (sBonos[i]!=null) {
				numeroBonos++;
			}
			
		}
		return numeroBonos;
	}
	
	public List<String> eliminarNombreBonosNulos(List<String> lBonoNombre, List<Integer> lBono) {
		List<String> lBonoNombres = new ArrayList<String>();
		for (int i = 0; i < 59;) {
			if (lBono.get(i)==null) {

				++i;
			} else {
				lBonoNombres.add(lBonoNombre.get(i));
				i++;
			}
		}
		
		return lBonoNombres;
	}
	
	public void selectPaladinAlter(ActionEvent ev) {
		
		pBonosCostes.getChildren().clear();
		ConsultasHibernate ch = new ConsultasHibernate();
		Categoria categoria;
		
		if (cPaladinAlter.getSelectionModel().getSelectedItem().equals("PALADIN")) {
			categoria = ch.obtenerCategoria("PALADIN", sessionFactory);
		} else if (cPaladinAlter.getSelectionModel().getSelectedItem().equals("PALADIN(ESP)")) {
			categoria = ch.obtenerCategoria("PALADIN(ESP)", sessionFactory);
		} else if (cPaladinAlter.getSelectionModel().getSelectedItem().equals("PALADIN OSCURO")) {
			categoria = ch.obtenerCategoria("PALADIN OSCURO", sessionFactory);
		} else {
			categoria = ch.obtenerCategoria("PALADIN OSCURO(ESP)", sessionFactory);
		}
		
		
		txtArquetipo.setText(categoria.getArquetipo1());
		if (categoria.getArquetipo2()==null) {
			txtArquetipo.setText(categoria.getArquetipo1());
		} else {
			txtArquetipo.setText(categoria.getArquetipo1()+", "+categoria.getArquetipo2());
		}
		
		imgCategoria.setImage(new Image("file:"+categoria.getImagen()));
		tAreaDescripcionCategoria.setText(categoria.getDescripcion());
		txtMultiploVida.setText(String.valueOf(categoria.getMultiploVida()));
		txtPuntosVida.setText(String.valueOf(categoria.getPuntosVida()));
		txtTurno.setText(String.valueOf(categoria.getTurno()));
		txtConocimientoMarcial.setText(String.valueOf(categoria.getConocimientoMarcial()));
		txtCvInnatos.setText(String.valueOf(categoria.getCvInnato()));
		
		txtHa.setText(String.valueOf(categoria.getCosteHabilidadAtaque()));
		txtHp.setText(String.valueOf(categoria.getCosteHabilidadParada()));
		txtHe.setText(String.valueOf(categoria.getCosteHabilidadEsquiva()));
		txtLlevarArmadura.setText(String.valueOf(categoria.getCosteLlevarArmadura()));
		txtCosteConocimientoMarcial.setText("5");
		txtKi.setText(String.valueOf(categoria.getCostePuntoKi()));
		txtMultiploAcumulacion.setText(String.valueOf(categoria.getCosteAcumulacionKi()));
		
		txtZeon.setText(String.valueOf(categoria.getCosteZeon()));
		txtMultiploAct.setText(String.valueOf(categoria.getMultiploRegeneracion()));
		txtProyeccionMagica.setText(String.valueOf(categoria.getCosteProyeccionMagica()));
		txtConvocar.setText(String.valueOf(categoria.getCosteConvocar()));
		txtControlar.setText(String.valueOf(categoria.getCosteControlar())); 
		txtAtar.setText(String.valueOf(categoria.getCosteAtar())); 
		txtDesconvocar.setText(String.valueOf(categoria.getCosteDesconvocar()));
		
		txtCv.setText(String.valueOf(categoria.getCostePuntosCv()));
		txtProyeccionPsiquica.setText(String.valueOf(categoria.getCosteProyeccionPsiquica()));
		
		txtAtleticas.setText(String.valueOf(categoria.getCosteAtleticas()));
		txtSociales.setText(String.valueOf(categoria.getCosteSociales()));
		txtPerceptivas.setText(String.valueOf(categoria.getCostePerceptivas())); 
		txtIntelectuales.setText(String.valueOf(categoria.getCosteIntelectuales())); 
		txtVigor.setText(String.valueOf(categoria.getCosteVigor())); 
		txtSubterfugio.setText(String.valueOf(categoria.getCosteSubterfugio()));
		txtCreativas.setText(String.valueOf(categoria.getCosteCreativas()));
		
		lCategoria2.setText(categoria.getNombre());
		
		
		List<Integer> lBono = new ArrayList<Integer>();
		Integer [] sBonos = new Integer[]{categoria.getBonoAcrobacias(), categoria.getBonoAdvertir(), categoria.getBonoAnimales(), categoria.getBonoAtar(), categoria.getBonoAtletismo(),
				categoria.getBonoBuscar(), categoria.getBonoControlar(), categoria.getBonoConvocar(), categoria.getBonoDesconvocar(), categoria.getBonoDeteccionKi(), 
				categoria.getBonoDisfraz(), categoria.getBonoEstilo(), categoria.getBonoFrialdad(), categoria.getBonoHa(), categoria.getBonoHe(), categoria.getBonoHp(), categoria.getBonoHerbolaria(),
				categoria.getBonoIntimidar(), categoria.getBonoLiderazgo(), categoria.getBonoLlevarArmadura(), categoria.getBonoOcultacionKi(), categoria.getBonoOcultarse(), categoria.getBonoOcultismo(),
				categoria.getBonoPersuasion(), categoria.getBonoProezaFuerza(), categoria.getBonoRastrear(),categoria.getBonoResistirDolor(), categoria.getBonoRobo(), categoria.getBonoSaltar(), 
				categoria.getBonoSigilo(), categoria.getBonoTramperia(), categoria.getBonoTrucoManos(), categoria.getBonoValoracionMagica(), categoria.getBonoVeneno(), categoria.getBonoZeon(),

				categoria.getCosteReducidoAcrobacias(), categoria.getCosteReducidoAdvertir(), categoria.getCosteReducidoAnimales(), categoria.getCosteReducidoAtletismo(), categoria.getCosteReducidoBuscar(), 
				categoria.getCosteReducidoDisfraz(), categoria.getCosteReducidoEstilo(), categoria.getCosteReducidoFrialdad(), categoria.getCosteReducidoHerbolaria(),
				categoria.getCosteReducidoIntimidar(), categoria.getCosteReducidoLiderazgo(), categoria.getCosteReducidoOcultarse(), categoria.getCosteReducidoOcultismo(), categoria.getCosteReducidoMemorizar(),
				categoria.getCosteReducidoPersuasion(), categoria.getCosteReducidoProezaFuerza(), categoria.getCosteReducidoRastrear(),categoria.getCosteReducidoResistirDolor(), categoria.getCosteReducidoRobo(), 
				categoria.getCosteReducidoSaltar(), categoria.getCosteReducidoSigilo(), categoria.getCosteReducidoTramperia(), categoria.getCosteReducidoTrucoManos(), categoria.getCosteReducidoValoracionMagica(), 
				categoria.getCosteReducidoVenenos()};
		
		for (int i = 0; i < sBonos.length; i++) {
			lBono.add(sBonos[i]);
		}
		
		
		List<String> lBonoNombre = new ArrayList<String>();
		String [] sBonosNombres = new String[] {"BONO ACROBACIAS", "BONO ADVERTIR", "BONO ANIMALES", "BONO ATAR", "BONO ATLETISMO",
				"BONO BUSCAR", "BONO CONTROLAR", "BONO CONVOCAR", "BONO DESCONVOCAR", "BONO DETECCION DE KI", 
				"BONO DISFRAZ", "BONO ESTILO", "BONO FRIALDAD", "BONO HABILIDAD DE ATAQUE", "BONO HABILIDAD DE ESQUIVA", "BONO HABILIDAD DE PARADA", "BONO HERBOLARIA",
				"BONO INTIMIDAR", "BONO LIDERAZGO", "BONO LLEVAR ARMADURA", "BONO OCULTACION DE KI", "BONO OCULTARSE", "BONO OCULTISMO",
				"BONO PERSUASION", "BONO PROEZA DE FUERZA", "BONO RASTREAR", "BONO RESISTIR EL DOLOR", "BONO ROBO", "BONO SALTAR", 
				"BONO SIGILO", "BONO TRAMPERIA", "BONO TRUCO DE MANOS", "BONO VALORACION MAGICA", "BONO VENENO", "BONO ZEON",

				"COSTE REDUCIDO ACROBACIAS", "COSTE REDUCIDO ADVERTIR", "COSTE REDUCIDO ANIMALES", "COSTE REDUCIDO ATLETISMO", "COSTE REDUCIDO BUSCAR", 
				"COSTE REDUCIDO DISFRAZ", "COSTE REDUCIDO ESTILO", "COSTE REDUCIDO FRIALDAD", "COSTE REDUCIDO HERBOLARIA",
				"COSTE REDUCIDO INTIMIDAR", "COSTE REDUCIDO LIDERAZGO", "COSTE REDUCIDO OCULTARSE", "COSTE REDUCIDO OCULTISMO", "COSTE REDUCIDO MEMORIZAR",
				"COSTE REDUCIDO PERSUASION", "COSTE REDUCIDO PROEZA DE FUERZA", "COSTE REDUCIDO RASTREAR", "COSTE REDUCIDO RESISTIR EL DOLOR", "COSTE REDUCIDO ROBO", 
				"COSTE REDUCIDO SALTAR", "COSTE REDUCIDO SIGILO", "COSTE REDUCIDO TRAMPERIA", "COSTE REDUCIDO TRUCO DE MANOS", "COSTE REDUCIDO VALORACION MAGICA", 
				"COSTE REDUCIDO VENENO"};
		
		for (int i = 0; i < sBonosNombres.length; i++) {
			lBonoNombre.add(sBonosNombres[i]);
		}
		
		int nBonos = comprobarNumeroBonos(categoria, sBonos);
		lBonoNombre = eliminarNombreBonosNulos(lBonoNombre,lBono);
		lBono.removeAll(Collections.singleton(null));
		TextField tBonos[] = new TextField[nBonos];
		Label lNombresBonos[] = new Label[nBonos];
		int x = 0;
		int y = 0;
		
		for (int i = 0; i < nBonos; i++) {
			
			tBonos[i] = new TextField();
			tBonos[i].setPrefWidth(366);
			tBonos[i].setPrefHeight(31);
			tBonos[i].setLayoutX(x);
			tBonos[i].setLayoutY(y);
			tBonos[i].getStyleClass().add("textFieldBonos");
			tBonos[i].setAlignment(Pos.CENTER_RIGHT);
			tBonos[i].setEditable(false);
			tBonos[i].setText(String.valueOf(lBono.get(i)));
			
			
			lNombresBonos[i] = new Label();
			lNombresBonos[i].setPrefWidth(300);
			lNombresBonos[i].setPrefHeight(30);
			lNombresBonos[i].setLayoutX(x);
			lNombresBonos[i].setLayoutY(y);
			lNombresBonos[i].getStyleClass().add("labelRasgoCategoria");
			lNombresBonos[i].setText(lBonoNombre.get(i));
			
			pBonosCostes.getChildren().add(tBonos[i]);
			pBonosCostes.getChildren().add(lNombresBonos[i]);
			
			y= y+31;
		}
		
		pCategoriaSeleccionada.setVisible(true);
		pCategoria.setVisible(false);
		lCategoria1.setVisible(false);
		lCategoria2.setVisible(true);
		lRaza2.setVisible(false);
		imgBack2.setVisible(true);
		imgBack.setVisible(false);
	}
	
	public void selectCategoriaAceptar(ActionEvent ev) throws IOException {
		Stage stage = new Stage();
		PersonajeController personajeController = new PersonajeController(sessionFactory);
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
	
	public void homeEfecto(MouseEvent ev) {
		lHome.setStyle("-fx-background-color:#ff5145");
		
	}
	
	public void homeSinEfecto(MouseEvent ev) {
		lHome.setStyle(null);
		
	}
	
	public void backSelectRaza(MouseEvent ev) throws IOException {
		pRazas.setVisible(true);
		lRaza1.setVisible(true);
		lRaza2.setVisible(false);
		imgBack.setVisible(false);
	}
	
	public void backCategoria(MouseEvent ev) throws IOException {
		if (pCategoriaSeleccionada.isVisible()==true) {
			pCategoriaSeleccionada.setVisible(false);
			pCategoria.setVisible(true);
			lCategoria1.setVisible(true);
			lCategoria2.setVisible(false);
			lRaza2.setVisible(false);
		} else {
			pCategoria.setVisible(false);
			pRazaSeleccionada.setVisible(true);
			lCategoria1.setVisible(false);
			lRaza2.setVisible(true);
			imgBack.setVisible(true);
			imgBack2.setVisible(false);
		}
		
	}
	
	public void backEfecto(MouseEvent ev) {
		lBack.setStyle("-fx-background-color:#ff5145");
		
	}
	
	public void backSinEfecto(MouseEvent ev) {
		lBack.setStyle(null);
		
	}
	
}
