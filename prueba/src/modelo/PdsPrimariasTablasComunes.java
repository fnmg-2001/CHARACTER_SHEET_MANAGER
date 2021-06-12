package modelo;
// Generated 12 jun. 2021 20:12:54 by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * PdsPrimariasTablasComunes generated by hbm2java
 */
@Entity
@Table(name = "pds_primarias_tablas_comunes", catalog = "anima_sheets_data")
public class PdsPrimariasTablasComunes implements java.io.Serializable {

	private int pdsPrimariasTablasComunes;
	private Integer pdsTablaArma1;
	private Integer pdsTablaArma2;
	private Integer pdsTablaArma3;
	private Integer pdsTablaArma4;
	private Integer pdsTablaArma5;
	private Integer pdsTablaEstilo1;
	private Integer pdsTablaEstilo2;
	private Integer pdsTablaEstilo3;
	private Integer pdsTablaEstilo4;
	private Integer pdsTablaEstilo5;
	private Integer pdsTablaEstilo6;
	private Integer pdsTablaArteMarcial1;
	private Integer pdsTablaArteMarcial2;
	private Integer pdsTablaArteMarcial3;
	private Integer pdsTablaArteMarcial4;
	private Integer pdsTablaArteMarcial5;
	private Integer pdsTablaArteMarcial6;
	private Integer pdsTablaArteMarcial7;
	private Integer pdsTablaArteMarcial8;
	private Integer pdsTablaArgMagnus1;
	private Integer pdsTablaArgMagnus2;
	private Integer pdsTablaArgMagnus3;
	private Integer pdsTablaArgMagnus4;
	private Integer pdsTablaArgMagnus5;
	private Set<PdsCategoria> pdsCategorias = new HashSet<PdsCategoria>(0);

	public PdsPrimariasTablasComunes() {
	}

	public PdsPrimariasTablasComunes(int pdsPrimariasTablasComunes) {
		this.pdsPrimariasTablasComunes = pdsPrimariasTablasComunes;
	}

	public PdsPrimariasTablasComunes(int pdsPrimariasTablasComunes, Integer pdsTablaArma1, Integer pdsTablaArma2,
			Integer pdsTablaArma3, Integer pdsTablaArma4, Integer pdsTablaArma5, Integer pdsTablaEstilo1,
			Integer pdsTablaEstilo2, Integer pdsTablaEstilo3, Integer pdsTablaEstilo4, Integer pdsTablaEstilo5,
			Integer pdsTablaEstilo6, Integer pdsTablaArteMarcial1, Integer pdsTablaArteMarcial2,
			Integer pdsTablaArteMarcial3, Integer pdsTablaArteMarcial4, Integer pdsTablaArteMarcial5,
			Integer pdsTablaArteMarcial6, Integer pdsTablaArteMarcial7, Integer pdsTablaArteMarcial8,
			Integer pdsTablaArgMagnus1, Integer pdsTablaArgMagnus2, Integer pdsTablaArgMagnus3,
			Integer pdsTablaArgMagnus4, Integer pdsTablaArgMagnus5, Set<PdsCategoria> pdsCategorias) {
		this.pdsPrimariasTablasComunes = pdsPrimariasTablasComunes;
		this.pdsTablaArma1 = pdsTablaArma1;
		this.pdsTablaArma2 = pdsTablaArma2;
		this.pdsTablaArma3 = pdsTablaArma3;
		this.pdsTablaArma4 = pdsTablaArma4;
		this.pdsTablaArma5 = pdsTablaArma5;
		this.pdsTablaEstilo1 = pdsTablaEstilo1;
		this.pdsTablaEstilo2 = pdsTablaEstilo2;
		this.pdsTablaEstilo3 = pdsTablaEstilo3;
		this.pdsTablaEstilo4 = pdsTablaEstilo4;
		this.pdsTablaEstilo5 = pdsTablaEstilo5;
		this.pdsTablaEstilo6 = pdsTablaEstilo6;
		this.pdsTablaArteMarcial1 = pdsTablaArteMarcial1;
		this.pdsTablaArteMarcial2 = pdsTablaArteMarcial2;
		this.pdsTablaArteMarcial3 = pdsTablaArteMarcial3;
		this.pdsTablaArteMarcial4 = pdsTablaArteMarcial4;
		this.pdsTablaArteMarcial5 = pdsTablaArteMarcial5;
		this.pdsTablaArteMarcial6 = pdsTablaArteMarcial6;
		this.pdsTablaArteMarcial7 = pdsTablaArteMarcial7;
		this.pdsTablaArteMarcial8 = pdsTablaArteMarcial8;
		this.pdsTablaArgMagnus1 = pdsTablaArgMagnus1;
		this.pdsTablaArgMagnus2 = pdsTablaArgMagnus2;
		this.pdsTablaArgMagnus3 = pdsTablaArgMagnus3;
		this.pdsTablaArgMagnus4 = pdsTablaArgMagnus4;
		this.pdsTablaArgMagnus5 = pdsTablaArgMagnus5;
		this.pdsCategorias = pdsCategorias;
	}

