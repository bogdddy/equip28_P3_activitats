package dades;

import java.io.Serializable;

/**
 * @author Bogdan
 */
public class Usuari implements Serializable {

    private String alies, correu; 
    private int codi_postal;

    /**
     * Constructor usuari
     * @param alies
     * @param correu
     * @param codi_postal
     */
    public Usuari(String alies, String correu, int codi_postal) {
        this.alies = alies;
        this.correu = correu;
        this.codi_postal = codi_postal;
    }

    /**
     * Getter alies
     */
    public String getAlies() {
        return alies;
    }

    /**
     * Setter alies
     */
    public void setAlies(String alies) {
        this.alies = alies;
    }

    /**
     * Getter correu
     * @return correu
     */
    public String getCorreu() {
        return correu;
    }

    /**
     * Setter correu
     * @param correu
     */
    public void setCorreu(String correu) {
        this.correu = correu;
    }

    /**
     * Getter codi_postal
     * @return codi_postal
     */
    public int getCodi_postal() {
        return codi_postal;
    }

    /**
     * Setter codi_postal
     */
    public void setCodi_postal(int codi_postal) {
        this.codi_postal = codi_postal;
    }
    
    /**
     * Métode copia
     * @return nova llista
     */
    public Usuari copia() {
        return new Usuari(alies, correu, codi_postal);
    }

    /**
     * toString
     * @return toString
     */
    @Override
    public String toString() {
        return "[alies=" + alies + ", correu=" + correu + ", codi_postal=" + codi_postal + "]\n";
    }

    
}
