package estruturadados.lista04;

public class ListaOrdenada extends Lista
{
    public void insere(int novo) {
        Elo p, q;
        Elo ant = null;

        q = new Elo(novo);

        for (p = prim; ((p != null) && (p.dado < novo)); p = p.prox)
            ant = p;

        if (ant == null)
            prim = q;
        else
            ant.prox = q;

        q.prox = p;
    }

    /* Remove da lista o primeiro elemento com valor igual a “elem". Ret. true se removeu. */
    public boolean remove(int elem)
    {
        Elo p;
        Elo ant = null; /* referência para anterior */

        for(p = prim; ((p != null) && (p.dado < elem)); p = p.prox)
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

    /////////////////////////////////////////////////////////////////////////////////////////
    /* QUESTÃO 2 */
    public Elo intercalaOrdenada(Elo prim1, Elo prim2) {

        Elo dummyElo = new Elo(0);

        Elo tail = dummyElo;

        while (true) {
            if (prim1 == null) {
                tail.prox = prim2;
                break;
            }
            if (prim2 == null) {
                tail.prox = prim1;
                break;
            }

            //
            if (prim1.dado <= prim2.dado) {
                tail.prox = prim1;
                prim1 = prim1.prox;
            } else {
                tail.prox = prim2;
                prim2 = prim2.prox;
            }

            tail = tail.prox;
        }

        return dummyElo.prox;
    }

    public void intercala(ListaOrdenada l1, ListaOrdenada l2) {
        l1.imprime();
        l2.imprime();

        l1.prim = intercalaOrdenada(l1.prim, l2.prim);

        l1.imprime();
    }

    /////////////////////////////////////////////////////////////////////////////////////////
}