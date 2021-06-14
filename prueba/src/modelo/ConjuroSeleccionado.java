package modelo;

import javafx.scene.control.ComboBox;

public class ConjuroSeleccionado {
	private ComboBox<String> nombreConjuroLibreAcceso;
	private String nivel;
	
	public ConjuroSeleccionado(ComboBox<String> nombreConjuroLibreAcceso, String nivel) {
		this.nombreConjuroLibreAcceso = nombreConjuroLibreAcceso;
		this.nivel = nivel;
	}

	public ComboBox<String> getNombreConjuroLibreAcceso() {
		return nombreConjuroLibreAcceso;
	}

	public void setNombreConjuroLibreAcceso(ComboBox<String> nombreConjuroLibreAcceso) {
		this.nombreConjuroLibreAcceso = nombreConjuroLibreAcceso;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	
}
