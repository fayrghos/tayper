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

    public Vector2 posicao;
    public Vector2 preenchimento = new Vector2().x(64).y(64);

    protected int vida;
    protected boolean ativo = true; // TODO: Remover depois.
    protected int dano = 1;

    public Entidade(int vida, Vector2 posicao) {
        this.vida = vida;
        this.posicao = posicao;
    }

    /**
     * Retorna a vida atual da unidade.
     *
     * @return A vida atual.
     */
    public int vida() {
        return this.vida;
    }

    /**
     * Causa dano em uma entidade.
     *
     * @param entidade
     */
    public void causarDano(Entidade entidade) {
        entidade.receberDano(dano);
    }

    /**
     * Causa dano na própria entidade, se possível.
     *
     * @param dano O dano a ser causado.
     */
    public void receberDano(int dano) {
        if (dano < 1) {
            return;
        }

        vida -= dano;

        if (vida < 1) {
            desativar();
        }
    }

    /**
     * Verifica se a unidade está ativa.
     */
    public boolean ativa() {
        return this.ativo;
    }

    /**
     * Desativa a unidade.
     */
    public void desativar() {
        ativo = false;
    }

    @Override
    public void desenhar() {
        Raylib.DrawRectangleV(
            Raylib.Vector2Subtract(
                posicao,
                Raylib.Vector2Divide(preenchimento, Geral.VETOR2)
            ),
            preenchimento,
            Colors.RED
        );
    }
}
