package estruturadados.lista01;

import java.util.Scanner;
import java.util.Stack;

// TODO: 23/11/2021 colocar a parte do código em um método verifica()

    /* Questão 5 da Lista 1 de EDD1
    Escreva um programa que leia uma sequência de caracteres e determine se os
    parênteses, colchetes e chaves estão balanceados. Se a sequência não possuir esses
    caracteres ele deve ser considerado balanceado. Exemplo:
    “{ab}[cde]” - Balanceado
    “{ab[cd]efg}” - Balanceado
    “[abcde{efg]}” - Não balanceado */

public class Ex05 {
    public static boolean balanceado() {
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // leitura da sequencia
        System.out.println("Insira uma sequência de caracteres: ");
        String sequencia = scan.nextLine();


        Stack<Character> stack = new Stack<>();

        //
        char abre1 = '(';
        char abre2 = '[';
        char abre3 = '{';

        char fecha1 = ')';
        char fecha2 = ']';
        char fecha3 = '}';
        
        //
        boolean ehBalanceado = true;

        //
        for (int i = 0; i < sequencia.length(); i++) {
            //
            if (sequencia.charAt(i) == abre1) {
                stack.push(abre1);
            } else if (sequencia.charAt(i) == abre2) {
                stack.push(abre2);
            } else if (sequencia.charAt(i) == abre3) {
                stack.push(abre3);
            }

            //
            else if (sequencia.charAt(i) == fecha1) {
                if (stack.isEmpty()) {
                    ehBalanceado = false;
                    break;
                }
                if (stack.pop() != abre1) {
                    ehBalanceado = false;
                    break;
                }
            }

            //
            else if (sequencia.charAt(i) == fecha2) {
                if (stack.isEmpty()) {
                    ehBalanceado = false;
                    break;
                }
                if (stack.pop() != abre2) {
                    ehBalanceado = false;
                    break;
                }
            }

            //
            else if (sequencia.charAt(i) == fecha3) {
                if (stack.isEmpty()) {
                    ehBalanceado = false;
                    break;
                }
                if (stack.pop() != abre3) {
                    ehBalanceado = false;
                    break;
                }
            }
        }

        //
        if (ehBalanceado) {
            System.out.println("A sequência está balanceada.");
        } else {
            System.out.println("A sequência não está balanceada.");
        }
    }
}
