package modelo;
// Generated 16 jun. 2021 23:54:00 by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * PdsSecundariasCreativas generated by hbm2java
 */
@Entity
@Table(name = "pds_secundarias_creativas", catalog = "anima_sheets_data")
public class PdsSecundariasCreativas implements java.io.Serializable {

	private int idPersonaje;
	private Personaje personaje;
	private Integer pdsArte;
	private Integer pdsBaile;
	private Integer pdsForja;
	private Integer pdsRunas;
	private Integer pdsAlquimia;
	private Integer pdsAnimismo;
	private Integer pdsMusica;
	private Integer pdsTrucoManos;
	private Integer pdsCaligrafiaRitual;
	private Integer pdsOrfebreria;
	private Integer pdsConfeccion;
	private Integer pdsConfeccionMarionetas;
	private Integer pdsEspArte;
	private Integer pdsEspBaile;
	private Integer pdsEspForja;
	private Integer pdsEspRunas;
	private Integer pdsEspAlquimia;
	private Integer pdsEspAnimismo;
	private Integer pdsEspMusica;
	private Integer pdsEspTrucoManos;
	private Integer pdsEspCaligrafiaRitual;
	private Integer pdsEspOrfebreria;
	private Integer pdsEspConfeccion;
	private Integer pdsEspConfeccionMarionetas;
	private Integer bonoNaturalArte;
	private Integer bonoNaturalBaile;
	private Integer bonoNaturalForja;
	private Integer bonoNaturalRunas;
	private Integer bonoNaturalAlquimia;
	private Integer bonoNaturalAnimismo;
	private Integer bonoNaturalMusica;
	private Integer bonoNaturalTrucoManos;
	private Integer bonoNaturalCaligrafiaRitual;
	private Integer bonoNaturalOrfebreria;
	private Integer bonoNaturalConfeccion;
	private Integer bonoNaturalConfeccionMarionetas;
	private Integer habNaturalArte;
	private Integer habNaturalBaile;
	private Integer habNaturalForja;
	private Integer habNaturalRunas;
	private Integer habNaturalAlquimia;
	private Integer habNaturalAnimismo;
	private Integer habNaturalMusica;
	private Integer habNaturalTrucoManos;
	private Integer habNaturalCaligrafiaRitual;
	private Integer habNaturalOrfebreria;
	private Integer habNaturalConfeccion;
	private Integer habNaturalConfeccionMarionetas;
	private Integer bonoNovelArte;
	private Integer bonoNovelBaile;
	private Integer bonoNovelForja;
	private Integer bonoNovelRunas;
	private Integer bonoNovelAlquimia;
	private Integer bonoNovelAnimismo;
	private Integer bonoNovelMusica;
	private Integer bonoNovelTrucoManos;
	private Integer bonoNovelCaligrafiaRitual;
	private Integer bonoNovelOrfebreria;
	private Integer bonoNovelConfeccion;
	private Integer bonoNovelConfeccionMarionetas;

	public PdsSecundariasCreativas() {
	}

	public PdsSecundariasCreativas(Personaje personaje) {
		this.personaje = personaje;
	}

