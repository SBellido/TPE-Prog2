package JuegoCartas;

public class EstrategiaObstinado implements Estrategia {
	private String atributo;
	
	public EstrategiaObstinado(String atributo) { 
		this.atributo = atributo;
	}

	@Override
	public Atributo elegirAtributo(Carta carta) {
		Atributo atributoEncontrado = carta.buscarAtributoNombre(this.atributo);
		return atributoEncontrado;
	}

}
