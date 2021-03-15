import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
public class FinestraSinusoide extends JFrame implements ActionListener {
    /**
     *
     */
    JLabel ResL= new JLabel("R");
    JLabel CapL= new JLabel("C");
    JLabel FreqL= new JLabel("f");
    JLabel InduL= new JLabel("L");
    JLabel VoltL= new JLabel("V");
    JTextField Res= new JTextField(4);
    JTextField Cap= new JTextField(4);
    JTextField Freq= new JTextField(4);
    JTextField Indu= new JTextField(4);
    JTextField Volt= new JTextField(4);
    private static final long serialVersionUID = 1L;
    JComboBox<String> tipo;
    JButton invia = new JButton("Comincia");
    JButton calcola = new JButton("calcola");
    JLabel risultato;
    JPanel testi = new JPanel();

    
    public FinestraSinusoide(){
        super("Sinusoidi");
        risultato = new JLabel();
        setSize(1000,800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
        String[] tipi = new String[]{"RC","RL","RLC"};
        tipo= new JComboBox<>(tipi);
        add(tipo,"North");
        tipo.setVisible(true);
        testi.add(ResL);
        testi.add(Res);
        testi.add(CapL);
        testi.add(Cap);
        testi.add(InduL);
        testi.add(Indu);
        testi.add(FreqL);
        testi.add(Freq);
        testi.add(VoltL);
        testi.add(Volt);
        add(testi,"Center");
        ResL.setVisible(false);
        Res.setVisible(false);
        CapL.setVisible(false);
        Cap.setVisible(false);
        FreqL.setVisible(false);
        Freq.setVisible(false);
        InduL.setVisible(false);
        Indu.setVisible(false);
        VoltL.setVisible(false);
        Volt.setVisible(false);
        calcola.setVisible(false);
        invia.addActionListener(new AscoltatoreMouse());
        add(risultato,"Center");
        calcola.addActionListener(this);
        add(calcola,"West");
        add(invia,"South");
        risultato.setVisible(false);
    }
    private class AscoltatoreMouse implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e) {
            int scelta =tipo.getSelectedIndex();
            calcola.setVisible(false);
            ResL.setVisible(true);
            Res.setVisible(true);
            /*switch(tipo.getSelectedIndex()){
                case 0: CapL.setVisible(true);
                        Cap.setVisible(true);
                        InduL.setVisible(false);
                        Indu.setVisible(false);
                case 1: CapL.setVisible(false);
                        Cap.setVisible(false);
                        InduL.setVisible(true);
                        Indu.setVisible(true);
                case 2: CapL.setVisible(true);
                        Cap.setVisible(true);
                        InduL.setVisible(true);
                        Indu.setVisible(true);
            }*/
            if(scelta==0){
                CapL.setVisible(true);
                Cap.setVisible(true);
                InduL.setVisible(false);
                Indu.setVisible(false); 
            }else if(scelta==1){
                CapL.setVisible(false);
                Cap.setVisible(false);
                InduL.setVisible(true);
                Indu.setVisible(true);
            }else{
                CapL.setVisible(true);
                Cap.setVisible(true);
                InduL.setVisible(true);
                Indu.setVisible(true);
            }
            FreqL.setVisible(true);
            Freq.setVisible(true);
            VoltL.setVisible(true);
            Volt.setVisible(true);
            invia.setVisible(false);
            calcola.setVisible(true);
            }
            
        }
    @Override
    public void actionPerformed(ActionEvent e) {
        int scelta =tipo.getSelectedIndex();
        testi.setVisible(false);
        invia.setVisible(true);
        calcola.setVisible(false);
        switch(scelta){
            case 0: 
                risultato.setText(Arrays.toString(RegimeSinusoidale.circuitoRcSerie(Double.parseDouble(Volt.getText()),Double.parseDouble(Res.getText()), Double.parseDouble(Cap.getText()), Double.parseDouble(Freq.getText()))));
                risultato.setVisible(true);
            case 1: 
                risultato.setText(Arrays.toString(RegimeSinusoidale.circuitoRlSerie(Double.parseDouble(Volt.getText()),Double.parseDouble(Res.getText()), Double.parseDouble(Indu.getText()), Double.parseDouble(Freq.getText()))));
                risultato.setVisible(true);
            case 2:
                risultato.setText(Arrays.toString(RegimeSinusoidale.circuitoRcSerie(Double.parseDouble(Volt.getText()),Double.parseDouble(Res.getText()), Double.parseDouble(Cap.getText()), Double.parseDouble(Freq.getText()))));
                risultato.setVisible(true);
        }
    }
}