	public PdsSecundariasCreativas(Personaje personaje, Integer pdsArte, Integer pdsBaile, Integer pdsForja,
			Integer pdsRunas, Integer pdsAlquimia, Integer pdsAnimismo, Integer pdsMusica, Integer pdsTrucoManos,
			Integer pdsCaligrafiaRitual, Integer pdsOrfebreria, Integer pdsConfeccion, Integer pdsConfeccionMarionetas,
			Integer pdsEspArte, Integer pdsEspBaile, Integer pdsEspForja, Integer pdsEspRunas, Integer pdsEspAlquimia,
			Integer pdsEspAnimismo, Integer pdsEspMusica, Integer pdsEspTrucoManos, Integer pdsEspCaligrafiaRitual,
			Integer pdsEspOrfebreria, Integer pdsEspConfeccion, Integer pdsEspConfeccionMarionetas,
			Integer bonoNaturalArte, Integer bonoNaturalBaile, Integer bonoNaturalForja, Integer bonoNaturalRunas,
			Integer bonoNaturalAlquimia, Integer bonoNaturalAnimismo, Integer bonoNaturalMusica,
			Integer bonoNaturalTrucoManos, Integer bonoNaturalCaligrafiaRitual, Integer bonoNaturalOrfebreria,
			Integer bonoNaturalConfeccion, Integer bonoNaturalConfeccionMarionetas, Integer habNaturalArte,
			Integer habNaturalBaile, Integer habNaturalForja, Integer habNaturalRunas, Integer habNaturalAlquimia,
			Integer habNaturalAnimismo, Integer habNaturalMusica, Integer habNaturalTrucoManos,
			Integer habNaturalCaligrafiaRitual, Integer habNaturalOrfebreria, Integer habNaturalConfeccion,
			Integer habNaturalConfeccionMarionetas, Integer bonoNovelArte, Integer bonoNovelBaile,
			Integer bonoNovelForja, Integer bonoNovelRunas, Integer bonoNovelAlquimia, Integer bonoNovelAnimismo,
			Integer bonoNovelMusica, Integer bonoNovelTrucoManos, Integer bonoNovelCaligrafiaRitual,
			Integer bonoNovelOrfebreria, Integer bonoNovelConfeccion, Integer bonoNovelConfeccionMarionetas) {
		this.personaje = personaje;
		this.pdsArte = pdsArte;
		this.pdsBaile = pdsBaile;
		this.pdsForja = pdsForja;
		this.pdsRunas = pdsRunas;
		this.pdsAlquimia = pdsAlquimia;
		this.pdsAnimismo = pdsAnimismo;
		this.pdsMusica = pdsMusica;
		this.pdsTrucoManos = pdsTrucoManos;
		this.pdsCaligrafiaRitual = pdsCaligrafiaRitual;
		this.pdsOrfebreria = pdsOrfebreria;
		this.pdsConfeccion = pdsConfeccion;
		this.pdsConfeccionMarionetas = pdsConfeccionMarionetas;
		this.pdsEspArte = pdsEspArte;
		this.pdsEspBaile = pdsEspBaile;
		this.pdsEspForja = pdsEspForja;
		this.pdsEspRunas = pdsEspRunas;
		this.pdsEspAlquimia = pdsEspAlquimia;
		this.pdsEspAnimismo = pdsEspAnimismo;
		this.pdsEspMusica = pdsEspMusica;
		this.pdsEspTrucoManos = pdsEspTrucoManos;
		this.pdsEspCaligrafiaRitual = pdsEspCaligrafiaRitual;
		this.pdsEspOrfebreria = pdsEspOrfebreria;
		this.pdsEspConfeccion = pdsEspConfeccion;
		this.pdsEspConfeccionMarionetas = pdsEspConfeccionMarionetas;
		this.bonoNaturalArte = bonoNaturalArte;
		this.bonoNaturalBaile = bonoNaturalBaile;
		this.bonoNaturalForja = bonoNaturalForja;
		this.bonoNaturalRunas = bonoNaturalRunas;
		this.bonoNaturalAlquimia = bonoNaturalAlquimia;
		this.bonoNaturalAnimismo = bonoNaturalAnimismo;
		this.bonoNaturalMusica = bonoNaturalMusica;
		this.bonoNaturalTrucoManos = bonoNaturalTrucoManos;
		this.bonoNaturalCaligrafiaRitual = bonoNaturalCaligrafiaRitual;
		this.bonoNaturalOrfebreria = bonoNaturalOrfebreria;
		this.bonoNaturalConfeccion = bonoNaturalConfeccion;
		this.bonoNaturalConfeccionMarionetas = bonoNaturalConfeccionMarionetas;
		this.habNaturalArte = habNaturalArte;
		this.habNaturalBaile = habNaturalBaile;
		this.habNaturalForja = habNaturalForja;
		this.habNaturalRunas = habNaturalRunas;
		this.habNaturalAlquimia = habNaturalAlquimia;
		this.habNaturalAnimismo = habNaturalAnimismo;
		this.habNaturalMusica = habNaturalMusica;
		this.habNaturalTrucoManos = habNaturalTrucoManos;
		this.habNaturalCaligrafiaRitual = habNaturalCaligrafiaRitual;
		this.habNaturalOrfebreria = habNaturalOrfebreria;
		this.habNaturalConfeccion = habNaturalConfeccion;
		this.habNaturalConfeccionMarionetas = habNaturalConfeccionMarionetas;
		this.bonoNovelArte = bonoNovelArte;
		this.bonoNovelBaile = bonoNovelBaile;
		this.bonoNovelForja = bonoNovelForja;
		this.bonoNovelRunas = bonoNovelRunas;
		this.bonoNovelAlquimia = bonoNovelAlquimia;
		this.bonoNovelAnimismo = bonoNovelAnimismo;
		this.bonoNovelMusica = bonoNovelMusica;
		this.bonoNovelTrucoManos = bonoNovelTrucoManos;
		this.bonoNovelCaligrafiaRitual = bonoNovelCaligrafiaRitual;
		this.bonoNovelOrfebreria = bonoNovelOrfebreria;
		this.bonoNovelConfeccion = bonoNovelConfeccion;
		this.bonoNovelConfeccionMarionetas = bonoNovelConfeccionMarionetas;
	}

