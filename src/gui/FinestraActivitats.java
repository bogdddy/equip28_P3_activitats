package gui;

import dades.LlistaActivitats;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe per crear la finestra d'activitats del gestor d'activitats
 *
 * @author Bogdan Struk
 */

public class FinestraActivitats {

    public FinestraActivitats(LlistaActivitats llista, int dia) {
        
        JFrame frame = new JFrame("Activitats dia " + dia);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // crear taula activitats
        JTable taula = new JTable();
        String[] nomsColumnes = {"Tipus", "Entitat", "Nom", "Lloc"};
        DefaultTableModel modelTaula = new DefaultTableModel(llista.convertirArray2D(), nomsColumnes);
        taula.setModel(modelTaula);
        JScrollPane scrollPane = new JScrollPane(taula); // afegir scroll
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        // botons filtratge
        JPanel filtrePanel = new JPanel(new FlowLayout());
        
        JButton botonsFiltre[] = new JButton[4];
        botonsFiltre[0] = new JButton("TOT");
        botonsFiltre[1] = new JButton("Xerrades");
        botonsFiltre[2] = new JButton("Visites");
        botonsFiltre[3] = new JButton("Taller");

        Color color = null;
        for (int i = 0; i < botonsFiltre.length; i++) {
            filtrePanel.add(botonsFiltre[i]);
            botonsFiltre[i].addActionListener(new ClickBotonsFiltre(llista, modelTaula));

            if (i>0) // no cambiar el color de "TOT"
                color = clorBotoFiltre(llista, botonsFiltre[i].getText().charAt(0));
            if (color != null) botonsFiltre[i].setEnabled(false);
            botonsFiltre[i].setBackground(color);
        }
        frame.getContentPane().add(filtrePanel, BorderLayout.SOUTH);

        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Decidir el color del botó en funcio si hi ha elements del tipus o no
     * @param llista llista de totes les activitats
     * @param tipus char indicant el tipus d'activitat (x,v,t)
     * @return el nou color del boto
     */
    private Color clorBotoFiltre(LlistaActivitats llista, char tipus){
        return llista.activitatsTipus(tipus).getNumElem() > 0 ? null : Color.RED;
    }

     /**
     * Classe interna per gestionar clics als BotonsFilre
     */
    private class ClickBotonsFiltre implements ActionListener {

        private LlistaActivitats llista;
        private DefaultTableModel model;

        ClickBotonsFiltre(LlistaActivitats llista, DefaultTableModel model) {
            this.llista = llista.copia();
            this.model = model;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            
            // boto clicat
            JButton botoClicat = (JButton) e.getSource();
            String tetxBoto = botoClicat.getText();

            switch (tetxBoto) {
                case "TOT":
                    actualitzarDadesTaula(llista.convertirArray2D());
                    break;
                case "Xerrades":
                    actualitzarDadesTaula(llista.activitatsTipus('x').convertirArray2D());
                    break;
                case "Visites":
                    actualitzarDadesTaula(llista.activitatsTipus('v').convertirArray2D());
                    break;
                case "Taller":
                    actualitzarDadesTaula(llista.activitatsTipus('t').convertirArray2D());
                    break;
            }
        }

        /**
         * Actualitzar les dades de la taula
         * @param novesActivitats array 2D amb les noves dades
         */
        private void actualitzarDadesTaula(Object[][] novesActivitats) {
            model.setDataVector(novesActivitats, new String[]{"Tipus", "Entitat", "Nom", "Lloc"});
        }
    }
}
