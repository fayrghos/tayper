package ui.telas;

import com.raylib.Colors;
import com.raylib.Raylib;
import com.raylib.Raylib.Vector2;
import core.Jogo;
import ui.componentes.CaixaTexto;
import ui.telas.base.Tela;
import ui.telas.base.TipoTela;
import utils.Ciclador;

/**
 * Representa o menu principal do jogo.
 */
public final class TelaInicial extends Tela {

    private final CaixaTexto[] botoes = {
        new CaixaTexto(
            "Iniciar",
            new Vector2().x(Jogo.LARGURA / 2).y(Jogo.ALTURA - 260),
            new Vector2().x(300).y(50),
            true
        ),
        new CaixaTexto(
            "Créditos",
            new Vector2().x(Jogo.LARGURA / 2).y(Jogo.ALTURA - 180),
            new Vector2().x(300).y(50),
            true
        ),
        new CaixaTexto(
            "Sair",
            new Vector2().x(Jogo.LARGURA / 2).y(Jogo.ALTURA - 100),
            new Vector2().x(300).y(50),
            true
        ),
    };
    private Ciclador cicloBotao;

    public TelaInicial(Jogo jogo) {
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

        if (Raylib.IsKeyPressed(Raylib.KEY_ENTER)) {
            switch (cicloBotao.atual) {
                case 0 -> jogo.mudarTela(TipoTela.PARTIDA);
                case 1 -> jogo.mudarTela(TipoTela.CREDITOS);
                case 2 -> jogo.encerrar();
            }
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
