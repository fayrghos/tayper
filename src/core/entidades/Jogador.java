package core.entidades;

import com.raylib.Raylib.Vector2;
import core.mecanicas.Pontuador;

/**
 * Representa um jogador.
 */
public final class Jogador extends Entidade {

    public Pontuador pontuador;

    public Jogador(Vector2 posicao) {
        super(3, posicao);
        this.pontuador = new Pontuador();
    }

    @Override
    public void atualizar() {}
}
