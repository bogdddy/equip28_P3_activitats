package dades;

public abstract class Activitat {
    
    protected char tipus;
    protected String entitat, codi, nom_activitat, lloc;
    protected int codi_postal, dia;
    protected static int num_codi = 100;

    public Activitat(char tipus, String entitat, String nom_activitat, String lloc, int codi_postal, int dia) {
        this.tipus = tipus;
        this.entitat = entitat;
        this.codi = generarCodi(entitat);
        this.nom_activitat = nom_activitat;
        this.lloc = lloc;
        this.codi_postal = codi_postal;
        this.dia = dia;
    }

    /**
     * Constructor amb parametre el "codi"
     * @param tipus
     * @param entitat
     * @param codi
     * @param nom_activitat
     * @param lloc
     * @param codi_postal
     * @param dia
     */
    public Activitat(char tipus, String entitat, String codi, String nom_activitat, String lloc, int codi_postal, int dia) {
        this.tipus = tipus;
        this.entitat = entitat;
        this.codi = codi;
        this.nom_activitat = nom_activitat;
        this.lloc = lloc;
        this.codi_postal = codi_postal;
        this.dia = dia;
    }

    public char getTipus() {
        return tipus;
    }

    public void setTipus(char tipus) {
        this.tipus = tipus;
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

    private String generarCodi(String entitat) {
        String codi = entitat.substring(0, 3) + Integer.toString(num_codi);
        num_codi++;
        
        return codi;
    }

    /**
     * Consultar el tipus de l'activitat
     * @return string del tpus d'activitat que és
     */
    public char tipusActivitat(){
        return this instanceof Xerrada ? 'x' : this instanceof Visita ? 'v' : 't';
    }

    protected abstract Activitat copia();

    @Override
    public String toString() {
        return "Activitat [entitat=" + entitat + ", codi=" + codi + ", nom_activitat=" + nom_activitat + ", lloc="
                + lloc + ", codi_postal=" + codi_postal + ", dia=" + dia ;
    }

    

    /*Amb aquest mètode equals, dues activitats es consideraran iguals si tenen el mateix codi. 
    Ara la teva llista verificarà correctament si una activitat ja existeix basant-se en el codi. 
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Activitat activitat = (Activitat) obj;

        return codi.equals(activitat.codi);
    }*/
}

