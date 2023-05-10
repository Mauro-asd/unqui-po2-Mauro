package ar.edu.unq.po2.tp5;

import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Iterator;

public class Banco {
	
	private LinkedList<Cliente> myClients = new LinkedList<Cliente>();
	private Queue<SolicitudDeCredito> creditosAProcesar = new LinkedList<SolicitudDeCredito>();
	private ArrayList<SolicitudDeCredito> creditosValidados = new ArrayList<SolicitudDeCredito>();
	
		
	
	 void clientePideCreditoPersonal(Cliente c, int suma, int plazo) {
		SolicitudDeCreditoPersonal s = new SolicitudDeCreditoPersonal(c, suma, plazo, this);
		creditosAProcesar.add(s);
	}

	 void clientePideCreditoHipotecario(Cliente cliente, int suma, int plazo, PropiedadInmoviliaria pf) {
		SolicitudDeCreditoHipotecario s = new SolicitudDeCreditoHipotecario(cliente, suma, plazo, this, pf);
		creditosAProcesar.add(s);
			
	}
	 
	public Queue<SolicitudDeCredito> solicitudesPendientes() {
		return this.creditosAProcesar;
	}
	 

	public Cliente ingresarCliente(String n, String a, String d, int e, int sm) {
		Cliente myClient = new Cliente(n, a, d, e, sm, this);
		this.myClients.add(myClient);
		return myClient;
	}

	public void chequearSolicitudDeCredito() {
		// chequea la solicitud dependiendo de la cola
		
		SolicitudDeCredito solicitudEnLaCola = creditosAProcesar.poll();
		solicitudEnLaCola.chequearValidez();
	}

	public void aprobarSolicitudCreditoPersonal(Cliente myClient, int sumaDeDinero, SolicitudDeCreditoPersonal sCredito) {
		myClient.ingresarDinero(sumaDeDinero);;
		creditosValidados.add(sCredito);
		
	}

	public void aprobarSolicitudCreditoHipotecario(Cliente myClient, int sumaDeDinero,
			SolicitudDeCreditoHipotecario sCredito) {
		
		myClient.ingresarDinero(sumaDeDinero);
		creditosValidados.add(sCredito);
		
	}
	
	public int cantidadDeDineroADesembolsarPorCreditos() {
		return creditosValidados.stream().map(s -> s.dineroSolicitado()).reduce(0, (a, b) -> a+b);
	}

	
}
