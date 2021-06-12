package modelo;

import javafx.scene.control.ComboBox;

public class ArmaduraSeleccionada {
	private ComboBox<String> nombreArmadura;
	private String filo;
	private String contundente;
	private String penetrante;
	private String calor;
	private String electrico;
	private String frio;
	private String energia;
	private String entereza;
	private String requisito;
	private String penalizadorNatural;
	
	public ArmaduraSeleccionada(ComboBox<String> nombreArmadura, String filo, String contundente, String penetrante,
			String calor, String electrico, String frio, String energia, String entereza, String requisito,
			String penalizadorNatural) {
		this.nombreArmadura = nombreArmadura;
		this.filo = filo;
		this.contundente = contundente;
		this.penetrante = penetrante;
		this.calor = calor;
		this.electrico = electrico;
		this.frio = frio;
		this.energia = energia;
		this.entereza = entereza;
		this.requisito = requisito;
		this.penalizadorNatural = penalizadorNatural;
	}
	
	public ComboBox<String> getNombreArmadura() {
		return nombreArmadura;
	}



	public void setNombreArmadura(ComboBox<String> nombreArmadura) {
		this.nombreArmadura = nombreArmadura;
	}

	public String getFilo() {
		return filo;
	}

	public void setFilo(String filo) {
		this.filo = filo;
	}

	public String getContundente() {
		return contundente;
	}

	public void setContundente(String contundente) {
		this.contundente = contundente;
	}

	public String getPenetrante() {
		return penetrante;
	}

	public void setPenetrante(String penetrante) {
		this.penetrante = penetrante;
	}

	public String getCalor() {
		return calor;
	}

	public void setCalor(String calor) {
		this.calor = calor;
	}

	public String getElectrico() {
		return electrico;
	}

	public void setElectrico(String electrico) {
		this.electrico = electrico;
	}

	public String getFrio() {
		return frio;
	}

	public void setFrio(String frio) {
		this.frio = frio;
	}

	public String getEnergia() {
		return energia;
	}

	public void setEnergia(String energia) {
		this.energia = energia;
	}

	public String getEntereza() {
		return entereza;
	}

	public void setEntereza(String entereza) {
		this.entereza = entereza;
	}

	public String getRequisito() {
		return requisito;
	}

	public void setRequisito(String requisito) {
		this.requisito = requisito;
	}

	public String getPenalizadorNatural() {
		return penalizadorNatural;
	}

	public void setPenalizadorNatural(String penalizadorNatural) {
		this.penalizadorNatural = penalizadorNatural;
	}
	
}
