package modelo;
// Generated 13 jun. 2021 23:25:16 by Hibernate Tools 5.2.12.Final

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
 * PdsCategoria generated by hbm2java
 */
@Entity
@Table(name = "pds_categoria", catalog = "anima_sheets_data")
public class PdsCategoria implements java.io.Serializable {

	private PdsCategoriaId id;
	private Categoria categoria;
	private Lv lv;
	private PdsPrimariasComunes pdsPrimariasComunes;
	private PdsPrimariasKi pdsPrimariasKi;
	private PdsPrimariasMisticas pdsPrimariasMisticas;
	private PdsPrimariasPatronesPsiquicos pdsPrimariasPatronesPsiquicos;
	private PdsPrimariasPsiquicas pdsPrimariasPsiquicas;
	private PdsPrimariasTablasComunes pdsPrimariasTablasComunes;
	private PdsSecundariasAtleticas pdsSecundariasAtleticas;
	private PdsSecundariasCreativas pdsSecundariasCreativas;
	private PdsSecundariasIntelectuales pdsSecundariasIntelectuales;
	private PdsSecundariasPerceptivas pdsSecundariasPerceptivas;
	private PdsSecundariasSociales pdsSecundariasSociales;
	private PdsSecundariasSubterfugio pdsSecundariasSubterfugio;
	private PdsSecundariasVigor pdsSecundariasVigor;
	private Integer pdsMultiploVida;
	private Integer pdsCambioCategoria1;
	private Integer pdsCambioCategoria2;
	private Integer pdsCambioCategoria3;
	private Integer pdsCambioCategoria4;

	public PdsCategoria() {
	}

	public PdsCategoria(PdsCategoriaId id, Categoria categoria, Lv lv, PdsPrimariasComunes pdsPrimariasComunes,
			PdsPrimariasKi pdsPrimariasKi, PdsPrimariasMisticas pdsPrimariasMisticas,
			PdsPrimariasPatronesPsiquicos pdsPrimariasPatronesPsiquicos, PdsPrimariasPsiquicas pdsPrimariasPsiquicas,
			PdsPrimariasTablasComunes pdsPrimariasTablasComunes, PdsSecundariasAtleticas pdsSecundariasAtleticas,
			PdsSecundariasCreativas pdsSecundariasCreativas, PdsSecundariasIntelectuales pdsSecundariasIntelectuales,
			PdsSecundariasPerceptivas pdsSecundariasPerceptivas, PdsSecundariasSociales pdsSecundariasSociales,
			PdsSecundariasSubterfugio pdsSecundariasSubterfugio, PdsSecundariasVigor pdsSecundariasVigor) {
		this.id = id;
		this.categoria = categoria;
		this.lv = lv;
		this.pdsPrimariasComunes = pdsPrimariasComunes;
		this.pdsPrimariasKi = pdsPrimariasKi;
		this.pdsPrimariasMisticas = pdsPrimariasMisticas;
		this.pdsPrimariasPatronesPsiquicos = pdsPrimariasPatronesPsiquicos;
		this.pdsPrimariasPsiquicas = pdsPrimariasPsiquicas;
		this.pdsPrimariasTablasComunes = pdsPrimariasTablasComunes;
		this.pdsSecundariasAtleticas = pdsSecundariasAtleticas;
		this.pdsSecundariasCreativas = pdsSecundariasCreativas;
		this.pdsSecundariasIntelectuales = pdsSecundariasIntelectuales;
		this.pdsSecundariasPerceptivas = pdsSecundariasPerceptivas;
		this.pdsSecundariasSociales = pdsSecundariasSociales;
		this.pdsSecundariasSubterfugio = pdsSecundariasSubterfugio;
		this.pdsSecundariasVigor = pdsSecundariasVigor;
	}

