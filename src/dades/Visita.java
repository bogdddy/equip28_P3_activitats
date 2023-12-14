package dades;

public class Visita extends Activitat {

    private String edifici;
    private boolean audioguia, per_cecs;

    public Visita(String entitat, String nom_activitat, String lloc, int codi_postal, int dia, String edifici,
            boolean audioguia, boolean per_cecs) {
        super(entitat, nom_activitat, lloc, codi_postal, dia);
        this.edifici = edifici;
        this.audioguia = audioguia;
        this.per_cecs = per_cecs;
    }

    public String getEdifici() {
        return edifici;
    }

    public void setEdifici(String edifici) {
        this.edifici = edifici;
    }

    public boolean isAudioguia() {
        return audioguia;
    }

    public void setAudioguia(boolean audioguia) {
        this.audioguia = audioguia;
    }

    public boolean esPer_cecs() {
        return per_cecs;
    }

    public void setPer_cecs(boolean per_cecs) {
        this.per_cecs = per_cecs;
    }

    protected Visita copia(){
        return new Visita(entitat, nom_activitat, lloc, codi_postal, dia, edifici, audioguia, per_cecs);
    }

    @Override
    public String toString() {
        return super.toString() + ", edifici=" + edifici + ", audioguia=" + audioguia + ", per_cecs=" + per_cecs + "]";
    }

    
    
}
