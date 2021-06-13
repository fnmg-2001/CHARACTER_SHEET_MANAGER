package modelo;

import javafx.scene.control.ComboBox;

public class TablaEstiloSeleccionada {
	private ComboBox<String> nombreTabla;
	private String coste;
	private String pds;
	
	public TablaEstiloSeleccionada(ComboBox<String> nombreTabla, String coste, String pds) {
		this.nombreTabla = nombreTabla;
		this.coste = coste;
		this.pds = pds;
	}
	
	public ComboBox<String> getNombreTabla() {
		return nombreTabla;
	}
	public void setNombreTabla(ComboBox<String> nombreTabla) {
		this.nombreTabla = nombreTabla;
	}
	public String getCoste() {
		return coste;
	}
	public void setCoste(String coste) {
		this.coste = coste;
	}
	public String getPds() {
		return pds;
	}
	public void setPds(String pds) {
		this.pds = pds;
	}
	
	
	
}
