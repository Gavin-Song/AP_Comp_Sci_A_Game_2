import java.util.*;

/**
 * Write a description of class AIPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AIPlayer extends Player 
{
    // instance variables - replace the example below with your own
    public AIPlayer(Country country, int score)
    {
        super(false, country, score);
    }
    public void placeBuildings()
    {
        HashMap count = this.getCountry().getBuildingCount();
        while((int) count.get("naval") > 0)
        {
            getCountry().addBuilding("naval", (int)(Math.random() * Config.WORLD_WIDTH),
            (int)(Math.random() * Config.WORLD_HEIGHT));
        }
        while((int) count.get("air") > 0)
        {
            getCountry().addBuilding("air", (int)(Math.random() * Config.WORLD_WIDTH),
            (int)(Math.random() * Config.WORLD_HEIGHT));
        }
        while((int) count.get("radar") > 0)
        {
            getCountry().addBuilding("radar", (int)(Math.random() * Config.WORLD_WIDTH),
            (int)(Math.random() * Config.WORLD_HEIGHT));
        }
        while((int) count.get("silo") > 0)
        {
            getCountry().addBuilding("silo", (int)(Math.random() * Config.WORLD_WIDTH),
            (int)(Math.random() * Config.WORLD_HEIGHT));
        }
    }
}
