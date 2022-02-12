package estruturadados.lista06;

    /* 4. Crie um método de esqueleto (diferencaConjunto(ConjGenerico<T> conj2) que
    receba um conjunto e retorne a diferença entre o conjunto que chamou a função e o
    conj2. */

public class Ex04 {
    // Complexidade: O(

    public static void main(String[] args) {
        ConjGenerico<Integer> conj1 = new ConjGenerico<>();
        ConjGenerico<Integer> conj2 = new ConjGenerico<>();
        ConjGenerico<Integer> diferenca;

        conj1.insere(1);
        conj1.insere(3);
        conj1.insere(5);
        conj1.insere(8);
        conj1.insere(7);
        conj1.insere(2);

        System.out.println("Conjunto 1:");
        conj1.imprime();

        conj2.insere(1);
        conj2.insere(3);
        conj2.insere(5);
        conj2.insere(7);
        conj2.insere(9);
        conj2.insere(11);

        System.out.println("Conjunto 2:");
        conj2.imprime();

        diferenca = conj1.diferencaConjunto(conj2);

        System.out.println("Diferença entre conjuntos:");
        diferenca.imprime();
    }
}
