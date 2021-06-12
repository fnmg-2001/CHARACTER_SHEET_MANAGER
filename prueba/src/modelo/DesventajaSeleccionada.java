package modelo;


import javafx.scene.control.ComboBox;

public class DesventajaSeleccionada {
	
	private ComboBox<String> nombreDesventaja;
	private String beneficioDesventaja;
	
	public DesventajaSeleccionada(ComboBox<String> nombreDesventaja, String beneficioDesventaja) {
		this.nombreDesventaja = nombreDesventaja;
		this.beneficioDesventaja = beneficioDesventaja;
	}
	
	public ComboBox<String> getNombreDesventaja() {
		return nombreDesventaja;
	}
	public void setNombreDesventaja(ComboBox<String> nombreDesventaja) {
		this.nombreDesventaja = nombreDesventaja;
	}
	public String getBeneficioDesventaja() {
		return beneficioDesventaja;
	}
	public void setBeneficioDesventaja(String beneficioDesventaja) {
		this.beneficioDesventaja = beneficioDesventaja;
	}
	
//	private String cBoxDesventaja;
//	private SessionFactory sf;
//	ConsultasHibernate ch;
//	private String beneficio;
//
//	public DesventajaSeleccionada(SessionFactory sf, String nombreVentaja) {
//		this.ch = new ConsultasHibernate();
//		this.sf = sf;
//		this.cBoxDesventaja = nombreVentaja;
//		if (this.cBoxDesventaja==null||"".equals(this.cBoxDesventaja)) {
//			this.beneficio = "-";
//		} else {
//			this.beneficio = String.valueOf(ch.obtenerBeneficioDesventajaSeleccionada(this.sf, this.cBoxDesventaja));
//		}
//	}
//
//	public String getcBoxDesventaja() {
//		return cBoxDesventaja;
//	}
//
//	public void setcBoxDesventaja(String desventajaSeleccionada) {
//		this.cBoxDesventaja = desventajaSeleccionada;
////		this.coste = String.valueOf(ch.obtenerCosteVentajaSeleccionada(this.sf, ventajaSeleccionada));
//		
//	}
//
//	public String getBeneficio() {
//		return beneficio;
//	}
//
//	public void setBeneficio(String coste) {
//		this.beneficio = coste;
//	}
	
}
