/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Player  
{
    // instance variables - replace the example below with your own
    private boolean isHuman;
    private Country country;
    private int score;
    public Player(boolean human, Country country, int score)
    {
        this.isHuman = human;
        this.country = country;
        this.score = score;
    }
    public Country getCountry() {
        return country;
    }
}
