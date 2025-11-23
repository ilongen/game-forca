package game_sticky;

public class Bracos {
    public void desenharBracoEsquerdo() {
        System.out.println("  |     O");
        System.out.println("  |    /|");
        System.out.println("  |");
        System.out.println("  |");
    }

    public void desenharBracosCompletos() {
        System.out.println("  |     O");
        System.out.println("  |    /|\\");
        System.out.println("  |");
        System.out.println("  |");
    }

    public void desenharBracoEsquerdoComMensagem(String mensagem) {
        System.out.println("  |     O");
        System.out.println("  |    /|   " + mensagem);
        System.out.println("  |");
        System.out.println("  |");
    }

    public void desenharBracosCompletosComMensagem(String mensagem) {
        System.out.println("  |     O");
        System.out.println("  |    /|\\  " + mensagem);
        System.out.println("  |");
        System.out.println("  |");
    }
}