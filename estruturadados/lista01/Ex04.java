package estruturadados.lista01;

import java.util.Scanner;

    /* Questão 4 da Lista 1 de EDD1
    Utilizando as operações de manipulação de pilhas vistas em aula, assim como o código
    de PilhaGenerica visto, use uma pilha auxiliar e uma variável do tipo T, para desenvolver
    um procedimento que remova um dado objeto do tipo T de uma posição qualquer de uma
    pilha. Para saber se dois objetos do tipo T são iguais, você deve usar o método equals (ou
    compareTo). Note que você não pode acessar diretamente a estrutura interna da pilha
    (atributos), devendo usar apenas as operações (métodos) de manipulação. */

public class Ex04 {
    // Testei removendo os elementos 3, 4 e 5 e funcionou, mas não deu certo removendo o 1 e o 2 (acaba removendo o último elemento).
    // Não testei com um número que não existe na pilha.

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // escolhi criar Pilhas que armazenam inteiros
        Pilha<Integer> pilha = new Pilha<>();
        Pilha<Integer> aux = new Pilha<>();

        // push de elementos na pilha
        pilha.empilha(1);
        pilha.empilha(2);
        pilha.empilha(3);
        pilha.empilha(4);
        pilha.empilha(5);

        // impressão do conteúdo inicial da pilha
        System.out.println("Pilha: "+ pilha);

        // input do usuário
        System.out.println("Insira o elemento que quer remover: ");
        int elementoRemover = scan.nextInt();

        // move todos os elementos para a pilha auxiliar, menos o escolhido, que será removido.
        for (int i = 0; i < pilha.tamanho(); i++) {
            if (pilha.topo().equals(elementoRemover)) {
                pilha.desempilha();
            } else {
                aux.empilha(pilha.desempilha());
            }
        }

        // empilha os elementos que estavam na pilha auxiliar novamente na pilha original
        for (int i = 0; i <= aux.tamanho(); i++) {
            pilha.empilha(aux.desempilha());
        }

        System.out.println("Pilha depois de remover o elemento escolhido: "+ pilha);
    }
}
