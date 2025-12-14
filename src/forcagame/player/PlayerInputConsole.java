package forcagame.player;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayerInputConsole implements PlayerInputHandler {

    private final Scanner scanner = new Scanner(System.in);
    ArrayList<String> charAttempts = new ArrayList<>();

    @Override
    public String getNameFile() {
        String name_file;

        System.out.println("Escolha um contexto para o jogo da forca");
        System.out.println("1- Anime");
        System.out.println("2- Filmes");
        System.out.println("3- Games");


        int choice;
        while (true) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= 3){
                    break;
                }
                System.out.println("Inseriu um valor fora do intervalo, tente novamente.");
            } else {
                System.out.println("Inseriu um valor inválido, tente novamente.");
                scanner.nextLine();
            }
        }

        try {
            name_file = switch (choice) {
                case 1 -> "anime.txt";
                case 2 -> "filmes.txt";
                case 3 -> "games.txt";
                default -> null;
            };

        } catch (NullPointerException e) {
            throw new RuntimeException(e);
        }
        return name_file;
    }

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
        if (!input.matches("[\\w-]+")) {
            System.out.println("Digite apenas letras!");
            continue;
        }
        charAttempts.add(input.toUpperCase());
        return input.toUpperCase().charAt(0);
        }
    }

}
