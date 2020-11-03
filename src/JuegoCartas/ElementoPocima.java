package JuegoCartas;

public abstract class ElementoPocima {
	protected String nombre;
	
	protected ElementoPocima() { }
	protected ElementoPocima(String nombre) { 
		this.nombre = nombre;
	}
	
	protected abstract double incorporarAditivo(Atributo atributo);
	
	
//	GETTERS & SETTERS
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	
}
