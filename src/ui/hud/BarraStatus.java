package ui.hud;

import com.raylib.Colors;
import com.raylib.Raylib;
import com.raylib.Raylib.Vector2;
import core.Digitador;
import core.Jogo;
import core.ciclo.Desenhavel;
import core.entidades.Jogador;
import ui.componentes.Texto;

/**
 * Representa a barra que contém as informações cruciais para o jogador.
 */
public final class BarraStatus implements Desenhavel {

    public static int ALTURA = 180;

    private Jogador jogador;
    private Digitador digitador;

    /**
     * Cria uma nova instância de barra de status.
     *
     * @param jogador O jogador.
     * @param digitador O digitador do jogo.
     */
    public BarraStatus(Jogador jogador, Digitador digitador) {
        this.jogador = jogador;
        this.digitador = digitador;
    }

    @Override
    public void desenhar() {
        Raylib.DrawRectangle(
            0,
            Jogo.ALTURA - BarraStatus.ALTURA,
            Jogo.LARGURA,
            Jogo.ALTURA,
            Colors.DARKGRAY
        );

        digitador.desenhar();

        new Texto(
            String.format("%d HP", jogador.vida),
            32,
            new Vector2().x(100).y(Jogo.ALTURA - 120)
        ).desenharCentro();

        new Texto(
            String.format("%d pts", jogador.pontuador.pontuacaoAtual()),
            32,
            new Vector2().x(100).y(Jogo.ALTURA - 60)
        ).desenharCentro();

        new Texto(
            String.format("x%d", jogador.pontuador.sequenciaAtual()),
            32,
            new Vector2().x(Jogo.LARGURA - 120).y(Jogo.ALTURA - 90)
        ).desenharCentro();
    }
}
