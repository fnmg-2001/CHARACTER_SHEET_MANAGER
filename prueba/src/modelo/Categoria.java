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
 * Categoria generated by hbm2java
 */
@Entity
@Table(name = "categoria", catalog = "anima_sheets_data")
public class Categoria implements java.io.Serializable {

	private Integer idCategoria;
	private String nombre;
	private String descripcion;
	private String arquetipo1;
	private String arquetipo2;
	private int multiploVida;
	private int puntosVida;
	private int conocimientoMarcial;
	private int turno;
	private int cvInnato;
	private Integer bonoHa;
	private Integer bonoHp;
	private Integer bonoHe;
	private Integer bonoLlevarArmadura;
	private Integer bonoAdvertir;
	private Integer bonoBuscar;
	private Integer bonoRastrear;
	private Integer bonoTramperia;
	private Integer bonoAnimales;
	private Integer bonoHerbolaria;
	private Integer bonoOcultarse;
	private Integer bonoSigilo;
	private Integer bonoRobo;
	private Integer bonoVenenos;
	private Integer bonoValoracionMagica;
	private Integer bonoOcultismo;
	private Integer bonoDisfraz;
	private Integer bonoProezaFuerza;
	private Integer bonoAcrobacias;
	private Integer bonoSaltar;
	private Integer bonoAtletismo;
	private Integer bonoTrucoManos;
	private Integer bonoEstilo;
	private Integer bonoLiderazgo;
	private Integer bonoIntimidar;
	private Integer bonoPersuasion;
	private Integer bonoResistirDolor;
	private Integer bonoFrialdad;
	private Integer bonoVeneno;
	private Integer bonoConvocar;
	private Integer bonoControlar;
	private Integer bonoAtar;
	private Integer bonoDesconvocar;
	private Integer bonoZeon;
	private Integer bonoDeteccionKi;
	private Integer bonoOcultacionKi;
	private int costeHabilidadAtaque;
	private int costeHabilidadParada;
	private int costeHabilidadEsquiva;
	private int costeLlevarArmadura;
	private int costePuntoKi;
	private int costeAcumulacionKi;
	private int costeZeon;
	private int costeAct;
	private int multiploRegeneracion;
	private int costeProyeccionMagica;
	private int costeNivelMagia;
	private int costeConvocar;
	private int costeControlar;
	private int costeAtar;
	private int costeDesconvocar;
	private int costePuntosCv;
	private int costeProyeccionPsiquica;
	private int costeAtleticas;
	private int costeSociales;
	private int costePerceptivas;
	private int costeIntelectuales;
	private int costeVigor;
	private int costeSubterfugio;
	private int costeCreativas;
	private Integer costeReducidoAdvertir;
	private Integer costeReducidoBuscar;
	private Integer costeReducidoRastrear;
	private Integer costeReducidoTramperia;
	private Integer costeReducidoAnimales;
	private Integer costeReducidoHerbolaria;
	private Integer costeReducidoOcultarse;
	private Integer costeReducidoSigilo;
	private Integer costeReducidoRobo;
	private Integer costeReducidoVenenos;
	private Integer costeReducidoValoracionMagica;
	private Integer costeReducidoOcultismo;
	private Integer costeReducidoDisfraz;
	private Integer costeReducidoProezaFuerza;
	private Integer costeReducidoAcrobacias;
	private Integer costeReducidoSaltar;
	private Integer costeReducidoAtletismo;
	private Integer costeReducidoTrucoManos;
	private Integer costeReducidoEstilo;
	private Integer costeReducidoLiderazgo;
	private Integer costeReducidoIntimidar;
	private Integer costeReducidoPersuasion;
	private Integer costeReducidoResistirDolor;
	private Integer costeReducidoFrialdad;
	private Integer costeReducidoMedicina;
	private Integer costeReducidoTasacion;
	private Integer costeReducidoMemorizar;
	private String imagen;
	private Set<Personaje> personajes = new HashSet<Personaje>(0);

	public Categoria() {
	}

