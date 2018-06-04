import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class City extends Actor
{
    /* These variables are to be modified
     * to correctly correspond to the position
     * of the city relative to a world map
     */
    private static int MAP_X = 0;  // X shift relative to world map
    private static int MAP_Y = 0;  // Y shift relative to world map
    private static int MAP_SCALE = 1; // Scale shift relative to map
    
    private String name;
    private int population;
    private Country country;
    
    private int x;
    private int y;
    
    public City (String name, int population, Country country,
            int x, int y) {
       this.name = name;
       this.population = population;
       this.country = country;
       
       this.x = MAP_X + x * MAP_SCALE;
       this.y = MAP_Y + y * MAP_SCALE;
    }
    
    public void occupy (Country new_country) {
        this.country = new_country;
    }
    
    public void reducePopulation (int deaths) {
        this.population -= deaths;
    }
    
    
    public String getName() {
        return this.name;
    }
    
    public int getPopulation() {
        return this.population;
    }
    
    public Country getCountry() {
        return this.country;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
}
