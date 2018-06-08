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
    
    // Make constructor private so it can't be constructed
    private Config() {}
}