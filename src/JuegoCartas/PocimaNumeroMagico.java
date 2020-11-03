package JuegoCartas;

public class PocimaNumeroMagico extends ElementoPocima {
	public final double NUMEROMAGICO;
	
	public PocimaNumeroMagico(String nombre, double NUMEROMAGICO) {
		super(nombre);
		this.NUMEROMAGICO = NUMEROMAGICO;
	}

	@Override
	public double incorporarAditivo(Atributo atributo) {
		return this.NUMEROMAGICO;
	}
	
}






