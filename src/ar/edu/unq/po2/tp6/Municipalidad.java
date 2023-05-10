package ar.edu.unq.po2.tp6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Municipalidad {
	
	private ArrayList<ActividadDeLaSemana> actividades =
			new ArrayList<ActividadDeLaSemana>();

	public ActividadDeLaSemana agregarActividad(DiaDeLaSemana dia,
												int h,
												int d,
												Deporte a) {
		ActividadDeLaSemana actividad = new ActividadDeLaSemana(dia, h, d, a);
		actividades.add(actividad);
		return actividad;
	}
	
	public List<ActividadDeLaSemana> todasLasActividadesDe(Deporte a){
		return actividades.stream().filter(s-> s.esActividad(a) ).toList();
	}
	
	public List<ActividadDeLaSemana> todasLasActividadesConComplejidad(int complejidad){
		return actividades.stream().filter(s-> s.esActividadConComplejidad(complejidad)).toList();
	}
	
	public int horasTotalesEnActividadesOfrecidas() {
		int n = actividades.stream().mapToInt(s -> s.duracion()).sum();
		return n;
	}
	
	public ActividadDeLaSemana actividadConMenorCosto(Deporte d) {
		ActividadDeLaSemana a =
				actividades.stream().min(Comparator.comparingInt(ActividadDeLaSemana::precio)).get();
		return a;
	}
	
	public Map<Deporte, List<ActividadDeLaSemana>> actividadesConMenorCosto(){
		Map<Deporte, List<ActividadDeLaSemana>> m = 
				actividades.stream()
				.collect(Collectors
						.groupingBy(ActividadDeLaSemana::actividad));
		m.forEach((t, u) -> u.stream().min(Comparator.comparingInt(ActividadDeLaSemana::precio)).get());
		return m;
	}
	
	
	
}
