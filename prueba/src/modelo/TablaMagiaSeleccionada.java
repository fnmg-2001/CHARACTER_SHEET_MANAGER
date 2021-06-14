package modelo;

import javafx.scene.control.ComboBox;

public class TablaMagiaSeleccionada {
	private ComboBox<String> nombreTablaSeleccionada;
	private String coste;
	private String pds;
	
	public TablaMagiaSeleccionada(ComboBox<String> nombreTablaSeleccionada, String coste, String pds) {
		this.nombreTablaSeleccionada = nombreTablaSeleccionada;
		this.coste = coste;
		this.pds = pds;
	}

	public ComboBox<String> getNombreTablaSeleccionada() {
		return nombreTablaSeleccionada;
	}

	public void setNombreTablaSeleccionada(ComboBox<String> nombreTablaSeleccionada) {
		this.nombreTablaSeleccionada = nombreTablaSeleccionada;
	}

	public String getCoste() {
		return coste;
	}

	public void setCoste(String coste) {
		this.coste = coste;
		this.pds = coste;
	}

	public String getPds() {
		return pds;
	}

	public void setPds(String pds) {
		this.pds = pds;
	}
	
	
	
}
