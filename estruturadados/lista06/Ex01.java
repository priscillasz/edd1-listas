package estruturadados.lista06;

/* 1. Crie métodos que retornem o menor elemento e o maior elemento de um conjunto
em tempo constante O(1). */

public class Ex01 {
    // Complexidade:

    public static void main(String[] args) {
        Conj conjunto = new Conj();

        conjunto.insere(5);
        conjunto.insere(1);
        conjunto.insere(3);
        conjunto.insere(11);
        conjunto.insere(9);
        conjunto.insere(7);

        conjunto.imprime();

        int menor = conjunto.menorElemento();
        System.out.println("Menor elemento: " + menor);

        int maior = conjunto.maiorElemento();
        System.out.println("Maior elemento: " + maior);



    }
}
