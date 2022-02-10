package estruturadados.lista04;

/* 3) Implemente uma lista ordenada genérica (usando Generics de Java) que armazene
nomes em ordem alfabética. Lembre-se de manter a prioridade de ordenação da lista nos
métodos implementados. Para cada método, diga a sua complexidade. */

// COMPLEXIDADE:

/* QUESTÃO 3
 * Complexidade do método insere():
 * Complexidade do método remove():
 *  */
import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ListaOrdenadaGenerica<String> lista = new ListaOrdenadaGenerica<>();

        int stop;
        String nome;
        do {
            System.out.println("1- Inserir nome");
            System.out.println("2- Imprimir nomes");
            System.out.println("0- Sair");
            stop = scan.nextInt();

            scan.nextLine(); // buffer

            switch (stop) {
                case 1:
                    System.out.println("Insira um nome:");
                    nome = scan.nextLine();
                    lista.insere(nome);
                    break;
                case 2:
                    lista.imprime();
                    break;
                default:
                    if (stop != 0) {
                        System.out.println("Entrada inválida.");
                    }
                    break;
            }

        } while(stop != 0);

        // teste
        // lista.imprime();
        /*lista.insere("Charizard");
        lista.insere("Bulbasaur");
        lista.insere("Ivysaur");
        lista.insere("Squirtle");*/
    }
}
