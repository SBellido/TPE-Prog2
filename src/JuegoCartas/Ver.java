package JuegoCartas;

public class Ver {

	public static void main(String[] args) {
		
//		OBTIENE MAZO DE CARTAS PRECARGADAS
		String mazoPath = "./superheroes.json";
		VisorMazo.mostrarMazo(mazoPath);
		
		
//		INSTANCIA MAZO	
		MazoCartas mazo = new MazoCartas();
		
		
//		INSTANCIA P�CIMAS
		PocimaNumeroMagico pocimaNumeroMagico = new PocimaNumeroMagico("P�cima N�mero M�gico", 4.0);
		PocimaKriptonita pocimaKriptonita = new PocimaKriptonita("P�cima Kriptonita", 0.2);
		PocimaFortalecedora pocimaFortalecedora = new PocimaFortalecedora("P�cima Fortalecedora", 0.35);
		PocimaAtributoSelectivo pocimaAtributo = new PocimaAtributoSelectivo("P�cima Atributo Selectivo","Fuerza");
		PocimaCocktail pocimaCocktail = new PocimaCocktail("P�cima Cocktail", pocimaAtributo, pocimaFortalecedora);
		PocimaCocktail pocimaCocktail1 = new PocimaCocktail("P�cima Cocktail", pocimaKriptonita, pocimaNumeroMagico);
		PocimaCocktail pocimaCocktail2 = new PocimaCocktail("P�cima Cocktail", pocimaCocktail1, pocimaCocktail);
		
		
//		AGREGA P�CIMAS AL MAZO
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
		Jugador jugadorB = new Jugador("Mar�a", obstinado);
		
		
//		INSTANCIA JUEGO
		Juego juego = new Juego(20, mazo, jugadorA, jugadorB);
		

//		JUEGA
		juego.jugar();

		
//		IMPRIME HISTORIAL POR CONSOLA
		juego.getHistorial().imprimir();
	}
	
}
