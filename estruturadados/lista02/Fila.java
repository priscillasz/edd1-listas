package estruturadados.lista02;

import java.util.Arrays;

public class Fila {
    /* Atributos protected para serem usados na subclasse. */
    protected int tamanho;	/* Tamanho do vetor */
    protected int[] vetor;	/* Vetor de elementos */
    protected int ini;	/* Posicao do proximo elemento a ser retirado */
    protected int n;	/* Numero de elementos na fila */

    public Fila(int tam)
    {
        tamanho = tam;
        vetor = new int[tamanho];
        ini = 0;
        n = 0;
    }

    public boolean vazia() {
        return (n == 0);
    }

    public boolean cheia() {
        return (n == tamanho);
    }

    public int remove() {
        int elemento = Integer.MIN_VALUE;

        if (!this.vazia()) {
            elemento = vetor[ini];
            ini = (ini + 1) % tamanho;
            n--;
        }

        return elemento;
    }

    public boolean insere(int elemento) {
        int fim;

        if (!cheia()) { //
            fim = (ini + n) % tamanho;
            vetor[fim] = elemento;
            n++;
            return true;
        } else
            return false;
    }

    // Questão 05
    public void inserePrioridade(int elemento) {
        insere(elemento);

        int[] templist = new int[tamanho];

        for (int i = 0; i < n; i++) {
            templist[i] = remove();
        }

        Arrays.sort(templist);

        // System.out.println(Arrays.toString(templist));

        System.out.println("sorted");
        Arrays.sort(vetor);
        // System.out.println(vetor);

        for (int i = 0; i < n; i++) {
            insere(templist[i]);
        }
    }

    // Questão 02
    public void combinaFilas(Fila f1, Fila f2) {
        int tamanhoMista = f1.tamanho + f2.tamanho;
        Fila mista = new Fila(tamanhoMista);

        while (!f1.vazia() || !f2.vazia()) {
            if (!f1.vazia()) {
                mista.insere(f1.remove());
            }
            if (!f2.vazia()) {
                mista.insere(f2.remove());
            }
        }

        System.out.println("Fila mista:");
        System.out.println(mista);

        // não consegui deixar f1 e f2 vazias ao final
        System.out.println("f1 ao final: "+f1);
        System.out.println("f2 ao final: "+f2);
    }

    @Override
    public String toString() {
        return Arrays.toString(vetor);
    }
}