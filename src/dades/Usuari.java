package dades;

public class Usuari {

    private String alies, correu, codi_postal;

    public Usuari(String alies, String correu, String codi_postal) {
        this.alies = alies;
        this.correu = correu;
        this.codi_postal = codi_postal;
    }

    public String getAlies() {
        return alies;
    }

    public void setAlies(String alies) {
        this.alies = alies;
    }

    public String getCorreu() {
        return correu;
    }

    public void setCorreu(String correu) {
        this.correu = correu;
    }

    public String getCodi_postal() {
        return codi_postal;
    }

    public void setCodi_postal(String codi_postal) {
        this.codi_postal = codi_postal;
    }

    public boolean equals(Usuari usuari){
        return (alies == usuari.getAlies() || correu == usuari.getCorreu());
    }
    
    public Usuari copia() {
        return new Usuari(alies, correu, codi_postal);
    }

    @Override
    public String toString() {
        return "[alies=" + alies + ", correu=" + correu + ", codi_postal=" + codi_postal + "]";
    }

    
}
