package estruturadados.lista01;

import java.util.Scanner;
import java.util.Stack;

    /* Questão 6 da Lista 1 de EDD1
    * Elabore um método que retorne as letras invertidas das palavras de uma frase recebida
    por parâmetro, preservando a ordem das palavras na frase. Por exemplo “a maçã está
    podre”, deve ter como saída: “a ãçam átse erdop”. As operações básicas de uma pilha,
    push e pop, devem ser usadas */

public class Ex06 {
    public static void inverteFrase(String frase) { // coloquei o método como void pq ele não estava retornando a string corretamente
        Stack<Character> pilha = new Stack<>();

        char[] fraseInvertida = new char[frase.length()];
        int count = 0;

        for (int i = 0; i < frase.length(); i++) {
            // empilha as letras de uma palavra de cada vez
            for (; i < frase.length() && frase.charAt(i) != ' '; i++) {
                pilha.push(frase.charAt(i));
            }

            // desempilha em seguida
            while (!pilha.isEmpty()) {
                if (frase.charAt(count) != ' ') {
                    fraseInvertida[count] = pilha.pop();
                } else {
                    fraseInvertida[count] = ' '; // acrescenta os espaços que foram ignorados no push
                }
                count++;
            }
        }
        System.out.println(fraseInvertida);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String frase;

        System.out.println("Frase a ser invertida: ");
        frase = scan.nextLine();

        inverteFrase(frase);
    }
}
