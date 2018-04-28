package mastermind;

import java.util.Arrays;

public class Combinacion implements Dibujable {
	private Ficha[] casillas;
	 private Modos modo;

	Combinacion(Modos modo) {
		this.modo = modo;
		this.casillas = new Ficha[modo.getNumCasillas()];
		
	}
	public Ficha[] getCasillas() {
		return casillas;
	}
	public void setCasillas(Ficha[] casillas) {
		this.casillas = casillas;
	}
	public Modos getModo() {
		return modo;
	}
	public int hashCode() {
		int hash;
		hash = Arrays.hashCode(casillas) + modo.hashCode();
		return hash;
	}
	public boolean equals(Object obj) {
		boolean resultado = false;
		if (obj instanceof Combinacion && Arrays.equals(casillas, ((Combinacion) obj).casillas)
				&& modo.equals(((Combinacion) obj).modo)) {
			resultado = true;
		}
		return resultado;
	}
	public String dibujar() {
		int i;
		String dibujo = "";
		for (i = 0; i < casillas.length; i++) {
			if (i == casillas.length - 1) {
				dibujo = dibujo + String.format(" %s |", casillas[i].dibujar());
			} else {
				dibujo = dibujo + String.format(" %s", casillas[i].dibujar());
			}
		}
		return dibujo;

	}

}
