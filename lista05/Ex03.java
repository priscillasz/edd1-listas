package lista05;

    /* 3) Implemente um método que inverta a ordem de uma lista circular e retorne a lista
    invertida. O protótipo do método é o seguinte:
    public ListaCircular inverteLista(); */

public class Ex03 {
    // Complexidade: O(n), pois para poder inverter a lista, precisa percorrê-la por completo, ou seja,
    // percorrer o seu tamanho n.

    public static void main(String[] args) {
        ListaCircular lista = new ListaCircular();

        lista.insere(10);
        lista.insere(20);
        lista.insere(30);
        lista.insere(40);
        lista.insere(50);
        lista.insere(60);

        System.out.println("Lista:");
        lista.imprime();

        lista.inverteLista();

        System.out.println("Lista invertida:");
        lista.imprime();
    }
}
