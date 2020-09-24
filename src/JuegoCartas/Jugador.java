package JuegoCartas;

public class Jugador {
	private String nombre;
	private MazoCartas cartas;
	
	public Jugador(String nombre) {
		this.nombre = nombre;
		this.cartas = new MazoCartas();
	}

	public void jugar() {
		
	}
	public int contarCartas() {
		return this.cartas.getCantidad();
	}
	
	
	@Override
	public boolean equals(Object obj) {
		try {
			Jugador aux = (Jugador) obj;
			return this.getCartas().equals(aux.getCartas());
		} catch (Exception e) {
			return false;
		}
	}
	@Override
	public String toString() {
		return "\nJUGADOR" + 
				"\nNombre: " + this.getNombre() + 
				"\nCartas: " + this.getCartas();
	}

	
//	GETTERS & SETTERS
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public MazoCartas getCartas() {
		return cartas;
	}
	
}