	@GenericGenerator(name = "modelo.PdsSecundariasCreativasIdGenerator", strategy = "foreign", parameters = @Parameter(name = "property", value = "personaje"))
	@Id
	@GeneratedValue(generator = "modelo.PdsSecundariasCreativasIdGenerator")

	@Column(name = "ID_PERSONAJE", unique = true, nullable = false)
	public int getIdPersonaje() {
		return this.idPersonaje;
	}

	public void setIdPersonaje(int idPersonaje) {
		this.idPersonaje = idPersonaje;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Personaje getPersonaje() {
		return this.personaje;
	}

	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}

	@Column(name = "PDS_ARTE")
	public Integer getPdsArte() {
		return this.pdsArte;
	}

	public void setPdsArte(Integer pdsArte) {
		this.pdsArte = pdsArte;
	}

	@Column(name = "PDS_BAILE")
	public Integer getPdsBaile() {
		return this.pdsBaile;
	}

	public void setPdsBaile(Integer pdsBaile) {
		this.pdsBaile = pdsBaile;
	}

	@Column(name = "PDS_FORJA")
	public Integer getPdsForja() {
		return this.pdsForja;
	}

	public void setPdsForja(Integer pdsForja) {
		this.pdsForja = pdsForja;
	}

	@Column(name = "PDS_RUNAS")
	public Integer getPdsRunas() {
		return this.pdsRunas;
	}

	public void setPdsRunas(Integer pdsRunas) {
		this.pdsRunas = pdsRunas;
	}

	@Column(name = "PDS_ALQUIMIA")
	public Integer getPdsAlquimia() {
		return this.pdsAlquimia;
	}

	public void setPdsAlquimia(Integer pdsAlquimia) {
		this.pdsAlquimia = pdsAlquimia;
	}

	@Column(name = "PDS_ANIMISMO")
	public Integer getPdsAnimismo() {
		return this.pdsAnimismo;
	}

	public void setPdsAnimismo(Integer pdsAnimismo) {
		this.pdsAnimismo = pdsAnimismo;
	}

	@Column(name = "PDS_MUSICA")
	public Integer getPdsMusica() {
		return this.pdsMusica;
	}

	public void setPdsMusica(Integer pdsMusica) {
		this.pdsMusica = pdsMusica;
	}

	@Column(name = "PDS_TRUCO_MANOS")
	public Integer getPdsTrucoManos() {
		return this.pdsTrucoManos;
	}

	public void setPdsTrucoManos(Integer pdsTrucoManos) {
		this.pdsTrucoManos = pdsTrucoManos;
	}

	@Column(name = "PDS_CALIGRAFIA_RITUAL")
	public Integer getPdsCaligrafiaRitual() {
		return this.pdsCaligrafiaRitual;
	}

	public void setPdsCaligrafiaRitual(Integer pdsCaligrafiaRitual) {
		this.pdsCaligrafiaRitual = pdsCaligrafiaRitual;
	}

