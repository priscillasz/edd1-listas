package estruturadados.lista04.Ex06;

public class Lista<T> {
    /* Referência para primeiro elemento */
    protected Elo prim;

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

    public Lista() {
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

    /* Imprime todos os elementos da lista. */
    public void imprime() {
        Elo p;

        System.out.println("Elementos da lista:");

        for(p = prim; p != null; p = p.prox) {
            System.out.print(p.dado + " ");
        }

        System.out.println();
    }

    /* Implementação recursiva da função de impressão. */
    public void imprimeRecursivo()
    {
        System.out.println("Elementos da lista:");

        if(this.vazia())
            return;

        imprimeRecursivo(prim);

        System.out.println();
    }

    private void imprimeRecursivo(Elo p)
    {
        if(p == null)
            return;

        System.out.print(p.dado + " ");

        imprimeRecursivo(p.prox);
    }

    /*@Override
    public String toString() {
        *//* String result = "";
            LinkedListNode current = head;
            while(current.getNext() != null){
                result += current.getData();
                if(current.getNext() != null){
                     result += ", ";
                }
                current = current.getNext();
            }
            return "List: " + result;*//*
        String result = "";
        Elo p = prim;

        while (p.prox != null) {
            result += p.dado;
            if (p.prox != null) {
                result += ", ";
            }
            p = p.prox;
        }

        return "List: "+result;
    }*/
}