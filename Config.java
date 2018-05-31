public class Config {
    /* 
     * General game config. Any specific config 
     * should go in a subclass of this.
     */
    public static final int WORLD_WIDTH = 1200;
    public static final int WORLD_HEIGHT = 800;
    
    // Make constructor private so it can't be constructed
    private Config() {}
}