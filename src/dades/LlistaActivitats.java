package dades;

public class LlistaActivitats {
    
    private Activitat[] llista;
    private int numElem;

    public LlistaActivitats(int mida){
        llista = new Activitat[mida];
        numElem=0;
    }

    /**
     * afegir un element a la llista
     * @param activitat element per afegir
     */
    public void afegirActivitat(Activitat activitat) {

        // aqui no deberia haber prints por eso
        if (numElem>llista.length){
            System.out.println("La llista està complerta");

        }else if (!this.repetit(activitat)){
            llista[numElem] = activitat.copia();
            numElem++;
        
        }else
            System.out.println("Ja hi ha un element amb aquestes dades");

    }

     /**
     * Mètode que comprova si ja hi ha un element amb exactament les mateixes dades
     * @param activitat element de la classe Activitat
     * @return true: ja existeix un element igual,   false: no existeix un element igual
     */
    private boolean repetit(Activitat activitat) {
        boolean repetit = false;
        int i=0;
        while(!repetit && i<numElem){
            if(llista[i].equals(activitat)){
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
     * Mètode que crea un duplicat d'un objecte de la classe LlistaActivitats
     * @return nou LlistaActivitats amb el mateix contingut que el que rebem
     */
    public LlistaActivitats copia(){
        LlistaActivitats duplicat = new LlistaActivitats(this.numElem);
        for(int i=0 ; i<this.numElem ; i++){
            duplicat.afegirActivitat(llista[i]);
        }
        return duplicat;
    }

    public String toString(){
        String aux = "Llista Activitats ==>\n";

        for (int i=0; i<numElem; i++)
            aux += llista[i].toString();

        return aux;
    }
}
