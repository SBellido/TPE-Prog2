package JuegoCartas;

import java.util.ArrayList;
import java.util.List;

public class Historial {
	private List<Object> datosRonda;

	public Historial() {
		this.datosRonda = new ArrayList<>();
	}

	public void guardarHistorialRonda(int ronda, Jugador ganador, Jugador perdedor, Jugador jugadorTurno,
			Jugador JugadorSinTurno, Atributo atributoElegido, Carta cartaTurno, Carta cartaSinTurno) {

		Atributo atributoSinTurno = cartaSinTurno.buscarAtributo(atributoElegido);

		int valorAtributoCartaSinTurno = atributoSinTurno.getValor();
		String nombreJugTurno = jugadorTurno.getNombre();
		String nombreJugSinTurno = JugadorSinTurno.getNombre();
		String nombreAtributo = atributoElegido.getNombre();
		String nombreSuperHeroeTurno = cartaTurno.getNombre();
		String nombreSuperHeroeSinTurno = cartaSinTurno.getNombre();
		int valorAtributoCartaTurno = atributoElegido.getValor();
		int cantCartasGanador = ganador.contarCartas();
		int cantCartasPerdedor = perdedor.contarCartas();
		String nombreGanador = ganador.getNombre();
		String nombrePerdedor = perdedor.getNombre();

		this.datosRonda.add("------- Ronda " + ronda + " -------\n");
		this.datosRonda
				.add("El jugador " + nombreJugTurno + " selecciona competir por el atributo " + nombreAtributo + "\n");
		this.datosRonda.add("La carta de " + nombreJugTurno + " es " + nombreSuperHeroeTurno + " con " + nombreAtributo
				+ " " + valorAtributoCartaTurno + "\n");
		this.datosRonda.add("La carta de " + nombreJugSinTurno + " es " + nombreSuperHeroeSinTurno + " con "
				+ nombreAtributo + " " + valorAtributoCartaSinTurno + "\n");
		this.datosRonda.add("Gana la ronda " + nombreGanador + ".\n");
		this.datosRonda.add(nombreJugTurno + " posee ahora " + cantCartasGanador + " cartas y " + nombreJugSinTurno
				+ " posee ahora " + cantCartasPerdedor + " cartas.\n");
	}

	public void imprimir() {
		for (Object data : this.datosRonda)
			System.out.println(data);

	}

	public List<Object> getDatosRonda() {
		return new ArrayList<Object>(this.datosRonda);
	}

}
