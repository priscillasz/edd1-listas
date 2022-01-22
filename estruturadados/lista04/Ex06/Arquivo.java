package estruturadados.lista04.Ex06;

public class Arquivo {
    private String nomeArquivo;

    public Arquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    @Override
    public String toString() {
        return "Arquivo{" +
                "nomeArquivo='" + nomeArquivo + '\'' +
                '}';
    }
}
