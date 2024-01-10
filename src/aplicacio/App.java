package aplicacio;

import java.io.IOException;
import java.util.Scanner;

import dades.Usuari;
import dades.Visita;
import dades.Xerrada;
import dades.Activitat;
import dades.Entitat;
import dades.GestorFitxers;
import dades.Reserva;
import dades.LlistaActivitats;
import dades.LlistaEntitats;
import dades.LlistaReserves;
import dades.LlistaUsuaris;
import dades.Taller;

public class App {

    public static Scanner teclat = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        LlistaUsuaris usuaris = new LlistaUsuaris(LlistaUsuaris.maxUsuaris);
        LlistaEntitats entitats = new LlistaEntitats(LlistaEntitats.maxEntitats);
        LlistaActivitats activitats = new LlistaActivitats(LlistaActivitats.maxActivitats);
        LlistaReserves reserves = new LlistaReserves(LlistaReserves.maxReserves);

        // carregar dades
        try {

            GestorFitxers.carregarUsuaris(usuaris);
            GestorFitxers.carregarEntitats(entitats);
            GestorFitxers.carregarActivitats(activitats);
            GestorFitxers.carregarReserves(reserves);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // TODO delete later
        /* Missatges de comprobacio de carrega del arxius.txt */
        System.out.println("\nNum usuaris: " + usuaris.getNumElem());
        System.out.println("Num entitats: " + entitats.getNumElem());
        System.out.println("Num activitats: " + activitats.getNumElem());
        System.out.println("Num reserves: " + reserves.getNumElem());
        System.out.println("\n");

        menu(usuaris, entitats, activitats, reserves);

        // desar dades
        System.out.println("Desitja desar els canvis? s/n");
        String desar = teclat.nextLine();
        if (desar.equals("s")) {
            
            try {
                GestorFitxers.desarActivitats(activitats);
                GestorFitxers.desarUsuaris(usuaris);
				GestorFitxers.desarReserves(reserves);
                System.out.println("\nS'han desat els canvis correctament");
			} catch (Exception e) {
				e.printStackTrace();
			}
            
        }
        System.out.println("Gràcies, adeu!");

    }

    private static void menu(LlistaUsuaris u, LlistaEntitats e, LlistaActivitats a, LlistaReserves r) {

        System.out.println(
                "1. Mostrar les dades de qualsevol llista que tingueu definida\n" + //
                "2. Obtenir i mostrar la llista d’activitats que ofereix una entitat concreta\n" + //
                "3. Obtenir i mostrar la llista de les activitats que es duen a terme en un dia indicat per teclat\n"+ //
                "4. Obtenir i mostrar la llista dels tallers que tenen places disponibles\n" + //
                "5. Afegir una nova activitat\n" + //
                "6. Registrar la petició d’un usuari per reservar un taller\n" +
                "7. Mostrar els usuaris que s’han apuntat a un taller.\n" + //
                "8. Calcular l’usuari que s’ha apuntat a més tallers.\n" + //
                "9. Registrar la nota que un usuari que s’ha apuntat a un taller li dona un cop s’ha fet.\n" + //
                "10. Calcular la nota mitja que ha rebut un taller.\n" + //
                "11. Quin és el taller que ha tingut més èxit? Calcularem l’èxit segons el taller que ha tingut una\r\n"+ //
                "ocupació més alta en proporció a les places que oferia.\n" + //
                "12. Obtenir i mostrar les dades de la llista de visites ofertes per una entitat (per teclat s’indicarà si\r\n"+ //
                "es vol audioguia o si cal que estigui adaptada per persones cegues).\n" + //
                "13. Mostrar les dades de les xerrades que farà una persona concreta.\n" + //
                "14. Donar de baixa un taller sempre que no hi hagi usuaris apuntats\n" + //
                "15. Sortir del programa.\n"
                );

        System.out.println("introdueix el num de l'opcio:");
        int opcio = Integer.parseInt(teclat.nextLine());

        while (opcio != 15) {

            switch (opcio) {
                case 1:
                    opcio1(u, e, a, r);
                    break;
                case 2:
                    opcio2(e, a);
                    break;
                case 3:
                    opcio3(a);
                    break;
                case 4:
                    opcio4(a);
                    break;
                case 5:
                    opcio5(a, e);
                    break;
                case 6:
                    opcio6(u, a, r);
                    break;
                case 7:
                    opcio7(r, u);
                    break;
                case 8:
                    opcio8();
                    break;
                case 9:
                    opcio9(r);
                    break;
                case 10:
                    opcio10(r, a);
                    break;
                case 11:
                    opcio11();
                    break;
                case 12:
                    opcio12();
                    break;
                case 13:
                    opcio13(a);
                    break;
                case 14:
                    opcio14();
                    break;

                default:
                    System.out.println("Numero d'opcio incorrecta");
                    
            }

            System.out.println("\nintrodueix el num de l'opcio:");
            opcio = Integer.parseInt(teclat.nextLine());

        }

    }

