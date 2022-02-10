package lista05;

public class ListaDuplamente {
    /* Referência para primeiro elemento */
    protected Elo prim;

    protected class Elo {
        protected int dado;
        protected Elo ant;
        protected Elo prox;

        public Elo() {
            ant = null;
            prox = null;
        }

        public Elo(int elem) {
            dado = elem;
            ant = null;
            prox = null;
        }

        public Elo(int elem, Elo antElem, Elo proxElem) {
            dado = elem;
            ant = antElem;
            prox = proxElem;
        }
    }

    public ListaDuplamente() {
        prim = null;
    }

    /* Testa se a lista está vazia. */
    public boolean vazia() {
        return prim == null;
    }

    /* Insere elemento no início da lista. */
    public void insere(int novo) {
        Elo p;

        p = new Elo(novo);

        p.prox = prim;

        p.ant = null;

        if (prim != null)
            prim.ant = p;

        prim = p;
    }

    /* Método auxiliar para busca. */
    private Elo busca(int elem) {
        Elo p = null;

        for (p = prim; ((p != null) && (p.dado != elem)); p = p.prox) ;

        return p;
    }

    /* Remove da lista o primeiro elemento com valor igual a "elem". Retorna true se removeu. */
    public boolean remove(int elem) {
        Elo p = null;
        p = busca(elem);

        if (p == null) return false;

        /* Retira primeiro elemento */
        if (p == prim)
            prim = prim.prox;
        else
            /* Retira elemento do meio */
            p.ant.prox = p.prox;

        /* Testa se é ultimo elemento */
        if (p.prox != null)
            p.prox.ant = p.ant;

        p = null;

        return true;
    }

    /* Imprime todos os elementos da lista. */
    public void imprime() {
        Elo p;

        for (p = prim; p != null; p = p.prox) {
            System.out.print(p.dado + " ");
        }

        System.out.println();
    }

    /* Imprime todos os elementos da lista em ordem reversa. */
    public void imprimeReversa() {
        Elo p;
        Elo ult = null;

        System.out.println("Elementos da lista em ordem reversa:");

        p = prim;

        while (p != null) {
            ult = p;
            p = p.prox;
        }

        for (p = ult; p != null; p = p.ant) {
            System.out.print(p.dado + " ");
        }

        System.out.println();
    }

    // QUESTÃO 01 - LISTA 5
    public void intersecao(Elo prim1, Elo prim2) {
        Elo head1 = prim1;

        while (head1 != null) {
            if (ehIgual(prim2, head1.dado)) {
                insere(head1.dado);
            }
            head1 = head1.prox;
        }
    }

    public boolean ehIgual(Elo prim1, int dado) {
        Elo head = prim1;

        while (head != null) {
            if (head.dado == dado) {
                return true;
            }
            head = head.prox;
        }
        return false;
    }

    ///////////////

    // QUESTÃO 04 - LISTA 5
    public void trocaElos(int indiceElo1, int indiceElo2) {

        Elo A = prim;
        Elo B = prim;

        Elo trocar1 = prim;
        Elo trocar2 = prim;

        for (int i = 0; i <= indiceElo2; i++) {
            // Se o index i for igual ao indice1 do parâmetro, a variável trocar1 recebe
            // o elo dessa posição
            if (i == indiceElo1) {
                trocar1 = A;
            }

            // Se o index i for igual ao indice2 do parâmetro, a variável trocar2 recebe
            // o elo dessa posição e quebra o loop
            if (i == indiceElo2) {
                trocar2 = B;
                break;
            }

            // toda vez que ocorre uma iteração, a head da lista recebe o próximo elo
            A = A.prox;
            B = B.prox;
        }

        // variável para armazenar temporariamente o dado do primeiro elo a ser trocado
        // enquanto esse mesmo recebe o dado do outro elo.
        // por fim, o segundo elo recebe o dado que foi armazenado na variavel temporaria
        int temp = trocar1.dado;
        trocar1.dado = trocar2.dado;
        trocar2.dado = temp;
    }


    // QUESTÃO 05 - LISTA 05
    public boolean verificaIgualdade(ListaDuplamente lista2) {
        Elo prim1 = this.prim;
        Elo prim2 = lista2.prim;

        while (prim1 != null && prim2 != null) {
            if (prim1.dado != prim2.dado) {
                return false;
            }

            prim1 = prim1.prox;
            prim2 = prim2.prox;
        }
        return (prim1 == null && prim2 == null);
    }

    /* Resolução da questão 4 da lista auxiliar de Lista Encadeada. */
    public static ListaDuplamente concatena(ListaDuplamente l1, ListaDuplamente l2) {
        Elo p;

        /* Verifica se a lista l1 é vazia. */
        if (l1.prim == null) {
            l1.prim = l2.prim;
        } else {
            /* Primeiramente, precisamos obter o último elo da lista l1. */
            for (p = l1.prim; p.prox != null; p = p.prox) ;

            /* Faz o "prox" do último elemento da lista l1, apontado por "p",
             * apontar para o "prim" da lista l2. */
            p.prox = l2.prim;

            /* Faz o "ant" do "prim" da lista l2 apontar para o último elemento da
             * lista l1, apontado por "p". */
            l2.prim.ant = p;
        }

        /* Nesse ponto, os elementos de l2 já estão encadeados ao final de l1,
         * como desejado. Assim, vamos deixar a lista l2 vazia. */
        l2.prim = null;

        return l1;
    }
}
