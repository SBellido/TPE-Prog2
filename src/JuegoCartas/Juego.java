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
	
	public void rondaJuego() {		
	}
	
	public boolean finDeJuego() {
		return false;
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
