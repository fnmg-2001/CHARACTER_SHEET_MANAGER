package modelo;

public class PdsHabilidadesSecundarias {
	private String nombreHabilidad;
	private String costeHabilidad;
	private String pdsHabilidad;
	private String baseHabilidad;
	private String bonoHabilidad;
	private String categoriaHabilidad;
	private String categoriaHabilidadAux;
	private String especialHabilidad;
	private String bonoNatural;
	private String habilidadNatural;
	private String bonoNovel;
	private String totalHabilidad;
	private int bonoNaturalValor;
	private int habilidadNaturalValor;
	private int bonoNovelValor;
	private String nivelClase;
	
	
	public PdsHabilidadesSecundarias(String nombreHabilidad, String costeHabilidad, String pdsHabilidad,
			String bonoHabilidad, String categoriaHabilidad, String especialHabilidad, String bonoNatural, String habilidadNatural, String bonoNovel,
			String nivelClase) {
		this.nombreHabilidad = nombreHabilidad;
		this.costeHabilidad = costeHabilidad;
		this.pdsHabilidad = pdsHabilidad;
		this.nivelClase = nivelClase;
		
		if (null!=this.pdsHabilidad && null!=this.costeHabilidad) {
			this.baseHabilidad = String.valueOf((Integer.parseInt(pdsHabilidad)/Integer.parseInt(this.costeHabilidad)));
			
		} else {
			this.baseHabilidad = "0";
			
		}
		
		this.bonoHabilidad = bonoHabilidad;
		if (this.categoriaHabilidad=="null"||this.bonoHabilidad=="-"||null==this.bonoHabilidad) {
			this.bonoHabilidad = "0";
			
		}else {
			this.bonoHabilidad = bonoHabilidad;
		}
		
		this.categoriaHabilidad = categoriaHabilidad;
		this.categoriaHabilidadAux = categoriaHabilidad;
		if (this.categoriaHabilidad=="null"||this.categoriaHabilidad=="-"||null==this.categoriaHabilidad) {
			this.categoriaHabilidad = "0";
			if (this.categoriaHabilidadAux=="null"||this.categoriaHabilidadAux=="-"||null==this.categoriaHabilidadAux) {
				this.categoriaHabilidadAux = "0";
			} 
			
		} else {
			this.categoriaHabilidad = categoriaHabilidad;
			this.categoriaHabilidadAux = categoriaHabilidad;
			
			for (int i = 1; i < Integer.parseInt(nivelClase); i++) {
				this.categoriaHabilidad = String.valueOf(Integer.parseInt(this.categoriaHabilidad) + Integer.parseInt(this.categoriaHabilidad));
			}
		}
		
		this.especialHabilidad = especialHabilidad;
		
		this.bonoNatural = bonoNatural;
		if (null==this.bonoNatural) {
			this.bonoNatural = "0";
		} else {
			this.bonoNatural = bonoNatural;
		}
		
		this.bonoNaturalValor = 0;
		for (int i = 0; i < Integer.parseInt(this.bonoNatural); i++) {
			this.bonoNaturalValor = this.bonoNaturalValor+Integer.parseInt(this.bonoHabilidad);
		}

		this.habilidadNatural = habilidadNatural;
		if (null==this.habilidadNatural) {
			this.habilidadNatural = "0";
		} else {
			this.habilidadNatural = habilidadNatural;
		}
			
		this.habilidadNaturalValor = 0;
		for (int i = 0; i < Integer.parseInt(this.habilidadNatural); i++) {
			this.habilidadNaturalValor = this.habilidadNaturalValor+10;
		}
		
		this.bonoNovel = bonoNovel;
		if (null==this.bonoNovel) {
			this.bonoNovel = "0";
		} else {
			this.bonoNovel = bonoNovel;
		}
		
		this.bonoNovelValor = 0;
		for (int i = 0; i < Integer.parseInt(this.bonoNovel); i++) {
			this.bonoNovelValor = this.bonoNovelValor+10;
		}
		
		if (null!=this.baseHabilidad && null!=this.especialHabilidad) {
			this.totalHabilidad = String.valueOf(Integer.parseInt(this.baseHabilidad)+Integer.parseInt(this.especialHabilidad)+Integer.parseInt(this.categoriaHabilidad)+Integer.parseInt(this.bonoHabilidad)+
					this.bonoNaturalValor+this.habilidadNaturalValor+this.bonoNovelValor);
			
		} else if (null!=this.baseHabilidad && null==this.especialHabilidad) {
			this.totalHabilidad = String.valueOf(Integer.parseInt(this.baseHabilidad)+0+Integer.parseInt(this.categoriaHabilidad)+Integer.parseInt(this.bonoHabilidad)+this.bonoNaturalValor+this.habilidadNaturalValor+this.bonoNovelValor);
			
		} else if (null==this.baseHabilidad && null!=this.especialHabilidad) {
			this.totalHabilidad = String.valueOf(0+Integer.parseInt(this.especialHabilidad)+Integer.parseInt(this.categoriaHabilidad)+Integer.parseInt(this.bonoHabilidad)+this.bonoNaturalValor+this.habilidadNaturalValor+this.bonoNovelValor);
			
			
		} else {
			this.totalHabilidad = "0";
			
		}
		
	}

