import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class TextLabel extends GUI
{
    String text;
    public TextLabel(String a)
    {
        text = a;
    }
    public void displayText()
    {
        getImage().drawString(text, 70, getImage().getHeight() / 2);
    }
    /**
     * Act - do whatever the TextLabel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
