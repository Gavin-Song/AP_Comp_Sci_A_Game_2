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
    private ArrayList<Building> buildings;
    
    private String name;
    private String flag;
    
    private Color color;
    
    private HashMap building_count = new HashMap();

    public Country(String name, String flag, Color color) {
        this.cities = new ArrayList<City>();
        this.units = new ArrayList<MobileUnit>();
        this.buildings = new ArrayList<Building>();
        
        this.name = name;
        this.flag = flag;
        this.color = color;
        
        building_count.put("naval", 3);
        building_count.put("air", 6);
        building_count.put("radar", 4);
        building_count.put("silo", 5);
    }
    
    public HashMap getBuildingCount() {
        return building_count;
    }
    
    public ArrayList<City> getCities()
    {
        return(cities);
    }
    
    public Silo getNonEmptySilo() {
        for (Building building: this.buildings) {
            if (building instanceof Silo && ((Silo)(building)).getMissileCount() > 0) {
                return (Silo)building;
            }
        }
        return null;
    }
    
    public Silo getReadySilo() {
        for (Building building: this.buildings) {
            if (building instanceof Silo && ((Silo)(building)).getMissileCount() > 0
                && ((Silo)building).getReloadTime() == 0 ) {
                return (Silo)building;
            }
        }
        return null;
    }
    
    public void addBuilding(String type, int x, int y) {
        if (!this.getWorld().getBackground().getColorAt(x, y).equals(this.color)) {
            // Not in country territory
            return;
        }
        
        if ((Integer)building_count.get(type) - 1 < 0) {
            // Not enough of the building
            return;
        }
        
        Building to_add = BuildingFactory.getBuilding(type, this, 1000);
        this.getWorld().addObject(to_add, x, y);
        
        building_count.put(type, (Integer)building_count.get(type) - 1);
        this.buildings.add(to_add);
        System.out.println(x + "," + y); 
    }
    
    public boolean noMoreBuildingsLeftToPlace() {
        for (String type: Config.building_types) {
            if ((int)building_count.get(type) != 0) return false;
        }
        return true;
    }
    
    public String getNonEmptyBuilding() {
        for (String type: Config.building_types) {
            if ((int)building_count.get(type) > 0) {
                return type;
            }
        }
        return null;
    }
    
    public String getName() {
        return this.name;
    }
    
    /**
     * Returns the most strategic target in the country
     * as an int[]  { x, y }
     * or null if no target is found
     * 
     * Strategic targets are ranked as follows:
     * > Silos
     * > City with largest population, if population > 100K
     * > Production facilities
     * > Cities with population < 100K
     */
    public int[] getStrategicTarget() {
        int[] returned = {0, 0};
        
        Actor optimal_target = null;
        
        // Silos, Factories and ProductionFacilities are targets
        for (Building building: this.buildings) {
            if (building instanceof Silo ||
                building instanceof Factory ||
                building instanceof ProductionFacility) {
                optimal_target = building;
                break;
            }
        }
        
        // Find cities to nuke, override nukes targetted on factories and production
        if (optimal_target == null || !(optimal_target instanceof Silo) || Math.random() < 0.5) {    
            for (City city: this.cities) {
                if (optimal_target == null ||
                        city.getPopulation() > Config.TARGET_CITY_MIN_POPULATION || 
                        (!(optimal_target instanceof Factory) && city.getPopulation() > 0)) {
                    optimal_target = city;
                    break;
                }
            }
        }
        
        // No optimal target found
        if (optimal_target == null) {
            return null;
        }
        
        returned[0] = optimal_target.getX();
        returned[1] = optimal_target.getY();
        return returned;
    }
}
