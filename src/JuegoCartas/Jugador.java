package JuegoCartas;

public class Jugador {
	private static int id;
	private int numbreId;
	private String nombre;
	private MazoCartas cartas;
	private boolean esGanador;

	public Jugador(String nombre) {
		this.nombre = nombre;
		this.numbreId = id++;
		this.esGanador = false;
		this.cartas = new MazoCartas();
	}

	public Carta seleccionarCarta() {
		if (this.cartas != null || (!this.cartas.estaVacio())) {
			return this.cartas.verCarta();
		}
		return null;
	}

	public void ganar(Carta cartaPerdedora) {
		this.gana();
		this.cartas.agregarCarta(cartaPerdedora);
	}
	public void perder(Carta cartaPerdedora) {
		this.pierde();
		this.cartas.eliminarCarta(cartaPerdedora);
	}
	
	public Atributo elegirAtributo(Carta carta) { 
		int cantAtributo = carta.contarAtributos();
		int atributoRandom = (int) (Math.random() * cantAtributo - 1);
		Atributo atributo = carta.buscarAtributoPorIndice(atributoRandom);
		return atributo;
	}

	public int contarCartas() {
		return this.cartas.getCantMazoCompleto();
	}

	public void agarrarCarta(Carta carta) {
		this.cartas.agregarCarta(carta);
	}

	public void gana() {
		this.setEsGanador(true);
	}
	public void pierde() {
		this.setEsGanador(false);
	
	}
	@Override
	public boolean equals(Object obj) {
		try {
			Jugador aux = (Jugador) obj;
			return this.getNumbreId() == aux.getNumbreId();
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public String toString() {
		return "\n------------------------------" + "\nJUGADOR" + "\nNombre: " + this.getNombre() + "\nID: "
				+ this.getNumbreId() + "\nCartas: " + this.getCartas();
	}

//	GETTERS & SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCartas(MazoCartas mazo) {
		this.cartas = mazo;
	}

	public MazoCartas getCartas() {
		return this.cartas;
	}

	public int getNumbreId() {
		return numbreId;
	}

	public boolean esGanador() {
		return this.esGanador;
	}

	public void setEsGanador(boolean esGanador) {
		this.esGanador = esGanador;
	}

}
