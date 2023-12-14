package aplicacio;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import dades.Usuari;
import dades.Visita;
import dades.Xerrada;
import dades.Entitat;
import dades.LlistaActivitats;
import dades.LlistaEntitats;
import dades.LlistaUsuaris;
import dades.Taller;

public class App {

    final static int maxUsuaris = 50;
    final static int maxEntitats = 50;
    final static int maxActivitats = 50;
    final static int maxReserves = 100;

    public static Scanner teclat = new Scanner(System.in);


    public static void main(String[] args) {

        LlistaUsuaris usuaris = new LlistaUsuaris(maxUsuaris);
        LlistaEntitats entitats = new LlistaEntitats(maxEntitats);
        LlistaActivitats activitats = new LlistaActivitats(maxActivitats);

        try {

            carregarUsuaris(usuaris);
            carregarEntitats(entitats);
            carregarActivitats(activitats);

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(usuaris);
        System.out.println(entitats);
        System.out.println(activitats);

        menu(usuaris, entitats, activitats);


    }

    /**
     * Carregar les dades dels usuaris del fitxer
     * @param usuaris llista d'usuaris
     * @throws IOException
     */
    private static void carregarUsuaris(LlistaUsuaris usuaris) throws IOException{

        Scanner f = new Scanner(new File("src\\aplicacio\\usuaris.txt"));

        String[] dades;
        while (f.hasNext()) {
            dades = f.next().split(";");
            usuaris.afegirUsuari(new Usuari(dades[0], dades[1], dades[2]));;
        }
        f.close();
    }

    /**
     * Carregar les dades de les entitats del fitxer
     * @param entitats llista d'entitats
     * @throws IOException
     */
    private static void carregarEntitats(LlistaEntitats entitats) throws IOException{

        Scanner f = new Scanner(new File("src\\aplicacio\\entitats.txt"));

        String[] dades;
        while (f.hasNext()) {
            dades = f.next().split(";");
            entitats.afegirEntitat(new Entitat(dades[0], dades[1], dades[2]));
        }
        f.close();
    }

    /**
     * Carregar les dades de les activitats del fitxer
     * @param entitats llista d'activitats
     * @throws IOException
     */
    private static void carregarActivitats(LlistaActivitats activitats) throws IOException{

        Scanner f = new Scanner(new File("src\\aplicacio\\activitats.txt"));

        char tipus;
        String[] dades;
        while (f.hasNext()) {
            
            tipus = f.next().charAt(0);
            dades = f.next().split(";");

            switch (tipus) {
                case 'v':
                    activitats.afegirActivitat(new Visita(dades[0], dades[1], dades[2], Integer.parseInt(dades[3]), Integer.parseInt(dades[4]), dades[5], Boolean.parseBoolean(dades[6]), Boolean.parseBoolean(dades[6])));
                    break;
                case 't':
                    activitats.afegirActivitat(new Taller(dades[0], dades[1], dades[2], Integer.parseInt(dades[3]), Integer.parseInt(dades[4]), dades[5], Integer.parseInt(dades[6]), Integer.parseInt(dades[6])));
                    break;
                case 'x':
                    activitats.afegirActivitat(new Xerrada(dades[0], dades[1], dades[2], Integer.parseInt(dades[3]), Integer.parseInt(dades[4]), dades[5]));
                    break;
                default:
                    break;
            }
        }
        f.close();
    }

    private static void menu(LlistaUsuaris u, LlistaEntitats e, LlistaActivitats a){

		System.out.println(
			"1. Mostrar les dades de qualsevol llista que tingueu definida\n" + //
			"2. Obtenir i mostrar la llista d’activitats que ofereix una entitat concreta\n" + //
			"3. Obtenir i mostrar la llista de les activitats que es duen a terme en un dia indicat per teclat\n" + //
			"4. Obtenir i mostrar la llista dels tallers que tenen places disponibles\n"+ //
			"5. Afegir una nova activitat\n" + //
			"6. Registrar la petició d’un usuari per reservar un taller\n" + 
			"7. Mostrar els usuaris que s’han apuntat a un taller.\n" + //
			"8. Calcular l’usuari que s’ha apuntat a més tallers.\n" + //
			"9. Registrar la nota que un usuari que s’ha apuntat a un taller li dona un cop s’ha fet.\n" + //
			"10. Calcular la nota mitja que ha rebut un taller.\n" + //
			"11. Quin és el taller que ha tingut més èxit? Calcularem l’èxit segons el taller que ha tingut una\r\n" + //
			"ocupació més alta en proporció a les places que oferia.\n" + //
			"12. Obtenir i mostrar les dades de la llista de visites ofertes per una entitat (per teclat s’indicarà si\r\n" + //
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
					opcio1();
					break;
				case 2:
					opcio2();
					break;
				case 3:
					opcio3();
					break;
				case 4:
					opcio4();
					break;
				case 5:
					opcio5();
					break;
				case 6:
					opcio6();
					break;
				case 7:
					opcio7();
					break;
				case 8:
					opcio8();
					break;
				case 9:
					opcio9();
					break;
				case 10:
					opcio10();
					break;
				case 11:
					opcio11();
					break;
				case 12:
					opcio12();
					break;
				case 13:
					opcio13();
					break;
				case 14:
					opcio14();
					break;
			
				default:
					System.out.println("Numero d'opcio incorrecta");;
			}
			
			System.out.println("\nintrodueix el num de l'opcio:");
			opcio = Integer.parseInt(teclat.nextLine());
			
		}

		System.out.println("CHAU !!");

	}

    private static void opcio1(){}

    private static void opcio2(){}

    private static void opcio3(){}
    
    private static void opcio4(){}

    private static void opcio5(){}

    private static void opcio6(){}

    private static void opcio7(){}

    private static void opcio8(){}

    private static void opcio9(){}

    private static void opcio10(){}

    private static void opcio11(){}

    private static void opcio12(){}

    private static void opcio13(){}

    private static void opcio14(){}

}
