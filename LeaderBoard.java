import greenfoot.*;
import java.util.*;

public class LeaderBoard extends Actor
{
    private ArrayList<TextLabel> labels;
    
    public LeaderBoard() {
        labels = new ArrayList<TextLabel>();
        for (Country country: MapWorld.getCountries()) {
            labels.add(new TextLabel(country.getName(), 30));
        }
    }
    
    public void act() {
    }
}
