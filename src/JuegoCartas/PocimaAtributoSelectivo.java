package JuegoCartas;

public class PocimaAtributoSelectivo extends Pocima {
	private String atributo;
	private Pocima pocima;
	
	public PocimaAtributoSelectivo(String nombre, String atributo) {
		super(nombre);
		this.atributo = atributo;
	}

	@Override
	protected double incorporarAditivo(Atributo atributo) {
		if (atributo.getNombre().equals(this.atributo))
			return this.pocima.incorporarAditivo(atributo);
		else return atributo.getValor();
	}

}
