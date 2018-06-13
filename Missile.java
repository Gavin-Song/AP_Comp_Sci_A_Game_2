import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Missile extends MilitaryUnit
{
    private int target_x;
    private int target_y;
    
    public Missile(int tx, int ty, Country country) {
        super(country, 10000); // 10000 is random number, health doesn't matter for a missile

        this.target_x = tx;
        this.target_y = ty;
    }       
    
    public void act() {
        // "Close enough" to fire
        if (Util.getDistance(this.getX(), this.getY(), this.target_x, this.target_y) 
                < Config.MISSILE_MIN_RANGE) {
             this.detonate();
             return;
        }
        
        // Progress towards the target
        this.turnTowards(target_x, target_y);
        this.setLocation(
            (int)(this.getX() + Config.MISSILE_SPEED * Math.cos(Util.degToRad(this.getRotation()))),
            (int)(this.getY() + Config.MISSILE_SPEED * Math.sin(Util.degToRad(this.getRotation())))
        );
    }
    
    public void detonate() {
        // Spawn an explosion object
        Explosion boom = new Explosion();
        this.getWorld().addObject(boom, this.getX(), this.getY());
        
        // Remove self from the world
        this.getWorld().removeObject(this);
    }
}
