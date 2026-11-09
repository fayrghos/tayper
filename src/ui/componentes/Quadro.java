package ui.componentes;

import com.raylib.Colors;
import com.raylib.Raylib;
import com.raylib.Raylib.Rectangle;
import com.raylib.Raylib.Vector2;
import utils.Geral;
import utils.fluxo.Desenhavel;

/**
 * Implementa quadros reutilizáveis.
 */
public class Quadro implements Desenhavel {

    private static final int ESPESSURA = 5;

    protected Vector2 posicao;
    protected Vector2 tamanho;

    /**
     * Cria uma nova instância de quadro.
     *
     * @param posicao A posição inicial.
     * @param tamanho As dimensões iniciais.
     * @param centralizar Se o quadro deve ser centralizado.
     */
    public Quadro(Vector2 posicao, Vector2 tamanho, boolean centralizar) {
        this.posicao = posicao;
        this.tamanho = tamanho;

        if (centralizar) {
            this.posicao = Raylib.Vector2Subtract(
                this.posicao,
                Geral.divideVetor(this.tamanho, 2)
            );
        }
    }

    @Override
    public void desenhar() {
        Rectangle contorno = new Rectangle()
            .x(this.posicao.x() - ESPESSURA)
            .y(this.posicao.y() - ESPESSURA)
            .width(this.tamanho.x() + ESPESSURA * 2)
            .height(this.tamanho.y() + ESPESSURA * 2);
        Raylib.DrawRectangleRec(contorno, Colors.BLACK);

        Rectangle interior = new Rectangle()
            .x(this.posicao.x())
            .y(this.posicao.y())
            .width(this.tamanho.x())
            .height(this.tamanho.y());
        Raylib.DrawRectangleRec(interior, Colors.WHITE);
    }
}
