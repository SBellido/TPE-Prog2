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
		if (this.jugadorA.esGanador() && (!this.jugadorB.esGanador())) {
			ganador = this.jugadorA;
			this.jugadorB.setEsGanador(false);
			this.setPerdedorRonda(jugadorB);
		} else if (this.jugadorB.esGanador() && (!this.jugadorA.esGanador())) {
			ganador = this.jugadorB;
			this.jugadorA.setEsGanador(false);
			this.setPerdedorRonda(jugadorA);
		} else {
			ganador = this.jugadorA;
			this.setPerdedorRonda(jugadorB);
		}
		return ganador;
	}

	public void jugar() {
		int ronda = 0;
		while (!this.finDeJuego(ronda)) {
			Jugador jugadorTurno = asignarTurno();
			Carta cartaTurno = jugadorTurno.seleccionarCarta();
			Jugador jugadorSinTurno = this.getPerdedorRonda();
			Carta cartaSinTurno = jugadorSinTurno.seleccionarCarta();
			Atributo atributoElegido = jugadorTurno.elegirAtributo(cartaTurno);			
			System.out.println("Artibuto Elegido: " + atributoElegido);		
			System.out.println(jugadorTurno);
			System.out.println(cartaTurno);
			System.out.println(jugadorSinTurno);
			System.out.println(cartaSinTurno);		
			System.out.println("-------------------------------------------");
			this.asignarResultadoRonda(jugadorTurno, jugadorSinTurno, atributoElegido, cartaTurno ,cartaSinTurno);		
			System.out.println("-------------------\nRonda número: " + ronda);		
			ronda++;
			System.out.println("FIN DE JUEGO");	
		}
	}

	
	public void asignarResultadoRonda(Jugador jugadorTurno, Jugador jugadorSinTurno, Atributo atributoElegido, Carta cartaTurno, Carta cartaSinTurno) {
		if(cartaSinTurno.esGanadora(atributoElegido)) {
			jugadorSinTurno.ganar(cartaTurno);
			jugadorTurno.perder(cartaTurno);
			jugadorSinTurno = this.asignarTurno();
			jugadorTurno = this.getPerdedorRonda();			
			System.out.println("\nCARTA GANADORA" + cartaSinTurno);
		} else {
			jugadorTurno.ganar(cartaSinTurno);
			jugadorSinTurno.perder(cartaSinTurno);
			jugadorTurno = this.asignarTurno();
			jugadorSinTurno = this.getPerdedorRonda();			
			System.out.println("\nCARTA GANADORA" + cartaTurno);
		}
	}
	
	public boolean finDeJuego(int ronda) {
		return (this.jugadorA.contarCartas() == 0 || 
				this.jugadorB.contarCartas() == 0 ||
				ronda == this.maxRondas);
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
