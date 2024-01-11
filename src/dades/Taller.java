package dades;

/**
 * @author Marius - Ayla - Manu
 */
public class Taller extends Activitat {

    private String hora;
    private int durada, capacitat;
    private int totalPuntuacions, numPuntuacions;
    private int placesDisponibles;
    
    /**
     * Constructor taller
     * @param entitat
     * @param codi
     * @param nom_activitat
     * @param lloc
     * @param codi_postal
     * @param dia
     * @param hora
     * @param durada
     * @param capacitat
     * @param totalPuntuacions
     * @param numPuntuacions
     * @param placesDisponibles
     */
    public Taller(String entitat, String codi, String nom_activitat, String lloc, int codi_postal, int dia, String hora, 
                    int durada, int capacitat, int totalPuntuacions, int numPuntuacions, int placesDisponibles) {
        super(entitat, codi, nom_activitat, lloc, codi_postal, dia);
        this.hora = hora;
        this.durada = durada;
        this.capacitat = capacitat;
        this.totalPuntuacions = totalPuntuacions; 
        this.numPuntuacions = numPuntuacions; 
        this.placesDisponibles = placesDisponibles;
    }

    /**
     * Getter total puntuacions
     * @return totalPuntuacions
     */
    public int getTotalPuntuacions() {
        return totalPuntuacions;
    }

    /**
     * Getter num puntuacions
     * @return numPuntuacions
     */
    public int getNumPuntuacions() {
        return numPuntuacions;
    }

    /**
     * Getter hora
     * @return hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * Setter hora
     * @param hora
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * Getter durada
     * @return durada
     */
    public int getDurada() {
        return durada;
    }

    /**
     * Setter durada
     * @param durada
     */
    public void setDurada(int durada) {
        this.durada = durada;
    }

    /**
     * Getter capacitat
     * @return capacitat
     */
    public int getCapacitat() {
        return capacitat;
    }

    /**
     * Setter capacitat
     * @param capacitat
     */
    public void setCapacitat(int capacitat) {
        this.capacitat = capacitat;
    }

    /**
     * S'utilitza en la opcio4 dintre de llistaActivitats 
     * Getter places disponibles
     * @return placesDisponibles
     */
    public int getPlacesDisponibles() {
        // Calcula y devuelve las plazas disponibles restando el número de puntuaciones de la capacidad total
        return placesDisponibles;
    }

    /**
     * Decrementa el nombre de places disponibles en un taller.
     * Opcio 6
     */
    public void decrementarPlacesDisponibles() {
        if (placesDisponibles > 0) 
            placesDisponibles--;
    }

    /**
     * Métode copia
     * @return nova llista
     */
    protected Taller copia(){
        return new Taller(entitat, codi, nom_activitat, lloc, codi_postal, dia, hora, durada, capacitat, totalPuntuacions, numPuntuacions, placesDisponibles);
    }

    /**
     * toString
     * @return toString
     */
    @Override
    public String toString() {
        return super.toString()+", hora=" + hora + ", durada=" + durada + ", capacitat=" + capacitat + ", totalPuntuacions="
                + totalPuntuacions + ", numPuntuacions=" + numPuntuacions + "]\n";
    }


}
