package dades;


public class LlistaReserves {

    public final static int maxReserves = 100;
    private Reserva[] llista;
    private int numElem;
    
    public LlistaReserves(int mida){
        llista = new Reserva[mida];
        numElem=0;
    }
    
    public int getNumElem(){
        return this.numElem;
    }

    /**
     * Mètode que consulta el contingut d'una posició de la llista
     * @param pos posicio específica que volem consultar (valors > 0)
     * @return Usuari
     */
    public Reserva consultaPoisicio(int pos){
        return llista[pos-1];
    }

    
    public String toString(){
        String aux = "Llista Reserves ==>\n";
        for (int i=0; i<numElem; i++)
            aux += llista[i].toString();
        return aux;
    }
    
    public void afegirReserva(Reserva reserva) {
        if (!this.repetit(reserva)){
            llista[numElem] = reserva;
            numElem++;
        }else{
            System.out.println("Ja has fet una reserva per aquest taller");
        }
    }

   
    private boolean repetit(Reserva reserva) {
        boolean repetit = false;
        int i=0;
        while(!repetit && i<numElem){
            if(llista[i].equals(reserva)){
                repetit=true;
            }
            i++;
        }
        return repetit;
    }    

    /**
     * Obte una reserva por el seu codi.
     * Opcio9.
     * @param codiReserva Codi de la reserva a buscar.
     * @return Reserva trobada, o null si no es troba ninguna reserva amb el codi proporcionat.
     */
    public Reserva obtenirReservaPerCodi(String codiReserva) {
        for (int i = 0; i < numElem; i++) {
            if (llista[i].getCodiReserva().equals(codiReserva)) {
                return llista[i];
            }
        }
        return null; // Si no es troba ninguna reserva amb el codi proporcionat.
    }

    /**
     * Mostra els usuaris que s'han apuntat a un taller específic.
     * Opcio 7
     * @param codiTaller Codi del taller pel qual es volen mostrar els usuaris.
     * @param usuaris
     */
    public void mostrarUsuarisApuntatsATaller(String codiTaller, LlistaUsuaris usuaris) {
        System.out.println("Usuaris apuntats al taller amb codi " + codiTaller + ":");
        for (int i = 0; i < numElem; i++) {
            if (llista[i].getCodiActivitat().equals(codiTaller)) {
                Usuari usuari = usuaris.obtenirUsuariPerAlies(llista[i].getAliesUsuari());
                if (usuari != null) {
                    System.out.println(usuari);
                } else {
                    System.out.println("Usuari no trobat per l'alias " + llista[i].getAliesUsuari());
                }
            }
        }
    }

    /**
     * Calcula la nota mitja que ha rebut un taller.
     * Opcio 10
     * @param codiTaller Codi del taller pel qual es vol calcular la nota mitja.
     * @return La nota mitja del taller, o -1 si no hi ha reserves per aquest taller.
     */
    public double calcularNotaMitjaTaller(String codiTaller) {
        double sumaNotes = 0;
        int numReserves = 0;

        // Iterem a través de les reserves per al taller donat
        for (int i = 0; i < numElem; i++) {
            Reserva reserva = llista[i];
            if (reserva.getCodiActivitat().equals(codiTaller) && reserva.getValoracio() != -1) {
                sumaNotes += reserva.getValoracio();
                numReserves++;
            }
        }

        // Calculem la nota mitja
        if (numReserves > 0) {
            return sumaNotes / numReserves;
        } else {
            return -1; // No hi ha reserves amb valoració per a aquest taller.
        }
    }

   

    
}

