package JuegoCartas;

public abstract class Pocima {
	protected String nombre;
	
	protected Pocima() {}
	protected Pocima(String nombre) {
		this.nombre = nombre;
	}

	protected abstract double incorporarAditivo(Atributo atributo);

	public String getNombre() {
		return nombre;
	}
	
	
	
}
