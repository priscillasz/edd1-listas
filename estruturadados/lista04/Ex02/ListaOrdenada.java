package estruturadados.lista04.Ex02;

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
    // QUESTÃO 2
    Elo sortedMerge(Elo headA, Elo headB) {

        Elo dummyElo = new Elo(0);

        Elo tail = dummyElo;

        while (true) {
            if (headA == null) {
                tail.prox = headB;
                break;
            }
            if (headB == null) {
                tail.prox = headA;
                break;
            }

            //
            if (headA.dado <= headB.dado) {
                tail.prox = headA;
                headA = headA.prox;
            } else {
                tail.prox = headB;
                headB = headB.prox;
            }

            tail = tail.prox;
        }

        return dummyElo.prox;
    }

    public void merge(ListaOrdenada l1, ListaOrdenada l2) {
        l1.imprime();
        l2.imprime();

        l1.prim = sortedMerge(l1.prim, l2.prim);

        l1.imprime();
    }

    /////////////////////////////////////////////////////////////////////////////////////////
}