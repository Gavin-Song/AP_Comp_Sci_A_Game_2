/**
 * Handles the current state of the game
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameState  
{
    /*
     * Stage 0: Construction
     * Stage 1: Make units
     * Stage 2: Fire nukes
     */
    private int stage = 0;
    
    public GameState() {
        // Nothing goes here
    }
    
    public int getStage() {
        return this.stage;
    }
    
    public void advanceStage() {
        this.stage++;
    }
}
