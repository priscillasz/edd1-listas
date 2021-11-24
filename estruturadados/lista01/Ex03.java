package estruturadados.lista01;

/* Questão 3 da Lista 1 de EDD1
* Desenvolva um método para manter duas pilhas dentro de um único vetor (array) de
modo que nenhuma das pilhas incorra em estouro até que toda a memória seja usada, e
toda uma pilha nunca seja deslocada para outro local dentro do vetor. */

public class Ex03 {
    public static void main(String[] args) {
        Pilha2x pilha = new Pilha2x(10);

        pilha.push1(1);
        pilha.push2(10); //
        pilha.push1(2);
        pilha.push2(9); //
        pilha.push1(3);
        pilha.push2(8); //
        pilha.push1(4);
        pilha.push2(7); //
        pilha.push1(5);
        pilha.push2(6); //
        pilha.push2(15);

        System.out.println(pilha);


    }
}
