package ui.telas.base;

import com.raylib.Colors;
import com.raylib.Raylib;
import core.Jogo;
import utils.fluxo.Atualizavel;
import utils.fluxo.Desenhavel;

/**
 * Implementa a lógica de cada tela do jogo.
 */
public abstract class Tela implements Atualizavel, Desenhavel {

    protected final Jogo jogo;

    /**
     * Cria uma nova instância da tela.
     *
     * @param jogo Uma instância do jogo
     */
    public Tela(Jogo jogo) {
        this.jogo = jogo;
    }

    /**
     * Chamada sempre que a tela é alternada para essa.
     */
    public void focar() {}

    /**
     * Chamada sempre que a tela é alternada para outra.
     */
    public void desfocar() {}

    @Override
    public void atualizar() {
        if (Raylib.IsKeyPressed(Raylib.KEY_ESCAPE)) {
            jogo.mudarTela(TipoTela.INICIAL);
        }
    }

    @Override
    public void desenhar() {
        Raylib.ClearBackground(Colors.DARKGRAY);
        Raylib.DrawText("Ainda não implementada...", 20, 20, 24, Colors.WHITE);
    }
}