	public PdsCategoria(PdsCategoriaId id, Categoria categoria, Lv lv, PdsPrimariasComunes pdsPrimariasComunes,
			PdsPrimariasKi pdsPrimariasKi, PdsPrimariasMisticas pdsPrimariasMisticas,
			PdsPrimariasPatronesPsiquicos pdsPrimariasPatronesPsiquicos, PdsPrimariasPsiquicas pdsPrimariasPsiquicas,
			PdsPrimariasTablasComunes pdsPrimariasTablasComunes, PdsSecundariasAtleticas pdsSecundariasAtleticas,
			PdsSecundariasCreativas pdsSecundariasCreativas, PdsSecundariasIntelectuales pdsSecundariasIntelectuales,
			PdsSecundariasPerceptivas pdsSecundariasPerceptivas, PdsSecundariasSociales pdsSecundariasSociales,
			PdsSecundariasSubterfugio pdsSecundariasSubterfugio, PdsSecundariasVigor pdsSecundariasVigor,
			Integer pdsMultiploVida, Integer pdsCambioCategoria1, Integer pdsCambioCategoria2,
			Integer pdsCambioCategoria3, Integer pdsCambioCategoria4) {
		this.id = id;
		this.categoria = categoria;
		this.lv = lv;
		this.pdsPrimariasComunes = pdsPrimariasComunes;
		this.pdsPrimariasKi = pdsPrimariasKi;
		this.pdsPrimariasMisticas = pdsPrimariasMisticas;
		this.pdsPrimariasPatronesPsiquicos = pdsPrimariasPatronesPsiquicos;
		this.pdsPrimariasPsiquicas = pdsPrimariasPsiquicas;
		this.pdsPrimariasTablasComunes = pdsPrimariasTablasComunes;
		this.pdsSecundariasAtleticas = pdsSecundariasAtleticas;
		this.pdsSecundariasCreativas = pdsSecundariasCreativas;
		this.pdsSecundariasIntelectuales = pdsSecundariasIntelectuales;
		this.pdsSecundariasPerceptivas = pdsSecundariasPerceptivas;
		this.pdsSecundariasSociales = pdsSecundariasSociales;
		this.pdsSecundariasSubterfugio = pdsSecundariasSubterfugio;
		this.pdsSecundariasVigor = pdsSecundariasVigor;
		this.pdsMultiploVida = pdsMultiploVida;
		this.pdsCambioCategoria1 = pdsCambioCategoria1;
		this.pdsCambioCategoria2 = pdsCambioCategoria2;
		this.pdsCambioCategoria3 = pdsCambioCategoria3;
		this.pdsCambioCategoria4 = pdsCambioCategoria4;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "idCategoria", column = @Column(name = "ID_CATEGORIA", nullable = false)),
			@AttributeOverride(name = "idPersonaje", column = @Column(name = "ID_PERSONAJE", nullable = false)),
			@AttributeOverride(name = "pdsPrimariasComunes", column = @Column(name = "PDS_PRIMARIAS_COMUNES", nullable = false)),
			@AttributeOverride(name = "pdsPrimariasKi", column = @Column(name = "PDS_PRIMARIAS_KI", nullable = false)),
			@AttributeOverride(name = "pdsPrimariasTablasComunes", column = @Column(name = "PDS_PRIMARIAS_TABLAS_COMUNES", nullable = false)),
			@AttributeOverride(name = "pdsPrimariasMisticas", column = @Column(name = "PDS_PRIMARIAS_MISTICAS", nullable = false)),
			@AttributeOverride(name = "pdsPrimariasPsiquicas", column = @Column(name = "PDS_PRIMARIAS_PSIQUICAS", nullable = false)),
			@AttributeOverride(name = "pdsPrimariasPatronesPsiquicos", column = @Column(name = "PDS_PRIMARIAS_PATRONES_PSIQUICOS", nullable = false)),
			@AttributeOverride(name = "pdsSecundariasAtleticas", column = @Column(name = "PDS_SECUNDARIAS_ATLETICAS", nullable = false)),
			@AttributeOverride(name = "pdsSecundariasSociales", column = @Column(name = "PDS_SECUNDARIAS_SOCIALES", nullable = false)),
			@AttributeOverride(name = "pdsSecundariasPerceptivas", column = @Column(name = "PDS_SECUNDARIAS_PERCEPTIVAS", nullable = false)),
			@AttributeOverride(name = "pdsSecundariasIntelectuales", column = @Column(name = "PDS_SECUNDARIAS_INTELECTUALES", nullable = false)),
			@AttributeOverride(name = "pdsSecundariasVigor", column = @Column(name = "PDS_SECUNDARIAS_VIGOR", nullable = false)),
			@AttributeOverride(name = "pdsSecundariasSubterfugio", column = @Column(name = "PDS_SECUNDARIAS_SUBTERFUGIO", nullable = false)),
			@AttributeOverride(name = "pdsSecundariasCreativas", column = @Column(name = "PDS_SECUNDARIAS_CREATIVAS", nullable = false)) })
	public PdsCategoriaId getId() {
		return this.id;
	}

	public void setId(PdsCategoriaId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CATEGORIA", nullable = false, insertable = false, updatable = false)
	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PERSONAJE", nullable = false, insertable = false, updatable = false)
	public Lv getLv() {
		return this.lv;
	}

	public void setLv(Lv lv) {
		this.lv = lv;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PDS_PRIMARIAS_COMUNES", nullable = false, insertable = false, updatable = false)
	public PdsPrimariasComunes getPdsPrimariasComunes() {
		return this.pdsPrimariasComunes;
	}

	public void setPdsPrimariasComunes(PdsPrimariasComunes pdsPrimariasComunes) {
		this.pdsPrimariasComunes = pdsPrimariasComunes;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PDS_PRIMARIAS_KI", nullable = false, insertable = false, updatable = false)
	public PdsPrimariasKi getPdsPrimariasKi() {
		return this.pdsPrimariasKi;
	}

	public void setPdsPrimariasKi(PdsPrimariasKi pdsPrimariasKi) {
		this.pdsPrimariasKi = pdsPrimariasKi;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PDS_PRIMARIAS_MISTICAS", nullable = false, insertable = false, updatable = false)
	public PdsPrimariasMisticas getPdsPrimariasMisticas() {
		return this.pdsPrimariasMisticas;
	}

	public void setPdsPrimariasMisticas(PdsPrimariasMisticas pdsPrimariasMisticas) {
		this.pdsPrimariasMisticas = pdsPrimariasMisticas;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PDS_PRIMARIAS_PATRONES_PSIQUICOS", nullable = false, insertable = false, updatable = false)
	public PdsPrimariasPatronesPsiquicos getPdsPrimariasPatronesPsiquicos() {
		return this.pdsPrimariasPatronesPsiquicos;
	}

	public void setPdsPrimariasPatronesPsiquicos(PdsPrimariasPatronesPsiquicos pdsPrimariasPatronesPsiquicos) {
		this.pdsPrimariasPatronesPsiquicos = pdsPrimariasPatronesPsiquicos;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PDS_PRIMARIAS_PSIQUICAS", nullable = false, insertable = false, updatable = false)
	public PdsPrimariasPsiquicas getPdsPrimariasPsiquicas() {
		return this.pdsPrimariasPsiquicas;
	}

	public void setPdsPrimariasPsiquicas(PdsPrimariasPsiquicas pdsPrimariasPsiquicas) {
		this.pdsPrimariasPsiquicas = pdsPrimariasPsiquicas;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PDS_PRIMARIAS_TABLAS_COMUNES", nullable = false, insertable = false, updatable = false)
	public PdsPrimariasTablasComunes getPdsPrimariasTablasComunes() {
		return this.pdsPrimariasTablasComunes;
	}

	public void setPdsPrimariasTablasComunes(PdsPrimariasTablasComunes pdsPrimariasTablasComunes) {
		this.pdsPrimariasTablasComunes = pdsPrimariasTablasComunes;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PDS_SECUNDARIAS_ATLETICAS", nullable = false, insertable = false, updatable = false)
	public PdsSecundariasAtleticas getPdsSecundariasAtleticas() {
		return this.pdsSecundariasAtleticas;
	}

	public void setPdsSecundariasAtleticas(PdsSecundariasAtleticas pdsSecundariasAtleticas) {
		this.pdsSecundariasAtleticas = pdsSecundariasAtleticas;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PDS_SECUNDARIAS_CREATIVAS", nullable = false, insertable = false, updatable = false)
	public PdsSecundariasCreativas getPdsSecundariasCreativas() {
		return this.pdsSecundariasCreativas;
	}

	public void setPdsSecundariasCreativas(PdsSecundariasCreativas pdsSecundariasCreativas) {
		this.pdsSecundariasCreativas = pdsSecundariasCreativas;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PDS_SECUNDARIAS_INTELECTUALES", nullable = false, insertable = false, updatable = false)
	public PdsSecundariasIntelectuales getPdsSecundariasIntelectuales() {
		return this.pdsSecundariasIntelectuales;
	}

	public void setPdsSecundariasIntelectuales(PdsSecundariasIntelectuales pdsSecundariasIntelectuales) {
		this.pdsSecundariasIntelectuales = pdsSecundariasIntelectuales;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PDS_SECUNDARIAS_PERCEPTIVAS", nullable = false, insertable = false, updatable = false)
	public PdsSecundariasPerceptivas getPdsSecundariasPerceptivas() {
		return this.pdsSecundariasPerceptivas;
	}

	public void setPdsSecundariasPerceptivas(PdsSecundariasPerceptivas pdsSecundariasPerceptivas) {
		this.pdsSecundariasPerceptivas = pdsSecundariasPerceptivas;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PDS_SECUNDARIAS_SOCIALES", nullable = false, insertable = false, updatable = false)
	public PdsSecundariasSociales getPdsSecundariasSociales() {
		return this.pdsSecundariasSociales;
	}

	public void setPdsSecundariasSociales(PdsSecundariasSociales pdsSecundariasSociales) {
		this.pdsSecundariasSociales = pdsSecundariasSociales;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PDS_SECUNDARIAS_SUBTERFUGIO", nullable = false, insertable = false, updatable = false)
	public PdsSecundariasSubterfugio getPdsSecundariasSubterfugio() {
		return this.pdsSecundariasSubterfugio;
	}

	public void setPdsSecundariasSubterfugio(PdsSecundariasSubterfugio pdsSecundariasSubterfugio) {
		this.pdsSecundariasSubterfugio = pdsSecundariasSubterfugio;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PDS_SECUNDARIAS_VIGOR", nullable = false, insertable = false, updatable = false)
	public PdsSecundariasVigor getPdsSecundariasVigor() {
		return this.pdsSecundariasVigor;
	}

	public void setPdsSecundariasVigor(PdsSecundariasVigor pdsSecundariasVigor) {
		this.pdsSecundariasVigor = pdsSecundariasVigor;
	}

	@Column(name = "PDS_MULTIPLO_VIDA")
	public Integer getPdsMultiploVida() {
		return this.pdsMultiploVida;
	}

	public void setPdsMultiploVida(Integer pdsMultiploVida) {
		this.pdsMultiploVida = pdsMultiploVida;
	}

	@Column(name = "PDS_CAMBIO_CATEGORIA1")
	public Integer getPdsCambioCategoria1() {
		return this.pdsCambioCategoria1;
	}

	public void setPdsCambioCategoria1(Integer pdsCambioCategoria1) {
		this.pdsCambioCategoria1 = pdsCambioCategoria1;
	}

	@Column(name = "PDS_CAMBIO_CATEGORIA2")
	public Integer getPdsCambioCategoria2() {
		return this.pdsCambioCategoria2;
	}

	public void setPdsCambioCategoria2(Integer pdsCambioCategoria2) {
		this.pdsCambioCategoria2 = pdsCambioCategoria2;
	}

	@Column(name = "PDS_CAMBIO_CATEGORIA3")
	public Integer getPdsCambioCategoria3() {
		return this.pdsCambioCategoria3;
	}

	public void setPdsCambioCategoria3(Integer pdsCambioCategoria3) {
		this.pdsCambioCategoria3 = pdsCambioCategoria3;
	}

	@Column(name = "PDS_CAMBIO_CATEGORIA4")
	public Integer getPdsCambioCategoria4() {
		return this.pdsCambioCategoria4;
	}

	public void setPdsCambioCategoria4(Integer pdsCambioCategoria4) {
		this.pdsCambioCategoria4 = pdsCambioCategoria4;
	}

}
