package JuegoCartas;

import java.util.ArrayList;
import java.util.List;

public class Carta {
	private String id;
	List<Atributo> atributos;
	
	public Carta(String id) {
		this.id = id;
		this.atributos = new ArrayList<>();
	}

	
// GETTERS & SETTERS
	public String getId() {
		return id;
	}
	
	public List<Atributo> getAtributos() {
		return new ArrayList<>(this.atributos);
	}
	
	

}
