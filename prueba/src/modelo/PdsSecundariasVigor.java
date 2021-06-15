package modelo;
// Generated 15 jun. 2021 21:58:49 by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * PdsSecundariasVigor generated by hbm2java
 */
@Entity
@Table(name = "pds_secundarias_vigor", catalog = "anima_sheets_data")
public class PdsSecundariasVigor implements java.io.Serializable {

	private int pdsSecundariasVigor;
	private Integer pdsFrialdad;
	private Integer pdsProezaFuerza;
	private Integer pdsResistirDolor;
	private Integer pdsEspFrialdad;
	private Integer pdsEspProezaFuerza;
	private Integer pdsEspResistirDolor;
	private Integer bonoNaturalFrialdad;
	private Integer bonoNaturalProezaFuerza;
	private Integer bonoNaturalResistirDolor;
	private Integer habNaturalFrialdad;
	private Integer habNaturalProezaFuerza;
	private Integer habNaturalResistirDolor;
	private Integer bonoNovelFrialdad;
	private Integer bonoNovelProezaFuerza;
	private Integer bonoNovelResistirDolor;
	private Set<PdsCategoria> pdsCategorias = new HashSet<PdsCategoria>(0);

	public PdsSecundariasVigor() {
	}

	public PdsSecundariasVigor(int pdsSecundariasVigor) {
		this.pdsSecundariasVigor = pdsSecundariasVigor;
	}

	public PdsSecundariasVigor(int pdsSecundariasVigor, Integer pdsFrialdad, Integer pdsProezaFuerza,
			Integer pdsResistirDolor, Integer pdsEspFrialdad, Integer pdsEspProezaFuerza, Integer pdsEspResistirDolor,
			Integer bonoNaturalFrialdad, Integer bonoNaturalProezaFuerza, Integer bonoNaturalResistirDolor,
			Integer habNaturalFrialdad, Integer habNaturalProezaFuerza, Integer habNaturalResistirDolor,
			Integer bonoNovelFrialdad, Integer bonoNovelProezaFuerza, Integer bonoNovelResistirDolor,
			Set<PdsCategoria> pdsCategorias) {
		this.pdsSecundariasVigor = pdsSecundariasVigor;
		this.pdsFrialdad = pdsFrialdad;
		this.pdsProezaFuerza = pdsProezaFuerza;
		this.pdsResistirDolor = pdsResistirDolor;
		this.pdsEspFrialdad = pdsEspFrialdad;
		this.pdsEspProezaFuerza = pdsEspProezaFuerza;
		this.pdsEspResistirDolor = pdsEspResistirDolor;
		this.bonoNaturalFrialdad = bonoNaturalFrialdad;
		this.bonoNaturalProezaFuerza = bonoNaturalProezaFuerza;
		this.bonoNaturalResistirDolor = bonoNaturalResistirDolor;
		this.habNaturalFrialdad = habNaturalFrialdad;
		this.habNaturalProezaFuerza = habNaturalProezaFuerza;
		this.habNaturalResistirDolor = habNaturalResistirDolor;
		this.bonoNovelFrialdad = bonoNovelFrialdad;
		this.bonoNovelProezaFuerza = bonoNovelProezaFuerza;
		this.bonoNovelResistirDolor = bonoNovelResistirDolor;
		this.pdsCategorias = pdsCategorias;
	}

	@Id

	@Column(name = "PDS_SECUNDARIAS_VIGOR", unique = true, nullable = false)
	public int getPdsSecundariasVigor() {
		return this.pdsSecundariasVigor;
	}

	public void setPdsSecundariasVigor(int pdsSecundariasVigor) {
		this.pdsSecundariasVigor = pdsSecundariasVigor;
	}

	@Column(name = "PDS_FRIALDAD")
	public Integer getPdsFrialdad() {
		return this.pdsFrialdad;
	}

	public void setPdsFrialdad(Integer pdsFrialdad) {
		this.pdsFrialdad = pdsFrialdad;
	}

	@Column(name = "PDS_PROEZA_FUERZA")
	public Integer getPdsProezaFuerza() {
		return this.pdsProezaFuerza;
	}

	public void setPdsProezaFuerza(Integer pdsProezaFuerza) {
		this.pdsProezaFuerza = pdsProezaFuerza;
	}

	@Column(name = "PDS_RESISTIR_DOLOR")
	public Integer getPdsResistirDolor() {
		return this.pdsResistirDolor;
	}

	public void setPdsResistirDolor(Integer pdsResistirDolor) {
		this.pdsResistirDolor = pdsResistirDolor;
	}

