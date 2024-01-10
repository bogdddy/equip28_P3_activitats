package dades;

import java.util.Arrays;
import java.util.Comparator;

public class LlistaActivitats {
    
    public final static int maxActivitats = 50;
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
    public String afegirActivitat(Activitat activitat) {

        if (numElem>llista.length){
            return "La llista està complerta";

        }else if (!this.repetit(activitat)){
            llista[numElem] = activitat.copia();
            numElem++;
            return "";

        }else
            return "Ja hi ha un element amb aquestes dades";

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
     * @return Activitat
     */
    public Activitat consultaPoisicio(int pos){
        return llista[pos-1].copia();
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

    /**
     * Obté una llista d'activitats per a una entitat concreta.
     * S'utiliza en la Opcio2
     * @param entitat Nom de l'entitat
     * @return Llista d'activitats de l'entitat
     */
    public LlistaActivitats obtenirLlistaActivitatsPerEntitat(String entitat) {

        LlistaActivitats llistaEntitat = new LlistaActivitats(this.numElem);
        for (int i = 0; i < this.numElem; i++) {
            // Obtener el nombre de la entidad desde el tipo de actividad
            String nombreEntidadActividad = llista[i].getEntitat();
            int indexPunto = nombreEntidadActividad.indexOf(';');
            if (indexPunto != -1) {
                nombreEntidadActividad = nombreEntidadActividad.substring(indexPunto + 1);
            }

            // Utilizar equalsIgnoreCase para ignorar diferencias entre mayúsculas y minúsculas
            if (nombreEntidadActividad.equalsIgnoreCase(entitat)) {
                llistaEntitat.afegirActivitat(llista[i]);
            }
        }
        return llistaEntitat;

    }

    /**
     * Obtiene una lista de actividades para un día específico.
     * S'utiliza en la Opcio3
     * @param dia Día para el cual se desea obtener la lista de actividades.
     * @return Lista de actividades para el día especificado.
     */
    public LlistaActivitats obtenirLlistaActivitatsPerDia(int dia) {
        LlistaActivitats activitatsEnDia = new LlistaActivitats(this.numElem);

        for (int i = 0; i < this.numElem; i++) 
            if (llista[i].getDia() == dia) 
                activitatsEnDia.afegirActivitat(llista[i].copia());

        return activitatsEnDia;
    }

    /**
     * Obtiene una lista de talleres que tienen plazas disponibles.
     * Opcio 4
     * @return Lista de talleres con plazas disponibles.
     */
    public LlistaActivitats obtenirLlistaTallersAmbPlacesDisponibles() {
        LlistaActivitats tallersAmbPlacesDisponibles = new LlistaActivitats(this.numElem);

        for (int i = 0; i < this.numElem; i++) {
            if (llista[i] instanceof Taller) {
                Taller taller = (Taller) llista[i];
                if (taller.getPlacesDisponibles() > 0) {
                    tallersAmbPlacesDisponibles.afegirActivitat(taller);
                }
            }
        }

        return tallersAmbPlacesDisponibles;
    }

    /**
     * Obté una activitat a partir del seu codi.
     * Opcio 6
     * @param codi Codi de l'activitat a buscar.
     * @return Activitat corresponent al codi donat o null si no es troba cap activitat.
     */
    public Activitat obtenirActivitatPerCodi(String codi) {
        for (int i = 0; i < numElem; i++) {
            if (llista[i].getCodi().equals(codi)) {
                return llista[i];
            }
        }
        return null;
    }
    
    
    /**
     * Obté una llista d'activitats de tipus xerrada que seran realitzades per una persona concreta.
     * Opcio 13
     * @param nomPersona El nom de la persona per la qual es vol obtenir la llista de xerrades.
     * @return Una llista d'activitats de tipus xerrada que seran realitzades per la persona especificada.
     */
    public LlistaActivitats obtenirLlistaXerradesPerPersona(String nomPersona) {
        LlistaActivitats xerradesPersona = new LlistaActivitats(this.numElem);
        for (int i = 0; i < numElem; i++) {
            Activitat activitat = llista[i];
            if (activitat instanceof Xerrada) {
                Xerrada xerrada = (Xerrada) activitat;
                if (xerrada.getResponsable().equalsIgnoreCase(nomPersona)) {
                    xerradesPersona.afegirActivitat(xerrada);
                }
            }
        }
        return xerradesPersona;
    }

    /**
     * Obté una llista d'activitats de tipus xerrada que seran realitzades per una persona concreta.
     * Opcio 13
     * @param nomPersona El nom de la persona per la qual es vol obtenir la llista de xerrades.
     * @return Una llista d'activitats de tipus xerrada que seran realitzades per la persona especificada.
     */
    public LlistaActivitats activitatsTipus(char tipus) {
        
        LlistaActivitats newLLista = new LlistaActivitats(numElem);
        
        for (int i = 0; i < numElem; i++) 
            if (llista[i].tipusActivitat() == tipus)
                newLLista.afegirActivitat(llista[i].copia());

        return newLLista;

    }

    

    /**
     * Ordena les activitats cronologicament
     */
    public void ordenaCronologicament() {
        Arrays.sort(llista, 0, numElem, Comparator.comparing(Activitat::getDia));
    }

    /**
     * Convertir les dades a un array 2D per montar la taula en SWING
     * @return [{},{},{},...]
     */
    public Object[][] convertirArray2D() {
        Object[][] data = new Object[numElem][5];

        for (int i = 0; i < numElem; i++) {
            Activitat activitat = llista[i];
            char tipus = activitat.tipusActivitat();
            data[i][0] =  tipus == 'v' ? "Visita" : tipus == 't' ? "Taller" : "Xerrada";
            data[i][1] = activitat.getEntitat();
            data[i][2] = activitat.getNom_activitat();
            data[i][3] = activitat.getLloc();
        }

        return data;
    }


}
