package estruturadados.lista01;

import java.util.Scanner;
import java.util.Stack;

// 1- A expressão infix é convertida para postfix
// 2- O resultado da expressão postfix é computado (com a classe Posfixada)

public class Teste {

    // retorna precedencia do operador
    static int precedencia(char ch)
    {
        switch (ch)
        {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    // converte a expressão infixa para posfixa
    static String conversao(String exp)
    {
        String resultado = new String("");

        Stack<Character> pilha = new Stack<>();

        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);

            if (Character.isLetterOrDigit(c)) { // adiciona os operandos ao output
                resultado += c;
            } else if (c == '(') {  // empilha todos os '('
                pilha.push(c);
            } else if (c == ')') { // desempilha a stack até encontrar um '('
                while (!pilha.isEmpty() && pilha.peek() != '(') {
                    resultado += pilha.pop();
                }
                pilha.pop();
            } else { // se um operador é encontrado
                while (!pilha.isEmpty() && precedencia(c) <= precedencia(pilha.peek())) {
                    resultado += pilha.pop();
                }
                pilha.push(c);
            }
        }

        // desempilha todos os operadores
        while (!pilha.isEmpty()) {
            if(pilha.peek() == '(') {
                return "Invalid Expression";
            }
            resultado += pilha.pop();
        }
        return resultado;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // leitura da expressão infixa
        // não considera espaços em branco ' '
        System.out.println("Insira uma expressão em notação infixa:"); // testei (1+((2+3)*(4*5)))
        String exp = scan.nextLine();

        // converte a expressão infixa para posfixa
        String expConverter = conversao(exp);

        // criação da pilha Posfixada
        Posfixada pos = new Posfixada(100);

        // leitura e avaliação da expressão + impressão do resultado
        pos.leExpressao(expConverter);

        // se a expressão estiver correta, imprime o resultado
        if (pos.avaliaExpressao()) {
            pos.imprimeResposta();
        }
    }
}
