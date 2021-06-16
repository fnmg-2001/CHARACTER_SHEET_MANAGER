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
 * PdsSecundariasAtleticas generated by hbm2java
 */
@Entity
@Table(name = "pds_secundarias_atleticas", catalog = "anima_sheets_data")
public class PdsSecundariasAtleticas implements java.io.Serializable {

	private int pdsSecundariasAtleticas;
	private Integer pdsAcrobacias;
	private Integer pdsAtletismo;
	private Integer pdsMontar;
	private Integer pdsNadar;
	private Integer pdsTrepar;
	private Integer pdsSaltar;
	private Integer pdsPilotar;
	private Integer pdsEspAcrobacias;
	private Integer pdsEspAtletismo;
	private Integer pdsEspMontar;
	private Integer pdsEspNadar;
	private Integer pdsEspTrepar;
	private Integer pdsEspSaltar;
	private Integer pdsEspPilotar;
	private Integer bonoNaturalAcrobacias;
	private Integer bonoNaturalAtletismo;
	private Integer bonoNaturalMontar;
	private Integer bonoNaturalNadar;
	private Integer bonoNaturalTrepar;
	private Integer bonoNaturalSaltar;
	private Integer bonoNaturalPilotar;
	private Integer habNaturalAcrobacias;
	private Integer habNaturalAtletismo;
	private Integer habNaturalMontar;
	private Integer habNaturalNadar;
	private Integer habNaturalTrepar;
	private Integer habNaturalSaltar;
	private Integer habNaturalPilotar;
	private Integer bonoNovelAcrobacias;
	private Integer bonoNovelAtletismo;
	private Integer bonoNovelMontar;
	private Integer bonoNovelNadar;
	private Integer bonoNovelTrepar;
	private Integer bonoNovelSaltar;
	private Integer bonoNovelPilotar;
	private Set<PdsCategoria> pdsCategorias = new HashSet<PdsCategoria>(0);

	public PdsSecundariasAtleticas() {
	}

	public PdsSecundariasAtleticas(int pdsSecundariasAtleticas) {
		this.pdsSecundariasAtleticas = pdsSecundariasAtleticas;
	}

	public PdsSecundariasAtleticas(int pdsSecundariasAtleticas, Integer pdsAcrobacias, Integer pdsAtletismo,
			Integer pdsMontar, Integer pdsNadar, Integer pdsTrepar, Integer pdsSaltar, Integer pdsPilotar,
			Integer pdsEspAcrobacias, Integer pdsEspAtletismo, Integer pdsEspMontar, Integer pdsEspNadar,
			Integer pdsEspTrepar, Integer pdsEspSaltar, Integer pdsEspPilotar, Integer bonoNaturalAcrobacias,
			Integer bonoNaturalAtletismo, Integer bonoNaturalMontar, Integer bonoNaturalNadar,
			Integer bonoNaturalTrepar, Integer bonoNaturalSaltar, Integer bonoNaturalPilotar,
			Integer habNaturalAcrobacias, Integer habNaturalAtletismo, Integer habNaturalMontar,
			Integer habNaturalNadar, Integer habNaturalTrepar, Integer habNaturalSaltar, Integer habNaturalPilotar,
			Integer bonoNovelAcrobacias, Integer bonoNovelAtletismo, Integer bonoNovelMontar, Integer bonoNovelNadar,
			Integer bonoNovelTrepar, Integer bonoNovelSaltar, Integer bonoNovelPilotar,
			Set<PdsCategoria> pdsCategorias) {
		this.pdsSecundariasAtleticas = pdsSecundariasAtleticas;
		this.pdsAcrobacias = pdsAcrobacias;
		this.pdsAtletismo = pdsAtletismo;
		this.pdsMontar = pdsMontar;
		this.pdsNadar = pdsNadar;
		this.pdsTrepar = pdsTrepar;
		this.pdsSaltar = pdsSaltar;
		this.pdsPilotar = pdsPilotar;
		this.pdsEspAcrobacias = pdsEspAcrobacias;
		this.pdsEspAtletismo = pdsEspAtletismo;
		this.pdsEspMontar = pdsEspMontar;
		this.pdsEspNadar = pdsEspNadar;
		this.pdsEspTrepar = pdsEspTrepar;
		this.pdsEspSaltar = pdsEspSaltar;
		this.pdsEspPilotar = pdsEspPilotar;
		this.bonoNaturalAcrobacias = bonoNaturalAcrobacias;
		this.bonoNaturalAtletismo = bonoNaturalAtletismo;
		this.bonoNaturalMontar = bonoNaturalMontar;
		this.bonoNaturalNadar = bonoNaturalNadar;
		this.bonoNaturalTrepar = bonoNaturalTrepar;
		this.bonoNaturalSaltar = bonoNaturalSaltar;
		this.bonoNaturalPilotar = bonoNaturalPilotar;
		this.habNaturalAcrobacias = habNaturalAcrobacias;
		this.habNaturalAtletismo = habNaturalAtletismo;
		this.habNaturalMontar = habNaturalMontar;
		this.habNaturalNadar = habNaturalNadar;
		this.habNaturalTrepar = habNaturalTrepar;
		this.habNaturalSaltar = habNaturalSaltar;
		this.habNaturalPilotar = habNaturalPilotar;
		this.bonoNovelAcrobacias = bonoNovelAcrobacias;
		this.bonoNovelAtletismo = bonoNovelAtletismo;
		this.bonoNovelMontar = bonoNovelMontar;
		this.bonoNovelNadar = bonoNovelNadar;
		this.bonoNovelTrepar = bonoNovelTrepar;
		this.bonoNovelSaltar = bonoNovelSaltar;
		this.bonoNovelPilotar = bonoNovelPilotar;
		this.pdsCategorias = pdsCategorias;
	}

