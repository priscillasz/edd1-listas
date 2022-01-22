package estruturadados.lista02;

import java.util.Arrays;

public class Fila {
    /* Atributos protected para serem usados na subclasse. */
    protected int tamanho;	/* Tamanho do vetor */
    protected int[] vetor;	/* Vetor de elementos */
    protected int ini;	/* Posicao do proximo elemento a ser retirado */
    protected int n;	/* Numero de elementos na fila */

    protected int[] templist; // ex 05

    public Fila(int tam) {
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

    public int topo() {
        ini = (ini + 1) % tamanho;

        return vetor[ini];
    }

    public int remove() {
        int elemento = Integer.MIN_VALUE;

        if (!this.vazia()) {
            elemento = vetor[ini];
            vetor[ini] = 0;
            ini = (ini + 1) % tamanho;
            n--;
        }

        return elemento;
    }

    public boolean insere(int elemento) {
        int fim;

        if (!cheia()) {
            fim = (ini + n) % tamanho;
            vetor[fim] = elemento;
            n++;
            return true;
        } else
            return false;
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

    // Questão 05
    public void prioridade(Fila fila) {
        // array auxiliar
        templist = new int[tamanho];

        // remove os clientes da fila circular e coloca na array temporaria
        for (int i = 0; i < tamanho; i++) {
            templist[i] = fila.remove();
        }

        // ordena
        ordenar(templist);

        // adiciona dnv na fila
        for (int i = 0; i < tamanho; i++) {
            fila.insere(templist[i]);
        }

        System.out.println("Fila de clientes ordenada por prioridade: "+fila);
    }

    // ex05 ordenar
    public void ordenar(int[] v) {
        for (int i = 0; i < v.length - 1; i++) {
            boolean estaOrdenado = true;
            for (int j = 0; j < v.length - 1 - i; j++) {
                if (v[j] > v[j + 1]) {
                    int aux = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = aux;
                    estaOrdenado = false;
                }
            }
            if (estaOrdenado)
                break;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(vetor);
    }
}