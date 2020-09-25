package JuegoCartas;

import java.util.ArrayList;
import java.util.List;

public class MazoCartas {
	private int cantidad;
	private List<Carta> mazo;

	public MazoCartas() {
	}

	public MazoCartas(int cantidad) {
		this.cantidad = cantidad;
		this.mazo = new ArrayList<>();
	}

	public boolean verificarCartas() {
		return false;
	}

	public boolean contieneCarta(Carta carta) {
		return this.mazo.contains(carta);
	}

	public boolean estaVacio() {
		return this.mazo.isEmpty();
	}

	public void agregarCarta(Carta carta) {
		if (this.estaVacio()) {
			this.mazo.add(carta);
		} else if (!contieneCarta(carta)) {
			this.mazo.add(carta);
		}
	}

	public int getCantMazoCompleto() {
		return this.mazo.size();
	}

	public void repartirCartas(Jugador jugadorA, Jugador jugadorB) {
		int cantidad = this.getCantidad();
		int mazoCompleto = this.getCantMazoCompleto();	
		if (cantidad == mazoCompleto) {
			this.darPrimeraMitad(jugadorA);
			this.darSegundaMitad(jugadorB);
		}
	}

	public void darPrimeraMitad(Jugador jugador) {
		MazoCartas mazo = new MazoCartas(this.mazo.size() / 2);
		for (int i = 0; i < this.mazo.size() / 2; i++) {
			Carta carta = this.mazo.get(i);
			mazo.agregarCarta(carta);
		}
		jugador.agarrarCartas(mazo);
	}

	public void darSegundaMitad(Jugador jugador) {
		MazoCartas mazo = new MazoCartas(this.mazo.size() / 2);
		for (int i = this.mazo.size() / 2; i < this.mazo.size(); i++) {
			Carta carta = this.mazo.get(i);
			mazo.agregarCarta(carta);
		}
		jugador.agarrarCartas(mazo);
	}

	@Override
	public String toString() {
		return "\nCantidad de cartas: " + this.getCantMazoCompleto() + 
				"\nMazo: " + this.getMazo();
	}

	// GETTERS & SETTERS
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public List<Carta> getMazo() {
		return new ArrayList<>(this.mazo);
	}

}
