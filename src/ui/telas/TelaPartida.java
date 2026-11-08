package ui.telas;

import core.Jogo;
import ui.telas.base.Tela;
import ui.telas.base.TipoTela;

/**
 * Representa a tela que será exibida durante jogatinas.
 */
public final class TelaPartida extends Tela {

    public TelaPartida(Jogo jogo) {
        super(jogo);
    }

    @Override
    public void focar() {
        jogo.iniciarPartida();
    }

    @Override
    public void desenhar() {
        jogo.partida().desenhar();
    }

    @Override
    public void atualizar() {
        jogo.partida().atualizar();

        if (jogo.partida().jogador.vida() < 1) {
            jogo.mudarTela(TipoTela.MORTE);
        }
    }
}
