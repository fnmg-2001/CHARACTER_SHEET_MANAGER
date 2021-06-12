package modelo;
// Generated 12 jun. 2021 20:12:54 by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * TablaEstilo generated by hbm2java
 */
@Entity
@Table(name = "tabla_estilo", catalog = "anima_sheets_data")
public class TablaEstilo implements java.io.Serializable {

	private int idTablaEstilo;
	private String nombre;
	private String descripcion;
	private int coste;
	private Set<Personaje> personajes = new HashSet<Personaje>(0);

	public TablaEstilo() {
	}

	public TablaEstilo(int idTablaEstilo, String nombre, String descripcion, int coste) {
		this.idTablaEstilo = idTablaEstilo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.coste = coste;
	}

	public TablaEstilo(int idTablaEstilo, String nombre, String descripcion, int coste, Set<Personaje> personajes) {
		this.idTablaEstilo = idTablaEstilo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.coste = coste;
		this.personajes = personajes;
	}

	@Id

	@Column(name = "ID_TABLA_ESTILO", unique = true, nullable = false)
	public int getIdTablaEstilo() {
		return this.idTablaEstilo;
	}

	public void setIdTablaEstilo(int idTablaEstilo) {
		this.idTablaEstilo = idTablaEstilo;
	}

	@Column(name = "NOMBRE", nullable = false, length = 50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "DESCRIPCION", nullable = false, length = 250)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "COSTE", nullable = false)
	public int getCoste() {
		return this.coste;
	}

	public void setCoste(int coste) {
		this.coste = coste;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tabla_estilo_personaje", catalog = "anima_sheets_data", joinColumns = {
			@JoinColumn(name = "ID_TABLA_ESTILO", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "ID_PERSONAJE", nullable = false, updatable = false) })
	public Set<Personaje> getPersonajes() {
		return this.personajes;
	}

	public void setPersonajes(Set<Personaje> personajes) {
		this.personajes = personajes;
	}

}
