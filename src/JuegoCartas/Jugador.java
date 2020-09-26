package JuegoCartas;

public class Jugador {
	private static int id;
	private int numbreId;
	private String nombre;
	private MazoCartas cartas;
	private boolean esGanador= false;
	
	public Jugador(String nombre) {
		this.nombre = nombre;
		this.numbreId = id++;
	}

	public Carta jugar() {
		Carta carta = null;
		if(this.cartas != null) {
			carta = this.cartas.getCarta();
		}
		return carta;
	}

	public int contarCartas() {
		return this.cartas.getCantidad();
	}
	
	public void agarrarCartas(MazoCartas mazo) {	
		this.setCartas(mazo);	
	}
	
	public void gana() {
		this.setEsGanador(true);
	}
	
	@Override
	public boolean equals(Object obj) {
		try {
			Jugador aux = (Jugador) obj;
			return this.getNumbreId() == aux.getNumbreId();
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public String toString() {
		return "\n------------------------------" + 
				"\nJUGADOR" + 
				"\nNombre: " + this.getNombre() +
				"\nID: " + this.getNumbreId() +
				"\nCartas: " + this.getCartas();
	}

//	GETTERS & SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setCartas(MazoCartas mazo) {
		this.cartas = mazo;
	}
	public MazoCartas getCartas() {
		return this.cartas;
	}
	public int getNumbreId() {
		return numbreId;
	}

	public boolean isEsGanador() {
		return esGanador;
	}

	public void setEsGanador(boolean esGanador) {
		this.esGanador = esGanador;
	}

	
}
