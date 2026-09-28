package ui.telas;

import com.raylib.Colors;
import com.raylib.Raylib;
import core.Jogo;

/**
 * Implementa a tela de fim de jogo.
 */
public final class TelaFim extends Tela {

    public TelaFim(Jogo jogo) {
        super(jogo);
    }

    @Override
    public void atualizar() {}

    @Override
    public void desenhar() {
        Raylib.ClearBackground(Colors.DARKGRAY);
        Raylib.DrawText(
            String.format(
                "Fim de jogo! Score: %d",
                jogo.jogador.pontuador.pontuacaoAtual()
            ),
            20,
            20,
            24,
            Colors.WHITE
        );
    }
}
