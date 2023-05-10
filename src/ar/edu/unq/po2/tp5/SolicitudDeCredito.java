package ar.edu.unq.po2.tp5;

public abstract class SolicitudDeCredito {
	
	protected Cliente myClient;
	protected int plazo;
	protected int sumaDeDinero;
	protected Banco bancoSolicitado;
	
	
	public abstract void chequearValidez();
	
	public int dineroSolicitado() {
		return sumaDeDinero;
	}
}
