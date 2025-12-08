package forcagame.word.player;

import java.util.ArrayList;
import java.util.Scanner;

public class ConPlayerInput implements PlayerInputHandler {
    private final Scanner scanner = new Scanner(System.in);
    ArrayList<String> charAttempts = new ArrayList<>();
    @Override
    public char getGuess() {
        while (true) {
        System.out.println("Letras que você chutou:"+charAttempts);
        System.out.print("Qual letra você irá chutar?: ");
        String input = scanner.nextLine();
        if (input.length() > 1) {
            System.out.println("Digite apenas UMA letra! Nada de palavras.");
            continue;
        }
        if (!input.matches("[a-zA-Z]+")) {
            System.out.println("Digite apenas letras!");
            continue;
        }
        charAttempts.add(input.toUpperCase());
        return input.toUpperCase().charAt(0);
        }
    }

}
