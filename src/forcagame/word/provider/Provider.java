package forcagame.word.provider;

import forcagame.word.random.Randomizer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 * <h3>Classname: Provider</h1>
 * <h4>Version: 1.0</h2>
 * <p>Describe: It receives a list of words in txt format, shuffles them, and randomly selects one word.</p>
 *
 * <b><i>Author: Ilongen</i></b>
 */
public class Provider implements Randomizer {

    int maxNumber, indexWord;
    static final int MIN_NUMBER = 0;
    ArrayList<String> words;
    String word;
    static final String PATH_FOLDER = "src/forcagame/word/list/";

    public String selectWord() {
        indexWord = getNumInRange(getMIN_NUMBER(), getMaxNumber());
        return getWords().get(indexWord);
    }

    public Provider(String category) {
        this.words = readingWords(category);
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



    private ArrayList<String> readingWords(String name_file) {
        ArrayList<String> listWords = new ArrayList<>();
        try {
            FileReader file = new FileReader(PATH_FOLDER + name_file);
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
