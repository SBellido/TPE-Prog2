package JuegoCartas;

public class PocimaCocktail extends Pocima {
	private Pocima poc1, poc2;
	
	public PocimaCocktail(String nombre, Pocima poc1, Pocima poc2) {
		super(nombre);
		this.poc1 = poc1;
		this.poc2 = poc2;
	}

	@Override
	protected double incorporarAditivo(Atributo atributo) {
		return (poc1.incorporarAditivo(atributo) + 
				poc2.incorporarAditivo(atributo));

	}

}
