package JuegoCartas;

import java.util.ArrayList;
import java.util.List;

public class Carta {
	private String id;
	private List<Atributo> atributos;

	public Carta(String id) {
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
	
	public boolean esGanadora(Atributo atributoElegido) {
		Atributo mismoAtributo = this.buscarAtributo(atributoElegido);
			return mismoAtributo.esGanador(atributoElegido);
	}	
	
// DEVOLVER UN ENTERO, 1 SI GANA, -1 SI PIERDE, 0 SI ES EMPATE
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
	
	public boolean esEmpate(Atributo atributoElegido) {
		Atributo mismoAtributo = this.buscarAtributo(atributoElegido);
			return mismoAtributo.esEmpate(atributoElegido);
	}
	
	@Override
	public boolean equals(Object obj) {
		try {
			Carta aux = (Carta) obj;
			return this.getId().equals(aux.getId());
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

}
