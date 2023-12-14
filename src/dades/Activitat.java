package dades;

public abstract class Activitat {
    
    protected String entitat, codi, nom_activitat, lloc;
    protected int codi_postal, dia;
    protected static int num_codi = 100;

    public Activitat(String entitat, String nom_activitat, String lloc, int codi_postal, int dia) {
        this.entitat = entitat;
        this.codi = generarCodi(entitat);
        this.nom_activitat = nom_activitat;
        this.lloc = lloc;
        this.codi_postal = codi_postal;
        this.dia = dia;
    }

    public String getEntitat() {
        return entitat;
    }

    public void setEntitat(String entitat) {
        this.entitat = entitat;
    }

    public String getCodi() {
        return codi;
    }

    public String getNom_activitat() {
        return nom_activitat;
    }

    public void setNom_activitat(String nom_activitat) {
        this.nom_activitat = nom_activitat;
    }

    public String getLloc() {
        return lloc;
    }

    public void setLloc(String lloc) {
        this.lloc = lloc;
    }

    public int getCodi_postal() {
        return codi_postal;
    }

    public void setCodi_postal(int codi_postal) {
        this.codi_postal = codi_postal;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    private String generarCodi(String e) {
        String r;
        
        r = e.substring(0, 2) + Integer.toString(num_codi);
        num_codi++;

        return r;

    }

    protected abstract Activitat copia();

    @Override
    public String toString() {
        return "Activitat [entitat=" + entitat + ", codi=" + codi + ", nom_activitat=" + nom_activitat + ", lloc="
                + lloc + ", codi_postal=" + codi_postal + ", dia=" + dia ;
    }

    


}
