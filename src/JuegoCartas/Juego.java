package JuegoCartas;

public class Juego {
	private int maxRondas;
	private MazoCartas mazo;
	private Jugador jugadorA;
	private Jugador jugadorB;

	public Juego(int maxRondas, MazoCartas mazo, Jugador jugadorA, Jugador jugadorB) {
		this.maxRondas = maxRondas;
		this.mazo = mazo;
		this.jugadorA = jugadorA;
		this.jugadorB = jugadorB;
	}

	public void asignarTurno() {
	}

	public boolean esGanador() {
		return false;
	}

	
	public void jugar() {
		for (int ronda = 0; ronda < this.maxRondas; ronda++) {
			this.jugadorA.jugar();
			this.jugadorB.jugar();
			this.finDeJuego(ronda);		
		}
	}

	public boolean finDeJuego(int ronda) {
		return (this.getMaxRondas() == ronda || this.jugadorA.contarCartas() == 0 || this.jugadorB.contarCartas() == 0);
	}

// GETTERS & SETTERS

	

	@Override
	public String toString() {
		return "JUEGO" + 
				"\nMáximo de rondas: " + this.getMaxRondas() + 
				"\nJugador A: " + this.getJugadorA().getNombre() + 
				"\nJugador B: " + this.getJugadorB().getNombre();
	}

	// GETTERS & SETTERS
	public int getMaxRondas() {
		return maxRondas;
	}

	public void setMaxRondas(int maxRondas) {
		this.maxRondas = maxRondas;
	}

	public MazoCartas getMazo() {
		return mazo;
	}

	public Jugador getJugadorA() {
		return jugadorA;
	}

	public Jugador getJugadorB() {
		return jugadorB;
	}

}
