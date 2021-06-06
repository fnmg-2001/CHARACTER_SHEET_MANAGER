package modelo;

public class ResistenciasTabla {
	private String nombreResistencia;
	private String presenciaBase;
	private String bonoCaracteristica;
	private String bonoEspecial;
	private String bonoRaza;
	private String resistenciaTotal;
	
	public ResistenciasTabla(String nombreResistencia, String presenciaBase, String bonoCaracteristica,  String bonoRaza, String bonoEspecial) {
		
		this.nombreResistencia = nombreResistencia;
		this.presenciaBase = presenciaBase;
		this.bonoCaracteristica = bonoCaracteristica;
		this.bonoEspecial = bonoEspecial;
		this.bonoRaza = bonoRaza;
		this.resistenciaTotal = String.valueOf(Integer.parseInt(presenciaBase)+Integer.parseInt(bonoCaracteristica)+Integer.parseInt(bonoEspecial)+Integer.parseInt(bonoRaza));
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
		this.resistenciaTotal = String.valueOf(Integer.parseInt(presenciaBase)+Integer.parseInt(bonoCaracteristica)+Integer.parseInt(bonoEspecial)+Integer.parseInt(bonoRaza));
	}

	public String getBonoCaracteristica() {
		return bonoCaracteristica;
	}

	public void setBonoCaracteristica(String bonoCaracteristica) {
		this.bonoCaracteristica = bonoCaracteristica;
		this.resistenciaTotal = String.valueOf(Integer.parseInt(presenciaBase)+Integer.parseInt(bonoCaracteristica)+Integer.parseInt(bonoEspecial)+Integer.parseInt(bonoRaza));
	}

	public String getBonoEspecial() {
		return bonoEspecial;
	}

	public void setBonoEspecial(String bonoEspecial) {
		this.bonoEspecial = bonoEspecial;
		this.resistenciaTotal = String.valueOf(Integer.parseInt(presenciaBase)+Integer.parseInt(bonoCaracteristica)+Integer.parseInt(bonoEspecial)+Integer.parseInt(bonoRaza));
	}

	public String getBonoRaza() {
		return bonoRaza;
	}

	public void setBonoRaza(String bonoRaza) {
		this.bonoRaza = bonoRaza;
		this.resistenciaTotal = String.valueOf(Integer.parseInt(presenciaBase)+Integer.parseInt(bonoCaracteristica)+Integer.parseInt(bonoEspecial)+Integer.parseInt(bonoRaza));
	}

	public String getResistenciaTotal() {
		return resistenciaTotal;
	}

	public void setResistenciaTotal(String resistenciaTotal) {
		this.resistenciaTotal = resistenciaTotal;
	}
	
	
}
