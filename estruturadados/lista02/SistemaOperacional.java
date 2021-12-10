package estruturadados.lista02;

import java.util.Arrays;
import java.util.Scanner;

// Questão 1, lista 2

// vai funcionar como se fosse uma fila de processos
public class SistemaOperacional {
    protected int tamanho; // tamanho do vetor
    protected Processo[] vetor; // vetor de processos
    protected int ini;  // posição do prox elemento a ser retirado
    protected int n; // numero de processos na fila

    // construtor
    public SistemaOperacional(int tam) {
        this.tamanho = tam;
        this.vetor = new Processo[tamanho];
        this.ini = 0;
        this.n = 0;
    }

    // isEmpty
    public boolean vazia() { return (n == 0); }

    // isFull
    public boolean cheia() { return (n == tamanho); }

    // incluir
    public boolean incluir(Processo processo) {
        int fim;

        if (!cheia()) {

            fim = (ini + n) % tamanho;
            vetor[fim] = processo;
            n++;
            return true;
        } else
            return false;
    }

    // retirar
    public void retira() { // era public Processo
        Processo processo = null;

        if (!this.vazia()) {
            // processo = vetor[ini];
            vetor[ini] = null;
            ini = (ini + 1) % tamanho;
            n--;
        }
    }

    // imprimir
    public void imprimir() {
        for (int i = 0; i < tamanho; i++) {
            if (vetor[i] != null)
                System.out.println(vetor[i]);
        }
    }
}
