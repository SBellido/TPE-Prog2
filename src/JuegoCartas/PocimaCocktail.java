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
		double result = 0;
		for (ElementoPocima elementoPocima : this.pocimas)
			result += elementoPocima.incorporarAditivo(atributo);
		return result;
	}
	
	public void agregarPocima(ElementoPocima pocima) {
		pocimas.add(pocima);
	}

}
