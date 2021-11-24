package estruturadados.lista01;

    /* Questão 8 da Lista 1 de EDD1
    Dada uma sequência de 1 a N armazenada em um array, são formadas todas as
    subsequências (subarrays) possíveis a partir da sequência original. Para todas essas
    subsequências geradas, encontre a quantidade de pares únicos (a, b), em que ‘a’ é
    diferente de ‘b’ e ‘a’ é máximo (maior número) e ‘b’ é o segundo máximo da subsequência.
    Por exemplo, em uma sequência de 1 até 5, podem ser formadas as seguintes 15
    subsequências: (...) */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Ex08 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Ler input
        System.out.println("Tamanho do array:");
        int n = scan.nextInt(); // não verifiquei se o tamanho é <=0

        // cria a array
        int[] arr = new int[n];

        // Leitura dos números
        for (int i = 0; i < n; i++) {
            System.out.println("Número "+(i+1)+":");
            arr[i] = scan.nextInt();
        }

        // criação de uma instância da classe Par
        Par par;

        // criação de um set para armazenar os pares -> sets não adicionam objetos repetidos
        Set<Par> pares = new HashSet<>();

        //
        for (int i = 0; i < n - 1; ++i) {

            // compara quem é o maior e o menor entre dois elementos
            int maior = Math.max(arr[i], arr[i + 1]);
            int menor = Math.min(arr[i], arr[i + 1]); // segundo maior, no caso

            for (int j = i + 1; j < n; ++j) {
                if (arr[j] > maior) {
                    menor = maior;
                    maior = arr[j];
                }
                if (arr[j] < maior && arr[j] > menor) {
                    menor = arr[j];
                }

                par = new Par(menor, maior);
                pares.add(par);
            }
        }

        System.out.println("Pares únicos:");
        for (Par p : pares) {
            System.out.println("("+p.getSegundo()+", "+p.getPrimeiro()+")");
        }

        System.out.println("Quantidade de pares únicos: "+pares.size());
    }
}