	@Column(name = "PDS_ORFEBRERIA")
	public Integer getPdsOrfebreria() {
		return this.pdsOrfebreria;
	}

	public void setPdsOrfebreria(Integer pdsOrfebreria) {
		this.pdsOrfebreria = pdsOrfebreria;
	}

	@Column(name = "PDS_CONFECCION")
	public Integer getPdsConfeccion() {
		return this.pdsConfeccion;
	}

	public void setPdsConfeccion(Integer pdsConfeccion) {
		this.pdsConfeccion = pdsConfeccion;
	}

	@Column(name = "PDS_CONFECCION_MARIONETAS")
	public Integer getPdsConfeccionMarionetas() {
		return this.pdsConfeccionMarionetas;
	}

	public void setPdsConfeccionMarionetas(Integer pdsConfeccionMarionetas) {
		this.pdsConfeccionMarionetas = pdsConfeccionMarionetas;
	}

	@Column(name = "PDS_ESP_ARTE")
	public Integer getPdsEspArte() {
		return this.pdsEspArte;
	}

	public void setPdsEspArte(Integer pdsEspArte) {
		this.pdsEspArte = pdsEspArte;
	}

	@Column(name = "PDS_ESP_BAILE")
	public Integer getPdsEspBaile() {
		return this.pdsEspBaile;
	}

	public void setPdsEspBaile(Integer pdsEspBaile) {
		this.pdsEspBaile = pdsEspBaile;
	}

	@Column(name = "PDS_ESP_FORJA")
	public Integer getPdsEspForja() {
		return this.pdsEspForja;
	}

	public void setPdsEspForja(Integer pdsEspForja) {
		this.pdsEspForja = pdsEspForja;
	}

	@Column(name = "PDS_ESP_RUNAS")
	public Integer getPdsEspRunas() {
		return this.pdsEspRunas;
	}

	public void setPdsEspRunas(Integer pdsEspRunas) {
		this.pdsEspRunas = pdsEspRunas;
	}

	@Column(name = "PDS_ESP_ALQUIMIA")
	public Integer getPdsEspAlquimia() {
		return this.pdsEspAlquimia;
	}

	public void setPdsEspAlquimia(Integer pdsEspAlquimia) {
		this.pdsEspAlquimia = pdsEspAlquimia;
	}

	@Column(name = "PDS_ESP_ANIMISMO")
	public Integer getPdsEspAnimismo() {
		return this.pdsEspAnimismo;
	}

	public void setPdsEspAnimismo(Integer pdsEspAnimismo) {
		this.pdsEspAnimismo = pdsEspAnimismo;
	}

	@Column(name = "PDS_ESP_MUSICA")
	public Integer getPdsEspMusica() {
		return this.pdsEspMusica;
	}

	public void setPdsEspMusica(Integer pdsEspMusica) {
		this.pdsEspMusica = pdsEspMusica;
	}

	@Column(name = "PDS_ESP_TRUCO_MANOS")
	public Integer getPdsEspTrucoManos() {
		return this.pdsEspTrucoManos;
	}

	public void setPdsEspTrucoManos(Integer pdsEspTrucoManos) {
		this.pdsEspTrucoManos = pdsEspTrucoManos;
	}

	@Column(name = "PDS_ESP_CALIGRAFIA_RITUAL")
	public Integer getPdsEspCaligrafiaRitual() {
		return this.pdsEspCaligrafiaRitual;
	}

	public void setPdsEspCaligrafiaRitual(Integer pdsEspCaligrafiaRitual) {
		this.pdsEspCaligrafiaRitual = pdsEspCaligrafiaRitual;
	}

	@Column(name = "PDS_ESP_ORFEBRERIA")
	public Integer getPdsEspOrfebreria() {
		return this.pdsEspOrfebreria;
	}

	public void setPdsEspOrfebreria(Integer pdsEspOrfebreria) {
		this.pdsEspOrfebreria = pdsEspOrfebreria;
	}

	@Column(name = "PDS_ESP_CONFECCION")
	public Integer getPdsEspConfeccion() {
		return this.pdsEspConfeccion;
	}

	public void setPdsEspConfeccion(Integer pdsEspConfeccion) {
		this.pdsEspConfeccion = pdsEspConfeccion;
	}

