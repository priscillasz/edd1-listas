package estruturadados.lista04;

/* 4) Suponha que uma frase é representada por uma lista encadeada, sendo que cada elo
contém uma string representando um token, isto é, um caracter de pontuação ou uma
palavra. Escreva um algoritmo para retornar a frase inteira. */

// COMPLEXIDADE:

public class Ex04 {
    public static void main(String[] args) {
        ListaGenerica<String> frase = new ListaGenerica<>();

        // Cada token é inserido ao final da lista encadeada
        frase.insereFim("Bom");
        frase.insereFim(" ");
        frase.insereFim("dia");
        frase.insereFim("!");
        frase.insereFim(" ");
        frase.insereFim("Como");
        frase.insereFim(" ");
        frase.insereFim("vai");
        frase.insereFim("?");

        frase.imprimeFim();
    }
}
