package core.entidades;

import com.raylib.Raylib;
import com.raylib.Raylib.Vector2;
import ui.componentes.Placa;

/**
 * Representa um inimigo no jogo
 */
public class Inimigo extends Entidade {

    public String palavraChave;
    private Placa caixaPalavra;

    public Inimigo(Vector2 posicao, String palavraChave) {
        super(1, posicao);
        this.palavraChave = palavraChave;
        this.caixaPalavra = new Placa(
            palavraChave,
            Raylib.Vector2Subtract(posicao, new Vector2().y(80)),
            new Vector2().x(100).y(30),
            true
        );
    }

    /**
     * Testa se a palavra inserida é igual a palavra do inimigo.
     *
     * @return Se as palavras coincidem.
     */
    public boolean testarPalavra(String palavra) {
        return palavraChave.equals(palavra);
    }

    @Override
    public void atualizar() {}

    @Override
    public void desenhar() {
        if (!ativo) {
            return;
        }

        super.desenhar();
        caixaPalavra.desenhar();
    }
}
