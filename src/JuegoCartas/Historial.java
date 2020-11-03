package JuegoCartas;

import java.util.ArrayList;
import java.util.List;

public class Historial {
	private List<Object> datosRonda;

	public Historial() {
		this.datosRonda = new ArrayList<>();
	}


	public void guardarHistorialRonda(int ronda, Jugador ganador, Jugador perdedor, Jugador jugadorTurno,
			Jugador jugadorSinTurno, Atributo atributoElegido, Carta cartaTurno, Carta cartaSinTurno,
			double valorCartaTurnoConPocima, double valorCartaSinTurnoConPocima) {

		Atributo atributoSinTurno = cartaSinTurno.buscarAtributo(atributoElegido);
		double valorAtributoCartaSinTurno = atributoSinTurno.getValor();
		double valorAtributoCartaTurno = atributoElegido.getValor();
		
		String nombreJugTurno = jugadorTurno.getNombre();
		String nombreJugSinTurno = jugadorSinTurno.getNombre();
		
		String nombreAtributo = atributoElegido.getNombre();
		String nombreSuperHeroeTurno = cartaTurno.getNombre();
		String nombreSuperHeroeSinTurno = cartaSinTurno.getNombre();
		String nombrePocimaTurno = "ninguna";
		String nombrePocimaSinTurno = "ninguna";
		
		if (cartaTurno.tienePocima()) {
			nombrePocimaTurno = cartaTurno.getPocima().getNombre();		
		} 
			
		if (cartaSinTurno.tienePocima()) {
			nombrePocimaSinTurno = cartaSinTurno.getPocima().getNombre();				
		}
		
		if (ganador != null) {
			int cantCartasGanador = ganador.contarCartas();
			int cantCartasPerdedor = perdedor.contarCartas();
			
			String nombreGanador = ganador.getNombre();		

			this.datosRonda.add("------- Ronda " + ronda + " -------\n");
			
			this.datosRonda.add("El jugador " + nombreJugTurno + " selecciona competir por el atributo " + nombreAtributo + "\n");
			
			this.datosRonda.add("La carta de " + nombreJugTurno + " es " + nombreSuperHeroeTurno + " con " + nombreAtributo
					+ " " + valorAtributoCartaTurno + ", se aplicó la pócima "+ nombrePocimaTurno + " valor resultante " + valorCartaTurnoConPocima);
			
			this.datosRonda.add("La carta de " + nombreJugSinTurno + " es " + nombreSuperHeroeSinTurno + " con "
					+ nombreAtributo + " " + valorAtributoCartaSinTurno + ", se aplicó la pócima " + nombrePocimaSinTurno + " valor resultante " + valorCartaSinTurnoConPocima);
			
					
			
			
			this.datosRonda.add(nombreJugTurno + " posee ahora " + cantCartasGanador + " cartas y " + nombreJugSinTurno
					+ " posee ahora " + cantCartasPerdedor + " cartas.\n");
						
		}
		else  {
			this.datosRonda.add("------- Ronda " + ronda + " -------\n");
			this.datosRonda.add("\t EMPATE");	
			
			this.datosRonda.add("El jugador " + nombreJugTurno + " selecciona competir por el atributo " + nombreAtributo + "\n");
			
			this.datosRonda.add("La carta de " + nombreJugTurno + " es " + nombreSuperHeroeTurno + " con " + nombreAtributo
					+ " " + valorAtributoCartaTurno + ", se aplicó la pócima "+ nombrePocimaTurno + " valor resultante " + valorCartaTurnoConPocima);
			
			this.datosRonda.add("La carta de " + nombreJugSinTurno + " es " + nombreSuperHeroeSinTurno + " con "
					+ nombreAtributo + " " + valorAtributoCartaSinTurno + ", se aplicó la pócima " + nombrePocimaSinTurno + " valor resultante " + valorCartaSinTurnoConPocima + "\n");
			
		}
		
	}

	public void imprimir() {
		for (Object data : this.datosRonda)
			System.out.println(data);
	}

	

}
