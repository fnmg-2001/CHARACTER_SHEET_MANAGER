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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TablaViasMagia generated by hbm2java
 */
@Entity
@Table(name = "tabla_vias_magia", catalog = "anima_sheets_data")
public class TablaViasMagia implements java.io.Serializable {

	private Integer idVia;
	private String nombre;
	private Set<TablaTablaViasMagiaPersonaje> tablaTablaViasMagiaPersonajes = new HashSet<TablaTablaViasMagiaPersonaje>(
			0);

	public TablaViasMagia() {
	}

	public TablaViasMagia(String nombre) {
		this.nombre = nombre;
	}

	public TablaViasMagia(String nombre, Set<TablaTablaViasMagiaPersonaje> tablaTablaViasMagiaPersonajes) {
		this.nombre = nombre;
		this.tablaTablaViasMagiaPersonajes = tablaTablaViasMagiaPersonajes;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID_VIA", unique = true, nullable = false)
	public Integer getIdVia() {
		return this.idVia;
	}

	public void setIdVia(Integer idVia) {
		this.idVia = idVia;
	}

	@Column(name = "NOMBRE", nullable = false, length = 50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tablaViasMagia")
	public Set<TablaTablaViasMagiaPersonaje> getTablaTablaViasMagiaPersonajes() {
		return this.tablaTablaViasMagiaPersonajes;
	}

	public void setTablaTablaViasMagiaPersonajes(Set<TablaTablaViasMagiaPersonaje> tablaTablaViasMagiaPersonajes) {
		this.tablaTablaViasMagiaPersonajes = tablaTablaViasMagiaPersonajes;
	}

}
