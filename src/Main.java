import com.raylib.Raylib;
import core.Jogo;

/**
 * O ponto de entrada do jogo.
 */
public class Main {

    public static void main(String[] args) {
        Raylib.InitWindow(Jogo.LARGURA, Jogo.ALTURA, "Tayper");
        Raylib.SetExitKey(Raylib.KEY_NULL);
        Raylib.SetTargetFPS(60);

        Jogo jogo = new Jogo();

        while (jogo.rodando()) {
            Raylib.BeginDrawing();

            jogo.atualizar();
            jogo.desenhar();

            Raylib.EndDrawing();
        }

        Raylib.CloseWindow();
    }
}
