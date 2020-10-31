package JuegoCartas;

public class PocimaNumeroMagico extends Pocima {
	private double valor;
	
	public PocimaNumeroMagico(String nombre, double valor) {
		super(nombre);
		this.valor = valor;
	}

	@Override
	protected double incorporarAditivo(Atributo atributo) {
		return valor;
	}

}
