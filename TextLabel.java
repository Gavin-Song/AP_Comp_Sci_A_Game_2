import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class TextLabel extends GUI
{
<<<<<<< HEAD
    //<<<<<<< HEAD
=======
>>>>>>> 5a0b203e0833cd9c71b0d432c5df755ccf9e40ab
    private String text;
    private int h;
    private Font font;
    private GreenfootImage image;
    
    //TODO make image transparnet
    public TextLabel(String txt, int h) {
        this.text = txt;
        this.h = h;
        
        image = new GreenfootImage(this.getImage());
        this.setImage(image);
        this.getImage().scale(txt.length * 5 + 40, h);
        //etImage().setTransparency(0);
        
        this.font = new Font(h / 2);
        this.image = this.getImage();
    }
    
<<<<<<< HEAD
    //=======
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
    //>>>>>>> title-screen
=======
>>>>>>> 5a0b203e0833cd9c71b0d432c5df755ccf9e40ab
    public void act() 
    {
        GreenfootImage img = new GreenfootImage(image);
        this.setImage(img);
        img = this.getImage();
        
        System.out.println(this.text);
        img.setFont(font);
        img.setColor(Color.BLACK);
        img.drawString(this.text, 8, this.h / 2 + 4);
    }    
    
    public void updateText(String s) {
        this.text = s;
    }
}
