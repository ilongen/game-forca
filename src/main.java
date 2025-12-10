import forcagame.sticky.paint.Sticky;
import forcagame.player.PlayerInputConsole;
import forcagame.word.provider.Provider;
import forcagame.word.mask.Mask;

void main() {
        PlayerInputConsole input = new PlayerInputConsole();
        String category = input.chooseCategory();
        Provider provider = new Provider(category);
        String word = provider.getWord();
        Mask mask = new Mask(word);
        Sticky sticky = new Sticky();

        System.out.println("=== JOGO DA FORCA ===");

        while (!mask.isComplete() && !sticky.endGame()) {
            System.out.println("\n========================");
            sticky.desenharForca();
            System.out.println("Palavra: " + mask.getMaskedWord());
            System.out.println("Erros: " + sticky.getCountError() + "/6");
            System.out.println("========================");

            char guess = input.getGuess();
            boolean hit = mask.guess(guess);

            if (hit) {
                System.out.println("✔ Acertou!");
            } else {
                System.out.println("✖ Errou!");
                sticky.adicionarParte();
            }
        }

        System.out.println("\n=== FIM DE JOGO ===");
        sticky.desenharForca();

        if (mask.isComplete()) {
            System.out.println("🎉 PARABÉNS! Você ganhou!");
        } else {
            System.out.println("💀 Game Over! Você perdeu.");
        }
        System.out.println("A palavra era: " + provider.getWord());
    }