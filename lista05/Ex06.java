package lista05;

    /* 6) Uma central de atendimento a clientes tem vários atendentes, mas um número muito
    maior de linhas telefônicas recebendo chamadas. Tais chamadas são colocadas em uma
    fila de espera segundo a ordem de chegada e são atendidas quando possível. Ocorre que
    algumas destas chamadas vêm de longe e, neste caso, se elas ficam esperando na linha,
    elas causam uma despesa muito maior do que as chamadas que vêm de perto. Dessa
    maneira, deseja-se implementar uma solução alternativa que coloque as chamadas em uma
    fila obedecendo à prioridade definida pelo custo (de modo que as mais caras sejam
    atendidas primeiro) e, em caso de empate no custo, deve ser respeitada a ordem de
    chegada. Efetue então uma modelagem Orientada a Objetos desta realidade e implemente
    a fila de prioridade usando Lista Duplamente Encadeada. Para esse propósito, você deve
    adaptar a classe ListaDuplamente vista em sala de aula. */

public class Ex06 {
    // Complexidade: O(n), pois toda vez que uma chamada é inserida na lista, seu custo é comparado com
    // as demais, afim de ordená-las do maior para o menor custo.

    public static void main(String[] args) {
        ListaChamadas lista = new ListaChamadas();

        lista.insere(30);
        lista.insere(50);
        lista.insere(35);
        lista.insere(45);
        lista.insere(35);

        System.out.println("Chamadas em ordem de prioridade:");
        lista.imprime();
    }
}
