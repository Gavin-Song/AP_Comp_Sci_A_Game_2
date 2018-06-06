import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Country here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Country extends Actor
{
    private ArrayList<City> cities;
    private ArrayList<MobileUnit> units;
    
    private String name;
    private String flag;
    
    private HashMap building_count = new HashMap();

    public Country(String name, String flag) {
        this.cities = new ArrayList<City>();
        this.units = new ArrayList<MobileUnit>();
        
        this.name = name;
        this.flag = flag;
        
        building_count.put("naval", 3);
        building_count.put("air", 6);
        building_count.put("radar", 4);
        building_count.put("silo", 5);
    }
    
    public void addBuilding(String type, int x, int y) {
        if (WorldMap.getBackground().getColorAt(x, y)) {
            // Not in country territory
            return;
        }
        
        if ((Integer)building_count.get(type) - 1 < 0) {
            // Not enough of the building
            return;
        }
        
        Building to_add = BuildingFactory.getBuilding(type, this, x, y);
        this.getWorld().addObject(to_add, x, y);
        
        building_count.put(type, (Integer)building_count.get(type) - 1);
    }
}
