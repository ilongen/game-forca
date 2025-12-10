package forcagame.word.mask;

import java.util.Arrays;

public class Mask {

    private final String word;
    private final char[] mask;

    public Mask(String word){
        this.word = word.toUpperCase();
        mask = new char[word.length()];
        Arrays.fill(mask, '_');
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ' ') {
                mask[i] = ' ';
            }
        }
    }

    public boolean guess(char c) {
        c = Character.toUpperCase(c);
        boolean hit = false;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == c) {
                mask[i] = c;
                hit = true;
            }
        }
        return hit;
    }

    public String getMaskedWord() {
        return new String(mask);
    }

    public boolean isComplete() {
        return !new String(mask).contains("_");
    }
}