package ar.edu.unq.po2.tp6;

public enum Deporte {
	Running(1), Futbol(2), Basket(2),
	Tennis(3), Jabalina(4);
	
	private int dificultad;
	
	private Deporte(int dificultad) {
		this.dificultad = dificultad;
	}

	int complejidad() {
		return dificultad;
	}
	
}
