package game_word;
import java.util.Random;
public interface randomizer{

     default int getNumInRange(int min, int max){
        Random rand = new Random();
        return rand.nextInt(max-min+1)+min;
    }
}
