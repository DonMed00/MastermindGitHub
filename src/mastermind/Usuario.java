package mastermind;

import static mastermind.Colores.*;
import static mastermind.Teclado.*;
import java.util.ArrayList;

public class Usuario extends Jugador {

	Usuario(Modos modo) {
		super(modo);
		nombre = "Humano";
	}

	public Combinacion rellenarCombiSecret() {
		int i;
		Ficha ficha;
		boolean confirmacion;
		System.out.println("Es hora de elegir tu combinación secreta");
		boolean contieneColor = false;
		ArrayList<Ficha> mapa = new ArrayList<>();
		for (i = 0; i < combinacionSecreta.getCasillas().length; i++) {
			do {
				do {
					mostrarMenuColores(i);
					ficha = new Ficha();
					ficha = elegirCombi(1);
					combinacionSecreta.getCasillas()[i] = ficha;
					if (!getModo().isColor_Repetido()) {
						if (mapa.contains(ficha)) {
							contieneColor = true;
							System.out.println("Este color ya se encuentra en la combinación\nNo se puede repetir");
						} else {
							contieneColor = false;
							mapa.add(ficha);
						}
					}
				} while (contieneColor);
				contieneColor = false;
				confirmacion = Teclado.leerBoolean("¿Estás conforme con el color?", "Si", "No");
			} while (!confirmacion);
		}
		return combinacionSecreta;
	}

	public Combinacion rellenarCombinacionAcertar() {
		int i;
		Ficha ficha;
		boolean confirmacion;
		Combinacion combiAux = new Combinacion(getModo());

		System.out.println("Es hora de intentar acertar\nla combinación del oponente");
		for (i = 0; i < combiAux.getCasillas().length; i++) {
			do {
				mostrarMenuColores(i);
				ficha = new Ficha();
				ficha = elegirCombi(1);
				combiAux.getCasillas()[i] = ficha;
				System.out.printf("Color %s en posicion %d", ficha.getColor(), i + 1);
				confirmacion = Teclado.leerBoolean("¿Estás conforme con el color?", "Si", "No");
			} while (!confirmacion);
		}
		setAcertarCombinacion(combiAux);
		return acertarCombinacion;
	}

	public Combinacion darAciertosRival(Combinacion combiComprobar, Combinacion combiRival) {
		int aciertoTotal;
		int soloColor;
		int i = 0;
		boolean comprobacionFalse;
		ArrayList<Ficha> lista = new ArrayList<>();
		Combinacion aciertoError;
		Ficha ficha = new Ficha();
		System.out.println("Este es el intento del rival: ");
		System.out.println(combiRival.dibujar());
		do {
			i=0;
			lista = new ArrayList<>();
			aciertoError = new Combinacion(getModo());
			System.out.println("Escribe cuantos colores en su posicion\n ha acertado el oponente");
			aciertoTotal = Teclado.leerNumEntre(Incluido.INCLUIDOS, 0, getModo().getNumCasillas());
			while (i < aciertoTotal) {
				ficha = new Ficha();
				ficha.addColor(NEGRO + (char) 9210 + RESET);
				lista.add(ficha);
				i++;
			}
			i = 0;
			if (aciertoTotal < getModo().getNumCasillas()) {
				System.out.println("Escribe cuantos colores fuera de su posición\n ha acertado el oponente");
				soloColor = Teclado.leerNumEntre(Incluido.INCLUIDOS, 0, getModo().getNumCasillas() - aciertoTotal);
				while (i < soloColor) {
					ficha = new Ficha();
					ficha.addColor(ROJO + (char) 9210 + RESET);
					lista.add(ficha);
					i++;
				}
			}
			aciertoError.setCasillas(lista.toArray(aciertoError.getCasillas()));
			for (i = 0; i < aciertoError.getCasillas().length; i++) {
				if (aciertoError.getCasillas()[i] == null) {
					ficha = new Ficha();
					ficha.addColor(BLANCO + (char) 9210 + RESET);
					aciertoError.getCasillas()[i] = ficha;
				}
			}
			if (!aciertoError.equals(combiComprobar)) {
				comprobacionFalse = true;
				System.out.println("Te has equivocado en tu correción, vuelve a intentarlo");
				System.out.println("Esto es lo que propone el juego: ");
				System.out.println(combiComprobar.dibujar());
			} else {
				comprobacionFalse = false;
			}
		} while (comprobacionFalse);

		return aciertoError;
	}

	public void mostrarMenuColores(int i) {
		System.out.printf("Elige el color para la casilla %d:\n", i + 1);
		System.out.printf("1.");
		System.out.printf(CELESTE + (char) 9209 + RESET);
		System.out.printf("\t5.");
		System.out.printf(AMARILLO + (char) 9209 + RESET + "\n");
		System.out.printf("2.");
		System.out.printf(ROJO + (char) 9209 + RESET);
		System.out.printf("\t6.");
		System.out.printf(MORADO + (char) 9209 + RESET + "\n");
		System.out.printf("3.");
		System.out.printf(VERDE + (char) 9209 + RESET);
		System.out.printf("\t7.");
		System.out.printf(ROSA + (char) 9209 + RESET + "\n");
		System.out.printf("4.");
		System.out.printf(AZUL + (char) 9209 + RESET);
		System.out.printf("\t8.");
		System.out.printf(VERDE_CLARO + (char) 9209 + RESET + "\n");
		if (getModo().getNumColores() == 10) {
			System.out.printf("9.");
			System.out.printf(BLANCO + (char) 9209 + RESET);
			System.out.printf("\t10.");
			System.out.printf(NEGRO + (char) 9209 + RESET + "\n");
		}
	}
}