	@Id

	@Column(name = "PDS_SECUNDARIAS_ATLETICAS", unique = true, nullable = false)
	public int getPdsSecundariasAtleticas() {
		return this.pdsSecundariasAtleticas;
	}

	public void setPdsSecundariasAtleticas(int pdsSecundariasAtleticas) {
		this.pdsSecundariasAtleticas = pdsSecundariasAtleticas;
	}

	@Column(name = "PDS_ACROBACIAS")
	public Integer getPdsAcrobacias() {
		return this.pdsAcrobacias;
	}

	public void setPdsAcrobacias(Integer pdsAcrobacias) {
		this.pdsAcrobacias = pdsAcrobacias;
	}

	@Column(name = "PDS_ATLETISMO")
	public Integer getPdsAtletismo() {
		return this.pdsAtletismo;
	}

	public void setPdsAtletismo(Integer pdsAtletismo) {
		this.pdsAtletismo = pdsAtletismo;
	}

	@Column(name = "PDS_MONTAR")
	public Integer getPdsMontar() {
		return this.pdsMontar;
	}

	public void setPdsMontar(Integer pdsMontar) {
		this.pdsMontar = pdsMontar;
	}

	@Column(name = "PDS_NADAR")
	public Integer getPdsNadar() {
		return this.pdsNadar;
	}

	public void setPdsNadar(Integer pdsNadar) {
		this.pdsNadar = pdsNadar;
	}

	@Column(name = "PDS_TREPAR")
	public Integer getPdsTrepar() {
		return this.pdsTrepar;
	}

	public void setPdsTrepar(Integer pdsTrepar) {
		this.pdsTrepar = pdsTrepar;
	}

	@Column(name = "PDS_SALTAR")
	public Integer getPdsSaltar() {
		return this.pdsSaltar;
	}

	public void setPdsSaltar(Integer pdsSaltar) {
		this.pdsSaltar = pdsSaltar;
	}

	@Column(name = "PDS_PILOTAR")
	public Integer getPdsPilotar() {
		return this.pdsPilotar;
	}

	public void setPdsPilotar(Integer pdsPilotar) {
		this.pdsPilotar = pdsPilotar;
	}

	@Column(name = "PDS_ESP_ACROBACIAS")
	public Integer getPdsEspAcrobacias() {
		return this.pdsEspAcrobacias;
	}

	public void setPdsEspAcrobacias(Integer pdsEspAcrobacias) {
		this.pdsEspAcrobacias = pdsEspAcrobacias;
	}

	@Column(name = "PDS_ESP_ATLETISMO")
	public Integer getPdsEspAtletismo() {
		return this.pdsEspAtletismo;
	}

