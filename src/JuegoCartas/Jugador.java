package JuegoCartas;

public class Jugador {
	private static int id;
	private int numeroId;
	private String nombre;
	private MazoCartas cartas;
	private boolean esGanador;
	private Estrategia estrategia;
	
	public Jugador(String nombre, MazoCartas cartas) {
		this.nombre = nombre;
		this.cartas = cartas;
		
	}
	public Jugador(String nombre, Estrategia estrategia) {
		this.nombre = nombre;
		this.numeroId = id++;
		this.esGanador = false;
		this.cartas = new MazoCartas();
		this.estrategia = estrategia;
	}

	public Carta seleccionarCarta() {
		if (this.cartas != null || (!this.cartas.estaVacio()))
			return this.cartas.verCarta();
		return null;
	}

	public void ganar(Carta perdedora, Carta ganadora) {
		this.setEsGanador(true);
		this.cartas.agregarCarta(perdedora);
		this.cartas.eliminarCarta(ganadora);
		this.cartas.agregarCarta(ganadora);
	}
	
	public void perder(Carta cartaPerdedora) {
		this.setEsGanador(false);
		this.cartas.eliminarCarta(cartaPerdedora);
	}
	
	public Atributo elegirAtributo(Carta carta) { 
		Atributo atributoElegido = this.estrategia.elegirAtributo(carta);	
		return atributoElegido;
	}

	public int contarCartas() {
		int total = this.cartas.obtenerCantCartas();
		return total;
	}

	public void agarrarCarta(Carta carta) {
		this.cartas.eliminarCarta(carta);
		this.cartas.agregarCarta(carta);
	}

	@Override
	public boolean equals(Object obj) {
		try {
			Jugador aux = (Jugador) obj;
			return this.getNumeroId() == aux.getNumeroId();
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public String toString() {
		return "\n------------------------------" + "\nJUGADOR" + "\nNombre: " + this.getNombre() + "\nID: "
				+ this.getNumeroId() + "\nCartas: " + this.cartas;
	}

//	GETTERS & SETTERS
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNumeroId() {
		return numeroId;
	}
	public boolean esGanador() {
		return this.esGanador;
	}
	public void setEsGanador(boolean esGanador) {
		this.esGanador = esGanador;
	}	
	public void setEstrategia(Estrategia estrategia) {
		this.estrategia = estrategia;
	}
	public MazoCartas getCopiaCartas() {	
		MazoCartas cartasCopia = this.cartas.copiarse();
		return cartasCopia;
	}

}
