package ar.edu.unq.po2.tp5;

public class SolicitudDeCreditoHipotecario extends SolicitudDeCredito {

		private PropiedadInmoviliaria propiedadDeCliente;		
	
		public SolicitudDeCreditoHipotecario(Cliente c, int suma, int p, Banco b, PropiedadInmoviliaria pi) {
			myClient = c;
			sumaDeDinero = suma;
			plazo = p;
			bancoSolicitado = b;
			propiedadDeCliente = pi;
		}
		
		public void chequearValidez() {
			if(this.myClient.chequearValidezDeCreditoHipotecario(sumaDeDinero, propiedadDeCliente, plazo)) {
				bancoSolicitado.aprobarSolicitudCreditoHipotecario(myClient, sumaDeDinero, this);
			}
		}
		
}
