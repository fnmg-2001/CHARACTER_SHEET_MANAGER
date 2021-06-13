package modelo;

import javafx.scene.control.ComboBox;

public class ArteMarcialSeleccionado {
	private ComboBox<String> nombreArteMarcial;
	private String coste;
	private String pds;
	private String bonoHa;
	private String bonoHe;
	private String bonoHp;
	private String bonoTurno;
	
	public ArteMarcialSeleccionado(ComboBox<String> nombreArteMarcial, String coste, String pds, String bonoHa,
			String bonoHe, String bonoHp, String bonoTurno) {
		this.nombreArteMarcial = nombreArteMarcial;
		this.coste = coste;
		this.pds = pds;
		this.bonoHa = bonoHa;
		this.bonoHe = bonoHe;
		this.bonoHp = bonoHp;
		this.bonoTurno = bonoTurno;
	}

	public ComboBox<String> getNombreArteMarcial() {
		return nombreArteMarcial;
	}

	public void setNombreArteMarcial(ComboBox<String> nombreArteMarcial) {
		this.nombreArteMarcial = nombreArteMarcial;
	}

	public String getCoste() {
		return coste;
	}

	public void setCoste(String coste) {
		this.coste = coste;
	}

	public String getPds() {
		return pds;
	}

	public void setPds(String pds) {
		this.pds = pds;
	}

	public String getBonoHa() {
		return bonoHa;
	}

	public void setBonoHa(String bonoHa) {
		this.bonoHa = bonoHa;
	}

	public String getBonoHe() {
		return bonoHe;
	}

	public void setBonoHe(String bonoHe) {
		this.bonoHe = bonoHe;
	}

	public String getBonoHp() {
		return bonoHp;
	}

	public void setBonoHp(String bonoHp) {
		this.bonoHp = bonoHp;
	}

	public String getBonoTurno() {
		return bonoTurno;
	}

	public void setBonoTurno(String bonoTurno) {
		this.bonoTurno = bonoTurno;
	}
	
}
