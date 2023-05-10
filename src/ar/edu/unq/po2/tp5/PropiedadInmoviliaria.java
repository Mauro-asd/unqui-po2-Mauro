package ar.edu.unq.po2.tp5;

public class PropiedadInmoviliaria {
	private int valorFiscal;
	private String description;
	private String direction;
	
	public PropiedadInmoviliaria(String descripcion, String direccion, int vf) {
		this.setDescription(descripcion);
		this.setDirection(direccion);
		this.setValorFiscal(vf);
	}

	public int getValorFiscal() {
		return valorFiscal;
	}

	private void setValorFiscal(int valorFiscal) {
		this.valorFiscal = valorFiscal;
	}

	private void setDescription(String description) {
		this.description = description;
	}


	private void setDirection(String direction) {
		this.direction = direction;
	}
	
}
