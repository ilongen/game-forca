import forcagame.sticky.paint.Sticki;
import forcagame.player.PlayerInputConsole;
import forcagame.player.PlayerInputHandler;
import forcagame.word.mask.Mask;

// Método responsável por execução de todo ecossistema do jogo.
void main() {
        PlayerInputHandler input = new PlayerInputConsole();
        Mask mask = new Mask();
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
        System.out.println("A palavra era: " + mask.getWord());
    }