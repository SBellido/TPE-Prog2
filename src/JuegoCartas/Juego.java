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
			Carta cartaA = this.jugadorA.jugar();
			Carta cartaB = this.jugadorB.jugar();		
			if (this.finDeJuego()) {
				ronda = this.maxRondas;
			}
			if (cartaA.esGanadora(cartaB, 0)) {
				this.jugadorA.gana();
			}
			
		}
	}

	public boolean finDeJuego() {
		return (this.jugadorA.contarCartas() == 0 || 
				this.jugadorB.contarCartas() == 0);
	}

// GETTERS & SETTERS

	@Override
	public String toString() {
		return "\nJUEGO" + 
				"\nMáximo de rondas: " + this.getMaxRondas() + 
				"\nJugador A: " + this.getJugadorA() +
				"\nJugador B: " + this.getJugadorB();
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
