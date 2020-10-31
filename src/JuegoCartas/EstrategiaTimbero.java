package JuegoCartas;

public class EstrategiaTimbero implements Estrategia {

	public EstrategiaTimbero() { }

	public Atributo elegirAtributo(Carta carta) { 
		int cantAtributo = carta.contarAtributos();	
		int indiceRandom = (int) Math.floor(Math.random() * (cantAtributo - 1));
		Atributo atributo = carta.buscarAtributoPorIndice(indiceRandom);
		return atributo;
	}
	
}
