package modelo;
// Generated 15 jun. 2021 23:20:51 by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * PdsSecundariasPerceptivas generated by hbm2java
 */
@Entity
@Table(name = "pds_secundarias_perceptivas", catalog = "anima_sheets_data")
public class PdsSecundariasPerceptivas implements java.io.Serializable {

	private int pdsSecundariasPerceptivas;
	private Integer pdsAdvertir;
	private Integer pdsBuscar;
	private Integer pdsRastrear;
	private Integer pdsEspAdvertir;
	private Integer pdsEspBuscar;
	private Integer pdsEspRastrear;
	private Integer bonoNaturalAdvertir;
	private Integer bonoNaturalBuscar;
	private Integer bonoNaturalRastrear;
	private Integer habNaturalAdvertir;
	private Integer habNaturalBuscar;
	private Integer habNaturalRastrear;
	private Integer bonoNovelAdvertir;
	private Integer bonoNovelBuscar;
	private Integer bonoNovelRastrear;
	private Set<PdsCategoria> pdsCategorias = new HashSet<PdsCategoria>(0);

	public PdsSecundariasPerceptivas() {
	}

	public PdsSecundariasPerceptivas(int pdsSecundariasPerceptivas) {
		this.pdsSecundariasPerceptivas = pdsSecundariasPerceptivas;
	}

	public PdsSecundariasPerceptivas(int pdsSecundariasPerceptivas, Integer pdsAdvertir, Integer pdsBuscar,
			Integer pdsRastrear, Integer pdsEspAdvertir, Integer pdsEspBuscar, Integer pdsEspRastrear,
			Integer bonoNaturalAdvertir, Integer bonoNaturalBuscar, Integer bonoNaturalRastrear,
			Integer habNaturalAdvertir, Integer habNaturalBuscar, Integer habNaturalRastrear, Integer bonoNovelAdvertir,
			Integer bonoNovelBuscar, Integer bonoNovelRastrear, Set<PdsCategoria> pdsCategorias) {
		this.pdsSecundariasPerceptivas = pdsSecundariasPerceptivas;
		this.pdsAdvertir = pdsAdvertir;
		this.pdsBuscar = pdsBuscar;
		this.pdsRastrear = pdsRastrear;
		this.pdsEspAdvertir = pdsEspAdvertir;
		this.pdsEspBuscar = pdsEspBuscar;
		this.pdsEspRastrear = pdsEspRastrear;
		this.bonoNaturalAdvertir = bonoNaturalAdvertir;
		this.bonoNaturalBuscar = bonoNaturalBuscar;
		this.bonoNaturalRastrear = bonoNaturalRastrear;
		this.habNaturalAdvertir = habNaturalAdvertir;
		this.habNaturalBuscar = habNaturalBuscar;
		this.habNaturalRastrear = habNaturalRastrear;
		this.bonoNovelAdvertir = bonoNovelAdvertir;
		this.bonoNovelBuscar = bonoNovelBuscar;
		this.bonoNovelRastrear = bonoNovelRastrear;
		this.pdsCategorias = pdsCategorias;
	}

	@Id

	@Column(name = "PDS_SECUNDARIAS_PERCEPTIVAS", unique = true, nullable = false)
	public int getPdsSecundariasPerceptivas() {
		return this.pdsSecundariasPerceptivas;
	}

	public void setPdsSecundariasPerceptivas(int pdsSecundariasPerceptivas) {
		this.pdsSecundariasPerceptivas = pdsSecundariasPerceptivas;
	}

	@Column(name = "PDS_ADVERTIR")
	public Integer getPdsAdvertir() {
		return this.pdsAdvertir;
	}

	public void setPdsAdvertir(Integer pdsAdvertir) {
		this.pdsAdvertir = pdsAdvertir;
	}

	@Column(name = "PDS_BUSCAR")
	public Integer getPdsBuscar() {
		return this.pdsBuscar;
	}

	public void setPdsBuscar(Integer pdsBuscar) {
		this.pdsBuscar = pdsBuscar;
	}

	@Column(name = "PDS_RASTREAR")
	public Integer getPdsRastrear() {
		return this.pdsRastrear;
	}

