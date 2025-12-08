package forcagame.word.provider;

import forcagame.word.random.Randomizer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
  * <b>Class name: Provider</b><br>
  * Describe: LER LISTA DE PALAVRAS TXT, RANDOMIZAR E SELECIONAR PALAVRA PARA O JOGO.
 * <br>
  * Date: 08.12.2025 : 15:11
 * <br>
  * Author: Ilongen
 */
public class Provider implements Randomizer {

    int maxNumber, indexWord;
    final int MIN_NUMBER = 0;
    ArrayList<String> words;
    String word;

    public String selectWord() {
        setWords();
        indexWord = getNumInRange(getMIN_NUMBER(), getMaxNumber());
        return getWords().get(indexWord);
    }

    public Provider() {
        word = selectWord();
    }

    public String getWord() {
        return word;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public int getMIN_NUMBER() {
        return MIN_NUMBER;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public void setWords() {
        this.words = read(context());
    }

    private String context() {
        Scanner input = new Scanner(System.in);
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

    private ArrayList<String> read(String name_file) {
        final String path_folder = "src/forcagame/word/list/";
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
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }
        return null;
    }
}
