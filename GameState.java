import java.util.*;
import greenfoot.*;

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
    
    private HumanPlayer human_player;
    private ArrayList<AIPlayer> ai_players;
    
    public GameState() {

    }
    
    public int getStage() {
        return this.stage;
    }
    
    public void advanceStage() {
        if (this.stage == 0) {
            // Remove building buttons from world
            MapWorld.removeStage0LabelsAndButtons();
        }
        this.stage++;
    }
    
    public HumanPlayer getHumanPlayer() {
        return human_player;
    }
    
    public void createHumanPlayer(String country_name) {
        for (Country country: MapWorld.getCountries()) {
            if (country.getName().equals(country_name)) {
                human_player = new HumanPlayer(country, 0);
                break;
            }
        }
    }
}
