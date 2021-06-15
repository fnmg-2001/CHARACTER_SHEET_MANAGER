package modelo;
// Generated 15 jun. 2021 21:58:49 by Hibernate Tools 5.2.12.Final

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
 * TablaPsiquico generated by hbm2java
 */
@Entity
@Table(name = "tabla_psiquico", catalog = "anima_sheets_data")
public class TablaPsiquico implements java.io.Serializable {

	private Integer idTablaPsiquico;
	private String nombre;
	private String descripcion;
	private int coste;
	private Set<Personaje> personajes = new HashSet<Personaje>(0);

	public TablaPsiquico() {
	}

	public TablaPsiquico(String nombre, String descripcion, int coste) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.coste = coste;
	}

	public TablaPsiquico(String nombre, String descripcion, int coste, Set<Personaje> personajes) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.coste = coste;
		this.personajes = personajes;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID_TABLA_PSIQUICO", unique = true, nullable = false)
	public Integer getIdTablaPsiquico() {
		return this.idTablaPsiquico;
	}

	public void setIdTablaPsiquico(Integer idTablaPsiquico) {
		this.idTablaPsiquico = idTablaPsiquico;
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
	@JoinTable(name = "tabla_psiquico_personaje", catalog = "anima_sheets_data", joinColumns = {
			@JoinColumn(name = "ID_TABLA_PSIQUICO", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "ID_PERSONAJE", nullable = false, updatable = false) })
	public Set<Personaje> getPersonajes() {
		return this.personajes;
	}

	public void setPersonajes(Set<Personaje> personajes) {
		this.personajes = personajes;
	}

}
