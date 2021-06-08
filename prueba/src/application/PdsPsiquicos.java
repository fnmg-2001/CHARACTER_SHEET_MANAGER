package application;

public class PdsPsiquicos {

	private String nombreHabilidad;
	private String costeHabilidad;
	private String pdsHabilidad;
	private String baseHabilidad;
	private String bonoHabilidad;
	private String categoriaHabilidad;
	private String especialHabilidad;
	private String totalHabilidad;
	
	public PdsPsiquicos(String nombreHabilidad, String costeHabilidad, String pdsHabilidad,
			String bonoHabilidad, String categoriaHabilidad, String especialHabilidad) {
		this.nombreHabilidad = nombreHabilidad;
		this.costeHabilidad = costeHabilidad;
		this.pdsHabilidad = pdsHabilidad;
		
		if (null!=this.pdsHabilidad && null!=this.costeHabilidad) {
			this.baseHabilidad = String.valueOf((Integer.parseInt(pdsHabilidad)/Integer.parseInt(this.costeHabilidad)));
			
		} else if (null==this.pdsHabilidad && null==this.especialHabilidad) {
			this.baseHabilidad = "0";
			
		}
		
		this.bonoHabilidad = bonoHabilidad;
		if (this.categoriaHabilidad=="null"||this.bonoHabilidad=="-"||null==this.bonoHabilidad) {
			this.bonoHabilidad = "0";
			
		}else {
			this.bonoHabilidad = bonoHabilidad;
		}
		
		this.categoriaHabilidad = categoriaHabilidad;
		if (this.categoriaHabilidad=="null"||this.categoriaHabilidad=="-"||null==this.categoriaHabilidad) {
			this.categoriaHabilidad = "0";
			
		}else {
			this.categoriaHabilidad = categoriaHabilidad;
		}
		
		this.especialHabilidad = especialHabilidad;
		
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
			
		} else if (null==this.pdsHabilidad && null==this.especialHabilidad) {
			this.baseHabilidad = "0";
			
		}
		
		if (null!=this.baseHabilidad && null!=this.especialHabilidad) {
			this.totalHabilidad = String.valueOf(Integer.parseInt(this.baseHabilidad)+Integer.parseInt(this.especialHabilidad)+Integer.parseInt(categoriaHabilidad)+Integer.parseInt(bonoHabilidad));
		} else if (null!=this.baseHabilidad && null==this.especialHabilidad) {
			this.totalHabilidad = String.valueOf(Integer.parseInt(this.baseHabilidad)+0+Integer.parseInt(categoriaHabilidad)+Integer.parseInt(bonoHabilidad));
		}  else if (null==this.baseHabilidad && null!=this.especialHabilidad) {
			this.totalHabilidad = String.valueOf(0+Integer.parseInt(this.especialHabilidad)+Integer.parseInt(categoriaHabilidad)+Integer.parseInt(bonoHabilidad));
			
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
			
		} else if (null==this.pdsHabilidad && null==this.especialHabilidad) {
			this.baseHabilidad = "0";
			
		}
		
		if (null!=this.baseHabilidad && null!=this.especialHabilidad) {
			this.totalHabilidad = String.valueOf(Integer.parseInt(this.baseHabilidad)+Integer.parseInt(this.especialHabilidad)+Integer.parseInt(categoriaHabilidad)+Integer.parseInt(bonoHabilidad));
		} else if (null!=this.baseHabilidad && null==this.especialHabilidad) {
			this.totalHabilidad = String.valueOf(Integer.parseInt(this.baseHabilidad)+0+Integer.parseInt(categoriaHabilidad)+Integer.parseInt(bonoHabilidad));
		}  else if (null==this.baseHabilidad && null!=this.especialHabilidad) {
			this.totalHabilidad = String.valueOf(0+Integer.parseInt(this.especialHabilidad)+Integer.parseInt(categoriaHabilidad)+Integer.parseInt(bonoHabilidad));
			
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
		if (null!=this.pdsHabilidad && null!=this.costeHabilidad) {
			this.baseHabilidad = String.valueOf((Integer.parseInt(pdsHabilidad)/Integer.parseInt(this.costeHabilidad)));
			
		} else if (null==this.pdsHabilidad && null==this.especialHabilidad) {
			this.baseHabilidad = "0";
			
		}
		
		if (null!=this.baseHabilidad && null!=this.especialHabilidad) {
			this.totalHabilidad = String.valueOf(Integer.parseInt(this.baseHabilidad)+Integer.parseInt(this.especialHabilidad)+Integer.parseInt(categoriaHabilidad)+Integer.parseInt(bonoHabilidad));
		} else if (null!=this.baseHabilidad && null==this.especialHabilidad) {
			this.totalHabilidad = String.valueOf(Integer.parseInt(this.baseHabilidad)+0+Integer.parseInt(categoriaHabilidad)+Integer.parseInt(bonoHabilidad));
		}  else if (null==this.baseHabilidad && null!=this.especialHabilidad) {
			this.totalHabilidad = String.valueOf(0+Integer.parseInt(this.especialHabilidad)+Integer.parseInt(categoriaHabilidad)+Integer.parseInt(bonoHabilidad));
			
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
	
}
