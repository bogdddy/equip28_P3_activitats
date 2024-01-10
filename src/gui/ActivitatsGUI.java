package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import dades.GestorFitxers;
import dades.LlistaActivitats;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.rmi.dgc.VMID;
import java.time.LocalDate;

/**
 * Classe per crear la GUI del gestor d'activitats
 *
 * @author Bogdan Struk
 */

public class ActivitatsGUI extends JFrame {

    public static void main(String[] args) {
        
        activitats = new LlistaActivitats(LlistaActivitats.maxActivitats);

        try { 
            
            GestorFitxers.carregarActivitats(activitats); 
            activitats.ordenaCronologicament();

        } catch (IOException e) { e.printStackTrace();}

        SwingUtilities.invokeLater(() -> new ActivitatsGUI());
    }

    private final int totalDies = 10;
    
    private JButton[] botonsDia = new JButton[totalDies];
    private JLabel infoLabel;

    private static LlistaActivitats activitats;

    public ActivitatsGUI() {

        super("Calendari d'Activitats");
        
        infoLabel = new JLabel("Selecciona un dia per veure les activitats");
        JPanel infoPanel = new JPanel(new FlowLayout());
        infoPanel.add(infoLabel);

        // botons activitats
        JPanel botonsPanel = new JPanel(new GridLayout(2, 5));
        JLabel labelDia, labelActivitats;
        int diaAvui =  LocalDate.now().getDayOfMonth();

        for (int i = 0; i < totalDies; i++) {

            labelDia =  new JLabel("Dia "+String.valueOf(diaAvui + i));
            labelActivitats = new JLabel("nº Act :"+String.valueOf(activitats.obtenirLlistaActivitatsPerDia(diaAvui+i).getNumElem()));

            botonsDia[i] = new JButton();
            botonsDia[i].setLayout(new BorderLayout());
            botonsDia[i].add(BorderLayout.NORTH, labelDia);
            botonsDia[i].add(BorderLayout.CENTER, labelActivitats);
            botonsDia[i].addActionListener(new ClickBotoDia(diaAvui + i));

            botonsPanel.add(botonsDia[i]);

        }
        
        // afegir items
        JPanel containerPanel = new JPanel(new BorderLayout());
        containerPanel.add(botonsPanel, BorderLayout.CENTER);
        containerPanel.add(infoPanel, BorderLayout.NORTH);

        add(containerPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Classe interna per gestionar clics als botonsDia
     */
    private class ClickBotoDia implements ActionListener {
        
        private int dia;

        public ClickBotoDia(int dia) {
            this.dia = dia;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            obrirFinestraActivitats(activitats.obtenirLlistaActivitatsPerDia(dia), dia);
        }
    }

    /**
     * Obre una nova finestra amb una taula d'activitats del dia seleccionat
     * @param llista llista d'activitats del dia
     * @param dia numero del dia
     */
    private void obrirFinestraActivitats(LlistaActivitats llista, int dia) {
        
        JFrame frame = new JFrame("Activitats dia "+dia);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // taula activitats
        String[] nomsColumnes = {"Tipus", "Entitat", "Nom", "Lloc"};
        JTable taula = new JTable(llista.convertirArray2D(), nomsColumnes);
        JScrollPane scrollPane = new JScrollPane(taula); // afegir scroll
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        // botons filtratge
        JButton botonsFiltre[] = new JButton[4];
        botonsFiltre[0] = new JButton("TOT");
        botonsFiltre[1] = new JButton("Xerrades");
        botonsFiltre[2] = new JButton("Visites");
        botonsFiltre[3] = new JButton("Taller");
        
        JPanel filterPanel = new JPanel(new FlowLayout());

        for (int i = 0; i < botonsFiltre.length; i++) {
            filterPanel.add(botonsFiltre[i]);
            botonsFiltre[i].addActionListener(new ClickBotonsFiltre(llista, taula));
        }
        frame.getContentPane().add(filterPanel, BorderLayout.SOUTH);
        
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private class ClickBotonsFiltre implements ActionListener {

        final String[] nomsColumnes = {"Tipus", "Entitat", "Nom", "Lloc"};
        private LlistaActivitats llista;
        private JTable taula;
    
        ClickBotonsFiltre(LlistaActivitats llista, JTable taula) {
            this.llista = llista.copia();
            this.taula = taula;
        }
    
        @Override
        public void actionPerformed(ActionEvent e) {
    
            // boto clicat
            JButton clickedButton = (JButton) e.getSource();
            String buttonText = clickedButton.getText();
    
            DefaultTableModel tableModel = (DefaultTableModel) taula.getModel();
    
            //TODO : FIX
            switch (buttonText) {
                case "TOT":
                    updateTableData(tableModel, llista.convertirArray2D());
                    break;
                case "Xerrades":
                    updateTableData(tableModel, llista.activitatsTipus('x').convertirArray2D());
                    break;
                case "Visites":
                    updateTableData(tableModel, llista.activitatsTipus('v').convertirArray2D());
                    break;
                case "Taller":
                    updateTableData(tableModel, llista.activitatsTipus('t').convertirArray2D());
                    break;
            }
        }
    
        private void updateTableData(DefaultTableModel model, Object[][] novesActivitats) {
            model.setDataVector(novesActivitats, nomsColumnes);
        }
    }
    

}
