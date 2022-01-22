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

    public boolean efetuarDano(Inimigo inimigo, double dano) {
        // dano precisa ser um valor maior ou igual a zero
        if (dano < 0) {
            System.out.println("Entrada inválida");
            return false;
        }
        if (dano >= inimigo.getVida()) { // se o dano for maior ou igual a vida do inimigo, ele é removido
            remover(inimigo);
            System.out.println("Inimigo removido.");
            return false;
        } else if (inimigo.getVida() == 0) { // se a vida do inimigo estiver em 0, ele também é removido
            remover(inimigo);
            System.out.println("Inimigo removido.");
            return false;
        }

        int novaVida = inimigo.getVida() - (int) dano;
        inimigo.setVida(novaVida);
        System.out.println("Vida restante: "+inimigo.getVida());
        return true;
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

    public void imprime() {
        Elo p;
        
        int i = 1;
        System.out.println("Lista de inimigos:");
        for(p = prim; p != null; p = p.prox) {
            System.out.print("Inimigo "+ i + ": "+ p.dado + " ");
            System.out.println();
            i++;
        }

        System.out.println();
    }
}

