package modelo;

public class CaracteristicaSeleccionada {
	private String nombreCaracteristica;
	private String baseCaracteristica;
	private String tempCaracteristica;
	private String totalCaracteristica;
	private String bonoCaracteristica;
	private String bonoRaza;
	
	public CaracteristicaSeleccionada(String nombreCaracteristica, String baseCaracteristica, String tempCaracteristica, String bonoRaza) {
		this.nombreCaracteristica = nombreCaracteristica;
		this.baseCaracteristica = baseCaracteristica;
		this.tempCaracteristica = tempCaracteristica;
		this.bonoRaza = bonoRaza;
		this.totalCaracteristica = String.valueOf(Integer.parseInt(this.baseCaracteristica)+Integer.parseInt(this.tempCaracteristica)+Integer.parseInt(this.bonoRaza));
		if (Integer.parseInt(this.totalCaracteristica)<=0) {
			this.bonoCaracteristica="-30";
		}
		else if (Integer.parseInt(this.totalCaracteristica)==1) {
			this.bonoCaracteristica="-30";
		}
		else if (Integer.parseInt(this.totalCaracteristica)==2) {
			this.bonoCaracteristica="-20";
		}
		else if (Integer.parseInt(this.totalCaracteristica)==3) {
			this.bonoCaracteristica="-10";
		}
		else if (Integer.parseInt(this.totalCaracteristica)==4) {
			this.bonoCaracteristica="-5";
		}
		else if (Integer.parseInt(this.totalCaracteristica)==5) {
			this.bonoCaracteristica="0";
		}
		else if (Integer.parseInt(this.totalCaracteristica)==6||Integer.parseInt(this.totalCaracteristica)==7) {
			this.bonoCaracteristica="5";
		}
		else if (Integer.parseInt(this.totalCaracteristica)==8||Integer.parseInt(this.totalCaracteristica)==9) {
			this.bonoCaracteristica="10";
		}
		else if (Integer.parseInt(this.totalCaracteristica)==10) {
			this.bonoCaracteristica="15";
		}
		else if (Integer.parseInt(this.totalCaracteristica)==11||Integer.parseInt(this.totalCaracteristica)==12) {
			this.bonoCaracteristica="20";
		}
		else if (Integer.parseInt(this.totalCaracteristica)==13||Integer.parseInt(this.totalCaracteristica)==14) {
			this.bonoCaracteristica="25";
		}
		else if (Integer.parseInt(this.totalCaracteristica)==15) {
			this.bonoCaracteristica="30";
		}
		else if (Integer.parseInt(this.totalCaracteristica)==16||Integer.parseInt(this.totalCaracteristica)==17) {
			this.bonoCaracteristica="35";
		}
		else if (Integer.parseInt(this.totalCaracteristica)==18||Integer.parseInt(this.totalCaracteristica)==19) {
			this.bonoCaracteristica="40";
		}
		else if (Integer.parseInt(this.totalCaracteristica)>=20) {
			this.bonoCaracteristica="45";
		}
	}

	public String getNombreCaracteristica() {
		return nombreCaracteristica;
	}

	public void setNombreCaracteristica(String nombreCaracteristica) {
		this.nombreCaracteristica = nombreCaracteristica;
	}

	public String getBaseCaracteristica() {
		return baseCaracteristica;
	}

	public void setBaseCaracteristica(String baseCaracteristica) {
		this.baseCaracteristica = baseCaracteristica;
	}

	public String getTempCaracteristica() {
		return tempCaracteristica;
	}

	public void setTempCaracteristica(String tempCaracteristica) {
		this.tempCaracteristica = tempCaracteristica;
	}

	public String getTotalCaracteristica() {
		return totalCaracteristica;
	}

	public void setTotalCaracteristica(String totalCaracteristica) {
		this.totalCaracteristica = totalCaracteristica;
	}

	public String getBonoCaracteristica() {
		return bonoCaracteristica;
	}

	public void setBonoCaracteristica(String totalCaracteristica) {
		if (Integer.parseInt(this.totalCaracteristica)<=0) {
			this.bonoCaracteristica="-30";
		}
		else if (Integer.parseInt(this.totalCaracteristica)==1) {
			this.bonoCaracteristica="-30";
		}
		else if (Integer.parseInt(this.totalCaracteristica)==2) {
			this.bonoCaracteristica="-20";
		}
		else if (Integer.parseInt(this.totalCaracteristica)==3) {
			this.bonoCaracteristica="-10";
		}
		else if (Integer.parseInt(this.totalCaracteristica)==4) {
			this.bonoCaracteristica="-5";
		}
		else if (Integer.parseInt(this.totalCaracteristica)==5) {
			this.bonoCaracteristica="0";
		}
		else if (Integer.parseInt(this.totalCaracteristica)==6||Integer.parseInt(this.totalCaracteristica)==7) {
			this.bonoCaracteristica="5";
		}
		else if (Integer.parseInt(this.totalCaracteristica)==8||Integer.parseInt(this.totalCaracteristica)==9) {
			this.bonoCaracteristica="10";
		}
		else if (Integer.parseInt(this.totalCaracteristica)==10) {
			this.bonoCaracteristica="15";
		}
		else if (Integer.parseInt(this.totalCaracteristica)==11||Integer.parseInt(this.totalCaracteristica)==12) {
			this.bonoCaracteristica="20";
		}
		else if (Integer.parseInt(this.totalCaracteristica)==13||Integer.parseInt(this.totalCaracteristica)==14) {
			this.bonoCaracteristica="25";
		}
		else if (Integer.parseInt(this.totalCaracteristica)==15) {
			this.bonoCaracteristica="30";
		}
		else if (Integer.parseInt(this.totalCaracteristica)==16||Integer.parseInt(this.totalCaracteristica)==17) {
			this.bonoCaracteristica="35";
		}
		else if (Integer.parseInt(this.totalCaracteristica)==18||Integer.parseInt(this.totalCaracteristica)==19) {
			this.bonoCaracteristica="40";
		}
		else if (Integer.parseInt(this.totalCaracteristica)>=20) {
			this.bonoCaracteristica="45";
		}
	}
	
	
}	
