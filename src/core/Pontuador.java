package core;

/**
 * Implementa contagens de inteiros.
 */
public final class Pontuador {

    private int pontuacao;
    private int sequencia = 1;
    private final int SEQUENCIA_MAX = 16;

    /**
     * Cria uma nova instância de pontuador com valor inicial.
     *
     * @param inicial O valor inicial.
     */
    public Pontuador(int inicial) {
        this.pontuacao = inicial;
    }

    /**
     * Cria uma nova instância de um pontuador.
     */
    public Pontuador() {
        this(0);
    }

    /**
     * Alterar o contador para uma pontuação específica.
     *
     * @param novaPontuacao A nova pontuação.
     */
    public void definir(int novaPontuacao) {
        pontuacao = novaPontuacao > 0 ? novaPontuacao : 0;
    }

    /**
     * Incrementa o contador.
     *
     * @param incremento O incremento.
     */
    public void incrementar(int incremento) {
        definir(pontuacao + incremento * sequencia);
        if (sequencia < SEQUENCIA_MAX) {
            sequencia++;
        }
    }

    /**
     * Reinicia a sequência de combo.
     */
    public void reiniciarSequencia() {
        sequencia = 1;
    }

    /**
     * Obtem a pontuação do jogador.
     * @return A pontuação do jogador.
     */
    public int pontuacaoAtual() {
        return pontuacao;
    }

    public int sequenciaAtual() {
        return sequencia;
    }
}
