package JuegoCartas;

public class MainJuegoCartas {

	public static void main(String[] args) {
		
//		OBTIENE MAZO DE CARTAS PRECARGADAS
		String mazoPath = "./superheroes.json";
		VisorMazo.mostrarMazo(mazoPath);
		
		
//		INSTANCIA MAZO CON LOS DATOS PRECARGADOS	
		MazoCartas mazo = VisorMazo.cargarMazo(mazoPath);
		
		
//		INSTANCIA P�CIMAS
		PocimaNumeroMagico pocimaNumeroMagico = new PocimaNumeroMagico("P�cima N�mero M�gico", 40);
		PocimaDebilitadora pocimaKriptonita = new PocimaDebilitadora("P�cima Kriptonita", 0.2);
		Pocima pocimaFortalecedora = new Pocima("P�cima Fortalecedora", 0.35);
		PocimaAtributoSelectivo pocimaAtributoFuerza = new PocimaAtributoSelectivo("P�cima Atributo Selectivo fuerza", 5.0, "fuerza");
		PocimaAtributoSelectivo pocimaAtributoVelocidad = new PocimaAtributoSelectivo("P�cima Atributo Selectivo velocidad", 4.0, "velocidad");
		PocimaAtributoSelectivo pocimaAtributoPeleas = new PocimaAtributoSelectivo("P�cima Atributo Selectivo peleas ganadas", 3.0, "peleas ganadas");
		PocimaAtributoSelectivo pocimaAtributoAltura = new PocimaAtributoSelectivo("P�cima Atributo Selectivo altura", 2.0, "altura");
		PocimaAtributoSelectivo pocimaAtributoPeso = new PocimaAtributoSelectivo("P�cima Atributo Selectivo peso", 4.5, "peso");
		PocimaCocktail pocimaCocktail = new PocimaCocktail("P�cima Cocktail");
		PocimaCocktail pocimaCocktail1 = new PocimaCocktail("P�cima Cocktail 1");
		PocimaCocktail pocimaCocktail2 = new PocimaCocktail("P�cima Cocktail 2");
	
		pocimaCocktail.agregarPocima(pocimaAtributoPeso);
		pocimaCocktail.agregarPocima(pocimaFortalecedora);
		pocimaCocktail1.agregarPocima(pocimaKriptonita);
		pocimaCocktail1.agregarPocima(pocimaAtributoPeso);
		pocimaCocktail2.agregarPocima(pocimaAtributoVelocidad);
		pocimaCocktail2.agregarPocima(pocimaNumeroMagico);
		
		
//		AGREGA P�CIMAS AL MAZO
		mazo.agregarPocima(pocimaNumeroMagico);
		mazo.agregarPocima(pocimaKriptonita);
		mazo.agregarPocima(pocimaFortalecedora);
		mazo.agregarPocima(pocimaAtributoFuerza);
		mazo.agregarPocima(pocimaAtributoPeleas);
		mazo.agregarPocima(pocimaAtributoAltura);
		mazo.agregarPocima(pocimaAtributoPeso);
		mazo.agregarPocima(pocimaCocktail);
		mazo.agregarPocima(pocimaCocktail1);
		mazo.agregarPocima(pocimaCocktail2);
//		mazo.agregarPocima(pocimaCocktailAtribFortale);
//		mazo.agregarPocima(pocimaCocktailKriptoNumMagico);
//		mazo.agregarPocima(pocimaCocktailDoble);
		
		
//		INSTANCIA ESTRATEGIAS
		EstrategiaTimbero timbero = new EstrategiaTimbero();
		EstrategiaObstinado obstinado = new EstrategiaObstinado("velocidad"); 		
		EstrategiaAmbicioso ambiocioso = new EstrategiaAmbicioso(); 
		

//		INSTANCIA JUGADOR
		Jugador jugadorA = new Jugador("Juan", timbero);
		Jugador jugadorB = new Jugador("Mar�a", obstinado);
		
		
//		INSTANCIA JUEGO
		Juego juego = new Juego(50, mazo, jugadorA, jugadorB);
		

//		JUEGA
		juego.comenzar();

		
//		IMPRIME HISTORIAL POR CONSOLA
		juego.getHistorial().imprimir();
	}
	
}
