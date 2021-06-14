package modelo;

import javafx.scene.control.ComboBox;

public class PoderPsiquicoSeleccionado {
	private ComboBox<String> nombrePoderSeleccionado;
	private String disciplinaPoderSeleccionado;
	private String nivelPoderSeleccionado;
	
	public PoderPsiquicoSeleccionado(ComboBox<String> nombrePoderSeleccionado, String disciplinaPoderSeleccionado,
			String nivelPoderSeleccionado) {
		this.nombrePoderSeleccionado = nombrePoderSeleccionado;
		this.disciplinaPoderSeleccionado = disciplinaPoderSeleccionado;
		this.nivelPoderSeleccionado = nivelPoderSeleccionado;
	}

	public ComboBox<String> getNombrePoderSeleccionado() {
		return nombrePoderSeleccionado;
	}

	public void setNombrePoderSeleccionado(ComboBox<String> nombrePoderSeleccionado) {
		this.nombrePoderSeleccionado = nombrePoderSeleccionado;
	}

	public String getDisciplinaPoderSeleccionado() {
		return disciplinaPoderSeleccionado;
	}

	public void setDisciplinaPoderSeleccionado(String disciplinaPoderSeleccionado) {
		this.disciplinaPoderSeleccionado = disciplinaPoderSeleccionado;
	}

	public String getNivelPoderSeleccionado() {
		return nivelPoderSeleccionado;
	}

	public void setNivelPoderSeleccionado(String nivelPoderSeleccionado) {
		this.nivelPoderSeleccionado = nivelPoderSeleccionado;
	}
	
}
