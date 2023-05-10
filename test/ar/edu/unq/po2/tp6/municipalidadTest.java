package ar.edu.unq.po2.tp6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Test;

public class municipalidadTest {
	
		
	@Test
	public void pruebaMap() {
		Municipalidad m = new Municipalidad();
		m.agregarActividad(DiaDeLaSemana.Miercoles, 4, 5, Deporte.Futbol);
		m.agregarActividad(DiaDeLaSemana.Jueves, 6, 3, Deporte.Jabalina);
		m.agregarActividad(DiaDeLaSemana.Sabado, 2, 5, Deporte.Futbol);
		Map<Deporte, List<ActividadDeLaSemana>> map= m.actividadesConMenorCosto();
		assertEquals(map, null);
	}
}
