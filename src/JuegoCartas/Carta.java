package JuegoCartas;

import java.util.ArrayList;
import java.util.List;

public class Carta {
	private String nombre;
	private String id;
	private List<Atributo> atributos;

	public Carta(String nombre) {
		this.nombre = nombre;
		this.atributos = new ArrayList<>();
	}
	public Carta(String nombre, String id) {
		this.id = id;
		this.atributos = new ArrayList<>();
	}

	public boolean tieneAtributo(Atributo atributo) {
		return this.atributos.contains(atributo);
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
				if (cartaComparada.tieneAtributo(atributo)) {
					count++;				
				}
			}
			return count == cantAtributos;			
		}
		return false;
	}
	
	public void agregarAtributo(Atributo atributo) {
		if (!tieneAtributo(atributo)) {
			this.atributos.add(atributo);
		}
	}
	
	public int contarAtributos() {
		return this.atributos.size();
	}
	
	public int esGanadora(Atributo atributoElegido) {
		Atributo mismoAtributo = this.buscarAtributo(atributoElegido);
		int resultado = mismoAtributo.compareTo(atributoElegido);
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
		return "\nID de Carta: " + this.getId() + "\nAtributos: " + this.getAtributos();
	}

	// GETTERS & SETTERS
	public String getId() {
		return id;
	}

	public List<Atributo> getAtributos() {
		return new ArrayList<>(this.atributos);
	}
	public String getNombre() {
		return nombre;
	}

	
}