	public void setPdsEspAtletismo(Integer pdsEspAtletismo) {
		this.pdsEspAtletismo = pdsEspAtletismo;
	}

	@Column(name = "PDS_ESP_MONTAR")
	public Integer getPdsEspMontar() {
		return this.pdsEspMontar;
	}

	public void setPdsEspMontar(Integer pdsEspMontar) {
		this.pdsEspMontar = pdsEspMontar;
	}

	@Column(name = "PDS_ESP_NADAR")
	public Integer getPdsEspNadar() {
		return this.pdsEspNadar;
	}

	public void setPdsEspNadar(Integer pdsEspNadar) {
		this.pdsEspNadar = pdsEspNadar;
	}

	@Column(name = "PDS_ESP_TREPAR")
	public Integer getPdsEspTrepar() {
		return this.pdsEspTrepar;
	}

	public void setPdsEspTrepar(Integer pdsEspTrepar) {
		this.pdsEspTrepar = pdsEspTrepar;
	}

	@Column(name = "PDS_ESP_SALTAR")
	public Integer getPdsEspSaltar() {
		return this.pdsEspSaltar;
	}

	public void setPdsEspSaltar(Integer pdsEspSaltar) {
		this.pdsEspSaltar = pdsEspSaltar;
	}

	@Column(name = "PDS_ESP_PILOTAR")
	public Integer getPdsEspPilotar() {
		return this.pdsEspPilotar;
	}

	public void setPdsEspPilotar(Integer pdsEspPilotar) {
		this.pdsEspPilotar = pdsEspPilotar;
	}

	@Column(name = "BONO_NATURAL_ACROBACIAS")
	public Integer getBonoNaturalAcrobacias() {
		return this.bonoNaturalAcrobacias;
	}

	public void setBonoNaturalAcrobacias(Integer bonoNaturalAcrobacias) {
		this.bonoNaturalAcrobacias = bonoNaturalAcrobacias;
	}

	@Column(name = "BONO_NATURAL_ATLETISMO")
	public Integer getBonoNaturalAtletismo() {
		return this.bonoNaturalAtletismo;
	}

	public void setBonoNaturalAtletismo(Integer bonoNaturalAtletismo) {
		this.bonoNaturalAtletismo = bonoNaturalAtletismo;
	}

	@Column(name = "BONO_NATURAL_MONTAR")
	public Integer getBonoNaturalMontar() {
		return this.bonoNaturalMontar;
	}

	public void setBonoNaturalMontar(Integer bonoNaturalMontar) {
		this.bonoNaturalMontar = bonoNaturalMontar;
	}

	@Column(name = "BONO_NATURAL_NADAR")
	public Integer getBonoNaturalNadar() {
		return this.bonoNaturalNadar;
	}

	public void setBonoNaturalNadar(Integer bonoNaturalNadar) {
		this.bonoNaturalNadar = bonoNaturalNadar;
	}

	@Column(name = "BONO_NATURAL_TREPAR")
	public Integer getBonoNaturalTrepar() {
		return this.bonoNaturalTrepar;
	}

	public void setBonoNaturalTrepar(Integer bonoNaturalTrepar) {
		this.bonoNaturalTrepar = bonoNaturalTrepar;
	}

	@Column(name = "BONO_NATURAL_SALTAR")
	public Integer getBonoNaturalSaltar() {
		return this.bonoNaturalSaltar;
	}

	public void setBonoNaturalSaltar(Integer bonoNaturalSaltar) {
		this.bonoNaturalSaltar = bonoNaturalSaltar;
	}

	@Column(name = "BONO_NATURAL_PILOTAR")
	public Integer getBonoNaturalPilotar() {
		return this.bonoNaturalPilotar;
	}

	public void setBonoNaturalPilotar(Integer bonoNaturalPilotar) {
		this.bonoNaturalPilotar = bonoNaturalPilotar;
	}

	@Column(name = "HAB_NATURAL_ACROBACIAS")
	public Integer getHabNaturalAcrobacias() {
		return this.habNaturalAcrobacias;
	}

	public void setHabNaturalAcrobacias(Integer habNaturalAcrobacias) {
		this.habNaturalAcrobacias = habNaturalAcrobacias;
	}

