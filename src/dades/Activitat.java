package dades;

/**
 * @author Ayla - Bogdan
 */
public abstract class Activitat {

    protected String entitat, codi, nom_activitat, lloc;
    protected int codi_postal, dia;
    protected static int numCodi;

    /**
     * Constructor de la classe Activitat
     * @param entitat nom de la entitat
     * @param codi codi de l'activitat
     * @param nom_activitat nom de l'activitat
     * @param lloc lloc on es fa l'activitat
     * @param codi_postal codi postal del lloc on es fa l'activitat
     * @param dia dia que es fa l'activitat
     */
    public Activitat(String entitat, String codi, String nom_activitat, String lloc, int codi_postal, int dia) {
        this.entitat = entitat;
        if (codi == null)
            this.codi = generarCodi(entitat); //només genera un nou codi si l'activitat es nova (es a dir, no té un codi encara)
        else
            this.codi = codi;
        this.nom_activitat = nom_activitat;
        this.lloc = lloc;
        this.codi_postal = codi_postal;
        this.dia = dia;
    }

    /**
     * Getter de la entitat
     * @return entitat
     */
    public String getEntitat() {
        return entitat;
    }

    /**
     * Getter del codi de l'activitat
     * @return codi
     */
    public String getCodi() {
        return codi;
    }

    /**
     * Getter del nom de l'activitat
     * @return nom_activitat
     */
    public String getNom_activitat() {
        return nom_activitat;
    }

    /**
     * Getter del lloc
     * @return lloc
     */
    public String getLloc() {
        return lloc;
    }

    /**
     * Getter del codi postal
     * @return codi_postal
     */
    public int getCodi_postal() {
        return codi_postal;
    }

    /**
     * Getter del dia
     * @return dia
     */
    public int getDia() {
        return dia;
    }

    /**
     * Genera un codi per una activitat nova
     * @param entitat nom de l'entitat que fa l'activitat
     * @return el codi
     */
    private String generarCodi(String entitat) {
        String codi = entitat.substring(0, 3) + Integer.toString(numCodi); //primeres tres lletres del nom de l'entitat + número
        Activitat.numCodi ++; //incrementa el valor del static int cada cop que es genera un nou codi
        return codi;
    }

    /**
     * Consultar el tipus de l'activitat
     * @return string del tipus d'activitat que és
     */
    public char tipusActivitat() {
        return this instanceof Xerrada ? 'x' : this instanceof Visita ? 'v' : 't';
    }

    /**
     * Mètode per poder fer copia de les diferents activitats
     * @return copia de l'objecte
     */
    protected abstract Activitat copia();

    /**
     * toString dels elements en comú de les activitats
     * @return string amb els elements comuns
     */
    @Override
    public String toString() {
        return "Activitat [entitat=" + entitat + ", codi=" + codi + ", nom_activitat=" + nom_activitat + ", lloc="
                + lloc + ", codi_postal=" + codi_postal + ", dia=" + dia;
    }

}
