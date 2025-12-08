package forcagame.word.random;
import java.util.Random;
public interface Randomizer {

     default int getNumInRange(int min, int max){
        Random rand = new Random();
        return rand.nextInt(max-min+1)+min;
    }
}
