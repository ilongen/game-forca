package forcagame.sticky.paint;

import forcagame.sticky.body.arms;
import forcagame.sticky.body.body;
import forcagame.sticky.body.head;
import forcagame.sticky.body.legs;

public class Sticky {
    private int partesDesenhadas;
    private int countError; // CAMPO NOVO ADICIONADO

    public Sticky() {
        this.partesDesenhadas = 0;
        this.countError = 0; // INICIALIZAR NOVO CAMPO
    }

    // MÉTODO NOVO ADICIONADO para integração
    public void adicionarParte() {
        if (partesDesenhadas < 6) {
            partesDesenhadas++;
            countError++;
        }
    }

    // MÉTODO NOVO ADICIONADO
    public int getCountError() {
        return countError;
    }

    public boolean endGame() {
        return partesDesenhadas >= 6;
    }

    public void desenharForca() {
        System.out.println("  _______");
        System.out.println("  |     |");

        switch (partesDesenhadas) {
            case 0:
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                break;
            case 1:
                head.desenhar();
                break;
            case 2:
                body.desenhar();
                break;
            case 3:
                arms.desenharBracoEsquerdo();
                break;
            case 4:
                arms.desenharBracosCompletos();
                break;
            case 5:
                legs.desenharPernaEsquerda();
                break;
            case 6:
                legs.desenharPernasCompletas();
                break;
        }

        System.out.println("__|__");
        System.out.println();
    }

}