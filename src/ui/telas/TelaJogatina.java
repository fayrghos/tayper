package ui.telas;

import com.raylib.Colors;
import com.raylib.Raylib;
import core.Digitador;
import core.Jogo;
import ui.hud.BarraStatus;

/**
 * Implementa a tela de jogatina do jogo.
 */
public final class TelaJogatina extends Tela {

    private Digitador digitador;
    private BarraStatus barraStatus;

    public TelaJogatina(Jogo jogo) {
        super(jogo);
        this.digitador = new Digitador();
        this.barraStatus = new BarraStatus(jogo.jogador, digitador);
    }

    @Override
    public void atualizar() {
        digitador.atualizar();

        if (Raylib.IsKeyPressed(Raylib.KEY_ENTER)) {
            processarPalavra();
            return;
        }

        if (jogo.jogador.vidas <= 0) {
            jogo.mudarTela(TipoTela.FIM);
        }
    }

    @Override
    public void desenhar() {
        Raylib.ClearBackground(Colors.DARKGREEN);

        jogo.jogador.desenhar();
        barraStatus.desenhar();
    }

    /**
     * Processa toda a lógica do ENTER do jogador.
     */
    private void processarPalavra() {
        String textoExtraido = digitador.extrairTexto();

        if (textoExtraido.equals("")) {
            return;
        }

        jogo.jogador.vidas--;
        jogo.jogador.pontuador.reiniciarSequencia();
    }
}
