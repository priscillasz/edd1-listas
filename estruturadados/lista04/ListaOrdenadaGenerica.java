package estruturadados.lista04;

public class ListaOrdenadaGenerica<T extends Comparable<T>> extends ListaGenerica<T> {
    public void insere(T novo) {
        Elo p, q;
        Elo ant = null;

        q = new Elo(novo);

        for (p = prim; ((p != null) && p.dado.compareTo(novo) < 0); p = p.prox) // (p.dado < novo)
            ant = p;

        if (ant == null)
            prim = q;
        else
            ant.prox = q;

        q.prox = p;
    }

    /* Remove da lista o primeiro elemento com valor igual a “elem". Ret. true se removeu. */
    public boolean remove(T elem) {
        Elo p;
        Elo ant = null; /* referência para anterior */

        for(p = prim; ((p != null) && (p.dado.compareTo(elem) < 0)); p = p.prox) // p.dado < elem
            ant = p;

        /* Se p é null ou p.dado != elem, então não encontrou elemento. */
        if ((p == null) || (p.dado != elem))
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

