package JuegoCartas;

public class Atributo implements Comparable<Atributo>{	
	private String nombre;
	private int valor;
	
	public Atributo() { }
	public Atributo(String nombre, int valor) {
		this.nombre = nombre;
		this.valor = valor;
	}
	
	@Override
	public int compareTo(Atributo atributo) {
		int result = 0;
		if (this.valor > atributo.getValor()) {
			result = 1;	
		} else if (this.valor < atributo.getValor()) {
			result = -1;
		}
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		try {
			Atributo aux = (Atributo) obj;
			return this.getNombre().equals(aux.getNombre());
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "\nATRIBUTO: " + this.getNombre() + 
				"\nValor: " + this.getValor();
	}



// GETTERS & SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	
}
