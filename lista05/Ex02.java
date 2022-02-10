package lista05;

    /* 2) Para a classe Lista Circular, crie um método para concatenar alternadamente
    elementos da lista corrente, para a qual o método é chamado, com a lista lista2 recebida
    como parâmetro. O resultado da operação deve ser colocado em uma terceira lista que será
    retornada. O protótipo do método é o seguinte:
    public ListaCircular merge(ListaCircular lista2); */

public class Ex02 {
    // Complexidade: O(m * n), pois percorre as duas listas, enquanto adiciona seus elementos
    // de forma alternada em uma terceira lista. m e n referem-se ao tamanho de cada uma das listas.

    public static void main(String[] args) {
        ListaCircular lista1 = new ListaCircular();
        ListaCircular lista2 = new ListaCircular();

        ListaCircular listaIntercalada = new ListaCircular();

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

        listaIntercalada = lista1.merge(lista2);

        System.out.println("Lista intercalada:");
        listaIntercalada.imprime();


    }
}
