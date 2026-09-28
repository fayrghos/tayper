package ui.telas;

import com.raylib.Colors;
import com.raylib.Raylib;
import core.Jogo;
import core.ciclo.Atualizavel;
import core.ciclo.Desenhavel;

/**
 * Implementa a lógica de cada tela do jogo.
 */
public abstract class Tela implements Atualizavel, Desenhavel {

    protected final Jogo jogo;

    /**
     * Cria uma nova instância da tela.
     * @param jogo Uma instância do jogo
     */
    public Tela(Jogo jogo) {
        this.jogo = jogo;
    }

    @Override
    public void atualizar() {
        if (Raylib.IsKeyPressed(Raylib.KEY_ESCAPE)) {
            jogo.mudarTela(TipoTela.PRINCIPAL);
        }
    }

    @Override
    public void desenhar() {
        Raylib.ClearBackground(Colors.DARKGRAY);
        Raylib.DrawText("Ainda não implementada...", 20, 20, 24, Colors.WHITE);
    }
}