	@Column(name = "PDS_ESP_CONFECCION_MARIONETAS")
	public Integer getPdsEspConfeccionMarionetas() {
		return this.pdsEspConfeccionMarionetas;
	}

	public void setPdsEspConfeccionMarionetas(Integer pdsEspConfeccionMarionetas) {
		this.pdsEspConfeccionMarionetas = pdsEspConfeccionMarionetas;
	}

	@Column(name = "BONO_NATURAL_ARTE")
	public Integer getBonoNaturalArte() {
		return this.bonoNaturalArte;
	}

	public void setBonoNaturalArte(Integer bonoNaturalArte) {
		this.bonoNaturalArte = bonoNaturalArte;
	}

	@Column(name = "BONO_NATURAL_BAILE")
	public Integer getBonoNaturalBaile() {
		return this.bonoNaturalBaile;
	}

	public void setBonoNaturalBaile(Integer bonoNaturalBaile) {
		this.bonoNaturalBaile = bonoNaturalBaile;
	}

	@Column(name = "BONO_NATURAL_FORJA")
	public Integer getBonoNaturalForja() {
		return this.bonoNaturalForja;
	}

	public void setBonoNaturalForja(Integer bonoNaturalForja) {
		this.bonoNaturalForja = bonoNaturalForja;
	}

	@Column(name = "BONO_NATURAL_RUNAS")
	public Integer getBonoNaturalRunas() {
		return this.bonoNaturalRunas;
	}

	public void setBonoNaturalRunas(Integer bonoNaturalRunas) {
		this.bonoNaturalRunas = bonoNaturalRunas;
	}

	@Column(name = "BONO_NATURAL_ALQUIMIA")
	public Integer getBonoNaturalAlquimia() {
		return this.bonoNaturalAlquimia;
	}

	public void setBonoNaturalAlquimia(Integer bonoNaturalAlquimia) {
		this.bonoNaturalAlquimia = bonoNaturalAlquimia;
	}

	@Column(name = "BONO_NATURAL_ANIMISMO")
	public Integer getBonoNaturalAnimismo() {
		return this.bonoNaturalAnimismo;
	}

	public void setBonoNaturalAnimismo(Integer bonoNaturalAnimismo) {
		this.bonoNaturalAnimismo = bonoNaturalAnimismo;
	}

	@Column(name = "BONO_NATURAL_MUSICA")
	public Integer getBonoNaturalMusica() {
		return this.bonoNaturalMusica;
	}

	public void setBonoNaturalMusica(Integer bonoNaturalMusica) {
		this.bonoNaturalMusica = bonoNaturalMusica;
	}

	@Column(name = "BONO_NATURAL_TRUCO_MANOS")
	public Integer getBonoNaturalTrucoManos() {
		return this.bonoNaturalTrucoManos;
	}

	public void setBonoNaturalTrucoManos(Integer bonoNaturalTrucoManos) {
		this.bonoNaturalTrucoManos = bonoNaturalTrucoManos;
	}

	@Column(name = "BONO_NATURAL_CALIGRAFIA_RITUAL")
	public Integer getBonoNaturalCaligrafiaRitual() {
		return this.bonoNaturalCaligrafiaRitual;
	}

	public void setBonoNaturalCaligrafiaRitual(Integer bonoNaturalCaligrafiaRitual) {
		this.bonoNaturalCaligrafiaRitual = bonoNaturalCaligrafiaRitual;
	}

	@Column(name = "BONO_NATURAL_ORFEBRERIA")
	public Integer getBonoNaturalOrfebreria() {
		return this.bonoNaturalOrfebreria;
	}

	public void setBonoNaturalOrfebreria(Integer bonoNaturalOrfebreria) {
		this.bonoNaturalOrfebreria = bonoNaturalOrfebreria;
	}

	@Column(name = "BONO_NATURAL_CONFECCION")
	public Integer getBonoNaturalConfeccion() {
		return this.bonoNaturalConfeccion;
	}

	public void setBonoNaturalConfeccion(Integer bonoNaturalConfeccion) {
		this.bonoNaturalConfeccion = bonoNaturalConfeccion;
	}

