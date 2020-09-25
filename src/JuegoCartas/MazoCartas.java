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

	public void agregarCarta(Carta carta) {
		if (!this.mazo.contains(carta))
			this.mazo.add(carta);
	}

	public int getMazoCompleto() {
		return this.mazo.size();
	}

	public void repartirCartas(Jugador jugadorA, Jugador jugadorB) {
		int cantidad = this.getCantidad();
		int mazoCompleto = getMazoCompleto();
		if (cantidad == mazoCompleto) {
			for (int i = 0; i < this.mazo.size() / 2; i++) {
				Carta carta = this.mazo.get(i);
				jugadorA.agregarCarta(carta);
			}
			for (int i = this.mazo.size() / 2; i < this.mazo.size(); i++) {
				Carta carta = this.mazo.get(i);
				jugadorB.agregarCarta(carta);
			}
		}
	}

	@Override
	public String toString() {
		return "Cantidad de cartas: " + cantidad + "\nMazo: " + mazo;
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
