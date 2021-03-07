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
    public static String[] circuitoRc(double volt, double r, double c, double f){
        double[] out = new double[4];
        out[0] = 1/(Math.PI*2*f*c);
        out[1] = Math.sqrt(Math.pow(r,2)+Math.pow(out[0], 2));
        out[2] = volt/out[1];
        out[3] = Math.toDegrees(Math.atan(-out[0]/r));
        String[] stringa = new String[4];
        stringa[0]="XC = "+out[0]+OMEGA;
        stringa[1]="|Z| = "+out[1]+OMEGA;
        stringa[2]="I = "+out[2]+"A";
        stringa[3]="\u03C6 = "+out[3]+"°";
        return stringa;
    }

    /**
     * Metodo che ritorna la corrente e lo sfasamento di un circuito RL serie
     * @return [XL, |Z|, I, Sfasamento]
     */
    public String[] circuitoRl(double volt, double r, double l, double f){
        double[] out = new double[4];
        out[0] = Math.PI*2*f*l;
        out[1] = Math.sqrt(Math.pow(r,2)+Math.pow(out[0], 2));
        out[2] = volt/out[1];
        out[3] = Math.toDegrees(Math.atan(out[0]/r));
        String[] stringa = new String[4];
        stringa[0]="XL = "+out[0]+OMEGA;
        stringa[1]="|Z| = "+out[1]+OMEGA;
        stringa[2]="I = "+out[2]+"A";
        stringa[3]="\u03C6 = "+out[3]+"°";
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
}
