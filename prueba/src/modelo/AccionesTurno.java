package modelo;

public class AccionesTurno {
	private String valorDestreza;
	private String valorAgilidad;
	private String numeroAcciones;
	
	public AccionesTurno(String valorDestreza, String valorAgilidad) {
		this.valorDestreza = valorDestreza;
		this.valorAgilidad = valorAgilidad;
		if (Integer.parseInt(this.valorDestreza)+Integer.parseInt(this.valorAgilidad)==10) {
			this.numeroAcciones = "1";
		} else if (Integer.parseInt(this.valorDestreza)+Integer.parseInt(this.valorAgilidad)==11 || 
				   Integer.parseInt(this.valorDestreza)+Integer.parseInt(this.valorAgilidad)==12 || 
				   Integer.parseInt(this.valorDestreza)+Integer.parseInt(this.valorAgilidad)==13 || 
				   Integer.parseInt(this.valorDestreza)+Integer.parseInt(this.valorAgilidad)==14) {
			this.numeroAcciones = "2";
		} else if (Integer.parseInt(this.valorDestreza)+Integer.parseInt(this.valorAgilidad)==15 || 
				   Integer.parseInt(this.valorDestreza)+Integer.parseInt(this.valorAgilidad)==16 || 
				   Integer.parseInt(this.valorDestreza)+Integer.parseInt(this.valorAgilidad)==17 || 
				   Integer.parseInt(this.valorDestreza)+Integer.parseInt(this.valorAgilidad)==18 || 
				   Integer.parseInt(this.valorDestreza)+Integer.parseInt(this.valorAgilidad)==19) {
			this.numeroAcciones = "3";
		} else if (Integer.parseInt(this.valorDestreza)+Integer.parseInt(this.valorAgilidad)==20 || 
				   Integer.parseInt(this.valorDestreza)+Integer.parseInt(this.valorAgilidad)==21 || 
				   Integer.parseInt(this.valorDestreza)+Integer.parseInt(this.valorAgilidad)==22) {
			this.numeroAcciones = "4";
		} else if (Integer.parseInt(this.valorDestreza)+Integer.parseInt(this.valorAgilidad)==23 || 
				   Integer.parseInt(this.valorDestreza)+Integer.parseInt(this.valorAgilidad)==24 || 
				   Integer.parseInt(this.valorDestreza)+Integer.parseInt(this.valorAgilidad)==25) {
			this.numeroAcciones = "5";
		} else if (Integer.parseInt(this.valorDestreza)+Integer.parseInt(this.valorAgilidad)==26 || 
				   Integer.parseInt(this.valorDestreza)+Integer.parseInt(this.valorAgilidad)==27 || 
				   Integer.parseInt(this.valorDestreza)+Integer.parseInt(this.valorAgilidad)==28) {
			this.numeroAcciones = "6";
		} else if (Integer.parseInt(this.valorDestreza)+Integer.parseInt(this.valorAgilidad)==29 || 
				   Integer.parseInt(this.valorDestreza)+Integer.parseInt(this.valorAgilidad)==30 || 
				   Integer.parseInt(this.valorDestreza)+Integer.parseInt(this.valorAgilidad)==31) {
			this.numeroAcciones = "8";
		} else if (Integer.parseInt(this.valorDestreza)+Integer.parseInt(this.valorAgilidad)>=32) {
			this.numeroAcciones = "10";
		}
		
	}

	public String getValorDestreza() {
		return valorDestreza;
	}

	public void setValorDestreza(String valorDestreza) {
		this.valorDestreza = valorDestreza;
	}

	public String getValorAgilidad() {
		return valorAgilidad;
	}

	public void setValorAgilidad(String valorAgilidad) {
		this.valorAgilidad = valorAgilidad;
	}

	public String getNumeroAcciones() {
		return numeroAcciones;
	}

	public void setNumeroAcciones(String numeroAcciones) {
		this.numeroAcciones = numeroAcciones;
	}
	
	
	
	
}
