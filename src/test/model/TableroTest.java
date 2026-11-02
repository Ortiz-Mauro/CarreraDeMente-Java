package test.model;

import org.junit.jupiter.api.Test; 
import static org.junit.jupiter.api.Assertions.*; 

import model.Tablero;
import model.Casilla;

public class TableroTest {

	//PRUEBA 1: obtener la casilla en la primer posicion del tablero
	@Test
	public void testObtenerCasillaEnPosicionValida() {
		Tablero tablero = new Tablero();
		Casilla casillaObtenida = tablero.obtenerCasillaEn(0);
		
		//verificamos existencia y consistencia de datos 
		assertNotNull(casillaObtenida, "El tablero no deberia devolver null en la posicion 0");
		assertNotNull(casillaObtenida.obtenerCategoria(), "La casilla obtenida debe tener una categoria valida");
	}
	
	// PRUEBA 2: obtener la casilla en la última posición del tablero
	@Test public void testObtenerCasillaEnUltimaPosicion() { 
		Tablero tablero = new Tablero();
		Casilla casillaObtenida = tablero.obtenerCasillaEn(35); 
		// Último casillero de los 36 
		assertNotNull(casillaObtenida, "El tablero no debería devolver null en la última posición (35)");
		assertNotNull(casillaObtenida.obtenerCategoria(), "La casilla de la última posición debe tener una categoría válida");
		}
}
