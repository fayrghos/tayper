package ui.telas;

import com.raylib.Colors;
import com.raylib.Raylib;
import com.raylib.Raylib.Vector2;
import core.Jogo;
import ui.componentes.CaixaTexto;
import ui.telas.base.Tela;
import utils.Ciclador;

/**
 * Representa o menu principal do jogo.
 */
public final class TelaMenu extends Tela {

    private final CaixaTexto[] botoes = {
        new CaixaTexto(
            new Vector2().x(Jogo.LARGURA / 2).y(Jogo.ALTURA - 200),
            new Vector2().x(200).y(50),
            "Iniciar"
        ),
        new CaixaTexto(
            new Vector2().x(Jogo.LARGURA / 2).y(Jogo.ALTURA - 100),
            new Vector2().x(200).y(50),
            "Opções"
        ),
    };
    private Ciclador cicloBotao;

    public TelaMenu(Jogo jogo) {
        super(jogo);
        this.cicloBotao = new Ciclador(0, 0, botoes.length - 1);
    }

    @Override
    public void atualizar() {
        if (Raylib.IsKeyPressed(Raylib.KEY_DOWN)) {
            cicloBotao.incrementar(+1);
        }

        if (Raylib.IsKeyPressed(Raylib.KEY_UP)) {
            cicloBotao.incrementar(-1);
        }
    }

    @Override
    public void desenhar() {
        Raylib.ClearBackground(Colors.SKYBLUE);

        for (int i = 0; i < botoes.length; i++) {
            botoes[i].desenhar(cicloBotao.atual == i);
        }
    }
}
