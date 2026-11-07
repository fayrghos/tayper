package core;

import com.raylib.Raylib;
import com.raylib.Raylib.Vector2;
import core.entidades.Jogador;
import java.util.Map;
import ui.telas.TelaCreditos;
import ui.telas.TelaInicial;
import ui.telas.TelaMorte;
import ui.telas.TelaPartida;
import ui.telas.base.Tela;
import ui.telas.base.TipoTela;
import utils.fluxo.Atualizavel;
import utils.fluxo.Desenhavel;

/**
 * O orquestrador principal do jogo.
 */
public final class Jogo implements Atualizavel, Desenhavel {

    public static final int LARGURA = 1280;
    public static final int ALTURA = 736;
    private boolean rodando = true;

    public Jogador jogador;

    private Map<TipoTela, Tela> telas;
    private Tela telaAtual;

    public Jogo() {
        this.jogador = new Jogador(
            new Vector2().x(Jogo.LARGURA / 2).y(Jogo.ALTURA / 2),
            new Vector2().x(64).y(64)
        );

        this.telas = Map.of(
            TipoTela.INICIAL,
            new TelaInicial(this),
            TipoTela.PARTIDA,
            new TelaPartida(this),
            TipoTela.CREDITOS,
            new TelaCreditos(this),
            TipoTela.MORTE,
            new TelaMorte(this)
        );
        this.telaAtual = telas.get(TipoTela.INICIAL);
    }

    /**
     * Verifica se o jogo deve continuar rodando.
     *
     * @return O estado atual do jogo.
     */
    public boolean rodando() {
        return !Raylib.WindowShouldClose() && rodando;
    }

    /**
     * Fecha o jogo.
     */
    public void encerrar() {
        rodando = false;
    }

    /**
     * Redesenha toda a tela do jogo.
     */
    public void desenhar() {
        telaAtual.desenhar();
    }

    /**
     * Atualiza todo o estado do jogo.
     */
    public void atualizar() {
        telaAtual.atualizar();
    }

    /**
     * Alterna para outra Tela cadastrada na instância do jogo.
     *
     * @param tela A tela de destino.
     */
    public void mudarTela(TipoTela tela) {
        telaAtual = telas.get(tela);
    }
}
