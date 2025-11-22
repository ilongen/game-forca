package game_word;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class wordProvider implements randomizer {
    // ESSA CLASSE JÁ CONSEGUE FAZER TODA RANDOMIZAÇÃO DA PALAVRA E SELECIONAR CONFORME DESEJADO
    // AGORA TERÁ QUE CRIAR A MANEIRA DE APRESENTAR A QUANTIDADE DE PALAVRAS
    // E DEIXAR COMO EXEMPLO: ______ = BATATA
    int maxNumber;
    final int minNumber = 0;
    ArrayList<String> words;
    int indexWord;
    String word;

    public String selectWord() {
        setWords();
        indexWord = getNumInRange(getMinNumber(), getMaxNumber());
        return getWords().get(indexWord);
    }

    public wordProvider() {
    word = selectWord();
    }
    public String getWord() {
        return word;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public ArrayList<String> getWords() {return words;}

    public int getMinNumber() {return minNumber;}

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public void setWords() {
        this.words = read(context());
    }

    private String context(){
        Scanner input = new Scanner(System.in);
        String name_file = null;
        System.out.println("Escolha um contexto para o jogo da forca");
        System.out.println("1- Anime");
        System.out.println("2- Filmes");
        System.out.println("3- Games");
        String choice = input.nextLine();
        name_file = switch (choice) {
            case "1" -> "anime.txt";
            case "2" -> "filmes.txt";
            case "3" -> "games.txt";
            default -> name_file;
        };
        return name_file;
    }
    private ArrayList<String> read(String name_file){
        final String path_folder = "src/game_word/";
        ArrayList<String> listWords = new ArrayList<>();
        try {
            FileReader file = new FileReader(path_folder + name_file);
            BufferedReader readFile = new BufferedReader(file);

            String row = readFile.readLine();

            while (row != null) {
                listWords.add(row);
                row = readFile.readLine();
            }
            setMaxNumber(listWords.size());
            return listWords;


        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
        return null;
    }
}
