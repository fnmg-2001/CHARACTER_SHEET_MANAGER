package modelo;

public class PotencialPsiquico {
	private String voluntad;
	private String potencial;
	private String cv;
	private String bonoCv;
	
	public PotencialPsiquico(String voluntad, String cv) {
		this.voluntad = voluntad;
		this.potencial = "0";
		this.cv = cv;
		
		if (Integer.parseInt(cv)>=1&&Integer.parseInt(cv)<3) {
			this.bonoCv="10";
		} else if (Integer.parseInt(cv)>=3&&Integer.parseInt(cv)<6) {
			this.bonoCv = "20";
		} else if (Integer.parseInt(cv)>=6&&Integer.parseInt(cv)<10) {
			this.bonoCv = "30";
		} else if (Integer.parseInt(cv)>=10&&Integer.parseInt(cv)<15) {
			this.bonoCv = "40";
		} else if (Integer.parseInt(cv)>=15&&Integer.parseInt(cv)<21) {
			this.bonoCv = "50";
		} else if (Integer.parseInt(cv)>=21&&Integer.parseInt(cv)<28) {
			this.bonoCv = "60";
		} else if (Integer.parseInt(cv)>=28&&Integer.parseInt(cv)<36) {
			this.bonoCv = "70";
		} else if (Integer.parseInt(cv)>=36&&Integer.parseInt(cv)<45) {
			this.bonoCv = "80";
		} else if (Integer.parseInt(cv)>=45&&Integer.parseInt(cv)<55) {
			this.bonoCv = "90";
		} else if (Integer.parseInt(cv)>=55) {
			this.bonoCv = "100";
		} else {
			this.bonoCv = "0";
		}
		
		if (Integer.parseInt(voluntad)<=4) {
			this.potencial = String.valueOf(Integer.parseInt("0")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(voluntad)==5) {
			this.potencial = String.valueOf(Integer.parseInt("10")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(voluntad)==6) {
			this.potencial = String.valueOf(Integer.parseInt("20")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(voluntad)==7) {
			this.potencial = String.valueOf(Integer.parseInt("30")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(voluntad)==8) {
			this.potencial = String.valueOf(Integer.parseInt("40")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(voluntad)==9) {
			this.potencial = "50";String.valueOf(Integer.parseInt("50")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(voluntad)==10) {
			this.potencial = "60";String.valueOf(Integer.parseInt("60")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(voluntad)==11) {
			this.potencial = "70";String.valueOf(Integer.parseInt("70")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(voluntad)==12) {
			this.potencial = "80";String.valueOf(Integer.parseInt("80")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(voluntad)==13) {
			this.potencial = "90";String.valueOf(Integer.parseInt("90")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(voluntad)==14) {
			this.potencial = "100";String.valueOf(Integer.parseInt("100")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(voluntad)==15) {
			this.potencial = "120";String.valueOf(Integer.parseInt("120")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(voluntad)==16) {
			this.potencial = "140";String.valueOf(Integer.parseInt("140")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(voluntad)==17) {
			this.potencial = "160";String.valueOf(Integer.parseInt("160")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(voluntad)==18) {
			this.potencial = "180";String.valueOf(Integer.parseInt("180")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(voluntad)==19) {
			this.potencial = "200";String.valueOf(Integer.parseInt("200")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(voluntad)>=20) {
			this.potencial = "220";String.valueOf(Integer.parseInt("220")+Integer.parseInt(this.bonoCv));
		}
	}

	public String getVoluntad() {
		return voluntad;
	}

	public void setVoluntad(String voluntad) {
		this.voluntad = voluntad;
		if (Integer.parseInt(voluntad)<=4) {
			this.potencial = String.valueOf(Integer.parseInt("0")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(voluntad)==5) {
			this.potencial = String.valueOf(Integer.parseInt("10")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(voluntad)==6) {
			this.potencial = String.valueOf(Integer.parseInt("20")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(voluntad)==7) {
			this.potencial = String.valueOf(Integer.parseInt("30")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(voluntad)==8) {
			this.potencial = String.valueOf(Integer.parseInt("40")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(voluntad)==9) {
			this.potencial = String.valueOf(Integer.parseInt("50")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(voluntad)==10) {
			this.potencial = String.valueOf(Integer.parseInt("60")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(voluntad)==11) {
			this.potencial = String.valueOf(Integer.parseInt("70")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(voluntad)==12) {
			this.potencial = String.valueOf(Integer.parseInt("80")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(voluntad)==13) {
			this.potencial = String.valueOf(Integer.parseInt("90")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(voluntad)==14) {
			this.potencial = String.valueOf(Integer.parseInt("100")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(voluntad)==15) {
			this.potencial = String.valueOf(Integer.parseInt("120")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(voluntad)==16) {
			this.potencial = String.valueOf(Integer.parseInt("140")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(voluntad)==17) {
			this.potencial = String.valueOf(Integer.parseInt("160")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(voluntad)==18) {
			this.potencial = String.valueOf(Integer.parseInt("180")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(voluntad)==19) {
			this.potencial = String.valueOf(Integer.parseInt("200")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(voluntad)>=20) {
			this.potencial = String.valueOf(Integer.parseInt("220")+Integer.parseInt(this.bonoCv));
		}
	}

	public String getPotencial() {
		return potencial;
	}

	public void setPotencial(String potencial) {
		this.potencial = potencial;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
		this.potencial = "0";
		if (Integer.parseInt(cv)>=1&&Integer.parseInt(cv)<3) {
			this.bonoCv="10";
		} else if (Integer.parseInt(cv)>=3&&Integer.parseInt(cv)<6) {
			this.bonoCv = "20";
		} else if (Integer.parseInt(cv)>=6&&Integer.parseInt(cv)<10) {
			this.bonoCv = "30";
		} else if (Integer.parseInt(cv)>=10&&Integer.parseInt(cv)<15) {
			this.bonoCv = "40";
		} else if (Integer.parseInt(cv)>=15&&Integer.parseInt(cv)<21) {
			this.bonoCv = "50";
		} else if (Integer.parseInt(cv)>=21&&Integer.parseInt(cv)<28) {
			this.bonoCv = "60";
		} else if (Integer.parseInt(cv)>=28&&Integer.parseInt(cv)<36) {
			this.bonoCv = "70";
		} else if (Integer.parseInt(cv)>=36&&Integer.parseInt(cv)<45) {
			this.bonoCv = "80";
		} else if (Integer.parseInt(cv)>=45&&Integer.parseInt(cv)<55) {
			this.bonoCv = "90";
		} else if (Integer.parseInt(cv)>=55) {
			this.bonoCv = "100";
		} else {
			this.bonoCv = "0";
		}
		
		if (Integer.parseInt(this.voluntad)<=4) {
			this.potencial = String.valueOf(Integer.parseInt("0")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(this.voluntad)==5) {
			this.potencial = String.valueOf(Integer.parseInt("10")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(this.voluntad)==6) {
			this.potencial = String.valueOf(Integer.parseInt("20")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(this.voluntad)==7) {
			this.potencial = String.valueOf(Integer.parseInt("30")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(this.voluntad)==8) {
			this.potencial = String.valueOf(Integer.parseInt("40")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(this.voluntad)==9) {
			this.potencial =String.valueOf(Integer.parseInt("50")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(this.voluntad)==10) {
			this.potencial = String.valueOf(Integer.parseInt("60")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(this.voluntad)==11) {
			this.potencial = String.valueOf(Integer.parseInt("70")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(this.voluntad)==12) {
			this.potencial = String.valueOf(Integer.parseInt("80")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(this.voluntad)==13) {
			this.potencial = String.valueOf(Integer.parseInt("90")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(this.voluntad)==14) {
			this.potencial = String.valueOf(Integer.parseInt("100")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(this.voluntad)==15) {
			this.potencial = String.valueOf(Integer.parseInt("120")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(this.voluntad)==16) {
			this.potencial = String.valueOf(Integer.parseInt("140")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(this.voluntad)==17) {
			this.potencial = String.valueOf(Integer.parseInt("160")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(this.voluntad)==18) {
			this.potencial = String.valueOf(Integer.parseInt("180")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(this.voluntad)==19) {
			this.potencial = String.valueOf(Integer.parseInt("200")+Integer.parseInt(this.bonoCv));
		} else if (Integer.parseInt(this.voluntad)>=20) {
			this.potencial = String.valueOf(Integer.parseInt("220")+Integer.parseInt(this.bonoCv));
		}
	}

	public String getBonoCv() {
		return bonoCv;
	}

	public void setBonoCv(String bonoCv) {
		this.bonoCv = bonoCv;
		
	}
	
	
	
	
}