	public String getNombreHabilidad() {
		return nombreHabilidad;
	}

	public void setNombreHabilidad(String nombreHabilidad) {
		this.nombreHabilidad = nombreHabilidad;
	}

	public String getCosteHabilidad() {
		return costeHabilidad;
	}

	public void setCosteHabilidad(String costeHabilidad) {
		this.costeHabilidad = costeHabilidad;
	}

	public String getPdsHabilidad() {
		return pdsHabilidad;
	}

	public void setPdsHabilidad(String pdsHabilidad) {
		this.pdsHabilidad = pdsHabilidad;

		if (null!=this.pdsHabilidad && null!=this.costeHabilidad) {
			this.baseHabilidad = String.valueOf((Integer.parseInt(pdsHabilidad)/Integer.parseInt(this.costeHabilidad)));
			
		} else {
			this.baseHabilidad = "0";
			
		}
		
		if (null!=this.baseHabilidad && null!=this.especialHabilidad) {
			this.totalHabilidad = String.valueOf(Integer.parseInt(this.baseHabilidad)+Integer.parseInt(this.especialHabilidad)+Integer.parseInt(this.categoriaHabilidad)+Integer.parseInt(this.bonoHabilidad)+
					this.bonoNaturalValor+this.habilidadNaturalValor+this.bonoNovelValor);
		} else if (null!=this.baseHabilidad && null==this.especialHabilidad) {
			this.totalHabilidad = String.valueOf(Integer.parseInt(this.baseHabilidad)+0+Integer.parseInt(this.categoriaHabilidad)+Integer.parseInt(this.bonoHabilidad)+this.bonoNaturalValor+this.habilidadNaturalValor+this.bonoNovelValor);
			
		}  else if (null==this.baseHabilidad && null!=this.especialHabilidad) {
			this.totalHabilidad = String.valueOf(0+Integer.parseInt(this.especialHabilidad)+Integer.parseInt(this.categoriaHabilidad)+Integer.parseInt(this.bonoHabilidad)+this.bonoNaturalValor+this.habilidadNaturalValor+this.bonoNovelValor);
			
		} else {
			this.totalHabilidad = "0";
			
		}
	}

	public String getBaseHabilidad() {
		return baseHabilidad;
	}

	public void setBaseHabilidad(String baseHabilidad) {
		this.baseHabilidad = baseHabilidad;
	}

	public String getBonoHabilidad() {
		return bonoHabilidad;
	}

