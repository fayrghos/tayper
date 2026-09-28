package core;

import com.raylib.Raylib;
import core.ciclo.Atualizavel;
import core.ciclo.Desenhavel;
import core.entidades.Jogador;
import java.util.Map;
import ui.telas.Tela;
import ui.telas.TelaCreditos;
import ui.telas.TelaFim;
import ui.telas.TelaJogatina;
import ui.telas.TelaPrincipal;
import ui.telas.TipoTela;

/**
 * O coração da lógica do jogo.
 */
public final class Jogo implements Atualizavel, Desenhavel {

    public static final int LARGURA = 1280;
    public static final int ALTURA = 720;
    private boolean rodando = true;

    public Jogador jogador;

    private Map<TipoTela, Tela> telas;
    private Tela telaAtual;

    public Jogo() {
        this.jogador = new Jogador();

        this.telas = Map.of(
            TipoTela.PRINCIPAL,
            new TelaPrincipal(this),
            TipoTela.CREDITOS,
            new TelaCreditos(this),
            TipoTela.JOGO,
            new TelaJogatina(this),
            TipoTela.FIM,
            new TelaFim(this)
        );
        this.telaAtual = telas.get(TipoTela.PRINCIPAL);
    }

    /**
     * Verifica se o jogo deve continuar rodando.
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
     * @param tela A tela de destino.
     */
    public void mudarTela(TipoTela tela) {
        telaAtual = telas.get(tela);
    }
}
