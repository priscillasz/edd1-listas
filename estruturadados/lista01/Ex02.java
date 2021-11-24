package estruturadados.lista01;

import java.util.Scanner;
import java.util.Stack;

    /* Questão 2 da Lista 1 de EDD1
    Escreva uma função para determinar se uma cadeia de caracteres (string) é da forma: a
    D b D c D ... D z onde cada cadeia de caracteres, a, b, ..., z, é da forma do exercício
    descrito acima. Portanto, uma cadeia de caracteres estará no formato correto se consistir
    em qualquer número de cadeias deste tipo ( x C y ), separadas pelo caractere ‘D’. Em cada
    ponto, você só poderá ler o próximo caractere da cadeia (é mandatório o uso de pilha). */

    // EXEMPLO DE FORMATO CORRETO: ABABBACABBABADABABBACABBABADABABBACABBABA
    // EXEMPLO DE FORMATO ERRADO: ABABBACABBABADABBBBACABBABADABABBACABBABA

public class Ex02 {
    // mesmo método da questão 1
    public static boolean isXCY(String xCy) {
        Pilha<Character> pilha = new Pilha<>();

        // colocar cada caractere da string na pilha até chegar no char C
        for (int i = 0; xCy.charAt(i) != 'C'; i++) {
            pilha.empilha(xCy.charAt(i));
        }

        // inicialização com 0
        int isXCY = 0;

        // pega o índice do char 'C'
        int posC = 0;
        for (int i = 0; i < xCy.length(); i++) {
            if (xCy.charAt(i) == 'C') {
                posC = i;
                break;
            }
        }

        // varre a string depois do caractere 'C' até o final, comparando com os elementos da pilha
        for (int i = posC+1; i<=xCy.length()-1; i++) {
            if (pilha.topo() == xCy.charAt(i)) {
                pilha.desempilha();
                isXCY = 0;
            } else {
                isXCY = 1;
                break;
            }
        }

        // valida o retorno
        if (isXCY == 0) {
            return true;
        } else {
            return false;
        }
    }

    // método que verifica a string inteira
    public static boolean verifica(String formD) {
        Pilha<Character> aux = new Pilha<>();

        char[] caracteres = new char[13]; // coloquei 13 por conta do tamanho da string que eu usei para testar
        int count;
        boolean formato = true;

        for (int i = 0; i < formD.length(); i++) {
            if (formD.charAt(i) != 'D') {
                aux.empilha(formD.charAt(i));
            } else if (formD.charAt(i) == 'D') { // if redundante: só pra eu visualizar direito
                count = 0;
                while (!aux.estaVazia()) {
                    caracteres[count] = aux.topo();
                    aux.desempilha();
                    count++;
                }
                String strAux = String.valueOf(caracteres);
                System.out.println("String: "+strAux); // teste
                if (!isXCY(strAux)) {
                    formato = false;
                    break;
                }
            }
        }

        if (formato) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // leitura da string
        System.out.println("Insira uma string no formato a D b D c D ... D z :");
        String formD = scan.nextLine();

        // chamar o método
        if (verifica(formD)) {
            System.out.println("A cadeia está no formato correto.");
        } else {
            System.out.println("A cadeia não está no formato correto.");
        }
    }
}
