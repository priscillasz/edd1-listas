package estruturadados.lista02;

    /* 1) Sabe-se que existem partes de sistemas operacionais que cuidam da ordem em que os
    processos devem ser executados. Por exemplo, em um sistema de computação “timeshared”, existe a necessidade de manter um conjunto de processos em uma fila. Realize
    uma modelagem e crie classes que representam um Processo e o Sistema Operacional.
    Dessa maneira, escreva métodos para:
    a. Incluir novos processos em uma fila de processos;
    b. Retirar da fila o processo com o maior tempo de espera;
    c. Imprimir o conteúdo da fila de processos em determinado momento. Cada processo
    possui um número identificador. */

public class Ex01 {
    public static void main(String[] args) {
        SistemaOperacional sistema = new SistemaOperacional(3);

        sistema.incluir(new Processo(1234, 12));
        sistema.incluir(new Processo(1233, 15));
        sistema.incluir(new Processo(1235, 5));

        // antes de ordenar
        sistema.imprimir();

        // ordena os processos do maior tempo de espera para o menor
        sistema.prioridade(sistema);

        // retira o processo com maior tempo de espera
        sistema.retira();

        // imprime a lista de processos existentes
        sistema.imprimir();
    }
}
