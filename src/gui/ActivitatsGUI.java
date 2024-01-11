package gui;

import dades.GestorFitxers;
import dades.LlistaActivitats;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;

/**
 * Classe per crear la finestra principal de la GUI del gestor d'activitats
 *
 * @author Bogdan Struk
 */

public class ActivitatsGUI extends JFrame {

    private final int totalDies = 10;
    private JButton[] botonsDia = new JButton[totalDies];
    private JLabel infoLabel;
    private static LlistaActivitats activitats;

    public ActivitatsGUI() {
        super("Calendari d'Activitats");

        infoLabel = new JLabel("Selecciona un dia per veure les activitats");
        JPanel infoPanel = new JPanel(new FlowLayout());
        infoPanel.add(infoLabel);

        // crear botons activitats
        JPanel botonsPanel = new JPanel(new GridLayout(2, 5));
        JLabel labelDia, labelActivitats;
        int diaAvui = LocalDate.now().getDayOfMonth();

        for (int i = 0; i < totalDies; i++) {
            labelDia = new JLabel("Dia " + String.valueOf(diaAvui + i));
            labelActivitats = new JLabel("nº Act :" + String.valueOf(activitats.obtenirLlistaActivitatsPerDia(diaAvui + i).getNumElem()));

            botonsDia[i] = new JButton();
            botonsDia[i].setLayout(new BorderLayout());
            botonsDia[i].add(BorderLayout.NORTH, labelDia);
            botonsDia[i].add(BorderLayout.CENTER, labelActivitats);
            botonsDia[i].addActionListener((ActionListener) new ClickBotoDia(diaAvui + i));

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
     * Classe interna per gestionar clics dels botonsDia
     */
    private class ClickBotoDia implements ActionListener {

        private int dia;

        public ClickBotoDia(int dia) {
            this.dia = dia;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new FinestraActivitats(activitats.obtenirLlistaActivitatsPerDia(dia), dia);
        }

    }

    /**
     * Metode principal per correr l'aplicacio
     */
    public static void main(String[] args) {
        activitats = new LlistaActivitats(LlistaActivitats.maxActivitats);

        try {
            GestorFitxers.carregarActivitats(activitats);
            activitats.ordenaCronologicament();
        } catch (IOException e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> new ActivitatsGUI());
    }

}
