package JuegoCartas;

public class Juego {
	private int maxRondas;
	private MazoCartas mazo;
	private Jugador jugadorA;
	private Jugador jugadorB;
	private Jugador perdedorRonda;

	public Juego(int maxRondas, MazoCartas mazo, Jugador jugadorA, Jugador jugadorB) {
		this.maxRondas = maxRondas;
		this.mazo = mazo;
		this.jugadorA = jugadorA;
		this.jugadorB = jugadorB;
	}

	public Jugador asignarTurno() {
		Jugador ganador;
		if (!this.jugadorA.esGanador() && this.jugadorB.esGanador()) {
			ganador = this.jugadorA;
		} else if (this.jugadorA.esGanador()) {
			ganador = this.jugadorA;
			this.jugadorB.setEsGanador(false);
			this.setPerdedorRonda(jugadorB);
		} else {
			ganador = this.jugadorB;
			this.jugadorA.setEsGanador(false);
			this.setPerdedorRonda(jugadorA);
		}
		return ganador;
	}

	public void jugar() {
		for (int ronda = 0; ronda < this.maxRondas; ronda++) {
			Jugador jugadorTurno = asignarTurno();
			Carta cartaTurno = jugadorTurno.seleccionarCarta();
			Jugador jugadorSinTurno = this.getPerdedorRonda();
			Carta cartaSinTurno = jugadorSinTurno.seleccionarCarta();
			int cantAtributos = cartaTurno.getCantAtributos();
			Atributo atributoElegido = jugadorTurno.elegirAtributo(cartaTurno, cantAtributos);
			cartaTurno.compararAtributos(cartaSinTurno, atributoElegido);

			if (this.finDeJuego()) {
				ronda = this.maxRondas;
			}
			if (cartaA.esGanadora(cartaB, 0)) {
				this.jugadorA.gana();
			}
		}
	}

	public boolean finDeJuego() {
		return (this.jugadorA.contarCartas() == 0 || this.jugadorB.contarCartas() == 0);
	}

// GETTERS & SETTERS

	@Override
	public String toString() {
		return "\nJUEGO" + "\nMáximo de rondas: " + this.getMaxRondas() + "\nJugador A: " + this.getJugadorA()
				+ "\nJugador B: " + this.getJugadorB();
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

	public void setPerdedorRonda(Jugador perdedorRonda) {
		this.perdedorRonda = perdedorRonda;
	}

	public Jugador getPerdedorRonda() {
		return this.perdedorRonda;
	}

}
