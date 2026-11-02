package test.model;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.Test; 
import static org.junit.jupiter.api.Assertions.*;


import model.Jugador;

public class JugadorTest {

	//PRUEBA 1: verifico que la posicion avance
	@Test
	public void testAvanzarPosicion() {
		Jugador jugador = new Jugador(); // al crear al jugador su posicion inicial debe ser 0
		jugador.avanzarPosicion(5);
		
		int posicionActual = jugador.obtenerPosicionActual();
		
		assertEquals(5, posicionActual, "No devolvio el valor esperado");
	}
	
	//PRUEBA 2: si gana dos veces la estrella de la misma categoria no debe sumar
	@Test
	public void testEstrellasDuplicadasNoSuman() {
		Jugador jugador = new Jugador();
		jugador.agregarEstrella("Historia y Geografía");
		jugador.agregarEstrella("Historia y Geografía");
		jugador.agregarEstrella("Historia y Geografía");
		jugador.agregarEstrella("Historia y Geografía");
		jugador.agregarEstrella("Historia y Geografía");
		//deberia tener solo UNA estrella porque esta es duplicada, no deberia ganar
		
		boolean resultado = jugador.tieneTodasLasEstrellas();

		assertFalse(resultado, "El jugador no deberia ganar al agregar categorias duplicadas");
	
	}
	
	//PRUEBA 3: si tiene CINCO estrellas de distintas categorias, se cumple la condicion de victoria
	@Test
	public void testVictoriaConCincoEstrellasDiferentes() {
		Jugador jugador = new Jugador();
		
		jugador.agregarEstrella("Historia y Geografía");
		jugador.agregarEstrella("Arte y Literatura"); 
		jugador.agregarEstrella("Naturaleza y Ciencia"); 
		jugador.agregarEstrella("Deportes y Juegos"); 
		jugador.agregarEstrella("Entretenimientos y Espectáculos");
		
		boolean resultado = jugador.tieneTodasLasEstrellas();
		
		assertTrue(resultado, "Deberia de haber ganado");
	}
	
	//PRUEBA 4: si tiene CUATRO estrellas de distintas categorias, NO se cumple la condicion de victoria
	@Test
	public void testCuatroEstrellasDiferentes() {
		Jugador jugador = new Jugador();
		jugador.agregarEstrella("Historia y Geografía");
		jugador.agregarEstrella("Arte y Literatura"); 
		jugador.agregarEstrella("Naturaleza y Ciencia"); 
		jugador.agregarEstrella("Deportes y Juegos");
		
		boolean resultado = jugador.tieneTodasLasEstrellas();
		
		assertFalse(resultado, "No deberia de haber ganado");
	}
	
	//PRUEBA 5:si se llega al final del tablero que pegue la vuelta y siga el juego
	@Test
	public void testAvanzarPosicionPegaLaVuelta() {
		Jugador jugador = new Jugador();

		jugador.avanzarPosicion(40); //(0+40)%36 deberia ser la posicion 4

		assertEquals(4, jugador.obtenerPosicionActual(), "El tablero debe ser circular y retornar a la misma casilla inicial");
	}
	
	//PRUEBA 6:prueba para ver si funciona cuando le di 3 vueltas completas al tablero
	@Test
	public void testAvanzarPosicionManejaMultiplesVueltas() {
		Jugador jugador = new Jugador();

		jugador.avanzarPosicion(36*3); //me deberia de dar la posicion 0, como que le di 3 vuetlas completas al tablero

		assertEquals(0, jugador.obtenerPosicionActual(), "El tablero debe ser circular y retornar a la misma casilla inicial");
	}

	@Test
	public void testElegirCategoriaReintentaHastaRecibirOpcionValida() {
		java.io.InputStream entradaOriginal = System.in;
		try {
			System.setIn(new ByteArrayInputStream("0\ntexto\n6\n3\n".getBytes()));
			Jugador jugador = new Jugador();

			assertEquals("Naturaleza y Ciencia", jugador.elegirCategoria());
		} finally {
			System.setIn(entradaOriginal);
		}
	}
}
