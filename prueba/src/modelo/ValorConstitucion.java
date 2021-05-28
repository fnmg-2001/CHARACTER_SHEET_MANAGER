package modelo;

public class ValorConstitucion {
	private String constitucion;
	private String puntosVidaBase;
	private String regeneracionBase;
	private String curacionDia;
	private String negativoDia;
	
	public ValorConstitucion(String constitucion) {
		this.constitucion = constitucion;
		/*Puntos de vida y nivel de regeneracion*/
		if (Integer.parseInt(this.constitucion)==0) {
			this.puntosVidaBase="-";
			this.regeneracionBase="-";
			this.curacionDia="-";
			this.negativoDia="-";
		} else if (Integer.parseInt(this.constitucion)==1) {
			this.puntosVidaBase="5";
			this.regeneracionBase="-";
		} else if (Integer.parseInt(this.constitucion)==2) {
			this.puntosVidaBase="20";
			this.regeneracionBase="-";
		} else if (Integer.parseInt(this.constitucion)==3) {
			this.puntosVidaBase="40";
			this.regeneracionBase="1";
		} else if (Integer.parseInt(this.constitucion)==4) {
			this.puntosVidaBase="55";
			this.regeneracionBase="1";
		} else if (Integer.parseInt(this.constitucion)==5) {
			this.puntosVidaBase="70";
			this.regeneracionBase="1";
		} else if (Integer.parseInt(this.constitucion)==6) {
			this.puntosVidaBase="85";
			this.regeneracionBase="1";
		} else if (Integer.parseInt(this.constitucion)==7) {
			this.puntosVidaBase="95";
			this.regeneracionBase="1";
		} else if (Integer.parseInt(this.constitucion)==8) {
			this.puntosVidaBase="110";
			this.regeneracionBase="2";
		} else if (Integer.parseInt(this.constitucion)==9) {
			this.puntosVidaBase="120";
			this.regeneracionBase="2";
		} else if (Integer.parseInt(this.constitucion)==10) {
			this.puntosVidaBase="135";
			this.regeneracionBase="3";
		} else if (Integer.parseInt(this.constitucion)==11) {
			this.puntosVidaBase="150";
			this.regeneracionBase="4";
		} else if (Integer.parseInt(this.constitucion)==12) {
			this.puntosVidaBase="160";
			this.regeneracionBase="5";
		} else if (Integer.parseInt(this.constitucion)==13) {
			this.puntosVidaBase="175";
			this.regeneracionBase="6";
		} else if (Integer.parseInt(this.constitucion)==14) {
			this.puntosVidaBase="185";
			this.regeneracionBase="7";
		} else if (Integer.parseInt(this.constitucion)==15) {
			this.puntosVidaBase="200";
			this.regeneracionBase="8";
		} else if (Integer.parseInt(this.constitucion)==16) {
			this.puntosVidaBase="215";
			this.regeneracionBase="9";
		} else if (Integer.parseInt(this.constitucion)==17) {
			this.puntosVidaBase="225";
			this.regeneracionBase="10";
		} else if (Integer.parseInt(this.constitucion)==18) {
			this.puntosVidaBase="240";
			this.regeneracionBase="11";
		} else if (Integer.parseInt(this.constitucion)==19) {
			this.puntosVidaBase="250";
			this.regeneracionBase="12";
		} else if (Integer.parseInt(this.constitucion)==20) {
			this.puntosVidaBase="265";
			this.regeneracionBase="12";
		}
		
		/*Recuperacion al dia por nivel de regeneracion*/
		if (Integer.parseInt(this.regeneracionBase)==0) {
			this.curacionDia="-";
			this.negativoDia="-";
		} else if (Integer.parseInt(this.regeneracionBase)==1) {
			this.curacionDia="10/DIA";
			this.negativoDia="-5/DIA";
		} else if (Integer.parseInt(this.regeneracionBase)==2) {
			this.curacionDia="20/DIA";
			this.negativoDia="-5/DIA";
		} else if (Integer.parseInt(this.regeneracionBase)==3) {
			this.curacionDia="30/DIA";
			this.negativoDia="-5/DIA";
		} else if (Integer.parseInt(this.regeneracionBase)==4) {
			this.curacionDia="40/DIA";
			this.negativoDia="-10/DIA";
		} else if (Integer.parseInt(this.regeneracionBase)==5) {
			this.curacionDia="50/DIA";
			this.negativoDia="-10/DIA";
		} else if (Integer.parseInt(this.regeneracionBase)==6) {
			this.curacionDia="75/DIA";
			this.negativoDia="-15/DIA";
		} else if (Integer.parseInt(this.regeneracionBase)==7) {
			this.curacionDia="100/DIA";
			this.negativoDia="-20/DIA";
		} else if (Integer.parseInt(this.regeneracionBase)==8) {
			this.curacionDia="250/DIA";
			this.negativoDia="-25/DIA";
		} else if (Integer.parseInt(this.regeneracionBase)==9) {
			this.curacionDia="500/DIA";
			this.negativoDia="-30/DIA";
		} else if (Integer.parseInt(this.regeneracionBase)==10) {
			this.curacionDia="1/MINUTO";
			this.negativoDia="-40/DIA";
		} else if (Integer.parseInt(this.regeneracionBase)==11) {
			this.curacionDia="2/MINUTO";
			this.negativoDia="-50/DIA";
		} else if (Integer.parseInt(this.regeneracionBase)==12) {
			this.curacionDia="5/MINUTO";
			this.negativoDia="-5/HORA";
		} else if (Integer.parseInt(this.regeneracionBase)==13) {
			this.curacionDia="10/MINUTO";
			this.negativoDia="-10/HORA";
		} else if (Integer.parseInt(this.regeneracionBase)==14) {
			this.curacionDia="1/ASALTO";
			this.negativoDia="-15/HORA";
		} else if (Integer.parseInt(this.regeneracionBase)==15) {
			this.curacionDia="5/ASALTO";
			this.negativoDia="-20/HORA";
		} else if (Integer.parseInt(this.regeneracionBase)==16) {
			this.curacionDia="10/ASALTO";
			this.negativoDia="-10/MINUTO";
		} else if (Integer.parseInt(this.regeneracionBase)==17) {
			this.curacionDia="25/ASALTO";
			this.negativoDia="-10/ASALTO";
		} else if (Integer.parseInt(this.regeneracionBase)==18) {
			this.curacionDia="50/ASALTO";
			this.negativoDia="-25/ASALTO";
		} else if (Integer.parseInt(this.regeneracionBase)==19) {
			this.curacionDia="100/ASALTO";
			this.negativoDia="TODOS";
		} else if (Integer.parseInt(this.regeneracionBase)==20) {
			this.curacionDia="250/ASALTO";
			this.negativoDia="TODOS";
		}
	}

	public String getConstitucion() {
		return constitucion;
	}

	public void setConstitucion(String constitucion) {
		this.constitucion = constitucion;
	}

	public String getPuntosVidaBase() {
		return puntosVidaBase;
	}

	public void setPuntosVidaBase(String puntosVidaBase) {
		this.puntosVidaBase = puntosVidaBase;
	}

	public String getRegeneracionBase() {
		return regeneracionBase;
	}

	public void setRegeneracionBase(String regeneracionBase) {
		this.regeneracionBase = regeneracionBase;
	}

	public String getCuracionDia() {
		return curacionDia;
	}

	public void setCuracionDia(String curacionDia) {
		this.curacionDia = curacionDia;
	}

	public String getNegativoDia() {
		return negativoDia;
	}

	public void setNegativoDia(String negativoDia) {
		this.negativoDia = negativoDia;
	}
	
	
}
