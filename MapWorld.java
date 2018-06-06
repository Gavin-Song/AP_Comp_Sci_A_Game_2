import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MapWorld extends World
{
    private WorldMap map;
    /**
     * Constructor for objects of class MapWorld.
     * 
     */
    public MapWorld()
    {    
        super(1500, 806, 1); 
        getBackground().scale(Config.WORLD_WIDTH, Config.WORLD_HEIGHT);
        map = new WorldMap();
        addObject(map, getWidth()/2, getHeight()/2);
    }
}
