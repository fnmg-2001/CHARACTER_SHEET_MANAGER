package modelo;

public class PdsHabilidadesSecundariasResumen {
	private String nombreHabilidad;
	private String penalizadorNaturalHabilidad;
	private String totalHabilidad;
	
	public PdsHabilidadesSecundariasResumen(String nombreHabilidad, String penalizadorNaturalHabilidad,
			String totalHabilidad) {
		this.nombreHabilidad = nombreHabilidad;
		this.penalizadorNaturalHabilidad = penalizadorNaturalHabilidad;
		this.totalHabilidad = totalHabilidad;
	}
	
	public String getNombreHabilidad() {
		return nombreHabilidad;
	}
	public void setNombreHabilidad(String nombreHabilidad) {
		this.nombreHabilidad = nombreHabilidad;
	}
	public String getPenalizadorNaturalHabilidad() {
		return penalizadorNaturalHabilidad;
	}
	public void setPenalizadorNaturalHabilidad(String penalizadorNaturalHabilidad) {
		this.penalizadorNaturalHabilidad = penalizadorNaturalHabilidad;
	}
	public String getTotalHabilidad() {
		return totalHabilidad;
	}
	public void setTotalHabilidad(String totalHabilidad) {
		this.totalHabilidad = totalHabilidad;
	}
	
	
}