    private static void opcio1(LlistaUsuaris u, LlistaEntitats e, LlistaActivitats a, LlistaReserves r) {
        System.out.println("\nEscull un número:\n1. Usuaris\n2. Activitats\n3. Reserves\n4. Entitats");
        int opcioLlista = Integer.parseInt(teclat.nextLine());

        switch (opcioLlista) {
            case 1:
                if (u.getNumElem() > 0) {
                    System.out.println(u);
                } else {
                    System.out.println("No hi ha usuaris.");
                }
                break;
            case 2:
                if (a.getNumElem() > 0) {
                    System.out.println(a);
                } else {
                    System.out.println("No hi ha activitats.");
                }
                break;
            case 3:
                if (r.getNumElem() > 0) {
                    System.out.println(r);
                } else {
                    System.out.println("No hi ha reserves.");
                }
                break;
            case 4:
                if (e.getNumElem() > 0) {
                    System.out.println(e);
                } else {
                    System.out.println("No hi ha entitats.");
                }
                break;
            default:
                System.out.println("Opció incorrecta");
        }
    }

    private static void opcio2(LlistaEntitats e, LlistaActivitats a) {

        System.out.println("Introdueix el nom de l'entitat:");
        String nomEntitat = teclat.nextLine();

        LlistaActivitats activitatsEntitat = a.obtenirLlistaActivitatsPerEntitat(nomEntitat);

        if (activitatsEntitat.getNumElem() > 0) {
            System.out.println("Llista d'activitats de l'entitat " + nomEntitat + ":");
            System.out.println(activitatsEntitat.toString());
        } else {
            System.out.println("No hi ha activitats per a l'entitat " + nomEntitat);
        }

    }

    private static void opcio3(LlistaActivitats activitats) {
        System.out.println("Introdueix el dia per veure les activitats:");
        int dia = Integer.parseInt(teclat.nextLine());

        LlistaActivitats activitatsEnDia = activitats.obtenirLlistaActivitatsPerDia(dia);

        if (activitatsEnDia.getNumElem() > 0) {
            System.out.println("Llista d'activitats per al dia " + dia + ":");
            System.out.println(activitatsEnDia.toString());
        } else {
            System.out.println("No hi ha activitats per al dia " + dia);
        }
    }

    private static void opcio4(LlistaActivitats activitats) {
        LlistaActivitats tallersAmbPlacesDisponibles = activitats.obtenirLlistaTallersAmbPlacesDisponibles();

        if (tallersAmbPlacesDisponibles.getNumElem() > 0) {
            System.out.println("Llista de tallers amb places disponibles:");
            System.out.println(tallersAmbPlacesDisponibles.toString());
        } else {
            System.out.println("No hi ha tallers amb places disponibles.");
        }
    }

