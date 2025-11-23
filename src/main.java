import game_word.*;
void main(){
    playerInputHandler input = new consolePlayerInput();
    wordMask mask = new wordMask();

    while (!mask.isComplete()) {
        System.out.println("\n==== JOGO DA FORCA =====");
        System.out.println("Palavra: " + mask.getMaskedWord());
        System.out.println("========================");

        char guess = input.getGuess();
        boolean hit = mask.guess(guess);

        System.out.println(hit ? "✔ Acertou!" : "✖ Errou!");
    }

}