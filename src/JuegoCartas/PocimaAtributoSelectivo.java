package JuegoCartas;

public class PocimaAtributoSelectivo extends Pocima {
	private String nombreAtributo;
	
	public PocimaAtributoSelectivo(String nombre, double porcentaje, String nombreAtributo) {
		super(nombre, porcentaje);
		this.nombreAtributo = nombreAtributo;
	}


	@Override
	public double incorporarAditivo(Atributo atributo) {
		if (atributo.getNombre().equals(this.nombreAtributo))
			return atributo.getValor() + (atributo.getValor() * this.porcentaje);
		else return atributo.getValor();
	}
	
	
	public void setNombreAtributo(String nombreAtributo) {
		this.nombreAtributo = nombreAtributo; 
	}
	public String getNombreAtributo() {
		return this.nombreAtributo;
	}


}

