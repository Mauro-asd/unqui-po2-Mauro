package clasePractica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class pruebaFAnonimas {

	private enum Dia {
		Lunes, Martes, Miercoles, Jueves, Viernes, Sabado, Domingo;
	}
	private static List<String> arrayListDeStrings = Arrays.asList("Luciano", "Florencia", "Victoria");
	
	public static void main(String[] args) {
		System.out.println(filtrar("F"));
		System.out.println(sumarPreciosMayoresA(100));
	}
	
	public static double sumarPreciosMayoresA(int montoMin) {
		List<Producto> listaDeProductos = new ArrayList<Producto>();
		listaDeProductos.add(new Producto("Milanesa", 80));
		listaDeProductos.add(new Producto("Pure", 50));
		listaDeProductos.add(new Producto("Agua", 70));
		listaDeProductos.add(new Producto("Fideo", 95));
		
		
		return listaDeProductos.stream()
				.filter(s->s.getPrecioConIva()>100)
				.mapToDouble(s -> s.getPrecioConIva())
				.sum();
	}
	
	public static List<String> filtrar(String letra){
		return arrayListDeStrings.stream().filter((s -> s.startsWith(letra))).toList();
	} 
		
	
}
