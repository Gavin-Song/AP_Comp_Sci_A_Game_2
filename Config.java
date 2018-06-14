public class Config {
    /* 
     * General game config. Any specific config 
     * should go in a subclass of this.
     */
    public static final int WORLD_WIDTH = 1500;
    public static final int WORLD_HEIGHT = 806;
    
    public static final int SQUARE_BUTTON_SIZE = 50;
    
    public static final String[] building_types = {
        "naval", "air", "silo", "radar"
    };
    
    // Missiles per silo, starting
    public static final int SILO_MISSILE_COUNT = 20;
    // Number of frames to reload the silo
    public static final int SILO_RELOAD_TIME = 150;
    // Min population for a city to be a primary target
    public static final int TARGET_CITY_MIN_POPULATION = 100000;
    // "Close enough" range for a missile to detonate
    public static final int MISSILE_MIN_RANGE = 10;
    // Speed of missile
    public static final int MISSILE_SPEED = 10;
    
    // Frames for explosion to last
    public static final int EXPLOSION_LIFE = 80;
    // Explosion size (starting)
    public static final int EXPLOSION_SIZE = 10;
    // Explosion size adder
    public static final double EXPLOSION_SIZE_INC = 0.5;
    
    // Odds a silo won't fire, to avoid all silos firing at the same time
    public static final double DONT_FIRE_PROB = 0.95;
    
    // Reduction of population per nuke in a city
    public static final double NUKE_POPULATION_CITY = 0.87;
    
    
    // Military unit score value
    public static final int MILITARY_UNIT_VALUE = 1000;
    
    // Make constructor private so it can't be constructed
    private Config() {}
}