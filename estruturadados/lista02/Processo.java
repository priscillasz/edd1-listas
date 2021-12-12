package estruturadados.lista02;

// Questão 1, lista 2
public class Processo implements Comparable<Processo> {
    private int id; // número identificador
    private int tempoEspera;

    // construtor
    public Processo(int id, int tempoEspera) {
        this.id = id;
        this.tempoEspera = tempoEspera;
    }

    @Override
    public String toString() {
        return "Processo {" +
                "id = " + id +
                ", tempo de espera = " + tempoEspera +
                '}';
    }

    @Override
    public int compareTo(Processo o) {
        if (this.tempoEspera > o.tempoEspera) {
            return 1;
        } else if (this.tempoEspera < o.tempoEspera) {
            return -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) { // não foi usado
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Processo processo = (Processo) o;
        return id == processo.id;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
