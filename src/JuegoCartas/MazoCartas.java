package JuegoCartas;

import java.util.ArrayList;
import java.util.List;

public class MazoCartas {
	private int cantidad;
	private List<Carta> mazo;
	
	public MazoCartas() {}
	public MazoCartas(int cantidad) {
		this.cantidad = cantidad;
		this.mazo = new ArrayList<>();
	}

	
	public boolean verificarCartas() {
		return false;
	}
	
	public void agregarCarta() {
		//add.(Carta c)
	}
	
	public void repartirCartas(Jugador jugadosA, Jugador jugadorB) {
		//math.random
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
