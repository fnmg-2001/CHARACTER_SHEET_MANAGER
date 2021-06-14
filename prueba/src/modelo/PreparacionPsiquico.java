package modelo;

public class PreparacionPsiquico {
	private String preparacion;
	private String bonoPotencial;
	
	public PreparacionPsiquico(String preparacion, String bonoPotencial) {
		this.preparacion = preparacion;
		this.bonoPotencial = bonoPotencial;
	}

	public String getPreparacion() {
		return preparacion;
	}

	public void setPreparacion(String preparacion) {
		this.preparacion = preparacion;
	}

	public String getBonoPotencial() {
		return bonoPotencial;
	}

	public void setBonoPotencial(String bonoPotencial) {
		this.bonoPotencial = bonoPotencial;
	}
	
	
}
