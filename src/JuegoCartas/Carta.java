package JuegoCartas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Carta {
	private String nombre;
	private ElementoPocima  pocima;
	private List<Atributo> atributos;

	public Carta(String nombre) {
		this.nombre = nombre;
		this.atributos = new ArrayList<>();
	}

	
	public void agregarAtributo(Atributo atributo) {
		if (!this.tieneAtributo(atributo))
			this.atributos.add(atributo);
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

	
	public boolean compararAtributos(Carta cartaComparada) {
		int count = 0;
		int cantAtributos = this.contarAtributos();

		if (cartaComparada.contarAtributos() == cantAtributos) {
			for (Atributo atributo : this.atributos) {
				if (cartaComparada.tieneAtributo(atributo))
					count++;
			}
			return count == cantAtributos;
		}
		return false;
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
		if (this.tienePocima()) {
			for (Atributo atributo : this.atributos) {
				if (atributo.equals(atributoElegido)) {
					double valor = pocima.incorporarAditivo(atributoElegido);
					copia.setNombre(atributo.getNombre());
					copia.setValor(valor);
					return copia;
				}
			}
		}
		return atributoElegido;
	}


	public double valorconPocima(Atributo atributoElegido) {
		double atributoConPocima = 0;
		double atributoSinPocima = atributoElegido.getValor();
		Atributo copia = this.buscarAtributo(atributoElegido);		
		
		if (this.tienePocima()) {
			atributoConPocima = this.pocima.incorporarAditivo(copia);	
			return atributoConPocima;
		}
		return copia.getValor();
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
	public String getNombre() {
		return nombre;
	}
	public ElementoPocima getPocima() {
		return this.pocima;
	}
	public void setPocima(ElementoPocima pocima) {
		this.pocima = pocima;
	}
	
}
