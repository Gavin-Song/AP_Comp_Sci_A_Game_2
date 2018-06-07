import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class MapWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MapWorld extends World
{
    private ArrayList<Country> countries;
    
    /**
     * Constructor for objects of class MapWorld.
     * 
     */
    public MapWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1500, 806, 1); 
        getBackground().scale(Config.WORLD_WIDTH, Config.WORLD_HEIGHT);

        // Add all the countries. Do not touch
        countries = new ArrayList<Country>();
        countries.add(new Country("UFNAC", "", new Color(0, 108, 255)));
        countries.add(new Country("Eastern-European Union", "", new Color(176, 104, 0)));
        countries.add(new Country("Second Soviet Union", "", new Color(255, 150, 0)));
        countries.add(new Country("Greater Asian Coalition", "", new Color(255, 0, 0)));
        countries.add(new Country("Brazil", "", new Color(0, 255, 42)));
        countries.add(new Country("Arabian Empire", "", new Color(252, 255, 0)));
        
        /* Hack: we're adding countries but making them 1x1 pixels to not display them
         * that way countries have access to Actor class without being an actor
         */
        for (Country c: countries) {
            c.getImage().scale(1, 1);
            addObject(c, -10, -10);
        }
        
    }
    
    public void act() {
        MouseInfo mouse = Greenfoot.getMouseInfo();   
        if (mouse != null && mouse.getButton() == 1 && Greenfoot.mouseClicked(null)) {
            for (Country country: countries) {
                country.addBuilding("silo", mouse.getX(), mouse.getY());
            }
        }
    }
}
