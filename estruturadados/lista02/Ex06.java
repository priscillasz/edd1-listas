package estruturadados.lista02;

import java.util.Scanner;

    /* 6) Dado um número inteiro N, faça um algoritmo eficiente que use fila para gerar todas as
    representações binárias dos números inteiros entre 1 e N. */

public class Ex06 {
    public static void converte(int n) {
        FilaGenerica<String> fila = new FilaGenerica<>(n);

        fila.insere("1");

        for (int i = n; i > 0; i--) {
            String item1 = fila.remove();
            System.out.println(item1);

            String item2 = item1;

            fila.insere(item1 + "0");
            fila.insere(item2 + "1");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        System.out.println("N: ");
        int n = scan.nextInt();

        converte(n);
    }
}
