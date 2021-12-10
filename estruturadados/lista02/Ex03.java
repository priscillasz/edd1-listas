package estruturadados.lista02;

         /* 3) Como você implementaria uma fila de pilhas? E uma pilha de filas? E uma fila de filas?
         Implemente cada uma dessas estruturas. Você pode reaproveitar ou modificar as classes
         fornecidas e apresentadas em sala de aula. */

public class Ex03 {
    public static void filaDeFilas() {
        FilaDeFilas filaDeFilas = new FilaDeFilas(3);

        Fila fila1 = new Fila(3);
        Fila fila2 = new Fila(3);
        Fila fila3 = new Fila(3);

        fila1.insere(1);
        fila1.insere(2);
        fila1.insere(3);

        fila2.insere(4);
        fila2.insere(5);
        fila2.insere(6);

        fila3.insere(7);
        fila3.insere(8);
        fila3.insere(9);

        filaDeFilas.insere(fila1);
        filaDeFilas.insere(fila2);
        filaDeFilas.insere(fila3);

        System.out.println("Fila de filas: "+filaDeFilas);
    }

    public static void pilhaDeFilas() {
        // Pilha<Fila> pilhaDeFilas = new Pilha<>();

        PilhaDeFilas pilhaDeFilas = new PilhaDeFilas();

        Fila fila1 = new Fila(3);
        Fila fila2 = new Fila(3);
        Fila fila3 = new Fila(3);

        fila1.insere(1);
        fila1.insere(2);
        fila1.insere(3);

        fila2.insere(4);
        fila2.insere(5);
        fila2.insere(6);

        fila3.insere(7);
        fila3.insere(8);
        fila3.insere(9);

        pilhaDeFilas.empilha(fila1);
        pilhaDeFilas.empilha(fila2);
        pilhaDeFilas.empilha(fila3);

        System.out.println("Pilha de filas: "+pilhaDeFilas);
    }

    public static void filaDePilhas() {
        /*FilaGenerica<Pilha> filaDePilhas = new FilaGenerica<>(3);*/

        FilaDePilhas filaDePilhas = new FilaDePilhas(2);

        Pilha<Integer> pilha1 = new Pilha<>();
        Pilha<Integer> pilha2 = new Pilha<>();
        Pilha<Integer> pilha3 = new Pilha<>();

        pilha1.empilha(1);
        pilha1.empilha(2);
        pilha1.empilha(3);

        pilha2.empilha(4);
        pilha2.empilha(5);
        pilha2.empilha(6);

        pilha3.empilha(7);
        pilha3.empilha(8);
        pilha3.empilha(9);

        filaDePilhas.insere(pilha1);
        filaDePilhas.insere(pilha2);
        filaDePilhas.insere(pilha3);

        System.out.println("Fila de pilhas: "+filaDePilhas);
    }

    public static void main(String[] args) {
        // fila de pilhas
        filaDePilhas();

        // pilha de filas
        pilhaDeFilas();

        // fila de filas
        filaDeFilas();
    }
}
