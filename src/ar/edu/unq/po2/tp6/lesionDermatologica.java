package ar.edu.unq.po2.tp6;

public enum lesionDermatologica {
	Rojo("malo"), Gris("poco malo"),
	Amarillo("poco bueno"), Miel("bueno");
	
	private String descripcion;
	
	private lesionDermatologica(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public lesionDermatologica siguiente() {
		lesionDermatologica[] ls = new lesionDermatologica[4];
		ls[3] = Rojo; ls[0] = Gris;
		ls[1] = Amarillo; ls[2] = Miel;
		lesionDermatologica o = ls[this.ordinal()];
		return o;
	}
	
	
}
