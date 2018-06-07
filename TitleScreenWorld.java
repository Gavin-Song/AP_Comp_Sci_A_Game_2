import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class TitleScreenWorld extends World
{
    private TextLabel titleBox;
    private TextLabel playBox;
    /**
     * Constructor for objects of class TitleScreenWorld.
     * 
     */
    public TitleScreenWorld()
    {    
        super(1500, 806, 1); 
        getBackground().scale(getWidth(), getHeight());
        getBackground().setTransparency(50);
        titleBox = new TextLabel("Pretty much a copy of supreme commander"); 
        playBox = new TextLabel("Play");
        addObject(titleBox, getWidth() / 2, getHeight() / 4);
        addObject(playBox, getWidth() / 2, getHeight() / 2);
        titleBox.getImage().scale(400, 70);
        playBox.getImage().scale(150, 40);
        titleBox.displayText();
        playBox.displayText();        
    }
}
