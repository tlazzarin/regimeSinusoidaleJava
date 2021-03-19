import javax.swing.*;
import java.awt.*;

public class FinestraToma extends JFrame{

    public FinestraToma(){
        super("Calcolatore circuiti a regime sinusoidale");
        setMinimumSize(new Dimension(800,200));
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(2,6));
        JTextField risultato = new JTextField();
        risultato.setEditable(false);
        Impostazioni imp = new Impostazioni(risultato);
        add(imp, "North");
        add(risultato,"South");
        setVisible(true);
    }
}
