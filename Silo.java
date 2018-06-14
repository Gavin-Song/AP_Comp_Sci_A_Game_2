import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Silo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Silo extends Building
{
    private int missile_count = Config.SILO_MISSILE_COUNT;
    private int reload_counter = 0; // When it's 0 it can fire another missile
    
    public Silo(Country country, int hp){
        super(country, hp);
        getImage().scale(25,25);
    }
    
    public void act() {
        this.reload_counter--;
        if (this.reload_counter < 0)
            this.reload_counter = 0;
    }
    
    public void fire() {
        if (this.missile_count > 0) {
            Country target;
            do {
                target = Util.randomChoice(MapWorld.getCountries());
            } while (target.getName().equals(this.getCountry().getName()));
            
            try { 
                int[] target_loc = target.getStrategicTarget();
                if (target_loc == null)
                    return;
                    
                Missile missile = new Missile(target_loc[0], target_loc[1], this.getCountry());
                this.getWorld().addObject(missile, this.getX(), this.getY());
                
                this.missile_count--;
                this.reload_counter = Config.SILO_RELOAD_TIME;
            } catch (IllegalStateException e) {
                return;
            }
        }
    }
    
    public int getReloadTime() {
        return this.reload_counter;
    }
    
    public int getMissileCount() {
        return this.missile_count;
    }
}
