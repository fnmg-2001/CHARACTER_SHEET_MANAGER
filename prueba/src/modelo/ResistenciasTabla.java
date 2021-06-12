package modelo;

public class ResistenciasTabla {
	private String nombreResistencia;
	private String presenciaBase;
	private String bonoCaracteristica;
	private String bonoEspecial;
	private String bonoRaza;
	private String resistenciaTotal;
	private String nivel;
	
	public ResistenciasTabla(String nombreResistencia, String bonoCaracteristica, String bonoRaza, String bonoEspecial, String nivel) {
		
		this.nombreResistencia = nombreResistencia;
		this.presenciaBase = "30";
		for (int i = 1; i < Integer.parseInt(nivel); i++) {
			this.presenciaBase = String.valueOf(Integer.parseInt(this.presenciaBase)+Integer.parseInt("5"));
		}
		this.bonoCaracteristica = bonoCaracteristica;
		this.bonoEspecial = bonoEspecial;
		this.bonoRaza = bonoRaza;
		this.nivel = nivel;
		this.resistenciaTotal = String.valueOf(Integer.parseInt(presenciaBase)+Integer.parseInt(bonoCaracteristica)+Integer.parseInt(bonoEspecial)+Integer.parseInt(this.bonoRaza));
	}

	public String getNombreResistencia() {
		return nombreResistencia;
	}

	public void setNombreResistencia(String nombreResistencia) {
		this.nombreResistencia = nombreResistencia;
	}
	
	public String getPresenciaBase() {
		return presenciaBase;
	}

	public void setPresenciaBase(String presenciaBase) {
		this.presenciaBase = presenciaBase;
		this.resistenciaTotal = String.valueOf(Integer.parseInt(presenciaBase)+Integer.parseInt(bonoCaracteristica)+Integer.parseInt(bonoEspecial)+Integer.parseInt(this.bonoRaza));
	}

	public String getBonoCaracteristica() {
		return bonoCaracteristica;
	}

	public void setBonoCaracteristica(String bonoCaracteristica) {
		this.bonoCaracteristica = bonoCaracteristica;
		this.resistenciaTotal = String.valueOf(Integer.parseInt(presenciaBase)+Integer.parseInt(bonoCaracteristica)+Integer.parseInt(bonoEspecial)+Integer.parseInt(this.bonoRaza));
	}

	public String getBonoEspecial() {
		return bonoEspecial;
	}

	public void setBonoEspecial(String bonoEspecial) {
		this.bonoEspecial = bonoEspecial;
		this.resistenciaTotal = String.valueOf(Integer.parseInt(presenciaBase)+Integer.parseInt(bonoCaracteristica)+Integer.parseInt(bonoEspecial)+Integer.parseInt(this.bonoRaza));
	}

	public String getBonoRaza() {
		return bonoRaza;
	}

	public void setBonoRaza(String bonoRaza) {
		this.bonoRaza = bonoRaza;
		this.resistenciaTotal = String.valueOf(Integer.parseInt(presenciaBase)+Integer.parseInt(bonoCaracteristica)+Integer.parseInt(bonoEspecial)+Integer.parseInt(this.bonoRaza));
	}

	public String getResistenciaTotal() {
		return resistenciaTotal;
	}

	public void setResistenciaTotal(String resistenciaTotal) {
		this.resistenciaTotal = resistenciaTotal;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
		this.presenciaBase = "30";
		for (int i = 1; i < Integer.parseInt(nivel); i++) {
			this.presenciaBase = String.valueOf(Integer.parseInt(this.presenciaBase)+Integer.parseInt("5"));
		}
		this.resistenciaTotal = String.valueOf(Integer.parseInt(this.presenciaBase)+Integer.parseInt(this.bonoCaracteristica)+Integer.parseInt(this.bonoEspecial)+Integer.parseInt(this.bonoRaza));
	}
	
	
}
