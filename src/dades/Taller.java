package dades;

public class Taller extends Activitat {

    private String hora;
    private int durada, capacitat;
    private int totalPuntuacions, numPuntuacions;
    private int placesDisponibles;
    
    public Taller(String entitat, String nom_activitat, String lloc, int codi_postal, int dia, String hora, 
                    int durada, int capacitat, int totalPuntuacions, int numPuntuacions, int placesDisponibles) {
        super('t', entitat, nom_activitat, lloc, codi_postal, dia);
        this.hora = hora;
        this.durada = durada;
        this.capacitat = capacitat;
        this.totalPuntuacions = totalPuntuacions; //si ya se ha valorado en algun momento no será 0
        this.numPuntuacions = numPuntuacions;   //si ya se ha valorado en algun momento no será 0
        this.placesDisponibles = placesDisponibles;
    }

    /**
     * Constructor amb el parametre "codi"
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
        super('t', entitat, codi, nom_activitat, lloc, codi_postal, dia);
        this.hora = hora;
        this.durada = durada;
        this.capacitat = capacitat;
        this.totalPuntuacions = totalPuntuacions; //si ya se ha valorado en algun momento no será 0
        this.numPuntuacions = numPuntuacions;   //si ya se ha valorado en algun momento no será 0
        this.placesDisponibles = placesDisponibles;
    }

    public int getTotalPuntuacions() {
        return totalPuntuacions;
    }


    public int getNumPuntuacions() {
        return numPuntuacions;
    }


    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getDurada() {
        return durada;
    }

    public void setDurada(int durada) {
        this.durada = durada;
    }

    public int getCapacitat() {
        return capacitat;
    }

    public void setCapacitat(int capacitat) {
        this.capacitat = capacitat;
    }

    /*S'utilitza en la opcio4 dintre de llistaActivitats */
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

    protected Taller copia(){
        return new Taller(entitat, codi, nom_activitat, lloc, codi_postal, dia, hora, durada, capacitat, totalPuntuacions, numPuntuacions, placesDisponibles);
    }

    @Override
    public String toString() {
        return super.toString()+", hora=" + hora + ", durada=" + durada + ", capacitat=" + capacitat + ", totalPuntuacions="
                + totalPuntuacions + ", numPuntuacions=" + numPuntuacions + "]\n";
    }


}
