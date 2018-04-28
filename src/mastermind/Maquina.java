package mastermind;

import static mastermind.Colores.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

public class Maquina extends Jugador {
	private static int numMaquina = 0;

	Maquina(Modos modo) {
		super(modo);
		numMaquina++;
		nombre = "Maquina " + numMaquina;

	}

	public Combinacion rellenarCombiSecret() {
		int i;
		boolean contieneColor = false;
		Ficha ficha;
		LinkedHashSet<Ficha> listaSinRepetidos = new LinkedHashSet<>();
		for (i = 0; i < combinacionSecreta.getCasillas().length; i++) {
			do {
				ficha = new Ficha();
				ficha = elegirCombi(2);
				combinacionSecreta.getCasillas()[i] = ficha;
				if (!getModo().isColor_Repetido()) {
					if (listaSinRepetidos.contains(ficha)) {
						contieneColor = true;
					} else {
						contieneColor = false;
						listaSinRepetidos.add(ficha);
					}
				}
			} while (contieneColor);
		}
		return combinacionSecreta;
	}

	public Combinacion rellenarCombinacionAcertar() {
		int i;
		Ficha ficha;
		Combinacion combiAux = new Combinacion(getModo());
		for (i = 0; i < combiAux.getCasillas().length; i++) {
			ficha = new Ficha();
			ficha = elegirCombi(2);
			combiAux.getCasillas()[i] = ficha;
		}
		setAcertarCombinacion(combiAux);
		return acertarCombinacion;
	}

	public Combinacion darAciertosRival(Combinacion combiComprobar, Combinacion combiRival) {
		int i;
		int aciertoTotal = 0;
		int soloColor = 0;
		Ficha ficha;
		ArrayList<Ficha> listaSoloColor = new ArrayList<>();
		ArrayList<Ficha> listaCombi1 = new ArrayList<>();
		ArrayList<Ficha> listaCombi2 = new ArrayList<>();
		HashMap<Ficha, Integer> mapaRojos = new HashMap<>();
		Combinacion aciertoError = new Combinacion(getModo());
		for (i = 0; i < combiComprobar.getCasillas().length; i++) {
			if (combiComprobar.getCasillas()[i].equals(combiRival.getCasillas()[i])) {
				aciertoTotal++;
			} else {
				listaCombi1.add(combiComprobar.getCasillas()[i]);
				listaCombi2.add(combiRival.getCasillas()[i]);
			}
		}
		for (i = 0; i < listaCombi1.size(); i++) {
			if (!mapaRojos.containsKey(listaCombi1.get(i))) {
				mapaRojos.put(listaCombi1.get(i), 1);
			} else {
				mapaRojos.put(listaCombi1.get(i), mapaRojos.get(listaCombi1.get(i)).intValue() + 1);
			}
		}

		for (i = 0; i < listaCombi2.size(); i++) {
			if (mapaRojos.containsKey(listaCombi2.get(i))) {
				if ((mapaRojos.get(listaCombi2.get(i)).intValue() < 1)) {
					mapaRojos.remove(listaCombi2.get(i));
				} else {
					soloColor++;
					mapaRojos.put(listaCombi2.get(i), mapaRojos.get(listaCombi2.get(i)).intValue() - 1);
				}
			}
		}

		for (i = 0; i < aciertoTotal; i++) {
			ficha = new Ficha();
			ficha.addColor(NEGRO + (char) 9210 + RESET);
			listaSoloColor.add(ficha);
		}

		if (aciertoTotal < getModo().getNumCasillas()) {
			for (i = 0; i < soloColor; i++) {
				ficha = new Ficha();
				ficha.addColor(ROJO + (char) 9210 + RESET);
				listaSoloColor.add(ficha);
			}
		}

		aciertoError.setCasillas(listaSoloColor.toArray(aciertoError.getCasillas()));
		for (i = 0; i < aciertoError.getCasillas().length; i++) {
			if (aciertoError.getCasillas()[i] == null) {
				ficha = new Ficha();
				ficha.addColor(BLANCO + (char) 9210 + RESET);
				aciertoError.getCasillas()[i] = ficha;
			}
		}
		return aciertoError;
	}


}
