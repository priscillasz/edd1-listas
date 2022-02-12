package estruturadados.lista06;

    /* 5. Crie uma lógica recursiva para um método retornar true se dois conjuntos forem
    iguais, ou false caso contrário. Utilize o esqueleto (boolean
    igualdadeConjuntos(ConjGenerico<T> conj2)) */

public class Ex05 {
    // Complexidade: O(n), linear, em que n é o tamanho da menor lista entre as duas. A comparação
    // entre as duas listas para quando se encontra um elemento diferente em uma delas.

    public static void main(String[] args) {
        ConjGenerico<Integer> conj1 = new ConjGenerico<>();
        ConjGenerico<Integer> conj2 = new ConjGenerico<>();

        conj1.insere(1);
        conj1.insere(3);
        conj1.insere(5);
        conj1.insere(7);
        conj1.insere(9);

        System.out.println("Conjunto 1:");
        conj1.imprime();

        conj2.insere(1);
        conj2.insere(3);
        conj2.insere(5);
        conj2.insere(7);
        conj2.insere(9);

        // Testar pro caso das listas serem diferentes:
        /* conj2.insere(1);
        conj2.insere(3);
        conj2.insere(5);
        conj2.insere(12);
        conj2.insere(9); */

        System.out.println("Conjunto 2:");
        conj2.imprime();

        if (conj1.igualdadeConjuntos(conj2)) {
            System.out.println("Os conjuntos são iguais.");
        } else {
            System.out.println("Os conjuntos não são iguais.");
        }
    }
}
