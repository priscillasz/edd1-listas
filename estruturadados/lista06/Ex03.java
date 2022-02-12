package estruturadados.lista06;

    /* 3. A partir da versão de ConjGenerico criada no exercício 2, desenvolva um método
    boolean subconjunto(ConjGenerico<T> conj2) que receba outro conjunto e retorne o
    true se o conjunto cujo método foi chamado é subconjunto próprio de conj2 e false
    em caso contrário. */

public class Ex03 {
    // Complexidade: O(n), em que n é o tamanho do conjunto (conj2) que contém ou não contém o outro conjunto (subconjunto conj1).
    // o método boolean subconjunto(ConjGenerico<T> conj2) percorre conj2 checando a existência de cada um dos elementos de conj1 nele.

    public static void main(String[] args) {
        ConjGenerico<Integer> conj1 = new ConjGenerico<>();
        ConjGenerico<Integer> conj2 = new ConjGenerico<>();

        conj2.insere(1);
        conj2.insere(3);
        conj2.insere(5);
        conj2.insere(7);
        conj2.insere(9);

        conj1.insere(3);
        conj1.insere(5);

        if (conj1.subconjunto(conj2)) {
            System.out.println("É subconjunto");
        } else {
            System.out.println("Não é subconjunto");
        }
    }
}
