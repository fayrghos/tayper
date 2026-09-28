package ui.componentes;

import com.raylib.Colors;
import com.raylib.Raylib;
import com.raylib.Raylib.Color;
import com.raylib.Raylib.Font;
import com.raylib.Raylib.Vector2;
import utils.Geral;

/**
 * Representa um texto posicionável na tela.
 */
public class Texto {

    public String linha;
    public float tamanho;
    public Vector2 posicao;

    public Font fonte;
    private int espaco = 1;
    private Color cor = Colors.WHITE;

    /**
     * Gera um novo texto posicionável.
     *
     * @param linha O texto a ser posicionado.
     * @param posicao A posição dele.
     */
    public Texto(String linha, float tamanho, Vector2 posicao) {
        this.linha = linha;
        this.tamanho = tamanho;
        this.posicao = posicao;

        this.fonte(Raylib.GetFontDefault());
    }

    /**
     * Altera a fonte do texto.
     * @param novaFonte A nova fonte.
     * @return A própria instância.
     */
    public Texto fonte(Font novaFonte) {
        this.fonte = novaFonte;
        return this;
    }

    /**
     * Altera o espaçamento entre o texto.
     * @param novoEspaco O novo espaçamento.
     * @return A própria instância.
     */
    public Texto espaco(int novoEspaco) {
        this.espaco = novoEspaco;
        return this;
    }

    /**
     * Altera a cor do texto.
     * @param novaCor A nova cor.
     * @return A própria instância.
     */
    public Texto cor(Color novaCor) {
        this.cor = novaCor;
        return this;
    }

    /**
     * Desenha o texto de maneira cuja sua própria posição seja o canto superior esquerdo.
     */
    public void desenharAbsoluto() {
        Raylib.DrawTextEx(fonte, linha, posicao, tamanho, espaco, cor);
    }

    /**
     * Desenha o texto centralizado na sua própria posição.
     */
    public void desenharCentro() {
        Raylib.Vector2 tamanhoTexto = Geral.divideVetor(
            Raylib.MeasureTextEx(fonte, linha, tamanho, espaco),
            2
        );

        Raylib.DrawTextEx(
            fonte,
            linha,
            Raylib.Vector2Subtract(posicao, tamanhoTexto),
            tamanho,
            espaco,
            cor
        );
    }
}
