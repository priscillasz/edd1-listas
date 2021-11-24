package estruturadados.lista01;

/* Questão 3 da Lista 1 de EDD1
* Desenvolva um método para manter duas pilhas dentro de um único vetor (array) de
modo que nenhuma das pilhas incorra em estouro até que toda a memória seja usada, e
toda uma pilha nunca seja deslocada para outro local dentro do vetor. */

public class Ex03 {
    public static void main(String[] args) {
        DuasPilhas pilha = new DuasPilhas(10);

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
        pilha.push2(15); //
        pilha.push1(11);
        pilha.push1(15);
        pilha.push1(123);
        //pilha.pop1();
        //pilha.pop1();
        //pilha.pop2();
        //pilha.pop2();

        System.out.println(pilha);

        if (pilha.overflow()) {
            System.out.println("Estouro!");
        } else {
            System.out.println("Não houve estouro ainda.");
        }
    }
}
