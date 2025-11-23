package game_sticky;

public class body {
    public static void desenhar() {
        System.out.println("  |     O");
        System.out.println("  |     |");
        System.out.println("  |");
        System.out.println("  |");
    }

    public static void desenharComMensagem(String mensagem) {
        System.out.println("  |     O");
        System.out.println("  |     |    " + mensagem);
        System.out.println("  |");
        System.out.println("  |");
    }
}