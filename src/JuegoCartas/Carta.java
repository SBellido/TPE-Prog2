package JuegoCartas;

import java.util.ArrayList;
import java.util.List;

public class Carta {
	private String id;
	List<Atributo> atributos;
	private int cantAtributos;

	public Carta(String id, int cantAtributos) {
		this.id = id;
		this.atributos = new ArrayList<>();
		this.cantAtributos = cantAtributos;
	}

	public boolean tieneAtributo(Atributo atributo) {
		return this.atributos.contains(atributo);
	}

	public Atributo buscarAtributo(int indiceAtributo) {
		Atributo atributoElegido = this.atributos.get(indiceAtributo);
		return atributoElegido;
	}

	public void agregarAtributo(Atributo atributo) {
		if (!tieneAtributo(atributo)) {
			this.atributos.add(atributo);
		}
	}

	public void compararAtributo(Carta carta, Atributo atributoElegido) {
		for (Atributo atributo : this.atributos) {
			if (atributo.equals(atributoElegido)) {

			}
		}
	}

	public boolean esGanadora(Carta carta, int atributo) {
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
		this.cantAtributos = cantAtributos;
	}

}