	public void setBonoHabilidad(String bonoHabilidad) {
		this.bonoHabilidad = bonoHabilidad;
		
		if (null!=this.pdsHabilidad && null!=this.costeHabilidad) {
			this.baseHabilidad = String.valueOf((Integer.parseInt(pdsHabilidad)/Integer.parseInt(this.costeHabilidad)));
			
		} else {
			this.baseHabilidad = "0";
			
		}
		
		if (null!=this.pdsHabilidad && null!=this.costeHabilidad && this.nombreHabilidad == "Conocimiento Marcial") {
			this.baseHabilidad = String.valueOf(Integer.parseInt(pdsHabilidad)/1);
			
		} else if (null!=this.pdsHabilidad && null!=this.costeHabilidad && this.nombreHabilidad != "Conocimiento Marcial") {
			this.baseHabilidad = String.valueOf(Integer.parseInt(pdsHabilidad)/Integer.parseInt(costeHabilidad));
			
		} else {
			this.baseHabilidad = "0";
			
		}
		
		if (null!=this.baseHabilidad && null!=this.especialHabilidad) {
			this.totalHabilidad = String.valueOf(Integer.parseInt(this.baseHabilidad)+Integer.parseInt(this.especialHabilidad)+Integer.parseInt(this.categoriaHabilidad)+Integer.parseInt(this.bonoHabilidad)+
					this.bonoNaturalValor+this.habilidadNaturalValor+this.bonoNovelValor);
		} else if (null!=this.baseHabilidad && null==this.especialHabilidad) {
			this.totalHabilidad = String.valueOf(Integer.parseInt(this.baseHabilidad)+0+Integer.parseInt(this.categoriaHabilidad)+Integer.parseInt(this.bonoHabilidad)+this.bonoNaturalValor+this.habilidadNaturalValor+this.bonoNovelValor);
		}  else if (null==this.baseHabilidad && null!=this.especialHabilidad) {
			this.totalHabilidad = String.valueOf(0+Integer.parseInt(this.especialHabilidad)+Integer.parseInt(this.categoriaHabilidad)+Integer.parseInt(this.bonoHabilidad)+this.bonoNaturalValor+this.habilidadNaturalValor+this.bonoNovelValor);
			
		} else {
			this.totalHabilidad = "0";
			
		}
	}

	public String getCategoriaHabilidad() {
		return categoriaHabilidad;
	}

	public void setCategoriaHabilidad(String categoriaHabilidad) {
		this.categoriaHabilidad = categoriaHabilidad;
	}

	public String getEspecialHabilidad() {
		return especialHabilidad;
	}

	public void setEspecialHabilidad(String especialHabilidad) {
		this.especialHabilidad = especialHabilidad;
		if (null!=this.pdsHabilidad && null!=this.costeHabilidad && this.nombreHabilidad == "Conocimiento Marcial") {
			this.baseHabilidad = String.valueOf(Integer.parseInt(pdsHabilidad)/1);
			
		} else if (null!=this.pdsHabilidad && null!=this.costeHabilidad && this.nombreHabilidad != "Conocimiento Marcial") {
			this.baseHabilidad = String.valueOf(Integer.parseInt(pdsHabilidad)/Integer.parseInt(costeHabilidad));
			
		} else {
			this.baseHabilidad = "0";
			
		}
		
		if (null!=this.baseHabilidad && null!=this.especialHabilidad) {
			this.totalHabilidad = String.valueOf(Integer.parseInt(this.baseHabilidad)+Integer.parseInt(this.especialHabilidad)+Integer.parseInt(this.categoriaHabilidad)+Integer.parseInt(this.bonoHabilidad)+
					this.bonoNaturalValor+this.habilidadNaturalValor+this.bonoNovelValor);
		} else if (null!=this.baseHabilidad && null==this.especialHabilidad) {
			this.totalHabilidad = String.valueOf(Integer.parseInt(this.baseHabilidad)+0+Integer.parseInt(this.categoriaHabilidad)+Integer.parseInt(this.bonoHabilidad)+this.bonoNaturalValor+this.habilidadNaturalValor+this.bonoNovelValor);
		}  else if (null==this.baseHabilidad && null!=this.especialHabilidad) {
			this.totalHabilidad = String.valueOf(0+Integer.parseInt(this.especialHabilidad)+Integer.parseInt(this.categoriaHabilidad)+Integer.parseInt(this.bonoHabilidad)+this.bonoNaturalValor+this.habilidadNaturalValor+this.bonoNovelValor);
			
		} else {
			this.totalHabilidad = "0";
			
		}
	}
	

	public String getTotalHabilidad() {
		return totalHabilidad;
	}

