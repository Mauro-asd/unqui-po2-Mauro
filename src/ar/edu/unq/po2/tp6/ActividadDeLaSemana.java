package ar.edu.unq.po2.tp6;

public class ActividadDeLaSemana {
	
	private DiaDeLaSemana dia;
	private int horaDeInicio;
	private int duracion;
	private Deporte actividad;
	
	public ActividadDeLaSemana(DiaDeLaSemana dia,
								int h, int d, Deporte a) {
		this.dia = dia;
		this.horaDeInicio = h;
		this.duracion = d;
		this.actividad = a;
	}
	
	public Deporte actividad() {
		return actividad;
	}
	
	public int precio() {
		int n = (this.precioPorDiaSemanal() * duracion)
				+ actividad.complejidad() ;
		return n;
	}

	private int precioPorDiaSemanal() {
		if(dia.ordinal()>2) {return 1000;}
		else return 500;
	}

	public boolean esActividad(Deporte a) {
		return actividad == a;
	}

	public boolean esActividadConComplejidad(int complejidad) {
		return actividad.complejidad() == complejidad;
	}

	public int duracion() {
		return duracion;
	}
}
