package modelo;

import javafx.scene.control.ComboBox;

public class VentajaSeleccionada {
	
	private ComboBox<String> cBoxVentaja;
	private String coste;

	public VentajaSeleccionada(ComboBox<String> cBoxVentaja, String coste) {
		this.cBoxVentaja = cBoxVentaja;
		this.coste = coste;
	}

	public ComboBox<String> getcBoxVentaja() {
		return cBoxVentaja;
	}

	public void setcBoxVentaja(ComboBox<String> cBoxVentaja) {
		this.cBoxVentaja = cBoxVentaja;
	}

	public String getCoste() {
		return coste;
	}

	public void setCoste(String coste) {
		this.coste = coste;
	}
	
}