	public void setTotalHabilidad(String totalHabilidad) {
		this.totalHabilidad = totalHabilidad;
	}

	public String getBonoNatural() {
		return bonoNatural;
	}

	public void setBonoNatural(String bonoNatural) {
		this.bonoNatural = bonoNatural;
		if (null==this.bonoNatural) {
			this.bonoNatural = "0";
		} else {
			this.bonoNatural = bonoNatural;
		}
		
		this.bonoNaturalValor = 0;
		for (int i = 0; i < Integer.parseInt(this.bonoNatural); i++) {
			this.bonoNaturalValor = this.bonoNaturalValor+Integer.parseInt(this.bonoHabilidad);
		}
		
		if (null!=this.pdsHabilidad && null!=this.costeHabilidad) {
			this.baseHabilidad = String.valueOf((Integer.parseInt(pdsHabilidad)/Integer.parseInt(this.costeHabilidad)));
			
		} else {
			this.baseHabilidad = "0";
			
		}
		
		if (null!=this.baseHabilidad && null!=this.especialHabilidad) {
			this.totalHabilidad = String.valueOf(Integer.parseInt(this.baseHabilidad)+Integer.parseInt(this.especialHabilidad)+Integer.parseInt(this.categoriaHabilidad)+Integer.parseInt(this.bonoHabilidad)+
					this.bonoNaturalValor+this.habilidadNaturalValor+this.bonoNovelValor);
		} else if (null!=this.baseHabilidad && null==this.especialHabilidad) {
			this.totalHabilidad = String.valueOf(Integer.parseInt(this.baseHabilidad)+0+Integer.parseInt(this.categoriaHabilidad)+Integer.parseInt(this.bonoHabilidad)+this.bonoNaturalValor+this.habilidadNaturalValor+this.bonoNovelValor);
		}  else if (null==this.baseHabilidad && null!=this.especialHabilidad) {
			this.totalHabilidad = String.valueOf(0+Integer.parseInt(this.especialHabilidad)+Integer.parseInt(this.categoriaHabilidad)+Integer.parseInt(this.bonoHabilidad)+this.bonoNaturalValor+this.habilidadNaturalValor+this.bonoNovelValor);
			
		} else {
			this.totalHabilidad = "0";
			
		}
	}

	public String getHabilidadNatural() {
		return habilidadNatural;
	}

	public void setHabilidadNatural(String habilidadNatural) {
		this.habilidadNatural = habilidadNatural;
		if (null==this.habilidadNatural) {
			this.habilidadNatural = "0";
		} else {
			this.habilidadNatural = habilidadNatural;
		}
		
		if (null!=this.pdsHabilidad && null!=this.costeHabilidad) {
			this.baseHabilidad = String.valueOf((Integer.parseInt(pdsHabilidad)/Integer.parseInt(this.costeHabilidad)));
			
		} else {
			this.baseHabilidad = "0";
			
		}
		
		if (null==this.habilidadNatural) {
			this.habilidadNatural = "0";
		} else {
			this.habilidadNatural = habilidadNatural;
		}
			
		this.habilidadNaturalValor = 0;
		for (int i = 0; i < Integer.parseInt(this.habilidadNatural); i++) {
			this.habilidadNaturalValor = this.habilidadNaturalValor+10;
		}
		
		if (null!=this.baseHabilidad && null!=this.especialHabilidad) {
			this.totalHabilidad = String.valueOf(Integer.parseInt(this.baseHabilidad)+Integer.parseInt(this.especialHabilidad)+Integer.parseInt(this.categoriaHabilidad)+Integer.parseInt(this.bonoHabilidad)+
					this.bonoNaturalValor+this.habilidadNaturalValor+this.bonoNovelValor);
		} else if (null!=this.baseHabilidad && null==this.especialHabilidad) {
			this.totalHabilidad = String.valueOf(Integer.parseInt(this.baseHabilidad)+0+Integer.parseInt(this.categoriaHabilidad)+Integer.parseInt(this.bonoHabilidad)+this.bonoNaturalValor+this.habilidadNaturalValor+this.bonoNovelValor);
		}  else if (null==this.baseHabilidad && null!=this.especialHabilidad) {
			this.totalHabilidad = String.valueOf(0+Integer.parseInt(this.especialHabilidad)+Integer.parseInt(this.categoriaHabilidad)+Integer.parseInt(this.bonoHabilidad)+this.bonoNaturalValor+this.habilidadNaturalValor+this.bonoNovelValor);
			
		} else {
			this.totalHabilidad = "0";
			
		}
	}

