package core.entidades;

import com.raylib.Raylib;
import com.raylib.Raylib.Vector2;
import ui.componentes.CaixaTexto;

/**
 * Representa um inimigo no jogo
 */
public class Inimigo extends Entidade {

    public String palavraChave;
    private CaixaTexto caixaPalavra;

    public Inimigo(Vector2 posicao, String palavraChave) {
        super(1, posicao);
        this.palavraChave = palavraChave;
        this.caixaPalavra = new CaixaTexto(
            palavraChave,
            Raylib.Vector2Subtract(posicao, new Vector2().y(80)),
            new Vector2().x(100).y(30),
            true
        );
    }

    @Override
    public void atualizar() {}

    @Override
    public void desenhar() {
        if (!ativo) {
            return;
        }

        super.desenhar();
        caixaPalavra.desenhar(false);
    }
}
