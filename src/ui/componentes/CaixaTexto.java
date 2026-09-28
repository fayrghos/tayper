package ui.componentes;

import com.raylib.Colors;
import com.raylib.Raylib;
import com.raylib.Raylib.Vector2;
import utils.Geral;

/**
 * Implementa caixas de exibição de texto.
 */
public class CaixaTexto extends Caixa {

    Texto texto;

    /**
     * Cria uma nova instância de caixa de texto.
     *
     * @param posicao A posição da caixa.
     * @param tamanho As dimensões da caixa.
     * @param linha O texto a ser exibido na caixa.
     */
    public CaixaTexto(Vector2 posicao, Vector2 tamanho, String linha) {
        super(posicao, tamanho);
        this.texto = new Texto(
            linha,
            24,
            Raylib.Vector2Add(posicao, Geral.divideVetor(tamanho, 2))
        ).cor(Colors.BLACK);
    }

    @Override
    public void desenhar(boolean focoAtivo) {
        super.desenhar(focoAtivo);
        texto.desenharCentro();
    }
}
