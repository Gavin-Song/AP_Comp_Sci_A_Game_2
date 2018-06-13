import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends Actor
{
    private int life = Config.EXPLOSION_LIFE;
    private double size = Config.EXPLOSION_SIZE;
    
    public Explosion() {
        this.getImage().scale((int)this.size, (int)this.size);
    }
    
    /**
     * Act - do whatever the Explosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        this.getImage().scale((int)this.size, (int)this.size);
        this.size += Config.EXPLOSION_SIZE_INC;
        
        this.life--;
        
        if (this.life <= 0) {
            this.getWorld().removeObject(this);
        }
    }    
}
