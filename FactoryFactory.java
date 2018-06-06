/**
 * Write a description of class FactoryFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FactoryFactory  
{
    private FactoryFactory() {}
    
    public static Factory getFactory(String type, Country country, int x, int y) {
        if ("air".equals(type)) {
            return new AirFactory(country, x, y);
        }
        else if ("naval".equals(type)) {
            return new NavalFactory(country, x, y);
        }
        throw new UnsupportedOperationException("Invalid Factory type '" + type + "'");
    }
}
