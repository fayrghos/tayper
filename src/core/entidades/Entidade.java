package core.entidades;

import com.raylib.Colors;
import com.raylib.Raylib;
import com.raylib.Raylib.Vector2;
import utils.Geral;
import utils.fluxo.Atualizavel;
import utils.fluxo.Desenhavel;

/**
 * Representa uma base para todas as entidades do jogo.
 */
public abstract class Entidade implements Atualizavel, Desenhavel {

    public int vidas = 1;
    public Vector2 posicao;
    public Vector2 tamanhoBox = new Vector2().x(64).y(64);

    public Entidade(int vidas, Vector2 posicao) {
        this.vidas = vidas;
        this.posicao = posicao;
    }

    @Override
    public void desenhar() {
        Raylib.DrawRectangleV(
            Raylib.Vector2Subtract(
                posicao,
                Raylib.Vector2Divide(tamanhoBox, Geral.VETOR2)
            ),
            tamanhoBox,
            Colors.RED
        );
    }
}
