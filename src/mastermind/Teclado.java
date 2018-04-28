package mastermind;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Teclado {
	//En cada Leer... existe un try catch por si no se introduce el numero del tipo que se indica, asi no hay que introducir erros manualmente en cada programa
	
	// Declarar Teclado
	public static Scanner teclado = new Scanner(System.in);

	// Cerrar Teclado
	public static void cerrarTeclado() {
		teclado.close();
	}

	// Limpiar bufer
	public static void nextLine() {
		teclado.nextLine();
	}

	// Leer caracter
	public static char leerCaracter() {
		char cadena;
		cadena = teclado.next().charAt(0);
		return cadena;
	}

	//Leer cadena
	public static String leerCadena() {
		String cadena;
		cadena = teclado.nextLine();
		return cadena;
	}

	
	//Leer boolean
	public static boolean leerBoolean(String mensaje, String opcion1, String opcion2) {
		int eleccion;

		boolean valor = false;
		System.out.printf("%s\n", mensaje);
		System.out.printf("1.- %s\n", opcion1);
		System.out.printf("2.- %s\n", opcion2);
		do {
			eleccion = Teclado.leerInt();

			if (eleccion == 1) {
				valor = true;

			} else if (eleccion == 2) {
				valor = false;

			}else if(eleccion!=1||eleccion!=2) {
				System.out.println("Introduce 1 o 2");
			}
		} while (eleccion != 1 && eleccion != 2);

		return valor;
	}

	//Leer boolean
	public static boolean leerBoolean(String pregunta) {
		char eleccion;
		boolean valor = false;
		do {

			System.out.printf("%s: s/n\n", pregunta);
			eleccion = Teclado.leerCaracter();
			if (eleccion == 's') {
				valor = true;
			} else if (eleccion == 'n') {
				valor = false;
			}
		} while (eleccion != 's' && eleccion != 'n');
		return valor;
	}

	
	//Leer byte
	@SuppressWarnings("unused")
	public static byte leerByte() {
		boolean error = false;
		byte n = 0;
		do {
			try {
				n = teclado.nextByte();
				error = false;
			} catch (InputMismatchException e) {
				System.out.println("Error: Deben ser numeros de tipo byte");
				error = true;
				
			}
			finally {
				Teclado.nextLine();
			}

		} while (error);
		return n;
	}

	
	//Leer short
	@SuppressWarnings("unused")
	public static short leerShort() {
		boolean error = false;
		short n = 0;
		do {
			try {
				n = teclado.nextShort();
				error = false;
			} catch (InputMismatchException e) {
				System.out.println("Error: Deben ser numeros de tipo short");
				error = true;
				
			}
			finally {
				Teclado.nextLine();
			}

		} while (error);
		return n;
	}

	
	//Leer int
	@SuppressWarnings("unused")
	public static int leerInt() {
		boolean error = false;
		int a = 0;
		do {
			try {

				a = teclado.nextInt();
				error = false;
			} catch (InputMismatchException e) {
				System.out.println("Error: Deben ser numeros de tipo entero");
				error = true;
				
			}
			finally {
				Teclado.nextLine();
			}

		} while (error);

		return a;
	}
	
	
	//Leer float
	@SuppressWarnings("unused")
	public static float leerFloat() {
		boolean error = false;
		float n = 0;
		do {
			try {
				n = teclado.nextFloat();
				error = false;
			} catch (InputMismatchException e) {
				System.out.println("Error: Deben ser numeros de tipo float");
				error = true;
				
			}
			finally {
				Teclado.nextLine();
			}

		} while (error);
		return n;
	}

	
	//Leer long
	@SuppressWarnings("unused")
	public static long leerLong() {
		boolean error = false;
		long n = 0;
		do {
			try {
				n = teclado.nextLong();
				error = false;
			} catch (InputMismatchException e) {
				System.out.println("Error: Deben ser números de tipo long");
				error = true;
				
			}
			finally {
				Teclado.nextLine();
			}

		} while (error);
		return n;
	}

	
	//Leer double
	@SuppressWarnings("unused")
	public static double leerDouble() {
		boolean error = false;
		double n = 0;
		do {
			try {
				n = teclado.nextDouble();
				error = false;
			} catch (InputMismatchException e) {
				System.out.println("Error: Deben ser numeros de tipo double");
				error = true;
				
			}
			finally {
				Teclado.nextLine();
			}

		} while (error);
		return n;
	}

	
	//Enum para leer num segun condición
	public static enum Operador {
		MAYORIGUALQUE, MENORIGUALQUE, MAYORQUE, MENORQUE

	}

	
	//Leer numero si cumple la condición enum. (SOBRECARGA PARA CADA TIPO DE NUM)
	public static byte leerNum(Operador operador, byte limite) {

		byte num = 0;

		switch (operador) {
		case MAYORIGUALQUE:
			do {
				System.out.printf("Escribe un número que sea >= que %d: ", limite);
				num = leerByte();
			} while (!(num >= limite));
			break;
		case MENORIGUALQUE:
			do {
				System.out.printf("Escribe un número que sea <= que %d: ", limite);
				num = leerByte();
			} while (!(num <= limite));
			break;
		case MAYORQUE:
			do {
				System.out.printf("Escribe un número que sea > que %d: ", limite);
				num = leerByte();
			} while (!(num > limite));
			break;
		case MENORQUE:
			do {
				System.out.printf("Escribe un número que sea < que %d: ", limite);
				num = leerByte();
			} while (!(num < limite));
			break;
		}

		return num;
	}

	public static short leerNum(Operador operador, short limite) {

		short num = 0;

		switch (operador) {
		case MAYORIGUALQUE:
			do {
				System.out.printf("Escribe un número que sea >= que %d: ", limite);
				num = leerShort();
			} while (!(num >= limite));
			break;
		case MENORIGUALQUE:
			do {
				System.out.printf("Escribe un número que sea <= que %d: ", limite);
				num = leerShort();
			} while (!(num <= limite));
			break;
		case MAYORQUE:
			do {
				System.out.printf("Escribe un número que sea > que %d: ", limite);
				num = leerShort();
			} while (!(num > limite));
			break;
		case MENORQUE:
			do {
				System.out.printf("Escribe un número que sea < que %d: ", limite);
				num = leerShort();
			} while (!(num < limite));
			break;
		}

		return num;
	}

	public static int leerNum(Operador operador, int limite) {

		int num = 0;

		switch (operador) {
		case MAYORIGUALQUE:
			do {
				System.out.printf("Escribe un número que sea >= que %d: ", limite);
				num = leerInt();
			} while (!(num >= limite));
			break;
		case MENORIGUALQUE:
			do {
				System.out.printf("Escribe un número que sea <= que %d: ", limite);
				num = leerInt();
			} while (!(num <= limite));
			break;
		case MAYORQUE:
			do {
				System.out.printf("Escribe un número que sea > que %d: ", limite);
				num = leerInt();
			} while (!(num > limite));
			break;
		case MENORQUE:
			do {
				System.out.printf("Escribe un número que sea < que %d: ", limite);
				num = leerInt();
			} while (!(num < limite));
			break;
		}

		return num;
	}

	public static float leerNum(Operador operador, float limite) {

		float num = 0;

		switch (operador) {
		case MAYORIGUALQUE:
			do {
				System.out.printf("Escribe un número que sea >= que %f: ", limite);
				num = leerFloat();
			} while (!(num >= limite));
			break;
		case MENORIGUALQUE:
			do {
				System.out.printf("Escribe un número que sea <= que %f: ", limite);
				num = leerFloat();
			} while (!(num <= limite));
			break;
		case MAYORQUE:
			do {
				System.out.printf("Escribe un número que sea > que %f: ", limite);
				num = leerFloat();
			} while (!(num > limite));
			break;
		case MENORQUE:
			do {
				System.out.printf("Escribe un número que sea < que %f: ", limite);
				num = leerFloat();
			} while (!(num < limite));
			break;
		}

		return num;
	}

	public static long leerNum(Operador operador, long limite) {

		long num = 0;

		switch (operador) {
		case MAYORIGUALQUE:
			do {
				System.out.printf("Escribe un número que sea >= que %d: ", limite);
				num = leerLong();
			} while (!(num >= limite));
			break;
		case MENORIGUALQUE:
			do {
				System.out.printf("Escribe un número que sea <= que %d: ", limite);
				num = leerLong();
			} while (!(num <= limite));
			break;
		case MAYORQUE:
			do {
				System.out.printf("Escribe un número que sea > que %d: ", limite);
				num = leerLong();
			} while (!(num > limite));
			break;
		case MENORQUE:
			do {
				System.out.printf("Escribe un número que sea < que %d: ", limite);
				num = leerLong();
			} while (!(num < limite));
			break;
		}
		return num;
	}

	public static double leerNum(Operador operador, double limite) {

		double num = 0;

		switch (operador) {
		case MAYORIGUALQUE:
			do {
				System.out.printf("Escribe un número que sea >= que %f: ", limite);
				num = leerDouble();
			} while (!(num >= limite));
			break;
		case MENORIGUALQUE:
			do {
				System.out.printf("Escribe un número que sea <= que %f: ", limite);
				num = leerDouble();
			} while (!(num <= limite));
			break;
		case MAYORQUE:
			do {
				System.out.printf("Escribe un número que sea > que %f: ", limite);
				num = leerDouble();
			} while (!(num > limite));
			break;
		case MENORQUE:
			do {
				System.out.printf("Escribe un número que sea < que %f: ", limite);
				num = leerDouble();
			} while (!(num < limite));
			break;
		}

		return num;
	}

	//Enum para indicar el rango de los numeros
	public static enum Incluido {
		INCLUIDOS, EXCLUIDOS, MENORINCLUIDO, MAYORINCLUIDO
	}

	//Leer numeros comprendidos entre numeros dados(SOBRECARGAR PARA CADA TIPO DE NUM)
	public static byte leerNumEntre(Incluido Incluido, byte minimo, byte maximo) throws IllegalArgumentException {

		byte num = 0;
		if (minimo > maximo) {
			throw new IllegalArgumentException();
		}
		switch (Incluido) {
		case INCLUIDOS:
			do {
				System.out.printf("Escribe un número que sea >= que %d y <= que %d: ", minimo, maximo);
				num = leerByte();
			} while (!(num >= minimo && num <= maximo));
			break;
		case EXCLUIDOS:
			do {
				System.out.printf("Escribe un número que sea > que %d y < que %d: ", minimo, maximo);
				num = leerByte();
			} while (!(num > minimo && num < maximo));
			break;
		case MENORINCLUIDO:
			do {
				System.out.printf("Escribe un número que sea >= que %d y < que %d: ", minimo, maximo);
				num = leerByte();
			} while (!(num >= minimo && num < maximo));
			break;
		case MAYORINCLUIDO:
			do {
				System.out.printf("Escribe un número que sea > que %d y <= que %d: ", minimo, maximo);
				num = leerByte();
			} while (!(num > minimo && num <= maximo));
		}
		return num;

	}

	public static short leerNumEntre(Incluido Incluido, short minimo, short maximo) throws IllegalArgumentException {

		short num = 0;
		if (minimo > maximo) {
			throw new IllegalArgumentException();
		}
		switch (Incluido) {
		case INCLUIDOS:
			do {
				System.out.printf("Escribe un número que sea >= que %d y <= que %d: ", minimo, maximo);
				num = leerShort();
			} while (!(num >= minimo && num <= maximo));
			break;
		case EXCLUIDOS:
			do {
				System.out.printf("Escribe un número que sea > que %d y < que %d: ", minimo, maximo);
				num = leerShort();
			} while (!(num > minimo && num < maximo));
			break;
		case MENORINCLUIDO:
			do {
				System.out.printf("Escribe un número que sea >= que %d y < que %d: ", minimo, maximo);
				num = leerShort();
			} while (!(num >= minimo && num < maximo));
			break;
		case MAYORINCLUIDO:
			do {
				System.out.printf("Escribe un número que sea > que %d y <= que %d: ", minimo, maximo);
				num = leerShort();
			} while (!(num > minimo && num <= maximo));
		}
		return num;

	}

	public static int leerNumEntre(Incluido Incluido, int minimo, int maximo) throws IllegalArgumentException {

		int num = 0;
		if (minimo > maximo) {
			throw new IllegalArgumentException();
		}
		switch (Incluido) {
		case INCLUIDOS:
			do {
				num = leerInt();
			} while (!(num >= minimo && num <= maximo));
			break;
		case EXCLUIDOS:
			do {
				num = leerInt();
			} while (!(num > minimo && num < maximo));
			break;
		case MENORINCLUIDO:
			do {
				num = leerInt();
			} while (!(num >= minimo && num < maximo));
			break;
		case MAYORINCLUIDO:
			do {
				num = leerInt();
			} while (!(num > minimo && num <= maximo));
		}
		return num;

	}

	public static long leerNumEntre(Incluido Incluido, long minimo, long maximo) throws IllegalArgumentException {

		long num = 0;
		if (minimo > maximo) {
			throw new IllegalArgumentException();
		}
		switch (Incluido) {
		case INCLUIDOS:
			do {
				System.out.printf("Escribe un número que sea >= que %d y <= que %d: ", minimo, maximo);
				num = leerLong();
			} while (!(num >= minimo && num <= maximo));
			break;
		case EXCLUIDOS:
			do {
				System.out.printf("Escribe un número que sea > que %d y < que %d: ", minimo, maximo);
				num = leerLong();
			} while (!(num > minimo && num < maximo));
			break;
		case MENORINCLUIDO:
			do {
				System.out.printf("Escribe un número que sea >= que %d y < que %d: ", minimo, maximo);
				num = leerLong();
			} while (!(num >= minimo && num < maximo));
			break;
		case MAYORINCLUIDO:
			do {
				System.out.printf("Escribe un número que sea > que %d y <= que %d: ", minimo, maximo);
				num = leerLong();
			} while (!(num > minimo && num <= maximo));
		}
		return num;

	}

	public static float leerNumEntre(Incluido Incluido, float minimo, float maximo) throws IllegalArgumentException {

		float num = 0;
		if (minimo > maximo) {
			throw new IllegalArgumentException();
		}
		switch (Incluido) {
		case INCLUIDOS:
			do {
				System.out.printf("Escribe un número que sea >= que %f y <= que %f: ", minimo, maximo);
				num = leerFloat();
			} while (!(num >= minimo && num <= maximo));
			break;
		case EXCLUIDOS:
			do {
				System.out.printf("Escribe un número que sea > que %f y < que %f: ", minimo, maximo);
				num = leerFloat();
			} while (!(num > minimo && num < maximo));
			break;
		case MENORINCLUIDO:
			do {
				System.out.printf("Escribe un número que sea >= que %f y < que %f: ", minimo, maximo);
				num = leerFloat();
			} while (!(num >= minimo && num < maximo));
			break;
		case MAYORINCLUIDO:
			do {
				System.out.printf("Escribe un número que sea > que %f y <= que %f: ", minimo, maximo);
				num = leerFloat();
			} while (!(num > minimo && num <= maximo));
		}
		return num;

	}

	public static double leerNumEntre(Incluido Incluido, double minimo, double maximo) throws IllegalArgumentException {

		double num = 0;
		if (minimo > maximo) {
			throw new IllegalArgumentException();
		}
		switch (Incluido) {
		case INCLUIDOS:
			do {
				System.out.printf("Escribe un número que sea >= que %f y <= que %f: ", minimo, maximo);
				num = leerDouble();
			} while (!(num >= minimo && num <= maximo));
			break;
		case EXCLUIDOS:
			do {
				System.out.printf("Escribe un número que sea > que %f y < que %f: ", minimo, maximo);
				num = leerDouble();
			} while (!(num > minimo && num < maximo));
			break;
		case MENORINCLUIDO:
			do {
				System.out.printf("Escribe un número que sea >= que %f y < que %f: ", minimo, maximo);
				num = leerDouble();
			} while (!(num >= minimo && num < maximo));
			break;
		case MAYORINCLUIDO:
			do {
				System.out.printf("Escribe un número que sea > que %f y <= que %f: ", minimo, maximo);
				num = leerDouble();
			} while (!(num > minimo && num <= maximo));
		}
		return num;

	}

}
