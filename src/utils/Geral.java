package utils;

import com.raylib.Raylib;
import com.raylib.Raylib.Vector2;

/**
 * Coleção de funções sem propósito certo.
 */
public final class Geral {

    /**
     * Checa se o jogador apertou ou está segurando uma determinada tecla.
     *
     * @param key A tecla em questão.
     * @return O estado atual da tecla.
     */
    public static boolean segurandoTecla(int key) {
        return Raylib.IsKeyPressed(key) || Raylib.IsKeyPressedRepeat(key);
    }

    /**
     * Divide um Vector2 por um determinado número.
     *
     * @param vetor O vetor a ser divido.
     * @param divisor O número divisor.
     * @return O novo vetor já dividido.
     */
    public static Raylib.Vector2 divideVetor(
        Raylib.Vector2 vetor,
        float divisor
    ) {
        return Raylib.Vector2Divide(vetor, new Vector2().x(divisor).y(divisor));
    }
}
