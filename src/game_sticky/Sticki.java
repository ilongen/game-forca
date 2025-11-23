package game_sticky;

public class Sticki {
    private int partesDesenhadas;

    public Sticki() {
        this.partesDesenhadas = 0;
    }

    public void adicionarParte() {
        if (partesDesenhadas < 6) {
            partesDesenhadas++;
        }
    }

    public int getPartesDesenhadas() {
        return partesDesenhadas;
    }

    public boolean jogoAcabou() {
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

    // Métodos para chamar partes específicas
    public static void desenharParte(int parte) {
        System.out.println("  _______");
        System.out.println("  |     |");

        switch (parte) {
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
            default:
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                break;
        }

        System.out.println("__|__");
        System.out.println();
    }
}