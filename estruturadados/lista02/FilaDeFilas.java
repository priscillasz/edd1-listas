package estruturadados.lista02;

import java.util.Arrays;

// Questão 3, lista 2
public class FilaDeFilas {
    /* Atributos protected para serem usados na subclasse. */
    protected int tamanho;	/* Tamanho do vetor */
    protected Fila[] vetor;	/* Vetor de elementos */
    protected int ini;	/* Posicao do proximo elemento a ser retirado */
    protected int n;	/* Numero de elementos na fila */

    public FilaDeFilas(int tam)
    {
        tamanho = tam;
        vetor = new Fila[tamanho];
        ini = 0;
        n = 0;
    }

    public boolean vazia() {
        return (n == 0);
    }

    public boolean cheia() {
        return (n == tamanho);
    }

    // Retiramos o elemento do início da fila
    public Fila remove() {
        Fila elemento = null;

        if (!this.vazia()) {
            elemento = vetor[ini];
            ini = (ini + 1) % tamanho;
            n--;
        }

        return elemento;
    }

    // Inserimos o elemento no final da fila
    public boolean insere(Fila elemento) {
        int fim;

        if (!cheia()) {
            fim = (ini + n) % tamanho;
            vetor[fim] = elemento;
            n++;
            return true;
        } else
            return false;
    }

    @Override
    public String toString() {
        return Arrays.toString(vetor);
    }
}