	@Column(name = "BONO_NATURAL_CONFECCION_MARIONETAS")
	public Integer getBonoNaturalConfeccionMarionetas() {
		return this.bonoNaturalConfeccionMarionetas;
	}

	public void setBonoNaturalConfeccionMarionetas(Integer bonoNaturalConfeccionMarionetas) {
		this.bonoNaturalConfeccionMarionetas = bonoNaturalConfeccionMarionetas;
	}

	@Column(name = "HAB_NATURAL_ARTE")
	public Integer getHabNaturalArte() {
		return this.habNaturalArte;
	}

	public void setHabNaturalArte(Integer habNaturalArte) {
		this.habNaturalArte = habNaturalArte;
	}

	@Column(name = "HAB_NATURAL_BAILE")
	public Integer getHabNaturalBaile() {
		return this.habNaturalBaile;
	}

	public void setHabNaturalBaile(Integer habNaturalBaile) {
		this.habNaturalBaile = habNaturalBaile;
	}

	@Column(name = "HAB_NATURAL_FORJA")
	public Integer getHabNaturalForja() {
		return this.habNaturalForja;
	}

	public void setHabNaturalForja(Integer habNaturalForja) {
		this.habNaturalForja = habNaturalForja;
	}

	@Column(name = "HAB_NATURAL_RUNAS")
	public Integer getHabNaturalRunas() {
		return this.habNaturalRunas;
	}

	public void setHabNaturalRunas(Integer habNaturalRunas) {
		this.habNaturalRunas = habNaturalRunas;
	}

	@Column(name = "HAB_NATURAL_ALQUIMIA")
	public Integer getHabNaturalAlquimia() {
		return this.habNaturalAlquimia;
	}

	public void setHabNaturalAlquimia(Integer habNaturalAlquimia) {
		this.habNaturalAlquimia = habNaturalAlquimia;
	}

	@Column(name = "HAB_NATURAL_ANIMISMO")
	public Integer getHabNaturalAnimismo() {
		return this.habNaturalAnimismo;
	}

	public void setHabNaturalAnimismo(Integer habNaturalAnimismo) {
		this.habNaturalAnimismo = habNaturalAnimismo;
	}

	@Column(name = "HAB_NATURAL_MUSICA")
	public Integer getHabNaturalMusica() {
		return this.habNaturalMusica;
	}

	public void setHabNaturalMusica(Integer habNaturalMusica) {
		this.habNaturalMusica = habNaturalMusica;
	}

	@Column(name = "HAB_NATURAL_TRUCO_MANOS")
	public Integer getHabNaturalTrucoManos() {
		return this.habNaturalTrucoManos;
	}

	public void setHabNaturalTrucoManos(Integer habNaturalTrucoManos) {
		this.habNaturalTrucoManos = habNaturalTrucoManos;
	}

	@Column(name = "HAB_NATURAL_CALIGRAFIA_RITUAL")
	public Integer getHabNaturalCaligrafiaRitual() {
		return this.habNaturalCaligrafiaRitual;
	}

	public void setHabNaturalCaligrafiaRitual(Integer habNaturalCaligrafiaRitual) {
		this.habNaturalCaligrafiaRitual = habNaturalCaligrafiaRitual;
	}

	@Column(name = "HAB_NATURAL_ORFEBRERIA")
	public Integer getHabNaturalOrfebreria() {
		return this.habNaturalOrfebreria;
	}

	public void setHabNaturalOrfebreria(Integer habNaturalOrfebreria) {
		this.habNaturalOrfebreria = habNaturalOrfebreria;
	}

	@Column(name = "HAB_NATURAL_CONFECCION")
	public Integer getHabNaturalConfeccion() {
		return this.habNaturalConfeccion;
	}

	public void setHabNaturalConfeccion(Integer habNaturalConfeccion) {
		this.habNaturalConfeccion = habNaturalConfeccion;
	}

	@Column(name = "HAB_NATURAL_CONFECCION_MARIONETAS")
	public Integer getHabNaturalConfeccionMarionetas() {
		return this.habNaturalConfeccionMarionetas;
	}

