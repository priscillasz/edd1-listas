package estruturadados.lista01;

// Pilha usada nos exercícios...

public class Pilha<T> {
    protected T[] elementos;
    protected int tamanho;

    // construtor com parametro
    public Pilha(int capacidade) {
        this.elementos = (T[]) new Object[capacidade];
        this.tamanho = 0;
    }

    // construtor sem parametro
    public Pilha() {
        this(10);
    }

    // checa se a pilha tá vazia
    public boolean estaVazia() {
        return this.tamanho == 0;
    }

    // peek
    public T topo() {
        if (this.estaVazia())
            return null;
        return this.elementos[tamanho-1];
    }

    // push
    protected boolean empilha(T elemento) {
        this.aumentaCapacidade();

        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
            return true;
        }
        return false;
    }

    // pop
    public T desempilha() {
        if (this.estaVazia()) {
            return null;
        }
        return this.elementos[--tamanho];
    }

    // só é executado quando o tamanho do vetor atinge a capacidade
    protected void aumentaCapacidade(){
        if (this.tamanho == this.elementos.length) {
            T[] elementosNovos = (T[]) new Object[this.elementos.length * 2];
            for (int i = 0; i < this.elementos.length; i++) {
                elementosNovos[i] = this.elementos[i];
            }
            this.elementos = elementosNovos; // atribuir o novo vetor ao vetor Vetor
        }
    }

    // getTamanho
    public int tamanho() {
        return this.tamanho;
    }

    // imprimir os elementos do vetor
    @Override
    public String toString() {

        StringBuilder s = new StringBuilder();
        s.append("[");

        for (int i = 0; i < this.tamanho-1; i++) {
            s.append(this.elementos[i]);
            s.append(", ");
        }

        if (this.tamanho > 0) {
            s.append(this.elementos[this.tamanho-1]);
        }

        s.append("]");
        return s.toString();
    }
}
