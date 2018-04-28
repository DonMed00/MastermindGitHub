package mastermind;

public class Jugada implements Dibujable {
	private Combinacion combinacion;
	private Combinacion respuesta;
	Modos modo;
	
	public Jugada(Modos modo) {
		this.modo = modo;
		combinacion = new Combinacion(modo);
		respuesta = new Combinacion(modo);
	}
	public int hashCode() {
		int hash;
		hash = combinacion.hashCode() + respuesta.hashCode();
		return hash;
	}

	public void addJugada(Combinacion combinacion, Combinacion respuesta) {
		this.combinacion = combinacion;
		this.respuesta = respuesta;
	}
	public String dibujar() {
		String dibujo = String.format("%s%s", combinacion.dibujar(), respuesta.dibujar());

		return dibujo;
	}

	public Combinacion getCombinacion() {
		return combinacion;
	}
	public Combinacion getRespuesta() {
		return respuesta;
	}
	public Modos getModo() {
		return modo;
	}

}
