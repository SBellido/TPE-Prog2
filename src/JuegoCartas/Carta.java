package JuegoCartas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Carta {
	private String nombre;
	private String id;
	private List<Atributo> atributos;
	private Pocima pocima;

	public Carta(String nombre) {
		this.nombre = nombre;
		this.atributos = new ArrayList<>();
	}

	
	public Carta(String nombre, String id) {
		this.id = id;
		this.atributos = new ArrayList<>();
	}

	
	public double obtenerValorconPocima(Atributo atributoElegido) {
		double atributoConPocima = 0;
		double atributoSinPocima = atributoElegido.getValor();
		Atributo copia = this.aplicarPocima(atributoElegido);
		
		if (this.tienePocima()) {
			copia = this.aplicarPocima(atributoElegido);
			atributoConPocima = copia.getValor();
			return atributoConPocima;
		}
		return atributoSinPocima;
	}

	
	public boolean tieneAtributo(Atributo atributo) {
		return this.atributos.contains(atributo);
	}

	
	public boolean tienePocima() {
		return this.pocima != null;
	}

	
	public Atributo buscarAtributoPorIndice(int indiceAtributo) {
		Atributo atributoElegido = this.atributos.get(indiceAtributo);
		return atributoElegido;
	}

	
	public boolean compararAtributo(Carta cartaComparada) {
		int count = 0;
		int cantAtributos = this.contarAtributos();

		if (cartaComparada.contarAtributos() == this.atributos.size()) {
			for (Atributo atributo : this.atributos) {
				if (cartaComparada.tieneAtributo(atributo))
					count++;
			}
			return count == cantAtributos;
		}
		return false;
	}

	
	public void agregarAtributo(Atributo atributo) {
		if (!tieneAtributo(atributo))
			this.atributos.add(atributo);
	}

	
	public int contarAtributos() {
		return this.atributos.size();
	}

	
	public int esGanadora(Carta carta, Atributo atributoElegido) {
		Atributo atributoEncontrado = this.buscarAtributo(atributoElegido);
		Atributo miJugada = this.aplicarPocima(atributoEncontrado);
		Atributo suJugada = carta.aplicarPocima(atributoElegido);
		int resultado = miJugada.compareTo(suJugada);
		return resultado;
	}

	public Atributo buscarAtributo(Atributo atributoElegido) {
		Atributo mismoAtributo = null;
		for (Atributo atributo : this.atributos) {
			if (atributo.equals(atributoElegido)) {
				mismoAtributo = atributo;
				return mismoAtributo;
			}
		}
		return mismoAtributo;
	}

	
	public Atributo buscarAtributoNombre(String atributoBuscado) {
		for (Atributo atributo : this.atributos) {
			String atributoEncontrado = atributo.getNombre();
			if (atributoEncontrado.equals(atributoBuscado))
				return atributo;
		}
		return null;
	}

	
	public Atributo obtenerMayorAtributo() {
		List<Atributo> copia = new ArrayList<>(this.atributos);
		Collections.sort(copia);
		return copia.get(copia.size() - 1);
	}

	
	public Atributo aplicarPocima(Atributo atributoElegido) {
		Atributo copia = new Atributo();
		if (this.pocima != null) {
			for (Atributo atributo : this.atributos) {
				if (atributo.equals(atributoElegido)) {
					copia.setNombre(atributo.getNombre());
					copia.setValor(atributo.getValor());
					this.pocima.incorporarAditivo(copia);
					return copia;
				}
			}
		}
		return atributoElegido;
	}

	
	@Override
	public boolean equals(Object obj) {
		try {
			Carta aux = (Carta) obj;
			return this.getNombre().equals(aux.getNombre());
		} catch (Exception e) {
			return false;
		}
	}

	
	@Override
	public String toString() {
		return "\nNombre: " + this.getNombre() + "\nAtributos: " + this.atributos;
	}

	
	// GETTERS & SETTERS
	public String getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public Pocima getPocima() {
		return this.pocima;
	}
	public void setPocima(Pocima pocima) {
		this.pocima = pocima;
	}

}
