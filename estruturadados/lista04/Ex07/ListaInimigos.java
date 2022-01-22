package estruturadados.lista04.Ex07;

public class ListaInimigos<Inimigos> {
    protected Elo prim;

    protected class Elo {
        protected Inimigo dado;
        protected Elo prox;

        public Elo()
        {
            prox = null;
        }

        public Elo(Inimigo inimigo)
        {
            dado = inimigo;
            prox = null;
        }

        public Elo(Inimigo inimigo, Elo proxInimigo) {
            dado = inimigo;
            prox = proxInimigo;
        }
    }

    public ListaInimigos() {
        prim = null;
    }

    /* Testa se a lista está vazia. */
    public boolean vazia() {
        return prim == null;
    }

    // Insere inimigo no início da lista
    public void inserir(Inimigo inimigo) {
        Elo p = new Elo(inimigo);
        p.prox = prim;
        prim = p;
    }

    public Inimigo localizar(Inimigo inimigo) {
        return null;
    }

    public int efetuarDano(Inimigo inimigo, double dano) {

        return 0;
    }

    public boolean remover(Inimigo inimigo) {
        Elo p;
        Elo ant = null; /* Referência para anterior. */

        for(p = prim; ((p != null) && (p.dado != inimigo)); p = p.prox)
            ant = p;

        /* Se p é null, então não encontrou elemento. */
        if (p == null)
            return false;

        if (p == prim)
            prim = prim.prox; /* Remove elemento do início. */
        else
            ant.prox = p.prox;  /* Remove elemento do meio. */

        /* Remove a última referência para o elo a ser removido. Dessa forma,
         * o Garbage Collector irá liberar essa memória. */
        p = null;

        return true;
    }
}

