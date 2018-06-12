import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class TitleScreenWorld extends World
{
    private TextLabel titleBox;
    private TextLabel playBox;
    private MapWorld mapWorld;
    /**
     * Constructor for objects of class TitleScreenWorld.
     * 
     */
    public TitleScreenWorld()
    {    
        super(1500, 806, 1); 
        getBackground().scale(getWidth(), getHeight());
        getBackground().setTransparency(50);
        titleBox = new TextLabel("Pretty much a copy of supreme commander", 30); 
        playBox = new TextLabel("Play", 20);
        mapWorld = new MapWorld();
        addObject(titleBox, getWidth() / 2, getHeight() / 4);
        addObject(playBox, getWidth() / 2, getHeight() / 2);
        titleBox.getImage().scale(400, 70);
        playBox.getImage().scale(150, 40);
        titleBox.displayText();
        playBox.displayText();        
    }
    public void act()
    {
        if(Greenfoot.mouseClicked(playBox))
        Greenfoot.setWorld(mapWorld);
            
        
    }
}
