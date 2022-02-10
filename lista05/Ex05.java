package lista05;

    /* 5) Para a classe ListaDuplamente, crie um método que use recursão para verificar se a
    lista corrente, isto é, para a qual o método é chamado, é igual a uma lista lista2 passada
    como parâmetro. Note que você pode criar um ou mais métodos auxiliares. O método deve
    obedecer ao seguinte protótipo:
    public boolean verificaIgualdade(ListaDuplamente lista2); */

public class Ex05 {
    // Complexidade: O(m * n), pois percorre as duas listas, verificando
    // se os elementos de mesmo índice são iguais ou não.

    public static void main(String[] args) {
        ListaDuplamente lista1 = new ListaDuplamente();
        ListaDuplamente lista2 = new ListaDuplamente();

        lista1.insere(3);
        lista1.insere(5);
        lista1.insere(7);

        System.out.println("Lista 1:");
        lista1.imprime();

        lista2.insere(3);
        lista2.insere(5);
        lista2.insere(7);

        System.out.println("Lista 2");
        lista2.imprime();

        if (lista1.verificaIgualdade(lista2)) {
            System.out.println("Correntes");
        } else {
            System.out.println("Diferentes");
        }
    }
}
