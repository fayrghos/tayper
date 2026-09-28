package utils;

/**
 * Implementa contagens cíclicas de números inteiros.
 */
public class CicloInteiro {

    public int atual;
    public int min;
    public int max;

    /**
     * Cria um novo contador cíclico de inteiros.
     *
     * @param inicial O valor inicial do contador.
     * @param min O valor mínimo do contador.
     * @param max O valor máximo do contador.
     */
    public CicloInteiro(int inicial, int min, int max) {
        this.atual = inicial;
        this.min = min;
        this.max = max;
    }

    /**
     * Incrementa o contador de maneira cíclica.
     * @param fator O valor do incremento.
     */
    public void incrementar(int fator) {
        this.atual += fator;

        if (this.atual > this.max) {
            this.atual = this.min;
        } else if (this.atual < this.min) {
            this.atual = this.max;
        }
    }
}
