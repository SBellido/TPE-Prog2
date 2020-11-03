package JuegoCartas;

public class PocimaDebilitadora extends Pocima {

	public PocimaDebilitadora(String nombre, double porcentaje) {
		super(nombre, porcentaje);
	}

	@Override
	public double incorporarAditivo(Atributo atributo) {
		return atributo.getValor() - (atributo.getValor() * this.porcentaje);
	}
}
