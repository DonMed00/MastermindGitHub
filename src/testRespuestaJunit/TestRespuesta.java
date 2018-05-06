package testRespuestaJunit;

import static mastermind.Colores.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import mastermind.Combinacion;
import mastermind.Ficha;
import mastermind.Jugador;
import mastermind.Maquina;
import mastermind.Modos;

class TestRespuesta {

	@Test
	@DisplayName("Pruebas para el método darAciertosRival en Facil y Medio")
	void darAciertosTestFacilMedio() {
		/*
		 * Utilizamos una combinacion para igualarla al metodo a comprobar que recibe
		 * como parametros dos combinaciones, las cuales iran variando segun el tipo de
		 * prueba que le hagamos.
		 */
		int i;
		Jugador m = new Maquina(Modos.Facil);
		Combinacion pinchosNegros = new Combinacion(Modos.Facil);
		Combinacion combi1 = new Combinacion(Modos.Facil);
		Combinacion combi2 = new Combinacion(Modos.Facil);
		Ficha[] fichas = new Ficha[4];
		fichas[0] = new Ficha();
		fichas[1] = new Ficha();
		fichas[2] = new Ficha();
		fichas[3] = new Ficha();
		fichas[0].setColor(ROJO + (char) 9209 + RESET);
		fichas[1].setColor(VERDE + (char) 9209 + RESET);
		fichas[2].setColor(AZUL + (char) 9209 + RESET);
		fichas[3].setColor(AMARILLO + (char) 9209 + RESET);
		for (i = 0; i < pinchosNegros.getCasillas().length; i++) {
			pinchosNegros.getCasillas()[i] = new Ficha();
			pinchosNegros.getCasillas()[i].setColor((NEGRO + (char) 9210 + RESET));
		}
		combi1.setCasillas(fichas);
		combi2.setCasillas(fichas);
		assertEquals(pinchosNegros, m.darAciertosRival(combi1, combi2));// Debe funcionar ya que las combinacion son
		// iguales
	}

	@Test
	@DisplayName("Pruebas para el método darAciertosRival en Difícil")
	void darAciertosTestDificil() {
		/*
		 * Utilizamos una combinacion para igualarla al metodo a comprobar que recibe
		 * como parametros dos combinaciones, las cuales iran variando segun el tipo de
		 * prueba que le hagamos.
		 */
		int i;
		Jugador m = new Maquina(Modos.Dificil);
		Combinacion pinchosNegros = new Combinacion(Modos.Dificil);
		Combinacion combi1 = new Combinacion(Modos.Dificil);
		Combinacion combi2 = new Combinacion(Modos.Facil);
		Ficha[] fichas = new Ficha[Modos.Dificil.getNumCasillas()];
		for (i = 0; i < fichas.length; i++) {
			fichas[i] = new Ficha();
			fichas[i].setColor(AMARILLO + (char) 9209 + RESET);
		}
		fichas[6] = new Ficha();
		fichas[6].setColor(AZUL + (char) 9209 + RESET);
		for (i = 0; i < pinchosNegros.getCasillas().length; i++) {
			pinchosNegros.getCasillas()[i] = new Ficha();
			pinchosNegros.getCasillas()[i].setColor((ROJO + (char) 9210 + RESET));
		}
		combi1.setCasillas(fichas);
		combi2.setCasillas(fichas);
		assertNotEquals(pinchosNegros, m.darAciertosRival(combi1, combi2));// Debe funcionar ya que las combinacion son
																			// iguales, y se ha igualado a unos pinchos
																			// rojos, cuando deberia ser negro.
	}
}