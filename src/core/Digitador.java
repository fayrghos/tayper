package core;

import com.raylib.Raylib;
import core.ciclo.Atualizavel;
import core.ciclo.Desenhavel;
import ui.componentes.Texto;
import utils.Geral;

/**
 * Responsável por processar os comandos de digitação do jogador.
 */
public final class Digitador implements Atualizavel, Desenhavel {

    public Texto texto;
    private static final int TAMANHO_MAX = 16;
    private static final String CHARS_VALIDOS =
        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ" +
        "çáéíóúâêôãõÇÁÉÍÓÚÂÊÔÃÕ";

    public Digitador() {
        this.texto = new Texto(
            "",
            80,
            new Raylib.Vector2().x(Jogo.LARGURA / 2).y(Jogo.ALTURA - 80)
        ).espaco(10);
    }

    @Override
    public void atualizar() {
        int apertada = Raylib.GetCharPressed();

        if (CHARS_VALIDOS.contains(Character.toString(apertada))) {
            adicionarChar((char) apertada);
            return;
        }

        if (Geral.segurandoTecla(Raylib.KEY_BACKSPACE)) {
            apagarChar();
            return;
        }
    }

    @Override
    public void desenhar() {
        this.texto.desenharCentro();
    }

    /**
     * Extrai o texto atual e apaga o que está no campo de digitação.
     * @return O texto que está no campo.
     */
    public String extrairTexto() {
        String copiaLinha = texto.linha;
        apagarLinha();
        return copiaLinha;
    }

    /**
     * Valida e adiciona um novo caractere no campo de texto.
     * @param novoChar O caractere desejado.
     */
    private void adicionarChar(char novoChar) {
        if (texto.linha.length() >= TAMANHO_MAX) {
            return;
        }

        if (texto.linha.length() <= 0) {
            texto.linha += Character.toUpperCase(novoChar);
            return;
        }

        texto.linha += Character.toLowerCase(novoChar);
    }

    /**
     * Apaga um caractere do final do campo de texto.
     */
    private void apagarChar() {
        if (texto.linha.length() > 0) {
            texto.linha = texto.linha.substring(0, texto.linha.length() - 1);
        }
    }

    /**
     * Apaga o campo de texto.
     */
    private void apagarLinha() {
        this.texto.linha = "";
    }
}
