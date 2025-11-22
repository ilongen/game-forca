package game_word;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class word {
    // ESSA CLASSE ELA TRABALHA TODA OPERAÇÃO COM A PALAVRA
    // DESDE A LISTAGEM DO MÁXIMO NUMERO PRA ELE RANDOMIZAR
    // QUANTO A SELEÇÃO DAS PALAVRAS/LEITURA DO ARQUIVO
    // PRÓXIMA AÇÃO AGORA É RANDOMIZAR O NÚMERO E O QUE ELE SABER ID DA PALAVRA
    // SALVAR PRA FAZER A SEPARAÇÃO DE LETRAS
    int maxNumber;
    ArrayList<String> words;

    public word() {
    setmaxNumber();
    setWords();
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public void setmaxNumber(){
        this.maxNumber = lengthArray(0);
    }
    public void setWords() {
        this.words = read(context());
    }
    public int lengthArray(int number){
        return number;
    }

    public String context(){
        Scanner input = new Scanner(System.in);
        String name_file = null;
        System.out.println("Escolha um contexto para o jogo da forca");
        System.out.println("1- Anime");
        System.out.println("2- Filmes");
        System.out.println("3- Games");
        String choice = input.nextLine();
        if (choice.equals("1")){
            name_file = "anime.txt";
        }
        else if (choice.equals("2")){
            name_file = "filmes.txt";
        }
        else if (choice.equals("3")){
            name_file = "games.txt";
        }
        return name_file;
    }
    public ArrayList<String> read(String name_file){
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
            lengthArray(listWords.size());
            return listWords;


        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
        return null;
    }
}
