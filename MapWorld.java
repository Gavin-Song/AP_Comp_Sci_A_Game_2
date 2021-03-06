import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class MapWorld extends World
{
    // Hack make variables static so we can reference them
    // via MapWorld.variable
    private static ArrayList<Country> countries;
    
    // Only exists to get a reference to the world
    private static TextLabel world_ref;
    
    // Stage 1 stuff
    private static ArrayList<ImageButton> building_buttons;
    private static ArrayList<TextLabel> building_labels;
    private static TextLabel selected_building_label;
    private static String selected_building = "silo";
    
    private static GameState game_state;
    private int frames = 0;
    private LeaderBoard leaderboard;

    /**
     * Constructor for objects of class MapWorld.
     * 
     */
    public MapWorld()
    {    
        super(1500, 806, 1); 
        getBackground().scale(Config.WORLD_WIDTH, Config.WORLD_HEIGHT);

        // Create a game state
        game_state = new GameState();
        
        world_ref = new TextLabel("", 1);
        addObject(world_ref, -100, -100);

        // Add all the countries. Do not touch
        // Please indent when adding cities to avoid confusion and try to use real city names (location doesn't matter)
        countries = new ArrayList<Country>();
        countries.add(new Country("UFNAC", "", new Color(0, 108, 255)));
            countries.get(0).getCities().add(new City("Ottawa", 947031, countries.get(0), 219,178));
            addObject(countries.get(0).getCities().get(0), 219,178);
            countries.get(0).getCities().add(new City("DC", 693972, countries.get(0), 204,329));
            addObject(countries.get(0).getCities().get(1), 204,329);
            countries.get(0).getCities().add(new City("Mexico City", 8851000, countries.get(0), 322,267));
            addObject(countries.get(0).getCities().get(2), 322,267);
        countries.add(new Country("Eastern-European Union", "", new Color(176, 104, 0)));
            countries.get(1).getCities().add(new City("Nuuk", 17036, countries.get(0), 517,108));
            addObject(countries.get(1).getCities().get(0), 517,108);
            countries.get(1).getCities().add(new City("Berlin", 3470000, countries.get(0), 755,173));
            addObject(countries.get(1).getCities().get(1), 755,173);
            countries.get(1).getCities().add(new City("Kyiv", 2804000, countries.get(0), 831,189));
            addObject(countries.get(1).getCities().get(2), 831,189);
        countries.add(new Country("Second Soviet Union", "", new Color(255, 150, 0)));
            countries.get(2).getCities().add(new City("Moscow", 11920000, countries.get(0), 854,166));
            addObject(countries.get(2).getCities().get(0), 854,166);
            countries.get(2).getCities().add(new City("Astana", 814435, countries.get(0), 1011,187));
            addObject(countries.get(2).getCities().get(1), 1011,187);
            countries.get(2).getCities().add(new City("Krasnoyarsk", 1007000, countries.get(0), 1113,159));
            addObject(countries.get(2).getCities().get(2), 1113,159);
        countries.add(new Country("Greater Asian Coalition", "", new Color(255, 0, 0)));
            countries.get(3).getCities().add(new City("Beijing", 21710000, countries.get(0), 1220,249));
            addObject(countries.get(3).getCities().get(0), 1220,249);
            countries.get(3).getCities().add(new City("Seoul", 9860000, countries.get(0), 1282,257));
            addObject(countries.get(3).getCities().get(1), 1282,257);
            countries.get(3).getCities().add(new City("Tokyo", 9273000, countries.get(0), 1342,260));
            addObject(countries.get(3).getCities().get(2), 1342,260);
        countries.add(new Country("Brazil", "", new Color(0, 255, 42)));
            countries.get(4).getCities().add(new City("Rio de Janiero", 6320000, countries.get(4), 371,411));
            countries.get(4).getCities().add(new City("Sao Paulo", 12000000, countries.get(4), 425,493));
            countries.get(4).getCities().add(new City("Salvador", 2700000, countries.get(4), 461,541));
            addObject(countries.get(4).getCities().get(0), 371,411);
            addObject(countries.get(4).getCities().get(1), 425,493);
            addObject(countries.get(4).getCities().get(2), 461,541);
        countries.add(new Country("Arabian Empire", "", new Color(252, 255, 0)));
            countries.get(5).getCities().add(new City("Riydah", 21710000, countries.get(0), 923,309));
            addObject(countries.get(5).getCities().get(0), 923,309);
            countries.get(5).getCities().add(new City("Jerusalem", 9860000, countries.get(0), 866,285));
            addObject(countries.get(5).getCities().get(1), 866,285);
            countries.get(5).getCities().add(new City("Cairo", 9273000, countries.get(0), 841,294));
            addObject(countries.get(5).getCities().get(2), 841,294);
        /* Hack: we're adding countries but making them 1x1 pixels to not display them
         * that way countries have access to Actor class without being an actor
         */
        for (Country c: countries) {
            c.getImage().scale(1, 1);
            this.addObject(c, -10, -10);
        }
        
        // Image buttons for placing buildings
        building_buttons = new ArrayList<ImageButton>();
        building_buttons.add(new ImageButton("naval.png", Config.SQUARE_BUTTON_SIZE, Config.SQUARE_BUTTON_SIZE, "naval"));
        building_buttons.add(new ImageButton("air.png", Config.SQUARE_BUTTON_SIZE, Config.SQUARE_BUTTON_SIZE, "air"));
        building_buttons.add(new ImageButton("radar.png", Config.SQUARE_BUTTON_SIZE, Config.SQUARE_BUTTON_SIZE, "radar"));
        building_buttons.add(new ImageButton("silo.png", Config.SQUARE_BUTTON_SIZE, Config.SQUARE_BUTTON_SIZE, "silo"));
 
        // Text labels for placing buildings
        building_labels = new ArrayList<TextLabel>();
        building_labels.add(new TextLabel(String.valueOf(this.countries.get(0).getBuildingCount().get("naval")), 30));
        building_labels.add(new TextLabel(String.valueOf(this.countries.get(0).getBuildingCount().get("air")), 30));
        building_labels.add(new TextLabel(String.valueOf(this.countries.get(0).getBuildingCount().get("radar")), 30));
        building_labels.add(new TextLabel(String.valueOf(this.countries.get(0).getBuildingCount().get("silo")), 30));

        // Add buttons to the world
        int i = 0;
        for (ImageButton button: building_buttons) {
            this.addObject(button, (int)(Config.SQUARE_BUTTON_SIZE * 1.5 + i * Config.SQUARE_BUTTON_SIZE * 1.5), 
                (int)(this.getHeight() - Config.SQUARE_BUTTON_SIZE * 1.5));
            i++;
        }
        i = 0;
        for (TextLabel label: building_labels) {
            this.addObject(label, (int)(Config.SQUARE_BUTTON_SIZE * 1.5 + i * Config.SQUARE_BUTTON_SIZE * 1.5 + Config.SQUARE_BUTTON_SIZE / 2), 
                (int)(this.getHeight() - Config.SQUARE_BUTTON_SIZE * 0.75));
            i++;
        }
        selected_building_label = new TextLabel("Selected: Silo", 30);
        this.addObject(selected_building_label, (int)(Config.SQUARE_BUTTON_SIZE * 1.5 + Config.SQUARE_BUTTON_SIZE / 2), 
                (int)(this.getHeight() - Config.SQUARE_BUTTON_SIZE * 0.35));
     
        
        leaderboard = new LeaderBoard(150);
        addObject(leaderboard, Config.WORLD_WIDTH - 260, 70);
        
        this.setPaintOrder(GUI.class, LeaderBoard.class, Explosion.class, Missile.class, City.class, MilitaryUnit.class);
    }
    
    public void createPlayers(String name) {
        game_state.createHumanPlayer(name);
        game_state.createAIPlayers(name);
        for(AIPlayer ai : game_state.getAIPlayers())
        {
            ai.placeBuildings();
        }
    }
    
    public static World getWorldObj() {
        return world_ref.getWorld();
    }
    
    public void act() {
        MouseInfo mouse = Greenfoot.getMouseInfo();   
        if (mouse != null && mouse.getButton() == 1 && Greenfoot.mouseClicked(null)) {
            /* All mouse clicks are handled here
               Yay for code quality */
            
            switch (game_state.getStage()) {
                case 0: {
                    this.handleStage0Click(mouse);
                    break;
                }
                case 1: {
                    /* Stage 1 You can move your units that are made in factories */
                    break;
                }
                case 2: {
                    /* Stage 2 You can fire nukes and move units */
                    break;
                }
                default: {
                    // Game over
                    break;
                }
            }
        }
        
        switch (game_state.getStage()) {
            case 1: {
                game_state.doCountryMoves();
            }
        }
    }
    
    public void handleStage0Click(MouseInfo mouse) {
        /* Stage 0 You can add different buildings to your respective country */
        for (ImageButton button: building_buttons) {
            if (button.isClicked()) {
                selected_building = button.getName();
                break;
            }
        }
 
        game_state.getHumanPlayer().getCountry().addBuilding(selected_building, mouse.getX(), mouse.getY()); 
        this.updateAllLabels();
        
        if (game_state.getHumanPlayer().getCountry().noMoreBuildingsLeftToPlace()) {
            game_state.advanceStage();
        }
    }
    
    private void updateAllLabels() {
        building_labels.get(0).updateText(String.valueOf(game_state.getHumanPlayer().getCountry().getBuildingCount().get("naval")));
        building_labels.get(1).updateText(String.valueOf(game_state.getHumanPlayer().getCountry().getBuildingCount().get("air")));
        building_labels.get(2).updateText(String.valueOf(game_state.getHumanPlayer().getCountry().getBuildingCount().get("radar")));
        building_labels.get(3).updateText(String.valueOf(game_state.getHumanPlayer().getCountry().getBuildingCount().get("silo")));
        selected_building_label.updateText("Selected: " + selected_building.substring(0, 1).toUpperCase() + selected_building.substring(1));
    }
    
    public static void removeStage0LabelsAndButtons() {
        World world = getWorldObj();
        for (TextLabel label: building_labels) {
            world.removeObject(label);
        }
        for (ImageButton button: building_buttons) {
            world.removeObject(button);
        }
        world.removeObject(selected_building_label);
    }
    
    public static ArrayList<Country> getCountries() {
        return countries;
    }
    
    public static GameState getGameState() {
        return game_state;      
    }
    
    public Country getCountryByName(String name)
    {
        for(Country x: countries)
        {
            if(x.getName().equals(name))
                return(x);
        }
        return(null);
    }
}
