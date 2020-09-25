package JuegoCartas;

public class MainJuegoCartas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// INSTANCIAS y prueba
		Jugador jugadorA = new Jugador("Federico");
		Jugador jugadorB = new Jugador("Josué");
		MazoCartas mazo = new MazoCartas(50);
		Juego juego = new Juego(40, mazo, jugadorA, jugadorB);

		// IMPRIME POR CONSOLA
		System.out.println(juego);
	}

}
