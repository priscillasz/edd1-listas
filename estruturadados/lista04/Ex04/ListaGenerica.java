package estruturadados.lista04.Ex04;

public class ListaGenerica<T> {
    /* Referência para primeiro elemento */
    protected Elo prim;
    protected Elo tail; //

    protected class Elo {
        protected T dado;
        protected Elo prox;

        public Elo()
        {
            prox = null;
        }

        public Elo(T elem)
        {
            dado = elem;
            prox = null;
        }

        public Elo(T elem, Elo proxElem) {
            dado = elem;
            prox = proxElem;
        }
    }

    public ListaGenerica()
    {
        prim = null;
    }

    /* Testa se a lista está vazia. */
    public boolean vazia()
    {
        return prim == null;
    }

    /* Insere elemento no início da lista. */
    public void insere(T novo) {
        Elo p = new Elo(novo);
        p.prox = prim;
        prim = p;
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
    //////////////
}
