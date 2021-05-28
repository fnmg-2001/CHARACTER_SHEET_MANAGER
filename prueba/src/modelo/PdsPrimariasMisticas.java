package modelo;
// Generated 24 may. 2021 13:40:54 by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * PdsPrimariasMisticas generated by hbm2java
 */
@Entity
@Table(name = "pds_primarias_misticas", catalog = "anima_sheets_data")
public class PdsPrimariasMisticas implements java.io.Serializable {

	private int pdsPrimariasMisticas;
	private Integer pdsZeon;
	private Integer pdsAct;
	private Integer pdsMultiploRegeneracion;
	private Integer pdsProyeccionMagica;
	private Integer pdsLvMagia;
	private Integer pdsConvocar;
	private Integer pdsControlar;
	private Integer pdsDesconvocar;
	private Integer pdsEspZeon;
	private Integer pdsEspAct;
	private Integer pdsEspMultiploRegeneracion;
	private Integer pdsEspProyeccionMagica;
	private Integer pdsEspLvMagia;
	private Integer pdsEspConvocar;
	private Integer pdsEspControlar;
	private Integer pdsEspDesconvocar;
	private Integer pdsTablaMistico1;
	private Integer pdsTablaMistico2;
	private Set<PdsCategoria> pdsCategorias = new HashSet<PdsCategoria>(0);

	public PdsPrimariasMisticas() {
	}

	public PdsPrimariasMisticas(int pdsPrimariasMisticas) {
		this.pdsPrimariasMisticas = pdsPrimariasMisticas;
	}

	public PdsPrimariasMisticas(int pdsPrimariasMisticas, Integer pdsZeon, Integer pdsAct,
			Integer pdsMultiploRegeneracion, Integer pdsProyeccionMagica, Integer pdsLvMagia, Integer pdsConvocar,
			Integer pdsControlar, Integer pdsDesconvocar, Integer pdsEspZeon, Integer pdsEspAct,
			Integer pdsEspMultiploRegeneracion, Integer pdsEspProyeccionMagica, Integer pdsEspLvMagia,
			Integer pdsEspConvocar, Integer pdsEspControlar, Integer pdsEspDesconvocar, Integer pdsTablaMistico1,
			Integer pdsTablaMistico2, Set<PdsCategoria> pdsCategorias) {
		this.pdsPrimariasMisticas = pdsPrimariasMisticas;
		this.pdsZeon = pdsZeon;
		this.pdsAct = pdsAct;
		this.pdsMultiploRegeneracion = pdsMultiploRegeneracion;
		this.pdsProyeccionMagica = pdsProyeccionMagica;
		this.pdsLvMagia = pdsLvMagia;
		this.pdsConvocar = pdsConvocar;
		this.pdsControlar = pdsControlar;
		this.pdsDesconvocar = pdsDesconvocar;
		this.pdsEspZeon = pdsEspZeon;
		this.pdsEspAct = pdsEspAct;
		this.pdsEspMultiploRegeneracion = pdsEspMultiploRegeneracion;
		this.pdsEspProyeccionMagica = pdsEspProyeccionMagica;
		this.pdsEspLvMagia = pdsEspLvMagia;
		this.pdsEspConvocar = pdsEspConvocar;
		this.pdsEspControlar = pdsEspControlar;
		this.pdsEspDesconvocar = pdsEspDesconvocar;
		this.pdsTablaMistico1 = pdsTablaMistico1;
		this.pdsTablaMistico2 = pdsTablaMistico2;
		this.pdsCategorias = pdsCategorias;
	}

	@Id

	@Column(name = "PDS_PRIMARIAS_MISTICAS", unique = true, nullable = false)
	public int getPdsPrimariasMisticas() {
		return this.pdsPrimariasMisticas;
	}

	public void setPdsPrimariasMisticas(int pdsPrimariasMisticas) {
		this.pdsPrimariasMisticas = pdsPrimariasMisticas;
	}

	@Column(name = "PDS_ZEON")
	public Integer getPdsZeon() {
		return this.pdsZeon;
	}

	public void setPdsZeon(Integer pdsZeon) {
		this.pdsZeon = pdsZeon;
	}

	@Column(name = "PDS_ACT")
	public Integer getPdsAct() {
		return this.pdsAct;
	}

	public void setPdsAct(Integer pdsAct) {
		this.pdsAct = pdsAct;
	}

	@Column(name = "PDS_MULTIPLO_REGENERACION")
	public Integer getPdsMultiploRegeneracion() {
		return this.pdsMultiploRegeneracion;
	}

	public void setPdsMultiploRegeneracion(Integer pdsMultiploRegeneracion) {
		this.pdsMultiploRegeneracion = pdsMultiploRegeneracion;
	}

