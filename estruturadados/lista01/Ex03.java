package estruturadados.lista01;

// Questão 3 da Lista 1 de EDD1
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
