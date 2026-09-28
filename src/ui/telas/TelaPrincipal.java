package ui.telas;

import com.raylib.Colors;
import com.raylib.Raylib;
import core.Jogo;
import ui.componentes.CaixaTexto;
import utils.CicloInteiro;

/**
 * Implementa o menu principal do jogo.
 */
public final class TelaPrincipal extends Tela {

    public TelaPrincipal(Jogo jogo) {
        super(jogo);
    }

    public CicloInteiro cicloBotao = new CicloInteiro(0, 0, 2);

    @Override
    public void atualizar() {
        int tecla = Raylib.GetKeyPressed();

        switch (tecla) {
            case Raylib.KEY_W, Raylib.KEY_UP -> {
                cicloBotao.incrementar(-1);
            }
            case Raylib.KEY_S, Raylib.KEY_DOWN -> {
                cicloBotao.incrementar(+1);
            }
            case Raylib.KEY_ENTER, Raylib.KEY_SPACE -> {
                switch (cicloBotao.atual) {
                    case 0 -> {
                        jogo.mudarTela(TipoTela.JOGO);
                    }
                    case 1 -> {
                        jogo.mudarTela(TipoTela.CREDITOS);
                    }
                    case 2 -> {
                        jogo.encerrar();
                    }
                }
            }
        }
    }

    @Override
    public void desenhar() {
        Raylib.ClearBackground(Colors.BLUE);

        new CaixaTexto(
            new Raylib.Vector2().x(Jogo.LARGURA / 2 - 200).y(400),
            new Raylib.Vector2().x(400).y(60),
            "Iniciar"
        ).desenhar(cicloBotao.atual == 0);

        new CaixaTexto(
            new Raylib.Vector2().x(Jogo.LARGURA / 2 - 200).y(500),
            new Raylib.Vector2().x(400).y(60),
            "Créditos"
        ).desenhar(cicloBotao.atual == 1);

        new CaixaTexto(
            new Raylib.Vector2().x(Jogo.LARGURA / 2 - 200).y(600),
            new Raylib.Vector2().x(400).y(60),
            "Sair"
        ).desenhar(cicloBotao.atual == 2);
    }
}
