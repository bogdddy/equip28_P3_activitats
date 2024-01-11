package dades;

/**
 * @author Bogdan
 */
public class Xerrada extends Activitat {

    private String responsable;
    private static String hora = "17:00";

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
        super(entitat, codi, nom_activitat, lloc, codi_postal, dia);
        this.responsable = responsable;
    }

    /**
     * Getter del responsable de la xerrada
     * @return responsable
     */
    public String getResponsable() {
        return responsable;
    }

    /**
     * Setter del responsable de la xerrada
     * @param responsable
     */
    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    /**
     * Getter hora
     * @return hora
     */
    public static String getHora() {
        return hora;
    }

    /**
     * Setter hora
     * @param hora
     */
    public static void setHora(String hora) {
        Xerrada.hora = hora;
    }

    /**
     * Métode copia
     * @return nova llista
     */
    protected Xerrada copia(){
        return new Xerrada(entitat, codi, nom_activitat, lloc, codi_postal, dia, responsable);
    }

    /**
     * toString
     * @return toString
     */
    @Override
    public String toString() {
        return super.toString()+", responsable=" + responsable + "]\n";
    } 
}
