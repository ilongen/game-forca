package forcagame.player;

import java.util.Scanner;

public interface PlayerChooseCategory {
    Scanner input = new Scanner(System.in);
    default String chooseCategory() {
        String name_file;
        System.out.println("Escolha um contexto para o jogo da forca");
        System.out.println("1- Anime");
        System.out.println("2- Filmes");
        System.out.println("3- Games");
        String choice = input.nextLine();
        name_file = switch (choice) {
            case "1" -> "anime.txt";
            case "2" -> "filmes.txt";
            case "3" -> "games.txt";
            default -> null;
        };
        return name_file;
    }
}
