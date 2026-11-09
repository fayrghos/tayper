package ui.componentes;

import com.raylib.Colors;
import com.raylib.Raylib;
import com.raylib.Raylib.Rectangle;
import com.raylib.Raylib.Vector2;
import utils.Geral;

/**
 * Implementa quadros especializados em exibir texto.
 */
public class Placa extends Quadro {

    protected Texto texto;

    /**
     * Cria uma nova instância de placa.
     *
     * @param linha O texto a ser exibido.
     * @param posicao A posição inicial.
     * @param tamanho As dimensões iniciais.
     * @param centralizar Se o quadro deve ser centralizado.
     */
    public Placa(
        String linha,
        Vector2 posicao,
        Vector2 tamanho,
        boolean centralizar
    ) {
        super(posicao, tamanho, centralizar);
        this.texto = new Texto(
            linha,
            24,
            Raylib.Vector2Add(this.posicao, Geral.divideVetor(tamanho, 2)),
            Colors.BLACK
        );
    }

    @Override
    public void desenhar() {
        super.desenhar();
        texto.desenhar();
    }

    /**
     * Desenha uma moldura de seleção ao redor dessa caixa.
     * Projetado para ser utilizado com botões de menu.
     */
    public void desenharMoldura() {
        Rectangle exterior = new Rectangle()
            .x(this.posicao.x() - 15)
            .y(this.posicao.y() - 15)
            .width(this.tamanho.x() + 30)
            .height(this.tamanho.y() + 30);
        Raylib.DrawRectangleLinesEx(exterior, 5, Colors.BLACK);
    }
}
