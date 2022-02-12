package estruturadados.lista06;

    /* 2. Desenvolva um método ConjGenerico<T> complementar(ConjGenerico<T>
    universo) que receba um conjunto universo e retorne o complementar do conjunto
    cujo método foi chamado. Se o conjunto original possuir elementos de fora do
    conjunto universo informado o método deve lançar uma exceção. */

public class Ex02 {
    // Complexidade: O(n), em que n é o tamanho do conjunto universo. O conjunto universo é varrido juntamente do conjunto
    // pelo qual o método foi chamado até que se descubra todos os elementos que não fazem parte desse último.

    public static void main(String[] args) {
        ConjGenerico<Integer> conj1 = new ConjGenerico<>();
        ConjGenerico<Integer> conj2;
        ConjGenerico<Integer> conjUniverso = new ConjGenerico<>();

        conj1.insere(1);
        conj1.insere(3);
        conj1.insere(5);
        conj1.insere(7);
        conj1.insere(9);

        System.out.println("Conjunto 1: ");
        conj1.imprime();

        conjUniverso.insere(1);
        conjUniverso.insere(2);
        conjUniverso.insere(3);
        conjUniverso.insere(4);
        conjUniverso.insere(5);
        conjUniverso.insere(6);
        conjUniverso.insere(7);
        conjUniverso.insere(8);
        conjUniverso.insere(9);

        System.out.println("Conjunto universo:");
        conjUniverso.imprime();

        conj2 = conj1.complementar(conjUniverso);

        System.out.println("Complementar do Conjunto 1:");
        conj2.imprime();
    }
}
