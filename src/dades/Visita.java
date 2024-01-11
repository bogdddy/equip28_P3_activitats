package dades;

/**
 * @author Bogdan
 */
public class Visita extends Activitat {

    private String edifici;
    private boolean audioguia, per_cecs;

    /**
     * Constructor visita
     * @param entitat
     * @param codi
     * @param nom_activitat
     * @param lloc
     * @param codi_postal
     * @param dia
     * @param edifici
     * @param audioguia
     * @param per_cecs
     */
    public Visita(String entitat, String codi, String nom_activitat, String lloc, int codi_postal, int dia, String edifici,
            boolean audioguia, boolean per_cecs) {
        super(entitat, codi, nom_activitat, lloc, codi_postal, dia);
        this.edifici = edifici;
        this.audioguia = audioguia;
        this.per_cecs = per_cecs;
    }

    /**
     * Getter edifici
     * @return edifici
     */
    public String getEdifici() {
        return edifici;
    }

    /**
     * Setter edifici
     * @param edifici
     */
    public void setEdifici(String edifici) {
        this.edifici = edifici;
    }

    /**
     * Getter audioguia
     * @return audioguia
     */
    public boolean getAudioguia() {
        return audioguia;
    }

    /**
     * Setter audioguia
     * @param audioguia
     */
    public void setAudioguia(boolean audioguia) {
        this.audioguia = audioguia;
    }

    /**
     * Getter per_cecs
     * @return per_cecs
     */
    public boolean getPer_cecs() {
        return per_cecs;
    }

    /**
     * Setter per_cecs
     * @param per_cecs
     */
    public void setPer_cecs(boolean per_cecs) {
        this.per_cecs = per_cecs;
    }

    /**
     * Métode copia
     * @return nova llista
     */
    protected Visita copia(){
        return new Visita(entitat, codi, nom_activitat, lloc, codi_postal, dia, edifici, audioguia, per_cecs);
    }

    /**
     * toString
     * @return toString
     */
    @Override
    public String toString() {
        return super.toString() + ", edifici=" + edifici + ", audioguia=" + audioguia + ", per_cecs=" + per_cecs + "]\n";
    }

}
