package estruturadados.lista06;

public class Conj
{
    private Elo prim;  /* Referência para primeiro elemento. */

    /* Classe auxiliar para guardar cada elemento do conjunto. */
    private class Elo {
        int dado;
        Elo prox;

        public Elo() {
            prox = null;
        }

        public Elo(int elem)
        {
            dado = elem;
            prox = null;
        }

        public Elo(int elem, Elo prox_elem) {
            dado = elem;
            prox = prox_elem;
        }
    }

    public Conj(){
        prim = null;
    }

    /* Função privada para realizar uma cópia de um outro conjunto. */
    private void copia(Conj cj2) {
        Elo ult = null, q;

        prim = null;
        for (Elo p = cj2.prim; p != null; p = p.prox) {
            q = new Elo(p.dado);
            if (ult == null)
                prim = q;
            else
                ult.prox = q;
            ult = q;
        }
    }

    /* Função privada para realizar uma cópia de um outro conjunto. */
    public void apaga() {
        for (Elo p = prim; p != null; p = prim){
            prim = prim.prox;
            p.prox = null;
        }
    }

    /* Simula uma sobrecarga do operador de atribuição. */
    public Conj atribui(Conj cj2) {
        if (this != cj2) {
            apaga();
            copia(cj2);
        }

        return this;
    }

    /* Testa se o conjunto está vazio. */
    public boolean vazio() {
        return prim == null;
    }

    /* Teste de pertinência. Usa fato de estar ordenado */
    public boolean pertence(int valor) {
        Elo p;

        for (p = prim; ((p != null) && (p.dado < valor)); p = p.prox);

        if ((p == null) || (p.dado > valor)) return false;

        return true;
    }

    /* Inserção de elemento no conjunto. Usa fato de estar ordenado.
       Retorna false se elemento já estava lá. */
    public boolean insere(int valor) {
        Elo p = prim, ant = null;

        for (p = prim; (p != null); p = p.prox) {
            if (p.dado == valor) return false;
            if (p.dado > valor) break;
            ant = p;
        }
        Elo q = new Elo(valor);
        if (p == prim)
            prim = q;
        else
            ant.prox = q;
        q.prox = p;
        return true;
    }

    /* Remoção de elemento do conjunto. Usa fato de estar ordenado.
       Retorna false se elemento não estava lá. */
    public boolean remove(int valor) {
        Elo p = prim, ant = null;

        for (p = prim; (p != null); p = p.prox){
            if (p.dado > valor) return false;
            if (p.dado == valor) break;
            ant = p;
        }
        if (p == null) return false;
        if (p == prim)
            prim = prim.prox;
        else
            ant.prox = p.prox;

        p = null;
        return true;
    }

    /* Método para união de conjuntos. Une conjunto com cj2 e retorna novo conjunto com a união.
     * Usa fato de conjuntos estarem ordenados e percorre as listas em paralelo. */
    public Conj uniao(Conj cj2)
    {
        Elo q, p1 = prim, p2 = cj2.prim, ult = null;
        Conj uniao = new Conj();
        while ( (p1 != null) || (p2 != null) )
        {
            if ( (p1 != null) && ( (p2 == null) || (p1.dado < p2.dado)))
            {
                q = new Elo(p1.dado);
                p1 = p1.prox;
            }
            else
            {
                q = new Elo(p2.dado);
                if ((p1 != null) && (p1.dado == p2.dado))
                    p1 = p1.prox;
                p2 = p2.prox;
            }

            if (ult == null)
                uniao.prim = q;
            else
                ult.prox = q;

            ult = q;
        }

        return uniao;
    }

    /* Método para intersecao de conjuntos. Calcula intersecao do conjunto com cj2 e retorna novo conjunto com a intersecao.
     * Usa fato de conjuntos estarem ordenados e percorre as listas em paralelo. */
    public Conj intersecao(Conj cj2)
    {
        Elo q, p1 = prim, p2 = cj2.prim, ult = null;
        Conj inter = new Conj();

        while ( (p1 != null) && (p2 != null) )
        {
            if (p1.dado < p2.dado)
            {
                p1 = p1.prox;
            }
            else if(p2.dado < p1.dado)
            {
                p2 = p2.prox;
            }
            else
            {
                q = new Elo(p1.dado);
                p1 = p1.prox;
                p2 = p2.prox;

                if (ult == null)
                    inter.prim = q;
                else
                    ult.prox = q;

                ult = q;
            }
        }

        return inter;
    }

    /* Retorna cardinalidade do conjunto */
    public int tamanho() {
        int tam = 0;
        Elo p;

        for(p = prim; p != null; p = p.prox)
            tam++;
        return tam;
    }

    /* Imprime todos os elementos do conjunto */
    public void imprime() {
        Elo p;
        System.out.println("Elementos do conjunto");
        for(p = prim; p != null; p = p.prox)
            System.out.print(p.dado + " ");
        System.out.println();
    }

    // QUESTÃO 01 - LISTA 06
    public int menorElemento() {
        if (prim == null) {
            return 0;
        }
        return prim.dado;
    }

    public int maiorElemento() {

        Elo ultimo = prim;

        /*while (ultimo.prox != null) {
            ultimo = ultimo.prox;
        }*/


        return ultimo.dado;
    }
}