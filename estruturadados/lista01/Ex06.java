package estruturadados.lista01;

import java.util.Scanner;
import java.util.Stack;

// tirando o erro do retorno, tá tudo funcionando normalmente...

public class Ex06 {
    public static void reverteFrase(String frase) {
        Stack<Character> pilha = new Stack<>();

        char[] fraseInvertida = new char[frase.length()];
        int count = 0;

        // TODO: 22/11/2021 consertar o erro de não conseguir retornar a frase pra main
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

    public static void main(String[] args) { // Ex06 da Lista 1 de EDD1
        Scanner scan = new Scanner(System.in);

        String frase;

        System.out.println("Frase a ser invertida: ");
        frase = scan.nextLine();

        reverteFrase(frase);
    }
}
