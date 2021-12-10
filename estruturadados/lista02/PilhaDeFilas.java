package estruturadados.lista02;

// Questão 3, lista 2
public class PilhaDeFilas {
    protected Fila[] elementos;
    protected int tamanho;

    // construtor com parâmetro
    public PilhaDeFilas(int capacidade) {
        this.elementos = new Fila[capacidade];
        this.tamanho = 0;
    }

    // construtor sem parâmetro
    public PilhaDeFilas() {
        this(10);
    }

    // isEmpty - checa se a pilha tá vazia
    public boolean estaVazia() {
        return this.tamanho == 0;
    }

    // peek
    public Fila topo() {
        if (this.estaVazia())
            return null;
        return this.elementos[tamanho-1];
    }

    // push
    protected boolean empilha(Fila elemento) {
        this.aumentaCapacidade();

        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
            return true;
        }
        return false;
    }

    // pop
    public Fila desempilha() {
        if (this.estaVazia()) {
            return null;
        }
        return this.elementos[--tamanho];
    }

    // só é executado quando o tamanho do vetor atinge a capacidade
    protected void aumentaCapacidade(){
        if (this.tamanho == this.elementos.length) {
            Fila[] elementosNovos = (new Fila[this.elementos.length * 2]);
            for (int i = 0; i < this.elementos.length; i++) {
                elementosNovos[i] = this.elementos[i];
            }
            this.elementos = elementosNovos;
        }
    }

    // getTamanho
    public int tamanho() {
        return this.tamanho;
    }

    @Override // imprimir os elementos do vetor
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
