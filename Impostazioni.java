import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;

public class Impostazioni extends JPanel{
    JComboBox<String> tipo;
    JTextField risultato, volt, resistenza, condensatore, induttore, frequenza;
    public Impostazioni(JTextField risultato){
        this.risultato = risultato;
        String[] tipiCircuito = {"Valore efficace C","RC Serie", "RL Serie", "RLC Serie"}; //MANCANO QUELLI IN PARALLELO
        tipo = new JComboBox<>(tipiCircuito);
        add(tipo);
        volt = new JTextField(6);
        add(volt);
        add(new JLabel("V   "));
        resistenza = new JTextField(6);
        add(resistenza);
        add(new JLabel("OHM   "));
        condensatore = new JTextField(6);
        add(condensatore);
        add(new JLabel("F   "));
        induttore = new JTextField(6);
        add(induttore);
        add(new JLabel("H   "));
        frequenza = new JTextField(6);
        add(frequenza);
        add(new JLabel("Hz"));
        JButton bottone = new JButton("Calcola");
        bottone.addActionListener(new AscoltatoreBottone());
        add(bottone);
    }

    public class AscoltatoreBottone implements ActionListener{
        public void actionPerformed(ActionEvent e){
            switch (tipo.getSelectedIndex()) {
                case 0:
                    risultato.setText(Arrays.toString(RegimeSinusoidale.valoreEfficaceC(Double.parseDouble(volt.getText()), 
                                                                                        Double.parseDouble(condensatore.getText()), 
                                                                                        Double.parseDouble(frequenza.getText()))));
                    break;
                case 1:
                    risultato.setText(Arrays.toString(RegimeSinusoidale.circuitoRcSerie(Double.parseDouble(volt.getText()),
                                                                                        Double.parseDouble(resistenza.getText()),
                                                                                        Double.parseDouble(condensatore.getText()), 
                                                                                        Double.parseDouble(frequenza.getText()))));
                    break;
                case 2:
                    risultato.setText(Arrays.toString(RegimeSinusoidale.circuitoRlSerie(Double.parseDouble(volt.getText()),
                                                                                        Double.parseDouble(resistenza.getText()),
                                                                                        Double.parseDouble(induttore.getText()), 
                                                                                        Double.parseDouble(frequenza.getText()))));
                    break;                                                                    
                default:
                    risultato.setText("Sos");
                    break;
            }
        }
    }
}
