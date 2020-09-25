package JuegoCartas;

public class MainJuegoCartas {

	public static void main(String[] args) {

// INSTANCIAS		
		MazoCartas mazo = new MazoCartas(4);
		Jugador jugadorA = new Jugador("Federico");
		Jugador jugadorB = new Jugador("Josué");
		Juego juego = new Juego(40, mazo, jugadorA, jugadorB);
		Carta carta1 = new Carta("A 1");
		Carta carta2 = new Carta("A 2");
		Carta carta3 = new Carta("A 3");
		Carta carta4 = new Carta("A 4");

		mazo.agregarCarta(carta1);
		mazo.agregarCarta(carta2);
		mazo.agregarCarta(carta3);
		mazo.agregarCarta(carta4);
		mazo.repartirCartas(jugadorA, jugadorB);

// IMPRIME POR CONSOLA
//		System.out.println(jugadorA);
		System.out.println(juego);
	}

}
