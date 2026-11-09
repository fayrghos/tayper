package ui.componentes;

import com.raylib.Raylib;
import com.raylib.Raylib.Color;
import com.raylib.Raylib.Font;
import com.raylib.Raylib.Vector2;
import utils.Geral;
import utils.fluxo.Desenhavel;

/**
 * Representa um texto posicionável na tela.
 */
public class Texto implements Desenhavel {

    public String linha;
    protected Vector2 posicao;
    protected int espaco = 1;

    protected final float tamanho;
    protected final Font fonte;
    protected final Color cor;

    /**
     * Gera um novo texto posicionável.
     *
     * @param linha O texto a ser posicionado.
     * @param posicao A posição dele.
     */
    public Texto(String linha, float tamanho, Vector2 posicao, Color cor) {
        this.linha = linha;
        this.tamanho = tamanho;
        this.posicao = posicao;
        this.cor = cor;
        this.fonte = Raylib.GetFontDefault();
    }

    /**
     * Aplica um novo espaçamento ao texto.
     *
     * @param novoEspaco O novo espaçamento.
     */
    public Texto espaco(int novoEspaco) {
        this.espaco = novoEspaco;
        return this;
    }

    @Override
    public void desenhar() {
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
