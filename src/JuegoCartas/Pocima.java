package JuegoCartas;

public class Pocima extends ElementoPocima {
	protected double porcentaje;
	
	public Pocima(String nombre, double porcentaje) {
		super(nombre);
		this.porcentaje = porcentaje;
	}

	@Override
	public double incorporarAditivo(Atributo atributo) {
		return atributo.getValor() + (atributo.getValor() * this.porcentaje);
	}
	
	public double getPorcentaje() {
		return this.porcentaje;
	}

}
