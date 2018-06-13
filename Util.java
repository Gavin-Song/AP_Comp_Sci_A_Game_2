import java.util.*;

public class Util  
{
    private Util() {}
    
    public static int getDistance(int x1, int y1, int x2, int y2) {
        int a = x1 - x2;
        int b = y1 - y2;
        return (int)Math.sqrt(a * a + b * b);
    }
    
    public static double degToRad(int deg) {
        return 0.0174533 * deg;
    }
    
    public static Country randomChoice(ArrayList<Country> countries) {
        return countries.get((int)(Math.random() * countries.size()));
    }
}
