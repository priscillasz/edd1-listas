package lista05;

    /* 4) Para a classe ListaDuplamente, crie um método que troque a posição de dois elos
    cujas posições na lista são passadas como parâmetros. O protótipo do método é o seguinte:
    public void trocaElos(int indiceElo1, int indiceElo2); */

public class Ex04 {
    // Complexidade: O(n), pois percorre a mesma lista duas vezes.

    public static void main(String[] args) {
        ListaDuplamente lista = new ListaDuplamente();

        lista.insere(1);
        lista.insere(3);
        lista.insere(5);
        lista.insere(7);
        lista.insere(9);
        lista.insere(11);
        lista.insere(13);

        System.out.println("Lista inicial:");
        lista.imprime();

        lista.trocaElos(3, 7);

        System.out.println("Lista após trocar os elos:");
        lista.imprime();
    }
}
