package core.entidades;

import core.Pontuador;

/**
 * Representa um jogador.
 */
public final class Jogador {

    public int vida;
    public Pontuador pontuador;

    public Jogador() {
        this.vida = 3;
        this.pontuador = new Pontuador();
    }
}
