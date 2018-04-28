package mastermind;

import static mastermind.Colores.*;
import java.util.Random;
import mastermind.Teclado.Incluido;

public abstract class Jugador {
	protected String nombre;
	protected Combinacion combinacionSecreta;
	protected Combinacion acertarCombinacion;
	protected Modos modo;

	Jugador(Modos modo) {
		this.modo = modo;
		combinacionSecreta = new Combinacion(modo);
		acertarCombinacion = new Combinacion(modo);
	}
	public abstract Combinacion rellenarCombiSecret();
	public abstract Combinacion rellenarCombinacionAcertar();
	public abstract Combinacion darAciertosRival(Combinacion combiComprobar,Combinacion combiRival);

	public void setAcertarCombinacion(Combinacion acertarCombinacion) {
		this.acertarCombinacion = acertarCombinacion;
	}
	public Ficha elegirCombi(int tipoJugador) {
		Ficha ficha = new Ficha();
		Random rnd = new Random();
		int respuesta = 0;
		if (tipoJugador == 1) {
			respuesta = Teclado.leerNumEntre(Incluido.INCLUIDOS, 1, getModo().getNumColores());
		} else if (tipoJugador == 2) {
			respuesta = rnd.nextInt(modo.getNumColores()) + 1;
		}
		switch (respuesta) {
		case 1:
			ficha.addColor(CELESTE + (char) 9209 + RESET);
			break;
		case 2:
			ficha.addColor(ROJO + (char) 9209 + RESET);
			break;
		case 3:
			ficha.addColor(VERDE + (char) 9209 + RESET);
			break;
		case 4:
			ficha.addColor(AZUL + (char) 9209 + RESET);
			break;
		case 5:
			ficha.addColor(AMARILLO + (char) 9209 + RESET);
			break;
		case 6:
			ficha.addColor(MORADO + (char) 9209 + RESET);
			break;
		case 7:
			ficha.addColor(ROSA + (char) 9209 + RESET);
			break;
		case 8:
			ficha.addColor(VERDE_CLARO + (char) 9209 + RESET);
			break;
		case 9:
			ficha.addColor(CELESTE_CLARO + (char) 9209 + RESET);
			break;
		case 10:
			ficha.addColor(AMARILLO_CLARO + (char) 9209 + RESET);
			break;
		}
		return ficha;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public Combinacion getCombinacionSecreta() {
		return combinacionSecreta;
	}
	public Combinacion getAcertarCombinacion() {
		return acertarCombinacion;
	}
	public Modos getModo() {
		return modo;
	}
}
