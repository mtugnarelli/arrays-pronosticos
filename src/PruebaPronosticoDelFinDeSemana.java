import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PruebaPronosticoDelFinDeSemana {

	private PronosticoDelFinDeSemana pronostico;

	@Before
	public void inicializarPronostico() {
		
		pronostico = new PronosticoDelFinDeSemana();

	}

	@Test
	public void crear() {
		
		/* operación */
		double temperaturaSabado = pronostico.obtenerTemperaturaDelSabado();
		double temperaturaDomingo = pronostico.obtenerTemperaturaDelDomingo();
		
		/* comprobación */
		Assert.assertEquals("sabado", 0, temperaturaSabado, 0.001);
		Assert.assertEquals("domingo", 0, temperaturaDomingo, 0.001);
	}

	@Test
	public void cambiarTemperaturaSabado() {
		
		/* operación */
		pronostico.pronosticarSabado(29);
		
		/* comprobación */
		Assert.assertEquals("sabado", 29, pronostico.obtenerTemperaturaDelSabado(), 0.001);
	}

	@Test(expected = Error.class)
	public void pronosticarSabadoConTemperaturaMayorAlMaximoGeneraUnError() {

		/* operación */
		pronostico.pronosticarSabado(51);
	}

	@Test(expected = Error.class)
	public void pronosticarSabadoConTemperaturaMenorAlMinimoGeneraUnError() {
		
		/* operación */
		pronostico.pronosticarSabado(-41);
	}

	@Test
	public void cambiarTemperaturaDomingo() {
		
		/* operación */
		pronostico.pronosticarDomingo(24);
		
		/* comprobación */
		Assert.assertEquals("domingo", 24, pronostico.obtenerTemperaturaDelDomingo(), 0.001);
	}

	@Test(expected = Error.class)
	public void pronosticarDomingoConTemperaturaMayorAlMaximoGeneraUnError() {

		/* operación */
		pronostico.pronosticarDomingo(50.1);
	}

	@Test(expected = Error.class)
	public void pronosticarDomingoConTemperaturaMenorAlMinimoGeneraUnError() {
		
		/* operación */
		pronostico.pronosticarDomingo(-40.3);
	}

	@Test
	public void calcularTemperaturaPromedio() {
		
		/* inicialización */
		pronostico.pronosticarSabado(15);
		pronostico.pronosticarDomingo(22);
		
		/* operación */
		double temperaturaPromedio = pronostico.calcularPromedio();
		
		/* comprobación */
		Assert.assertEquals("promedio", 18.5, temperaturaPromedio, 0.001);
	}
	
	@Test
	public void buscarTemperaturaMinima() {
		
		/* inicialización */
		pronostico.pronosticarSabado(12);
		pronostico.pronosticarDomingo(19);
		
		/* operación */
		double minima = pronostico.buscarTemperaturaMinima();
		
		/* comprobación */
		Assert.assertEquals("minima", 12, minima, 0.001);
	}
	
	@Test
	public void buscarTemperaturaMaxima() {
		
		/* inicialización */
		pronostico.pronosticarSabado(12);
		pronostico.pronosticarDomingo(19);
		
		/* operación */
		double maxima = pronostico.buscarTemperaturaMaxima();
		
		/* comprobación */
		Assert.assertEquals("minima", 19, maxima, 0.001);
	}
	
}