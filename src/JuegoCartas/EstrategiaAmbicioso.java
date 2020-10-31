package JuegoCartas;

public class EstrategiaAmbicioso implements Estrategia {

	public EstrategiaAmbicioso() { }

	@Override
	public Atributo elegirAtributo(Carta carta) {
		Atributo mayor = carta.obtenerMayorAtributo();
		return mayor;
	}

}
