package ar.edu.unq.po2.tp5;

public class SolicitudDeCreditoPersonal extends SolicitudDeCredito {

	
	public SolicitudDeCreditoPersonal(Cliente c, int suma, int p, Banco b) {
		myClient = c;
		sumaDeDinero = suma;
		plazo = p;
		bancoSolicitado = b;
	}
	
	public void chequearValidez() {
		if(this.myClient.chequearValidezDeCreditoPersonal(sumaDeDinero)) {
			bancoSolicitado.aprobarSolicitudCreditoPersonal(myClient, sumaDeDinero, this);
		}
	}
}
