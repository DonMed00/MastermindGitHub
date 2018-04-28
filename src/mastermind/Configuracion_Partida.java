package mastermind;

import static mastermind.Teclado.*;

public class Configuracion_Partida {
	Modos modo;

	public Configuracion_Partida() {
	}
	public Modos elegirModo() {
		int numModo;
		Modos modo = null;
		System.out.println("Bienvenido a Mastermind");
		System.out.println("Elige un modo de juego:");
		System.out.println("1. Fácil");
		System.out.println("2. Medio");
		System.out.println("3. Difícil");
		numModo=leerNumEntre(Incluido.INCLUIDOS,1,3);
		switch(numModo) {
		case 1:
			modo=Modos.Facil;
			break;
		case 2:
			modo=Modos.Medio;
			break;
		case 3:
			modo=Modos.Dificil;
			break;
		}
		return modo;
	}
	public void hacerPartida(){
		boolean jugar = false;
		do {
		Partida partida;
		Jugador jugador1 = null;
		Jugador jugador2 = null;
		TableroJugador tablero1=new TableroJugador();
		TableroJugador tablero2=new TableroJugador();
		this.modo=elegirModo();
		partida=new Partida(jugador1,jugador2,tablero1,tablero2,modo);
		partida.llamarPartida();
		jugar=Teclado.leerBoolean("\n¿Volver a jugar?", "Si","No" );
		}while(jugar);
		System.out.println("Hasta la próxima");
	}
	public static void main(String[] args){
		Configuracion_Partida partida=new Configuracion_Partida();
		partida.hacerPartida();
//		TreeMap<String,Integer> mapa=new TreeMap<>();
//		mapa.put("C", 1);
//		mapa.put("C", 2);
//		mapa.put("C", 3);
//		mapa.put("A", 1);
//		mapa.put("D", 2);
//		for (Object l : mapa.values()) {// No se ordena alfabeticamente en mi eclipse(Posible error).
//			System.out.println(l);
//		}
	}
	
}
