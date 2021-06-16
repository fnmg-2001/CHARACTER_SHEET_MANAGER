package modelo;
// Generated 16 jun. 2021 23:54:00 by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * TablaConjurosLibreAcceso generated by hbm2java
 */
@Entity
@Table(name = "tabla_conjuros_libre_acceso", catalog = "anima_sheets_data")
public class TablaConjurosLibreAcceso implements java.io.Serializable {

	private Integer idTablaConjurosLibreAcceso;
	private String nombre;
	private String nivel;
	private Set<Personaje> personajes = new HashSet<Personaje>(0);

	public TablaConjurosLibreAcceso() {
	}

	public TablaConjurosLibreAcceso(String nombre, String nivel) {
		this.nombre = nombre;
		this.nivel = nivel;
	}

	public TablaConjurosLibreAcceso(String nombre, String nivel, Set<Personaje> personajes) {
		this.nombre = nombre;
		this.nivel = nivel;
		this.personajes = personajes;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID_TABLA_CONJUROS_LIBRE_ACCESO", unique = true, nullable = false)
	public Integer getIdTablaConjurosLibreAcceso() {
		return this.idTablaConjurosLibreAcceso;
	}

	public void setIdTablaConjurosLibreAcceso(Integer idTablaConjurosLibreAcceso) {
		this.idTablaConjurosLibreAcceso = idTablaConjurosLibreAcceso;
	}

	@Column(name = "NOMBRE", nullable = false, length = 50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "NIVEL", nullable = false, length = 50)
	public String getNivel() {
		return this.nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tabla_conjuros_libre_acceso_personaje", catalog = "anima_sheets_data", joinColumns = {
			@JoinColumn(name = "ID_TABLA_CONJUROS_LIBRE_ACCESO", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "ID_PERSONAJE", nullable = false, updatable = false) })
	public Set<Personaje> getPersonajes() {
		return this.personajes;
	}

	public void setPersonajes(Set<Personaje> personajes) {
		this.personajes = personajes;
	}

}
