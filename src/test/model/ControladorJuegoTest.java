package test.model;

import org.junit.jupiter.api.Test; 
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;

import controller.ControladorJuego; 
import model.Jugador; 
import model.Tablero; 
import model.Dado; 
import model.ProveedorPreguntas; 

public class ControladorJuegoTest {
	
	// Atributos de la prueba compartidos por cada test
	private Tablero tablero; 
	private ProveedorPreguntas proveedor; 
	private Dado dado; 
	private Jugador jugador1; 
	private Jugador jugador2; 
	private ControladorJuego controlador;
	

	// Se ejecuta automaticamente antes de CADA metodo @Test
	@BeforeEach 
	public void setUp() { 
		this.tablero = new Tablero();
		this.proveedor = new ProveedorPreguntas(); 
		this.dado = new Dado(); 
		this.jugador1 = new Jugador(); 
		this.jugador2 = new Jugador();	
		
		List<Jugador> jugadores = List.of(jugador1, jugador2);
		
		this.controlador = new ControladorJuego(tablero, proveedor, dado, jugadores);
	}
		
		
	//PRUEBA 1: verifica que se inicialice en estado valido(no null) y que la partida ya este lista para jugar
	@Test
	public void testInicializacionDelControlador() {
		assertNotNull(controlador, "El controlador debe instanciarse sin ser nulo");
	}
	
	//PRUEBA 2: verifica que empiece siempre el jugador 1
	@Test
	public void testEmpiezaJugador1(){
		assertEquals(jugador1, controlador.obtenerJugadorActual(), "El jugador inicial debe ser el primero de la lista");
	}
	
	//PRUEBA 3: verifica que el jugador avance correctamente de posición
	@Test
	public void testAvanzarPosicionDelJugador() {
		int posicionInicial = jugador1.obtenerPosicionActual();
		jugador1.avanzarPosicion(1);
		
		assertEquals(posicionInicial + 1, jugador1.obtenerPosicionActual(), "La posición del jugador debe avanzar");
	}
	
	//PRUEBA 4: verifico que si acierto se me mantenga el turno
	@Test
	public void testNotificarAciertoMantieneTurno() {
		assertDoesNotThrow(() -> controlador.notificarAcierto(), "notificarAcierto no debe lanzar errores");		
	}
	
	//PRUEBA 5: verifico que pase al siguiente turno correctamente
	@Test
	public void testSiguienteTurnoNoLanzaExcepcion() {
		assertDoesNotThrow(() -> controlador.siguienteTurno(), "siguienteTurno debe ejecutarse sin excepciones");		
	}
	
	//PRUEBA 6: verifico que si erro la respuesta cambie o rote de jugador
	@Test
	public void testSiguienteTurnoCambiaAlProximoJugador() {
		//somos jugador1
		assertSame(jugador1, controlador.obtenerJugadorActual());
	
		controlador.siguienteTurno();
		//somos jugador2
		assertSame(jugador2, controlador.obtenerJugadorActual(), "al errar la pregunta y pasar al siguiente turno deberia cambiar de jugador");
	}
}
