package dades;

/**
 * @author Bogdan
 */
public class Entitat {

    private String nom, telefon, correu;

    /**
     * Constructor de la classe Entitat
     * @param nom
     * @param telefon
     * @param correu
     */
    public Entitat(String nom, String telefon, String correu) {
        this.nom = nom;
        this.telefon = telefon;
        this.correu = correu;
    }

    /**
     * Getter del nom de l'entitat
     * @return String nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter del nom de l'entitat
     * @param nom nou nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Getter del telefon de l'entitat
     * @return String telefon
     */
    public String getTelefon() {
        return telefon;
    }

    /**
     * Setter del telefon de l'entitat
     * @param telefon nou telefono
     */
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    /**
     * Getter del correu de l'entitat
     * @return correu de l'entitat
     */
    public String getCorreu() {
        return correu;
    }

    /**
     * Setter del correu de l'entitat
     * @param correu nou correu
     */
    public void setCorreu(String correu) {
        this.correu = correu;
    }

    /**
     * Mètode que retorna un duplicat d'un objecte de la classe Entitat
     * @return un duplicat
     */
    public Entitat copia() {
        return new Entitat(nom, telefon, correu);
    }

    /**
     * toString de la classe Entitat
     * @return string amb els elements de Entitats
     */
    @Override
    public String toString() {
        return "Entitat [nom=" + nom + ", telefon=" + telefon + ", correu=" + correu + "]\n";
    }

}


