package JuegoCartas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MazoCartas {
	private final int PRIMERACARTA = 0;
	private int cantidad;
	private List<Carta> mazo;
	private List<Pocima> pocimas;
	private final static int MAX = 100;
	private final static int MIN = 1;
	private final static int MIDDLE = 50;

	public MazoCartas() {
		this.mazo = new ArrayList<>();
		this.pocimas = new ArrayList<>();
	}

	public Carta verCarta() {
		return this.mazo.get(PRIMERACARTA);
	}

	public boolean verificarSiEsDelMazo(Carta cartaVerificada) {
		for (Carta carta : this.mazo) {
			return carta.compararAtributo(cartaVerificada);
		}
		return false;
	}

	public Carta darCarta() {
		return this.mazo.remove(PRIMERACARTA);
	}

	public boolean contieneCarta(Carta carta) {
		return this.mazo.contains(carta);
	}

	public boolean estaVacio() {
		return this.mazo.isEmpty();
	}

	public void agregarPocima(Pocima pocima) {
		this.pocimas.add(pocima);
	}

	public void agregarCarta(Carta carta) {
		if (this.verificarSiEsDelMazo(carta) && (!this.contieneCarta(carta)))
			this.mazo.add(carta);
		else if (this.estaVacio())
			this.mazo.add(carta);
	}

	public void eliminarCarta(Carta cartaPerdedora) {
		if (this.contieneCarta(cartaPerdedora))
			this.mazo.remove(cartaPerdedora);
	}

	public int getCantMazoCompleto() {
		return this.mazo.size();
	}

	public void repartirCartas(Jugador jugadorA, Jugador jugadorB) {
		Collections.shuffle(mazo);
		this.asignarPocima();
		while (!this.estaVacio()) {
			jugadorA.agarrarCarta(this.darCarta());
			if (!this.estaVacio())
				jugadorB.agarrarCarta(this.darCarta());
		}
	}

	public void asignarPocima() {
 		int indice = 0;
		for (Carta carta : this.mazo) {
			if (this.seAsigna()) {
				indice = (int) Math.floor(Math.random() * this.pocimas.size());
 				Pocima pocimaAleatoria = this.pocimas.get(indice);
				carta.setPocima(pocimaAleatoria);
			}
		}
	}

	private boolean seAsigna() {
		boolean result = true;
		int value = (int) Math.floor(Math.random() * (MAX - MIN)) + MIN;
		if (value >= MIDDLE)
			result = false;
		return result;
	}

	@Override
	public String toString() {
		return "\nCantidad de cartas: " + this.getCantMazoCompleto() + "\nMazo: " + this.mazo;
	}

}