	public String getBonoNovel() {
		return bonoNovel;
	}

	public void setBonoNovel(String bonoNovel) {
		this.bonoNovel = bonoNovel;
		if (null==this.bonoNovel) {
			this.bonoNovel = "0";
		} else {
			this.bonoNovel = bonoNovel;
		}
		
		this.bonoNovelValor = 0;
		for (int i = 0; i < Integer.parseInt(this.bonoNovel); i++) {
			this.bonoNovelValor = this.bonoNovelValor+10;
		}
		
		if (null!=this.baseHabilidad && null!=this.especialHabilidad) {
			this.totalHabilidad = String.valueOf(Integer.parseInt(this.baseHabilidad)+Integer.parseInt(this.especialHabilidad)+Integer.parseInt(this.categoriaHabilidad)+Integer.parseInt(this.bonoHabilidad)+
					this.bonoNaturalValor+this.habilidadNaturalValor+this.bonoNovelValor);
		} else if (null!=this.baseHabilidad && null==this.especialHabilidad) {
			this.totalHabilidad = String.valueOf(Integer.parseInt(this.baseHabilidad)+0+Integer.parseInt(this.categoriaHabilidad)+Integer.parseInt(this.bonoHabilidad)+this.bonoNaturalValor+this.habilidadNaturalValor+this.bonoNovelValor);
		}  else if (null==this.baseHabilidad && null!=this.especialHabilidad) {
			this.totalHabilidad = String.valueOf(0+Integer.parseInt(this.especialHabilidad)+Integer.parseInt(this.categoriaHabilidad)+Integer.parseInt(this.bonoHabilidad)+this.bonoNaturalValor+this.habilidadNaturalValor+this.bonoNovelValor);
			
		} else {
			this.totalHabilidad = "0";
			
		}
	}

	public String getNivelClase() {
		return nivelClase;
	}

	public void setNivelClase(String nivelClase) {
		this.nivelClase = nivelClase;
		if (this.categoriaHabilidad=="null"||this.categoriaHabilidad=="-"||null==this.categoriaHabilidad||this.categoriaHabilidadAux=="null"||this.categoriaHabilidadAux=="-"||null==this.categoriaHabilidadAux) {
			this.categoriaHabilidad = "0";
			this.categoriaHabilidadAux = "0";
			
		} else {
			this.categoriaHabilidad = this.categoriaHabilidadAux;
			for (int i = 1; i < Integer.parseInt(nivelClase); i++) {
				this.categoriaHabilidad = String.valueOf(Integer.parseInt(this.categoriaHabilidad) + Integer.parseInt(this.categoriaHabilidadAux));
			}
		}
		
		if (null!=this.baseHabilidad && null!=this.especialHabilidad) {
			this.totalHabilidad = String.valueOf(Integer.parseInt(this.baseHabilidad)+Integer.parseInt(this.especialHabilidad)+Integer.parseInt(this.categoriaHabilidad)+Integer.parseInt(this.bonoHabilidad));
		} else if (null!=this.baseHabilidad && null==this.especialHabilidad) {
			this.totalHabilidad = String.valueOf(Integer.parseInt(this.baseHabilidad)+0+Integer.parseInt(this.categoriaHabilidad)+Integer.parseInt(this.bonoHabilidad));
		}  else if (null==this.baseHabilidad && null!=this.especialHabilidad) {
			this.totalHabilidad = String.valueOf(0+Integer.parseInt(this.especialHabilidad)+Integer.parseInt(this.categoriaHabilidad)+Integer.parseInt(this.bonoHabilidad));
			
		} else {
			this.totalHabilidad = "0";
			
		}
	}
	
	
}
