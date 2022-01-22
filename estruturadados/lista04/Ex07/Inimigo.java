package estruturadados.lista04.Ex07;

public class Inimigo {
    private int vida;
    private double danoPorSegundo;

    public Inimigo(int vida, double danoPorSegundo) {
        this.vida = vida;
        this.danoPorSegundo = danoPorSegundo;
    }

    public Inimigo() {
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public double getDanoPorSegundo() {
        return danoPorSegundo;
    }

    public void setDanoPorSegundo(double danoPorSegundo) {
        this.danoPorSegundo = danoPorSegundo;
    }
}
