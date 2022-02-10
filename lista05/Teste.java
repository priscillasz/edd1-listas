package lista05;

import lista05.ListaDuplamente;

public class Teste {
    public static void main(String[] args) {

        ListaDuplamente lista1 = new ListaDuplamente();
        ListaDuplamente lista2 = new ListaDuplamente();
        ListaDuplamente intersecao = new ListaDuplamente();
        System.out.println("Primeira lista");
        lista1.insere(1);
        lista1.insere(2);
        lista1.insere(3);
        lista1.insere(4);
        lista1.insere(5);
        lista1.imprime();

        System.out.println("Segunda lista");
        lista2.insere(2);
        lista2.insere(6);
        lista2.insere(4);
        lista2.insere(3);
        lista2.imprime();

        System.out.println("Lista interseção:");
        intersecao.intersecao(lista1.prim,lista2.prim);
        intersecao.imprime();
    }
}
