package forcagame.word.mask;

import forcagame.word.provider.Provider;

import java.util.Arrays;

public class Mask extends Provider {

    // ESSA CLASSE É RESPONSAVEL POR PEGAR A PALAVRA SELECIONADA DA SUA HERANÇA
    // E MASCARAR ELA PARA FICAR INTUITIVO NO JOGO.

    // MÉTODOS TOTAL -> 4
    // M. PRIVADOS -> 0
    // M. PUBLICOS -> 4
    // -----------

    // PEGA A PALAVRA QUE VEM DIRETAMENTE DO wordProvider
    private final String word = getWord().toUpperCase();
    private final char[] mask;
    // CONSTRUTOR QUE DETERMINA A MÁSCARA E FAZ TODA A MODIFICAÇÃO PARA FICAR APENAS O TAMANHO DAS LETRAS.
    public Mask(){
        mask = new char[word.length()];
        Arrays.fill(mask, '_');
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ' ') {
                mask[i] = ' ';
            }
        }
    }
    // VALIDA ENTRADA DO USUÁRIO E VEJA SE ELE CONSEGUE ADIVINHAR A LETRA PERTECENTE A PALAVRA.
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
    // CASO COMPLETAR RETORNA SEM AS MASCARÁS.
    public boolean isComplete() {
        return !new String(mask).contains("_");
    }
}