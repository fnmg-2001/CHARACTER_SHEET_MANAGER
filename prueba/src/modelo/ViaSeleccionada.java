package modelo;

import javafx.scene.control.ComboBox;

public class ViaSeleccionada {
	private ComboBox<String> nombreViaSeleccionada;
	private String nivelUsado;
	private String nivelTotal;
	
	public ViaSeleccionada(ComboBox<String> nombreViaSeleccionada, String nivelUsado, String nivelTotal) {
		this.nombreViaSeleccionada = nombreViaSeleccionada;
		this.nivelUsado = nivelUsado;
		this.nivelTotal = nivelUsado;
	}

	public ComboBox<String> getNombreViaSeleccionada() {
		return nombreViaSeleccionada;
	}

	public void setNombreViaSeleccionada(ComboBox<String> nombreViaSeleccionada) {
		this.nombreViaSeleccionada = nombreViaSeleccionada;
	}

	public String getNivelUsado() {
		return nivelUsado;
	}

	public void setNivelUsado(String nivelUsado) {
		this.nivelUsado = nivelUsado;
		this.nivelTotal = nivelUsado;
	}

	public String getNivelTotal() {
		return nivelTotal;
	}

	public void setNivelTotal(String nivelTotal) {
		this.nivelTotal = nivelTotal;
	}
	
	
}
