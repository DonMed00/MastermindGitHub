package mastermind;

import java.util.ArrayList;

public class TableroJugador implements Dibujable {
	private ArrayList<Jugada> tablero;

	TableroJugador() {
		tablero = new ArrayList<>();
	}

	public String dibujar() {
		String dibujo = "";
		int i = 0;
		while (i < tablero.size()) {
			dibujo += String.format("%s\n", tablero.get(i).dibujar());
			i++;
		}
		return dibujo;
	}

	public ArrayList<Jugada> getTablero() {
		return tablero;
	}
}