	@Id

	@Column(name = "PDS_PRIMARIAS_TABLAS_COMUNES", unique = true, nullable = false)
	public int getPdsPrimariasTablasComunes() {
		return this.pdsPrimariasTablasComunes;
	}

	public void setPdsPrimariasTablasComunes(int pdsPrimariasTablasComunes) {
		this.pdsPrimariasTablasComunes = pdsPrimariasTablasComunes;
	}

	@Column(name = "PDS_TABLA_ARMA1")
	public Integer getPdsTablaArma1() {
		return this.pdsTablaArma1;
	}

	public void setPdsTablaArma1(Integer pdsTablaArma1) {
		this.pdsTablaArma1 = pdsTablaArma1;
	}

	@Column(name = "PDS_TABLA_ARMA2")
	public Integer getPdsTablaArma2() {
		return this.pdsTablaArma2;
	}

	public void setPdsTablaArma2(Integer pdsTablaArma2) {
		this.pdsTablaArma2 = pdsTablaArma2;
	}

	@Column(name = "PDS_TABLA_ARMA3")
	public Integer getPdsTablaArma3() {
		return this.pdsTablaArma3;
	}

	public void setPdsTablaArma3(Integer pdsTablaArma3) {
		this.pdsTablaArma3 = pdsTablaArma3;
	}

	@Column(name = "PDS_TABLA_ARMA4")
	public Integer getPdsTablaArma4() {
		return this.pdsTablaArma4;
	}

	public void setPdsTablaArma4(Integer pdsTablaArma4) {
		this.pdsTablaArma4 = pdsTablaArma4;
	}

	@Column(name = "PDS_TABLA_ARMA5")
	public Integer getPdsTablaArma5() {
		return this.pdsTablaArma5;
	}

	public void setPdsTablaArma5(Integer pdsTablaArma5) {
		this.pdsTablaArma5 = pdsTablaArma5;
	}

	@Column(name = "PDS_TABLA_ESTILO1")
	public Integer getPdsTablaEstilo1() {
		return this.pdsTablaEstilo1;
	}

	public void setPdsTablaEstilo1(Integer pdsTablaEstilo1) {
		this.pdsTablaEstilo1 = pdsTablaEstilo1;
	}

	@Column(name = "PDS_TABLA_ESTILO2")
	public Integer getPdsTablaEstilo2() {
		return this.pdsTablaEstilo2;
	}

	public void setPdsTablaEstilo2(Integer pdsTablaEstilo2) {
		this.pdsTablaEstilo2 = pdsTablaEstilo2;
	}

	@Column(name = "PDS_TABLA_ESTILO3")
	public Integer getPdsTablaEstilo3() {
		return this.pdsTablaEstilo3;
	}

	public void setPdsTablaEstilo3(Integer pdsTablaEstilo3) {
		this.pdsTablaEstilo3 = pdsTablaEstilo3;
	}

	@Column(name = "PDS_TABLA_ESTILO4")
	public Integer getPdsTablaEstilo4() {
		return this.pdsTablaEstilo4;
	}

	public void setPdsTablaEstilo4(Integer pdsTablaEstilo4) {
		this.pdsTablaEstilo4 = pdsTablaEstilo4;
	}

	@Column(name = "PDS_TABLA_ESTILO5")
	public Integer getPdsTablaEstilo5() {
		return this.pdsTablaEstilo5;
	}

	public void setPdsTablaEstilo5(Integer pdsTablaEstilo5) {
		this.pdsTablaEstilo5 = pdsTablaEstilo5;
	}

	@Column(name = "PDS_TABLA_ESTILO6")
	public Integer getPdsTablaEstilo6() {
		return this.pdsTablaEstilo6;
	}

	public void setPdsTablaEstilo6(Integer pdsTablaEstilo6) {
		this.pdsTablaEstilo6 = pdsTablaEstilo6;
	}

	@Column(name = "PDS_TABLA_ARTE_MARCIAL1")
	public Integer getPdsTablaArteMarcial1() {
		return this.pdsTablaArteMarcial1;
	}

	public void setPdsTablaArteMarcial1(Integer pdsTablaArteMarcial1) {
		this.pdsTablaArteMarcial1 = pdsTablaArteMarcial1;
	}

