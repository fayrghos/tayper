package ui.telas;

import com.raylib.Colors;
import com.raylib.Raylib;
import com.raylib.Raylib.Vector2;
import core.Digitador;
import core.Jogo;
import ui.componentes.Texto;
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

        if (jogo.jogador.vida <= 0) {
            jogo.mudarTela(TipoTela.FIM);
        }
    }

    @Override
    public void desenhar() {
        Raylib.ClearBackground(Colors.DARKGREEN);

        new Texto(
            "Palavras válidas:\n\tAndar\n\tBaixar\n\tCair",
            30,
            new Vector2().x(40).y(40)
        ).desenharAbsoluto();

        barraStatus.desenhar();
    }

    // TODO: Passar isso para a lógica do jogo.
    /**
     * Processa toda a lógica do ENTER do jogador.
     */
    private void processarPalavra() {
        String textoExtraido = digitador.extrairTexto();

        if (textoExtraido.equals("")) {
            return;
        }

        String[] palavrasValidas = { "Andar", "Baixar", "Cair" };
        for (String palavra : palavrasValidas) {
            if (textoExtraido.equals(palavra)) {
                jogo.jogador.pontuador.incrementar(palavra.length());
                return;
            }
        }

        jogo.jogador.vida--;
        jogo.jogador.pontuador.reiniciarSequencia();
    }
}
