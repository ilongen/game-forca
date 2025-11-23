package game_sticky;

public class arms {
    public static void desenharBracoEsquerdo() {
        System.out.println("  |     O");
        System.out.println("  |    /|");
        System.out.println("  |");
        System.out.println("  |");
    }

    public static void desenharBracosCompletos() {
        System.out.println("  |     O");
        System.out.println("  |    /|\\");
        System.out.println("  |");
        System.out.println("  |");
    }

    public static void desenharBracoEsquerdoComMensagem(String mensagem) {
        System.out.println("  |     O");
        System.out.println("  |    /|    " + mensagem);
        System.out.println("  |");
        System.out.println("  |");
    }

    public static void desenharBracosCompletosComMensagem(String mensagem) {
        System.out.println("  |     O");
        System.out.println("  |    /|\\   " + mensagem);
        System.out.println("  |");
        System.out.println("  |");
    }
}