	@Column(name = "PDS_PROYECCION_MAGICA")
	public Integer getPdsProyeccionMagica() {
		return this.pdsProyeccionMagica;
	}

	public void setPdsProyeccionMagica(Integer pdsProyeccionMagica) {
		this.pdsProyeccionMagica = pdsProyeccionMagica;
	}

	@Column(name = "PDS_LV_MAGIA")
	public Integer getPdsLvMagia() {
		return this.pdsLvMagia;
	}

	public void setPdsLvMagia(Integer pdsLvMagia) {
		this.pdsLvMagia = pdsLvMagia;
	}

	@Column(name = "PDS_CONVOCAR")
	public Integer getPdsConvocar() {
		return this.pdsConvocar;
	}

	public void setPdsConvocar(Integer pdsConvocar) {
		this.pdsConvocar = pdsConvocar;
	}

	@Column(name = "PDS_CONTROLAR")
	public Integer getPdsControlar() {
		return this.pdsControlar;
	}

	public void setPdsControlar(Integer pdsControlar) {
		this.pdsControlar = pdsControlar;
	}

	@Column(name = "PDS_DESCONVOCAR")
	public Integer getPdsDesconvocar() {
		return this.pdsDesconvocar;
	}

	public void setPdsDesconvocar(Integer pdsDesconvocar) {
		this.pdsDesconvocar = pdsDesconvocar;
	}

	@Column(name = "PDS_ESP_ZEON")
	public Integer getPdsEspZeon() {
		return this.pdsEspZeon;
	}

	public void setPdsEspZeon(Integer pdsEspZeon) {
		this.pdsEspZeon = pdsEspZeon;
	}

	@Column(name = "PDS_ESP_ACT")
	public Integer getPdsEspAct() {
		return this.pdsEspAct;
	}

	public void setPdsEspAct(Integer pdsEspAct) {
		this.pdsEspAct = pdsEspAct;
	}

	@Column(name = "PDS_ESP_MULTIPLO_REGENERACION")
	public Integer getPdsEspMultiploRegeneracion() {
		return this.pdsEspMultiploRegeneracion;
	}

	public void setPdsEspMultiploRegeneracion(Integer pdsEspMultiploRegeneracion) {
		this.pdsEspMultiploRegeneracion = pdsEspMultiploRegeneracion;
	}

	@Column(name = "PDS_ESP_PROYECCION_MAGICA")
	public Integer getPdsEspProyeccionMagica() {
		return this.pdsEspProyeccionMagica;
	}

	public void setPdsEspProyeccionMagica(Integer pdsEspProyeccionMagica) {
		this.pdsEspProyeccionMagica = pdsEspProyeccionMagica;
	}

	@Column(name = "PDS_ESP_LV_MAGIA")
	public Integer getPdsEspLvMagia() {
		return this.pdsEspLvMagia;
	}

	public void setPdsEspLvMagia(Integer pdsEspLvMagia) {
		this.pdsEspLvMagia = pdsEspLvMagia;
	}

	@Column(name = "PDS_ESP_CONVOCAR")
	public Integer getPdsEspConvocar() {
		return this.pdsEspConvocar;
	}

	public void setPdsEspConvocar(Integer pdsEspConvocar) {
		this.pdsEspConvocar = pdsEspConvocar;
	}

	@Column(name = "PDS_ESP_CONTROLAR")
	public Integer getPdsEspControlar() {
		return this.pdsEspControlar;
	}

	public void setPdsEspControlar(Integer pdsEspControlar) {
		this.pdsEspControlar = pdsEspControlar;
	}

	@Column(name = "PDS_ESP_DESCONVOCAR")
	public Integer getPdsEspDesconvocar() {
		return this.pdsEspDesconvocar;
	}

	public void setPdsEspDesconvocar(Integer pdsEspDesconvocar) {
		this.pdsEspDesconvocar = pdsEspDesconvocar;
	}

	@Column(name = "PDS_TABLA_MISTICO1")
	public Integer getPdsTablaMistico1() {
		return this.pdsTablaMistico1;
	}

	public void setPdsTablaMistico1(Integer pdsTablaMistico1) {
		this.pdsTablaMistico1 = pdsTablaMistico1;
	}

	@Column(name = "PDS_TABLA_MISTICO2")
	public Integer getPdsTablaMistico2() {
		return this.pdsTablaMistico2;
	}

	public void setPdsTablaMistico2(Integer pdsTablaMistico2) {
		this.pdsTablaMistico2 = pdsTablaMistico2;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pdsPrimariasMisticas")
	public Set<PdsCategoria> getPdsCategorias() {
		return this.pdsCategorias;
	}

	public void setPdsCategorias(Set<PdsCategoria> pdsCategorias) {
		this.pdsCategorias = pdsCategorias;
	}

}
