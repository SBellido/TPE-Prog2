package JuegoCartas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MazoCartas {
	private final static int PRIMERACARTA = 0;
	private final int MAX = 100;
	private final int MED = 50;
	private final int MIN = 1;
 	private List<Carta> mazo;
	private List<ElementoPocima> pocimas;
	
	public MazoCartas() {
		this.mazo = new ArrayList<>();
		this.pocimas = new ArrayList<>();
	}

	public Carta verCarta() {
		return this.mazo.get(MazoCartas.PRIMERACARTA);
	}

	public boolean verificarCarta(Carta cartaNueva) {
		for (Carta carta : this.mazo)
			return carta.compararAtributos(cartaNueva);
		return false;
	}

	public Carta darCarta() {
		return this.mazo.remove(MazoCartas.PRIMERACARTA);
	}

	public boolean contieneCarta(Carta carta) {
		return this.mazo.contains(carta);
	}

	public boolean estaVacio() {
		return this.mazo.isEmpty();
	}

	public void agregarPocima(ElementoPocima pocima) {
		this.pocimas.add(pocima);
	}

	public void agregarCarta(Carta carta) {
		if (this.verificarCarta(carta) && (!this.contieneCarta(carta))) {
			this.mazo.add(carta);		
		} else if (this.estaVacio())
			this.mazo.add(carta);
	}

	public void eliminarCarta(Carta cartaPerdedora) {
		if (this.contieneCarta(cartaPerdedora))
			this.mazo.remove(cartaPerdedora);
	}

	public int obtenerCantCartas() {
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
 				ElementoPocima pocimaAleatoria = this.pocimas.get(indice);
				carta.setPocima(pocimaAleatoria);
			}
		}
	}

	private boolean seAsigna() {
		boolean result = true;
		int value = (int) Math.floor(Math.random() * (MAX - MIN)) + MIN;
		if (value <= MED)
			result = false;
		return result;
	}

	
	@Override
	public String toString() {
		return "\nCantidad de cartas: " + this.obtenerCantCartas() + "\nMazo: " + this.mazo;
	}
	


}
