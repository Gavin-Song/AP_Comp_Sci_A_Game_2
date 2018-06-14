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
        ai_players = new ArrayList<AIPlayer>();
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
    
    public void createAIPlayers(String country_name) {
        for (Country country: MapWorld.getCountries()) {
            if(!country.getName().equals(country_name))
                ai_players.add(new AIPlayer(country, 0));
        }
    }
    
    public Player getPlayerByCountry(String name) {
        if (human_player.getCountry().getName().equals(name)) 
            return human_player;
        for (AIPlayer player: this.ai_players) {
            if (player.getCountry().getName().equals(name)) {
                return player;
            }
        }
        return null;
    }
    
    public void doCountryMoves() {
        Silo silo;
        do {
            silo = human_player.getCountry().getReadySilo();
            if (silo == null || Math.random() < Config.DONT_FIRE_PROB) {
                break;
            }
            silo.fire();
        } while (true);
        
        silo = null;
        
        for (AIPlayer player: this.ai_players) {
            do {
                silo = player.getCountry().getReadySilo();
                if (silo == null || Math.random() < Config.DONT_FIRE_PROB) {
                    break;
                }
                silo.fire();
            } while (true);
        }
    }
    
    public ArrayList<AIPlayer> getAIPlayers()
    {
        return(ai_players);
    }
    
    public ArrayList<String> getLeaderboardData() {
        ArrayList<String> data = new ArrayList<String>();
        data.add(human_player.getCountry().getName() + ": " + human_player.getScore());
        
        for (AIPlayer player: this.ai_players) {
            data.add(player.getCountry().getName() + ": " + player.getScore());
        }
        
        data.sort((a, b) -> new Integer(b.split(": ")[1]).compareTo(new Integer(a.split(": ")[1])));
        return data;
    }
}
