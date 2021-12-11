package estruturadados.lista02;

import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Fila fila = new Fila(5);

        System.out.println("Prioridade do cliente a entrar na fila:");
        System.out.println("(1) Idoso");
        System.out.println("(2) Adulto");

        fila.inserePrioridade(2);
        fila.inserePrioridade(1);
        fila.inserePrioridade(1);
        fila.inserePrioridade(2);
        fila.inserePrioridade(1);

        System.out.println(fila);


    }
}
