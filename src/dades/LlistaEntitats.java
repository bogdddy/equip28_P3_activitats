package dades;

public class LlistaEntitats {
    
    public final static int maxEntitats = 50;
    private Entitat[] llista;
    private int numElem;

    public LlistaEntitats(int mida){
        llista = new Entitat[mida];
        numElem=0;
    }

    /**
     * Afegir un element a la llista
     * @param entitat Element per afegir
     */
    public String afegirEntitat(Entitat entitat) {

        if (numElem > llista.length){
            return "La llista està complerta";

        } else if (!this.repetit(entitat)){
            llista[numElem] = entitat.copia();
            numElem++;
            return "";
            
        } else {
            return "Ja hi ha un element amb aquestes dades";
        }
    }

    /**
     * Mètode que comprova si ja hi ha un element amb exactament les mateixes dades
     * @param entitat Element de la classe Entitat
     * @return true: Ja existeix un element igual, false: No existeix un element igual
     */
    private boolean repetit(Entitat entitat) {
        boolean repetit = false;
        int i = 0;
        while (!repetit && i < numElem){
            if (llista[i].equals(entitat)){
                repetit = true;
            }
            i++;
        }
        return repetit;
    }

    /**
     * Getter del número d'elements de la llista
     * @return numElem
     */
    public int getNumElem(){
        return this.numElem;
    }

    /**
     * Mètode que consulta el contingut d'una posició de la llista
     * @param pos Posició específica que volem consultar (valors > 0)
     * @return El contingut en un string
     */
    public String consultaPosicio(int pos){
        return llista[pos-1].toString();
    }

    /**
     * Mètode que crea un duplicat d'un objecte de la classe LlistaEntitats
     * @return Nou LlistaEntitats amb el mateix contingut que el que rebem
     */
    public LlistaEntitats copia(){
        LlistaEntitats duplicat = new LlistaEntitats(this.numElem);
        for(int i = 0; i < this.numElem; i++){
            duplicat.afegirEntitat(llista[i]);
        }
        return duplicat;
    }

    /**
     * Obtiene una entidad por su nombre.
     * Opcio 5
     * @param nom Nombre de la entidad a buscar.
     * @return La entidad encontrada o null si no se encuentra.
     */
    public Entitat obtenirEntitatPerNom(String nom) {
        for (int i = 0; i < numElem; i++) {
            if (llista[i].getNom().equalsIgnoreCase(nom)) {
                return llista[i];
            }
        }
        return null; // Si no se encuentra la entidad con el nombre dado
    }

    @Override
    public String toString(){
        String aux = "Llista Entitats ==>\n";

        for (int i = 0; i < numElem; i++)
            aux += llista[i].toString() + "\n";

        return aux;
    }
}
