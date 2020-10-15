package JuegoCartas;

public class MainJuegoCartas {

	public static void main(String[] args) {

		String mazoPath = "./superheroes.json";
		MazoCartas mazo = VisorMazo.cargarMazo(mazoPath);
		Jugador jugadorA = new Jugador("jugadorA");
		Jugador jugadorB = new Jugador("jugadorB");
		Juego juego = new Juego(10, mazo, jugadorA, jugadorB);
		juego.jugar();
		juego.getHistorial().imprimir();
	}
}
