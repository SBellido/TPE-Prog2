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
		
		Atributo atributoAlturaFlash = new Atributo("Altura", 1.95);
		Atributo atributoPesoFlash = new Atributo("Peso", 90.0);
		Atributo atributoFuerzaFlash = new Atributo("Fuerza", 840.0);
		Atributo atributoPeleasGanadasFlash = new Atributo("Peleas ganadas", 900.0);
		Atributo atributoVelociadFlash = new Atributo("Velocidad", 800000.0);
		
		
		Atributo atributoAlturaSuperman = new Atributo("Altura", 2.05);
		Atributo atributoPesoSuperman = new Atributo("Peso", 110.0);
		Atributo atributoFuerzaSuperman = new Atributo("Fuerza", 2000.0);
		Atributo atributoPeleasGanadasSuperman = new Atributo("Peleas ganadas", 990.0);
		Atributo atributoVelociadSuperman = new Atributo("Velocidad", 400.0);
		
		
		Atributo atributoAlturaFireStorm = new Atributo("Altura", 1.75);
		Atributo atributoPesoFireStorm = new Atributo("Peso", 70.0);
		Atributo atributoFuerzaFireStorm = new Atributo("Fuerza", 700.0);
		Atributo atributoPeleasGanadasFireStorm = new Atributo("Peleas ganadas", 615.0);
		Atributo atributoVelociadFireStorm = new Atributo("Velocidad", 50.0);
		
		
		Atributo atributoAlturaManHunter = new Atributo("Altura", 1.93);
		Atributo atributoPesoManHunter = new Atributo("Peso", 100.0);
		Atributo atributoFuerzaManHunter = new Atributo("Fuerza", 500.0);
		Atributo atributoPeleasGanadasManHunter = new Atributo("Peleas ganadas", 25.0);
		Atributo atributoVelociadManHunter = new Atributo("Velocidad", 220.0);
		
		carta1.agregarAtributo(atributoAlturaSuperman);
		carta1.agregarAtributo(atributoPesoSuperman);
		carta1.agregarAtributo(atributoFuerzaSuperman);
		carta1.agregarAtributo(atributoPeleasGanadasSuperman);
		carta1.agregarAtributo(atributoVelociadSuperman);
		
		carta2.agregarAtributo(atributoAlturaFlash);
		carta2.agregarAtributo(atributoPesoFlash);
		carta2.agregarAtributo(atributoFuerzaFlash);
		carta2.agregarAtributo(atributoPeleasGanadasFlash);
		carta2.agregarAtributo(atributoVelociadFlash);
		
		carta3.agregarAtributo(atributoAlturaFireStorm);
		carta3.agregarAtributo(atributoPesoFireStorm);
		carta3.agregarAtributo(atributoFuerzaFireStorm);
		carta3.agregarAtributo(atributoPeleasGanadasFireStorm);
		carta3.agregarAtributo(atributoVelociadFireStorm);
		
		carta4.agregarAtributo(atributoAlturaManHunter);
		carta4.agregarAtributo(atributoPesoManHunter);
		carta4.agregarAtributo(atributoFuerzaManHunter);
		carta4.agregarAtributo(atributoPeleasGanadasManHunter);
		carta4.agregarAtributo(atributoVelociadManHunter);
		
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
