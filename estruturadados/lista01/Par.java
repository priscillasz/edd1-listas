package estruturadados.lista01;

import java.util.Objects;

// Usado na questão 8
public class Par implements Comparable<Par> {
    int primeiro, segundo;

    public Par(int primeiro, int segundo) {
        this.primeiro = primeiro;
        this.segundo = segundo;
    }

    public int getPrimeiro() {
        return primeiro;
    }

    public int getSegundo() {
        return segundo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Par par = (Par) o;
        return primeiro == par.primeiro && segundo == par.segundo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(primeiro, segundo);
    }

    @Override
    public int compareTo(Par o) {
        return 0;
    }
}
