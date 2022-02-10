package lista05;

public class ListaCircular extends Lista
{
    /* Imprime todos os elementos da lista */
    public void imprime() {
        Elo p;

        p = prim;

        if (p != null)
        {
            do
            {
                System.out.print(p.dado + " ");
                p = p.prox;

            } while (p != prim);
        }

        System.out.println();
    }

    public void imprimeRecursivo()
    {
        System.out.println("Elementos da lista:");

        if(this.vazia())
            return;

        imprimeRecursivo(prim);

        System.out.println();
    }

    private void imprimeRecursivo(Elo p) {
        System.out.print(p.dado + " ");

        if(p.prox == prim)
            return;

        imprimeRecursivo(p.prox);
    }

    public int tamanho() {
        int tamanho = 0;
        Elo p;
        p = prim;

        if (p != null) {
            do {
                p = p.prox;
                tamanho++;
            } while(p != prim);
        }
        return tamanho;
    }

    /* Insere elemento no fim da lista. */
    public void insere(int novo)
    {
        Elo p, q;
        q = new Elo(novo);
        p = prim;

        if (p != null)
        {
            /* Percorre até alcancar o início. */
            while (p.prox != prim)
            {
                p = p.prox;
            }

            p.prox = q;
            q.prox = prim;
        }
        else
        {
            prim = q;
            prim.prox = q;
        }
    }

    public boolean remove(int elem)
    {
        Elo p = null;
        Elo ant = null;

        if (prim == null) return false;

        for( p = prim; ( (p.prox != prim ) && (p.dado != elem) ); p = p.prox)
            ant = p;

        /* Achou */
        if ( p.dado == elem )
        {
            /* É o primeiro */
            if ( p == prim )
            {
                /* É o único */
                if ( prim == prim.prox )
                {
                    prim = null;
                }
                else
                {
                    /* Guarda o anterior ao primeiro */
                    for( ant = prim; ( ant.prox != prim ); ant = ant.prox);

                    ant.prox = prim.prox;
                    prim = prim.prox;
                }
            }
            else
            {
                /* No meio */
                ant.prox = p.prox;
            }

            /* Remove a última referência para o elo a ser removido. Dessa forma,
             * o Garbage Collector irá liberar essa memória. */
            p = null;

            return true;
        }
        else
            return false;
    }

    // QUESTÃO 02 - LISTA 05
    public ListaCircular merge(ListaCircular lista2) {
        ListaCircular listafinal = new ListaCircular();

        Elo prim1 = prim;
        Elo prim2 = lista2.prim;

        int count1 = 0;
        int count2 = 0;

        int tamanho = this.tamanho() + lista2.tamanho();

        while((count1+count2) < tamanho) {
            if (prim1 != null && count1 < tamanho()) {
                listafinal.insere(prim1.dado);
                prim1 = prim1.prox;
                count1++;
            }
            if (prim2 != null && count2 < lista2.tamanho()) {
                listafinal.insere(prim2.dado);
                prim2 = prim2.prox;
                count2++;
            }
        }
        return listafinal;
    }

    // QUESTÃO 03 - LISTA 05
    public ListaCircular inverteLista() {
        if (prim == null) {
            return null;
        }

        Elo anterior = null;
        Elo atual = prim;
        Elo proximo;

        do {
            proximo = atual.prox;
            atual.prox = anterior;
            anterior = atual;
            atual = proximo;
        } while (atual != prim);

        prim.prox = anterior;
        prim = anterior;

        return this;
    }

    ///////////////////////////////////////

    /* Resolução da questão 3 da lista auxiliar de Lista Encadeada. */
    public Lista separa(int n)
    {
        Lista l2 = new Lista();

        Elo p = prim;

        /* Loop para encontrar o elo cujo atributo dado tenha valor "n". */
        do
        {
            /* Encontrou o elemento desejado. */
            if(p.dado == n)
                break;

            p = p.prox;

        } while (p != prim);

        /* Caso tenha percorrido a lista sem encontrar o elemento. */
        if(p.dado != n)
            return null;

        /* O "prim" da nova lista é o próximo do elo apontado por p. */
        l2.prim = p.prox;

        /* O próximo do elo apontado por p tem que apontar para o prim da
         * lista original. */
        p.prox = prim;

        Elo q;

        /* Anda até o último elemento da lista 2. */
        for(q = l2.prim; q.prox != prim; q = q.prox);

        /* O próximo do último elemento da lista 2 aponta para o primeiro. */
        q.prox = l2.prim;

        /* Retorna a nova lista construída. */
        return l2;
    }
}