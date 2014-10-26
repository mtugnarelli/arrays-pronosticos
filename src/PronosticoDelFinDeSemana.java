public class PronosticoDelFinDeSemana {

	private double temperaturaSabado;
	private double temperaturaDomingo;

	/**
	 * post: el pronostico queda inicializado con temperatura de 0º para el
	 * sábado y el domingo.
	 */
	public PronosticoDelFinDeSemana() {
		
		this.temperaturaSabado = 0;
		this.temperaturaDomingo = 0;
	}

	/**
	 * post: devuelve la temperatura pronosticada para el día sábado en grados
	 * centígrados.
	 */
	public double obtenerTemperaturaDelSabado() {

		return this.temperaturaSabado;
	}

	/**
	 * post: devuelve la temperatura pronosticada para el día domingo en grados
	 * centígrados.
	 */
	public double obtenerTemperaturaDelDomingo() {

		return this.temperaturaDomingo;
	}

	/**
	 * pre : se indica la temperatura en grados centígrados en el rango (-40.0,
	 * 50.0). post: cambia la temperatura pronosticada para el día sábado.
	 * 
	 */
	public void pronosticarSabado(double temperatura) {

		this.validarTemperatura(temperatura);
		this.temperaturaSabado = temperatura;
	}

	/**
	 * pre : se indica la temperatura en grados centígrados en el rango (-40.0,
	 * 50.0). post: cambia la temperatura pronosticada para el día domingo.
	 * 
	 */
	public void pronosticarDomingo(double temperatura) {

		this.validarTemperatura(temperatura);
		this.temperaturaDomingo = temperatura;
	}

	private void validarTemperatura(double temperatura) {
		
		if ((temperatura < -40) || (temperatura > 50)) {
		
			Error temperaturaErronea = new Error("La temperatura " + temperatura + 
												 ", no está en el rango (-40.0, 50.0)");
			throw temperaturaErronea;
		}
	}

	/**
	 * post: devuelve la temperatura promedio del fin de semana en grados
	 * centígrados.
	 */
	public double calcularPromedio() {

		return (this.obtenerTemperaturaDelDomingo() + this.obtenerTemperaturaDelSabado()) / 2;
	}

	/**
	 * post: devuelve la temparatura más baja del pronóstico.
	 */
	public double buscarTemperaturaMinima() {

		double minima = this.obtenerTemperaturaDelSabado();
		
		if (this.obtenerTemperaturaDelDomingo() < minima) {
			
			minima = this.obtenerTemperaturaDelDomingo();
		}
		
		return minima;
	}

	/**
	 * post: devuelve la temparatura más alta del pronóstico.
	 */
	public double buscarTemperaturaMaxima() {

		double maxima = this.obtenerTemperaturaDelSabado();
		
		if (this.obtenerTemperaturaDelDomingo() > maxima) {
			
			maxima = this.obtenerTemperaturaDelDomingo();
		}
		
		return maxima;
	}
}
