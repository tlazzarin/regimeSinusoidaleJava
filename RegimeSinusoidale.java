import java.math.BigDecimal;
import java.util.Random;
import java.math.RoundingMode;

public class RegimeSinusoidale{
    public static final char OMEGA='\u2126';
    public static final Random rand = new Random();
    /**
     * Metodo che ritorna la corrente e lo sfasamento di un circuito RC serie
     * @return [XC, |Z|, I, Sfasamento]
     */
    public static String[] circuitoRCSerie(double volt, double r, double c, double f){
        String[] supp = circuitoRLCSerie(volt, r, 0, c, f);
        String[] stringa = new String[4];
        stringa[0]=supp[0];
        stringa[1]=supp[2];
        stringa[2]=supp[3];
        stringa[3]=supp[4];
        return stringa;
    }

    /**
     * Metodo che ritorna la corrente e lo sfasamento di un circuito RL serie
     * @param volt voltaggio
     * @param r la resistenza
     * @param l l'induttanza
     * @param f la frequenza
     * @return [XL, |Z|, I, Sfasamento]
     */
    public static String[] circuitoRLSerie(double volt, double r, double l, double f){
        String[] supp = circuitoRLCSerie(volt, r, l, 0, f);
        String[] stringa = new String[4];
        stringa[0]=supp[1];
        stringa[1]=supp[2];
        stringa[2]=supp[3];
        stringa[3]=supp[4];
        return stringa;
    }

    /**
     * 
     * @return [V, R, C, L, f]
     */
    public static String[] generaValori(){
        String[] out = new String[5];
        out[0]="V = "+rand.nextInt(40)+"V";
        out[1]="R = "+rand.nextInt(3000)+OMEGA;
        out[2]="C = "+(round(rand.nextInt(400),1)*10E-9)+"F";
        out[3]="L = "+(round(rand.nextInt(400),1)*10E-9)+"H";
        out[4]="f = "+rand.nextInt(100)*10E1+"Hz";
        return out;
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
    
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    /**
     * funzione che ritorna il valore efficace e l'intensità di picco di un condensatore a regime sinusoidale
     * @param v voltaggio
     * @param c capacità del condensatore
     * @param f frequenza della sinusoide
     * @return [valoreEfficace, valoreDiPicco]
     */
    public static String[] valoreEfficaceC(double v, double c, double f){
        String[] out = new String[2];
        out[0] = circuitoRCSerie(v, 0, c, f)[2];
        out[1] = "IP = "+(Double.parseDouble(out[0].substring(5,out[0].length()-1)) * Math.sqrt(2));
        return out;
    }

    public static double pulsazione(double f){
        return 2*Math.PI*f;
    }

    /**
     * Metodo che ritorna la corrente e lo sfasamento di un circuito RLC serie
     * @param volt voltaggio
     * @param r la resistenza
     * @param l l'induttanza
     * @param c capacità condensatore
     * @param f la frequenza
     * @return [XC, XL, |Z|, I, Sfasamento]
     */
    public static String[] circuitoRLCSerie(double volt, double r, double l, double c, double f){
        double[] temp = new double[5];
        temp[0]=1/(pulsazione(f)*c);
        temp[1]=pulsazione(f)*l;
        temp[2]=Math.sqrt(Math.pow(r, 2)+Math.pow(temp[1]-temp[0], 2));
        temp[3]=volt/temp[2];
        temp[4]=Math.toDegrees(Math.atan((temp[1]-temp[0])/r));
        String[] out = new String[5];
        out[0]="XC = "+temp[0]+OMEGA;
        out[1]="XL = "+temp[1]+OMEGA;
        out[2]="|Z| = "+temp[2]+OMEGA;
        out[3]="I = "+temp[3]+"A";
        out[4]="\u03C6 = "+temp[4]+"°";
        return out;
    }
}
