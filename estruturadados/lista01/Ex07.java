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

public class Ex07 {

    static Stack<Character> pilhaOperadores = new Stack<>();
    static Stack<Double> pilhaNumeros = new Stack<>();

    // checa se char é um operador
    public static boolean ehOperador(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    // precedência
    public static int precedencia(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        } else if (ch == '*' || ch == '/') {
            return 2;
        }
        return 0;
    }

    // computa o operador...
    public static void computaOperador(char op) {
        double x = 0, y = 0;

        if (pilhaNumeros.empty()) {
            System.out.println("Erro.");
            // erro = true;
        } else {
            y = pilhaNumeros.peek();
            pilhaNumeros.pop();
        }

        if (pilhaNumeros.empty()) {
            System.out.println("Erro.");
            // erro = true;
        } else {
            x = pilhaNumeros.peek();
            pilhaNumeros.pop();
        }

        double z = 0;

        if (op == '+') {
            z = x + y;
        } else if (op == '-') {
            z = x - y;
        } else if (op == '*') {
            z = x * y;
        } else if (op == '/') {
            z = x / y;
        } else {
            System.out.println("Erro de operação.");
            // erro = true;
        }
        pilhaNumeros.push(z);
    }

    // computa a expressão: separa os números dos operadores numéricos + - * /
    public static void computarExpressao(String expressao) {
        //
        String[] tokens = expressao.split(" ");

        // loop principal
        for (int i = 0; i < expressao.length(); i++) {
            // String nextToken = tokens[i]; - apagar dps
            if (expressao.charAt(i) >= '0' && expressao.charAt(i) < '9') {
                double valor = Double.parseDouble(tokens[i]);
                pilhaNumeros.push(valor);
            } else if (ehOperador(expressao.charAt(i))) {
                if (pilhaOperadores.isEmpty() || precedencia(expressao.charAt(i)) > precedencia(pilhaOperadores.peek())) {
                    pilhaOperadores.push(expressao.charAt(i));
                } else {
                    while (!pilhaOperadores.empty() && precedencia(expressao.charAt(i)) <= precedencia(pilhaOperadores.peek())) {
                        char processar = pilhaOperadores.peek();
                        pilhaOperadores.pop();
                        computaOperador(processar);
                    }
                    pilhaOperadores.push(expressao.charAt(i));
                }
            } else if (expressao.charAt(i) == '(') {
                pilhaOperadores.push(expressao.charAt(i));
            } else if (expressao.charAt(i) == ')') {
                while (!pilhaOperadores.empty() && ehOperador(pilhaOperadores.peek())) {
                    char processar = pilhaOperadores.peek();
                    pilhaOperadores.pop();
                    computaOperador(processar);
                }
                if (!pilhaOperadores.empty() && pilhaOperadores.peek() == '(') {
                    pilhaOperadores.pop();
                } else {
                    System.out.println("Parenteses desbalanceados.");
                    // erro = true;
                }
            }
        }

        // esvazia a pilha de operadores
        while (!pilhaOperadores.empty() && ehOperador(pilhaOperadores.peek())) {
            char processar = pilhaOperadores.peek();
            pilhaOperadores.pop();
            computaOperador(processar);
        }

        // imprime o resultado caso nao haja nenhum erro
        // arrumar isso aqui dps que validar os erros

        double resultado = pilhaNumeros.peek();
        pilhaNumeros.pop();

        System.out.println("Resultado: "+ resultado);

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // leitura da expressão aritmética
        System.out.println("Expressão:");
        String expressao = scan.nextLine();

        computarExpressao(expressao);
    }

}
