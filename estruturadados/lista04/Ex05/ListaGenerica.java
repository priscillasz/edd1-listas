package estruturadados.lista04.Ex05;

public class ListaGenerica {
    protected Elo prim; /* Referência para primeiro elemento */

    protected class Elo {
        protected String dado;
        protected Elo prox;

        public Elo() {
            prox = null;
        }

        public Elo(String elem) {
            dado = elem;
            prox = null;
        }

        public Elo(String elem, Elo proxElem) {
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
    public void insere(String novo) {
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

    /////////// QUESTÃO 5 /////////////////
    // inverte as letras de cada palavra
    public String invertePalavra(String palavra) {
        String s = "";
        for (int i = 0; i < palavra.length(); i++) {
            s = palavra.charAt(i) + s;
        }
        return s;
    }

    public Elo inverte() {
        Elo inv = prim;

        while (inv != null) {
            inv.dado = invertePalavra(inv.dado);
            inv = inv.prox;
        }
        return prim;
    }
    //////////////////////
}