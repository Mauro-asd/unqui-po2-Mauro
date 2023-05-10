package ar.edu.unq.po2.tp5;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BancoTest{
	
	private Cliente roman;
	private Cliente juan;
	private Banco banco;
	private PropiedadInmoviliaria casaDeRoman;

	@BeforeEach
	protected void setUp(){
		banco = new Banco();
		roman = banco.ingresarCliente("roman", "aguero", "uspallata", 20, 15000);
		juan = banco.ingresarCliente("juan", "aguero", "uspallata", 20, 1200);
		casaDeRoman = new PropiedadInmoviliaria("hola", "Uspallata 411", 13300);
		roman.obtenerPropiedadInmoviliaria(casaDeRoman);
	}

	@Test
	public void clientePideCreditoPersonalEsAprobado() {
			roman.pedirCreditoPersonalDe(4000, 5);
		banco.chequearSolicitudDeCredito();
		assertEquals(roman.getAhorros(), 4000);
	}
	
	@Test
	public void clientePideCreditoPersonalEsRechazado() {
		juan.pedirCreditoPersonalDe(4000, 5);
		banco.chequearSolicitudDeCredito();
		assertEquals(juan.getAhorros(), 0);
	}
	@Test
	public void dosClientesPidenCreditoPeroSoloUnoSeChequea() {
		//se aclara que ambos clientes se les validaria el pedido dado
		// que ambos superano los 15000 anuales		
		roman.pedirCreditoPersonalDe(4000, 5);
		juan.pedirCreditoPersonalDe(4000, 5);
		banco.chequearSolicitudDeCredito();
		assertEquals(juan.getAhorros(), 0);
		assertEquals(roman.getAhorros(), 4000);
		
		// el primer parametro es la solicitud del cliente2 que luego pasa a ser el cliente 2
		assertEquals(banco.solicitudesPendientes().poll().myClient, juan);
	}
	@Test
	public void clientePideCreditoHipotecarioEsAprobado() {
		roman.pedirCreditoHipotecarioDe(5000, 54, casaDeRoman);
		banco.chequearSolicitudDeCredito();
		assertEquals(roman.getAhorros(), 5000);
	}
	@Test
	public void clientePideCreditoHipotecarioEsRechazadoPorEdad() {
		roman.setAge(64);
		roman.pedirCreditoHipotecarioDe(5000, 54, casaDeRoman);
		banco.chequearSolicitudDeCredito();
		assertEquals(roman.getAhorros(), 0);
	}
	@Test
	public void clientePideCreditoHipotecarioEsRechazadoPorMontoPedidoEsMayorAValorFiscal() {
		roman.pedirCreditoHipotecarioDe(12000, 54, casaDeRoman);
		banco.chequearSolicitudDeCredito();
		assertEquals(roman.getAhorros(), 0);
	}
	@Test
	public void bancoPideLaCantidadDeDineroADesembolsarDeCreditosValidados() {
		roman.pedirCreditoPersonalDe(4000, 5);
		juan.pedirCreditoPersonalDe(4000, 5);
		banco.chequearSolicitudDeCredito();
		banco.chequearSolicitudDeCredito();
		int resultadoEsperado = 4000;
		int resultadoDado = banco.cantidadDeDineroADesembolsarPorCreditos();
		assertEquals(resultadoEsperado, resultadoDado);
	}
	@Test
	public void bancoPideLaCantidadDeDineroADesembolsarDeCreditosValidadosSon2() {
	juan.setSueldoNetoMensual(5000);
	roman.pedirCreditoPersonalDe(4000, 5);
	juan.pedirCreditoHipotecarioDe(4000, 5, casaDeRoman);
	banco.chequearSolicitudDeCredito();
	banco.chequearSolicitudDeCredito();
	int resultadoEsperado = 8000;
	int resultadoDado = banco.cantidadDeDineroADesembolsarPorCreditos();
	assertEquals(resultadoEsperado, resultadoDado);
	}
}
