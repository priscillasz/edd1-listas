package estruturadados.lista02;

    /* 1) Sabe-se que existem partes de sistemas operacionais que cuidam da ordem em que os
    processos devem ser executados. Por exemplo, em um sistema de computação “timeshared”, existe a necessidade de manter um conjunto de processos em uma fila. Realize
    uma modelagem e crie classes que representam um Processo e o Sistema Operacional.
    Dessa maneira, escreva métodos para:
    a. Incluir novos processos em uma fila de processos;
    b. Retirar da fila o processo com o maior tempo de espera;
    c. Imprimir o conteúdo da fila de processos em determinado momento. Cada processo
    possui um número identificador. */

import java.util.Scanner;

public class Ex01 {
    public static boolean checkID(SistemaOperacional sistema, int id, int tempoEspera) {
        for (int i = 0; i < 5; i++) {
            if (new Processo(id, tempoEspera).equals(sistema.vetor[i])) {
                return true;
            }
        }
        return false;
    }

    public static void menu() {
        Scanner scan = new Scanner(System.in);
        int opcao;

        SistemaOperacional sistema = new SistemaOperacional(5); // sistema com 5 processos

        do {
            System.out.println("1- Incluir processo");
            System.out.println("2- Retirar processo");
            System.out.println("3- Ver processos existentes");
            System.out.println("0- Sair");
            opcao = scan.nextInt();

            switch(opcao) {
                case 1: // incluir processo
                    boolean idExiste = false;

                    System.out.println("ID do processo:");
                    int id = scan.nextInt();

                    // sistema.validaID();

                    System.out.println("Tempo de espera:");
                    int tempoEspera = scan.nextInt();

                    /*for (int i = 0; i < 5; i++) {
                        if (new Processo(id, tempoEspera).equals(sistema.vetor[i])) {
                            System.out.println("lmao");
                            idExiste = true;
                            break;
                        }
                    }

                    if (idExiste) {
                        System.out.println("id já existe");
                    } else {
                        sistema.incluir(new Processo(id, tempoEspera));
                    }*/

                    if (checkID(sistema, id, tempoEspera)) {
                        System.out.println("ID já existente.");
                    } else {
                        sistema.incluir(new Processo(id, tempoEspera));
                        System.out.println("Processo adicionado.");
                    }
                    break;
                case 2: // retirar o processo com maior tempo de espera
                    sistema.retira();
                    System.out.println("Processo removido.");
                    break;
                case 3: // ver processos existentes
                    sistema.imprimir();
                    break;
                default:
                    if (opcao != 0)
                        System.out.println("Opção inválida");
            }
        } while (opcao != 0);
    }

    public static void main(String[] args) {

        menu();
    }
}
