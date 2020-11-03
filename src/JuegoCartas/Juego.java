package JuegoCartas;

public class Juego {
	private int maxRondas;
	private MazoCartas mazo;
	private Jugador jugadorA;
	private Jugador jugadorB;
	private Jugador perdedorRonda;
	private Historial historial;

	public Juego(int maxRondas, MazoCartas mazo, Jugador jugadorA, Jugador jugadorB) {
		this.maxRondas = maxRondas;
		this.mazo = mazo;
		this.jugadorA = jugadorA;
		this.jugadorB = jugadorB;
		this.historial = new Historial();
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

	public void comenzar() {
		int ronda = 0;
		mazo.repartirCartas(jugadorA, jugadorB);
		
		while (!this.finDeJuego(ronda)) {	
			
			Jugador jugadorTurno = asignarTurno();
			Carta cartaTurno = jugadorTurno.seleccionarCarta();
			Atributo atributoElegido = jugadorTurno.elegirAtributo(cartaTurno);			
			
			Jugador jugadorSinTurno = this.getPerdedorRonda();
			Carta cartaSinTurno = jugadorSinTurno.seleccionarCarta();
			
			this.asignarResultadoRonda(ronda, jugadorTurno, jugadorSinTurno, 
					atributoElegido, cartaTurno, cartaSinTurno);
			ronda++;
			System.out.println("\n" + ronda);
		}
	}	
	
	public void asignarResultadoRonda(int ronda, Jugador jugadorTurno, Jugador jugadorSinTurno,
			Atributo atributoElegido, Carta cartaTurno, Carta cartaSinTurno) {
			double valorCartaTurnoConPocima = cartaTurno.valorconPocima(atributoElegido);
			double valorCartaSinTurnoConPocima = cartaSinTurno.valorconPocima(atributoElegido);
		
		if (cartaSinTurno.esGanadora(cartaTurno, atributoElegido) == 0) {
			jugadorTurno.agarrarCarta(cartaTurno);
			jugadorSinTurno.agarrarCarta(cartaSinTurno);
			Jugador ganador = new Jugador(" ninguno ", jugadorTurno.getCopiaCartas());
			Jugador perdedor = new Jugador(" ninguno ", jugadorSinTurno.getCopiaCartas());
			
			this.historial.guardarHistorialRonda(ronda, ganador, perdedor, 
					jugadorTurno, jugadorSinTurno, atributoElegido, cartaTurno, cartaSinTurno, 
					valorCartaTurnoConPocima, valorCartaSinTurnoConPocima);
			
		} else if (cartaSinTurno.esGanadora(cartaTurno, atributoElegido) > 0) {
			
			jugadorSinTurno.ganar(cartaTurno, cartaSinTurno);
			jugadorTurno.perder(cartaTurno);
			Jugador ganador = jugadorSinTurno;
			Jugador perdedor = jugadorTurno;
			jugadorSinTurno = this.asignarTurno();
			jugadorTurno = this.getPerdedorRonda();
			
			this.historial.guardarHistorialRonda(ronda, ganador, perdedor, 
					jugadorTurno, jugadorSinTurno, atributoElegido, cartaTurno, cartaSinTurno,
					valorCartaTurnoConPocima, valorCartaSinTurnoConPocima);
		} else {
			jugadorTurno.ganar(cartaSinTurno, cartaTurno);
			jugadorSinTurno.perder(cartaSinTurno);
			Jugador ganador = jugadorTurno;
			Jugador perdedor = jugadorSinTurno;
			jugadorTurno = this.asignarTurno();
			jugadorSinTurno = this.getPerdedorRonda();
			
			this.historial.guardarHistorialRonda(ronda, ganador, perdedor, 
					jugadorTurno, jugadorSinTurno, atributoElegido, cartaTurno, cartaSinTurno,
					valorCartaTurnoConPocima, valorCartaSinTurnoConPocima);
		}
	}

	
	public boolean finDeJuego(int ronda) {
		return (this.jugadorA.contarCartas() == 0 || 
				this.jugadorB.contarCartas() == 0 || 
				ronda == this.maxRondas);
	}

	
	@Override
	public String toString() {
		return "\nJUEGO" + 
				"\nMáximo de rondas: " + this.getMaxRondas() + 
				"\nJugador A: " + this.getJugadorA() + 
				"\nJugador B: " + this.getJugadorB();
	}
	
	
	// GETTERS & SETTERS
	public Jugador getJugadorA() {
		return jugadorA;
	}
	public Jugador getJugadorB() {
		return jugadorB;
	}
	public Jugador getPerdedorRonda() {
		return this.perdedorRonda;
	}
	public int getMaxRondas() {
		return maxRondas;
	}
	public Historial getHistorial() {
		return this.historial;
	}
	public void setPerdedorRonda(Jugador perdedorRonda) {
		this.perdedorRonda = perdedorRonda;
	}
	public void setMaxRondas(int maxRondas) {
		this.maxRondas = maxRondas;
	}

}
