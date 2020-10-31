package JuegoCartas;

public class Ver {

	public static void main(String[] args) {
		
//		OBTIENE MAZO DE CARTAS PRECARGADAS
		String mazoPath = "./superheroes.json";
		VisorMazo.mostrarMazo(mazoPath);
		
		
//		INSTANCIA MAZO	
		MazoCartas mazo = new MazoCartas();
		
		
//		INSTANCIA PÓCIMAS
		PocimaNumeroMagico pocimaNumeroMagico = new PocimaNumeroMagico("Pócima Número Mágico", 4.0);
		PocimaKriptonita pocimaKriptonita = new PocimaKriptonita("Pócima Kriptonita", 0.2);
		PocimaFortalecedora pocimaFortalecedora = new PocimaFortalecedora("Pócima Fortalecedora", 0.35);
		PocimaAtributoSelectivo pocimaAtributo = new PocimaAtributoSelectivo("Pócima Atributo Selectivo","Fuerza");
		PocimaCocktail pocimaCocktail = new PocimaCocktail("Pócima Cocktail", pocimaAtributo, pocimaFortalecedora);
		PocimaCocktail pocimaCocktail1 = new PocimaCocktail("Pócima Cocktail", pocimaKriptonita, pocimaNumeroMagico);
		PocimaCocktail pocimaCocktail2 = new PocimaCocktail("Pócima Cocktail", pocimaCocktail1, pocimaCocktail);
		
		
//		AGREGA PÓCIMAS AL MAZO
		mazo.agregarPocima(pocimaNumeroMagico);
		mazo.agregarPocima(pocimaKriptonita);
		mazo.agregarPocima(pocimaKriptonita);
		mazo.agregarPocima(pocimaKriptonita);
		mazo.agregarPocima(pocimaKriptonita);
		mazo.agregarPocima(pocimaKriptonita);
		mazo.agregarPocima(pocimaKriptonita);
		
		
//		INSTANCIA ESTRATEGIAS
		EstrategiaTimbero timbero = new EstrategiaTimbero();
		EstrategiaObstinado obstinado = new EstrategiaObstinado("Velocidad"); 		
		EstrategiaAmbicioso ambiocioso = new EstrategiaAmbicioso(); 
		

//		INSTANCIA JUGADOR
		Jugador jugadorA = new Jugador("Juan", timbero);
		Jugador jugadorB = new Jugador("María", obstinado);
		
		
//		INSTANCIA JUEGO
		Juego juego = new Juego(20, mazo, jugadorA, jugadorB);
		

//		JUEGA
		juego.jugar();

		
//		IMPRIME HISTORIAL POR CONSOLA
		juego.getHistorial().imprimir();
	}
	
}
