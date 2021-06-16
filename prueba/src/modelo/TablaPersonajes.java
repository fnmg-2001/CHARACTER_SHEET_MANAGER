package modelo;

public class TablaPersonajes {
	private int idPersonaje;
	private String colNombre;
	private String colNivel;
	private String colRaza;
	private String colCategoria;
	

	public TablaPersonajes(int idPersonaje, String colNombre, String colNivel, String colRaza, String colCategoria) {
		this.idPersonaje = idPersonaje;
		this.colNombre = colNombre;
		this.colNivel = colNivel;
		this.colRaza = colRaza;
		this.colCategoria = colCategoria;
	}

	
	public int getIdPersonaje() {
		return idPersonaje;
	}
	public void setIdPersonaje(int idPersonaje) {
		this.idPersonaje = idPersonaje;
	}
	public String getColNombre() {
		return colNombre;
	}
	public void setColNombre(String colNombre) {
		this.colNombre = colNombre;
	}
	public String getColNivel() {
		return colNivel;
	}
	public void setColNivel(String colNivel) {
		this.colNivel = colNivel;
	}
	public String getColRaza() {
		return colRaza;
	}
	public void setColRaza(String colRaza) {
		this.colRaza = colRaza;
	}
	public String getColCategoria() {
		return colCategoria;
	}
	public void setColCategoria(String colCatgoria) {
		this.colCategoria = colCatgoria;
	}
	
	
}
