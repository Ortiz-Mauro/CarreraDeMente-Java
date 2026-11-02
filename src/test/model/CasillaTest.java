package test.model;

import org.junit.jupiter.api.Test; 
import static org.junit.jupiter.api.Assertions.*; 

import model.Casilla;

public class CasillaTest {

	//PRUEBA 1: que la casilla devuelva su categoria asignada
	@Test
	public void testObtenerCategoria() {
		Casilla casilla = new Casilla("Deportes y Juegos", false);
		String categoriaObtenida = casilla.obtenerCategoria();
		
		assertEquals("Deportes y Juegos", categoriaObtenida);
	}
	
	//PRUEBA 2: chequea que la casilla sea normal(sin estrella) de false
	@Test
	public void testCasillaComunNoEsEstrella() {
		Casilla casilla = new Casilla("Deportes y Juegos", false);
		boolean esEstrella = casilla.esEstrella();
		
		assertFalse(esEstrella, "Una casilla comun no debe ser de tipo estrella");
	}
	
	//PRUEBA 3: chequea que la casilla sea especial(con estrella) devuelva true
	@Test
	public void testCasillaEstrellaDevuelveTrue() {
		Casilla casilla = new Casilla("Deportes y Juegos", true);
		boolean esEstrella = casilla.esEstrella();
		
		assertTrue(esEstrella, "Una casilla especial deberia dar TRUE");
	}
	
}
