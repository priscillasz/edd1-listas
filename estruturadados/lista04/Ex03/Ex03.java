package estruturadados.lista04.Ex03;

/* 3) Implemente uma lista ordenada genérica (usando Generics de Java) que armazene
nomes em ordem alfabética. Lembre-se de manter a prioridade de ordenação da lista nos
métodos implementados. Para cada método, diga a sua complexidade. */

// COMPLEXIDADE:

public class Ex03 {
    /* QUESTÃO 3
     * Complexidade do método insere():
     * Complexidade do método remove():
     *  */

    public static void main(String[] args) {
        ListaOrdenadaGenerica<String> lista = new ListaOrdenadaGenerica<>();

        lista.insere("Priscilla");
        lista.insere("Louise");
        lista.insere("Leticia");
        lista.insere("Thaís");

        lista.imprime();
    }
}
