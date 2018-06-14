import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class Missile extends MilitaryUnit
{
    private int target_x;
    private int target_y;
    
    public Missile(int tx, int ty, Country country) {
        super(country, 10000); // 10000 is random number, health doesn't matter for a missile

        this.target_x = tx;
        this.target_y = ty;
        
        this.getImage().scale(5, 15);
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
        this.setRotation(this.getRotation() - 90);
    }
    
    public void detonate() {
        // Spawn an explosion object
        Explosion boom = new Explosion();
        this.getWorld().addObject(boom, this.getX(), this.getY());
        
        // Destroy whatever is there
        List targetl = this.getWorld().getObjectsAt(this.target_x, this.target_y, Actor.class);
        if (targetl.size() == 0) return;
        Actor target = (Actor)targetl.get(0);
        
        Player to_destroy;
        try {
            to_destroy = MapWorld.getGameState().getPlayerByCountry(((City)(target)).getCountry().getName());
        } catch (ClassCastException e) {
            try {
                to_destroy = MapWorld.getGameState().getPlayerByCountry(((MilitaryUnit)(target)).getCountry().getName());
            } catch (ClassCastException e2) {
                return;
            }
        }
        
        Player self = MapWorld.getGameState().getPlayerByCountry(this.getCountry().getName());
        
        if (target instanceof Factory ||
            target instanceof Radar ||
            target instanceof ProductionFacility) {
                to_destroy.addScore(-Config.MILITARY_UNIT_VALUE);
                self.addScore(Config.MILITARY_UNIT_VALUE);
                
                this.getWorld().removeObject(target);
        }
        else if (target instanceof City) {
            int pop_damage = (int)(Config.NUKE_POPULATION_CITY * ((City)(target)).getPopulation());
            to_destroy.addScore(-pop_damage / 1000);
            self.addScore(pop_damage / 1000);
            
            ((City)target).reducePopulation(pop_damage);
        } else if (target instanceof Silo) {
            if (Math.random() < 0.2) {
                this.getWorld().removeObject(target);
            }
        }
        
        
        // Remove self from the world
        this.getWorld().removeObject(this);
    }
}
