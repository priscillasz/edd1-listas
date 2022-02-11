package estruturadados.lista06;

/* 3. A partir da versão de ConjGenerico criada no exercício 2, desenvolva um método
boolean subconjunto(ConjGenerico<T> conj2) que receba outro conjunto e retorne o
true se o conjunto cujo método foi chamado é subconjunto próprio de conj2 e false
em caso contrário. */

public class Ex03 {
    // Complexidade:

    public static void main(String[] args) {
        ConjGenerico<Integer> conj1 = new ConjGenerico<>();
        ConjGenerico<Integer> conj2 = new ConjGenerico<>();

        conj1.insere(1);
        conj1.insere(3);
        conj1.insere(5);
        conj1.insere(7);
        conj1.insere(9);

        conj2.insere(3);
        conj2.insere(5);
    }
}
