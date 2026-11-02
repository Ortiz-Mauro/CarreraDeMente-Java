package test.model;

import org.junit.jupiter.api.Test; 
import static org.junit.jupiter.api.Assertions.*; 

import java.util.HashSet;
import java.util.Set;

import model.Dado;

public class DadoTest {

	//PRUEBA 1: me debe devolver un valor entre 1 y 6 inclusive
	@Test
	public void testLanzarDadoRangoValido() {
		Dado dado = new Dado();
		
		for (int i=0; i<100; i++) {
			int resultado = dado.lanzarDado();
			
			assertTrue((resultado>=1 && resultado<=6), "Devolvio un valor fuera del rango 1-6");
		}
	}
	
	//PRUEBA 2: verifica que cada lanzada devuelva un valor distinto
	@Test
	public void testLanzarDadoDevuelveValoresDiferentes() {
		Dado dado = new Dado();
		Set <Integer> valoresObtenidos = new HashSet<>();//guardo solo valores NO repetidos

		for (int i=0; i<100; i++) {
			int tirada = dado.lanzarDado();
			valoresObtenidos.add(tirada);
		}	
		
		assertTrue(valoresObtenidos.size()>1, "No varia de numero");
		
	}
}
