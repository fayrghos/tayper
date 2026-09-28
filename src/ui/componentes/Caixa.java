package ui.componentes;

import com.raylib.Colors;
import com.raylib.Raylib;
import com.raylib.Raylib.Font;
import com.raylib.Raylib.Rectangle;
import com.raylib.Raylib.Vector2;

/**
 * Implementa caixas de interface simples.
 */
public abstract class Caixa {

    final int espessuraCont = 5;

    Vector2 posicao;
    Vector2 tamanho;
    Font fonte;

    /**
     * Cria uma nova instância de caixa.
     *
     * @param posicao A posição da caixa.
     * @param tamanho As dimensões da caixa.
     */
    public Caixa(Vector2 posicao, Vector2 tamanho) {
        this.posicao = posicao;
        this.tamanho = tamanho;
        this.fonte = Raylib.GetFontDefault();
    }

    /**
     * Redesenha a caixa na tela.
     * @param focoAtivo Informa se a caixa está focada ou não.
     */
    public void desenhar(boolean focoAtivo) {
        Rectangle contorno = new Rectangle()
            .x(this.posicao.x() - this.espessuraCont)
            .y(this.posicao.y() - this.espessuraCont)
            .width(this.tamanho.x() + this.espessuraCont * 2)
            .height(this.tamanho.y() + this.espessuraCont * 2);
        Raylib.DrawRectangleRec(contorno, Colors.BLACK);

        Rectangle interior = new Rectangle()
            .x(this.posicao.x())
            .y(this.posicao.y())
            .width(this.tamanho.x())
            .height(this.tamanho.y());
        Raylib.DrawRectangleRec(interior, Colors.WHITE);

        if (focoAtivo) desenharFoco();
    }

    /**
     * Redesenha o contorno da caixa.
     */
    private void desenharFoco() {
        Rectangle exterior = new Rectangle()
            .x(this.posicao.x() - 15)
            .y(this.posicao.y() - 15)
            .width(this.tamanho.x() + 30)
            .height(this.tamanho.y() + 30);
        Raylib.DrawRectangleLinesEx(exterior, 5, Colors.BLACK);
    }
}
