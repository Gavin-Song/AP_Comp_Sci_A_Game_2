import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
public class TitleScreenWorld extends World
{
    private PrettyTextLabel titleBox;
    private PrettyTextLabel playBox;
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
        titleBox = new PrettyTextLabel("Pretty much a copy of supreme commander", 40); 
        playBox = new PrettyTextLabel("Play", 30);
        
        titleBox.setImage("textbox.png");
        playBox.setImage("textbox.png");
        countries = new ArrayList<TextLabel>();

        mapWorld = new MapWorld();
        for(Country x: mapWorld.getCountries())
        {
            countries.add(new TextLabel(x.getName(), 40));
        }
        addObject(titleBox, getWidth() / 2, getHeight() / 4);
        addObject(playBox, getWidth() / 2, getHeight() / 2);
        titleBox.getImage().scale(400, 70);
        playBox.getImage().scale(150, 40);    
        
        
        // Credits
        TextLabel label = new TextLabel("Credits: Gavin Song, Alex Kim, Daniel Drata | Nuclear War Gambling Game | Pick a country! | Place down buildings! | Click on the country name not the flag!", 20);
        label.setFontSize(15);
        addObject(label, getWidth() * 3 / 4, getHeight() * 3 /4);
        
        this.setPaintOrder(GUI.class, LeaderBoard.class, Explosion.class, Missile.class, City.class, MilitaryUnit.class);
    }
    public void act()
    {
        if(Greenfoot.mouseClicked(playBox))
        {
            int a = mapWorld.getWidth() / (countries.size() + 2) ; 
            int b = a;
            a *= 1.2;
            int c = mapWorld.getHeight() / 2;
            removeObject(playBox);
            removeObject(titleBox);
            for(TextLabel x: countries)
            {
               Actor flag = new ImageButton(x.getText() + ".jpg", (int)a, (int)(a * 0.7), x.getText());
               addObject(flag, b, c + 100);
                
               addObject(x, b, c); 
               b += a; 
            }
        }
        
        try {
            for(TextLabel x: countries) {
                if (Greenfoot.mouseClicked(x)) {
                    mapWorld.createPlayers(x.getText());
                    Greenfoot.setWorld(mapWorld);
                }
            }
        } catch(Exception e) { // It's the last day rip code quality
            // Do nothing :D :D
        }        
    }
}
