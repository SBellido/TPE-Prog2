package JuegoCartas;

import java.util.ArrayList;
import java.util.List;

public class Carta {
	private String id;
	List<Atributo> atributos;
	private static int cantAtributos = 5;

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

	public void agregarAtributo(Atributo atributo) {
		if (!tieneAtributo(atributo)) {
			this.atributos.add(atributo);
		}
	}

	public boolean esGanadora(Atributo atributoElegido) {
		double atributoValor = atributoElegido.getValor();
		for (Atributo atributo : this.atributos) {
			if (atributo.equals(atributoElegido)) {
				return atributo.esGanador(atributoValor);
			}
		}
		return false;
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

	public int getCantAtributos() {
		return cantAtributos;
	}

	public void setCantAtributos(int cantAtributos) {
		Carta.cantAtributos = cantAtributos;
	}

}
