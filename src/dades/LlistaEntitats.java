package dades;

public class LlistaEntitats {
    
    private Entitat[] llista;
    private int numElem;

    public LlistaEntitats(int mida){
        llista = new Entitat[mida];
        numElem=0;
    }

    /**
     * afegir un element a la llista
     * @param entitat element per afegir
     */
    public void afegirEntitat(Entitat entitat) {

        if (numElem>llista.length){
            System.out.println("La llista està complerta");

        }else if (!this.repetit(entitat)){
            llista[numElem] = entitat.copia();
            numElem++;
        
        }else
            System.out.println("Ja hi ha un element amb aquestes dades");

    }

     /**
     * Mètode que comprova si ja hi ha un element amb exactament les mateixes dades
     * @param entitat element de la classe Entitat
     * @return true: ja existeix un element igual,   false: no existeix un element igual
     */
    private boolean repetit(Entitat entitat) {
        boolean repetit = false;
        int i=0;
        while(!repetit && i<numElem){
            if(llista[i].equals(entitat)){
                repetit=true;
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
     * @param pos posicio específica que volem consultar (valors > 0)
     * @return el contingut en un string
     */
    public String consultaPoisicio(int pos){
        return llista[pos-1].toString();
    }

    /**
     * Mètode que crea un duplicat d'un objecte de la classe LlistaEntitats
     * @return nou LlistaEntitats amb el mateix contingut que el que rebem
     */
    public LlistaEntitats copia(){
        LlistaEntitats duplicat = new LlistaEntitats(this.numElem);
        for(int i=0 ; i<this.numElem ; i++){
            duplicat.afegirEntitat(llista[i]);
        }
        return duplicat;
    }

    public String toString(){
        String aux = "Llista Entitats ==>\n";

        for (int i=0; i<numElem; i++)
            aux += llista[i].toString();

        return aux;
    }
}
