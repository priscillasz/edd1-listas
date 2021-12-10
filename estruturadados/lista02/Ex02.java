package estruturadados.lista02;

        /* 2) Para a implementação de fila de inteiros apresentada em sala de aula, faça:
        Usando apenas os métodos disponíveis previamente na classe Fila, implemente um novo
        método na classe Fila que receba outras duas filas f1 e f2 e transfira alternadamente os
        elementos de f1 e f2 para a fila corrente (cujo método foi chamado). A seguir está ilustrado
        um exemplo:
        f1 = 1,2,3
        f2 = 4,5,6
        filaMista = 1,4,2,5,3,6
        Note que, ao final desse método, as filas f1 e f2 deverão estar vazias e a fila para o qual o
        método foi chamado deve conter todos os valores originalmente em f1 e f2 (inicialmente a
        fila para a qual o método foi chamado pode ou não estar vazia). O método transfere, no
        máximo, quantos elementos couberem na fila. Tal método deve obedecer ao seguinte
        protótipo:
        public void combinaFilas(Fila f1, Fila f2);*/

public class Ex02 {
    public static void main(String[] args) {
        Fila f1 = new Fila(3);
        Fila f2 = new Fila(3);

        f1.insere(1);
        f1.insere(2);
        f1.insere(3);
        // f1.insere(7);

        f2.insere(4);
        f2.insere(5);
        f2.insere(6);
        // f2.insere(8);

        Fila filaMista = new Fila(f1.tamanho+ f2.tamanho);

        filaMista.combinaFilas(f1, f2);
    }
}
