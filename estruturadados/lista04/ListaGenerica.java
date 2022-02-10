package estruturadados.lista04;

public class ListaGenerica<T> {
    /* Referência para primeiro elemento */
    protected Elo prim;
    protected Elo tail; //

    protected class Elo {
        protected T dado;
        protected Elo prox;

        public Elo() {
            prox = null;
        }

        public Elo(T elem) {
            dado = elem;
            prox = null;
        }

        public Elo(T elem, Elo proxElem) {
            dado = elem;
            prox = proxElem;
        }
    }

    public ListaGenerica() {
        prim = null;
    }

    /* Testa se a lista está vazia. */
    public boolean vazia() {
        return prim == null;
    }

    /* Insere elemento no início da lista. */
    public void insere(T novo) {
        Elo p = new Elo(novo);
        p.prox = prim;
        prim = p;
    }

    /* Verifica se um determinado elemento está na lista. */
    public boolean busca(T elem) {
        Elo p;

        for (p = prim; p != null; p = p.prox) {
            if (p.dado == elem)
                return true;
        }

        return false;
    }

    /* Implementação recursiva do método de busca. */
    public boolean buscaRecursiva(T elem) {
        if (this.vazia())
            return false;

        return buscaRecursiva(elem, prim);
    }

    private boolean buscaRecursiva(T elem, Elo p) {
        if (p == null)
            return false;

        if (p.dado == elem)
            return true;

        return buscaRecursiva(elem, p.prox);
    }

    /* Remove da lista o primeiro elemento com valor igual a “elem". Ret. true se removeu. */
    public boolean remove(T elem) {
        Elo p;
        Elo ant = null; /* Referência para anterior. */

        for (p = prim; ((p != null) && (p.dado != elem)); p = p.prox)
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

    /* Imprime todos os elementos da lista. */
    public void imprime() {
        Elo p;

        System.out.println("Nomes em ordem alfabética:");

        for (p = prim; p != null; p = p.prox) {
            System.out.print(p.dado + " ");
        }

        System.out.println();
    }

    /* Implementação recursiva da função de impressão. */
    public void imprimeRecursivo() {
        System.out.println("Elementos da lista:");

        if (this.vazia())
            return;

        imprimeRecursivo(prim);

        System.out.println();
    }

    private void imprimeRecursivo(Elo p) {
        if (p == null)
            return;

        System.out.print(p.dado + " ");

        imprimeRecursivo(p.prox);
    }

    /* Calcula e retorna o tamanho da lista. */
    public int tamanho() {
        int tam = 0;
        Elo p = prim;

        while (p != null) {
            tam++;
            p = p.prox;
        }

        return tam;
    }

    /* Calcula e retorna o tamanho da lista de maneira recursiva. */
    public int tamanhoRecursivo() {
        if (this.vazia())
            return 0;

        return tamanhoRecursivo(prim);
    }

    private int tamanhoRecursivo(Elo p) {
        if (p == null)
            return 0;

        return 1 + tamanhoRecursivo(p.prox);
    }

    /////// QUESTÃO 04
    // Ao invés de cada novo elemento ser inserido no início da lista, são inseridos ao final,
    // fazendo com que a frase fique na ordem
    public void insereFim(T novo) {
        Elo p = new Elo(novo);

        if (prim == null) {
            prim = p;
            tail = p;
        } else {
            tail.prox = p;
            tail = p;
        }
    }

    public void imprimeFim() { // QUESTÃO 04
        Elo current = prim;
        if (prim == null) {
            System.out.println("Lista vazia");
            return;
        }
        while (current != null) {
            System.out.print(current.dado);
            current = current.prox;
        }
    }
}
    //////////////

