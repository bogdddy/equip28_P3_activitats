package dades;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 * Classe per llegir/escriure informació dels/als fitxers de dades
 *
 * @author Bogdan Struk
 */

public class GestorFitxers {

    private final static String dirFitxers = "src\\fitxersDades\\";
    private final static String fUsuaris = "usuaris.txt";
    private final static String fEntitats = "entitats.txt";
    private final static String fActivitats = "activitats.txt";
    private final static String fReserves = "reserves.bin";
    
    /**
     * Carregar les dades dels usuaris del fitxer
     * @param usuaris llista d'usuaris
     * @throws IOException si hi ha un error al llegir l'arxiu
     */
    public static void carregarUsuaris(LlistaUsuaris usuaris) throws IOException {

        try (Scanner f = new Scanner(new File(dirFitxers + fUsuaris))) {
            String[] dades;
            while (f.hasNext()) {
                dades = f.next().split(";");
                usuaris.afegirUsuari(new Usuari(dades[0], dades[1], Integer.parseInt(dades[2])));
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e; 
        }
        
    }

    /**
     * Desar les dades dels usuaris al fitxer
     * @param usuaris llista d'usuaris
     * @throws IOException
     */
    public static void desarUsuaris(LlistaUsuaris usuaris) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter( dirFitxers+fUsuaris ))) {
            
            for (int i = 1; i <= usuaris.getNumElem(); i++) {
                Usuari u = usuaris.consultaPoisicio(i);
                writer.write(u.getAlies() + ";" + u.getCorreu() + ";" + u.getCodi_postal());
                writer.newLine();
            }

        } catch (IOException e) {
            System.err.println("error al escriure usuaris: " + e.getMessage());
        }
        
    }

    /**
     * Carregar les dades de les entitats del fitxer
     * @param entitats llista d'entitats
     * @throws IOException
     */
    public static void carregarEntitats(LlistaEntitats entitats) throws IOException {
        
        try {
            Scanner f = new Scanner(new File(dirFitxers + fEntitats));
    
            String[] dades;
            while (f.hasNextLine()) {
                String linia = f.nextLine();
                if (!linia.isEmpty()) {
                    dades = linia.split(";");
                    entitats.afegirEntitat(new Entitat(dades[0], dades[1], dades[2]));
                }
            }
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw e; 
        }
    }

    /**
     * Carregar les dades de les activitats del fitxer
     * @param activitats llista d'activitats
     * @throws IOException
     */
    public static void carregarActivitats(LlistaActivitats activitats) throws IOException {
        
        try (Scanner f = new Scanner(new File(dirFitxers + fActivitats))) {
            
            // TODO: leer codigo act y guardar en codigo
            while (f.hasNextLine()) {
                String linia = f.nextLine();
                if (!linia.isEmpty()) {

                    String[] dades = linia.split(";");    
                    char tipus = dades[0].charAt(0);
    
                    switch (tipus) {
                        case 'v':
                            activitats.afegirActivitat(new Visita(dades[1], dades[2], dades[3], Integer.parseInt(dades[4]),
                                    Integer.parseInt(dades[5]), dades[6], Boolean.parseBoolean(dades[7]),
                                    Boolean.parseBoolean(dades[8])));
                            break;
    
                        case 't':
                            activitats.afegirActivitat(new Taller(dades[1], dades[2], dades[3], Integer.parseInt(dades[4]),
                                    Integer.parseInt(dades[5]), dades[6], Integer.parseInt(dades[7]), Integer.parseInt(dades[8]),
                                    Integer.parseInt(dades[9]), Integer.parseInt(dades[10]), Integer.parseInt(dades[11])));
                            break;
    
                        case 'x':
                            activitats.afegirActivitat(new Xerrada(dades[1], dades[2], dades[3], Integer.parseInt(dades[4]),
                                    Integer.parseInt(dades[5]), dades[6]));
                            break;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }

    }
    

    /**
     * Desar les dades de les activitats al fitxer
     * @param entitats llista d'activitats
     * @throws IOException
     */
    public static void desarActivitats(LlistaActivitats activitats){

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dirFitxers+fActivitats))) {
            
            for (int i = 1; i <= activitats.getNumElem(); i++) {
                
                Activitat a = activitats.consultaPoisicio(i);
        
                String linia = a.tipusActivitat() + ";" + a.getEntitat() + ";" + a.getNom_activitat() +
                        ";" + a.getLloc() + ";" + a.getCodi_postal() + ";" + a.getDia() + ";";
        
                switch (a.tipusActivitat()) {
                    case 'v':
                        Visita v = (Visita) a;
                        linia += v.getEdifici() + ";" + v.getAudioguia() + ";" + v.getPer_cecs();
                        break;
        
                    case 't':
                        Taller t = (Taller) a;
                        linia += t.getHora() + ";" + t.getDurada() + ";" + t.getCapacitat() + ";" +
                                t.getTotalPuntuacions() + ";" + t.getNumPuntuacions() + ";"
                                + t.getPlacesDisponibles();
                        break;
        
                    case 'x':
                        Xerrada x = (Xerrada) a;
                        linia += x.getResponsable();
                        break;
                }
        
                writer.write(linia);
                writer.newLine();
            }

        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
        
    }

    /**
     * Carregar les reserves del fitxer bin
     * @param reservas llista de reserves
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void carregarReserves(LlistaReserves reserves) throws IOException, ClassNotFoundException {
            
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dirFitxers+fReserves))) {
            while (true) {
                try {
                    Reserva reserva = (Reserva) ois.readObject();
                    reserves.afegirReserva(reserva);
                } catch (EOFException e) {
                    break; // final fitxer
                    // alternament podriem guardar el num de reserves al principi del fitxer.
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Desar les reserves al fitxer bin
     * @param reservas
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void desarReserves(LlistaReserves reserves) throws IOException, ClassNotFoundException {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dirFitxers+fReserves))) {
            
            for (int i=1; i<= reserves.getNumElem(); i++)
                oos.writeObject(reserves.consultaPoisicio(i));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
