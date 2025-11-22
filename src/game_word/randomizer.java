package game_word;
import java.util.Random;
public class randomizer{

    public int getNumInRange(int min,int max){
        Random rand = new Random();
        return rand.nextInt(max-min+1)+min;
    }
}
