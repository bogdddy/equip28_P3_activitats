package dades;

import java.io.Serializable;

/**
 * @author Marius - Ayla
 */
public class Reserva implements Serializable {

    //per no tindre problemes de deserialitzacio
    private static final long serialVersionUID = 1L; 

    private String codiReserva;
    private Usuari usuari;
    private String codiActivitat;
    private String codiTaller;
    private double valoracio;

    /**
     * Constructor reserva
     * @param usuari
     * @param codiTaller
     */
    public Reserva(Usuari usuari, String codiTaller) {
        this.codiReserva = generarCodiUnic(usuari, codiTaller);
        this.usuari = usuari;
        this.codiTaller = codiTaller;
        this.valoracio = -1; // -1 indica que encara no s'ha valorat
    }
    
    /**
     * Getter codi reserva
     * @return codiReserva
     */
    public String getCodiReserva() {
        return codiReserva;
    }

    /**
     * Getter usuari
     * @return usuari
     */
    public Usuari getUsuari() {
        return usuari;
    }

    /**
     * Getter codi taller
     * @return codiTaller
     */
    public String getCodiTaller() {
        return codiTaller;
    }

    /**
     * S'utilitza en Opcio 7 
     * Getter codi activitat
     * @return codiActivitat
     */
    public String getCodiActivitat() {
        return codiActivitat;
    }

     /**
      * S'utilitza en Opcio 7 
      * Getter alies usuari
      * @return alies usuari
      */
    public String getAliesUsuari() {
        return usuari.getAlies();
    }

    /**
     * toString
     * @return toString
     */
    public String toString() {
        return "Reserva [codiReserva=" + codiReserva + ", usuari=" + usuari + ", codiTaller=" + codiTaller
                + ", valoracio=" + valoracio + "]\n";
    }

    /**
     * Getter valoracio
     * @return valoracio
     */
    public double getValoracio() {
        return valoracio;
    }

    /**
     * Métode per a generar un codi únic per cada reserva
     * @return codiUnic
     */
    private String generarCodiUnic(Usuari usuari, String codiTaller) {
        return (usuari.getAlies()+codiTaller);
    }

    /**
     * Métode per a valorar la reserva feta
     * @param puntuacio
     */
    public void valorarReserva(double puntuacio) {
        if(valoracio==-1){
            if (puntuacio >= 0 && puntuacio <= 10) {
                valoracio = puntuacio;
            } else {
                System.out.println("La valoració ha de ser entre 0 i 10.");
            }
        }
        else{
            System.out.println("Ja has valorat aquest taller amb una puntuació de "+valoracio);
        }
    }
}
