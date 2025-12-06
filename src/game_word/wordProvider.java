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

    // VÁRIAVEIS CONSTANTES

    // -----------
    int maxNumber;
    final int minNumber = 0;
    ArrayList<String> words;
    int indexWord;
    String word;
    // -----------


    // MÉTODOS TOTAL -> 10
    // M. PRIVADOS -> 2
    // M. PUBLICOS -> 8
    // -----------

    // Gatilho geral, responsável por selecionar a palavra e deixar reservada em uma váriavel.
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

    // setWords: DEFINE AS PALAVRAS QUE IRÁ RECEBER APÓS A LEITURA SOBRE UM ARQUIVO QUE GERA O CONTEXTO DO GAME
    public void setWords() {
        this.words = read(context());
    }

    // DETERMINANTE DE CONCEITO DO GAME, ABRE A POSSIBILIDADE DE DADOS QUE O JOGADOR IRÁ CONCORRER.
    // ELE RECEBE UM NÚMERO DO USUÁRIO.
    // E ESSE NÚMERO DETERMINARÁ O CAMINHO ESCOLHIDO PELO PRÓPRIO USUÁRIO E DEIXANDO SALVO PARA UM PRÓXIMO PASSO.
    private String context(){
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
    // RECEBE A ESCOLHA DO USUÁRIO PELO MÉTODO DO CONTEXTO E FAZ A LEITURA DO ARQUIVO TXT PARA ARMAZENAR EM UMA LISTA >
    // REDIMENSIONÁVEL.
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
            // ATUALIZA O NÚMERO MÁXIMO DE ACORDO COM O LIMITE FINAL DA LISTA DEPOIS DE SABER O COMPRIMENTO DELA.
            setMaxNumber(listWords.size());
            return listWords;


        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
        return null;
    }
}
