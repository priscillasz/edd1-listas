package estruturadados.lista02;

    /* 5) Uma loja deseja implementar um sistema diferente em seus caixas. Haverá apenas uma
    fila e essa fila será ordenada conforme o grau de prioridade dos clientes. Haverá dois tipos
    de cliente, que possuem diferentes prioridades: o “cliente idoso” e o “cliente adulto”. Esses
    serão ordenados da seguinte forma:
    i) Um cliente idoso sempre passará a frente dos clientes adultos;
    ii) No caso de mais de um cliente idoso na fila, o que tiver entrado primeiro na fila
    permanece em sua posição e o outro se posiciona após ele;
    Iii) Implemente os métodos e atributos necessários para que esse sistema de fila seja
    possível. Você pode utilizar e modificar a implementação de fila que julgar mais adequada
    (fila circular ou fila dupla, vistas em sala de aula). */

import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Fila fila = new Fila(5);
        int opcao;
        do {
            System.out.println("Prioridade do cliente a entrar na fila:");
            System.out.println("(1) Idoso");
            System.out.println("(2) Adulto");
            opcao = scan.nextInt();

            if (opcao == 1 || opcao == 2) {
                fila.insere(opcao);
            }
        } while (fila.n < 5);

        fila.prioridade(fila);
    }
}
