package lista05;

    /* Dadas duas listas duplamente encadeadas L1 e L2, sem elementos repetidos,
    implemente um método estático que realize a interseção das duas listas, criando uma
    terceira lista L3 contendo a interseção entre as duas listas. */

public class Ex01 {
    // Complexidade: O(m * n), pois percorre as duas listas l1 e l2 enquanto confere quais elementos
    // estão presentes em ambas as listas. m e n referem-se ao tamanho de cada uma das listas.

    public static void main(String[] args) {

        ListaDuplamente lista1 = new ListaDuplamente();
        ListaDuplamente lista2 = new ListaDuplamente();
        ListaDuplamente listaIntersecao = new ListaDuplamente();

        lista1.insere(1);
        lista1.insere(2);
        lista1.insere(3);
        lista1.insere(4);
        lista1.insere(8);

        System.out.println("Lista 1:");
        lista1.imprime();

        lista2.insere(2);
        lista2.insere(3);
        lista2.insere(6);
        lista2.insere(8);
        lista2.insere(10);

        System.out.println("Lista 2:");
        lista2.imprime();

        listaIntersecao.intersecao(lista1.prim, lista2.prim);

        System.out.println("Interseção entre as duas listas:");
        listaIntersecao.imprime();
    }
}
