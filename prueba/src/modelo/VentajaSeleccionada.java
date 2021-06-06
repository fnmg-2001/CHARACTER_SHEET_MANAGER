package modelo;

import javafx.scene.control.ComboBox;

public class VentajaSeleccionada {
	
	private ComboBox<String> nombreVentaja;
	private String costeVentaja;
	
	public VentajaSeleccionada(ComboBox<String> nombreVentaja, String costeVentaja) {
		
		this.nombreVentaja = nombreVentaja;
		this.costeVentaja = costeVentaja;
	}

	public ComboBox<String> getNombreVentaja() {
		return nombreVentaja;
	}

	public void setNombreVentaja(ComboBox<String> nombreVentaja) {
		this.nombreVentaja = nombreVentaja;
	}

	public String getCosteVentaja() {
		return costeVentaja;
	}

	public void setCosteVentaja(String costeVentaja) {
		this.costeVentaja = costeVentaja;
	}
	
	
	
//	private String cBoxVentaja;
//	private SessionFactory sf;
//	ConsultasHibernate ch;
//	private String coste;
//
//	public VentajaSeleccionada(SessionFactory sf, String nombreVentaja) {
//		this.ch = new ConsultasHibernate();
//		this.sf = sf;
//		this.cBoxVentaja = nombreVentaja;
//		if (this.cBoxVentaja==null||"".equals(this.cBoxVentaja)) {
//			this.coste = "-";
//		} else {
//			this.coste = String.valueOf(ch.obtenerCosteVentajaSeleccionada(this.sf, this.cBoxVentaja));
//		}
//	}
//
//	public String getcBoxVentaja() {
//		return cBoxVentaja;
//	}
//
//	public void setcBoxVentaja(String ventajaSeleccionada) {
//		this.cBoxVentaja = ventajaSeleccionada;
////		this.coste = String.valueOf(ch.obtenerCosteVentajaSeleccionada(this.sf, ventajaSeleccionada));
//		
//	}
//
//	public String getCoste() {
//		return coste;
//	}
//
//	public void setCoste(String coste) {
//		this.coste = coste;
//	}
	
}
