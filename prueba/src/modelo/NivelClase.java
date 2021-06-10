package modelo;

public class NivelClase {
	private String nombreClase;
	private String nivel;
	private String pds;
	private String bonoNatural;
	private String habilidadNatural;
	private String bonoNovel;
	
	public NivelClase(String nombreClase, String nivel) {
		this.nombreClase = nombreClase;
		this.nivel = nivel;
		this.pds = "600";
		this.bonoNatural = "0";
		this.habilidadNatural = "0";
		this.bonoNovel = "0";
		
		for (int i = 0; i < Integer.parseInt(this.nivel); i++) {
			this.bonoNatural = String.valueOf(Integer.parseInt(this.bonoNatural)+5);
			this.habilidadNatural = String.valueOf(Integer.parseInt(this.habilidadNatural)+5);
		}
		
		if (this.nombreClase=="NOVEL"||this.nombreClase.equals("NOVEL")) {
			for (int i = 0; i < Integer.parseInt(this.nivel); i++) {
				this.bonoNovel = String.valueOf(Integer.parseInt(this.bonoNovel)+5);
			}
		}
		else {
			this.bonoNovel = "0";
		}
		
		for (int i = 1; i < Integer.parseInt(this.nivel); i++) {
			this.pds = String.valueOf(Integer.parseInt(this.pds)+100);
		}
		
		
	}
	
	public String getNombreClase() {
		return nombreClase;
	}
	public void setNombreClase(String nombreClase) {
		this.nombreClase = nombreClase;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
		this.pds="600";
		this.bonoNatural = "0";
		this.bonoNovel = "0";
		this.habilidadNatural = "0";
		
		for (int i = 0; i < Integer.parseInt(this.nivel); i++) {
			this.bonoNatural = String.valueOf(Integer.parseInt(this.bonoNatural)+5);
			this.habilidadNatural = String.valueOf(Integer.parseInt(this.habilidadNatural)+5);
		}
		
		if ("NOVEL"==this.nombreClase||this.nombreClase.equals("NOVEL")) {
			for (int i = 0; i < Integer.parseInt(this.nivel); i++) {
				this.bonoNovel = String.valueOf(Integer.parseInt(this.bonoNovel)+5);
			}
		}
		else {
			this.bonoNovel = "0";
		}
		
		for (int i = 1; i < Integer.parseInt(this.nivel); i++) {
			this.pds = String.valueOf(Integer.parseInt(this.pds)+100);
		}
	}
	public String getPds() {
		return pds;
	}
	public void setPds(String pds) {
		this.pds = pds;
	}

	public String getBonoNatural() {
		return bonoNatural;
	}

	public void setBonoNatural(String bonoNatural) {
		this.bonoNatural = bonoNatural;
	}

	public String getHabilidadNatural() {
		return habilidadNatural;
	}

	public void setHabilidadNatural(String habilidadNatural) {
		this.habilidadNatural = habilidadNatural;
	}

	public String getBonoNovel() {
		return bonoNovel;
	}

	public void setBonoNovel(String bonoNovel) {
		this.bonoNovel = bonoNovel;
	}
	
	
}
