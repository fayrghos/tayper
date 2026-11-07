package core;

import com.raylib.Colors;
import com.raylib.Raylib;
import com.raylib.Raylib.Vector2;
import core.entidades.Jogador;
import core.mecanicas.Digitador;
import core.mecanicas.Pontuador;
import ui.conjuntos.BarraStatus;
import utils.fluxo.Atualizavel;
import utils.fluxo.Desenhavel;

/**
 * Carrega a lógica de uma partida jogável inteira.
 */
public final class Partida implements Atualizavel, Desenhavel {

    public final Jogador jogador = new Jogador(
        new Vector2().x(Jogo.LARGURA / 2).y(Jogo.ALTURA / 2)
    );

    public final Digitador digitador = new Digitador();
    public final Pontuador pontuador = new Pontuador();

    public final BarraStatus status;

    public Partida() {
        this.status = new BarraStatus(jogador, digitador);
    }

    @Override
    public void desenhar() {
        Raylib.ClearBackground(Colors.DARKGREEN);

        jogador.desenhar();
        status.desenhar();
    }

    @Override
    public void atualizar() {
        digitador.atualizar();
    }
}
