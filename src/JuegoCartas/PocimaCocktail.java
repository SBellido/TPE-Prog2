package JuegoCartas;

import java.util.ArrayList;
import java.util.List;

public class PocimaCocktail extends ElementoPocima {
	private List<ElementoPocima> pocimas;
	
	public PocimaCocktail(String nombre) {
		super(nombre);
		this.pocimas = new ArrayList<>();
	}

	@Override
	protected double incorporarAditivo(Atributo atributo) {
		double valorTemp = 0;
		Atributo copia = new Atributo(atributo.getNombre(), atributo.getValor());
		for (ElementoPocima elementoPocima : this.pocimas) {
			valorTemp = elementoPocima.incorporarAditivo(copia);
			copia = new Atributo(copia.getNombre(), valorTemp);
		}
		return valorTemp;
	}
	
	public void agregarPocima(ElementoPocima pocima) {
		pocimas.add(pocima);
	}

}