	public void setHabNaturalConfeccionMarionetas(Integer habNaturalConfeccionMarionetas) {
		this.habNaturalConfeccionMarionetas = habNaturalConfeccionMarionetas;
	}

	@Column(name = "BONO_NOVEL_ARTE")
	public Integer getBonoNovelArte() {
		return this.bonoNovelArte;
	}

	public void setBonoNovelArte(Integer bonoNovelArte) {
		this.bonoNovelArte = bonoNovelArte;
	}

	@Column(name = "BONO_NOVEL_BAILE")
	public Integer getBonoNovelBaile() {
		return this.bonoNovelBaile;
	}

	public void setBonoNovelBaile(Integer bonoNovelBaile) {
		this.bonoNovelBaile = bonoNovelBaile;
	}

	@Column(name = "BONO_NOVEL_FORJA")
	public Integer getBonoNovelForja() {
		return this.bonoNovelForja;
	}

	public void setBonoNovelForja(Integer bonoNovelForja) {
		this.bonoNovelForja = bonoNovelForja;
	}

	@Column(name = "BONO_NOVEL_RUNAS")
	public Integer getBonoNovelRunas() {
		return this.bonoNovelRunas;
	}

	public void setBonoNovelRunas(Integer bonoNovelRunas) {
		this.bonoNovelRunas = bonoNovelRunas;
	}

	@Column(name = "BONO_NOVEL_ALQUIMIA")
	public Integer getBonoNovelAlquimia() {
		return this.bonoNovelAlquimia;
	}

	public void setBonoNovelAlquimia(Integer bonoNovelAlquimia) {
		this.bonoNovelAlquimia = bonoNovelAlquimia;
	}

	@Column(name = "BONO_NOVEL_ANIMISMO")
	public Integer getBonoNovelAnimismo() {
		return this.bonoNovelAnimismo;
	}

	public void setBonoNovelAnimismo(Integer bonoNovelAnimismo) {
		this.bonoNovelAnimismo = bonoNovelAnimismo;
	}

	@Column(name = "BONO_NOVEL_MUSICA")
	public Integer getBonoNovelMusica() {
		return this.bonoNovelMusica;
	}

	public void setBonoNovelMusica(Integer bonoNovelMusica) {
		this.bonoNovelMusica = bonoNovelMusica;
	}

	@Column(name = "BONO_NOVEL_TRUCO_MANOS")
	public Integer getBonoNovelTrucoManos() {
		return this.bonoNovelTrucoManos;
	}

	public void setBonoNovelTrucoManos(Integer bonoNovelTrucoManos) {
		this.bonoNovelTrucoManos = bonoNovelTrucoManos;
	}

	@Column(name = "BONO_NOVEL_CALIGRAFIA_RITUAL")
	public Integer getBonoNovelCaligrafiaRitual() {
		return this.bonoNovelCaligrafiaRitual;
	}

	public void setBonoNovelCaligrafiaRitual(Integer bonoNovelCaligrafiaRitual) {
		this.bonoNovelCaligrafiaRitual = bonoNovelCaligrafiaRitual;
	}

	@Column(name = "BONO_NOVEL_ORFEBRERIA")
	public Integer getBonoNovelOrfebreria() {
		return this.bonoNovelOrfebreria;
	}

	public void setBonoNovelOrfebreria(Integer bonoNovelOrfebreria) {
		this.bonoNovelOrfebreria = bonoNovelOrfebreria;
	}

	@Column(name = "BONO_NOVEL_CONFECCION")
	public Integer getBonoNovelConfeccion() {
		return this.bonoNovelConfeccion;
	}

	public void setBonoNovelConfeccion(Integer bonoNovelConfeccion) {
		this.bonoNovelConfeccion = bonoNovelConfeccion;
	}

	@Column(name = "BONO_NOVEL_CONFECCION_MARIONETAS")
	public Integer getBonoNovelConfeccionMarionetas() {
		return this.bonoNovelConfeccionMarionetas;
	}

	public void setBonoNovelConfeccionMarionetas(Integer bonoNovelConfeccionMarionetas) {
		this.bonoNovelConfeccionMarionetas = bonoNovelConfeccionMarionetas;
	}

}
