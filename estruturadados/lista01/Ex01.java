package estruturadados.lista01;

import java.util.Scanner;

    /* Questão 1 da Lista 1 de EDD1
    Escreva uma função para determinar se uma cadeia de caracteres (string) é da forma: x
    C y onde x e y são cadeias de caracteres compostas por letras ‘A’ e/ou ‘B’, e y é o inverso
    de x. Isto é, se x = “ABABBA”, y deve equivaler a “ABBABA”. Em cada ponto, você só
    poderá ler o próximo caractere da cadeia. */

public class Ex01 {

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

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // leitura da string
        System.out.println("Insira uma string no formato xCy:");
        String xCy = scan.nextLine();

        if (isXCY(xCy)) {
            System.out.println("Está na forma xCy.");
        } else {
            System.out.println("Não está na forma xCy.");
        }
    }
}