	@Column(name = "PDS_ESP_FRIALDAD")
	public Integer getPdsEspFrialdad() {
		return this.pdsEspFrialdad;
	}

	public void setPdsEspFrialdad(Integer pdsEspFrialdad) {
		this.pdsEspFrialdad = pdsEspFrialdad;
	}

	@Column(name = "PDS_ESP_PROEZA_FUERZA")
	public Integer getPdsEspProezaFuerza() {
		return this.pdsEspProezaFuerza;
	}

	public void setPdsEspProezaFuerza(Integer pdsEspProezaFuerza) {
		this.pdsEspProezaFuerza = pdsEspProezaFuerza;
	}

	@Column(name = "PDS_ESP_RESISTIR_DOLOR")
	public Integer getPdsEspResistirDolor() {
		return this.pdsEspResistirDolor;
	}

	public void setPdsEspResistirDolor(Integer pdsEspResistirDolor) {
		this.pdsEspResistirDolor = pdsEspResistirDolor;
	}

	@Column(name = "BONO_NATURAL_FRIALDAD")
	public Integer getBonoNaturalFrialdad() {
		return this.bonoNaturalFrialdad;
	}

	public void setBonoNaturalFrialdad(Integer bonoNaturalFrialdad) {
		this.bonoNaturalFrialdad = bonoNaturalFrialdad;
	}

	@Column(name = "BONO_NATURAL_PROEZA_FUERZA")
	public Integer getBonoNaturalProezaFuerza() {
		return this.bonoNaturalProezaFuerza;
	}

	public void setBonoNaturalProezaFuerza(Integer bonoNaturalProezaFuerza) {
		this.bonoNaturalProezaFuerza = bonoNaturalProezaFuerza;
	}

	@Column(name = "BONO_NATURAL_RESISTIR_DOLOR")
	public Integer getBonoNaturalResistirDolor() {
		return this.bonoNaturalResistirDolor;
	}

	public void setBonoNaturalResistirDolor(Integer bonoNaturalResistirDolor) {
		this.bonoNaturalResistirDolor = bonoNaturalResistirDolor;
	}

	@Column(name = "HAB_NATURAL_FRIALDAD")
	public Integer getHabNaturalFrialdad() {
		return this.habNaturalFrialdad;
	}

	public void setHabNaturalFrialdad(Integer habNaturalFrialdad) {
		this.habNaturalFrialdad = habNaturalFrialdad;
	}

	@Column(name = "HAB_NATURAL_PROEZA_FUERZA")
	public Integer getHabNaturalProezaFuerza() {
		return this.habNaturalProezaFuerza;
	}

	public void setHabNaturalProezaFuerza(Integer habNaturalProezaFuerza) {
		this.habNaturalProezaFuerza = habNaturalProezaFuerza;
	}

	@Column(name = "HAB_NATURAL_RESISTIR_DOLOR")
	public Integer getHabNaturalResistirDolor() {
		return this.habNaturalResistirDolor;
	}

	public void setHabNaturalResistirDolor(Integer habNaturalResistirDolor) {
		this.habNaturalResistirDolor = habNaturalResistirDolor;
	}

	@Column(name = "BONO_NOVEL_FRIALDAD")
	public Integer getBonoNovelFrialdad() {
		return this.bonoNovelFrialdad;
	}

	public void setBonoNovelFrialdad(Integer bonoNovelFrialdad) {
		this.bonoNovelFrialdad = bonoNovelFrialdad;
	}

	@Column(name = "BONO_NOVEL_PROEZA_FUERZA")
	public Integer getBonoNovelProezaFuerza() {
		return this.bonoNovelProezaFuerza;
	}

	public void setBonoNovelProezaFuerza(Integer bonoNovelProezaFuerza) {
		this.bonoNovelProezaFuerza = bonoNovelProezaFuerza;
	}

	@Column(name = "BONO_NOVEL_RESISTIR_DOLOR")
	public Integer getBonoNovelResistirDolor() {
		return this.bonoNovelResistirDolor;
	}

	public void setBonoNovelResistirDolor(Integer bonoNovelResistirDolor) {
		this.bonoNovelResistirDolor = bonoNovelResistirDolor;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pdsSecundariasVigor")
	public Set<PdsCategoria> getPdsCategorias() {
		return this.pdsCategorias;
	}

	public void setPdsCategorias(Set<PdsCategoria> pdsCategorias) {
		this.pdsCategorias = pdsCategorias;
	}

}
