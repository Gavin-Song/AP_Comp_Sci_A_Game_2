/**
 * Write a description of class BuildingFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BuildingFactory  
{
    private BuildingFactory() {}
    
    public static Building getBuilding(String type, Country country, int hp) {
        if ("air".equals(type)) {
            return new AirFactory(country, hp);
        }
        else if ("naval".equals(type)) {
            return new NavalFactory(country, hp);
        }
        else if ("radar".equals(type)) {
            return new Radar(country, hp);
        }
        else if ("silo".equals(type)) {
            return new Silo(country, hp);
        }
        throw new UnsupportedOperationException("Invalid Building type '" + type + "'");
    }
}
