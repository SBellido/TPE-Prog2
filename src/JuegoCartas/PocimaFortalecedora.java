package JuegoCartas;

public class PocimaFortalecedora extends Pocima {
	private double porcentaje;
	
	public PocimaFortalecedora(String nombre, double porcentaje) {
		super(nombre);
		this.porcentaje = porcentaje;
	}

	@Override
	public double incorporarAditivo(Atributo atributo) {
		return atributo.getValor() + (atributo.getValor() * this.porcentaje);
	}

}
