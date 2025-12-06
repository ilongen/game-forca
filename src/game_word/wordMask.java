package game_word;

import java.util.Arrays;

public class wordMask extends wordProvider{

    // ESSA CLASSE É RESPONSAVEL POR PEGAR A PALAVRA SELECIONADA DE SUA HERANÇA
    // E MASCARAR ELA PRA FICAR INTUITIVO NO JOGO.

    // MÉTODOS TOTAL -> 4
    // M. PRIVADOS -> 0
    // M. PUBLICOS -> 4
    // -----------

    private final String word = getWord().toUpperCase();
    private final char[] mask;
    public wordMask(){
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