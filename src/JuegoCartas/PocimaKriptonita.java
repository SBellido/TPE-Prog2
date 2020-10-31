package JuegoCartas;

public class PocimaKriptonita extends Pocima {
	private double porcentaje;
	
	public PocimaKriptonita(String nombre, double porcentaje) {
		super(nombre);
		this.porcentaje = porcentaje;
	}

	@Override
	protected double incorporarAditivo(Atributo atributo) {
		return atributo.getValor() - (atributo.getValor() * this.porcentaje);

	}

}
