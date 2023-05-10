package clasePractica;

public class Producto {
	private double precio;
	private String nombre;
	
	Producto(String n, int p){
		setNombre(n);
		setPrecio(p);
	}
	
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecioConIva() {
		return precioIva() + precio;
	}

	private double precioIva() {
		return precio * 0.21;
	}
	
	
	
}
