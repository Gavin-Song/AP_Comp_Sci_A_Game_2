/**
 * Write a description of class BuildingFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BuildingFactory  
{
    private BuildingFactory() {}
    
    public static Building getBuilding(String type, Country country, int x, int y) {
        if ("air".equals(type)) {
            return new AirFactory(country, x, y);
        }
        else if ("naval".equals(type)) {
            return new NavalFactory(country, x, y);
        }
        else if ("radar".equals(type)) {
            return new Radar(country, x, y);
        }
        else if ("silo".equals(type)) {
            return new Silo(country, x, y);
        }
        throw new UnsupportedOperationException("Invalid Building type '" + type + "'");
    }
}
