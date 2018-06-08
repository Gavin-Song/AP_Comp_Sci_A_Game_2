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
<<<<<<< HEAD
    public Country getCountry()
    {
        return(country);
=======
    
    public Country getCountry() {
        return country;
>>>>>>> 46146b4dab4ae55545a2ef8d5946707a295ac317
    }
}
