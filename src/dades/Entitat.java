package dades;

public class Entitat {

    private String nom, telefon, correu;

    public Entitat(String nom, String telefon, String correu) {
        this.nom = nom;
        this.telefon = telefon;
        this.correu = correu;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getCorreu() {
        return correu;
    }

    public void setCorreu(String correu) {
        this.correu = correu;
    }

    public Entitat copia() {
        return new Entitat(nom, telefon, correu);
    }

    @Override
    public String toString() {
        return "Entitat [nom=" + nom + ", telefon=" + telefon + ", correu=" + correu + "]\n";
    }

}


