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
    private GameState game_state;
    
    /**
     * Constructor for objects of class MapWorld.
     * 
     */
    public MapWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1500, 806, 1); 
        getBackground().scale(Config.WORLD_WIDTH, Config.WORLD_HEIGHT);

        // Create a game state
        game_state = new GameState();

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
            /* All mouse clicks are handled here
               Yay for code quality */
            
            switch (game_state.getStage()) {
                case 0: {
                    /* Stage 0 You can add different buildings to your respective country */
                    for (Country country: countries) {
                        country.addBuilding("silo", mouse.getX(), mouse.getY());
                    }
                    break;
                }
                case 1: {
                    /* Stage 1 You can move your units that are made in factories */
                    break;
                }
                case 2: {
                    /* Stage 2 You can fire nukes and move units */
                    break;
                }
                default: {
                    // Game over
                    break;
                }
            }
        }
    }
}