	@Column(name = "HAB_NATURAL_ATLETISMO")
	public Integer getHabNaturalAtletismo() {
		return this.habNaturalAtletismo;
	}

	public void setHabNaturalAtletismo(Integer habNaturalAtletismo) {
		this.habNaturalAtletismo = habNaturalAtletismo;
	}

	@Column(name = "HAB_NATURAL_MONTAR")
	public Integer getHabNaturalMontar() {
		return this.habNaturalMontar;
	}

	public void setHabNaturalMontar(Integer habNaturalMontar) {
		this.habNaturalMontar = habNaturalMontar;
	}

	@Column(name = "HAB_NATURAL_NADAR")
	public Integer getHabNaturalNadar() {
		return this.habNaturalNadar;
	}

	public void setHabNaturalNadar(Integer habNaturalNadar) {
		this.habNaturalNadar = habNaturalNadar;
	}

	@Column(name = "HAB_NATURAL_TREPAR")
	public Integer getHabNaturalTrepar() {
		return this.habNaturalTrepar;
	}

	public void setHabNaturalTrepar(Integer habNaturalTrepar) {
		this.habNaturalTrepar = habNaturalTrepar;
	}

	@Column(name = "HAB_NATURAL_SALTAR")
	public Integer getHabNaturalSaltar() {
		return this.habNaturalSaltar;
	}

	public void setHabNaturalSaltar(Integer habNaturalSaltar) {
		this.habNaturalSaltar = habNaturalSaltar;
	}

	@Column(name = "HAB_NATURAL_PILOTAR")
	public Integer getHabNaturalPilotar() {
		return this.habNaturalPilotar;
	}

	public void setHabNaturalPilotar(Integer habNaturalPilotar) {
		this.habNaturalPilotar = habNaturalPilotar;
	}

	@Column(name = "BONO_NOVEL_ACROBACIAS")
	public Integer getBonoNovelAcrobacias() {
		return this.bonoNovelAcrobacias;
	}

	public void setBonoNovelAcrobacias(Integer bonoNovelAcrobacias) {
		this.bonoNovelAcrobacias = bonoNovelAcrobacias;
	}

	@Column(name = "BONO_NOVEL_ATLETISMO")
	public Integer getBonoNovelAtletismo() {
		return this.bonoNovelAtletismo;
	}

	public void setBonoNovelAtletismo(Integer bonoNovelAtletismo) {
		this.bonoNovelAtletismo = bonoNovelAtletismo;
	}

	@Column(name = "BONO_NOVEL_MONTAR")
	public Integer getBonoNovelMontar() {
		return this.bonoNovelMontar;
	}

	public void setBonoNovelMontar(Integer bonoNovelMontar) {
		this.bonoNovelMontar = bonoNovelMontar;
	}

	@Column(name = "BONO_NOVEL_NADAR")
	public Integer getBonoNovelNadar() {
		return this.bonoNovelNadar;
	}

	public void setBonoNovelNadar(Integer bonoNovelNadar) {
		this.bonoNovelNadar = bonoNovelNadar;
	}

	@Column(name = "BONO_NOVEL_TREPAR")
	public Integer getBonoNovelTrepar() {
		return this.bonoNovelTrepar;
	}

	public void setBonoNovelTrepar(Integer bonoNovelTrepar) {
		this.bonoNovelTrepar = bonoNovelTrepar;
	}

	@Column(name = "BONO_NOVEL_SALTAR")
	public Integer getBonoNovelSaltar() {
		return this.bonoNovelSaltar;
	}

	public void setBonoNovelSaltar(Integer bonoNovelSaltar) {
		this.bonoNovelSaltar = bonoNovelSaltar;
	}

	@Column(name = "BONO_NOVEL_PILOTAR")
	public Integer getBonoNovelPilotar() {
		return this.bonoNovelPilotar;
	}

	public void setBonoNovelPilotar(Integer bonoNovelPilotar) {
		this.bonoNovelPilotar = bonoNovelPilotar;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pdsSecundariasAtleticas")
	public Set<PdsCategoria> getPdsCategorias() {
		return this.pdsCategorias;
	}

	public void setPdsCategorias(Set<PdsCategoria> pdsCategorias) {
		this.pdsCategorias = pdsCategorias;
	}

}
