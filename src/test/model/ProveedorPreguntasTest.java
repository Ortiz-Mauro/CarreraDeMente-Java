package test.model;

import org.junit.jupiter.api.Test; 
import static org.junit.jupiter.api.Assertions.*; 

import model.ProveedorPreguntas;
import model.Pregunta;

public class ProveedorPreguntasTest {

	//PRUEBA 1: verifico que al solicitar una categoria valida como "Historia y Geografía"
	//el repositorio entregue un objeto "Pregunta" instanciado
	@Test
	public void testObtenerPreguntaPorCategoriaExistente() {
		ProveedorPreguntas proveedor = new ProveedorPreguntas();
		Pregunta preguntaObtenida = proveedor.obtenerPregunta("Historia y Geografía");
		
		assertNotNull(preguntaObtenida, "Proveedor debe entregar una pregunta valida.");	
	}
	
	//PRUEBA 2: Verifico que si le pedimos la pregunta de una categoria, devuelva una de ESA categoria
	@Test
	public void testPreguntaDevueltaCoincideConCategoria() {		
		ProveedorPreguntas proveedor = new ProveedorPreguntas();
		Pregunta preguntaObtenida = proveedor.obtenerPregunta("Deportes y Juegos");
			
		assertNotNull(preguntaObtenida);
		assertEquals("Deportes y Juegos", preguntaObtenida.obtenerCategoria(), "La categoria debe coinicidir.");
	}
	
	//PRUEBA 3: Si se pregunta por una categoria que NO EXISTE debe devolver null
	@Test
	public void testObtenerPreguntaPorCategoriaInexistente() {	
		ProveedorPreguntas proveedor = new ProveedorPreguntas();
		Pregunta preguntaObtenida = proveedor.obtenerPregunta("Astronomia");
		
		assertNull(preguntaObtenida, "Deberia devolver null si la categoria no existe.");
	}
}