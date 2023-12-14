package dades;

public class LlistaUsuaris {
    
    private Usuari[] llista;
    private int numElem;

    public LlistaUsuaris(int mida){
        llista = new Usuari[mida];
        numElem=0;
    }

    /**
     * afegir un element a la llista
     * @param usuari element per afegir
     */
    public void afegirUsuari(Usuari usuari) {

        // aqui no deberia haber prints por eso
        if (numElem>llista.length){
            System.out.println("La llista està complerta");

        }else if (!this.repetit(usuari)){
            llista[numElem] = usuari.copia();
            numElem++;
        
        }else
            System.out.println("Ja hi ha un element amb aquestes dades");

    }

     /**
     * Mètode que comprova si ja hi ha un element amb exactament les mateixes dades
     * @param usuari element de la classe Usuari
     * @return true: ja existeix un element igual,   false: no existeix un element igual
     */
    private boolean repetit(Usuari usuari) {
        boolean repetit = false;
        int i=0;
        while(!repetit && i<numElem){
            if(llista[i].equals(usuari)){
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
     * Mètode que crea un duplicat d'un objecte de la classe LlistaUsuaris
     * @return nou LlistaUsuaris amb el mateix contingut que el que rebem
     */
    public LlistaUsuaris copia(){
        LlistaUsuaris duplicat = new LlistaUsuaris(this.numElem);
        for(int i=0 ; i<this.numElem ; i++){
            duplicat.afegirUsuari(llista[i]);
        }
        return duplicat;
    }

    public String toString(){
        String aux = "Llista Usuaris ==>\n";

        for (int i=0; i<numElem; i++)
            aux += llista[i].toString();

        return aux;
    }
}
