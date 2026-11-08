package core;

import com.raylib.Colors;
import com.raylib.Raylib;
import com.raylib.Raylib.Vector2;
import core.entidades.Inimigo;
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
    public final BarraStatus status;

    public final Digitador digitador = new Digitador();
    public final Pontuador pontuador = new Pontuador();

    public Inimigo[] inimigos = {
        new Inimigo(new Vector2().x(100).y(Jogo.ALTURA / 2), "Andar"),
        new Inimigo(
            new Vector2().x(Jogo.LARGURA - 100).y(Jogo.ALTURA / 2),
            "Baixar"
        ),
    };

    public Partida() {
        this.status = new BarraStatus(jogador, digitador);
    }

    @Override
    public void desenhar() {
        Raylib.ClearBackground(Colors.DARKGREEN);

        jogador.desenhar();
        for (Inimigo inimigo : inimigos) {
            inimigo.desenhar();
        }

        status.desenhar();
    }

    @Override
    public void atualizar() {
        digitador.atualizar();

        if (Raylib.IsKeyPressed(Raylib.KEY_ENTER)) {
            String texto = digitador.extrairTexto();

            boolean encontrado = false;
            for (int i = 0; i < inimigos.length; i++) {
                if (!inimigos[i].ativa()) {
                    break;
                }

                if (texto.equals(inimigos[i].palavraChave)) {
                    encontrado = true;
                    inimigos[i].desativar();
                }
            }

            if (!encontrado) {
                jogador.danificar(1);
            }
        }
    }
}
