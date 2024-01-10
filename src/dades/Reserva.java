package dades;

import java.io.Serializable;

public class Reserva implements Serializable {

    //per no tindre problemes de deserialitzacio
    private static final long serialVersionUID = 1L; 

    private String codiReserva;
    private Usuari usuari;
    private String codiActivitat;
    private String codiTaller;
    private double valoracio;

    public Reserva(Usuari usuari, String codiTaller) {
        this.codiReserva = generarCodiUnic(usuari, codiTaller);
        this.usuari = usuari;
        this.codiTaller = codiTaller;
        this.valoracio = -1; // -1 indica que encara no s'ha valorat
    }
    
    public String getCodiReserva() {
        return codiReserva;
    }

    public Usuari getUsuari() {
        return usuari;
    }

    public String getCodiTaller() {
        return codiTaller;
    }

    /*S'utilitza en Opcio 7 */
    public String getCodiActivitat() {
        return codiActivitat;
    }

     /*S'utilitza en Opcio 7 */
    public String getAliesUsuari() {
        return usuari.getAlies();
    }


    public String toString() {
        return "Reserva [codiReserva=" + codiReserva + ", usuari=" + usuari + ", codiTaller=" + codiTaller
                + ", valoracio=" + valoracio + "]\n";
    }

    public double getValoracio() {
        return valoracio;
    }

    private String generarCodiUnic(Usuari usuari, String codiTaller) {
        return (usuari.getAlies()+codiTaller);
    }

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
