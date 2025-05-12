package Practicas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un sistema de reservas par pistas deportivas.
 * Permite reservar, cancelar y verificar disponibilidad de pistas, asi como controlar su iluminacion
 * @author Juanjo
 * @version 1.0
 */

public class SistemaReservasDeportivas {

    private List<Reserva> reservas;
    private boolean[] iluminacion;
    private static final int MAX_PISTAS = 10; // Asumimos un máximo de 10 pistas
	private static final LocalDate LocalDate = null;
    
    /**
     * Constructor que incializa el sistema de reservas
     * Crea una lista vacia de reservas y un arreglo para el estado de la iluminacion
     */

    public SistemaReservasDeportivas() {
        reservas = new ArrayList<>();
        iluminacion = new boolean[MAX_PISTAS];
    }
    
    /**
     * Reserva una pista deportiva en una fecha y duracion especificas
     * @param idPista el identificador de la pista (O a MAX_PIESTAS-1)
     * @param fecha la fecha de la reserva (formato String)
     * @param duracion la duracion de la reserva en minutos
     * @return true si la reserva se realizo con exito, false si la pista no esta disponible o el ID es invalido
     */

    public boolean reservarPista(int idPista, String fecha, int duracion) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        for (Reserva r : reservas) {
            if (r.getIdPista() == idPista && r.getFecha().equals(fecha)) {
                return false; // La pista ya está reservada en esa fecha
            }
        }
        reservas.add(new Reserva(idPista, LocalDate, duracion));
        return true;
    }
    
    /**
     * Cancela una reserva existente basada en el ID de la pista
     * @param idReserva el ID de la pista asociada a la reserva a cancelar
     * @return trrue si la reserva fue cancelada y false si no se encontro
     */

    public boolean cancelarReserva(int idReserva) {
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getIdPista() == idReserva) {
                reservas.remove(i);
                return true;
            }
        }
        return false; // No se encontró la reserva
    }
    
    /**
     * Activa la iluminacion de una pista especifica
     * @param idPista el identificador de la pista
     * @return true si la iluminacion se activo, false si el ID es invalido
     */

    public boolean encendderLuces(int idPista) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        iluminacion[idPista] = true;
        return true;
    }
    
    /**
     * Desactiva la iluminacion de una pista especifica
     * @param idPista el identificador de la pista
     * @return true si la iluminacion se desactivo, false si el ID es invalido
     */

    public boolean apagarLuces(int idPista) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        iluminacion[idPista] = false;
        return true;
    }
    
    /**
     * Verifica si una pista esta disponible en una fecha y hora especificas
     * @param idPista el identificador de la pista
     * @param fecha la fecha a verificar (formato String)
     * @param hora la hora a verificar (no uilizada en la logica actual)
     * @return true si la pista esta disponible , false si esta reservada o el ID es invalido
     */

    public boolean verificarDisponibilidad(int idPista, String fecha, String hora) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        for (Reserva r : reservas) {
            if (r.getIdPista() == idPista && r.getFecha().equals(fecha)) {
                return false; // La pista no está disponible en esa fecha
            }
        }
        return true; // La pista está disponible
    }
    
    
    
    
    // Metodo extraido
    
    private boolean esFechaDisponible(int idPista, LocalDate fecha) {
    	for(Reserva r : reservas) {
    		if (r.getIdPista() == idPista && r.getFecha().equals(fecha)) {
    			return false;
    		}
    	}
    	return true;
    }
}