package modelo;
// Generated 16 jun. 2021 23:54:00 by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TablaTablaViasMagiaPersonajeId generated by hbm2java
 */
@Embeddable
public class TablaTablaViasMagiaPersonajeId implements java.io.Serializable {

	private int idVia;
	private int idPersonaje;

	public TablaTablaViasMagiaPersonajeId() {
	}

	public TablaTablaViasMagiaPersonajeId(int idVia, int idPersonaje) {
		this.idVia = idVia;
		this.idPersonaje = idPersonaje;
	}

	@Column(name = "ID_VIA", nullable = false)
	public int getIdVia() {
		return this.idVia;
	}

	public void setIdVia(int idVia) {
		this.idVia = idVia;
	}

	@Column(name = "ID_PERSONAJE", nullable = false)
	public int getIdPersonaje() {
		return this.idPersonaje;
	}

	public void setIdPersonaje(int idPersonaje) {
		this.idPersonaje = idPersonaje;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TablaTablaViasMagiaPersonajeId))
			return false;
		TablaTablaViasMagiaPersonajeId castOther = (TablaTablaViasMagiaPersonajeId) other;

		return (this.getIdVia() == castOther.getIdVia()) && (this.getIdPersonaje() == castOther.getIdPersonaje());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdVia();
		result = 37 * result + this.getIdPersonaje();
		return result;
	}

}
