package dades;

public class Xerrada extends Activitat {

    private String responsable;
    private static String hora = "17:00";

    public Xerrada(String entitat, String nom_activitat, String lloc, int codi_postal, int dia, String responsable){
        super('x', entitat, nom_activitat, lloc, codi_postal, dia);
        this.responsable = responsable;
    }

    /**
     * Constructor amb el parametre "codi"
     * @param entitat
     * @param codi
     * @param nom_activitat
     * @param lloc
     * @param codi_postal
     * @param dia
     * @param responsable
     */
    public Xerrada(String entitat, String codi, String nom_activitat, String lloc, int codi_postal, int dia, String responsable){
        super('x', entitat, nom_activitat, lloc, codi_postal, dia);
        this.responsable = responsable;
    }

    /**
     * Getter del responsable de la xerrada
     * @return
     */
    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public static String getHora() {
        return hora;
    }

    public static void setHora(String hora) {
        Xerrada.hora = hora;
    }

    protected Xerrada copia(){
        return new Xerrada(entitat, codi, nom_activitat, lloc, codi_postal, dia, responsable);
    }

    @Override
    public String toString() {
        return super.toString()+", responsable=" + responsable + "]\n";
    } 
}
