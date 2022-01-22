package estruturadados.lista04.Ex02;

/* 2) Elabore um algoritmo que, dadas duas listas encadeadas ordenadas, intercale as duas
listas de forma que a lista resultante seja também ordenada.*/

public class Ex02 {
    /* Complexidade: O(m+n), pois as duas listas (lista1 e lista2) estão sendo percorridas.
        No caso, m e n correspondem ao tamanho de cada uma dessas listas. */

    public static void main(String[] args) {
        ListaOrdenada lista1 = new ListaOrdenada();
        ListaOrdenada lista2 = new ListaOrdenada();

        lista1.insere(10);
        lista1.insere(15);
        lista1.insere(5);

        lista2.insere(3);
        lista2.insere(2);
        lista2.insere(20);

        lista1.merge(lista1, lista2);
    }
}
