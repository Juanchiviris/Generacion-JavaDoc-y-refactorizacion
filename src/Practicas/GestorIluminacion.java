package Practicas;

/**
 * Clase encargada de controlar la iluminacion de las pistas deportivas.
 * Permite encender y apagar las luces de pistas individuales
 * 
 * Autor: Juanjo
 */


public class GestorIluminacion {
	private boolean[] iluminacion;
	
	/**
	 * Inicializa el gestor de iluminacion para una cantidad de pistas determinada
	 * 
	 * @param numPistas numero total de pistas
	 */
	
	public GestorIluminacion(int numPistas) {
		iluminacion = new boolean[numPistas];
	}
	
	/**
	 * Enciende las luces de una pista especifica.
	 * 
	 * @param idPista identificador de la pista
	 * @return true si se encendieron, false si el ID es invalido.
	 */
	
	public boolean encenderLuces(int idPista) {
		if(!esPistaValida(idPista)) return false;
		iluminacion[idPista] = true;
		return true;
	}
	
	/**
	 * Apaga las luces de una pista especifica
	 * 
	 * @param idPista identificador de la pista
	 * @return true si se apagaron, false si el ID es invalido
	 */
	
	public boolean apagarLuces(int idPista) {
		if (!esPistaValida(idPista)) return false;
		iluminacion[idPista] = false;
		return true;
	}
	
	/**
	 * verifica si el ID de pista es valirdo
	 */
	
	private boolean esPistaValida(int idPista) {
		return idPista >= 0 && idPista < iluminacion.length;
	}

}
