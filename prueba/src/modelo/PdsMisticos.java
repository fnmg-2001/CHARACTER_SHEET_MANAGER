package modelo;

public class PdsMisticos {
	private String nombreHabilidad;
	private String costeHabilidad;
	private String pdsHabilidad;
	private String baseHabilidad;
	private String bonoHabilidad;
	private String categoriaHabilidad;
	private String categoriaHabilidadAux;
	private String especialHabilidad;
	private String totalHabilidad;
	private String nivelClase;
	
	public PdsMisticos(String nombreHabilidad, String costeHabilidad, String pdsHabilidad,
			String bonoHabilidad, String categoriaHabilidad, String especialHabilidad , String nivelClase) {
		this.nombreHabilidad = nombreHabilidad;
		this.costeHabilidad = costeHabilidad;
		this.pdsHabilidad = pdsHabilidad;
		this.nivelClase = nivelClase;
		
		this.bonoHabilidad = bonoHabilidad;
		if (this.categoriaHabilidad=="null"||this.bonoHabilidad=="-"||null==this.bonoHabilidad) {
			this.bonoHabilidad = "0";
			
		} else if (this.nombreHabilidad=="Zeon"&&this.getBonoHabilidad()=="-30") {
			this.bonoHabilidad = "5";
			
		} else if (this.nombreHabilidad=="Zeon"&&this.getBonoHabilidad()=="-20") {
			this.bonoHabilidad = "20";
			
		} else if (this.nombreHabilidad=="Zeon"&&this.getBonoHabilidad()=="-10") {
			this.bonoHabilidad = "40";
			
		} else if (this.nombreHabilidad=="Zeon"&&this.getBonoHabilidad()=="-5") {
			this.bonoHabilidad = "55";
			
		} else if (this.nombreHabilidad=="Zeon"&&this.getBonoHabilidad()=="0") {
			this.bonoHabilidad = "70";
			
		} else if (this.nombreHabilidad=="Zeon"&&this.getBonoHabilidad()=="5") {
			this.bonoHabilidad = "95";
			
		} else if (this.nombreHabilidad=="Zeon"&&this.getBonoHabilidad()=="10") {
			this.bonoHabilidad = "120";
			
		} else if (this.nombreHabilidad=="Zeon"&&this.getBonoHabilidad()=="15") {
			this.bonoHabilidad = "135";
			
		} else if (this.nombreHabilidad=="Zeon"&&this.getBonoHabilidad()=="20") {
			this.bonoHabilidad = "160";
			
		} else if (this.nombreHabilidad=="Zeon"&&this.getBonoHabilidad()=="25") {
			this.bonoHabilidad = "185";
			
		} else if (this.nombreHabilidad=="Zeon"&&this.getBonoHabilidad()=="30") {
			this.bonoHabilidad = "215";
			
		} else if (this.nombreHabilidad=="Zeon"&&this.getBonoHabilidad()=="35") {
			this.bonoHabilidad = "215";
			
		} else if (this.nombreHabilidad=="Zeon"&&this.getBonoHabilidad()=="40") {
			this.bonoHabilidad = "250";
			
		} else if (this.nombreHabilidad=="Zeon"&&this.getBonoHabilidad()=="45") {
			this.bonoHabilidad = "265";
			
		} else if (this.nombreHabilidad=="ACT"&&((Integer.parseInt(this.getBonoHabilidad())>=-30 && Integer.parseInt(this.getBonoHabilidad())<=-5))) {
			this.bonoHabilidad = "0";
			
		} else if (this.nombreHabilidad=="ACT"&&((Integer.parseInt(this.getBonoHabilidad())>=0 && Integer.parseInt(this.getBonoHabilidad())<=5))) {
			this.bonoHabilidad = "5";
			
		} else if (this.nombreHabilidad=="ACT"&&((Integer.parseInt(this.getBonoHabilidad())>=10 && Integer.parseInt(this.getBonoHabilidad())<=20))) {
			this.bonoHabilidad = "10";
			
		} else if (this.nombreHabilidad=="ACT"&&((Integer.parseInt(this.getBonoHabilidad())>=20 && Integer.parseInt(this.getBonoHabilidad())<=25))) {
			this.bonoHabilidad = "15";
			
		} else if (this.nombreHabilidad=="ACT"&&Integer.parseInt(this.getBonoHabilidad())>=30) {
			this.bonoHabilidad = "20";
			
		} else if (this.nombreHabilidad=="ACT"&&Integer.parseInt(this.getBonoHabilidad())>=35) {
			this.bonoHabilidad = "25";
			
		} else if (this.nombreHabilidad=="ACT"&&Integer.parseInt(this.getBonoHabilidad())>=40) {
			this.bonoHabilidad = "30";
			
		} else if (this.nombreHabilidad=="ACT"&&Integer.parseInt(this.getBonoHabilidad())>=45) {
			this.bonoHabilidad = "35";
			
		} else {
			this.bonoHabilidad = bonoHabilidad;
		}
		
		if (null!=this.pdsHabilidad && this.nombreHabilidad == "ACT") {
			this.baseHabilidad = String.valueOf((Integer.parseInt(pdsHabilidad)/Integer.parseInt(this.costeHabilidad))*10);
			
		} else if (null!=this.pdsHabilidad && this.nombreHabilidad == "Multiplo de regeneracion") {
			this.baseHabilidad = String.valueOf(((Integer.parseInt(pdsHabilidad)/Integer.parseInt(this.costeHabilidad))*10));
			
		} else if (null!=this.pdsHabilidad && this.nombreHabilidad == "Nivel de Magia") {
			this.baseHabilidad = String.valueOf((Integer.parseInt(pdsHabilidad)/Integer.parseInt(this.costeHabilidad))*5);
			
		} else if (null!=this.pdsHabilidad && null!=this.costeHabilidad) {
			this.baseHabilidad = String.valueOf((Integer.parseInt(pdsHabilidad)/Integer.parseInt(this.costeHabilidad)));
			
		} else if (null==this.pdsHabilidad && null==this.especialHabilidad) {
			this.baseHabilidad = "0";
			
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
		if (null!=this.pdsHabilidad && this.nombreHabilidad == "ACT") {
			this.baseHabilidad = String.valueOf((Integer.parseInt(pdsHabilidad)/Integer.parseInt(this.costeHabilidad))*10);
			
		} else if (null!=this.pdsHabilidad && this.nombreHabilidad == "Multiplo de regeneracion") {
			this.baseHabilidad = String.valueOf(((Integer.parseInt(pdsHabilidad)/Integer.parseInt(this.costeHabilidad))*10));
			
		} else if (null!=this.pdsHabilidad && this.nombreHabilidad == "Nivel de Magia") {
			this.baseHabilidad = String.valueOf((Integer.parseInt(pdsHabilidad)/Integer.parseInt(this.costeHabilidad))*5);
			
		} else if (null!=this.pdsHabilidad && null!=this.costeHabilidad) {
			this.baseHabilidad = String.valueOf((Integer.parseInt(pdsHabilidad)/Integer.parseInt(this.costeHabilidad)));
			
		} else if (null==this.pdsHabilidad && null==this.especialHabilidad) {
			this.baseHabilidad = "0";
			
		}
		
		if (null!=this.baseHabilidad && null!=this.especialHabilidad) {
			this.totalHabilidad = String.valueOf(Integer.parseInt(this.baseHabilidad)+Integer.parseInt(this.especialHabilidad)+Integer.parseInt(categoriaHabilidad)+Integer.parseInt(bonoHabilidad));
		} else if (null!=this.baseHabilidad && null==this.especialHabilidad) {
			this.totalHabilidad = String.valueOf(Integer.parseInt(this.baseHabilidad)+0+Integer.parseInt(categoriaHabilidad)+Integer.parseInt(this.bonoHabilidad));
		}  else if (null==this.baseHabilidad && null!=this.especialHabilidad) {
			this.totalHabilidad = String.valueOf(0+Integer.parseInt(this.especialHabilidad)+Integer.parseInt(categoriaHabilidad)+Integer.parseInt(this.bonoHabilidad));
			
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
		if (this.categoriaHabilidad=="null"||this.bonoHabilidad=="-"||null==this.bonoHabilidad) {
			this.bonoHabilidad = "0";
			
		} else if (this.nombreHabilidad=="Zeon"&&this.getBonoHabilidad()=="-30") {
			this.bonoHabilidad = "5";
			
		} else if (this.nombreHabilidad=="Zeon"&&this.getBonoHabilidad()=="-20") {
			this.bonoHabilidad = "20";
			
		} else if (this.nombreHabilidad=="Zeon"&&this.getBonoHabilidad()=="-10") {
			this.bonoHabilidad = "40";
			
		} else if (this.nombreHabilidad=="Zeon"&&this.getBonoHabilidad()=="-5") {
			this.bonoHabilidad = "55";
			
		} else if (this.nombreHabilidad=="Zeon"&&this.getBonoHabilidad()=="0") {
			this.bonoHabilidad = "70";
			
		} else if (this.nombreHabilidad=="Zeon"&&this.getBonoHabilidad()=="5") {
			this.bonoHabilidad = "95";
			
		} else if (this.nombreHabilidad=="Zeon"&&this.getBonoHabilidad()=="10") {
			this.bonoHabilidad = "120";
			
		} else if (this.nombreHabilidad=="Zeon"&&this.getBonoHabilidad()=="15") {
			this.bonoHabilidad = "135";
			
		} else if (this.nombreHabilidad=="Zeon"&&this.getBonoHabilidad()=="20") {
			this.bonoHabilidad = "160";
			
		} else if (this.nombreHabilidad=="Zeon"&&this.getBonoHabilidad()=="25") {
			this.bonoHabilidad = "185";
			
		} else if (this.nombreHabilidad=="Zeon"&&this.getBonoHabilidad()=="30") {
			this.bonoHabilidad = "215";
			
		} else if (this.nombreHabilidad=="Zeon"&&this.getBonoHabilidad()=="35") {
			this.bonoHabilidad = "215";
			
		} else if (this.nombreHabilidad=="Zeon"&&this.getBonoHabilidad()=="40") {
			this.bonoHabilidad = "250";
			
		} else if (this.nombreHabilidad=="Zeon"&&this.getBonoHabilidad()=="45") {
			this.bonoHabilidad = "265";
			
		} else if (this.nombreHabilidad=="ACT"&&((Integer.parseInt(this.getBonoHabilidad())>=-30 && Integer.parseInt(this.getBonoHabilidad())<=-5))) {
			this.bonoHabilidad = "0";
			
		} else if (this.nombreHabilidad=="ACT"&&((Integer.parseInt(this.getBonoHabilidad())>=0 && Integer.parseInt(this.getBonoHabilidad())<=5))) {
			this.bonoHabilidad = "5";
			
		} else if (this.nombreHabilidad=="ACT"&&((Integer.parseInt(this.getBonoHabilidad())>=10 && Integer.parseInt(this.getBonoHabilidad())<=20))) {
			this.bonoHabilidad = "10";
			
		} else if (this.nombreHabilidad=="ACT"&&((Integer.parseInt(this.getBonoHabilidad())>=20 && Integer.parseInt(this.getBonoHabilidad())<=25))) {
			this.bonoHabilidad = "15";
			
		} else if (this.nombreHabilidad=="ACT"&&Integer.parseInt(this.getBonoHabilidad())>=30) {
			this.bonoHabilidad = "20";
			
		} else if (this.nombreHabilidad=="ACT"&&Integer.parseInt(this.getBonoHabilidad())>=35) {
			this.bonoHabilidad = "25";
			
		} else if (this.nombreHabilidad=="ACT"&&Integer.parseInt(this.getBonoHabilidad())>=40) {
			this.bonoHabilidad = "30";
			
		} else if (this.nombreHabilidad=="ACT"&&Integer.parseInt(this.getBonoHabilidad())>=45) {
			this.bonoHabilidad = "35";
			
		} else {
			this.bonoHabilidad = bonoHabilidad;
		}
		

		if (null!=this.pdsHabilidad && this.nombreHabilidad == "ACT") {
			this.baseHabilidad = String.valueOf((Integer.parseInt(pdsHabilidad)/Integer.parseInt(this.costeHabilidad))*10);
			
		} else if (null!=this.pdsHabilidad && this.nombreHabilidad == "Multiplo de regeneracion") {
			this.baseHabilidad = String.valueOf(((Integer.parseInt(pdsHabilidad)/Integer.parseInt(this.costeHabilidad))*10));
			
		} else if (null!=this.pdsHabilidad && this.nombreHabilidad == "Nivel de Magia") {
			this.baseHabilidad = String.valueOf((Integer.parseInt(pdsHabilidad)/Integer.parseInt(this.costeHabilidad))*5);
			
		} else if (null!=this.pdsHabilidad && null!=this.costeHabilidad) {
			this.baseHabilidad = String.valueOf((Integer.parseInt(pdsHabilidad)/Integer.parseInt(this.costeHabilidad)));
			
		} else if (null==this.pdsHabilidad && null==this.especialHabilidad) {
			this.baseHabilidad = "0";
			
		}
		
		
		if (null!=this.baseHabilidad && null!=this.especialHabilidad) {
			this.totalHabilidad = String.valueOf(Integer.parseInt(this.baseHabilidad)+Integer.parseInt(this.especialHabilidad)+Integer.parseInt(categoriaHabilidad)+Integer.parseInt(bonoHabilidad));
		} else if (null!=this.baseHabilidad && null==this.especialHabilidad) {
			this.totalHabilidad = String.valueOf(Integer.parseInt(this.baseHabilidad)+0+Integer.parseInt(categoriaHabilidad)+Integer.parseInt(this.bonoHabilidad));
		}  else if (null==this.baseHabilidad && null!=this.especialHabilidad) {
			this.totalHabilidad = String.valueOf(0+Integer.parseInt(this.especialHabilidad)+Integer.parseInt(categoriaHabilidad)+Integer.parseInt(this.bonoHabilidad));
			
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
		if (null!=this.pdsHabilidad && this.nombreHabilidad == "ACT") {
			this.baseHabilidad = String.valueOf((Integer.parseInt(pdsHabilidad)/Integer.parseInt(this.costeHabilidad))*10);
			
		} else if (null!=this.pdsHabilidad && this.nombreHabilidad == "Multiplo de regeneracion") {
			this.baseHabilidad = String.valueOf(((Integer.parseInt(pdsHabilidad)/Integer.parseInt(this.costeHabilidad))*10));
			
		} else if (null!=this.pdsHabilidad && this.nombreHabilidad == "Nivel de Magia") {
			this.baseHabilidad = String.valueOf((Integer.parseInt(pdsHabilidad)/Integer.parseInt(this.costeHabilidad))*5);
			
		} else if (null!=this.pdsHabilidad && null!=this.costeHabilidad) {
			this.baseHabilidad = String.valueOf((Integer.parseInt(pdsHabilidad)/Integer.parseInt(this.costeHabilidad)));
			
		} else if (null==this.pdsHabilidad && null==this.especialHabilidad) {
			this.baseHabilidad = "0";
			
		}
		
		if (null!=this.baseHabilidad && null!=this.especialHabilidad) {
			this.totalHabilidad = String.valueOf(Integer.parseInt(this.baseHabilidad)+Integer.parseInt(this.especialHabilidad)+Integer.parseInt(categoriaHabilidad)+Integer.parseInt(bonoHabilidad));
		} else if (null!=this.baseHabilidad && null==this.especialHabilidad) {
			this.totalHabilidad = String.valueOf(Integer.parseInt(this.baseHabilidad)+0+Integer.parseInt(categoriaHabilidad)+Integer.parseInt(this.bonoHabilidad));
		}  else if (null==this.baseHabilidad && null!=this.especialHabilidad) {
			this.totalHabilidad = String.valueOf(0+Integer.parseInt(this.especialHabilidad)+Integer.parseInt(categoriaHabilidad)+Integer.parseInt(this.bonoHabilidad));
			
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
