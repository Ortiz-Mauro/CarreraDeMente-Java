package test.model;

import org.junit.jupiter.api.Test; 
import static org.junit.jupiter.api.Assertions.*; 

import java.util.List;
import java.util.Arrays;

import model.Pregunta;

public class PreguntaTest {

	//PRUEBA 1: verifico que la opcion elejida coinicida con la opcion correcta
	@Test
	public void testRespuestaCorrectaDevuelveTrue() {

		List<String> opciones = Arrays.asList("1816", "1810", "1853", "1820");
		
		Pregunta pregunta = new Pregunta(
				"¿En qué año fue la Revolución de Mayo?",
				opciones,
				2,
				"Historia y Geografía");
		
		boolean respuesta = pregunta.esCorrecta(2);//deberia devolver true
		
		assertTrue(respuesta, "La opcion 2 deberia ser la correcta");
	}
	
	//PRUEBA 2: verifico que la opcion elejida incorrecta sea incorrecta
	@Test
	public void testRespuestaIncorrectaDevuelveFalse() {

		List<String> opciones = Arrays.asList("1816", "1810", "1853", "1820");
		
		Pregunta pregunta = new Pregunta(
				"¿En qué año fue la Revolución de Mayo?",
				opciones,
				2,
				"Historia y Geografía");
		
		boolean respuesta = pregunta.esCorrecta(1);//deberia devolver false
		
		assertFalse(respuesta, "La opcion 1 deberia dar false");
	}
	
	//PRUEBA 3: verifico que la respuesta sea una opcion valida
	@Test
	public void testRespuestaInvalidaDevuelveFalse(){

		List<String> opciones = Arrays.asList("1816", "1810", "1853", "1820");
		
		Pregunta pregunta = new Pregunta(
				"¿En qué año fue la Revolución de Mayo?",
				opciones,
				2,
				"Historia y Geografía");
		
		boolean respuesta = pregunta.esCorrecta(99);//deberia devolver false
		
		assertFalse(respuesta, "Opcion inexistente debe devolver false");
	}

	
	//PRUEBA 4: verifico que los datos del constructor sean correctos
	@Test
	public void testGettersRetornanValoresCorrectos(){

		String consignaEsperada = "¿En qué año fue la Revolución de Mayo?";
		List<String> opcionesEsperadas = Arrays.asList("1816", "1810", "1853", "1820");
		int  opcionCorrectaEsperada = 2;
		String categoriaEsperada = "Historia y Geografía";

		Pregunta pregunta = new Pregunta(
				consignaEsperada,
				opcionesEsperadas,
				opcionCorrectaEsperada,
				categoriaEsperada);
		
		List<String> opcionesObtenidas = pregunta.obtenerOpciones();
		String consignaObtenida = pregunta.obtenerConsigna();
		assertEquals(consignaEsperada, consignaObtenida, "No devolvio el valor esperado");
		assertEquals(opcionesEsperadas, opcionesObtenidas, "No devolvio el valor esperado");
	
		assertEquals(categoriaEsperada, pregunta.obtenerCategoria(), "La categoria devuelta no coincide con la esperada.");
	}
}