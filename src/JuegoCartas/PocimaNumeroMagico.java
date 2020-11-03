package JuegoCartas;

public class PocimaNumeroMagico extends Pocima {
	public final static int NUMEROMAGICO = 10;
	
	public PocimaNumeroMagico(String nombre, double porcentaje) {
		super(nombre, porcentaje);
	}

	@Override
	public double incorporarAditivo(Atributo atributo) {
		return this.porcentaje * NUMEROMAGICO;
	}
}






