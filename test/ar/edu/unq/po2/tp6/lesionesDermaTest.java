package ar.edu.unq.po2.tp6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class lesionesDermaTest {
	
	@Test
	public void elSieguienteDeRojoEsAmarillo() {
		lesionDermatologica l = lesionDermatologica.Rojo;
		lesionDermatologica resultado = l.siguiente();
		lesionDermatologica rEsperado = lesionDermatologica.Gris;
		assertEquals(resultado, rEsperado);
	}
}
