import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
public class TitleScreenWorld extends World
{
    private TextLabel titleBox;
    private TextLabel playBox;
    private MapWorld mapWorld;
    private ArrayList<TextLabel> countries; 
    
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
        
        titleBox.setImage("textbox.png");
        playBox.setImage("textbox.png");

        mapWorld = new MapWorld();
        for(Country x: mapWorld.getCountries())
        {
            countries.add(new TextLabel(x.getName(), 20));
        }
        addObject(titleBox, getWidth() / 2, getHeight() / 4);
        addObject(playBox, getWidth() / 2, getHeight() / 2);
        titleBox.getImage().scale(400, 70);
        playBox.getImage().scale(150, 40);    
    }
    public void act()
    {
        if(Greenfoot.mouseClicked(playBox))
        {
            int a = mapWorld.getWidth() / (countries.size() + 2) ; 
            int b = a;
            int c = mapWorld.getHeight() / 2;
            removeObject(playBox);
            removeObject(titleBox);
            for(TextLabel x: countries)
            {
               addObject(x, c, b); 
               b += a; 
            }
        }
        //Greenfoot.setWorld(mapWorld);
            
        
    }
}
