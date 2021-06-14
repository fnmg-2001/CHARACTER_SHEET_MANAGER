package modelo;
// Generated 15 jun. 2021 0:01:59 by Hibernate Tools 5.2.12.Final

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
 * Arma generated by hbm2java
 */
@Entity
@Table(name = "arma", catalog = "anima_sheets_data")
public class Arma implements java.io.Serializable {

	private Integer idArma;
	private String nombre;
	private int fuerzaRequeridaMinima;
	private int fuerzaRequeridaMaxima;
	private String tipo;
	private int turno;
	private int da�oBase;
	private String critico1;
	private String critico2;
	private int AUnaODosManos;
	private int ADosManos;
	private int rotura;
	private int entereza;
	private int presencia;
	private String rasgo;
	private Set<ArmaPersonaje> armaPersonajes = new HashSet<ArmaPersonaje>(0);

	public Arma() {
	}

	public Arma(String nombre, int fuerzaRequeridaMinima, int fuerzaRequeridaMaxima, String tipo, int turno,
			int da�oBase, int AUnaODosManos, int ADosManos, int rotura, int entereza, int presencia) {
		this.nombre = nombre;
		this.fuerzaRequeridaMinima = fuerzaRequeridaMinima;
		this.fuerzaRequeridaMaxima = fuerzaRequeridaMaxima;
		this.tipo = tipo;
		this.turno = turno;
		this.da�oBase = da�oBase;
		this.AUnaODosManos = AUnaODosManos;
		this.ADosManos = ADosManos;
		this.rotura = rotura;
		this.entereza = entereza;
		this.presencia = presencia;
	}

	public Arma(String nombre, int fuerzaRequeridaMinima, int fuerzaRequeridaMaxima, String tipo, int turno,
			int da�oBase, String critico1, String critico2, int AUnaODosManos, int ADosManos, int rotura, int entereza,
			int presencia, String rasgo, Set<ArmaPersonaje> armaPersonajes) {
		this.nombre = nombre;
		this.fuerzaRequeridaMinima = fuerzaRequeridaMinima;
		this.fuerzaRequeridaMaxima = fuerzaRequeridaMaxima;
		this.tipo = tipo;
		this.turno = turno;
		this.da�oBase = da�oBase;
		this.critico1 = critico1;
		this.critico2 = critico2;
		this.AUnaODosManos = AUnaODosManos;
		this.ADosManos = ADosManos;
		this.rotura = rotura;
		this.entereza = entereza;
		this.presencia = presencia;
		this.rasgo = rasgo;
		this.armaPersonajes = armaPersonajes;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID_ARMA", unique = true, nullable = false)
	public Integer getIdArma() {
		return this.idArma;
	}

	public void setIdArma(Integer idArma) {
		this.idArma = idArma;
	}

	@Column(name = "NOMBRE", nullable = false, length = 100)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "FUERZA_REQUERIDA_MINIMA", nullable = false)
	public int getFuerzaRequeridaMinima() {
		return this.fuerzaRequeridaMinima;
	}

	public void setFuerzaRequeridaMinima(int fuerzaRequeridaMinima) {
		this.fuerzaRequeridaMinima = fuerzaRequeridaMinima;
	}

	@Column(name = "FUERZA_REQUERIDA_MAXIMA", nullable = false)
	public int getFuerzaRequeridaMaxima() {
		return this.fuerzaRequeridaMaxima;
	}

	public void setFuerzaRequeridaMaxima(int fuerzaRequeridaMaxima) {
		this.fuerzaRequeridaMaxima = fuerzaRequeridaMaxima;
	}

	@Column(name = "TIPO", nullable = false, length = 50)
	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Column(name = "TURNO", nullable = false)
	public int getTurno() {
		return this.turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	@Column(name = "DA�O_BASE", nullable = false)
	public int getDa�oBase() {
		return this.da�oBase;
	}

	public void setDa�oBase(int da�oBase) {
		this.da�oBase = da�oBase;
	}

	@Column(name = "CRITICO1", length = 3)
	public String getCritico1() {
		return this.critico1;
	}

	public void setCritico1(String critico1) {
		this.critico1 = critico1;
	}

	@Column(name = "CRITICO2", length = 3)
	public String getCritico2() {
		return this.critico2;
	}

	public void setCritico2(String critico2) {
		this.critico2 = critico2;
	}

	@Column(name = "A_UNA_O_DOS_MANOS", nullable = false)
	public int getAUnaODosManos() {
		return this.AUnaODosManos;
	}

	public void setAUnaODosManos(int AUnaODosManos) {
		this.AUnaODosManos = AUnaODosManos;
	}

	@Column(name = "A_DOS_MANOS", nullable = false)
	public int getADosManos() {
		return this.ADosManos;
	}

	public void setADosManos(int ADosManos) {
		this.ADosManos = ADosManos;
	}

	@Column(name = "ROTURA", nullable = false)
	public int getRotura() {
		return this.rotura;
	}

	public void setRotura(int rotura) {
		this.rotura = rotura;
	}

	@Column(name = "ENTEREZA", nullable = false)
	public int getEntereza() {
		return this.entereza;
	}

	public void setEntereza(int entereza) {
		this.entereza = entereza;
	}

	@Column(name = "PRESENCIA", nullable = false)
	public int getPresencia() {
		return this.presencia;
	}

	public void setPresencia(int presencia) {
		this.presencia = presencia;
	}

	@Column(name = "RASGO", length = 100)
	public String getRasgo() {
		return this.rasgo;
	}

	public void setRasgo(String rasgo) {
		this.rasgo = rasgo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "arma")
	public Set<ArmaPersonaje> getArmaPersonajes() {
		return this.armaPersonajes;
	}

	public void setArmaPersonajes(Set<ArmaPersonaje> armaPersonajes) {
		this.armaPersonajes = armaPersonajes;
	}

}
