import game_sticky.Sticki;
import game_word.consolePlayerInput;
import game_word.playerInputHandler;
import game_word.wordMask;

// MUDAR o nome da classe para corresponder ao arquivo
class Main { // REMOVIDO o 'public'
    public static void main(String[] args) {
        playerInputHandler input = new consolePlayerInput();
        wordMask mask = new wordMask();
        Sticki sticki = new Sticki();

        System.out.println("=== JOGO DA FORCA ===");

        while (!mask.isComplete() && !sticki.jogoAcabou()) {
            System.out.println("\n========================");
            sticki.desenharForca();
            System.out.println("Palavra: " + mask.getMaskedWord());
            System.out.println("Erros: " + sticki.getErros() + "/6");
            System.out.println("========================");

            char guess = input.getGuess();
            boolean hit = mask.guess(guess);

            if (hit) {
                System.out.println("✔ Acertou!");
            } else {
                System.out.println("✖ Errou!");
                sticki.adicionarParte();
            }
        }

        System.out.println("\n=== FIM DE JOGO ===");
        sticki.desenharForca();

        if (mask.isComplete()) {
            System.out.println("🎉 PARABÉNS! Você ganhou!");
        } else {
            System.out.println("💀 Game Over! Você perdeu.");
        }
        System.out.println("A palavra era: " + mask.getPalavraReal());
    }
}