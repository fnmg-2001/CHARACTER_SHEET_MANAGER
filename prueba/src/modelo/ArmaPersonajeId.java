package modelo;
// Generated 15 jun. 2021 0:01:59 by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ArmaPersonajeId generated by hbm2java
 */
@Embeddable
public class ArmaPersonajeId implements java.io.Serializable {

	private int idArma;
	private int idPersonaje;
	private int tamano;

	public ArmaPersonajeId() {
	}

	public ArmaPersonajeId(int idArma, int idPersonaje, int tamano) {
		this.idArma = idArma;
		this.idPersonaje = idPersonaje;
		this.tamano = tamano;
	}

	@Column(name = "ID_ARMA", nullable = false)
	public int getIdArma() {
		return this.idArma;
	}

	public void setIdArma(int idArma) {
		this.idArma = idArma;
	}

	@Column(name = "ID_PERSONAJE", nullable = false)
	public int getIdPersonaje() {
		return this.idPersonaje;
	}

	public void setIdPersonaje(int idPersonaje) {
		this.idPersonaje = idPersonaje;
	}

	@Column(name = "TAMANO", nullable = false)
	public int getTamano() {
		return this.tamano;
	}

	public void setTamano(int tamano) {
		this.tamano = tamano;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ArmaPersonajeId))
			return false;
		ArmaPersonajeId castOther = (ArmaPersonajeId) other;

		return (this.getIdArma() == castOther.getIdArma()) && (this.getIdPersonaje() == castOther.getIdPersonaje())
				&& (this.getTamano() == castOther.getTamano());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdArma();
		result = 37 * result + this.getIdPersonaje();
		result = 37 * result + this.getTamano();
		return result;
	}

}
