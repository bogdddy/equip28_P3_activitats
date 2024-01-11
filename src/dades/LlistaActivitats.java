package dades;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Marius - Ayla - Manu
 */

public class LlistaActivitats {
    
    public final static int maxActivitats = 50;
    private Activitat[] llista;
    private int numElem;

    /**
     * Constructor LlistaActivitats
     * @param mida mida de la llista
     */
    public LlistaActivitats(int mida){
        llista = new Activitat[mida];
        numElem=0;
    }

    /**
     * afegir un element a la llista
     * @param activitat element per afegir
     * @return si s'ha afegit o no
     */
    public String afegirActivitat(Activitat activitat) {

        if (numElem>llista.length){
            return "La llista està complerta";

        }else if (!this.repetit(activitat.getNom_activitat())){
            llista[numElem] = activitat.copia();
            numElem++;
            return "";

        }else
            return "Ja hi ha un dia amb aquesta activitat";

    }

     /**
     * Se considera que l'activitat ja es fa si el nom es el mateix
     * @param nomActivitat element de la classe Activitat
     * @return true: ja existeix un element igual,   false: no existeix un element igual
     */
    public boolean repetit(String nomActivitat) {
        boolean repetit = false;
        int i=0;
        while(!repetit && i<numElem){
            if(llista[i].getNom_activitat().equals(nomActivitat)){
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

    /**
     * toString
     * @return aux (toString)
     */
    public String toString(){
        String aux = "Llista Activitats ==>\n";

        for (int i=0; i<numElem; i++)
            aux += llista[i].toString();

        return aux;
    }

    /**
     * Obté una llista d'activitats per a una entitat concreta.
     * Opcio 2:
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
     * Opcio 3:
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
     * Opcio 4:
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
     * Opcio 6:
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
     * Opcio 13:
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
     * Obté una llista d'activitats d'un tipus concreta.
     * @param tipus tipus de l'activitat
     * @return Una llista d'activitats del tipus especificada.
     */
    public LlistaActivitats activitatsTipus(char tipus) {

        tipus = Character.toLowerCase(tipus);
        
        LlistaActivitats newLlista = new LlistaActivitats(this.numElem);
        
        for (int i = 0; i < numElem; i++) 
            if (llista[i].tipusActivitat() == tipus)
                newLlista.afegirActivitat(llista[i].copia());

        return newLlista;

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

    /**
     * Obté el taller amb més èxit, calculat com la ocupació més alta en proporció a les places ofertades.
     * Opció 11
     * @return Taller amb més èxit o null si no hi ha tallers.
     */
    public Taller obtenirTallerMesExit() {
        Taller tallerMesExit = null;
        double maxProporcióOcupació = 0;

        for (int i = 0; i < numElem; i++) {
            Activitat activitat = llista[i];
            if (activitat instanceof Taller) {
                Taller taller = (Taller) activitat;
                double proporcióOcupació = (double) (taller.getCapacitat() - taller.getPlacesDisponibles()) / taller.getCapacitat();

                if (proporcióOcupació > maxProporcióOcupació) {
                    maxProporcióOcupació = proporcióOcupació;
                    tallerMesExit = taller;
                }
            }
        }

        return tallerMesExit;
    }

    /**
     * Obtiene y muestra los datos de la lista de visitas ofrecidas por una entidad
     * Opción 12:
     * @param entitat nom de l'entitat
     * @return llistaVisites
     */
     public LlistaActivitats obtenirIDadesLlistaVisitesPerEntitat(String entitat) {
        LlistaActivitats llistaVisites = new LlistaActivitats(this.numElem);

        for (int i = 0; i < this.numElem; i++) {
            Activitat activitat = llista[i];
            if (activitat.getEntitat().equalsIgnoreCase(entitat) && activitat instanceof Visita) {
                llistaVisites.afegirActivitat(activitat);
            }
        }
        return llistaVisites;
    }
    
    /**
     * Opció 14: Donar de baixa un taller sempre que no hi hagi usuaris apuntats
     * @param codiTaller Codi del taller a donar de baixa
     * @return Missatge indicant si s'ha donat de baixa o si hi ha usuaris apuntats
     */
    public String donarDeBaixaTaller(String codiTaller) {
        for (int i = 0; i < numElem; i++) {
            if (llista[i].getCodi().equals(codiTaller) && llista[i] instanceof Taller) {
                Taller taller = (Taller) llista[i];
                if (taller.getPlacesDisponibles() == taller.getCapacitat()) {
                    // No hi ha usuaris apuntats, es pot donar de baixa
                    eliminarTaller(i);
                    return "S'ha donat de baixa el taller amb codi " + codiTaller;
                } else {
                    return "No es pot donar de baixa el taller, ja hi ha usuaris apuntats.";
                }
            }
        }
        return "No s'ha trobat cap taller amb el codi proporcionat.";
    }

    /**
     * Mètode per eliminar un taller de la llista.
     * @param index Índex del taller a eliminar.
     */
    private void eliminarTaller(int index) {
        // Movem els elements posteriors una posició enrere per a omplir l'espai
        for (int i = index; i < numElem - 1; i++) {
            llista[i] = llista[i + 1];
        }
        // Decrementem el número d'elements
        numElem--;
    }

}
