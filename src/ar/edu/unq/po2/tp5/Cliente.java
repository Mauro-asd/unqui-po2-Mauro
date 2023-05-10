package ar.edu.unq.po2.tp5;

import java.util.LinkedList;

public class Cliente {
	
	private String name;
	private String lastName;
	private String direction;
	private int age;
	private int sueldoNetoMensual;
	private int ahorros = sueldoNetoMensual;
	private Banco b;
	private LinkedList<PropiedadInmoviliaria> propiedadesActuales= new LinkedList<PropiedadInmoviliaria>(); 
	
	public Cliente(String n, String l, String d, int a, int sn, Banco banco) {
		this.setName(n);
		this.setLastName(l);
		this.setDirection(d);
		this.setAge(a);
		this.setSueldoNetoMensual(sn);
		this.b = banco;
	}
	

	private void setName(String name) {
		this.name = name;
	}

	private void setLastName(String lastName) {
		this.lastName = lastName;
	}

	private void setDirection(String direction) {
		this.direction = direction;
	}
	void setAge(int age) {
		this.age = age;
	}
	public void setSueldoNetoMensual(int sueldoNetoMensual) {
		this.sueldoNetoMensual = sueldoNetoMensual;
	}
	
	public int sueldoNetoAnual() {
		int x = this.sueldoNetoMensual * 12;
		return x;
	}
	
	public void pedirCreditoPersonalDe(int suma, int plazo) {
		this.b.clientePideCreditoPersonal(this, suma, plazo);
	}

	public void pedirCreditoHipotecarioDe(int suma, int plazo, PropiedadInmoviliaria pf) {
		this.b.clientePideCreditoHipotecario(this, suma, plazo, pf);
	}
	
	protected boolean chequearValidezDeCreditoPersonal(int monto) {
		boolean x = this.sueldoNetoAnual() >= 15000;
		boolean y = this.sueldoNetoMensual > (monto * 0.7);
		return x && y;
	}

	public int getAhorros() {
		return ahorros;
	}

	public void ingresarDinero(int sumaDeDinero) {
		this.ahorros += sumaDeDinero;		
	}

	public boolean chequearValidezDeCreditoHipotecario(int sumaDeDinero, PropiedadInmoviliaria propiedadDeCliente, int plazo) {
		double porcentajeDeVFResultante = propiedadDeCliente.getValorFiscal() * 0.7;
		boolean x = (this.sueldoNetoMensual*0.5) > (sumaDeDinero/plazo);
		boolean y = porcentajeDeVFResultante > sumaDeDinero;
		boolean z = 65 >= (this.age + (plazo/12));
		return x && y && z;
	}

	public void obtenerPropiedadInmoviliaria(PropiedadInmoviliaria propiedad) {
		this.propiedadesActuales.add(propiedad);		
	}
}
