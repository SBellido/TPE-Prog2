package JuegoCartas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MazoCartas {
	private final int PRIMERACARTA = 0;
	private int cantidad;
	private List<Carta> mazo;

	public MazoCartas() {
		this.mazo = new ArrayList<>();
	}

	public Carta verCarta() {
		return this.getMazo().get(PRIMERACARTA);
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

	public void agregarCarta(Carta carta) {
		if (this.verificarSiEsDelMazo(carta) && (!this.contieneCarta(carta))) {
			this.mazo.add(carta);						
		} else if (this.estaVacio()) {
			this.mazo.add(carta);		
		}
	}

	public void eliminarCarta(Carta cartaPerdedora) {
		if (this.contieneCarta(cartaPerdedora)) {
			this.mazo.remove(cartaPerdedora);
		}

	}

	public int getCantMazoCompleto() {
		return this.mazo.size();
	}

	public void repartirCartas(Jugador jugadorA, Jugador jugadorB) {
		Collections.shuffle(mazo);
		while (!this.estaVacio()) {
			jugadorA.agarrarCarta(this.darCarta());
			if (!this.estaVacio()) {
				jugadorB.agarrarCarta(this.darCarta());
			}
		}
	}

	@Override
	public String toString() {
		return "\nCantidad de cartas: " + this.getCantMazoCompleto() + "\nMazo: " + this.getMazo();
	}

	// GETTERS & SETTERS

	public List<Carta> getMazo() {
		return new ArrayList<>(this.mazo);
	}

}