    //Hay que arreglarlo
    private static void opcio5(LlistaActivitats activitats, LlistaEntitats entitats) {
        System.out.println("Introdueix les dades de la nova activitat:");

        System.out.println("Entitat de l'activitat:");
        String entitat = teclat.nextLine();

        // Comprova si l'entitat existeix
        Entitat entitatSeleccionada = entitats.obtenirEntitatPerNom(entitat);
        if (entitatSeleccionada == null) {
            System.out.println("L'entitat no existeix. No es pot afegir l'activitat.");
            return;
        }

        System.out.println("Nom de l'activitat:");
        String nomActivitat = teclat.nextLine();

        System.out.println("Lloc de l'activitat:");
        String lloc = teclat.nextLine();

        System.out.println("Codi postal de l'activitat:");
        int codiPostal = Integer.parseInt(teclat.nextLine());

        System.out.println("Dia de l'activitat:");
        int dia = Integer.parseInt(teclat.nextLine());

        System.out.println("Tipus d'activitat (v: Visita, t: Taller, x: Xerrada):");
        char tipus = teclat.nextLine().charAt(0);

        switch (tipus) {
            case 'v':
                System.out.println("Lloc que es visita:");
                String dataVisita = teclat.nextLine();
                System.out.println("Audioguia (true/false):");
                boolean audioguia = Boolean.parseBoolean(teclat.nextLine());
                System.out.println("Adaptada per a persones cegues (true/false):");
                boolean adaptada = Boolean.parseBoolean(teclat.nextLine());

                activitats.afegirActivitat(
                        new Visita(entitat, nomActivitat, lloc, codiPostal, dia, dataVisita, audioguia, adaptada));
                break;

            case 't':
                System.out.println("Hora del taller:");
                String horaTaller = teclat.nextLine();
                System.out.println("Durada del taller (en hores):");
                int duradaTaller = Integer.parseInt(teclat.nextLine());
                System.out.println("Capacitat del taller:");
                int capacitatTaller = Integer.parseInt(teclat.nextLine());

                activitats.afegirActivitat(new Taller(entitat, nomActivitat, lloc, codiPostal, dia, horaTaller,
                        duradaTaller, capacitatTaller, 0, 0, capacitatTaller));
                break;

            case 'x':
                System.out.println("Responsable de la xerrada (nom):");
                String responsableXerrada = teclat.nextLine();

                activitats.afegirActivitat(new Xerrada(entitat, nomActivitat, lloc, codiPostal, dia, responsableXerrada));
                break;

            default:
                System.out.println("Tipus d'activitat no vàlid.");
                break;
        }

        // Hay que comprovar si ya existe esa actividad

        System.out.println("Nova activitat afegida amb èxit:\n" + activitats.consultaPoisicio(activitats.getNumElem()));
    }

    private static void opcio6(LlistaUsuaris usuaris, LlistaActivitats activitats, LlistaReserves reserves) {

        // Mostrar la llista de tallers disponibles perquè l'usuari en seleccioni un
        LlistaActivitats tallersDisponibles = activitats.obtenirLlistaTallersAmbPlacesDisponibles();
        if (tallersDisponibles.getNumElem() == 0) {
            System.out.println("No hi ha tallers disponibles en aquest moment.");
            return;
        }

        System.out.println("Llista de tallers disponibles:");
        System.out.println(tallersDisponibles);

        System.out.println("Introdueix el codi del taller pel qual vols fer la reserva:");
        String codiTaller = teclat.nextLine();

        // Comprovar si el taller seleccionat existeix a la llista de tallers
        // disponibles
        Taller tallerSeleccionat = (Taller) tallersDisponibles.obtenirActivitatPerCodi(codiTaller);

        if (tallerSeleccionat != null) { // Solo si el taller existe preguntamos el usuario
            // Mostrar la llista d'usuaris
            System.out.println("Llista d'usuaris:");
            System.out.println(usuaris);

            System.out.println("Introdueix el nom d'usuari pel qual vols fer la reserva:");
            String aliesUsuari = teclat.nextLine();

            // Verificar si l'usuari existeix
            Usuari usuari = usuaris.obtenirUsuariPerAlies(aliesUsuari);
            int intents = 0;

            // Para que no pueda ser un bucle infinito damos 3 intentos para que se intente registrar un nuevo usuario
            while (usuari == null && intents < 3) {
                System.out.println("\n'"+aliesUsuari+"': No s'ha trobat cap usuari amb aquest alies." +
                                    "\nVols registrar un nou usuari? s/n");
                String registrar = teclat.nextLine();
                if (registrar.equals("n")) {
                    return;
                }
                registrarNouUsuari(usuaris); // Intentamos crear un nuevo usuario
                usuari = usuaris.obtenirUsuariPerAlies(aliesUsuari);
                intents++; // incrementamos los intentos
            }
            if (usuari == null){ // si sale del bucle y sigue sin existir el usuario sale de la opción
                System.out.println("\nIntenta-ho de nou més tard\n");
                return;
            }

            // Hay que comprovar si ese mismo usuario ya ha hecho una reserva para ese mismo taller
            // El codigo de reserva es el usuario+numero del taller, así que es facil comprovarlo con solo eso

            // Todos los datos están en orden:
            // Crear una nova reserva
            Reserva reserva = new Reserva(usuari, codiTaller);

            // Afegir la reserva a la llista de reserves
            reserves.afegirReserva(reserva);

            // Actualitzar les places disponibles del taller
            ((Taller) activitats.obtenirActivitatPerCodi(codiTaller)).decrementarPlacesDisponibles();

            System.out.println("Reserva realitzada amb èxit:");
            System.out.println(reserva);

        } else {
            System.out.println("No s'ha trobat cap taller amb el codi proporcionat.");
        }
    }

