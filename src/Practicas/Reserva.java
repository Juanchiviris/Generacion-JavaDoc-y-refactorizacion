package Practicas;

import java.time.LocalDate;

/**
 * Clase que representa una reserva de una pista deportiva.
 * Almacena informacion basica como el identificador de la pista, la fecha y la duracion
 */

public class Reserva {
	//Atributo privado que almacena el identificador de la pista
    private int idPista;
    //Atributo privvado que almacena la fecha de la reserva como String
    private LocalDate fecha;
    //Atributo privado que almacena la duracion de la reserva en minutos
    private int duracion;
    
    /**
     * Constructor de la clase Reserva.
     * Inicializaa una nueva reserva con los valores proporcionados
     * @param idPista el identificador de la pista a reservar
     * @param fecha la fecha de la reserva en formato String
     * @param duracion la duracion de la reserva en minutos
     */

    public Reserva(int idPista, LocalDate fecha, int duracion) {
        this.idPista = idPista; 	//Asigna el valor del parametro idPista al atributo de la clase
        this.fecha = fecha;			//Asigna el valor del parametro fecha al atributo de la clase
        this.duracion = duracion;	//Asigna el valor del parametro duracion al atributo de la clase
    }
    
    /**
     * Obtiene el identificador de la pista reservada
     * @return el valor de idPista
     */
    
    public int getIdPista() {
        return idPista;
    }
    
    /**
     * Obtiene la fecha de la reserva
     * @return la fecha de la reserva como string
     */

    public LocalDate getFecha() {
        return fecha;
    }
    
    /**
     * obtiene la duracion de la reserva
     * @return la duracion de la reserva como string
     */

    public int getDuracion() {
        return duracion;
    }
}