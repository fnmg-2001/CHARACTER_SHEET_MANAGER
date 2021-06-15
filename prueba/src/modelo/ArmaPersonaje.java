package modelo;
// Generated 15 jun. 2021 21:58:49 by Hibernate Tools 5.2.12.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ArmaPersonaje generated by hbm2java
 */
@Entity
@Table(name = "arma_personaje", catalog = "anima_sheets_data")
public class ArmaPersonaje implements java.io.Serializable {

	private ArmaPersonajeId id;
	private Arma arma;
	private Personaje personaje;
	private Tamano tamano;
	private int laManeja;

	public ArmaPersonaje() {
	}

	public ArmaPersonaje(ArmaPersonajeId id, Arma arma, Personaje personaje, Tamano tamano, int laManeja) {
		this.id = id;
		this.arma = arma;
		this.personaje = personaje;
		this.tamano = tamano;
		this.laManeja = laManeja;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "idArma", column = @Column(name = "ID_ARMA", nullable = false)),
			@AttributeOverride(name = "idPersonaje", column = @Column(name = "ID_PERSONAJE", nullable = false)),
			@AttributeOverride(name = "tamano", column = @Column(name = "TAMANO", nullable = false)) })
	public ArmaPersonajeId getId() {
		return this.id;
	}

	public void setId(ArmaPersonajeId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ARMA", nullable = false, insertable = false, updatable = false)
	public Arma getArma() {
		return this.arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PERSONAJE", nullable = false, insertable = false, updatable = false)
	public Personaje getPersonaje() {
		return this.personaje;
	}

	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TAMANO", nullable = false, insertable = false, updatable = false)
	public Tamano getTamano() {
		return this.tamano;
	}

	public void setTamano(Tamano tamano) {
		this.tamano = tamano;
	}

	@Column(name = "LA_MANEJA", nullable = false)
	public int getLaManeja() {
		return this.laManeja;
	}

	public void setLaManeja(int laManeja) {
		this.laManeja = laManeja;
	}

}
