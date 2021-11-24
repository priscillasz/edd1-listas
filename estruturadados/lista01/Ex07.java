package estruturadados.lista01;

    /* Questão 7 da Lista 1 de EDD1
    Em sala de aula, aprendemos a avaliar uma expressão aritmética que estivesse em
    notação pós-fixada, que não faz uso de parênteses por não possuir ambiguidade na sua
    avaliação. Neste exercício, você deve utilizar o conceito de Pilha para realizar a avaliação
    de expressões aritméticas em notação infixa, isto é, aquela que aprendemos e utilizamos ao
    longo do Ensino Fundamental e do Ensino Médio. Nesse contexto, vamos usar a seguintedefinição recursiva:
    uma expressão aritmética é um número, ou um parêntese esquerdo
    seguido de uma expressão aritmética seguida por um operador seguido por outra expressão
    aritmética seguida de um parêntese direito. Por simplicidade, essa definição assume que a
    expressão está completamente parentizada, especificando precisamente quais operadores
    devem ser aplicados a quais operandos e removendo possíveis ambiguidades na avaliação.
    Por exemplo, a expressão ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) ) segue essa definição.
    Você deve então implementar um método que realize a avaliação de tais expressões
    representadas em uma String usando o conceito de Pilha. Por fim, cabe citar que o código
    que voces vão desenvolver corresponde a um exemplo simples de um interpretador: um
    programa que interpreta uma computação especificada por uma string e realiza tal
    computação para chegar ao resultado. */

import java.util.Scanner;
import java.util.Stack;

// 1- A expressão infix é convertida para postfix
// 2- O resultado da expressão postfix é computado (com a classe Posfixada)

public class Ex07 {
    // retorna precedencia do operador
    public static int precedencia(char ch)
    {
        switch (ch) {
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
    public static String conversao(String exp)
    {
        String resultado = new String(""); // string vazia para armazenar o resultado

        Stack<Character> pilha = new Stack<>(); // stack que armazena Caracteres

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
