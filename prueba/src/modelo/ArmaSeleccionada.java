package modelo;

public class ArmaSeleccionada {
	private Arma armaSeleccionada;
	private String tipoArma;
	private String tama�o;
	private String calidad;
	
	private String critico1;
	private String critico2;
	private String entereza;
	private String rotura;
	private String turno;
	private String ataque;
	private String da�o;
	private String rasgo;
	
	public ArmaSeleccionada(Arma armaSeleccionada, String ataqueDesarrollado, String bonoFuerza, String turno) {
		this.armaSeleccionada = armaSeleccionada;
		this.tipoArma = armaSeleccionada.getTipo();
		this.critico1 = armaSeleccionada.getCritico1();
		this.critico2 = armaSeleccionada.getCritico2();
		this.entereza = String.valueOf(armaSeleccionada.getEntereza());
		this.rotura = String.valueOf(armaSeleccionada.getRotura());
		this.turno = String.valueOf(armaSeleccionada.getTurno()+Integer.parseInt(turno));
		this.ataque = ataqueDesarrollado;
		this.da�o = String.valueOf(armaSeleccionada.getDa�oBase() + Integer.parseInt(bonoFuerza));
		this.rasgo = armaSeleccionada.getRasgo();
	}

	public Arma getArmaSeleccionada() {
		return armaSeleccionada;
	}

	public void setArmaSeleccionada(Arma armaSeleccionada, String ataqueDesarrollado, String bonoFuerza, String turno) {
		this.armaSeleccionada = armaSeleccionada;
		this.tipoArma = armaSeleccionada.getTipo();
		this.critico1 = armaSeleccionada.getCritico1();
		this.critico2 = armaSeleccionada.getCritico2();
		this.entereza = String.valueOf(armaSeleccionada.getEntereza());
		this.rotura = String.valueOf(armaSeleccionada.getRotura());
		this.turno = String.valueOf(armaSeleccionada.getTurno()+Integer.parseInt(turno));
		this.ataque = ataqueDesarrollado;
		this.da�o = String.valueOf(armaSeleccionada.getDa�oBase()+Integer.parseInt(bonoFuerza));
		this.rasgo = armaSeleccionada.getRasgo();
	}

	public String getTipoArma() {
		return tipoArma;
	}

	public void setTipoArma(String tipoArma) {
		this.tipoArma = tipoArma;
	}

	public String getTama�o() {
		return tama�o;
	}

	public void setTama�o(String tama�o) {
		this.tama�o = tama�o;
	}

	public String getCalidad() {
		return calidad;
	}

	public void setCalidad(String calidad) {
		this.calidad = calidad;
	}

	public String getCritico1() {
		return critico1;
	}

	public void setCritico1(String critico1) {
		this.critico1 = critico1;
	}

	public String getCritico2() {
		return critico2;
	}

	public void setCritico2(String critico2) {
		this.critico2 = critico2;
	}

	public String getEntereza() {
		return entereza;
	}

	public void setEntereza(String entereza) {
		this.entereza = entereza;
	}

	public String getRotura() {
		return rotura;
	}

	public void setRotura(String rotura) {
		this.rotura = rotura;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.tipoArma = armaSeleccionada.getTipo();
		this.critico1 = armaSeleccionada.getCritico1();
		this.critico2 = armaSeleccionada.getCritico2();
		this.entereza = String.valueOf(armaSeleccionada.getEntereza());
		this.rotura = String.valueOf(armaSeleccionada.getRotura());
		this.turno = String.valueOf(this.armaSeleccionada.getTurno()+Integer.parseInt(turno));
	}

	public String getAtaque() {
		return ataque;
	}

	public void setAtaque(String ataque) {
		this.tipoArma = armaSeleccionada.getTipo();
		this.critico1 = armaSeleccionada.getCritico1();
		this.critico2 = armaSeleccionada.getCritico2();
		this.entereza = String.valueOf(armaSeleccionada.getEntereza());
		this.rotura = String.valueOf(armaSeleccionada.getRotura());
		this.ataque = ataque;
	}

	public String getDa�o() {
		return da�o;
	}

	public void setDa�o(String da�o) {
		this.da�o = da�o;
	}
	public void setBonoFuerza(String bonoFuerza) {
		this.tipoArma = armaSeleccionada.getTipo();
		this.critico1 = armaSeleccionada.getCritico1();
		this.critico2 = armaSeleccionada.getCritico2();
		this.entereza = String.valueOf(armaSeleccionada.getEntereza());
		this.rotura = String.valueOf(armaSeleccionada.getRotura());
		this.da�o = String.valueOf(armaSeleccionada.getDa�oBase() + Integer.parseInt(bonoFuerza));
	}

	public String getRasgo() {
		return rasgo;
	}

	public void setRasgo(String rasgo) {
		this.rasgo = rasgo;
	}
	
	
}
