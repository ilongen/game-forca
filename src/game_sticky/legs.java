package game_sticky;

public class legs {
    public static void desenharPernaEsquerda() {
        System.out.println("  |     O");
        System.out.println("  |    /|\\");
        System.out.println("  |    /");
        System.out.println("  |");
    }

    public static void desenharPernasCompletas() {
        System.out.println("  |     O");
        System.out.println("  |    /|\\");
        System.out.println("  |    / \\");
        System.out.println("  |");
    }

    public static void desenharPernaEsquerdaComMensagem(String mensagem) {
        System.out.println("  |     O");
        System.out.println("  |    /|\\");
        System.out.println("  |    /     " + mensagem);
        System.out.println("  |");
    }

    public static void desenharPernasCompletasComMensagem(String mensagem) {
        System.out.println("  |     O");
        System.out.println("  |    /|\\");
        System.out.println("  |    / \\   " + mensagem);
        System.out.println("  |");
    }
}