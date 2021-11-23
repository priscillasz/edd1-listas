package estruturadados.lista01;

import java.util.Scanner;

/* Testei removendo os elementos 3, 4 e 5 e funcionou, mas não deu certo removendo o 1 e o 2. */
// tirando isso, tá tudo funcionando normalmente...

// Questão 4 da Lista 1 de EDD1
public class Ex04 {
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

        System.out.println("Tamanho inicial da pilha: "+pilha.tamanho()); // teste

        // TODO: 22/11/2021 não esquecer de verificar antes o tamanho da pilha, ou se o elemento não existe na pilha!!!!!

        // move todos os elementos para a pilha auxiliar, menos o escolhido, que será removido.
        for (int i = 0; i < pilha.tamanho(); i++) {
            if (pilha.topo().equals(elementoRemover)) {
                System.out.println("Empilhando "+pilha.topo()); // teste
                pilha.desempilha();
            } else {
                aux.empilha(pilha.desempilha());
                System.out.println("Desempilhando "+ pilha); // teste
            }
        }

        // empilha os elementos que estavam na pilha auxiliar novamente na pilha original
        for (int i = 0; i <= aux.tamanho(); i++) {
            pilha.empilha(aux.desempilha());
        }

        System.out.println("Pilha depois de remover o elemento escolhido: "+ pilha);
    }
}