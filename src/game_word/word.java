package game_word;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class word {
    // ESSA CLASSE TEM FUNÇÃO DE LER UM ARQUIVO E ARMAZENAR NUMA COLEÇÃO COM CHAVE E VALOR
    // CHAVE VALOR EXEMPLO:
    // CHAVE: 0 ATÉ ULTIMA PALAVRA
    // VALOR: A PALAVRA QUE É ESCRITA
    // EXEMPLO: 1 : MACACO
    public void read(){
        File PATH = new File("src/game_word/words.txt");
        try {
            FileReader fr = new FileReader(PATH);
            BufferedReader br = new BufferedReader(fr);
        }
        catch (Exception e){
            System.out.println("Error is: "+e);
        }

    }
}
