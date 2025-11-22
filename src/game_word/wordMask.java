package game_word;

import java.util.Arrays;

public class wordMask extends wordProvider{

    @Override
    public String selectWord() {
        return super.selectWord();
    }

    private final String word = getWord();
    private final char[] mask;
    public wordMask(){
        mask = new char[this.word.length()];
        Arrays.fill(mask, '_');
        for (int i = 0; i < this.word.length(); i++) {
            if (this.word.charAt(i) == ' ') {
                mask[i] = ' ';
            }
        }

        System.out.println(mask);
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