	@Column(name = "PDS_TABLA_ARTE_MARCIAL2")
	public Integer getPdsTablaArteMarcial2() {
		return this.pdsTablaArteMarcial2;
	}

	public void setPdsTablaArteMarcial2(Integer pdsTablaArteMarcial2) {
		this.pdsTablaArteMarcial2 = pdsTablaArteMarcial2;
	}

	@Column(name = "PDS_TABLA_ARTE_MARCIAL3")
	public Integer getPdsTablaArteMarcial3() {
		return this.pdsTablaArteMarcial3;
	}

	public void setPdsTablaArteMarcial3(Integer pdsTablaArteMarcial3) {
		this.pdsTablaArteMarcial3 = pdsTablaArteMarcial3;
	}

	@Column(name = "PDS_TABLA_ARTE_MARCIAL4")
	public Integer getPdsTablaArteMarcial4() {
		return this.pdsTablaArteMarcial4;
	}

	public void setPdsTablaArteMarcial4(Integer pdsTablaArteMarcial4) {
		this.pdsTablaArteMarcial4 = pdsTablaArteMarcial4;
	}

	@Column(name = "PDS_TABLA_ARTE_MARCIAL5")
	public Integer getPdsTablaArteMarcial5() {
		return this.pdsTablaArteMarcial5;
	}

	public void setPdsTablaArteMarcial5(Integer pdsTablaArteMarcial5) {
		this.pdsTablaArteMarcial5 = pdsTablaArteMarcial5;
	}

	@Column(name = "PDS_TABLA_ARTE_MARCIAL6")
	public Integer getPdsTablaArteMarcial6() {
		return this.pdsTablaArteMarcial6;
	}

	public void setPdsTablaArteMarcial6(Integer pdsTablaArteMarcial6) {
		this.pdsTablaArteMarcial6 = pdsTablaArteMarcial6;
	}

	@Column(name = "PDS_TABLA_ARTE_MARCIAL7")
	public Integer getPdsTablaArteMarcial7() {
		return this.pdsTablaArteMarcial7;
	}

	public void setPdsTablaArteMarcial7(Integer pdsTablaArteMarcial7) {
		this.pdsTablaArteMarcial7 = pdsTablaArteMarcial7;
	}

	@Column(name = "PDS_TABLA_ARTE_MARCIAL8")
	public Integer getPdsTablaArteMarcial8() {
		return this.pdsTablaArteMarcial8;
	}

	public void setPdsTablaArteMarcial8(Integer pdsTablaArteMarcial8) {
		this.pdsTablaArteMarcial8 = pdsTablaArteMarcial8;
	}

	@Column(name = "PDS_TABLA_ARG_MAGNUS1")
	public Integer getPdsTablaArgMagnus1() {
		return this.pdsTablaArgMagnus1;
	}

	public void setPdsTablaArgMagnus1(Integer pdsTablaArgMagnus1) {
		this.pdsTablaArgMagnus1 = pdsTablaArgMagnus1;
	}

	@Column(name = "PDS_TABLA_ARG_MAGNUS2")
	public Integer getPdsTablaArgMagnus2() {
		return this.pdsTablaArgMagnus2;
	}

	public void setPdsTablaArgMagnus2(Integer pdsTablaArgMagnus2) {
		this.pdsTablaArgMagnus2 = pdsTablaArgMagnus2;
	}

	@Column(name = "PDS_TABLA_ARG_MAGNUS3")
	public Integer getPdsTablaArgMagnus3() {
		return this.pdsTablaArgMagnus3;
	}

	public void setPdsTablaArgMagnus3(Integer pdsTablaArgMagnus3) {
		this.pdsTablaArgMagnus3 = pdsTablaArgMagnus3;
	}

	@Column(name = "PDS_TABLA_ARG_MAGNUS4")
	public Integer getPdsTablaArgMagnus4() {
		return this.pdsTablaArgMagnus4;
	}

	public void setPdsTablaArgMagnus4(Integer pdsTablaArgMagnus4) {
		this.pdsTablaArgMagnus4 = pdsTablaArgMagnus4;
	}

	@Column(name = "PDS_TABLA_ARG_MAGNUS5")
	public Integer getPdsTablaArgMagnus5() {
		return this.pdsTablaArgMagnus5;
	}

	public void setPdsTablaArgMagnus5(Integer pdsTablaArgMagnus5) {
		this.pdsTablaArgMagnus5 = pdsTablaArgMagnus5;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pdsPrimariasTablasComunes")
	public Set<PdsCategoria> getPdsCategorias() {
		return this.pdsCategorias;
	}

	public void setPdsCategorias(Set<PdsCategoria> pdsCategorias) {
		this.pdsCategorias = pdsCategorias;
	}

}
