package estruturadados.lista02;

import java.util.Arrays;

// Questão 1, lista 2

// vai funcionar como se fosse uma fila de processos
public class SistemaOperacional {
    protected int tamanho; // tamanho do vetor
    protected Processo[] vetor; // vetor de processos
    protected int ini;  // posição do prox elemento a ser retirado
    protected int n; // numero de processos na fila
    protected Processo[] templist; // vetor auxiliar

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
    public Processo retira() { // era public Processo
        Processo processo = null;

        if (!this.vazia()) {
            processo = vetor[ini];
            vetor[ini] = null;
            ini = (ini + 1) % tamanho;
            n--;
        }
        return processo;
    }

    // imprimir
    public void imprimir() {
        System.out.println("\nLista de Processos:");
        for (int i = 0; i < tamanho; i++) {
            if (vetor[i] != null)
                System.out.println(vetor[i]);
        }
    }

    public void prioridade(SistemaOperacional filaDeProcessos) {
        // array auxiliar
        templist = new Processo[tamanho];

        // remove os clientes da fila circular e coloca na array temporaria
        for (int i = 0; i < tamanho; i++) {
            templist[i] = filaDeProcessos.retira();
        }

        // ordena
        ordenar(templist);

        // adiciona dnv na fila
        for (int i = 0; i < tamanho; i++) {
            filaDeProcessos.incluir(templist[i]);
        }

        imprimir();
    }

   // ordena os processos -> do maior tempo de espera pro menor
    public void ordenar(Processo[] v) {
        for (int i = 0; i < v.length - 1; i++) {
            boolean estaOrdenado = true;
            for (int j = 0; j < v.length - 1 - i; j++) {
                if (v[j].compareTo(v[j+1]) < 0) { // v[j] < v[j + 1]
                    Processo aux = v[j];
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
