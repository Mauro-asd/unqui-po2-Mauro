package ar.edu.unq.po2.tp3;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tp3.Multiplos;

public class testMultiplos {
	
	@Test
	public void testMultiplo() {
		Multiplos mult = new Multiplos();
		assertEquals(840, mult.multiploDe(70, 3));
	}
}
