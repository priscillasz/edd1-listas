package estruturadados.lista04.Ex06;

public class Diretorio<T> extends Lista<T> {
    private String nomeDiretorio;
    private Lista<T> diretorio = new Lista<>();

    Diretorio(String nomeDiretorio) {
        this.nomeDiretorio = nomeDiretorio;
    }

    Diretorio() {
    }

    @Override
    public String toString() {
        return "Diretorio{" +
                "nomeDiretorio='" + nomeDiretorio + '\'' +
                '}';
    }

    public String diretorio() {
        /* String result = "";
            LinkedListNode current = head;
            while(current.getNext() != null){
                result += current.getData();
                if(current.getNext() != null){
                     result += ", ";
                }
                current = current.getNext();
            }
            return "List: " + result;*/
        String result = "";
        Elo p = prim;

        while (p.prox != null) {
            result += p.dado;
            if (p.prox != null) {
                result += ", ";
            }
            p = p.prox;
        }

        return "List: "+result;
    }
}
