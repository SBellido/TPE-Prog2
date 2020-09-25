package JuegoCartas;

public class MainJuegoCartas {

	public static void main(String[] args) {
		
// INSTANCIAS		
		Jugador jugadorA = new Jugador("Federico");
		Jugador jugadorB = new Jugador("Josué");
		MazoCartas mazo = new MazoCartas(50);
		Juego juego = new Juego(40, mazo, jugadorA, jugadorB);
	
// IMPRIME POR CONSOLA
		System.out.println(juego);
	}

}