    private static void registrarNouUsuari(LlistaUsuaris u) {

        System.out.println("Introdueix un alies d'usuari:");
        String alies = teclat.nextLine();

        if (u.obtenirUsuariPerAlies(alies)==null){
            System.out.println("Introdueix el correu electronic:");
            String correu = teclat.nextLine();

            if (!u.existeixCorreu(correu)){
                System.out.println("Introdueix el codi postal del teu domicili:");
                int codiPostal = Integer.parseInt(teclat.nextLine());
                System.out.println(u.afegirUsuari(new Usuari(alies, correu, codiPostal)));
                return;
            }
        } 
        System.out.println("Ja existeix aquest alies/correu a la llista d'usuaris");
    }

    private static void opcio7(LlistaReserves reserves, LlistaUsuaris usuaris) {

        System.out.println("Introdueix el codi del taller per veure els usuaris apuntats:");
        String codiTaller = teclat.nextLine();

        // Mostrar els usuaris apuntats al taller
        reserves.mostrarUsuarisApuntatsATaller(codiTaller, usuaris);

    }

    private static void opcio8() {
    }

    private static void opcio9(LlistaReserves reserves) {
        System.out.println("Introdueix el codi de la reserva per a la qual vols registrar la nota:");
        String codiReserva = teclat.nextLine();

        // Busca la reserva amb el codi proporcionat
        Reserva reserva = reserves.obtenirReservaPerCodi(codiReserva);

        if (reserva != null) {
            if (reserva.getValoracio() == -1) { // Comprova si la reserva ja té una valoració
                System.out.println("Introdueix la nota que vols donar al taller (entre 0 i 10):");
                double puntuacio = Double.parseDouble(teclat.nextLine());

                if (puntuacio >= 0 && puntuacio <= 10) {
                    reserva.valorarReserva(puntuacio);
                    System.out.println("Nota enregistrada amb èxit:\n" + reserva);
                } else {
                    System.out.println("La nota ha de ser entre 0 i 10.");
                }
            } else {
                System.out.println("Aquesta reserva ja té una valoració registrada.");
            }
        } else {
            System.out.println("No s'ha trobat cap reserva amb aquest codi.");
        }
    }

    private static void opcio10(LlistaReserves reserves, LlistaActivitats activitats) {
        System.out.println("Introdueix el codi del taller per calcular la nota mitja:");
        String codiTaller = teclat.nextLine();

        // Busca el taller amb el codi proporcionat
        Activitat taller = activitats.obtenirActivitatPerCodi(codiTaller);

        if (taller instanceof Taller) {
            // Calcula la nota mitja per al taller
            double notaMitja = reserves.calcularNotaMitjaTaller(codiTaller);

            if (notaMitja != -1) {
                System.out.println("La nota mitja del taller " + codiTaller + " és: " + notaMitja);
            } else {
                System.out.println("No hi ha reserves amb valoració per aquest taller.");
            }
        } else {
            System.out.println("No s'ha trobat cap taller amb el codi proporcionat.");
        }
    }

    private static void opcio11() {
    }

    private static void opcio12() {
    }

    private static void opcio13(LlistaActivitats activitats) {
        System.out.println("Introdueix el nom de la persona:");
        String nomPersona = teclat.nextLine();

        // Obtenir i mostrar les dades de les xerrades de la persona
        LlistaActivitats xerradesPersona = activitats.obtenirLlistaXerradesPerPersona(nomPersona);

        if (xerradesPersona.getNumElem() > 0) {
            System.out.println("Dades de les xerrades que farà la persona " + nomPersona + ":");
            System.out.println(xerradesPersona.toString());
        } else {
            System.out.println("Aquesta persona no farà cap xerrada.");
        }
    }

    private static void opcio14() {
    }

}