	public void setPdsRastrear(Integer pdsRastrear) {
		this.pdsRastrear = pdsRastrear;
	}

	@Column(name = "PDS_ESP_ADVERTIR")
	public Integer getPdsEspAdvertir() {
		return this.pdsEspAdvertir;
	}

	public void setPdsEspAdvertir(Integer pdsEspAdvertir) {
		this.pdsEspAdvertir = pdsEspAdvertir;
	}

	@Column(name = "PDS_ESP_BUSCAR")
	public Integer getPdsEspBuscar() {
		return this.pdsEspBuscar;
	}

	public void setPdsEspBuscar(Integer pdsEspBuscar) {
		this.pdsEspBuscar = pdsEspBuscar;
	}

	@Column(name = "PDS_ESP_RASTREAR")
	public Integer getPdsEspRastrear() {
		return this.pdsEspRastrear;
	}

	public void setPdsEspRastrear(Integer pdsEspRastrear) {
		this.pdsEspRastrear = pdsEspRastrear;
	}

	@Column(name = "BONO_NATURAL_ADVERTIR")
	public Integer getBonoNaturalAdvertir() {
		return this.bonoNaturalAdvertir;
	}

	public void setBonoNaturalAdvertir(Integer bonoNaturalAdvertir) {
		this.bonoNaturalAdvertir = bonoNaturalAdvertir;
	}

	@Column(name = "BONO_NATURAL_BUSCAR")
	public Integer getBonoNaturalBuscar() {
		return this.bonoNaturalBuscar;
	}

	public void setBonoNaturalBuscar(Integer bonoNaturalBuscar) {
		this.bonoNaturalBuscar = bonoNaturalBuscar;
	}

	@Column(name = "BONO_NATURAL_RASTREAR")
	public Integer getBonoNaturalRastrear() {
		return this.bonoNaturalRastrear;
	}

	public void setBonoNaturalRastrear(Integer bonoNaturalRastrear) {
		this.bonoNaturalRastrear = bonoNaturalRastrear;
	}

	@Column(name = "HAB_NATURAL_ADVERTIR")
	public Integer getHabNaturalAdvertir() {
		return this.habNaturalAdvertir;
	}

	public void setHabNaturalAdvertir(Integer habNaturalAdvertir) {
		this.habNaturalAdvertir = habNaturalAdvertir;
	}

	@Column(name = "HAB_NATURAL_BUSCAR")
	public Integer getHabNaturalBuscar() {
		return this.habNaturalBuscar;
	}

	public void setHabNaturalBuscar(Integer habNaturalBuscar) {
		this.habNaturalBuscar = habNaturalBuscar;
	}

	@Column(name = "HAB_NATURAL_RASTREAR")
	public Integer getHabNaturalRastrear() {
		return this.habNaturalRastrear;
	}

	public void setHabNaturalRastrear(Integer habNaturalRastrear) {
		this.habNaturalRastrear = habNaturalRastrear;
	}

	@Column(name = "BONO_NOVEL_ADVERTIR")
	public Integer getBonoNovelAdvertir() {
		return this.bonoNovelAdvertir;
	}

	public void setBonoNovelAdvertir(Integer bonoNovelAdvertir) {
		this.bonoNovelAdvertir = bonoNovelAdvertir;
	}

	@Column(name = "BONO_NOVEL_BUSCAR")
	public Integer getBonoNovelBuscar() {
		return this.bonoNovelBuscar;
	}

	public void setBonoNovelBuscar(Integer bonoNovelBuscar) {
		this.bonoNovelBuscar = bonoNovelBuscar;
	}

	@Column(name = "BONO_NOVEL_RASTREAR")
	public Integer getBonoNovelRastrear() {
		return this.bonoNovelRastrear;
	}

	public void setBonoNovelRastrear(Integer bonoNovelRastrear) {
		this.bonoNovelRastrear = bonoNovelRastrear;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pdsSecundariasPerceptivas")
	public Set<PdsCategoria> getPdsCategorias() {
		return this.pdsCategorias;
	}

	public void setPdsCategorias(Set<PdsCategoria> pdsCategorias) {
		this.pdsCategorias = pdsCategorias;
	}

}