	public Categoria(String nombre, String descripcion, String arquetipo1, int multiploVida, int puntosVida,
			int conocimientoMarcial, int turno, int cvInnato, int costeHabilidadAtaque, int costeHabilidadParada,
			int costeHabilidadEsquiva, int costeLlevarArmadura, int costePuntoKi, int costeAcumulacionKi, int costeZeon,
			int costeAct, int multiploRegeneracion, int costeProyeccionMagica, int costeNivelMagia, int costeConvocar,
			int costeControlar, int costeAtar, int costeDesconvocar, int costePuntosCv, int costeProyeccionPsiquica,
			int costeAtleticas, int costeSociales, int costePerceptivas, int costeIntelectuales, int costeVigor,
			int costeSubterfugio, int costeCreativas) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.arquetipo1 = arquetipo1;
		this.multiploVida = multiploVida;
		this.puntosVida = puntosVida;
		this.conocimientoMarcial = conocimientoMarcial;
		this.turno = turno;
		this.cvInnato = cvInnato;
		this.costeHabilidadAtaque = costeHabilidadAtaque;
		this.costeHabilidadParada = costeHabilidadParada;
		this.costeHabilidadEsquiva = costeHabilidadEsquiva;
		this.costeLlevarArmadura = costeLlevarArmadura;
		this.costePuntoKi = costePuntoKi;
		this.costeAcumulacionKi = costeAcumulacionKi;
		this.costeZeon = costeZeon;
		this.costeAct = costeAct;
		this.multiploRegeneracion = multiploRegeneracion;
		this.costeProyeccionMagica = costeProyeccionMagica;
		this.costeNivelMagia = costeNivelMagia;
		this.costeConvocar = costeConvocar;
		this.costeControlar = costeControlar;
		this.costeAtar = costeAtar;
		this.costeDesconvocar = costeDesconvocar;
		this.costePuntosCv = costePuntosCv;
		this.costeProyeccionPsiquica = costeProyeccionPsiquica;
		this.costeAtleticas = costeAtleticas;
		this.costeSociales = costeSociales;
		this.costePerceptivas = costePerceptivas;
		this.costeIntelectuales = costeIntelectuales;
		this.costeVigor = costeVigor;
		this.costeSubterfugio = costeSubterfugio;
		this.costeCreativas = costeCreativas;
	}

	public Categoria(String nombre, String descripcion, String arquetipo1, String arquetipo2, int multiploVida,
			int puntosVida, int conocimientoMarcial, int turno, int cvInnato, Integer bonoHa, Integer bonoHp,
			Integer bonoHe, Integer bonoLlevarArmadura, Integer bonoAdvertir, Integer bonoBuscar, Integer bonoRastrear,
			Integer bonoTramperia, Integer bonoAnimales, Integer bonoHerbolaria, Integer bonoOcultarse,
			Integer bonoSigilo, Integer bonoRobo, Integer bonoVenenos, Integer bonoValoracionMagica,
			Integer bonoOcultismo, Integer bonoDisfraz, Integer bonoProezaFuerza, Integer bonoAcrobacias,
			Integer bonoSaltar, Integer bonoAtletismo, Integer bonoTrucoManos, Integer bonoEstilo,
			Integer bonoLiderazgo, Integer bonoIntimidar, Integer bonoPersuasion, Integer bonoResistirDolor,
			Integer bonoFrialdad, Integer bonoVeneno, Integer bonoConvocar, Integer bonoControlar, Integer bonoAtar,
			Integer bonoDesconvocar, Integer bonoZeon, Integer bonoDeteccionKi, Integer bonoOcultacionKi,
			int costeHabilidadAtaque, int costeHabilidadParada, int costeHabilidadEsquiva, int costeLlevarArmadura,
			int costePuntoKi, int costeAcumulacionKi, int costeZeon, int costeAct, int multiploRegeneracion,
			int costeProyeccionMagica, int costeNivelMagia, int costeConvocar, int costeControlar, int costeAtar,
			int costeDesconvocar, int costePuntosCv, int costeProyeccionPsiquica, int costeAtleticas, int costeSociales,
			int costePerceptivas, int costeIntelectuales, int costeVigor, int costeSubterfugio, int costeCreativas,
			Integer costeReducidoAdvertir, Integer costeReducidoBuscar, Integer costeReducidoRastrear,
			Integer costeReducidoTramperia, Integer costeReducidoAnimales, Integer costeReducidoHerbolaria,
			Integer costeReducidoOcultarse, Integer costeReducidoSigilo, Integer costeReducidoRobo,
			Integer costeReducidoVenenos, Integer costeReducidoValoracionMagica, Integer costeReducidoOcultismo,
			Integer costeReducidoDisfraz, Integer costeReducidoProezaFuerza, Integer costeReducidoAcrobacias,
			Integer costeReducidoSaltar, Integer costeReducidoAtletismo, Integer costeReducidoTrucoManos,
			Integer costeReducidoEstilo, Integer costeReducidoLiderazgo, Integer costeReducidoIntimidar,
			Integer costeReducidoPersuasion, Integer costeReducidoResistirDolor, Integer costeReducidoFrialdad,
			Integer costeReducidoMedicina, Integer costeReducidoTasacion, Integer costeReducidoMemorizar, String imagen,
			Set<Personaje> personajes) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.arquetipo1 = arquetipo1;
		this.arquetipo2 = arquetipo2;
		this.multiploVida = multiploVida;
		this.puntosVida = puntosVida;
		this.conocimientoMarcial = conocimientoMarcial;
		this.turno = turno;
		this.cvInnato = cvInnato;
		this.bonoHa = bonoHa;
		this.bonoHp = bonoHp;
		this.bonoHe = bonoHe;
		this.bonoLlevarArmadura = bonoLlevarArmadura;
		this.bonoAdvertir = bonoAdvertir;
		this.bonoBuscar = bonoBuscar;
		this.bonoRastrear = bonoRastrear;
		this.bonoTramperia = bonoTramperia;
		this.bonoAnimales = bonoAnimales;
		this.bonoHerbolaria = bonoHerbolaria;
		this.bonoOcultarse = bonoOcultarse;
		this.bonoSigilo = bonoSigilo;
		this.bonoRobo = bonoRobo;
		this.bonoVenenos = bonoVenenos;
		this.bonoValoracionMagica = bonoValoracionMagica;
		this.bonoOcultismo = bonoOcultismo;
		this.bonoDisfraz = bonoDisfraz;
		this.bonoProezaFuerza = bonoProezaFuerza;
		this.bonoAcrobacias = bonoAcrobacias;
		this.bonoSaltar = bonoSaltar;
		this.bonoAtletismo = bonoAtletismo;
		this.bonoTrucoManos = bonoTrucoManos;
		this.bonoEstilo = bonoEstilo;
		this.bonoLiderazgo = bonoLiderazgo;
		this.bonoIntimidar = bonoIntimidar;
		this.bonoPersuasion = bonoPersuasion;
		this.bonoResistirDolor = bonoResistirDolor;
		this.bonoFrialdad = bonoFrialdad;
		this.bonoVeneno = bonoVeneno;
		this.bonoConvocar = bonoConvocar;
		this.bonoControlar = bonoControlar;
		this.bonoAtar = bonoAtar;
		this.bonoDesconvocar = bonoDesconvocar;
		this.bonoZeon = bonoZeon;
		this.bonoDeteccionKi = bonoDeteccionKi;
		this.bonoOcultacionKi = bonoOcultacionKi;
		this.costeHabilidadAtaque = costeHabilidadAtaque;
		this.costeHabilidadParada = costeHabilidadParada;
		this.costeHabilidadEsquiva = costeHabilidadEsquiva;
		this.costeLlevarArmadura = costeLlevarArmadura;
		this.costePuntoKi = costePuntoKi;
		this.costeAcumulacionKi = costeAcumulacionKi;
		this.costeZeon = costeZeon;
		this.costeAct = costeAct;
		this.multiploRegeneracion = multiploRegeneracion;
		this.costeProyeccionMagica = costeProyeccionMagica;
		this.costeNivelMagia = costeNivelMagia;
		this.costeConvocar = costeConvocar;
		this.costeControlar = costeControlar;
		this.costeAtar = costeAtar;
		this.costeDesconvocar = costeDesconvocar;
		this.costePuntosCv = costePuntosCv;
		this.costeProyeccionPsiquica = costeProyeccionPsiquica;
		this.costeAtleticas = costeAtleticas;
		this.costeSociales = costeSociales;
		this.costePerceptivas = costePerceptivas;
		this.costeIntelectuales = costeIntelectuales;
		this.costeVigor = costeVigor;
		this.costeSubterfugio = costeSubterfugio;
		this.costeCreativas = costeCreativas;
		this.costeReducidoAdvertir = costeReducidoAdvertir;
		this.costeReducidoBuscar = costeReducidoBuscar;
		this.costeReducidoRastrear = costeReducidoRastrear;
		this.costeReducidoTramperia = costeReducidoTramperia;
		this.costeReducidoAnimales = costeReducidoAnimales;
		this.costeReducidoHerbolaria = costeReducidoHerbolaria;
		this.costeReducidoOcultarse = costeReducidoOcultarse;
		this.costeReducidoSigilo = costeReducidoSigilo;
		this.costeReducidoRobo = costeReducidoRobo;
		this.costeReducidoVenenos = costeReducidoVenenos;
		this.costeReducidoValoracionMagica = costeReducidoValoracionMagica;
		this.costeReducidoOcultismo = costeReducidoOcultismo;
		this.costeReducidoDisfraz = costeReducidoDisfraz;
		this.costeReducidoProezaFuerza = costeReducidoProezaFuerza;
		this.costeReducidoAcrobacias = costeReducidoAcrobacias;
		this.costeReducidoSaltar = costeReducidoSaltar;
		this.costeReducidoAtletismo = costeReducidoAtletismo;
		this.costeReducidoTrucoManos = costeReducidoTrucoManos;
		this.costeReducidoEstilo = costeReducidoEstilo;
		this.costeReducidoLiderazgo = costeReducidoLiderazgo;
		this.costeReducidoIntimidar = costeReducidoIntimidar;
		this.costeReducidoPersuasion = costeReducidoPersuasion;
		this.costeReducidoResistirDolor = costeReducidoResistirDolor;
		this.costeReducidoFrialdad = costeReducidoFrialdad;
		this.costeReducidoMedicina = costeReducidoMedicina;
		this.costeReducidoTasacion = costeReducidoTasacion;
		this.costeReducidoMemorizar = costeReducidoMemorizar;
		this.imagen = imagen;
		this.personajes = personajes;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID_CATEGORIA", unique = true, nullable = false)
	public Integer getIdCategoria() {
		return this.idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	@Column(name = "NOMBRE", nullable = false, length = 50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "DESCRIPCION", nullable = false, length = 65535)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "ARQUETIPO1", nullable = false, length = 50)
	public String getArquetipo1() {
		return this.arquetipo1;
	}

	public void setArquetipo1(String arquetipo1) {
		this.arquetipo1 = arquetipo1;
	}

	@Column(name = "ARQUETIPO2", length = 50)
	public String getArquetipo2() {
		return this.arquetipo2;
	}

	public void setArquetipo2(String arquetipo2) {
		this.arquetipo2 = arquetipo2;
	}

	@Column(name = "MULTIPLO_VIDA", nullable = false)
	public int getMultiploVida() {
		return this.multiploVida;
	}

	public void setMultiploVida(int multiploVida) {
		this.multiploVida = multiploVida;
	}

	@Column(name = "PUNTOS_VIDA", nullable = false)
	public int getPuntosVida() {
		return this.puntosVida;
	}

	public void setPuntosVida(int puntosVida) {
		this.puntosVida = puntosVida;
	}

	@Column(name = "CONOCIMIENTO_MARCIAL", nullable = false)
	public int getConocimientoMarcial() {
		return this.conocimientoMarcial;
	}

	public void setConocimientoMarcial(int conocimientoMarcial) {
		this.conocimientoMarcial = conocimientoMarcial;
	}

	@Column(name = "TURNO", nullable = false)
	public int getTurno() {
		return this.turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	@Column(name = "CV_INNATO", nullable = false)
	public int getCvInnato() {
		return this.cvInnato;
	}

	public void setCvInnato(int cvInnato) {
		this.cvInnato = cvInnato;
	}

	@Column(name = "BONO_HA")
	public Integer getBonoHa() {
		return this.bonoHa;
	}

	public void setBonoHa(Integer bonoHa) {
		this.bonoHa = bonoHa;
	}

	@Column(name = "BONO_HP")
	public Integer getBonoHp() {
		return this.bonoHp;
	}

	public void setBonoHp(Integer bonoHp) {
		this.bonoHp = bonoHp;
	}

	@Column(name = "BONO_HE")
	public Integer getBonoHe() {
		return this.bonoHe;
	}

	public void setBonoHe(Integer bonoHe) {
		this.bonoHe = bonoHe;
	}

	@Column(name = "BONO_LLEVAR_ARMADURA")
	public Integer getBonoLlevarArmadura() {
		return this.bonoLlevarArmadura;
	}

	public void setBonoLlevarArmadura(Integer bonoLlevarArmadura) {
		this.bonoLlevarArmadura = bonoLlevarArmadura;
	}

	@Column(name = "BONO_ADVERTIR")
	public Integer getBonoAdvertir() {
		return this.bonoAdvertir;
	}

	public void setBonoAdvertir(Integer bonoAdvertir) {
		this.bonoAdvertir = bonoAdvertir;
	}

	@Column(name = "BONO_BUSCAR")
	public Integer getBonoBuscar() {
		return this.bonoBuscar;
	}

	public void setBonoBuscar(Integer bonoBuscar) {
		this.bonoBuscar = bonoBuscar;
	}

	@Column(name = "BONO_RASTREAR")
	public Integer getBonoRastrear() {
		return this.bonoRastrear;
	}

	public void setBonoRastrear(Integer bonoRastrear) {
		this.bonoRastrear = bonoRastrear;
	}

	@Column(name = "BONO_TRAMPERIA")
	public Integer getBonoTramperia() {
		return this.bonoTramperia;
	}

	public void setBonoTramperia(Integer bonoTramperia) {
		this.bonoTramperia = bonoTramperia;
	}

	@Column(name = "BONO_ANIMALES")
	public Integer getBonoAnimales() {
		return this.bonoAnimales;
	}

	public void setBonoAnimales(Integer bonoAnimales) {
		this.bonoAnimales = bonoAnimales;
	}

	@Column(name = "BONO_HERBOLARIA")
	public Integer getBonoHerbolaria() {
		return this.bonoHerbolaria;
	}

	public void setBonoHerbolaria(Integer bonoHerbolaria) {
		this.bonoHerbolaria = bonoHerbolaria;
	}

	@Column(name = "BONO_OCULTARSE")
	public Integer getBonoOcultarse() {
		return this.bonoOcultarse;
	}

	public void setBonoOcultarse(Integer bonoOcultarse) {
		this.bonoOcultarse = bonoOcultarse;
	}

	@Column(name = "BONO_SIGILO")
	public Integer getBonoSigilo() {
		return this.bonoSigilo;
	}

	public void setBonoSigilo(Integer bonoSigilo) {
		this.bonoSigilo = bonoSigilo;
	}

	@Column(name = "BONO_ROBO")
	public Integer getBonoRobo() {
		return this.bonoRobo;
	}

	public void setBonoRobo(Integer bonoRobo) {
		this.bonoRobo = bonoRobo;
	}

	@Column(name = "BONO_VENENOS")
	public Integer getBonoVenenos() {
		return this.bonoVenenos;
	}

	public void setBonoVenenos(Integer bonoVenenos) {
		this.bonoVenenos = bonoVenenos;
	}

	@Column(name = "BONO_VALORACION_MAGICA")
	public Integer getBonoValoracionMagica() {
		return this.bonoValoracionMagica;
	}

	public void setBonoValoracionMagica(Integer bonoValoracionMagica) {
		this.bonoValoracionMagica = bonoValoracionMagica;
	}

	@Column(name = "BONO_OCULTISMO")
	public Integer getBonoOcultismo() {
		return this.bonoOcultismo;
	}

	public void setBonoOcultismo(Integer bonoOcultismo) {
		this.bonoOcultismo = bonoOcultismo;
	}

	@Column(name = "BONO_DISFRAZ")
	public Integer getBonoDisfraz() {
		return this.bonoDisfraz;
	}

	public void setBonoDisfraz(Integer bonoDisfraz) {
		this.bonoDisfraz = bonoDisfraz;
	}

	@Column(name = "BONO_PROEZA_FUERZA")
	public Integer getBonoProezaFuerza() {
		return this.bonoProezaFuerza;
	}

	public void setBonoProezaFuerza(Integer bonoProezaFuerza) {
		this.bonoProezaFuerza = bonoProezaFuerza;
	}

	@Column(name = "BONO_ACROBACIAS")
	public Integer getBonoAcrobacias() {
		return this.bonoAcrobacias;
	}

	public void setBonoAcrobacias(Integer bonoAcrobacias) {
		this.bonoAcrobacias = bonoAcrobacias;
	}

	@Column(name = "BONO_SALTAR")
	public Integer getBonoSaltar() {
		return this.bonoSaltar;
	}

	public void setBonoSaltar(Integer bonoSaltar) {
		this.bonoSaltar = bonoSaltar;
	}

	@Column(name = "BONO_ATLETISMO")
	public Integer getBonoAtletismo() {
		return this.bonoAtletismo;
	}

	public void setBonoAtletismo(Integer bonoAtletismo) {
		this.bonoAtletismo = bonoAtletismo;
	}

	@Column(name = "BONO_TRUCO_MANOS")
	public Integer getBonoTrucoManos() {
		return this.bonoTrucoManos;
	}

	public void setBonoTrucoManos(Integer bonoTrucoManos) {
		this.bonoTrucoManos = bonoTrucoManos;
	}

	@Column(name = "BONO_ESTILO")
	public Integer getBonoEstilo() {
		return this.bonoEstilo;
	}

	public void setBonoEstilo(Integer bonoEstilo) {
		this.bonoEstilo = bonoEstilo;
	}

	@Column(name = "BONO_LIDERAZGO")
	public Integer getBonoLiderazgo() {
		return this.bonoLiderazgo;
	}

	public void setBonoLiderazgo(Integer bonoLiderazgo) {
		this.bonoLiderazgo = bonoLiderazgo;
	}

	@Column(name = "BONO_INTIMIDAR")
	public Integer getBonoIntimidar() {
		return this.bonoIntimidar;
	}

	public void setBonoIntimidar(Integer bonoIntimidar) {
		this.bonoIntimidar = bonoIntimidar;
	}

	@Column(name = "BONO_PERSUASION")
	public Integer getBonoPersuasion() {
		return this.bonoPersuasion;
	}

	public void setBonoPersuasion(Integer bonoPersuasion) {
		this.bonoPersuasion = bonoPersuasion;
	}

	@Column(name = "BONO_RESISTIR_DOLOR")
	public Integer getBonoResistirDolor() {
		return this.bonoResistirDolor;
	}

	public void setBonoResistirDolor(Integer bonoResistirDolor) {
		this.bonoResistirDolor = bonoResistirDolor;
	}

	@Column(name = "BONO_FRIALDAD")
	public Integer getBonoFrialdad() {
		return this.bonoFrialdad;
	}

	public void setBonoFrialdad(Integer bonoFrialdad) {
		this.bonoFrialdad = bonoFrialdad;
	}

	@Column(name = "BONO_VENENO")
	public Integer getBonoVeneno() {
		return this.bonoVeneno;
	}

	public void setBonoVeneno(Integer bonoVeneno) {
		this.bonoVeneno = bonoVeneno;
	}

	@Column(name = "BONO_CONVOCAR")
	public Integer getBonoConvocar() {
		return this.bonoConvocar;
	}

	public void setBonoConvocar(Integer bonoConvocar) {
		this.bonoConvocar = bonoConvocar;
	}

	@Column(name = "BONO_CONTROLAR")
	public Integer getBonoControlar() {
		return this.bonoControlar;
	}

	public void setBonoControlar(Integer bonoControlar) {
		this.bonoControlar = bonoControlar;
	}

	@Column(name = "BONO_ATAR")
	public Integer getBonoAtar() {
		return this.bonoAtar;
	}

	public void setBonoAtar(Integer bonoAtar) {
		this.bonoAtar = bonoAtar;
	}

	@Column(name = "BONO_DESCONVOCAR")
	public Integer getBonoDesconvocar() {
		return this.bonoDesconvocar;
	}

	public void setBonoDesconvocar(Integer bonoDesconvocar) {
		this.bonoDesconvocar = bonoDesconvocar;
	}

	@Column(name = "BONO_ZEON")
	public Integer getBonoZeon() {
		return this.bonoZeon;
	}

	public void setBonoZeon(Integer bonoZeon) {
		this.bonoZeon = bonoZeon;
	}

	@Column(name = "BONO_DETECCION_KI")
	public Integer getBonoDeteccionKi() {
		return this.bonoDeteccionKi;
	}

	public void setBonoDeteccionKi(Integer bonoDeteccionKi) {
		this.bonoDeteccionKi = bonoDeteccionKi;
	}

	@Column(name = "BONO_OCULTACION_KI")
	public Integer getBonoOcultacionKi() {
		return this.bonoOcultacionKi;
	}

	public void setBonoOcultacionKi(Integer bonoOcultacionKi) {
		this.bonoOcultacionKi = bonoOcultacionKi;
	}

	@Column(name = "COSTE_HABILIDAD_ATAQUE", nullable = false)
	public int getCosteHabilidadAtaque() {
		return this.costeHabilidadAtaque;
	}

	public void setCosteHabilidadAtaque(int costeHabilidadAtaque) {
		this.costeHabilidadAtaque = costeHabilidadAtaque;
	}

	@Column(name = "COSTE_HABILIDAD_PARADA", nullable = false)
	public int getCosteHabilidadParada() {
		return this.costeHabilidadParada;
	}

	public void setCosteHabilidadParada(int costeHabilidadParada) {
		this.costeHabilidadParada = costeHabilidadParada;
	}

	@Column(name = "COSTE_HABILIDAD_ESQUIVA", nullable = false)
	public int getCosteHabilidadEsquiva() {
		return this.costeHabilidadEsquiva;
	}

	public void setCosteHabilidadEsquiva(int costeHabilidadEsquiva) {
		this.costeHabilidadEsquiva = costeHabilidadEsquiva;
	}

	@Column(name = "COSTE_LLEVAR_ARMADURA", nullable = false)
	public int getCosteLlevarArmadura() {
		return this.costeLlevarArmadura;
	}

	public void setCosteLlevarArmadura(int costeLlevarArmadura) {
		this.costeLlevarArmadura = costeLlevarArmadura;
	}

	@Column(name = "COSTE_PUNTO_KI", nullable = false)
	public int getCostePuntoKi() {
		return this.costePuntoKi;
	}

	public void setCostePuntoKi(int costePuntoKi) {
		this.costePuntoKi = costePuntoKi;
	}

	@Column(name = "COSTE_ACUMULACION_KI", nullable = false)
	public int getCosteAcumulacionKi() {
		return this.costeAcumulacionKi;
	}

	public void setCosteAcumulacionKi(int costeAcumulacionKi) {
		this.costeAcumulacionKi = costeAcumulacionKi;
	}

	@Column(name = "COSTE_ZEON", nullable = false)
	public int getCosteZeon() {
		return this.costeZeon;
	}

	public void setCosteZeon(int costeZeon) {
		this.costeZeon = costeZeon;
	}

	@Column(name = "COSTE_ACT", nullable = false)
	public int getCosteAct() {
		return this.costeAct;
	}

	public void setCosteAct(int costeAct) {
		this.costeAct = costeAct;
	}

	@Column(name = "MULTIPLO_REGENERACION", nullable = false)
	public int getMultiploRegeneracion() {
		return this.multiploRegeneracion;
	}

	public void setMultiploRegeneracion(int multiploRegeneracion) {
		this.multiploRegeneracion = multiploRegeneracion;
	}

	@Column(name = "COSTE_PROYECCION_MAGICA", nullable = false)
	public int getCosteProyeccionMagica() {
		return this.costeProyeccionMagica;
	}

	public void setCosteProyeccionMagica(int costeProyeccionMagica) {
		this.costeProyeccionMagica = costeProyeccionMagica;
	}

	@Column(name = "COSTE_NIVEL_MAGIA", nullable = false)
	public int getCosteNivelMagia() {
		return this.costeNivelMagia;
	}

	public void setCosteNivelMagia(int costeNivelMagia) {
		this.costeNivelMagia = costeNivelMagia;
	}

	@Column(name = "COSTE_CONVOCAR", nullable = false)
	public int getCosteConvocar() {
		return this.costeConvocar;
	}

	public void setCosteConvocar(int costeConvocar) {
		this.costeConvocar = costeConvocar;
	}

	@Column(name = "COSTE_CONTROLAR", nullable = false)
	public int getCosteControlar() {
		return this.costeControlar;
	}

	public void setCosteControlar(int costeControlar) {
		this.costeControlar = costeControlar;
	}

	@Column(name = "COSTE_ATAR", nullable = false)
	public int getCosteAtar() {
		return this.costeAtar;
	}

	public void setCosteAtar(int costeAtar) {
		this.costeAtar = costeAtar;
	}

	@Column(name = "COSTE_DESCONVOCAR", nullable = false)
	public int getCosteDesconvocar() {
		return this.costeDesconvocar;
	}

	public void setCosteDesconvocar(int costeDesconvocar) {
		this.costeDesconvocar = costeDesconvocar;
	}

	@Column(name = "COSTE_PUNTOS_CV", nullable = false)
	public int getCostePuntosCv() {
		return this.costePuntosCv;
	}

	public void setCostePuntosCv(int costePuntosCv) {
		this.costePuntosCv = costePuntosCv;
	}

	@Column(name = "COSTE_PROYECCION_PSIQUICA", nullable = false)
	public int getCosteProyeccionPsiquica() {
		return this.costeProyeccionPsiquica;
	}

	public void setCosteProyeccionPsiquica(int costeProyeccionPsiquica) {
		this.costeProyeccionPsiquica = costeProyeccionPsiquica;
	}

	@Column(name = "COSTE_ATLETICAS", nullable = false)
	public int getCosteAtleticas() {
		return this.costeAtleticas;
	}

	public void setCosteAtleticas(int costeAtleticas) {
		this.costeAtleticas = costeAtleticas;
	}

	@Column(name = "COSTE_SOCIALES", nullable = false)
	public int getCosteSociales() {
		return this.costeSociales;
	}

	public void setCosteSociales(int costeSociales) {
		this.costeSociales = costeSociales;
	}

	@Column(name = "COSTE_PERCEPTIVAS", nullable = false)
	public int getCostePerceptivas() {
		return this.costePerceptivas;
	}

	public void setCostePerceptivas(int costePerceptivas) {
		this.costePerceptivas = costePerceptivas;
	}

	@Column(name = "COSTE_INTELECTUALES", nullable = false)
	public int getCosteIntelectuales() {
		return this.costeIntelectuales;
	}

	public void setCosteIntelectuales(int costeIntelectuales) {
		this.costeIntelectuales = costeIntelectuales;
	}

	@Column(name = "COSTE_VIGOR", nullable = false)
	public int getCosteVigor() {
		return this.costeVigor;
	}

	public void setCosteVigor(int costeVigor) {
		this.costeVigor = costeVigor;
	}

	@Column(name = "COSTE_SUBTERFUGIO", nullable = false)
	public int getCosteSubterfugio() {
		return this.costeSubterfugio;
	}

	public void setCosteSubterfugio(int costeSubterfugio) {
		this.costeSubterfugio = costeSubterfugio;
	}

	@Column(name = "COSTE_CREATIVAS", nullable = false)
	public int getCosteCreativas() {
		return this.costeCreativas;
	}

	public void setCosteCreativas(int costeCreativas) {
		this.costeCreativas = costeCreativas;
	}

	@Column(name = "COSTE_REDUCIDO_ADVERTIR")
	public Integer getCosteReducidoAdvertir() {
		return this.costeReducidoAdvertir;
	}

	public void setCosteReducidoAdvertir(Integer costeReducidoAdvertir) {
		this.costeReducidoAdvertir = costeReducidoAdvertir;
	}

	@Column(name = "COSTE_REDUCIDO_BUSCAR")
	public Integer getCosteReducidoBuscar() {
		return this.costeReducidoBuscar;
	}

	public void setCosteReducidoBuscar(Integer costeReducidoBuscar) {
		this.costeReducidoBuscar = costeReducidoBuscar;
	}

	@Column(name = "COSTE_REDUCIDO_RASTREAR")
	public Integer getCosteReducidoRastrear() {
		return this.costeReducidoRastrear;
	}

	public void setCosteReducidoRastrear(Integer costeReducidoRastrear) {
		this.costeReducidoRastrear = costeReducidoRastrear;
	}

	@Column(name = "COSTE_REDUCIDO_TRAMPERIA")
	public Integer getCosteReducidoTramperia() {
		return this.costeReducidoTramperia;
	}

	public void setCosteReducidoTramperia(Integer costeReducidoTramperia) {
		this.costeReducidoTramperia = costeReducidoTramperia;
	}

	@Column(name = "COSTE_REDUCIDO_ANIMALES")
	public Integer getCosteReducidoAnimales() {
		return this.costeReducidoAnimales;
	}

	public void setCosteReducidoAnimales(Integer costeReducidoAnimales) {
		this.costeReducidoAnimales = costeReducidoAnimales;
	}

	@Column(name = "COSTE_REDUCIDO_HERBOLARIA")
	public Integer getCosteReducidoHerbolaria() {
		return this.costeReducidoHerbolaria;
	}

	public void setCosteReducidoHerbolaria(Integer costeReducidoHerbolaria) {
		this.costeReducidoHerbolaria = costeReducidoHerbolaria;
	}

	@Column(name = "COSTE_REDUCIDO_OCULTARSE")
	public Integer getCosteReducidoOcultarse() {
		return this.costeReducidoOcultarse;
	}

	public void setCosteReducidoOcultarse(Integer costeReducidoOcultarse) {
		this.costeReducidoOcultarse = costeReducidoOcultarse;
	}

	@Column(name = "COSTE_REDUCIDO_SIGILO")
	public Integer getCosteReducidoSigilo() {
		return this.costeReducidoSigilo;
	}

	public void setCosteReducidoSigilo(Integer costeReducidoSigilo) {
		this.costeReducidoSigilo = costeReducidoSigilo;
	}

	@Column(name = "COSTE_REDUCIDO_ROBO")
	public Integer getCosteReducidoRobo() {
		return this.costeReducidoRobo;
	}

	public void setCosteReducidoRobo(Integer costeReducidoRobo) {
		this.costeReducidoRobo = costeReducidoRobo;
	}

	@Column(name = "COSTE_REDUCIDO_VENENOS")
	public Integer getCosteReducidoVenenos() {
		return this.costeReducidoVenenos;
	}

	public void setCosteReducidoVenenos(Integer costeReducidoVenenos) {
		this.costeReducidoVenenos = costeReducidoVenenos;
	}

	@Column(name = "COSTE_REDUCIDO_VALORACION_MAGICA")
	public Integer getCosteReducidoValoracionMagica() {
		return this.costeReducidoValoracionMagica;
	}

	public void setCosteReducidoValoracionMagica(Integer costeReducidoValoracionMagica) {
		this.costeReducidoValoracionMagica = costeReducidoValoracionMagica;
	}

	@Column(name = "COSTE_REDUCIDO_OCULTISMO")
	public Integer getCosteReducidoOcultismo() {
		return this.costeReducidoOcultismo;
	}

	public void setCosteReducidoOcultismo(Integer costeReducidoOcultismo) {
		this.costeReducidoOcultismo = costeReducidoOcultismo;
	}

	@Column(name = "COSTE_REDUCIDO_DISFRAZ")
	public Integer getCosteReducidoDisfraz() {
		return this.costeReducidoDisfraz;
	}

	public void setCosteReducidoDisfraz(Integer costeReducidoDisfraz) {
		this.costeReducidoDisfraz = costeReducidoDisfraz;
	}

	@Column(name = "COSTE_REDUCIDO_PROEZA_FUERZA")
	public Integer getCosteReducidoProezaFuerza() {
		return this.costeReducidoProezaFuerza;
	}

	public void setCosteReducidoProezaFuerza(Integer costeReducidoProezaFuerza) {
		this.costeReducidoProezaFuerza = costeReducidoProezaFuerza;
	}

	@Column(name = "COSTE_REDUCIDO_ACROBACIAS")
	public Integer getCosteReducidoAcrobacias() {
		return this.costeReducidoAcrobacias;
	}

	public void setCosteReducidoAcrobacias(Integer costeReducidoAcrobacias) {
		this.costeReducidoAcrobacias = costeReducidoAcrobacias;
	}

	@Column(name = "COSTE_REDUCIDO_SALTAR")
	public Integer getCosteReducidoSaltar() {
		return this.costeReducidoSaltar;
	}

	public void setCosteReducidoSaltar(Integer costeReducidoSaltar) {
		this.costeReducidoSaltar = costeReducidoSaltar;
	}

	@Column(name = "COSTE_REDUCIDO_ATLETISMO")
	public Integer getCosteReducidoAtletismo() {
		return this.costeReducidoAtletismo;
	}

	public void setCosteReducidoAtletismo(Integer costeReducidoAtletismo) {
		this.costeReducidoAtletismo = costeReducidoAtletismo;
	}

	@Column(name = "COSTE_REDUCIDO_TRUCO_MANOS")
	public Integer getCosteReducidoTrucoManos() {
		return this.costeReducidoTrucoManos;
	}

	public void setCosteReducidoTrucoManos(Integer costeReducidoTrucoManos) {
		this.costeReducidoTrucoManos = costeReducidoTrucoManos;
	}

	@Column(name = "COSTE_REDUCIDO_ESTILO")
	public Integer getCosteReducidoEstilo() {
		return this.costeReducidoEstilo;
	}

	public void setCosteReducidoEstilo(Integer costeReducidoEstilo) {
		this.costeReducidoEstilo = costeReducidoEstilo;
	}

	@Column(name = "COSTE_REDUCIDO_LIDERAZGO")
	public Integer getCosteReducidoLiderazgo() {
		return this.costeReducidoLiderazgo;
	}

	public void setCosteReducidoLiderazgo(Integer costeReducidoLiderazgo) {
		this.costeReducidoLiderazgo = costeReducidoLiderazgo;
	}

	@Column(name = "COSTE_REDUCIDO_INTIMIDAR")
	public Integer getCosteReducidoIntimidar() {
		return this.costeReducidoIntimidar;
	}

	public void setCosteReducidoIntimidar(Integer costeReducidoIntimidar) {
		this.costeReducidoIntimidar = costeReducidoIntimidar;
	}

	@Column(name = "COSTE_REDUCIDO_PERSUASION")
	public Integer getCosteReducidoPersuasion() {
		return this.costeReducidoPersuasion;
	}

	public void setCosteReducidoPersuasion(Integer costeReducidoPersuasion) {
		this.costeReducidoPersuasion = costeReducidoPersuasion;
	}

	@Column(name = "COSTE_REDUCIDO_RESISTIR_DOLOR")
	public Integer getCosteReducidoResistirDolor() {
		return this.costeReducidoResistirDolor;
	}

	public void setCosteReducidoResistirDolor(Integer costeReducidoResistirDolor) {
		this.costeReducidoResistirDolor = costeReducidoResistirDolor;
	}

	@Column(name = "COSTE_REDUCIDO_FRIALDAD")
	public Integer getCosteReducidoFrialdad() {
		return this.costeReducidoFrialdad;
	}

	public void setCosteReducidoFrialdad(Integer costeReducidoFrialdad) {
		this.costeReducidoFrialdad = costeReducidoFrialdad;
	}

	@Column(name = "COSTE_REDUCIDO_MEDICINA")
	public Integer getCosteReducidoMedicina() {
		return this.costeReducidoMedicina;
	}

	public void setCosteReducidoMedicina(Integer costeReducidoMedicina) {
		this.costeReducidoMedicina = costeReducidoMedicina;
	}

	@Column(name = "COSTE_REDUCIDO_TASACION")
	public Integer getCosteReducidoTasacion() {
		return this.costeReducidoTasacion;
	}

	public void setCosteReducidoTasacion(Integer costeReducidoTasacion) {
		this.costeReducidoTasacion = costeReducidoTasacion;
	}

	@Column(name = "COSTE_REDUCIDO_MEMORIZAR")
	public Integer getCosteReducidoMemorizar() {
		return this.costeReducidoMemorizar;
	}

	public void setCosteReducidoMemorizar(Integer costeReducidoMemorizar) {
		this.costeReducidoMemorizar = costeReducidoMemorizar;
	}

	@Column(name = "IMAGEN", length = 50)
	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria")
	public Set<Personaje> getPersonajes() {
		return this.personajes;
	}

	public void setPersonajes(Set<Personaje> personajes) {
		this.personajes = personajes;
	}

}
