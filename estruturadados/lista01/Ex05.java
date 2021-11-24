package estruturadados.lista01;

import java.util.Scanner;
import java.util.Stack;

    /* Questão 5 da Lista 1 de EDD1
    Escreva um programa que leia uma sequência de caracteres e determine se os
    parênteses, colchetes e chaves estão balanceados. Se a sequência não possuir esses
    caracteres ele deve ser considerado balanceado. Exemplo:
    “{ab}[cde]” - Balanceado
    “{ab[cd]efg}” - Balanceado
    “[abcde{efg]}” - Não balanceado */

public class Ex05 {
    public static boolean balanceado(String sequencia) {
        Stack<Character> stack = new Stack<>(); // usei a API Stack ao invés de usar a classe Pilha

        // parênteses, colchetes e chaves...
        char abre1 = '(';
        char abre2 = '[';
        char abre3 = '{';

        char fecha1 = ')';
        char fecha2 = ']';
        char fecha3 = '}';

        // loop que varre a sequência
        for (int i = 0; i < sequencia.length(); i++) {
            // empilha os caracteres de abertura: ( [ {
            if (sequencia.charAt(i) == abre1) {
                stack.push(abre1);
            } else if (sequencia.charAt(i) == abre2) {
                stack.push(abre2);
            } else if (sequencia.charAt(i) == abre3) {
                stack.push(abre3);
            }

            else if (sequencia.charAt(i) == fecha1) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.pop() != abre1) {
                    return false;
                }
            }

            else if (sequencia.charAt(i) == fecha2) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.pop() != abre2) {
                    return false;
                }
            }

            else if (sequencia.charAt(i) == fecha3) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.pop() != abre3) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // leitura da sequência
        System.out.println("Insira uma sequência de caracteres: ");
        String sequencia = scan.nextLine();

        // verificação
        if (balanceado(sequencia)) {
            System.out.println("A sequência está balanceada.");
        } else {
            System.out.println("A sequência não está balanceada.");
        }
    }
}
